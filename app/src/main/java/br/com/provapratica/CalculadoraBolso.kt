package br.com.provapratica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.calculadora_bolso.*

class CalculadoraBolso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculadora_bolso)
        val title = intent.getStringExtra("title")
        if (title != null) {
            bolso_app_title.text = title.toString()
        }

    }
}