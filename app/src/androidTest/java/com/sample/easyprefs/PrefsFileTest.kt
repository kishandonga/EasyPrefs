package com.sample.easyprefs

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
class PrefsFileTest {

    @Before
    fun initApp() {
        Prefs.initializeApp(InstrumentationRegistry.getInstrumentation().targetContext)
    }

    @Test
    fun testString() {
        val value = "Hello..."
        assertTrue(Prefs.write(Const.PREF_SAMPLE_FILE).string(Const.SAMPLE_STRING_KEY, value))

        val data = Prefs.read(Const.PREF_SAMPLE_FILE).string(Const.SAMPLE_STRING_KEY, "")
        assertEquals(value, data)
    }

    @Test
    fun testStringAsync() {
        val value = "Async..."
        Prefs.write(Const.PREF_SAMPLE_FILE).stringAsync(Const.SAMPLE_STRING_KEY_ASYNC, value)

        val data = Prefs.read(Const.PREF_SAMPLE_FILE).string(Const.SAMPLE_STRING_KEY_ASYNC, "")
        assertEquals(value, data)
    }

    @Test
    fun testInt() {
        val value = Int.MAX_VALUE
        assertTrue(Prefs.write(Const.PREF_SAMPLE_FILE).int(Const.SAMPLE_INT_KEY, value))

        val data = Prefs.read(Const.PREF_SAMPLE_FILE).int(Const.SAMPLE_INT_KEY, Int.MIN_VALUE)
        assertEquals(value, data)
    }

    @Test
    fun testIntAsync() {
        val value = Int.MAX_VALUE
        Prefs.write(Const.PREF_SAMPLE_FILE).intAsync(Const.SAMPLE_INT_KEY_ASYNC, value)

        val data = Prefs.read(Const.PREF_SAMPLE_FILE).int(Const.SAMPLE_INT_KEY_ASYNC, Int.MIN_VALUE)
        assertEquals(value, data)
    }

    @Test
    fun testFloat() {
        val value = Float.MAX_VALUE
        assertTrue(Prefs.write(Const.PREF_SAMPLE_FILE).float(Const.SAMPLE_FLOAT_KEY, value))

        val data = Prefs.read(Const.PREF_SAMPLE_FILE).float(Const.SAMPLE_FLOAT_KEY, Float.MIN_VALUE)
        assertEquals(value, data)
    }

    @Test
    fun testFloatAsync() {
        val value = Float.MAX_VALUE
        Prefs.write(Const.PREF_SAMPLE_FILE).floatAsync(Const.SAMPLE_FLOAT_KEY_ASYNC, value)

        val data =
            Prefs.read(Const.PREF_SAMPLE_FILE).float(Const.SAMPLE_FLOAT_KEY_ASYNC, Float.MIN_VALUE)
        assertEquals(value, data)
    }

    @Test
    fun testLong() {
        val value = Long.MAX_VALUE
        assertTrue(Prefs.write(Const.PREF_SAMPLE_FILE).long(Const.SAMPLE_LONG_KEY, value))

        val data = Prefs.read(Const.PREF_SAMPLE_FILE).long(Const.SAMPLE_LONG_KEY, Long.MIN_VALUE)
        assertEquals(value, data)
    }

    @Test
    fun testLongAsync() {
        val value = Long.MAX_VALUE
        Prefs.write(Const.PREF_SAMPLE_FILE).longAsync(Const.SAMPLE_LONG_KEY_ASYNC, value)

        val data =
            Prefs.read(Const.PREF_SAMPLE_FILE).long(Const.SAMPLE_LONG_KEY_ASYNC, Long.MIN_VALUE)
        assertEquals(value, data)
    }

    @Test
    fun testDouble() {
        val value = Double.MAX_VALUE
        assertTrue(Prefs.write(Const.PREF_SAMPLE_FILE).double(Const.SAMPLE_DOUBLE_KEY, value))

        val data =
            Prefs.read(Const.PREF_SAMPLE_FILE).double(Const.SAMPLE_DOUBLE_KEY, Double.MIN_VALUE)
        assertEquals(value.toString(), data.toString())
    }

    @Test
    fun testDoubleAsync() {
        val value = Double.MAX_VALUE
        Prefs.write(Const.PREF_SAMPLE_FILE).doubleAsync(Const.SAMPLE_DOUBLE_KEY_ASYNC, value)

        val data = Prefs.read(Const.PREF_SAMPLE_FILE)
            .double(Const.SAMPLE_DOUBLE_KEY_ASYNC, Double.MIN_VALUE)
        assertEquals(value.toString(), data.toString())
    }

    @Test
    fun testBoolean() {
        val value = false
        assertTrue(Prefs.write(Const.PREF_SAMPLE_FILE).boolean(Const.SAMPLE_BOOLEAN_KEY, value))

        val data = Prefs.read(Const.PREF_SAMPLE_FILE).boolean(Const.SAMPLE_BOOLEAN_KEY, true)
        assertEquals(value, data)
    }

    @Test
    fun testBooleanAsync() {
        val value = false
        Prefs.write(Const.PREF_SAMPLE_FILE).booleanAsync(Const.SAMPLE_BOOLEAN_KEY_ASYNC, value)

        val data = Prefs.read(Const.PREF_SAMPLE_FILE).boolean(Const.SAMPLE_BOOLEAN_KEY_ASYNC, true)
        assertEquals(value, data)
    }

    @Test
    fun testStringSet() {
        val value = setOf("A", "B", "C", "D")
        assertTrue(
            Prefs.write(Const.PREF_SAMPLE_FILE).stringSet(Const.SAMPLE_STRING_SET_KEY, value)
        )

        val data =
            Prefs.read(Const.PREF_SAMPLE_FILE).stringSet(Const.SAMPLE_STRING_SET_KEY, setOf())
        assertEquals(value, data)
    }

    @Test
    fun testStringSetAsync() {
        val value = setOf("A", "B", "C", "D")
        Prefs.write(Const.PREF_SAMPLE_FILE).stringSetAsync(Const.SAMPLE_STRING_SET_KEY_ASYNC, value)

        val data =
            Prefs.read(Const.PREF_SAMPLE_FILE).stringSet(Const.SAMPLE_STRING_SET_KEY_ASYNC, setOf())
        assertEquals(value, data)
    }
}