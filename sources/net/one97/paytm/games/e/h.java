package net.one97.paytm.games.e;

import android.content.Context;
import android.webkit.JavascriptInterface;
import net.one97.paytm.games.activity.GpBaseActivity;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final String f35622a = h.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private GpBaseActivity f35623b;

    public h(GpBaseActivity gpBaseActivity) {
        this.f35623b = gpBaseActivity;
    }

    @JavascriptInterface
    public void share(String str) {
        f.a((Context) this.f35623b, "Share using", str);
    }
}
