package kr.co.samsami_service_desk.agent.service

import kr.co.samsami_service_desk.agent.dto.AgentRequestDto
import kr.co.samsami_service_desk.agent.dto.AgentResponseDto
import kr.co.samsami_service_desk.agent.service.mapper.AgentMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AgentService(private val mapper: AgentMapper) {
    private val logger: Logger = LoggerFactory.getLogger(AgentService::class.java)

    @Transactional
    fun createAgent(dto: AgentRequestDto.CREATE) {
        try {
            mapper.createAgent(dto)
        } catch(e: Exception) {
            logger.error("에이전트 등록 중 오류 발생: ${e.message}", e)
            throw RuntimeException(e)
        }
    }

    fun readAgentList(dto: AgentRequestDto.READ): List<AgentResponseDto> {
        try {
            return mapper.readAgentList(dto)
        } catch (e: Exception) {
            logger.error("에이전트 목록 조회 중 오류 발생: ${e.message}", e)
            throw RuntimeException(e)
        }
    }

    fun countAgentList(dto: AgentRequestDto.READ): Long {
        try {
            return mapper.countAgentList(dto)
        } catch (e: Exception) {
            logger.error("에이전트 목록 건수 조회 중 오류 발생: ${e.message}", e)
            throw RuntimeException(e)
        }
    }

    @Transactional
    fun updateAgent(dto: AgentRequestDto.UPDATE) {
        try {
            mapper.updateAgent(dto)
        } catch(e: Exception) {
            logger.error("에이전트 정보 수정 중 오류 발생: ${e.message}", e)
            throw RuntimeException(e)
        }
    }

    @Transactional
    fun deleteAgent(dto: AgentRequestDto.DELETE) {
        try {
            mapper.deleteAgent(dto)
        } catch(e: Exception) {
            logger.error("에이전트 삭제 중 오류 발생: ${e.message}", e)
            throw RuntimeException(e)
        }
    }
}