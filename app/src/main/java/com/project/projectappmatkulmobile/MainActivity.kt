package com.project.projectappmatkulmobile

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btnKaryawan = findViewById<Button>(R.id.btnKaryawan)
        val tv1 = findViewById<TextView>(R.id.tv1)


        btn2.setOnClickListener {
            val intent = Intent(this,SecondActivity :: class.java)
            startActivity(intent)
        }

        btnKaryawan.setOnClickListener {
            val intent = Intent(this,KaryawanForm:: class.java)
            startActivity(intent)
        }


        btn1.setOnClickListener {
            Toast.makeText(this,"Ini proses dari klik tombol", Toast.LENGTH_SHORT).show()
            tv1.text = "Berubah setelah tombol di kKlik"

        }

    }
}