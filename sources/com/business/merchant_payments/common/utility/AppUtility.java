package com.business.merchant_payments.common.utility;

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
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.TypedValue;
import androidx.core.content.b;
import com.alipay.mobile.h5container.api.H5Param;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.deeplinkUtil.DeepLinkConstant;
import com.business.merchant_payments.model.AddressDetailsModel;
import com.business.merchant_payments.model.v2.OrderDetailV2Model;
import com.google.android.gms.common.c;
import com.paytm.network.model.NetworkCustomError;
import easypay.manager.Constants;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
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
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class AppUtility {
    public static final String CENTER_DOT = ".";
    public static final String FOUR_CENTER_DOT = "....";
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
    public static final String RUPEE_SYMBOL = "PaymentsConfig.getInstance().getAppContext().getString(R.string.mp_rupee_symbol)";
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

    public static int isGooglePlayServicesAvailable(Context context) {
        try {
            return c.a().a(context);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
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

    public static String formatDecimalIntegerNumber(double d2, String str) {
        String str2;
        try {
            NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.US);
            ((DecimalFormat) numberInstance).applyPattern(str);
            numberInstance.setMaximumFractionDigits(2);
            String valueOf = String.valueOf(d2);
            int indexOf = valueOf.indexOf(CENTER_DOT);
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
            int indexOf = valueOf.indexOf(CENTER_DOT);
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
                boolean contains = str.contains(context.getString(R.string.mp_rupee_symbol));
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
                int indexOf = str.indexOf(CENTER_DOT);
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
                boolean contains = str.contains(context.getString(R.string.mp_rupee_symbol));
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
            boolean contains = str.contains(context.getString(R.string.mp_rupee_symbol));
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
        int indexOf = str.indexOf(CENTER_DOT);
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
        if (str == null || str.contains(CENTER_DOT)) {
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
        return "(Ac. no.- ........" + str.substring(str.length() - 4) + ")";
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
            int r7 = com.business.merchant_payments.R.string.mp_lbl_debit_card
            java.lang.String r7 = r6.getString(r7)
            goto L_0x006d
        L_0x0059:
            int r7 = com.business.merchant_payments.R.string.mp_lbl_credit_card
            java.lang.String r7 = r6.getString(r7)
            goto L_0x006d
        L_0x0060:
            int r7 = com.business.merchant_payments.R.string.mp_lbl_net_banking
            java.lang.String r7 = r6.getString(r7)
            goto L_0x006d
        L_0x0067:
            int r7 = com.business.merchant_payments.R.string.mp_lbl_paytm_wallet
            java.lang.String r7 = r6.getString(r7)
        L_0x006d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.common.utility.AppUtility.getDisplayPaymentMode(android.content.Context, java.lang.String):java.lang.String");
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
                    c2 = 15;
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
                    c2 = 24;
                    break;
                }
                break;
            case -250353122:
                if (upperCase.equals("PAYTM_DIGITAL_CREDIT")) {
                    c2 = 25;
                    break;
                }
                break;
            case -157615350:
                if (upperCase.equals("WITHDRAW")) {
                    c2 = 16;
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
                    c2 = 27;
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
                    c2 = 12;
                    break;
                }
                break;
            case 2251303:
                if (upperCase.equals("IMPS")) {
                    c2 = 13;
                    break;
                }
                break;
            case 2462282:
                if (upperCase.equals(SDKConstants.AI_KEY_PPBL)) {
                    c2 = 14;
                    break;
                }
                break;
            case 295748685:
                if (upperCase.equals("BANK_EXPRESS")) {
                    c2 = 21;
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
                    c2 = 23;
                    break;
                }
                break;
            case 891952512:
                if (upperCase.equals("PREPAID_CARD")) {
                    c2 = 22;
                    break;
                }
                break;
            case 1280945827:
                if (upperCase.equals(SDKConstants.DEBIT)) {
                    c2 = 17;
                    break;
                }
                break;
            case 1310753099:
                if (upperCase.equals("QR_CODE")) {
                    c2 = 26;
                    break;
                }
                break;
            case 1484795270:
                if (upperCase.equals("MOBILE_NUMBER")) {
                    c2 = 28;
                    break;
                }
                break;
            case 1615521458:
                if (upperCase.equals("CASH_COUPON")) {
                    c2 = 20;
                    break;
                }
                break;
            case 1878720662:
                if (upperCase.equals(SDKConstants.CREDIT)) {
                    c2 = 19;
                    break;
                }
                break;
            case 2048730175:
                if (upperCase.equals(AppConstants.EMI_CC)) {
                    c2 = 9;
                    break;
                }
                break;
            case 2048730206:
                if (upperCase.equals(AppConstants.EMI_DC)) {
                    c2 = 10;
                    break;
                }
                break;
            case 2048790718:
                if (upperCase.equals("EMI_CC")) {
                    c2 = 8;
                    break;
                }
                break;
            case 2048790749:
                if (upperCase.equals(SDKConstants.EMI_DC)) {
                    c2 = 11;
                    break;
                }
                break;
            case 2134027076:
                if (upperCase.equals("NET_BANKING")) {
                    c2 = 18;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return "Paytm Loyalty Points";
            case 1:
            case 5:
            case 22:
            case 26:
            case 27:
            case 28:
                return "Paytm Wallet";
            case 2:
            case 19:
                return "Credit Card";
            case 3:
            case 17:
                return "Debit Card";
            case 4:
            case 18:
                return "Net Banking";
            case 6:
                return "ATM Card";
            case 7:
            case 8:
            case 9:
                return "EMI";
            case 10:
            case 11:
                return AppConstants.EMI_DC;
            case 12:
                return "UPI";
            case 13:
                return "IMPS";
            case 14:
                return "Paytm Payments Bank Account";
            case 15:
                return "Cash on Delivery";
            case 16:
                return "Withdraw";
            case 20:
                return "Cash Coupon";
            case 21:
                return "Bank Express";
            case 23:
                return "Loyalty Points";
            case 24:
                return "Hybrid Payment";
            case 25:
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
                    c2 = 19;
                    break;
                }
                break;
            case -2013743940:
                if (upperCase.equals("MP_COD")) {
                    c2 = 13;
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
                    c2 = 22;
                    break;
                }
                break;
            case -814993632:
                if (upperCase.equals("PAYTM DIGITAL CREDIT")) {
                    c2 = 24;
                    break;
                }
                break;
            case -288841629:
                if (upperCase.equals(SDKConstants.AI_KEY_NB)) {
                    c2 = 16;
                    break;
                }
                break;
            case -157615350:
                if (upperCase.equals("WITHDRAW")) {
                    c2 = 14;
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
                    c2 = 26;
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
                    c2 = 8;
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
                    c2 = 10;
                    break;
                }
                break;
            case 2251303:
                if (upperCase.equals("IMPS")) {
                    c2 = 11;
                    break;
                }
                break;
            case 2462282:
                if (upperCase.equals(SDKConstants.AI_KEY_PPBL)) {
                    c2 = 12;
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
                    c2 = 23;
                    break;
                }
                break;
            case 833770689:
                if (upperCase.equals("PREPAID CARD")) {
                    c2 = 20;
                    break;
                }
                break;
            case 1027670008:
                if (upperCase.equals("PAYTM WALLET")) {
                    c2 = 21;
                    break;
                }
                break;
            case 1222764004:
                if (upperCase.equals(AppConstants.DEBIT_CARD)) {
                    c2 = 15;
                    break;
                }
                break;
            case 1252571276:
                if (upperCase.equals("QR CODE")) {
                    c2 = 25;
                    break;
                }
                break;
            case 1406638215:
                if (upperCase.equals("MOBILE NUMBER")) {
                    c2 = 27;
                    break;
                }
                break;
            case 1537364403:
                if (upperCase.equals("CASH COUPON")) {
                    c2 = 18;
                    break;
                }
                break;
            case 1820538839:
                if (upperCase.equals(AppConstants.CREDIT_CARD)) {
                    c2 = 17;
                    break;
                }
                break;
            case 2048730175:
                if (upperCase.equals(AppConstants.EMI_CC)) {
                    c2 = 7;
                    break;
                }
                break;
            case 2048730206:
                if (upperCase.equals(AppConstants.EMI_DC)) {
                    c2 = 9;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                str2 = "Paytm Loyalty Points";
                break;
            case 1:
                str2 = context.getString(R.string.mp_lbl_paytm_wallet);
                break;
            case 2:
                str2 = context.getString(R.string.mp_lbl_credit_card);
                break;
            case 3:
                str2 = context.getString(R.string.mp_lbl_debit_card);
                break;
            case 4:
                str2 = context.getString(R.string.mp_lbl_net_banking);
                break;
            case 5:
                str2 = context.getString(R.string.mp_lbl_paytm_wallet);
                break;
            case 6:
                str2 = context.getString(R.string.mp_lbl_atm_card);
                break;
            case 7:
            case 8:
                str2 = context.getString(R.string.mp_label_emi_credit_card);
                break;
            case 9:
                str2 = context.getString(R.string.mp_label_emi_debit_card);
                break;
            case 10:
                str2 = context.getString(R.string.mp_upi);
                break;
            case 11:
                str2 = context.getString(R.string.mp_label_imps);
                break;
            case 12:
                str2 = context.getString(R.string.mp_ppbl);
                break;
            case 13:
                str2 = context.getString(R.string.mp_lbl_cod);
                break;
            case 14:
                str2 = context.getString(R.string.mp_lbl_withdraw);
                break;
            case 15:
                str2 = context.getString(R.string.mp_lbl_debit_card);
                break;
            case 16:
                str2 = context.getString(R.string.mp_lbl_net_banking);
                break;
            case 17:
                str2 = context.getString(R.string.mp_lbl_credit_card);
                break;
            case 18:
                str2 = context.getString(R.string.mp_lbl_cash_coupon);
                break;
            case 19:
                str2 = context.getString(R.string.mp_bank_express);
                break;
            case 20:
                str2 = context.getString(R.string.mp_lbl_paytm_wallet);
                break;
            case 21:
                str2 = context.getString(R.string.mp_lbl_paytm_wallet);
                break;
            case 22:
                str2 = context.getString(R.string.mp_loyalty_points);
                break;
            case 23:
                str2 = context.getString(R.string.mp_hybrid_payment);
                break;
            case 24:
                str2 = context.getString(R.string.mp_paytm_postpaid);
                break;
            case 25:
                str2 = context.getString(R.string.mp_lbl_paytm_wallet);
                break;
            case 26:
                str2 = context.getString(R.string.mp_lbl_paytm_wallet);
                break;
            case 27:
                str2 = context.getString(R.string.mp_lbl_paytm_wallet);
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
        Context appContext = PaymentsConfig.getInstance().getAppContext();
        if (!TextUtils.isEmpty(str) && !str.contains(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA) && !str.contains("null") && !str.contains("--")) {
            boolean contains = str.contains(appContext.getString(R.string.mp_rupee_symbol));
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
        int indexOf = str.indexOf(CENTER_DOT);
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
        String merchantDisplayName = APSharedPreferences.getInstance().getMerchantDisplayName(context);
        Resources resources = context.getResources();
        int i2 = R.string.mp_ap_share_message;
        StringBuilder sb = new StringBuilder();
        sb.append(d2);
        return resources.getString(i2, new Object[]{merchantDisplayName, sb.toString(), str2, str});
    }

    public static float convertDpToPixels(Context context, float f2) {
        return TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
    }

    public static String dateFormatter(String str, String str2, String str3) {
        try {
            return new SimpleDateFormat(str2, new Locale(APSharedPreferences.getInstance().getLanguage(PaymentsConfig.getInstance().getAppContext()))).format(new SimpleDateFormat(str).parse(str3));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getString(Context context, String str) {
        if (str.equalsIgnoreCase(context.getString(R.string.mp_today))) {
            return context.getString(R.string.mp_today);
        }
        if (str.equalsIgnoreCase(context.getString(R.string.mp_this_week))) {
            return context.getString(R.string.mp_this_week);
        }
        if (str.equalsIgnoreCase(context.getString(R.string.mp_yesterday))) {
            return context.getString(R.string.mp_yesterday);
        }
        return context.getString(R.string.mp_this_period);
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
            return " 12 AM " + PaymentsConfig.getInstance().getAppContext().getString(R.string.mp_tomorrow);
        } else if (i2 == 12) {
            return " 12 PM " + PaymentsConfig.getInstance().getAppContext().getString(R.string.mp_today);
        } else if (i2 > 12) {
            return " " + (i2 - 12) + "  PM " + PaymentsConfig.getInstance().getAppContext().getString(R.string.mp_today);
        } else {
            if (i3 <= 12 || i3 >= 24) {
                str = PaymentsConfig.getInstance().getAppContext().getString(R.string.mp_today);
            } else {
                str = PaymentsConfig.getInstance().getAppContext().getString(R.string.mp_tomorrow);
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
            return str + PaymentsConfig.getInstance().getAppContext().getString(R.string.mp_today);
        }
        return str + PaymentsConfig.getInstance().getAppContext().getString(R.string.mp_tomorrow);
    }

    public static SpannableString getSpannedText(String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new SpannableString(Html.fromHtml(str, 63));
        }
        return new SpannableString(Html.fromHtml(str));
    }

    public static void onSignOut(Context context) {
        PaymentsConfig.getInstance().getCommonUtils();
    }

    public static void onSignOut(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError) {
        PaymentsConfig.getInstance().getCommonUtils().a(activity, str, bundle);
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
                sb.replace(2, split[0].length() - 1, "..");
            } else if (i2 == 2) {
                sb.replace(2, split[0].length() - 2, "..");
            } else if (i2 == 3) {
                sb.replace(2, split[0].length() - 2, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.DOTS);
            } else if (i2 == 4) {
                sb.replace(2, split[0].length() - 2, FOUR_CENTER_DOT);
            } else if (i2 != 5) {
                sb.replace(4, split[0].length() - 2, FOUR_CENTER_DOT);
            } else {
                sb.replace(3, split[0].length() - 2, FOUR_CENTER_DOT);
            }
        } else {
            sb.replace(1, split[0].length(), com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.DOTS);
        }
        sb.append("@" + split[1]);
        return sb.toString();
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
                boolean contains = str.contains(context.getString(R.string.mp_rupee_symbol));
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
                int indexOf = str.indexOf(CENTER_DOT);
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

    public static String getVirtualPaymentAddr(String str) {
        try {
            int indexOf = str.indexOf("virtualPaymentAddr") + 19;
            if (indexOf != 18) {
                return str.substring(indexOf, str.indexOf(44, indexOf)).replaceAll("[\\\\|:|\"]", "");
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static String getFormattedJsonString(String str) {
        return str.replace("\\", "").replace("\"{", "{").replace("}\"", "}");
    }

    public static JSONObject getFormattedJsonObject(JSONObject jSONObject, String str) {
        try {
            return new JSONObject(getFormattedJsonString(jSONObject.optString(str, "")));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String rangeFormat(Double d2, Double d3) {
        if (d2.doubleValue() == -1.0d && d3.doubleValue() == -1.0d) {
            return PaymentsConfig.getInstance().getAppContext().getString(R.string.mp_unlimited);
        }
        if (d2.doubleValue() == 0.0d) {
            return "Upto PaymentsConfig.getInstance().getAppContext().getString(R.string.mp_rupee_symbol)" + justApplyPattern(d3.doubleValue(), "##,##,##,##,###");
        } else if (d3.doubleValue() == -1.0d) {
            return "Above PaymentsConfig.getInstance().getAppContext().getString(R.string.mp_rupee_symbol)" + justApplyPattern(d2.doubleValue(), "##,##,##,##,###");
        } else {
            return RUPEE_SYMBOL + justApplyPattern(d2.doubleValue(), "##,##,##,##,###") + " to PaymentsConfig.getInstance().getAppContext().getString(R.string.mp_rupee_symbol)" + justApplyPattern(d3.doubleValue(), "##,##,##,##,###");
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
        String userPANRegex = APSharedPreferences.getInstance().getUserPANRegex();
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

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getExpandedPayMode(android.content.Context r2, java.lang.String r3) {
        /*
            java.lang.String r0 = r3.toUpperCase()
            java.lang.String r0 = r0.trim()
            int r1 = r0.hashCode()
            switch(r1) {
                case -250353122: goto L_0x006c;
                case 2144: goto L_0x0062;
                case 2175: goto L_0x0058;
                case 2484: goto L_0x004e;
                case 79433: goto L_0x0044;
                case 84238: goto L_0x0039;
                case 2462282: goto L_0x002f;
                case 1280945827: goto L_0x0025;
                case 1878720662: goto L_0x001b;
                case 2134027076: goto L_0x0011;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0077
        L_0x0011:
            java.lang.String r1 = "NET_BANKING"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0077
            r0 = 2
            goto L_0x0078
        L_0x001b:
            java.lang.String r1 = "CREDIT_CARD"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0077
            r0 = 4
            goto L_0x0078
        L_0x0025:
            java.lang.String r1 = "DEBIT_CARD"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0077
            r0 = 6
            goto L_0x0078
        L_0x002f:
            java.lang.String r1 = "PPBL"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0077
            r0 = 7
            goto L_0x0078
        L_0x0039:
            java.lang.String r1 = "UPI"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0077
            r0 = 8
            goto L_0x0078
        L_0x0044:
            java.lang.String r1 = "PPI"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0077
            r0 = 0
            goto L_0x0078
        L_0x004e:
            java.lang.String r1 = "NB"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0077
            r0 = 1
            goto L_0x0078
        L_0x0058:
            java.lang.String r1 = "DC"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0077
            r0 = 5
            goto L_0x0078
        L_0x0062:
            java.lang.String r1 = "CC"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0077
            r0 = 3
            goto L_0x0078
        L_0x006c:
            java.lang.String r1 = "PAYTM_DIGITAL_CREDIT"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0077
            r0 = 9
            goto L_0x0078
        L_0x0077:
            r0 = -1
        L_0x0078:
            switch(r0) {
                case 0: goto L_0x00a6;
                case 1: goto L_0x009f;
                case 2: goto L_0x009f;
                case 3: goto L_0x0098;
                case 4: goto L_0x0098;
                case 5: goto L_0x0091;
                case 6: goto L_0x0091;
                case 7: goto L_0x008a;
                case 8: goto L_0x0083;
                case 9: goto L_0x007c;
                default: goto L_0x007b;
            }
        L_0x007b:
            goto L_0x00ac
        L_0x007c:
            int r3 = com.business.merchant_payments.R.string.mp_lbl_paytm_postpaid
            java.lang.String r3 = r2.getString(r3)
            goto L_0x00ac
        L_0x0083:
            int r3 = com.business.merchant_payments.R.string.mp_upi
            java.lang.String r3 = r2.getString(r3)
            goto L_0x00ac
        L_0x008a:
            int r3 = com.business.merchant_payments.R.string.mp_ppbl_label
            java.lang.String r3 = r2.getString(r3)
            goto L_0x00ac
        L_0x0091:
            int r3 = com.business.merchant_payments.R.string.mp_lbl_debit_card
            java.lang.String r3 = r2.getString(r3)
            goto L_0x00ac
        L_0x0098:
            int r3 = com.business.merchant_payments.R.string.mp_lbl_credit_card
            java.lang.String r3 = r2.getString(r3)
            goto L_0x00ac
        L_0x009f:
            int r3 = com.business.merchant_payments.R.string.mp_lbl_net_banking
            java.lang.String r3 = r2.getString(r3)
            goto L_0x00ac
        L_0x00a6:
            int r3 = com.business.merchant_payments.R.string.mp_wallet
            java.lang.String r3 = r2.getString(r3)
        L_0x00ac:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.common.utility.AppUtility.getExpandedPayMode(android.content.Context, java.lang.String):java.lang.String");
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

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void formatData(com.business.merchant_payments.model.v2.OrderListV2 r10) {
        /*
            java.lang.String r0 = "REFUND"
            java.util.List r1 = r10.getOrderList()
            if (r1 != 0) goto L_0x0009
            return
        L_0x0009:
            java.util.List r10 = r10.getOrderList()
            java.util.ArrayList r10 = (java.util.ArrayList) r10
            java.util.Iterator r10 = r10.iterator()
        L_0x0013:
            boolean r1 = r10.hasNext()
            if (r1 == 0) goto L_0x01d1
            java.lang.Object r1 = r10.next()
            com.business.merchant_payments.model.v2.OrderDetailV2Model r1 = (com.business.merchant_payments.model.v2.OrderDetailV2Model) r1
            java.lang.String r2 = r1.getExtendInfo()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x0013
            java.lang.String r3 = r1.getBizType()     // Catch:{ Exception -> 0x0077 }
            boolean r3 = r3.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0077 }
            java.lang.String r4 = "requestType"
            if (r3 == 0) goto L_0x0050
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0077 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0077 }
            java.lang.String r5 = "EDC_VOID_EXTEND_INFO"
            org.json.JSONObject r3 = getFormattedJsonObject(r3, r5)     // Catch:{ Exception -> 0x0077 }
            if (r3 == 0) goto L_0x007b
            java.lang.String r3 = r3.optString(r4)     // Catch:{ Exception -> 0x0077 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0077 }
            if (r4 != 0) goto L_0x007b
            r1.setBizType(r3)     // Catch:{ Exception -> 0x0077 }
            goto L_0x007b
        L_0x0050:
            java.lang.String r3 = r1.getBizType()     // Catch:{ Exception -> 0x0077 }
            java.lang.String r5 = "CANCEL"
            boolean r3 = r3.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x0077 }
            if (r3 == 0) goto L_0x007b
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0077 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0077 }
            java.lang.String r5 = "CANCEL_EXTEND_INFO"
            org.json.JSONObject r3 = getFormattedJsonObject(r3, r5)     // Catch:{ Exception -> 0x0077 }
            if (r3 == 0) goto L_0x007b
            java.lang.String r3 = r3.optString(r4)     // Catch:{ Exception -> 0x0077 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0077 }
            if (r4 != 0) goto L_0x007b
            r1.setBizType(r3)     // Catch:{ Exception -> 0x0077 }
            goto L_0x007b
        L_0x0077:
            r3 = move-exception
            r3.printStackTrace()
        L_0x007b:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01cb }
            r3.<init>(r2)     // Catch:{ JSONException -> 0x01cb }
            java.lang.String r4 = "EXT_PASSTHROUGH"
            org.json.JSONObject r4 = getFormattedJsonObject(r3, r4)     // Catch:{ JSONException -> 0x01cb }
            java.lang.String r5 = "EXTERNAL_INST_INFO"
            org.json.JSONObject r5 = getFormattedJsonObject(r3, r5)     // Catch:{ JSONException -> 0x01cb }
            java.lang.String r6 = "ORDER_CREATE_EXTEND_INFO"
            org.json.JSONObject r3 = getFormattedJsonObject(r3, r6)     // Catch:{ JSONException -> 0x01cb }
            java.lang.String r6 = r1.getBizType()     // Catch:{ JSONException -> 0x01cb }
            java.lang.String r6 = r6.toUpperCase()     // Catch:{ JSONException -> 0x01cb }
            r7 = -1
            int r8 = r6.hashCode()     // Catch:{ JSONException -> 0x01cb }
            switch(r8) {
                case -1881484424: goto L_0x00df;
                case -1690950081: goto L_0x00d5;
                case 2342128: goto L_0x00cb;
                case 2640276: goto L_0x00c1;
                case 518125902: goto L_0x00b7;
                case 660516851: goto L_0x00ad;
                case 2038719571: goto L_0x00a3;
                default: goto L_0x00a2;
            }     // Catch:{ JSONException -> 0x01cb }
        L_0x00a2:
            goto L_0x00e6
        L_0x00a3:
            java.lang.String r8 = "REPAYMENT"
            boolean r6 = r6.equals(r8)     // Catch:{ JSONException -> 0x01cb }
            if (r6 == 0) goto L_0x00e6
            r7 = 4
            goto L_0x00e6
        L_0x00ad:
            java.lang.String r8 = "ACQUIRING"
            boolean r6 = r6.equals(r8)     // Catch:{ JSONException -> 0x01cb }
            if (r6 == 0) goto L_0x00e6
            r7 = 0
            goto L_0x00e6
        L_0x00b7:
            java.lang.String r8 = "REVERSAL"
            boolean r6 = r6.equals(r8)     // Catch:{ JSONException -> 0x01cb }
            if (r6 == 0) goto L_0x00e6
            r7 = 3
            goto L_0x00e6
        L_0x00c1:
            java.lang.String r8 = "VOID"
            boolean r6 = r6.equals(r8)     // Catch:{ JSONException -> 0x01cb }
            if (r6 == 0) goto L_0x00e6
            r7 = 2
            goto L_0x00e6
        L_0x00cb:
            java.lang.String r8 = "LOAN"
            boolean r6 = r6.equals(r8)     // Catch:{ JSONException -> 0x01cb }
            if (r6 == 0) goto L_0x00e6
            r7 = 5
            goto L_0x00e6
        L_0x00d5:
            java.lang.String r8 = "EDC_RENTAL"
            boolean r6 = r6.equals(r8)     // Catch:{ JSONException -> 0x01cb }
            if (r6 == 0) goto L_0x00e6
            r7 = 6
            goto L_0x00e6
        L_0x00df:
            boolean r6 = r6.equals(r0)     // Catch:{ JSONException -> 0x01cb }
            if (r6 == 0) goto L_0x00e6
            r7 = 1
        L_0x00e6:
            java.lang.String r6 = "cardType"
            java.lang.String r8 = "maskedCardNo"
            java.lang.String r9 = "virtualPaymentAddr"
            switch(r7) {
                case 0: goto L_0x01a0;
                case 1: goto L_0x0124;
                case 2: goto L_0x0106;
                case 3: goto L_0x0106;
                case 4: goto L_0x00f2;
                case 5: goto L_0x00f2;
                case 6: goto L_0x00f2;
                default: goto L_0x00f0;
            }
        L_0x00f0:
            goto L_0x0013
        L_0x00f2:
            if (r3 == 0) goto L_0x0013
            java.lang.String r2 = "udf1"
            java.lang.String r2 = r3.optString(r2)     // Catch:{ JSONException -> 0x01cb }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x01cb }
            if (r3 != 0) goto L_0x0013
            r1.setmLoanRefNumber(r2)     // Catch:{ JSONException -> 0x01cb }
            goto L_0x0013
        L_0x0106:
            if (r3 == 0) goto L_0x0013
            java.lang.String r2 = r3.optString(r8)     // Catch:{ JSONException -> 0x01cb }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x01cb }
            if (r4 != 0) goto L_0x0115
            r1.setmMaskedCardNo(r2)     // Catch:{ JSONException -> 0x01cb }
        L_0x0115:
            java.lang.String r2 = r3.optString(r6)     // Catch:{ JSONException -> 0x01cb }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x01cb }
            if (r3 != 0) goto L_0x0013
            r1.setmPayMode(r2)     // Catch:{ JSONException -> 0x01cb }
            goto L_0x0013
        L_0x0124:
            java.lang.String r2 = getVirtualPaymentAddr(r2)     // Catch:{ JSONException -> 0x01cb }
            if (r5 == 0) goto L_0x0156
            java.lang.String r6 = "payMethod"
            java.lang.String r6 = r5.optString(r6)     // Catch:{ JSONException -> 0x01cb }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x01cb }
            if (r7 != 0) goto L_0x0156
            java.lang.String r7 = "UPI"
            boolean r7 = r6.equalsIgnoreCase(r7)     // Catch:{ JSONException -> 0x01cb }
            if (r7 == 0) goto L_0x0156
            r1.setmPayMode(r6)     // Catch:{ JSONException -> 0x01cb }
            java.lang.String r6 = "externalExtendInfo"
            org.json.JSONObject r5 = getFormattedJsonObject(r5, r6)     // Catch:{ JSONException -> 0x01cb }
            if (r5 == 0) goto L_0x0156
            java.lang.String r2 = r5.optString(r9)     // Catch:{ JSONException -> 0x01cb }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x01cb }
            if (r5 != 0) goto L_0x0156
            r1.setmUpiId(r2)     // Catch:{ JSONException -> 0x01cb }
        L_0x0156:
            if (r4 == 0) goto L_0x017c
            java.lang.String r5 = "originalPaymentMode"
            java.lang.String r4 = r4.optString(r5)     // Catch:{ JSONException -> 0x01cb }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x01cb }
            if (r5 != 0) goto L_0x0167
            r1.setmPayMode(r4)     // Catch:{ JSONException -> 0x01cb }
        L_0x0167:
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x01cb }
            if (r4 == 0) goto L_0x0173
            if (r3 == 0) goto L_0x0173
            java.lang.String r2 = r3.optString(r9)     // Catch:{ JSONException -> 0x01cb }
        L_0x0173:
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x01cb }
            if (r4 != 0) goto L_0x017c
            r1.setmUpiId(r2)     // Catch:{ JSONException -> 0x01cb }
        L_0x017c:
            if (r3 == 0) goto L_0x0013
            java.lang.String r4 = r3.optString(r8)     // Catch:{ JSONException -> 0x01cb }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x01cb }
            if (r5 != 0) goto L_0x018b
            r1.setmMaskedCardNo(r4)     // Catch:{ JSONException -> 0x01cb }
        L_0x018b:
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x01cb }
            if (r4 == 0) goto L_0x0195
            java.lang.String r2 = r3.optString(r9)     // Catch:{ JSONException -> 0x01cb }
        L_0x0195:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x01cb }
            if (r3 != 0) goto L_0x0013
            r1.setmUpiId(r2)     // Catch:{ JSONException -> 0x01cb }
            goto L_0x0013
        L_0x01a0:
            if (r4 == 0) goto L_0x0013
            java.lang.String r2 = r4.optString(r6)     // Catch:{ JSONException -> 0x01cb }
            java.lang.String r3 = r4.optString(r8)     // Catch:{ JSONException -> 0x01cb }
            java.lang.String r4 = r4.optString(r9)     // Catch:{ JSONException -> 0x01cb }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x01cb }
            if (r5 != 0) goto L_0x01b7
            r1.setmPayMode(r2)     // Catch:{ JSONException -> 0x01cb }
        L_0x01b7:
            boolean r2 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x01cb }
            if (r2 != 0) goto L_0x01c0
            r1.setmMaskedCardNo(r3)     // Catch:{ JSONException -> 0x01cb }
        L_0x01c0:
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x01cb }
            if (r2 != 0) goto L_0x0013
            r1.setmUpiId(r4)     // Catch:{ JSONException -> 0x01cb }
            goto L_0x0013
        L_0x01cb:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0013
        L_0x01d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.common.utility.AppUtility.formatData(com.business.merchant_payments.model.v2.OrderListV2):void");
    }

    public static void formatData(OrderDetailV2Model orderDetailV2Model) {
        try {
            if (!orderDetailV2Model.getBizType().equalsIgnoreCase("REPAYMENT")) {
                return;
            }
            if (!TextUtils.isEmpty(orderDetailV2Model.getBizSystemName()) && orderDetailV2Model.getBizSystemName().equalsIgnoreCase(AppConstants.LOAN_INSTALLMENT)) {
                orderDetailV2Model.setBizType(AppConstants.LOAN_INSTALLMENT);
            } else if (!TextUtils.isEmpty(orderDetailV2Model.getBizSystemName()) && orderDetailV2Model.getBizSystemName().equalsIgnoreCase(AppConstants.PAYTM_TERMINAL)) {
                orderDetailV2Model.setBizType(AppConstants.PAYTM_TERMINAL);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
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

    public static Boolean isEdcFlavour() {
        return Boolean.FALSE;
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

    public static boolean shouldShowSettlementToolTip(Context context) {
        return APSharedPreferences.getInstance().getSettlementToolTipCount() < 3 && System.currentTimeMillis() - APSharedPreferences.getInstance().getSettlementToolTipShowTime() >= 86400000;
    }

    public static void onShowSettlementToolTip(Context context) {
        APSharedPreferences.getInstance().setSettlementToolTipShowCount(APSharedPreferences.getInstance().getSettlementToolTipCount() + 1);
        APSharedPreferences.getInstance().setSettlementToolTipShowTime(System.currentTimeMillis());
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

    public static String getDownloadStatementDeeplink(String str, String str2) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("paytmmp").authority(DeepLinkConstant.ACCEPT_PAYMENT_AUTHORITY).appendQueryParameter("featuretype", DeepLinkConstant.FEATURES.DOWNLOAD_PAYMENTS_STATEMENT).appendQueryParameter("start", str).appendQueryParameter("end", str2);
        return builder.build().toString();
    }

    public static boolean isDirectSettlement(String str) {
        return !TextUtils.isEmpty(str) && str.equalsIgnoreCase(AppConstants.DIRECT_SETTLE_TYPE);
    }

    public static int getRequestMoneyDigitCount() {
        try {
            return Integer.parseInt(PaymentsConfig.getInstance().getGTMDataProvider().getString(PaymentsGTMConstants.KEY_REQUEST_MONEY_MAX_DIGIT_COUNT, "8"));
        } catch (Exception unused) {
            return 8;
        }
    }

    public static String formatNumber(String str, String str2) {
        try {
            NumberFormat instance = NumberFormat.getInstance(Locale.US);
            Number parse = instance.parse(str);
            double doubleValue = parse != null ? parse.doubleValue() : Double.parseDouble(str);
            DecimalFormat decimalFormat = (DecimalFormat) instance;
            decimalFormat.applyPattern(str2);
            decimalFormat.setMaximumFractionDigits(2);
            decimalFormat.setMinimumFractionDigits(2);
            return decimalFormat.format(doubleValue);
        } catch (NumberFormatException | ParseException unused) {
            return str;
        }
    }

    public static String buildScreenName(String str, String str2, String str3) {
        return "/business-app/" + str + "/" + str2 + "/" + str3;
    }
}
