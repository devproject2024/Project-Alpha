package net.one97.paytm.upi.profile.a;

import net.one97.paytm.upi.d;
import net.one97.paytm.upi.util.UpiConstants;

public interface c {

    public interface a extends net.one97.paytm.upi.c {
        void a(String str);

        void b(String str);
    }

    public interface b extends d<a> {
        void a();

        void a(String str);

        void a(String str, String str2);

        void a(UpiConstants.UpiVpaValidationError upiVpaValidationError);

        void b();

        void b(String str);

        void c();
    }
}
