/*
 * Copyright 2023 RTAkland
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

import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.InputStreamReader
import java.net.URL
import java.nio.charset.StandardCharsets
import java.util.zip.GZIPInputStream


private fun unGZip(byteArray: ByteArray): String {
    val byteArrayInputStream = ByteArrayInputStream(byteArray)
    val gZIPInputStream = GZIPInputStream(byteArrayInputStream)
    val bufferedReader = BufferedReader(InputStreamReader(gZIPInputStream, StandardCharsets.UTF_8))
    val stringBuilder = StringBuilder()
    while (true) {
        val readLine = bufferedReader.readLine()
        if (readLine != null) {
            stringBuilder.append(readLine)
        } else {
            bufferedReader.close()
            gZIPInputStream.close()
            byteArrayInputStream.close()
            return stringBuilder.toString()
        }
    }
}

fun get(url: String): String {
    return unGZip(URL(url).readBytes())
}
