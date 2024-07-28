package com.google.android.gms.internal.j;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.g;
import java.util.List;

public final class x extends g<i> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f10371a;

    public x(Context context, Looper looper, d dVar, e.b bVar, e.c cVar) {
        super(context, looper, 45, dVar, bVar, cVar);
        this.f10371a = context;
    }

    public final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
        return queryLocalInterface instanceof i ? (i) queryLocalInterface : new j(iBinder);
    }

    public final String a() {
        return "com.google.android.gms.safetynet.service.START";
    }

    /* access modifiers changed from: protected */
    public final String a(String str) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.f10371a.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.f10371a.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null) {
                return null;
            }
            return (String) bundle.get(str);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public final void a(g gVar, List<Integer> list, int i2, String str, String str2) throws RemoteException {
        if (str2 == null) {
            str2 = a("com.google.android.safetynet.API_KEY");
        }
        String str3 = str2;
        int[] iArr = new int[list.size()];
        for (int i3 = 0; i3 < list.size(); i3++) {
            iArr[i3] = list.get(i3).intValue();
        }
        ((i) r()).a(gVar, str3, iArr, i2, str);
    }

    public final String b() {
        return "com.google.android.gms.safetynet.internal.ISafetyNetService";
    }

    public final int e() {
        return 12200000;
    }
}
