package kr.co.samsami_service_desk.ticket.service.mapper

import kr.co.samsami_service_desk.ticket.dto.ReplyRequestDto
import kr.co.samsami_service_desk.ticket.dto.ReplyResponseDto
import org.apache.ibatis.annotations.Mapper

@Mapper
interface ReplyMapper {
    /**
     * 답변 등록
     */
    fun createReply(dto: ReplyRequestDto.CREATE)

    /**
     * 답변 조회
     */
    fun readReply(dto: ReplyRequestDto.READ): List<ReplyResponseDto>

    /**
     * 답변 수정
     */
    fun updateReply(dto: ReplyRequestDto.UPDATE)

    /**
     * 답변 삭제
     */
    fun deleteReply(dto: ReplyRequestDto.DELETE)
}