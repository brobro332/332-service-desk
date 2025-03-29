package kr.co.samsami_service_desk.ticket.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "답변 요청 DTO")
object ReplyRequestDto {
    @Schema(
        name = "createReplyDto",
        description = "답변 등록 요청"
    )
    class CREATE (
        @Schema(description = "문의 아이디")
        val inquiryId: Long,

        @Schema(description = "문의 작성자 이메일")
        val inquiryWriterEmail: String,

        @Schema(description = "제목")
        val title: String,

        @Schema(description = "내용")
        val content: String,

        @Schema(description = "작성자 이메일")
        val writerEmail: String
    )

    @Schema(
        name = "readReplyDto",
        description = "답변 조회 요청"
    )
    class READ (
        @Schema(description = "문의 아이디")
        val inquiryId: Long,

        @Schema(description = "문의 작성자 이메일")
        val inquiryWriterEmail: String,
    )

    @Schema(
        name = "updateReplyDto",
        description = "답변 정보 수정 요청"
    )
    class UPDATE (
        @Schema(description = "문의 아이디")
        val inquiryId: Long,

        @Schema(description = "문의 작성자 이메일")
        val inquiryWriterEmail: String,

        @Schema(description = "제목")
        val title: String? = null,

        @Schema(description = "내용")
        val content: String? = null
    )

    @Schema(
        name = "deleteReplyDto",
        description = "답변 삭제 요청"
    )
    class DELETE (
        @Schema(description = "문의 아이디")
        val inquiryId: Long,

        @Schema(description = "문의 작성자 이메일")
        val inquiryWriterEmail: String,
    )
}