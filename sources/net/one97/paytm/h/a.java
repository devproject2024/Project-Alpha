package net.one97.paytm.h;

import android.app.Activity;
import java.util.Map;

public interface a {

    /* renamed from: net.one97.paytm.h.a$a  reason: collision with other inner class name */
    public enum C0908a {
        AuthActivity,
        WebViewActivity
    }

    Map<C0908a, Class<? extends Activity>> a();

    void a(Activity activity);
}
