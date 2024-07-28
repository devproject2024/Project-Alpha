package com.google.android.play.core.missingsplits;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.android.play.core.b.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class c {

    /* renamed from: a  reason: collision with root package name */
    static final b f37486a = new b("MissingSplitsAppComponentsHelper");

    /* renamed from: b  reason: collision with root package name */
    private final Context f37487b;

    /* renamed from: c  reason: collision with root package name */
    private final PackageManager f37488c;

    c(Context context, PackageManager packageManager) {
        this.f37487b = context;
        this.f37488c = packageManager;
    }

    /* access modifiers changed from: package-private */
    public final void a(List<ComponentInfo> list, int i2) {
        for (ComponentInfo next : list) {
            this.f37488c.setComponentEnabledSetting(new ComponentName(next.packageName, next.name), i2, 1);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        for (ComponentInfo next : c()) {
            if (this.f37488c.getComponentEnabledSetting(new ComponentName(next.packageName, next.name)) != 2) {
                f37486a.a("Not all non-activity components are disabled", new Object[0]);
                return false;
            }
        }
        f37486a.a("All non-activity components are disabled", new Object[0]);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        f37486a.d("Resetting enabled state of all non-activity components", new Object[0]);
        a(c(), 0);
    }

    /* access modifiers changed from: package-private */
    public final List<ComponentInfo> c() {
        try {
            ArrayList arrayList = new ArrayList();
            PackageInfo packageInfo = this.f37488c.getPackageInfo(this.f37487b.getPackageName(), 526);
            if (packageInfo.providers != null) {
                Collections.addAll(arrayList, packageInfo.providers);
            }
            if (packageInfo.receivers != null) {
                Collections.addAll(arrayList, packageInfo.receivers);
            }
            if (packageInfo.services != null) {
                Collections.addAll(arrayList, packageInfo.services);
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e2) {
            f37486a.e("Failed to resolve own package : %s", e2);
            return Collections.emptyList();
        }
    }
}
