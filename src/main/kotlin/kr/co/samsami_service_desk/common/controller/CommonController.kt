package kr.co.samsami_service_desk.common.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Tag(name = "Common", description = "공통 API")
@Controller
@RequestMapping
class CommonController {
    @Operation(summary = "인덱스 페이지", description = "인덱스 페이지를 반환합니다.")
    @GetMapping("/")
    fun showMainPage(): String {
        return "index"
    }

    @Operation(summary = "로그인 페이지", description = "로그인 페이지를 반환합니다.")
    @GetMapping("/login")
    fun showLoginPage(): String {
        return "login"
    }
}