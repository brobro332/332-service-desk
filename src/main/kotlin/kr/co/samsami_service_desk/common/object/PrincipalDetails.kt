package kr.co.samsami_service_desk.common.`object`

import io.swagger.v3.oas.annotations.media.Schema
import kr.co.samsami_service_desk.agent.AgentDivision
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Schema(description = "인증 에이전트")
class PrincipalDetails(
    @Schema(description = "이메일")
    private val email: String,

    @Schema(description = "비밀번호")
    private val password: String,

    @Schema(description = "에이전트 구분")
    private val agentDivision: AgentDivision
): UserDetails {
    override fun getUsername(): String {
        return email
    }

    override fun getPassword(): String {
        return password
    }

    override fun getAuthorities(): Collection<GrantedAuthority> {
        val authorities = mutableListOf<GrantedAuthority>()

        when (agentDivision) {
            AgentDivision.ADMINISTRATOR -> authorities.add(SimpleGrantedAuthority("ROLE_ADMINISTRATOR"))
            AgentDivision.COUNSELOR -> authorities.add(SimpleGrantedAuthority("ROLE_COUNSELOR"))
        }

        return authorities
    }
}