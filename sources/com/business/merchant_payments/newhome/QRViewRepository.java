package com.business.merchant_payments.newhome;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.common.utility.RequestParamUtil;
import com.business.merchant_payments.model.qrsummarymodel.QRSummary;
import com.business.merchant_payments.utility.NetworkService;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QRViewRepository {
    public static QRViewRepository mProfileRepo;
    public Context mAppContext = PaymentsConfig.getInstance().getAppContext();
    public NetworkService networkService = PaymentsConfig.getInstance().getNetworkService();

    public static QRViewRepository getInstance() {
        if (mProfileRepo == null) {
            synchronized (QRViewRepository.class) {
                if (mProfileRepo == null) {
                    mProfileRepo = new QRViewRepository();
                }
            }
        }
        return mProfileRepo;
    }

    public LiveData<b<QRSummary>> fetchQRCodeApiCallNew() {
        final y yVar = new y();
        HashMap<String, Object> requestHeaderMidParam = RequestParamUtil.getRequestHeaderMidParam(this.mAppContext);
        yVar.setValue(b.a());
        this.networkService.getQRSUmmary(GTMDataProviderImpl.Companion.getMInstance().getQRSummeryAPI() + SDKConstants.ALL_TYPE, requestHeaderMidParam).enqueue(new Callback<QRSummary>(this) {
            public void onResponse(Call<QRSummary> call, Response<QRSummary> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    yVar.setValue(b.a((Response<?>) response));
                } else {
                    yVar.setValue(b.a(response, response.body()));
                }
            }

            public void onFailure(Call<QRSummary> call, Throwable th) {
                yVar.setValue(b.a(th));
            }
        });
        return yVar;
    }
}
