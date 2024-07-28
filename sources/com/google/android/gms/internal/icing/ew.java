package com.google.android.gms.internal.icing;

public enum ew {
    DOUBLE(fd.DOUBLE, 1),
    FLOAT(fd.FLOAT, 5),
    INT64(fd.LONG, 0),
    UINT64(fd.LONG, 0),
    INT32(fd.INT, 0),
    FIXED64(fd.LONG, 1),
    FIXED32(fd.INT, 5),
    BOOL(fd.BOOLEAN, 0),
    STRING(fd.STRING, 2),
    GROUP(fd.MESSAGE, 3),
    MESSAGE(fd.MESSAGE, 2),
    BYTES(fd.BYTE_STRING, 2),
    UINT32(fd.INT, 0),
    ENUM(fd.ENUM, 0),
    SFIXED32(fd.INT, 5),
    SFIXED64(fd.LONG, 1),
    SINT32(fd.INT, 0),
    SINT64(fd.LONG, 0);
    
    private final fd zzpq;
    private final int zzpr;

    private ew(fd fdVar, int i2) {
        this.zzpq = fdVar;
        this.zzpr = i2;
    }

    public final fd zzdu() {
        return this.zzpq;
    }

    public final int zzdv() {
        return this.zzpr;
    }
}
