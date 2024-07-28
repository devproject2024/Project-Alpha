package androidx.browser.trusted;

import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.a.a.a;
import androidx.browser.trusted.i;
import androidx.core.app.k;
import java.util.Locale;

public abstract class TrustedWebActivityService extends Service {

    /* renamed from: a  reason: collision with root package name */
    NotificationManager f1921a;

    /* renamed from: b  reason: collision with root package name */
    int f1922b = -1;

    /* renamed from: c  reason: collision with root package name */
    private final a.C0007a f1923c = new a.C0007a() {
        public final Bundle a(Bundle bundle) {
            boolean z;
            d();
            i.a(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            i.c cVar = new i.c(bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
            TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
            String str = cVar.f1953a;
            trustedWebActivityService.c();
            if (!k.a((Context) trustedWebActivityService).a()) {
                z = false;
            } else if (Build.VERSION.SDK_INT < 26) {
                z = true;
            } else {
                z = a.a(trustedWebActivityService.f1921a, TrustedWebActivityService.a(str));
            }
            return new i.e(z).a();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0079, code lost:
            if (androidx.browser.trusted.a.a(r10.f1921a, r4) == false) goto L_0x0082;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final android.os.Bundle b(android.os.Bundle r10) {
            /*
                r9 = this;
                r9.d()
                java.lang.String r0 = "android.support.customtabs.trusted.PLATFORM_TAG"
                androidx.browser.trusted.i.a(r10, r0)
                java.lang.String r1 = "android.support.customtabs.trusted.PLATFORM_ID"
                androidx.browser.trusted.i.a(r10, r1)
                java.lang.String r2 = "android.support.customtabs.trusted.NOTIFICATION"
                androidx.browser.trusted.i.a(r10, r2)
                java.lang.String r3 = "android.support.customtabs.trusted.CHANNEL_NAME"
                androidx.browser.trusted.i.a(r10, r3)
                androidx.browser.trusted.i$d r4 = new androidx.browser.trusted.i$d
                java.lang.String r0 = r10.getString(r0)
                int r1 = r10.getInt(r1)
                android.os.Parcelable r2 = r10.getParcelable(r2)
                android.app.Notification r2 = (android.app.Notification) r2
                java.lang.String r10 = r10.getString(r3)
                r4.<init>(r0, r1, r2, r10)
                androidx.browser.trusted.TrustedWebActivityService r10 = androidx.browser.trusted.TrustedWebActivityService.this
                java.lang.String r0 = r4.f1954a
                int r1 = r4.f1955b
                android.app.Notification r2 = r4.f1956c
                java.lang.String r3 = r4.f1957d
                r10.c()
                androidx.core.app.k r4 = androidx.core.app.k.a((android.content.Context) r10)
                boolean r4 = r4.a()
                r5 = 0
                if (r4 != 0) goto L_0x0047
                goto L_0x0082
            L_0x0047:
                int r4 = android.os.Build.VERSION.SDK_INT
                r6 = 26
                if (r4 < r6) goto L_0x007c
                java.lang.String r4 = androidx.browser.trusted.TrustedWebActivityService.a(r3)
                android.app.NotificationManager r6 = r10.f1921a
                android.app.NotificationChannel r7 = new android.app.NotificationChannel
                r8 = 3
                r7.<init>(r4, r3, r8)
                r6.createNotificationChannel(r7)
                android.app.NotificationChannel r3 = r6.getNotificationChannel(r4)
                int r3 = r3.getImportance()
                if (r3 != 0) goto L_0x0068
                r2 = 0
                goto L_0x0073
            L_0x0068:
                android.app.Notification$Builder r2 = android.app.Notification.Builder.recoverBuilder(r10, r2)
                r2.setChannelId(r4)
                android.app.Notification r2 = r2.build()
            L_0x0073:
                android.app.NotificationManager r3 = r10.f1921a
                boolean r3 = androidx.browser.trusted.a.a(r3, r4)
                if (r3 != 0) goto L_0x007c
                goto L_0x0082
            L_0x007c:
                android.app.NotificationManager r10 = r10.f1921a
                r10.notify(r0, r1, r2)
                r5 = 1
            L_0x0082:
                androidx.browser.trusted.i$e r10 = new androidx.browser.trusted.i$e
                r10.<init>(r5)
                android.os.Bundle r10 = r10.a()
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.browser.trusted.TrustedWebActivityService.AnonymousClass1.b(android.os.Bundle):android.os.Bundle");
        }

        public final void c(Bundle bundle) {
            d();
            i.a(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            i.a(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            i.b bVar = new i.b(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"));
            TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
            String str = bVar.f1951a;
            int i2 = bVar.f1952b;
            trustedWebActivityService.c();
            trustedWebActivityService.f1921a.cancel(str, i2);
        }

        public final Bundle a() {
            d();
            TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
            trustedWebActivityService.c();
            if (Build.VERSION.SDK_INT >= 23) {
                i.a aVar = new i.a(trustedWebActivityService.f1921a.getActiveNotifications());
                Bundle bundle = new Bundle();
                bundle.putParcelableArray("android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS", aVar.f1950a);
                return bundle;
            }
            throw new IllegalStateException("onGetActiveNotifications cannot be called pre-M.");
        }

        public final int b() {
            d();
            return TrustedWebActivityService.this.a();
        }

        public final Bundle c() {
            d();
            TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
            int a2 = trustedWebActivityService.a();
            Bundle bundle = new Bundle();
            if (a2 == -1) {
                return bundle;
            }
            bundle.putParcelable("android.support.customtabs.trusted.SMALL_ICON_BITMAP", BitmapFactory.decodeResource(trustedWebActivityService.getResources(), a2));
            return bundle;
        }

        private void d() {
            if (TrustedWebActivityService.this.f1922b == -1) {
                String[] packagesForUid = TrustedWebActivityService.this.getPackageManager().getPackagesForUid(getCallingUid());
                int i2 = 0;
                if (packagesForUid == null) {
                    packagesForUid = new String[0];
                }
                c a2 = TrustedWebActivityService.this.b().a();
                PackageManager packageManager = TrustedWebActivityService.this.getPackageManager();
                if (a2 != null) {
                    int length = packagesForUid.length;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (a2.b(packagesForUid[i2], packageManager)) {
                            TrustedWebActivityService.this.f1922b = getCallingUid();
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            if (TrustedWebActivityService.this.f1922b != getCallingUid()) {
                throw new SecurityException("Caller is not verified as Trusted Web Activity provider.");
            }
        }
    };

    public abstract e b();

    public void onCreate() {
        super.onCreate();
        this.f1921a = (NotificationManager) getSystemService("notification");
    }

    public final int a() {
        try {
            ServiceInfo serviceInfo = getPackageManager().getServiceInfo(new ComponentName(this, getClass()), 128);
            if (serviceInfo.metaData == null) {
                return -1;
            }
            return serviceInfo.metaData.getInt("android.support.customtabs.trusted.SMALL_ICON", -1);
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public final IBinder onBind(Intent intent) {
        return this.f1923c;
    }

    public final boolean onUnbind(Intent intent) {
        this.f1922b = -1;
        return super.onUnbind(intent);
    }

    static String a(String str) {
        return str.toLowerCase(Locale.ROOT).replace(' ', '_') + "_channel_id";
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        if (this.f1921a == null) {
            throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
        }
    }
}
