package net.one97.paytm.moneytransfer.a;

import net.one97.paytm.common.entity.CJRClaimCashbackDataModel;
import net.one97.paytm.upi.c;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.d;

public final class g {

    public interface a extends c {
        void a();

        void a(String str, String str2);
    }

    public interface b extends d<a> {
        void a(CJRClaimCashbackDataModel cJRClaimCashbackDataModel);

        void a(UpiProfileDefaultBank upiProfileDefaultBank);
    }
}
