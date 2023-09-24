package com.sample.easyprefs.kotlin.pref.rdwr

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