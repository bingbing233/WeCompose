package com.bing.wecompose.ui.chat

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bing.wecompose.R

/**
 *  @author: liangbinghao
 *  @date:  2021/12/13 23:45
 *  @desc:
 */
@Composable
fun ChatBottomBar() {
    var text by remember {
        mutableStateOf("")
    }

    Box {
        Row (Modifier.fillMaxWidth().padding(horizontal = 8.dp,vertical = 6.dp),horizontalArrangement = Arrangement.SpaceBetween,verticalAlignment = Alignment.CenterVertically){
            Icon(painter = painterResource(id = R.drawable.ic_baseline_keyboard_voice_24), "voice")
            OutlinedTextField(value = text, onValueChange = { text = it })
            Icon(
                painter = painterResource(id = R.drawable.ic_outline_emoji_emotions_24),
                contentDescription = "emotion"
            )
            Icon(painter = painterResource(id = R.drawable.ic_baseline_add_circle_outline_24), contentDescription = "add")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatBottomBarPrev() {
    ChatBottomBar()
}