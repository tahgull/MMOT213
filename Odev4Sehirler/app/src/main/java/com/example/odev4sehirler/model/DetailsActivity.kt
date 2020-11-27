package com.example.odev4sehirler.model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.odev4sehirler.R
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    lateinit var text : TextView
    lateinit var imageview : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        text = findViewById(R.id.sehirIsımleriUygula)
        imageview = findViewById(R.id.gorselUygula)
        val extras = intent.extras

        val value = extras?.getString("gonderilen")
        text.setText(value)
        

    }
}
