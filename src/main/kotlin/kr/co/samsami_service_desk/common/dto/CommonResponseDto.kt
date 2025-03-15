package kr.co.samsami_service_desk.common.dto

class CommonResponseDto<T>(
    val resultCode: String,
    val message: String?,
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