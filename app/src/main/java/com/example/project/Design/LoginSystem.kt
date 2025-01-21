package com.example.project.Design

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project.R

class LoginSystem {
    @Composable
    fun LoginPage(onLogin: (String, String) -> Unit){
        var email  by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue(""))}
        Column (modifier = Modifier.fillMaxSize()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center)
        {

            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "App Logo",
                modifier = Modifier.size(100.dp).padding(bottom = 16.dp)
            )
            Text(
                text = "Welcome to VanToGo",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp),
                textAlign = TextAlign.Center
            )
            TextField(
                value = email,
                onValueChange = {email = it},
                label = {Text("Email")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email ),
                modifier = Modifier.padding(bottom = 16.dp)
            )
            TextField(
                value = password,
                onValueChange = {password = it},
                label = {Text("Password")},
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Button(
                onClick = { onLogin(email.toString(), password.toString())}, modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
                    .height(48.dp)
            ) {
                Text(text = "login", fontSize = 16.sp)
            }

        }

    }
}