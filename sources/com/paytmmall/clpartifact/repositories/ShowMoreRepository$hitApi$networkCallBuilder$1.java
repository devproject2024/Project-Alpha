package com.paytmmall.clpartifact.repositories;

import android.os.AsyncTask;
import androidx.lifecycle.y;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.modal.StringResponseModel;
import com.paytmmall.clpartifact.network.RequestType;

public final class ShowMoreRepository$hitApi$networkCallBuilder$1 implements b {
    final /* synthetic */ y $liveData;
    final /* synthetic */ ShowMoreRepository this$0;

    ShowMoreRepository$hitApi$networkCallBuilder$1(ShowMoreRepository showMoreRepository, y yVar) {
        this.this$0 = showMoreRepository;
        this.$liveData = yVar;
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.this$0.handleErrorResponse(this.$liveData, RequestType.REFRESH, networkCustomError);
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof StringResponseModel) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new ShowMoreRepository$hitApi$networkCallBuilder$1$onApiSuccess$1(this, iJRPaytmDataModel));
        }
    }
}
