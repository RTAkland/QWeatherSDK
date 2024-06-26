<div align="center">
<img src="https://static.rtakland.icu/static/qwsdk/qwsdkIcon.png" alt="SDKIcon">

<h3>Made By <a href="https://github.com/RTAkland">RTAkland</a></h3>

<img src="https://static.rtakland.icu/static/kotlin/made-with-kotlin.svg" alt="MadeWithKotlin">

<br>
<img alt="GitHub Workflow Status" src="https://img.shields.io/github/actions/workflow/status/RTAkland/QWeatherSDK/build.yml">
<img alt="Kotlin Version" src="https://img.shields.io/badge/Kotlin-1.9.23-pink?logo=kotlin">
<img alt="GitHub" src="https://img.shields.io/github/license/RTAkland/QWeatherSDK?logo=apache">
<a href="https://jitpack.io/#RTAkland/QWeatherSDK"><img alt="jitpackV" src="https://jitpack.io/v/RTAkland/QWeatherSDK.svg"></a>

</div>

# 概述

> 这里是更详细的 [`QWeatherSDK`](https://github.com/RTAkland/QWeatherSDK) 文档

> 在SDK中`所有`的api均被以官方文档分割方式分开, 如果想要使用 `GeoAPI`
> 则需要在创建好的示例调用 `geo()` 方法, 此方法返回一个 `Geo` 类, 这个类中
> 包括了所有的 `GeoAPI`, 其他api也是一样
> 但是如果直接调用 `太阳辐射` API会抛出 `kotlin.NotImplementedError`异常
> 因为没有条件测试这个API

# 目录

<!-- TOC -->
* [概述](#概述)
* [目录](#目录)
* [注意事项](#注意事项)
* [数据类](#数据类)
  * [Geo](#geo)
    * [城市搜索](#城市搜索)
    * [热门城市查询](#热门城市查询)
    * [POI搜索](#poi搜索)
    * [POI范围搜索](#poi范围搜索)
  * [城市天气](#城市天气)
    * [实时天气](#实时天气)
    * [每日天气预报](#每日天气预报)
    * [逐小时天气预报](#逐小时天气预报)
  * [分钟预报](#分钟预报)
    * [分钟级降水](#分钟级降水)
  * [格点天气](#格点天气)
    * [格点实时天气](#格点实时天气)
    * [格点每日天气预报](#格点每日天气预报)
    * [格点逐小时天气预报](#格点逐小时天气预报)
  * [预警](#预警)
    * [天气灾害预警](#天气灾害预警)
    * [天气预警城市列表](#天气预警城市列表)
  * [天气指数](#天气指数)
    * [天气指数预报](#天气指数预报)
  * [空气质量](#空气质量)
    * [实时空气质量](#实时空气质量)
    * [空气质量每日预报](#空气质量每日预报)
  * [时光机](#时光机)
    * [天气时光机](#天气时光机)
    * [空气质量时光机](#空气质量时光机)
  * [热带气旋（台风）](#热带气旋台风)
    * [台风预报](#台风预报)
    * [台风实况和路径](#台风实况和路径)
    * [台风列表](#台风列表)
  * [海洋数据](#海洋数据)
    * [潮汐](#潮汐)
    * [潮流](#潮流)
  * [太阳辐射](#太阳辐射)
    * [太阳辐射逐小时预报](#太阳辐射逐小时预报)
  * [太阳和月亮](#太阳和月亮)
    * [日出日落](#日出日落)
    * [月升月落和月相](#月升月落和月相)
    * [太阳高度角](#太阳高度角)
* [子类](#子类)
* [开源](#开源)
* [鸣谢](#鸣谢)
<!-- TOC -->

# 注意事项

> 列出的参数后面如果加上了 `?` 则表明此参数有默认值, 可以不填

# 数据类

> 所有的数据类均存储在 `cn.rtast.qwsdk.entity` 包中

## Geo

### 城市搜索

* 接口: `geo().citySearch()`  参数: `location` `adm?` `range?` `number?` `lang?`  数据类: `GeoLookupEntity`

### 热门城市查询

* 接口: `geo().topCity()`  参数: `location?` `number?` `lang?`  数据类: `GeoTopEntity`

### POI搜索

* 接口: `geo().poiLookup()`  参数: `location` `type` `city?` `number?` `lang?`  数据类: `POIEntity`

### POI范围搜索

* 接口: `geo().poiRange()`  参数: `location` `type` `radius` `city?` `number?` `lang?`  数据类: `POIRangeEntity`

## 城市天气

### 实时天气

* 接口: `weather().now()`  参数: `location` `lang?` `unit?` 数据类: `WeatherBowEntity`

### 每日天气预报

* 接口: `weather().weather3d()`  参数: `location` `lang?` `unit?`  数据类: `WeatherDailyEntity`
* 接口: `weather().weather7d()`  参数: `location` `lang?` `unit?`  数据类: `WeatherDailyEntity`
* 接口: `weather().weather15d()`  参数: `location` `lang?` `unit?`  数据类: `WeatherDailyEntity`

### 逐小时天气预报

* 接口: `weather().weather24h()`  参数: `location` `lang?` `unit?`  数据类: `WeatherHourlyEntity`
* 接口: `weather().weather72h()`  参数: `location` `lang?` `unit?`  数据类: `WeatherHourlyEntity`
* 接口: `weather().weather168h()`  参数: `location` `lang?` `unit?`  数据类: `WeatherHourlyEntity`

## 分钟预报

### 分钟级降水

* 接口: `weather().weatherMinutely()`  参数: `location` `lang?`  数据类: `WeatherMinutelyEntity`

## 格点天气

### 格点实时天气

* 接口: `weather().weatherGridRealtime()`  参数: `location` `lang?` `unit?`  数据类: `WeatherGridRealtimeEntity`

### 格点每日天气预报

* 接口: `weatherGrid3d`  参数: `location` `lang?` `unit?`  数据类: `WeatherGridDailyEntity`
* 接口: `weatherGrid7d`  参数: `location` `lang?` `unit?`  数据类: `WeatherGridDailyEntity`

### 格点逐小时天气预报

* 接口: `weatherGrid24h`  参数: `location` `lang?` `unit?`  数据类: `WeatherGridHourlyEntity`
* 接口: `weatherGrid72h`  参数: `location` `lang?` `unit?`  数据类: `WeatherGridHourlyEntity`

## 预警

### 天气灾害预警

* 接口: `warning().now()`  参数: `location` `lang?`  数据类: `WarningEntity`

### 天气预警城市列表

* 接口: `warning().list()`  参数: `range?`  数据类: `WarningCityListEntity`

## 天气指数

### 天气指数预报

* 接口: `indices1d`  参数: `location` `type?` `lang?`  数据类: `IndicesEntity`
* 接口: `indices3d`  参数: `location` `type?` `lang?`  数据类: `IndicesEntity`

## 空气质量

### 实时空气质量

* 接口: `air().now()`  参数: `location` `lang?`  数据类: `AirEntity`

### 空气质量每日预报

* 接口: `air().daily()`  参数: `location` `lang?`  数据类: `AirDailyEntity`

## 时光机

### 天气时光机

* 接口: `timemachine().weatherHistory()`  参数: `location` `date` `lang?` `unit?`  数据类: `WeatherHistoricalEntity`

### 空气质量时光机

* 接口: `timeMachine().airHistory()`  参数: `location` `date` `lang?` `unit?`  数据类: `AirHistoricalEntity`

## 热带气旋（台风）

### 台风预报

* 接口: `tropical().forecast()`  参数: `stormID`  数据类: `TropicalForecastEntity`

### 台风实况和路径

* 接口: `tropical().track()`  参数: `stormID`  数据类: `TropicalTrackEntity`

### 台风列表

* 接口: `tropical().list()`  参数: `basin?` `year`  数据类: `TropicalListEntity`

## 海洋数据

### 潮汐

* 接口: `ocean().tide()`  参数: `location` `date`  数据类: `TideEntity`

### 潮流

* 接口: `ocean().currents()`  参数: `location` `date`  数据类: `CurrentsEntity`

## 太阳辐射

### 太阳辐射逐小时预报

> ***Not Available/不可用***

## 太阳和月亮

### 日出日落

* 接口: `astronomy().sun()`  参数: `location` `date` `lang?`  数据类: `SunEntity`

### 月升月落和月相

* 接口: `astronomy().moon()`  参数: `location` `date` `lang?`  数据类: `MoonEntity`

### 太阳高度角

* 接口: `astronomy().solarElevationAngle()`  参数: `location` `date` `time` `tz` `alt`
  数据类: `SolarElevationAngleEntity`

# 子类

> 你可以在 `QWeatherSDK` 类中使用所有的API, 对应的方法返回了对应的子类对象

# 开源

- 本项目以[Apache-2.0](./LICENSE)许可开源, 即:
    - 你可以直接使用该项目提供的功能, 无需任何授权
    - 你可以在**注明来源版权信息**的情况下对源代码进行任意分发和修改以及衍生

# 鸣谢

<div>
<a href="https://www.jetbrains.com/opensource/"><code>JetBrains Open Source</code></a> 提供的强大IDE支持
<img src="https://static.rtast.cn/static/other/jetbrains.png" alt="JetBrainsIcon" width="128">
</div>
