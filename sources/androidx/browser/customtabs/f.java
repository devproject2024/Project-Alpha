package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.a.a;
import android.support.a.b;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    final ComponentName f1912a;

    /* renamed from: b  reason: collision with root package name */
    final PendingIntent f1913b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f1914c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private final b f1915d;

    /* renamed from: e  reason: collision with root package name */
    private final a f1916e;

    f(b bVar, a aVar, ComponentName componentName, PendingIntent pendingIntent) {
        this.f1915d = bVar;
        this.f1916e = aVar;
        this.f1912a = componentName;
        this.f1913b = pendingIntent;
    }

    public final boolean a(Uri uri) {
        try {
            return this.f1915d.a(this.f1916e, 2, uri, b());
        } catch (RemoteException unused) {
            return false;
        }
    }

    public final boolean b(Uri uri) {
        try {
            return this.f1915d.a(this.f1916e, uri, 1, b());
        } catch (RemoteException unused) {
            return false;
        }
    }

    private Bundle b() {
        Bundle bundle = new Bundle();
        a(bundle);
        return bundle;
    }

    private void a(Bundle bundle) {
        PendingIntent pendingIntent = this.f1913b;
        if (pendingIntent != null) {
            bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
        }
    }

    /* access modifiers changed from: package-private */
    public final IBinder a() {
        return this.f1916e.asBinder();
    }
}
