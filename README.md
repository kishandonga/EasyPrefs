# Android EasyPrefs

[![](https://jitpack.io/v/kishandonga/EasyPrefs.svg)](https://jitpack.io/#kishandonga/EasyPrefs)

EasyPrefs is library for the android SharedPreferences or we can say it wrapper on it. It is provided easy access to the SharedPreferences API, also it will need only one-time initialization and used in the whole project without context also facility to provide context if necessary with support deferent file name and mode.

This library design like write, read and edit call with synchronous and  asynchronous manner when you call synchronous API then behind `commit` operation to happen and when you do asynchronous operation behind happening to `apply` 

This library is developed in the Kotlin and supported to both language `Kotlin` as well as `Java`

Default file name as like **`prefs_<package_name>`** and custom file name like **`prefs_<given_filename>`** there is no need to give file extension.

## Installation
Gradle:

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
	implementation 'com.github.kishandonga:EasyPrefs:1.0'
}
```

## Examples

#### Refer This Sample Test Cases and for more information refer API Document Section
For, the more infromation refer this test case code [here](app/src/androidTest/java/com/sample/easyprefs)

#### Initialize App

`Prefs.initializeApp(context)` this line of code add into the main Application Class, as like this.

```kotlin
class MainApp : Application() {  
    override fun onCreate() {  
        super.onCreate()  
        Prefs.initializeApp(this)  
    }  
}
```

#### Write Operation

```kotlin
Prefs.write().string("KEY", "VALUE")
Prefs.write().stringAsync("KEY", "VALUE")
```

```kotlin
Prefs.write(context).string("KEY", "VALUE")
Prefs.write(context).stringAsync("KEY", "VALUE")
```

```kotlin
Prefs.write(context, fileName).string("KEY", "VALUE")
Prefs.write(context, fileName).stringAsync("KEY", "VALUE")
```

#### Read Operation

```kotlin
Prefs.read().string("KEY", "")
```

```kotlin
Prefs.read(context).string("KEY", "")
```

```kotlin
Prefs.read(context, fileName).string("KEY", "")
```

#### Edit Operation

```kotlin
Prefs.edit().remove("KEY")
Prefs.edit().removeAsync("KEY")
```

```kotlin
Prefs.edit(context).remove("KEY")
Prefs.edit(context).removeAsync("KEY")
```

```kotlin
Prefs.edit(context, fileName).remove("KEY")
Prefs.edit(context, fileName).removeAsync("KEY")
```

If you pass context manully then no need to initialize lib on the application class, For, more information refer API Document section and [here](app/src/androidTest/java/com/sample/easyprefs)

## API Document

#### v1.0

> **Write Operations**

### **Prefs.**

```kotlin
write()  
write(fileName: String)  
write(fileName: String, mode: Int)  
write(context: Context)  
write(context: Context, fileName: String)  
write(context: Context, fileName: String, mode: Int)
```
**•**
```kotlin
int(key: String, value: Int): Boolean  
intAsync(key: String, value: Int)  
  
string(key: String, value: String): Boolean  
stringAsync(key: String, value: String)  
  
long(key: String, value: Long): Boolean  
longAsync(key: String, value: Long)  
  
float(key: String, value: Float): Boolean  
floatAsync(key: String, value: Float)  
  
double(key: String, value: Double): Boolean  
doubleAsync(key: String, value: Double)  
  
boolean(key: String, value: Boolean): Boolean  
booleanAsync(key: String, value: Boolean)  
  
stringSet(key: String, value: Set<String>): Boolean  
stringSetAsync(key: String, value: Set<String>)
```
---
> **Read Operations**

### **Prefs.**

```kotlin
read()  
read(fileName: String)  
read(fileName: String, mode: Int)  
read(context: Context)  
read(context: Context, fileName: String)  
read(context: Context, fileName: String, mode: Int)
```
**•**
```kotlin
int(key: String, defaultValue: Int): Int  
string(key: String, defaultValue: String): String  
long(key: String, defaultValue: Long): Long  
float(key: String, defaultValue: Float): Float  
double(key: String, defaultValue: Double): Double  
boolean(key: String, defaultValue: Boolean): Boolean  
stringSet(key: String, defaultValue: Set<String>): Set<String>
```
---
> **Edit Operations**

### **Prefs.**

```kotlin
edit()  
edit(fileName: String)  
edit(fileName: String, mode: Int)  
edit(context: Context)  
edit(context: Context, fileName: String)  
edit(context: Context, fileName: String, mode: Int)
```
**•**
```kotlin
clear(): Boolean  
clearAsync()  
remove(key: String): Boolean  
removeAsync(key: String)
```

### About me

I'm Kishan Donga and you can connect with me via twitter [@ikishan92](https://twitter.com/ikishan92) and instagram [@ikishan92](https://www.instagram.com/ikishan92/), I am a mobility developer and I love to do some innovation.
