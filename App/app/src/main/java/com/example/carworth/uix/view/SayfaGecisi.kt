package com.example.carworth.uix.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.carworth.uix.view.fonk.Araba
import com.google.gson.Gson

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

        composable(route = "sonucsayfasi/{araba}",
            arguments = listOf(
                navArgument("araba"){type= NavType.StringType})
            )
            {
            val jsonAraba=it.arguments?.getString("araba")!!
            val araba= Gson().fromJson(jsonAraba, Araba::class.java)
            SonucSayfasi(navController,araba)
        }

    }


}