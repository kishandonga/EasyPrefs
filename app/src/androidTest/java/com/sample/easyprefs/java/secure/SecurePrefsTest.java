package com.sample.easyprefs.java.secure;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashSet;
import java.util.Set;

import io.easyprefs.Prefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class SecurePrefsTest {

    private String p1 = "Hello...";
    private int p2 = Integer.MAX_VALUE;
    private float p3 = Float.MAX_VALUE;
    private long p4 = Long.MAX_VALUE;
    private double p5 = Double.MAX_VALUE;
    private boolean p6 = false;
    private Set<String> p7 = new HashSet<>();

    @Before
    public void initApp() {
        p7.add("A");
        p7.add("B");
        p7.add("C");
        p7.add("D");
        Prefs.initializeApp(InstrumentationRegistry.getInstrumentation().getTargetContext());
    }

    @Test
    public void testCommitOp() {
        assertTrue(Prefs.securely().write()
                .content(Const.SAMPLE_STRING_KEY, p1)
                .content(Const.SAMPLE_INT_KEY, p2)
                .content(Const.SAMPLE_FLOAT_KEY, p3)
                .content(Const.SAMPLE_LONG_KEY, p4)
                .content(Const.SAMPLE_DOUBLE_KEY, p5)
                .content(Const.SAMPLE_BOOLEAN_KEY, p6)
                .content(Const.SAMPLE_STRING_SET_KEY, p7)
                .commit()
        );
    }

    @Test
    public void testReadCommitOp() {

        String o1 = Prefs.securely().read().content(Const.SAMPLE_STRING_KEY, "");
        assertEquals(p1, o1);

        int o2 = Prefs.securely().read().content(Const.SAMPLE_INT_KEY, Integer.MIN_VALUE);
        assertEquals(p2, o2);

        float o3 = Prefs.securely().read().content(Const.SAMPLE_FLOAT_KEY, Float.MIN_VALUE);
        assertEquals(String.valueOf(p3), String.valueOf(o3));

        long o4 = Prefs.securely().read().content(Const.SAMPLE_LONG_KEY, Long.MIN_VALUE);
        assertEquals(p4, o4);

        double o5 = Prefs.securely().read().content(Const.SAMPLE_DOUBLE_KEY, Double.MIN_VALUE);
        assertEquals(String.valueOf(p5), String.valueOf(o5));

        boolean o6 = Prefs.securely().read().content(Const.SAMPLE_BOOLEAN_KEY, true);
        assertEquals(p6, o6);

        Set<String> o7 = Prefs.securely().read().content(Const.SAMPLE_STRING_SET_KEY, new HashSet<String>());
        assertEquals(p7, o7);
    }

    @Test
    public void testApplyOp() {
        Prefs.securely().write()
                .content(Const.SAMPLE_STRING_KEY_APPLY, p1)
                .content(Const.SAMPLE_INT_KEY_APPLY, p2)
                .content(Const.SAMPLE_FLOAT_KEY_APPLY, p3)
                .content(Const.SAMPLE_LONG_KEY_APPLY, p4)
                .content(Const.SAMPLE_DOUBLE_KEY_APPLY, p5)
                .content(Const.SAMPLE_BOOLEAN_KEY_APPLY, p6)
                .content(Const.SAMPLE_STRING_SET_KEY_APPLY, p7)
                .apply();

        String o1 = Prefs.securely().read().content(Const.SAMPLE_STRING_KEY_APPLY, "");
        assertEquals(p1, o1);

        int o2 = Prefs.securely().read().content(Const.SAMPLE_INT_KEY_APPLY, Integer.MIN_VALUE);
        assertEquals(p2, o2);

        float o3 = Prefs.securely().read().content(Const.SAMPLE_FLOAT_KEY_APPLY, Float.MIN_VALUE);
        assertEquals(String.valueOf(p3), String.valueOf(o3));

        long o4 = Prefs.securely().read().content(Const.SAMPLE_LONG_KEY_APPLY, Long.MIN_VALUE);
        assertEquals(p4, o4);

        double o5 = Prefs.securely().read().content(Const.SAMPLE_DOUBLE_KEY_APPLY, Double.MIN_VALUE);
        assertEquals(String.valueOf(p5), String.valueOf(o5));

        boolean o6 = Prefs.securely().read().content(Const.SAMPLE_BOOLEAN_KEY_APPLY, true);
        assertEquals(p6, o6);

        Set<String> o7 = Prefs.securely().read().content(Const.SAMPLE_STRING_SET_KEY_APPLY, new HashSet<String>());
        assertEquals(p7, o7);
    }
}
