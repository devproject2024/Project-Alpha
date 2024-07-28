package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.play.core.b.bw;
import com.google.android.play.core.b.c;
import com.google.android.play.core.e.p;

final class j extends c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f36906a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ p f36907b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ o f36908c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    j(o oVar, p pVar, String str, p pVar2) {
        super(pVar);
        this.f36908c = oVar;
        this.f36906a = str;
        this.f36907b = pVar2;
    }

    public final void a() {
        try {
            ((bw) this.f36908c.f36919b.f37315e).a(this.f36908c.f36920d, o.a(this.f36908c, this.f36906a), new n(this.f36908c, this.f36907b, this.f36906a));
        } catch (RemoteException e2) {
            o.f36917a.c("requestUpdateInfo(%s)", this.f36906a);
            this.f36907b.b((Exception) new RuntimeException(e2));
        }
    }
}
