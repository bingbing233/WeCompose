package com.bing.wecompose.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bing.wecompose.R

@Composable
fun ExploreItem() {
    Box() {
        Row(
            Modifier
                .fillMaxWidth()
                .clickable {

                }
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.lin2),
                contentDescription = "lin2",
                Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "上班的猫", fontWeight = FontWeight.Bold,fontSize = 14.sp)
        }
    }
}

@Composable
fun WeExploreList() {
    Box() {
        LazyColumn(Modifier.fillMaxSize()){
            items(6){ index->
                ExploreItem()
                if(index%2==0){
                    Divider(Modifier.height(5.dp),color = Color(0xffeaeaea))
                }
            }
        }
    }
}