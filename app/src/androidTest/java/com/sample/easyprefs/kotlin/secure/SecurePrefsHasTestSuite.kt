package com.sample.easyprefs.kotlin.secure

import com.sample.easyprefs.kotlin.secure.has.SecurePrefsHasContextFileTest
import com.sample.easyprefs.kotlin.secure.has.SecurePrefsHasContextTest
import com.sample.easyprefs.kotlin.secure.has.SecurePrefsHasFileTest
import com.sample.easyprefs.kotlin.secure.has.SecurePrefsHasTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    SecurePrefsHasTest::class,
    SecurePrefsHasFileTest::class,
    SecurePrefsHasContextTest::class,
    SecurePrefsHasContextFileTest::class,
)
class SecurePrefsHasTestSuite