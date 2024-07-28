package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.b.c;
import com.google.android.play.core.b.cb;
import com.google.android.play.core.e.p;

final class m extends c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f37227a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ s f37228b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    m(s sVar, p pVar, p pVar2) {
        super(pVar);
        this.f37228b = sVar;
        this.f37227a = pVar2;
    }

    public final void a() {
        try {
            ((cb) this.f37228b.f37242f.f37315e).b(this.f37228b.f37239c, s.e(), new q(this.f37228b, this.f37227a));
        } catch (RemoteException unused) {
            s.f37237a.c("keepAlive", new Object[0]);
        }
    }
}
