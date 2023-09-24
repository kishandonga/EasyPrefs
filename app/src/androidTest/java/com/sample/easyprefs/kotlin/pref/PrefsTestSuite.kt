package com.sample.easyprefs.kotlin.pref

import com.sample.easyprefs.kotlin.pref.rdwr.PrefsContextFileTest
import com.sample.easyprefs.kotlin.pref.rdwr.PrefsContextTest
import com.sample.easyprefs.kotlin.pref.rdwr.PrefsFileTest
import com.sample.easyprefs.kotlin.pref.rdwr.PrefsTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    PrefsTest::class,
    PrefsFileTest::class,
    PrefsContextTest::class,
    PrefsContextFileTest::class
)
class PrefsTestSuite