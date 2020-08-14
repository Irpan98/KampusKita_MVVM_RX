package id.itborneo.kampuskita.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Mahasiswa(

    @field:SerializedName("address")
    val address: String? = null,

    @field:SerializedName("contact")
    val contact: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: String? = null
):Parcelable