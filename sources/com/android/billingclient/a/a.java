package com.android.billingclient.a;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.android.billingclient.api.g;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f30904a = Runtime.getRuntime().availableProcessors();

    public static void a(String str) {
        Log.isLoggable(str, 2);
    }

    public static void b(String str) {
        Log.isLoggable(str, 5);
    }

    public static List<g> a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        ArrayList arrayList = new ArrayList();
        if (stringArrayList == null || stringArrayList2 == null) {
            Log.isLoggable("BillingHelper", 5);
            g a2 = a(bundle.getString("INAPP_PURCHASE_DATA"), bundle.getString("INAPP_DATA_SIGNATURE"));
            if (a2 == null) {
                Log.isLoggable("BillingHelper", 5);
                return null;
            }
            arrayList.add(a2);
        } else {
            int i2 = 0;
            while (i2 < stringArrayList.size() && i2 < stringArrayList2.size()) {
                g a3 = a(stringArrayList.get(i2), stringArrayList2.get(i2));
                if (a3 != null) {
                    arrayList.add(a3);
                }
                i2++;
            }
        }
        return arrayList;
    }

    private static g a(String str, String str2) {
        if (str == null || str2 == null) {
            Log.isLoggable("BillingHelper", 5);
            return null;
        }
        try {
            return new g(str, str2);
        } catch (JSONException e2) {
            "Got JSONException while parsing purchase data: ".concat(String.valueOf(e2));
            Log.isLoggable("BillingHelper", 5);
            return null;
        }
    }

    public static int a(Intent intent, String str) {
        if (intent != null) {
            return a(intent.getExtras(), str);
        }
        Log.isLoggable("BillingHelper", 5);
        return 6;
    }

    public static int a(Bundle bundle, String str) {
        if (bundle == null) {
            Log.isLoggable(str, 5);
            return 6;
        }
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            Log.isLoggable(str, 2);
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            new StringBuilder("Unexpected type for bundle response code: ").append(obj.getClass().getName());
            Log.isLoggable(str, 5);
            return 6;
        }
    }
}
