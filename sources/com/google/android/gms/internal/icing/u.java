package com.google.android.gms.internal.icing;

import android.database.ContentObserver;
import android.os.Handler;

final class u extends ContentObserver {
    u() {
        super((Handler) null);
    }

    public final void onChange(boolean z) {
        x.a();
    }
}
