package kr.co.samsami_service_desk.ticket.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "답변 목록 조회 응답 DTO")
class ReplyResponseDto (
    @Schema(description = "아이디")
    val id: Int,

    @Schema(description = "문의 아이디")
    val inquiryId: Int,

    @Schema(description = "문의 작성자 이메일")
    val inquiryWriterEmail: String,

    @Schema(description = "작성자 이메일")
    val writerEmail: String,

    @Schema(description = "제목")
    val title: String,

    @Schema(description = "내용")
    val content: String,

    @Schema(description = "등록일자")
    val createdDate: String,

    @Schema(description = "수정일자")
    val updatedDate: String
)