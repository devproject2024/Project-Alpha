package net.one97.paytm.p2b.a;

import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.common.entity.beneficiaryModels.CJRAddBeneficiary;

public final class c {

    public interface a extends net.one97.paytm.p2b.a {
        void a(String str, String str2);

        void a(String str, String str2, String str3, String str4, boolean z);

        void a(BeneficiaryEntity beneficiaryEntity, boolean z);
    }

    public interface b {
        void a(NetworkCustomError networkCustomError);

        void a(String str);

        void a(CJRAddBeneficiary.CJRAddBeneficiarySubError cJRAddBeneficiarySubError, String str);

        void a(CJRAddBeneficiary cJRAddBeneficiary);

        void b(NetworkCustomError networkCustomError);

        void d();

        void e();
    }
}
