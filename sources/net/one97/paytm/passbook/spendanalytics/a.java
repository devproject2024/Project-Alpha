package net.one97.paytm.passbook.spendanalytics;

import android.graphics.Color;
import android.os.Build;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import com.business.merchant_payments.utility.MPConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import kotlin.g.b.k;
import kotlin.m.p;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f58478a = new a();

    private a() {
    }

    public static String a(String str) {
        k.c(str, MPConstants.PaymentSummaryRange.MONTH);
        CharSequence charSequence = str;
        Date parse = new SimpleDateFormat("MMMM").parse((String) p.a(charSequence, new String[]{AppConstants.COMMA}).get(0));
        Calendar instance = Calendar.getInstance();
        k.a((Object) instance, "cal");
        instance.setTime(parse);
        return ((String) p.a(charSequence, new String[]{AppConstants.COMMA}).get(1)) + '-' + (instance.get(2) + 1) + "-01 00:00:00";
    }

    public static String b(String str) {
        k.c(str, MPConstants.PaymentSummaryRange.MONTH);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM yyyy");
        StringBuilder sb = new StringBuilder();
        CharSequence charSequence = str;
        sb.append((String) p.a(charSequence, new String[]{AppConstants.COMMA}).get(0));
        sb.append(" ");
        sb.append((String) p.a(charSequence, new String[]{AppConstants.COMMA}).get(1));
        Date parse = simpleDateFormat.parse(sb.toString());
        Calendar instance = Calendar.getInstance();
        k.a((Object) instance, "cal");
        instance.setTime(parse);
        int actualMaximum = instance.getActualMaximum(5);
        return ((String) p.a(charSequence, new String[]{AppConstants.COMMA}).get(1)) + '-' + (instance.get(2) + 1) + '-' + actualMaximum + " 23:59:59";
    }

    public static boolean c(String str) {
        k.c(str, MPConstants.PaymentSummaryRange.MONTH);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM yyyy");
        StringBuilder sb = new StringBuilder();
        CharSequence charSequence = str;
        sb.append((String) p.a(charSequence, new String[]{AppConstants.COMMA}).get(0));
        sb.append(" ");
        sb.append((String) p.a(charSequence, new String[]{AppConstants.COMMA}).get(1));
        Date parse = simpleDateFormat.parse(sb.toString());
        Calendar instance = Calendar.getInstance();
        k.a((Object) instance, "cal");
        instance.setTime(parse);
        return instance.get(2) + 1 == Calendar.getInstance().get(2) + 1;
    }

    public static Integer d(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1922936957:
                    if (str.equals("Others")) {
                        return Integer.valueOf(Color.parseColor("#506d85"));
                    }
                    break;
                case -1781830854:
                    if (str.equals("Travel")) {
                        return Integer.valueOf(Color.parseColor("#8278f4"));
                    }
                    break;
                case -1439515420:
                    if (str.equals("Dairy & Groceries")) {
                        return Integer.valueOf(Color.parseColor("#41cc99"));
                    }
                    break;
                case -1238342200:
                    if (str.equals("Transfers")) {
                        return Integer.valueOf(Color.parseColor("#00aeed"));
                    }
                    break;
                case -882097093:
                    if (str.equals("Food & Beverage")) {
                        return Integer.valueOf(Color.parseColor("#f0bf44"));
                    }
                    break;
                case -279816824:
                    if (str.equals("Shopping")) {
                        return Integer.valueOf(Color.parseColor("#f575b5"));
                    }
                    break;
                case -237997464:
                    if (str.equals("Taxi & Transportation")) {
                        return Integer.valueOf(Color.parseColor("#ed8a8a"));
                    }
                    break;
                case 340973982:
                    if (str.equals("Fuel & Automobiles")) {
                        return Integer.valueOf(Color.parseColor("#c278f4"));
                    }
                    break;
                case 654576827:
                    if (str.equals("Recharges & Bill Payment")) {
                        return Integer.valueOf(Color.parseColor("#6ca6fc"));
                    }
                    break;
                case 1298968424:
                    if (str.equals("Entertainment")) {
                        return Integer.valueOf(Color.parseColor("#f5916c"));
                    }
                    break;
                case 1443853438:
                    if (str.equals("Services")) {
                        return Integer.valueOf(Color.parseColor("#f5a76c"));
                    }
                    break;
                case 1478121371:
                    if (str.equals("Personal & Health Care")) {
                        return Integer.valueOf(Color.parseColor("#4dcdc9"));
                    }
                    break;
            }
        }
        return Integer.valueOf(Color.parseColor("#506d85"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x008f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String e(java.lang.String r3) {
        /*
            if (r3 != 0) goto L_0x0004
            goto L_0x00bb
        L_0x0004:
            int r0 = r3.hashCode()
            r1 = 50
            if (r0 == r1) goto L_0x00b1
            r1 = 53
            if (r0 == r1) goto L_0x00a6
            r1 = 55
            if (r0 == r1) goto L_0x009b
            r1 = 1669(0x685, float:2.339E-42)
            if (r0 == r1) goto L_0x0090
            r1 = 1700(0x6a4, float:2.382E-42)
            java.lang.String r2 = "Other Wallets"
            if (r0 == r1) goto L_0x0087
            r1 = 1756(0x6dc, float:2.46E-42)
            if (r0 == r1) goto L_0x007e
            r1 = 1665(0x681, float:2.333E-42)
            if (r0 == r1) goto L_0x0073
            r1 = 1666(0x682, float:2.335E-42)
            if (r0 == r1) goto L_0x0068
            r1 = 1730(0x6c2, float:2.424E-42)
            if (r0 == r1) goto L_0x005d
            r1 = 1731(0x6c3, float:2.426E-42)
            if (r0 == r1) goto L_0x0052
            switch(r0) {
                case 1696: goto L_0x0049;
                case 1697: goto L_0x0040;
                case 1698: goto L_0x0037;
                default: goto L_0x0035;
            }
        L_0x0035:
            goto L_0x00bb
        L_0x0037:
            java.lang.String r0 = "57"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00bb
            goto L_0x008f
        L_0x0040:
            java.lang.String r0 = "56"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00bb
            goto L_0x008f
        L_0x0049:
            java.lang.String r0 = "55"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00bb
            goto L_0x008f
        L_0x0052:
            java.lang.String r0 = "69"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00bb
            java.lang.String r3 = "Payments"
            return r3
        L_0x005d:
            java.lang.String r0 = "68"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00bb
            java.lang.String r3 = "Gift Vouchers"
            return r3
        L_0x0068:
            java.lang.String r0 = "46"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00bb
            java.lang.String r3 = "Gift Wallet"
            return r3
        L_0x0073:
            java.lang.String r0 = "45"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00bb
            java.lang.String r3 = "Food Wallet"
            return r3
        L_0x007e:
            java.lang.String r0 = "73"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00bb
            return r2
        L_0x0087:
            java.lang.String r0 = "59"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00bb
        L_0x008f:
            return r2
        L_0x0090:
            java.lang.String r0 = "49"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00bb
            java.lang.String r3 = "Toll Wallet"
            return r3
        L_0x009b:
            java.lang.String r0 = "7"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00bb
            java.lang.String r3 = "Cashback"
            return r3
        L_0x00a6:
            java.lang.String r0 = "5"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00bb
            java.lang.String r3 = "Friends & Family"
            return r3
        L_0x00b1:
            java.lang.String r0 = "2"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00bb
            java.lang.String r3 = "Refunds"
        L_0x00bb:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.spendanalytics.a.e(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
        if (r2.equals("57") != false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0044, code lost:
        if (r2.equals("56") != false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004d, code lost:
        if (r2.equals("55") != false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a1, code lost:
        if (r2.equals("59") != false) goto L_0x00a3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Integer f(java.lang.String r2) {
        /*
            if (r2 != 0) goto L_0x0004
            goto L_0x00e6
        L_0x0004:
            int r0 = r2.hashCode()
            r1 = 50
            if (r0 == r1) goto L_0x00d7
            r1 = 53
            if (r0 == r1) goto L_0x00c8
            r1 = 55
            if (r0 == r1) goto L_0x00b9
            r1 = 1669(0x685, float:2.339E-42)
            if (r0 == r1) goto L_0x00aa
            r1 = 1700(0x6a4, float:2.382E-42)
            if (r0 == r1) goto L_0x009b
            r1 = 1756(0x6dc, float:2.46E-42)
            if (r0 == r1) goto L_0x008c
            r1 = 1665(0x681, float:2.333E-42)
            if (r0 == r1) goto L_0x007d
            r1 = 1666(0x682, float:2.335E-42)
            if (r0 == r1) goto L_0x006e
            r1 = 1730(0x6c2, float:2.424E-42)
            if (r0 == r1) goto L_0x005f
            r1 = 1731(0x6c3, float:2.426E-42)
            if (r0 == r1) goto L_0x0050
            switch(r0) {
                case 1696: goto L_0x0047;
                case 1697: goto L_0x003e;
                case 1698: goto L_0x0035;
                default: goto L_0x0033;
            }
        L_0x0033:
            goto L_0x00e6
        L_0x0035:
            java.lang.String r0 = "57"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00e6
            goto L_0x00a3
        L_0x003e:
            java.lang.String r0 = "56"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00e6
            goto L_0x00a3
        L_0x0047:
            java.lang.String r0 = "55"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00e6
            goto L_0x00a3
        L_0x0050:
            java.lang.String r0 = "69"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00e6
            int r2 = net.one97.paytm.passbook.R.drawable.pass_sa_payments
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        L_0x005f:
            java.lang.String r0 = "68"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00e6
            int r2 = net.one97.paytm.passbook.R.drawable.pass_sa_gift_voucher
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        L_0x006e:
            java.lang.String r0 = "46"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00e6
            int r2 = net.one97.paytm.passbook.R.drawable.pass_sa_gift_wallet
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        L_0x007d:
            java.lang.String r0 = "45"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00e6
            int r2 = net.one97.paytm.passbook.R.drawable.pass_sa_food_wallet
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        L_0x008c:
            java.lang.String r0 = "73"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00e6
            int r2 = net.one97.paytm.passbook.R.drawable.pass_sa_other_wallets
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        L_0x009b:
            java.lang.String r0 = "59"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00e6
        L_0x00a3:
            int r2 = net.one97.paytm.passbook.R.drawable.pass_sa_other_wallets
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        L_0x00aa:
            java.lang.String r0 = "49"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00e6
            int r2 = net.one97.paytm.passbook.R.drawable.pass_sa_toll_wallet
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        L_0x00b9:
            java.lang.String r0 = "7"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00e6
            int r2 = net.one97.paytm.passbook.R.drawable.pass_sa_cashback
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        L_0x00c8:
            java.lang.String r0 = "5"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00e6
            int r2 = net.one97.paytm.passbook.R.drawable.pass_sa_friends_family
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        L_0x00d7:
            java.lang.String r0 = "2"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00e6
            int r2 = net.one97.paytm.passbook.R.drawable.pass_sa_refunds
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        L_0x00e6:
            int r2 = net.one97.paytm.passbook.R.drawable.pass_sa_other_wallets
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.spendanalytics.a.f(java.lang.String):java.lang.Integer");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
        if (r3.equals("57") != false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
        if (r3.equals("56") != false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
        if (r3.equals("55") != false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a0, code lost:
        if (r3.equals("59") != false) goto L_0x00a2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Integer g(java.lang.String r3) {
        /*
            java.lang.String r0 = "#506D85"
            if (r3 != 0) goto L_0x0006
            goto L_0x00f7
        L_0x0006:
            int r1 = r3.hashCode()
            r2 = 50
            if (r1 == r2) goto L_0x00e4
            r2 = 53
            if (r1 == r2) goto L_0x00d1
            r2 = 55
            if (r1 == r2) goto L_0x00be
            r2 = 1669(0x685, float:2.339E-42)
            if (r1 == r2) goto L_0x00ab
            r2 = 1700(0x6a4, float:2.382E-42)
            if (r1 == r2) goto L_0x009a
            r2 = 1665(0x681, float:2.333E-42)
            if (r1 == r2) goto L_0x0087
            r2 = 1666(0x682, float:2.335E-42)
            if (r1 == r2) goto L_0x0074
            r2 = 1730(0x6c2, float:2.424E-42)
            if (r1 == r2) goto L_0x0061
            r2 = 1731(0x6c3, float:2.426E-42)
            if (r1 == r2) goto L_0x004e
            switch(r1) {
                case 1696: goto L_0x0045;
                case 1697: goto L_0x003c;
                case 1698: goto L_0x0033;
                default: goto L_0x0031;
            }
        L_0x0031:
            goto L_0x00f7
        L_0x0033:
            java.lang.String r1 = "57"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x00f7
            goto L_0x00a2
        L_0x003c:
            java.lang.String r1 = "56"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x00f7
            goto L_0x00a2
        L_0x0045:
            java.lang.String r1 = "55"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x00f7
            goto L_0x00a2
        L_0x004e:
            java.lang.String r1 = "69"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x00f7
            java.lang.String r3 = "#00ACED"
            int r3 = android.graphics.Color.parseColor(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            return r3
        L_0x0061:
            java.lang.String r1 = "68"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x00f7
            java.lang.String r3 = "#C278F4"
            int r3 = android.graphics.Color.parseColor(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            return r3
        L_0x0074:
            java.lang.String r1 = "46"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x00f7
            java.lang.String r3 = "#F575B6"
            int r3 = android.graphics.Color.parseColor(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            return r3
        L_0x0087:
            java.lang.String r1 = "45"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x00f7
            java.lang.String r3 = "#F4906C"
            int r3 = android.graphics.Color.parseColor(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            return r3
        L_0x009a:
            java.lang.String r1 = "59"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x00f7
        L_0x00a2:
            int r3 = android.graphics.Color.parseColor(r0)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            return r3
        L_0x00ab:
            java.lang.String r1 = "49"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x00f7
            java.lang.String r3 = "#F0BF44"
            int r3 = android.graphics.Color.parseColor(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            return r3
        L_0x00be:
            java.lang.String r1 = "7"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x00f7
            java.lang.String r3 = "#20C1BC"
            int r3 = android.graphics.Color.parseColor(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            return r3
        L_0x00d1:
            java.lang.String r1 = "5"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x00f7
            java.lang.String r3 = "#5243ED"
            int r3 = android.graphics.Color.parseColor(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            return r3
        L_0x00e4:
            java.lang.String r1 = "2"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x00f7
            java.lang.String r3 = "#4790fb"
            int r3 = android.graphics.Color.parseColor(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            return r3
        L_0x00f7:
            int r3 = android.graphics.Color.parseColor(r0)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.spendanalytics.a.g(java.lang.String):java.lang.Integer");
    }

    public static Spanned h(String str) {
        if (str == null) {
            return new SpannableString("");
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Spanned fromHtml = Html.fromHtml(str, 0);
            k.a((Object) fromHtml, "Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)");
            return fromHtml;
        }
        Spanned fromHtml2 = Html.fromHtml(str);
        k.a((Object) fromHtml2, "Html.fromHtml(html)");
        return fromHtml2;
    }
}
