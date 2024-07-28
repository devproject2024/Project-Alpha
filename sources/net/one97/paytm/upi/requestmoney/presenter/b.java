package net.one97.paytm.upi.requestmoney.presenter;

import net.one97.paytm.upi.common.ConsolidatePaymentInstrumentationRes;
import net.one97.paytm.upi.common.PaymentInstrumentationType;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.requestmoney.a.b;
import net.one97.paytm.upi.requestmoney.b.a.a;
import net.one97.paytm.upi.util.UpiUtils;

public final class b implements b.a, a.C1402a {

    /* renamed from: a  reason: collision with root package name */
    private b.C1400b f69179a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.upi.requestmoney.b.a.b f69180b;

    public final void e() {
    }

    public final void f() {
    }

    public b(b.C1400b bVar, net.one97.paytm.upi.requestmoney.b.a.b bVar2) {
        this.f69179a = bVar;
        this.f69180b = bVar2;
        this.f69179a.a(this);
    }

    public final void a(String str) {
        this.f69179a.a(true);
        this.f69180b.a((a.C1402a) this, str);
    }

    public final void a(UpiBaseDataModel upiBaseDataModel) {
        if (upiBaseDataModel instanceof ConsolidatePaymentInstrumentationRes) {
            ConsolidatePaymentInstrumentationRes consolidatePaymentInstrumentationRes = (ConsolidatePaymentInstrumentationRes) upiBaseDataModel;
            if (consolidatePaymentInstrumentationRes.getGlobalError() != null && consolidatePaymentInstrumentationRes.getGlobalError().getErrorList() != null && consolidatePaymentInstrumentationRes.getGlobalError().getErrorList().size() > 0) {
                this.f69179a.a(false);
                b.C1400b bVar = this.f69179a;
                consolidatePaymentInstrumentationRes.getGlobalError().getErrorList().get(0).getMessage();
                bVar.a();
            } else if (consolidatePaymentInstrumentationRes.getPaymentOptionList() == null || consolidatePaymentInstrumentationRes.getPaymentOptionList().size() <= 0) {
                this.f69179a.a(false);
                this.f69179a.a();
            } else {
                for (ConsolidatePaymentInstrumentationRes.PaymentOptionList next : consolidatePaymentInstrumentationRes.getPaymentOptionList()) {
                    if (next != null && next.getDestinationPayment() != null && next.getDestinationPayment().getPaymentType() != null && next.getDestinationPayment().getPaymentType().equalsIgnoreCase(PaymentInstrumentationType.UPI.name())) {
                        this.f69179a.a(next);
                        return;
                    }
                }
                this.f69179a.a(false);
                this.f69179a.a();
            }
        } else {
            this.f69179a.a(false);
            this.f69179a.a();
        }
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        b.C1400b bVar = this.f69179a;
        if (bVar != null) {
            bVar.a(false);
            if (upiCustomVolleyError == null || !"BT_INV_435".equalsIgnoreCase(upiCustomVolleyError.getmErrorCode())) {
                if (upiCustomVolleyError != null && "BT_ISE_436".equalsIgnoreCase(upiCustomVolleyError.getmErrorCode())) {
                    upiCustomVolleyError.setmErrorCode(UpiUtils.AUTHENTICATION_FAILURE_401);
                }
                this.f69179a.a(upiCustomVolleyError);
                return;
            }
            b.C1400b bVar2 = this.f69179a;
            upiCustomVolleyError.getmErrorCode();
            bVar2.a();
        }
    }
}
