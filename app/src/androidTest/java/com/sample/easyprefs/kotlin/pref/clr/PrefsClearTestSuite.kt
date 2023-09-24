package com.sample.easyprefs.kotlin.pref.clr

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    PrefsClearTest::class,
    PrefsClearFileTest::class,
    PrefsClearContextTest::class,
    PrefsClearContextFileTest::class
)
class PrefsClearTestSuite