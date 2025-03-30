package kr.co.samsami_service_desk.ticket.service.mapper

import kr.co.samsami_service_desk.ticket.dto.InquiryRequestDto
import kr.co.samsami_service_desk.ticket.dto.InquiryResponseDto
import org.apache.ibatis.annotations.Mapper

@Mapper
interface InquiryMapper {
    /**
     * 문의 등록
     */
    fun createInquiry(dto: InquiryRequestDto.CREATE)

    /**
     * 문의 목록 조회
     */
    fun readInquiryList(dto: InquiryRequestDto.READ): List<InquiryResponseDto>

    /**
     * 문의 목록 개수 조회
     */
    fun countInquiryList(dto: InquiryRequestDto.READ): Long

    /**
     * 문의 수정
     */
    fun updateInquiry(dto: InquiryRequestDto.UPDATE)

    /**
     * 문의 삭제
     */
    fun deleteInquiry(dto: InquiryRequestDto.DELETE)
}