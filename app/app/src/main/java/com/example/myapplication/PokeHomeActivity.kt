package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PokeHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poke_home)

        this.title = "Pokedex"
    }
}