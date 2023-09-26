package com.sample.easyprefs.kotlin.secure.remove

import android.content.Context
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
class SecurePrefsRemoveContextFileTest {

    private lateinit var context: Context
    private val p1 = "Hello..."

    @Before
    fun initApp() {
        context = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun test1_commitOp() {

        assertTrue(Prefs.clear(context, Const.PREF_FILE).all().commit())
        assertTrue(Prefs.has(context, Const.PREF_FILE).empty())

        assertTrue(
            Prefs.securely().write(context, Const.PREF_FILE)
                .content(Const.STRING_KEY, p1)
                .commit()
        )

        assertTrue(
            Prefs.securely().remove(context, Const.PREF_FILE).key(Const.STRING_KEY).commit()
        )

        val data = Prefs.securely().read(context, Const.PREF_FILE).content(Const.STRING_KEY, "")
        assertEquals("", data)
    }

    @Test
    fun test2_applyOp() {

        assertTrue(Prefs.clear(context, Const.PREF_FILE).all().commit())
        assertTrue(Prefs.has(context, Const.PREF_FILE).empty())

        assertTrue(
            Prefs.securely().write(context, Const.PREF_FILE)
                .content(Const.STRING_KEY, p1)
                .commit()
        )

        Prefs.securely().remove(context, Const.PREF_FILE).key(Const.STRING_KEY_APPLY).apply()

        val data = Prefs.securely().read(
            context,
            Const.PREF_FILE
        ).content(Const.STRING_KEY_APPLY, "")
        assertEquals("", data)
    }
}