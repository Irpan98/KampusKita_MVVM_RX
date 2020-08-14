package id.itborneo.kampuskita.data.response

import com.google.gson.annotations.SerializedName

data class PostResponse(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null
)
