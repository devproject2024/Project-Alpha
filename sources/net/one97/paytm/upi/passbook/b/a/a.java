package net.one97.paytm.upi.passbook.b.a;

import com.android.volley.VolleyError;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.UpiTxnHistoryV2RequestBody;

public interface a {

    /* renamed from: net.one97.paytm.upi.passbook.b.a.a$a  reason: collision with other inner class name */
    public interface C1379a {
        void a(UpiBaseDataModel upiBaseDataModel);

        void a(UpiCustomVolleyError upiCustomVolleyError);
    }

    public interface b {
        void a(VolleyError volleyError);

        void a(UpiBaseDataModel upiBaseDataModel);
    }

    void a();

    void a(String str);

    void a(C1379a aVar, String str, int i2, String str2);

    void a(C1379a aVar, String str, String str2);

    void a(C1379a aVar, String str, String str2, String str3);

    void a(C1379a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11);

    void a(C1379a aVar, String str, UpiTxnHistoryV2RequestBody upiTxnHistoryV2RequestBody);

    void a(b bVar, String str, String str2, String str3, String str4, String str5);

    void b(C1379a aVar, String str, int i2, String str2);

    void b(C1379a aVar, String str, String str2, String str3);
}
