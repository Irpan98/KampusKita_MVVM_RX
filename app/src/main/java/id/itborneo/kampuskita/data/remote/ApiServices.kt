package id.itborneo.kampuskita.data.remote


import id.itborneo.kampuskita.data.model.Mahasiswa
import id.itborneo.kampuskita.data.response.MahasiswaReponse
import id.itborneo.kampuskita.data.response.PostResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServices {

    @GET("getData.php")

    fun getMahasiswa(): Call<MahasiswaReponse>


    @FormUrlEncoded
    @POST("insertData.php")
    fun addMahasiswa(
        @Field("name") nama: String,
        @Field("contact") contact: Long,
        @Field("address") address: String

    ): Call<PostResponse>

    @FormUrlEncoded
    @POST("updateData.php")
    fun updateMahasiswsa(
        @Field("id") id: Int,
        @Field("name") nama: String,
        @Field("contact") contact: Int,
        @Field("address") address: String

    ): Call<PostResponse>

    @FormUrlEncoded
    @POST("deleteData.php")
    fun deleteMahasiswa(
        @Field("id") id: Int
    ): Call<PostResponse>



}