package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.provider.Settings;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.r;
import io.reactivex.rxjava3.a.s;
import io.reactivex.rxjava3.g.c;
import io.reactivex.rxjava3.i.a;
import java.util.TimeZone;
import java.util.UUID;
import net.one97.paytm.upi.util.UpiContract;

public class AppInstallationHelper {
    public static Object appInstallationObjectLock = new Object();
    AppInstallationModel appInstallationModel;
    /* access modifiers changed from: private */
    public AppInstallation mAppInstallationLocal;
    Preference<AppInstallation> mAppInstallationPref;
    private Context mContext;
    Preference<LoginResponse> mLoginResponse;

    public AppInstallationHelper(Context context) {
        SheroesSdk.getAppComponent(context).inject(this);
        this.mContext = context;
    }

    public void setAppInstallation(AppInstallation appInstallation) {
        this.mAppInstallationLocal = appInstallation;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setupAndSaveInstallation(boolean r4) {
        /*
            r3 = this;
            java.lang.Object r0 = appInstallationObjectLock
            monitor-enter(r0)
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference<com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallation> r1 = r3.mAppInstallationPref     // Catch:{ all -> 0x0052 }
            if (r1 == 0) goto L_0x001b
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference<com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallation> r1 = r3.mAppInstallationPref     // Catch:{ all -> 0x0052 }
            boolean r1 = r1.isSet()     // Catch:{ all -> 0x0052 }
            if (r1 != 0) goto L_0x0010
            goto L_0x001b
        L_0x0010:
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference<com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallation> r1 = r3.mAppInstallationPref     // Catch:{ all -> 0x0052 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x0052 }
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallation r1 = (com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallation) r1     // Catch:{ all -> 0x0052 }
            r3.mAppInstallationLocal = r1     // Catch:{ all -> 0x0052 }
            goto L_0x0022
        L_0x001b:
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallation r1 = new com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallation     // Catch:{ all -> 0x0052 }
            r1.<init>()     // Catch:{ all -> 0x0052 }
            r3.mAppInstallationLocal = r1     // Catch:{ all -> 0x0052 }
        L_0x0022:
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallation r1 = r3.mAppInstallationLocal     // Catch:{ all -> 0x0052 }
            java.lang.String r1 = r1.guid     // Catch:{ all -> 0x0052 }
            boolean r1 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil.isNotEmpty(r1)     // Catch:{ all -> 0x0052 }
            if (r1 != 0) goto L_0x0038
            java.util.UUID r1 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x0052 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0052 }
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallation r2 = r3.mAppInstallationLocal     // Catch:{ all -> 0x0052 }
            r2.guid = r1     // Catch:{ all -> 0x0052 }
        L_0x0038:
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference<com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallation> r1 = r3.mAppInstallationPref     // Catch:{ all -> 0x0052 }
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallation r2 = r3.mAppInstallationLocal     // Catch:{ all -> 0x0052 }
            r1.set(r2)     // Catch:{ all -> 0x0052 }
            monitor-exit(r0)     // Catch:{ all -> 0x0052 }
            if (r4 == 0) goto L_0x0047
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallation r4 = r3.mAppInstallationLocal
            r0 = 0
            r4.isLoggedOut = r0
        L_0x0047:
            android.content.Context r4 = r3.mContext
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallationHelper$1 r0 = new com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallationHelper$1
            r0.<init>()
            r3.saveInBackground(r4, r0)
            return
        L_0x0052:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0052 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallationHelper.setupAndSaveInstallation(boolean):void");
    }

    /* access modifiers changed from: private */
    public void fillDefaults() {
        fillAppAndDeviceRelatedInfo();
        fillUserId();
    }

    private void fillUserId() {
        Preference<LoginResponse> preference = this.mLoginResponse;
        if (preference != null && preference.isSet() && this.mLoginResponse.get().getUserSummary() != null && CommonUtil.isNotEmpty(Long.toString(this.mLoginResponse.get().getUserSummary().getUserId().longValue()))) {
            String l = Long.toString(this.mLoginResponse.get().getUserSummary().getUserId().longValue());
            if (CommonUtil.isNotEmpty(this.mAppInstallationLocal.userId) && !this.mAppInstallationLocal.userId.equalsIgnoreCase(l)) {
                this.mAppInstallationLocal.guid = UUID.randomUUID().toString();
            }
            this.mAppInstallationLocal.userId = l;
        }
    }

    private void fillAppAndDeviceRelatedInfo() {
        PackageInfo packageInfo = CommonUtil.getPackageInfo(SheroesSdk.getApplicationContext());
        if (packageInfo != null) {
            this.mAppInstallationLocal.appVersion = packageInfo.versionName;
            this.mAppInstallationLocal.appVersionCode = Integer.valueOf(packageInfo.versionCode);
        }
        this.mAppInstallationLocal.androidId = getDeviceId();
        this.mAppInstallationLocal.androidVersion = CommonUtil.getAndroidVersion();
        this.mAppInstallationLocal.timeZone = TimeZone.getDefault().getID();
        this.mAppInstallationLocal.deviceName = CommonUtil.getDeviceName();
        AppInstallation appInstallation = this.mAppInstallationLocal;
        appInstallation.platform = "android-sdk-paytm";
        appInstallation.deviceType = "android";
        appInstallation.locale = SheroesSdk.getApplicationContext().getResources().getConfiguration().locale.toString();
    }

    public String getDeviceId() {
        try {
            if (!CommonUtil.isNotEmpty("")) {
                return Settings.Secure.getString(SheroesSdk.getApplicationContext().getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID);
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public void saveInBackground(Context context, final CommonUtil.Callback callback) {
        p.create(new s<String>() {
            public void subscribe(r<String> rVar) {
                rVar.onNext("");
            }
        }).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a()).subscribe(new c<String>() {
            public void onComplete() {
            }

            public void onError(Throwable th) {
            }

            public void onNext(String str) {
                AppInstallationHelper.this.mAppInstallationLocal.advertisingId = str;
                AppInstallationHelper.this.fillDefaults();
                AppInstallationHelper.this.saveInstallationAsync(callback);
            }
        });
    }

    /* access modifiers changed from: private */
    public void saveInstallationAsync(final CommonUtil.Callback callback) {
        this.mAppInstallationPref.set(this.mAppInstallationLocal);
        this.appInstallationModel.getAppInstallation(this.mAppInstallationLocal).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a()).subscribe(new c<AppInstallation>() {
            public void onComplete() {
            }

            public void onError(Throwable th) {
                callback.callBack(false);
            }

            public void onNext(AppInstallation appInstallation) {
                if (appInstallation != null) {
                    callback.callBack(true);
                }
            }
        });
    }
}
