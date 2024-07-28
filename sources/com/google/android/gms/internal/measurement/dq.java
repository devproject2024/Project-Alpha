package com.google.android.gms.internal.measurement;

enum dq {
    SCALAR(false),
    VECTOR(true),
    PACKED_VECTOR(true),
    MAP(false);
    
    private final boolean zze;

    private dq(boolean z) {
        this.zze = z;
    }
}
