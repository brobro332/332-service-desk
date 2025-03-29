package kr.co.samsami_service_desk.agent.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "에이전트 목록 조회 응답 DTO")
class AgentResponseDto (
    @Schema(description = "행 번호")
    val rowNumber: Int,

    @Schema(description = "이메일")
    val email: String,

    @Schema(description = "이름")
    val name: String,

    @Schema(description = "전화번호")
    val phoneNumber: String,

    @Schema(description = "에이전트 구분")
    val userDivision: String,

    @Schema(description = "삭제 여부")
    val deleteFlag: Boolean,

    @Schema(description = "등록일자")
    val createdDate: String,

    @Schema(description = "수정일자")
    val updatedDate: String
)