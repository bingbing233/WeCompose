package com.bing.wecompose.ui.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bing.wecompose.WeViewModel
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

/**
 *  @author: liangbinghao
 *  @date:  2021/12/14 0:09
 *  @desc:
 */

@OptIn(ExperimentalAnimationApi::class, com.google.accompanist.pager.ExperimentalPagerApi::class)
@Composable
fun HomePage() {
    val viewModel: WeViewModel = viewModel()
    var pageState = rememberPagerState(0)
    Box() {
        Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
            HorizontalPager(count = 4, Modifier.weight(1f), pageState) { index ->
                when (index) {
                    0 -> ChatList()
                    1 -> ContactList()
                    2 -> ExploreList()
                    3 -> MineList ()
                }
            }
            val scope = rememberCoroutineScope()
            WeBottomBar(selected = pageState.currentPage, onSelectedChanged = {
                scope.launch {
                    pageState.animateScrollToPage(it,0f)
                }
            })
        }
    }

}

@Composable
fun ChatList() {
    val viewModel:WeViewModel = viewModel()
    Box {
        Column {
            WeTopBar("微信")
            WeChatList{
                viewModel.isChatting = true
            }
        }
    }
}

@Composable
fun ContactList() {
    Box() {
        Column {
            WeTopBar("联系人")
            WeContactList()
        }
    }
}

@Composable
fun ExploreList() {
    Box() {
        Column {
            WeTopBar("发现")
            WeExploreList()
        }
    }
}

@Composable
fun MineList() {
    Box(Modifier.fillMaxSize()) {
        Text(text = "我的页面")
    }
}