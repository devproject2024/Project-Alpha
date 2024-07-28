package com.paytmmall.clpartifact.view.viewmodel;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.android.volley.VolleyError;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.gson.f;
import com.google.gson.o;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.modal.grid.CJRFrontEndFilter;
import com.paytmmall.clpartifact.modal.grid.CJRFrontEndFilterItem;
import com.paytmmall.clpartifact.modal.grid.CJRGrid;
import com.paytmmall.clpartifact.network.CLPNetworkService;
import com.paytmmall.clpartifact.repositories.CLPRepository;
import com.paytmmall.clpartifact.utils.UrlUtils;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class InfiniteGridViewModel extends ai {
    /* access modifiers changed from: private */
    public y<CJRGrid> mGridLiveData;
    private CLPRepository mRepository = new CLPRepository();
    private boolean requesting;

    public boolean isRequesting() {
        return this.requesting;
    }

    public void setRequesting(boolean z) {
        this.requesting = z;
    }

    public LiveData<CJRGrid> fetchGridResponse(Context context, String str) {
        String queryParameter = UrlUtils.getQueryParameter(str, "current_page");
        this.mGridLiveData = new y<>();
        String oVar = new o().toString();
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        if (str.contains("api_type=re")) {
            getREBody(queryParameter);
            oVar = getREBody(queryParameter);
        }
        this.mRepository.getGridResponse(context, str, hashMap, oVar, new CLPNetworkService.IResponseListener() {
            public void onSuccess(String str, o oVar) {
                InfiniteGridViewModel.this.mGridLiveData.postValue(InfiniteGridViewModel.this.getGridObject((CJRGrid) new f().a(str, CJRGrid.class)));
            }

            public void onError(VolleyError volleyError) {
                InfiniteGridViewModel.this.mGridLiveData.postValue(null);
            }
        });
        return this.mGridLiveData;
    }

    /* access modifiers changed from: private */
    public CJRGrid getGridObject(CJRGrid cJRGrid) {
        ArrayList<CJRFrontEndFilter> frontEndFilterList;
        if (!(cJRGrid == null || (frontEndFilterList = cJRGrid.getFrontEndFilterList()) == null)) {
            Iterator<CJRFrontEndFilter> it2 = frontEndFilterList.iterator();
            while (it2.hasNext()) {
                sanitizeFilters(it2.next().getFrontEndRootFilterItem(), (String) null);
            }
        }
        return cJRGrid;
    }

    private void sanitizeFilters(CJRFrontEndFilterItem cJRFrontEndFilterItem, String str) {
        if (cJRFrontEndFilterItem != null) {
            cJRFrontEndFilterItem.setParentId(str);
            ArrayList<CJRFrontEndFilterItem> frontEndFilterItemList = cJRFrontEndFilterItem.getFrontEndFilterItemList();
            if (frontEndFilterItemList != null) {
                Iterator<CJRFrontEndFilterItem> it2 = frontEndFilterItemList.iterator();
                while (it2.hasNext()) {
                    sanitizeFilters(it2.next(), cJRFrontEndFilterItem.getID());
                }
            }
        }
    }

    private String getREBody(String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        JSONObject jSONObject5 = new JSONObject();
        String userId = CLPArtifact.getInstance().getCommunicationListener().getUserId(CLPArtifact.getInstance().getContext());
        if (userId != null) {
            try {
                jSONObject2.put("user_id", userId);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        jSONObject2.put(AddEditGstinViewModelKt.BODY_PARAM_PINCODE, "");
        try {
            jSONObject3.put("ga_id", CLPArtifact.getInstance().getCommunicationListener().getGAId(CLPArtifact.getInstance().getContext()));
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        try {
            jSONObject4.put("name", CLPArtifact.getInstance().getCommunicationListener().getAppName());
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        try {
            jSONObject5.put("item_count", "");
            jSONObject5.put("current_page", str);
            jSONObject5.put("id", "");
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
        try {
            jSONObject.put(StringSet.user, jSONObject2);
            jSONObject.put(AppConstants.TAG_DEVICE, jSONObject3);
            jSONObject.put("channel", jSONObject4);
            jSONObject.put("custom", jSONObject5);
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void fetchActiveOrder(FragmentActivity fragmentActivity, String str) {
        this.mRepository.fetchActiveOrder(fragmentActivity, str);
    }
}
