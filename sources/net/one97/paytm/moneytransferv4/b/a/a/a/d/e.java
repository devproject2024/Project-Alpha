package net.one97.paytm.moneytransferv4.b.a.a.a.d;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.android.volley.VolleyError;
import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;
import net.one97.paytm.moneytransfer.model.c;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.passbook.b.a.a;

public final class e extends ai {

    /* renamed from: a  reason: collision with root package name */
    UpiProfileDefaultBank f55268a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public final y<c<BaseUpiResponse>> f55269b = new y<>();
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public final y<BaseUpiResponse> f55270c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    final net.one97.paytm.upi.passbook.b.a.a f55271d;

    public e(net.one97.paytm.upi.passbook.b.a.a aVar) {
        k.c(aVar, "upiPassbookRepository");
        this.f55271d = aVar;
    }

    public static final class b implements a.C1379a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f55273a;

        b(e eVar) {
            this.f55273a = eVar;
        }

        public final void a(UpiBaseDataModel upiBaseDataModel) {
            if (upiBaseDataModel instanceof BaseUpiResponse) {
                y a2 = this.f55273a.f55269b;
                c.a aVar = c.f54031e;
                a2.setValue(c.a.a(upiBaseDataModel));
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "error");
            y a2 = this.f55273a.f55269b;
            c.a aVar = c.f54031e;
            a2.setValue(c.a.a(upiCustomVolleyError));
        }
    }

    public static final class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f55272a;

        a(e eVar) {
            this.f55272a = eVar;
        }

        public final void a(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof BaseUpiResponse) {
                this.f55272a.f55270c.setValue(upiBaseDataModel);
            }
        }

        public final void a(VolleyError volleyError) {
            k.c(volleyError, "error");
            this.f55272a.f55270c.setValue(null);
        }
    }
}
