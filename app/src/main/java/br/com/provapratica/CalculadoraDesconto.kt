package br.com.provapratica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.calculadora_bolso.*
import kotlinx.android.synthetic.main.calculadora_desconto.*

class CalculadoraDesconto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculadora_desconto)
        val title = intent.getStringExtra("title")
        if (title != null) {
            desconto_app_title.text = title.toString()
        }
        calcular.setOnClickListener {
            val pay = value_pay.text.toString().toDouble()
            val discount = value_discount.text.toString().toInt()
            if (pay > 0.0 && discount != null) {
                if (discount < 100) {
                    val result = calcDesconto(pay, discount)
                    value_result.text = (pay - result).toString()
                    message("Você esta economizando $result reais.")
                } else {
                    message("Insira um desconto válido. Insira um valor menor que 100")
                }
            }
        }

        desconto_limpar.setOnClickListener {
            clear()
        }

        desconto_voltar.setOnClickListener {
            backPage()
        }

        if (savedInstanceState != null){
            value_result.text = savedInstanceState.getString("desconto_save")
        }
    }

    fun calcDesconto(pay: Double, discount: Int): Double {
        return  (pay * discount) / 100
    }

    fun message(value: String) {
        Toast.makeText(
            this,
            value,
            Toast.LENGTH_LONG
        )
            .show()
    }

    fun clear(){
        value_pay.setText("")
        value_discount.setText("")
    }

    fun backPage(){
        finish()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putString("desconto_save", value_result.text.toString())
    }

}