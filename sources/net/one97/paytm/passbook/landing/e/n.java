package net.one97.paytm.passbook.landing.e;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.genericPassbook.b;
import net.one97.paytm.passbook.main.widget.PassbookBalanceCardView;
import net.one97.paytm.passbook.mapping.f;

public final class n extends a {

    /* renamed from: a  reason: collision with root package name */
    public final b<IJRPaytmDataModel> f57668a;

    public n(b<? extends IJRPaytmDataModel> bVar) {
        k.c(bVar, Payload.RESPONSE);
        this.f57668a = bVar;
    }

    public static void a(PassbookBalanceCardView passbookBalanceCardView, String str) {
        double d2;
        passbookBalanceCardView.setVisibility(0);
        passbookBalanceCardView.setTitle(R.string.pfg_balance_display_name);
        passbookBalanceCardView.setIcon(R.drawable.pass_ic_pfg_wallet);
        if (str == null) {
            try {
                k.a();
            } catch (Exception unused) {
                d2 = Double.parseDouble("0");
            }
        }
        String a2 = p.a(str, AppConstants.COMMA, "", false);
        if (a2 != null) {
            d2 = Double.parseDouble(p.b(a2).toString());
            if (d2 > 0.0d) {
                passbookBalanceCardView.setAmount(d2);
                passbookBalanceCardView.a(false);
                passbookBalanceCardView.b(true);
            } else {
                passbookBalanceCardView.a(true);
                passbookBalanceCardView.b(false);
            }
            passbookBalanceCardView.setOnClickListener(new a(passbookBalanceCardView));
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PassbookBalanceCardView f57669a;

        a(PassbookBalanceCardView passbookBalanceCardView) {
            this.f57669a = passbookBalanceCardView;
        }

        public final void onClick(View view) {
            if (this.f57669a.getContext() instanceof Activity) {
                f b2 = d.b();
                Context context = this.f57669a.getContext();
                if (context != null) {
                    b2.a("paytmmp://pfgPassbook?source=passbook", (Activity) context);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.app.Activity");
            }
        }
    }
}
