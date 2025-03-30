package kr.co.samsami_service_desk.agent.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import kr.co.samsami_service_desk.common.dto.CommonResponseDto
import kr.co.samsami_service_desk.common.`object`.PagedResult
import kr.co.samsami_service_desk.agent.dto.AgentRequestDto
import kr.co.samsami_service_desk.agent.dto.AgentResponseDto
import kr.co.samsami_service_desk.agent.service.AgentService
import org.springframework.web.bind.annotation.*

@Tag(name = "Agent", description = "에이전트 API")
@RestController
@RequestMapping("/api/v1/agent")
class AgentApiController (private val service: AgentService) {
    @PostMapping
    @ApiResponse(responseCode = "200", description = "에이전트 등록 완료")
    @Operation(summary = "에이전트 등록", description = "새로운 에이전트를 등록합니다.")
    fun createAgent(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "에이전트 등록 요청 DTO",
            required = true,
            content = [Content(schema = Schema(implementation = AgentRequestDto.CREATE::class))]
        )
        @RequestBody dto: AgentRequestDto.CREATE): CommonResponseDto<String> {
        service.createAgent(dto);
        return CommonResponseDto.ofSuccess("에이전트가 성공적으로 등록되었습니다.")
    }

    @GetMapping
    @ApiResponse(responseCode = "200", description = "에이전트 목록 조회 완료")
    @Operation(summary = "에이전트 목록 조회", description = "에이전트 목록을 조회합니다.")
    fun readAgentList(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "에이전트 목록 조회 요청 DTO",
            required = true,
            content = [Content(schema = Schema(implementation = AgentRequestDto.READ::class))]
        )
        @ModelAttribute dto: AgentRequestDto.READ): CommonResponseDto<PagedResult<List<AgentResponseDto>>> {
        return CommonResponseDto.ofSuccess("에이전트 목록이 성공적으로 조회되었습니다.", PagedResult(service.countAgentList(dto), service.readAgentList(dto)))
    }

    @PutMapping
    @ApiResponse(responseCode = "200", description = "에이전트 정보 수정 완료")
    @Operation(summary = "에이전트 정보 수정", description = "에이전트 정보를 수정합니다.")
    fun updateAgent(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "에이전트 정보 수정 요청 DTO",
            required = true,
            content = [Content(schema = Schema(implementation = AgentRequestDto.UPDATE::class))]
        )
        @RequestBody dto: AgentRequestDto.UPDATE): CommonResponseDto<String> {
        service.updateAgent(dto)
        return CommonResponseDto.ofSuccess("에이전트 정보가 성공적으로 수정되었습니다.")
    }

    @PatchMapping
    @ApiResponse(responseCode = "200", description = "에이전트 삭제 완료")
    @Operation(summary = "에이전트 삭제", description = "에이전트를 삭제 합니다.")
    fun deleteAgent(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "에이전트 삭제 요청 DTO",
            required = true,
            content = [Content(schema = Schema(implementation = AgentRequestDto.DELETE::class))]
        )
        @RequestBody dto: AgentRequestDto.DELETE): CommonResponseDto<String> {
        service.deleteAgent(dto)
        return CommonResponseDto.ofSuccess("에이전트가 성공적으로 삭제되었습니다.")
    }
}