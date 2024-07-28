package com.paytmmall.clpartifact.repositories;

import android.content.Context;
import com.android.volley.VolleyError;
import com.google.gson.i;
import com.google.gson.l;
import com.google.gson.o;
import com.paytmmall.clpartifact.modal.grid.CJRGrid;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.navigator.VariantBottomSheetNavigator;
import com.paytmmall.clpartifact.network.CLPNetworkService;
import java.util.ArrayList;
import java.util.HashMap;

public class VariantBottomSheetRepository extends BaseRepository<VariantBottomSheetNavigator> {
    private Context context;
    /* access modifiers changed from: private */
    public OnSuccessListener mListener;
    private CLPNetworkService mNetworkService = new CLPNetworkService();

    public interface OnSuccessListener {
        void onSuccessVariant(String str);
    }

    public VariantBottomSheetRepository(Context context2) {
        this.context = context2.getApplicationContext();
    }

    public void setListener(OnSuccessListener onSuccessListener) {
        this.mListener = onSuccessListener;
    }

    public void loadSheetData(String str, long j) {
        if (getNavigator() != null) {
            ((VariantBottomSheetNavigator) getNavigator()).onProgress();
        }
        o oVar = new o();
        i iVar = new i();
        o oVar2 = new o();
        oVar2.a("group_id", (Number) Long.valueOf(j));
        iVar.a((l) oVar2);
        oVar.a("products", (l) iVar);
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        this.mNetworkService.fetch(this.context, str, 1, oVar.toString(), hashMap, new CLPNetworkService.IResponseListener() {
            public void onSuccess(String str, o oVar) {
                if (VariantBottomSheetRepository.this.mListener != null) {
                    VariantBottomSheetRepository.this.mListener.onSuccessVariant(str);
                }
            }

            public void onError(VolleyError volleyError) {
                if (VariantBottomSheetRepository.this.getNavigator() != null) {
                    ((VariantBottomSheetNavigator) VariantBottomSheetRepository.this.getNavigator()).onFailed((Throwable) null);
                }
            }
        });
    }

    private boolean hasVariant(CJRGrid cJRGrid) {
        try {
            return !cJRGrid.getGridLayout().get(0).getVariant().getItems().isEmpty();
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
        }
    }

    private ArrayList<CJRGridProduct> getVariantItems(CJRGrid cJRGrid) {
        return cJRGrid.getGridLayout().get(0).getVariant().getItems();
    }
}
