package controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.android.appandroidmaster.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class IMCAppActivity : AppCompatActivity() {

    private lateinit var cardHombre: CardView
    private lateinit var cardMujer: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rangeSliderAltura: RangeSlider
    private lateinit var btnSumaPeso: FloatingActionButton
    private lateinit var btnRestaPeso: FloatingActionButton
    private lateinit var textoPeso: TextView
    private lateinit var textoEdad: TextView
    private lateinit var restaEdad: FloatingActionButton
    private lateinit var sumaEdad: FloatingActionButton
    private lateinit var resultadoIMC: CardView

    private var alturaPorDefecto: Int = 120
    private var edadPorDefecto: Int = 27

    companion object {

        const val IMC_KEY = "IMC_RESULTADO"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imcapp)

        initializeComponents()
        initializeListeners()

        initUI()
    }

    private fun initUI() {

        tvHeight.text = String.format("%d cm", alturaPorDefecto)
    }

    private fun initializeComponents() {
        cardHombre = findViewById(R.id.cardHombre)
        cardMujer = findViewById(R.id.cardMujer)
        tvHeight = findViewById(R.id.textViewAltura)
        rangeSliderAltura = findViewById(R.id.rangeSliderAltura)
        btnSumaPeso = findViewById(R.id.btnSumarPeso)
        btnRestaPeso = findViewById(R.id.btnRestarPeso)
        textoPeso = findViewById(R.id.pesoNumero)
        textoEdad = findViewById(R.id.numeroEdad)
        restaEdad = findViewById(R.id.btnRestarEdad)
        sumaEdad = findViewById(R.id.btnSumarEdad)

        textoEdad.text = edadPorDefecto.toString()

        resultadoIMC = findViewById(R.id.calculaIMC)
    }

    private fun initializeListeners() {
        cardHombre.setOnClickListener { setGenderColor(cardHombre) }
        cardMujer.setOnClickListener { setGenderColor(cardMujer) }
        rangeSliderAltura.addOnChangeListener { _, value, _ ->
            tvHeight.text = String.format("%.0f cm", value)
        }
        btnSumaPeso.setOnClickListener {
            var pesoActual = textoPeso.text.toString().toInt()
            pesoActual++
            textoPeso.text = pesoActual.toString()

        }
        btnRestaPeso.setOnClickListener {
            var pesoActual = textoPeso.text.toString().toInt()
            pesoActual--
            textoPeso.text = pesoActual.toString()
        }
        restaEdad.setOnClickListener {
            edadPorDefecto -= 1
            textoEdad.text = edadPorDefecto.toString()
        }
        sumaEdad.setOnClickListener {
            edadPorDefecto += 1
            textoEdad.text = edadPorDefecto.toString()
        }
        resultadoIMC.setOnClickListener {
            val IMC = calculaIMC()
            //Log.i("Botón pulsado", "El imc es = ${String.format("%.2f", IMC)}")
            cambiaPantallaResultado(IMC)
        }
    }

    private fun cambiaPantallaResultado(imc: Double) {

        val intent = Intent(this,ResultadoIMCActivity::class.java)
        intent.putExtra(IMC_KEY,imc)
        startActivity(intent)
    }

    private fun calculaIMC(): Double {

        val alturaString = tvHeight.text.toString().replace(" cm", "").trim()
        val altura: Double = alturaString.toDouble() / 100 * alturaString.toDouble() / 100

        val peso: Double = textoPeso.text.toString().toDouble()
        val IMC: Double = peso / altura

        return IMC
    }

    private fun setGenderColor(genderType: CardView) {
        if (genderType == cardHombre) {
            cardHombre.setCardBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.background_component_selected
                )
            )
            cardMujer.setCardBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.background_component
                )
            )
        } else {
            cardMujer.setCardBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.background_component_selected
                )
            )
            cardHombre.setCardBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.background_component
                )
            )
        }
    }

}