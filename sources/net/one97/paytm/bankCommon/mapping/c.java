package net.one97.paytm.bankCommon.mapping;

import android.content.Context;
import java.util.Map;
import net.one97.paytm.bankOpen.f;

public final class c {
    public static void a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        f.b().sendCustomGTMEvents(context, str, str2, str3, str4, str5, str6);
    }

    public static void a(String str, String str2, Context context) {
        f.b().sendOpenScreenWithDeviceInfo(str, str2, context);
    }

    public static void a(String str, Map<String, Object> map, Context context) {
        f.b().sendCustomEventWithMap(str, map, context);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        f.b().sendNewCustomGTMEvents(context, str, str2, str3, str4, str5, str6, str7);
    }
}
