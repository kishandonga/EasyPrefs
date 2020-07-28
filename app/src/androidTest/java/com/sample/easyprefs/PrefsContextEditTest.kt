package com.sample.easyprefs

import android.content.Context
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
class PrefsContextEditTest {

    private lateinit var context: Context

    @Before
    fun initApp() {
        //Prefs.initializeApp()
        context = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun testRemove() {
        assertTrue(Prefs.edit(context).remove(Const.SAMPLE_STRING_KEY))

        val data = Prefs.read(context).string(Const.SAMPLE_STRING_KEY, "")
        assertEquals("", data)
    }

    @Test
    fun testRemoveAsync() {
        Prefs.edit(context).removeAsync(Const.SAMPLE_STRING_KEY_ASYNC)

        val data = Prefs.read(context).string(Const.SAMPLE_STRING_KEY_ASYNC, "")
        assertEquals("", data)
    }

    @Test
    fun testClear() {
        Prefs.edit(context).clear()

        val data = Prefs.read(context).string(Const.SAMPLE_STRING_SET_KEY, "")
        assertEquals("", data)
    }

    @Test
    fun testClearAsync() {
        Prefs.edit(context).clearAsync()

        val data = Prefs.read(context).string(Const.SAMPLE_STRING_SET_KEY_ASYNC, "")
        assertEquals("", data)
    }
}