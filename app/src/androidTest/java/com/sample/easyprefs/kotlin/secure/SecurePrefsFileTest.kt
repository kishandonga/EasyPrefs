package com.sample.easyprefs.kotlin.secure

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import io.easyprefs.Prefs
import org.junit.Assert
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
class SecurePrefsFileTest {

    private val p1 = "Hello..."
    private val p2 = Int.MAX_VALUE
    private val p3 = Float.MAX_VALUE
    private val p4 = Long.MAX_VALUE
    private val p5 = Double.MAX_VALUE
    private val p6 = false
    private val p7 = setOf("A", "B", "C", "D")

    @Before
    fun initApp() {
        Prefs.initializeApp(InstrumentationRegistry.getInstrumentation().targetContext)
    }

    @Test
    fun test1_CommitOp() {
        Assert.assertTrue(
            Prefs.securely().write(Const.PREF_SAMPLE_FILE)
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

        val o1 = Prefs.securely().read(Const.PREF_SAMPLE_FILE).content(Const.SAMPLE_STRING_KEY, "")
        Assert.assertEquals(p1, o1)

        val o2 = Prefs.securely().read(Const.PREF_SAMPLE_FILE).content(Const.SAMPLE_INT_KEY, Int.MIN_VALUE)
        Assert.assertEquals(p2, o2)

        val o3 = Prefs.securely().read(Const.PREF_SAMPLE_FILE).content(Const.SAMPLE_FLOAT_KEY, Float.MIN_VALUE)
        Assert.assertEquals(p3, o3)

        val o4 = Prefs.securely().read(Const.PREF_SAMPLE_FILE).content(Const.SAMPLE_LONG_KEY, Long.MIN_VALUE)
        Assert.assertEquals(p4, o4)

        val o5 = Prefs.securely().read(Const.PREF_SAMPLE_FILE).content(Const.SAMPLE_DOUBLE_KEY, Double.MIN_VALUE)
        Assert.assertEquals(p5.toString(), o5.toString())

        val o6 = Prefs.securely().read(Const.PREF_SAMPLE_FILE).content(Const.SAMPLE_BOOLEAN_KEY, true)
        Assert.assertEquals(p6, o6)

        val o7 = Prefs.securely().read(Const.PREF_SAMPLE_FILE).content(Const.SAMPLE_STRING_SET_KEY, setOf())
        Assert.assertEquals(p7, o7)
    }

    @Test
    fun test3_ApplyOp() {
        Prefs.securely().write(Const.PREF_SAMPLE_FILE)
            .content(Const.SAMPLE_STRING_KEY_APPLY, p1)
            .content(Const.SAMPLE_INT_KEY_APPLY, p2)
            .content(Const.SAMPLE_FLOAT_KEY_APPLY, p3)
            .content(Const.SAMPLE_LONG_KEY_APPLY, p4)
            .content(Const.SAMPLE_DOUBLE_KEY_APPLY, p5)
            .content(Const.SAMPLE_BOOLEAN_KEY_APPLY, p6)
            .content(Const.SAMPLE_STRING_SET_KEY_APPLY, p7)
            .apply()

        val o1 = Prefs.securely().read(Const.PREF_SAMPLE_FILE).content(Const.SAMPLE_STRING_KEY_APPLY, "")
        Assert.assertEquals(p1, o1)

        val o2 = Prefs.securely().read(Const.PREF_SAMPLE_FILE).content(Const.SAMPLE_INT_KEY_APPLY, Int.MIN_VALUE)
        Assert.assertEquals(p2, o2)

        val o3 = Prefs.securely().read(Const.PREF_SAMPLE_FILE).content(Const.SAMPLE_FLOAT_KEY_APPLY, Float.MIN_VALUE)
        Assert.assertEquals(p3, o3)

        val o4 = Prefs.securely().read(Const.PREF_SAMPLE_FILE).content(Const.SAMPLE_LONG_KEY_APPLY, Long.MIN_VALUE)
        Assert.assertEquals(p4, o4)

        val o5 = Prefs.securely().read(Const.PREF_SAMPLE_FILE).content(Const.SAMPLE_DOUBLE_KEY_APPLY, Double.MIN_VALUE)
        Assert.assertEquals(p5.toString(), o5.toString())

        val o6 = Prefs.securely().read(Const.PREF_SAMPLE_FILE).content(Const.SAMPLE_BOOLEAN_KEY_APPLY, true)
        Assert.assertEquals(p6, o6)

        val o7 = Prefs.securely().read(Const.PREF_SAMPLE_FILE).content(Const.SAMPLE_STRING_SET_KEY_APPLY, setOf())
        Assert.assertEquals(p7, o7)
    }
}