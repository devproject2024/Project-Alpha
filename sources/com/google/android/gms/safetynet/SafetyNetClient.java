package com.google.android.gms.safetynet;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.a;
import com.google.android.gms.common.api.internal.r;
import com.google.android.gms.internal.j.k;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.Task;

public class SafetyNetClient extends d<Object> {
    SafetyNetClient(Activity activity) {
        super(activity, SafetyNet.API, null, (r) new a());
    }

    SafetyNetClient(Context context) {
        super(context, SafetyNet.API, null, (r) new a());
    }

    public Task<SafetyNetApi.AttestationResponse> attest(byte[] bArr, String str) {
        return com.google.android.gms.common.internal.r.a(k.a(asGoogleApiClient(), bArr, str), new SafetyNetApi.AttestationResponse());
    }

    public Task<SafetyNetApi.VerifyAppsUserResponse> enableVerifyApps() {
        return com.google.android.gms.common.internal.r.a(SafetyNet.SafetyNetApi.enableVerifyApps(asGoogleApiClient()), new SafetyNetApi.VerifyAppsUserResponse());
    }

    public Task<Void> initSafeBrowsing() {
        return doRead(new zzl(this));
    }

    public Task<SafetyNetApi.VerifyAppsUserResponse> isVerifyAppsEnabled() {
        return com.google.android.gms.common.internal.r.a(SafetyNet.SafetyNetApi.isVerifyAppsEnabled(asGoogleApiClient()), new SafetyNetApi.VerifyAppsUserResponse());
    }

    public Task<SafetyNetApi.HarmfulAppsResponse> listHarmfulApps() {
        return com.google.android.gms.common.internal.r.a(SafetyNet.SafetyNetApi.listHarmfulApps(asGoogleApiClient()), new SafetyNetApi.HarmfulAppsResponse());
    }

    public Task<SafetyNetApi.SafeBrowsingResponse> lookupUri(String str, String str2, int... iArr) {
        return com.google.android.gms.common.internal.r.a(k.a(asGoogleApiClient(), str, 3, str2, iArr), new SafetyNetApi.SafeBrowsingResponse());
    }

    public Task<Void> shutdownSafeBrowsing() {
        return doRead(new zzn(this));
    }

    public Task<SafetyNetApi.RecaptchaTokenResponse> verifyWithRecaptcha(String str) {
        return com.google.android.gms.common.internal.r.a(SafetyNet.SafetyNetApi.verifyWithRecaptcha(asGoogleApiClient(), str), new SafetyNetApi.RecaptchaTokenResponse());
    }
}
