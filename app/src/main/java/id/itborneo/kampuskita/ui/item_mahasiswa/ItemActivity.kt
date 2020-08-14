package id.itborneo.kampuskita.ui.item_mahasiswa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.itborneo.kampuskita.R
import id.itborneo.kampuskita.data.model.Mahasiswa
import id.itborneo.kampuskita.utils.isInternetAvailable
import id.itborneo.kampuskita.utils.setDialogNoInternet
import kotlinx.android.synthetic.main.activity_item_mahasiwa.*

class ItemActivity : AppCompatActivity() {


    private lateinit var viewModel: ItemViewModel

    companion object {
        const val EXTRA_ITEM = "mahasiswa"
    }

    private val TAG = "ItemActivity"
    private lateinit var mahasiswa: Mahasiswa
    private var getDataIntent: Mahasiswa? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_mahasiwa)


        setViewModel()


        val getData = intent.getParcelableExtra<Mahasiswa>(EXTRA_ITEM)

        if (getData != null) {
            getDataIntent = getData
            etAddress.setText(getData.address)
            etName.setText(getData.name)
            etContact.setText(getData.contact)
        }else{
            btn_add.text = "Update Mahasiswa"
        }


        execute(getDataIntent == null)


    }


    private fun execute(isNew: Boolean) {


        btn_add.setOnClickListener {
            mahasiswa = Mahasiswa(
                etAddress.text.toString(),
                etContact.text.toString(),
                etName.text.toString(),
                getDataIntent?.id
            )

            if (isNew) {
                addMahasiswa()
            } else {
                editMahasiswa()
            }
            Log.d(TAG, mahasiswa.toString())
        }


    }

    private fun setViewModel() {

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[ItemViewModel::class.java]

    }


    private fun addMahasiswa() {

        if (isInternetAvailable(this)) {
            viewModel.addMahasiswa(mahasiswa).observe(this, Observer {

                Toast.makeText(this, "Berhasil Menambahkan  ${mahasiswa.name}", Toast.LENGTH_LONG).show()

                onBackPressed()
            })
        } else {
            setDialogNoInternet(this) {
                //retry
                addMahasiswa()
            }
        }


    }

    private fun editMahasiswa() {
        if (isInternetAvailable(this)) {
            viewModel.updateMahasiswa(mahasiswa).observe(this, Observer {

                Toast.makeText(this, "Berhasil Update  ${mahasiswa.name}", Toast.LENGTH_LONG).show()
                onBackPressed()

            })
        } else {
            setDialogNoInternet(this) {
                //retry
                editMahasiswa()
            }
        }
    }


}