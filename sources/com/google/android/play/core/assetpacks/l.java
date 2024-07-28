package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.b.c;
import com.google.android.play.core.b.cb;
import com.google.android.play.core.e.p;

final class l extends c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f37221a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f37222b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f37223c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ int f37224d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ p f37225e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ s f37226f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    l(s sVar, p pVar, int i2, String str, String str2, int i3, p pVar2) {
        super(pVar);
        this.f37226f = sVar;
        this.f37221a = i2;
        this.f37222b = str;
        this.f37223c = str2;
        this.f37224d = i3;
        this.f37225e = pVar2;
    }

    public final void a() {
        try {
            ((cb) this.f37226f.f37241e.f37315e).d(this.f37226f.f37239c, s.c(this.f37221a, this.f37222b, this.f37223c, this.f37224d), s.e(), new o(this.f37226f, this.f37225e));
        } catch (RemoteException e2) {
            s.f37237a.b("getChunkFileDescriptor(%s, %s, %d, session=%d)", this.f37222b, this.f37223c, Integer.valueOf(this.f37224d), Integer.valueOf(this.f37221a));
            this.f37225e.b((Exception) new RuntimeException(e2));
        }
    }
}
