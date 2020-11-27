package com.example.odev4sehirler.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.odev4sehirler.R
import com.example.odev4sehirler.model.SehirlerItem

class SehirAdapters(var context: Context, var arrayList: ArrayList<SehirlerItem>) : BaseAdapter() {


    override fun getItem(position: Int): Any {


        return arrayList.get(position)

    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getCount(): Int {

        return arrayList.size


    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View = View.inflate(context, R.layout.cardview_grid, null)

        var resimler: ImageView = view.findViewById(R.id.icon)
        var isimler: TextView = view.findViewById(R.id.sehir)

        var listeResimleri: SehirlerItem = arrayList.get(position)
        resimler.setImageResource(listeResimleri.icon!!)
        isimler.text = listeResimleri.isim


        return view
    }


}