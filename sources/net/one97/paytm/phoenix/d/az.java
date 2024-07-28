package net.one97.paytm.phoenix.d;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.core.a;
import net.one97.paytm.phoenix.util.j;

public final class az extends a {
    public az() {
        super("getTitleAndStatusBarHeight", "getTitleAndStatusbarHeight");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        View decorView;
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        j jVar = j.f59646a;
        j.a("PhoenixAlertPlugin", "handleEvent");
        if (h5Event.getActivity() == null) {
            a(h5Event, net.one97.paytm.phoenix.api.a.NOT_FOUND, "Couldn't find activity");
        }
        Rect rect = new Rect();
        Activity activity = h5Event.getActivity();
        if (activity == null) {
            k.a();
        }
        Window window = activity.getWindow();
        if (!(window == null || (decorView = window.getDecorView()) == null)) {
            decorView.getWindowVisibleDisplayFrame(rect);
        }
        int i2 = rect.top;
        int i3 = 0;
        if (i2 == 0) {
            k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
            Activity activity2 = h5Event.getActivity();
            if (activity2 == null) {
                k.a();
            }
            int identifier = activity2.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                Activity activity3 = h5Event.getActivity();
                if (activity3 == null) {
                    k.a();
                }
                i2 = activity3.getResources().getDimensionPixelSize(identifier);
            } else {
                i2 = 0;
            }
        }
        TypedValue typedValue = new TypedValue();
        Activity activity4 = h5Event.getActivity();
        if (activity4 != null) {
            if (activity4.getTheme().resolveAttribute(16843499, typedValue, true)) {
                int i4 = typedValue.data;
                Activity activity5 = h5Event.getActivity();
                if (activity5 == null) {
                    k.a();
                }
                Resources resources = activity5.getResources();
                k.a((Object) resources, "event.getActivity()!!.resources");
                i3 = TypedValue.complexToDimensionPixelSize(i4, resources.getDisplayMetrics());
            }
            Activity activity6 = h5Event.getActivity();
            if (activity6 == null) {
                k.a();
            }
            Resources resources2 = activity6.getResources();
            k.a((Object) resources2, "event.getActivity()!!.resources");
            int a2 = kotlin.h.a.a(resources2.getDisplayMetrics().density);
            a("density", (Object) Integer.valueOf(a2));
            a("titleBarHeight", (Object) Integer.valueOf(i3 / a2));
            a("statusBarHeight", (Object) Integer.valueOf(i2 / a2));
            a.a(this, h5Event, (Object) null, true, 2);
            return true;
        }
        throw new u("null cannot be cast to non-null type android.app.Activity");
    }
}
