package com.sample.easyprefs.kotlin.secure.has

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.sample.easyprefs.kotlin.Const
import io.easyprefs.Prefs
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
class SecurePrefsHasContextFileTest {

    private lateinit var context: Context
    private val p1 = "Hello..."

    @Before
    fun initApp() {
        context = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun test1_hasOp() {

        assertTrue(Prefs.clear(context, Const.PREF_FILE).all().commit())

        assertTrue(
            Prefs.securely().write(context, Const.PREF_FILE)
                .content(Const.STRING_KEY, p1)
                .commit()
        )

        assertTrue(
            Prefs.securely().has(context, Const.PREF_FILE)
                .key(Const.STRING_KEY)
        )
    }
}
