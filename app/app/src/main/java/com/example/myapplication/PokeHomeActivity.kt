package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class PokeHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pokemonescapturados: ArrayList<Pokemon>
    private lateinit var currentUser:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //currentUser=intent.getStringExtra("com.example.myapplication").toString()
        //this.title = currentUser


        pokemonescapturados=ArrayList()
        Firebase.firestore.collection("pokemones")

    }
}