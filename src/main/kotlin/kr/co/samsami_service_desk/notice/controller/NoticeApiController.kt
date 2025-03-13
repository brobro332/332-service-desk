package kr.co.samsami_service_desk.notice.controller

import kr.co.samsami_service_desk.common.dto.ResponseDto
import kr.co.samsami_service_desk.notice.dto.NoticeRequestDto
import kr.co.samsami_service_desk.notice.service.NoticeService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/notice")
class NoticeApiController(private val noticeService: NoticeService) {
    @PostMapping
    fun createNotice(@RequestBody dto: NoticeRequestDto.CREATE): ResponseDto<String> {
        noticeService.createNotice(dto)
        return ResponseDto.ofSuccess<String>("공지사항이 성공적으로 등록되었습니다.");
    }
}