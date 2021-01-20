package com.example.picturebook

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.Menu
import android.view.MenuItem
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_save_photo.*
import java.lang.Exception


class SavePhoto : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_photo)
        auth = FirebaseAuth.getInstance()

        val artNameList = ArrayList<String>()
        val artIdList = ArrayList<Int>()
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, artNameList)
        listView.adapter = arrayAdapter

        try {
            val database = this.openOrCreateDatabase("Arts", Context.MODE_PRIVATE, null)
            val cursor = database.rawQuery("SELECT * FROM arts", null)
            val artNameIx = cursor.getColumnIndex("artname")
            val idIx = cursor.getColumnIndex("id")

            while (cursor.moveToNext()) {
                artNameList.add(cursor.getString(artNameIx))
                artIdList.add(cursor.getInt(idIx))
            }
            arrayAdapter.notifyDataSetChanged()
            cursor.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }


        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            val intent = Intent (this,SavePhotoActiviy2::class.java)
            intent.putExtra("info","old")
            intent.putExtra("id",artIdList[position])
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.options_menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.logout) {
            auth.signOut()
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        if (item.itemId == R.id.add_art_item) {
            val intent = Intent(this, SavePhotoActiviy2::class.java)
            intent.putExtra("info","new")
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

}





