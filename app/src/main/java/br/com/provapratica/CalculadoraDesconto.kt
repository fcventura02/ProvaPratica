package br.com.provapratica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.calculadora_desconto.*

class CalculadoraDesconto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculadora_desconto)
        val title = intent.getStringExtra("title")
        if (title != null) {
            desconto_app_title.text = title.toString()
        }
    }
}