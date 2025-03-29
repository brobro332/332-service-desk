package kr.co.samsami_service_desk.common.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class CommonController {
    @GetMapping
    fun showMainPage(): String {
        return "index"
    }
}