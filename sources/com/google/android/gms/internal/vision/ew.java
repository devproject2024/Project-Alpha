package com.google.android.gms.internal.vision;

public enum ew {
    zzxo(Void.class, Void.class, (Class<?>) null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(cz.class, cz.class, cz.zzsd),
    ENUM(Integer.TYPE, Integer.class, (Class<?>) null),
    MESSAGE(Object.class, Object.class, (Class<?>) null);
    
    private final Class<?> zzxy;
    private final Class<?> zzxz;
    private final Object zzya;

    private ew(Class<?> cls, Class<?> cls2, Object obj) {
        this.zzxy = cls;
        this.zzxz = cls2;
        this.zzya = obj;
    }

    public final Class<?> zzgv() {
        return this.zzxz;
    }
}
