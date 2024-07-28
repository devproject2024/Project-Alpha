package com.google.android.gms.internal.vision;

public enum hs {
    DOUBLE(hv.DOUBLE, 1),
    FLOAT(hv.FLOAT, 5),
    INT64(hv.LONG, 0),
    UINT64(hv.LONG, 0),
    INT32(hv.INT, 0),
    FIXED64(hv.LONG, 1),
    FIXED32(hv.INT, 5),
    BOOL(hv.BOOLEAN, 0),
    STRING(hv.STRING, 2),
    GROUP(hv.MESSAGE, 3),
    MESSAGE(hv.MESSAGE, 2),
    BYTES(hv.BYTE_STRING, 2),
    UINT32(hv.INT, 0),
    ENUM(hv.ENUM, 0),
    SFIXED32(hv.INT, 5),
    SFIXED64(hv.LONG, 1),
    SINT32(hv.INT, 0),
    SINT64(hv.LONG, 0);
    
    private final hv zzack;
    private final int zzacl;

    private hs(hv hvVar, int i2) {
        this.zzack = hvVar;
        this.zzacl = i2;
    }

    public final hv zzip() {
        return this.zzack;
    }

    public final int zziq() {
        return this.zzacl;
    }
}
