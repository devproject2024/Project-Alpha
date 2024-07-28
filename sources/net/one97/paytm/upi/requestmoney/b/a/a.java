package net.one97.paytm.upi.requestmoney.b.a;

import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;
import net.one97.paytm.upi.e;

public interface a {

    /* renamed from: net.one97.paytm.upi.requestmoney.b.a.a$a  reason: collision with other inner class name */
    public interface C1402a {
        void a(UpiBaseDataModel upiBaseDataModel);

        void a(UpiCustomVolleyError upiCustomVolleyError);
    }

    public interface b {
        void a();
    }

    void a(String str);

    void a(UpiDBTransactionModel upiDBTransactionModel);

    void a(e eVar);

    void a(C1402a aVar, String str);

    void a(C1402a aVar, String str, int i2, String str2);

    void a(C1402a aVar, String str, String str2);

    void a(C1402a aVar, String str, String str2, String str3, String str4);

    void a(C1402a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10);

    void a(C1402a aVar, String str, String str2, boolean z);

    void a(C1402a aVar, b bVar, int i2, int i3);

    boolean a();

    void b(C1402a aVar, String str, String str2, String str3, String str4);
}
