package com.google.android.gms.internal.measurement;

public enum hh {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(cm.zza),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzj;

    private hh(Object obj) {
        this.zzj = obj;
    }
}
