package com.example.carworth.uix.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun SayfaGecisi(secilenSayfa: String){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = secilenSayfa){
        composable(route="anasayfa"){
            Anasayfa(navController)
        }

        composable(route="sorusayfasi") {
            SoruSayfalari(navController)
        }
    }


}