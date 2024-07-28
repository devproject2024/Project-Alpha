package net.one97.paytm.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import kotlin.g.b.k;
import kotlin.x;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final a f69723a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static volatile e f69724c;

    /* renamed from: b  reason: collision with root package name */
    private final Context f69725b;

    private e(Context context) {
        this.f69725b = context;
    }

    public /* synthetic */ e(Context context, byte b2) {
        this(context);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final e a(Context context) {
            e a2;
            k.c(context, "context");
            e a3 = e.f69724c;
            if (a3 != null) {
                return a3;
            }
            synchronized (this) {
                a2 = e.f69724c;
                if (a2 == null) {
                    a aVar = e.f69723a;
                    a2 = new e(context, (byte) 0);
                    e.f69724c = a2;
                }
            }
            return a2;
        }
    }

    public final boolean a(String str) {
        return k.a((Object) str, (Object) b());
    }

    private final String b() {
        try {
            String packageName = this.f69725b.getPackageName();
            k.a((Object) packageName, "context.packageName");
            PackageManager packageManager = this.f69725b.getPackageManager();
            k.a((Object) packageManager, "context.packageManager");
            return packageManager.getInstallerPackageName(packageName);
        } catch (PackageManager.NameNotFoundException e2) {
            StringBuilder sb = new StringBuilder("getInstallerPackageName Exception: ");
            e2.printStackTrace();
            sb.append(x.f47997a);
            return "";
        }
    }

    public final void a(String str, String str2) {
        k.c(str, "packageName");
        k.c(str2, "marketPackageName");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=".concat(String.valueOf(str))));
            intent.setPackage(str2);
            intent.addFlags(268435456);
            this.f69725b.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            this.f69725b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=net.one97.paytm")));
        } catch (Exception e2) {
            new StringBuilder("Other error:").append(e2.getMessage());
        }
    }
}
