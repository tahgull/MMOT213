package com.example.camera

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.ByteArrayOutputStream


class MainActivity : AppCompatActivity() {

    private var adapter: CaptureAdapter? = null
    var ArrayImages = ArrayList<ByteArray>()
    val REQUESTCODE = 6
    lateinit var Camera: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Camera = findViewById(R.id.ImageCaptureBtn)

        ImageCaptureBtn.setOnClickListener {
            if (checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED || checkSelfPermission(
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                val permission = arrayOf(
                    android.Manifest.permission.CAMERA,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
                requestPermissions(permission, REQUESTCODE)
            } else
                CaptureCamera()
        }

    }

    private fun CaptureCamera()
    {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUESTCODE)
            }
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == REQUESTCODE)
        {
            val imageBitmap = intent?.extras!!.get("data") as Bitmap
            val bytes = ByteArrayOutputStream()
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 70, bytes)
            ArrayImages.add(bytes.toByteArray())
            bytes.close()
        }

        adapter = CaptureAdapter(this, ArrayImages)
        setPhotos.adapter = adapter
    }

}