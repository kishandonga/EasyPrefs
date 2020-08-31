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
class SecurePrefsTest {

    @Before
    fun initApp() {
        Prefs.initializeApp(InstrumentationRegistry.getInstrumentation().targetContext)
    }

    @Test
    fun testString() {
        val value = "Hello..."
        assertTrue(Prefs.securely().write().string(Const.SAMPLE_STRING_KEY, value))

        val data = Prefs.securely().read().string(Const.SAMPLE_STRING_KEY, "")
        assertEquals(value, data)
    }

    @Test
    fun testStringAsync() {
        val value = "Async..."
        Prefs.securely().write().stringAsync(Const.SAMPLE_STRING_KEY_ASYNC, value)
    }

    @Test
    fun testInt() {
        val value = Int.MAX_VALUE
        assertTrue(Prefs.securely().write().int(Const.SAMPLE_INT_KEY, value))

        val data = Prefs.securely().read().int(Const.SAMPLE_INT_KEY, Int.MIN_VALUE)
        assertEquals(value, data)
    }

    @Test
    fun testIntAsync() {
        val value = Int.MAX_VALUE
        Prefs.securely().write().intAsync(Const.SAMPLE_INT_KEY_ASYNC, value)
    }

    @Test
    fun testFloat() {
        val value = Float.MAX_VALUE
        assertTrue(Prefs.securely().write().float(Const.SAMPLE_FLOAT_KEY, value))

        val data = Prefs.securely().read().float(Const.SAMPLE_FLOAT_KEY, Float.MIN_VALUE)
        assertEquals(value, data)
    }

    @Test
    fun testFloatAsync() {
        val value = Float.MAX_VALUE
        Prefs.securely().write().floatAsync(Const.SAMPLE_FLOAT_KEY_ASYNC, value)
    }

    @Test
    fun testLong() {
        val value = Long.MAX_VALUE
        assertTrue(Prefs.securely().write().long(Const.SAMPLE_LONG_KEY, value))

        val data = Prefs.securely().read().long(Const.SAMPLE_LONG_KEY, Long.MIN_VALUE)
        assertEquals(value, data)
    }

    @Test
    fun testLongAsync() {
        val value = Long.MAX_VALUE
        Prefs.securely().write().longAsync(Const.SAMPLE_LONG_KEY_ASYNC, value)
    }

    @Test
    fun testDouble() {
        val value = Double.MAX_VALUE
        assertTrue(Prefs.securely().write().double(Const.SAMPLE_DOUBLE_KEY, value))

        val data = Prefs.securely().read().double(Const.SAMPLE_DOUBLE_KEY, Double.MIN_VALUE)
        assertEquals(value.toString(), data.toString())
    }

    @Test
    fun testDoubleAsync() {
        val value = Double.MAX_VALUE
        Prefs.securely().write().doubleAsync(Const.SAMPLE_DOUBLE_KEY_ASYNC, value)
    }

    @Test
    fun testBoolean() {
        val value = false
        assertTrue(Prefs.securely().write().boolean(Const.SAMPLE_BOOLEAN_KEY, value))

        val data = Prefs.securely().read().boolean(Const.SAMPLE_BOOLEAN_KEY, true)
        assertEquals(value, data)
    }

    @Test
    fun testBooleanAsync() {
        val value = false
        Prefs.securely().write().booleanAsync(Const.SAMPLE_BOOLEAN_KEY_ASYNC, value)
    }

    @Test
    fun testStringSet() {
        val value = setOf("A", "B", "C", "D")
        assertTrue(Prefs.securely().write().stringSet(Const.SAMPLE_STRING_SET_KEY, value))

        val data = Prefs.securely().read().stringSet(Const.SAMPLE_STRING_SET_KEY, setOf())
        assertEquals(value, data)
    }

    @Test
    fun testStringSetAsync() {
        val value = setOf("A", "B", "C", "D")
        Prefs.securely().write().stringSetAsync(Const.SAMPLE_STRING_SET_KEY_ASYNC, value)
    }
}