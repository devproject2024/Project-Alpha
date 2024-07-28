package net.one97.paytm.hotels2.fragment;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.u;
import net.one97.paytm.hotels2.utils.c;

final class HotelHomeFragment$onCreateView$4 implements ViewTreeObserver.OnScrollChangedListener {
    final /* synthetic */ HotelHomeFragment this$0;

    HotelHomeFragment$onCreateView$4(HotelHomeFragment hotelHomeFragment) {
        this.this$0 = hotelHomeFragment;
    }

    public final void onScrollChanged() {
        View childAt = this.this$0.getNestedView().getChildAt(this.this$0.getNestedView().getChildCount() - 1);
        if (childAt == null) {
            throw new u("null cannot be cast to non-null type android.view.View");
        } else if (childAt.getBottom() - (this.this$0.getNestedView().getHeight() + this.this$0.getNestedView().getScrollY()) == 0) {
            if (this.this$0.mEndlessScrollFragment != null && this.this$0.shouldRequestForLoadMore()) {
                c.b().a(this.this$0.mEndlessScrollFragment);
            }
        } else if (this.this$0.mEndlessScrollFragment != null) {
            c.b().b(this.this$0.mEndlessScrollFragment);
        }
    }
}
