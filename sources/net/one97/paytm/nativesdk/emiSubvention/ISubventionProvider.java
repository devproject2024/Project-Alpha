package net.one97.paytm.nativesdk.emiSubvention;

import android.content.Context;
import java.util.ArrayList;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.emiSubvention.models.BankData;
import org.json.JSONObject;

public interface ISubventionProvider {

    public interface IBankErrorListener {
        void onBankError(String str, String str2);

        void onBankNetworkError(PaytmSDKRequestClient.ApiResponseError apiResponseError);
    }

    public interface IBankListener extends IBankErrorListener {
        void onBankSuccessResponse(String str);
    }

    public interface IBankTenureListener extends IBankErrorListener {
        void onBankSuccessResponse(String str);
    }

    public interface IBankValidator extends IBankErrorListener {
        void onBankSuccessResponse(String str, String str2, String str3);
    }

    void fetchTenures(BankData bankData, ArrayList<PaymentIntent> arrayList, JSONObject jSONObject, IBankTenureListener iBankTenureListener);

    void getBanks(IBankListener iBankListener);

    void showBottomSheet(Context context, String str, Double d2, String str2);

    void validateTenure(String str, String str2, IBankValidator iBankValidator, ArrayList<PaymentIntent> arrayList, JSONObject jSONObject);
}
