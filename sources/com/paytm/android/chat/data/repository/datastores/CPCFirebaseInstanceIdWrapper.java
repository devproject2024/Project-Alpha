package com.paytm.android.chat.data.repository.datastores;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.firebase.c;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.w;
import com.paytm.android.chat.f;
import io.reactivex.rxjava3.a.y;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.h;

public final class CPCFirebaseInstanceIdWrapper implements IPCFirebaseInstanceIdWrapper {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static final kotlin.g INSTANCE$delegate = h.a(a.INSTANCE);

    public static final CPCFirebaseInstanceIdWrapper getINSTANCE() {
        return Companion.getINSTANCE();
    }

    public final y<w> getInstanceId() {
        FirebaseInstanceId a2 = FirebaseInstanceId.a();
        k.a((Object) a2, "FirebaseInstanceId.getInstance()");
        Task<w> f2 = a2.f();
        k.a((Object) f2, "FirebaseInstanceId.getInstance().instanceId");
        return f.a(f2);
    }

    public static final class Companion {
        public static /* synthetic */ void INSTANCE$annotations() {
        }

        public final CPCFirebaseInstanceIdWrapper getINSTANCE() {
            kotlin.g access$getINSTANCE$cp = CPCFirebaseInstanceIdWrapper.INSTANCE$delegate;
            Companion companion = CPCFirebaseInstanceIdWrapper.Companion;
            return (CPCFirebaseInstanceIdWrapper) access$getINSTANCE$cp.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    static final class a extends l implements kotlin.g.a.a<CPCFirebaseInstanceIdWrapper> {
        public static final a INSTANCE = new a();

        a() {
            super(0);
        }

        public final CPCFirebaseInstanceIdWrapper invoke() {
            c.a((Context) com.paytm.android.chat.c.a());
            return new CPCFirebaseInstanceIdWrapper();
        }
    }
}
