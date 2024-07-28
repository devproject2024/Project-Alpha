package net.one97.paytm.recharge.common.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.g.d;
import com.airbnb.lottie.LottieAnimationView;
import com.business.merchant_payments.common.utility.AppUtility;
import com.google.gsonhtcfix.f;
import com.paytm.utility.n;
import com.paytm.utility.q;
import com.paytm.utility.v;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.x;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRBillDetails;
import net.one97.paytm.common.entity.recharge.CJRDisplayValues;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRRelatedCategory;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.FetchOptionsRequest;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.nativesdk.Utils.Server;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.j;
import net.one97.paytm.recharge.common.activity.AJRRechargeOperatorGridV4;
import net.one97.paytm.recharge.common.activity.AJRRechargeOperatorListV4;
import net.one97.paytm.recharge.common.e.aa;
import net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.legacy.catalog.a.a;
import net.one97.paytm.recharge.metro.activity.AJRMetroRechargeOperatorListV4;
import net.one97.paytm.recharge.model.CJRMerchantLoanAccountItem;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.ErrorAction;
import net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.upi.common.upi.CommonPayParams;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONObject;

public class ba {

    /* renamed from: a  reason: collision with root package name */
    public static String f61539a = ba.class.getName();

    /* renamed from: b  reason: collision with root package name */
    public static long f61540b = 4;

    /* renamed from: c  reason: collision with root package name */
    public static long f61541c = 56;

    /* renamed from: d  reason: collision with root package name */
    public static long f61542d = 71;

    /* renamed from: e  reason: collision with root package name */
    public static long f61543e = 76;

    /* renamed from: f  reason: collision with root package name */
    public static long f61544f = 156705;

    /* renamed from: g  reason: collision with root package name */
    public static long f61545g = 101975;

    /* renamed from: h  reason: collision with root package name */
    public static long f61546h = 26;

    /* renamed from: i  reason: collision with root package name */
    public static long f61547i = 78640;
    public static long j = 68869;
    public static long k = 64739;
    public static long l = 37217;
    public static String m = "  ";
    public static int n = 4;
    private static HashMap<String, d<String, String>> o;
    private static String p = "+91";
    private static String q;
    /* access modifiers changed from: private */
    public a r;

    public interface a {
        void as_();

        void b_(String str);
    }

    public enum b {
        ORDER_SUMMARY,
        COUPONS,
        RECHARGE_PAYMENT
    }

    public static int a(int i2) {
        if (i2 == 21 || i2 == 5 || i2 == 9) {
            return 17;
        }
        if (i2 == 23 || i2 == 7 || i2 == 11) {
            return 19;
        }
        if (i2 == 6) {
            return 18;
        }
        if (i2 == 13) {
            return 78640;
        }
        return i2;
    }

    public static long a(long j2) {
        if (j2 == 5) {
            return 17;
        }
        if (j2 == 9) {
            return 21;
        }
        if (j2 == 6) {
            return 18;
        }
        if (j2 == 7) {
            return 19;
        }
        if (j2 == 11) {
            return 23;
        }
        return j2;
    }

    public static boolean a() {
        return true;
    }

    public ba(a aVar) {
        this.r = aVar;
    }

    public final void a(a aVar) {
        this.r = aVar;
    }

    public static d<String, String> a(String str, Context context) {
        HashMap<String, d<String, String>> a2 = a(context);
        if (str == null || a2 == null || !a2.containsKey(str)) {
            return null;
        }
        return a2.get(str);
    }

    public static boolean b(String str, Context context) {
        String[] split = com.paytm.utility.b.Q(context).split("\\.");
        String[] split2 = str.split("\\.");
        int length = split.length > split2.length ? split.length : split2.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 == split2.length && Integer.valueOf(split[i2]).intValue() > 0) {
                return false;
            }
            if (i2 == split.length && Integer.valueOf(split2[i2]).intValue() > 0) {
                return true;
            }
            if (Integer.valueOf(split[i2]).intValue() > Integer.valueOf(split2[i2]).intValue()) {
                return false;
            }
            if (Integer.valueOf(split[i2]).intValue() < Integer.valueOf(split2[i2]).intValue()) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(String str, Context context) {
        String[] split = com.paytm.utility.b.Q(context).split("\\.");
        String[] split2 = str.split("\\.");
        int length = split.length > split2.length ? split.length : split2.length;
        int i2 = 0;
        while (i2 < length && i2 != split2.length) {
            if (i2 == split.length) {
                return Integer.valueOf(split2[i2]).intValue() <= 0;
            }
            if (i2 < 2) {
                if (Integer.valueOf(split[i2]).intValue() >= Integer.valueOf(split2[i2]).intValue()) {
                    if (Integer.valueOf(split[i2]).intValue() > Integer.valueOf(split2[i2]).intValue()) {
                        break;
                    }
                } else {
                    return false;
                }
            } else {
                int intValue = Integer.valueOf(split2[i2]).intValue();
                int intValue2 = Integer.valueOf(split[i2]).intValue();
                int i3 = 0;
                for (int i4 = intValue; i4 > 0; i4 /= 10) {
                    i3++;
                }
                int i5 = 0;
                for (int i6 = intValue2; i6 > 0; i6 /= 10) {
                    i5++;
                }
                if (i3 > i5) {
                    intValue2 = (int) (((double) intValue2) * Math.pow(10.0d, (double) (i3 - i5)));
                } else if (i5 > i3) {
                    intValue = (int) (((double) intValue) * Math.pow(10.0d, (double) (i5 - i3)));
                }
                if (intValue2 < intValue) {
                    return false;
                }
            }
            i2++;
        }
        return true;
    }

    public static String a(String str, String str2) {
        boolean a2 = az.a(CJRRechargeUtilities.INSTANCE.getApplicationContext(), str);
        StringBuilder sb = new StringBuilder();
        Uri parse = Uri.parse(str2);
        sb.append(str2);
        if (a2 && parse != null) {
            if (parse.getQuery() != null) {
                sb.append(AppConstants.AND_SIGN);
            } else {
                sb.append("?");
            }
            sb.append("payment_info=1");
            sb.append("&native_withdraw=1");
        }
        return sb.toString();
    }

    private static boolean a(Context context, String str) {
        if (context == null) {
            return false;
        }
        String[] split = str.split("/");
        for (String a2 : split) {
            if (g.a(context, a2)) {
                return true;
            }
        }
        return false;
    }

    public static Class<? extends Activity> a(Context context, b bVar, CJRRechargeCart cJRRechargeCart) {
        long j2;
        String str = "";
        try {
            CJRCartProduct cJRCartProduct = cJRRechargeCart.getCart().getCartItems().get(0);
            j2 = Long.valueOf(cJRCartProduct.getProductId()).longValue();
            try {
                Map<String, String> configurationList = cJRCartProduct.getConfigurationList();
                str = (configurationList == null || !configurationList.containsKey(ab.f61497b)) ? cJRCartProduct.getCategoryIdForGTM() : configurationList.get(ab.f61497b);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            j2 = 0;
        }
        if (!a(context, str)) {
            c cVar = c.f62654a;
            if (!c.n().contains(Long.valueOf(j2))) {
                return null;
            }
        }
        int i2 = AnonymousClass2.f61557a[bVar.ordinal()];
        if (i2 == 1) {
            return AJRechargeOrderSummaryActivity.class;
        }
        if (i2 == 2) {
            return AJRCouponsActivityV8.class;
        }
        if (i2 != 3) {
            return null;
        }
        net.one97.paytm.recharge.di.helper.a aVar = net.one97.paytm.recharge.di.helper.a.f62650a;
        return net.one97.paytm.recharge.di.helper.a.e();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0052, code lost:
        if (net.one97.paytm.recharge.di.helper.c.n().contains(java.lang.Long.valueOf(r1)) != false) goto L_0x0054;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.Intent a(android.content.Intent r5, net.one97.paytm.recharge.common.utils.ba.b r6, net.one97.paytm.common.entity.CJRRechargeCart r7, android.content.Context r8) {
        /*
            java.lang.String r0 = ""
            net.one97.paytm.common.entity.shopping.CJRCart r7 = r7.getCart()     // Catch:{ Exception -> 0x003c }
            java.util.ArrayList r7 = r7.getCartItems()     // Catch:{ Exception -> 0x003c }
            r1 = 0
            java.lang.Object r7 = r7.get(r1)     // Catch:{ Exception -> 0x003c }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r7 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r7     // Catch:{ Exception -> 0x003c }
            java.lang.String r1 = r7.getProductId()     // Catch:{ Exception -> 0x003c }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ Exception -> 0x003c }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x003c }
            java.util.Map r3 = r7.getConfigurationList()     // Catch:{ Exception -> 0x003a }
            if (r3 == 0) goto L_0x0035
            java.lang.String r4 = net.one97.paytm.recharge.common.utils.ab.f61497b     // Catch:{ Exception -> 0x003a }
            boolean r4 = r3.containsKey(r4)     // Catch:{ Exception -> 0x003a }
            if (r4 == 0) goto L_0x0035
            java.lang.String r7 = net.one97.paytm.recharge.common.utils.ab.f61497b     // Catch:{ Exception -> 0x003a }
            java.lang.Object r7 = r3.get(r7)     // Catch:{ Exception -> 0x003a }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x003a }
            r0 = r7
            goto L_0x003e
        L_0x0035:
            java.lang.String r0 = r7.getCategoryIdForGTM()     // Catch:{ Exception -> 0x003a }
            goto L_0x003e
        L_0x003a:
            goto L_0x003e
        L_0x003c:
            r1 = 0
        L_0x003e:
            boolean r7 = a((android.content.Context) r8, (java.lang.String) r0)
            if (r7 != 0) goto L_0x0054
            net.one97.paytm.recharge.di.helper.c r7 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.HashSet r7 = net.one97.paytm.recharge.di.helper.c.n()
            java.lang.Long r8 = java.lang.Long.valueOf(r1)
            boolean r7 = r7.contains(r8)
            if (r7 == 0) goto L_0x005f
        L_0x0054:
            int[] r7 = net.one97.paytm.recharge.common.utils.ba.AnonymousClass2.f61557a
            int r6 = r6.ordinal()
            r6 = r7[r6]
            r7 = 1
            if (r6 == r7) goto L_0x0060
        L_0x005f:
            return r5
        L_0x0060:
            java.lang.Class<net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity> r6 = net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity.class
            java.lang.String r6 = r6.getName()
            java.lang.String r8 = "screen_name_to_redirect"
            r5.putExtra(r8, r6)
            java.lang.String r6 = "intent_extra_is_recharge"
            r5.putExtra(r6, r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.ba.a(android.content.Intent, net.one97.paytm.recharge.common.utils.ba$b, net.one97.paytm.common.entity.CJRRechargeCart, android.content.Context):android.content.Intent");
    }

    public static int a(String str) {
        if (str.length() > 1) {
            if (str.substring(0, 1).equalsIgnoreCase("4")) {
                return 1;
            }
            if ("51,52,53,54,55,".contains(str.substring(0, 2) + AppConstants.COMMA)) {
                return 2;
            }
            if ("34,37,".contains(str.substring(0, 2) + AppConstants.COMMA)) {
                return 4;
            }
            if (str.substring(0, 1).equalsIgnoreCase("6")) {
                return 3;
            }
            if ("30,36,38,39".contains(str.substring(0, 2) + AppConstants.COMMA)) {
                return 5;
            }
        }
        return 0;
    }

    public static String a(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            if (Character.isDigit(charSequence.charAt(i3))) {
                if (i2 % 4 == 0 && i2 > 0) {
                    sb.append(" ");
                }
                sb.append(charSequence.charAt(i3));
                i2++;
            }
        }
        return sb.toString();
    }

    public static String b(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            if (Character.isDigit(charSequence.charAt(i3))) {
                if (i2 > 0 && (i2 == 4 || i2 == 10)) {
                    sb.append(" ");
                }
                sb.append(charSequence.charAt(i3));
                i2++;
            }
        }
        return sb.toString();
    }

    public static String c(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            if (Character.isDigit(charSequence.charAt(i3)) || charSequence.charAt(i3) == 'X') {
                if (i2 % 4 == 0 && i2 > 0) {
                    sb.append("  ");
                }
                sb.append(charSequence.charAt(i3));
                i2++;
            }
        }
        return sb.toString();
    }

    public static String d(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            if (Character.isDigit(charSequence.charAt(i3)) || charSequence.charAt(i3) == 'X') {
                if (i2 % 4 == 0 && i2 > 0) {
                    sb.append(" ");
                }
                sb.append(charSequence.charAt(i3));
                i2++;
            }
        }
        return sb.toString();
    }

    public static String e(CharSequence charSequence) {
        String charSequence2 = charSequence.toString();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence2.length(); i3++) {
            if (Character.isDigit(charSequence2.charAt(i3)) || charSequence2.charAt(i3) == 'X') {
                if (i2 > 0 && (i2 == 4 || i2 == 10)) {
                    sb.append("  ");
                }
                sb.append(charSequence2.charAt(i3));
                i2++;
            }
        }
        return sb.toString();
    }

    public static String a(List<CJRFrequentOrder> list, String str, int i2) {
        try {
            q = str;
            if (str.length() >= p.length() && q.substring(0, p.length()).equals(p)) {
                q = q.substring(p.length(), q.length());
                q = q.replace("\\b+91\\b", "").trim();
            }
            if (list != null) {
                if (list.size() != 0) {
                    int i3 = 0;
                    while (i3 < list.size()) {
                        if (q.equalsIgnoreCase(list.get(i3).getRechargeNumber())) {
                            return null;
                        }
                        int i4 = 0;
                        int i5 = 0;
                        while (i4 < q.length() && i4 != i2 && (list.get(i3).getRechargeNumber().charAt(i4) == q.charAt(i4) || (i5 = i5 + 1) < 3)) {
                            i4++;
                        }
                        if (i5 != 1) {
                            if (i5 != 2) {
                                i3++;
                            }
                        }
                        return list.get(i3).getRechargeNumber();
                    }
                    int[] iArr = new int[i2];
                    for (int i6 = 0; i6 < q.length(); i6++) {
                        int numericValue = Character.getNumericValue(q.charAt(i6));
                        iArr[numericValue] = iArr[numericValue] + 1;
                    }
                    for (int i7 = 0; i7 < list.size(); i7++) {
                        int[] iArr2 = new int[i2];
                        for (int i8 = 0; i8 < i2; i8++) {
                            int numericValue2 = Character.getNumericValue(list.get(i7).getRechargeNumber().charAt(i8));
                            iArr2[numericValue2] = iArr2[numericValue2] + 1;
                        }
                        int i9 = 0;
                        while (i9 < i2 && iArr2[i9] == iArr[i9]) {
                            i9++;
                        }
                        if (i9 == i2) {
                            return list.get(i7).getRechargeNumber();
                        }
                    }
                    return null;
                }
            }
            return null;
        } catch (Exception e2) {
            q.d(e2.getMessage());
        }
    }

    public final AlertDialog a(String str, Context context, String str2, String str3) {
        final String str4 = str;
        final Context context2 = context;
        final String str5 = str3;
        AlertDialog create = new AlertDialog.Builder(context2).create();
        View inflate = LayoutInflater.from(context).inflate(R.layout.incorrect_number_dialog, (ViewGroup) null);
        create.setView(inflate);
        final boolean[] zArr = {false};
        String str6 = "Did you mean " + str4 + " instead of " + q + " ? ";
        ((TextView) inflate.findViewById(R.id.title1)).setText(Html.fromHtml("Did you mean <b>" + str4 + "</b> "));
        ((TextView) inflate.findViewById(R.id.title2)).setText(Html.fromHtml("instead of <b>" + q + "</b>  ? "));
        final boolean[] zArr2 = zArr;
        final Context context3 = context;
        final String str7 = str3;
        final AlertDialog alertDialog = create;
        ((Button) inflate.findViewById(R.id.yes)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                zArr2[0] = true;
                ba.c(CommonPayParams.Builder.YES, context3, str7);
                ba.this.r.b_(str4);
                alertDialog.dismiss();
            }
        });
        final AlertDialog alertDialog2 = create;
        ((TextView) inflate.findViewById(R.id.no)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                zArr2[0] = true;
                ba.c(CommonPayParams.Builder.NO, context3, str7);
                ba.this.r.as_();
                alertDialog2.dismiss();
            }
        });
        create.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                boolean[] zArr = zArr;
                if (!zArr[0]) {
                    zArr[0] = false;
                    ba.c(CommonPayParams.Builder.NO, context2, str5);
                    ba.this.r.as_();
                }
            }
        });
        c("Loaded", context2, str5);
        create.show();
        net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a(str5, context2, str2, str6) {
            private final /* synthetic */ String f$0;
            private final /* synthetic */ Context f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ String f$3;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final Object invoke() {
                return ba.d(this.f$0, this.f$1, this.f$2, this.f$3);
            }
        });
        return create;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ x d(String str, Context context, String str2, String str3) {
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a(str, context, str2, str3);
        return null;
    }

    public final AlertDialog a(String str, final Context context, final String str2) {
        AlertDialog create = new AlertDialog.Builder(context).create();
        View inflate = LayoutInflater.from(context).inflate(R.layout.v3_incorrect_number_dialog, (ViewGroup) null);
        create.setView(inflate);
        final boolean[] zArr = {false};
        create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        TextView textView = (TextView) inflate.findViewById(R.id.firstNumber);
        TextView textView2 = (TextView) inflate.findViewById(R.id.secondNumber);
        textView.setText(str);
        textView2.setText(q);
        final boolean[] zArr2 = zArr;
        final Context context2 = context;
        final String str3 = str2;
        final AlertDialog alertDialog = create;
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                zArr2[0] = true;
                String charSequence = ((TextView) view).getText().toString();
                ba.c("", context2, str3, "mobile_number_corrected");
                ba.this.r.b_(charSequence);
                alertDialog.dismiss();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                zArr2[0] = true;
                String charSequence = ((TextView) view).getText().toString();
                ba.c(CommonPayParams.Builder.YES, context2, str3);
                ba.this.r.b_(charSequence);
                alertDialog.dismiss();
            }
        });
        create.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                boolean[] zArr = zArr;
                if (!zArr[0]) {
                    zArr[0] = false;
                    ba.c(CommonPayParams.Builder.NO, context, str2);
                    ba.this.r.as_();
                }
            }
        });
        c("", context, str2, "wrong_number_popup_displayed");
        create.show();
        return create;
    }

    /* access modifiers changed from: private */
    public static void c(String str, Context context, String str2) {
        net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a(str2, str, context) {
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;
            private final /* synthetic */ Context f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Object invoke() {
                return ba.a(this.f$0, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ x a(String str, String str2, Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", str);
        hashMap.put("event_action", "number_correction_popup");
        hashMap.put("event_label", str2);
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "");
        if (com.paytm.utility.b.n(context) != null) {
            hashMap.put("user_id", com.paytm.utility.b.n(context));
        } else {
            hashMap.put("user_id", "");
        }
        hashMap.put("vertical_name", "recharges_utilities");
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a((HashMap<String, Object>) hashMap, context);
        return null;
    }

    /* access modifiers changed from: private */
    public static void c(String str, Context context, String str2, String str3) {
        net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a(str2, str3, str, context) {
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ Context f$3;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final Object invoke() {
                return ba.a(this.f$0, this.f$1, this.f$2, this.f$3);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ x a(String str, String str2, String str3, Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", str);
        hashMap.put("event_action", str2);
        hashMap.put("event_label", str3);
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "");
        if (com.paytm.utility.b.n(context) != null) {
            hashMap.put("user_id", com.paytm.utility.b.n(context));
        } else {
            hashMap.put("user_id", "");
        }
        hashMap.put("vertical_name", "recharges_utilities");
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a((HashMap<String, Object>) hashMap, context);
        return null;
    }

    public static void a(Context context, String str, String str2, String str3, net.one97.paytm.recharge.legacy.catalog.a.a aVar) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_custom_alert);
        ((TextView) dialog.findViewById(R.id.title_view)).setText(str);
        ((TextView) dialog.findViewById(R.id.message_view)).setText(str2);
        if (!TextUtils.isEmpty(str3)) {
            ((TextView) dialog.findViewById(R.id.custom_dialog_btn_positive)).setText(str3);
        }
        dialog.findViewById(R.id.custom_dialog_btn_positive).setOnClickListener(new View.OnClickListener(dialog, aVar) {
            private final /* synthetic */ Dialog f$0;
            private final /* synthetic */ a f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                ba.a(this.f$0, this.f$1, view);
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.show();
        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Dialog dialog, net.one97.paytm.recharge.legacy.catalog.a.a aVar, View view) {
        dialog.cancel();
        if (aVar != null) {
            aVar.a();
        }
    }

    public static ErrorAction b(String str) {
        if ("operator_list".equals(str)) {
            return ErrorAction.OPERATOR_LIST;
        }
        if ("browse_plan".equals(str)) {
            return ErrorAction.BROWSE_PLAN;
        }
        if ("Action_ProceedOnValidationBlock".equals(str)) {
            return ErrorAction.Action_ProceedOnValidationBlock;
        }
        if ("open_multi_product".equals(str)) {
            return ErrorAction.OPEN_MULTI_PRODUCT;
        }
        return ErrorAction.NO_ACTION;
    }

    public static float a(float f2) {
        return (float) Math.round(f2 * (((float) Resources.getSystem().getDisplayMetrics().densityDpi) / 160.0f));
    }

    public static void a(LottieAnimationView lottieAnimationView) {
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.playAnimation();
        }
    }

    public static void b(LottieAnimationView lottieAnimationView) {
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setVisibility(8);
        }
    }

    public static void a(int i2, View view) {
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    public static boolean a(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static void a(CJRFrequentOrder cJRFrequentOrder, Context context) {
        String str;
        int category_id = cJRFrequentOrder.getFrequentOrderProduct().getCategory_id();
        String productID = cJRFrequentOrder.getProductID();
        String rechargeNumber = cJRFrequentOrder.getRechargeNumber();
        String rechargeNumber2 = cJRFrequentOrder.getRechargeNumber2();
        switch (category_id) {
            case 5:
            case 17:
            case 95972:
                str = "paytmmp://mobile_prepaid?url=https://catalog.paytm.com/v2/mobile/getproductlist/17?product_id=" + productID + "&recharge_number=" + rechargeNumber;
                break;
            case 6:
            case 18:
                str = "paytmmp://dth?url=https://catalog.paytm.com/v2/mobile/getproductlist/18?product_id=" + productID + "&recharge_number=" + rechargeNumber;
                break;
            case 7:
            case 19:
                str = "paytmmp://datacard_prepaid?url=https://catalog.paytm.com/v2/mobile/getproductlist/19?product_id=" + productID + "&recharge_number=" + rechargeNumber;
                break;
            case 9:
            case 21:
            case 46758:
            case 92346:
                str = "paytmmp://mobile_postpaid?url=https://catalog.paytm.com/v2/mobile/getproductlist/21?product_id=" + productID + "&recharge_number=" + rechargeNumber;
                break;
            case 11:
            case 23:
            case 46818:
                str = "paytmmp://datacard_postpaid?url=https://catalog.paytm.com/v2/mobile/getproductlist/23?product_id=" + productID + "&recharge_number=" + rechargeNumber;
                break;
            case 12:
            case 26:
            case 106022:
            case 144863:
                str = "paytmmp://utility?url=https://catalog.paytm.com/v2/mobile/getproductlist/26?product_id=" + productID + "&recharge_number=" + rechargeNumber;
                break;
            case 13:
            case 25:
            case 78640:
                str = "paytmmp://utility?url=https://catalog.paytm.com/v2/mobile/getproductlist/78640?product_id=" + productID + "&recharge_number=" + rechargeNumber;
                break;
            case 22:
            case 47464:
            case 75505:
            case 92791:
                str = "paytmmp://utility?url=https://catalog.paytm.com/v2/mobile/getproductlist/75505?product_id=" + productID + "&recharge_number=" + rechargeNumber + "&recharge_number_2=" + rechargeNumber2;
                break;
            case 28:
            case 77409:
                str = "paytmmp://utility?url=https://catalog.paytm.com/v2/mobile/getproductlist/77409?product_id=" + productID + "&recharge_number=" + rechargeNumber;
                break;
            case 6238:
            case 6239:
            case 46006:
            case 46007:
                str = "paytmmp://utility?url=https://catalog.paytm.com/v2/mobile/getproductlist/46007?product_id=" + productID + "&recharge_number=" + rechargeNumber;
                break;
            case 37217:
                str = "paytmmp://utility?url=https://catalog.paytm.com/v2/mobile/getproductlist/37217?product_id=" + productID + "&recharge_number=" + rechargeNumber;
                break;
            case 64739:
                str = "paytmmp://utility?url=https://catalog.paytm.com/v2/mobile/getproductlist/64739?product_id=" + productID + "&recharge_number=" + rechargeNumber;
                break;
            case 68869:
            case 102399:
                str = "paytmmp://utility?url=https://catalog.paytm.com/v2/mobile/getproductlist/68869?product_id=" + productID + "&recharge_number=" + rechargeNumber;
                break;
            case 99932:
                str = "paytmmp://utility?url=https://catalog.paytm.com/v2/mobile/getproductlist/99932?product_id=" + productID + "&recharge_number=" + rechargeNumber;
                break;
            case 100253:
                str = "paytmmp://utility?url=https://catalog.paytm.com/v2/mobile/getproductlist/100253?product_id=" + productID + "&recharge_number=" + rechargeNumber;
                break;
            case 101950:
                str = "paytmmp://utility?url=https://catalog.paytm.com/v2/mobile/getproductlist/101950?product_id=" + productID + "&recharge_number=" + rechargeNumber;
                break;
            case 104154:
                str = "paytmmp://utility?url=https://catalog.paytm.com/v2/mobile/getproductlist/104154?product_id=" + productID + "&recharge_number=" + rechargeNumber;
                break;
            case 107730:
                str = "paytmmp://utility?url=https://catalog.paytm.com/v2/mobile/getproductlist/107730?product_id=" + productID + "&recharge_number=" + rechargeNumber;
                break;
            case 123988:
                str = "paytmmp://utility?url=https://catalog.paytm.com/v2/mobile/getproductlist/123988?product_id=" + productID + "&recharge_number=" + rechargeNumber;
                break;
            case 127781:
                str = "paytmmp://utility?url=https://catalog.paytm.com/v2/mobile/getproductlist/127781?product_id=" + productID + "&recharge_number=" + rechargeNumber + "&recharge_number_2=" + rechargeNumber2;
                break;
            default:
                str = "";
                break;
        }
        if (!TextUtils.isEmpty(str)) {
            CJRRechargeUtilities.INSTANCE.checkDeepLinking(context, str);
        }
    }

    public static int c(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        if (str != null) {
            try {
                simpleDateFormat.setLenient(false);
                date = simpleDateFormat.parse(str);
            } catch (ParseException e2) {
                q.d(e2.getMessage());
            }
        }
        if (date == null) {
            return -1000;
        }
        return a(new Date(System.currentTimeMillis()), date);
    }

    private static int a(Date date, Date date2) {
        try {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            Calendar instance2 = Calendar.getInstance();
            instance2.setTime(date2);
            instance2.set(11, 0);
            instance2.set(12, 0);
            instance2.set(13, 0);
            instance2.set(14, 0);
            return (int) TimeUnit.DAYS.convert(instance2.getTimeInMillis() - instance.getTimeInMillis(), TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            q.d(e2.getMessage());
            return -1000;
        }
    }

    public static CJRBillDetails a(CJRBillDetails cJRBillDetails, Context context) {
        c cVar = c.f62654a;
        if (!c.aZ().booleanValue()) {
            return null;
        }
        if (context != null) {
            c cVar2 = c.f62654a;
            if (cJRBillDetails.getAmount().doubleValue() <= ((double) Integer.valueOf(c.aY()).intValue())) {
                return null;
            }
        }
        if (!TextUtils.isEmpty(cJRBillDetails.getDueDate())) {
            int c2 = c(cJRBillDetails.getDueDate());
            if (c2 + 3 >= 0) {
                cJRBillDetails.setDaysDiff(c2);
                return cJRBillDetails;
            }
        }
        if (TextUtils.isEmpty(cJRBillDetails.getExpiry())) {
            return null;
        }
        cJRBillDetails.setDaysDiff(c(cJRBillDetails.getExpiry()));
        return cJRBillDetails;
    }

    public static CJRBillDetails b(CJRBillDetails cJRBillDetails, Context context) {
        c cVar = c.f62654a;
        if (!c.aZ().booleanValue()) {
            return null;
        }
        if (context != null) {
            c cVar2 = c.f62654a;
            if (cJRBillDetails.getAmount().doubleValue() <= ((double) Integer.valueOf(c.aY()).intValue())) {
                return null;
            }
        }
        if (!TextUtils.isEmpty(cJRBillDetails.getDueDate())) {
            int c2 = c(cJRBillDetails.getDueDate());
            if (c2 + 3 >= 0 || c2 == -1000) {
                cJRBillDetails.setDaysDiff(c2);
                return cJRBillDetails;
            }
        }
        if (TextUtils.isEmpty(cJRBillDetails.getExpiry()) || TextUtils.isEmpty(cJRBillDetails.getPlan())) {
            return null;
        }
        cJRBillDetails.setDaysDiff(c(cJRBillDetails.getExpiry()));
        return cJRBillDetails;
    }

    public static CJRBillDetails a(CJRBillDetails cJRBillDetails) {
        if (cJRBillDetails.getAmount().doubleValue() <= 0.0d || TextUtils.isEmpty(cJRBillDetails.getBillsLabelColor())) {
            return null;
        }
        return cJRBillDetails;
    }

    public static CJRBillDetails b(CJRBillDetails cJRBillDetails) {
        if (TextUtils.isEmpty(cJRBillDetails.getBillsLabelColor())) {
            return null;
        }
        return cJRBillDetails;
    }

    public static boolean c(CJRBillDetails cJRBillDetails) {
        return (a(cJRBillDetails) == null || a(cJRBillDetails, (Context) null) == null) ? false : true;
    }

    public static String a(Double d2) {
        if (d2.doubleValue() <= ((double) Math.round(d2.doubleValue()))) {
            return String.valueOf(Math.round(d2.doubleValue()));
        }
        return String.valueOf(Math.round(d2.doubleValue() + 1.0d));
    }

    public static String d(String str) {
        StringBuilder sb = new StringBuilder();
        Uri parse = Uri.parse(str);
        sb.append(str);
        if (parse != null) {
            if (parse.getQuery() != null) {
                sb.append(AppConstants.AND_SIGN);
            } else {
                sb.append("?");
            }
            sb.append("channel=android");
        }
        return sb.toString();
    }

    public static String a(Context context, String str, CJRBillDetails cJRBillDetails, j.a aVar) {
        int daysDiff = cJRBillDetails.getDaysDiff();
        if (TextUtils.isEmpty(str)) {
            str = context.getResources().getString(R.string.bill_payment);
        }
        if (daysDiff >= 0) {
            if (daysDiff == 0) {
                try {
                    int i2 = AnonymousClass2.f61558b[aVar.ordinal()];
                    if (i2 == 1) {
                        return context.getResources().getString(R.string.bill_reminder_text_2_, new Object[]{str, context.getString(R.string.today_re)});
                    } else if (i2 != 2) {
                        return "";
                    } else {
                        Resources resources = context.getResources();
                        int i3 = R.string.bill_remainder_text_prepaid_2_view_all;
                        StringBuilder sb = new StringBuilder();
                        sb.append(cJRBillDetails.getAmount());
                        return resources.getString(i3, new Object[]{sb.toString(), context.getString(R.string.today_re)});
                    }
                } catch (Exception e2) {
                    CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
                    return "";
                }
            } else if (daysDiff == 1) {
                int i4 = AnonymousClass2.f61558b[aVar.ordinal()];
                if (i4 == 1) {
                    return context.getResources().getString(R.string.bill_reminder_text_2_, new Object[]{str, context.getString(R.string.tomorrow)});
                } else if (i4 != 2) {
                    return "";
                } else {
                    Resources resources2 = context.getResources();
                    int i5 = R.string.bill_remainder_text_prepaid_2_view_all;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(cJRBillDetails.getAmount());
                    return resources2.getString(i5, new Object[]{sb2.toString(), context.getString(R.string.tomorrow)});
                }
            } else {
                int i6 = AnonymousClass2.f61558b[aVar.ordinal()];
                if (i6 == 1) {
                    String m2 = m(cJRBillDetails.getDueDate());
                    return context.getResources().getString(R.string.bill_reminder_text_1_, new Object[]{str, m2});
                } else if (i6 != 2) {
                    return "";
                } else {
                    String m3 = m(cJRBillDetails.getExpiry());
                    Resources resources3 = context.getResources();
                    int i7 = R.string.bill_remainder_text_prepaid_1_view_all;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(cJRBillDetails.getAmount());
                    return resources3.getString(i7, new Object[]{sb3.toString(), m3});
                }
            }
        } else if (daysDiff >= 0) {
            return "";
        } else {
            int i8 = AnonymousClass2.f61558b[aVar.ordinal()];
            if (i8 == 1) {
                return context.getResources().getString(R.string.bill_reminder_text_0_, new Object[]{str});
            } else if (i8 != 2) {
                return "";
            } else {
                Resources resources4 = context.getResources();
                int i9 = R.string.bill_remainder_text_prepaid_0_view_all;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(cJRBillDetails.getAmount());
                return resources4.getString(i9, new Object[]{sb4.toString()});
            }
        }
    }

    /* renamed from: net.one97.paytm.recharge.common.utils.ba$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f61557a = new int[b.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f61558b = new int[j.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|5|6|7|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003c */
        static {
            /*
                net.one97.paytm.recharge.common.a.j$a[] r0 = net.one97.paytm.recharge.common.a.j.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f61558b = r0
                r0 = 1
                int[] r1 = f61558b     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.recharge.common.a.j$a r2 = net.one97.paytm.recharge.common.a.j.a.POSTPAID     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f61558b     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.recharge.common.a.j$a r3 = net.one97.paytm.recharge.common.a.j.a.PREPAID     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                net.one97.paytm.recharge.common.utils.ba$b[] r2 = net.one97.paytm.recharge.common.utils.ba.b.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f61557a = r2
                int[] r2 = f61557a     // Catch:{ NoSuchFieldError -> 0x0032 }
                net.one97.paytm.recharge.common.utils.ba$b r3 = net.one97.paytm.recharge.common.utils.ba.b.ORDER_SUMMARY     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                int[] r0 = f61557a     // Catch:{ NoSuchFieldError -> 0x003c }
                net.one97.paytm.recharge.common.utils.ba$b r2 = net.one97.paytm.recharge.common.utils.ba.b.COUPONS     // Catch:{ NoSuchFieldError -> 0x003c }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                int[] r0 = f61557a     // Catch:{ NoSuchFieldError -> 0x0047 }
                net.one97.paytm.recharge.common.utils.ba$b r1 = net.one97.paytm.recharge.common.utils.ba.b.RECHARGE_PAYMENT     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.ba.AnonymousClass2.<clinit>():void");
        }
    }

    private static String m(String str) {
        Date i2 = com.paytm.utility.b.i(str, "yyyy-MM-dd", (String) null);
        int a2 = com.paytm.utility.b.a(i2);
        return v.a(String.valueOf(a2), com.paytm.utility.b.b(a2), " ", com.paytm.utility.b.a(i2, 2));
    }

    public static String a(CJRCategoryData cJRCategoryData) {
        if (cJRCategoryData == null || cJRCategoryData.getRelatedCategories() == null) {
            return "";
        }
        for (int i2 = 0; i2 < cJRCategoryData.getRelatedCategories().size(); i2++) {
            if (cJRCategoryData.getRelatedCategories().get(i2) != null && !cJRCategoryData.getRelatedCategories().get(i2).isSelected() && !TextUtils.isEmpty(cJRCategoryData.getRelatedCategories().get(i2).getValue())) {
                return cJRCategoryData.getRelatedCategories().get(i2).getValue();
            }
        }
        return "";
    }

    public static int a(List<CJRAggsItem> list, String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        String a2 = z.a(str);
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (a2.contains(z.a(list.get(i2).getValue()))) {
                return i2;
            }
        }
        return -1;
    }

    public static Class a(String str, boolean z, String str2) {
        if (z.b(str2)) {
            return AJRMetroRechargeOperatorListV4.class;
        }
        if ("dropdown".equalsIgnoreCase(str) || "inputGrouping".equalsIgnoreCase(str) || z) {
            return AJRRechargeOperatorListV4.class;
        }
        return AJRRechargeOperatorGridV4.class;
    }

    public static String e(String str) {
        try {
            return str.replaceAll("[,]", "").trim();
        } catch (Exception unused) {
            return str;
        }
    }

    public static void a(View view, String str) {
        if (view != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    view.setBackgroundResource(0);
                } else if (str.equalsIgnoreCase("master")) {
                    view.setBackgroundResource(R.drawable.card_mastercard);
                } else if (str.equalsIgnoreCase(SDKConstants.RUPAY)) {
                    view.setBackgroundResource(R.drawable.card_rupay);
                } else if (str.equalsIgnoreCase("Visa")) {
                    view.setBackgroundResource(R.drawable.card_visa);
                } else if (str.equalsIgnoreCase("amex")) {
                    view.setBackgroundResource(R.drawable.card_amex);
                } else if (str.equalsIgnoreCase(SDKConstants.DINERS)) {
                    view.setBackgroundResource(R.drawable.card_dinerclub);
                }
            } catch (Exception e2) {
                view.setBackgroundResource(0);
                CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
            }
        }
    }

    public static String a(String str, String str2, int i2) {
        StringBuilder sb = new StringBuilder(str.length() + (str2.length() * (str.length() / i2)) + 1);
        int i3 = 0;
        String str3 = "";
        while (i3 < str.length()) {
            sb.append(str3);
            int i4 = i3 + i2;
            sb.append(str.substring(i3, Math.min(i4, str.length())));
            i3 = i4;
            str3 = str2;
        }
        return sb.toString();
    }

    public static void a(final Context context, String str, final ImageView imageView, final boolean z) {
        if (imageView != null && !TextUtils.isEmpty(str) && context != null) {
            w.a().a(str).a(imageView, (e) new e() {
                public final void onSuccess() {
                    imageView.setVisibility(0);
                    if (z) {
                        imageView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.recharge_visa_scale));
                    }
                }

                public final void onError(Exception exc) {
                    imageView.setVisibility(4);
                }
            });
        }
    }

    public static SpannableStringBuilder a(Context context, CJRBrowsePlanProductList cJRBrowsePlanProductList) {
        if (context == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        if (!TextUtils.isEmpty(cJRBrowsePlanProductList.getParsedDataValue())) {
            spannableStringBuilder.append(context.getString(R.string.v8_os_selected_plan_data)).append(": ").append(cJRBrowsePlanProductList.getData()).append("   •   ");
        }
        if (!TextUtils.isEmpty(cJRBrowsePlanProductList.getParsedTalktime())) {
            spannableStringBuilder.append(context.getString(R.string.v8_os_selected_plan_talktime)).append(": ").append(cJRBrowsePlanProductList.getTalktime()).append("   •   ");
        }
        if (!TextUtils.isEmpty(cJRBrowsePlanProductList.getParsedSms())) {
            spannableStringBuilder.append(context.getString(R.string.sms)).append(": ").append(cJRBrowsePlanProductList.getSms()).append("   •   ");
        }
        if (!TextUtils.isEmpty(cJRBrowsePlanProductList.getParsedDescription())) {
            spannableStringBuilder.append(cJRBrowsePlanProductList.getDescription());
        }
        if (!TextUtils.isEmpty(spannableStringBuilder)) {
            try {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context, R.color.color_222222)), 0, spannableStringBuilder.length(), 33);
                String spannableStringBuilder2 = spannableStringBuilder.toString();
                int indexOf = spannableStringBuilder2.indexOf("   •   ", 0);
                while (indexOf >= 0 && indexOf < spannableStringBuilder.length()) {
                    int i2 = indexOf + 7;
                    spannableStringBuilder.setSpan(new StyleSpan(1), indexOf, i2, 33);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context, R.color.color_8f969c)), indexOf, i2, 33);
                    indexOf = spannableStringBuilder2.indexOf("   •   ", indexOf + 1);
                }
            } catch (Exception unused) {
            }
        }
        if (!TextUtils.isEmpty(cJRBrowsePlanProductList.getParsedValidity())) {
            spannableStringBuilder.append("\n\n").append(context.getString(R.string.v8_os_selected_plan_validity)).append(": ").append(cJRBrowsePlanProductList.getValidity());
        }
        return spannableStringBuilder;
    }

    public static boolean f(String str) {
        if (str == null) {
            return false;
        }
        c cVar = c.f62654a;
        return c.J().contains(str);
    }

    public static void a(net.one97.paytm.recharge.common.f.a aVar, Context context) {
        a(aVar, context, (DialogInterface.OnCancelListener) null, (aa) null);
    }

    public static void a(final net.one97.paytm.recharge.common.f.a aVar, final Context context, DialogInterface.OnCancelListener onCancelListener, final aa aaVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getResources().getString(R.string.no_connection));
        builder.setMessage(context.getResources().getString(R.string.no_internet));
        builder.setPositiveButton(context.getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                if (com.paytm.utility.b.c(context)) {
                    aa aaVar = aaVar;
                    if (aaVar != null) {
                        aaVar.f();
                    }
                    net.one97.paytm.recharge.common.f.d.a(aVar);
                    return;
                }
                ba.a(aVar, context);
            }
        });
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        builder.show();
    }

    public static void a(Context context, CJRRechargePayment cJRRechargePayment, FetchPayOptionsListener fetchPayOptionsListener) {
        PaytmSDK.setServer(Server.PRODUCTION);
        new FetchOptionsRequest(context, cJRRechargePayment.getMID(), cJRRechargePayment.getOrderId(), cJRRechargePayment.getmTxnToken(), fetchPayOptionsListener).executeRequest();
    }

    public static boolean g(String str) {
        try {
            return Float.parseFloat(str) > 0.0f;
        } catch (Exception unused) {
        }
    }

    public static String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return str.indexOf(AppUtility.CENTER_DOT) < 0 ? str : str.replaceAll("0*$", "").replaceAll("\\.$", "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(Context context, String str, String str2) {
        if (context != null) {
            if (TextUtils.isEmpty(str)) {
                str = context.getString(R.string.imps_api_error_msg);
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            az azVar = az.f61525a;
            az.a(context, ERROR_TYPE.UNDEFINED, ACTION_TYPE.OS_INSTANT_REFUND, str2, str);
        }
    }

    public static int a(float f2, Context context) {
        return (int) (f2 * (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isConnected();
    }

    public static void a(Context context, View view) {
        InputMethodManager inputMethodManager;
        if (context != null && (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) != null && view != null && view.getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String i(java.lang.String r1) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case 53: goto L_0x00ad;
                case 54: goto L_0x00a2;
                case 55: goto L_0x0098;
                case 57: goto L_0x008e;
                case 1568: goto L_0x0084;
                case 1574: goto L_0x007a;
                case 1575: goto L_0x006f;
                case 1576: goto L_0x0065;
                case 1599: goto L_0x005b;
                case 1601: goto L_0x0051;
                case 1604: goto L_0x0045;
                case 51593977: goto L_0x0039;
                case 52425052: goto L_0x002d;
                case 52515505: goto L_0x0021;
                case 1448850396: goto L_0x0015;
                case 1454360956: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x00b7
        L_0x0009:
            java.lang.String r0 = "166690"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b7
            r1 = 9
            goto L_0x00b8
        L_0x0015:
            java.lang.String r0 = "107730"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b7
            r1 = 15
            goto L_0x00b8
        L_0x0021:
            java.lang.String r0 = "78640"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b7
            r1 = 10
            goto L_0x00b8
        L_0x002d:
            java.lang.String r0 = "75505"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b7
            r1 = 13
            goto L_0x00b8
        L_0x0039:
            java.lang.String r0 = "68869"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b7
            r1 = 14
            goto L_0x00b8
        L_0x0045:
            java.lang.String r0 = "26"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b7
            r1 = 8
            goto L_0x00b8
        L_0x0051:
            java.lang.String r0 = "23"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b7
            r1 = 7
            goto L_0x00b8
        L_0x005b:
            java.lang.String r0 = "21"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b7
            r1 = 3
            goto L_0x00b8
        L_0x0065:
            java.lang.String r0 = "19"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b7
            r1 = 5
            goto L_0x00b8
        L_0x006f:
            java.lang.String r0 = "18"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b7
            r1 = 12
            goto L_0x00b8
        L_0x007a:
            java.lang.String r0 = "17"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b7
            r1 = 1
            goto L_0x00b8
        L_0x0084:
            java.lang.String r0 = "11"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b7
            r1 = 6
            goto L_0x00b8
        L_0x008e:
            java.lang.String r0 = "9"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b7
            r1 = 2
            goto L_0x00b8
        L_0x0098:
            java.lang.String r0 = "7"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b7
            r1 = 4
            goto L_0x00b8
        L_0x00a2:
            java.lang.String r0 = "6"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b7
            r1 = 11
            goto L_0x00b8
        L_0x00ad:
            java.lang.String r0 = "5"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b7
            r1 = 0
            goto L_0x00b8
        L_0x00b7:
            r1 = -1
        L_0x00b8:
            switch(r1) {
                case 0: goto L_0x00db;
                case 1: goto L_0x00db;
                case 2: goto L_0x00d8;
                case 3: goto L_0x00d8;
                case 4: goto L_0x00d5;
                case 5: goto L_0x00d5;
                case 6: goto L_0x00d2;
                case 7: goto L_0x00d2;
                case 8: goto L_0x00cf;
                case 9: goto L_0x00cc;
                case 10: goto L_0x00c9;
                case 11: goto L_0x00c6;
                case 12: goto L_0x00c6;
                case 13: goto L_0x00c3;
                case 14: goto L_0x00c0;
                case 15: goto L_0x00bd;
                default: goto L_0x00bb;
            }
        L_0x00bb:
            r1 = 0
            goto L_0x00dd
        L_0x00bd:
            java.lang.String r1 = "Municipal Payments (new)"
            goto L_0x00dd
        L_0x00c0:
            java.lang.String r1 = "Water (new)"
            goto L_0x00dd
        L_0x00c3:
            java.lang.String r1 = "Landline_Broadband"
            goto L_0x00dd
        L_0x00c6:
            java.lang.String r1 = "DTH (new)"
            goto L_0x00dd
        L_0x00c9:
            java.lang.String r1 = "gas_pipeline"
            goto L_0x00dd
        L_0x00cc:
            java.lang.String r1 = "book_cylinder"
            goto L_0x00dd
        L_0x00cf:
            java.lang.String r1 = "Electricity (new)"
            goto L_0x00dd
        L_0x00d2:
            java.lang.String r1 = "datacard_postpaid"
            goto L_0x00dd
        L_0x00d5:
            java.lang.String r1 = "datacard_prepaid"
            goto L_0x00dd
        L_0x00d8:
            java.lang.String r1 = "mobile_postpaid"
            goto L_0x00dd
        L_0x00db:
            java.lang.String r1 = "mobile_prepaid"
        L_0x00dd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.ba.i(java.lang.String):java.lang.String");
    }

    public static String a(Context context, String str, String str2, String str3, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("recharge_number", str);
            jSONObject3.put(CLPConstants.PRODUCT_ID, str2);
            jSONObject3.put("amount", str3);
            jSONObject2.put("custId", com.paytm.utility.b.n(context));
            jSONObject2.put("rechargeInfo", jSONObject3);
            jSONObject2.put("productInfo", jSONObject);
        } catch (Exception e2) {
            q.d(e2.getMessage());
        }
        return jSONObject2.toString();
    }

    public static String j(String str) {
        if (str == null || str.trim().equalsIgnoreCase("")) {
            return "";
        }
        try {
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
            decimalFormat.applyPattern(com.business.merchant_payments.common.utility.AppConstants.PRICE_PATTERN);
            return decimalFormat.format((double) Float.parseFloat(str));
        } catch (Exception unused) {
            return new DecimalFormat(com.business.merchant_payments.common.utility.AppConstants.PRICE_PATTERN).format((double) Float.parseFloat(str));
        }
    }

    public static ArrayList<CJRRelatedCategory> k(String str) {
        CJRRelatedCategory[] cJRRelatedCategoryArr;
        try {
            if (TextUtils.isEmpty(str) || (cJRRelatedCategoryArr = (CJRRelatedCategory[]) new f().a(str, CJRRelatedCategory[].class)) == null || cJRRelatedCategoryArr.length <= 0) {
                return null;
            }
            return new ArrayList<>(Arrays.asList(cJRRelatedCategoryArr));
        } catch (Exception e2) {
            q.d(e2.getMessage());
            return null;
        }
    }

    public static String a(CJRItem cJRItem) {
        if (cJRItem == null) {
            return null;
        }
        if (!TextUtils.isEmpty(cJRItem.getCategoryId())) {
            return cJRItem.getCategoryId();
        }
        if (!TextUtils.isEmpty(cJRItem.getURL())) {
            String l2 = l(cJRItem.getURL());
            ((CJRHomePageItem) cJRItem).setCategoryId(l2);
            return l2;
        }
        CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) cJRItem;
        if (TextUtils.isEmpty(cJRHomePageItem.getDeeplink())) {
            return null;
        }
        String l3 = l(Uri.parse(cJRHomePageItem.getDeeplink()).getQueryParameter("url"));
        cJRHomePageItem.setCategoryId(l3);
        return l3;
    }

    public static String l(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("?");
        int lastIndexOf = str.lastIndexOf(47);
        if (indexOf == -1 || lastIndexOf >= indexOf) {
            return str.substring(str.lastIndexOf(47) + 1, str.length());
        }
        return str.substring(str.lastIndexOf(47) + 1, indexOf);
    }

    public static String a(String str, boolean z) {
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        return net.one97.paytm.recharge.widgets.c.d.a(str, z, -1, true);
    }

    public static void a(Activity activity) {
        if (activity != null) {
            new CJRHomePageItem().setUrl(ax.a(activity.getApplicationContext()).b("home_url", "", true));
            net.one97.paytm.recharge.di.helper.a aVar = net.one97.paytm.recharge.di.helper.a.f62650a;
            Intent intent = new Intent(activity, net.one97.paytm.recharge.di.helper.a.g());
            intent.addFlags(67108864);
            intent.addFlags(268435456);
            intent.setFlags(536870912);
            intent.putExtra("CLEAR_MOBILE_DATA", true);
            intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
            activity.startActivity(intent);
            activity.finish();
        }
    }

    public static void a(final Activity activity, SpannableStringBuilder spannableStringBuilder, final URLSpan uRLSpan) {
        try {
            int spanStart = spannableStringBuilder.getSpanStart(uRLSpan);
            int spanEnd = spannableStringBuilder.getSpanEnd(uRLSpan);
            int spanFlags = spannableStringBuilder.getSpanFlags(uRLSpan);
            final String substring = spannableStringBuilder.toString().substring(spanStart, spanEnd);
            spannableStringBuilder.setSpan(new ClickableSpan() {
                public final void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setUnderlineText(false);
                }

                public final void onClick(View view) {
                    Activity activity = activity;
                    if (activity != null && !activity.isFinishing()) {
                        Activity activity2 = activity;
                        net.one97.paytm.recharge.di.helper.a aVar = net.one97.paytm.recharge.di.helper.a.f62650a;
                        Intent intent = new Intent(activity2, net.one97.paytm.recharge.di.helper.a.c());
                        intent.putExtra("url", uRLSpan.getURL());
                        intent.putExtra("title", substring);
                        intent.putExtra(UpiConstants.FROM, "electricity");
                        activity.startActivity(intent);
                    }
                }
            }, spanStart, spanEnd, spanFlags);
            spannableStringBuilder.removeSpan(uRLSpan);
        } catch (Exception unused) {
        }
    }

    public static void a(List<CJRMerchantLoanAccountItem> list, List<CJRFrequentOrder> list2, String str) {
        int i2 = 0;
        for (CJRMerchantLoanAccountItem next : list) {
            CJRFrequentOrder cJRFrequentOrder = new CJRFrequentOrder();
            cJRFrequentOrder.setRechargeNumber(next.getAccountNumber());
            Map<String, String> configuration = cJRFrequentOrder.getConfiguration();
            String valueOf = String.valueOf(next.getBillingDetails().get("due_amount"));
            cJRFrequentOrder.getClass();
            configuration.put("price", valueOf);
            cJRFrequentOrder.setmCreatedAt(next.getAccountActivationDate());
            cJRFrequentOrder.setService(str);
            Map<String, String> productAttributes = cJRFrequentOrder.getProductAttributes();
            productAttributes.put("paytype", str);
            productAttributes.put(StringSet.operator, next.getLender());
            productAttributes.put("lender", next.getDisplayName());
            productAttributes.put("merchant_loan_account", "merchant_loan_account");
            if (list2 != null) {
                list2.add(i2, cJRFrequentOrder);
                i2++;
            }
        }
    }

    public static void b(Context context, View view) {
        if (view.requestFocus()) {
            ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 1);
        }
    }

    public static boolean c(Context context) {
        try {
            int b2 = ax.a(context.getApplicationContext()).b("recharge.prefs.lang", -1, false);
            if (b2 == -1) {
                d(context);
                return true;
            } else if (b2 != n.b()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception unused) {
        }
    }

    public static void d(Context context) {
        try {
            ax.a(context.getApplicationContext()).a("recharge.prefs.lang", n.b(), false);
        } catch (Exception unused) {
        }
    }

    public static SpannableStringBuilder a(Context context, ArrayList<CJRDisplayValues> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        int size = arrayList.size();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            CJRDisplayValues cJRDisplayValues = arrayList.get(i2);
            if (i2 != size - 1) {
                spannableStringBuilder.append(cJRDisplayValues.getLabel()).append(" ").append(cJRDisplayValues.getValue()).append("   •   ");
            } else {
                spannableStringBuilder.append(cJRDisplayValues.getLabel()).append(" ").append(cJRDisplayValues.getValue());
            }
        }
        if (!TextUtils.isEmpty(spannableStringBuilder)) {
            try {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context, R.color.color_222222)), 0, spannableStringBuilder.length(), 33);
                String spannableStringBuilder2 = spannableStringBuilder.toString();
                int indexOf = spannableStringBuilder2.indexOf("   •   ", 0);
                while (indexOf >= 0 && indexOf < spannableStringBuilder.length()) {
                    int i3 = indexOf + 7;
                    spannableStringBuilder.setSpan(new StyleSpan(1), indexOf, i3, 33);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context, R.color.color_8f969c)), indexOf, i3, 33);
                    indexOf = spannableStringBuilder2.indexOf("   •   ", indexOf + 1);
                }
                for (int i4 = 0; i4 < size; i4++) {
                    String value = arrayList.get(i4).getValue();
                    int indexOf2 = spannableStringBuilder.toString().indexOf(value);
                    int length = value.length() + indexOf2;
                    if (indexOf2 >= 0) {
                        spannableStringBuilder.setSpan(new StyleSpan(1), indexOf2, length, 33);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return spannableStringBuilder;
    }

    public static boolean b(String str, String str2) {
        return str != null && !TextUtils.isEmpty(str2) && str.matches(str2);
    }

    public static int c(String str, String str2) {
        try {
            return Color.parseColor(str);
        } catch (Exception unused) {
            return Color.parseColor(str2);
        }
    }

    public static HashMap<String, d<String, String>> a(Context context) {
        HashMap<String, d<String, String>> hashMap = o;
        if (hashMap == null || hashMap.isEmpty()) {
            o = new HashMap<>();
            if (context != null) {
                o.put(BaseViewModel.PaymentType.COD, new d("Cash On Delivery", context.getResources().getString(R.string.pay_mode_cod)));
                d dVar = new d("Credit Card", context.getResources().getString(R.string.pay_mode_credit_card));
                o.put("cc", dVar);
                o.put("credit_card", dVar);
                d dVar2 = new d("Debit Card", context.getResources().getString(R.string.pay_mode_debit_card));
                o.put("dc", dVar2);
                o.put("debit_card", dVar2);
                d dVar3 = new d("Net Banking", context.getResources().getString(R.string.pay_mode_net_banking));
                o.put("nb", dVar3);
                o.put(SDKConstants.UPI_NET_BANKING, dVar3);
                o.put("escrow", new d("ESCROW", context.getResources().getString(R.string.pay_mode_esc)));
                o.put("emi", new d("EMI", context.getResources().getString(R.string.pay_mode_emi)));
                o.put("upi", new d("UPI", context.getResources().getString(R.string.pay_mode_upi)));
                d dVar4 = new d("Paytm Wallet", context.getResources().getString(R.string.pay_mode_wallet));
                o.put("ppi", dVar4);
                o.put("paytm cash", dVar4);
                o.put("balance", dVar4);
                o.put("paytm_digital_credit", new d("Paytm Postpaid", context.getResources().getString(R.string.pay_mode_postpaid)));
            }
        }
        return o;
    }
}
