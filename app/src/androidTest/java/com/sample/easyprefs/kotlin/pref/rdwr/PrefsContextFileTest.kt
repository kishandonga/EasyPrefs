package com.sample.easyprefs.kotlin.pref.rdwr

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
class PrefsContextFileTest {

    private lateinit var context: Context

    private val p1 = "Hello..."
    private val p2 = Int.MAX_VALUE
    private val p3 = Float.MAX_VALUE
    private val p4 = Long.MAX_VALUE
    private val p5 = Double.MAX_VALUE
    private val p6 = false
    private val p7 = setOf("A", "B", "C", "D")

    @Before
    fun initApp() {
        context = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun test1_commitOp() {

        assertTrue(Prefs.clear(context).all().commit())

        assertTrue(
            Prefs.write(context, Const.PREF_FILE)
                .content(Const.STRING_KEY, p1)
                .content(Const.INT_KEY, p2)
                .content(Const.FLOAT_KEY, p3)
                .content(Const.LONG_KEY, p4)
                .content(Const.DOUBLE_KEY, p5)
                .content(Const.BOOLEAN_KEY, p6)
                .content(Const.SET_KEY, p7)
                .commit()
        )

        val o1 = Prefs.read(context, Const.PREF_FILE).content(Const.STRING_KEY, "")
        assertEquals(p1, o1)

        val o2 = Prefs.read(context, Const.PREF_FILE).content(Const.INT_KEY, Int.MIN_VALUE)
        assertEquals(p2, o2)

        val o3 = Prefs.read(context, Const.PREF_FILE).content(Const.FLOAT_KEY, Float.MIN_VALUE)
        assertEquals(p3, o3)

        val o4 = Prefs.read(context, Const.PREF_FILE).content(Const.LONG_KEY, Long.MIN_VALUE)
        assertEquals(p4, o4)

        val o5 = Prefs.read(context, Const.PREF_FILE).content(Const.DOUBLE_KEY, Double.MIN_VALUE)
        assertEquals(p5.toString(), o5.toString())

        val o6 = Prefs.read(context, Const.PREF_FILE).content(Const.BOOLEAN_KEY, true)
        assertEquals(p6, o6)

        val o7 = Prefs.read(context, Const.PREF_FILE).content(Const.SET_KEY, setOf())
        assertEquals(p7, o7)
    }

    @Test
    fun test2_applyOp() {

        assertTrue(Prefs.clear(context).all().commit())

        Prefs.write(context, Const.PREF_FILE)
            .content(Const.STRING_KEY_APPLY, p1)
            .content(Const.INT_KEY_APPLY, p2)
            .content(Const.FLOAT_KEY_APPLY, p3)
            .content(Const.LONG_KEY_APPLY, p4)
            .content(Const.DOUBLE_KEY_APPLY, p5)
            .content(Const.BOOLEAN_KEY_APPLY, p6)
            .content(Const.SET_KEY_APPLY, p7)
            .apply()

        val o1 = Prefs.read(
            context,
            Const.PREF_FILE
        ).content(Const.STRING_KEY_APPLY, "")
        assertEquals(p1, o1)

        val o2 = Prefs.read(context, Const.PREF_FILE).content(Const.INT_KEY_APPLY, Int.MIN_VALUE)
        assertEquals(p2, o2)

        val o3 =
            Prefs.read(context, Const.PREF_FILE).content(Const.FLOAT_KEY_APPLY, Float.MIN_VALUE)
        assertEquals(p3, o3)

        val o4 =
            Prefs.read(context, Const.PREF_FILE).content(Const.LONG_KEY_APPLY, Long.MIN_VALUE)
        assertEquals(p4, o4)

        val o5 = Prefs.read(
            context,
            Const.PREF_FILE
        ).content(Const.DOUBLE_KEY_APPLY, Double.MIN_VALUE)
        assertEquals(p5.toString(), o5.toString())

        val o6 = Prefs.read(
            context,
            Const.PREF_FILE
        ).content(Const.BOOLEAN_KEY_APPLY, true)
        assertEquals(p6, o6)

        val o7 = Prefs.read(
            context,
            Const.PREF_FILE
        ).content(Const.SET_KEY_APPLY, setOf())
        assertEquals(p7, o7)
    }
}