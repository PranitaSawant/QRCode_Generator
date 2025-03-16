package com.example.qrcode_generator

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder

/*This is Sample app to generate QR code from entered text*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etInput : EditText = findViewById(R.id.etInput)
        val btnGenerate : Button = findViewById(R.id.btnGenerate)
        val imgQr : ImageView = findViewById(R.id.imgQR)

        btnGenerate.setOnClickListener {
            val input = etInput.text.toString()
            if(input.isNotEmpty()) {
                val bitmap = generateQrCode(input)
                imgQr.setImageBitmap(bitmap)
            }
        }
    }

    private fun generateQrCode(text : String) : Bitmap{
        val barcodeEncoder = BarcodeEncoder()
        val bitmap = barcodeEncoder.encodeBitmap(text, BarcodeFormat.QR_CODE,400,400)
        return bitmap
    }
}