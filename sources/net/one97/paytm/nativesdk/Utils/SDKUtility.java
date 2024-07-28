package net.one97.paytm.nativesdk.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import androidx.core.content.b;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
import androidx.localbroadcastmanager.a.a;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.nebula.util.H5Utils;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.utility.StringUtility;
import com.google.gson.f;
import com.google.gson.u;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.one97.paytm.nativesdk.BuildConfig;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.ConvenienceFeeController;
import net.one97.paytm.nativesdk.ConvenienceFeeOrController;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.model.ApplyPromoResponse;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.CustomVolleyError;
import net.one97.paytm.nativesdk.common.model.MerchantPayOption;
import net.one97.paytm.nativesdk.common.model.OneClickResponse;
import net.one97.paytm.nativesdk.common.model.PayChannelOptions;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.model.SavedInstruments;
import net.one97.paytm.nativesdk.common.model.SubscriptionDetailsInfo;
import net.one97.paytm.nativesdk.emiSubvention.models.Gratifications;
import net.one97.paytm.nativesdk.instruments.InstrumentActivity;
import net.one97.paytm.nativesdk.instruments.netbanking.view.NetBankingView;
import net.one97.paytm.nativesdk.instruments.upicollect.models.UpiOptionsModel;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaAccountDetail;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;
import net.one97.paytm.payments.visascp.util.TokenStatus;
import net.one97.paytm.upi.util.UpiContract;
import org.json.JSONObject;

public class SDKUtility {
    private static final String TAG_APP_LANGUAGE = "language";
    private static final String TAG_DEVICE = "device";
    private static final String TAG_IMEI = "imei";
    private static final String TAG_LANG_ID = "lang_id";
    private static final String TAG_LATITUDE = "lat";
    private static final String TAG_LONGITUDE = "long";
    private static final String TAG_NETWORK_TYPE = "networkType";
    private static final String TAG_OS_VERSION = "osVersion";
    private static final String TAG_PLAY_STORE_INSTALL = "playStore";
    private static final String TAG_SIM_1 = "sim1";
    private static final String TAG_SIM_2 = "sim2";
    public static String imeiNum = null;
    private static final String kmTagClient = "client";
    private static final String kmTagDeviceIdentifier = "deviceIdentifier";
    private static final String kmTagDeviceManufacturer = "deviceManufacturer";
    private static final String kmTagDeviceName = "deviceName";
    private static final String kmTagSessionID = "session_id";
    private static final String kmTagSsoToken = "sso_token";
    private static final String kmTagVersion = "version";
    public static String mClient = MerchantBL.getMerchantInstance().getAuthentication();
    private static Map<String, Object> mEventMap;
    private static String subscriptionMaxAmount = "";

    public static void collapse(View view) {
    }

    public static void expand(View view, Integer num) {
    }

    public static String formatNumber(String str) {
        return str;
    }

    public static int getDefaultTimeout() {
        return 30000;
    }

    public static Map<String, Object> getGenericEventParams(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/payment-gateway");
        hashMap.put("event_category", SDKConstants.GA_PAYMENT_GATEWAY);
        hashMap.put("vertical_name", DirectPaymentBL.getInstance().getVerticalName());
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("event_action", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("event_label", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("event_label2", str4);
        }
        return hashMap;
    }

    public static Map<String, Object> getVisaEventParams(String str, String str2, String str3) {
        return getGenericEventParams(SDKConstants.VSC, "", str, str2, str3, MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId());
    }

    public static Map<String, Object> getGenericEventParams(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/payment-gateway");
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("event_category", str);
        } else {
            hashMap.put("event_category", SDKConstants.GA_PAYMENT_GATEWAY);
        }
        hashMap.put("vertical_name", SDKConstants.GA_PAYMENT_GATEWAY);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("event_action", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("event_label", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put("event_label2", str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put("event_label3", str6);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, str7);
        }
        return hashMap;
    }

    public static Map<String, Object> getGenericEventParams(String str, String str2, String str3, String str4, String str5, String str6) {
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/payment-gateway");
        hashMap.put("event_category", SDKConstants.GA_PAYMENT_GATEWAY);
        hashMap.put("vertical_name", DirectPaymentBL.getInstance().getVerticalName());
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("event_action", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("event_label", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("event_label2", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put("event_label3", str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, str6);
        }
        return hashMap;
    }

    public static Map<String, Object> getGenericEventUPI(String str, String str2, String str3, String str4, String str5) {
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str);
        hashMap.put("event_category", str);
        hashMap.put("vertical_name", DirectPaymentBL.getInstance().getVerticalName());
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("event_action", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("event_label", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("event_label2", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put("event_label3", str5);
        }
        return hashMap;
    }

    public static Map<String, Object> getGenericEventNB(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str);
        hashMap.put("event_category", str);
        hashMap.put("event_label3", "transaction_status");
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("event_action", str2);
        }
        if (!TextUtils.isEmpty(MerchantBL.getMerchantInstance().getOrderId())) {
            hashMap.put("event_label", MerchantBL.getMerchantInstance().getOrderId());
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("event_label2", str3);
        }
        return hashMap;
    }

    public static Map<String, Object> getGenericEventParams(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/payment-gateway");
        hashMap.put("event_category", SDKConstants.GA_PAYMENT_GATEWAY);
        hashMap.put("vertical_name", DirectPaymentBL.getInstance().getVerticalName());
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("event_action", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("event_label", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("event_label2", str3);
        }
        return hashMap;
    }

    public static Map<String, Object> getAllInOneEventParams(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, SDKConstants.ALL_IN_ONE_SDK);
        hashMap.put("event_category", SDKConstants.ALL_IN_ONE_SDK);
        hashMap.put("vertical_name", DirectPaymentBL.getInstance().getVerticalName());
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("event_action", str);
        }
        if (MerchantBL.getMerchantInstance().getOrderId() != null && !MerchantBL.getMerchantInstance().getOrderId().isEmpty()) {
            hashMap.put("event_label", MerchantBL.getMerchantInstance().getOrderId());
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("event_label2", str2);
        }
        if (MerchantBL.getMerchantInstance().getMid() != null && !MerchantBL.getMerchantInstance().getMid().isEmpty()) {
            hashMap.put("event_label3", MerchantBL.getMerchantInstance().getMid());
        }
        return hashMap;
    }

    public static Map<String, Object> getAllInOneEventParamsBO(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, SDKConstants.ALL_IN_ONE_SDK);
        hashMap.put("event_category", SDKConstants.AI_BO_CATEGORY);
        hashMap.put("vertical_name", DirectPaymentBL.getInstance().getVerticalName());
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("event_action", str);
        }
        if (!TextUtils.isEmpty(MerchantBL.getMerchantInstance().getOrderId())) {
            hashMap.put("event_label", MerchantBL.getMerchantInstance().getOrderId());
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("event_label2", str2);
        }
        if (!TextUtils.isEmpty(MerchantBL.getMerchantInstance().getMid())) {
            hashMap.put("event_label3", MerchantBL.getMerchantInstance().getMid());
        }
        return hashMap;
    }

    public static Map<String, Object> getAllInOneEventParams(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, SDKConstants.ALL_IN_ONE_SDK);
        hashMap.put("event_category", SDKConstants.ALL_IN_ONE_SDK);
        hashMap.put("vertical_name", DirectPaymentBL.getInstance().getVerticalName());
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("event_action", str);
        }
        if (!TextUtils.isEmpty(MerchantBL.getMerchantInstance().getOrderId())) {
            hashMap.put("event_label", MerchantBL.getMerchantInstance().getOrderId());
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("event_label2", str2);
        }
        if (!TextUtils.isEmpty(MerchantBL.getMerchantInstance().getMid())) {
            hashMap.put("event_label3", MerchantBL.getMerchantInstance().getMid());
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, str3);
        }
        return hashMap;
    }

    public static void sendGaEvents(Map<String, Object> map) {
        if (PaytmSDK.getCallbackListener() != null) {
            PaytmSDK.getCallbackListener().performGAOperation(map);
        }
    }

    public static void sendGaTransactionEvent(Map<String, Object> map) {
        if (!MerchantBL.getMerchantInstance().ismWebAppInvoke()) {
            sendGaEvents(map);
        }
    }

    public static void dropBreadCrumbs(String str, String str2) {
        if (PaytmSDK.getCallbackListener() != null) {
            PaytmSDK.getCallbackListener().logCrashAnalytics(str, str2);
        }
    }

    public static void logException(String str, String str2, Throwable th) {
        if (PaytmSDK.getCallbackListener() != null) {
            PaytmSDK.getCallbackListener().logException(str, str2, th);
        }
    }

    private static String convertToStringEvent(Map<String, Object> map) {
        try {
            StringBuilder sb = new StringBuilder("{");
            for (String next : map.keySet()) {
                sb.append(next);
                sb.append(": ");
                sb.append(map.get(next));
                sb.append(StringUtility.NEW_LINE);
            }
            sb.append("}\n");
            return sb.toString();
        } catch (Exception e2) {
            if (!BuildConfig.DEBUG) {
                return "";
            }
            e2.getMessage();
            return "";
        }
    }

    public static String formatDateinMonthName(String str) {
        try {
            if (str.contains(AppUtility.CENTER_DOT)) {
                str = str.split("[.]")[0];
            }
            String format = new SimpleDateFormat("dd MMM yyyy hh:mm:ss aa", Locale.ENGLISH).format(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(str));
            String[] split = format.split(" ");
            if (format.length() >= 2) {
                return format;
            }
            return split[1] + " " + split[0];
        } catch (ParseException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String formatDateIntoDateMonthYear(String str) {
        try {
            Date parse = new SimpleDateFormat("EEE MMM dd '00:00:00 IST' yyyy").parse(str);
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            return new DecimalFormat("00").format((long) instance.get(5)) + " " + new Formatter().format("%tb", new Object[]{instance}) + " " + instance.get(1);
        } catch (ParseException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String formatDateInEnglish(Context context, String str, String str2, String str3) {
        try {
            String format = new SimpleDateFormat(str3, Locale.ENGLISH).format(new SimpleDateFormat(str2, Locale.ENGLISH).parse(str));
            format.split(" ");
            return format;
        } catch (Exception | ParseException unused) {
            return "";
        }
    }

    public static int daysBetween(Date date, Date date2) {
        if (date2.before(date)) {
            return -1;
        }
        return ((int) TimeUnit.DAYS.convert(date2.getTime() - date.getTime(), TimeUnit.MILLISECONDS)) + 1;
    }

    public static boolean isValidAmount(String str) {
        try {
            if (TextUtils.isEmpty(str) || Double.parseDouble(str) <= 0.0d) {
                return false;
            }
            return true;
        } catch (NumberFormatException e2) {
            LogUtility.printStackTrace(e2);
            return false;
        }
    }

    public static void hideKeyboard(View view, Context context) {
        if (view != null) {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            } catch (Exception e2) {
                LogUtility.printStackTrace(e2);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getCardImage(java.lang.String r2) {
        /*
            java.lang.String r2 = r2.toUpperCase()
            int r0 = r2.hashCode()
            r1 = -1
            switch(r0) {
                case -2027938206: goto L_0x005e;
                case -1934718846: goto L_0x0054;
                case 73257: goto L_0x004a;
                case 2012639: goto L_0x0040;
                case 2634817: goto L_0x0036;
                case 78339941: goto L_0x002c;
                case 1055811561: goto L_0x0022;
                case 1545480463: goto L_0x0018;
                case 2016591933: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0068
        L_0x000d:
            java.lang.String r0 = "DINERS"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0068
            r2 = 8
            goto L_0x0069
        L_0x0018:
            java.lang.String r0 = "MAESTRO"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0068
            r2 = 4
            goto L_0x0069
        L_0x0022:
            java.lang.String r0 = "DISCOVER"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0068
            r2 = 6
            goto L_0x0069
        L_0x002c:
            java.lang.String r0 = "RUPAY"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0068
            r2 = 5
            goto L_0x0069
        L_0x0036:
            java.lang.String r0 = "VISA"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0068
            r2 = 1
            goto L_0x0069
        L_0x0040:
            java.lang.String r0 = "AMEX"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0068
            r2 = 7
            goto L_0x0069
        L_0x004a:
            java.lang.String r0 = "JCB"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0068
            r2 = 3
            goto L_0x0069
        L_0x0054:
            java.lang.String r0 = "VISA_NEW"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0068
            r2 = 2
            goto L_0x0069
        L_0x005e:
            java.lang.String r0 = "MASTER"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0068
            r2 = 0
            goto L_0x0069
        L_0x0068:
            r2 = -1
        L_0x0069:
            switch(r2) {
                case 0: goto L_0x0085;
                case 1: goto L_0x0082;
                case 2: goto L_0x007f;
                case 3: goto L_0x007c;
                case 4: goto L_0x0079;
                case 5: goto L_0x0076;
                case 6: goto L_0x0073;
                case 7: goto L_0x0070;
                case 8: goto L_0x006d;
                default: goto L_0x006c;
            }
        L_0x006c:
            return r1
        L_0x006d:
            int r2 = net.one97.paytm.nativesdk.R.drawable.native_diners
            return r2
        L_0x0070:
            int r2 = net.one97.paytm.nativesdk.R.drawable.amex_logo
            return r2
        L_0x0073:
            int r2 = net.one97.paytm.nativesdk.R.drawable.discover
            return r2
        L_0x0076:
            int r2 = net.one97.paytm.nativesdk.R.drawable.rupay
            return r2
        L_0x0079:
            int r2 = net.one97.paytm.nativesdk.R.drawable.maestro
            return r2
        L_0x007c:
            int r2 = net.one97.paytm.nativesdk.R.drawable.jcb
            return r2
        L_0x007f:
            int r2 = net.one97.paytm.nativesdk.R.drawable.native_visa_logo
            return r2
        L_0x0082:
            int r2 = net.one97.paytm.nativesdk.R.drawable.visa
            return r2
        L_0x0085:
            int r2 = net.one97.paytm.nativesdk.R.drawable.master_card
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.Utils.SDKUtility.getCardImage(java.lang.String):int");
    }

    public static boolean hideKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager == null || activity.getCurrentFocus() == null) {
            return false;
        }
        return inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    public static void showKeyboard(final EditText editText) {
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                editText.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 0.0f, 0.0f, 0));
                editText.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 0.0f, 0.0f, 0));
                EditText editText = editText;
                editText.setSelection(editText.getText().length());
            }
        }, 200);
    }

    public static JSONObject getNecessaryHeadersParams(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb.toString());
            jSONObject.put("txnToken", MerchantBL.getMerchantInstance().getToken());
            jSONObject.put("channelId", SDKConstants.WAP);
            jSONObject.put(SDKConstants.VERSION, "1.0");
        } catch (Exception e2) {
            LogUtility.d("Prince", e2.getMessage());
        }
        return jSONObject;
    }

    public static JSONObject getNecessaryHeadersParams() {
        JSONObject jSONObject = new JSONObject();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb.toString());
            jSONObject.put("txnToken", MerchantBL.getMerchantInstance().getToken());
            jSONObject.put("channelId", SDKConstants.WAP);
            jSONObject.put(SDKConstants.VERSION, "1.0");
        } catch (Exception e2) {
            LogUtility.d("Prince", e2.getMessage());
        }
        return jSONObject;
    }

    public static JSONObject getNecessaryHeadersParamsWithSSO() {
        JSONObject jSONObject = new JSONObject();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb.toString());
            jSONObject.put("channelId", SDKConstants.WAP);
            jSONObject.put(SDKConstants.VERSION, "1.0");
            jSONObject.put("tokenType", SDKConstants.SSO);
            jSONObject.put(StringSet.token, MerchantBL.getMerchantInstance().getSsoToken());
        } catch (Exception e2) {
            LogUtility.d("Prince", e2.getMessage());
        }
        return jSONObject;
    }

    public static boolean isValidJSON(String str) {
        try {
            new f().a(str, Object.class);
            return true;
        } catch (u unused) {
            return false;
        }
    }

    public static int getOSVersion() {
        return Build.VERSION.SDK_INT;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return android.provider.Settings.System.getString(r2.getContentResolver(), net.one97.paytm.upi.util.UpiContract.DeviceInfoColumns.ANDROID_ID);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getAndroidId(android.content.Context r2) {
        /*
            java.lang.String r0 = "android_id"
            android.content.ContentResolver r1 = r2.getContentResolver()     // Catch:{ Exception -> 0x000b }
            java.lang.String r2 = android.provider.Settings.System.getString(r1, r0)     // Catch:{ Exception -> 0x000b }
            goto L_0x0015
        L_0x000b:
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ Exception -> 0x0014 }
            java.lang.String r2 = android.provider.Settings.System.getString(r2, r0)     // Catch:{ Exception -> 0x0014 }
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.Utils.SDKUtility.getAndroidId(android.content.Context):java.lang.String");
    }

    public static String getOtpFromSms(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        try {
            if (!str.toLowerCase().contains("paytm")) {
                return null;
            }
            Matcher matcher = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)").matcher(str2);
            if (matcher.find()) {
                return matcher.group();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isConnected();
    }

    public static String setOneClickToken(Context context, CardData cardData, String str) {
        try {
            return SDKUtils.getVisaSDK(context).setEnrollmentData(cardData.getFirstSixDigit(), cardData.getLastFourDigit(), cardData.getExpiryDate(), DirectPaymentBL.getInstance().getCustomerId(), str);
        } catch (Exception e2) {
            if (PaytmSDK.getCallbackListener() == null) {
                return "";
            }
            PaytmSDK.getCallbackListener().logException("SDKUtility", "setOneClickToken method not found", e2);
            return "";
        }
    }

    public static void checkEnrollmentForAllCards(Context context, String str, String str2) {
        SDKUtils.getVisaSDK(context).checkAllEnrolledCards(str, SDKConstants.SSO, str2, (String) null, (String) null);
    }

    public static void setConvenienceFeeText(i<SpannableString> iVar, String str, String str2, Context context) {
        setConvenienceFeeText(iVar, str, str2, context, (SpannableString) null);
    }

    public static void setConvenienceFeeText(i<SpannableString> iVar, String str, String str2, Context context, SpannableString spannableString) {
        SpannableString spannableString2;
        if (!TextUtils.isEmpty(spannableString)) {
            iVar.set(spannableString);
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            spannableString2 = new SpannableString(context.getString(R.string.conv_fee_default_msg, new Object[]{str}));
        } else if (isAppInvokeFlow()) {
            spannableString2 = new SpannableString(str2);
        } else {
            spannableString2 = new SpannableString(context.getString(R.string.nativesdk_conv_amount_holder, new Object[]{str2, str}));
        }
        iVar.set(spannableString2);
    }

    public static boolean isValidMobileNo(Context context, String str) {
        return Pattern.compile(SDKConstants.MOB_NO_REG_EX).matcher(str).find();
    }

    public static String getDeviceId(Context context) {
        return PermissionUtil.checkPhoneStatePermission(context) ? Settings.Secure.getString(context.getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID) : "";
    }

    public static String getRequestId(Context context) {
        return getAndroidId(context) + System.currentTimeMillis();
    }

    public static boolean isPaytmApp(Context context) {
        if (!BuildConfig.DEBUG || !context.getPackageName().contains("net.one97.paytm")) {
            return "net.one97.paytm".equals(context.getPackageName());
        }
        return true;
    }

    public static String addAuthDefaultParams(Context context, String str) {
        if (context == null) {
            return str;
        }
        String authDefaultParams = getAuthDefaultParams(context);
        if (!TextUtils.isEmpty(str) && str.contains("?")) {
            authDefaultParams = AppConstants.AND_SIGN + authDefaultParams.substring(1);
        }
        return str + authDefaultParams;
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0289  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006d A[Catch:{ UnsupportedEncodingException -> 0x0091, Exception -> 0x008f }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a4 A[Catch:{ UnsupportedEncodingException -> 0x00c8, Exception -> 0x00c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x022f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getAuthDefaultParams(android.content.Context r10) {
        /*
            java.lang.String r0 = "_"
            java.lang.String r1 = " "
            java.lang.String r2 = "UTF-8"
            java.lang.String r3 = "phone"
            java.lang.Object r3 = r10.getSystemService(r3)
            android.telephony.TelephonyManager r3 = (android.telephony.TelephonyManager) r3
            generateNewSessionId(r10)
            android.content.pm.PackageManager r4 = r10.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0021, RuntimeException -> 0x0025 }
            java.lang.String r5 = r10.getPackageName()     // Catch:{ NameNotFoundException -> 0x0021, RuntimeException -> 0x0025 }
            r6 = 0
            android.content.pm.PackageInfo r4 = r4.getPackageInfo(r5, r6)     // Catch:{ NameNotFoundException -> 0x0021, RuntimeException -> 0x0025 }
            java.lang.String r4 = r4.versionName     // Catch:{ NameNotFoundException -> 0x0021, RuntimeException -> 0x0025 }
            goto L_0x0027
        L_0x0021:
            r4 = move-exception
            net.one97.paytm.nativesdk.Utils.LogUtility.printStackTrace(r4)
        L_0x0025:
            java.lang.String r4 = ""
        L_0x0027:
            java.lang.String r5 = android.os.Build.MANUFACTURER
            java.lang.String r6 = android.os.Build.MODEL
            java.lang.String r3 = getDeviceIdentifier(r10, r3)
            java.lang.String r3 = java.net.URLEncoder.encode(r3, r2)     // Catch:{ UnsupportedEncodingException -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r7 = move-exception
            net.one97.paytm.nativesdk.Utils.LogUtility.printStackTrace(r7)
        L_0x0038:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "?"
            r7.<init>(r8)
            r8 = 1
            if (r3 == 0) goto L_0x0063
            int r9 = r7.length()
            if (r9 <= r8) goto L_0x0056
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r9 = "&deviceIdentifier="
            java.lang.String r3 = r9.concat(r3)
            r7.append(r3)
            goto L_0x0063
        L_0x0056:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r9 = "deviceIdentifier="
            java.lang.String r3 = r9.concat(r3)
            r7.append(r3)
        L_0x0063:
            java.lang.String r3 = r5.replaceAll(r1, r0)     // Catch:{ UnsupportedEncodingException -> 0x0091, Exception -> 0x008f }
            java.lang.String r3 = java.net.URLEncoder.encode(r3, r2)     // Catch:{ UnsupportedEncodingException -> 0x0091, Exception -> 0x008f }
            if (r3 == 0) goto L_0x009a
            int r5 = r7.length()     // Catch:{ UnsupportedEncodingException -> 0x0091, Exception -> 0x008f }
            if (r5 <= r8) goto L_0x0081
            java.lang.String r5 = "&deviceManufacturer="
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ UnsupportedEncodingException -> 0x0091, Exception -> 0x008f }
            java.lang.String r3 = r5.concat(r3)     // Catch:{ UnsupportedEncodingException -> 0x0091, Exception -> 0x008f }
            r7.append(r3)     // Catch:{ UnsupportedEncodingException -> 0x0091, Exception -> 0x008f }
            goto L_0x009a
        L_0x0081:
            java.lang.String r5 = "deviceManufacturer="
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ UnsupportedEncodingException -> 0x0091, Exception -> 0x008f }
            java.lang.String r3 = r5.concat(r3)     // Catch:{ UnsupportedEncodingException -> 0x0091, Exception -> 0x008f }
            r7.append(r3)     // Catch:{ UnsupportedEncodingException -> 0x0091, Exception -> 0x008f }
            goto L_0x009a
        L_0x008f:
            r3 = move-exception
            goto L_0x0093
        L_0x0091:
            r3 = move-exception
            goto L_0x0097
        L_0x0093:
            net.one97.paytm.nativesdk.Utils.LogUtility.printStackTrace(r3)
            goto L_0x009a
        L_0x0097:
            net.one97.paytm.nativesdk.Utils.LogUtility.printStackTrace(r3)
        L_0x009a:
            java.lang.String r0 = r6.replaceAll(r1, r0)     // Catch:{ UnsupportedEncodingException -> 0x00c8, Exception -> 0x00c6 }
            java.lang.String r0 = java.net.URLEncoder.encode(r0, r2)     // Catch:{ UnsupportedEncodingException -> 0x00c8, Exception -> 0x00c6 }
            if (r0 == 0) goto L_0x00d1
            int r1 = r7.length()     // Catch:{ UnsupportedEncodingException -> 0x00c8, Exception -> 0x00c6 }
            if (r1 <= r8) goto L_0x00b8
            java.lang.String r1 = "&deviceName="
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ UnsupportedEncodingException -> 0x00c8, Exception -> 0x00c6 }
            java.lang.String r0 = r1.concat(r0)     // Catch:{ UnsupportedEncodingException -> 0x00c8, Exception -> 0x00c6 }
            r7.append(r0)     // Catch:{ UnsupportedEncodingException -> 0x00c8, Exception -> 0x00c6 }
            goto L_0x00d1
        L_0x00b8:
            java.lang.String r1 = "deviceName="
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ UnsupportedEncodingException -> 0x00c8, Exception -> 0x00c6 }
            java.lang.String r0 = r1.concat(r0)     // Catch:{ UnsupportedEncodingException -> 0x00c8, Exception -> 0x00c6 }
            r7.append(r0)     // Catch:{ UnsupportedEncodingException -> 0x00c8, Exception -> 0x00c6 }
            goto L_0x00d1
        L_0x00c6:
            r0 = move-exception
            goto L_0x00ca
        L_0x00c8:
            r0 = move-exception
            goto L_0x00ce
        L_0x00ca:
            net.one97.paytm.nativesdk.Utils.LogUtility.printStackTrace(r0)
            goto L_0x00d1
        L_0x00ce:
            net.one97.paytm.nativesdk.Utils.LogUtility.printStackTrace(r0)
        L_0x00d1:
            java.lang.String r0 = mClient
            if (r0 == 0) goto L_0x0103
            int r0 = r7.length()
            if (r0 <= r8) goto L_0x00ef
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "&client="
            r0.<init>(r1)
            java.lang.String r1 = mClient
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.append(r0)
            goto L_0x0114
        L_0x00ef:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "client="
            r0.<init>(r1)
            java.lang.String r1 = mClient
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.append(r0)
            goto L_0x0114
        L_0x0103:
            int r0 = r7.length()
            if (r0 <= r8) goto L_0x010f
            java.lang.String r0 = "&client=androidapp"
            r7.append(r0)
            goto L_0x0114
        L_0x010f:
            java.lang.String r0 = "client=androidapp"
            r7.append(r0)
        L_0x0114:
            if (r4 == 0) goto L_0x0137
            int r0 = r7.length()
            if (r0 <= r8) goto L_0x012a
            java.lang.String r0 = java.lang.String.valueOf(r4)
            java.lang.String r1 = "&version="
            java.lang.String r0 = r1.concat(r0)
            r7.append(r0)
            goto L_0x0137
        L_0x012a:
            java.lang.String r0 = java.lang.String.valueOf(r4)
            java.lang.String r1 = "version="
            java.lang.String r0 = r1.concat(r0)
            r7.append(r0)
        L_0x0137:
            boolean r0 = isPlayStoreInstall(r10)
            if (r0 == 0) goto L_0x014f
            int r0 = r7.length()
            if (r0 <= r8) goto L_0x0149
            java.lang.String r0 = "&playStore=true"
            r7.append(r0)
            goto L_0x0160
        L_0x0149:
            java.lang.String r0 = "playStore=true"
            r7.append(r0)
            goto L_0x0160
        L_0x014f:
            int r0 = r7.length()
            if (r0 <= r8) goto L_0x015b
            java.lang.String r0 = "&playStore=false"
            r7.append(r0)
            goto L_0x0160
        L_0x015b:
            java.lang.String r0 = "playStore=false"
            r7.append(r0)
        L_0x0160:
            net.one97.paytm.nativesdk.Utils.LocationManager r0 = net.one97.paytm.nativesdk.Utils.LocationManager.getManger()
            android.location.Location r0 = r0.getLocation(r10)
            java.lang.String r1 = getLatitude(r0)
            java.lang.String r0 = getLongitude(r0)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r3 = "0.0"
            if (r2 == 0) goto L_0x0179
            r1 = r3
        L_0x0179:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x0180
            r0 = r3
        L_0x0180:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x01c3
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x01c3
            int r2 = r7.length()
            java.lang.String r3 = "&long="
            if (r2 <= r8) goto L_0x01ac
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "&lat="
            r2.<init>(r4)
            r2.append(r1)
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r7.append(r0)
            goto L_0x01c3
        L_0x01ac:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "lat="
            r2.<init>(r4)
            r2.append(r1)
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r7.append(r0)
        L_0x01c3:
            java.lang.String r0 = getLanguage(r10)
            if (r0 == 0) goto L_0x01f4
            java.lang.String r1 = r0.trim()
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x01f4
            int r1 = r7.length()
            if (r1 <= r8) goto L_0x01e7
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "&language="
            java.lang.String r0 = r1.concat(r0)
            r7.append(r0)
            goto L_0x01f4
        L_0x01e7:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "language="
            java.lang.String r0 = r1.concat(r0)
            r7.append(r0)
        L_0x01f4:
            java.lang.String r0 = getNetworkType(r10)
            if (r0 == 0) goto L_0x0225
            java.lang.String r1 = r0.trim()
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0225
            int r1 = r7.length()
            if (r1 <= r8) goto L_0x0218
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "&networkType="
            java.lang.String r0 = r1.concat(r0)
            r7.append(r0)
            goto L_0x0225
        L_0x0218:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "networkType="
            java.lang.String r0 = r1.concat(r0)
            r7.append(r0)
        L_0x0225:
            java.lang.String r0 = getImeiNumber(r10)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0250
            int r1 = r7.length()
            if (r1 <= r8) goto L_0x0243
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "&imei="
            java.lang.String r0 = r1.concat(r0)
            r7.append(r0)
            goto L_0x0250
        L_0x0243:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "imei="
            java.lang.String r0 = r1.concat(r0)
            r7.append(r0)
        L_0x0250:
            java.lang.String r0 = getOSReleaseVersion()
            java.lang.String r1 = getOSReleaseVersion()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x027f
            int r1 = r7.length()
            if (r1 <= r8) goto L_0x0272
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "&osVersion="
            java.lang.String r0 = r1.concat(r0)
            r7.append(r0)
            goto L_0x027f
        L_0x0272:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "osVersion="
            java.lang.String r0 = r1.concat(r0)
            r7.append(r0)
        L_0x027f:
            java.lang.String r10 = getSimSerialNumber(r10)
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto L_0x02aa
            int r0 = r7.length()
            if (r0 <= r8) goto L_0x029d
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.String r0 = "&sim1="
            java.lang.String r10 = r0.concat(r10)
            r7.append(r10)
            goto L_0x02aa
        L_0x029d:
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.String r0 = "sim1="
            java.lang.String r10 = r0.concat(r10)
            r7.append(r10)
        L_0x02aa:
            java.lang.String r10 = r7.toString()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.Utils.SDKUtility.getAuthDefaultParams(android.content.Context):java.lang.String");
    }

    public static String getDeviceIdentifier(Context context, TelephonyManager telephonyManager) {
        String uniqueDeviceId = getUniqueDeviceId(context, telephonyManager);
        String replaceAll = (Build.MANUFACTURER + "-" + Build.MODEL + "-" + uniqueDeviceId).replaceAll(" ", "");
        LogUtility.d("", "Device identifier is : ".concat(String.valueOf(replaceAll)));
        return replaceAll;
    }

    public static VpaBankAccountDetail getRegisteredVpa(String str) {
        List<VpaBankAccountDetail> allVpas = getAllVpas();
        if (allVpas == null || allVpas.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i2 = 0; i2 < allVpas.size(); i2++) {
            if (allVpas.get(i2).getVpaDetail() != null && str.trim().equalsIgnoreCase(allVpas.get(i2).getVpaDetail().getName())) {
                return allVpas.get(i2);
            }
        }
        return null;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x00b0 */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00be A[Catch:{ Exception -> 0x00e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cc A[Catch:{ Exception -> 0x00e8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getUniqueDeviceId(android.content.Context r7, android.telephony.TelephonyManager r8) {
        /*
            java.lang.String r0 = "uniqueid"
            java.lang.String r1 = "SDKUtility"
            net.one97.paytm.nativesdk.MerchantBL r2 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            java.lang.String r2 = r2.getDeviceId()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x001b
            net.one97.paytm.nativesdk.MerchantBL r7 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            java.lang.String r7 = r7.getDeviceId()
            return r7
        L_0x001b:
            java.lang.String r2 = imeiNum
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0026
            java.lang.String r7 = imeiNum
            return r7
        L_0x0026:
            net.one97.paytm.nativesdk.Utils.SharedPreferenceUtil r2 = net.one97.paytm.nativesdk.Utils.SharedPreferenceUtil.getInstance()
            java.lang.String r3 = "imei"
            java.lang.String r4 = ""
            java.lang.String r2 = r2.getString(r3, r4)
            boolean r5 = android.text.TextUtils.isEmpty(r2)
            if (r5 != 0) goto L_0x003b
            imeiNum = r2
            return r2
        L_0x003b:
            r2 = 0
            android.content.ContentResolver r5 = r7.getContentResolver()     // Catch:{ Exception -> 0x0061 }
            java.lang.String r6 = "android_id"
            java.lang.String r2 = android.provider.Settings.Secure.getString(r5, r6)     // Catch:{ Exception -> 0x0061 }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0061 }
            if (r5 != 0) goto L_0x0069
            net.one97.paytm.nativesdk.Utils.SharedPreferenceUtil r5 = net.one97.paytm.nativesdk.Utils.SharedPreferenceUtil.getInstance()     // Catch:{ Exception -> 0x0061 }
            r5.setString(r3, r2)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r5 = "Android Id is : "
            java.lang.String r6 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r5 = r5.concat(r6)     // Catch:{ Exception -> 0x0061 }
            net.one97.paytm.nativesdk.Utils.LogUtility.d(r1, r5)     // Catch:{ Exception -> 0x0061 }
            return r2
        L_0x0061:
            r5 = move-exception
            java.lang.String r5 = r5.toString()
            net.one97.paytm.nativesdk.Utils.LogUtility.e(r1, r5)
        L_0x0069:
            java.lang.String r5 = "android.permission.READ_PHONE_STATE"
            int r7 = androidx.core.content.b.a((android.content.Context) r7, (java.lang.String) r5)     // Catch:{ Exception -> 0x0090 }
            if (r7 != 0) goto L_0x0075
            java.lang.String r2 = r8.getDeviceId()     // Catch:{ Exception -> 0x0090 }
        L_0x0075:
            boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0090 }
            if (r7 != 0) goto L_0x0098
            net.one97.paytm.nativesdk.Utils.SharedPreferenceUtil r7 = net.one97.paytm.nativesdk.Utils.SharedPreferenceUtil.getInstance()     // Catch:{ Exception -> 0x0090 }
            r7.setString(r3, r2)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r7 = "IMEI number is : "
            java.lang.String r3 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r7 = r7.concat(r3)     // Catch:{ Exception -> 0x0090 }
            net.one97.paytm.nativesdk.Utils.LogUtility.d(r1, r7)     // Catch:{ Exception -> 0x0090 }
            return r2
        L_0x0090:
            r7 = move-exception
            java.lang.String r7 = r7.toString()
            net.one97.paytm.nativesdk.Utils.LogUtility.e(r1, r7)
        L_0x0098:
            java.lang.String r2 = r8.getSubscriberId()     // Catch:{ Exception -> 0x00b0 }
            boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x00b0 }
            if (r7 != 0) goto L_0x00b0
            java.lang.String r7 = "Subscriber Id is : "
            java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r7 = r7.concat(r8)     // Catch:{ Exception -> 0x00b0 }
            net.one97.paytm.nativesdk.Utils.LogUtility.d(r4, r7)     // Catch:{ Exception -> 0x00b0 }
            return r2
        L_0x00b0:
            net.one97.paytm.nativesdk.Utils.SharedPreferenceUtil r7 = net.one97.paytm.nativesdk.Utils.SharedPreferenceUtil.getInstance()     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r2 = r7.getString(r0, r4)     // Catch:{ Exception -> 0x00e8 }
            boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x00e8 }
            if (r7 != 0) goto L_0x00cc
            java.lang.String r7 = "Use existing uniqe id : "
            java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r7 = r7.concat(r8)     // Catch:{ Exception -> 0x00e8 }
            net.one97.paytm.nativesdk.Utils.LogUtility.d(r4, r7)     // Catch:{ Exception -> 0x00e8 }
            return r2
        L_0x00cc:
            java.util.UUID r7 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r2 = r7.toString()     // Catch:{ Exception -> 0x00e8 }
            net.one97.paytm.nativesdk.Utils.SharedPreferenceUtil r7 = net.one97.paytm.nativesdk.Utils.SharedPreferenceUtil.getInstance()     // Catch:{ Exception -> 0x00e8 }
            r7.setString(r0, r2)     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r7 = "Create New uniqe id : "
            java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r7 = r7.concat(r8)     // Catch:{ Exception -> 0x00e8 }
            net.one97.paytm.nativesdk.Utils.LogUtility.d(r4, r7)     // Catch:{ Exception -> 0x00e8 }
        L_0x00e8:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.Utils.SDKUtility.getUniqueDeviceId(android.content.Context, android.telephony.TelephonyManager):java.lang.String");
    }

    public static String getLatitude(Location location) {
        if (location != null) {
            try {
                return Double.toString(location.getLatitude());
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String getLongitude(Location location) {
        if (location != null) {
            try {
                return Double.toString(location.getLongitude());
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String getLanguage(Context context) {
        return Resources.getSystem().getConfiguration().locale.getLanguage();
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
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getNetworkType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getType() == 1) {
                        return H5Utils.NETWORK_TYPE_WIFI;
                    }
                    if (activeNetworkInfo.getType() == 0) {
                        switch (activeNetworkInfo.getSubtype()) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                                return H5Utils.NETWORK_TYPE_2G;
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                                return H5Utils.NETWORK_TYPE_3G;
                            case 13:
                                return H5Utils.NETWORK_TYPE_4G;
                            default:
                                return null;
                        }
                    }
                }
            }
            return null;
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
            return null;
        }
    }

    public static String getImeiNumber(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(ContactColumn.PHONE_NUMBER);
            if (telephonyManager == null || b.a(context, "android.permission.READ_PHONE_STATE") != 0) {
                return null;
            }
            return telephonyManager.getDeviceId();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getOSReleaseVersion() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Exception unused) {
            return null;
        }
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
        } catch (Exception unused) {
            return null;
        }
    }

    public static String generateNewSessionId(Context context) {
        return generateSessionId(context, (TelephonyManager) context.getSystemService(ContactColumn.PHONE_NUMBER), String.valueOf((int) System.currentTimeMillis()));
    }

    public static String generateSessionId(Context context, TelephonyManager telephonyManager, String str) {
        String uniqueDeviceId = getUniqueDeviceId(context, telephonyManager);
        return md5(uniqueDeviceId + str);
    }

    public static String md5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            int length = digest.length;
            StringBuilder sb = new StringBuilder(length << 1);
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(Character.forDigit((digest[i2] & 240) >> 4, 16));
                sb.append(Character.forDigit(digest[i2] & 15, 16));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String getDoubleFormaAmount(double d2) {
        return String.format(Locale.ENGLISH, "%.2f", new Object[]{Double.valueOf(d2)});
    }

    public static String getAmountwithComma(String str) {
        return new DecimalFormat("##,##,###.00").format(str);
    }

    public static String priceWithDecimal(Double d2) {
        return new DecimalFormat("##,##,##,##,###.00").format(d2);
    }

    public static String priceWithoutDecimal(String str) {
        DecimalFormat decimalFormat;
        try {
            double parseDouble = Double.parseDouble(str);
            if (parseDouble < 1.0d && parseDouble > 0.0d) {
                decimalFormat = new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.US));
            } else if (((int) Math.ceil(parseDouble)) == ((int) Math.floor(parseDouble))) {
                decimalFormat = new DecimalFormat("##,##,##,##,###", new DecimalFormatSymbols(Locale.US));
            } else {
                decimalFormat = new DecimalFormat("##,##,##,##,###.00", new DecimalFormatSymbols(Locale.US));
            }
            return decimalFormat.format(parseDouble);
        } catch (Exception unused) {
            return str;
        }
    }

    public static String priceWithoutDecimal(double d2) {
        DecimalFormat decimalFormat;
        if (d2 < 1.0d && d2 > 0.0d) {
            try {
                decimalFormat = new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.US));
            } catch (Exception unused) {
                return String.valueOf(d2);
            }
        } else if (((int) Math.ceil(d2)) == ((int) Math.floor(d2))) {
            decimalFormat = new DecimalFormat("##,##,##,##,###", new DecimalFormatSymbols(Locale.US));
        } else {
            decimalFormat = new DecimalFormat("##,##,##,##,###.00", new DecimalFormatSymbols(Locale.US));
        }
        return decimalFormat.format(d2);
    }

    public static double getDiffAmount() {
        double parseDouble = parseDouble(DirectPaymentBL.getInstance().getInstrumentBalance(PayMethodType.BALANCE));
        double parseDouble2 = !TextUtils.isEmpty(MerchantBL.getMerchantInstance().getAmount()) ? parseDouble(MerchantBL.getMerchantInstance().getAmount().replace(AppConstants.COMMA, "")) : 0.0d;
        if (isHybridCase()) {
            parseDouble2 -= parseDouble;
        }
        return ((double) Math.round(parseDouble2 * 100.0d)) / 100.0d;
    }

    public static boolean isHybridCase() {
        if (!DirectPaymentBL.getInstance().isWalletEnabledOnMerchant() || DirectPaymentBL.getInstance().isWalletAmountSufficientToPay() || ((!SDKConstants.HYBRID.equalsIgnoreCase(DirectPaymentBL.getInstance().getPaymentFlowAvailable()) && !SDKConstants.ADDANDPAY.equalsIgnoreCase(DirectPaymentBL.getInstance().getPaymentFlowAvailable())) || !DirectPaymentBL.getInstance().isPaytmWalletChecked())) {
            return false;
        }
        if (!DirectPaymentBL.getInstance().isSubsCriptionFlow() || DirectPaymentBL.getInstance().isWalletOtpValidated()) {
            return true;
        }
        return false;
    }

    public static boolean isSubscriptionAmountZero() {
        return MerchantBL.getMerchantInstance().isZeroSubscriptionFlow;
    }

    public static boolean isHybridSupported() {
        String instrumentBalance = DirectPaymentBL.getInstance().getInstrumentBalance(PayMethodType.BALANCE);
        if (!TextUtils.isEmpty(instrumentBalance) && parseDouble(instrumentBalance) > 0.0d && !DirectPaymentBL.getInstance().isRemainingAmountInDecimals() && DirectPaymentBL.getInstance().isWalletEnabledOnMerchant() && !DirectPaymentBL.getInstance().isWalletAmountSufficientToPay() && SDKConstants.HYBRID.equalsIgnoreCase(DirectPaymentBL.getInstance().getPaymentFlowAvailable())) {
            return true;
        }
        return false;
    }

    public static double parseDouble(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0.0d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return 0.0d;
        }
    }

    public static boolean applyLuhnCheck(String str) {
        if (!Pattern.compile("^[0-9]\\d*$").matcher(str).matches()) {
            return false;
        }
        int i2 = 0;
        boolean z = false;
        for (int length = str.length() - 1; length >= 0; length--) {
            int parseInt = Integer.parseInt(str.substring(length, length + 1));
            if (z && (parseInt = parseInt * 2) > 9) {
                parseInt = (parseInt % 10) + 1;
            }
            i2 += parseInt;
            z = !z;
        }
        if (i2 % 10 == 0) {
            return true;
        }
        return false;
    }

    public static boolean isPayableAmountGreaterThanOwnedMoney(String str, boolean z, double d2) {
        double d3;
        double parseDouble = Double.parseDouble(str);
        if (z) {
            d3 = Double.valueOf(DirectPaymentBL.getInstance().getDifferentialAmount()).doubleValue();
        } else {
            d3 = !TextUtils.isEmpty(MerchantBL.getMerchantInstance().getAmount()) ? parseDouble(MerchantBL.getMerchantInstance().getAmount().replace(AppConstants.COMMA, "")) : 0.0d;
        }
        int compare = Double.compare(parseDouble, d3 + d2);
        if (compare > 0) {
            System.out.println("d1 is greater than d2");
            return true;
        } else if (compare < 0) {
            System.out.println("d1 is less than d2");
            return false;
        } else {
            System.out.println("d1 is equal to d2");
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isPayableAmountGreaterThanOwnedMoney(java.lang.String r4, double r5, boolean r7, double r8) {
        /*
            double r0 = java.lang.Double.parseDouble(r4)
            if (r7 == 0) goto L_0x0018
            net.one97.paytm.nativesdk.DirectPaymentBL r4 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            java.lang.String r4 = r4.getDifferentialAmount()
            java.lang.Double r4 = java.lang.Double.valueOf(r4)
            double r2 = r4.doubleValue()
        L_0x0016:
            double r2 = r2 - r5
            goto L_0x003d
        L_0x0018:
            net.one97.paytm.nativesdk.MerchantBL r4 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            java.lang.String r4 = r4.getAmount()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x003b
            net.one97.paytm.nativesdk.MerchantBL r4 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            java.lang.String r4 = r4.getAmount()
            java.lang.String r7 = ","
            java.lang.String r2 = ""
            java.lang.String r4 = r4.replace(r7, r2)
            double r2 = parseDouble(r4)
            goto L_0x0016
        L_0x003b:
            r2 = 0
        L_0x003d:
            double r2 = r2 + r8
            int r4 = java.lang.Double.compare(r0, r2)
            r5 = 1
            if (r4 <= 0) goto L_0x004d
            java.io.PrintStream r4 = java.lang.System.out
            java.lang.String r6 = "d1 is greater than d2"
            r4.println(r6)
            return r5
        L_0x004d:
            if (r4 >= 0) goto L_0x0058
            java.io.PrintStream r4 = java.lang.System.out
            java.lang.String r5 = "d1 is less than d2"
            r4.println(r5)
            r4 = 0
            return r4
        L_0x0058:
            java.io.PrintStream r4 = java.lang.System.out
            java.lang.String r6 = "d1 is equal to d2"
            r4.println(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.Utils.SDKUtility.isPayableAmountGreaterThanOwnedMoney(java.lang.String, double, boolean, double):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006f A[Catch:{ Exception -> 0x007b }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail> getAllVpas() {
        /*
            r0 = 0
            boolean r1 = isUpiPushEnabledOnMerchant()     // Catch:{ Exception -> 0x007b }
            if (r1 != 0) goto L_0x000e
            boolean r1 = isUpiCollectEnabled()     // Catch:{ Exception -> 0x007b }
            if (r1 != 0) goto L_0x000e
            return r0
        L_0x000e:
            java.lang.String r1 = "ADDANDPAY"
            net.one97.paytm.nativesdk.DirectPaymentBL r2 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()     // Catch:{ Exception -> 0x007b }
            java.lang.String r2 = r2.getSelectedPaymentMode()     // Catch:{ Exception -> 0x007b }
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x007b }
            if (r1 == 0) goto L_0x0045
            boolean r1 = net.one97.paytm.nativesdk.Utils.SDKUtils.checkIfAddMoneyVpaExist()     // Catch:{ Exception -> 0x007b }
            if (r1 == 0) goto L_0x006c
            net.one97.paytm.nativesdk.DirectPaymentBL r1 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()     // Catch:{ Exception -> 0x007b }
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r1 = r1.getCjPayMethodResponse()     // Catch:{ Exception -> 0x007b }
            net.one97.paytm.nativesdk.common.model.Body r1 = r1.getBody()     // Catch:{ Exception -> 0x007b }
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r1 = r1.getAddMoneyPayOption()     // Catch:{ Exception -> 0x007b }
            net.one97.paytm.nativesdk.instruments.upipush.model.UpiProfile r1 = r1.getUpiProfile()     // Catch:{ Exception -> 0x007b }
            net.one97.paytm.nativesdk.instruments.upipush.model.ResponseDetails r1 = r1.getRespDetails()     // Catch:{ Exception -> 0x007b }
            net.one97.paytm.nativesdk.instruments.upipush.model.ProfileData r1 = r1.getProfileDetail()     // Catch:{ Exception -> 0x007b }
            java.util.List r1 = r1.getBankAccounts()     // Catch:{ Exception -> 0x007b }
            goto L_0x006d
        L_0x0045:
            boolean r1 = net.one97.paytm.nativesdk.Utils.SDKUtils.checkIfMerchantPayVpaExist()     // Catch:{ Exception -> 0x007b }
            if (r1 == 0) goto L_0x006c
            net.one97.paytm.nativesdk.DirectPaymentBL r1 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()     // Catch:{ Exception -> 0x007b }
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r1 = r1.getCjPayMethodResponse()     // Catch:{ Exception -> 0x007b }
            net.one97.paytm.nativesdk.common.model.Body r1 = r1.getBody()     // Catch:{ Exception -> 0x007b }
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r1 = r1.getMerchantPayOption()     // Catch:{ Exception -> 0x007b }
            net.one97.paytm.nativesdk.instruments.upipush.model.UpiProfile r1 = r1.getUpiProfile()     // Catch:{ Exception -> 0x007b }
            net.one97.paytm.nativesdk.instruments.upipush.model.ResponseDetails r1 = r1.getRespDetails()     // Catch:{ Exception -> 0x007b }
            net.one97.paytm.nativesdk.instruments.upipush.model.ProfileData r1 = r1.getProfileDetail()     // Catch:{ Exception -> 0x007b }
            java.util.List r1 = r1.getBankAccounts()     // Catch:{ Exception -> 0x007b }
            goto L_0x006d
        L_0x006c:
            r1 = r0
        L_0x006d:
            if (r1 == 0) goto L_0x007a
            int r2 = r1.size()     // Catch:{ Exception -> 0x007b }
            if (r2 > 0) goto L_0x0076
            goto L_0x007a
        L_0x0076:
            java.util.List r0 = filterVpas(r1)     // Catch:{ Exception -> 0x007b }
        L_0x007a:
            return r0
        L_0x007b:
            java.lang.String r1 = "Prince"
            java.lang.String r2 = "Vpas not present"
            net.one97.paytm.nativesdk.Utils.LogUtility.d(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.Utils.SDKUtility.getAllVpas():java.util.List");
    }

    public static List<VpaBankAccountDetail> getAllUnFilteredVpas() {
        List<VpaBankAccountDetail> list;
        try {
            if (!isUpiPushEnabledOnMerchant() && !isUpiCollectEnabled()) {
                return null;
            }
            if (!SDKConstants.ADDANDPAY.equalsIgnoreCase(DirectPaymentBL.getInstance().getSelectedPaymentMode()) || !SDKUtils.checkIfAddMoneyVpaExist()) {
                list = SDKUtils.checkIfMerchantPayVpaExist() ? DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getMerchantPayOption().getUpiProfile().getRespDetails().getProfileDetail().getBankAccounts() : null;
            } else {
                list = DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getAddMoneyPayOption().getUpiProfile().getRespDetails().getProfileDetail().getBankAccounts();
            }
            if (list == null || list.size() <= 0) {
                return null;
            }
            return list;
        } catch (Exception unused) {
            LogUtility.d("Prince", "Vpas not present");
            return null;
        }
    }

    public static List<VpaAccountDetail> getAllVpaDetails() {
        List<VpaAccountDetail> list;
        try {
            if (!isUpiPushEnabledOnMerchant() && !isUpiCollectEnabled()) {
                return null;
            }
            if (!SDKConstants.ADDANDPAY.equalsIgnoreCase(DirectPaymentBL.getInstance().getSelectedPaymentMode()) || !SDKUtils.checkIfAddMoneyVpaExist()) {
                list = SDKUtils.checkIfMerchantVpaExist() ? DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getMerchantPayOption().getUpiProfile().getRespDetails().getProfileDetail().getVpaDetails() : null;
            } else {
                list = DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getAddMoneyPayOption().getUpiProfile().getRespDetails().getProfileDetail().getVpaDetails();
            }
            if (list == null || list.size() <= 0) {
                return null;
            }
            return list;
        } catch (Exception unused) {
            LogUtility.d("Prince", "Vpas not present");
            return null;
        }
    }

    public static boolean isPPBBankUpiAvailable() {
        List<VpaBankAccountDetail> allUnFilteredVpas;
        if (DirectPaymentBL.getInstance().isPPBUpiFlag() && (allUnFilteredVpas = getAllUnFilteredVpas()) != null && !allUnFilteredVpas.isEmpty()) {
            int i2 = 0;
            while (i2 < allUnFilteredVpas.size()) {
                try {
                    if (allUnFilteredVpas.get(i2).getBank().contains("Paytm") && "Y".equalsIgnoreCase(allUnFilteredVpas.get(i2).getMpinSet())) {
                        return true;
                    }
                    i2++;
                } catch (Exception unused) {
                }
            }
        }
        return false;
    }

    public static List<VpaBankAccountDetail> filterVpas(List<VpaBankAccountDetail> list) {
        ArrayList arrayList = new ArrayList();
        for (VpaBankAccountDetail next : list) {
            if ((next.getBank() == null || !next.getBank().toLowerCase().contains("paytm") || "Y".equalsIgnoreCase(next.getMpinSet())) && (next.getBank() == null || !next.getBank().toLowerCase().contains("paytm") || !"Y".equalsIgnoreCase(next.getMpinSet()) || DirectPaymentBL.getInstance().isPPBUpiFlag())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static List<VpaBankAccountDetail> filterVpasOrFlow(List<VpaBankAccountDetail> list) {
        return new ArrayList(list);
    }

    public static String getLastFourDigitAccountNumber(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.substring(str.length() - 4, str.length());
    }

    public static String getMobile() {
        return MerchantBL.getMerchantInstance().getSsoMobileNumber();
    }

    public static String maskNumber(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 4) {
            return str;
        }
        return " •••• " + str.substring(str.length() - 4);
    }

    public static boolean isUpiPushEnabled() {
        try {
            MerchantPayOption merchantPayMethod = DirectPaymentBL.getInstance().getMerchantPayMethod();
            if (merchantPayMethod == null || merchantPayMethod.getPaymentModes() == null || merchantPayMethod.getPaymentModes().size() <= 0) {
                return false;
            }
            Iterator<PaymentModes> it2 = merchantPayMethod.getPaymentModes().iterator();
            while (it2.hasNext()) {
                PaymentModes next = it2.next();
                if (next.getPaymentMode().equalsIgnoreCase("UPI") && next.getPayChannelOptions() != null && next.getPayChannelOptions().size() > 0) {
                    Iterator<PayChannelOptions> it3 = next.getPayChannelOptions().iterator();
                    while (it3.hasNext()) {
                        PayChannelOptions next2 = it3.next();
                        if (!TextUtils.isEmpty(next2.getChannelCode()) && SDKConstants.UPIPUSHEXPRESS.equalsIgnoreCase(next2.getChannelCode())) {
                            if (next2.getIsDisabled() == null || !next2.getIsDisabled().getStatus()) {
                                if (DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getMerchantDetails() != null) {
                                    return true;
                                }
                                return false;
                            }
                        }
                    }
                    continue;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isUpiPushEnabledOnMerchant() {
        try {
            MerchantPayOption merchantPayMethod = DirectPaymentBL.getInstance().getMerchantPayMethod();
            if (merchantPayMethod == null || merchantPayMethod.getPaymentModes() == null || merchantPayMethod.getPaymentModes().size() <= 0) {
                return false;
            }
            Iterator<PaymentModes> it2 = merchantPayMethod.getPaymentModes().iterator();
            while (it2.hasNext()) {
                PaymentModes next = it2.next();
                if (next.getPaymentMode().equalsIgnoreCase("UPI") && next.getPayChannelOptions() != null && next.getPayChannelOptions().size() > 0) {
                    Iterator<PayChannelOptions> it3 = next.getPayChannelOptions().iterator();
                    while (it3.hasNext()) {
                        if (it3.next().getChannelCode().equalsIgnoreCase(SDKConstants.UPIPUSHEXPRESS)) {
                            return true;
                        }
                    }
                    continue;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isUpiCollectEnabled() {
        try {
            MerchantPayOption merchantPayMethod = DirectPaymentBL.getInstance().getMerchantPayMethod();
            if (!(merchantPayMethod == null || merchantPayMethod.getPaymentModes() == null || merchantPayMethod.getPaymentModes().size() <= 0)) {
                Iterator<PaymentModes> it2 = merchantPayMethod.getPaymentModes().iterator();
                while (it2.hasNext()) {
                    PaymentModes next = it2.next();
                    if (next.getPaymentMode().equalsIgnoreCase("UPI") && next.getPayChannelOptions() != null && next.getPayChannelOptions().size() > 0) {
                        Iterator<PayChannelOptions> it3 = next.getPayChannelOptions().iterator();
                        while (it3.hasNext()) {
                            PayChannelOptions next2 = it3.next();
                            if (next2.getChannelCode().equalsIgnoreCase("UPI") && (next2.getIsDisabled() == null || !next2.getIsDisabled().getStatus())) {
                                return true;
                            }
                        }
                        continue;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isUpiIntentEnabled() {
        if (!DirectPaymentBL.getInstance().isNativeJsonRequestSupported()) {
            return false;
        }
        try {
            MerchantPayOption merchantPayMethod = DirectPaymentBL.getInstance().getMerchantPayMethod();
            if (!(merchantPayMethod == null || merchantPayMethod.getPaymentModes() == null || merchantPayMethod.getPaymentModes().size() <= 0)) {
                Iterator<PaymentModes> it2 = merchantPayMethod.getPaymentModes().iterator();
                while (it2.hasNext()) {
                    PaymentModes next = it2.next();
                    if (next.getPaymentMode().equalsIgnoreCase("UPI") && next.getPayChannelOptions() != null && next.getPayChannelOptions().size() > 0) {
                        Iterator<PayChannelOptions> it3 = next.getPayChannelOptions().iterator();
                        while (it3.hasNext()) {
                            PayChannelOptions next2 = it3.next();
                            if (next2.getChannelCode().equalsIgnoreCase("UPIPUSH") && (next2.getIsDisabled() == null || !next2.getIsDisabled().getStatus())) {
                                return true;
                            }
                        }
                        continue;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String getActualPaySecurelyText(Context context) {
        return context.getString(R.string.nativesdk_amount_pay, new Object[]{MerchantBL.getMerchantInstance().getWithoutDoubleAmount(getDiffAmount())});
    }

    public static String getPaySecurelyText(Context context) {
        return getNetPaySecurelyText(context, 0.0d, ConvenienceFeeOrController.getInstance().getPostConvFeePayableAmount());
    }

    public static String getNetPaySecurelyText(Context context, double d2, double d3) {
        if (ConvenienceFeeController.getInstance().hasOverflowConvenienceFee()) {
            String postConvenienceFeeDisplayAmount = ConvenienceFeeController.getInstance().getPostConvenienceFeeDisplayAmount();
            return context.getString(R.string.nativesdk_amount_pay, new Object[]{priceWithoutDecimal(postConvenienceFeeDisplayAmount)});
        }
        return context.getString(R.string.nativesdk_amount_pay, new Object[]{priceWithoutDecimal((getDiffAmount() - d2) + d3)});
    }

    public static double getNetPaySecurelyAmount(Context context, double d2, double d3) {
        if (ConvenienceFeeController.getInstance().hasOverflowConvenienceFee()) {
            return parseDouble(ConvenienceFeeController.getInstance().getPostConvenienceFeeDisplayAmount());
        }
        return (getDiffAmount() - d2) + d3;
    }

    public static String getNetAmountText(Context context, double d2, double d3) {
        if (ConvenienceFeeController.getInstance().hasOverflowConvenienceFee()) {
            String postConvenienceFeeDisplayAmount = ConvenienceFeeController.getInstance().getPostConvenienceFeeDisplayAmount();
            return context.getString(R.string.nativesdk_amount, new Object[]{priceWithoutDecimal(postConvenienceFeeDisplayAmount)});
        }
        return context.getString(R.string.nativesdk_amount, new Object[]{priceWithoutDecimal((getDiffAmount() - d2) + d3)});
    }

    public static String getNetPayableAmount(Context context, double d2, double d3) {
        if (ConvenienceFeeController.Companion.getInstance().hasOverflowConvenienceFee()) {
            return priceWithoutDecimal(ConvenienceFeeController.Companion.getInstance().getPostConvenienceFeeDisplayAmount());
        }
        return priceWithoutDecimal((getDiffAmount() - d2) + d3);
    }

    public static double getNetPayableAmountInDouble(Context context, double d2, double d3) {
        if (ConvenienceFeeController.Companion.getInstance().hasOverflowConvenienceFee()) {
            return ConvenienceFeeController.Companion.getInstance().getPostConvFeePayableAmount();
        }
        return (getDiffAmount() - d2) + d3;
    }

    public static String getNetEmiPaySecurelyText(Context context, double d2) {
        double parseDouble = parseDouble(DirectPaymentBL.getInstance().getInstrumentBalance(PayMethodType.BALANCE));
        if (isHybridCase()) {
            d2 -= parseDouble;
        }
        return context.getString(R.string.nativesdk_amount_pay, new Object[]{priceWithoutDecimal(d2)});
    }

    public static Double getNetEmiPaySecurelyAmount(Context context, double d2) {
        double parseDouble = parseDouble(DirectPaymentBL.getInstance().getInstrumentBalance(PayMethodType.BALANCE));
        if (isHybridCase()) {
            d2 -= parseDouble;
        }
        return Double.valueOf(d2);
    }

    public static double getTotalOrderAmount() {
        return parseDouble(MerchantBL.getMerchantInstance().getAmount());
    }

    public static String getNetEmiAmountText(Context context, double d2) {
        double parseDouble = parseDouble(DirectPaymentBL.getInstance().getInstrumentBalance(PayMethodType.BALANCE));
        if (isHybridCase()) {
            d2 -= parseDouble;
        }
        return context.getString(R.string.nativesdk_amount, new Object[]{priceWithoutDecimal(d2)});
    }

    public static void handleVerticalError(final PaytmSDKRequestClient.ApiResponseError apiResponseError, final Context context) {
        if (apiResponseError != null) {
            CustomVolleyError customVolleyError = new CustomVolleyError();
            int statusCode = apiResponseError.getStatusCode();
            if (401 == statusCode || 410 == statusCode || 403 == statusCode || 1006 == statusCode) {
                if (PaytmSDK.getCallbackListener() != null) {
                    PaytmSDK.getCallbackListener().onSessionExpire(customVolleyError);
                }
                if (context != null) {
                    Intent intent = new Intent("kill");
                    intent.putExtra(SDKConstants.SAVE_ACTIVITY, "none");
                    a.a(context.getApplicationContext()).a(intent);
                }
            } else if (apiResponseError.isClosePgWithoutError()) {
                closePGScreen(context);
            } else {
                String errorMsg = apiResponseError.getErrorMsg();
                String errorTitle = apiResponseError.getErrorTitle();
                if (TextUtils.isEmpty(errorMsg) || H5BridgeContext.INVALID_ID.equalsIgnoreCase(errorMsg)) {
                    errorMsg = context.getString(R.string.generic_checkout_error_msg);
                }
                if (TextUtils.isEmpty(errorTitle)) {
                    errorTitle = context.getString(R.string.network_error_title);
                }
                DialogUtility.showDialog(context, errorTitle, errorMsg, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        Context context = context;
                        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                            dialogInterface.dismiss();
                        }
                        if (apiResponseError.isShouldClosePG()) {
                            SDKUtility.closePGScreen(context);
                        }
                    }
                });
            }
        } else {
            DialogUtility.showDialog(context, context.getString(R.string.generic_checkout_error_msg), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    Context context = context;
                    if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                        dialogInterface.dismiss();
                    }
                }
            });
        }
    }

    public static void closePGScreen(Context context) {
        if (DirectPaymentBL.getInstance().getDeferredCheckoutCallbackListener() != null) {
            DirectPaymentBL.getInstance().getDeferredCheckoutCallbackListener().finishActivity();
        }
        Intent intent = new Intent("kill");
        intent.putExtra(SDKConstants.SAVE_ACTIVITY, "none");
        a.a(context).a(intent);
    }

    public static void startUpiPush(Context context, VpaBankAccountDetail vpaBankAccountDetail, String str, String str2) {
        if (isSubScriptionMaxAmount()) {
            startUpiPush(context, vpaBankAccountDetail, str, subscriptionMaxAmount, (String) null);
        } else {
            startUpiPush(context, vpaBankAccountDetail, str, str2, (String) null);
        }
    }

    private static boolean isSubScriptionMaxAmount() {
        if (DirectPaymentBL.getInstance().getCjPayMethodResponse() == null) {
            return false;
        }
        CJPayMethodResponse cjPayMethodResponse = DirectPaymentBL.getInstance().getCjPayMethodResponse();
        if (cjPayMethodResponse.getBody() == null || cjPayMethodResponse.getBody().getSubscriptionDetailsInfo() == null) {
            return false;
        }
        SubscriptionDetailsInfo subscriptionDetailsInfo = cjPayMethodResponse.getBody().getSubscriptionDetailsInfo();
        if (TextUtils.isEmpty(subscriptionDetailsInfo.getSubsMaxAmount())) {
            return false;
        }
        subscriptionMaxAmount = subscriptionDetailsInfo.getSubsMaxAmount();
        return true;
    }

    public static void startUpiPush(Context context, VpaBankAccountDetail vpaBankAccountDetail, String str, String str2, String str3) {
        HashMap<String, String> hashMap;
        if (isPaytmApp(context)) {
            String addAuthDefaultParams = addAuthDefaultParams(context, NativeSdkGtmLoader.getProcessTranscationUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId()));
            Bundle bundle = new Bundle();
            bundle.putString(SDKConstants.WEB_VIEW_URL, addAuthDefaultParams);
            bundle.putString("ORDER_ID", MerchantBL.getMerchantInstance().getOrderId());
            bundle.putString(SDKConstants.MID, MerchantBL.getMerchantInstance().getMid());
            bundle.putBoolean(SDKConstants.NATIVE_JSON_REQUEST_SUPPORTED, DirectPaymentBL.getInstance().isNativeJsonRequestSupported());
            bundle.putBoolean("UPIPUSH", isUpiPushEnabled());
            bundle.putString("user_upi_details", new f().b(SDKUtils.convertVpaPojo(vpaBankAccountDetail)));
            if (!isUpiPushEnabled() || vpaBankAccountDetail == null) {
                hashMap = PayUtility.getUpiCollectParam(vpaBankAccountDetail.getName(), str3);
                bundle.putBoolean(SDKConstants.UPI_COLLECT, true);
            } else {
                hashMap = PayUtility.getUpiPushParam(vpaBankAccountDetail);
                if (!DirectPaymentBL.getInstance().isWalletChecked() || !SDKConstants.ADDANDPAY.equalsIgnoreCase(DirectPaymentBL.getInstance().getPaymentFlowAvailable())) {
                    bundle.putString("payee_name", DirectPaymentBL.getInstance().getMerchantDetails().getMerchantName());
                    bundle.putString("payee_vpa", DirectPaymentBL.getInstance().getMerchantDetails().getMerchantVpa());
                    bundle.putString("merchant_code", DirectPaymentBL.getInstance().getMerchantDetails().getMcc());
                } else {
                    bundle.putString("payee_name", DirectPaymentBL.getInstance().getAddNPayMerchantDetails().getMerchantName());
                    bundle.putString("payee_vpa", DirectPaymentBL.getInstance().getAddNPayMerchantDetails().getMerchantVpa());
                    bundle.putString("merchant_code", DirectPaymentBL.getInstance().getAddNPayMerchantDetails().getMcc());
                }
            }
            if (TextUtils.isEmpty(str2)) {
                if (DirectPaymentBL.getInstance().isWalletAmountSufficientToPay() || !DirectPaymentBL.getInstance().isPaytmWalletChecked()) {
                    str2 = MerchantBL.getMerchantInstance().getAmount();
                } else {
                    str2 = DirectPaymentBL.getInstance().getDifferentialAmount();
                }
            }
            bundle.putString("amount", str2);
            bundle.putString(SDKConstants.EXTRA_PUSH_TYPE, str);
            bundle.putSerializable(SDKConstants.WEB_VIEW_PARAMS, hashMap);
            if (PaytmSDK.getUpiCallBackListener() == null || !isUpiPushEnabled()) {
                if (PaytmSDK.getCallbackListener() != null) {
                    PaytmSDK.getCallbackListener().onTransactionResponse(bundle);
                }
                Intent intent = new Intent("kill");
                intent.putExtra(SDKConstants.SAVE_ACTIVITY, "none");
                if (context != null) {
                    a.a(context.getApplicationContext()).a(intent);
                }
            } else {
                PaytmSDK.getUpiCallBackListener().openMPINScreen(context, bundle);
            }
            sendGaEvents(getGenericEventParams("pay_clicked", "UPI Push", SDKConstants.GA_KEY_DEFAULT));
        }
    }

    public static String addParams(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str);
        if (!str.contains("?")) {
            sb.append("?");
            sb.append(str2);
            sb.append("=");
            sb.append(str3);
        } else {
            sb.append(AppConstants.AND_SIGN);
            sb.append(str2);
            sb.append("=");
            sb.append(str3);
        }
        return sb.toString();
    }

    public static String addParams(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str);
        for (Map.Entry next : map.entrySet()) {
            if (!sb.toString().contains("?")) {
                sb.append("?");
                sb.append((String) next.getKey());
                sb.append("=");
                sb.append((String) next.getValue());
            } else {
                sb.append(AppConstants.AND_SIGN);
                sb.append((String) next.getKey());
                sb.append("=");
                sb.append((String) next.getValue());
            }
        }
        return sb.toString();
    }

    public static List<UpiOptionsModel> getUpiAppsInstalled(Context context, String str) {
        UpiOptionsModel upiOptionsModel;
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        PackageManager packageManager = context.getPackageManager();
        for (ResolveInfo next : packageManager.queryIntentActivities(intent, 0)) {
            String str2 = next.activityInfo.packageName;
            if (!TextUtils.isEmpty(str2) && !str2.toLowerCase().contains("com.olacabs") && !str2.toLowerCase().contains("com.dreamplug")) {
                if ("net.one97.paytm".equalsIgnoreCase(str2)) {
                    if (getAllVpas() != null || !isPaytmApp(context)) {
                        upiOptionsModel = new UpiOptionsModel(next, next.loadLabel(packageManager).toString(), next.loadIcon(packageManager));
                        upiOptionsModel.setSortingIndex(6);
                    }
                } else if (str2.toLowerCase().contains("com.phonepe.app")) {
                    upiOptionsModel = new UpiOptionsModel(next, next.loadLabel(packageManager).toString(), next.loadIcon(packageManager));
                    upiOptionsModel.setSortingIndex(5);
                } else if (str2.toLowerCase().contains(Payload.SOURCE_GOOGLE)) {
                    upiOptionsModel = new UpiOptionsModel(next, next.loadLabel(packageManager).toString(), next.loadIcon(packageManager));
                    upiOptionsModel.setSortingIndex(4);
                } else if (str2.toLowerCase().contains("in.org.npci")) {
                    upiOptionsModel = new UpiOptionsModel(next, next.loadLabel(packageManager).toString(), next.loadIcon(packageManager));
                    upiOptionsModel.setSortingIndex(3);
                } else if (str2.toLowerCase().contains("icici")) {
                    upiOptionsModel = new UpiOptionsModel(next, next.loadLabel(packageManager).toString(), next.loadIcon(packageManager));
                    upiOptionsModel.setSortingIndex(2);
                } else if (str2.toLowerCase().contains("com.myairtelapp")) {
                    upiOptionsModel = new UpiOptionsModel(next, next.loadLabel(packageManager).toString(), next.loadIcon(packageManager));
                    upiOptionsModel.setSortingIndex(1);
                } else {
                    upiOptionsModel = new UpiOptionsModel(next, next.loadLabel(packageManager).toString(), next.loadIcon(packageManager));
                }
                arrayList.add(upiOptionsModel);
            }
        }
        Collections.sort(arrayList, new Comparator<UpiOptionsModel>() {
            public final int compare(UpiOptionsModel upiOptionsModel, UpiOptionsModel upiOptionsModel2) {
                return upiOptionsModel2.getSortingIndex() > upiOptionsModel.getSortingIndex() ? 1 : -1;
            }
        });
        return arrayList;
    }

    public static String generateRequestId() {
        String str;
        StringBuilder sb = new StringBuilder(UUID.randomUUID().toString().replace("-", ""));
        int length = sb.length();
        if (length >= 32) {
            str = sb.substring(0, 32);
        } else {
            int i2 = 32 - length;
            for (int i3 = 1; i3 <= i2; i3++) {
                sb.append(i3 + 97);
            }
            str = sb.toString();
        }
        return "Native_".concat(String.valueOf(str));
    }

    public static double getEffectAfterOfferAmount(String str) {
        if (TextUtils.isEmpty(str)) {
            return getDiffAmount();
        }
        return getDiffAmount() - parseDouble(str);
    }

    public static int convertDpToPixel(Context context, int i2) {
        return (int) TypedValue.applyDimension(1, (float) i2, context.getResources().getDisplayMetrics());
    }

    public static boolean isSaveCardsAvailable() {
        boolean z = false;
        if (DirectPaymentBL.getInstance().getCjPayMethodResponse() == null || DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody() == null) {
            return false;
        }
        if (!(DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getMerchantPayOption() == null || DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getMerchantPayOption().getSavedInstruments() == null || DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getMerchantPayOption().getSavedInstruments().size() <= 0)) {
            z = true;
        }
        if (DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getAddMoneyPayOption() == null || DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getAddMoneyPayOption().getSavedInstruments() == null || DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getAddMoneyPayOption().getSavedInstruments().size() <= 0) {
            return z;
        }
        return true;
    }

    public static void startAnimation(LottieAnimationView lottieAnimationView) {
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.playAnimation();
        }
    }

    public static void stopAnimation(LottieAnimationView lottieAnimationView) {
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setVisibility(8);
        }
    }

    public static boolean isOfferValid(ApplyPromoResponse.PaymentOffer paymentOffer) {
        if (paymentOffer == null) {
            return false;
        }
        return !TextUtils.isEmpty(paymentOffer.getTotalInstantDiscount()) || !TextUtils.isEmpty(paymentOffer.getTotalCashbackAmount());
    }

    public static Activity getTopActivity() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke((Object) null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(invoke);
            if (map == null) {
                return null;
            }
            for (Object next : map.values()) {
                Class<?> cls2 = next.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(next)) {
                    Field declaredField3 = cls2.getDeclaredField("activity");
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(next);
                }
            }
            return null;
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    public static int getScreenHeight(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getScreenWidth(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static float getDensity(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    public static void finishSDK(Context context) {
        if (context != null) {
            Intent intent = new Intent("kill");
            intent.putExtra(SDKConstants.SAVE_ACTIVITY, "none");
            a.a(context.getApplicationContext()).a(intent);
        }
    }

    public static void onTransactionDialogDismiss(Context context) {
        if (PaytmSDK.getCallbackListener() != null) {
            PaytmSDK.getCallbackListener().onBackPressedCancelTransaction();
        }
        finishSDK(context);
    }

    public static String getEmiAvailableText(Context context, String str) {
        if (SDKConstants.EmiSubventionType.ZERO_COST.name().equalsIgnoreCase(str)) {
            return context.getString(R.string.zero_cost_emi_availbale);
        }
        if (SDKConstants.EmiSubventionType.LOW_COST.name().equalsIgnoreCase(str)) {
            return context.getString(R.string.low_cost_emi_availbale);
        }
        return context.getString(R.string.emi_option_available);
    }

    private static String getEmiTypeLabel(Context context, String str) {
        if (SDKConstants.EmiSubventionType.ZERO_COST.name().equalsIgnoreCase(str)) {
            return context.getString(R.string.zero_cost_emi);
        }
        return SDKConstants.EmiSubventionType.LOW_COST.name().equalsIgnoreCase(str) ? context.getString(R.string.low_cost_emi) : "";
    }

    public static String getEmiGratificationsMsg(Context context, List<Gratifications> list, String str) {
        if (list == null || list.size() == 0) {
            return null;
        }
        String emiTypeLabel = getEmiTypeLabel(context, str);
        String str2 = "";
        for (Gratifications next : list) {
            String lowerCase = next.getType().toLowerCase();
            char c2 = 65535;
            int hashCode = lowerCase.hashCode();
            if (hashCode != 24489626) {
                if (hashCode == 273184065 && lowerCase.equals(Item.KEY_DISCOUNT)) {
                    c2 = 0;
                }
            } else if (lowerCase.equals("cashback")) {
                c2 = 1;
            }
            if (c2 == 0) {
                str2 = context.getString(R.string.emi_discount_msg, new Object[]{emiTypeLabel, next.getValue()});
            } else if (c2 == 1) {
                str2 = context.getString(R.string.emi_cashback_msg, new Object[]{emiTypeLabel, next.getValue()});
            }
        }
        return str2;
    }

    public static void showErrorInSnackBar(Context context, String str, String str2) {
        if (context instanceof InstrumentActivity) {
            ((InstrumentActivity) context).showErrorMsg(str, str2, "", true);
        } else {
            Toast.makeText(context, str2, 1).show();
        }
    }

    public static String getEncryptedAuthCode(String str) {
        try {
            return new JSONObject(str).getJSONObject("content").getString("authCode");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getCorrelationId(String str) {
        try {
            return new JSONObject(str).getJSONObject("content").getString("partnerOriginalTransactionID");
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean disabledDueToBalance(PaymentModes paymentModes) {
        if (DirectPaymentBL.getInstance().getCjPayMethodResponse() == null || DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody() == null || SDKConstants.ADDANDPAY.equalsIgnoreCase(DirectPaymentBL.getInstance().getPaymentFlowAvailable())) {
            return false;
        }
        if (DirectPaymentBL.getInstance().isSubsCriptionFlow()) {
            if (paymentModes.getPayChannelOptions().get(0).getBalanceInfo() == null || paymentModes.getPayChannelOptions().get(0).getBalanceInfo().getAccountBalance() == null || Double.valueOf(paymentModes.getPayChannelOptions().get(0).getBalanceInfo().getAccountBalance().getValue()).doubleValue() >= 0.0d) {
                return false;
            }
            return true;
        } else if (paymentModes.getPayChannelOptions().get(0).getBalanceInfo() == null || paymentModes.getPayChannelOptions().get(0).getBalanceInfo().getAccountBalance() == null || Double.valueOf(paymentModes.getPayChannelOptions().get(0).getBalanceInfo().getAccountBalance().getValue()).doubleValue() >= 1.0d) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isAppInvokeFlow() {
        return MerchantBL.getMerchantInstance().isAppInvoke() || MerchantBL.getMerchantInstance().isTransparentAppInvoke();
    }

    public static void openUPIOnboarding(Context context) {
        if (PaytmSDK.getUpiCallBackListener() != null) {
            sendGaEvents(getGenericEventUPI(SDKConstants.GA_UPI_ONBOARDING, SDKConstants.UPI_ADD_ACCOUNT_AND_PAY, MerchantBL.getMerchantInstance().getOrderId(), MerchantBL.getMerchantInstance().getAmount(), MerchantBL.getMerchantInstance().getMid()));
            int i2 = 352;
            if (SDKUtils.isUpiProfileCreated()) {
                i2 = SDKConstants.REQUEST_CODE_SELECT_BANK_ACCOUNT;
            }
            if (context instanceof Activity) {
                PaytmSDK.getUpiCallBackListener().startUpiOnBoarding((Activity) context, i2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0032 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.one97.paytm.nativesdk.common.model.OneClickResponse getOneClickInfoResponse(boolean r2, boolean r3, boolean r4, boolean r5) {
        /*
            r0 = 103(0x67, float:1.44E-43)
            r1 = 100
            if (r5 == 0) goto L_0x001e
            if (r4 == 0) goto L_0x002e
            if (r2 == 0) goto L_0x000f
            if (r3 == 0) goto L_0x000f
            r0 = 104(0x68, float:1.46E-43)
            goto L_0x0030
        L_0x000f:
            if (r2 == 0) goto L_0x0014
            if (r3 != 0) goto L_0x0014
            goto L_0x0030
        L_0x0014:
            if (r2 != 0) goto L_0x001b
            if (r3 == 0) goto L_0x001b
            r0 = 101(0x65, float:1.42E-43)
            goto L_0x0030
        L_0x001b:
            r0 = 102(0x66, float:1.43E-43)
            goto L_0x0030
        L_0x001e:
            if (r4 == 0) goto L_0x002e
            if (r2 == 0) goto L_0x0027
            if (r3 == 0) goto L_0x0027
            r0 = 105(0x69, float:1.47E-43)
            goto L_0x0030
        L_0x0027:
            if (r2 == 0) goto L_0x002c
            if (r3 != 0) goto L_0x002c
            goto L_0x0030
        L_0x002c:
            r0 = 0
            goto L_0x0030
        L_0x002e:
            r0 = 100
        L_0x0030:
            if (r0 != 0) goto L_0x0034
            r2 = 0
            return r2
        L_0x0034:
            net.one97.paytm.nativesdk.common.model.OneClickResponse r2 = new net.one97.paytm.nativesdk.common.model.OneClickResponse
            java.lang.String r3 = ""
            r2.<init>(r0, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.Utils.SDKUtility.getOneClickInfoResponse(boolean, boolean, boolean, boolean):net.one97.paytm.nativesdk.common.model.OneClickResponse");
    }

    public static void sendEnrollmentGAEvent(OneClickResponse oneClickResponse, String str, PaymentInstrument paymentInstrument) {
        if (oneClickResponse != null && paymentInstrument != null) {
            if (101 == oneClickResponse.getStatusCode()) {
                sendGaEvents(getVisaEventParams(SDKConstants.GA_VISA_SUCCESSFUL, SDKConstants.GA_ENROLLMENT, paymentInstrument.getGaVisaPaymentMode()));
            } else if (103 == oneClickResponse.getStatusCode()) {
                sendGaEvents(getVisaEventParams(SDKConstants.GA_VISA_TOKEN_DELETED, SDKConstants.GA_REPEAT, paymentInstrument.getGaVisaPaymentMode()));
            } else if (TokenStatus.REPLACED.equalsIgnoreCase(str)) {
                sendGaEvents(getVisaEventParams(SDKConstants.GA_VISA_SUCCESSFUL, SDKConstants.GA_REPEAT, paymentInstrument.getGaVisaPaymentMode()));
            } else if (TokenStatus.RETAINED.equalsIgnoreCase(str)) {
                sendGaEvents(getVisaEventParams(SDKConstants.GA_VISA_TOKEN_RETAINED, SDKConstants.GA_REPEAT, paymentInstrument.getGaVisaPaymentMode()));
            }
        }
    }

    public static void logCrashAndException(String str, String str2, Throwable th) {
        if (PaytmSDK.getCallbackListener() != null) {
            PaytmSDK.getCallbackListener().logCrashAnalytics(str, str2);
            PaytmSDK.getCallbackListener().logException(str, "Paytm Assist MID Null/Empty exception", th);
        }
    }

    public static void setPaddingBankOffer(View view, boolean z, Context context, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        int convertDpToPixel = z ? 0 : convertDpToPixel(context, i4);
        if (!z) {
            i6 = convertDpToPixel(context, i5);
        }
        view.setPadding(convertDpToPixel(context, i2), convertDpToPixel, convertDpToPixel(context, i3), i6);
    }

    public static boolean shouldShowValidatePromoError() {
        return isAppInvokeFlow() && MerchantBL.getMerchantInstance().isValidatePromo();
    }

    public static boolean isValidIFSCode(String str) {
        Pattern compile = Pattern.compile("^[A-Z]{4}0[A-Z0-9]{6}$");
        if (str == null || str.length() == 0) {
            return false;
        }
        return compile.matcher(str).matches();
    }

    public static void handlePromotionVisibility(View view, int i2) {
        if (!isAddMoneyConvFeeFlow() || !DirectPaymentBL.getInstance().isAddMoneyPromotionTagEnable()) {
            view.setVisibility(8);
        } else if (SDKUtils.isRiskConvFeeApplicable()) {
            view.setVisibility(i2);
        } else {
            view.setVisibility(8);
        }
    }

    public static boolean isAddMoneyConvFeeFlow() {
        return DirectPaymentBL.getInstance().isAddMoney() && ConvenienceFeeController.getInstance().isConvenienceFeeEnabled();
    }

    public static Boolean isBankOfferBottom() {
        return Boolean.valueOf(DirectPaymentBL.getInstance().isAddMoney());
    }

    private static boolean isSavedCCAvailable() {
        Iterator<SavedInstruments> it2 = DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getMerchantPayOption().getSavedInstruments().iterator();
        while (it2.hasNext()) {
            SavedInstruments next = it2.next();
            if (next != null && next.getCardDetails() != null && next.getCardDetails().getCardType().contains("CREDIT")) {
                return true;
            }
        }
        return false;
    }

    public static boolean expiryValidate(String str) {
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (str.charAt(i3) == '/') {
                i2++;
            }
        }
        if (i2 != 1) {
            return false;
        }
        String[] split = str.split("/");
        Pattern compile = Pattern.compile("^[0-9]\\d*$");
        if (split.length >= 2 && compile.matcher(split[0]).matches() && compile.matcher(split[1]).matches()) {
            Calendar instance = Calendar.getInstance();
            if (Integer.parseInt(split[0]) <= 12 && Integer.parseInt(split[0]) > 0) {
                if (Integer.parseInt("20" + split[1]) <= instance.get(1)) {
                    if (Integer.parseInt("20" + split[1]) != instance.get(1) || Integer.parseInt(split[0]) <= instance.get(2)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static SpannableString getBankOfferText(Context context, String str, ApplyPromoResponse.PaymentOffer paymentOffer) {
        if (paymentOffer != null && paymentOffer.getOfferBreakup() != null && paymentOffer.getOfferBreakup().size() > 0 && !TextUtils.isEmpty(paymentOffer.getOfferBreakup().get(0).getPromotext())) {
            str = paymentOffer.getOfferBreakup().get(0).getPromotext();
        }
        return new SpannableString(str);
    }

    public static void setBankOfferTextFromVerify(ObservableInt observableInt, ObservableInt observableInt2, i<SpannableString> iVar, i<SpannableString> iVar2, String str) {
        if (!DirectPaymentBL.getInstance().isAddMoney()) {
            iVar.set(new SpannableString(""));
            iVar2.set(new SpannableString(""));
            observableInt2.set(8);
            observableInt.set(8);
        } else if (str != null && !TextUtils.isEmpty(str)) {
            if (isBankOfferBottom().booleanValue()) {
                observableInt.set(0);
                observableInt2.set(8);
                iVar.set(new SpannableString(str));
                return;
            }
            observableInt.set(8);
            iVar2.set(new SpannableString(str));
            observableInt2.set(0);
        }
    }

    public static boolean isPayModeDisabled(PaymentModes paymentModes) {
        if (paymentModes == null || paymentModes.getPayChannelOptions() == null || paymentModes.getPayChannelOptions().size() <= 0 || paymentModes.getPayChannelOptions().get(0) == null || paymentModes.getPayChannelOptions().get(0).getIsDisabled() == null || !paymentModes.getPayChannelOptions().get(0).getIsDisabled().getStatus()) {
            return false;
        }
        return true;
    }

    public static void addOfferInCallBackData(PaytmSDKRequestClient.CallbackData callbackData, ApplyPromoResponse.PaymentOffer paymentOffer) {
        try {
            if (isOfferValid(paymentOffer)) {
                callbackData.setOfferBody(new JSONObject(new f().b(paymentOffer)));
            }
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    public static boolean isNetBankingTransactionProcessing() {
        return DirectPaymentBL.getInstance().isTransactionProcessing() && (DirectPaymentBL.getInstance().getPaytmBaseView() instanceof NetBankingView);
    }
}
