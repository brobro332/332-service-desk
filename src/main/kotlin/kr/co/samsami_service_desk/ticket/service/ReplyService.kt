package kr.co.samsami_service_desk.ticket.service

import kr.co.samsami_service_desk.ticket.dto.ReplyRequestDto
import kr.co.samsami_service_desk.ticket.dto.ReplyResponseDto
import kr.co.samsami_service_desk.ticket.service.mapper.ReplyMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReplyService(private val mapper: ReplyMapper) {
    private val logger: Logger = LoggerFactory.getLogger(ReplyService::class.java)

    @Transactional
    fun createReply(dto: ReplyRequestDto.CREATE) {
        try {
            mapper.createReply(dto)
        } catch (e: Exception) {
            logger.error("답변 등록 중 오류 발생: ${e.message}", e)
            throw RuntimeException("답변 등록에 실패했습니다.")
        }
    }

    fun readReply(dto: ReplyRequestDto.READ): List<ReplyResponseDto> {
        try {
            return mapper.readReply(dto)
        } catch (e: Exception) {
            logger.error("답변 조회 중 오류 발생: ${e.message}", e)
            throw RuntimeException("답변 조회에 실패했습니다.")
        }
    }

    @Transactional
    fun updateReply(dto: ReplyRequestDto.UPDATE) {
        try {
            mapper.updateReply(dto)
        } catch (e: Exception) {
            logger.error("답변 정보 수정 중 오류 발생: ${e.message}", e)
            throw RuntimeException("답변 정보 수정에 실패했습니다.")
        }
    }

    @Transactional
    fun deleteReply(dto: ReplyRequestDto.DELETE) {
        try {
            mapper.deleteReply(dto)
        } catch (e: Exception) {
            logger.error("답변 삭제 중 오류 발생: ${e.message}", e)
            throw RuntimeException("답변 삭제에 실패했습니다.")
        }
    }
}