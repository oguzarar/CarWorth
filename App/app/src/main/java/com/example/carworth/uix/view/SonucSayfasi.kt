package com.example.carworth.uix.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.carworth.R
import com.example.carworth.ui.theme.MainColor
import com.example.carworth.ui.theme.backgroundColor
import com.example.carworth.uix.view.fonk.Araba
import com.example.carworth.uix.view.fonk.VSpacers
import com.example.halisaham.uix.utils.Resource
import java.text.NumberFormat
import java.util.Locale


@Composable
fun SonucSayfasi(navController: NavController,araba: Araba,viewmodel: Viewmodel = hiltViewModel()) {
    val fiyat = remember { mutableStateOf("") }
    val price = viewmodel.price.value
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(color = backgroundColor),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LaunchedEffect(key1 = araba) {
                viewmodel.getPrice(araba)
            }
            Box {
                Image(
                    painter = painterResource(R.drawable.vector),
                    contentDescription = "",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier = Modifier
                            .padding(start = 34.dp, end = 34.dp, top = 156.dp, bottom = 156.dp)
                            .width(335.dp)
                            .height(535.dp)
                            .shadow(elevation = 35.dp)
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(size = 15.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 124.dp)
                            ) {
                                Text(
                                    text = "Aracınızın Ortalama Değeri",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                )
                                VSpacers(36)
                                Text(text = "${araba.marka} ${araba.model} ${araba.seri}",
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black))
                                VSpacers(18)
                                when(price){
                                    is Resource.Loading -> {
                                        CircularProgressIndicator(color = Color(0xFF1F8CF9))
                                    }
                                    is Resource.Succes -> {
                                        val sonuc = NumberFormat.getNumberInstance(Locale("tr", "TR"))
                                            .format((fiyat.value.toDouble()).toInt())
                                        Text("$sonuc TL", fontSize = 25.sp)
                                    }
                                    is Resource.Error -> {
                                        Text(
                                            text = price.message,
                                            color = Color.Red
                                        )
                                    }
                                }

                            }
                            Button(
                                onClick = {
                                    navController.navigate("anasayfa"){
                                        popUpTo("sonucsayfasi"){inclusive=true}
                                    }

                                },
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = MainColor, contentColor = Color.White),
                                modifier = Modifier
                                    .fillMaxWidth(0.7f)
                                    .height(50.dp)
                                    .align(Alignment.BottomCenter)
                                    .padding(bottom = 10.dp)
                            ) {
                                Text("Anasayfa", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))
                            }

                        }
                    }
                }


            }
        }
    }
}