package com.bing.wecompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.core.view.WindowCompat
import com.bing.wecompose.ui.chat.ChatPage
import com.bing.wecompose.ui.main.MainPage
import com.bing.wecompose.ui.theme.WeComposeTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.systemuicontroller.rememberSystemUiController


class MainActivity : ComponentActivity() {
    private val viewModel: WeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        setContent {
            MaterialTheme {
                ProvideWindowInsets {
                    val systemUiController = rememberSystemUiController()
                    Box(modifier = Modifier.statusBarsPadding()) {
                        SideEffect {
                            systemUiController.setStatusBarColor(color= White,true)
                        }
                        MainPage()
                        ChatPage()
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        if (viewModel.isChatting) {
            viewModel.isChatting = false
        } else {
            super.onBackPressed()
        }
    }

}


