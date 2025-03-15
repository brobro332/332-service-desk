package kr.co.samsami_service_desk.notice.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import kr.co.samsami_service_desk.common.dto.CommonResponseDto
import kr.co.samsami_service_desk.notice.dto.NoticeRequestDto
import kr.co.samsami_service_desk.notice.service.NoticeService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/notice")
class NoticeApiController(private val service: NoticeService) {
    @PostMapping
    @ApiResponse(responseCode = "200", description = "공지사항 등록 완료")
    @Operation(summary = "공지사항 등록", description = "새로운 공지사항을 등록합니다.")
    fun createNotice(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "공지사항 등록 요청 DTO",
            required = true,
            content = [Content(schema = Schema(implementation = NoticeRequestDto.CREATE::class))]
        )
        @RequestBody dto: NoticeRequestDto.CREATE): CommonResponseDto<String> {
        service.createNotice(dto)
        return CommonResponseDto.ofSuccess("공지사항이 성공적으로 등록되었습니다.");
    }
}