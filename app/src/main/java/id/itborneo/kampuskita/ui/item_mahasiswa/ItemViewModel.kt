package id.itborneo.kampuskita.ui.item_mahasiswa

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.itborneo.kampuskita.data.model.Mahasiswa
import id.itborneo.kampuskita.data.repository.Repository
import id.itborneo.kampuskita.data.response.PostResponse

class ItemViewModel : ViewModel() {


    fun addMahasiswa(mahasiswa: Mahasiswa): LiveData<PostResponse> {
        return Repository.addMahasiswa(mahasiswa)
    }

    fun updateMahasiswa(mahasiswa: Mahasiswa): LiveData<PostResponse> {
        return Repository.updateMahasiswa(mahasiswa)
    }
}