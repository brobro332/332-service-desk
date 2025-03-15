package kr.co.samsami_service_desk.user.service.mapper

import kr.co.samsami_service_desk.user.dto.UserRequestDto
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper {
    fun createUser(dto: UserRequestDto.CREATE)
}