package kr.co.samsami_service_desk.notice.dto

class NoticeRequestDto {
     class CREATE (
        val id: Int? = null,
        val title: String,
        val content: String,
        val createdAt: String? = null,
        val updatedAt: String? = null
    )
}
