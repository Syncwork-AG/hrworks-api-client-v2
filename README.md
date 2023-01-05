# HRWorks-Api-Client 

This client provides access to the HRworks API V2 and is written in Kotlin but can be used in all JVM Languages. Currently, it is published on jitpack.io and can be used by simply adding the dependency to your project.

Use it at own Risk. We won't provide any support.

If you want to change or add any feature, feel free to create an issue or make pull requests.

## Used Technologies

[gradle](https://github.com/gradle/gradle)  
[kotlin](https://github.com/JetBrains/kotlin)  
[ktor-Client](https://ktor.io/docs/create-client.html) (with some plugins)

## Gradle

Add the jitpack.io repo to the project repos

``` groovy
repositories {
    ...
    maven { url 'https://jitpack.io' }
}
```

and then adding add the implementation dependency

``` groovy
dependencies {
    ...
    implementation 'com.github.Syncwork-AG:hrworks-api-client-v2:[[[tbd]]]'
    ...
}
```

## Maven

Add the jitpack.io repo to the project repos

``` xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

and then adding add the implementation dependency

``` xml
<dependency>
    <groupId>com.github.Syncwork-AG</groupId>
    <artifactId>hrworks-api-client-v2</artifactId>
    <version>[[[tbd]]]</version>
</dependency>
```

## Usage in Kotlin

[//]: # (TODO Beschreibung ergänzen)
[//]: # (``` kotlin)

[//]: # (import com.aoe.hrworks.HrWorksClientBuilder)

[//]: # (fun main&#40;args: Array<String>&#41; {)

[//]: # (    HrWorksClientBuilder.buildClient&#40;)

[//]: # (        apiKey = "key",)

[//]: # (        apiSecret = "secret"&#41;)

[//]: # (        .getAllActivePersons&#40;&#41;)

[//]: # (        .blockingGet&#40;&#41;.apply {)

[//]: # (            println&#40;this&#41;)

[//]: # (        })

[//]: # (})

[//]: # (```)

## Usage in Groovy

[//]: # (TODO Beschreibung ergänzen)
[//]: # (```groovy)

[//]: # (import com.aoe.hrworks.HrWorksClientBuilder)

[//]: # (class Sample {)

[//]: # (    static void main&#40;String[] args&#41;{)

[//]: # (        def client = HrWorksClientBuilder.INSTANCE.)

[//]: # (                buildClient&#40;"key","secret"&#41;)

[//]: # (        client.allActivePersons.blockingGet&#40;&#41;.each {)

[//]: # (            println&#40;it&#41;)

[//]: # (        })

[//]: # (    })

[//]: # (})

[//]: # (```)

## Usage in Java

[//]: # (TODO Beschreibung ergänzen)
[//]: # (```java)

[//]: # (import com.aoe.hrworks.HrWorksClient;)

[//]: # (import com.aoe.hrworks.HrWorksClientBuilder;)

[//]: # (public class Sample {)

[//]: # (    public static void main&#40;String[] args&#41;{)

[//]: # (        HrWorksClient client = HrWorksClientBuilder.INSTANCE)

[//]: # (                .buildClient&#40;"key", "secret"&#41;;)

[//]: # (        client.getAllActivePersons&#40;&#41;)

[//]: # (                .blockingGet&#40;&#41;)

[//]: # (                .forEach&#40;&#40;k,v&#41; -> )

[//]: # (                System.out.print&#40;String.format&#40;"Key:%s Value:%s",k,v&#41;&#41;&#41;;)

[//]: # (    })

[//]: # (})

[//]: # (```)

## Usage in Scala

[//]: # (TODO Beschreibung ergänzen)
[//]: # (```scala)

[//]: # (import com.aoe.hrworks.HrWorksClientBuilder)

[//]: # (object Sample {)

[//]: # (  def main&#40;args: Array[String]&#41;: Unit = {)

[//]: # (    val client = HrWorksClientBuilder.INSTANCE.buildClient&#40;"key","secret"&#41;)

[//]: # (    client.getAllActivePersons)

[//]: # (      .blockingGet&#40;&#41;)

[//]: # (      .forEach&#40;&#40;k, v&#41; =>)

[//]: # (        System.out.println&#40;s"key: $k, value: $v"&#41;)

[//]: # (      &#41;)

[//]: # (  })

[//]: # (})

[//]: # (```)