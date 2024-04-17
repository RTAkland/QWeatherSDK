<div align="center">
<img src="https://static.rtast.cn/static/qwsdk/qwsdkIcon.png" alt="SDKIcon">

<h3>Made By <a href="https://github.com/RTAkland">RTAkland</a></h3>

<img src="https://static.rtast.cn/static/kotlin/made-with-kotlin.svg" alt="MadeWithKotlin">

<br>
<img alt="GitHub Workflow Status" src="https://img.shields.io/github/actions/workflow/status/RTAkland/QWeatherSDK/build.yml">
<img alt="Kotlin Version" src="https://img.shields.io/badge/Kotlin-1.9.23-pink?logo=kotlin">
<img alt="GitHub" src="https://img.shields.io/github/license/RTAkland/QWeatherSDK?logo=apache">
<a href="https://jitpack.io/#RTAkland/QWeatherSDK"><img alt="jitpackV" src="https://jitpack.io/v/RTAkland/QWeatherSDK.svg"></a>

</div>

# 概述

> 本项目是一个非官方的[`QWeather`](https://dev.qweather.com) `Kotlin / Java / Android SDK`, 可以在基于`JVM`的语言使用,
> 例如[`Kotlin`](https://kotl.in)、[`Java`](https://java.com)、[`Scala`](https://www.scala-lang.org/)

> 本项目基于`Web API` 所以只需要申请一个`Web API key`即可使用,
> 点击[这里](https://dev.qweather.com/docs/configuration/project-and-key/)
> 来查看如何申请一个`Web API key`

# 目录

<!-- TOC -->
* [概述](#概述)
* [目录](#目录)
* [使用](#使用)
  * [添加依赖](#添加依赖)
    * [本地文件](#本地文件)
    * [Jitpack](#jitpack)
    * [fatjar](#fatjar)
      * [Groovy DSL](#groovy-dsl)
      * [Kotlin DSL](#kotlin-dsl)
  * [简单的例子](#简单的例子)
    * [Kotlin](#kotlin)
    * [Java](#java)
    * [Scala](#scala)
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
    implementation("com.github.RTAkland:QWeatherSDK:v0.4.3")
}
```

### fatjar

> 如果想要将获取fatjar包你需要使用以下方法获取, 下面提供了两种脚本语言的解决方法

#### Groovy DSL

```groovy
configurations {
    embed
    compile.extendsFrom(embed)
}

// other configurations...

jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE  // 排除重复的依赖文件
    from configurations.embed.collect {
        it.isDirectory() ? it : zipTree(it)
    }
}

dependencies {
    implementation("com.github.RTAkland:QWeatherSDK:v0.4.3")  // 这里需要用常规方法添加依赖
    embed(api("com.github.RTAkland:QWeatherSDK:v0.4.3"))  // 必须在这里使用embed再添加一次
}
```

> 使用embed将会把embed内包裹的库中的.class文件全部打包进, 你的jar文件中
> 如果库使用了别的库, 那embed也会把该库使用的库的.class文件打包进你的jar中 和 shadowJar比较类似
> 和gradle中的include类似, 但是gradle是将依赖jar打包进jar
> embed 不会和implementation关键字冲突, embed仅在编译时生效
> 使用embed后就可以在独立的环境运行而不需要额外下载依赖

#### Kotlin DSL

> 以下是使用Kotlin作为Gradle构建脚本的解决方法

```kotlin

// other configurations...

dependencies {
    implementation("com.github.RTAkland:QWeatherSDK:v0.4.3")  // 直接使用常规方法添加依赖
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    val files = configurations.runtimeClasspath.get()
        .filter { it.exists() }
        .map { if (it.isDirectory) it else zipTree(it) }
    from(files)
}

```

## 简单的例子

### Kotlin

```kotlin
import cn.rtast.qwsdk.QWeatherSDK
import cn.rtast.qwsdk.enums.Plans

fun main() {
    val qw = QWeatherSDK()
    // 可用的计划有 Free, Standard, Custom
    qw.init(Plans.Free, "<replace your key here>")
    val response = qw.weather().now("101010100")  // 填入对应的数据, 这里只需要填写一个
    println(response)  // 返回的数据已经被反序列化, 可以直接访问对应的数据类来获取数据
}
```

### Java

```java
import cn.rtast.qwsdk.QWeatherSDK;
import cn.rtast.qwsdk.enums.Plans;

public class Main {
    public static void main(String[] args) {
        QWeatherSDK qw = new QWeatherSDK();
        qw.init(Plans.Free, "<replace your key here>");
        System.out.println(qw.weather().now("101010100"));
        // 最后两个参数有默认值, 通过给函数添加@JvmOverloads注解在编译时生成重载函数来实现Java参数默认值
    }
}
```

### Scala

```scala
import cn.rtast.qwsdk.QWeatherSDK
import cn.rtast.qwsdk.enums.Plans

object Main extends App {
  val qw = new QWeatherSDK()
  qw.init(Plans.Free, "<replace your key here>")
  println(qw.weather().now("101010100"))
  // 在Scala中，不需要显式声明main方法的参数，且App trait已经提供了args参数
}
```

# 数据类

> 请点击[这里](/docs/README.md)查看

# 单元测试

> 在`v0.2.0`版本添加了单元测试, 如果想要使用单元测试你需要添加两个环境变量 `QW_KEY` `QW_PLAN`,
> 这两个变量分别代表 [QWeather Key](https://dev.qweather.com/docs/configuration/project-and-key/) 和 key的版本,
> `QW_PLAN` 可用数据有 `free` `standard` `custom` ***不区分大小写, 但是变量名必须大写***
> 测试完成后你可以在`build/reports/tests/test/index.html` 找到测试报告

> 如果你的Key无法使用某些api那么这个测试则会直接跳过并判定为成功,
> 你可以在[这里](https://dev.qweather.com/docs/finance/subscription/#comparison)找到各种订阅之间的差别

# 注意事项

> 本SDK无法使用[`太阳辐射`](https://dev.qweather.com/docs/api/solar-radiation/solar-radiation-hourly-forecast/)
> 因为没有条件测试返回结果, 并且官方文档也没有写明返回的数据, 故无法创建数据类实现接口

> 目前编译出的产物的JVM版本为 1.8, 所以你至少需要JVM1.8以上版本来使用此SDK

# 开发

* 建议使用`Intellij IDEA` 进行开发

## 克隆项目

```shell
$ git clone https://github.com/RTAkland/QWeatherSDK.git
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
