package com.google.firebase.appindexing.internal;

import com.google.android.gms.tasks.OnFailureListener;

final /* synthetic */ class o implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    private final l f38037a;

    o(l lVar) {
        this.f38037a = lVar;
    }

    public final void onFailure(Exception exc) {
        l lVar;
        l lVar2 = this.f38037a;
        synchronized (lVar2.f38031c.f38034c) {
            if (lVar2.f38031c.f38034c.peek() == lVar2) {
                lVar2.f38031c.f38034c.remove();
                int unused = lVar2.f38031c.f38035d = 0;
                lVar = (l) lVar2.f38031c.f38034c.peek();
            } else {
                lVar = null;
            }
        }
        lVar2.f38030b.b(exc);
        if (lVar != null) {
            lVar.a();
        }
    }
}
