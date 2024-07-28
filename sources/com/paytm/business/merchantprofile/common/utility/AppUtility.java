package com.paytm.business.merchantprofile.common.utility;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.TypedValue;
import androidx.core.content.b;
import com.alipay.mobile.h5container.api.H5Param;
import com.business.common_module.utilities.CustomTypeFaceSpan;
import com.google.android.gms.common.g;
import com.paytm.business.merchantprofile.ProfileConfig;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.common.ProfileGTMConstants;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.business.merchantprofile.model.AddressDetailsModel;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.model.NetworkCustomError;
import easypay.manager.Constants;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class AppUtility {
    public static final String CENTER_DOT = ProfileConfig.getInstance().getApplication().getApplicationContext().getResources().getString(R.string.pr_sbl_bullet);
    public static final String FOUR_CENTER_DOT = (CENTER_DOT + CENTER_DOT + CENTER_DOT + CENTER_DOT);
    public static final Map<String, Integer> LANG_ID_MAP = new HashMap<String, Integer>() {
        {
            put("en", 1);
            put("ml", 6);
            put("te", 9);
            put("ta", 8);
            put("or", 4);
            put("mr", 5);
            put("gu", 10);
            put("pa", 11);
            put("bn", 3);
            put("hi", 2);
            put("kn", 7);
            put(CLConstants.DEFAULT_LANGUAGE_PREFERENCE, 1);
        }
    };
    public static final String RUPEE_SYMBOL = ProfileConfig.getInstance().getAppContext().getString(R.string.pr_rupee_symbol);
    public static final String TAG = "APPUTILITY";
    public static String mVersion;

    public static int getOSVersion() {
        return Build.VERSION.SDK_INT;
    }

    public static String getDecimalUpto(double d2, int i2) {
        try {
            return String.format("%." + i2 + "f", new Object[]{Double.valueOf(d2)});
        } catch (Exception unused) {
            return String.valueOf(d2);
        }
    }

    public static String getClient() {
        return AppConstants.KeyValues.APP_CLIENT;
    }

    public static String getSimSerialNumber(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(ContactColumn.PHONE_NUMBER);
            if (telephonyManager == null || b.a(context, "android.permission.READ_PHONE_STATE") != 0) {
                return null;
            }
            return telephonyManager.getSimSerialNumber();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getOSReleaseVersion() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getVersion(Context context) {
        try {
            if (mVersion == null) {
                mVersion = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        return mVersion;
    }

    public static boolean isGooglePlayServicesAvailable(Context context) {
        try {
            return g.a(context) == 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean hasGPSDevice(Context context) {
        List<String> allProviders;
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (locationManager == null || (allProviders = locationManager.getAllProviders()) == null) {
                return false;
            }
            return allProviders.contains("gps");
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static String formatNumber(double d2, String str) {
        try {
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
            decimalFormat.applyPattern(str);
            decimalFormat.setMaximumFractionDigits(2);
            decimalFormat.setMinimumFractionDigits(2);
            return decimalFormat.format(d2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String formatDecimalIntegerNumber(double d2, String str) {
        String str2;
        try {
            NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.US);
            ((DecimalFormat) numberInstance).applyPattern(str);
            numberInstance.setMaximumFractionDigits(2);
            String valueOf = String.valueOf(d2);
            int indexOf = valueOf.indexOf(com.business.merchant_payments.common.utility.AppUtility.CENTER_DOT);
            if (indexOf >= 0) {
                str2 = valueOf.substring(indexOf + 1);
            } else {
                str2 = "";
            }
            try {
                if (Integer.parseInt(str2) <= 0) {
                    return String.valueOf((int) d2);
                }
                numberInstance.setMinimumFractionDigits(2);
                return numberInstance.format(d2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }

    public static String formatDecimalIntegerNumber(String str) {
        try {
            NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.US);
            numberInstance.setMaximumFractionDigits(2);
            String valueOf = String.valueOf(str);
            int indexOf = valueOf.indexOf(com.business.merchant_payments.common.utility.AppUtility.CENTER_DOT);
            try {
                if (Integer.parseInt(indexOf >= 0 ? valueOf.substring(indexOf + 1) : "") <= 0) {
                    return String.valueOf((int) Float.parseFloat(str));
                }
                numberInstance.setMinimumFractionDigits(2);
                return numberInstance.format(str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            return str;
        }
    }

    public static BigDecimal getBigDecimalValue(double d2) {
        return new BigDecimal(d2);
    }

    public static SpannableString formattedPrice(String str, Context context) {
        try {
            if (!str.contains(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA) && !str.contains("null")) {
                boolean contains = str.contains(context.getString(R.string.pr_rupee_symbol));
                String substring = str.substring(findIndexOfFirstDigit(str));
                String substring2 = str.substring(0, findIndexOfFirstDigit(str));
                DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
                decimalFormat.applyPattern("##,##,##,##,##,##,##,##,##,##0.00");
                String format = decimalFormat.format(Double.valueOf(substring));
                if (contains) {
                    str = substring2 + format;
                } else {
                    str = format;
                }
            }
            if (!TextUtils.isEmpty(str)) {
                SpannableString spannableString = new SpannableString(str);
                CustomTypeFaceSpan customTypeFaceSpan = new CustomTypeFaceSpan("", Typeface.DEFAULT);
                int indexOf = str.indexOf(com.business.merchant_payments.common.utility.AppUtility.CENTER_DOT);
                if (indexOf >= 0) {
                    try {
                        spannableString.setSpan(customTypeFaceSpan, indexOf + 1, str.length(), 18);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                return spannableString;
            }
        } catch (NumberFormatException e3) {
            e3.printStackTrace();
        }
        return new SpannableString("");
    }

    public static String getFormattedPrice(String str, Context context) {
        try {
            if (!str.contains(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA) && !str.contains("null")) {
                boolean contains = str.contains(context.getString(R.string.pr_rupee_symbol));
                String substring = str.substring(findIndexOfFirstDigit(str));
                String substring2 = str.substring(0, findIndexOfFirstDigit(str));
                DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
                decimalFormat.applyPattern("##,##,##,##,##,##,##,##,##,##0.00");
                String format = decimalFormat.format(Double.valueOf(substring));
                if (contains) {
                    str = substring2 + format;
                } else {
                    str = format;
                }
            }
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            return "0.00";
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return "0.00";
        }
    }

    public static SpannableString formattedPriceWithColor(String str, Context context, int i2) {
        if (!str.contains(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA) && !str.contains("null")) {
            boolean contains = str.contains(context.getString(R.string.pr_rupee_symbol));
            String substring = str.substring(findIndexOfFirstDigit(str));
            String substring2 = str.substring(0, findIndexOfFirstDigit(str));
            String format = new DecimalFormat("##,##,##,##,##,##,##,##,##,##0.00").format(Double.valueOf(substring));
            if (contains) {
                str = substring2 + format;
            } else {
                str = format;
            }
        }
        if (TextUtils.isEmpty(str)) {
            return new SpannableString("");
        }
        SpannableString spannableString = new SpannableString(str);
        CustomTypeFaceSpan customTypeFaceSpan = new CustomTypeFaceSpan("", Typeface.create("sans-serif-light", 0));
        int indexOf = str.indexOf(com.business.merchant_payments.common.utility.AppUtility.CENTER_DOT);
        if (indexOf >= 0) {
            try {
                int i3 = indexOf + 1;
                spannableString.setSpan(new ForegroundColorSpan(b.c(context, i2)), i3, str.length(), 18);
                spannableString.setSpan(customTypeFaceSpan, i3, str.length(), 18);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return spannableString;
    }

    public static String addDecimal(String str) {
        if (str == null || str.contains(com.business.merchant_payments.common.utility.AppUtility.CENTER_DOT)) {
            return str;
        }
        return str.concat(".00");
    }

    public static boolean isPlayStoreInstall(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            String installerPackageName = packageManager.getInstallerPackageName(context.getPackageName());
            if (!TextUtils.isEmpty(installerPackageName)) {
                return "com.android.vending".equalsIgnoreCase(installerPackageName);
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static String getOtpFromSms(String str, String str2) {
        if (!(str == null || str2 == null)) {
            try {
                if (str.toLowerCase().contains("paytm")) {
                    Matcher matcher = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)").matcher(str2);
                    if (matcher.find()) {
                        return matcher.group();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static String getDeviceName() {
        String str = Build.MODEL;
        if (str == null) {
            return "";
        }
        String replaceAll = str.replaceAll(" ", "_");
        try {
            return URLEncoder.encode(replaceAll, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return replaceAll;
        }
    }

    public static String getDeviceManufacturer() {
        String str = Build.MANUFACTURER;
        if (str == null) {
            return "";
        }
        String replaceAll = str.replaceAll(" ", "_");
        try {
            return URLEncoder.encode(replaceAll, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return replaceAll;
        }
    }

    public static String getFormattedAccountNumber(String str) {
        if (str == null || str.length() < 4) {
            return null;
        }
        return "(Ac. no.- " + FOUR_CENTER_DOT + FOUR_CENTER_DOT + str.substring(str.length() - 4) + ")";
    }

    public static String getMaskedMobileNumber(String str) {
        if ((str != null && (str.contains("*") || str.contains("X") || str.contains("x") || str.contains(CENTER_DOT))) || str == null || str.length() <= 6) {
            return str;
        }
        return str.substring(0, 2) + FOUR_CENTER_DOT + str.substring(str.length() - 4);
    }

    public static String getDotMaskedReplacedString(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '*' || charAt == 'X' || charAt == 'x') {
                charAt = CENTER_DOT.charAt(0);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static boolean isNonEmptyString(String str) {
        return str != null && str.trim().length() > 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDisplayPaymentMode(android.content.Context r6, java.lang.String r7) {
        /*
            java.lang.String r0 = r7.toUpperCase()
            java.lang.String r0 = r0.trim()
            int r1 = r0.hashCode()
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 2144(0x860, float:3.004E-42)
            if (r1 == r5) goto L_0x003e
            r5 = 2175(0x87f, float:3.048E-42)
            if (r1 == r5) goto L_0x0034
            r5 = 2484(0x9b4, float:3.481E-42)
            if (r1 == r5) goto L_0x002a
            r5 = 79433(0x13649, float:1.1131E-40)
            if (r1 != r5) goto L_0x0048
            java.lang.String r1 = "PPI"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0048
            r0 = 0
            goto L_0x0049
        L_0x002a:
            java.lang.String r1 = "NB"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0048
            r0 = 1
            goto L_0x0049
        L_0x0034:
            java.lang.String r1 = "DC"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0048
            r0 = 3
            goto L_0x0049
        L_0x003e:
            java.lang.String r1 = "CC"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0048
            r0 = 2
            goto L_0x0049
        L_0x0048:
            r0 = -1
        L_0x0049:
            if (r0 == 0) goto L_0x0067
            if (r0 == r4) goto L_0x0060
            if (r0 == r3) goto L_0x0059
            if (r0 == r2) goto L_0x0052
            goto L_0x006d
        L_0x0052:
            int r7 = com.paytm.business.merchantprofile.R.string.pr_lbl_debit_card
            java.lang.String r7 = r6.getString(r7)
            goto L_0x006d
        L_0x0059:
            int r7 = com.paytm.business.merchantprofile.R.string.pr_lbl_credit_card
            java.lang.String r7 = r6.getString(r7)
            goto L_0x006d
        L_0x0060:
            int r7 = com.paytm.business.merchantprofile.R.string.pr_lbl_net_banking
            java.lang.String r7 = r6.getString(r7)
            goto L_0x006d
        L_0x0067:
            int r7 = com.paytm.business.merchantprofile.R.string.pr_lbl_paytm_wallet
            java.lang.String r7 = r6.getString(r7)
        L_0x006d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.common.utility.AppUtility.getDisplayPaymentMode(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String getPayMode(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String upperCase = str.trim().toUpperCase();
        char c2 = 65535;
        switch (upperCase.hashCode()) {
            case -2013743940:
                if (upperCase.equals("MP_COD")) {
                    c2 = 11;
                    break;
                }
                break;
            case -1693145316:
                if (upperCase.equals("LOYALTY_POINTS")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1299054941:
                if (upperCase.equals("HYBRID_PAYMENT")) {
                    c2 = 20;
                    break;
                }
                break;
            case -250353122:
                if (upperCase.equals("PAYTM_DIGITAL_CREDIT")) {
                    c2 = 21;
                    break;
                }
                break;
            case -157615350:
                if (upperCase.equals("WITHDRAW")) {
                    c2 = 12;
                    break;
                }
                break;
            case 2144:
                if (upperCase.equals(Constants.EASYPAY_PAYTYPE_CREDIT_CARD)) {
                    c2 = 2;
                    break;
                }
                break;
            case 2175:
                if (upperCase.equals(Constants.EASYPAY_PAYTYPE_DEBIT_CARD)) {
                    c2 = 3;
                    break;
                }
                break;
            case 2484:
                if (upperCase.equals("NB")) {
                    c2 = 4;
                    break;
                }
                break;
            case 2593:
                if (upperCase.equals(CJRQRScanResultModel.REQ_TYPE)) {
                    c2 = 23;
                    break;
                }
                break;
            case 65146:
                if (upperCase.equals("ATM")) {
                    c2 = 6;
                    break;
                }
                break;
            case 68769:
                if (upperCase.equals("EMI")) {
                    c2 = 7;
                    break;
                }
                break;
            case 79433:
                if (upperCase.equals("PPI")) {
                    c2 = 5;
                    break;
                }
                break;
            case 84238:
                if (upperCase.equals("UPI")) {
                    c2 = 8;
                    break;
                }
                break;
            case 2251303:
                if (upperCase.equals("IMPS")) {
                    c2 = 9;
                    break;
                }
                break;
            case 2462282:
                if (upperCase.equals(SDKConstants.AI_KEY_PPBL)) {
                    c2 = 10;
                    break;
                }
                break;
            case 295748685:
                if (upperCase.equals("BANK_EXPRESS")) {
                    c2 = 17;
                    break;
                }
                break;
            case 378796732:
                if (upperCase.equals("BALANCE")) {
                    c2 = 1;
                    break;
                }
                break;
            case 499571735:
                if (upperCase.equals("LOYALTY_POINT")) {
                    c2 = 19;
                    break;
                }
                break;
            case 891952512:
                if (upperCase.equals("PREPAID_CARD")) {
                    c2 = 18;
                    break;
                }
                break;
            case 1280945827:
                if (upperCase.equals(SDKConstants.DEBIT)) {
                    c2 = 13;
                    break;
                }
                break;
            case 1310753099:
                if (upperCase.equals("QR_CODE")) {
                    c2 = 22;
                    break;
                }
                break;
            case 1484795270:
                if (upperCase.equals("MOBILE_NUMBER")) {
                    c2 = 24;
                    break;
                }
                break;
            case 1615521458:
                if (upperCase.equals("CASH_COUPON")) {
                    c2 = 16;
                    break;
                }
                break;
            case 1878720662:
                if (upperCase.equals(SDKConstants.CREDIT)) {
                    c2 = 15;
                    break;
                }
                break;
            case 2134027076:
                if (upperCase.equals("NET_BANKING")) {
                    c2 = 14;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return "Paytm Loyalty Points";
            case 1:
            case 5:
            case 18:
            case 22:
            case 23:
            case 24:
                return "Paytm Wallet";
            case 2:
            case 15:
                return "Credit Card";
            case 3:
            case 13:
                return "Debit Card";
            case 4:
            case 14:
                return "Net Banking";
            case 6:
                return "ATM Card";
            case 7:
                return "EMI";
            case 8:
                return "UPI";
            case 9:
                return "IMPS";
            case 10:
                return "Paytm Payments Bank Account";
            case 11:
                return "Cash on Delivery";
            case 12:
                return "Withdraw";
            case 16:
                return "Cash Coupon";
            case 17:
                return "Bank Express";
            case 19:
                return "Loyalty Points";
            case 20:
                return "Hybrid Payment";
            case 21:
                return "Paytm Postpaid";
            default:
                return str;
        }
    }

    public static String getPayModeLocalised(Context context, String str) {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        String upperCase = str.trim().toUpperCase();
        char c2 = 65535;
        switch (upperCase.hashCode()) {
            case -2127120020:
                if (upperCase.equals("BANK EXPRESS")) {
                    c2 = 17;
                    break;
                }
                break;
            case -2013743940:
                if (upperCase.equals("MP_COD")) {
                    c2 = 11;
                    break;
                }
                break;
            case -1693145316:
                if (upperCase.equals("LOYALTY_POINTS")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1304064778:
                if (upperCase.equals("LOYALTY POINT")) {
                    c2 = 20;
                    break;
                }
                break;
            case -814993632:
                if (upperCase.equals("PAYTM DIGITAL CREDIT")) {
                    c2 = 22;
                    break;
                }
                break;
            case -288841629:
                if (upperCase.equals(SDKConstants.AI_KEY_NB)) {
                    c2 = 14;
                    break;
                }
                break;
            case -157615350:
                if (upperCase.equals("WITHDRAW")) {
                    c2 = 12;
                    break;
                }
                break;
            case 2144:
                if (upperCase.equals(Constants.EASYPAY_PAYTYPE_CREDIT_CARD)) {
                    c2 = 2;
                    break;
                }
                break;
            case 2175:
                if (upperCase.equals(Constants.EASYPAY_PAYTYPE_DEBIT_CARD)) {
                    c2 = 3;
                    break;
                }
                break;
            case 2484:
                if (upperCase.equals("NB")) {
                    c2 = 4;
                    break;
                }
                break;
            case 2593:
                if (upperCase.equals(CJRQRScanResultModel.REQ_TYPE)) {
                    c2 = 24;
                    break;
                }
                break;
            case 65146:
                if (upperCase.equals("ATM")) {
                    c2 = 6;
                    break;
                }
                break;
            case 68769:
                if (upperCase.equals("EMI")) {
                    c2 = 7;
                    break;
                }
                break;
            case 79433:
                if (upperCase.equals("PPI")) {
                    c2 = 5;
                    break;
                }
                break;
            case 84238:
                if (upperCase.equals("UPI")) {
                    c2 = 8;
                    break;
                }
                break;
            case 2251303:
                if (upperCase.equals("IMPS")) {
                    c2 = 9;
                    break;
                }
                break;
            case 2462282:
                if (upperCase.equals(SDKConstants.AI_KEY_PPBL)) {
                    c2 = 10;
                    break;
                }
                break;
            case 378796732:
                if (upperCase.equals("BALANCE")) {
                    c2 = 1;
                    break;
                }
                break;
            case 573043650:
                if (upperCase.equals("HYBRID PAYMENT")) {
                    c2 = 21;
                    break;
                }
                break;
            case 833770689:
                if (upperCase.equals("PREPAID CARD")) {
                    c2 = 18;
                    break;
                }
                break;
            case 1027670008:
                if (upperCase.equals("PAYTM WALLET")) {
                    c2 = 19;
                    break;
                }
                break;
            case 1222764004:
                if (upperCase.equals(com.business.merchant_payments.common.utility.AppConstants.DEBIT_CARD)) {
                    c2 = 13;
                    break;
                }
                break;
            case 1252571276:
                if (upperCase.equals("QR CODE")) {
                    c2 = 23;
                    break;
                }
                break;
            case 1406638215:
                if (upperCase.equals("MOBILE NUMBER")) {
                    c2 = 25;
                    break;
                }
                break;
            case 1537364403:
                if (upperCase.equals("CASH COUPON")) {
                    c2 = 16;
                    break;
                }
                break;
            case 1820538839:
                if (upperCase.equals(com.business.merchant_payments.common.utility.AppConstants.CREDIT_CARD)) {
                    c2 = 15;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                str2 = "Paytm Loyalty Points";
                break;
            case 1:
                str2 = context.getString(R.string.pr_lbl_paytm_wallet);
                break;
            case 2:
                str2 = context.getString(R.string.pr_lbl_credit_card);
                break;
            case 3:
                str2 = context.getString(R.string.pr_lbl_debit_card);
                break;
            case 4:
                str2 = context.getString(R.string.pr_lbl_net_banking);
                break;
            case 5:
                str2 = context.getString(R.string.pr_lbl_paytm_wallet);
                break;
            case 6:
                str2 = context.getString(R.string.pr_lbl_atm_card);
                break;
            case 7:
                return "EMI";
            case 8:
                str2 = context.getString(R.string.pr_upi);
                break;
            case 9:
                return "IMPS";
            case 10:
                str2 = context.getString(R.string.pr_ppbl);
                break;
            case 11:
                str2 = context.getString(R.string.pr_lbl_cod);
                break;
            case 12:
                str2 = context.getString(R.string.pr_lbl_withdraw);
                break;
            case 13:
                str2 = context.getString(R.string.pr_lbl_debit_card);
                break;
            case 14:
                str2 = context.getString(R.string.pr_lbl_net_banking);
                break;
            case 15:
                str2 = context.getString(R.string.pr_lbl_credit_card);
                break;
            case 16:
                str2 = context.getString(R.string.pr_lbl_cash_coupon);
                break;
            case 17:
                str2 = context.getString(R.string.pr_bank_express);
                break;
            case 18:
                str2 = context.getString(R.string.pr_lbl_paytm_wallet);
                break;
            case 19:
                str2 = context.getString(R.string.pr_lbl_paytm_wallet);
                break;
            case 20:
                str2 = context.getString(R.string.pr_loyalty_points);
                break;
            case 21:
                str2 = context.getString(R.string.pr_hybrid_payment);
                break;
            case 22:
                str2 = context.getString(R.string.pr_paytm_postpaid);
                break;
            case 23:
                str2 = context.getString(R.string.pr_lbl_paytm_wallet);
                break;
            case 24:
                str2 = context.getString(R.string.pr_lbl_paytm_wallet);
                break;
            case 25:
                str2 = context.getString(R.string.pr_lbl_paytm_wallet);
                break;
            default:
                return str;
        }
        return str2;
    }

    public static void openWebUrl(String str, Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static long getCurrentAppVersionCode(Context context) {
        try {
            return (long) context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static SpannableString formattedPrice(float f2, String str, int i2) {
        return formattedPrice(f2, str, i2, false);
    }

    public static SpannableString formattedPrice(float f2, String str, int i2, boolean z) {
        Context appContext = ProfileConfig.getInstance().getAppContext();
        if (!TextUtils.isEmpty(str) && !str.contains(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA) && !str.contains("null") && !str.contains("--")) {
            boolean contains = str.contains(appContext.getString(R.string.pr_rupee_symbol));
            String substring = str.substring(findIndexOfFirstDigit(str));
            String substring2 = str.substring(0, findIndexOfFirstDigit(str));
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
            decimalFormat.applyPattern("##,##,##,##,##,##,##,##,##,##0.00");
            String format = decimalFormat.format(Double.valueOf(substring));
            if (contains) {
                str = substring2 + format;
            } else {
                str = format;
            }
        }
        if (TextUtils.isEmpty(str)) {
            return new SpannableString("");
        }
        SpannableString spannableString = new SpannableString(str);
        Typeface typeface = Typeface.DEFAULT;
        int indexOf = str.indexOf(com.business.merchant_payments.common.utility.AppUtility.CENTER_DOT);
        if (indexOf >= 0) {
            try {
                spannableString.setSpan(new ForegroundColorSpan(i2), indexOf, str.length(), 18);
                spannableString.setSpan(new StyleSpan(0), indexOf, str.length(), 18);
                spannableString.setSpan(new RelativeSizeSpan(f2), indexOf, str.length(), 0);
                if (!z) {
                    spannableString.setSpan(new CustomTypeFaceSpan("", typeface), indexOf, str.length(), 18);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return spannableString;
    }

    public static int findIndexOfFirstDigit(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (Character.isDigit(str.charAt(i2))) {
                return i2;
            }
        }
        return -1;
    }

    public static String insertPeriodically(String str, String str2, int i2) {
        StringBuilder sb = new StringBuilder(str.length() + (str2.length() * (str.length() / i2)) + 1);
        int i3 = 0;
        while (i3 < str.length()) {
            sb.append(str2);
            int i4 = i3 + i2;
            sb.append(str.substring(i3, Math.min(i4, str.length())));
            i3 = i4;
        }
        return sb.toString();
    }

    public static int convertDpToPixel(float f2, Context context) {
        return (int) (f2 * (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    public static String createMessage(String str, double d2, String str2, Context context) {
        String merchantDisplayName = ProfileSharedPreferences.getInstance().getMerchantDisplayName(context);
        Resources resources = context.getResources();
        int i2 = R.string.pr_ap_share_message;
        StringBuilder sb = new StringBuilder();
        sb.append(d2);
        return resources.getString(i2, new Object[]{merchantDisplayName, sb.toString(), str2, str});
    }

    public static float convertDpToPixels(Context context, float f2) {
        return TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
    }

    public static String dateFormatter(String str, String str2, String str3) {
        try {
            return new SimpleDateFormat(str2, new Locale(ProfileSharedPreferences.getInstance().getLanguage(ProfileConfig.getInstance().getAppContext()))).format(new SimpleDateFormat(str).parse(str3));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getString(Context context, String str) {
        if (str.equalsIgnoreCase(context.getString(R.string.pr_today))) {
            return context.getString(R.string.pr_today);
        }
        if (str.equalsIgnoreCase(context.getString(R.string.pr_this_week))) {
            return context.getString(R.string.pr_this_week);
        }
        if (str.equalsIgnoreCase(context.getString(R.string.pr_yesterday))) {
            return context.getString(R.string.pr_yesterday);
        }
        return context.getString(R.string.pr_this_period);
    }

    public static String getFormateedAMPMTime(int i2) {
        if (i2 == 0) {
            return " 12 AM";
        }
        if (i2 == 12) {
            return " 12 PM";
        }
        if (i2 > 12) {
            return " " + (i2 - 12) + "  PM";
        }
        return " " + i2 + "  AM";
    }

    public static String getFormateedAMPMTimeDayAppended(int i2) {
        String str;
        int i3 = Calendar.getInstance().get(11);
        if (i2 == 0) {
            return " 12 AM " + ProfileConfig.getInstance().getAppContext().getString(R.string.pr_tomorrow);
        } else if (i2 == 12) {
            return " 12 PM " + ProfileConfig.getInstance().getAppContext().getString(R.string.pr_today);
        } else if (i2 > 12) {
            return " " + (i2 - 12) + "  PM " + ProfileConfig.getInstance().getAppContext().getString(R.string.pr_today);
        } else {
            if (i3 <= 12 || i3 >= 24) {
                str = ProfileConfig.getInstance().getAppContext().getString(R.string.pr_today);
            } else {
                str = ProfileConfig.getInstance().getAppContext().getString(R.string.pr_tomorrow);
            }
            return " " + i2 + "  AM " + str;
        }
    }

    public static String getFormatedAMPMTimeDayAppendedNew(int i2) {
        String str;
        int i3 = Calendar.getInstance().get(11);
        if (i2 == 0) {
            str = " 12 AM ";
        } else if (i2 == 12) {
            str = " 12 PM ";
        } else if (i2 > 12) {
            StringBuilder sb = new StringBuilder(" ");
            sb.append(i2 - 12);
            sb.append(" PM ");
            str = sb.toString();
        } else {
            str = " " + i2 + " AM ";
        }
        if (i3 < i2) {
            return str + ProfileConfig.getInstance().getAppContext().getString(R.string.pr_today);
        }
        return str + ProfileConfig.getInstance().getAppContext().getString(R.string.pr_tomorrow);
    }

    public static SpannableString getSpannedText(String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new SpannableString(Html.fromHtml(str, 63));
        }
        return new SpannableString(Html.fromHtml(str));
    }

    public static void onSignOut(Context context) {
        ProfileConfig.getInstance().getCommonUtils();
    }

    public static void onSignOut(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError) {
        ProfileConfig.getInstance().getCommonUtils().a(activity, str, bundle);
    }

    public static String getMaskedUPI_Email(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String[] split = str.split("@");
        int length = split[0].length();
        StringBuilder sb = new StringBuilder(split[0]);
        if (length > 4) {
            int i2 = length - 4;
            if (i2 == 1) {
                sb.replace(2, split[0].length() - 1, CENTER_DOT + CENTER_DOT);
            } else if (i2 == 2) {
                sb.replace(2, split[0].length() - 2, CENTER_DOT + CENTER_DOT);
            } else if (i2 == 3) {
                sb.replace(2, split[0].length() - 2, CENTER_DOT + CENTER_DOT + CENTER_DOT);
            } else if (i2 == 4) {
                sb.replace(2, split[0].length() - 2, FOUR_CENTER_DOT);
            } else if (i2 != 5) {
                sb.replace(4, split[0].length() - 2, FOUR_CENTER_DOT);
            } else {
                sb.replace(3, split[0].length() - 2, FOUR_CENTER_DOT);
            }
        } else {
            int length2 = split[0].length();
            sb.replace(1, length2, CENTER_DOT + CENTER_DOT + CENTER_DOT);
        }
        sb.append("@" + split[1]);
        return sb.toString();
    }

    public static String getMHDHelpLineNumber() {
        return ProfileConfig.getInstance().getGTMDataProvider().getString(ProfileGTMConstants.MHD_HELPLINE_NUMBER, "");
    }

    public static String getFormattedCardNumber(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '*' || charAt == 'X' || charAt == 'x') {
                charAt = CENTER_DOT.charAt(0);
            }
            sb.append(charAt);
            i2++;
            if (i2 == 4) {
                sb.append(" ");
                i2 = 0;
            }
        }
        return sb.toString();
    }

    public static SpannableString formattedPrice(String str, Context context, String str2) {
        try {
            if (!str.contains(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA) && !str.contains("null")) {
                boolean contains = str.contains(context.getString(R.string.pr_rupee_symbol));
                String substring = str.substring(findIndexOfFirstDigit(str));
                String substring2 = str.substring(0, findIndexOfFirstDigit(str));
                DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
                decimalFormat.applyPattern(str2);
                String format = decimalFormat.format(Double.valueOf(substring));
                if (contains) {
                    str = substring2 + format;
                } else {
                    str = format;
                }
            }
            if (!TextUtils.isEmpty(str)) {
                SpannableString spannableString = new SpannableString(str);
                CustomTypeFaceSpan customTypeFaceSpan = new CustomTypeFaceSpan("", Typeface.DEFAULT);
                int indexOf = str.indexOf(com.business.merchant_payments.common.utility.AppUtility.CENTER_DOT);
                if (indexOf >= 0) {
                    try {
                        spannableString.setSpan(customTypeFaceSpan, indexOf + 1, str.length(), 18);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                return spannableString;
            }
        } catch (NumberFormatException e3) {
            e3.printStackTrace();
        }
        return new SpannableString("");
    }

    public static String getFormattedJsonString(String str) {
        return str.replace("\\", "").replace("\"{", "{").replace("}\"", "}");
    }

    public static String rangeFormat(Double d2, Double d3) {
        if (d2.doubleValue() == -1.0d && d3.doubleValue() == -1.0d) {
            return ProfileConfig.getInstance().getAppContext().getString(R.string.pr_unlimited);
        }
        if (d2.doubleValue() == 0.0d) {
            return "Upto " + RUPEE_SYMBOL + justApplyPattern(d3.doubleValue(), "##,##,##,##,###");
        } else if (d3.doubleValue() == -1.0d) {
            return "Above " + RUPEE_SYMBOL + justApplyPattern(d2.doubleValue(), "##,##,##,##,###");
        } else {
            return RUPEE_SYMBOL + justApplyPattern(d2.doubleValue(), "##,##,##,##,###") + " to " + RUPEE_SYMBOL + justApplyPattern(d3.doubleValue(), "##,##,##,##,###");
        }
    }

    public static String justApplyPattern(double d2, String str) {
        try {
            NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.US);
            ((DecimalFormat) numberInstance).applyPattern(str);
            numberInstance.setMaximumFractionDigits(2);
            return numberInstance.format(d2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getUserEntityType() {
        String userPANRegex = ProfileSharedPreferences.getInstance().getUserPANRegex();
        if (TextUtils.isEmpty(userPANRegex)) {
            userPANRegex = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.FEED_COMMUNITY_POST;
        }
        String upperCase = userPANRegex.toUpperCase();
        char c2 = 65535;
        int hashCode = upperCase.hashCode();
        if (hashCode != 65) {
            if (hashCode != 67) {
                if (hashCode != 70) {
                    if (hashCode != 80) {
                        if (hashCode == 84 && upperCase.equals("T")) {
                            c2 = 3;
                        }
                    } else if (upperCase.equals(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.FEED_COMMUNITY_POST)) {
                        c2 = 2;
                    }
                } else if (upperCase.equals(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.FEED_SUB_TYPE)) {
                    c2 = 1;
                }
            } else if (upperCase.equals(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.FEED_COMMUNITY)) {
                c2 = 0;
            }
        } else if (upperCase.equals("A")) {
            c2 = 4;
        }
        return (c2 != 0 ? c2 != 1 ? c2 != 2 ? c2 != 3 ? c2 != 4 ? "INDIVIDUAL" : "Society" : "Trust" : "Individual" : "Partnership" : "Private").toUpperCase();
    }

    public static String insertCharacterForEveryNDistance(String str, int i2, char c2) {
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        for (int i3 = 0; i3 < charArray.length; i3++) {
            if (i3 % i2 == 0) {
                sb.append(c2);
                sb.append(charArray[i3]);
            } else {
                sb.append(charArray[i3]);
            }
        }
        return sb.toString();
    }

    public static String getDateWithSuffix(String str) {
        if (str.startsWith("0")) {
            str = str.substring(1);
        }
        if (str.endsWith("1") && !str.endsWith("11")) {
            return str + H5Param.SHOW_TITLEBAR;
        } else if (str.endsWith("2") && !str.endsWith("12")) {
            return str + "nd";
        } else if (!str.endsWith("3") || str.endsWith("13")) {
            return str + "th";
        } else {
            return str + "rd";
        }
    }

    public static Integer getLangId(String str) {
        if (LANG_ID_MAP.get(str) == null) {
            return 1;
        }
        return LANG_ID_MAP.get(str);
    }

    public static String removeNullFromString(String str) {
        return (TextUtils.isEmpty(str) || !str.contains("null")) ? str : str.replace(" null", "");
    }

    public static int getValueInDp(Context context, int i2) {
        return (int) (((float) i2) * context.getResources().getDisplayMetrics().density);
    }

    public static SpannableString getFormattedTextWithImage(StringBuilder sb, int i2, Context context) {
        sb.append(" ");
        SpannableString spannableString = new SpannableString(sb);
        spannableString.setSpan(new com.business.common_module.b(context, i2), spannableString.length() - 1, spannableString.length(), 17);
        return spannableString;
    }

    public static String getStringAddressDetailModel(AddressDetailsModel addressDetailsModel) {
        if (addressDetailsModel != null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(addressDetailsModel.getAddress1())) {
                sb.append(addressDetailsModel.getAddress1());
                sb.append(", ");
            }
            if (!TextUtils.isEmpty(addressDetailsModel.getAddress2())) {
                sb.append(addressDetailsModel.getAddress2());
            }
            sb.append(System.getProperty("line.separator"));
            if (!TextUtils.isEmpty(addressDetailsModel.getAddress3())) {
                sb.append(addressDetailsModel.getAddress3());
                sb.append(", ");
            }
            if (!TextUtils.isEmpty(addressDetailsModel.getCity())) {
                sb.append(addressDetailsModel.getCity());
            }
            sb.append(System.getProperty("line.separator"));
            if (!TextUtils.isEmpty(addressDetailsModel.getState())) {
                sb.append(addressDetailsModel.getState());
                sb.append(", ");
            }
            if (!TextUtils.isEmpty(addressDetailsModel.getCountry())) {
                sb.append(addressDetailsModel.getCountry());
                sb.append(", ");
            }
            if (!TextUtils.isEmpty(addressDetailsModel.getPin())) {
                sb.append(addressDetailsModel.getPin());
                sb.append(", ");
            }
            if (sb.length() > 2) {
                return sb.substring(0, sb.length() - 2);
            }
        }
        return "";
    }

    public static String getFileName(Context context, Uri uri) {
        String str = "";
        if (uri.getScheme().equals("content")) {
            Cursor query = context.getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndex("_display_name"));
                    }
                } catch (Throwable th) {
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
        }
        return TextUtils.isEmpty(str) ? uri.getLastPathSegment() : str;
    }

    public static long getFileSize(Context context, Uri uri) {
        long j = 0;
        if (uri.getScheme().equals("content")) {
            Cursor query = context.getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        long j2 = query.getLong(query.getColumnIndex("_size"));
                        if (j2 > 0) {
                            j2 /= 1000;
                        }
                        j = j2;
                    }
                } catch (Throwable th) {
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
        }
        return j;
    }
}
