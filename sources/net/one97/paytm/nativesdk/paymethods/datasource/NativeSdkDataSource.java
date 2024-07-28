package net.one97.paytm.nativesdk.paymethods.datasource;

import java.util.HashMap;
import net.one97.paytm.nativesdk.common.model.ApplyPromoRequest;
import net.one97.paytm.nativesdk.common.model.ApplyPromoResponse;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.CJRVerifyPasscodeResponse;
import net.one97.paytm.nativesdk.common.model.FetchCardDetailsRequest;
import net.one97.paytm.nativesdk.common.model.FetchCardDetailsResponse;
import net.one97.paytm.nativesdk.common.model.PcfDetailsResponse;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.EmiResponse;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.PromoCodeResponse;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.NBResponse;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.paymethods.model.fetchBalance.CJRFetchBalanceResponse;
import org.json.JSONObject;

public interface NativeSdkDataSource {
    void applyOffer(ApplyPromoRequest applyPromoRequest, PaymentMethodDataSource.Callback<ApplyPromoResponse> callback);

    void fetchBalance(String str, PaymentMethodDataSource.Callback<CJRFetchBalanceResponse> callback);

    void fetchBinDetails(String str, PaymentMethodDataSource.Callback<BinResponse> callback);

    void fetchCardDetails(FetchCardDetailsRequest fetchCardDetailsRequest, PaymentMethodDataSource.Callback<FetchCardDetailsResponse> callback);

    void fetchEmiDetails(String str, String str2, PaymentMethodDataSource.Callback<EmiResponse> callback);

    void fetchNBDetails(String str, PaymentMethodDataSource.Callback<NBResponse> callback);

    void fetchPayOptions(String str, double d2, String str2, PaymentMethodDataSource.Callback<CJPayMethodResponse> callback);

    void fetchPayOptions(String str, String str2, String str3, PaymentMethodDataSource.Callback<CJPayMethodResponse> callback);

    void fetchPcfDetails(JSONObject jSONObject, PaymentMethodDataSource.Callback<PcfDetailsResponse> callback);

    void fetchPromoCodeDetail(String str, String str2, PaymentMethodDataSource.Callback<PromoCodeResponse> callback);

    void getToken(String str, String str2, PaymentMethodDataSource.Callback<CJRVerifyPasscodeResponse> callback);

    void makeUpiConsentApiCall(String str, boolean z, HashMap<String, String> hashMap);

    void notifyServerAboutCloseOrder();
}
