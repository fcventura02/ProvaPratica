package br.com.provapratica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.name_app.*

class NewName : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.name_app)
        val title = intent.getStringExtra("title")
        if (title != null) {
            app_title.text = title.toString()
        }

        btm_new_name.setOnClickListener {
            nextPage()
        }
    }

    fun  nextPage(){
        val name = new_name.text.toString()
        app_title.text = name
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("app_title", name)
        startActivity(intent)
    }
}