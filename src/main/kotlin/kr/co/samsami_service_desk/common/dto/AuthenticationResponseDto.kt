package kr.co.samsami_service_desk.common.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "에이전트 로그인 응답 DTO")
class AuthenticationResponseDto (
    @Schema(description = "이메일")
    val email: String,

    @Schema(description = "비밀번호")
    val password: String,

    @Schema(description = "에이전트 구분")
    val agentDivision: String
)