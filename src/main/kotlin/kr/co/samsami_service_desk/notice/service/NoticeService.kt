package kr.co.samsami_service_desk.notice.service

import kr.co.samsami_service_desk.notice.dto.NoticeRequestDto
import kr.co.samsami_service_desk.notice.service.mapper.NoticeMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class NoticeService(private val mapper: NoticeMapper) {
    private val logger: Logger = LoggerFactory.getLogger(NoticeService::class.java)

    @Transactional
    fun createNotice(dto: NoticeRequestDto.CREATE) {
        try {
            mapper.createNotice(dto)
        } catch (e: Exception) {
            logger.error("공지사항 등록 중 오류 발생: ${e.message}", e)
            throw RuntimeException("공지사항 등록에 실패했습니다.")
        }
    }
}