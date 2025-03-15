package kr.co.samsami_service_desk.notice.service.mapper

import kr.co.samsami_service_desk.notice.dto.NoticeReqDto
import org.apache.ibatis.annotations.Mapper

@Mapper
interface NoticeMapper {
    fun createNotice(dto: NoticeReqDto.CREATE)
}