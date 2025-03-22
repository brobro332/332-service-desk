package kr.co.samsami_service_desk.ticket.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "문의 요청 DTO")
object InquiryRequestDto {
    @Schema(
        name = "createInquiryDto",
        description = "문의 등록 요청"
    )
    class CREATE (
        @Schema(description = "제목")
        val title: String,

        @Schema(description = "내용")
        val content: String,

        @Schema(description = "작성자 이메일")
        val writerEmail: String,

        @Schema(description = "작성자 전화번호")
        val writerPhoneNumber: String? = null
    )

    @Schema(
        name = "readInquiryDto",
        description = "문의 목록 조회 요청"
    )
    class READ (
        @Schema(description = "제목")
        val title: String? = null,

        @Schema(description = "내용")
        val content: String? = null,

        @Schema(description = "작성자 이메일")
        val writerEmail: String? = null,

        @Schema(description = "반환 행 수")
        val limit: Int? = null,

        @Schema(description = "건너뛸 행 수")
        val offset: Int? = null
    )

    @Schema(
        name = "updateInquiryDto",
        description = "문의 정보 수정 요청"
    )
    class UPDATE (
        @Schema(description = "아이디")
        val id: Long,

        @Schema(description = "제목")
        val title: String? = null,

        @Schema(description = "내용")
        val content: String? = null,

        @Schema(description = "작성자 이메일")
        val writerEmail: String,

        @Schema(description = "작성자 전화번호")
        val writerPhoneNumber: String? = null
    )

    @Schema(
        name = "deleteInquiryDto",
        description = "문의 삭제 요청"
    )
    class DELETE (
        @Schema(description = "아이디")
        val id: Long,

        @Schema(description = "작성자 이메일")
        val writerEmail: String
    )
}