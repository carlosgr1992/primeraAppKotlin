package controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.android.appandroidmaster.R

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val saludApp = findViewById<AppCompatButton>(R.id.btnSaludApp)

        saludApp.setOnClickListener {
            val intentFirstActivity = Intent(this,FirstAppActivity::class.java)
            startActivity(intentFirstActivity)
        }

        val IMCApp = findViewById<AppCompatButton>(R.id.btnIMCApp)

        IMCApp.setOnClickListener {
            val intentIMCApp = Intent(this,IMCAppActivity::class.java)
            startActivity(intentIMCApp)
        }

    }
}