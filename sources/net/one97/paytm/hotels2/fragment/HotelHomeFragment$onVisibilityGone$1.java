package net.one97.paytm.hotels2.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import kotlin.g.b.k;

final class HotelHomeFragment$onVisibilityGone$1 implements Runnable {
    final /* synthetic */ HotelHomeFragment this$0;

    HotelHomeFragment$onVisibilityGone$1(HotelHomeFragment hotelHomeFragment) {
        this.this$0 = hotelHomeFragment;
    }

    public final void run() {
        if (this.this$0.mEndlessScrollFragment != null && this.this$0.isAdded() && !this.this$0.isDetached()) {
            q a2 = this.this$0.getChildFragmentManager().a();
            Fragment access$getMEndlessScrollFragment$p = this.this$0.mEndlessScrollFragment;
            if (access$getMEndlessScrollFragment$p == null) {
                k.a();
            }
            a2.a(access$getMEndlessScrollFragment$p).b();
        }
    }
}
