package com.business.merchant_payments.mapqr.repository;

import androidx.lifecycle.y;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.mapqr.model.MapQRRequest;
import com.business.merchant_payments.mapqr.model.MapQRResponse;
import com.business.merchant_payments.mapqr.model.VerifyQRResponse;
import com.business.merchant_payments.utility.NetworkService;
import java.util.HashMap;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapQRRepository {
    public static final String TAG = "MapQRRepository";
    public static MapQRRepository mapQRRepository;
    public NetworkService networkService = PaymentsConfig.getInstance().getNetworkService();

    public static MapQRRepository getInstance() {
        if (mapQRRepository == null) {
            synchronized (MapQRRepository.class) {
                if (mapQRRepository == null) {
                    mapQRRepository = new MapQRRepository();
                }
            }
        }
        return mapQRRepository;
    }

    public y<b<MapQRResponse>> getMapQRResponse(String str, HashMap<String, Object> hashMap, MapQRRequest mapQRRequest) {
        final y<b<MapQRResponse>> yVar = new y<>();
        yVar.setValue(b.a());
        this.networkService.getMapQRResponse(str, hashMap, mapQRRequest).enqueue(new Callback<MapQRResponse>(this) {
            public void onResponse(Call<MapQRResponse> call, Response<MapQRResponse> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    yVar.setValue(b.a((Response<?>) response));
                } else {
                    yVar.setValue(b.a(response, response.body()));
                }
            }

            public void onFailure(Call<MapQRResponse> call, Throwable th) {
                yVar.setValue(b.a(th));
            }
        });
        return yVar;
    }

    public y<b<VerifyQRResponse>> getVerifyQRResponse(String str, HashMap<String, Object> hashMap) {
        final y<b<VerifyQRResponse>> yVar = new y<>();
        yVar.setValue(b.a());
        this.networkService.getVerifyQResponse(str, hashMap).enqueue(new Callback<VerifyQRResponse>(this) {
            public void onResponse(Call<VerifyQRResponse> call, Response<VerifyQRResponse> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    yVar.setValue(b.a((Response<?>) response));
                } else {
                    yVar.setValue(b.a(response, response.body()));
                }
            }

            public void onFailure(Call<VerifyQRResponse> call, Throwable th) {
                yVar.setValue(b.a(th));
            }
        });
        return yVar;
    }
}
