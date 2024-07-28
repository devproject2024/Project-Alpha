package com.google.android.gms.internal.icing;

enum bt {
    SCALAR(false),
    VECTOR(true),
    PACKED_VECTOR(true),
    MAP(false);
    
    private final boolean zzjp;

    private bt(boolean z) {
        this.zzjp = z;
    }
}
