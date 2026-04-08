package com.example.medicoapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
<<<<<<< HEAD
=======
import androidx.activity.enableEdgeToEdge
>>>>>>> 12e771da26e225d7f45d4c5609915a7ea28ee781
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
<<<<<<< HEAD
        setContentView(R.layout.activity_main)

        // 1. Configuração de bordas (Edge-to-Edge)
=======
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Configuração padrão de bordas do Android (Mantenha fora do clique)
>>>>>>> 12e771da26e225d7f45d4c5609915a7ea28ee781
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
<<<<<<< HEAD

        // 2. Referência do botão "Começar"
        val btnComecar = findViewById<Button>(R.id.btnComecar)

        // 3. Ação de clique para ir para a LoginActivity
        btnComecar.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Fecha a tela de entrada para não voltar nela ao clicar em 'back'
=======
        // --- O CÓDIGO DO BOTÃO DEVE FICAR AQUI, FORA DO LISTENER ACIMA ---
        val btnComecar = findViewById<Button>(R.id.btnComecar)

        btnComecar.setOnClickListener {
            // Agora o 'this' refere-se à MainActivity corretamente
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
>>>>>>> 12e771da26e225d7f45d4c5609915a7ea28ee781
        }
    }
}