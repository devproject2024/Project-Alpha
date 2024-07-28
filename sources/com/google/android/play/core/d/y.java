package com.google.android.play.core.d;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.b.as;
import com.google.android.play.core.e.p;
import java.util.List;

class y<T> extends as {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f37450a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ z f37451b;

    y(z zVar, p<T> pVar) {
        this.f37451b = zVar;
        this.f37450a = pVar;
    }

    public final void a() throws RemoteException {
        this.f37451b.f37454b.a();
        z.f37452a.d("onDeferredLanguageInstall", new Object[0]);
    }

    public final void a(int i2) throws RemoteException {
        this.f37451b.f37454b.a();
        z.f37452a.d("onGetSession(%d)", Integer.valueOf(i2));
    }

    public void a(int i2, Bundle bundle) throws RemoteException {
        this.f37451b.f37454b.a();
        z.f37452a.d("onStartInstall(%d)", Integer.valueOf(i2));
    }

    public final void a(Bundle bundle) throws RemoteException {
        this.f37451b.f37454b.a();
        int i2 = bundle.getInt("error_code");
        z.f37452a.b("onError(%d)", Integer.valueOf(i2));
        this.f37450a.b((Exception) new a(i2));
    }

    public void a(List<Bundle> list) throws RemoteException {
        this.f37451b.f37454b.a();
        z.f37452a.d("onGetSessionStates", new Object[0]);
    }

    public final void b() throws RemoteException {
        this.f37451b.f37454b.a();
        z.f37452a.d("onDeferredLanguageUninstall", new Object[0]);
    }

    public final void b(int i2) throws RemoteException {
        this.f37451b.f37454b.a();
        z.f37452a.d("onCompleteInstall(%d)", Integer.valueOf(i2));
    }

    public void b(int i2, Bundle bundle) throws RemoteException {
        this.f37451b.f37454b.a();
        z.f37452a.d("onCancelInstall(%d)", Integer.valueOf(i2));
    }

    public void b(Bundle bundle) throws RemoteException {
        this.f37451b.f37454b.a();
        z.f37452a.d("onDeferredUninstall", new Object[0]);
    }

    public final void c() throws RemoteException {
        this.f37451b.f37454b.a();
        z.f37452a.d("onCompleteInstallForAppUpdate", new Object[0]);
    }

    public void c(Bundle bundle) throws RemoteException {
        this.f37451b.f37454b.a();
        z.f37452a.d("onDeferredInstall", new Object[0]);
    }

    public final void d() throws RemoteException {
        this.f37451b.f37454b.a();
        z.f37452a.d("onGetSplitsForAppUpdate", new Object[0]);
    }
}
