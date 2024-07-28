package net.one97.paytm.upi.util;

import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppUtility;

public class UPIEnglishNumberToWords {
    public static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static final String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    public static String convert(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (str.indexOf(AppUtility.CENTER_DOT) == -1) {
            return convert(Long.parseLong(str));
        }
        String substring = str.substring(0, str.indexOf(AppUtility.CENTER_DOT));
        String substring2 = str.substring(str.indexOf(AppUtility.CENTER_DOT));
        String convert = !TextUtils.isEmpty(substring) ? convert(Long.parseLong(substring)) : str2;
        if (!AppUtility.CENTER_DOT.equalsIgnoreCase(substring2) && !TextUtils.isEmpty(substring2)) {
            String substring3 = substring2.substring(substring2.indexOf(AppUtility.CENTER_DOT) + 1);
            if (substring3.length() == 1) {
                substring3 = substring3 + "0";
            }
            str2 = convertAfterDecimalValue(Long.parseLong(substring3));
            if (!TextUtils.isEmpty(str2)) {
                str2 = "and " + str2 + " Paise";
            }
        }
        if (str2.length() == 0) {
            return convert;
        }
        return convert + " " + str2;
    }

    public static String convert(long j) {
        if (j < 0) {
            return "Minus " + convert(-j);
        } else if (j < 20) {
            return units[(int) j];
        } else {
            String str = " ";
            if (j < 100) {
                StringBuilder sb = new StringBuilder();
                sb.append(tens[(int) (j / 10)]);
                long j2 = j % 10;
                if (j2 == 0) {
                    str = "";
                }
                sb.append(str);
                sb.append(units[(int) j2]);
                return sb.toString();
            } else if (j < 1000) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(units[(int) (j / 100)]);
                sb2.append(" Hundred");
                long j3 = j % 100;
                if (j3 == 0) {
                    str = "";
                }
                sb2.append(str);
                sb2.append(convert(j3));
                return sb2.toString();
            } else if (j < 100000) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(convert(j / 1000));
                sb3.append(" Thousand");
                if (j % 10000 == 0) {
                    str = "";
                }
                sb3.append(str);
                sb3.append(convert(j % 1000));
                return sb3.toString();
            } else if (j < 10000000) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(convert(j / 100000));
                sb4.append(" Lakh");
                long j4 = j % 100000;
                if (j4 == 0) {
                    str = "";
                }
                sb4.append(str);
                sb4.append(convert(j4));
                return sb4.toString();
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(convert(j / 10000000));
                sb5.append(" Crore");
                sb5.append(convert(j % 10000000));
                return sb5.toString();
            }
        }
    }

    public static String convertAfterDecimalValue(long j) {
        if (j < 0) {
            return "Minus " + convert(-j);
        } else if (j < 20) {
            return units[(int) j];
        } else {
            if (j < 100) {
                StringBuilder sb = new StringBuilder();
                sb.append(tens[(int) (j / 10)]);
                long j2 = j % 10;
                sb.append(j2 != 0 ? " " : "");
                sb.append(units[(int) j2]);
                return sb.toString();
            }
            return units[(int) (j / 100)] + " Hundred" + convert(j % 100);
        }
    }
}
