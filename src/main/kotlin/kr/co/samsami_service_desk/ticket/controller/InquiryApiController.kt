package kr.co.samsami_service_desk.ticket.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import kr.co.samsami_service_desk.common.dto.CommonResponseDto
import kr.co.samsami_service_desk.ticket.dto.InquiryRequestDto
import kr.co.samsami_service_desk.ticket.dto.InquiryResponseDto
import kr.co.samsami_service_desk.ticket.service.InquiryService
import org.springframework.web.bind.annotation.*

@Tag(name = "Ticket", description = "티켓 API")
@RestController
@RequestMapping("/api/v1/ticket/inquiry")
class InquiryApiController(private val service: InquiryService) {
    @PostMapping
    @ApiResponse(responseCode = "200", description = "문의 등록 완료")
    @Operation(summary = "문의 등록", description = "새로운 문의를 등록합니다.")
    fun createInquiry(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "문의 등록 요청 DTO",
            required = true,
            content = [Content(schema = Schema(implementation = InquiryRequestDto.CREATE::class))]
        )
        @RequestBody dto: InquiryRequestDto.CREATE): CommonResponseDto<String> {
        service.createInquiry(dto)
        return CommonResponseDto.ofSuccess("문의가 성공적으로 등록되었습니다.")
    }

    @GetMapping
    @ApiResponse(responseCode = "200", description = "문의 목록 조회 완료")
    @Operation(summary = "문의 목록 조회", description = "문의 목록을 조회합니다.")
    fun readInquiry(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "문의 목록 조회 요청 DTO",
            required = true,
            content = [Content(schema = Schema(implementation = InquiryRequestDto.READ::class))]
        )
        @ModelAttribute dto: InquiryRequestDto.READ): CommonResponseDto<List<InquiryResponseDto>> {
        return CommonResponseDto.ofSuccess("문의 목록이 성공적으로 조회되었습니다.", service.readInquiryList(dto))
    }

    @PutMapping
    @ApiResponse(responseCode = "200", description = "문의 정보 수정 완료")
    @Operation(summary = "문의 정보 수정", description = "문의 정보를 수정합니다.")
    fun updateInquiry(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "문의 정보 수정 요청 DTO",
            required = true,
            content = [Content(schema = Schema(implementation = InquiryRequestDto.UPDATE::class))]
        )
        @RequestBody dto: InquiryRequestDto.UPDATE): CommonResponseDto<String> {
        service.updateInquiry(dto)
        return CommonResponseDto.ofSuccess("문의 정보가 성공적으로 수정되었습니다.")
    }

    @PatchMapping
    @ApiResponse(responseCode = "200", description = "문의 삭제 완료")
    @Operation(summary = "문의 삭제", description = "문의를 삭제 합니다.")
    fun deleteInquiry(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "문의 삭제 요청 DTO",
            required = true,
            content = [Content(schema = Schema(implementation = InquiryRequestDto.DELETE::class))]
        )
        @RequestBody dto: InquiryRequestDto.DELETE): CommonResponseDto<String> {
        service.deleteInquiry(dto)
        return CommonResponseDto.ofSuccess("문의가 성공적으로 삭제되었습니다.")
    }
}