package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.b.c;
import com.google.android.play.core.b.cb;
import com.google.android.play.core.b.cd;
import com.google.android.play.core.e.p;
import java.util.Collection;
import java.util.List;

final class f extends c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f37199a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ p f37200b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ s f37201c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    f(s sVar, p pVar, List list, p pVar2) {
        super(pVar);
        this.f37201c = sVar;
        this.f37199a = list;
        this.f37200b = pVar2;
    }

    public final void a() {
        try {
            ((cb) this.f37201c.f37241e.f37315e).a(this.f37201c.f37239c, (List<Bundle>) s.a((Collection) this.f37199a), s.e(), (cd) new n(this.f37201c, this.f37200b, (byte) 0));
        } catch (RemoteException unused) {
            s.f37237a.c("cancelDownloads(%s)", this.f37199a);
        }
    }
}
