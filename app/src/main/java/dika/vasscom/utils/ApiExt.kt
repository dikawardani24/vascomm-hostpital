package dika.vasscom.utils

import dika.vasscom.core.domain.ApiResult
import dika.vasscom.core.network.response.ErrorResponse
import retrofit2.HttpException

fun Exception.toApiError(): ApiResult.Error {
    if (this is HttpException) {
        val body = this.response()?.errorBody()?.string() ?: ""
        val response = try {
            JSonHelper.fromJson(ErrorResponse::class.java, body).error
        } catch (e: Exception) {
            e.message ?: "An error occurred"
        }
        return ApiResult.Error(response)
    }
    return ApiResult.Error(this.message ?: "An error occurred")
}