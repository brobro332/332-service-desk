package kr.co.samsami_service_desk.notice.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "공지사항 요청 DTO")
class NoticeReqDto {
    @Schema(description = "공지사항 등록 요청 DTO")
    class CREATE (
        @Schema(description = "아이디")
        val id: Int? = null,
        
        @Schema(description = "작성자 아이디")
        val userId: Long,

        @Schema(description = "제목")
        val title: String,

        @Schema(description = "내용")
        val content: String
    )
}