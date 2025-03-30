package kr.co.samsami_service_desk.agent.service.mapper

import kr.co.samsami_service_desk.agent.dto.AgentRequestDto
import kr.co.samsami_service_desk.agent.dto.AgentResponseDto
import org.apache.ibatis.annotations.Mapper

@Mapper
interface AgentMapper {
    /**
     * 에이전트 등록
     */
    fun createAgent(dto: AgentRequestDto.CREATE)

    /**
     * 에이전트 목록 조회
     */
    fun readAgentList(dto: AgentRequestDto.READ): List<AgentResponseDto>

    /**
     * 에이전트 목록 개수 조회
     */
    fun countAgentList(dto: AgentRequestDto.READ): Long

    /**
     * 에이전트 수정
     */
    fun updateAgent(dto: AgentRequestDto.UPDATE)

    /**
     * 에이전트 삭제
     */
    fun deleteAgent(dto: AgentRequestDto.DELETE)
}