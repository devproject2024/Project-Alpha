package h.a;

import com.j256.ormlite.stmt.query.SimpleComparison;

@Deprecated
public class a {
    protected a() {
    }

    public static void assertTrue(String str, boolean z) {
        if (!z) {
            fail(str);
        }
    }

    public static void assertTrue(boolean z) {
        assertTrue((String) null, z);
    }

    public static void assertFalse(String str, boolean z) {
        assertTrue(str, !z);
    }

    public static void assertFalse(boolean z) {
        assertFalse((String) null, z);
    }

    public static void fail(String str) {
        if (str == null) {
            throw new b();
        }
        throw new b(str);
    }

    public static void fail() {
        fail((String) null);
    }

    public static void assertEquals(String str, Object obj, Object obj2) {
        if (obj != null || obj2 != null) {
            if (obj == null || !obj.equals(obj2)) {
                failNotEquals(str, obj, obj2);
            }
        }
    }

    public static void assertEquals(Object obj, Object obj2) {
        assertEquals((String) null, obj, obj2);
    }

    public static void assertEquals(String str, String str2, String str3) {
        if (str2 != null || str3 != null) {
            if (str2 == null || !str2.equals(str3)) {
                if (str == null) {
                    str = "";
                }
                throw new d(str, str2, str3);
            }
        }
    }

    public static void assertEquals(String str, String str2) {
        assertEquals((String) null, str, str2);
    }

    public static void assertEquals(String str, double d2, double d3, double d4) {
        if (Double.compare(d2, d3) != 0 && Math.abs(d2 - d3) > d4) {
            failNotEquals(str, Double.valueOf(d2), Double.valueOf(d3));
        }
    }

    public static void assertEquals(double d2, double d3, double d4) {
        assertEquals((String) null, d2, d3, d4);
    }

    public static void assertEquals(String str, float f2, float f3, float f4) {
        if (Float.compare(f2, f3) != 0 && Math.abs(f2 - f3) > f4) {
            failNotEquals(str, Float.valueOf(f2), Float.valueOf(f3));
        }
    }

    public static void assertEquals(float f2, float f3, float f4) {
        assertEquals((String) null, f2, f3, f4);
    }

    public static void assertEquals(String str, long j, long j2) {
        assertEquals(str, (Object) Long.valueOf(j), (Object) Long.valueOf(j2));
    }

    public static void assertEquals(long j, long j2) {
        assertEquals((String) null, j, j2);
    }

    public static void assertEquals(String str, boolean z, boolean z2) {
        assertEquals(str, (Object) Boolean.valueOf(z), (Object) Boolean.valueOf(z2));
    }

    public static void assertEquals(boolean z, boolean z2) {
        assertEquals((String) null, z, z2);
    }

    public static void assertEquals(String str, byte b2, byte b3) {
        assertEquals(str, (Object) Byte.valueOf(b2), (Object) Byte.valueOf(b3));
    }

    public static void assertEquals(byte b2, byte b3) {
        assertEquals((String) null, b2, b3);
    }

    public static void assertEquals(String str, char c2, char c3) {
        assertEquals(str, (Object) Character.valueOf(c2), (Object) Character.valueOf(c3));
    }

    public static void assertEquals(char c2, char c3) {
        assertEquals((String) null, c2, c3);
    }

    public static void assertEquals(String str, short s, short s2) {
        assertEquals(str, (Object) Short.valueOf(s), (Object) Short.valueOf(s2));
    }

    public static void assertEquals(short s, short s2) {
        assertEquals((String) null, s, s2);
    }

    public static void assertEquals(String str, int i2, int i3) {
        assertEquals(str, (Object) Integer.valueOf(i2), (Object) Integer.valueOf(i3));
    }

    public static void assertEquals(int i2, int i3) {
        assertEquals((String) null, i2, i3);
    }

    public static void assertNotNull(Object obj) {
        assertNotNull((String) null, obj);
    }

    public static void assertNotNull(String str, Object obj) {
        assertTrue(str, obj != null);
    }

    public static void assertNull(Object obj) {
        if (obj != null) {
            assertNull("Expected: <null> but was: " + obj.toString(), obj);
        }
    }

    public static void assertNull(String str, Object obj) {
        assertTrue(str, obj == null);
    }

    public static void assertSame(String str, Object obj, Object obj2) {
        if (obj != obj2) {
            failNotSame(str, obj, obj2);
        }
    }

    public static void assertSame(Object obj, Object obj2) {
        assertSame((String) null, obj, obj2);
    }

    public static void assertNotSame(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            failSame(str);
        }
    }

    public static void assertNotSame(Object obj, Object obj2) {
        assertNotSame((String) null, obj, obj2);
    }

    public static void failSame(String str) {
        String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        fail(str2 + "expected not same");
    }

    public static void failNotSame(String str, Object obj, Object obj2) {
        String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        fail(str2 + "expected same:<" + obj + "> was not:<" + obj2 + SimpleComparison.GREATER_THAN_OPERATION);
    }

    public static void failNotEquals(String str, Object obj, Object obj2) {
        fail(format(str, obj, obj2));
    }

    public static String format(String str, Object obj, Object obj2) {
        String str2;
        if (str == null || str.length() <= 0) {
            str2 = "";
        } else {
            str2 = str + " ";
        }
        return str2 + "expected:<" + obj + "> but was:<" + obj2 + SimpleComparison.GREATER_THAN_OPERATION;
    }
}
