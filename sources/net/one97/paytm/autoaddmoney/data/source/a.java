package net.one97.paytm.autoaddmoney.data.source;

import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import net.one97.paytm.addmoney.common.model.CJRSubscribeAutoAdd;
import net.one97.paytm.addmoney.common.paymethodresponse.HasLowSuccess;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.auth.TncData;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.wallet.newdesign.addmoney.model.CJRSubscribeDisableAutoAdd;
import net.one97.paytm.wallet.newdesign.addmoney.model.CJRSubscribeFetchStatus;

public interface a {

    /* renamed from: net.one97.paytm.autoaddmoney.data.source.a$a  reason: collision with other inner class name */
    public interface C0872a extends c {
        void a(CJRSubscribeAutoAdd cJRSubscribeAutoAdd);
    }

    public interface b extends c {
        void a(String str);

        void a(CJRSubscribeDisableAutoAdd cJRSubscribeDisableAutoAdd);
    }

    public interface c {
        void a();

        void a(com.paytm.network.a aVar);

        void a(NetworkCustomError networkCustomError);

        void b(NetworkCustomError networkCustomError);
    }

    public interface d extends c {
        void a(CJRSubscribeFetchStatus cJRSubscribeFetchStatus);
    }

    public interface e {
        void a(HasLowSuccess hasLowSuccess, String str, String str2);
    }

    public interface f extends c {
        void a(String str);

        void a(ArrayList<TncData> arrayList);
    }

    public interface g extends c {
        void a(String str);

        void b();
    }

    public interface h extends c {
        void a(ArrayList<IJRDataModel> arrayList);
    }

    public interface i {
        void a(com.paytm.network.a aVar);

        void a(String str);

        void a(CJROrderSummary cJROrderSummary);
    }

    public interface j extends c {
        void a(CJRRechargePayment cJRRechargePayment);
    }

    void a(String str, e eVar);

    void a(String str, i iVar);

    void a(String str, j jVar);

    void a(ArrayList<TncData> arrayList, g gVar);

    void a(net.one97.paytm.addmoney.h hVar);

    void a(b bVar);

    void a(d dVar);

    void a(f fVar);

    void a(IJRDataModel iJRDataModel, String str, String str2, String str3, C0872a aVar);

    void a(boolean z, h hVar);
}
