package com.sample.easyprefs.kotlin.pref.has

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