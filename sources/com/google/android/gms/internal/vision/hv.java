package com.google.android.gms.internal.vision;

public enum hv {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(cz.zzsd),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzya;

    private hv(Object obj) {
        this.zzya = obj;
    }
}
