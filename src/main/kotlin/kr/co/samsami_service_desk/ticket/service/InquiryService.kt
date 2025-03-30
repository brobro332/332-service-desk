package kr.co.samsami_service_desk.ticket.service

import kr.co.samsami_service_desk.notice.dto.NoticeRequestDto
import kr.co.samsami_service_desk.ticket.dto.InquiryRequestDto
import kr.co.samsami_service_desk.ticket.dto.InquiryResponseDto
import kr.co.samsami_service_desk.ticket.service.mapper.InquiryMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class InquiryService(private val mapper: InquiryMapper) {
    private val logger: Logger = LoggerFactory.getLogger(InquiryService::class.java)

    /**
     * 문의 등록
     */
    @Transactional
    fun createInquiry(dto: InquiryRequestDto.CREATE) {
        try {
            mapper.createInquiry(dto)
        } catch (e: Exception) {
            logger.error("문의 등록 중 오류 발생: ${e.message}", e)
            throw RuntimeException("문의 등록에 실패했습니다.")
        }
    }

    /**
     * 문의 목록 조회
     */
    fun readInquiryList(dto: InquiryRequestDto.READ): List<InquiryResponseDto> {
        try {
            return mapper.readInquiryList(dto)
        } catch (e: Exception) {
            logger.error("문의 목록 조회 중 오류 발생: ${e.message}", e)
            throw RuntimeException("문의 목록 조회에 실패했습니다.")
        }
    }

    /**
     * 문의 목록 개수 조회
     */
    fun countInquiryList(dto: InquiryRequestDto.READ): Long {
        try {
            return mapper.countInquiryList(dto)
        } catch (e: Exception) {
            logger.error("문의 목록 건수 조회 중 오류 발생: ${e.message}", e)
            throw RuntimeException("문의 목록 건수 조회에 실패했습니다.")
        }
    }

    /**
     * 문의 수정
     */
    @Transactional
    fun updateInquiry(dto: InquiryRequestDto.UPDATE) {
        try {
            mapper.updateInquiry(dto)
        } catch (e: Exception) {
            logger.error("문의 정보 수정 중 오류 발생: ${e.message}", e)
            throw RuntimeException("문의 정보 수정에 실패했습니다.")
        }
    }

    /**
     * 문의 삭제
     */
    @Transactional
    fun deleteInquiry(dto: InquiryRequestDto.DELETE) {
        try {
            mapper.deleteInquiry(dto)
        } catch (e: Exception) {
            logger.error("문의 삭제 중 오류 발생: ${e.message}", e)
            throw RuntimeException("문의 삭제에 실패했습니다.")
        }
    }
}