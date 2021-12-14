package com.bing.wecompose.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import com.bing.wecompose.R
import kotlin.math.exp

/**
 *  @author: liangbinghao
 *  @date:  2021/12/11 19:37
 *  @desc:
 */
@Composable
fun WeTopBar(title: String) {
    var expaned by remember {
        mutableStateOf(false)
    }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /*TODO*/ }) {}
            Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Box {
                IconButton(onClick = { expaned = true }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_add_circle_outline_24),
                        contentDescription = "add",
                    )
                }

                DropdownMenu(expanded = expaned, onDismissRequest = { expaned = false }) {
                    DropdownMenuItem(onClick = { }) {
                        Text("发起群聊")
                    }
                    DropdownMenuItem(onClick = { }) {
                        Text("添加朋友")
                    }
                    DropdownMenuItem(onClick = { }) {
                        Text("扫一扫")
                    }
                    DropdownMenuItem(onClick = { }) {
                        Text("收付款")
                    }
                    DropdownMenuItem(onClick = { }) {
                        Text("帮助与反馈")
                    }
                }
            }

        }

        Divider(color = Color(0xffeaeaea))
    }

}

@Preview(showBackground = true)
@Composable
fun WeTopBarPreview() {
    WeTopBar("微信")
}

@Composable
fun MyDropDownMenu(expaned: Boolean) {
    DropdownMenu(expanded = expaned, onDismissRequest = { }) {

    }
}
