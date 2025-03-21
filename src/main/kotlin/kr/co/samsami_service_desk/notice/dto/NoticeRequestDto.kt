package kr.co.samsami_service_desk.notice.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "공지사항 요청 DTO")
class NoticeRequestDto {
    @Schema(
        name = "createNoticeDto",
        description = "공지사항 등록 요청"
    )
    class CREATE (
        @Schema(description = "제목")
        val title: String,

        @Schema(description = "내용")
        val content: String,

        @Schema(description = "작성자 이메일")
        val writerEmail: String
    )

    @Schema(
        name = "readNoticeDto",
        description = "공지사항 목록 조회 요청"
    )
    class READ (
        @Schema(description = "제목")
        val title: String? = null,

        @Schema(description = "내용")
        val content: String? = null,

        @Schema(description = "반환 행 수")
        val limit: Int? = null,

        @Schema(description = "건너뛸 행 수")
        val offset: Int? = null
    )

    @Schema(
        name = "updateNoticeDto",
        description = "공지사항 정보 수정 요청"
    )
    class UPDATE (
        @Schema(description = "아이디")
        val id: Long,

        @Schema(description = "제목")
        val title: String? = null,

        @Schema(description = "내용")
        val content: String? = null
    )

    @Schema(
        name = "deleteNoticeDto",
        description = "공지사항 삭제 요청"
    )
    class DELETE (
        @Schema(description = "아이디")
        val id: Long
    )
}