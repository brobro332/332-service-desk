package kr.co.samsami_service_desk.ticket.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import kr.co.samsami_service_desk.common.dto.CommonResponseDto
import kr.co.samsami_service_desk.ticket.dto.ReplyRequestDto
import kr.co.samsami_service_desk.ticket.dto.ReplyResponseDto
import kr.co.samsami_service_desk.ticket.service.ReplyService
import org.springframework.web.bind.annotation.*

@Tag(name = "Ticket", description = "티켓 API")
@RestController
@RequestMapping("/api/v1/ticket/reply")
class ReplyApiController(private val service: ReplyService) {
    @PostMapping
    @ApiResponse(responseCode = "200", description = "답변 등록 완료")
    @Operation(summary = "답변 등록", description = "새로운 답변을 등록합니다.")
    fun createReply(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "답변 등록 요청 DTO",
            required = true,
            content = [Content(schema = Schema(implementation = ReplyRequestDto.CREATE::class))]
        )
        @RequestBody dto: ReplyRequestDto.CREATE): CommonResponseDto<String> {
        service.createReply(dto)
        return CommonResponseDto.ofSuccess("답변이 성공적으로 등록되었습니다.")
    }

    @GetMapping
    @ApiResponse(responseCode = "200", description = "답변 조회 완료")
    @Operation(summary = "답변 조회", description = "답변을 조회합니다.")
    fun readReply(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "답변 조회 요청 DTO",
            required = true,
            content = [Content(schema = Schema(implementation = ReplyRequestDto.READ::class))]
        )
        @ModelAttribute dto: ReplyRequestDto.READ): CommonResponseDto<List<ReplyResponseDto>> {
        return CommonResponseDto.ofSuccess("답변이 성공적으로 조회되었습니다.", service.readReply(dto))
    }

    @PutMapping
    @ApiResponse(responseCode = "200", description = "답변 정보 수정 완료")
    @Operation(summary = "답변 정보 수정", description = "답변 정보를 수정합니다.")
    fun updateReply(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "답변 정보 수정 요청 DTO",
            required = true,
            content = [Content(schema = Schema(implementation = ReplyRequestDto.UPDATE::class))]
        )
        @RequestBody dto: ReplyRequestDto.UPDATE): CommonResponseDto<String> {
        service.updateReply(dto)
        return CommonResponseDto.ofSuccess("답변 정보가 성공적으로 수정되었습니다.")
    }

    @PatchMapping
    @ApiResponse(responseCode = "200", description = "답변 삭제 완료")
    @Operation(summary = "답변 삭제", description = "답변을 삭제 합니다.")
    fun deleteReply(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "답변 삭제 요청 DTO",
            required = true,
            content = [Content(schema = Schema(implementation = ReplyRequestDto.DELETE::class))]
        )
        @RequestBody dto: ReplyRequestDto.DELETE): CommonResponseDto<String> {
        service.deleteReply(dto)
        return CommonResponseDto.ofSuccess("답변이 성공적으로 삭제되었습니다.")
    }
}