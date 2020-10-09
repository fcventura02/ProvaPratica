package br.com.provapratica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.calculadora_bolso.*
import java.time.chrono.JapaneseEra.values

class CalculadoraBolso : AppCompatActivity() {
    var values : ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculadora_bolso)
        val title = intent.getStringExtra("title")
        if (title != null) {
            bolso_app_title.text = title.toString()
        }
        bolso_backPage.setOnClickListener {
            backPage()
        }
        //numbers
        btm_0.setOnClickListener { addNumber(0) }
        btm_1.setOnClickListener { addNumber(1) }
        btm_2.setOnClickListener { addNumber(2) }
        btm_3.setOnClickListener { addNumber(3) }
        btm_4.setOnClickListener { addNumber(4) }
        btm_5.setOnClickListener { addNumber(5) }
        btm_6.setOnClickListener { addNumber(6) }
        btm_7.setOnClickListener { addNumber(7) }
        btm_8.setOnClickListener { addNumber(8) }
        btm_9.setOnClickListener { addNumber(9) }
        //operações
        btm_c.setOnClickListener { addOperation("c") }
        btm_ac.setOnClickListener { addOperation("ac") }
        btm_soma.setOnClickListener { addOperation("+") }
        btm_sub.setOnClickListener { addOperation("-") }
        btm_mult.setOnClickListener { addOperation("*") }
        btm_div.setOnClickListener { addOperation("/") }
        btm_equals.setOnClickListener { addOperation("=") }

    }

    fun addNumber(number: Number) {
        //val position = values.size-1
           if (bolso_exprecao.text == "0") {
               values.add("$number")
               bolso_exprecao.text = number.toString()
           }else{
               bolso_exprecao.text =  bolso_exprecao.text.toString() + number.toString()
           }
    }

    fun addOperation(string: String) {
        if (bolso_exprecao.text != "0") {
            when (string) {
                "+" -> {
                    values.add("+")
                    bolso_exprecao.text = bolso_exprecao.text.toString() + "+"
                }
                "-" -> {
                    values.add("-")
                    bolso_exprecao.text = bolso_exprecao.text.toString() + "-"

                }
                "*" -> {
                    values.add("*")
                    bolso_exprecao.text = bolso_exprecao.text.toString() + "*"
                }
                "/" -> {
                    values.add("/")
                    bolso_exprecao.text = bolso_exprecao.text.toString() + "/"
                }
                "=" -> {
                    var termos = bolso_exprecao.text.toString().split("+","-","*","/")
                    var operadores = bolso_exprecao.text.toString().split("9","8","7","6","5","4","3","2","1","0","")
                    Toast.makeText(
                        this,
                        "$termos \n ${operadores}",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }
                "ac" -> {
                    values.clear()
                    bolso_exprecao.text = "0"
                    bolso_result.text = "0"
                }
                else -> {
                }
            }
        }
    }

    fun backPage() {
        finish()
    }
}