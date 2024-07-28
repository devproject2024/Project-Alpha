package com.travel.utils;

import com.travel.d;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static final a f28549a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(String str, String str2, String str3) {
            HashMap hashMap = new HashMap();
            if (str2 != null) {
                hashMap.put("event_label1", str2);
            }
            if (str2 != null) {
                Map map = hashMap;
                if (str3 != null) {
                    map.put("event_label2", str3);
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.Any");
                }
            }
            k.a((Object) d.a(), "TravelController.getInstance()");
            d.b().a("custom-event", "Travel Homepage", "travel_cross_category", str, (HashMap<String, Object>) hashMap);
        }
    }
}
