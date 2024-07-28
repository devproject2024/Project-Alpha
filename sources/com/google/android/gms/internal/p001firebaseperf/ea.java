package com.google.android.gms.internal.p001firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.ea  reason: invalid package */
public enum ea {
    zzrt(Void.class, Void.class, (Class<?>) null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(co.class, co.class, co.zznb),
    ENUM(Integer.TYPE, Integer.class, (Class<?>) null),
    MESSAGE(Object.class, Object.class, (Class<?>) null);
    
    private final Class<?> zzsd;
    private final Class<?> zzse;
    private final Object zzsf;

    private ea(Class<?> cls, Class<?> cls2, Object obj) {
        this.zzsd = cls;
        this.zzse = cls2;
        this.zzsf = obj;
    }

    public final Class<?> zzhz() {
        return this.zzse;
    }
}
