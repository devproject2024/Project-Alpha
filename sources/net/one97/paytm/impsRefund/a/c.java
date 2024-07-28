package net.one97.paytm.impsRefund.a;

import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.common.entity.impsdatamodel.CJRAddRefundAmount;

public interface c {

    public interface a {
        void a(String str);

        void a(String str, String str2, String str3, String str4);
    }

    public interface b {
        void a();

        void a(NetworkCustomError networkCustomError);

        void a(String str);

        void a(CJRAddRefundAmount cJRAddRefundAmount);

        void a(boolean z);
    }
}
