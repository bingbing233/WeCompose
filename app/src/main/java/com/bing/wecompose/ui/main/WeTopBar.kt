package com.bing.wecompose.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 *  @author: liangbinghao
 *  @date:  2021/12/11 19:37
 *  @desc:
 */
@Composable
fun WeTopBar() {
    Column {
        Row(modifier = Modifier.fillMaxWidth().padding(15.dp), horizontalArrangement = Arrangement.Center) {
            Text(text = "微信",fontSize = 18.sp,fontWeight = FontWeight.Bold)

        }
        Divider(color = Color(0xffeaeaea))
    }

}

@Preview(showBackground = true)
@Composable
fun WeTopBarPreview() {
    WeTopBar()
}