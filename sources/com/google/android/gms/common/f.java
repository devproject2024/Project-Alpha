package com.google.android.gms.common;

import android.content.Intent;

public final class f extends k {
    private final int zzas;

    public f(int i2, String str, Intent intent) {
        super(str, intent);
        this.zzas = i2;
    }

    public final int getConnectionStatusCode() {
        return this.zzas;
    }
}
