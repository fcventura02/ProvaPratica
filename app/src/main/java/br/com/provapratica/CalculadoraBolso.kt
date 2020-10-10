package br.com.provapratica

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.calculadora_bolso.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class CalculadoraBolso : AppCompatActivity() {
    var values: ArrayList<String> = ArrayList()
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

    @SuppressLint("SetTextI18n")
    fun addNumber(number: Number) {
        if (bolso_exprecao.text == "0") {
            values.add("$number")
            bolso_exprecao.text = number.toString()
        } else {
            bolso_exprecao.text = bolso_exprecao.text.toString() + number.toString()
        }
    }

    fun addOperation(string: String) {
        val value = bolso_exprecao.text.toString()
        val validate = validateOperator()
        if (bolso_exprecao.text != "0") {
            if (validate) {
                setOperator(string, value.substring(0, value.length))
            } else {
                setOperator(string, value.substring(0, value.length - 1))
            }

        }
    }

    fun validateOperator(): Boolean {
        val indice = bolso_exprecao.text.length - 1
        val termo = bolso_exprecao.text.get(indice).toString()
        var result = false
        if (termo != "+" && termo != "-" && termo != "*" && termo != "/")
            result = true
        return result
    }

    fun setOperator(string: String, value: String) {
        when (string) {
            "+" -> {
                values.add("+")
                bolso_exprecao.text = ("$value+").toString()
            }
            "-" -> {
                values.add("-")
                bolso_exprecao.text = ("$value-").toString()

            }
            "*" -> {
                values.add("*")
                bolso_exprecao.text = ("$value*").toString()
            }
            "/" -> {
                values.add("/")
                bolso_exprecao.text = ("$value/").toString()
            }
            "=" -> {
                try {
                    val expression = ExpressionBuilder(bolso_exprecao.text.toString()).build()
                    val result = expression.evaluate()
                    val longResult = result.toLong()
                    if (result == longResult.toDouble())
                        bolso_result.text = longResult.toString()
                    else
                        bolso_result.text = result.toString()
                } catch (e: Exception) {
                    Log.d("Excepetion", "message: " + e.message)
                }
            }
            "ac" -> {
                values.clear()
                bolso_exprecao.text = "0"
                bolso_result.text = "0"
            }
            else -> {
                if (bolso_exprecao.text.length > 1)
                    bolso_exprecao.text = value.substring(0, value.length - 1)
                else
                    bolso_exprecao.text = "0"
            }
        }
    }

    fun backPage() {
        finish()
    }
}