package com.example.carworth.uix.view.fonk

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable

fun Textfields(baslik:String,placeholderText: String,onTextChange: (String) -> Unit){
    val text= remember{ mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp)
    ) {
        Text(
            text = baslik,
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        )
        VSpacers(24)
        Box(
            modifier = Modifier
                .size(width = 175.dp, height = 45.dp)
                .shadow(10.dp, RoundedCornerShape(10.dp))
                .border(1.dp, Color.Black, RoundedCornerShape(10.dp))
                .background(Color.White, RoundedCornerShape(10.dp))
                .padding(horizontal = 12.dp, vertical = 15.dp),
                    contentAlignment = Alignment.CenterStart
        ) {
            if (text.value.isEmpty()) {
                Text(
                    text = placeholderText,
                    color = Color.LightGray,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth()
                )
            }
           BasicTextField(
                value = text.value,
                onValueChange = {
                    text.value=it
                    onTextChange(it) },
                modifier = Modifier.fillMaxSize(),
                textStyle = TextStyle(fontSize = 15.sp, color = Color.Black),
                singleLine = true,
               keyboardOptions = KeyboardOptions(
                   keyboardType = KeyboardType.Number
               )
            )
        }

    }
}