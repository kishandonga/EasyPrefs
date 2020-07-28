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
class PrefsEditFileTest {

    @Before
    fun initApp() {
        Prefs.initializeApp(InstrumentationRegistry.getInstrumentation().targetContext)
    }

    @Test
    fun testRemove() {
        assertTrue(Prefs.edit(Const.PREF_SAMPLE_FILE_2).remove(Const.SAMPLE_STRING_KEY))

        val data = Prefs.read(Const.PREF_SAMPLE_FILE_2).string(Const.SAMPLE_STRING_KEY, "")
        assertEquals("", data)
    }

    @Test
    fun testRemoveAsync() {
        Prefs.edit(Const.PREF_SAMPLE_FILE_2).removeAsync(Const.SAMPLE_STRING_KEY_ASYNC)

        val data = Prefs.read(Const.PREF_SAMPLE_FILE_2).string(Const.SAMPLE_STRING_KEY_ASYNC, "")
        assertEquals("", data)
    }

    @Test
    fun testClear() {
        Prefs.edit(Const.PREF_SAMPLE_FILE_2).clear()

        val data = Prefs.read(Const.PREF_SAMPLE_FILE_2).string(Const.SAMPLE_STRING_SET_KEY, "")
        assertEquals("", data)
    }

    @Test
    fun testClearAsync() {
        Prefs.edit(Const.PREF_SAMPLE_FILE_2).clearAsync()

        val data =
            Prefs.read(Const.PREF_SAMPLE_FILE_2).string(Const.SAMPLE_STRING_SET_KEY_ASYNC, "")
        assertEquals("", data)
    }
}