package com.bing.wecompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

/**
 *  @author: liangbinghao
 *  @date:  2021/12/7 22:25
 *  @desc:
 */
class WeViewModel:ViewModel() {

    //选中的item
    var selectedTab by mutableStateOf(0)
    //是否正在聊天
    var isChatting by mutableStateOf(false)
}