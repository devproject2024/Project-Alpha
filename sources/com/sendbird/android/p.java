package com.sendbird.android;

final class p {
    static int a(Object... objArr) {
        int i2;
        int i3 = 17;
        for (Object obj : objArr) {
            int i4 = i3 * 31;
            if (obj == null) {
                i2 = 0;
            } else {
                i2 = a(obj);
            }
            i3 = i4 + i2;
        }
        return i3;
    }

    private static int a(Object obj) {
        if ((obj instanceof Integer) || (obj instanceof Character) || (obj instanceof Short) || (obj instanceof Byte)) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? 1231 : 1237;
        }
        if (obj instanceof Float) {
            return Float.floatToIntBits(((Float) obj).floatValue());
        }
        if (obj instanceof Long) {
            return a((Long) obj);
        }
        if (obj instanceof Double) {
            return a((Double) obj);
        }
        return obj.hashCode();
    }

    private static int a(Long l) {
        return (int) (l.longValue() ^ (l.longValue() >>> 32));
    }

    private static int a(Double d2) {
        return a(Long.valueOf(Double.doubleToLongBits(d2.doubleValue())));
    }
}
