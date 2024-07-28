package net.one97.paytm.passbook.landing.e;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.passbook.beans.goldv2.GoldResponse;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.a.f;
import net.one97.paytm.passbook.utility.q;

public final class h extends a {

    /* renamed from: a  reason: collision with root package name */
    public f<GoldResponse> f57658a;

    public h(f<GoldResponse> fVar) {
        k.c(fVar, Payload.RESPONSE);
        this.f57658a = fVar;
    }

    public static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f57659a;

        public a(h hVar) {
            this.f57659a = hVar;
        }

        public final void onClick(View view) {
            String a2 = d.b().a("passGoldBalanceDeeplink");
            k.a((Object) a2, "deeplink");
            k.a((Object) view, "it");
            Context context = view.getContext();
            if (context != null) {
                h.a(a2, (Activity) context);
                return;
            }
            throw new u("null cannot be cast to non-null type android.app.Activity");
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f57660a;

        public b(h hVar) {
            this.f57660a = hVar;
        }

        public final void onClick(View view) {
            String a2 = d.b().a("passGoldInvestNowDeeplink");
            k.a((Object) a2, "deeplink");
            k.a((Object) view, "it");
            Context context = view.getContext();
            if (context != null) {
                h.a(a2, (Activity) context);
                return;
            }
            throw new u("null cannot be cast to non-null type android.app.Activity");
        }
    }

    public static final /* synthetic */ void a(String str, Activity activity) {
        d.b().a(str, activity);
        q.a(activity, "uth_passbook", "Paytm_gold_clicked", (String) null, (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
    }
}
