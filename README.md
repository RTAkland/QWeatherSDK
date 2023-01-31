<div align="center">
<img src="https://static.rtast.cn/static/qwsdk/qwsdkIcon.png" alt="SDKIcon">

<h3>Made By <a href="https://github.com/RTAkland">RTAkland</a></h3>

<img src="https://static.rtast.cn/static/kotlin/made-with-kotlin.svg" alt="MadeWithKotlin">

<br>
<img alt="GitHub Workflow Status" src="https://img.shields.io/github/actions/workflow/status/RTAkland/QWeatherSDK/build.yml">
<img alt="Kotlin Version" src="https://img.shields.io/badge/Kotlin-1.8.0-pink?logo=kotlin">
<img alt="GitHub" src="https://img.shields.io/github/license/RTAkland/QWeatherSDK?logo=apache">
<a href="https://jitpack.io/#RTAkland/QWeatherSDK"><img alt="jitpackV" src="https://jitpack.io/v/RTAkland/QWeatherSDK.svg"></a>

</div>

# 概述

> 此项目是一个非官方 [`Kotlin`](https://kotl.in)/[`Java`](https://java.com) 的
> [`和风天气`](https://dev.qweather.com) SDK, 使用Kotlin开发
> 和官方的[`SDK`](https://a.hecdn.net/download/api_sdk/QWeather_Public_Android_V4.11.jar)
> 区别在于此SDK只需要申请一个 `WEB API`即可使用

# 目录

<!-- TOC -->
* [概述](#概述)
* [目录](#目录)
* [使用](#使用)
  * [添加依赖](#添加依赖)
    * [本地文件](#本地文件)
    * [Jitpack](#jitpack)
  * [embed](#embed)
  * [简单的例子](#简单的例子)
    * [Kotlin](#kotlin)
    * [Java](#java)
* [数据类](#数据类)
* [单元测试](#单元测试)
* [注意事项](#注意事项)
* [开发](#开发)
  * [克隆项目](#克隆项目)
  * [手动编译](#手动编译)
* [开源](#开源)
* [鸣谢](#鸣谢)
<!-- TOC -->

# 使用

## 添加依赖

### 本地文件

> 以 `Groovy DSL` 为例

```groovy
// 添加gson 和 QWeatherSDK 依赖
dependencies {
    implementation("com.google.code.gson:gson:2.10.1")
    implementation(files("./lib/QWeatherSDK.jar"))
}
```

> 你也可以使用 [`jitpack`](https://jitpack.io) 来获取依赖

### Jitpack

```groovy

repositories {
    // other repos...
    maven { url "https://jitpack.io" }
}

dependencies {
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.github.RTAkland:QWeatherSDK:v0.2.0")
}
```

> 如果想要得到`fat jar`包, 你可以使用`embed`, 这里以`Groovy DSL`为例

## embed

> 添加embed配置

```groovy
configurations {
    embed
    compile.extendsFrom(embed)
}

// other configurations...

dependencies {
    embed(api("com.github.RTAkland:QWeatherSDK:v0.2.0"))
    // 使用embed将会把embed内包裹的依赖中的.class文件全部打包进, 你的jar文件中
    // 和gradle中的include类似, 但是gradle是将依赖jar打包进jar
    // embed 不会和implementation关键字冲突, embed仅在编译时生效
}
```

> 使用embed后就可以在独立的环境运行而不需要额外下载依赖

## 简单的例子

### Kotlin

```kotlin
import cn.rtast.qwsdk.QWeather
import cn.rtast.qwsdk.enums.Plans

fun main() {
    val qw = QWeather()  // 创建一的对象
    // 可用的计划有 Free, Standard, Custom
    qw.init(Plans.Free, "<replace your key here>")
    val response = qw.weather().now("101010100")  // 填入对应的数据, 这里只需要填写一个
    println(response)  // 返回的数据已经被反序列化, 可以直接访问对应的数据类来获取数据
}
```

### Java

> 不建议Java使用此SDK进行开发, 因为kotlin中的特性在Java中无法使用

```java
import cn.rtast.qwsdk.QWeather;
import cn.rtast.qwsdk.enums.Lang;
import cn.rtast.qwsdk.enums.Unit;
import cn.rtast.qwsdk.enums.Plans;

public class Main {
    public static void main(String[] args) {
        QWeather qw = new QWeather();
        qw.init(Plans.Free, "<replace your key here>");
        System.out.println(qw.weather().now("101010100", Lang.ZH, Unit.M));
        // 在Kotlin中有默认值可以不填, 在Java中必须填写
    }
}
```

# 数据类

> 请点击[这里](/docs/README.md)查看

# 单元测试

> 在`v0.2.0`版本添加了单元测试, 如果想要使用单元测试你需要添加两个环境变量 `QW_KEY` `QW_PLAN`,
> 这两个变量分别代表 [QWeather Key](https://dev.qweather.com/docs/configuration/project-and-key/) 和 key的版本,
> `QW_PLAN` 可用数据有 `free` `standard` `custom` ***不区分大小写, 但是变量名必须大写***
> 测试完成后你可以在`build/reports/tests/test/index.html` 找到测试报告

*** 如果你的Key无法使用某些api那么这个测试则会直接跳过并判定为成功,
你可以在[这里](https://dev.qweather.com/docs/finance/subscription/#comparison)找到各种订阅之间的差别**

# 注意事项

> 本SDK无法使用[`太阳辐射`](https://dev.qweather.com/docs/api/solar-radiation/solar-radiation-hourly-forecast/)
> 因为没有条件测试返回结果, 并且官方文档也没有写明返回的数据, 故无法创建数据类实现接口

> 目前编译出的产物的JVM版本为 1.8, 所以你至少需要1.8以上版本来使用此JDK

# 开发

* 建议使用`Intellij IDEA` 进行开发

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

# 开源

- 本项目以[Apache-2.0](./LICENSE)许可开源, 即:
    - 你可以直接使用该项目提供的功能, 无需任何授权
    - 你可以在**注明来源版权信息**的情况下对源代码进行任意分发和修改以及衍生

# 鸣谢

<div>

<img src="https://static.rtast.cn/static/other/jetbrains.png" alt="JetBrainsIcon" width="128">

<a href="https://www.jetbrains.com/opensource/"><code>JetBrains Open Source</code></a> 提供的强大IDE支持

</div>
