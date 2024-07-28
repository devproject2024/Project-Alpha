package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.b.c;
import com.google.android.play.core.b.cb;
import com.google.android.play.core.e.p;
import java.util.Map;

final class g extends c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Map f37202a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ p f37203b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ s f37204c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    g(s sVar, p pVar, Map map, p pVar2) {
        super(pVar);
        this.f37204c = sVar;
        this.f37202a = map;
        this.f37203b = pVar2;
    }

    public final void a() {
        try {
            ((cb) this.f37204c.f37241e.f37315e).a(this.f37204c.f37239c, s.b(this.f37202a), new p(this.f37204c, this.f37203b));
        } catch (RemoteException e2) {
            s.f37237a.c("syncPacks", new Object[0]);
            this.f37203b.b((Exception) new RuntimeException(e2));
        }
    }
}
