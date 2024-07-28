package com.paytm.network.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.utility.a;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f42886a = "CJRAppUtility";

    public static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            a.c();
        }
    }

    public static String b(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        String str3 = null;
        if (str == null) {
            return null;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis() / 1000);
        stringBuffer.append(str2 + StringUtility.NEW_LINE + valueOf + StringUtility.NEW_LINE + str);
        a("K-MSG", String.valueOf(stringBuffer));
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(i.f42890a.getBytes(), "HmacSHA1");
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            byte[] doFinal = instance.doFinal(stringBuffer.toString().getBytes());
            String encodeToString = Base64.encodeToString(doFinal, 2);
            a("K-HMAC", "HEX:" + doFinal.toString() + "BASE64:" + encodeToString + "ENCOADED URL:" + URLEncoder.encode(encodeToString, AppConstants.UTF_8));
            str3 = str + "&timestamp=" + valueOf + "&signature=" + URLEncoder.encode(encodeToString, AppConstants.UTF_8);
            a("FinalUrl", String.valueOf(str3));
            return str3;
        } catch (InvalidKeyException e2) {
            q.b(e2.getMessage());
            return str3;
        } catch (NoSuchAlgorithmException e3) {
            q.b(e3.getMessage());
            return str3;
        } catch (IllegalStateException e4) {
            q.b(e4.getMessage());
            return str3;
        } catch (UnsupportedEncodingException e5) {
            q.b(e5.getMessage());
            return str3;
        } catch (Exception e6) {
            q.b(e6.getMessage());
            return str3;
        }
    }

    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return true;
        }
    }

    public static int a() {
        return Build.VERSION.SDK_INT;
    }
}
