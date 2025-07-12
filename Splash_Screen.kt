package com.example.heloha.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.heloha.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController)
{

    LaunchedEffect(Unit) {

        delay(2000)

        val currentUser = FirebaseAuth.getInstance().currentUser

        val destination = if (currentUser != null) {
            "home"
        } else {
            "login"
        }
        navController.navigate(destination)
        {

            popUpTo("splash") { inclusive = true }
        }
    }
    Column (modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Image(painter = painterResource(R.drawable.splash),
            contentDescription = "Splash Screen Logo",
            modifier = Modifier.size(350.dp,420.dp)
        )
    }
}