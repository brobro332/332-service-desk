package kr.co.samsami_service_desk.common.`object`

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "페이징 결과 DTO")
class PagedResult<T>(
    @Schema(description = "전체 데이터 수")
    val count: Long,

    @Schema(description = "데이터 리스트")
    val list: T
)