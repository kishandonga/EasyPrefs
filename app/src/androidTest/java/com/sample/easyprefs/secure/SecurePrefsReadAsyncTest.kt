package com.sample.easyprefs.secure

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import io.easyprefs.Prefs
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class SecurePrefsReadAsyncTest {

    @Before
    fun initApp() {
        Prefs.initializeApp(InstrumentationRegistry.getInstrumentation().targetContext)
    }

    @Test
    fun testStringAsync() {
        val value = "Async..."
        val data = Prefs.securely().read().string(Const.SAMPLE_STRING_KEY_ASYNC, "")
        assertEquals(value, data)
    }

    @Test
    fun testIntAsync() {
        val value = Int.MAX_VALUE
        val data = Prefs.securely().read().int(Const.SAMPLE_INT_KEY_ASYNC, Int.MIN_VALUE)
        assertEquals(value, data)
    }

    @Test
    fun testFloatAsync() {
        val value = Float.MAX_VALUE
        val data = Prefs.securely().read().float(Const.SAMPLE_FLOAT_KEY_ASYNC, Float.MIN_VALUE)
        assertEquals(value, data)
    }

    @Test
    fun testLongAsync() {
        val value = Long.MAX_VALUE
        val data = Prefs.securely().read().long(Const.SAMPLE_LONG_KEY_ASYNC, Long.MIN_VALUE)
        assertEquals(value, data)
    }

    @Test
    fun testDoubleAsync() {
        val value = Double.MAX_VALUE
        val data = Prefs.securely().read().double(Const.SAMPLE_DOUBLE_KEY_ASYNC, Double.MIN_VALUE)
        assertEquals(value.toString(), data.toString())
    }

    @Test
    fun testBooleanAsync() {
        val value = false
        val data = Prefs.securely().read().boolean(Const.SAMPLE_BOOLEAN_KEY_ASYNC, true)
        assertEquals(value, data)
    }

    @Test
    fun testStringSetAsync() {
        val value = setOf("A", "B", "C", "D")
        val data = Prefs.securely().read().stringSet(Const.SAMPLE_STRING_SET_KEY_ASYNC, setOf())
        assertEquals(value, data)
    }
}