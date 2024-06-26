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

package cn.rtast.qwsdk.entity.warning

import cn.rtast.qwsdk.entity.Refer

data class WarningEntity(
    val code: String,
    val fxLink: String,
    val refer: Refer,
    val updateTime: String,
    val warning: List<Warning>,
) {
    data class Warning(
        val endTime: String,
        val id: String,
        val level: String,
        val pubTime: String,
        val related: String,
        val sender: String,
        val startTime: String,
        val status: String,
        val text: String,
        val title: String,
        val type: String,
        val typeName: String,
    )
}
