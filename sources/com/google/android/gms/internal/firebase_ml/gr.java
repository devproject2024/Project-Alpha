package com.google.android.gms.internal.firebase_ml;

public enum gr {
    zzcml(Void.class, Void.class, (Class<?>) null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(fh.class, fh.class, fh.zzchp),
    ENUM(Integer.TYPE, Integer.class, (Class<?>) null),
    MESSAGE(Object.class, Object.class, (Class<?>) null);
    
    private final Class<?> zzcmv;
    private final Class<?> zzcmw;
    private final Object zzcmx;

    private gr(Class<?> cls, Class<?> cls2, Object obj) {
        this.zzcmv = cls;
        this.zzcmw = cls2;
        this.zzcmx = obj;
    }

    public final Class<?> zzvk() {
        return this.zzcmw;
    }
}
