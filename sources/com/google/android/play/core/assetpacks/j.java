package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.b.c;
import com.google.android.play.core.b.cb;
import com.google.android.play.core.e.p;

final class j extends c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f37213a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f37214b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ p f37215c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ int f37216d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ s f37217e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    j(s sVar, p pVar, int i2, String str, p pVar2, int i3) {
        super(pVar);
        this.f37217e = sVar;
        this.f37213a = i2;
        this.f37214b = str;
        this.f37215c = pVar2;
        this.f37216d = i3;
    }

    public final void a() {
        try {
            ((cb) this.f37217e.f37241e.f37315e).b(this.f37217e.f37239c, s.c(this.f37213a, this.f37214b), s.e(), new r(this.f37217e, this.f37215c, this.f37213a, this.f37214b, this.f37216d));
        } catch (RemoteException unused) {
            s.f37237a.c("notifyModuleCompleted", new Object[0]);
        }
    }
}
