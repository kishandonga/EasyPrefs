package com.sample.easyprefs.kotlin.secure

import com.sample.easyprefs.kotlin.secure.rdwr.SecurePrefsContextFileTest
import com.sample.easyprefs.kotlin.secure.rdwr.SecurePrefsContextTest
import com.sample.easyprefs.kotlin.secure.rdwr.SecurePrefsFileTest
import com.sample.easyprefs.kotlin.secure.rdwr.SecurePrefsTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    SecurePrefsTest::class,
    SecurePrefsFileTest::class,
    SecurePrefsContextTest::class,
    SecurePrefsContextFileTest::class,
)
class SecurePrefsTestSuite