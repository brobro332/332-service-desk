package kr.co.samsami_service_desk.notice.service.mapper

import kr.co.samsami_service_desk.notice.dto.NoticeRequestDto
import kr.co.samsami_service_desk.notice.dto.NoticeResponseDto
import org.apache.ibatis.annotations.Mapper

@Mapper
interface NoticeMapper {
    fun createNotice(dto: NoticeRequestDto.CREATE)
    fun readNotice(dto: NoticeRequestDto.READ): List<NoticeResponseDto>
    fun updateNotice(dto: NoticeRequestDto.UPDATE)
    fun deleteNotice(dto: NoticeRequestDto.DELETE)
}