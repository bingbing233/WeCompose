package com.bing.wecompose.ui.chat

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bing.wecompose.WeViewModel
import com.bing.wecompose.ui.home.WeTopBar

/**
 *  @author: liangbinghao
 *  @date:  2021/12/14 0:07
 *  @desc:
 */
@Preview(showBackground = true)
@Composable
fun ChatPagePrev() {
    Scaffold(topBar = { ChatTopBar(title = "年轻的兔子") }, bottomBar = { ChatBottomBar() }) {
        ChatContent()
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ChatPage() {
    val viewModel: WeViewModel = viewModel()
    AnimatedVisibility(
        visible = viewModel.isChatting,
        enter = slideInHorizontally { it },
        exit = slideOutHorizontally{ it }
    ) {
        Box(Modifier.background(color = Color.White)) {
            Column {
                ChatTopBar(title = "年轻的兔子",onBackClick = {viewModel.isChatting = false})
                ChatContent(Modifier.weight(1f))
                ChatBottomBar()
            }
        }
    }
}