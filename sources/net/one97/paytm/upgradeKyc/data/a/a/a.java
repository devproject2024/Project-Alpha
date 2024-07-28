package net.one97.paytm.upgradeKyc.data.a.a;

import kotlin.d.d;
import net.one97.paytm.common.entity.auth.KYCFetchTnc;
import net.one97.paytm.common.entity.auth.KYCTncAccept;
import net.one97.paytm.common.entity.upgradeKyc.KYCStatusV3;
import net.one97.paytm.upgradeKyc.data.models.aotpexpire.AOTPExpireApiResponse;
import net.one97.paytm.upgradeKyc.kycV3.b.b;

public interface a {
    Object a(int i2, String str, d<? super b<KYCTncAccept>> dVar);

    Object a(d<? super b<KYCFetchTnc>> dVar);

    void a(KYCStatusV3 kYCStatusV3);

    Object b(d<? super b<AOTPExpireApiResponse>> dVar);

    Object c(d<? super b<KYCStatusV3>> dVar);
}
