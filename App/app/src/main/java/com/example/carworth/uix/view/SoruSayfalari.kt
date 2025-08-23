package com.example.carworth.uix.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carworth.R
import com.example.carworth.ui.theme.MainColor
import com.example.carworth.ui.theme.backgroundColor
import com.example.carworth.uix.view.fonk.Dropdowns
import com.example.carworth.uix.view.fonk.VSpacers

@Preview(showBackground = true)


@Composable

fun SoruSayfalari(){
    val currentquest= remember{ mutableStateOf(0) }
    Scaffold {paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(color = backgroundColor),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Box(){
                Image(painter = painterResource(R.drawable.vector), contentDescription = "", modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.Crop)
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(modifier = Modifier
                        .padding(start = 34.dp, end = 34.dp, top = 156.dp, bottom = 156.dp)
                        .width(335.dp)
                        .height(535.dp)
                        .shadow(elevation = 35.dp)
                        .background(
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(size = 15.dp)
                        ),
                        contentAlignment = Alignment.Center){
                        Box(modifier = Modifier.fillMaxSize()) {
                            Image(painter = painterResource(R.drawable.baseline_arrow_back_24), contentDescription = "",
                                modifier = Modifier
                                    .padding(start = 15.dp, top = 15.dp)
                                    .size(32.dp)
                                    .clickable{
                                        if(currentquest.value>0){
                                            currentquest.value--
                                        }

                                    })
                            Column() {
                                when(currentquest.value){
                                    0-> {
                                        Dropdowns("Şehir Seçiniz","Şehir Seçiniz")
                                    }
                                    1-> {
                                        Dropdowns("Marka","Marka Seçiniz")
                                        Dropdowns("Seri","Seri Seçiniz")
                                        Dropdowns("Model","Model Seçiniz")
                                        Dropdowns("Yıl","Yıl Seçiniz")
                                    }
                                    2-> {
                                        Dropdowns("Kilometre Seçiniz","Kilometre Seçiniz")
                                    }
                                    3-> {
                                        Dropdowns("Vites Tipi","Vites Tipi Seçiniz")
                                        Dropdowns("Yakıt Tipi","Yakıt Tipi Seçiniz")
                                        Dropdowns("Kasa Tipi","Kasa Tipi Seçiniz")
                                    }
                                    4-> {
                                        Dropdowns("Motor Hacmi","Motor Hacmi Seçiniz")
                                        Dropdowns("Motor Gücü","Motor Gücü Seçiniz")
                                        Dropdowns("Çekiş","Çekiş Tipi Seçiniz")
                                    }
                                    5-> {
                                        Dropdowns("Ort. Yakıt Tüketimi","Ort. Yakıt Tüketimi")
                                        Dropdowns("Yakıt Deposu","Yakıt Deposu")
                                    }
                                    6-> {
                                        Dropdowns("Boya Değişen","Boya Değişen")
                                        Dropdowns("Tramer","Tramer")
                                    }
                                }

                            }

                        }
                        Button(
                            onClick = {
                                if(currentquest.value<6){
                                    currentquest.value++
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
                            Text("Devam Et", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))
                        }


                    }

                }


            }


            }
    }
}