package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.a.a;
import com.google.android.play.core.b.b;
import com.google.android.play.core.e.p;

final class n extends l<a> {

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ o f36915d;

    /* renamed from: e  reason: collision with root package name */
    private final String f36916e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    n(o oVar, p<a> pVar, String str) {
        super(oVar, new b("OnRequestInstallCallback"), pVar);
        this.f36915d = oVar;
        this.f36916e = str;
    }

    public final void a(Bundle bundle) throws RemoteException {
        super.a(bundle);
        if (bundle.getInt("error.code", -2) != 0) {
            this.f36913b.b((Exception) new a(bundle.getInt("error.code", -2)));
        } else {
            this.f36913b.b(o.a(this.f36915d, bundle, this.f36916e));
        }
    }
}
