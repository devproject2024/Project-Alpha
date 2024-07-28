package net.one97.paytm.paymentsBank.slfd.redeemFd;

import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel;

public interface c {

    public interface a extends net.one97.paytm.paymentsBank.slfd.a {
        void a(String str);

        void a(String str, double d2);

        void b(String str);

        void b(String str, double d2);

        void c();
    }

    public interface b extends net.one97.paytm.paymentsBank.slfd.b<a> {
        void a(NetworkCustomError networkCustomError);

        void a(String str);

        void a(String str, Double d2);

        void a(SlfdMetaApiResponseModel slfdMetaApiResponseModel);

        void a(a aVar);

        void b(String str);

        void b(a aVar);

        void c(String str);

        void m();

        void n();

        void o();
    }
}
