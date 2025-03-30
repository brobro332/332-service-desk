package kr.co.samsami_service_desk.common.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "공통 응답 DTO")
class CommonResponseDto<T>(
    @Schema(description = "결과 코드")
    val resultCode: String,

    @Schema(description = "메시지")
    val message: String?,

    @Schema(description = "데이터")
    val data: T?
) {
    companion object {
        @JvmStatic
        fun <T> ofSuccess(): CommonResponseDto<T> {
            return CommonResponseDto("SUCCESS", null, null)
        }

        @JvmStatic
        fun <T> ofSuccess(message: String): CommonResponseDto<T> {
            return CommonResponseDto("SUCCESS", message, null)
        }

        @JvmStatic
        fun <T> ofSuccess(message: String, data: T): CommonResponseDto<T> {
            return CommonResponseDto("SUCCESS", message, data)
        }

        @JvmStatic
        fun <T> ofFail(): CommonResponseDto<T> {
            return CommonResponseDto("FAIL", null, null)
        }

        @JvmStatic
        fun <T> ofFail(message: String): CommonResponseDto<T> {
            return CommonResponseDto("FAIL", message, null)
        }

        @JvmStatic
        fun <T> ofFail(message: String, data: T): CommonResponseDto<T> {
            return CommonResponseDto("FAIL", message, data)
        }
    }
}