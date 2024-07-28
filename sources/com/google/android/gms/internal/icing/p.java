package com.google.android.gms.internal.icing;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.Iterator;

final class p extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ o f10272a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    p(o oVar) {
        super((Handler) null);
        this.f10272a = oVar;
    }

    public final void onChange(boolean z) {
        o oVar = this.f10272a;
        synchronized (oVar.f10267b) {
            oVar.f10268c = null;
            x.a();
        }
        synchronized (oVar) {
            Iterator<Object> it2 = oVar.f10269d.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
    }
}
