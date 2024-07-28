package com.paytmmall.clpartifact.view.viewmodel;

import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.android.volley.VolleyError;
import com.google.gson.f;
import com.google.gson.o;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.modal.stores.CJRStores;
import com.paytmmall.clpartifact.network.CLPNetworkService;
import com.paytmmall.clpartifact.repositories.CLPRepository;
import com.paytmmall.clpartifact.utils.UrlUtils;
import java.util.HashMap;

public class StoreTabViewModel extends BaseViewModel {
    private CLPRepository mRepository = new CLPRepository();
    /* access modifiers changed from: private */
    public y<CJRStores> mStoreData;

    public StoreTabViewModel(Application application) {
        super(application);
    }

    public LiveData<CJRStores> fetchStoreResponse(String str) {
        this.mStoreData = new y<>();
        String str2 = str;
        this.mRepository.getStoreResponse(getApplication(), str2, getStoreHeaders(str), (String) null, new CLPNetworkService.IResponseListener() {
            public void onSuccess(String str, o oVar) {
                StoreTabViewModel.this.mStoreData.postValue(new f().a(str, CJRStores.class));
            }

            public void onError(VolleyError volleyError) {
                StoreTabViewModel.this.mStoreData.postValue(null);
            }
        });
        return this.mStoreData;
    }

    private HashMap<String, String> getStoreHeaders(final String str) {
        return new HashMap<String, String>() {
            {
                put("Content-Type", "application/json");
                put(AppConstants.SSO_TOKEN, CLPArtifact.getInstance().getCommunicationListener().getSSOToken(StoreTabViewModel.this.getApplication()));
                put("X-client-secret", "kybid_brand_fe@123");
                put("X-client-name", "feBrand_client");
                put("lat", StoreTabViewModel.this.getLatLongFromUrl(str, "hr_lat"));
                put("lon", StoreTabViewModel.this.getLatLongFromUrl(str, "hr_lon"));
            }
        };
    }

    /* access modifiers changed from: private */
    public String getLatLongFromUrl(String str, String str2) {
        try {
            return !TextUtils.isEmpty(str) ? UrlUtils.getQueryParameter(str, str2) : "";
        } catch (Exception unused) {
            return "";
        }
    }
}
