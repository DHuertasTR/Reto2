package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val usersReals= arrayListOf<String>()
    var userLooged ="nobody"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //poblateUserPool(usersReals)
        binding.loginButton.setOnClickListener{
            realTrainerNofake()
        }
        this.title = "Pokedex"

    }
    fun poblateUserPool(array: ArrayList<String>){
        val user1="brock"
        val user2="red team"
        array.add("ash ketchup")
        array.add(user1)
        array.add(user2)

        postUser(user1)
        postUser(user2)

    }


    fun  postUser(username:String){
        val list = arrayListOf<String>()
        val user= User(UUID.randomUUID().toString(),username,list)
        Firebase.firestore.collection("users").document(user.userId).set(user)
    }


    fun realTrainerNofake(){
        val userinfo=binding.trainerName.text.toString()

        val query = Firebase.firestore.collection("users").whereEqualTo("username",userinfo)
        query.get().addOnCompleteListener{ task ->
            if(task.result?.size()!=0){
                userLooged=userinfo
                val intent=Intent(this,PokeHomeActivity::class.java).apply {
                    putExtra("com.example.myapplication",userinfo)
                }
                startActivity(intent)

            }else{
                Toast.makeText(this,"No Tiene Permiso de ingreso :(",Toast.LENGTH_SHORT).show()
            }
        }


    }

}