/*
 * Copyright © 2025 RTAkland
 * Author: RTAkland
 * Date: 2025/2/21
 */


package cn.rtast.qwsdk.entity.internal

interface Callback {
    fun <T> onSuccess(content: T)
    fun onFailure(ex: Exception)
}