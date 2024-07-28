package net.one97.paytm.paymentsBank.createfd.c;

import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.bankCommon.model.PBCJRAccountSummary;
import net.one97.paytm.paymentsBank.createfd.utils.b;
import net.one97.paytm.paymentsBank.model.slfd.TransactionDetailResponse;

public final class e {

    public interface a extends a {
        long a();

        b.a.c a(TransactionDetailResponse transactionDetailResponse);

        void a(String str);

        String b(String str, String str2);

        String b(TransactionDetailResponse transactionDetailResponse);

        void b();

        PBCJRAccountSummary c();
    }

    public interface b extends b {
        void a(NetworkCustomError networkCustomError, b.a.c cVar);

        void a(TransactionDetailResponse transactionDetailResponse);

        void g();
    }
}
