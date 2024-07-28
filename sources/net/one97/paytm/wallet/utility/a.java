package net.one97.paytm.wallet.utility;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.ClipboardManager;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.z;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.business.merchant_payments.deeplinkUtil.DeepLinkConstant;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.paytm.android.chat.utils.KeyList;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.utility.CustomTypefaceSpan;
import com.paytm.utility.b;
import com.paytm.utility.c;
import com.paytm.utility.d;
import com.paytm.utility.g;
import com.paytm.utility.h;
import com.paytm.utility.q;
import com.paytmmoney.lite.mod.util.PMConstants;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import easypay.manager.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.one97.paytm.common.entity.RiskAnalysis.RiskExtendedInfo;
import net.one97.paytm.common.entity.passcode.DeviceDetailPreference;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.common.entity.wallet.CJRQRInfoResponse;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.n.e;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.network.f;
import net.one97.paytm.p2mNewDesign.activity.P2MPaymentSuccessActivity;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.be;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.activity.AJRScanWebView;
import net.one97.paytm.wallet.activity.P2MPaymentSuccessActivityV2;
import net.one97.paytm.wallet.d.j;
import net.one97.paytm.wallet.d.l;
import net.one97.paytm.wallet.entity.MerchantVerifedStatus;
import net.one97.paytm.wallet.f.n;
import net.one97.paytm.wallet.f.o;
import net.one97.paytm.wallet.newdesign.activity.P2PActivity;
import net.one97.paytm.wallet.newdesign.activity.PaySendInfoActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f72250a = a.class.getSimpleName();

    public static int a(int i2) {
        if (i2 == 0) {
            return 36000;
        }
        return i2 * 1000;
    }

    public static String b() {
        return "http://m.p-y.tm";
    }

    public static String c() {
        return "?fetch_strategy=USER_ATTRIBUTE";
    }

    public static void a(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            a(activity, activity.getResources().getString(R.string.no_connection), activity.getResources().getString(R.string.no_internet));
        }
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.trim().replaceAll("[^\\d+]", "").replaceAll(" ", "");
        }
        return "";
    }

    public static String a(Activity activity, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int i2 = 0;
        String replaceAll = str.trim().replaceAll("[^\\d+]", "");
        if (replaceAll.startsWith(activity.getString(R.string.mobile_number_prefix_91))) {
            i2 = 3;
        } else if (replaceAll.startsWith(activity.getString(R.string.mobile_number_prefix_91_without_plus))) {
            i2 = 2;
        } else if (replaceAll.startsWith(activity.getString(R.string.mobile_number_prefix_0))) {
            i2 = 1;
        }
        return replaceAll.substring(i2, replaceAll.length()).trim().replaceAll(" ", "");
    }

    public static boolean b(String str) {
        return Pattern.compile(SDKConstants.MOB_NO_REG_EX).matcher(str).find();
    }

    public static boolean c(String str) {
        return Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*(\\+[_A-Za-z0-9-]+){0,1}@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$").matcher(str).find();
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0027 A[Catch:{ Exception -> 0x003b }, LOOP:0: B:6:0x0027->B:9:0x0035, LOOP_START, PHI: r10 
      PHI: (r10v5 java.lang.String) = (r10v3 java.lang.String), (r10v8 java.lang.String) binds: [B:5:0x0025, B:9:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "display_name"
            r1 = 0
            boolean r2 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x003b }
            if (r2 != 0) goto L_0x0047
            android.net.Uri r2 = android.provider.ContactsContract.PhoneLookup.CONTENT_FILTER_URI     // Catch:{ Exception -> 0x003b }
            java.lang.String r10 = android.net.Uri.encode(r10)     // Catch:{ Exception -> 0x003b }
            android.net.Uri r4 = android.net.Uri.withAppendedPath(r2, r10)     // Catch:{ Exception -> 0x003b }
            android.content.ContentResolver r3 = r9.getContentResolver()     // Catch:{ Exception -> 0x003b }
            java.lang.String r9 = "_id"
            java.lang.String[] r5 = new java.lang.String[]{r9, r0}     // Catch:{ Exception -> 0x003b }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r9 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x003b }
            r10 = r1
            if (r9 == 0) goto L_0x003a
        L_0x0027:
            boolean r2 = r9.moveToNext()     // Catch:{ Exception -> 0x003b }
            if (r2 == 0) goto L_0x0037
            int r10 = r9.getColumnIndex(r0)     // Catch:{ Exception -> 0x003b }
            java.lang.String r10 = r9.getString(r10)     // Catch:{ Exception -> 0x003b }
            if (r10 == 0) goto L_0x0027
        L_0x0037:
            r9.close()     // Catch:{ Exception -> 0x003b }
        L_0x003a:
            return r10
        L_0x003b:
            r9 = move-exception
            boolean r10 = com.paytm.utility.b.v
            if (r10 == 0) goto L_0x0047
            java.lang.String r9 = java.lang.String.valueOf(r9)
            com.paytm.utility.q.d(r9)
        L_0x0047:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.utility.a.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String trim = str.trim();
            if (!TextUtils.isEmpty(trim)) {
                return String.valueOf(trim.toUpperCase().charAt(0));
            }
            return null;
        } catch (Exception e2) {
            if (!b.v) {
                return null;
            }
            q.d(String.valueOf(e2));
            return null;
        }
    }

    public static String a(Context context) {
        if (context == null) {
            return null;
        }
        String b2 = be.a(context.getApplicationContext()).b("pref_key_wallet_balance", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static void a(Context context, double d2) {
        try {
            String d3 = Double.toString(d2);
            if (context != null) {
                be.a(context.getApplicationContext()).a("pref_key_wallet_balance", d3, true);
            }
        } catch (Exception e2) {
            if (b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    public static String a(DecimalFormat decimalFormat, String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                double parseDouble = Double.parseDouble(str);
                double parseDouble2 = Double.parseDouble(str2);
                if (parseDouble >= 0.0d) {
                    double d2 = parseDouble2 - parseDouble;
                    if (d2 < 0.0d || d2 >= 1.0d) {
                        return decimalFormat.format(d2);
                    }
                    return Double.toString(Math.ceil(d2));
                }
            }
        } catch (Exception e2) {
            if (b.v) {
                q.d(String.valueOf(e2));
            }
        }
        return decimalFormat.format(str2);
    }

    public static String a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                double parseDouble = Double.parseDouble(str);
                double parseDouble2 = Double.parseDouble(str2);
                if (parseDouble >= 0.0d) {
                    double d2 = parseDouble2 - parseDouble;
                    if (d2 < 0.0d || d2 >= 1.0d) {
                        return Double.toString(d2);
                    }
                    return Double.toString(Math.ceil(d2));
                }
            }
        } catch (Exception e2) {
            if (b.v) {
                q.d(String.valueOf(e2));
            }
        }
        return str2;
    }

    public static Dialog b(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.lyt_progress_bar);
            dialog.getWindow().setBackgroundDrawableResource(17170445);
            return dialog;
        } catch (Exception e2) {
            if (!b.v) {
                return null;
            }
            q.d(String.valueOf(e2));
            return null;
        }
    }

    public static Dialog c(Activity activity) {
        try {
            Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.ajr_progress_bar);
            dialog.getWindow().setBackgroundDrawableResource(17170445);
            return dialog;
        } catch (Exception e2) {
            if (!b.v) {
                return null;
            }
            q.d(String.valueOf(e2));
            return null;
        }
    }

    public static void a(final Activity activity, String str, String str2) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    if (str == null) {
                        str = "";
                    }
                    if (str2 == null) {
                        str2 = "";
                    }
                    final h hVar = new h(activity);
                    hVar.setTitle(str);
                    hVar.a(str2);
                    hVar.a(-3, activity.getResources().getString(R.string.wallet_ok), new View.OnClickListener() {
                        public final void onClick(View view) {
                            hVar.cancel();
                            if (net.one97.paytm.wallet.communicator.b.a().isFromAppEvoke(activity)) {
                                activity.finish();
                            }
                        }
                    });
                    hVar.setCancelable(true);
                    if (!activity.isFinishing()) {
                        hVar.show();
                    }
                }
            } catch (Exception e2) {
                if (b.v) {
                    q.d(String.valueOf(e2));
                }
            }
        }
    }

    public static void a(Activity activity, String str, String str2, DialogInterface.OnClickListener onClickListener) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    if (str == null) {
                        str = "";
                    }
                    if (str2 == null) {
                        str2 = "";
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setTitle(str);
                    builder.setMessage(str2);
                    builder.setPositiveButton(activity.getResources().getString(R.string.wallet_ok), onClickListener);
                    builder.setCancelable(false);
                    builder.show();
                }
            } catch (Exception e2) {
                if (b.v) {
                    q.d(String.valueOf(e2));
                }
            }
        }
    }

    public static boolean e(String str) {
        return !TextUtils.isEmpty(str) && str.trim().length() >= 6 && str.trim().length() <= 18 && str.trim().replaceAll("[ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789]", "").length() == 0;
    }

    public static boolean f(String str) {
        return !TextUtils.isEmpty(str) && str.trim().length() > 6 && str.trim().length() <= 18 && str.trim().replaceAll("[0123456789]", "").length() == 0;
    }

    public static final String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1991355703:
                if (str.equals(DeepLinkConstant.ACCEPT_PAYMENT_AUTHORITY)) {
                    c2 = 13;
                    break;
                }
                break;
            case -1903828497:
                if (str.equals("show_code")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1744309939:
                if (str.equals("scanner_only")) {
                    c2 = 10;
                    break;
                }
                break;
            case -1486739036:
                if (str.equals("wallet_to_ppb")) {
                    c2 = 14;
                    break;
                }
                break;
            case -1152004902:
                if (str.equals("sendmoneymobile")) {
                    c2 = 7;
                    break;
                }
                break;
            case -1102914125:
                if (str.equals("lifafa")) {
                    c2 = 2;
                    break;
                }
                break;
            case -619964558:
                if (str.equals("send_money_bank")) {
                    c2 = 6;
                    break;
                }
                break;
            case -46456017:
                if (str.equals("transfer_money_bank")) {
                    c2 = 11;
                    break;
                }
                break;
            case 337854370:
                if (str.equals("add_money")) {
                    c2 = 4;
                    break;
                }
                break;
            case 704464919:
                if (str.equals("request_money_dl")) {
                    c2 = 8;
                    break;
                }
                break;
            case 821988681:
                if (str.equals("send_money")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1375125493:
                if (str.equals("cash_ledger")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1740443408:
                if (str.equals("request_money")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1799528586:
                if (str.equals(UpiConstants.WALLET_TYPE_MONEY_TRANSFER)) {
                    c2 = 12;
                    break;
                }
                break;
            case 1910961662:
                if (str.equals("scanner")) {
                    c2 = 9;
                    break;
                }
                break;
            case 1992578977:
                if (str.equals("insurance_buy")) {
                    c2 = 15;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                return "wallet_type_pay";
            case 2:
                return "lifafa";
            case 3:
                return "wallet_type_request";
            case 4:
                return "wallet_type_add";
            case 5:
                return "show_code";
            case 6:
                return "send_money_bank";
            case 7:
                return "sendmoneymobile";
            case 8:
                return "request_money_dl";
            case 9:
                return "scanner";
            case 10:
                return "scanner_only";
            case 11:
                return "send_money_bank";
            case 12:
                return UpiConstants.WALLET_TYPE_MONEY_TRANSFER;
            case 13:
                return DeepLinkConstant.ACCEPT_PAYMENT_AUTHORITY;
            case 14:
                return "wallet_to_ppb";
            case 15:
                return "insurance_buy";
            default:
                return str;
        }
    }

    public static int h(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        Uri parse = Uri.parse(str);
        boolean z = false;
        if (parse != null && parse.getHost() != null && parse.getHost().equalsIgnoreCase("qr.paytm.in") && q(str)) {
            return 9;
        }
        if (b.o(str) || b.s(str)) {
            return 1;
        }
        if (str.length() == 24) {
            if (str.equalsIgnoreCase("2810050501011O7KV4V6FDGU")) {
                return 3;
            }
            return "90".equalsIgnoreCase(str.substring(6, 8)) ? 4 : 2;
        } else if (!TextUtils.isEmpty(i(str))) {
            return 5;
        } else {
            Matcher matcher = Pattern.compile("BEGIN:VCARD", 2).matcher(str);
            if (matcher.find() && matcher.start() == 0) {
                z = true;
            }
            if (z) {
                return 6;
            }
            return 1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0027, code lost:
        if (r4.length() < 10) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String i(java.lang.String r4) {
        /*
            java.lang.String r0 = r4.toLowerCase()
            java.lang.String r1 = "c="
            boolean r0 = r0.startsWith(r1)
            r1 = 0
            if (r0 == 0) goto L_0x0061
            java.lang.String r0 = "="
            java.lang.String[] r4 = r4.split(r0)
            int r0 = r4.length
            r2 = 1
            if (r0 <= r2) goto L_0x0029
            r4 = r4[r2]
            java.lang.String r0 = "^\"|\"$"
            java.lang.String r3 = ""
            java.lang.String r4 = r4.replaceAll(r0, r3)
            int r0 = r4.length()
            r3 = 10
            if (r0 >= r3) goto L_0x002a
        L_0x0029:
            r4 = r1
        L_0x002a:
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L_0x0062
            java.lang.String r0 = "+"
            boolean r0 = r4.startsWith(r0)
            if (r0 == 0) goto L_0x0046
            int r0 = r4.length()
            r3 = 13
            if (r0 != r3) goto L_0x0046
            r0 = 3
            java.lang.String r4 = r4.substring(r0)
            goto L_0x0062
        L_0x0046:
            int r0 = r4.length()
            r3 = 12
            if (r0 != r3) goto L_0x0054
            r0 = 2
            java.lang.String r4 = r4.substring(r0)
            goto L_0x0062
        L_0x0054:
            int r0 = r4.length()
            r3 = 11
            if (r0 != r3) goto L_0x0062
            java.lang.String r4 = r4.substring(r2)
            goto L_0x0062
        L_0x0061:
            r4 = r1
        L_0x0062:
            boolean r0 = com.paytm.utility.b.b((java.lang.String) r4)
            if (r0 == 0) goto L_0x0069
            return r4
        L_0x0069:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.utility.a.i(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003b A[Catch:{ Exception -> 0x006c }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r8, android.widget.TextView r9) {
        /*
            java.lang.String r0 = ""
            boolean r1 = android.text.TextUtils.isEmpty(r8)
            if (r1 == 0) goto L_0x0009
            return
        L_0x0009:
            android.graphics.Typeface r1 = r9.getTypeface()     // Catch:{ Exception -> 0x006c }
            r2 = 0
            if (r1 == 0) goto L_0x0019
            android.graphics.Typeface r1 = r9.getTypeface()     // Catch:{ Exception -> 0x006c }
            if (r1 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r1 = r2
            goto L_0x0020
        L_0x0019:
            java.lang.String r1 = "sans-serif-medium"
            r3 = 1
            android.graphics.Typeface r1 = android.graphics.Typeface.create(r1, r3)     // Catch:{ Exception -> 0x006c }
        L_0x0020:
            android.graphics.Typeface r3 = r9.getTypeface()     // Catch:{ Exception -> 0x006c }
            r4 = 0
            if (r3 == 0) goto L_0x002d
            android.graphics.Typeface r3 = r9.getTypeface()     // Catch:{ Exception -> 0x006c }
            if (r3 == 0) goto L_0x0033
        L_0x002d:
            java.lang.String r2 = "sans-serif-light"
            android.graphics.Typeface r2 = android.graphics.Typeface.create(r2, r4)     // Catch:{ Exception -> 0x006c }
        L_0x0033:
            java.lang.String r3 = "\\."
            java.lang.String[] r3 = r8.split(r3)     // Catch:{ Exception -> 0x006c }
            if (r3 == 0) goto L_0x006b
            int r5 = r3.length     // Catch:{ Exception -> 0x006c }
            if (r5 > 0) goto L_0x003f
            goto L_0x006b
        L_0x003f:
            r3 = r3[r4]     // Catch:{ Exception -> 0x006c }
            int r3 = r3.length()     // Catch:{ Exception -> 0x006c }
            int r5 = r8.length()     // Catch:{ Exception -> 0x006c }
            android.text.SpannableStringBuilder r6 = new android.text.SpannableStringBuilder     // Catch:{ Exception -> 0x006c }
            r6.<init>(r8)     // Catch:{ Exception -> 0x006c }
            com.paytm.utility.CustomTypefaceSpan r7 = new com.paytm.utility.CustomTypefaceSpan     // Catch:{ Exception -> 0x006c }
            r7.<init>(r0, r1)     // Catch:{ Exception -> 0x006c }
            r1 = 34
            r6.setSpan(r7, r4, r3, r1)     // Catch:{ Exception -> 0x006c }
            java.lang.String r4 = "."
            boolean r8 = r8.contains(r4)     // Catch:{ Exception -> 0x006c }
            if (r8 == 0) goto L_0x0068
            com.paytm.utility.CustomTypefaceSpan r8 = new com.paytm.utility.CustomTypefaceSpan     // Catch:{ Exception -> 0x006c }
            r8.<init>(r0, r2)     // Catch:{ Exception -> 0x006c }
            r6.setSpan(r8, r3, r5, r1)     // Catch:{ Exception -> 0x006c }
        L_0x0068:
            r9.setText(r6)     // Catch:{ Exception -> 0x006c }
        L_0x006b:
            return
        L_0x006c:
            r8 = move-exception
            java.lang.String r8 = java.lang.String.valueOf(r8)
            com.paytm.utility.q.d(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.utility.a.a(java.lang.String, android.widget.TextView):void");
    }

    public static void b(String str, TextView textView) {
        Typeface typeface;
        try {
            Typeface typeface2 = null;
            if (textView.getTypeface() != null) {
                if (textView.getTypeface() == null) {
                    typeface = null;
                    if (textView.getTypeface() == null || textView.getTypeface() != null) {
                        typeface2 = Typeface.create("sans-serif-light", 0);
                    }
                    int length = new String[]{str.substring(0, str.length() - 8), str.substring(str.length() - 8)}[0].length();
                    int length2 = str.length();
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                    spannableStringBuilder.setSpan(new CustomTypefaceSpan("", typeface2), 0, length, 34);
                    spannableStringBuilder.setSpan(new CustomTypefaceSpan("", typeface), length, length2, 34);
                    textView.setText(spannableStringBuilder);
                }
            }
            typeface = Typeface.create("sans-serif-medium", 1);
            typeface2 = Typeface.create("sans-serif-light", 0);
            int length3 = new String[]{str.substring(0, str.length() - 8), str.substring(str.length() - 8)}[0].length();
            int length22 = str.length();
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str);
            spannableStringBuilder2.setSpan(new CustomTypefaceSpan("", typeface2), 0, length3, 34);
            spannableStringBuilder2.setSpan(new CustomTypefaceSpan("", typeface), length3, length22, 34);
            textView.setText(spannableStringBuilder2);
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    public static void b(Context context, String str) {
        if (Build.VERSION.SDK_INT < 11) {
            ((ClipboardManager) context.getSystemService("clipboard")).setText(str);
        } else {
            ((android.content.ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Copied Text", str));
        }
    }

    public static String b(Context context) {
        return "https://assetscdn.paytm.com/images/catalog/wallet/card_bg-" + l.a(context).toLowerCase() + ".png";
    }

    public static String c(Context context) {
        return "https://assetscdn.paytm.com/images/catalog/wallet/IdayCard-" + l.a(context).toLowerCase() + ".png";
    }

    public static boolean c(Context context, String str) {
        try {
            context.getPackageManager().getApplicationInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void a(Context context, String str, String str2) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.setPackage(str);
        intent.putExtra("android.intent.extra.TEXT", str2);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            q.d(String.valueOf(e2));
        }
    }

    public static String a() {
        return new SimpleDateFormat("dd MMM yy, hh:mm aa").format(new Date(System.currentTimeMillis()));
    }

    public static void a(Intent intent, Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            if (!b.r((Context) activity)) {
                Intent intent2 = new Intent(activity, PaySendInfoActivity.class);
                intent2.putExtra("dest", "p2p_screen");
                intent2.putExtra("UNI_P2P_BUNDLE", a(intent));
                activity.startActivity(intent2);
                activity.finish();
                return;
            }
            Intent intent3 = new Intent(activity, P2PActivity.class);
            if (intent.hasExtra("ssid")) {
                intent3.putExtra("ssid", intent.getStringExtra("ssid"));
            }
            if (intent.hasExtra(UpiConstants.IS_GALLERY_SCAN)) {
                intent3.putExtra(UpiConstants.IS_GALLERY_SCAN, intent.getBooleanExtra(UpiConstants.IS_GALLERY_SCAN, false));
            }
            if (intent.hasExtra(UpiConstants.IS_MID_SCAN)) {
                intent3.putExtra(UpiConstants.IS_MID_SCAN, intent.getBooleanExtra(UpiConstants.IS_MID_SCAN, false));
            }
            intent3.putExtra("UNI_P2P_BUNDLE", a(intent));
            activity.startActivityForResult(intent3, 3113);
        }
    }

    private static Bundle a(Intent intent) {
        Bundle bundle = new Bundle();
        if (intent.hasExtra("PHONE_NUMBER")) {
            bundle.putString("PHONE_NUMBER", intent.getStringExtra("PHONE_NUMBER"));
        }
        if (intent.hasExtra("NAME")) {
            bundle.putString("NAME", intent.getStringExtra("NAME"));
        }
        if (intent.hasExtra("UPI_ADDRESS")) {
            bundle.putString("UPI_ADDRESS", intent.getStringExtra("UPI_ADDRESS"));
        }
        if (intent.hasExtra("MODE")) {
            bundle.putString("MODE", intent.getStringExtra("MODE"));
        }
        if (intent.hasExtra("AMOUNT")) {
            bundle.putString("AMOUNT", intent.getStringExtra("AMOUNT"));
        }
        if (intent.hasExtra("BASE_UPI_RESPONSE")) {
            bundle.putSerializable("BASE_UPI_RESPONSE", intent.getSerializableExtra("BASE_UPI_RESPONSE"));
        }
        if (intent.hasExtra("SOURCE")) {
            bundle.putSerializable("SOURCE", intent.getStringExtra("SOURCE"));
        }
        if (intent.hasExtra("PAYER_ID")) {
            bundle.putSerializable("PAYER_ID", intent.getStringExtra("PAYER_ID"));
        }
        if (intent.hasExtra("PAYEE_ID")) {
            bundle.putSerializable("PAYEE_ID", intent.getStringExtra("PAYEE_ID"));
        }
        return bundle;
    }

    public static void a(Fragment fragment) {
        Intent intent = new Intent(fragment.getActivity(), net.one97.paytm.wallet.communicator.b.a().getAuthActivityClass());
        intent.putExtra("launchSignUp", false);
        intent.putExtra("set_result_required", true);
        intent.putExtra("VERTICAL_NAME", "Wallet");
        fragment.startActivityForResult(intent, KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_MEDIA);
    }

    public static Map<String, String> j(String str) throws UnsupportedEncodingException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str2 : str.split(AppConstants.AND_SIGN)) {
            int indexOf = str2.indexOf("=");
            linkedHashMap.put(URLDecoder.decode(str2.substring(0, indexOf), AppConstants.UTF_8), URLDecoder.decode(str2.substring(indexOf + 1), AppConstants.UTF_8));
        }
        return linkedHashMap;
    }

    public static String b(String str, String str2) {
        return new SimpleDateFormat(str2).format(new Date(Long.parseLong(str)));
    }

    public static String d(Context context) {
        return be.a(context.getApplicationContext()).b("kyc_state", "", true);
    }

    public static boolean e(Context context) {
        if (context != null) {
            return be.a(context.getApplicationContext()).b("add_money_refund_setting", false, true);
        }
        return false;
    }

    public static void a(Context context, boolean z) {
        if (context != null) {
            be.a(context.getApplicationContext()).a("add_money_refund_setting", z, true);
        }
    }

    public static void d(Context context, String str) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap.put("ssotoken", com.paytm.utility.a.q(context));
        hashMap.put("Content-Type", "application/json");
        new net.one97.paytm.network.b(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, "pgQRInfoURL") + c.a(context, false), new CJRQRInfoResponse(), hashMap2, hashMap, F(str)).c().observeForever(new z(str, context) {
            private final /* synthetic */ String f$0;
            private final /* synthetic */ Context f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                a.a(this.f$0, this.f$1, (f) obj);
            }
        });
    }

    private static String F(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("qrCodeId", str);
            jSONObject.put("request", jSONObject2);
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject.put("scanCompletedTime", sb.toString());
            jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "QR_CODE");
            jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
            return jSONObject.toString();
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
            return jSONObject.toString();
        } catch (Throwable unused) {
            return jSONObject.toString();
        }
    }

    public static Intent k(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        return intent;
    }

    public static long l(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0058, code lost:
        return new net.one97.paytm.common.entity.RiskAnalysis.Contact(r12, false, "0");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        if (r3 != null) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005f, code lost:
        throw r11;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x004e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.one97.paytm.common.entity.RiskAnalysis.Contact e(android.content.Context r11, java.lang.String r12) {
        /*
            java.lang.String r0 = "0"
            java.lang.String r1 = "contact_last_updated_timestamp"
            r2 = 0
            r3 = 0
            java.lang.String r4 = "data1"
            java.lang.String[] r7 = new java.lang.String[]{r1, r4}     // Catch:{ Exception -> 0x004e }
            android.content.ContentResolver r5 = r11.getContentResolver()     // Catch:{ Exception -> 0x004e }
            android.net.Uri r6 = android.provider.ContactsContract.Data.CONTENT_URI     // Catch:{ Exception -> 0x004e }
            java.lang.String r8 = "data1 LIKE '%' || ?"
            r11 = 1
            java.lang.String[] r9 = new java.lang.String[r11]     // Catch:{ Exception -> 0x004e }
            r9[r2] = r12     // Catch:{ Exception -> 0x004e }
            r10 = 0
            android.database.Cursor r3 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x004e }
            if (r3 == 0) goto L_0x0043
            boolean r4 = r3.moveToFirst()     // Catch:{ Exception -> 0x004e }
            if (r4 == 0) goto L_0x0043
            int r4 = r3.getCount()     // Catch:{ Exception -> 0x004e }
            if (r4 <= 0) goto L_0x0043
            int r1 = r3.getColumnIndex(r1)     // Catch:{ Exception -> 0x004e }
            long r4 = r3.getLong(r1)     // Catch:{ Exception -> 0x004e }
            net.one97.paytm.common.entity.RiskAnalysis.Contact r1 = new net.one97.paytm.common.entity.RiskAnalysis.Contact     // Catch:{ Exception -> 0x004e }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x004e }
            r1.<init>(r12, r11, r4)     // Catch:{ Exception -> 0x004e }
            if (r3 == 0) goto L_0x0042
            r3.close()
        L_0x0042:
            return r1
        L_0x0043:
            if (r3 == 0) goto L_0x0048
            r3.close()
        L_0x0048:
            net.one97.paytm.common.entity.RiskAnalysis.Contact r11 = new net.one97.paytm.common.entity.RiskAnalysis.Contact
            r11.<init>(r12, r2, r0)
            return r11
        L_0x004e:
            net.one97.paytm.common.entity.RiskAnalysis.Contact r11 = new net.one97.paytm.common.entity.RiskAnalysis.Contact     // Catch:{ all -> 0x0059 }
            r11.<init>(r12, r2, r0)     // Catch:{ all -> 0x0059 }
            if (r3 == 0) goto L_0x0058
            r3.close()
        L_0x0058:
            return r11
        L_0x0059:
            r11 = move-exception
            if (r3 == 0) goto L_0x005f
            r3.close()
        L_0x005f:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.utility.a.e(android.content.Context, java.lang.String):net.one97.paytm.common.entity.RiskAnalysis.Contact");
    }

    public static String c(String str, String str2) {
        if (str == null || str.trim().length() <= 0) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = null;
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e2) {
            if (b.v) {
                q.d(String.valueOf(e2));
            }
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str2);
        simpleDateFormat2.setTimeZone(TimeZone.getDefault());
        String format = simpleDateFormat2.format(date);
        return !TextUtils.isEmpty(format) ? format.replace("-", " ") : str;
    }

    public static boolean m(String str) {
        return str.startsWith("paytmmp://") || str.startsWith("paytmmall://") || str.startsWith("paytmba://") || str.startsWith(PMConstants.PAYTM_MONEY_APP_URI);
    }

    public static void a(final Activity activity, final n nVar) {
        if (activity != null && !activity.isFinishing()) {
            String str = null;
            String string = TextUtils.isEmpty((CharSequence) null) ? activity.getResources().getString(R.string.message_401_410) : null;
            if (TextUtils.isEmpty((CharSequence) null)) {
                str = activity.getResources().getString(R.string.title_401_410);
            }
            String q = com.paytm.utility.a.q(activity);
            if (!TextUtils.isEmpty(q)) {
                String concat = "/".concat(String.valueOf(q));
                if (!TextUtils.isEmpty(string) && string.contains(concat)) {
                    string = string.replace(concat, "");
                }
            }
            String b2 = d.b(activity);
            if (!TextUtils.isEmpty(b2)) {
                String concat2 = "/".concat(String.valueOf(b2));
                if (!TextUtils.isEmpty(string) && string.contains(concat2)) {
                    string = string.replace(concat2, "");
                }
            }
            g.b(activity, str, string, new g.c() {
                public final void onDialogDismissed() {
                    net.one97.paytm.wallet.communicator.b.a().signOut(activity);
                    nVar.a();
                }
            });
        }
    }

    public static MerchantVerifedStatus n(String str) {
        if (TextUtils.isEmpty(str)) {
            return MerchantVerifedStatus.MERCHANT_NO_STATUS;
        }
        try {
            String optString = new JSONObject(str).optString("merchantVerified");
            if (TextUtils.isEmpty(optString)) {
                return MerchantVerifedStatus.MERCHANT_NO_STATUS;
            }
            if (optString.equalsIgnoreCase("true")) {
                return MerchantVerifedStatus.MERCHANT_VERIFED;
            }
            return MerchantVerifedStatus.MERCHANT_UNVERIFED;
        } catch (Exception unused) {
            return MerchantVerifedStatus.MERCHANT_NO_STATUS;
        }
    }

    public static void a(Activity activity, final o oVar) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.unverified_merchant_dialog);
        ((TextView) dialog.findViewById(R.id.tv_cancel)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                oVar.b();
                dialog.dismiss();
            }
        });
        ((TextView) dialog.findViewById(R.id.ll_proceed)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                oVar.a();
                dialog.dismiss();
            }
        });
        if (activity != null && !activity.isFinishing()) {
            dialog.show();
        }
    }

    public static String a(double d2) {
        try {
            return new DecimalFormat("##,##,##,##,##,##,###.##").format(d2);
        } catch (Exception unused) {
            return String.valueOf(d2);
        }
    }

    public static Bundle o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String replace = str.replace('$', '&');
        Bundle bundle = new Bundle();
        int indexOf = replace.indexOf(63);
        if (indexOf == -1) {
            return null;
        }
        while (true) {
            int indexOf2 = replace.indexOf(61);
            if (indexOf2 == -1) {
                break;
            }
            String substring = replace.substring(indexOf + 1, indexOf2);
            int indexOf3 = replace.indexOf(38);
            if (indexOf3 == -1) {
                bundle.putString(substring, replace.substring(indexOf2 + 1));
                break;
            }
            bundle.putString(substring, replace.substring(indexOf2 + 1, indexOf3));
            replace = replace.substring(indexOf3 + 1);
            indexOf = -1;
        }
        return bundle;
    }

    public static String p(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str.replaceAll("[₹, ]", "").trim().replaceAll("^\\s+", "");
    }

    public static boolean q(String str) {
        Uri parse = Uri.parse(str);
        return parse != null && !TextUtils.isEmpty(parse.getPath()) && !TextUtils.isEmpty(parse.getLastPathSegment()) && !TextUtils.isEmpty(parse.getHost()) && "qr.paytm.in".equalsIgnoreCase(parse.getHost());
    }

    public static String d(String str, String str2) {
        return str + "|isaddnpaytowallet:true|addmoney:" + str2;
    }

    private static boolean G(String str) {
        Map linkedHashMap = new LinkedHashMap();
        try {
            linkedHashMap = j(str);
        } catch (Exception unused) {
        }
        if (linkedHashMap.containsKey("upi://pay?pa")) {
            String str2 = (String) linkedHashMap.get("upi://pay?pa");
            if (TextUtils.isEmpty(str2) || ((!str2.contains("paytmqr") && !str2.contains("pgqr")) || !str2.contains("@paytm"))) {
                return false;
            }
            return true;
        }
        return false;
    }

    private static String H(String str) {
        String str2;
        String[] split = str.split(AppConstants.AND_SIGN);
        int length = split.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str2 = null;
                break;
            }
            String str3 = split[i2];
            if (str3.startsWith("paytmqr")) {
                String[] split2 = str3.split("=");
                if (split2.length > 1) {
                    str2 = split2[1];
                    break;
                }
            }
            i2++;
        }
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        for (String str4 : str.split("\\?")[1].split(AppConstants.AND_SIGN)) {
            if (str4.startsWith("pa")) {
                String[] split3 = str4.split("=");
                if (split3.length > 1) {
                    String str5 = split3[1];
                    if (!str5.startsWith("paytmqr") || !str5.contains("@paytm")) {
                        return (!str5.startsWith("pgqr") || !str5.contains("@paytm")) ? str2 : str5.substring(str5.indexOf("pgqr") + 4, str5.indexOf("@"));
                    }
                    return str5.substring(str5.indexOf("paytmqr") + 7, str5.indexOf("@"));
                }
            }
        }
        return str2;
    }

    public static String r(String str) {
        if (!b.p(str) || !G(str)) {
            return null;
        }
        return H(str);
    }

    public static boolean s(String str) {
        String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(net.one97.paytm.wallet.communicator.b.a().getContext(), "P0_REGEX");
        if (TextUtils.isEmpty(stringFromGTM)) {
            stringFromGTM = "^^(281005|000000)[a-zA-Z0-9]{18}$";
        }
        return Pattern.compile(stringFromGTM).matcher(str).find();
    }

    public static boolean t(String str) {
        return !TextUtils.isEmpty(str) && str.contains("@");
    }

    public static <T> T a(Object obj, Class<T> cls) {
        com.google.gsonhtcfix.f fVar = new com.google.gsonhtcfix.f();
        return fVar.a(fVar.a(obj), cls);
    }

    public static boolean f(Context context) {
        return androidx.core.app.a.a(context, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public static void a(Activity activity, int i2) {
        androidx.core.app.a.a(activity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, i2);
    }

    public static boolean g(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((LocationManager) context.getSystemService("location")).isLocationEnabled();
        }
        return Settings.Secure.getInt(context.getContentResolver(), "location_mode", 0) != 0;
    }

    public static void a(Activity activity, OnSuccessListener<com.google.android.gms.location.g> onSuccessListener, OnFailureListener onFailureListener) {
        LocationRequest a2 = LocationRequest.a();
        a2.a(100);
        a2.a(2000);
        a2.b(1000);
        Task<com.google.android.gms.location.g> a3 = com.google.android.gms.location.f.a(activity).a(new LocationSettingsRequest.a().a(a2).b());
        a3.a(activity, (OnSuccessListener<? super com.google.android.gms.location.g>) onSuccessListener);
        a3.a(activity, onFailureListener);
    }

    public static String a(boolean z, String str, String str2, String str3, String str4, boolean z2, String str5, String str6, boolean z3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isSingleAPI", z);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("transcationTime", System.currentTimeMillis() - Long.parseLong(str));
            }
            jSONObject.put("suggestedInstrument", str2);
            jSONObject.put("usedInstrument", str3);
            jSONObject.put("transcationStatus", str4);
            jSONObject.put("isFromRecent", z2);
            jSONObject.put("isAutoFlashTransaction", z3);
            if (!TextUtils.isEmpty(str5)) {
                jSONObject.put("page_load_type", str5);
            }
            if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str)) {
                jSONObject.put("page_load_time", Long.parseLong(str6) - Long.parseLong(str));
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static Intent h(Context context) {
        if (net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(context, "usePostPaymentOldFlow", false)) {
            return net.one97.paytm.wallet.communicator.b.a().getPaymentSuccessIntent(context);
        }
        if (net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(context, "p2mPostPaymentV2Enabled", true)) {
            return new Intent(context, P2MPaymentSuccessActivityV2.class);
        }
        return new Intent(context, P2MPaymentSuccessActivity.class);
    }

    public static Drawable g(Context context, String str) {
        try {
            if (SDKConstants.VISA.toLowerCase().equals(str.toLowerCase())) {
                return androidx.core.content.b.a(context, R.drawable.ic_visa);
            }
            if (SDKConstants.MAESTRO.toLowerCase().equals(str.toLowerCase())) {
                return androidx.core.content.b.a(context, R.drawable.ic_maestro);
            }
            if ("RUPAY".toLowerCase().equals(str.toLowerCase())) {
                return androidx.core.content.b.a(context, R.drawable.ic_rupay);
            }
            if ("DINERS".toLowerCase().equals(str.toLowerCase())) {
                return androidx.core.content.b.a(context, R.drawable.ic_diners);
            }
            if ("MASTER".toLowerCase().equals(str.toLowerCase())) {
                return androidx.core.content.b.a(context, R.drawable.ic_mastercard);
            }
            if ("AMEX".toLowerCase().equals(str.toLowerCase())) {
                return androidx.core.content.b.a(context, R.drawable.ic_amex);
            }
            return null;
        } catch (Exception unused) {
        }
    }

    public static String u(String str) {
        return str + ("&userAgent=" + System.getProperty("http.agent")) + "&CHANNEL_ID=APP";
    }

    public static boolean v(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Map linkedHashMap = new LinkedHashMap();
        try {
            linkedHashMap = j(str);
        } catch (Exception unused) {
        }
        if (!linkedHashMap.containsKey("mid") || !linkedHashMap.containsKey(UpiConstants.URI_IS_ORDER_CREATED_KEY)) {
            return false;
        }
        return true;
    }

    public static String w(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map linkedHashMap = new LinkedHashMap();
        try {
            linkedHashMap = j(str);
        } catch (Exception unused) {
        }
        if (linkedHashMap.containsKey("mid")) {
            return (String) linkedHashMap.get("mid");
        }
        return null;
    }

    public static boolean x(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("upi://")) {
            return false;
        }
        Map linkedHashMap = new LinkedHashMap();
        try {
            linkedHashMap = j(str);
        } catch (Exception unused) {
        }
        return linkedHashMap.containsKey("tr");
    }

    public static String h(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int i2 = 0;
        String replaceAll = str.trim().replaceAll("[^\\d+]", "");
        if (replaceAll.startsWith(context.getString(R.string.mobile_number_prefix_91))) {
            i2 = 3;
        } else if (replaceAll.startsWith(context.getString(R.string.mobile_number_prefix_91_without_plus))) {
            i2 = 2;
        } else if (replaceAll.startsWith(context.getString(R.string.mobile_number_prefix_0))) {
            i2 = 1;
        }
        return replaceAll.substring(i2, replaceAll.length()).trim().replaceAll(" ", "");
    }

    public static boolean y(String str) {
        if (TextUtils.isEmpty(str) || str.length() > 249) {
            return false;
        }
        if ((!str.matches("[0-9]+") || str.length() < 10 || str.length() > 12) && str.contains("@")) {
            return true;
        }
        return false;
    }

    public static boolean i(Context context) {
        return net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(context, Constants.EVENTS_IS_NATIVE_OTP_ENABLED, true);
    }

    public static boolean a(String str, Context context) {
        for (String contentEquals : o(context)) {
            if (str.contentEquals(contentEquals)) {
                return true;
            }
        }
        return false;
    }

    private static List<String> o(Context context) {
        try {
            String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, "whiteListedScannedUrls");
            if (TextUtils.isEmpty(stringFromGTM)) {
                return new ArrayList(0);
            }
            return Arrays.asList((String[]) new com.google.gson.f().a(stringFromGTM, String[].class));
        } catch (Exception unused) {
            return new ArrayList(0);
        }
    }

    public static void a(Window window) {
        if (Build.VERSION.SDK_INT >= 21 && window != null) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
    }

    public static String z(String str) {
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("pn");
            if (!TextUtils.isEmpty(queryParameter)) {
                return URLDecoder.decode(queryParameter, AppConstants.UTF_8);
            }
            return "UPI";
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
            return "UPI";
        }
    }

    public static String A(String str) {
        String str2 = "";
        boolean z = false;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (z) {
                str2 = str2 + str.toUpperCase().charAt(i2);
            } else if (i2 == 0) {
                str2 = str2 + str.toUpperCase().charAt(i2);
            } else {
                str2 = str2 + str.toLowerCase().charAt(i2);
            }
            z = str.charAt(i2) == ' ';
        }
        return str2;
    }

    public static String B(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str) || str.length() <= 4) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 2; i2++) {
            sb.append("X");
        }
        String substring = str.substring(str.length() - 4);
        sb.append(" ");
        sb.append(substring);
        return sb.toString();
    }

    public static void j(Context context) {
        Intent intent = new Intent(context, AJRScanWebView.class);
        String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, "syncContactConcentPageURL");
        if (TextUtils.isEmpty(stringFromGTM)) {
            stringFromGTM = "https://kyc.paytmbank.com/kyc/tnc/get/1000";
        }
        intent.putExtra("url", stringFromGTM);
        intent.putExtra("KEY_HIDE_TITLE", true);
        context.startActivity(intent);
    }

    public static Map<String, String> k(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept", "application/json");
        hashMap.put("verification_type", "oauth_token");
        hashMap.put("data", com.paytm.utility.a.q(context));
        hashMap.put("Authorization", b.m());
        return hashMap;
    }

    public static Map<String, String> l(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("session_token", com.paytm.utility.a.q(context));
        hashMap.put("Authorization", b.m());
        return hashMap;
    }

    public static String d() {
        DeviceDetailPreference deviceDetailPreference = new DeviceDetailPreference();
        e eVar = e.f55762a;
        deviceDetailPreference.setDEVICE_PASSCODE_VERIFIED(e.c());
        return new com.google.gsonhtcfix.f().a((Object) deviceDetailPreference);
    }

    public static String C(String str) {
        if (b.p(str)) {
            return H(str);
        }
        return null;
    }

    public static int a(int i2, Context context) {
        return (int) TypedValue.applyDimension(1, (float) i2, context.getResources().getDisplayMetrics());
    }

    public static void a(View view, int i2, int i3) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins(0, i2, 0, i3);
            view.requestLayout();
        }
    }

    public static void d(Activity activity) {
        String str;
        RiskExtendedInfo osType = net.one97.paytm.f.b.a().f50402a.setTerminalType("APP").setDeviceId(b.A(activity.getApplicationContext())).setAppVersion(b.Q(activity.getApplicationContext())).setVersionCode(p((Context) activity)).setOsType(StringSet.Android);
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        RiskExtendedInfo timeZone = osType.setScreenResolution(point.x + "x" + point.y).setIsRooted(b.t()).setPhoneModel(b.c()).setIMEI(q((Context) activity)).setDeviceManufacturer(b.b()).setDeviceLanguage(b.a((Context) activity)).setTimeZone(Calendar.getInstance().getTimeZone().getDisplayName(false, 0));
        String str2 = null;
        if (activity != null) {
            str = ((WifiManager) activity.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getBSSID();
        } else {
            str = null;
        }
        RiskExtendedInfo routerMac = timeZone.setRouterMac(str);
        if (activity != null) {
            str2 = Formatter.formatIpAddress(((WifiManager) activity.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getIpAddress());
        }
        routerMac.setClientIp(str2).setIsOfflineMerchant(true).setIsOnlineMerchant(false).setOperationOrigin("consumer app").setPaymentFlow("").setOperationType("PAYMENT").setFuzzyDeviceId(b.A((Context) activity));
    }

    private static String p(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (Exception unused) {
            return H5BridgeContext.INVALID_ID;
        }
    }

    private static String q(Context context) {
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(ContactColumn.PHONE_NUMBER);
                if (Build.VERSION.SDK_INT > 28) {
                    return b.d(context);
                }
                if (androidx.core.app.a.a(context, "android.permission.READ_PHONE_STATE") != 0) {
                    return b.d(context);
                }
                if (telephonyManager.getDeviceId() != null) {
                    return telephonyManager.getDeviceId();
                }
                return b.d(context);
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String a(Context context, int i2) {
        return (context == null || !(context instanceof Activity) || ((Activity) context).isFinishing()) ? "" : context.getResources().getString(i2);
    }

    public static boolean m(Context context) {
        String n = b.n(context);
        if (TextUtils.isEmpty(n) || !TextUtils.isDigitsOnly(n) || ((long) Integer.parseInt(n)) % 100 > ((long) net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM("singleApiV2CustIdEligibleValue", 5))) {
            return false;
        }
        return true;
    }

    public static boolean D(String str) {
        return str.matches(".*[a-zA-Z]+.*");
    }

    public static String E(String str) {
        return str.replaceFirst("^0+(?!$)", "");
    }

    public static List<String> n(Context context) {
        String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, "walletVpaSuggestionsList");
        if (stringFromGTM == null || stringFromGTM.isEmpty()) {
            stringFromGTM = "paytm,ybl,okicici,okaxis,icici,axisbank,yesbank";
        }
        return Arrays.asList(stringFromGTM.split(AppConstants.COMMA));
    }

    public static String f(Context context, String str) {
        String str2;
        if (str.startsWith("paytmmp")) {
            str2 = "net.one97.paytm";
        } else if (str.startsWith("paytmmall")) {
            str2 = "com.paytmmall";
        } else if (str.startsWith("paytmba")) {
            str2 = "com.paytm.business";
        } else {
            str2 = str.startsWith(DeepLinkConstant.PATTERN_PAYTM_MONEY) ? PMConstants.PAYTM_MONEY_NATIVE_PACKAGE_NAME : "";
        }
        try {
            context.getPackageManager().getPackageInfo(str2, 1);
            return "";
        } catch (PackageManager.NameNotFoundException unused) {
            return str2;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(String str, Context context, f fVar) {
        if (fVar.f55796a != net.one97.paytm.network.h.SUCCESS) {
            net.one97.paytm.network.h hVar = net.one97.paytm.network.h.ERROR;
        } else if (fVar.f55797b instanceof CJRQRInfoResponse) {
            CJRQRInfoResponse cJRQRInfoResponse = (CJRQRInfoResponse) fVar.f55797b;
            if (cJRQRInfoResponse.getStatusCode().equalsIgnoreCase("SUCCESS")) {
                JSONObject response = cJRQRInfoResponse.getResponse();
                try {
                    response.put(CJRQRScanResultModel.KEY_QR_CODE_ID, str);
                } catch (JSONException e2) {
                    q.d(String.valueOf(e2));
                }
                if (response != null) {
                    try {
                        String string = response.getString(CJRQRScanResultModel.KEY_TAG_LINE);
                        Intent intent = new Intent("com.android.wallet.TAGLINE_REFERER");
                        intent.putExtra("merchant_tagline", string);
                        context.sendBroadcast(intent);
                    } catch (JSONException e3) {
                        q.d(String.valueOf(e3));
                    }
                    j.a().a(context, response.toString(), str, 1, 2);
                }
            }
        }
    }
}
