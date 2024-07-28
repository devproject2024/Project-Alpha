package net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a;

import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.view.a;
import net.one97.paytm.paymentsBank.chequebook.utils.CbCataloguePayLoad;
import net.one97.paytm.paymentsBank.chequebook.utils.ChequeBookNames;

public final class c {

    public interface a extends net.one97.paytm.paymentsBank.slfd.a {
        void a(String str, String str2);

        void a(a.C0280a aVar, int i2);

        void a(CbCataloguePayLoad cbCataloguePayLoad);

        void c();

        void d();

        void e();

        int f();

        void g();

        void h();

        boolean i();

        String j();
    }

    public interface b extends net.one97.paytm.paymentsBank.slfd.b<a> {
        void a(String str);

        void a(String str, String str2);

        void a(ArrayList<PBTncData> arrayList);

        void a(List<CbCataloguePayLoad> list);

        void a(ChequeBookNames chequeBookNames);

        void b();

        void b(String str);

        void b(String str, String str2);

        void c(String str, String str2);

        void d(String str, String str2);
    }
}
