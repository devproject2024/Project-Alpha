package com.google.firebase.perf.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.p001firebaseperf.v;
import com.google.android.gms.internal.p001firebaseperf.zzbg;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.a;
import com.google.firebase.perf.internal.zzs;
import com.google.firebase.perf.metrics.AppStartTrace;

public class FirebasePerfProvider extends ContentProvider {
    private static final zzbg zzhf = new zzbg();
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public static zzbg zzcw() {
        return zzhf;
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        s.a(providerInfo, (Object) "FirebasePerfProvider ProviderInfo cannot be null.");
        if (!"com.google.firebase.firebaseperfprovider".equals(providerInfo.authority)) {
            super.attachInfo(context, providerInfo);
            a.a().a(getContext());
            AppStartTrace a2 = AppStartTrace.a();
            a2.a(getContext());
            this.mHandler.post(new AppStartTrace.a(a2));
            if (zzs.c()) {
                GaugeManager.zzbh();
                return;
            }
            return;
        }
        throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
    }

    static {
        new v();
    }
}
