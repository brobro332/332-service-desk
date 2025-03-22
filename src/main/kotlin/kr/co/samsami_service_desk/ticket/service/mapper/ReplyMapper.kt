package kr.co.samsami_service_desk.ticket.service.mapper

import kr.co.samsami_service_desk.ticket.dto.ReplyRequestDto
import kr.co.samsami_service_desk.ticket.dto.ReplyResponseDto
import org.apache.ibatis.annotations.Mapper

@Mapper
interface ReplyMapper {
    fun createReply(dto: ReplyRequestDto.CREATE)
    fun readReplyList(dto: ReplyRequestDto.READ): List<ReplyResponseDto>
    fun updateReply(dto: ReplyRequestDto.UPDATE)
    fun deleteReply(dto: ReplyRequestDto.DELETE)
}