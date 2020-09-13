package com.sample.easyprefs.kotlin.suite

import com.sample.easyprefs.kotlin.clr.PrefsClearContextFileTest
import com.sample.easyprefs.kotlin.clr.PrefsClearContextTest
import com.sample.easyprefs.kotlin.clr.PrefsClearFileTest
import com.sample.easyprefs.kotlin.clr.PrefsClearTest
import com.sample.easyprefs.kotlin.has.PrefsHasContextFileTest
import com.sample.easyprefs.kotlin.has.PrefsHasContextTest
import com.sample.easyprefs.kotlin.has.PrefsHasFileTest
import com.sample.easyprefs.kotlin.has.PrefsHasTest
import com.sample.easyprefs.kotlin.rdwr.PrefsContextFileTest
import com.sample.easyprefs.kotlin.rdwr.PrefsContextTest
import com.sample.easyprefs.kotlin.rdwr.PrefsFileTest
import com.sample.easyprefs.kotlin.rdwr.PrefsTest
import com.sample.easyprefs.kotlin.remove.PrefsRemoveContextFileTest
import com.sample.easyprefs.kotlin.remove.PrefsRemoveContextTest
import com.sample.easyprefs.kotlin.remove.PrefsRemoveFileTest
import com.sample.easyprefs.kotlin.remove.PrefsRemoveTest
import com.sample.easyprefs.kotlin.secure.SecurePrefsContextFileTest
import com.sample.easyprefs.kotlin.secure.SecurePrefsContextTest
import com.sample.easyprefs.kotlin.secure.SecurePrefsFileTest
import com.sample.easyprefs.kotlin.secure.SecurePrefsTest
import org.junit.runner.RunWith
import org.junit.runners.Suite


@RunWith(Suite::class)
@Suite.SuiteClasses(
    PrefsTest::class,
    PrefsFileTest::class,
    PrefsContextTest::class,
    PrefsContextFileTest::class,

    SecurePrefsTest::class,
    SecurePrefsFileTest::class,
    SecurePrefsContextTest::class,
    SecurePrefsContextFileTest::class,

    PrefsHasTest::class,
    PrefsHasFileTest::class,
    PrefsHasContextTest::class,
    PrefsHasContextFileTest::class,

    PrefsRemoveTest::class,
    PrefsRemoveFileTest::class,
    PrefsRemoveContextTest::class,
    PrefsRemoveContextFileTest::class,

    PrefsClearTest::class,
    PrefsClearFileTest::class,
    PrefsClearContextTest::class,
    PrefsClearContextFileTest::class
)
class TestSuite