package kr.co.samsami_service_desk.notice.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Tag(name = "Notice", description = "공지사항 API")
@Controller
@RequestMapping("/notice")
class NoticeController {
    @Operation(summary = "공지사항 목록 페이지", description = "공지사항 목록 페이지를 반환합니다.")
    @GetMapping("/noticeList")
    fun showNoticeListPage(): String {
        return "/notice/noticeList"
    }

    @Operation(summary = "공지사항 등록 및 수정 페이지", description = "공지사항 등록 및 수정 페이지를 반환합니다.")
    @GetMapping("/saveNotice")
    fun showSaveNoticePage(): String {
        return "/notice/saveNotice"
    }

    @Operation(summary = "공지사항 정보 페이지", description = "공지사항 정보 페이지를 반환합니다.")
    @GetMapping("/noticeInformation")
    fun showNoticeInformationPage(): String {
        return "/notice/noticeInformation"
    }
}