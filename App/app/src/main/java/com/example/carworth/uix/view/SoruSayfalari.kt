package com.example.carworth.uix.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.navigation.NavController
import com.example.carworth.R
import com.example.carworth.ui.theme.MainColor
import com.example.carworth.ui.theme.backgroundColor
import com.example.carworth.uix.view.fonk.Araba
import com.example.carworth.uix.view.fonk.Dropdowns
import com.example.carworth.uix.view.fonk.Listeler
import com.example.carworth.uix.view.fonk.Textfields
import com.example.carworth.uix.view.fonk.VSpacers
import com.example.carworth.uix.view.fonk.getArabaFiyati

@Composable

fun SoruSayfalari(navController: NavController){
    val currentquest= remember{ mutableStateOf(0) }

    val secilenSehir=remember{mutableStateOf("")}
    val secilenMarka=remember{mutableStateOf("")}
    val secilenSeri=remember{mutableStateOf("")}
    val secilenModel=remember{mutableStateOf("")}
    val secilenYil=remember{mutableStateOf(0)}
    val girilenKM=remember{mutableStateOf(0)}
    val secilenVitesTipi=remember{mutableStateOf("")}
    val secilenYakitTipi=remember{mutableStateOf("")}
    val secilenKasaTipi=remember{mutableStateOf("")}
    val secilenrenk=remember{mutableStateOf("")}
    val girilenMotorHacmi=remember{mutableStateOf(0.0)}
    val girilenMotorGucu=remember{mutableStateOf(0.0)}
    val secilenCekis=remember{mutableStateOf("")}
    val girilenOrtYakit=remember{mutableStateOf(0.0)}
    val girilenYakitDepo=remember{mutableStateOf(0.0)}
    val girilenTramer=remember{mutableStateOf(0.0)}
    val secilenBoya=remember{mutableStateOf(0)}
    val secilenDegisen=remember{mutableStateOf(0)}
    val fiyat=remember{mutableStateOf("")}
    val loading = remember { mutableStateOf(true) }


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
                                    .clickable {
                                        if (currentquest.value > 0) {
                                            currentquest.value--
                                        }
                                    })
                            Column() {
                                when(currentquest.value){
                                    0-> {
                                        Dropdowns("Şehir Seçiniz","Şehir Seçiniz", Listeler().sehirList, onItemSelected = {secilen->secilenSehir.value=secilen})
                                    }
                                    1-> {
                                        Dropdowns("Marka","Marka Seçiniz", Listeler().arabaMarkalari, onItemSelected = {secilen->secilenMarka.value=secilen})
                                        Dropdowns("Seri","Seri Seçiniz",Listeler().arabaModel[secilenMarka.value]?:emptyList(), onItemSelected = {secilen->secilenModel.value=secilen})
                                        Dropdowns("Model","Model Seçiniz",Listeler().arabaSeri[secilenModel.value]?:emptyList(), onItemSelected = {secilen->secilenSeri.value=secilen})

                                    }
                                    2-> {
                                        Dropdowns("Yıl","Yıl Seçiniz",Listeler().yil, onItemSelected = {secilen->secilenYil.value=secilen.toInt()})
                                        Textfields("Kilometre Giriniz","Kilometre Giriniz",
                                            { deger -> girilenKM.value = deger.toInt() })
                                        Dropdowns("Renk","Renk Seçiniz",Listeler().renk, onItemSelected = {secilen->secilenrenk.value=secilen})
                                    }
                                    3-> {
                                        Dropdowns("Vites Tipi","Vites Tipi Seçiniz",Listeler().vites_tipi, onItemSelected = {secilen->secilenVitesTipi.value=secilen})
                                        Dropdowns("Yakıt Tipi","Yakıt Tipi Seçiniz",Listeler().yakit_tipi, onItemSelected = {secilen->secilenYakitTipi.value=secilen})
                                        Dropdowns("Kasa Tipi","Kasa Tipi Seçiniz",Listeler().kasa_tipi, onItemSelected = {secilen->secilenKasaTipi.value=secilen})

                                    }
                                    4-> {
                                        Textfields("Motor Hacmi","Motor Hacmi",{ deger -> girilenMotorHacmi.value = deger.toDouble() })
                                        Textfields("Motor Gücü","Motor Gücü",{ deger -> girilenMotorGucu.value = deger.toDouble() })
                                        Dropdowns("Çekiş","Çekiş Tipi Seçiniz",Listeler().cekis, onItemSelected = {secilen->secilenCekis.value=secilen})
                                    }
                                    5-> {
                                        Textfields("Ort. Yakıt Tüketimi","Ort. Yakıt Tüketimi",{ deger -> girilenOrtYakit.value = deger.toDouble() })
                                        Textfields("Yakıt Deposu","Yakıt Deposu",{ deger -> girilenYakitDepo.value = deger.toDouble() })
                                    }
                                    6-> {
                                        Dropdowns("Boya","Boya",Listeler().boyaDegisen, onItemSelected = {secilen->secilenBoya.value=secilen.toInt()})
                                        Dropdowns("Değişen","Değişen",Listeler().boyaDegisen, onItemSelected = {secilen->secilenDegisen.value=secilen.toInt()})
                                        Textfields("Tramer","Tramer",{ deger -> girilenTramer.value = deger.toDouble() })
                                    }
                                    7->{
                                        Column(
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 124.dp)) {
                                            Text(
                                                text = "Tahmini Fİyat",
                                                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                                            )
                                            VSpacers(12)
                                            val araba= Araba(
                                                secilenSehir.value,
                                                secilenMarka.value,
                                                secilenSeri.value,
                                                secilenModel.value,
                                                secilenYil.value,
                                                girilenKM.value,
                                                secilenrenk.value,
                                                secilenVitesTipi.value,
                                                secilenYakitTipi.value,
                                                secilenKasaTipi.value,
                                                girilenMotorHacmi.value,
                                                girilenMotorGucu.value,
                                                secilenCekis.value,
                                                girilenOrtYakit.value,
                                                girilenYakitDepo.value,
                                                secilenBoya.value,
                                                secilenDegisen.value,
                                                girilenTramer.value)


                                            LaunchedEffect(araba) {
                                                loading.value = true
                                                val price = getArabaFiyati(araba)
                                                fiyat.value = price?.let { "$it" } ?: "Hata oluştu!"
                                                loading.value = false
                                            }
                                            if (loading.value) {
                                                CircularProgressIndicator()
                                            } else {
                                                Text(fiyat.value ?: "Hata oluştu!", fontSize = 25.sp)
                                            }


                                        }
                                    }
                                }
                            }
                        }
                        Button(
                            onClick = {
                                if(currentquest.value<7){
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