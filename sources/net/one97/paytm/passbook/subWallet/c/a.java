package net.one97.paytm.passbook.subWallet.c;

import net.one97.paytm.passbook.beans.CustProductList;
import net.one97.paytm.passbook.c;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public interface a {

    public interface b extends c {
        void a();

        void a(String str);

        void a(Throwable th);

        void a(CustProductList.FreezeDescription freezeDescription);

        void a(IJRDataModel iJRDataModel);

        void b();

        void b(IJRDataModel iJRDataModel);

        void c();

        void c(IJRDataModel iJRDataModel);

        void d();

        void d(IJRDataModel iJRDataModel);

        void e();

        void e(IJRDataModel iJRDataModel);

        void f();

        void g();

        void h();

        void i();

        void j();

        void k();
    }

    /* renamed from: net.one97.paytm.passbook.subWallet.c.a$a  reason: collision with other inner class name */
    public static abstract class C1134a extends net.one97.paytm.passbook.a<b> {
        public C1134a(b bVar) {
            super(bVar);
        }
    }
}
