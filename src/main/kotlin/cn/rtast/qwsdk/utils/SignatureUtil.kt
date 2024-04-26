/*
 * Copyright 2024 RTAkland
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */


package cn.rtast.qwsdk.utils

import java.security.MessageDigest


fun getSignature(params: String, key: String): String {
    val md5Instance = MessageDigest.getInstance("MD5")
    val resultByteArray = md5Instance.digest(params.plus(key).toByteArray(Charsets.UTF_8))
    return bytesToHex(resultByteArray)
}

fun bytesToHex(bytes: ByteArray): String {
    val hexChars = "0123456789abcdef"
    val hex = StringBuilder(2 * bytes.size)
    for (byte in bytes) {
        val index = byte.toInt() and 0xFF
        hex.append(hexChars[index shr 4])
        hex.append(hexChars[index and 0x0F])
    }
    return hex.toString()
}
