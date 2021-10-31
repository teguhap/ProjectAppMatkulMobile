package com.project.projectappmatkulmobile

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

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

        }


    }
}