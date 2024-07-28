package net.one97.paytm.k.a;

import android.app.Activity;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class a {
    public static Date a(Activity activity, String str) {
        if (str == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("dd MMMM yy").parse(str);
        } catch (ParseException e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
            b.a(activity, a.class.getName());
            return null;
        }
    }
}
