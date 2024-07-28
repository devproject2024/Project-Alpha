package net.one97.paytm.upi.requestmoney.a;

import net.one97.paytm.upi.c;
import net.one97.paytm.upi.common.ConsolidatePaymentInstrumentationRes;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.d;

public interface b {

    public interface a extends c {
        void a(String str);
    }

    /* renamed from: net.one97.paytm.upi.requestmoney.a.b$b  reason: collision with other inner class name */
    public interface C1400b extends d<a> {
        void a();

        void a(ConsolidatePaymentInstrumentationRes.PaymentOptionList paymentOptionList);

        void a(UpiCustomVolleyError upiCustomVolleyError);

        void a(boolean z);
    }
}
