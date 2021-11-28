package com.project.projectappmatkulmobile

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class KaryawanForm : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_karyawanform)

        val etNama = findViewById<EditText>(R.id.etNamaKaryawan)
        val etUnitKerja = findViewById<EditText>(R.id.etUnitKerja)
        val rgJk = findViewById<RadioGroup>(R.id.rgJenisKelaminKaryawan)
        val spJumlahAnak = findViewById<Spinner>(R.id.spJumlahAnak)
        val spLamaBekerja = findViewById<Spinner>(R.id.spLamaBekerja)
        val tvDataKaryawan = findViewById<TextView>(R.id.tvDataKaryawan)
        val btnProsses = findViewById<Button>(R.id.btnProssesKaryawan)

        btnProsses.setOnClickListener {
            val nama = etNama.text.toString()
            val unitKerja = etUnitKerja.text.toString()

            val jenisKelamin = when(rgJk.checkedRadioButtonId){
                R.id.rbLk -> "Laki=laki"
                else -> "Perempuan"
            }

            val jumlahAnak = spJumlahAnak.selectedItem.toString()
            var tunjangan = ""
            if(jumlahAnak == "lebih dari 3 dan kurang dari 5"){
                tunjangan = "Rp. 2.000.000"
            }else if(jumlahAnak == "lebih dari 5 dan kurang dari 8"){
                tunjangan = "Rp. 4.000.000"
            }else{
                tunjangan = "Rp. 0"
            }

            val lamaBekerja = spLamaBekerja.selectedItem.toString()
            tvDataKaryawan.text = " Nama : $nama\n Unit Kerja : $unitKerja\n Jenis Kelamin : $jenisKelamin\n Jumlah Anak : $jumlahAnak\n Tunjangan : $tunjangan\n Lama Bekerja : $lamaBekerja"

        }



    }
}