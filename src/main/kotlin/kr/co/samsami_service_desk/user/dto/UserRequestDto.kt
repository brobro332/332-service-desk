package kr.co.samsami_service_desk.user.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "사용자 요청 DTO")
class UserRequestDto {
    @Schema(description = "사용자 등록 요청 DTO")
    class CREATE (
        @Schema(description = "아이디")
        val email: String,

        @Schema(description = "비밀번호")
        val password: String,

        @Schema(description = "이름")
        val name: String,

        @Schema(description = "전화번호")
        val phoneNumber: String,

        @Schema(description = "사용자 구분")
        val userDivision: String
    )
}