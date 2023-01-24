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

import cn.rtast.qwsdk.QWeather
import cn.rtast.qwsdk.entity.Code
import cn.rtast.qwsdk.errors.*
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.ConnectException

object HTTPUtil {

    private val gson = Gson()
    private val cli = OkHttpClient()


    fun get(url: String, onlyOne: Boolean = false): String {
        if (QWeather.key == null) {
            throw KeyNullException("Invalid Key.")
        }
        try {
            var aUrl = url
            aUrl += if (onlyOne) {
                "?"
            } else {
                "&"
            }
            val request = Request.Builder().url("${aUrl}key=${QWeather.key}").get().build()
            val result = cli.newCall(request).execute().body.string()
            println("${aUrl}key=${QWeather.key}")
            println(result)
            when (gson.fromJson(result, Code::class.java).code) {
                400 -> {
                    throw RequestException("Request error, may contain wrong request parameters or missing required parameters.")
                }

                401 -> {
                    throw AuthException("Authentication failed, the wrong KEY may be used, Signature Authentication wrong, wrong KEY type (such as using SDK KEY to access Web API).")
                }

                402 -> {
                    throw ExceededException("The requests has been exceeded or the balance is insufficient to support continued access to the service. You can recharge, or wait for the calls to reset.")
                }

                403 -> {
                    throw ForbiddenException("No access permission, it may be because the PackageName or BundleID are inconsistent, or data that requires additional payment.")
                }

                429 -> {
                    throw RateLimitException("Exceeding the limited QPM, please refer to QPM (https://dev.qweather.com/en/docs/resource/glossary/#qpm).")
                }

                500 -> {
                    throw ServerException("No response or timeout, service down, please contact QWeather (https://www.qweather.com/contact).")
                }
            }
            return result
        } catch (_: ConnectException) {
            throw ConnectException("Failed to get $url")
        }
    }
}