package com.sample.easyprefs.kotlin.secure.clr

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.sample.easyprefs.kotlin.Const
import io.easyprefs.Prefs
import org.junit.Assert.assertEquals
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
class SecurePrefsClearFileTest {

    @Before
    fun initApp() {
        Prefs.initializeApp(InstrumentationRegistry.getInstrumentation().targetContext)
    }

    @Test
    fun test1_commitOp() {
        assertTrue(Prefs.clear(Const.PREF_FILE).all().commit())
        assertTrue(Prefs.has(Const.PREF_FILE).empty())

        val data = Prefs.securely().read(Const.PREF_FILE).content(Const.STRING_KEY, "")
        assertEquals("", data)
    }

    @Test
    fun test2_applyOp() {
        Prefs.clear(Const.PREF_FILE).all().apply()
        assertTrue(Prefs.has(Const.PREF_FILE).empty())

        val data = Prefs.securely().read(Const.PREF_FILE).content(Const.STRING_KEY_APPLY, "")
        assertEquals("", data)
    }
}