package net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic;

import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse;
import net.one97.paytm.p2mNewDesign.models.MerchantDetailsV2;
import net.one97.paytm.p2mNewDesign.models.MerchantLimitInfoV2;
import net.one97.paytm.p2mNewDesign.models.PaymentModesV2;
import net.one97.paytm.p2mNewDesign.models.SavedInstrumentsV2;

public class a {

    /* renamed from: a  reason: collision with root package name */
    protected CJRFetchPayMethodResponse f13085a;

    public final void a(CJRFetchPayMethodResponse cJRFetchPayMethodResponse) {
        MerchantLimitInfoV2 merchantLimitInfo;
        this.f13085a = cJRFetchPayMethodResponse;
        CJRFetchPayMethodResponse cJRFetchPayMethodResponse2 = this.f13085a;
        if (cJRFetchPayMethodResponse2 != null && cJRFetchPayMethodResponse2.getBody() != null && this.f13085a.getBody().getMerchantLimitInfo() != null && (merchantLimitInfo = this.f13085a.getBody().getMerchantLimitInfo()) != null && merchantLimitInfo.getExcludedPaymodes() != null && merchantLimitInfo.getExcludedPaymodes().size() > 0) {
            ArrayList<String> excludedPaymodes = merchantLimitInfo.getExcludedPaymodes();
            if (excludedPaymodes.contains("NET_BANKING")) {
                excludedPaymodes.remove("NET_BANKING");
                excludedPaymodes.add(SDKConstants.AI_KEY_PPBL);
            }
            merchantLimitInfo.setExcludedPaymodes(excludedPaymodes);
        }
    }

    public final ArrayList<SavedInstrumentsV2> a() {
        try {
            return this.f13085a.getBody().getMerchantPayOption().getSavedInstruments();
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public final List<PaymentModesV2> b() {
        try {
            return this.f13085a.getBody().getMerchantPayOption().getPaymentModes();
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public final MerchantDetailsV2 c() {
        try {
            return this.f13085a.getBody().getMerchantDetails();
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public final String d() {
        try {
            return this.f13085a.getBody().getOrderId();
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public final void a(String str) {
        try {
            this.f13085a.getBody().setOrderId(str);
        } catch (NullPointerException unused) {
        }
    }

    public final CJRFetchPayMethodResponse e() {
        return this.f13085a;
    }
}
