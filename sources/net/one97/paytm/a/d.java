package net.one97.paytm.a;

import android.app.Activity;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.k;
import kotlin.o;
import net.one97.paytm.AJREmbedWebView;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.auth.b.b;
import net.one97.paytm.h.a;

public final class d implements a {
    public final Map<a.C0908a, Class<? extends Activity>> a() {
        return ae.a((o<? extends K, ? extends V>[]) new o[]{new o(a.C0908a.AuthActivity, AJRAuthActivity.class), new o(a.C0908a.WebViewActivity, AJREmbedWebView.class)});
    }

    public final void a(Activity activity) {
        k.c(activity, "activity");
        b.a(activity, false);
    }
}
