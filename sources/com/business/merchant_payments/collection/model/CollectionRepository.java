package com.business.merchant_payments.collection.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.model.AcceptedPaymentMode;
import com.business.merchant_payments.model.lastcollectedpaymentmodel.OfflineTransDetailObject;
import com.business.merchant_payments.model.lastcollectedpaymentmodel.OfflineTransactionDetails;
import com.business.merchant_payments.model.lastcollectedpaymentmodel.OrderDetailItem;
import com.business.merchant_payments.model.lastcollectedpaymentmodel.OrderDetailModel;
import com.business.merchant_payments.model.v2.OrderDetailV2Model;
import com.business.merchant_payments.utility.NetworkService;
import java.util.HashMap;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CollectionRepository {
    public static final String TAG = "CollectionRepository";
    public static CollectionRepository mCollectionRepo;
    public NetworkService networkService = PaymentsConfig.getInstance().getNetworkService();

    public static CollectionRepository getInstance() {
        if (mCollectionRepo == null) {
            synchronized (CollectionRepository.class) {
                if (mCollectionRepo == null) {
                    mCollectionRepo = new CollectionRepository();
                }
            }
        }
        return mCollectionRepo;
    }

    public LiveData<b<OrderDetailItem>> getOnlineOrderDetail(String str, HashMap<String, Object> hashMap, Map<String, String> map) {
        final y yVar = new y();
        this.networkService.getOnlineOrderDetail(str, hashMap, map).enqueue(new Callback<OrderDetailModel>(this) {
            public void onResponse(Call<OrderDetailModel> call, Response<OrderDetailModel> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    yVar.setValue(b.a((Response<?>) response));
                    return;
                }
                OrderDetailModel body = response.body();
                if (body == null || body.getResults() == null || body.getResults().size() <= 0) {
                    yVar.setValue(b.a((Response<?>) response));
                } else {
                    yVar.setValue(b.a(response, body.getResults().get(0)));
                }
            }

            public void onFailure(Call<OrderDetailModel> call, Throwable th) {
                yVar.setValue(b.a(th));
            }
        });
        return yVar;
    }

    public y<b<OfflineTransDetailObject>> getOfflineOrderDetail(String str, HashMap<String, Object> hashMap, Map<String, String> map) {
        final y<b<OfflineTransDetailObject>> yVar = new y<>();
        this.networkService.getOfflineTransactionDetails(str, hashMap, map).enqueue(new Callback<OfflineTransactionDetails>(this) {
            public void onResponse(Call<OfflineTransactionDetails> call, Response<OfflineTransactionDetails> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    yVar.setValue(b.a((Response<?>) response));
                    return;
                }
                OfflineTransactionDetails body = response.body();
                if (body == null || body.getmOfflineTransactionDetailMsg() == null || body.getmOfflineTransactionDetailMsg().getmOfflineTransDetailObj() == null || body.getmOfflineTransactionDetailMsg().getmOfflineTransDetailObj().size() <= 0) {
                    yVar.setValue(b.a((Response<?>) response));
                } else {
                    yVar.setValue(b.a(response, body.getmOfflineTransactionDetailMsg().getmOfflineTransDetailObj().get(0)));
                }
            }

            public void onFailure(Call<OfflineTransactionDetails> call, Throwable th) {
                yVar.setValue(b.a(th));
            }
        });
        return yVar;
    }

    public LiveData<b<OrderDetailV2Model>> getV2OrderDetails(String str, HashMap<String, Object> hashMap, String str2) {
        final y yVar = new y();
        this.networkService.getV2Detail(str, hashMap, str2).enqueue(new Callback<OrderDetailV2Model>(this) {
            public void onResponse(Call<OrderDetailV2Model> call, Response<OrderDetailV2Model> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    yVar.setValue(b.a((Response<?>) response));
                    return;
                }
                OrderDetailV2Model body = response.body();
                if (body.getResultInfo() == null || (!"S".equalsIgnoreCase(body.getResultInfo().getResultStatus()) && !"SUCCESS".equalsIgnoreCase(body.getResultInfo().getResultCode()))) {
                    yVar.setValue(b.a((Response<?>) response));
                } else {
                    yVar.setValue(b.a(body));
                }
            }

            public void onFailure(Call<OrderDetailV2Model> call, Throwable th) {
                yVar.setValue(b.a(th));
            }
        });
        return yVar;
    }

    public LiveData<b<AcceptedPaymentMode>> getPaymentModeDetails(String str, HashMap<String, Object> hashMap) {
        final y yVar = new y();
        this.networkService.getPaymentModeDetails(str, hashMap).enqueue(new Callback<AcceptedPaymentMode>(this) {
            public void onResponse(Call<AcceptedPaymentMode> call, Response<AcceptedPaymentMode> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    yVar.setValue(b.a((Response<?>) response));
                } else {
                    yVar.setValue(b.a(response, response.body()));
                }
            }

            public void onFailure(Call<AcceptedPaymentMode> call, Throwable th) {
                yVar.setValue(b.a(th));
            }
        });
        return yVar;
    }
}
