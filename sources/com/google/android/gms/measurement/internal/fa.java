package com.google.android.gms.measurement.internal;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

final /* synthetic */ class fa implements hf {

    /* renamed from: a  reason: collision with root package name */
    private final fc f11931a;

    fa(fc fcVar) {
        this.f11931a = fcVar;
    }

    public final void a(int i2, Throwable th, byte[] bArr) {
        List<ResolveInfo> queryIntentActivities;
        fc fcVar = this.f11931a;
        boolean z = true;
        if (!((i2 == 200 || i2 == 204 || i2 == 304) && th == null)) {
            fcVar.J_().f11831f.a("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th);
            return;
        }
        fcVar.b().v.a(true);
        if (bArr.length == 0) {
            fcVar.J_().j.a("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String optString = jSONObject.optString("deeplink", "");
            String optString2 = jSONObject.optString("gclid", "");
            double optDouble = jSONObject.optDouble("timestamp", 0.0d);
            if (TextUtils.isEmpty(optString)) {
                fcVar.J_().j.a("Deferred Deep Link is empty.");
                return;
            }
            jq e2 = fcVar.e();
            if (TextUtils.isEmpty(optString) || (queryIntentActivities = e2.k().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0)) == null || queryIntentActivities.isEmpty()) {
                z = false;
            }
            if (!z) {
                fcVar.J_().f11831f.a("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("gclid", optString2);
            bundle.putString("_cis", "ddp");
            fcVar.f11948h.a("auto", "_cmp", bundle);
            jq e3 = fcVar.e();
            if (!TextUtils.isEmpty(optString) && e3.a(optString, optDouble)) {
                e3.k().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
            }
        } catch (JSONException e4) {
            fcVar.J_().f11828c.a("Failed to parse the Deferred Deep Link response. exception", e4);
        }
    }
}
