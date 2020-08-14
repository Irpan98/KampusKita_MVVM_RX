package id.itborneo.kampuskita.data.repository

import androidx.lifecycle.LiveData

import id.itborneo.kampuskita.data.model.Mahasiswa
import id.itborneo.kampuskita.data.response.PostResponse

interface DataSource {

    fun getMahasiswa(): LiveData<List<Mahasiswa>>


//    fun getTvShows(): LiveData<List<TvShow>>
//
//    fun getCastMovie(idMovie: Int?): LiveData<List<Cast>>
//    fun getCastTvShow(idTvShow: Int?): LiveData<List<Cast>>


    fun addMahasiswa(mahasiswa: Mahasiswa): LiveData<PostResponse>

    fun updateMahasiswa(mahasiswa: Mahasiswa): LiveData<PostResponse>

    fun deleteMahasiwa(id: Int): LiveData<PostResponse>
}
