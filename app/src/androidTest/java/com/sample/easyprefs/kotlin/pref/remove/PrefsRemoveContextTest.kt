package com.sample.easyprefs.kotlin.pref.remove

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.sample.easyprefs.kotlin.pref.Const
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
class PrefsRemoveContextTest {

    private lateinit var context: Context
    private val p1 = "Hello..."

    @Before
    fun initApp() {
        context = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun test1_commitOp() {
        assertTrue(Prefs.clear(context).all().commit())

        assertTrue(
            Prefs.write(context)
                .content(Const.STRING_KEY, p1)
                .commit()
        )

        assertTrue(Prefs.remove(context).key(Const.STRING_KEY).commit())

        val data = Prefs.read(context).content(Const.STRING_KEY, "")
        assertEquals("", data)
    }

    @Test
    fun test2_applyOp() {
        assertTrue(Prefs.clear(context).all().commit())

        assertTrue(
            Prefs.write(context)
                .content(Const.STRING_KEY_APPLY, p1)
                .commit()
        )

        Prefs.remove(context).key(Const.STRING_KEY_APPLY).apply()

        val data = Prefs.read(context).content(Const.STRING_KEY_APPLY, "")
        assertEquals("", data)
    }
}