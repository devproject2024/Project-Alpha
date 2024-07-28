package com.google.android.gms.internal.firebase_ml;

public enum n {
    DOUBLE(q.DOUBLE, 1),
    FLOAT(q.FLOAT, 5),
    INT64(q.LONG, 0),
    UINT64(q.LONG, 0),
    INT32(q.INT, 0),
    FIXED64(q.LONG, 1),
    FIXED32(q.INT, 5),
    BOOL(q.BOOLEAN, 0),
    STRING(q.STRING, 2),
    GROUP(q.MESSAGE, 3),
    MESSAGE(q.MESSAGE, 2),
    BYTES(q.BYTE_STRING, 2),
    UINT32(q.INT, 0),
    ENUM(q.ENUM, 0),
    SFIXED32(q.INT, 5),
    SFIXED64(q.LONG, 1),
    SINT32(q.INT, 0),
    SINT64(q.LONG, 0);
    
    private final q zzcrw;
    private final int zzcrx;

    private n(q qVar, int i2) {
        this.zzcrw = qVar;
        this.zzcrx = i2;
    }

    public final q zzxi() {
        return this.zzcrw;
    }

    public final int zzxj() {
        return this.zzcrx;
    }
}
