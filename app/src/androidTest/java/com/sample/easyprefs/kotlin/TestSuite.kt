package com.sample.easyprefs.kotlin

import com.sample.easyprefs.kotlin.pref.PrefsClearTestSuite
import com.sample.easyprefs.kotlin.pref.PrefsHasTestSuite
import com.sample.easyprefs.kotlin.pref.PrefsRemoveTestSuite
import com.sample.easyprefs.kotlin.pref.PrefsTestSuite
import com.sample.easyprefs.kotlin.secure.SecurePrefsClearTestSuite
import com.sample.easyprefs.kotlin.secure.SecurePrefsHasTestSuite
import com.sample.easyprefs.kotlin.secure.SecurePrefsRemoveTestSuite
import com.sample.easyprefs.kotlin.secure.SecurePrefsTestSuite
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    PrefsTestSuite::class,
    PrefsHasTestSuite::class,
    PrefsRemoveTestSuite::class,
    PrefsClearTestSuite::class,

    SecurePrefsTestSuite::class,
    SecurePrefsHasTestSuite::class,
    SecurePrefsRemoveTestSuite::class,
    SecurePrefsClearTestSuite::class,
)
class TestSuite