package com.google.android.gms.internal.clearcut;

public enum ej {
    DOUBLE(eo.DOUBLE, 1),
    FLOAT(eo.FLOAT, 5),
    INT64(eo.LONG, 0),
    UINT64(eo.LONG, 0),
    INT32(eo.INT, 0),
    FIXED64(eo.LONG, 1),
    FIXED32(eo.INT, 5),
    BOOL(eo.BOOLEAN, 0),
    STRING(eo.STRING, 2),
    GROUP(eo.MESSAGE, 3),
    MESSAGE(eo.MESSAGE, 2),
    BYTES(eo.BYTE_STRING, 2),
    UINT32(eo.INT, 0),
    ENUM(eo.ENUM, 0),
    SFIXED32(eo.INT, 5),
    SFIXED64(eo.LONG, 1),
    SINT32(eo.INT, 0),
    SINT64(eo.LONG, 0);
    
    private final eo zzqu;
    private final int zzqv;

    private ej(eo eoVar, int i2) {
        this.zzqu = eoVar;
        this.zzqv = i2;
    }

    public final eo zzek() {
        return this.zzqu;
    }

    public final int zzel() {
        return this.zzqv;
    }
}
