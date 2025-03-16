package kr.co.samsami_service_desk.user.service.mapper

import kr.co.samsami_service_desk.user.dto.UserRequestDto
import kr.co.samsami_service_desk.user.dto.UserResponseDto
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper {
    fun createUser(dto: UserRequestDto.CREATE)
    fun readUserList(dto: UserRequestDto.READ): List<UserResponseDto>
    fun updateUser(dto: UserRequestDto.UPDATE)
    fun deleteUser(dto: UserRequestDto.DELETE)
}