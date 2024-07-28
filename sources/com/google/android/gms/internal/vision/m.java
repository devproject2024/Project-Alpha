package com.google.android.gms.internal.vision;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.Iterator;

final class m extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ l f11261a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    m(l lVar) {
        super((Handler) null);
        this.f11261a = lVar;
    }

    public final void onChange(boolean z) {
        l lVar = this.f11261a;
        synchronized (lVar.f11255a) {
            lVar.f11256b = null;
            z.a();
        }
        synchronized (lVar) {
            Iterator<Object> it2 = lVar.f11257c.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
    }
}
