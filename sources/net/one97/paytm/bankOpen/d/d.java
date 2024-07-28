package net.one97.paytm.bankOpen.d;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.paytm.utility.b;
import com.paytm.utility.h;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankOpen.R;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f16427a = new d();

    private d() {
    }

    public static void a(f fVar, Activity activity) {
        k.c(fVar, "request");
        if (activity != null && !activity.isFinishing() && activity.isFinishing()) {
            h hVar = new h(activity);
            hVar.setTitle(activity.getResources().getString(R.string.no_connection));
            hVar.a(activity.getResources().getString(R.string.no_internet));
            hVar.a(-3, activity.getResources().getString(R.string.network_retry_yes), new a(hVar, activity, fVar));
            hVar.show();
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f16428a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f16429b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f f16430c;

        a(h hVar, Activity activity, f fVar) {
            this.f16428a = hVar;
            this.f16429b = activity;
            this.f16430c = fVar;
        }

        public final void onClick(View view) {
            this.f16428a.cancel();
            if (b.c((Context) this.f16429b)) {
                this.f16429b.getApplicationContext();
                c.a();
                c.a(this.f16430c);
                return;
            }
            d dVar = d.f16427a;
            d.a(this.f16430c, this.f16429b);
        }
    }
}
