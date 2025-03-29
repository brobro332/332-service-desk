package kr.co.samsami_service_desk.agent.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Tag(name = "Agent", description = "에이전트 API")
@Controller
@RequestMapping("/agent")
class AgentController {
    @Operation(summary = "에이전트 목록 페이지", description = "에이전트 목록 페이지를 반환합니다.")
    @GetMapping("/agentList")
    fun showAgentListPage(): String {
        return "/agent/agentList"
    }

    @Operation(summary = "에이전트 등록 및 수정 페이지", description = "에이전트 등록 및 수정 페이지를 반환합니다.")
    @GetMapping("/saveAgent")
    fun showSaveAgentPage(): String {
        return "/agent/saveAgent"
    }

    @Operation(summary = "에이전트 정보 페이지", description = "에이전트 정보 페이지를 반환합니다.")
    @GetMapping("/agentInformation")
    fun showAgentInformationPage(): String {
        return "/agent/agentInformation"
    }
}