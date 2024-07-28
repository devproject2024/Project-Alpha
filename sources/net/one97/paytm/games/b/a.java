package net.one97.paytm.games.b;

import net.one97.paytm.games.e.a.d;
import net.one97.paytm.games.e.f;
import net.one97.paytm.games.e.g;
import net.one97.paytm.games.e.i;
import net.one97.paytm.games.model.GpTasksListResponse;
import net.one97.paytm.games.model.core.CJRSignupUser;

public final class a {
    public static CJRSignupUser a() {
        com.paytm.b.a.a a2 = i.a(g.a().b());
        String b2 = a2.b("gamepind_cas_masked_msisdn_1", "", true);
        if (f.a((Object) b2)) {
            return null;
        }
        CJRSignupUser cJRSignupUser = new CJRSignupUser();
        cJRSignupUser.masked_msisdn = b2;
        cJRSignupUser.user_id = a2.b("gamepind_cas_user_id_1", "", true);
        cJRSignupUser.customer_id = a2.b("gamepind_cas_customer_id_1", "", true);
        cJRSignupUser.access_token = a2.b("gamepind_cas_access_token_1", "", true);
        return cJRSignupUser;
    }

    public static void a(CJRSignupUser cJRSignupUser) {
        String str;
        String str2;
        String str3;
        if (cJRSignupUser != null) {
            String gtmString = g.a().c().getGtmString("gamepind_cms_client");
            if (!f.a((Object) gtmString)) {
                d dVar = d.f35594a;
                CJRSignupUser cJRSignupUser2 = (CJRSignupUser) d.a(gtmString, CJRSignupUser.class);
                if (cJRSignupUser2 != null && !f.a((Object) cJRSignupUser2.access_token)) {
                    cJRSignupUser = cJRSignupUser2;
                }
            }
        }
        com.paytm.b.a.a a2 = i.a(g.a().b());
        String str4 = "";
        if (cJRSignupUser == null) {
            str = str4;
        } else {
            str = cJRSignupUser.user_id;
        }
        a2.a("gamepind_cas_user_id_1", str, true);
        if (cJRSignupUser == null) {
            str2 = str4;
        } else {
            str2 = cJRSignupUser.masked_msisdn;
        }
        a2.a("gamepind_cas_masked_msisdn_1", str2, true);
        if (cJRSignupUser == null) {
            str3 = str4;
        } else {
            str3 = cJRSignupUser.customer_id;
        }
        a2.a("gamepind_cas_customer_id_1", str3, true);
        if (cJRSignupUser != null) {
            str4 = cJRSignupUser.access_token;
        }
        a2.a("gamepind_cas_access_token_1", str4, true);
    }

    public static void a(GpTasksListResponse.GpTask gpTask) {
        String str;
        com.paytm.b.a.a a2 = i.a(g.a().b());
        if (gpTask == null) {
            str = "";
        } else {
            d dVar = d.f35594a;
            str = d.a(gpTask);
        }
        a2.a("gamepind_signup_popup_shown_data_1", str, true);
    }

    public static GpTasksListResponse.GpTask b() {
        String b2 = i.a(g.a().b()).b("gamepind_signup_popup_shown_data_1", "", true);
        if (f.a((Object) b2)) {
            return null;
        }
        d dVar = d.f35594a;
        return (GpTasksListResponse.GpTask) d.a(b2, GpTasksListResponse.GpTask.class);
    }

    public static void a(Long l) {
        i.a(g.a().b()).a("gamepind_popup_time_1", l.longValue(), true);
    }

    public static Long c() {
        return Long.valueOf(i.a(g.a().b()).b("gamepind_popup_time_1", 0, true));
    }
}
