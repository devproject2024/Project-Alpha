package net.one97.paytm.bankCommon.utils;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class a {
    public static String a() {
        return "paytmmp://";
    }

    public static String a(String str, String str2, boolean z) throws UnsupportedEncodingException {
        return a() + "add_pan?call_back_url=" + URLEncoder.encode(str, AppConstants.UTF_8) + "&vertical=" + str2 + "&form_60=" + z;
    }

    public static String a(String str, String str2) throws UnsupportedEncodingException {
        return a() + "upgrade_wallet?call_back_url=" + URLEncoder.encode(str, AppConstants.UTF_8) + "&vertical=" + str2 + "&aadhaar_otp=false&non_aadhaar=false";
    }

    public static String b() {
        return a() + "payment_bank?featuretype=bank_landing";
    }
}
