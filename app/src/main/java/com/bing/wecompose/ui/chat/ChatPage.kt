package com.bing.wecompose.ui.chat

import androidx.compose.animation.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bing.wecompose.WeViewModel

/**
 *  @author: liangbinghao
 *  @date:  2021/12/14 0:07
 *  @desc:
 */
@Preview(showBackground = true)
@Composable
fun ChatPagePrev() {
    Scaffold(topBar = { ChatTopBar(title = "上班的琳") }, bottomBar = { ChatBottomBar() }) {
        ChatContent()
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ChatPage() {
    val viewModel: WeViewModel = viewModel()
    AnimatedVisibility(
        visible = viewModel.isChatting,
        enter = slideInHorizontally {
                                    it
        },
        exit = slideOutHorizontally{
            it
        }
    ) {
        Scaffold(topBar = {
            ChatTopBar(
                title = "年轻的兔子",
                onBackClick = { viewModel.isChatting = false })
        }, bottomBar = { ChatBottomBar() }) {
            ChatContent()
        }
    }
}