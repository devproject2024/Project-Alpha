package net.one97.paytm.upi.profile.a;

import net.one97.paytm.upi.c;
import net.one97.paytm.upi.common.UpiCheckAndAddVpaModel;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.d;
import net.one97.paytm.upi.util.UpiConstants;

public interface a {

    /* renamed from: net.one97.paytm.upi.profile.a.a$a  reason: collision with other inner class name */
    public interface C1380a extends c {
        void a();

        void a(String str, boolean z);

        void a(AccountProviderBody.AccountProvider accountProvider);

        void b();
    }

    public interface b extends d<C1380a> {
        void a();

        void a(String str);

        void a(String str, String str2);

        void a(String str, String str2, String str3);

        void a(String str, String str2, UserUpiDetails userUpiDetails, String str3);

        void a(UpiCheckAndAddVpaModel upiCheckAndAddVpaModel);

        void a(UserUpiDetails userUpiDetails);

        void a(UserUpiDetails userUpiDetails, boolean z);

        void a(UpiConstants.UpiVpaValidationError upiVpaValidationError);

        void b();

        void b(String str);

        void b(String str, String str2);

        void b(String str, String str2, String str3);

        void b(UserUpiDetails userUpiDetails);

        void c(UserUpiDetails userUpiDetails);

        void d(UserUpiDetails userUpiDetails);
    }
}
