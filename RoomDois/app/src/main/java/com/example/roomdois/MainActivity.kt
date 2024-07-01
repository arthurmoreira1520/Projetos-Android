package com.example.roomdois

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.roomdois.model.UsuarioModel
import com.example.roomdois.repository.UsuarioDataBase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Instancia de Room
        val usuarioDatabase = UsuarioDataBase.getDataBase(this).usuarioDAO()//Aqui estamos instanciando a classe do Room, ao mesmo tempo que estamos retornando a classe de usuarioDao

        //Insert, observe como fazemos o insert, passando uma instância de UsuarioModel, com os atributos alterados:
        val retornoInsert = usuarioDatabase.insertUser(UsuarioModel().apply {
            //this.id_usuario = 1

            this.id_usuario = 1
            this.nome = "Davi Duarte"
            this.idade = 17

            this.id_usuario = 2
            this.nome = "Maria"
            this.idade = 21

            this.id_usuario = 3
            this.nome = "Breno"
            this.idade = 30

            this.id_usuario = 4
            this.nome = "Moreira"
            this.idade = 10

        })

        val updateUser = usuarioDatabase.updateUser(UsuarioModel().apply{

            this.id_usuario = 2
            this.nome = "Pedro"
            this.idade = 70

            this.id_usuario = 3
            this.nome = "Rodrigo"
            this.idade = 13

        })

        val deleteUser = usuarioDatabase.deleteUser(UsuarioModel().apply{
            this.id_usuario = 4
            this.nome = "Moreira"
            this.idade = 10


            this.id_usuario = 2
            this.nome = "Pedro"
            this.idade = 70
        })

        val retornoSelectMultiplo = usuarioDatabase.getAll()//Retorna todos os registros

        for(item in retornoSelectMultiplo){
            Log.d("Retorno Múltiplo", "id_usuario: ${item.id_usuario}, nome: ${item.nome}, idade: ${item.idade}")
        }

    }
}