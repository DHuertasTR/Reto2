package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapplication.databinding.ActivityTempPokeBinding
import java.lang.Exception

class TempPokeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTempPokeBinding
    var currentUser ="nobody"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTempPokeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        currentUser=intent.getStringExtra("com.example.myapplication").toString()
        this.title = currentUser

        Toast.makeText(this,"al menos llega aca ", Toast.LENGTH_SHORT).show()
        binding.goid.setOnClickListener {
            Toast.makeText(this,"buscando", Toast.LENGTH_SHORT).show()
            val userinfo=binding.buscaPokeid.text.toString()
            searchPoke(userinfo)
        }
    }

    fun searchPoke(pokename:String){
        try {
            val response= HTTPSWebUtilDomi().GETRequest("https://pokeapi.co/api/v2/pokemon/${pokename}")
            binding.pokename1.text=response

        }catch (e:Exception){
            Log.e("<<<",e.stackTraceToString())
        }
    }


}