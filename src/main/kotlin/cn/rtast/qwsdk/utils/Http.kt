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

import cn.rtast.qwsdk.QWeatherSDK
import okhttp3.Call
import okhttp3.Callback
import okhttp3.FormBody
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException
import java.net.URLEncoder
import java.time.Instant


object Http {

    val jsonMediaType = "application/json; charset=utf-8".toMediaType()
    val jsonHeader = mapOf(
        "Content-Type" to "application/json; charset=utf-8",
        "Accept" to "application/json"
    )
    val okHttpClient = OkHttpClient()

    fun buildParams(url: String, params: Map<String, Any?>?): String {
        val urlString = StringBuilder("$url?")
        val newParamsMap = params?.toMutableMap()
            ?.filter { it.value != null }
            ?.toMutableMap()
            ?: mutableMapOf()
        newParamsMap["publicid"] = QWeatherSDK.publicIDKey
        newParamsMap["t"] = Instant.now().epochSecond
        val sortedParams = newParamsMap.toSortedMap().filterValues { it != null }
            .map { (k, v) -> k to (v?.toString()?.let { URLEncoder.encode(it, "UTF-8") }) }
            .joinToString("&") { (k, v) -> "$k=$v" }
        val sign = getSignature(sortedParams, QWeatherSDK.apiKey)
        urlString.append(sortedParams).append("&sign=$sign")
        return urlString.toString()
    }

    fun addHeaders(request: Request.Builder, headers: Map<String, String>?): Request.Builder {
        headers?.let {
            it.forEach { (key, value) ->
                request.addHeader(key, value)
            }
        }
        return request
    }

    inline fun <reified T> executeRequest(request: Request): T {
        val result = okHttpClient.newCall(request).execute().body.string()
        return result.fromJson<T>()
    }

    private fun executeRequest(request: Request): String {
        return okHttpClient.newCall(request).execute().body.string()
    }

    fun executeRequestAsync(
        requestBuilder: Request.Builder,
        headers: Map<String, String>?,
        callback: (String) -> Unit
    ) {
        this.addHeaders(requestBuilder, headers)
        okHttpClient.newCall(requestBuilder.build()).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val responseBody = response.body.string()
                callback(responseBody)
            }

            override fun onFailure(call: Call, e: IOException) {
                callback(e.toString())
            }
        })
    }

    @JvmOverloads
    fun get(
        url: String,
        params: Map<String, Any?>? = null,
        headers: Map<String, String>? = null
    ): String {
        val paramsUrl = buildParams(url, params)
        val request = Request.Builder()
            .url(paramsUrl)
            .get()
        val headerRequest = addHeaders(request, headers)
        return this.executeRequest(headerRequest.build())
    }

    @JvmOverloads
    inline fun <reified T> get(
        url: String,
        params: Map<String, Any?>? = null,
        headers: Map<String, String>? = null
    ): T {
        return get(url, params, headers).fromJson<T>()
    }

    @JvmOverloads
    inline fun <reified T> post(
        url: String,
        formBody: Map<String, String>? = null,
        headers: Map<String, String>? = null,
        params: Map<String, Any>? = null
    ): T {
        val body = FormBody.Builder()
        val paramsUrl = buildParams(url, params)
        formBody?.let {
            it.forEach { (key, value) ->
                body.add(key, value)
            }
        }
        val request = Request.Builder()
            .post(body.build())
            .url(paramsUrl)
        val headerRequest = addHeaders(request, headers)
        return this.executeRequest<T>(headerRequest.build())
    }

    @JvmOverloads
    inline fun <reified T> post(
        url: String,
        jsonBody: String,
        headers: Map<String, String>? = null,
        params: Map<String, Any>? = null
    ): T {
        val result = post(url, jsonBody, headers, params)
        return result.fromJson<T>()
    }

    @JvmOverloads
    fun post(
        url: String,
        jsonBody: String,
        headers: Map<String, String>? = null,
        params: Map<String, Any>? = null
    ): String {
        val body = jsonBody.toRequestBody(jsonMediaType)
        val paramsUrl = buildParams(url, params)
        val request = Request.Builder()
            .post(body)
            .url(paramsUrl)
        this.addHeaders(request, jsonHeader)
        val headerRequest = addHeaders(request, headers)
        return this.executeRequest(headerRequest.build())
    }

    inline fun <reified T> getAsync(
        url: String,
        params: Map<String, Any?>? = null,
        headers: Map<String, String>? = null,
        noinline callback: (T?) -> Unit
    ) {
        val paramsUrl = buildParams(url, params)
        val request = Request.Builder()
            .url(paramsUrl)
            .get()

        executeRequestAsync(request, headers) { response ->
            try {
                callback(response.fromJson<T>())
            } catch (e: Exception) {
                e.printStackTrace()
                callback(null)
            }
        }
    }

    inline fun <reified T> postAsync(
        url: String,
        jsonBody: String,
        headers: Map<String, String>? = null,
        params: Map<String, Any>? = null,
        noinline callback: (T?) -> Unit
    ) {
        val body = jsonBody.toRequestBody(jsonMediaType)
        val paramsUrl = buildParams(url, params)
        val request = Request.Builder()
            .post(body)
            .url(paramsUrl)
        this.addHeaders(request, jsonHeader)

        executeRequestAsync(request, headers) { response ->
            try {
                callback(response.fromJson<T>())
            } catch (e: Exception) {
                e.printStackTrace()
                callback(null)
            }
        }
    }
}