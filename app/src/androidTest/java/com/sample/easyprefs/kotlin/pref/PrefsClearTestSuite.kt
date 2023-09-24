package com.sample.easyprefs.kotlin.pref

import com.sample.easyprefs.kotlin.pref.clr.PrefsClearContextFileTest
import com.sample.easyprefs.kotlin.pref.clr.PrefsClearContextTest
import com.sample.easyprefs.kotlin.pref.clr.PrefsClearFileTest
import com.sample.easyprefs.kotlin.pref.clr.PrefsClearTest
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