package net.one97.paytm.games.e.a;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f35591a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f35592b = new Object();

    public static String b() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(1, -1);
        return simpleDateFormat.format(instance.getTime());
    }

    public static String a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(5, 1);
        return simpleDateFormat.format(instance.getTime());
    }
}
