package net.one97.paytm.upi.registration.b.a;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.upi.a.c;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.registration.a.d;

public interface a {

    /* renamed from: net.one97.paytm.upi.registration.b.a.a$a  reason: collision with other inner class name */
    public interface C1389a {
        void onError(UpiCustomVolleyError upiCustomVolleyError);

        void onSuccess(UpiBaseDataModel upiBaseDataModel);
    }

    String a();

    void a(String str);

    void a(String str, String str2, C1389a aVar, String str3, String str4);

    void a(List<AccountProviderBody.AccountProvider> list);

    void a(c.b bVar);

    void a(d.a aVar, net.one97.paytm.upi.h.a aVar2, String str);

    void a(C1389a aVar, String str);

    void a(C1389a aVar, String str, String str2);

    void a(C1389a aVar, String str, String str2, String str3);

    void a(C1389a aVar, String str, String str2, HashMap<String, String> hashMap, String str3);

    void a(C1389a aVar, String str, String str2, boolean z, String str3, String str4);

    void a(boolean z);

    String b();

    void b(String str);

    void b(d.a aVar, net.one97.paytm.upi.h.a aVar2, String str);

    void b(C1389a aVar, String str);

    void b(C1389a aVar, String str, String str2);

    void b(boolean z);

    void c(String str);

    void c(C1389a aVar, String str);

    void c(C1389a aVar, String str, String str2);

    void c(boolean z);

    boolean c();

    void d();

    void d(boolean z);

    void e(boolean z);

    boolean e();

    boolean f();

    boolean g();

    boolean h();

    boolean i();

    void j();

    List<AccountProviderBody.AccountProvider> k();

    Map<String, AccountProviderBody.AccountProvider> l();

    void m();

    String n();
}
