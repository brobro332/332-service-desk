package kr.co.samsami_service_desk.common.dto

class ResponseDto<T>(
    val resultCode: String,
    val message: String?,
    val data: T?
) {
    companion object {
        @JvmStatic
        fun <T> ofSuccess(): ResponseDto<T> {
            return ResponseDto("SUCCESS", null, null)
        }

        @JvmStatic
        fun <T> ofSuccess(message: String): ResponseDto<T> {
            return ResponseDto("SUCCESS", message, null)
        }

        @JvmStatic
        fun <T> ofSuccess(message: String, data: T): ResponseDto<T> {
            return ResponseDto("SUCCESS", message, data)
        }

        @JvmStatic
        fun <T> ofFail(): ResponseDto<T> {
            return ResponseDto("FAIL", null, null)
        }

        @JvmStatic
        fun <T> ofFail(message: String): ResponseDto<T> {
            return ResponseDto("FAIL", message, null)
        }

        @JvmStatic
        fun <T> ofFail(message: String, data: T): ResponseDto<T> {
            return ResponseDto("FAIL", message, data)
        }
    }
}