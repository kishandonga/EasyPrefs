package com.sample.easyprefs.kotlin.secure

import com.sample.easyprefs.kotlin.secure.clr.SecurePrefsClearContextFileTest
import com.sample.easyprefs.kotlin.secure.clr.SecurePrefsClearContextTest
import com.sample.easyprefs.kotlin.secure.clr.SecurePrefsClearFileTest
import com.sample.easyprefs.kotlin.secure.clr.SecurePrefsClearTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    SecurePrefsClearTest::class,
    SecurePrefsClearFileTest::class,
    SecurePrefsClearContextTest::class,
    SecurePrefsClearContextFileTest::class
)
class SecurePrefsClearTestSuite