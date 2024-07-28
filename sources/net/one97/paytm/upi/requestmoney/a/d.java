package net.one97.paytm.upi.requestmoney.a;

import android.os.Bundle;
import java.util.List;
import net.one97.paytm.upi.c;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.common.upi.ValidateVpaResponse;
import net.one97.paytm.upi.requestmoney.view.RequestMoneyV2Activity;

public interface d {

    public interface a extends c {
        void a();

        void a(Bundle bundle);

        void a(String str, String str2, RequestMoneyV2Activity.b bVar);

        void a(AccountProviderBody.AccountProvider accountProvider);

        void a(UpiProfileDefaultBank upiProfileDefaultBank);

        void a(UpiProfileDefaultBank upiProfileDefaultBank, String str, String str2, String str3, String str4, String str5);

        void a(UserUpiDetails userUpiDetails);

        void b();
    }

    public interface b extends net.one97.paytm.upi.d<a> {
        void a(Bundle bundle);

        void a(String str);

        void a(String str, String str2);

        void a(String str, String str2, String str3);

        void a(List<UpiProfileDefaultBank> list);

        void a(UpiCustomVolleyError upiCustomVolleyError);

        void a(AccountProviderBody.AccountProvider accountProvider, String str);

        void a(RequestMoneyV2Activity.a aVar);

        void a(boolean z);

        void a(boolean z, String str, ValidateVpaResponse validateVpaResponse);

        void a(boolean z, RequestMoneyV2Activity.b bVar);

        void b(List<UpiProfileDefaultBank> list);

        void b(boolean z);

        void e();

        void f();

        void g();

        void h();

        void i();
    }
}
