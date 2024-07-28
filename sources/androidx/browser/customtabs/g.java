package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.a.a;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    final a f1917a;

    /* renamed from: b  reason: collision with root package name */
    private final PendingIntent f1918b;

    /* renamed from: c  reason: collision with root package name */
    private final b f1919c;

    g(a aVar, PendingIntent pendingIntent) {
        if (aVar == null && pendingIntent == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        this.f1917a = aVar;
        this.f1918b = pendingIntent;
        this.f1919c = this.f1917a == null ? null : new b() {
            public final void a(int i2, Bundle bundle) {
                try {
                    g.this.f1917a.a(i2, bundle);
                } catch (RemoteException unused) {
                }
            }

            public final void a(String str, Bundle bundle) {
                try {
                    g.this.f1917a.a(str, bundle);
                } catch (RemoteException unused) {
                }
            }

            public final Bundle b(String str, Bundle bundle) {
                try {
                    return g.this.f1917a.c(str, bundle);
                } catch (RemoteException unused) {
                    return null;
                }
            }

            public final void a(Bundle bundle) {
                try {
                    g.this.f1917a.a(bundle);
                } catch (RemoteException unused) {
                }
            }

            public final void c(String str, Bundle bundle) {
                try {
                    g.this.f1917a.b(str, bundle);
                } catch (RemoteException unused) {
                }
            }

            public final void a(int i2, Uri uri, boolean z, Bundle bundle) {
                try {
                    g.this.f1917a.a(i2, uri, z, bundle);
                } catch (RemoteException unused) {
                }
            }
        };
    }

    private IBinder a() {
        a aVar = this.f1917a;
        if (aVar != null) {
            return aVar.asBinder();
        }
        throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
    }

    public final int hashCode() {
        PendingIntent pendingIntent = this.f1918b;
        if (pendingIntent != null) {
            return pendingIntent.hashCode();
        }
        return a().hashCode();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        PendingIntent pendingIntent = gVar.f1918b;
        boolean z = true;
        boolean z2 = this.f1918b == null;
        if (pendingIntent != null) {
            z = false;
        }
        if (z2 != z) {
            return false;
        }
        PendingIntent pendingIntent2 = this.f1918b;
        if (pendingIntent2 != null) {
            return pendingIntent2.equals(pendingIntent);
        }
        return a().equals(gVar.a());
    }
}
