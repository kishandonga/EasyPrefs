package com.sample.easyprefs.kotlin.pref

import com.sample.easyprefs.kotlin.pref.has.PrefsHasContextFileTest
import com.sample.easyprefs.kotlin.pref.has.PrefsHasContextTest
import com.sample.easyprefs.kotlin.pref.has.PrefsHasFileTest
import com.sample.easyprefs.kotlin.pref.has.PrefsHasTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    PrefsHasTest::class,
    PrefsHasFileTest::class,
    PrefsHasContextTest::class,
    PrefsHasContextFileTest::class,
)
class PrefsHasTestSuite