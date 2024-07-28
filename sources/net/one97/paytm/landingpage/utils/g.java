package net.one97.paytm.landingpage.utils;

import android.content.Context;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.b.d;

public final class g {
    public static void a(Context context, String str, String str2, String str3) {
        try {
            new HashMap();
            d.a().a(context, str, str2, str3, "/", "homescreen");
        } catch (Exception e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    public static void a(Context context, Map<String, Object> map) {
        d.b().a("top_nav_clicked", map, context);
    }
}
