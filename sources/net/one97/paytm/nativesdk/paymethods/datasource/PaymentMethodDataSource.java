package net.one97.paytm.nativesdk.paymethods.datasource;

import com.android.volley.VolleyError;
import net.one97.paytm.nativesdk.common.model.CreateOrderModel;
import net.one97.paytm.nativesdk.common.model.CreateOrderResponse;
import net.one97.paytm.nativesdk.instruments.upicollect.models.VerifyVpaResponse;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.BankFormItem;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.ProcessTransactionInfo;
import net.one97.paytm.nativesdk.transactionsummary.model.TxnSummaryResponse;
import net.one97.paytm.nativesdk.transcation.model.OtpApiResponse;
import net.one97.paytm.nativesdk.walletOtp.WalletOtpResponse;

public interface PaymentMethodDataSource {

    public interface Callback<T> {
        void onErrorResponse(VolleyError volleyError, T t);

        void onResponse(T t);
    }

    void checkSubsPaymentStatus(Callback<TxnSummaryResponse> callback);

    void createOrder(CreateOrderModel createOrderModel, Callback<CreateOrderResponse> callback);

    void fetchProcessTransactionInfo(String str, Callback<ProcessTransactionInfo> callback);

    void makeOtpCancelRequest(BankFormItem bankFormItem, Callback<OtpApiResponse> callback);

    void makeOtpResendRequest(BankFormItem bankFormItem, Callback<OtpApiResponse> callback);

    void makeOtpSubmitRequest(String str, BankFormItem bankFormItem, Callback<OtpApiResponse> callback);

    void makeTransactionRequest(Callback<ProcessTransactionInfo> callback);

    void makeUpiTransactionStatusRequest(String str, Callback<ProcessTransactionInfo> callback);

    void postDataOnCallBack(ProcessTransactionInfo processTransactionInfo, Callback<Object> callback);

    void sendWalletOtpRequest(String str, Callback<WalletOtpResponse> callback);

    void validateVPA(String str, Callback<VerifyVpaResponse> callback);

    void validateWalletOtpRequest(String str, Callback<WalletOtpResponse> callback);
}
