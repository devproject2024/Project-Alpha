package net.one97.paytm.upi.mandate.e;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.appsflyer.internal.referrer.Payload;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.mandate.data.b;
import net.one97.paytm.upi.mandate.data.model.MandateTimeLineItem;
import net.one97.paytm.upi.mandate.data.model.MandateTimeLineResponse;
import net.one97.paytm.upi.mandate.utils.c;
import net.one97.paytm.upi.mandate.utils.r;
import net.one97.paytm.upi.mandate.utils.t;
import net.one97.paytm.upi.mandate.utils.u;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiUtils;

public final class d extends androidx.lifecycle.a {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public final y<r<List<MandateTimeLineItem>>> f67171a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    private final b f67172b;

    /* renamed from: c  reason: collision with root package name */
    private final Application f67173c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Application application) {
        super(application);
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        this.f67173c = application;
        b a2 = g.a((Context) this.f67173c);
        k.a((Object) a2, "Injection.provideUpiMandateRepository(app)");
        this.f67172b = a2;
    }

    public final void a(String str) {
        k.c(str, "umn");
        if (UpiAppUtils.isNetworkAvailable(this.f67173c)) {
            this.f67171a.setValue(new r(u.LOADING, (Object) null, (t) null, false, 14));
            this.f67172b.a(str, (b.a) new a(this));
            return;
        }
        this.f67171a.setValue(new r(u.ERROR, (Object) null, t.i.f67428a, false, 10));
    }

    public static final class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f67174a;

        a(d dVar) {
            this.f67174a = dVar;
        }

        public final void a(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof MandateTimeLineResponse) {
                MandateTimeLineResponse mandateTimeLineResponse = (MandateTimeLineResponse) upiBaseDataModel;
                if (c.FAILURE.equals(mandateTimeLineResponse.getStatus())) {
                    this.f67174a.f67171a.setValue(new r(u.ERROR, (Object) null, new t.a(mandateTimeLineResponse.getResponseCode()), false, 10));
                } else if (mandateTimeLineResponse.getTimeLine() != null) {
                    this.f67174a.f67171a.setValue(new r(u.SUCCESS, mandateTimeLineResponse.getTimeLine(), (t) null, false, 12));
                } else {
                    this.f67174a.f67171a.setValue(new r(u.ERROR, (Object) null, t.g.f67426a, false, 10));
                }
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            if (UpiUtils.isAuthenticationFailure(upiCustomVolleyError != null ? upiCustomVolleyError.getmErrorCode() : null)) {
                this.f67174a.f67171a.setValue(new r(u.ERROR, (Object) null, t.j.f67429a, false, 10));
            } else {
                this.f67174a.f67171a.setValue(new r(u.ERROR, (Object) null, t.g.f67426a, false, 10));
            }
        }
    }
}
