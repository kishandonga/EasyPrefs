package com.sample.easyprefs.kotlin.pref.remove

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    PrefsRemoveTest::class,
    PrefsRemoveFileTest::class,
    PrefsRemoveContextTest::class,
    PrefsRemoveContextFileTest::class,
)
class PrefsRemoveTestSuite