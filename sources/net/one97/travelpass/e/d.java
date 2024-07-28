package net.one97.travelpass.e;

import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f30331a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static /* synthetic */ void a(String str, String str2, String str3, String str4, String str5, String str6, int i2) {
            if ((i2 & 8) != 0) {
                str4 = "";
            }
            a(str, str2, str3, str4, (i2 & 16) != 0 ? null : str5, (String) null, (i2 & 64) != 0 ? null : str6);
        }

        public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            HashMap hashMap = new HashMap();
            CharSequence charSequence = str5;
            boolean z = false;
            if (!(charSequence == null || charSequence.length() == 0)) {
                Map map = hashMap;
                if (str5 != null) {
                    map.put("event_label1", str5);
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.Any");
                }
            }
            CharSequence charSequence2 = str6;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                Map map2 = hashMap;
                if (str6 != null) {
                    map2.put("event_label2", str6);
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.Any");
                }
            }
            CharSequence charSequence3 = str7;
            if (charSequence3 == null || charSequence3.length() == 0) {
                z = true;
            }
            if (!z) {
                Map map3 = hashMap;
                if (str7 != null) {
                    map3.put("event_label3", str7);
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.Any");
                }
            }
            k.a((Object) net.one97.travelpass.d.a(), "TravelPassController.getInstance()");
            net.one97.travelpass.d.b().a(str, str2, str3, str4, hashMap);
        }

        public static void a(String str) {
            k.c(str, "verticalType");
            a("custom-event", "/travel-pass/home", "travel_pass_home", "buttons_clicked", str, (String) null, 96);
        }

        public static void b(String str) {
            k.c(str, "verticalType");
            a("custom-event", "/travel-pass/details", "travel_pass_pdp", "buttons_clicked", str, (String) null, 96);
        }
    }
}
