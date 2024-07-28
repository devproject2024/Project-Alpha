package net.one97.paytm.passbook.mapping;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.business.merchant_payments.deeplinkUtil.DeepLinkConstant;
import com.paytm.b.a.a;
import com.paytm.utility.b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.utility.m;
import net.one97.paytm.upi.util.UpiConstants;

public final class c extends b {
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003b A[Catch:{ Exception -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(java.lang.String r8, android.widget.TextView r9) {
        /*
            java.lang.String r0 = ""
            boolean r1 = android.text.TextUtils.isEmpty(r8)
            if (r1 == 0) goto L_0x0009
            return
        L_0x0009:
            android.graphics.Typeface r1 = r9.getTypeface()     // Catch:{ Exception -> 0x006b }
            r2 = 0
            if (r1 == 0) goto L_0x0019
            android.graphics.Typeface r1 = r9.getTypeface()     // Catch:{ Exception -> 0x006b }
            if (r1 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r1 = r2
            goto L_0x0020
        L_0x0019:
            java.lang.String r1 = "sans-serif-medium"
            r3 = 1
            android.graphics.Typeface r1 = android.graphics.Typeface.create(r1, r3)     // Catch:{ Exception -> 0x006b }
        L_0x0020:
            android.graphics.Typeface r3 = r9.getTypeface()     // Catch:{ Exception -> 0x006b }
            r4 = 0
            if (r3 == 0) goto L_0x002d
            android.graphics.Typeface r3 = r9.getTypeface()     // Catch:{ Exception -> 0x006b }
            if (r3 == 0) goto L_0x0033
        L_0x002d:
            java.lang.String r2 = "sans-serif-light"
            android.graphics.Typeface r2 = android.graphics.Typeface.create(r2, r4)     // Catch:{ Exception -> 0x006b }
        L_0x0033:
            java.lang.String r3 = "\\."
            java.lang.String[] r3 = r8.split(r3)     // Catch:{ Exception -> 0x006b }
            if (r3 == 0) goto L_0x006b
            int r5 = r3.length     // Catch:{ Exception -> 0x006b }
            if (r5 > 0) goto L_0x003f
            goto L_0x006b
        L_0x003f:
            r3 = r3[r4]     // Catch:{ Exception -> 0x006b }
            int r3 = r3.length()     // Catch:{ Exception -> 0x006b }
            int r5 = r8.length()     // Catch:{ Exception -> 0x006b }
            android.text.SpannableStringBuilder r6 = new android.text.SpannableStringBuilder     // Catch:{ Exception -> 0x006b }
            r6.<init>(r8)     // Catch:{ Exception -> 0x006b }
            com.paytm.utility.CustomTypefaceSpan r7 = new com.paytm.utility.CustomTypefaceSpan     // Catch:{ Exception -> 0x006b }
            r7.<init>(r0, r1)     // Catch:{ Exception -> 0x006b }
            r1 = 34
            r6.setSpan(r7, r4, r3, r1)     // Catch:{ Exception -> 0x006b }
            java.lang.String r4 = "."
            boolean r8 = r8.contains(r4)     // Catch:{ Exception -> 0x006b }
            if (r8 == 0) goto L_0x0068
            com.paytm.utility.CustomTypefaceSpan r8 = new com.paytm.utility.CustomTypefaceSpan     // Catch:{ Exception -> 0x006b }
            r8.<init>(r0, r2)     // Catch:{ Exception -> 0x006b }
            r6.setSpan(r8, r3, r5, r1)     // Catch:{ Exception -> 0x006b }
        L_0x0068:
            r9.setText(r6)     // Catch:{ Exception -> 0x006b }
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.mapping.c.b(java.lang.String, android.widget.TextView):void");
    }

    public static Dialog f(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.pass_lyt_progress_bar);
            dialog.getWindow().setBackgroundDrawableResource(17170445);
            return dialog;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean ao(Context context) {
        if (context != null) {
            return m.a(d.b().b()).b("add_money_refund_setting", false, true);
        }
        return false;
    }

    public static String j(String str, String str2) {
        return new SimpleDateFormat(str2).format(new Date(Long.parseLong(str)));
    }

    public static void g(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            a((Context) activity, activity.getResources().getString(R.string.no_connection), activity.getResources().getString(R.string.no_internet));
        }
    }

    public static void a(Activity activity, DialogInterface.OnClickListener onClickListener) {
        if (activity != null && !activity.isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle(activity.getResources().getString(R.string.no_connection));
            builder.setMessage(activity.getResources().getString(R.string.no_internet));
            builder.setPositiveButton(activity.getResources().getString(R.string.network_retry_yes), onClickListener);
            builder.show();
        }
    }

    public static String k(String str, String str2, String str3) {
        try {
            return new SimpleDateFormat(str2).format(new SimpleDateFormat(str, Locale.ENGLISH).parse(str3));
        } catch (Exception unused) {
            return "";
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
                    builder.setPositiveButton(activity.getResources().getString(R.string.ok), onClickListener);
                    builder.setCancelable(false);
                    builder.show();
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void Z(String str) {
        m.a(d.b().b()).a("pref_key_wallet_balance", str, true);
    }

    public static String v() {
        return m.a(d.b().b()).b("pass_wallet_grade_kyc_state", "", false);
    }

    public static void aa(String str) {
        a a2 = m.a(d.b().b());
        a2.a("kyc_state", str, true);
        a2.a("pass_wallet_grade_kyc_state", str, false);
    }

    public static final String ab(String str) {
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
                    c2 = 15;
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
            case 116765:
                if (str.equals("vip")) {
                    c2 = 14;
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
                    c2 = 16;
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
                return "vip";
            case 15:
                return "wallet_to_ppb";
            case 16:
                return "insurance_buy";
            default:
                return "";
        }
    }
}
