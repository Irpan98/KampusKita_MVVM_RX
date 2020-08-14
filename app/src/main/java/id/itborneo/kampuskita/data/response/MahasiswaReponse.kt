package id.itborneo.kampuskita.data.response

import com.google.gson.annotations.SerializedName
import id.itborneo.kampuskita.data.model.Mahasiswa

data class MahasiswaReponse(

    @field:SerializedName("data")
	val data: List<Mahasiswa?>? = null,

    @field:SerializedName("message")
	val message: String? = null,

    @field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null
)


