package net.one97.paytm.addmoney;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.fragment.app.Fragment;
import net.one97.paytm.addmoney.common.d.a;
import net.one97.paytm.addmoney.common.d.b;

public final class j {
    public static b a(Context context, Fragment fragment) {
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        return b.a((a) net.one97.paytm.addmoney.common.d.a.a.a(context), (a) net.one97.paytm.addmoney.common.d.b.a.a(context, fragment));
    }

    public static net.one97.paytm.addmoney.addmoneysource.c.c.b b(Context context, Fragment fragment) {
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        return net.one97.paytm.addmoney.addmoneysource.c.c.b.a((net.one97.paytm.addmoney.addmoneysource.c.c.a) net.one97.paytm.addmoney.addmoneysource.c.c.a.a.a(context), (net.one97.paytm.addmoney.addmoneysource.c.c.a) net.one97.paytm.addmoney.addmoneysource.c.c.b.a.a(context, fragment));
    }

    public static net.one97.paytm.addmoney.togv.c.a.b a(Context context, Activity activity) {
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        return net.one97.paytm.addmoney.togv.c.a.b.a((net.one97.paytm.addmoney.togv.c.a.a) net.one97.paytm.addmoney.togv.c.a.a.a.a(context, activity), (net.one97.paytm.addmoney.togv.c.a.a) net.one97.paytm.addmoney.togv.c.a.b.a.a(context, activity));
    }
}
