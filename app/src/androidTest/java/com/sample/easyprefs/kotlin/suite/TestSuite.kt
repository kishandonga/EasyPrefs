package com.sample.easyprefs.kotlin.suite

import com.sample.easyprefs.kotlin.pref.has.PrefsHasTestSuite
import com.sample.easyprefs.kotlin.pref.rdwr.PrefsTestSuite
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    PrefsTestSuite::class,
    PrefsHasTestSuite::class,


//    SecurePrefsTest::class,
//    SecurePrefsFileTest::class,
//    SecurePrefsContextTest::class,
//    SecurePrefsContextFileTest::class,
//
//    SecurePrefsHasTest::class,
//    SecurePrefsHasFileTest::class,
//    SecurePrefsHasContextTest::class,
//    SecurePrefsHasContextFileTest::class,
//
//    PrefsRemoveTest::class,
//    PrefsRemoveFileTest::class,
//    PrefsRemoveContextTest::class,
//    PrefsRemoveContextFileTest::class,
//
//    PrefsClearTest::class,
//    PrefsClearFileTest::class,
//    PrefsClearContextTest::class,
//    PrefsClearContextFileTest::class
)
class TestSuite