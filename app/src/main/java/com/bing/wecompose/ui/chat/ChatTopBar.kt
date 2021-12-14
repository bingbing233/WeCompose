package com.bing.wecompose.ui.chat

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bing.wecompose.R

/**
 *  @author: liangbinghao
 *  @date:  2021/12/13 23:36
 *  @desc:
 */
@Composable
fun ChatTopBar(title: String, onBackClick: (() -> Unit)? =null, onMoreClick: (() -> Unit)? =null) {
    Box {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(5.dp)
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { onBackClick?.invoke() }) {
                Icon(Icons.Default.ArrowBack, "back")
            }

            Text(
                text = title,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            IconButton(onClick = { onMoreClick?.invoke()}) {
                Icon(painter = painterResource(id = R.drawable.ic_baseline_more_horiz_24), "menu")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatTopBarPrev() {
    ChatTopBar(title = "上班的琳")
}