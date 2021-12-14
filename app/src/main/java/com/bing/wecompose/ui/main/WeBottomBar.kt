package com.bing.wecompose.ui.main

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bing.wecompose.R

/**
 *  @author: liangbinghao
 *  @date:  2021/12/7 22:19
 *  @desc:  WeBottomBar
 */
@Composable
fun TabItem(@DrawableRes iconId: Int, title: String, tint: Color, modifier: Modifier) {
    Column(modifier.padding(vertical = 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = title,
            tint = tint
        )
        Text(text = title, fontSize = 11.sp, color = tint)
    }
}

@Composable
fun WeBottomBar(selected: Int, onSelectedChanged: (Int) -> Unit,modifier: Modifier = Modifier) {
    Box(modifier = modifier ){
        Row (Modifier.fillMaxWidth()){
            TabItem(
                iconId = if (selected == 0) R.drawable.ic_baseline_chat_bubble_24 else R.drawable.ic_baseline_chat_bubble_outline_24,
                title = "聊天",
                tint = if (selected == 0) Color.Green else Color.Black,
                Modifier
                    .weight(1f)
                    .clickable {
                        onSelectedChanged(0)
                    }
            )
            TabItem(
                iconId = if (selected == 1) R.drawable.ic_baseline_contacts_24 else R.drawable.ic_outline_contacts_24,
                title = "通信录",
                tint = if (selected == 1) Color.Green else Color.Black,
                Modifier
                    .weight(1f)
                    .clickable {
                        onSelectedChanged(1)
                    }
            )
            TabItem(
                iconId = if (selected == 2) R.drawable.ic_baseline_web_24 else R.drawable.ic_baseline_web_asset_24,
                title = "发现",
                tint = if (selected == 2) Color.Green else Color.Black,
                Modifier
                    .weight(1f)
                    .clickable {
                        onSelectedChanged(2)
                    }
            )
            TabItem(
                iconId = if (selected == 3) R.drawable.ic_baseline_person_24 else R.drawable.ic_baseline_person_outline_24,
                title = "我",
                tint = if (selected == 3) Color.Green else Color.Black,
                Modifier
                    .weight(1f)
                    .clickable {
                        onSelectedChanged(3)
                    }
            )
        }
    }

}

@Preview(showBackground = true)
@Composable()
fun WeBottomBarPrev() {
    var selected by remember {
        mutableStateOf(0)
    }
    WeBottomBar(selected = selected, onSelectedChanged = {selected = it})
}
