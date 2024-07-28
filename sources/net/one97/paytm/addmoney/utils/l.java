package net.one97.paytm.addmoney.utils;

import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppUtility;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f48998a = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f48999b = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static String a(String str) {
        String str2;
        String str3 = "";
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        if (str.indexOf(AppUtility.CENTER_DOT) == -1) {
            return a(Long.parseLong(str));
        }
        String substring = str.substring(0, str.indexOf(AppUtility.CENTER_DOT));
        String substring2 = str.substring(str.indexOf(AppUtility.CENTER_DOT));
        String a2 = !TextUtils.isEmpty(substring) ? a(Long.parseLong(substring)) : str3;
        if (!AppUtility.CENTER_DOT.equalsIgnoreCase(substring2) && !TextUtils.isEmpty(substring2)) {
            String substring3 = substring2.substring(substring2.indexOf(AppUtility.CENTER_DOT) + 1);
            if (substring3.length() == 1) {
                substring3 = substring3 + "0";
            }
            long parseLong = Long.parseLong(substring3);
            if (parseLong < 0) {
                str2 = "Minus " + a(-parseLong);
            } else if (parseLong < 20) {
                str2 = f48998a[(int) parseLong];
            } else if (parseLong < 100) {
                StringBuilder sb = new StringBuilder();
                sb.append(f48999b[(int) (parseLong / 10)]);
                long j = parseLong % 10;
                if (j != 0) {
                    str3 = " ";
                }
                sb.append(str3);
                sb.append(f48998a[(int) j]);
                str2 = sb.toString();
            } else {
                str2 = f48998a[(int) (parseLong / 100)] + " Hundred" + a(parseLong % 100);
            }
            str3 = str2;
            if (!TextUtils.isEmpty(str3)) {
                str3 = "and " + str3 + " Paise";
            }
        }
        if (str3.length() == 0) {
            return a2;
        }
        return a2 + " " + str3;
    }

    private static String a(long j) {
        if (j < 0) {
            return "Minus " + a(-j);
        } else if (j < 20) {
            return f48998a[(int) j];
        } else {
            String str = " ";
            if (j < 100) {
                StringBuilder sb = new StringBuilder();
                sb.append(f48999b[(int) (j / 10)]);
                long j2 = j % 10;
                if (j2 == 0) {
                    str = "";
                }
                sb.append(str);
                sb.append(f48998a[(int) j2]);
                return sb.toString();
            } else if (j < 1000) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(f48998a[(int) (j / 100)]);
                sb2.append(" Hundred");
                long j3 = j % 100;
                if (j3 == 0) {
                    str = "";
                }
                sb2.append(str);
                sb2.append(a(j3));
                return sb2.toString();
            } else if (j < 100000) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(a(j / 1000));
                sb3.append(" Thousand");
                if (j % 10000 == 0) {
                    str = "";
                }
                sb3.append(str);
                sb3.append(a(j % 1000));
                return sb3.toString();
            } else if (j < 10000000) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(a(j / 100000));
                sb4.append(" Lakh");
                long j4 = j % 100000;
                if (j4 == 0) {
                    str = "";
                }
                sb4.append(str);
                sb4.append(a(j4));
                return sb4.toString();
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(a(j / 10000000));
                sb5.append(" Crore");
                sb5.append(a(j % 10000000));
                return sb5.toString();
            }
        }
    }
}
