package com.example.odev4sehirler

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import com.example.odev4sehirler.adapters.SehirAdapters
import com.example.odev4sehirler.model.DetailsActivity
import com.example.odev4sehirler.model.SehirlerItem
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.cardview_grid.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {



    private var arrayList: ArrayList<SehirlerItem>? = null
    private var gridView: GridView? = null
    private var sehirAdapters: SehirAdapters? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        gridView = findViewById(R.id.Mygridview)
        arrayList = ArrayList()
        arrayList = ListeyiUygula()
        sehirAdapters = SehirAdapters(applicationContext, arrayList!!)
        gridView?.adapter = sehirAdapters
        gridView?.onItemClickListener = this

    }

    private fun ListeyiUygula(): ArrayList<SehirlerItem> {

        var arrayList: ArrayList<SehirlerItem> = ArrayList()



        arrayList.add(SehirlerItem(R.drawable.anitkabir, "ANKARA"))
        arrayList.add(SehirlerItem(R.drawable.antalya, "ANTALYA"))
        arrayList.add(SehirlerItem(R.drawable.canakkale, "ÇANAKKALE"))
        arrayList.add(SehirlerItem(R.drawable.istanbul, "İstanbul"))
        arrayList.add(SehirlerItem(R.drawable.izmir, "İZMİR"))
        arrayList.add(SehirlerItem(R.drawable.kirsehir, "KIRŞEHİR"))
        arrayList.add(SehirlerItem(R.drawable.kocaeli, "KOCAELİ"))
        arrayList.add(SehirlerItem(R.drawable.sakarya, "SAKARYA"))
        arrayList.add(SehirlerItem(R.drawable.rize, "RİZE"))
        arrayList.add(SehirlerItem(R.drawable.kars, "KARS"))

        return arrayList

    }



    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        val intent = Intent(applicationContext,DetailsActivity::class.java)

        intent.putExtra("gonderilen",sehir.text.toString())

        startActivity(intent)

        var sehirler: SehirlerItem = arrayList!!.get(position)
        Toast.makeText(applicationContext, sehirler.isim, Toast.LENGTH_SHORT).show()

    }


    }



