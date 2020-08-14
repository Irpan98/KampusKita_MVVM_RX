package id.itborneo.kampuskita.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.itborneo.kampuskita.data.model.Mahasiswa
import id.itborneo.kampuskita.data.repository.Repository
import id.itborneo.kampuskita.data.response.PostResponse

class MainViewModel : ViewModel() {
    private var TAG = "MainViewModel"

    fun getMahasiswa(): LiveData<List<Mahasiswa>> {
        return Repository.getMahasiswa()
    }

    fun deleteMahasiswa(id: Int): LiveData<PostResponse> {
        return Repository.deleteMahasiwa(id)
    }
}