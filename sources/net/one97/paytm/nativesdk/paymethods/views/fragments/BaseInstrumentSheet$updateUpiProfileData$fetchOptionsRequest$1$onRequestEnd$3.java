package net.one97.paytm.nativesdk.paymethods.views.fragments;

import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail;

final class BaseInstrumentSheet$updateUpiProfileData$fetchOptionsRequest$1$onRequestEnd$3 extends l implements b<VpaBankAccountDetail, String> {
    public static final BaseInstrumentSheet$updateUpiProfileData$fetchOptionsRequest$1$onRequestEnd$3 INSTANCE = new BaseInstrumentSheet$updateUpiProfileData$fetchOptionsRequest$1$onRequestEnd$3();

    BaseInstrumentSheet$updateUpiProfileData$fetchOptionsRequest$1$onRequestEnd$3() {
        super(1);
    }

    public final String invoke(VpaBankAccountDetail vpaBankAccountDetail) {
        k.c(vpaBankAccountDetail, "it");
        return String.valueOf(vpaBankAccountDetail.getBank());
    }
}
