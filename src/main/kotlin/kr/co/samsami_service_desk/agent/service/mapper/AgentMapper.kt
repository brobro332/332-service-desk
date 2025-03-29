package kr.co.samsami_service_desk.agent.service.mapper

import kr.co.samsami_service_desk.agent.dto.AgentRequestDto
import kr.co.samsami_service_desk.agent.dto.AgentResponseDto
import org.apache.ibatis.annotations.Mapper

@Mapper
interface AgentMapper {
    fun createAgent(dto: AgentRequestDto.CREATE)
    fun readAgentList(dto: AgentRequestDto.READ): List<AgentResponseDto>
    fun countAgentList(dto: AgentRequestDto.READ): Long
    fun updateAgent(dto: AgentRequestDto.UPDATE)
    fun deleteAgent(dto: AgentRequestDto.DELETE)
}