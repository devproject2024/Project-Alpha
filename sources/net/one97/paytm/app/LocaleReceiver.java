package net.one97.paytm.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.paytm.utility.b;
import com.paytm.utility.n;
import com.paytm.utility.q;
import net.one97.paytm.utils.l;

public class LocaleReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            if (b.j(Resources.getSystem().getConfiguration().locale.getLanguage())) {
                l.a(context);
            } else {
                n.b(context.getApplicationContext(), n.a(context.getApplicationContext(), n.a()));
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }
}
