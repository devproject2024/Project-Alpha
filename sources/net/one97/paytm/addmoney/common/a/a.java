package net.one97.paytm.addmoney.common.a;

import android.view.View;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.addmoney.common.model.SourceCardDataModel;
import net.one97.paytm.addmoney.common.model.UAMErrorType;
import net.one97.paytm.addmoney.common.paymethodresponse.CJPayMethodResponse;
import net.one97.paytm.addmoney.f;
import net.one97.paytm.addmoney.g;
import net.one97.paytm.addmoney.utils.AddMoneyCardView;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.paymentsbank.CustProductList;
import net.one97.paytm.common.entity.shopping.CJRCart;

public interface a {

    /* renamed from: net.one97.paytm.addmoney.common.a.a$a  reason: collision with other inner class name */
    public interface C0849a extends f {
        void a(int i2);

        void a(int i2, b bVar);

        int c();

        void d();

        String e();

        double f();

        double g();

        double h();

        double i();

        String j();

        CustProductList k();

        void l();

        void m();

        void n();

        String o();
    }

    public interface b {
        AddMoneyCardView a(SourceCardDataModel sourceCardDataModel);

        void a(double d2);

        void a(int i2);

        void a(SourceCardDataModel sourceCardDataModel, boolean z, View view);
    }

    public interface c extends g<C0849a> {
        String a();

        void a(int i2);

        void a(String str);

        void a(String str, String str2);

        void a(String str, String str2, String str3);

        void a(String str, String str2, SourceCardDataModel sourceCardDataModel);

        void a(UAMErrorType uAMErrorType);

        void a(CJPayMethodResponse cJPayMethodResponse);

        void a(CJRCart cJRCart);

        void a(boolean z, int i2);

        boolean a(CJRRechargeCart cJRRechargeCart);

        void b();

        void b(int i2);

        void b(NetworkCustomError networkCustomError);

        void b(String str);

        void b(UAMErrorType uAMErrorType);

        void c();

        void c(String str);

        double d();

        double e();

        double f();

        boolean g();

        void h();

        String i();

        String j();

        String k();

        String l();

        String m();

        void n();

        void o();

        double p();

        void q();
    }
}
