package com.travel.utils;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.paytm.utility.q;
import java.util.List;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static String f28524a = "CJRTravelUtils";

    public static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str);
        } catch (JSONException e2) {
            q.c(e2.getMessage());
        }
        return jSONObject;
    }

    public static String a(String str, List<String> list) {
        if (list == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String append : list) {
            sb.append(append);
        }
        try {
            return String.format(str, new Object[]{sb.toString()});
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return sb.toString();
        }
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        return String.format(str, new Object[]{str2});
    }

    public static Spanned b(String str) {
        if (str == null) {
            return new SpannableString("");
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return Html.fromHtml(str, 0);
        }
        return Html.fromHtml(str);
    }

    public static boolean a(Context context) {
        String b2 = r.a(context.getApplicationContext()).b("sso_token=", "", true);
        if (b2 == "" || b2.length() <= 0) {
            return false;
        }
        return true;
    }

    public static Fragment c(String str) {
        Fragment fragment = null;
        try {
            Object newInstance = Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (newInstance instanceof Fragment) {
                fragment = (Fragment) newInstance;
            }
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
        return fragment == null ? new Fragment() : fragment;
    }
}
