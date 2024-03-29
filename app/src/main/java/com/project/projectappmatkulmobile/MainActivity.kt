package com.project.projectappmatkulmobile

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.view.Menu
import android.view.MenuItem


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btnKaryawan = findViewById<Button>(R.id.btnKaryawan)


        btn2.setOnClickListener {
            val intent = Intent(this,SecondActivity :: class.java)
            startActivity(intent)
        }

        btnKaryawan.setOnClickListener {
            val intent = Intent(this,KaryawanForm:: class.java)
            startActivity(intent)
        }


        btn1.setOnClickListener {
            val intent = Intent(this,ViewMahasiswaActivity:: class.java)
            startActivity(intent)

        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.option_menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuTambah -> Intent(this,SecondActivity::class.java).also {
                startActivity(it)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

