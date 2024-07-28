package net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw;

import java.text.DecimalFormat;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f18290a = {"", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f18291b = {"", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen"};

    private static String a(int i2) {
        int i3;
        String str;
        int i4 = i2 % 100;
        if (i4 < 20) {
            str = f18291b[i4];
            i3 = i2 / 100;
        } else {
            String str2 = f18291b[i2 % 10];
            int i5 = i2 / 10;
            str = f18290a[i5 % 10] + str2;
            i3 = i5 / 10;
        }
        if (i3 == 0) {
            return str;
        }
        return f18291b[i3] + " hundred" + str;
    }

    public static String a(long j) {
        String str;
        String str2;
        String str3;
        if (j == 0) {
            return "zero";
        }
        Long.toString(j);
        String format = new DecimalFormat("000000000000").format(j);
        int parseInt = Integer.parseInt(format.substring(0, 3));
        int parseInt2 = Integer.parseInt(format.substring(3, 6));
        int parseInt3 = Integer.parseInt(format.substring(6, 9));
        int parseInt4 = Integer.parseInt(format.substring(9, 12));
        if (parseInt != 0) {
            str = a(parseInt) + " billion ";
        } else {
            str = "";
        }
        if (parseInt2 != 0) {
            str2 = a(parseInt2) + " million ";
        } else {
            str2 = "";
        }
        String str4 = str + str2;
        if (parseInt3 == 0) {
            str3 = "";
        } else if (parseInt3 != 1) {
            str3 = a(parseInt3) + " thousand ";
        } else {
            str3 = "one thousand ";
        }
        return ((str4 + str3) + a(parseInt4)).replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }
}
