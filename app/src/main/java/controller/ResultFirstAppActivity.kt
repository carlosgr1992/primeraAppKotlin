package controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.appandroidmaster.R

class ResultFirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_first_app)

        val textViewNombre = findViewById<TextView>(R.id.textViewNombre)

        val nombre : String = intent.extras?.getString("EXTRA_NAME").orEmpty()

        textViewNombre.text = "Hola ${nombre.substring(0,1).toUpperCase() + nombre.substring(1).toLowerCase()}, un placer conocerte"
    }
}