package com.business.merchant_payments.common.utility;

import android.content.Context;
import com.business.merchant_payments.ups.Preferences;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.ae;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.t;

public final class MpSharedPreferences {
    public static final String WHATS_APP_NOTIFICATION_CONSENT_PREFS = "ocl.notification.merchant.whatsapp";

    public static final String getPreferenceStatus(Context context, String str) {
        APSharedPreferences instance = APSharedPreferences.getInstance();
        k.b(instance, "APSharedPreferences.getInstance()");
        List<Preferences> uPSData = instance.getUPSData();
        if (uPSData == null || !(!uPSData.isEmpty())) {
            return "false";
        }
        ArrayList arrayList = new ArrayList(kotlin.a.k.a(uPSData));
        for (Preferences preferences : uPSData) {
            arrayList.add(t.a(preferences.getKey(), preferences));
        }
        Preferences preferences2 = (Preferences) ae.a(arrayList).get(str);
        if (preferences2 != null) {
            return preferences2.getValue();
        }
        return null;
    }

    public static final boolean getWhatAppConsent(Context context) {
        if (context != null) {
            return p.a(getPreferenceStatus(context, "ocl.notification.merchant.whatsapp"), "true", false);
        }
        return false;
    }
}
