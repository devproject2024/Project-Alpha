package net.one97.paytm.p2mNewDesign.h;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;
import com.paytm.utility.b;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.utils.at;
import net.one97.paytm.utils.be;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.c;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f51295a = new a();

    private a() {
    }

    public static boolean a(Context context) {
        k.c(context, "context");
        return b.a(context.getApplicationContext(), net.one97.paytm.wallet.utility.a.l(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, "app_rating_5_star_time_gap")), net.one97.paytm.wallet.utility.a.l(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, "app_rating_less_than_5_star_time_gap")), net.one97.paytm.wallet.utility.a.l(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, "app_rating_not_now_time_gap")));
    }

    public static boolean b(Context context) {
        k.c(context, "context");
        be.a aVar = be.f69718a;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        com.paytm.b.a.a a2 = be.a.a(applicationContext);
        int i2 = a2.b("rating", 0, true) == 0 ? 1 : 0;
        a2.a("rating", i2, true);
        return i2 == 0;
    }

    public static String a(Activity activity, String str) {
        k.c(activity, "activity");
        k.c(str, "mode");
        if (p.a("BALANCE", str, true)) {
            return activity.getResources().getString(R.string.paytm_wallet);
        }
        if (p.a("PAYTM_DIGITAL_CREDIT", str, true)) {
            return activity.getResources().getString(R.string.paytm_postpaid);
        }
        if (p.a(SDKConstants.AI_KEY_PPBL, str, true)) {
            return activity.getResources().getString(R.string.paytm_payment_bank);
        }
        if (p.a(SDKConstants.CREDIT, str, true)) {
            return activity.getResources().getString(R.string.credit_card);
        }
        if (p.a(SDKConstants.DEBIT, str, true)) {
            return activity.getResources().getString(R.string.debit_card);
        }
        if (p.a("UPI", str, true)) {
            return activity.getResources().getString(R.string.upi);
        }
        return p.a("NET_BANKING", str, true) ? activity.getResources().getString(R.string.net_banking) : "";
    }

    public static void a(String str) {
        k.c(str, "status");
        at.a().a(at.a.Tprocess, System.currentTimeMillis(), str);
        at.a().a(at.a.Tpayment, System.currentTimeMillis(), str);
        at.a().a(System.currentTimeMillis(), str);
        at.b();
    }

    public static void a(String str, String str2, Context context, String str3) {
        c a2 = net.one97.paytm.wallet.communicator.b.a();
        Boolean g2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().g();
        k.a((Object) g2, "DirectPaymentBl.getInstance().getisScanOnly()");
        a2.sendCustomGTMEvents(context, str, str2, g2.booleanValue() ? "flow_through_scan_icon" : "flow_through_pay_icon", (String) null, str3, "offline_payments");
    }

    private static void a(String str, String str2, String str3, String str4, Context context, String str5) {
        net.one97.paytm.wallet.communicator.b.a().sendNewCustomGTMEvents(context, str, str2, str3, str4, (String) null, str5, "offline_payments");
    }

    public static void a(Context context, String str) {
        if (context != null) {
            CharSequence charSequence = str;
            if (charSequence == null || charSequence.length() == 0) {
                return;
            }
            if (k.a((Object) net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().g(), (Object) Boolean.TRUE)) {
                a("offline_payments", "post_payment_failure_shown", "flow_through_scan_icon", str, context, "home/pay-send/payment-failed");
            } else {
                a("offline_payments", "post_payment_failure_shown", "flow_through_pay_icon", str, context, "home/pay-send/payment-failed");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004c A[Catch:{ Exception -> 0x00d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0080 A[Catch:{ Exception -> 0x00d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ac A[Catch:{ Exception -> 0x00d0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r10, android.widget.TextView r11) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "amount"
            kotlin.g.b.k.c(r10, r1)
            java.lang.String r1 = "textView"
            kotlin.g.b.k.c(r11, r1)
            r1 = 0
            r2 = 1
            r11.setTypeface(r1, r2)
            android.graphics.Typeface r3 = r11.getTypeface()     // Catch:{ Exception -> 0x00d0 }
            if (r3 == 0) goto L_0x0021
            android.graphics.Typeface r3 = r11.getTypeface()     // Catch:{ Exception -> 0x00d0 }
            if (r3 == 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r3 = r1
            goto L_0x0027
        L_0x0021:
            java.lang.String r3 = "sans-serif-medium"
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r3, r2)     // Catch:{ Exception -> 0x00d0 }
        L_0x0027:
            android.graphics.Typeface r4 = r11.getTypeface()     // Catch:{ Exception -> 0x00d0 }
            r5 = 0
            if (r4 == 0) goto L_0x0034
            android.graphics.Typeface r4 = r11.getTypeface()     // Catch:{ Exception -> 0x00d0 }
            if (r4 == 0) goto L_0x003a
        L_0x0034:
            java.lang.String r1 = "sans-serif-light"
            android.graphics.Typeface r1 = android.graphics.Typeface.create(r1, r5)     // Catch:{ Exception -> 0x00d0 }
        L_0x003a:
            r4 = r10
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r6 = ": "
            r7 = 6
            int r4 = kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.String) r6, (int) r5, (boolean) r5, (int) r7)     // Catch:{ Exception -> 0x00d0 }
            int r4 = r4 + 10
            int r6 = r10.length()     // Catch:{ Exception -> 0x00d0 }
            if (r4 < r6) goto L_0x0052
            r6 = r10
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x00d0 }
            r11.setText(r6)     // Catch:{ Exception -> 0x00d0 }
        L_0x0052:
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ Exception -> 0x00d0 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d0 }
            r7.<init>()     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r8 = r10.substring(r5, r4)     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r9 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)     // Catch:{ Exception -> 0x00d0 }
            r7.append(r8)     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r8 = "  "
            r7.append(r8)     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00d0 }
            r6[r5] = r7     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r4 = r10.substring(r4)     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r7 = "(this as java.lang.String).substring(startIndex)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)     // Catch:{ Exception -> 0x00d0 }
            r6[r2] = r4     // Catch:{ Exception -> 0x00d0 }
            r4 = r6[r5]     // Catch:{ Exception -> 0x00d0 }
            if (r4 != 0) goto L_0x0083
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00d0 }
        L_0x0083:
            int r4 = r4.length()     // Catch:{ Exception -> 0x00d0 }
            android.text.SpannableStringBuilder r7 = new android.text.SpannableStringBuilder     // Catch:{ Exception -> 0x00d0 }
            r8 = r6[r5]     // Catch:{ Exception -> 0x00d0 }
            r9 = r6[r2]     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r8 = kotlin.g.b.k.a((java.lang.String) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x00d0 }
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x00d0 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x00d0 }
            com.paytm.utility.CustomTypefaceSpan r8 = new com.paytm.utility.CustomTypefaceSpan     // Catch:{ Exception -> 0x00d0 }
            r8.<init>(r0, r1)     // Catch:{ Exception -> 0x00d0 }
            r1 = 34
            r7.setSpan(r8, r5, r4, r1)     // Catch:{ Exception -> 0x00d0 }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r8 = "."
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x00d0 }
            boolean r10 = kotlin.m.p.a((java.lang.CharSequence) r10, (java.lang.CharSequence) r8, false)     // Catch:{ Exception -> 0x00d0 }
            if (r10 == 0) goto L_0x00cb
            com.paytm.utility.CustomTypefaceSpan r10 = new com.paytm.utility.CustomTypefaceSpan     // Catch:{ Exception -> 0x00d0 }
            r10.<init>(r0, r3)     // Catch:{ Exception -> 0x00d0 }
            r0 = r6[r5]     // Catch:{ Exception -> 0x00d0 }
            if (r0 != 0) goto L_0x00b8
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00d0 }
        L_0x00b8:
            int r0 = r0.length()     // Catch:{ Exception -> 0x00d0 }
            r2 = r6[r2]     // Catch:{ Exception -> 0x00d0 }
            if (r2 != 0) goto L_0x00c3
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00d0 }
        L_0x00c3:
            int r2 = r2.length()     // Catch:{ Exception -> 0x00d0 }
            int r0 = r0 + r2
            r7.setSpan(r10, r4, r0, r1)     // Catch:{ Exception -> 0x00d0 }
        L_0x00cb:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ Exception -> 0x00d0 }
            r11.setText(r7)     // Catch:{ Exception -> 0x00d0 }
        L_0x00d0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.h.a.a(java.lang.String, android.widget.TextView):void");
    }

    public static void a(Activity activity, View view) {
        k.c(view, "view");
        if (activity != null && !activity.isFinishing()) {
            try {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("image/png");
                intent.putExtra("android.intent.extra.SUBJECT", activity.getResources().getString(R.string.post_payment_share_subject));
                intent.putExtra("android.intent.extra.TEXT", net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(activity, "GTM_SHARE_BUTTON_TEXT_MESSAGE_P2M"));
                k.c(view, "view");
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
                view.draw(new Canvas(createBitmap));
                ContentResolver contentResolver = activity.getContentResolver();
                String insertImage = MediaStore.Images.Media.insertImage(contentResolver, createBitmap, activity.getString(R.string.title).toString() + "-" + System.currentTimeMillis(), (String) null);
                if (insertImage != null) {
                    Uri parse = Uri.parse(insertImage);
                    k.a((Object) parse, "Uri.parse(pathofBmp)");
                    intent.putExtra("android.intent.extra.STREAM", parse);
                    Intent createChooser = Intent.createChooser(intent, activity.getResources().getString(R.string.post_payment_share_title));
                    if (createChooser.resolveActivity(activity.getPackageManager()) != null) {
                        activity.startActivity(createChooser);
                    } else {
                        Toast.makeText(activity, activity.getResources().getString(R.string.no_app_found), 1).show();
                    }
                } else {
                    return;
                }
            } catch (Exception unused) {
            }
        }
        a("offline_payments", "post_payment_share_clicked", (Context) activity, "home/pay-send/payment-share");
    }

    public static void a(Context context, String str, String str2) {
        k.c(str, "source");
        if (context != null) {
            Map hashMap = new HashMap();
            hashMap.put("new_wallet_screen_type", "send_money");
            hashMap.put("new_wallet_successfully_sent_money_amount", str2);
            hashMap.put("wallet_send_money_method_name", str);
            net.one97.paytm.wallet.communicator.b.a().sendCustomEventWithMap("wallet_success_screen_loaded", hashMap, context.getApplicationContext());
        }
    }

    public static void a(Context context, boolean z, String str) {
        k.c(context, "context");
        try {
            Map hashMap = new HashMap();
            hashMap.put("event_category", d.cr);
            hashMap.put("event_action", d.cq);
            String str2 = d.ct;
            k.a((Object) str2, "CJRGTMConstants.GTM_EVENT_LABEL2_KEY_ORDER_SUMMERY");
            hashMap.put(str2, z ? d.cj : d.ck);
            hashMap.put("user_id", b.n(context));
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, d.cp);
            String str3 = d.cv;
            k.a((Object) str3, "CJRGTMConstants.GTM_KEY_VERTICAL_NAME_NEW");
            hashMap.put(str3, d.cy);
            String str4 = d.cw;
            k.a((Object) str4, "CJRGTMConstants.GTM_KEY_USER_ACTION");
            hashMap.put(str4, d.cl);
            String str5 = d.cm;
            k.a((Object) str5, "CJRGTMConstants.GTM_EVENT_KEY_WALLET_SCREEN_TYPE");
            hashMap.put(str5, d.cp);
            String str6 = d.cn;
            k.a((Object) str6, "CJRGTMConstants.GTM_EVEN…_SUCCESSFULLY_SENT_AMOUNT");
            hashMap.put(str6, str);
            String str7 = d.co;
            k.a((Object) str7, "CJRGTMConstants.GTM_EVEN…EY_SEND_MONEY_METHOD_NAME");
            hashMap.put(str7, z ? d.cj : d.ck);
            hashMap.put("event_label", str);
            hashMap.put("event_value", str);
            net.one97.paytm.wallet.communicator.b.a().sendCustomEventWithMap(d.cu, hashMap, context);
        } catch (Exception unused) {
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        k.c(str, "gtmEventActionValue");
        k.c(str2, "gtmUserActionValue");
        if (context != null) {
            Map hashMap = new HashMap();
            hashMap.put("event_category", d.bF + d.cx);
            hashMap.put("event_action", str);
            String str4 = d.cw;
            k.a((Object) str4, "CJRGTMConstants.GTM_KEY_USER_ACTION");
            hashMap.put(str4, str2);
            String n = b.n(context);
            k.a((Object) n, "CJRAppCommonUtility.getUserId(it)");
            hashMap.put("user_id", n);
            String str5 = d.cx;
            k.a((Object) str5, "CJRGTMConstants.GTM_SEND_MONEY_VALUE");
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str5);
            String str6 = d.cv;
            k.a((Object) str6, "CJRGTMConstants.GTM_KEY_VERTICAL_NAME_NEW");
            String str7 = d.ch;
            k.a((Object) str7, "CJRGTMConstants.GTM_EVENT_VERTICAL_NAME_VALUE");
            hashMap.put(str6, str7);
            if (str3 != null) {
                hashMap.put("event_label", str3);
            }
            net.one97.paytm.wallet.communicator.b.a().sendCustomEventWithMap(GAUtil.CUSTOM_EVENT, hashMap, context);
        }
    }

    public static long a(String str, String str2) {
        k.c(str2, "format");
        try {
            Date parse = new SimpleDateFormat(str2, Locale.ENGLISH).parse(str);
            k.a((Object) parse, "parsedDate");
            return parse.getTime();
        } catch (Exception unused) {
            return System.currentTimeMillis();
        }
    }

    public static String a(long j, String str) {
        k.c(str, "format");
        String format = new SimpleDateFormat(str, Locale.ENGLISH).format(Long.valueOf(j));
        k.a((Object) format, "sdf.format(time)");
        return format;
    }
}
