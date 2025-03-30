package kr.co.samsami_service_desk.notice.service.mapper

import kr.co.samsami_service_desk.notice.dto.NoticeRequestDto
import kr.co.samsami_service_desk.notice.dto.NoticeResponseDto
import org.apache.ibatis.annotations.Mapper

@Mapper
interface NoticeMapper {
    /**
     * 공지사항 등록
     */
    fun createNotice(dto: NoticeRequestDto.CREATE)

    /**
     * 공지사항 목록 조회
     */
    fun readNoticeList(dto: NoticeRequestDto.READ): List<NoticeResponseDto>

    /**
     * 공지사항 목록 개수 조회
     */
    fun countNoticeList(dto: NoticeRequestDto.READ): Long

    /**
     * 공지사항 수정
     */
    fun updateNotice(dto: NoticeRequestDto.UPDATE)

    /**
     * 공지사항 삭제
     */
    fun deleteNotice(dto: NoticeRequestDto.DELETE)
}