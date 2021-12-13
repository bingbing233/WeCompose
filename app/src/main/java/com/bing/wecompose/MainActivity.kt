package com.bing.wecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bing.wecompose.ui.chat.ChatPage
import com.bing.wecompose.ui.main.MainPage
import com.bing.wecompose.ui.main.WeBottomBar
import com.bing.wecompose.ui.main.WeChatList
import com.bing.wecompose.ui.main.WeTopBar
import com.bing.wecompose.ui.theme.WeComposeTheme

class MainActivity : ComponentActivity() {
    private val viewModel: WeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            WeComposeTheme {
                Box {
                   MainPage()
                    if(viewModel.isChatting){
                        ChatPage()
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        if(viewModel.isChatting){
            viewModel.isChatting = false
        }else{
            super.onBackPressed()
        }
    }
}


