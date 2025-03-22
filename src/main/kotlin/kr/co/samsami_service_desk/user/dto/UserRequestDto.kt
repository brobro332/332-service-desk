package kr.co.samsami_service_desk.user.dto

import io.swagger.v3.oas.annotations.media.Schema
import kr.co.samsami_service_desk.user.UserDivision

@Schema(description = "사용자 요청 DTO")
class UserRequestDto {
    @Schema(
        name = "createUserDto",
        description = "사용자 등록 요청"
    )
    class CREATE (
        @Schema(description = "이메일")
        val email: String,

        @Schema(description = "비밀번호")
        val password: String,

        @Schema(description = "이름")
        val name: String,

        @Schema(description = "전화번호")
        val phoneNumber: String,

        @Schema(description = "사용자 구분")
        val userDivision: UserDivision
    )

    @Schema(
        name = "readUserDto",
        description = "사용자 목록 조회 요청"
    )
    class READ (
        @Schema(description = "이메일")
        val email: String? = null,

        @Schema(description = "이름")
        val name: String? = null,

        @Schema(description = "사용자 구분")
        val userDivision: UserDivision? = null,

        @Schema(description = "반환 행 수")
        val limit: Int? = null,

        @Schema(description = "건너뛸 행 수")
        val offset: Int? = null
    )

    @Schema(
        name = "updateUserDto",
        description = "사용자 정보 수정 요청"
    )
    class UPDATE (
        @Schema(description = "이메일")
        val email: String,

        @Schema(description = "비밀번호")
        val password: String? = null,

        @Schema(description = "이름")
        val name: String? = null,

        @Schema(description = "전화번호")
        val phoneNumber: String? = null,

        @Schema(description = "사용자 구분")
        val userDivision: UserDivision? = null
    )

    @Schema(
        name = "deleteUserDto",
        description = "사용자 삭제 요청"
    )
    class DELETE (
        @Schema(description = "이메일")
        val email: String
    )
}