package br.com.provapratica

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.calculadora_temperatura.*

class CalculadoraTemperatura : AppCompatActivity() {
    var valuetemperatura = 0.0
    var temperatura_f = true
    var temperatura_c = false
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculadora_temperatura)
        val title = intent.getStringExtra("title")
        if (title != null) {
            temperatura_app_title.text = title.toString()
        }


        temperatura.setOnClickListener {
            dialogInput()
        }

        rbtm_c.setOnClickListener {
            if (temperatura_c) {
                valuetemperatura = calcC(valuetemperatura)
                temperatura.text = "$valuetemperatura°"
                temperatura_c = false
                temperatura_f = true
                rbtm_f.isChecked = false
            }
        }
        rbtm_f.setOnClickListener {
            if (temperatura_f) {
                valuetemperatura = calcF(valuetemperatura)
                temperatura.text = "$valuetemperatura°"
                temperatura_f = false
                temperatura_c = true
                rbtm_c.isChecked = false
            }
        }

        btm_voltar.setOnClickListener {
            finish()
        }

    }

    @SuppressLint("SetTextI18n")
    fun dialogInput(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Entre cum uma temperatura")

        val input = EditText(this)
        input.inputType = InputType.TYPE_CLASS_NUMBER

        builder.setView(input)
        builder.setPositiveButton("ok") { dialogInterface, i ->
            val value = input.text.toString()
            valuetemperatura = value.toDouble()
            temperatura.text = "$valuetemperatura°"
        }
        builder.setNegativeButton("cancelar", null)
        builder.show()

    }

    fun calcF(value: Double): Double {
        val result = value * 1.8 + 32
        return Math.round(result * 1000.0) / 1000.0
    }

    fun calcC(value: Double): Double {
        val result = (value - 32) / 1.8
        return Math.round(result * 1000.0) / 1000.0
    }
}