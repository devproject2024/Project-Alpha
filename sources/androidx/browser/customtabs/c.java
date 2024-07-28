package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.a.a;
import android.support.a.b;
import android.text.TextUtils;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1879a;

    /* renamed from: b  reason: collision with root package name */
    private final b f1880b;

    /* renamed from: c  reason: collision with root package name */
    private final ComponentName f1881c;

    c(b bVar, ComponentName componentName, Context context) {
        this.f1880b = bVar;
        this.f1881c = componentName;
        this.f1879a = context;
    }

    public static boolean a(Context context, String str, e eVar) {
        eVar.f1910a = context.getApplicationContext();
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, eVar, 33);
    }

    public final boolean a() {
        try {
            return this.f1880b.a(0);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public final f a(final b bVar, PendingIntent pendingIntent) {
        boolean z;
        AnonymousClass1 r0 = new a.C0005a() {

            /* renamed from: c  reason: collision with root package name */
            private Handler f1884c = new Handler(Looper.getMainLooper());

            public final void a(final int i2, final Bundle bundle) {
                if (bVar != null) {
                    this.f1884c.post(new Runnable() {
                        public final void run() {
                            bVar.a(i2, bundle);
                        }
                    });
                }
            }

            public final void a(final String str, final Bundle bundle) throws RemoteException {
                if (bVar != null) {
                    this.f1884c.post(new Runnable() {
                        public final void run() {
                            bVar.a(str, bundle);
                        }
                    });
                }
            }

            public final Bundle c(String str, Bundle bundle) throws RemoteException {
                b bVar = bVar;
                if (bVar == null) {
                    return null;
                }
                return bVar.b(str, bundle);
            }

            public final void a(final Bundle bundle) throws RemoteException {
                if (bVar != null) {
                    this.f1884c.post(new Runnable() {
                        public final void run() {
                            bVar.a(bundle);
                        }
                    });
                }
            }

            public final void b(final String str, final Bundle bundle) throws RemoteException {
                if (bVar != null) {
                    this.f1884c.post(new Runnable() {
                        public final void run() {
                            bVar.c(str, bundle);
                        }
                    });
                }
            }

            public final void a(int i2, Uri uri, boolean z, Bundle bundle) throws RemoteException {
                if (bVar != null) {
                    final int i3 = i2;
                    final Uri uri2 = uri;
                    final boolean z2 = z;
                    final Bundle bundle2 = bundle;
                    this.f1884c.post(new Runnable() {
                        public final void run() {
                            bVar.a(i3, uri2, z2, bundle2);
                        }
                    });
                }
            }
        };
        if (pendingIntent != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
                z = this.f1880b.a((a) r0, bundle);
            } catch (RemoteException unused) {
                return null;
            }
        } else {
            z = this.f1880b.a((a) r0);
        }
        if (!z) {
            return null;
        }
        return new f(this.f1880b, r0, this.f1881c, pendingIntent);
    }
}
