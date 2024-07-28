package net.one97.paytm.fastag.a;

import net.one97.paytm.fastag.c;
import net.one97.paytm.fastag.model.CJRAadharPanSave;
import net.one97.paytm.fastag.model.CJRAddresses;
import net.one97.paytm.fastag.model.CJRDetailProduct;
import net.one97.paytm.fastag.model.CJRRechargeCart;

public interface a {

    public interface b extends net.one97.paytm.fastag.b {
        void a();

        void a(Throwable th);

        void a(c cVar);

        void a(CJRAadharPanSave cJRAadharPanSave);

        void a(CJRAddresses cJRAddresses);

        void a(CJRDetailProduct cJRDetailProduct);

        void a(CJRRechargeCart cJRRechargeCart);

        void b();

        void b(Throwable th);

        void c();

        void c(Throwable th);

        void d();

        void e();
    }

    /* renamed from: net.one97.paytm.fastag.a.a$a  reason: collision with other inner class name */
    public static abstract class C0185a extends net.one97.paytm.fastag.a<b> {
        public C0185a(b bVar) {
            super(bVar);
        }
    }
}
