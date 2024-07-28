package com.google.android.gms.internal.clearcut;

public enum eo {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(ab.zzfi),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzlj;

    private eo(Object obj) {
        this.zzlj = obj;
    }
}
