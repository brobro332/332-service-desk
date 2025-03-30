package kr.co.samsami_service_desk.ticket.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Tag(name = "Ticket", description = "티켓 API")
@Controller
@RequestMapping("/ticket")
class TicketController {
    @Operation(summary = "티켓 목록 페이지", description = "티켓 목록 페이지를 반환합니다.")
    @GetMapping("/ticketList")
    fun showTicketListPage(): String {
        return "/ticket/ticketList"
    }

    @Operation(summary = "티켓 정보 및 답변 저장 페이지", description = "티켓 정보 및 답변 저장 페이지를 반환합니다.")
    @GetMapping("/ticketInformation")
    fun showSaveReplyPage(): String {
        return "/ticket/saveReply"
    }

    @Operation(summary = "문의 등록 페이지", description = "문의 등록 페이지를 반환합니다.")
    @GetMapping("/inquiry/createInquiry")
    fun showCreateInquiryPage(): String {
        return "/ticket/createInquiry"
    }
}