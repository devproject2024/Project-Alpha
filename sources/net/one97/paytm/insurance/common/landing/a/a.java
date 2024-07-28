package net.one97.paytm.insurance.common.landing.a;

import com.paytm.network.model.NetworkCustomError;
import common.landing.a.b;
import net.one97.paytm.common.entity.insurance.InsuranceCategoryModel;

public interface a {

    /* renamed from: net.one97.paytm.insurance.common.landing.a.a$a  reason: collision with other inner class name */
    public interface C0193a {
        void a();

        void a(int i2);

        void a(b.a aVar, int i2);

        int b();
    }

    public interface b extends net.one97.paytm.insurance.a {
        void a();

        void a(NetworkCustomError networkCustomError);

        void a(String str);

        void a(InsuranceCategoryModel insuranceCategoryModel);

        Boolean b();

        String c();
    }
}
