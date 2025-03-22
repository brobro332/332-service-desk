package kr.co.samsami_service_desk.user.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import kr.co.samsami_service_desk.common.dto.CommonResponseDto
import kr.co.samsami_service_desk.user.dto.UserRequestDto
import kr.co.samsami_service_desk.user.dto.UserResponseDto
import kr.co.samsami_service_desk.user.service.UserService
import org.springframework.web.bind.annotation.*

@Tag(name = "User", description = "사용자 API")
@RestController
@RequestMapping("/api/v1/user")
class UserApiController (private val service: UserService) {
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
        service.createUser(dto);
        return CommonResponseDto.ofSuccess("사용자가 성공적으로 등록되었습니다.")
    }

    @GetMapping
    @ApiResponse(responseCode = "200", description = "사용자 목록 조회 완료")
    @Operation(summary = "사용자 목록 조회", description = "사용자 목록을 조회합니다.")
    fun readUserList(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "사용자 목록 조회 요청 DTO",
            required = true,
            content = [Content(schema = Schema(implementation = UserRequestDto.READ::class))]
        )
        @ModelAttribute dto: UserRequestDto.READ): CommonResponseDto<List<UserResponseDto>> {
        return CommonResponseDto.ofSuccess("사용자 목록이 성공적으로 조회되었습니다.", service.readUserList(dto))
    }

    @PutMapping
    @ApiResponse(responseCode = "200", description = "사용자 정보 수정 완료")
    @Operation(summary = "사용자 정보 수정", description = "사용자 정보를 수정합니다.")
    fun updateUser(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "사용자 정보 수정 요청 DTO",
            required = true,
            content = [Content(schema = Schema(implementation = UserRequestDto.UPDATE::class))]
        )
        @RequestBody dto: UserRequestDto.UPDATE): CommonResponseDto<String> {
        service.updateUser(dto)
        return CommonResponseDto.ofSuccess("사용자 정보가 성공적으로 수정되었습니다.")
    }

    @PatchMapping
    @ApiResponse(responseCode = "200", description = "사용자 삭제 완료")
    @Operation(summary = "사용자 삭제", description = "사용자를 삭제 합니다.")
    fun deleteUser(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "사용자 삭제 요청 DTO",
            required = true,
            content = [Content(schema = Schema(implementation = UserRequestDto.DELETE::class))]
        )
        @RequestBody dto: UserRequestDto.DELETE): CommonResponseDto<String> {
        service.deleteUser(dto)
        return CommonResponseDto.ofSuccess("사용자가 성공적으로 삭제되었습니다.")
    }
}