package com.google.android.gms.internal.measurement;

public enum he {
    DOUBLE(hh.DOUBLE, 1),
    FLOAT(hh.FLOAT, 5),
    INT64(hh.LONG, 0),
    UINT64(hh.LONG, 0),
    INT32(hh.INT, 0),
    FIXED64(hh.LONG, 1),
    FIXED32(hh.INT, 5),
    BOOL(hh.BOOLEAN, 0),
    STRING(hh.STRING, 2),
    GROUP(hh.MESSAGE, 3),
    MESSAGE(hh.MESSAGE, 2),
    BYTES(hh.BYTE_STRING, 2),
    UINT32(hh.INT, 0),
    ENUM(hh.ENUM, 0),
    SFIXED32(hh.INT, 5),
    SFIXED64(hh.LONG, 1),
    SINT32(hh.INT, 0),
    SINT64(hh.LONG, 0);
    
    private final hh zzs;
    private final int zzt;

    private he(hh hhVar, int i2) {
        this.zzs = hhVar;
        this.zzt = i2;
    }

    public final hh zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }
}
