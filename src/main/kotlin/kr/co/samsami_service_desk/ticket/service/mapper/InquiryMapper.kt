package kr.co.samsami_service_desk.ticket.service.mapper

import kr.co.samsami_service_desk.ticket.dto.InquiryRequestDto
import kr.co.samsami_service_desk.ticket.dto.InquiryResponseDto
import org.apache.ibatis.annotations.Mapper

@Mapper
interface InquiryMapper {
    fun createInquiry(dto: InquiryRequestDto.CREATE)
    fun readInquiryList(dto: InquiryRequestDto.READ): List<InquiryResponseDto>
    fun updateInquiry(dto: InquiryRequestDto.UPDATE)
    fun deleteInquiry(dto: InquiryRequestDto.DELETE)
}