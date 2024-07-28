package net.one97.paytm.recharge.common.utils;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.text.TextUtils;
import androidx.core.content.b;
import com.paytm.utility.q;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;

public final class ab {

    /* renamed from: a  reason: collision with root package name */
    public static String f61496a = "utility";

    /* renamed from: b  reason: collision with root package name */
    public static String f61497b = "category_id";

    public static String a(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str2);
            simpleDateFormat2.setTimeZone(TimeZone.getDefault());
            return simpleDateFormat2.format(simpleDateFormat.parse(str));
        } catch (Exception unused) {
            return str;
        }
    }

    public static String a(String str, String str2, String str3) {
        try {
            return new SimpleDateFormat(str3).format(new SimpleDateFormat(str2).parse(str));
        } catch (Exception unused) {
            return str;
        }
    }

    public static Date a(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            return simpleDateFormat.parse(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(Context context, String str) {
        Cursor query;
        String str2 = null;
        try {
            if ((Build.VERSION.SDK_INT >= 23 && b.a(context, "android.permission.READ_CONTACTS") != 0) || (query = context.getContentResolver().query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str)), new String[]{"display_name"}, (String) null, (String[]) null, (String) null)) == null) {
                return null;
            }
            if (query.getCount() > 0 && query.moveToFirst()) {
                str2 = query.getString(query.getColumnIndex("display_name"));
            }
            if (!query.isClosed()) {
                query.close();
            }
            return str2;
        } catch (Exception e2) {
            q.d(e2.getMessage());
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.contains("?")) {
            return str + "&native_withdraw=1";
        }
        return str + "?native_withdraw=1";
    }

    public static boolean a(CJRRechargePayment cJRRechargePayment) {
        return cJRRechargePayment != null && "1".equalsIgnoreCase(cJRRechargePayment.isNativeEnabled());
    }

    public static void a(CJRRechargePayment cJRRechargePayment, Intent intent) {
        if (a(cJRRechargePayment)) {
            intent.putExtra("txnToken", cJRRechargePayment.getmTxnToken());
            intent.putExtra("mid", cJRRechargePayment.getMID());
            intent.putExtra("orderid", cJRRechargePayment.getOrderId());
            intent.putExtra("nativeSdkEnabled", true);
            intent.putExtra("price", cJRRechargePayment.getTxnAmount());
            return;
        }
        intent.putExtra("nativeSdkEnabled", false);
    }
}
