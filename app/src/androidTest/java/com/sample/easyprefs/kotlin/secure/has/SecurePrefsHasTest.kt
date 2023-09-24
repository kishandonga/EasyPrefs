package com.sample.easyprefs.kotlin.secure.has

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.sample.easyprefs.kotlin.Const
import io.easyprefs.Prefs
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class SecurePrefsHasTest {

    private val p1 = "Hello..."

    @Before
    fun initApp() {
        Prefs.initializeApp(InstrumentationRegistry.getInstrumentation().targetContext)
    }

    @Test
    fun test1_hasOp() {

        assertTrue(Prefs.clear().all().commit())

        assertTrue(
            Prefs.securely().write()
                .content(Const.STRING_KEY, p1)
                .commit()
        )

        assertTrue(Prefs.securely().has().key(Const.STRING_KEY))
    }
}
