package net.one97.paytm.paymentsBank.slfd.b.a;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class a {
    public static final String a(String str) {
        k.c(str, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
        try {
            String format = new SimpleDateFormat("dd MMM yyyy").format(Long.valueOf(Long.parseLong(str)));
            k.a((Object) format, "to.format(dateLong)");
            return format;
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static final double a(Double d2, Double d3) {
        if (d3 == null || d2 == null) {
            return 0.0d;
        }
        double doubleValue = d3.doubleValue() - d2.doubleValue();
        if (doubleValue > 0.0d) {
            doubleValue = ((double) Math.round(doubleValue * 100.0d)) / 100.0d;
        }
        if (doubleValue < 0.0d) {
            return 0.0d;
        }
        return doubleValue;
    }

    public static final String a(String str, String str2, long j) {
        k.c(str, "fromFormat");
        k.c(str2, "toFormat");
        try {
            Calendar instance = Calendar.getInstance();
            Date date = new Date(j);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
            k.a((Object) instance, "now");
            simpleDateFormat.setTimeZone(instance.getTimeZone());
            String format = simpleDateFormat.format(date);
            k.a((Object) format, "format.format(date)");
            return format;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
