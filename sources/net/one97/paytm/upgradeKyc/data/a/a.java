package net.one97.paytm.upgradeKyc.data.a;

import kotlin.d.d;
import net.one97.paytm.upgradeKyc.data.models.requestotp.RequestOtpResponse;
import net.one97.paytm.upgradeKyc.data.models.resendotp.KycResendOtpResponse;
import net.one97.paytm.upgradeKyc.data.models.verifykycotp.KycVerifyOtpResponse;
import net.one97.paytm.upgradeKyc.kycV3.b.b;

public interface a {
    Object a(String str, String str2, d<? super b<RequestOtpResponse>> dVar);

    Object a(String str, d<? super b<KycResendOtpResponse>> dVar);

    Object b(String str, String str2, d<? super b<KycVerifyOtpResponse>> dVar);
}
