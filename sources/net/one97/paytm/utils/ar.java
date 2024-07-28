package net.one97.paytm.utils;

import android.content.Context;
import android.content.Intent;
import java.util.HashMap;
import java.util.Hashtable;
import net.one97.paytm.deeplink.z;
import net.one97.paytm.dynamic.module.movie.EventsModuleManager;

public final class ar {
    public static Intent a(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("extra_url_type", "movietickets");
        return z.a(context, "net.one97.paytm.o2o.movies.activity.MoviesHomeActivity", hashMap);
    }

    public static void a(String str) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("L0_id", "L0_BK");
        hashtable.put("L0_name", "Booking");
        hashtable.put("L1_id", "L1_BK_O2O");
        hashtable.put("L1_name", "O2O");
        if ("movies".equalsIgnoreCase(str)) {
            hashtable.put("L2_id", "L2_BK_70");
            hashtable.put("L2_name", "Movies");
        } else if (EventsModuleManager.MODULE_NAME.equalsIgnoreCase(str)) {
            hashtable.put("L2_id", "L2_BK_73");
            hashtable.put("L2_name", "Events");
        } else if ("amusement".equalsIgnoreCase(str)) {
            hashtable.put("L2_id", "L2_BK_74");
            hashtable.put("L2_name", "Amusements");
        } else if ("giftcards".equalsIgnoreCase(str)) {
            hashtable.put("L2_id", "L2_BK_81");
            hashtable.put("L2_name", "Gift Card");
        } else if ("deals".equalsIgnoreCase(str)) {
            hashtable.put("L2_id", "L2_BK_66");
            hashtable.put("L2_name", "Deals");
        }
    }
}
