package net.one97.paytm.h5;

import android.app.Activity;
import android.os.Bundle;
import kotlin.g.b.k;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.deeplink.q;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f50535a = new a();

    private a() {
    }

    public static void a(Activity activity, Bundle bundle, String str) {
        k.c(activity, "activity");
        k.c(bundle, "bundle");
        k.c(str, "target");
        q qVar = q.f50365a;
        k.c(activity, "activity");
        k.c(str, "target");
        if (bundle == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("isFromH5", true);
            bundle2.putString("target", str);
            q.b(activity, (DeepLinkData) null, bundle2);
        }
        if (bundle != null) {
            bundle.putBoolean("isFromH5", true);
            bundle.putString("target", str);
            q.b(activity, (DeepLinkData) null, bundle);
        }
    }
}
