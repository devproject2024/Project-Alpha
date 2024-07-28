package common.landing.b;

import com.paytm.network.model.NetworkCustomError;
import common.landing.a.a;
import net.one97.paytm.common.entity.insurance.InsuranceBuyPayOptionModel;

public interface a {

    /* renamed from: common.landing.b.a$a  reason: collision with other inner class name */
    public interface C0181a {
        void a();

        void a(int i2);

        void a(a.C0178a aVar, int i2);

        int b();
    }

    public interface b extends net.one97.paytm.insurance.a {
        void a();

        void a(NetworkCustomError networkCustomError);

        void a(String str);

        void a(InsuranceBuyPayOptionModel insuranceBuyPayOptionModel);

        void b(String str);
    }
}
