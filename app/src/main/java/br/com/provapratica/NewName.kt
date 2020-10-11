package br.com.provapratica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.name_app.*

@Suppress("DEPRECATION")
class NewName : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.name_app)
        val mypreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val myEditor = mypreferences.edit()
        val title = mypreferences.getString("save_title", null).toString()
        if (title != null) {
            app_title.text = title
        }

        btm_new_name.setOnClickListener {
            //salva variavel local
            myEditor.putString("save_title",  new_name.text.toString())
            myEditor.apply()
            nextPage()
        }
        voltar.setOnClickListener {
            finish()
        }
    }

    fun  nextPage(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}