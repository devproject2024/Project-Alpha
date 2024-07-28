package com.google.androidbrowserhelper.trusted.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import androidx.browser.trusted.h;
import java.util.HashMap;
import java.util.Map;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, a> f37649a = new HashMap();

    d() {
    }

    /* access modifiers changed from: package-private */
    public final boolean a(Context context, String str) {
        return b(context, str).f37651b;
    }

    /* access modifiers changed from: package-private */
    public final a b(Context context, String str) {
        a aVar = this.f37649a.get(str);
        if (aVar != null) {
            return aVar;
        }
        if (com.google.androidbrowserhelper.trusted.a.a(context.getPackageManager(), str)) {
            a aVar2 = new a(true, true, (byte) 0);
            this.f37649a.put(str, aVar2);
            return aVar2;
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(new Intent().setAction("android.support.customtabs.action.CustomTabsService").setPackage(str), 64);
        a aVar3 = new a(a(resolveService, "androidx.browser.customtabs.category.NavBarColorCustomization"), a(resolveService, "androidx.browser.customtabs.category.ColorSchemeCustomization"), (byte) 0);
        this.f37649a.put(str, aVar3);
        return aVar3;
    }

    private static boolean a(ResolveInfo resolveInfo, String str) {
        return (resolveInfo == null || resolveInfo.filter == null || !resolveInfo.filter.hasCategory(str)) ? false : true;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f37650a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f37651b;

        /* synthetic */ a(boolean z, boolean z2, byte b2) {
            this(z, z2);
        }

        private a(boolean z, boolean z2) {
            this.f37650a = z;
            this.f37651b = z2;
        }
    }

    static int a(Context context, h hVar) {
        Integer num;
        Bundle extras = hVar.f1944b.c().f1901a.getExtras();
        if (extras == null) {
            num = null;
        } else {
            num = (Integer) extras.get("androidx.browser.customtabs.extra.COLOR_SCHEME");
        }
        if (num != null && num.intValue() != 0) {
            return num.intValue();
        }
        return (context.getResources().getConfiguration().uiMode & 48) == 32 ? 2 : 1;
    }
}
