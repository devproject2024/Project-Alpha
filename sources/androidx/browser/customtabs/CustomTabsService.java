package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.app.Service;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.a.a;
import android.support.a.b;
import androidx.a.g;
import androidx.browser.customtabs.CustomTabsService;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class CustomTabsService extends Service {

    /* renamed from: a  reason: collision with root package name */
    final g<IBinder, IBinder.DeathRecipient> f1868a = new g<>();

    /* renamed from: b  reason: collision with root package name */
    private b.a f1869b = new b.a() {
        public final boolean a(long j) {
            return CustomTabsService.this.a();
        }

        public final boolean a(a aVar) {
            return a(aVar, (PendingIntent) null);
        }

        public final boolean a(a aVar, Bundle bundle) {
            return a(aVar, a(bundle));
        }

        private boolean a(a aVar, PendingIntent pendingIntent) {
            try {
                $$Lambda$CustomTabsService$1$kKupuqzt47GsD5m1zKax6oIHq4 r1 = new IBinder.DeathRecipient(new g(aVar, pendingIntent)) {
                    private final /* synthetic */ g f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void binderDied() {
                        CustomTabsService.AnonymousClass1.this.a(this.f$1);
                    }
                };
                synchronized (CustomTabsService.this.f1868a) {
                    aVar.asBinder().linkToDeath(r1, 0);
                    CustomTabsService.this.f1868a.put(aVar.asBinder(), r1);
                }
                return CustomTabsService.this.b();
            } catch (RemoteException unused) {
                return false;
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(g gVar) {
            CustomTabsService.this.a(gVar);
        }

        public final boolean a(a aVar, Uri uri, Bundle bundle, List<Bundle> list) {
            CustomTabsService customTabsService = CustomTabsService.this;
            new g(aVar, a(bundle));
            return customTabsService.c();
        }

        public final Bundle a(String str, Bundle bundle) {
            return CustomTabsService.this.d();
        }

        public final boolean b(a aVar, Bundle bundle) {
            CustomTabsService customTabsService = CustomTabsService.this;
            new g(aVar, a(bundle));
            return customTabsService.e();
        }

        public final boolean a(a aVar, Uri uri) {
            CustomTabsService customTabsService = CustomTabsService.this;
            new g(aVar, (PendingIntent) null);
            return customTabsService.f();
        }

        public final boolean a(a aVar, Uri uri, Bundle bundle) {
            CustomTabsService customTabsService = CustomTabsService.this;
            new g(aVar, a(bundle));
            return customTabsService.f();
        }

        public final int a(a aVar, String str, Bundle bundle) {
            CustomTabsService customTabsService = CustomTabsService.this;
            new g(aVar, a(bundle));
            return customTabsService.g();
        }

        public final boolean a(a aVar, int i2, Uri uri, Bundle bundle) {
            CustomTabsService customTabsService = CustomTabsService.this;
            new g(aVar, a(bundle));
            return customTabsService.h();
        }

        public final boolean a(a aVar, Uri uri, int i2, Bundle bundle) {
            CustomTabsService customTabsService = CustomTabsService.this;
            new g(aVar, a(bundle));
            return customTabsService.i();
        }

        private static PendingIntent a(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("android.support.customtabs.extra.SESSION_ID");
            bundle.remove("android.support.customtabs.extra.SESSION_ID");
            return pendingIntent;
        }
    };

    /* access modifiers changed from: protected */
    public abstract boolean a();

    /* access modifiers changed from: protected */
    public abstract boolean b();

    /* access modifiers changed from: protected */
    public abstract boolean c();

    /* access modifiers changed from: protected */
    public abstract Bundle d();

    /* access modifiers changed from: protected */
    public abstract boolean e();

    /* access modifiers changed from: protected */
    public abstract boolean f();

    /* access modifiers changed from: protected */
    public abstract int g();

    /* access modifiers changed from: protected */
    public abstract boolean h();

    /* access modifiers changed from: protected */
    public abstract boolean i();

    /* access modifiers changed from: protected */
    public final boolean a(g gVar) {
        IBinder iBinder;
        try {
            synchronized (this.f1868a) {
                if (gVar.f1917a == null) {
                    iBinder = null;
                } else {
                    iBinder = gVar.f1917a.asBinder();
                }
                if (iBinder == null) {
                    return false;
                }
                iBinder.unlinkToDeath(this.f1868a.get(iBinder), 0);
                this.f1868a.remove(iBinder);
                return true;
            }
        } catch (NoSuchElementException unused) {
            return false;
        }
    }
}
