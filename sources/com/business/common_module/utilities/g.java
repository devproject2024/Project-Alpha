package com.business.common_module.utilities;

import com.alipay.mobile.h5container.api.H5Param;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f7371a = new g();

    private g() {
    }

    public static String a(String str, String str2) {
        k.d(str, "inputDate");
        k.d(str2, "inputFormat");
        return c(str, str2);
    }

    private static String c(String str, String str2) {
        try {
            Date parse = new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM", Locale.getDefault());
            StringBuilder sb = new StringBuilder();
            k.b(parse, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            k.d(parse, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            sb.append(a(parse));
            sb.append(" ");
            sb.append(simpleDateFormat.format(parse));
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    private static String a(Date date) {
        try {
            int parseInt = Integer.parseInt(new SimpleDateFormat("d", Locale.getDefault()).format(date));
            if (parseInt <= 0 || 31 < parseInt) {
                return "";
            }
            if (11 <= parseInt && 13 >= parseInt) {
                return String.valueOf(parseInt) + "th";
            }
            int i2 = parseInt % 10;
            if (i2 == 1) {
                return String.valueOf(parseInt) + H5Param.SHOW_TITLEBAR;
            } else if (i2 == 2) {
                return String.valueOf(parseInt) + "nd";
            } else if (i2 != 3) {
                return String.valueOf(parseInt) + "th";
            } else {
                return String.valueOf(parseInt) + "rd";
            }
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
            return "";
        }
    }

    public static String a(String str) {
        k.d(str, "outputFormat");
        try {
            Calendar instance = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
            k.b(instance, "calendar");
            String format = simpleDateFormat.format(instance.getTime());
            k.b(format, "dateFormat.format(calendar.time)");
            return format;
        } catch (Exception unused) {
            return "";
        }
    }

    /* access modifiers changed from: private */
    public static String d(String str, String str2) {
        k.d(str, "inputDate");
        k.d(str2, "format");
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.getDefault());
            Date parse = simpleDateFormat.parse(str);
            Calendar instance = Calendar.getInstance();
            k.b(instance, "Calendar.getInstance()");
            instance.setTime(parse);
            instance.add(13, 0);
            instance.add(12, 0);
            instance.add(10, 0);
            instance.add(5, 5);
            instance.add(2, 0);
            instance.add(1, 0);
            String format = simpleDateFormat.format(instance.getTime());
            k.b(format, "dateFormat.format(calendar.time)");
            return format;
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
            return "";
        }
    }
}
