package net.one97.paytm.transport.iocl.b;

import android.content.Context;
import com.paytm.utility.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f14280a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Context context, Object obj, Object obj2, Object obj3, Object obj4) {
            k.c(context, "context");
            k.c(obj, "eventCategory");
            k.c(obj2, "eventAction");
            k.c(obj3, SDKConstants.EVENT_KEY_SCREEN_NAME);
            k.c(obj4, "label");
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("event_category", obj);
                hashMap.put("event_action", obj2);
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, obj3);
                hashMap.put("event_label", obj4);
                Map map = hashMap;
                String n = b.n(context) != null ? b.n(context) : "";
                k.a((Object) n, "if (CJRAppCommonUtility.…etUserId(context) else \"\"");
                map.put("user_id", n);
                hashMap.put("vertical_name", "iocl_xtrarewards");
                net.one97.paytm.transport.iocl.a.c().sendCustomRechargeEvent(hashMap, context);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
