package kr.co.samsami_service_desk.common.service.mapper

import kr.co.samsami_service_desk.common.dto.AuthenticationResponseDto
import org.apache.ibatis.annotations.Mapper

@Mapper
interface AuthenticationMapper {
    fun selectAgentByEmail(email: String): AuthenticationResponseDto?
}