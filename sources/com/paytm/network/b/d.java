package com.paytm.network.b;

import android.content.Context;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.utility.a;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.Calendar;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static int f42887a;

    /* renamed from: b  reason: collision with root package name */
    private static int f42888b;

    public static String a(Context context) {
        StringBuilder sb = new StringBuilder("");
        context.getSystemService(ContactColumn.PHONE_NUMBER);
        String f2 = a.f(context);
        if (f2 == null) {
            f2 = "";
        }
        sb.append(f2);
        sb.append(AppConstants.COLON.concat(String.valueOf(Calendar.getInstance().getTimeInMillis())));
        StringBuilder sb2 = new StringBuilder(AppConstants.COLON);
        int i2 = f42888b;
        if (i2 < 255) {
            f42888b = i2 + 1;
        } else {
            f42888b = 0;
        }
        sb2.append(Integer.toHexString(f42888b));
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder(AppConstants.COLON);
        int i3 = f42887a;
        if (i3 < 4095) {
            f42887a = i3 + 1;
        } else {
            f42887a = 0;
        }
        sb3.append(Integer.toHexString(f42887a));
        sb.append(sb3.toString());
        return sb.toString();
    }

    public static void a() {
        f42888b = 0;
    }
}
