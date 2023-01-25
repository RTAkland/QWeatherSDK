<div align="center">
<img src="https://static.rtast.cn/static/qwsdk/qwsdkIcon.png" alt="SDKIcon">

<h3>Made By <a href="https://github.com/RTAkland">RTAkland</a></h3>

<img src="https://static.rtast.cn/static/kotlin/made-with-kotlin.svg" alt="MadeWithKotlin">

<br>
<img alt="GitHub Workflow Status" src="https://img.shields.io/github/actions/workflow/status/RTAkland/QWeatherSDK/build.yml">
<img alt="Kotlin Version" src="https://img.shields.io/badge/Kotlin-1.8.0-pink?logo=kotlin">
<img alt="GitHub" src="https://img.shields.io/github/license/RTAkland/QWeatherSDK?logo=apache">
<a href="https://jitpack.io/#RTAkland/QWeatherSDK"><img alt="jitpackV" src="https://jitpack.io/v/RTAkland/QWeatherSDK.svg"><a>

</div>

# 概述

> 此项目是一个非官方 [`Kotlin`](https://kotl.in)/[`Java`](https://java.com) 的 [`和风天气`](https://dev.qweather.com)
> SDK, 使用Kotlin开发
> 和官方的[`SDK`](https://a.hecdn.net/download/api_sdk/QWeather_Public_Android_V4.11.jar)
> 区别在于此SDK只需要申请一个 `WEB API`即可使用

# 使用

## 添加依赖

> 以 `Groovy DSL` 为例

```groovy
// 添加gson 和 QWeatherSDK 依赖
dependencies {
    implementation("com.google.code.gson:gson:2.10.1")
    files("./lib/QWeatherSDK.jar")
}
```

> 你也可以使用 [`jitpack`](https://jitpack.io) 来获取依赖, 这里不做演示

## 简单的例子

```kotlin
import cn.rtast.qwsdk.QWeather
import cn.rtast.qwsdk.enums.Plans

fun main() {
    val qw = QWeather  // 这里是静态类
    // 可用的计划有 FREE, STANDARD, CUSTOM
    qw.switchPlan(Plans.FREE, "<replace your key here>")
    val response = qw.weather().now("101010100")  // 填入对应的数据, 这里只需要填写一个
    println(response)  // 返回的数据已经被反序列化, 可以直接访问对应的数据类来获取数据
}
```

# 数据类

> 请点击[这里](/docs/README.md)查看

# 原理

> 使用HTTP请求获取数据后将其反序列化返回, 减少了反序列化的工作量

# 注意事项
> 本SDK无法使用[`太阳辐射`](https://dev.qweather.com/docs/api/solar-radiation/solar-radiation-hourly-forecast/)
> 因为没有条件测试返回结果, 并且官方文档也没有写明返回的数据, 故无法创建数据类实现接口

# 开发

* 建议使用`Intellij IDEA` 可进行开发

## 克隆项目

```shell
$ git clone https://github.com/RTAkland/RMusic.git
```

## 手动编译

> Linux/Unix/Mac OS

```shell
$ chmod +x ./gradlew
$ ./gradlew build
```

> Windows

```shell
$ .\gradlew.bat build
```

> 输出的构建文件在 [build/libs/*.jar](build/libs), 请运行文件名内没有`source`字样的jar文件

# 开源

- 本项目以[Apache-2.0](./LICENSE)许可开源, 即:
    - 你可以直接使用该项目提供的功能, 无需任何授权
    - 你可以在**注明来源版权信息**的情况下对源代码进行任意分发和修改以及衍生

# 鸣谢

* [JetBrains Open Source](https://www.jetbrains.com/opensource/) 项目提供的IDE支持.
