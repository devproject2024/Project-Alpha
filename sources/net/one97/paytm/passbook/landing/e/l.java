package net.one97.paytm.passbook.landing.e;

import android.view.View;
import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;
import net.one97.paytm.passbook.beans.CustProductList;
import net.one97.paytm.passbook.mapping.a.f;
import net.one97.paytm.passbook.utility.q;

public final class l extends a {

    /* renamed from: a  reason: collision with root package name */
    public f<? extends CustProductList> f57664a;

    public l(f<? extends CustProductList> fVar) {
        k.c(fVar, Payload.RESPONSE);
        this.f57664a = fVar;
    }

    public static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.passbook.landing.d.a f57665a;

        public a(net.one97.paytm.passbook.landing.d.a aVar) {
            this.f57665a = aVar;
        }

        public final void onClick(View view) {
            this.f57665a.b();
            k.a((Object) view, "it");
            q.a(view.getContext(), "uth_passbook", "Check_bal_item_clicked", "ICA_PPBL", (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.passbook.landing.d.a f57666a;

        public b(net.one97.paytm.passbook.landing.d.a aVar) {
            this.f57666a = aVar;
        }

        public final void onClick(View view) {
            this.f57666a.b();
            k.a((Object) view, "it");
            q.a(view.getContext(), "uth_passbook", "Check_bal_item_clicked", "ICA_FD_PPBL", (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
        }
    }
}
