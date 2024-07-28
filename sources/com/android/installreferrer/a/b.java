package com.android.installreferrer.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.b.a.a;
import java.util.List;

final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    int f6381a = 0;

    /* renamed from: b  reason: collision with root package name */
    com.google.android.b.a.a f6382b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f6383c;

    /* renamed from: d  reason: collision with root package name */
    private ServiceConnection f6384d;

    public b(Context context) {
        this.f6383c = context.getApplicationContext();
    }

    public final boolean a() {
        return (this.f6381a != 2 || this.f6382b == null || this.f6384d == null) ? false : true;
    }

    public final void a(c cVar) {
        if (a()) {
            Log.isLoggable("InstallReferrerClient", 2);
            cVar.onInstallReferrerSetupFinished(0);
            return;
        }
        int i2 = this.f6381a;
        if (i2 == 1) {
            Log.isLoggable("InstallReferrerClient", 5);
            cVar.onInstallReferrerSetupFinished(3);
        } else if (i2 == 3) {
            Log.isLoggable("InstallReferrerClient", 5);
            cVar.onInstallReferrerSetupFinished(3);
        } else {
            Log.isLoggable("InstallReferrerClient", 2);
            Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
            intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
            List<ResolveInfo> queryIntentServices = this.f6383c.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                ResolveInfo resolveInfo = queryIntentServices.get(0);
                if (resolveInfo.serviceInfo != null) {
                    String str = resolveInfo.serviceInfo.packageName;
                    String str2 = resolveInfo.serviceInfo.name;
                    if (!"com.android.vending".equals(str) || str2 == null || !d()) {
                        Log.isLoggable("InstallReferrerClient", 5);
                        this.f6381a = 0;
                        cVar.onInstallReferrerSetupFinished(2);
                        return;
                    }
                    Intent intent2 = new Intent(intent);
                    this.f6384d = new a(this, cVar, (byte) 0);
                    if (this.f6383c.bindService(intent2, this.f6384d, 1)) {
                        Log.isLoggable("InstallReferrerClient", 2);
                        return;
                    }
                    Log.isLoggable("InstallReferrerClient", 5);
                    this.f6381a = 0;
                    cVar.onInstallReferrerSetupFinished(1);
                    return;
                }
            }
            this.f6381a = 0;
            Log.isLoggable("InstallReferrerClient", 2);
            cVar.onInstallReferrerSetupFinished(2);
        }
    }

    public final void b() {
        this.f6381a = 3;
        if (this.f6384d != null) {
            Log.isLoggable("InstallReferrerClient", 2);
            this.f6383c.unbindService(this.f6384d);
            this.f6384d = null;
        }
        this.f6382b = null;
    }

    public final d c() throws RemoteException {
        if (a()) {
            Bundle bundle = new Bundle();
            bundle.putString("package_name", this.f6383c.getPackageName());
            try {
                return new d(this.f6382b.a(bundle));
            } catch (RemoteException e2) {
                Log.isLoggable("InstallReferrerClient", 5);
                this.f6381a = 0;
                throw e2;
            }
        } else {
            throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
        }
    }

    private boolean d() {
        try {
            if (this.f6383c.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode >= 80837300) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    final class a implements ServiceConnection {

        /* renamed from: b  reason: collision with root package name */
        private final c f6386b;

        /* synthetic */ a(b bVar, c cVar, byte b2) {
            this(cVar);
        }

        private a(c cVar) {
            if (cVar != null) {
                this.f6386b = cVar;
                return;
            }
            throw new RuntimeException("Please specify a listener to know when setup is done.");
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.isLoggable("InstallReferrerClient", 2);
            b.this.f6382b = a.C0108a.a(iBinder);
            b.this.f6381a = 2;
            this.f6386b.onInstallReferrerSetupFinished(0);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            Log.isLoggable("InstallReferrerClient", 5);
            b bVar = b.this;
            bVar.f6382b = null;
            bVar.f6381a = 0;
            this.f6386b.onInstallReferrerServiceDisconnected();
        }
    }
}
