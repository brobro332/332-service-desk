package kr.co.samsami_service_desk.notice.service.mapper

import kr.co.samsami_service_desk.notice.dto.NoticeRequestDto
import org.apache.ibatis.annotations.Mapper

@Mapper
interface NoticeMapper {
    fun createNotice(dto: NoticeRequestDto.CREATE)
}