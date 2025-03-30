package kr.co.samsami_service_desk.common.service

import kr.co.samsami_service_desk.agent.AgentDivision
import kr.co.samsami_service_desk.common.service.mapper.AuthenticationMapper
import kr.co.samsami_service_desk.common.`object`.PrincipalDetails
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class AuthenticationService(private val mapper: AuthenticationMapper): UserDetailsService {
    override fun loadUserByUsername(email: String): UserDetails {
        val principal = mapper.selectAgentByEmail(email)
            ?: throw UsernameNotFoundException("해당 에이전트를 찾을 수 없습니다.")

        return PrincipalDetails(principal.email, principal.password, AgentDivision.valueOf(principal.agentDivision))
    }
}