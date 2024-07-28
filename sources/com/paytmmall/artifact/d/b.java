package com.paytmmall.artifact.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.paytmmall.artifact.cart.entity.CJRAddress;
import com.paytmmall.artifact.cart.entity.CJRAddressList;
import com.paytmmall.artifact.e.a;

public final class b {
    public static String a(Context context) {
        CJRAddress f2 = f(context);
        if (f2 != null) {
            return f2.getPin();
        }
        return b(context);
    }

    static String b(Context context) {
        return u.a(context.getApplicationContext()).b("default_address_pincode", "", true);
    }

    public static String c(Context context) {
        CJRAddress f2 = f(context);
        if (f2 == null) {
            return "";
        }
        return f2.getCity();
    }

    public static String d(Context context) {
        try {
            if (f(context) != null) {
                if (f(context).getLocation() != null) {
                    return String.valueOf(f(context).getLocation().getLatitude());
                }
            }
            return null;
        } catch (Exception e2) {
            s.a(e2);
            return null;
        }
    }

    public static String e(Context context) {
        try {
            if (f(context) != null) {
                if (f(context).getLocation() != null) {
                    return String.valueOf(f(context).getLocation().getLongitude());
                }
            }
            return null;
        } catch (Exception e2) {
            s.a(e2);
            return null;
        }
    }

    public static CJRAddress f(Context context) {
        String b2 = u.a(context.getApplicationContext()).b("SAVE_SELECTED_ADDRESS", "", false);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        return (CJRAddress) a.a(b2, CJRAddress.class);
    }

    public static void a(Context context, CJRAddress cJRAddress) {
        u.a(context.getApplicationContext()).a("SAVE_SELECTED_ADDRESS", q.a(cJRAddress), false);
        androidx.localbroadcastmanager.a.a.a(context).a(new Intent("ACTION_UPDATE_PINCODE"));
    }

    public static void a(Context context, CJRAddressList cJRAddressList) {
        u.a(context.getApplicationContext()).a("SAVE_SELECTED_ADDRESS_LIST_RESPONSE", q.a(cJRAddressList), false);
    }
}
