package kotlinx.coroutines.internal;

import kotlin.m.p;

final /* synthetic */ class SystemPropsKt__SystemProps_commonKt {
    public static final boolean systemProp(String str, boolean z) {
        String systemProp = SystemPropsKt.systemProp(str);
        return systemProp != null ? Boolean.parseBoolean(systemProp) : z;
    }

    public static /* synthetic */ int systemProp$default(String str, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i3 = 1;
        }
        if ((i5 & 8) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        return SystemPropsKt.systemProp(str, i2, i3, i4);
    }

    public static final int systemProp(String str, int i2, int i3, int i4) {
        return (int) SystemPropsKt.systemProp(str, (long) i2, (long) i3, (long) i4);
    }

    public static /* synthetic */ long systemProp$default(String str, long j, long j2, long j3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i2 & 8) != 0) {
            j3 = Long.MAX_VALUE;
        }
        return SystemPropsKt.systemProp(str, j, j4, j3);
    }

    public static final long systemProp(String str, long j, long j2, long j3) {
        String systemProp = SystemPropsKt.systemProp(str);
        if (systemProp == null) {
            return j;
        }
        Long d2 = p.d(systemProp);
        if (d2 != null) {
            long longValue = d2.longValue();
            if (j2 <= longValue && j3 >= longValue) {
                return longValue;
            }
            throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + longValue + '\'').toString());
        }
        throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + systemProp + '\'').toString());
    }
}
