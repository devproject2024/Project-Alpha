package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.play.core.b.bw;
import com.google.android.play.core.b.c;
import com.google.android.play.core.e.p;

final class k extends c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f36909a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f36910b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ o f36911c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    k(o oVar, p pVar, p pVar2, String str) {
        super(pVar);
        this.f36911c = oVar;
        this.f36909a = pVar2;
        this.f36910b = str;
    }

    public final void a() {
        try {
            ((bw) this.f36911c.f36919b.f37315e).b(this.f36911c.f36920d, o.d(), new m(this.f36911c, this.f36909a));
        } catch (RemoteException e2) {
            o.f36917a.c("completeUpdate(%s)", this.f36910b);
            this.f36909a.b((Exception) new RuntimeException(e2));
        }
    }
}
