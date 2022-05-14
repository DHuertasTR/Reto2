package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val usersReals= arrayListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        poblateUserPool(usersReals)
        binding.loginButton.setOnClickListener{
            realTrainerNofake()
        }
        this.title = "Pokedex"

    }
    fun poblateUserPool(array: ArrayList<String>){
        array.add("ash ketchup")
        array.add("red team")
        array.add("brock")
    }

    fun  postUser(username:String){
        val user= User(UUID.randomUUID().toString())
    }


    fun realTrainerNofake(){
        val userinfo=binding.trainerName.text.toString()
        if(userinfo in usersReals){

            val intent=Intent(this,PokeHomeActivity::class.java).apply {
                putExtra("com.example.myapplication",userinfo)
            }
            startActivity(intent)
        }else{
            Toast.makeText(this,"No Tiene Permiso de ingreso :(",Toast.LENGTH_SHORT).show()
        }
    }

}