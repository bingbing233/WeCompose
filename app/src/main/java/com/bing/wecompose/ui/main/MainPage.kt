package com.bing.wecompose.ui.main

import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bing.wecompose.WeViewModel

/**
 *  @author: liangbinghao
 *  @date:  2021/12/14 0:09
 *  @desc:
 */

@Composable
fun MainPage() {
    val viewModel:WeViewModel  = viewModel()
    var selected by remember {
        mutableStateOf(0)
    }
    Scaffold(
        topBar = { WeTopBar() },
        bottomBar = { WeBottomBar(selected = selected, onSelectedChanged = { selected = it }) }){
        WeChatList{
            viewModel.isChatting = true
        }
    }
}
@Preview(showBackground = true)
@Composable
fun MainPagePrev() {
    var selected by remember {
        mutableStateOf(0)
    }
    Scaffold(
        topBar = { WeTopBar() },
        bottomBar = { WeBottomBar(selected = selected, onSelectedChanged = { selected = it }) }){
        WeChatList()
    }
}