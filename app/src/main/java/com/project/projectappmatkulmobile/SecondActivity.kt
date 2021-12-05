package com.project.projectappmatkulmobile

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import org.json.JSONException
import org.json.JSONObject

class SecondActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bar = supportActionBar
        bar!!.title = "Second Activiy"

        bar.setDisplayHomeAsUpEnabled(true)

        //Inisialisasi
        val etNama = findViewById<EditText>(R.id.etNama)
        val etNpm = findViewById<EditText>(R.id.etNpm)
        val rgjenisKelamin = findViewById<RadioGroup>(R.id.rgJenisKelamin)
        val spProdi = findViewById<Spinner>(R.id.spProdi)
        val cbPemrograman = findViewById<CheckBox>(R.id.cbPemrograman)
        val cbBacaBuku = findViewById<CheckBox>(R.id.cbBacaBuku)
        val tvDataMhs = findViewById<TextView>(R.id.tvDataMahasiswa)
        val btnProsses = findViewById<Button>(R.id.btnProsses)

        btnProsses.setOnClickListener {

            var nama = ""
            var npm = ""
            if(etNama.text.isEmpty()){
                etNama.error = "Silahkan Masukan Nama"
            }else{
                nama = etNama.text.toString()
            }

            if(etNpm.text.isEmpty()){
                etNpm.error = "Silahkan Masukan NPM"
            }else{
                npm = etNpm.text.toString()
            }

            val jenisKelamin = when(rgjenisKelamin.checkedRadioButtonId){
                R.id.rbLaki -> "Laki=laki"
                else -> "Perempuan"
            }
            val hobi : String
            if(cbBacaBuku.isChecked && cbPemrograman.isChecked){
                hobi =  "${cbPemrograman.text} , ${cbBacaBuku.text}"
            }else if(cbBacaBuku.isChecked){
                hobi = cbBacaBuku.text.toString()
            }else if(cbPemrograman.isChecked){
                hobi = cbPemrograman.text.toString()
            }else{
                hobi = "-"
            }

            val prodi = spProdi.selectedItem.toString()

            tvDataMhs.text = " Nama\t: $nama\n Npm\t: $npm\n JenisKelamin\t: $jenisKelamin\n Prodi\t: $prodi\n Hobi\t: $hobi"


            val BASE_URL = "http://192.168.43.55/kuliah_mobile_prog_unsika/index.php?op="
            val ACTION = BASE_URL+"mahasiswa_create&npm='$npm'&nama='$nama'&jenis_kelamin='$jenisKelamin'&prodi='$prodi'&hobi='$hobi'"



            val stringRequest = object : StringRequest(Request.Method.GET,ACTION,
            Response.Listener<String>{ response ->
                try{
                    val obj = JSONObject(response)
                    Log.i("hasil",obj.getString("message"))
                }catch(e: JSONException){
                    e.printStackTrace()
                }
            },
             object : Response.ErrorListener{
                override fun onErrorResponse(error: VolleyError?) {
                    Log.e(
                        "hasil : ",error!!.message.toString()
                    )
                }
            }) {
                @Throws(AuthFailureError::class)
                override fun getParams(): MutableMap<String, String> {
                    val params = HashMap<String,String>()
                    return params
                }
            }

            Sender.instance!!.addToRequestQueue(stringRequest)

            Toast.makeText(this,"Data Berhasil Terinput",Toast.LENGTH_SHORT).show()


            etNama.text.clear()
            etNpm.text.clear()
            rgjenisKelamin.check(R.id.rbLaki)
            spProdi.setSelection(0)
            cbBacaBuku.isChecked = false
            cbPemrograman.isChecked = false
        }

    }
}