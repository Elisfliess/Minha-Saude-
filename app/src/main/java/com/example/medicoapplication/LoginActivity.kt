package com.example.medicoapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout

class LoginActivity : AppCompatActivity() {

    private var tipoUsuario = "Paciente"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Referências do XML
        val tabLayout = findViewById<TabLayout>(R.id.tabUserType)
        val inputUsuario = findViewById<EditText>(R.id.etUser)
        val inputSenha = findViewById<EditText>(R.id.etPassword)
        val botaoLogin = findViewById<Button>(R.id.btnLogin)
        val btnIrParaCadastro = findViewById<TextView>(R.id.tvIrParaCadastro)

        // Alternar entre Paciente e Médico
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tipoUsuario = tab?.text.toString()
                inputUsuario.hint =
                    if (tipoUsuario == "Medico") "CRM ou E-mail" else "Usuário ou CPF"
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        // Lógica de Login
        botaoLogin.setOnClickListener {
            val user = inputUsuario.text.toString()
            val pass = inputSenha.text.toString()

            if (user.isNotEmpty() && pass.isNotEmpty()) {
                val destino =
                    if (tipoUsuario == "Medico") HomeMedicoActivity::class.java else HomePacienteActivity::class.java
                startActivity(Intent(this, destino))
                finish()
            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }

        // Lógica para abrir Tela de Cadastro
        btnIrParaCadastro.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


        // Dentro do onCreate da LoginActivity
        val tvEsqueciSenha =
            findViewById<TextView>(R.id.tvEsqueciSenha) // Verifique o ID no seu XML de Login
        tvEsqueciSenha.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
    }
}
