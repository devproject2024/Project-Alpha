package com.paytmmall.clpartifact.widgets.component.smarticongrid;

import android.os.AsyncTask;
import androidx.lifecycle.y;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.modal.StringResponseModel;
import com.paytmmall.clpartifact.network.Resource;
import com.paytmmall.clpartifact.network.Status;
import kotlin.g.b.k;

public final class SmartIconGridRepository$callCategoryAPI$request$1 implements b {
    final /* synthetic */ boolean $forceCall;
    final /* synthetic */ y $liveData;

    SmartIconGridRepository$callCategoryAPI$request$1(y yVar, boolean z) {
        this.$liveData = yVar;
        this.$forceCall = z;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        k.c(iJRPaytmDataModel, "dataModel");
        if (iJRPaytmDataModel instanceof StringResponseModel) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new SmartIconGridRepository$callCategoryAPI$request$1$onApiSuccess$1(this, iJRPaytmDataModel));
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
        k.c(networkCustomError, "networkCustomError");
        try {
            if (this.$forceCall) {
                this.$liveData.setValue(new Resource.Builder().status(Status.FAIL).build());
            }
        } catch (Exception unused) {
        }
    }
}
