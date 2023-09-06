package controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.android.appandroidmaster.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)

        //añadir la funcionalidad del botón "btnPulsame"
        val editTextView = findViewById<AppCompatEditText>(R.id.editTextView)
        val btnPulsame = findViewById<AppCompatButton>(R.id.btnPulsame)


        btnPulsame.setOnClickListener {
            val textoEditTextView = editTextView.text.toString()
            if(textoEditTextView.isNotBlank()){
                Log.i("Botón pulsado", "Cliente escribe= $textoEditTextView")
                val intent = Intent(this, ResultFirstAppActivity::class.java)
                intent.putExtra("EXTRA_NAME",textoEditTextView)
                startActivity(intent)
            }
        }
    }
}