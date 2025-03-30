package kr.co.samsami_service_desk.notice.service

import kr.co.samsami_service_desk.notice.dto.NoticeRequestDto
import kr.co.samsami_service_desk.notice.dto.NoticeResponseDto
import kr.co.samsami_service_desk.notice.service.mapper.NoticeMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class NoticeService(private val mapper: NoticeMapper) {
    private val logger: Logger = LoggerFactory.getLogger(NoticeService::class.java)

    /**
     * 공지사항 등록
     */
    @Transactional
    fun createNotice(dto: NoticeRequestDto.CREATE) {
        try {
            mapper.createNotice(dto)
        } catch (e: Exception) {
            logger.error("공지사항 등록 중 오류 발생: ${e.message}", e)
            throw RuntimeException("공지사항 등록에 실패했습니다.")
        }
    }

    /**
     * 공지사항 목록 조회
     */
    fun readNoticeList(dto: NoticeRequestDto.READ): List<NoticeResponseDto> {
        try {
            return mapper.readNoticeList(dto)
        } catch (e: Exception) {
            logger.error("공지사항 목록 조회 중 오류 발생: ${e.message}", e)
            throw RuntimeException("공지사항 목록 조회에 실패했습니다.")
        }
    }

    /**
     * 공지사항 목록 개수 조회
     */
    fun countNoticeList(dto: NoticeRequestDto.READ): Long {
        try {
            return mapper.countNoticeList(dto)
        } catch (e: Exception) {
            logger.error("공지사항 목록 건수 조회 중 오류 발생: ${e.message}", e)
            throw RuntimeException("공지사항 목록 건수 조회에 실패했습니다.")
        }
    }

    /**
     * 공지사항 수정
     */
    @Transactional
    fun updateNotice(dto: NoticeRequestDto.UPDATE) {
        try {
            mapper.updateNotice(dto)
        } catch (e: Exception) {
            logger.error("공지사항 정보 수정 중 오류 발생: ${e.message}", e)
            throw RuntimeException("공지사항 정보 수정에 실패했습니다.")
        }
    }

    /**
     * 공지사항 삭제
     */
    @Transactional
    fun deleteNotice(dto: NoticeRequestDto.DELETE) {
        try {
            mapper.deleteNotice(dto)
        } catch (e: Exception) {
            logger.error("공지사항 삭제 중 오류 발생: ${e.message}", e)
            throw RuntimeException("공지사항 삭제에 실패했습니다.")
        }
    }
}