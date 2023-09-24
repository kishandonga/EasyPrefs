package com.sample.easyprefs.kotlin.pref

import com.sample.easyprefs.kotlin.pref.remove.PrefsRemoveContextFileTest
import com.sample.easyprefs.kotlin.pref.remove.PrefsRemoveContextTest
import com.sample.easyprefs.kotlin.pref.remove.PrefsRemoveFileTest
import com.sample.easyprefs.kotlin.pref.remove.PrefsRemoveTest
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