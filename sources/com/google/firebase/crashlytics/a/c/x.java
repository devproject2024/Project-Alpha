package com.google.firebase.crashlytics.a.c;

import android.content.Context;

final class x {

    /* renamed from: a  reason: collision with root package name */
    private String f38328a;

    x() {
    }

    /* access modifiers changed from: package-private */
    public final synchronized String a(Context context) {
        if (this.f38328a == null) {
            String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            if (installerPackageName == null) {
                installerPackageName = "";
            }
            this.f38328a = installerPackageName;
        }
        if ("".equals(this.f38328a)) {
            return null;
        }
        return this.f38328a;
    }
}
