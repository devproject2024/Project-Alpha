package net.one97.paytm.paymentsBank.si.f;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;

public interface a {

    /* renamed from: net.one97.paytm.paymentsBank.si.f.a$a  reason: collision with other inner class name */
    public interface C0325a {
        void a(IJRPaytmDataModel iJRPaytmDataModel);

        void a(NetworkCustomError networkCustomError);
    }

    public interface b {
        void a();
    }

    void a(C0325a aVar, String str, String str2, boolean z);

    void a(C0325a aVar, b bVar, int i2, int i3);
}
