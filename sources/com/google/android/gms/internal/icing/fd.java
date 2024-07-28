package com.google.android.gms.internal.icing;

public enum fd {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(at.zzfy),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzlh;

    private fd(Object obj) {
        this.zzlh = obj;
    }
}
