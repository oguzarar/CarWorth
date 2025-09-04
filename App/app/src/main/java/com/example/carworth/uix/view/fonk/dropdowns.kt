package com.example.carworth.uix.view.fonk

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carworth.R
import kotlin.collections.forEachIndexed


@Composable

fun <T> Dropdowns(baslik: String,placeholder: String,list: List<T>,
                  onItemSelected: (String) -> Unit){
    val kontrol=remember { mutableStateOf(false) }
    val aciliskontrol=remember { mutableStateOf(false) }
    var placetext=remember{mutableStateOf(placeholder)}
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
                .shadow(25.dp, shape = RoundedCornerShape(10.dp))
                .background(Color.White, shape = RoundedCornerShape(10.dp))
                .border(1.dp, Color.Black, shape = RoundedCornerShape(10.dp))
                .clickable { aciliskontrol.value = true },
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = placetext.value,
                    color = if(kontrol.value) Color.Black else Color.Gray)
                Image(
                    painter = painterResource(R.drawable.dropdownitem),
                    contentDescription = "",
                    modifier = Modifier.size(18.dp)
                )
            }
            DropdownMenu(expanded=aciliskontrol.value,onDismissRequest = {aciliskontrol.value=false},
                modifier = Modifier
                    .size(175.dp,200.dp)
                    .background(Color.White, shape = RoundedCornerShape(10.dp))
                    .border(1.dp, Color.Black, shape = RoundedCornerShape(10.dp))){
                list.forEachIndexed {
                    index,string ->
                    DropdownMenuItem(text = {Text(text = string.toString())},
                        onClick = {
                            placetext.value=string.toString()
                            aciliskontrol.value=false
                            onItemSelected(string.toString())
                            kontrol.value=true
                        })
                }
            }
        }
    }


}