package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.Iterator;

final class ar extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ap f10465a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ar(ap apVar) {
        super((Handler) null);
        this.f10465a = apVar;
    }

    public final void onChange(boolean z) {
        ap apVar = this.f10465a;
        synchronized (apVar.f10456a) {
            apVar.f10457b = null;
            bd.a();
        }
        synchronized (apVar) {
            Iterator<Object> it2 = apVar.f10458c.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
    }
}
