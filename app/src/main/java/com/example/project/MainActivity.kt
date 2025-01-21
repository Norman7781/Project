package com.example.project

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.project.DataStore.UserDao
import com.example.project.Design.LoginSystem
import com.example.project.DataStore.AppDatabase
import com.example.project.DataStore.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var userDa: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val database = AppDatabase(this)
        userDa = database.userDao()

        prepopulateDatabase()

        setContent {
            val loginSystem = LoginSystem()
            loginSystem.LoginPage { email, password ->
                validateUser(this, email, password)
            }
        }
    }

    private fun prepopulateDatabase() {
        CoroutineScope(Dispatchers.IO).launch {
            val existingUser = userDa.getUser("apk@gmail.com", "1212weedpwal")
            if (existingUser == null) {
                val validUser = User(email = "apk@gmail.com", password = "1212weedpwal")
                userDa.insertUser(validUser)
                Log.d("MainActivity", "User prepopulated: $validUser")
            } else {
                Log.d("MainActivity", "User already exists")
            }
        }
    }

    private fun validateUser(context: Context, email: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val user = userDa.getUser(email, password)
            CoroutineScope(Dispatchers.Main).launch {
                if (user != null) {
                    Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                } else {
                    Toast.makeText(context, "Login failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}



