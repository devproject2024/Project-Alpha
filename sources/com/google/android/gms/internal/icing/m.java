package com.google.android.gms.internal.icing;

import android.database.ContentObserver;
import android.os.Handler;

final class m extends ContentObserver {
    m() {
        super((Handler) null);
    }

    public final void onChange(boolean z) {
        j.f10254e.set(true);
    }
}
