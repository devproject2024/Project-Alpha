package net.one97.paytm.addmoney.landing.a;

import android.app.Activity;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.addmoney.common.model.CJRAccountSummary;
import net.one97.paytm.addmoney.f;
import net.one97.paytm.addmoney.g;
import net.one97.paytm.addmoney.landing.view.a;
import net.one97.paytm.common.entity.paymentsbank.CustProductList;

public interface a {

    /* renamed from: net.one97.paytm.addmoney.landing.a.a$a  reason: collision with other inner class name */
    public interface C0851a {
        void a();

        void b();

        void c();
    }

    public interface b extends f {
        void a(int i2);

        void a(int i2, a.C0852a aVar);

        void a(NetworkCustomError networkCustomError);

        void a(String str, String str2, String str3);

        void a(CJRAccountSummary cJRAccountSummary);

        void a(CustProductList custProductList);

        Activity c();

        void d();

        int e();
    }

    public interface c extends g<b> {
        void a(int i2);

        void a(int i2, int i3);

        void a(String str);

        void a(String str, String str2, String str3);

        void a(String str, String str2, String str3, String str4);

        void a(String str, String str2, String str3, String str4, String str5);

        void a(boolean z, String str);

        void b(String str);

        void b(boolean z);

        Activity c();

        void c(boolean z);

        void d();

        void e();

        void f();
    }
}
