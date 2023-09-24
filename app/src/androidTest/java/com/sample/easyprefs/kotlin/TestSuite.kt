package com.sample.easyprefs.kotlin

import com.sample.easyprefs.kotlin.pref.clr.PrefsClearTestSuite
import com.sample.easyprefs.kotlin.pref.has.PrefsHasTestSuite
import com.sample.easyprefs.kotlin.pref.rdwr.PrefsTestSuite
import com.sample.easyprefs.kotlin.pref.remove.PrefsRemoveTestSuite
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    PrefsTestSuite::class,
    PrefsHasTestSuite::class,
    PrefsRemoveTestSuite::class,
    PrefsClearTestSuite::class,

//    SecurePrefsTest::class,
//    SecurePrefsFileTest::class,
//    SecurePrefsContextTest::class,
//    SecurePrefsContextFileTest::class,

//    SecurePrefsHasTest::class,
//    SecurePrefsHasFileTest::class,
//    SecurePrefsHasContextTest::class,
//    SecurePrefsHasContextFileTest::class,
)
class TestSuite