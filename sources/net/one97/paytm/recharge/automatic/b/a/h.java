package net.one97.paytm.recharge.automatic.b.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import easypay.manager.Constants;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.automatic.R;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final a f60252a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final DecimalFormat f60253b = new DecimalFormat("##,##,##,##,###", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static NetworkCustomError a(NetworkCustomError networkCustomError, NetworkCustomError networkCustomError2) {
            k.c(networkCustomError, "newNetworkError");
            k.c(networkCustomError2, "oldNetworkError");
            networkCustomError.setAlertMessage(networkCustomError2.getAlertMessage());
            networkCustomError.setmAlertTitle(networkCustomError2.getAlertTitle());
            networkCustomError.setUrl(networkCustomError2.getUrl());
            networkCustomError.setNetworkResponse(networkCustomError2.getNetworkResponse());
            networkCustomError.setErrorType(networkCustomError2.getErrorType());
            networkCustomError.setUniqueReference(networkCustomError2.getUniqueReference());
            return networkCustomError;
        }

        public static boolean a(String str) {
            k.c(str, "input");
            try {
                return Double.parseDouble(str) > 0.0d;
            } catch (Exception unused) {
                return false;
            }
        }

        public static String b(String str) {
            k.c(str, "str");
            BigDecimal bigDecimal = new BigDecimal(str);
            DecimalFormat decimalFormat = new DecimalFormat("##,##,##,##,###." + h(str), DecimalFormatSymbols.getInstance(Locale.ENGLISH));
            decimalFormat.setMinimumIntegerDigits(1);
            String format = decimalFormat.format(bigDecimal);
            k.a((Object) format, "formatter.format(parsed)");
            return format;
        }

        private static String h(String str) {
            int i2 = 0;
            int length = (str.length() - 1) - p.a((CharSequence) str, AppUtility.CENTER_DOT, 0, false, 6);
            String str2 = "";
            while (i2 < length && i2 < 2) {
                str2 = str2 + "0";
                i2++;
            }
            return str2;
        }

        public static String c(String str) {
            k.c(str, "str");
            CharSequence replace = new l("[₹, ]").replace((CharSequence) str, "");
            int length = replace.length() - 1;
            int i2 = 0;
            boolean z = false;
            while (i2 <= length) {
                boolean z2 = replace.charAt(!z ? i2 : length) <= ' ';
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (!z2) {
                    z = true;
                } else {
                    i2++;
                }
            }
            String replace2 = new l("\\.0*$").replace((CharSequence) new l("^\\s+").replace((CharSequence) replace.subSequence(i2, length + 1).toString(), ""), "");
            try {
                if (TextUtils.isEmpty(replace2)) {
                    return str;
                }
                if (p.a((CharSequence) replace2, (CharSequence) AppUtility.CENTER_DOT, false)) {
                    return b(replace2);
                }
                String format = h.f60253b.format(new BigDecimal(replace2));
                k.a((Object) format, "decimalFormatter.format(parsed)");
                return format;
            } catch (Exception e2) {
                q.d(e2.getMessage());
                return str;
            }
        }

        public static String a() {
            String format = c().format(new Date());
            k.a((Object) format, "getSimpleDateFormat().format(Date())");
            return format;
        }

        public static String d(String str) {
            k.c(str, "givenDate");
            String format = c().format(new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).parse(str));
            k.a((Object) format, "getSimpleDateFormat().format(date)");
            return format;
        }

        public static String b() {
            Calendar instance = Calendar.getInstance();
            instance.add(1, 10);
            SimpleDateFormat c2 = c();
            k.a((Object) instance, "calendar");
            String format = c2.format(instance.getTime());
            k.a((Object) format, "getSimpleDateFormat().format(calendar.time)");
            return format;
        }

        private static SimpleDateFormat c() {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        }

        public static void e(String str) {
            k.c(str, "log");
            q.d(str);
        }

        public static void a(Context context, View view) {
            k.c(context, "context");
            k.c(view, "view");
            Object systemService = context.getSystemService("input_method");
            if (systemService != null) {
                ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }

        public static int f(String str) {
            k.c(str, SDKConstants.CARD_NUMBER);
            if (str.length() > 1) {
                String substring = str.substring(0, 1);
                k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (substring == "4") {
                    return 1;
                }
                StringBuilder sb = new StringBuilder();
                String substring2 = str.substring(0, 2);
                k.a((Object) substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb.append(substring2);
                sb.append(AppConstants.COMMA);
                if (p.a((CharSequence) "51,52,53,54,55,", (CharSequence) sb.toString(), false)) {
                    return 2;
                }
                StringBuilder sb2 = new StringBuilder();
                String substring3 = str.substring(0, 2);
                k.a((Object) substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb2.append(substring3);
                sb2.append(AppConstants.COMMA);
                if (p.a((CharSequence) "34,37,", (CharSequence) sb2.toString(), false)) {
                    return 4;
                }
                String substring4 = str.substring(0, 1);
                k.a((Object) substring4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (substring4 == "6") {
                    return 3;
                }
                StringBuilder sb3 = new StringBuilder();
                String substring5 = str.substring(0, 2);
                k.a((Object) substring5, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb3.append(substring5);
                sb3.append(AppConstants.COMMA);
                if (p.a((CharSequence) "30,36,38,39", (CharSequence) sb3.toString(), false)) {
                    return 5;
                }
            }
            return 0;
        }

        public static String a(CharSequence charSequence) {
            k.c(charSequence, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
            StringBuilder sb = new StringBuilder();
            int length = charSequence.length();
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (Character.isDigit(charSequence.charAt(i3))) {
                    if (i2 % 4 == 0 && i2 > 0) {
                        sb.append(" ");
                    }
                    sb.append(charSequence.charAt(i3));
                    i2++;
                }
            }
            String sb2 = sb.toString();
            k.a((Object) sb2, "formatted.toString()");
            return sb2;
        }

        public static String b(CharSequence charSequence) {
            k.c(charSequence, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
            StringBuilder sb = new StringBuilder();
            int length = charSequence.length();
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (Character.isDigit(charSequence.charAt(i3))) {
                    if (i2 > 0 && (i2 == 4 || i2 == 10)) {
                        sb.append(" ");
                    }
                    sb.append(charSequence.charAt(i3));
                    i2++;
                }
            }
            String sb2 = sb.toString();
            k.a((Object) sb2, "formatted.toString()");
            return sb2;
        }

        public static Integer g(String str) {
            k.c(str, Constants.EXTRA_BANK_SCHEME);
            if (p.a(str, "maestro", true)) {
                return Integer.valueOf(R.drawable.maestro_icon);
            }
            if (p.a(str, "visa", true)) {
                return Integer.valueOf(R.drawable.visa_icon);
            }
            if (p.a(str, "master", true)) {
                return Integer.valueOf(R.drawable.master_icon);
            }
            if (p.a(str, "diners", true)) {
                return Integer.valueOf(R.drawable.diners);
            }
            if (p.a(str, "jcb", true)) {
                return Integer.valueOf(R.drawable.jcb);
            }
            if (p.a(str, "amex", true)) {
                return Integer.valueOf(R.drawable.amex);
            }
            return null;
        }

        public static View a(Activity activity) {
            k.c(activity, "activity");
            Window window = activity.getWindow();
            View decorView = window != null ? window.getDecorView() : null;
            if (!(decorView instanceof ViewGroup)) {
                decorView = null;
            }
            ViewGroup viewGroup = (ViewGroup) decorView;
            View findViewById = viewGroup != null ? viewGroup.findViewById(R.id.lyt_automatic_delete_header) : null;
            if (findViewById == null) {
                findViewById = LayoutInflater.from(activity).inflate(R.layout.lyt_delete_automatic_status_view, (ViewGroup) null, false);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(0, b.c(24), 0, 0);
                if (viewGroup != null) {
                    viewGroup.addView(findViewById, layoutParams);
                }
            }
            if (findViewById == null) {
                k.a();
            }
            return findViewById;
        }

        public static void a(View view) {
            if (view != null) {
                View findViewById = view.findViewById(R.id.tv_header);
                view.setVisibility(0);
                if (findViewById != null) {
                    findViewById.setVisibility(0);
                }
                view.postDelayed(new C1161a(findViewById, view), 3000);
            }
        }

        /* renamed from: net.one97.paytm.recharge.automatic.b.a.h$a$a  reason: collision with other inner class name */
        static final class C1161a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ View f60254a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ View f60255b;

            C1161a(View view, View view2) {
                this.f60254a = view;
                this.f60255b = view2;
            }

            public final void run() {
                View view = this.f60254a;
                if (view != null) {
                    view.setVisibility(8);
                }
                this.f60255b.setVisibility(8);
            }
        }
    }
}
