package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.b.c;
import com.google.android.play.core.b.cb;
import com.google.android.play.core.b.cd;
import com.google.android.play.core.e.p;

final class h extends c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f37205a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f37206b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f37207c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ int f37208d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ p f37209e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ s f37210f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    h(s sVar, p pVar, int i2, String str, String str2, int i3, p pVar2) {
        super(pVar);
        this.f37210f = sVar;
        this.f37205a = i2;
        this.f37206b = str;
        this.f37207c = str2;
        this.f37208d = i3;
        this.f37209e = pVar2;
    }

    public final void a() {
        try {
            ((cb) this.f37210f.f37241e.f37315e).a(this.f37210f.f37239c, s.c(this.f37205a, this.f37206b, this.f37207c, this.f37208d), s.e(), (cd) new n(this.f37210f, this.f37209e, 0));
        } catch (RemoteException unused) {
            s.f37237a.c("notifyChunkTransferred", new Object[0]);
        }
    }
}
