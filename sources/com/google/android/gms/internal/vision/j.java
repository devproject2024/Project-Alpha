package com.google.android.gms.internal.vision;

import android.database.ContentObserver;
import android.os.Handler;

final class j extends ContentObserver {
    j() {
        super((Handler) null);
    }

    public final void onChange(boolean z) {
        g.f11162e.set(true);
    }
}
