package com.paytmmall.clpartifact.repositories;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.android.volley.VolleyError;
import com.google.gson.f;
import com.google.gson.o;
import com.paytmmall.clpartifact.modal.grid.CJRGrid;
import com.paytmmall.clpartifact.network.CLPNetworkService;
import com.paytmmall.clpartifact.network.RequestType;
import com.paytmmall.clpartifact.network.Resource;
import com.paytmmall.clpartifact.repositories.VoucherRepository;
import com.paytmmall.clpartifact.threading.Task;
import java.util.HashMap;

public class VoucherRepository {
    private Context mContext;
    private CLPNetworkService mNetworkService = new CLPNetworkService();
    /* access modifiers changed from: private */
    public y<Resource<CJRGrid>> mVoucherLiveData = new y<>();

    public VoucherRepository(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void loadVoucher(String str, final RequestType requestType) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        String str2 = str;
        this.mNetworkService.fetch(this.mContext, str2, 1, new o().toString(), hashMap, new CLPNetworkService.IResponseListener() {
            public void onSuccess(String str, o oVar) {
                Task.runOnIOThread(new Runnable(str, requestType) {
                    private final /* synthetic */ String f$1;
                    private final /* synthetic */ RequestType f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        VoucherRepository.AnonymousClass1.this.lambda$onSuccess$0$VoucherRepository$1(this.f$1, this.f$2);
                    }
                });
            }

            public /* synthetic */ void lambda$onSuccess$0$VoucherRepository$1(String str, RequestType requestType) {
                try {
                    VoucherRepository.this.mVoucherLiveData.postValue(Resource.success((CJRGrid) new f().a(str, CJRGrid.class)).setRequestType(requestType));
                } catch (Exception e2) {
                    VoucherRepository.this.mVoucherLiveData.postValue(Resource.error(e2).setRequestType(requestType));
                }
            }

            public void onError(VolleyError volleyError) {
                VoucherRepository.this.mVoucherLiveData.setValue(Resource.error(volleyError).setRequestType(requestType));
            }
        });
    }

    public LiveData<Resource<CJRGrid>> getVoucherLiveData() {
        return this.mVoucherLiveData;
    }
}
