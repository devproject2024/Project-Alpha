package net.one97.paytm.h5.b;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.utility.h;
import kotlin.g.b.k;
import net.one97.paytm.auth.b.b;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.h5paytmsdk.c.ac;

public final class t implements ac {
    public final void a(Activity activity) {
        k.c(activity, "activity");
        b.b(activity);
        h hVar = new h(activity);
        hVar.setTitle("Session Time Out");
        hVar.a("You've been logged out of Paytm. Don't worry, just login again to continue");
        hVar.setCancelable(false);
        hVar.a(-3, Payload.RESPONSE_OK, new a(hVar, activity));
        hVar.show();
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f16937a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f16938b;

        a(h hVar, Activity activity) {
            this.f16937a = hVar;
            this.f16938b = activity;
        }

        public final void onClick(View view) {
            this.f16937a.cancel();
            h.a aVar = net.one97.paytm.deeplink.h.f50349a;
            h.a.a(this.f16938b, "paytmmp://login?screen=signOutLogin", (Bundle) null);
        }
    }
}
