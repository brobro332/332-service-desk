package kr.co.samsami_service_desk.common.service.mapper

import kr.co.samsami_service_desk.common.dto.AuthenticationResponseDto
import org.apache.ibatis.annotations.Mapper

@Mapper
interface AuthenticationMapper {
    /**
     * 로그인 시 이메일에 해당하는 에이전트 조회
     */
    fun selectAgentByEmail(email: String): AuthenticationResponseDto?
}