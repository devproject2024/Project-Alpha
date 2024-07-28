package net.one97.paytmflight.a;

import android.app.Activity;
import android.content.Intent;
import com.paytm.utility.n;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

@Deprecated
public final class a {
    public static String a(String str, String str2, String str3) {
        try {
            return new SimpleDateFormat(str3).format(new SimpleDateFormat(str2, new Locale(n.a())).parse(str));
        } catch (Exception | ParseException unused) {
            return "";
        }
    }

    public static void a(Activity activity) {
        if (activity != null) {
            n.b(activity.getApplicationContext(), n.a(activity.getApplicationContext(), n.a()));
            Intent intent = new Intent();
            intent.setClassName(activity.getApplicationContext().getPackageName(), "net.one97.paytm.landingpage.activity.AJRMainActivity");
            intent.addFlags(67108864);
            intent.addFlags(268435456);
            intent.putExtra("CLEAR_MOBILE_DATA", true);
            intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "featured");
            intent.putExtra("resultant fragment position", 0);
            intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
            activity.startActivity(intent);
            activity.finish();
        }
    }
}
