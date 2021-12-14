package com.bing.wecompose.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bing.wecompose.R
import com.bing.wecompose.bean.User

/**
 *  @author: liangbinghao
 *  @date:  2021/12/11 19:49
 *  @desc: 聊天列表
 */

@Composable
fun WeChatList(onItemClick: ((String) -> Unit)? =null) {
    val user = User()
    user.apply {
        name = "年轻的兔子"
        avatarId = R.drawable.lin1
        time = "20:04"
        chatContent = arrayListOf("早上好")
    }

    Box(Modifier.fillMaxSize()){
        LazyColumn() {
            items(6) { item ->
                ChatItem(user = user) { onItemClick?.invoke(user.name) }
                if (item != 2) {
                    Divider(
                        color = Color(0xffeaeaea),
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth()
                            .padding(horizontal = 70.dp),
                    )
                }
            }
        }
    }


}

@Composable
fun ChatItem(user: User, onClick: (() -> Unit)? =null) {
    Row(
        Modifier
            .fillMaxWidth()
            .clickable {
                 onClick?.invoke()
            }
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            Modifier
                .clip(RoundedCornerShape(5))
                .size(50.dp)
        ) {
            Image(painter = painterResource(id = user.avatarId), contentDescription = "avatar")
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            Modifier
                .height(50.dp)
                .weight(1f), verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = user.name, fontSize = 18.sp)
            Text(text = user.chatContent[user.chatContent.lastIndex],color=Color.Gray,fontSize = 14.sp)
        }
        Text(text = user.time, Modifier.weight(1f), textAlign = TextAlign.End, color = Color.Gray,fontSize = 12.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun ChatItemPre() {
    val user = User()
    user.apply {
        name = "年轻的兔子"
        avatarId = R.drawable.lin1
        time = "20:04"
        chatContent = arrayListOf("早上好")
    }
    ChatItem(user = user)
}
