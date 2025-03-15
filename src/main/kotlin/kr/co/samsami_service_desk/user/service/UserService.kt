package kr.co.samsami_service_desk.user.service

import kr.co.samsami_service_desk.user.dto.UserRequestDto
import kr.co.samsami_service_desk.user.dto.UserResponseDto
import kr.co.samsami_service_desk.user.service.mapper.UserMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(private val mapper: UserMapper) {
    private val logger: Logger = LoggerFactory.getLogger(UserService::class.java)

    @Transactional
    fun createUser(dto: UserRequestDto.CREATE) {
        try {
            mapper.createUser(dto)
        } catch(e: Exception) {
            logger.error("사용자 등록 중 오류 발생: ${e.message}", e)
            throw RuntimeException(e)
        }
    }

    fun readUserList(dto: UserRequestDto.READ): List<UserResponseDto> {
        try {
            return mapper.readUserList(dto)
        } catch (e: Exception) {
            logger.error("사용자 목록 조회 중 오류 발생: ${e.message}", e)
            throw RuntimeException(e)
        }
    }

    @Transactional
    fun updateUser(dto: UserRequestDto.UPDATE) {
        try {
            mapper.updateUser(dto)
        } catch(e: Exception) {
            logger.error("사용자 정보 수정 중 오류 발생: ${e.message}", e)
            throw RuntimeException(e)
        }
    }

    @Transactional
    fun deleteUser(dto: UserRequestDto.DELETE) {
        try {
            mapper.deleteUser(dto)
        } catch(e: Exception) {
            logger.error("사용자 삭제 중 오류 발생: ${e.message}", e)
            throw RuntimeException(e)
        }
    }
}