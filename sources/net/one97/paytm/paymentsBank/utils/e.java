package net.one97.paytm.paymentsBank.utils;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class e {
    public static String a() {
        return "paytmmp://";
    }

    public static String a(String str, String str2) throws UnsupportedEncodingException {
        return a() + "add_pan?call_back_url=" + URLEncoder.encode(str, AppConstants.UTF_8) + "&vertical=" + str2 + "&form_60=false";
    }

    public static String b(String str, String str2) throws UnsupportedEncodingException {
        return a() + "add_aadhaar?call_back_url=" + URLEncoder.encode(str, AppConstants.UTF_8) + "&vertical=" + str2 + "&dbt_consent=false";
    }

    public static String c(String str, String str2) throws UnsupportedEncodingException {
        return a() + "upgrade_wallet?call_back_url=" + URLEncoder.encode(str, AppConstants.UTF_8) + "&vertical=" + str2 + "&aadhaar_otp=false&non_aadhaar=false";
    }

    public static String b() {
        return a() + "payment_bank?featuretype=bank_landing";
    }
}
