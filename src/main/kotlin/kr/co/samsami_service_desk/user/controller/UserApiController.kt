package kr.co.samsami_service_desk.user.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import kr.co.samsami_service_desk.common.dto.CommonResponseDto
import kr.co.samsami_service_desk.user.dto.UserRequestDto
import kr.co.samsami_service_desk.user.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
class UserApiController (private val userService: UserService) {
    @PostMapping
    @ApiResponse(responseCode = "200", description = "사용자 등록 완료")
    @Operation(summary = "사용자 등록", description = "새로운 사용자를 등록합니다.")
    fun createUser(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "사용자 등록 요청 DTO",
            required = true,
            content = [Content(schema = Schema(implementation = UserRequestDto.CREATE::class))]
        )
        @RequestBody dto: UserRequestDto.CREATE): CommonResponseDto<String> {
        userService.createUser(dto);
        return CommonResponseDto.ofSuccess("사용자가 성공적으로 등록되었습니다.")
    }
}