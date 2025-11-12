package com.example.app_carro

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var preco: EditText
    lateinit var btnCalcular: Button
    lateinit var kmPercorrido: EditText

    lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setupVews()
        setupListeners()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun setupVews(){
        preco = findViewById(R.id.et_preco_kwh)
        kmPercorrido = findViewById(R.id.et_km_percorrido)
        btnCalcular = findViewById(R.id.btn_calcular)
        resultado = findViewById(R.id.et_resultado)
    }
    fun setupListeners(){
        btnCalcular.setOnClickListener {
           calcular()

        }
    }
    fun calcular(){
        val precoDigitado = preco.text.toString().toFloat()
        val kmDigitado = kmPercorrido.text.toString().toFloat()
        var autonomia = precoDigitado / kmDigitado
        resultado.text = autonomia.toString()
    }

}