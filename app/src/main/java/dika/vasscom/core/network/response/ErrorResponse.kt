package dika.vasscom.core.network.response

import com.google.gson.annotations.SerializedName


data class ErrorResponse(
    @SerializedName("error")
    val error: String
)