package com.project.projectappmatkulmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject
import android.R.layout.simple_list_item_1

class ViewMahasiswaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_mahasiswa)

        val bar = supportActionBar
        bar!!.title = "Data Mahasiswa"

        bar.setDisplayHomeAsUpEnabled(true)
        getMahasiswaData()
    }

    fun getMahasiswaData(){
        val queue = Volley.newRequestQueue(this)
        val url = "http://192.168.43.55/kuliah_mobile_prog_unsika/index.php?op=mahasiswa_view"

        val listViewMahasiswa = findViewById<ListView>(R.id.list_mahasiswa)

        val listMahasiswa : ArrayList<String> = ArrayList()

        val stringRequest = StringRequest(Request.Method.GET,url,
            {
                    response ->

                val strRespon = response.toString()
                val jsonObject = JSONObject(strRespon)
                val jsonArray: JSONArray = jsonObject.getJSONArray("mahasiswa")
                var dataMhs = ""

                    for(i in 0 until jsonArray.length()){
                    val jsonInner : JSONObject = jsonArray.getJSONObject(i)
                    val npm = jsonInner.get("npm").toString()
                    val nama =  jsonInner.get("nama").toString()
                    val jenisKelamin = jsonInner.get("jenis_kelamin").toString()
                    val prodi = jsonInner.get("prodi").toString()
                    val hobi = jsonInner.get("hobi").toString()

                        dataMhs = "NPM\t\t: $npm\n" +
                                "Nama: $nama\n" +
                                "JK\t\t\t\t: $jenisKelamin\n" +
                                "Prodi\t: $prodi\n" +
                                "Hobi\t\t: $hobi"
                        listMahasiswa.add(dataMhs)
                    }
                listViewMahasiswa.adapter = ArrayAdapter(this, simple_list_item_1,listMahasiswa)
            }, {})
        queue.add(stringRequest)
    }
}