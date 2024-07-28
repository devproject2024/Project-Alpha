package com.travel.flight.flightSRPV2.c;

import android.content.Context;
import com.paytm.utility.b;
import com.travel.flight.flightticket.widget.DiscreteRangeSeekBarFlight;
import com.travel.flight.pojo.flightticket.CJRDiscountedStrip;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.k;
import kotlin.m.p;

public final class d {
    public static final <T extends Number> DiscreteRangeSeekBarFlight<T> a(T t, T t2, T t3, Context context) {
        k.c(t, "min");
        k.c(t2, "max");
        k.c(t3, "step");
        k.c(context, "context");
        DiscreteRangeSeekBarFlight<T> discreteRangeSeekBarFlight = new DiscreteRangeSeekBarFlight<>(t, t2, t3, context);
        discreteRangeSeekBarFlight.setMaxHeight(b.c(3));
        discreteRangeSeekBarFlight.setMinimumHeight(b.c(3));
        discreteRangeSeekBarFlight.setPadding(0, 0, b.c(20), 0);
        discreteRangeSeekBarFlight.setNotifyWhileDragging(true);
        return discreteRangeSeekBarFlight;
    }

    public static final boolean a(String str, String str2) {
        long j;
        if (!(str == null || str2 == null)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            try {
                Date parse = simpleDateFormat.parse(str);
                k.a((Object) parse, "dateFormat.parse(onwardDate)");
                Date parse2 = simpleDateFormat.parse(str2);
                k.a((Object) parse2, "dateFormat.parse(returnDate)");
                TimeUnit timeUnit = TimeUnit.DAYS;
                k.c(parse, "startDate");
                k.c(parse2, "endDate");
                k.c(timeUnit, "unit");
                j = timeUnit.convert(parse2.getTime() - parse.getTime(), TimeUnit.MILLISECONDS);
            } catch (ParseException unused) {
                j = 0;
            }
            if (j > 0) {
                return true;
            }
        }
        return false;
    }

    public static final boolean a(String str) {
        if (str != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Calendar instance = Calendar.getInstance();
            k.a((Object) instance, "Calendar.getInstance()");
            Date time = instance.getTime();
            try {
                Date parse = simpleDateFormat.parse(str);
                k.a((Object) parse, "dateFormat.parse(date)");
                if (parse.compareTo(time) > 0) {
                    return true;
                }
            } catch (ParseException unused) {
            }
        }
        return false;
    }

    public static final String a(String str, ArrayList<CJRDiscountedStrip> arrayList) {
        if (!(str == null || arrayList == null)) {
            Iterator<CJRDiscountedStrip> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                CJRDiscountedStrip next = it2.next();
                k.a((Object) next, "discountedStrip");
                if (p.a(str, next.getAirlineCode(), true)) {
                    String combinedFlightId = next.getCombinedFlightId();
                    k.a((Object) combinedFlightId, "discountedStrip.combinedFlightId");
                    return combinedFlightId;
                }
            }
        }
        return "";
    }
}
