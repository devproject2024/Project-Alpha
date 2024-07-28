package net.one97.paytm.dynamic.module.feed;

import androidx.fragment.app.Fragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;

public final class InboxFeedHelper$getFeedCreadentials$networking$1$onApiSuccess$1 implements SheroesSdk.LogInCallback {
    final /* synthetic */ InboxFeedHelper$getFeedCreadentials$networking$1 this$0;

    InboxFeedHelper$getFeedCreadentials$networking$1$onApiSuccess$1(InboxFeedHelper$getFeedCreadentials$networking$1 inboxFeedHelper$getFeedCreadentials$networking$1) {
        this.this$0 = inboxFeedHelper$getFeedCreadentials$networking$1;
    }

    public final void onLoggedInSuccess() {
        InboxFeedHelper.isSheroesNetworkApiInProcess = false;
        this.this$0.$listener.getSheroesFragment(SheroesSdk.getFeedFragment());
    }

    public final void onFailure() {
        InboxFeedHelper.isSheroesNetworkApiInProcess = false;
        this.this$0.$listener.getSheroesFragment((Fragment) null);
    }
}
