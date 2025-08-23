package com.example.carworth.uix.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.carworth.uix.view.fonk.VSpacers


@Preview(showBackground = true)


@Composable

fun Anasayfa(){
    Scaffold {paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(color = backgroundColor)
        , horizontalAlignment = Alignment.CenterHorizontally) {
            VSpacers(64)
            HorizontalDivider(
                modifier = Modifier
                    .width(300.dp),
                thickness = 1.dp,
                color = Color.Black.copy(alpha = 0.25f)
            )
            VSpacers(5)
            Text(
                text = "CarWorth",
                style = TextStyle(
                    fontSize = 48.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                )
            )
            VSpacers(5)
            HorizontalDivider(
                modifier = Modifier
                    .width(300.dp),
                thickness = 1.dp,
                color = Color.Black.copy(alpha = 0.25f)
            )
            VSpacers(58)
            Text(
                text = "Bu uygulama, girdiğiniz verilere göre aracınızın yaklaşık piyasa değerini tahmin eder.",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight(200),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier.width(350.dp)
            )
            VSpacers(65)
            Image(painter = painterResource(R.drawable.car),
                contentDescription = "",
                modifier = Modifier.size(200.dp))
            VSpacers(132)
            Button(onClick = {},
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MainColor,
                    contentColor = Color.White
                ),
                modifier = Modifier.width(250.dp).height(50.dp)
            ) {
                Text(
                    text = "Tahmine Başla",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                    )
                )

            }



        }
    }
}