package me.dio.imcapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.w("lifecycle", "onCreate")
        setListeners()
    }

    override fun onStart() {
        super.onStart()
        Log.w("lifecycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.w("lifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.w("lifecycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.w("lifecycle", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.w("lifecycle", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("lifecycle", "onDestroy")
    }

    private fun setListeners() {
        etAltura.doAfterTextChanged { text ->
            Toast.makeText(this, text.toString(), Toast.LENGTH_LONG).show()
        }

        btCalcular.setOnClickListener {
            calcularIMC(etPeso.text.toString(), etAltura.text.toString())
        }
    }

    private fun calcularIMC(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if (peso != null && altura != null) {
            val imc = peso / (altura * altura)
            tvTitle.text = "Seu IMC é \n%.2f".format(imc)
        }
    }
}