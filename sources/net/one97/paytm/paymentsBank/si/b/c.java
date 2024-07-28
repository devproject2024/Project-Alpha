package net.one97.paytm.paymentsBank.si.b;

import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import net.one97.paytm.bankCommon.model.BeneficiaryEntity;

public interface c {

    public interface a extends a {
        void a(int i2, int i3);

        void a(String str, String str2, boolean z);
    }

    public interface b extends b<a> {
        void a();

        void a(NetworkCustomError networkCustomError);

        void a(String str);

        void a(ArrayList<BeneficiaryEntity> arrayList, int i2);

        void a(boolean z);

        void b(boolean z);
    }
}
