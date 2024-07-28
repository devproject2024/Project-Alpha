package net.one97.paytm.dynamic.module.feed;

import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import net.one97.paytm.dynamic.module.feed.SheroesAuthModel;
import net.one97.paytm.feed.ui.feed.sheroes.SheroesActivity;

public final class InboxFeedHelper$getFeedCreadentials$networking$1 implements b {
    final /* synthetic */ SheroesActivity.c $listener;

    InboxFeedHelper$getFeedCreadentials$networking$1(SheroesActivity.c cVar) {
        this.$listener = cVar;
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        InboxFeedHelper.isSheroesNetworkApiInProcess = false;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof SheroesAuthModel) {
            SheroesAuthModel sheroesAuthModel = (SheroesAuthModel) iJRPaytmDataModel;
            SheroesAuthModel.Data data = sheroesAuthModel.getData();
            String str = null;
            String resourceOwnerId = data != null ? data.getResourceOwnerId() : null;
            SheroesAuthModel.Data data2 = sheroesAuthModel.getData();
            if (data2 != null) {
                str = data2.getAccess_token();
            }
            SheroesSdk.login(resourceOwnerId, str, new InboxFeedHelper$getFeedCreadentials$networking$1$onApiSuccess$1(this));
        }
    }
}
