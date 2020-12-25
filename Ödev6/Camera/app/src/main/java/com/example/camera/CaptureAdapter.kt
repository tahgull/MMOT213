package com.example.camera

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.camera.R
import kotlinx.android.synthetic.main.photos_items.view.*

class CaptureAdapter(): BaseAdapter()
{
    var Image : List<ByteArray> = emptyList()
    var context: Context?=null

    constructor(context: Context, imagesList: List<ByteArray>) : this() {
        this.context = context
        this.Image = imagesList
    }
    @SuppressLint("ServiceCast", "ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View
    {
        val img= BitmapFactory.decodeByteArray(Image[position], 0, Image[position].size)
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        var view = inflator.inflate(R.layout.photos_items, null)
        view.imageView.setImageBitmap(img)

        return view
    }

    override fun getItem(position: Int): Any {
        return Image[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return Image.size
    }

}