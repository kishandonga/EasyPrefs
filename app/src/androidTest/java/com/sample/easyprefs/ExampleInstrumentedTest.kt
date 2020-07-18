package com.sample.easyprefs

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import io.easyprefs.Prefs
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Before
    fun initApp() {
        Prefs.initializeApp(InstrumentationRegistry.getInstrumentation().targetContext)
    }

    @Test
    fun testString() {
        val value = "Hello..."
        val out = Prefs.write().string(Const.SAMPLE_STRING_KEY, value)
        assertEquals(true, out)

        val data = Prefs.read().string(Const.SAMPLE_STRING_KEY, "")
        assertEquals(value, data)
    }

    @Test
    fun testStringAsync() {
        val value = "Async..."
        Prefs.write().stringAsync(Const.SAMPLE_STRING_KEY_ASYNC, value)

        val data = Prefs.read().string(Const.SAMPLE_STRING_KEY_ASYNC, "")
        assertEquals(value, data)
    }

    @Test
    fun testInt() {
        val value = Int.MAX_VALUE
        val out = Prefs.write().int(Const.SAMPLE_INT_KEY, value)
        assertEquals(true, out)

        val data = Prefs.read().int(Const.SAMPLE_INT_KEY, Int.MIN_VALUE)
        assertEquals(value, data)
    }

    @Test
    fun testIntAsync() {
        val value = Int.MAX_VALUE
        Prefs.write().intAsync(Const.SAMPLE_INT_KEY_ASYNC, value)

        val data = Prefs.read().int(Const.SAMPLE_INT_KEY_ASYNC, Int.MIN_VALUE)
        assertEquals(value, data)
    }

    @Test
    fun testFloat() {
        val value = Float.MAX_VALUE
        val out = Prefs.write().float(Const.SAMPLE_FLOAT_KEY, value)
        assertEquals(true, out)

        val data = Prefs.read().float(Const.SAMPLE_FLOAT_KEY, Float.MIN_VALUE)
        assertEquals(value, data)
    }

    @Test
    fun testFloatAsync() {
        val value = Float.MAX_VALUE
        Prefs.write().floatAsync(Const.SAMPLE_FLOAT_KEY_ASYNC, value)

        val data = Prefs.read().float(Const.SAMPLE_FLOAT_KEY_ASYNC, Float.MIN_VALUE)
        assertEquals(value, data)
    }
}