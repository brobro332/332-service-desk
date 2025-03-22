package kr.co.samsami_service_desk.user.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Tag(name = "User", description = "사용자 API")
@Controller
@RequestMapping("/user")
class UserController {
    @Operation(summary = "사용자 목록 페이지", description = "사용자 목록 페이지를 반환합니다.")
    @GetMapping("/userList")
    fun showUserListPage(): String {
        return "/user/userList"
    }

    @Operation(summary = "사용자 등록 및 수정 페이지", description = "사용자 등록 및 수정 페이지를 반환합니다.")
    @GetMapping("/saveUser")
    fun showSaveUserPage(): String {
        return "/user/saveUser"
    }

    @Operation(summary = "사용자 정보 페이지", description = "사용자 정보 페이지를 반환합니다.")
    @GetMapping("/userInformation")
    fun showUserInformationPage(): String {
        return "/user/userInformation"
    }
}