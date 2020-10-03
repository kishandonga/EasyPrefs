# Android EasyPrefs

[![](https://jitpack.io/v/kishandonga/EasyPrefs.svg)](https://jitpack.io/#kishandonga/EasyPrefs)&nbsp;&nbsp;![](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat)&nbsp;&nbsp;[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-EasyPrefs-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/8171)

EasyPrefs is library for the android SharedPreferences or we can say it wrapper on it. It is provided easy access to the SharedPreferences API, also it will need only one-time initialization and used in the whole project without context also facility to provide context if necessary with support encryption and decryption.

It support all Primitive Data Type and String Set more api will be added soon.

For, the secure operation used AES encryption <= 20 API Level, and for 21 >= used android provided encrypted shared preferences in both case you got same output your key and value both are stored securly.

This library is developed in the Kotlin and supported both language `Kotlin` as well as `Java` with the same practices.

Default file name is **`prefs_<package_name>`** and custom file name like **`prefs_<given_filename>`** there is no need to give file extension. it is automatically append at the end of the name.

## Installation
Gradle:

```groovy
allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
    implementation 'com.github.kishandonga:EasyPrefs:1.1'
}
```

## Examples

Refer [This](app/src/androidTest/java/com/sample/easyprefs/kotlin/suite) Sample Test Suite in the suite package
For, the more information refer this test case code [here](app/src/androidTest/java/com/sample/easyprefs)

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
Prefs.write().content("KEY", "VALUE")
	     .content("KEY", "VALUE")
	     .commit() or .apply()
```

```kotlin
Prefs.write(fileName)
       	     .content("KEY", "VALUE")
	     .content("KEY", "VALUE")
	     .commit() or .apply()
```

```kotlin
Prefs.write(context)
       	     .content("KEY", "VALUE")
       	     .content("KEY", "VALUE")
       	     .commit() or .apply()
```

```kotlin
Prefs.write(context, fileName)
       	     .content("KEY", "VALUE")
       	     .content("KEY", "VALUE")
       	     .commit() or .apply()
```

#### Read Operation

```kotlin
Prefs.read().content("KEY", "")
Prefs.read(fileName).content("KEY", "")
Prefs.read(context).content("KEY", "")
Prefs.read(context, fileName).content("KEY", "")
```

#### Secure Operation

```kotlin
Prefs.securely().write()
       	     .content("KEY", "VALUE")
       	     .content("KEY", "VALUE")
       	     .commit() or .apply()

Prefs.securely().read().content("KEY",  "")
```

#### Has Operation

```kotlin
Prefs.has().key("KEY");
Prefs.has(fileName).key("KEY");
Prefs.has(context).key("KEY");
Prefs.has(context, fileName).key("KEY");
```
- Give boolean value if key exists then true else false.

#### Remove Operation

```kotlin
Prefs.remove().key("KEY").
Prefs.remove(fileName).key("KEY").
Prefs.remove(context).key("KEY").
Prefs.remove(context, fileName).key("KEY").

commit() or .apply()
```
-	After the remove operation commit and apply call mandatory.

#### Clear Operation

```kotlin
Prefs.clear().all().
Prefs.clear(fileName).all().
Prefs.clear(context).all().
Prefs.clear(context, fileName).all().

.commit() or .apply()
```
-	After the clear operation commit and apply call mandatory.

For, all the read, write, clear, has, remove support context and file name manually so you can used your preferences with multiple files with the same api use just need to change file name when you call.

If you pass context manually then no need to initialize lib on the application class, For, more information refer [here](app/src/androidTest/java/com/sample/easyprefs)

## Future Scope
- has and remove support provided to secure operations.
- add sorting on the Set so get direct sorted data.
- to make life easier adding more api in near future
- callback extend as we already have in the preferences.

---

### Contributing

Contributions are welcome! If you find a bug please report it and if you want add new feature then please suggest to me. If you want to contribute code please file an issue and create a branch off of the current dev branch and post a pull request.

### About me

I'm Kishan Donga and you can connect with me via twitter [@ikishan92](https://twitter.com/ikishan92) and instagram [@ikishan92](https://www.instagram.com/ikishan92/), I am a mobility developer and I love to do some innovation.

### License

[EasyPrefs](https://github.com/kishandonga/EasyPrefs)  is released under the [MIT License](https://github.com/kishandonga/EasyPrefs/blob/master/LICENSE.md).
