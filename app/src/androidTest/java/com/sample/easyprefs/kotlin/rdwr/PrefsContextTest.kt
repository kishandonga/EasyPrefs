package com.sample.easyprefs.kotlin.rdwr

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
class PrefsContextTest {

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
        //Prefs.initializeApp()
        context = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun test1_CommitOp() {
        assertTrue(
            Prefs.write(context)
                .content(Const.SAMPLE_STRING_KEY, p1)
                .content(Const.SAMPLE_INT_KEY, p2)
                .content(Const.SAMPLE_FLOAT_KEY, p3)
                .content(Const.SAMPLE_LONG_KEY, p4)
                .content(Const.SAMPLE_DOUBLE_KEY, p5)
                .content(Const.SAMPLE_BOOLEAN_KEY, p6)
                .content(Const.SAMPLE_STRING_SET_KEY, p7)
                .commit()
        )
    }

    @Test
    fun test2_ReadCommitOp() {

        val o1 = Prefs.read(context).content(Const.SAMPLE_STRING_KEY, "")
        assertEquals(p1, o1)

        val o2 = Prefs.read(context).content(Const.SAMPLE_INT_KEY, Int.MIN_VALUE)
        assertEquals(p2, o2)

        val o3 = Prefs.read(context).content(Const.SAMPLE_FLOAT_KEY, Float.MIN_VALUE)
        assertEquals(p3, o3)

        val o4 = Prefs.read(context).content(Const.SAMPLE_LONG_KEY, Long.MIN_VALUE)
        assertEquals(p4, o4)

        val o5 = Prefs.read(context).content(Const.SAMPLE_DOUBLE_KEY, Double.MIN_VALUE)
        assertEquals(p5.toString(), o5.toString())

        val o6 = Prefs.read(context).content(Const.SAMPLE_BOOLEAN_KEY, true)
        assertEquals(p6, o6)

        val o7 = Prefs.read(context).content(Const.SAMPLE_STRING_SET_KEY, setOf())
        assertEquals(p7, o7)
    }

    @Test
    fun test3_ApplyOp() {
        Prefs.write(context)
            .content(Const.SAMPLE_STRING_KEY_APPLY, p1)
            .content(Const.SAMPLE_INT_KEY_APPLY, p2)
            .content(Const.SAMPLE_FLOAT_KEY_APPLY, p3)
            .content(Const.SAMPLE_LONG_KEY_APPLY, p4)
            .content(Const.SAMPLE_DOUBLE_KEY_APPLY, p5)
            .content(Const.SAMPLE_BOOLEAN_KEY_APPLY, p6)
            .content(Const.SAMPLE_STRING_SET_KEY_APPLY, p7)
            .apply()
    }

    @Test
    fun test4_ReadApplyOp() {

        val o1 = Prefs.read(context).content(Const.SAMPLE_STRING_KEY_APPLY, "")
        assertEquals(p1, o1)

        val o2 = Prefs.read(context).content(Const.SAMPLE_INT_KEY_APPLY, Int.MIN_VALUE)
        assertEquals(p2, o2)

        val o3 = Prefs.read(context).content(Const.SAMPLE_FLOAT_KEY_APPLY, Float.MIN_VALUE)
        assertEquals(p3, o3)

        val o4 = Prefs.read(context).content(Const.SAMPLE_LONG_KEY_APPLY, Long.MIN_VALUE)
        assertEquals(p4, o4)

        val o5 = Prefs.read(context).content(Const.SAMPLE_DOUBLE_KEY_APPLY, Double.MIN_VALUE)
        assertEquals(p5.toString(), o5.toString())

        val o6 = Prefs.read(context).content(Const.SAMPLE_BOOLEAN_KEY_APPLY, true)
        assertEquals(p6, o6)

        val o7 = Prefs.read(context).content(Const.SAMPLE_STRING_SET_KEY_APPLY, setOf())
        assertEquals(p7, o7)
    }
}