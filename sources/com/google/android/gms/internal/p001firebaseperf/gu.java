package com.google.android.gms.internal.p001firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.gu  reason: invalid package */
public enum gu {
    DOUBLE(gx.DOUBLE, 1),
    FLOAT(gx.FLOAT, 5),
    INT64(gx.LONG, 0),
    UINT64(gx.LONG, 0),
    INT32(gx.INT, 0),
    FIXED64(gx.LONG, 1),
    FIXED32(gx.INT, 5),
    BOOL(gx.BOOLEAN, 0),
    STRING(gx.STRING, 2),
    GROUP(gx.MESSAGE, 3),
    MESSAGE(gx.MESSAGE, 2),
    BYTES(gx.BYTE_STRING, 2),
    UINT32(gx.INT, 0),
    ENUM(gx.ENUM, 0),
    SFIXED32(gx.INT, 5),
    SFIXED64(gx.LONG, 1),
    SINT32(gx.INT, 0),
    SINT64(gx.LONG, 0);
    
    private final gx zzws;
    private final int zzwt;

    private gu(gx gxVar, int i2) {
        this.zzws = gxVar;
        this.zzwt = i2;
    }

    public final gx zzju() {
        return this.zzws;
    }

    public final int zzjv() {
        return this.zzwt;
    }
}
