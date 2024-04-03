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

package cn.rtast.qwsdk

import cn.rtast.qwsdk.api.*
import cn.rtast.qwsdk.enums.Plans
import com.google.gson.Gson
import java.util.logging.Logger


class QWeatherSDK {
    companion object {
        var key: String? = null
        var rootAPI: String? = null
        const val GEO_API = "https://geoapi.qweather.com/v2"
        val logger: Logger = Logger.getLogger("QWSDK-MAIN")
        val gson = Gson()
    }

    fun init(plan: Plans, apiKey: String) {
        rootAPI = plan.apiUrl
        key = apiKey
        logger.info("Current Plan: $plan, Current API Host: $rootAPI")
    }

    fun geo(): Geo {
        // GEOAPI 查询API: 城市搜索 + 热门城市查询 + POI搜索 + POI范围搜索
        /*GeoAPI提供全球地理位位置、全球城市搜索服务，支持经纬度坐标反查、多语言、模糊搜索等功能。

        天气数据是基于地理位置的数据，因此获取天气之前需要先知道具体的位置信息。和风天气提供一个功能强大的位置信息搜索API服务：GeoAPI。
        通过GeoAPI，你可获取到需要查询城市或POI的基本信息，
        包括查询地区的Location ID（你需要这个ID去查询天气），
        多语言名称、经纬度、时区、海拔、Rank值、归属上级行政区域、所在行政区域等。
        除此之外，GeoAPI还可以帮助你：
            避免重名城市的困扰
            支持名称模糊搜索
            在你的应用或网站中根据用户输入的名称返回多个城市结果，便于用户选择准确的城市并返回该城市天气
            在你的应用或网站中展示热门城市
            不需要维护城市列表，城市信息更新实时获取
        */
        return Geo
    }

    fun weather(): Weather {
        // 城市天气 + 格点天气 + 分钟级降水

        // 城市天气: 实时天气 + 每日天气预报 + 逐小时天气预报
        // 城市天气预报提供包括中国3000+市县区在内的全球20万+城市的天气预报，支持实时天气、最多30天预报及最多7天逐小时天气预报。

        // 格点天气: 格点实时天气 + 格点每日天气预报 + 格点逐小时天气预报
        // 以经纬度为基准的全球高精度、公里级、格点化天气预报产品，包括任意经纬度的实时天气和天气预报。

        // 分钟级降水
        // 分钟级降水API（临近预报）支持中国1公里精度的分钟级降雨预报数据，为每一分钟的降雨进行精准预测。
        return Weather
    }

    fun indices(): Indices {
        // 天气指数: 天气指数预报
        // 天气生活指数包括洗车指数、穿衣指数、感冒指数、过敏指数、紫外线指数、
        // 钓鱼指数等数据。天气指数支持中国3000+个市县区和海外15万个城市天气预报。
        return Indices
    }

    fun air(): Air {
        // 空气质量: 实时空气质量 + 空气质量每日预报
        // 中国3000+市县区及1700+监测站点的空气质量AQI数据，包括空气质量（AQI）实时数据，空气质量未来5天预报。
        return Air
    }

    fun timeMachine(): TimeMachine {
        // 时光机: 天气时光机 + 空气质量时光机 +
        // 时光机可以获取最近10天的历史天气和空气质量数据。
        return TimeMachine
    }

    fun tropical(): Tropical {
        // 热带气旋（台风）: 台风预报 + 台风列表 + 台风实况和路径
        // 热带气旋（台风）API提供全球主要海洋流域的台风信息，包括台风实时位置、等级、气压、风速，还可查询台风路径和台风预报信息。
        return Tropical
    }

    fun ocean(): Ocean {
        // 海洋数据: 潮汐 + 潮流
        // 海洋数据API提供全球主要港口和城市的潮汐和潮流数据。
        return Ocean
    }

    @Deprecated("This API is not impl! (No data to create data bean!)")
    fun solarRadiation() {
        // 太阳辐射
        // 太阳辐射API支持获取全球任意坐标的辐射数据，包括净太阳辐射，太阳散射辐射和太阳直接辐射。
        logger.warning("Not Available!")
        TODO("Not available!")
    }

    fun astronomy(): Astronomy {
        // 天文: 日出日落 + 月升月落和月相 + 太阳高度角
        // 天文API提供了全球任意地点未来60天的日出日落、太阳高度角、月升月落和月相数据。
        return Astronomy
    }

    fun warning(): Warning {
        // 预警: 天气灾害预警 + 天气预警城市列表
        // 和风天气灾害预警API提供了全球极端天气预警服务，覆盖中国及全球数十个国家或地区。
        // 预警数据包括数百种灾害预警类型，
        // 例如：台风、暴雨、暴雪、寒潮、大风、沙尘暴、高温、干旱、
        // 雷电、冰雹、霜冻、大雾、霾、道路结冰、寒冷、灰霾、雷雨大风、
        // 森林火险、降温、道路冰雪、干热风、低温、冰冻、空气重污染、
        // 海上大雾、雷暴大风、持续低温、浓浮尘、龙卷风、低温冻害、海上大风、
        // 低温雨雪冰冻、强对流、臭氧、大雪、强降雨、强降温、雪灾、森林（草原）火险、雷暴、严寒、沙尘等等
        return Warning
    }

}
