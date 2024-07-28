package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.play.core.a.a;
import com.google.android.play.core.b.av;
import com.google.android.play.core.b.b;
import com.google.android.play.core.b.bw;
import com.google.android.play.core.b.l;
import com.google.android.play.core.d.as;
import com.google.android.play.core.e.e;
import com.google.android.play.core.e.g;
import java.io.File;

final class o {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public static final b f36917a = new b("AppUpdateService");

    /* renamed from: c  reason: collision with root package name */
    private static final Intent f36918c = new Intent("com.google.android.play.core.install.BIND_UPDATE_SERVICE").setPackage("com.android.vending");

    /* renamed from: b  reason: collision with root package name */
    l<bw> f36919b;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f36920d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f36921e;

    /* renamed from: f  reason: collision with root package name */
    private final p f36922f;

    public o(Context context) {
        this.f36920d = context.getPackageName();
        this.f36921e = context;
        if (av.a(context)) {
            this.f36919b = new l(as.a(context), f36917a, "AppUpdateService", f36918c, i.f36905a);
        }
        this.f36922f = new p(context);
    }

    static /* synthetic */ Bundle a(o oVar, String str) {
        Integer num;
        Bundle bundle = new Bundle();
        bundle.putAll(d());
        bundle.putString("package.name", str);
        try {
            num = Integer.valueOf(oVar.f36921e.getPackageManager().getPackageInfo(oVar.f36921e.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            f36917a.b("The current version of the app could not be retrieved", new Object[0]);
            num = null;
        }
        if (num != null) {
            bundle.putInt("app.version.code", num.intValue());
        }
        return bundle;
    }

    static <T> e<T> a() {
        f36917a.b("onError(%d)", -9);
        return g.a((Exception) new a(-9));
    }

    /* access modifiers changed from: private */
    public static Bundle d() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore.version.code", 10703);
        return bundle;
    }

    static /* synthetic */ a a(o oVar, Bundle bundle, String str) {
        Bundle bundle2 = bundle;
        return new q(str, bundle2.getInt("version.code", -1), bundle2.getInt("update.availability"), bundle2.getInt("install.status", 0), bundle2.getInt("client.version.staleness", -1) != -1 ? Integer.valueOf(bundle2.getInt("client.version.staleness")) : null, bundle2.getInt("in.app.update.priority", 0), bundle2.getLong("bytes.downloaded"), bundle2.getLong("total.bytes.to.download"), bundle2.getLong("additional.size.required"), p.a(new File(oVar.f36922f.f36923a.getFilesDir(), "assetpacks")), (PendingIntent) bundle2.getParcelable("blocking.intent"), (PendingIntent) bundle2.getParcelable("nonblocking.intent"), (PendingIntent) bundle2.getParcelable("blocking.destructive.intent"), (PendingIntent) bundle2.getParcelable("nonblocking.destructive.intent"));
    }
}
