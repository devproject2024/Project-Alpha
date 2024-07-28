package net.one97.paytm.passbook.landing.e;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.passbook.beans.CustProductList;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.a.f;
import net.one97.paytm.passbook.utility.q;

public final class x extends a {

    /* renamed from: a  reason: collision with root package name */
    public String f57697a;

    /* renamed from: b  reason: collision with root package name */
    public f<? extends CustProductList> f57698b;

    public x(f<? extends CustProductList> fVar) {
        k.c(fVar, Payload.RESPONSE);
        this.f57698b = fVar;
    }

    public static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f57699a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CustProductList f57700b;

        public a(x xVar, CustProductList custProductList) {
            this.f57699a = xVar;
            this.f57700b = custProductList;
        }

        public final void onClick(View view) {
            CustProductList custProductList = this.f57700b;
            k.a((Object) view, "it");
            String str = null;
            String isaStatus = custProductList != null ? custProductList.getIsaStatus() : null;
            if (isaStatus != null) {
                if (k.a((Object) isaStatus, (Object) "FAILED") || k.a((Object) isaStatus, (Object) "IN_PROGRESS") || k.a((Object) isaStatus, (Object) "INITIATED") || k.a((Object) isaStatus, (Object) "PENDING")) {
                    str = "paytmmp://payment_bank?featuretype=open_acc_base" + "&extraDefaultFrame=6";
                } else if (k.a((Object) isaStatus, (Object) "NOT_APPLIED") || k.a((Object) isaStatus, (Object) "LEAD")) {
                    str = "paytmmp://payment_bank?featuretype=open_acc_base" + "&extraDefaultFrame=3";
                }
                net.one97.paytm.passbook.mapping.f b2 = d.b();
                Context context = view.getContext();
                if (context != null) {
                    b2.a(str, (Activity) context);
                } else {
                    throw new u("null cannot be cast to non-null type android.app.Activity");
                }
            }
            q.a(view.getContext(), "uth_passbook", "SA_clicked", "open_account", (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.passbook.landing.d.a f57701a;

        public b(net.one97.paytm.passbook.landing.d.a aVar) {
            this.f57701a = aVar;
        }

        public final void onClick(View view) {
            this.f57701a.b();
            k.a((Object) view, "it");
            q.a(view.getContext(), "uth_passbook", "Check_bal_item_clicked", "SA_PPBL", (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.passbook.landing.d.a f57702a;

        public c(net.one97.paytm.passbook.landing.d.a aVar) {
            this.f57702a = aVar;
        }

        public final void onClick(View view) {
            this.f57702a.b();
            k.a((Object) view, "it");
            q.a(view.getContext(), "uth_passbook", "Check_bal_item_clicked", "SA_FD_PPBL", (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
        }
    }
}
