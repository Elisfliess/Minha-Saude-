package com.example.medicoapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val tabLayout = findViewById<TabLayout>(R.id.tabUserType)

        // Lógica para saber qual aba foi clicada
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            // Essa variável vai guardar se o usuário clicou em "Paciente" ou "Medico"
            private var tipoUsuario = "Paciente"
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tipoUsuario = tab?.text.toString()

                // Mostra um aviso rápido na tela só para testar
                Toast.makeText(this@LoginActivity, "Entrando como: $tipoUsuario",
                    Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Não precisa de código aqui por enquanto
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Não precisa de código aqui por enquanto
            }



        })
    }
}