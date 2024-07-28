package net.one97.paytm.passbook.subWallet.c;

import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.passbook.c;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import org.json.JSONObject;

public interface b {

    /* renamed from: net.one97.paytm.passbook.subWallet.c.b$b  reason: collision with other inner class name */
    public interface C1135b extends c {
        void a(String str, JSONObject jSONObject, String str2);

        void a(Throwable th);

        void a(CJRPGTokenList cJRPGTokenList);

        void a(IJRDataModel iJRDataModel);

        void h();

        void j();

        void k();

        void l();

        void m();
    }

    public static abstract class a extends net.one97.paytm.passbook.a<C1135b> {
        public a(C1135b bVar) {
            super(bVar);
        }
    }
}
