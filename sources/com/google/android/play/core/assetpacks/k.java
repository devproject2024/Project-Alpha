package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.b.c;
import com.google.android.play.core.b.cb;
import com.google.android.play.core.e.p;

final class k extends c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f37218a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ p f37219b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ s f37220c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    k(s sVar, p pVar, int i2, p pVar2) {
        super(pVar);
        this.f37220c = sVar;
        this.f37218a = i2;
        this.f37219b = pVar2;
    }

    public final void a() {
        try {
            ((cb) this.f37220c.f37241e.f37315e).c(this.f37220c.f37239c, s.c(this.f37218a), s.e(), new n(this.f37220c, this.f37219b, 0));
        } catch (RemoteException unused) {
            s.f37237a.c("notifySessionFailed", new Object[0]);
        }
    }
}
