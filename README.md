# Android EasyPrefs

[![](https://jitpack.io/v/kishandonga/EasyPrefs.svg)](https://jitpack.io/#kishandonga/EasyPrefs)&nbsp;&nbsp;![](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat)&nbsp;&nbsp;[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-EasyPrefs-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/8171)

EasyPrefs is a library for the android SharedPreferences or we can say it wrapper on it. It provides easy access to the SharedPreferences API, also it will need only one-time initialization, and is used in the whole project without context also has a facility to provide context if necessary with support encryption and decryption.

It supports all Primitive Data Types including Set.

For, the secure operation use AES encryption <= 20 API Level, and for 21 >= use Android-provided encrypted shared preferences in both cases you get the same output your key and value are stored securely.

This library is developed in Kotlin and supports both the language `Kotlin` as well as `Java` with the same practices.

The default file name is **`prefs_<package_name>`** and custom file name like **`prefs_<given_filename>`** there is no need to give a file extension. it is automatically appended at the end of the name.

## Installation
Gradle:

```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
    implementation 'com.github.kishandonga:EasyPrefs:1.2'
}
```

## Examples

Refer, to the Sample Test Suite in the suite package
For, more information refer to this test case code [here](app/src/androidTest/java/com/sample/easyprefs/kotlin)

#### Initialize App

`Prefs.initializeApp(context)` this line of code adds into the main Application Class, as like this.

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

Prefs.has().empty();
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
Prefs.clear().all()
Prefs.clear(fileName).all()
Prefs.clear(context).all()
Prefs.clear(context, fileName).all()

.commit() or .apply()

Note: for, securely operation use the same Prefs.clear() operation.
```
-	After the clear operation commit and apply call mandatory.

For, all the read, write, clear, has, remove support context and fileName manually, so you can use your preferences with multiple files with the same API use just need to change the fileName when you call.

If you pass context manually then no need to initialize lib on the application class, For, more information refer [here](app/src/androidTest/java/com/sample/easyprefs)

This library tested on the API levels 20, 26, 29, and 30 if you found any bug or issue raise an issue or submit a PR

## Future Scope
- add sorting on the Set so get direct sorted data.
- callback extend as we already have in the preferences.
- provide suggestions to make this lib more helpful.

---

### Contributing

Contributions are welcome! If you find a bug please report it and if you want to add a new feature then please suggest it to me. If you want to contribute code please file an issue or create a branch of the current dev branch and post a pull request.

### About me

I'm Kishan Donga and you can connect with me via the below links, I am a developer and I love to create innovations.

LinkedIn [@ikd96](https://www.linkedin.com/in/ikd96/) 
Email [kishandonga.92@gmail.com](mailto:kishandonga.92@gmail.com)
Twitter [@ikishan96](https://twitter.com/ikishan96) 
Instagram [@ikishan96](https://www.instagram.com/ikishan96/)

### License

[EasyPrefs](https://github.com/kishandonga/EasyPrefs)  is released under the [MIT License](https://github.com/kishandonga/EasyPrefs/blob/master/LICENSE.md).
