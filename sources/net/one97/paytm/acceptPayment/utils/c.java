package net.one97.paytm.acceptPayment.utils;

import android.app.Activity;
import android.os.Bundle;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import kotlin.m.d;
import net.one97.paytm.acceptPayment.configs.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f52162a = new c();

    private c() {
    }

    public static /* synthetic */ void a(Activity activity, String str, NetworkCustomError networkCustomError) {
        JSONObject jSONObject;
        k.d(activity, "activity");
        k.d(str, "targetClassName");
        k.d(networkCustomError, "networkCustomError");
        try {
            if (!(networkCustomError.networkResponse == null || networkCustomError.networkResponse.data == null)) {
                byte[] bArr = networkCustomError.networkResponse.data;
                k.b(bArr, "networkCustomError.networkResponse.data");
                jSONObject = new JSONObject(new String(bArr, d.f47971a));
                if (networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410 || (jSONObject != null && jSONObject.has(AppConstants.TRANSACTION_STATUS_ERROR) && k.a(jSONObject.get(AppConstants.TRANSACTION_STATUS_ERROR), (Object) "INVALID_TOKEN"))) {
                    a.a().b().a(activity, str, (Bundle) null);
                } else if (!activity.isFinishing()) {
                    DialogUtility.a(activity, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                    return;
                } else {
                    return;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        jSONObject = null;
        if (!(networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410)) {
        }
        a.a().b().a(activity, str, (Bundle) null);
    }
}
