package com.uygulama.kdvhesaplama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var tutarGirin:EditText
    private lateinit var kdvOrani:EditText
    private lateinit var kdvTutari:TextView
    private lateinit var islemTutari:TextView
    private lateinit var toplamTutar:TextView
    private lateinit var kdvTutariH:TextView
    private lateinit var islemTutariH:TextView
    private lateinit var toplamTutarH:TextView
    private lateinit var hesapla:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tutarGirin = findViewById(R.id.tutar)
        kdvOrani = findViewById(R.id.kdvorani)
        kdvTutari = findViewById(R.id.kdvtutari)
        islemTutari = findViewById(R.id.islemtutari)
        toplamTutar = findViewById(R.id.toplamtutar)
        kdvTutariH = findViewById(R.id.kdvtutari_h)
        islemTutariH = findViewById(R.id.islemtutari_h)
        toplamTutarH = findViewById(R.id.toplamtutar_h)
        hesapla = findViewById(R.id.hesapla)


        hesapla.setOnClickListener{
            var tutar:Double? = null
            var oran:Double? = null
            var islemTutariDouble:Double? = null
            var islemTutariHDouble:Double? = null

            if (TextUtils.isEmpty(tutarGirin.text.toString())) {
                Toast.makeText(this, "Tutar Boş Bırakılamaz!!!", Toast.LENGTH_SHORT).show()
            } else {
                tutar= tutarGirin.text.toString().toDouble()
            }


            if (TextUtils.isEmpty(kdvOrani.text.toString())) {
                Toast.makeText(this, "KDV Oranı Boş Bırakılamaz!!!", Toast.LENGTH_SHORT).show()
            } else {
                 oran = kdvOrani.text.toString().toDouble()
            }

            if (tutar != null && oran != null){
                islemTutariDouble = tutar/(1 + (oran/100))
                islemTutariHDouble = tutar*(1+(oran/100))
            }
            else{
                islemTutariDouble = 0.0
                islemTutariHDouble = 0.0
                tutar = 0.0
                oran = 0.0
            }

            kdvTutari.setText("KDV Tutarı: " + "%.2f".format(tutar!!-islemTutariDouble!!))
            islemTutari.setText("İşlem Tutarı: " + "%.2f".format(islemTutariDouble) )
            toplamTutar.setText("Toplam Tutar: " + tutar.toString())

            kdvTutariH.setText("KDV Tutarı: " + "%.2f".format(tutar * (oran!! /100)))
            islemTutariH.setText("İşlem Tutarı: " + "%.2f".format(tutar))
            toplamTutarH.setText("Toplam Tutar: " + "%.2f".format(islemTutariHDouble))


        }

    }
}