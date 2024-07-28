package net.one97.paytm.nativesdk.dataSource;

import android.content.Context;
import android.content.pm.ActivityInfo;
import java.util.ArrayList;
import net.one97.paytm.nativesdk.Utils.PayMethodType;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.dataSource.models.CreateTransaction;
import net.one97.paytm.nativesdk.dataSource.models.CreateTranscationResponse;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.EmiResponse;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.NBResponse;
import net.one97.paytm.nativesdk.instruments.upicollect.models.UpiOptionsModel;
import net.one97.paytm.nativesdk.instruments.upipush.model.BaseVpaDetail;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;

public interface PaymentDataSource {
    void doMGVTransaction(Context context, String str, String str2, String str3);

    void doNBTransaction(Context context, String str, String str2);

    void doNewCardTransaction(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, boolean z2, PayMethodType payMethodType);

    void doPaymentsBankTransaction(Context context, String str, String str2, String str3);

    void doPaytmWalletTransaction(Context context);

    void doPostPaidTransaction(Context context, String str, String str2, String str3);

    void doSavedCardTransaction(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, PayMethodType payMethodType);

    void doUPITransaction(Context context, String str, String str2, String str3, String str4, BaseVpaDetail baseVpaDetail);

    void doUpiCollectTransaction(Context context, String str, String str2);

    void doUpiIntentTransaction(Context context, String str, ActivityInfo activityInfo);

    void fetchBinDetails(String str, PaymentMethodDataSource.Callback<BinResponse> callback);

    void fetchEMIDetails(String str, String str2, PaymentMethodDataSource.Callback<EmiResponse> callback);

    void fetchPaymentOptions(String str, String str2, String str3, PaymentMethodDataSource.Callback<CJPayMethodResponse> callback);

    void getNBList(PaymentMethodDataSource.Callback<NBResponse> callback);

    ArrayList<UpiOptionsModel> getUpiAppsInstalled(Context context);

    void hitCloseOrderApi();

    void initiateTransaction(Context context, String str, String str2, CreateTransaction createTransaction, PaymentMethodDataSource.Callback<CreateTranscationResponse> callback);

    void makeUPITransactionStatusRequest(Context context, String str);

    public static final class DefaultImpls {
        public static /* synthetic */ void doNewCardTransaction$default(PaymentDataSource paymentDataSource, Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, boolean z2, PayMethodType payMethodType, int i2, Object obj) {
            if (obj == null) {
                paymentDataSource.doNewCardTransaction(context, str, str2, str3, str4, str5, str6, str7, str8, str9, z, (i2 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? false : z2, payMethodType);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doNewCardTransaction");
        }

        public static /* synthetic */ void doSavedCardTransaction$default(PaymentDataSource paymentDataSource, Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, PayMethodType payMethodType, int i2, Object obj) {
            if (obj == null) {
                paymentDataSource.doSavedCardTransaction(context, str, str2, str3, str4, str5, str6, str7, str8, (i2 & 512) != 0 ? false : z, payMethodType);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doSavedCardTransaction");
        }
    }
}
