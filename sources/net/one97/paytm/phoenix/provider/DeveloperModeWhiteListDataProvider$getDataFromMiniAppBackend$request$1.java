package net.one97.paytm.phoenix.provider;

import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.h5.model.H5AppDetailsForUserModel;

public final class DeveloperModeWhiteListDataProvider$getDataFromMiniAppBackend$request$1 implements b {
    final /* synthetic */ UserWhitelistedForDeveloperModeCallback $callback;

    DeveloperModeWhiteListDataProvider$getDataFromMiniAppBackend$request$1(UserWhitelistedForDeveloperModeCallback userWhitelistedForDeveloperModeCallback) {
        this.$callback = userWhitelistedForDeveloperModeCallback;
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.$callback.onError();
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (!(iJRPaytmDataModel instanceof H5AppDetailsForUserModel) || !((H5AppDetailsForUserModel) iJRPaytmDataModel).getCode().equals("SR_2000")) {
            this.$callback.onError();
        } else {
            this.$callback.onSuccess();
        }
    }
}
