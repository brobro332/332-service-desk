package kr.co.samsami_service_desk.notice.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/notice")
class NoticeController {
    @GetMapping("/noticeList")
    fun showNoticeListPage(): String {
        return "/notice/noticeList"
    }

    @GetMapping("/createNotice")
    fun showCreateNoticePage(): String {
        return "/notice/createNotice"
    }
}