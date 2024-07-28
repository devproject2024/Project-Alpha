package net.one97.paytm.addmoney.togv.e;

import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppUtility;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0858a f48722a = new C0858a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static String f48723b = "₹ ";
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static String f48724c = "##,##,##,##,###";
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static String f48725d = "##,##,##,##,###.";
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final int f48726e = 2;

    /* renamed from: net.one97.paytm.addmoney.togv.e.a$a  reason: collision with other inner class name */
    public static final class C0858a {
        private C0858a() {
        }

        public /* synthetic */ C0858a(byte b2) {
            this();
        }

        public static String a(String str) {
            String str2;
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
            String replace2 = new l("^\\s+").replace((CharSequence) replace.subSequence(i2, length + 1).toString(), "");
            try {
                if (TextUtils.isEmpty(replace2)) {
                    return "";
                }
                if (p.a((CharSequence) replace2, (CharSequence) AppUtility.CENTER_DOT, false)) {
                    k.c(replace2, "str");
                    if (k.a((Object) replace2, (Object) AppUtility.CENTER_DOT)) {
                        str2 = a.f48723b + AppUtility.CENTER_DOT;
                    } else {
                        str2 = new DecimalFormat(a.f48723b + a.f48725d + b(replace2), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(new BigDecimal(replace2));
                        k.a((Object) str2, "formatter.format(parsed)");
                    }
                } else {
                    k.c(replace2, "str");
                    str2 = new DecimalFormat(a.f48723b + a.f48724c, DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(new BigDecimal(replace2));
                    k.a((Object) str2, "formatter.format(parsed)");
                }
                return str2;
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return "";
            }
        }

        private static String b(String str) {
            k.c(str, "str");
            int i2 = 0;
            int length = (str.length() - 1) - p.a((CharSequence) str, AppUtility.CENTER_DOT, 0, false, 6);
            String str2 = "";
            if (length == 0) {
                return str2 + "00";
            }
            while (i2 < length && i2 < a.f48726e) {
                str2 = str2 + "0";
                i2++;
            }
            return str2;
        }
    }
}
