package com.bing.wecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bing.wecompose.ui.main.WeBottomBar
import com.bing.wecompose.ui.WeChatList
import com.bing.wecompose.ui.WeTopBar
import com.bing.wecompose.ui.theme.WeComposeTheme

class MainActivity : ComponentActivity() {
    private val viewModel: WeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            WeComposeTheme {
                Column(Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween) {
                    WeTopBar()
                    Box(modifier = Modifier.weight(1f)) {
                        WeChatList()
                    }
                    WeBottomBar(selected = viewModel.selectedTab, onSelectedChanged = {
                        viewModel.selectedTab = it
                    })
                }
            }
        }
    }

    override fun onBackPressed() {
        viewModel.isChatting = false
        super.onBackPressed()
    }
}

@Preview(showBackground = true)
@Composable
fun MainPage() {
    var selected by remember {
        mutableStateOf(0)
    }
    Scaffold(
        topBar = { WeTopBar() },
        bottomBar = { WeBottomBar(selected = selected, onSelectedChanged = { selected = it }) }){
        WeChatList()
    }
}

@Composable
fun ChatPage() {

}

