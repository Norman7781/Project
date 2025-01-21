package com.example.project.HomePage

import android.R.attr.top
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import kotlinx.coroutines.NonDisposableHandle.parent

class Home {
    @Composable
    fun HomeScreen(){
        ConstraintLayout {
            val (button, text1, ) = createRefs()
            Button(onClick = {}, modifier = Modifier.constrainAs(button)) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        }
    }
    @Composable
    fun Add(item:String){
        Column {
//            Text()
        }
    }
}