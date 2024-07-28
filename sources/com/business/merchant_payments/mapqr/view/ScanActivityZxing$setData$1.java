package com.business.merchant_payments.mapqr.view;

import androidx.lifecycle.z;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.e;
import com.business.merchant_payments.mapqr.model.MapQRResponse;
import com.google.android.material.snackbar.Snackbar;
import kotlin.g.b.k;
import kotlin.m.p;

public final class ScanActivityZxing$setData$1<T> implements z<b<MapQRResponse>> {
    public final /* synthetic */ ScanActivityZxing this$0;

    public ScanActivityZxing$setData$1(ScanActivityZxing scanActivityZxing) {
        this.this$0 = scanActivityZxing;
    }

    public final void onChanged(b<MapQRResponse> bVar) {
        k.a((Object) bVar);
        if (bVar.f7357b == e.LOADING) {
            if (this.this$0.errorSnackBar != null) {
                Snackbar access$getErrorSnackBar$p = this.this$0.errorSnackBar;
                k.a((Object) access$getErrorSnackBar$p);
                if (access$getErrorSnackBar$p.e()) {
                    Snackbar access$getErrorSnackBar$p2 = this.this$0.errorSnackBar;
                    k.a((Object) access$getErrorSnackBar$p2);
                    access$getErrorSnackBar$p2.d();
                }
            }
        } else if (bVar.f7356a != null) {
            MapQRResponse mapQRResponse = (MapQRResponse) bVar.f7358c;
            if (mapQRResponse == null) {
                this.this$0.showErrorLayout((String) null);
            } else if (p.a("SUCCESS", mapQRResponse.getStatus(), true)) {
                this.this$0.setResponseFlow(bVar);
            } else {
                this.this$0.showErrorLayout(mapQRResponse.getStatusMessage());
            }
        } else {
            this.this$0.showErrorLayout((String) null);
        }
    }
}
