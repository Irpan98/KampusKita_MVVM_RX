package id.itborneo.kampuskita.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.itborneo.kampuskita.data.model.Mahasiswa
import id.itborneo.kampuskita.data.response.MahasiswaReponse
import id.itborneo.kampuskita.data.remote.ApiClient
import id.itborneo.kampuskita.data.response.PostResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object Repository : DataSource {

    private val TAG = "Repository"
    override fun getMahasiswa(): LiveData<List<Mahasiswa>> {
        Log.e(TAG, "getMahasiswa called")

        val mahasiswa = MutableLiveData<List<Mahasiswa>>()
        ApiClient.create().getMahasiswa().enqueue(object : Callback<MahasiswaReponse> {
            override fun onFailure(call: Call<MahasiswaReponse>, t: Throwable) {
                Log.e(TAG, "onFailure called : gagal terhubung ke API error : ${t.message}")
            }

            override fun onResponse(
                call: Call<MahasiswaReponse>,
                response: Response<MahasiswaReponse>
            ) {


                val getMahasiswa = mutableListOf<Mahasiswa>()
                if (response.body() != null) {

                    val mahasiswaReponse = response.body() as MahasiswaReponse

                    mahasiswaReponse.data?.forEach {
                        it?.let {
                            getMahasiswa.add(it)
                        }
                    }
                    Log.d(TAG, getMahasiswa.toString())


                } else {
                    Log.d(TAG, "response.body adalah null")
                }
                mahasiswa.postValue(getMahasiswa)

            }

        })
        return mahasiswa

    }

    override fun addMahasiswa(mahasiswa: Mahasiswa): LiveData<PostResponse> {
        Log.e(TAG, "addMahasiswa called")


        val postResponse = MutableLiveData<PostResponse>()
        if (
            mahasiswa.name == null ||
            mahasiswa.contact == null ||
            mahasiswa.address == null
        ) return postResponse

        ApiClient.create()
            .addMahasiswa(mahasiswa.name, mahasiswa.contact.toLong(), mahasiswa.address)
            .enqueue(object : Callback<PostResponse> {
                override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                    Log.e(TAG, "onFailure called : gagal terhubung ke API error : ${t.message}")
                }

                override fun onResponse(
                    call: Call<PostResponse>,
                    response: Response<PostResponse>
                ) {


                    var getResponse = PostResponse()
                    if (response.body() != null) {

                        getResponse = response.body() as PostResponse


                        Log.d(TAG, getResponse.toString())


                    } else {
                        Log.d(TAG, "response.body adalah null")
                    }
                    postResponse.postValue(getResponse)

                }

            })
        return postResponse
    }

    override fun updateMahasiswa(mahasiswa: Mahasiswa): LiveData<PostResponse> {
        Log.e(TAG, "updateMahasiswa called")


        val postResponse = MutableLiveData<PostResponse>()
        if (
            mahasiswa.id == null ||
            mahasiswa.name == null ||
            mahasiswa.contact == null ||
            mahasiswa.address == null
        ) return postResponse

        ApiClient.create()
            .updateMahasiswsa(
                mahasiswa.id.toInt(),
                mahasiswa.name,
                mahasiswa.contact.toInt(),
                mahasiswa.address
            )
            .enqueue(object : Callback<PostResponse> {
                override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                    Log.e(TAG, "onFailure called : gagal terhubung ke API error : ${t.message}")
                }

                override fun onResponse(
                    call: Call<PostResponse>,
                    response: Response<PostResponse>
                ) {


                    var getResponse = PostResponse()
                    if (response.body() != null) {

                        getResponse = response.body() as PostResponse


                        Log.d(TAG, getResponse.toString())


                    } else {
                        Log.d(TAG, "response.body adalah null")
                    }
                    postResponse.postValue(getResponse)

                }

            })
        return postResponse
    }

    override fun deleteMahasiwa(id: Int): LiveData<PostResponse> {
        Log.e(TAG, "deleteMahasiwa called")


        val postResponse = MutableLiveData<PostResponse>()

        ApiClient.create()
            .deleteMahasiswa(
                id.toInt()
            )
            .enqueue(object : Callback<PostResponse> {
                override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                    Log.e(TAG, "onFailure called : gagal terhubung ke API error : ${t.message}")
                }

                override fun onResponse(
                    call: Call<PostResponse>,
                    response: Response<PostResponse>
                ) {


                    var getResponse = PostResponse()
                    if (response.body() != null) {

                        getResponse = response.body() as PostResponse


                        Log.d(TAG, getResponse.toString())


                    } else {
                        Log.d(TAG, "response.body adalah null")
                    }
                    postResponse.postValue(getResponse)

                }

            })
        return postResponse
    }


}