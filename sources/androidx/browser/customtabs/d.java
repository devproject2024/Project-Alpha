package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import androidx.browser.customtabs.a;
import androidx.core.content.b;
import java.util.ArrayList;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final Intent f1901a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f1902b;

    public final void a(Context context, Uri uri) {
        this.f1901a.setData(uri);
        b.a(context, this.f1901a, this.f1902b);
    }

    d(Intent intent, Bundle bundle) {
        this.f1901a = intent;
        this.f1902b = bundle;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Intent f1903a = new Intent("android.intent.action.VIEW");

        /* renamed from: b  reason: collision with root package name */
        public final a.C0027a f1904b = new a.C0027a();

        /* renamed from: c  reason: collision with root package name */
        public SparseArray<Bundle> f1905c;

        /* renamed from: d  reason: collision with root package name */
        private ArrayList<Bundle> f1906d;

        /* renamed from: e  reason: collision with root package name */
        private Bundle f1907e;

        /* renamed from: f  reason: collision with root package name */
        private ArrayList<Bundle> f1908f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f1909g = true;

        public a() {
        }

        public a(f fVar) {
            if (fVar != null) {
                a(fVar);
            }
        }

        public final a a(f fVar) {
            this.f1903a.setPackage(fVar.f1912a.getPackageName());
            a(fVar.a(), fVar.f1913b);
            return this;
        }

        private void a(IBinder iBinder, PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            androidx.core.app.d.a(bundle, "android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.f1903a.putExtras(bundle);
        }

        public final a a(int i2) {
            this.f1904b.a(i2);
            return this;
        }

        public final a a() {
            this.f1903a.putExtra("android.support.customtabs.extra.ENABLE_URLBAR_HIDING", true);
            return this;
        }

        public final a b() {
            this.f1903a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", 1);
            return this;
        }

        public final a a(String str, PendingIntent pendingIntent) {
            if (this.f1906d == null) {
                this.f1906d = new ArrayList<>();
            }
            Bundle bundle = new Bundle();
            bundle.putString("android.support.customtabs.customaction.MENU_ITEM_TITLE", str);
            bundle.putParcelable("android.support.customtabs.customaction.PENDING_INTENT", pendingIntent);
            this.f1906d.add(bundle);
            return this;
        }

        public final d c() {
            if (!this.f1903a.hasExtra("android.support.customtabs.extra.SESSION")) {
                a((IBinder) null, (PendingIntent) null);
            }
            ArrayList<Bundle> arrayList = this.f1906d;
            if (arrayList != null) {
                this.f1903a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.f1908f;
            if (arrayList2 != null) {
                this.f1903a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f1903a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f1909g);
            this.f1903a.putExtras(this.f1904b.a().a());
            if (this.f1905c != null) {
                Bundle bundle = new Bundle();
                bundle.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f1905c);
                this.f1903a.putExtras(bundle);
            }
            return new d(this.f1903a, this.f1907e);
        }
    }

    public static a a(Intent intent, int i2) {
        Bundle bundle;
        if (i2 < 0 || i2 > 2 || i2 == 0) {
            throw new IllegalArgumentException("Invalid colorScheme: ".concat(String.valueOf(i2)));
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return a.a((Bundle) null);
        }
        a a2 = a.a(extras);
        SparseArray sparseParcelableArray = extras.getSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS");
        if (sparseParcelableArray == null || (bundle = (Bundle) sparseParcelableArray.get(i2)) == null) {
            return a2;
        }
        a a3 = a.a(bundle);
        return new a(a3.f1873a == null ? a2.f1873a : a3.f1873a, a3.f1874b == null ? a2.f1874b : a3.f1874b, a3.f1875c == null ? a2.f1875c : a3.f1875c);
    }
}
