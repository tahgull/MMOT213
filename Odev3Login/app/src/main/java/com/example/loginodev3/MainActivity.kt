package com.example.loginodev3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adi = findViewById(R.id.TextAdi) as EditText
        var soyadi = findViewById(R.id.TextSoyadii) as EditText
        var yası = findViewById(R.id.TextYas) as EditText
        var eposta = findViewById(R.id.TextMail) as EditText
        var şifre = findViewById(R.id.EditTextSifre) as EditText
        var sifreTekrar = findViewById(R.id.EditTextSifreTekrar) as EditText
        var kayıt = findViewById(R.id.KontrolBtn) as Button


        Toast.makeText(applicationContext, "Kayıt Ekranına Hoş Geldiniz", Toast.LENGTH_SHORT).show()

        kayıt.setOnClickListener(){
            if(adi.text.isEmpty() )
                Toast.makeText(applicationContext,"İsim Hatalıdır Tekrar Girin!",Toast.LENGTH_SHORT).show()
            else if(soyadi.text.isEmpty())
                Toast.makeText(applicationContext,"Soyisim Hatalıdır Tekrar Girin!",Toast.LENGTH_SHORT).show()
            else if(yası.text.isEmpty() ||yası.text.toString().toInt() !in 18..100)
                Toast.makeText(applicationContext,"Yaş Hatalıdır Tekrar Girin!",Toast.LENGTH_SHORT).show()
            else if(!mailInvalid(eposta.text.toString()))
                Toast.makeText(applicationContext,"E-posta, Kontrolü hatalıdır tekrar gir!! ",Toast.LENGTH_SHORT).show()
            else if(şifre.text.toString().trim().length < 5)
                Toast.makeText(applicationContext,"Şifre En Az 5 Karakterden Oluşmalıdır.!",Toast.LENGTH_SHORT).show()
            else if(sifreTekrar.text.toString() != sifreTekrar.text.toString())
                Toast.makeText(applicationContext,"Şifreler Aynı Değil Tekrar Gir",Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(applicationContext,"Kayıt ve Kontroller Başarılıdır!",Toast.LENGTH_SHORT).show()

        }
    }
    private fun mailInvalid(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}

