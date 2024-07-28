package net.one97.paytm.transport.iocl_v1.b;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class a {
    public static String a(String str) {
        return new SimpleDateFormat(str).format(Calendar.getInstance().getTime());
    }
}
