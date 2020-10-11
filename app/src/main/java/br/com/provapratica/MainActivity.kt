package br.com.provapratica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
  /*  */
    lateinit var title : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mypreferences = PreferenceManager.getDefaultSharedPreferences(this)
        title = mypreferences.getString("save_title", null).toString()
        if (title != "null") {
            main_app_title.text = title
        }

        btm_name.setOnClickListener {
            nextPage("newname")
        }
        btm_calc_bolso.setOnClickListener {
            nextPage("calcBolso")
        }
        btm_calc_desconto.setOnClickListener {
            nextPage("calcDesconto")
        }
        btm_calc_temperatura.setOnClickListener {
            nextPage("calcTemperatura")
        }
    }

    fun nextPage(string: String) {
        val intent: Intent
        when (string) {
            "calcDesconto" -> intent = Intent(this, CalculadoraDesconto::class.java)
            "calcTemperatura" -> intent = Intent(this, CalculadoraTemperatura::class.java)
            "calcBolso" -> intent = Intent(this, CalculadoraBolso::class.java)
            else -> intent = Intent(this, NewName::class.java)
        }
        startActivity(intent)
    }
}