package net.one97.paytm.common.entity.vipcashback;

import com.paytm.network.model.IJRPaytmDataModel;

public final class TransactionsInfo extends IJRPaytmDataModel {
    private boolean isStageCompleted;
    private boolean isSuccessful;
    private String message;

    public final boolean isSuccessful() {
        return this.isSuccessful;
    }

    public final void setSuccessful(boolean z) {
        this.isSuccessful = z;
    }

    public final boolean isStageCompleted() {
        return this.isStageCompleted;
    }

    public final void setStageCompleted(boolean z) {
        this.isStageCompleted = z;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }
}
