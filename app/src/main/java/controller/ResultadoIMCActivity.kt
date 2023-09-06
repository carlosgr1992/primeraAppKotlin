package controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.android.appandroidmaster.R

class ResultadoIMCActivity : AppCompatActivity() {

    //CONSTANTES (No las uso porque es preferible utilizar los string del fichero values) lo dejo por ver como se hacen las constantes
    companion object {
        const val MUYBAJO:String = "Excesivamente bajo"
        const val NORMAL:String = "Normal"
        const val LIGEROSOBREPESO:String = "Ligero sobrepeso"
        const val OBESIDAD:String = "Obesidad"

        const val TEXTOMUYBAJO:String = "Texto de muy bajo"
        const val TEXTONORMAL:String = "Texto de normal"
        const val TEXTOLIGEROSOBREPESO:String = "Texto de ligero sobrepeso"
        const val TEXTOOBESIDAD:String = "texto de obesidad"
    }


    private lateinit var textoIMCNormal :TextView
    private lateinit var textoIMCNumero :TextView
    private lateinit var textoIMCTextoCompleto : TextView
    private lateinit var btnRecalcular : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_imcactivity)
        val resultado_imc :Double = intent.extras?.getDouble(IMCAppActivity.IMC_KEY) ?: -1.0

        initComponents()
        initListeners()

        resultadoIMC(resultado_imc)
    }

    private fun initListeners() {
        btnRecalcular.setOnClickListener {
            intent = Intent(this,IMCAppActivity::class.java)
            startActivity(intent)
        }
    }

    private fun resultadoIMC(resultadoImc: Double) {

        when(resultadoImc) {

            in Double.MIN_VALUE..18.49 -> {
                textoIMCNormal.text = getString(R.string.muyBajo)
                textoIMCNumero.text = String.format("%.2f",resultadoImc)
                textoIMCTextoCompleto.text = getString(R.string.textoMuyBajo)
            }
            in 18.50..25.00 -> {
                textoIMCNormal.text = getString(R.string.normal)
                textoIMCNumero.text = String.format("%.2f",resultadoImc)
                textoIMCTextoCompleto.text = getString(R.string.textoNormal)
            }
            in 25.01..29.99 -> {
                textoIMCNormal.text = getString(R.string.ligeroSobrepeso)
                textoIMCNumero.text = String.format("%.2f",resultadoImc)
                textoIMCTextoCompleto.text = getString(R.string.textoLigeroSobrepeso)
            }
            in 30.0..Double.MAX_VALUE -> {
                textoIMCNormal.text = getString(R.string.sobrepeso)
                textoIMCNumero.text = String.format("%.2f",resultadoImc)
                textoIMCTextoCompleto.text = getString(R.string.textoSobrepeso)
            }
            else -> {
                //ERROR
            }
        }

    }

    private fun initComponents() {
        textoIMCNormal = findViewById(R.id.textoIMCNormal)
        textoIMCNumero = findViewById(R.id.textoIMCNumero)
        textoIMCTextoCompleto = findViewById(R.id.textoIMCTextoCompleto)
        btnRecalcular = findViewById(R.id.btnRecalcular)
    }

}