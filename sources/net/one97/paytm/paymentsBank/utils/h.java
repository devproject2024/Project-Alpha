package net.one97.paytm.paymentsBank.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.paytm.utility.b;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankOpen.R;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f19510a = new h();

    private h() {
    }

    public static void a(f fVar, Activity activity) {
        k.c(fVar, "request");
        k.c(activity, "activity");
        if (!activity.isFinishing()) {
            com.paytm.utility.h hVar = new com.paytm.utility.h(activity);
            hVar.setTitle(activity.getResources().getString(R.string.no_connection));
            hVar.a(activity.getResources().getString(R.string.no_internet));
            hVar.a(-3, activity.getResources().getString(R.string.network_retry_yes), new a(hVar, activity, fVar));
            hVar.show();
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.paytm.utility.h f19511a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f19512b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f f19513c;

        a(com.paytm.utility.h hVar, Activity activity, f fVar) {
            this.f19511a = hVar;
            this.f19512b = activity;
            this.f19513c = fVar;
        }

        public final void onClick(View view) {
            this.f19511a.cancel();
            if (b.c((Context) this.f19512b)) {
                this.f19512b.getApplicationContext();
                c.a();
                c.a(this.f19513c);
                return;
            }
            h hVar = h.f19510a;
            h.a(this.f19513c, this.f19512b);
        }
    }
}
