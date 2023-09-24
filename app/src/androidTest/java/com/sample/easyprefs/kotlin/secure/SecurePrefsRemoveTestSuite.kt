package com.sample.easyprefs.kotlin.secure

import com.sample.easyprefs.kotlin.secure.remove.SecurePrefsRemoveContextFileTest
import com.sample.easyprefs.kotlin.secure.remove.SecurePrefsRemoveContextTest
import com.sample.easyprefs.kotlin.secure.remove.SecurePrefsRemoveFileTest
import com.sample.easyprefs.kotlin.secure.remove.SecurePrefsRemoveTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    SecurePrefsRemoveTest::class,
    SecurePrefsRemoveFileTest::class,
    SecurePrefsRemoveContextTest::class,
    SecurePrefsRemoveContextFileTest::class,
)
class SecurePrefsRemoveTestSuite