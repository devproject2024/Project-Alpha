package net.one97.paytm.paymentsBank.slfd.timeline.a;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;

public interface a {

    /* renamed from: net.one97.paytm.paymentsBank.slfd.timeline.a.a$a  reason: collision with other inner class name */
    public interface C0344a extends net.one97.paytm.paymentsBank.slfd.a {
        void a(Double d2);

        void a(String str);

        void c();
    }

    public interface b extends net.one97.paytm.paymentsBank.slfd.b<C0344a> {
        void a();

        void a(IJRPaytmDataModel iJRPaytmDataModel);

        void a(NetworkCustomError networkCustomError);

        void a(String str);

        void a(String str, Double d2);

        void ak_();

        void b();

        void b(IJRPaytmDataModel iJRPaytmDataModel);

        void b(String str);

        void c(String str);
    }
}
