package net.one97.paytm.hotels2.fragment;

import androidx.core.widget.NestedScrollView;
import kotlin.g.b.n;
import kotlin.g.b.y;
import kotlin.k.d;

final /* synthetic */ class HotelHomeFragment$createEndlessScroll$1 extends n {
    HotelHomeFragment$createEndlessScroll$1(HotelHomeFragment hotelHomeFragment) {
        super(hotelHomeFragment);
    }

    public final String getName() {
        return "nestedView";
    }

    public final d getOwner() {
        return y.b(HotelHomeFragment.class);
    }

    public final String getSignature() {
        return "getNestedView()Landroidx/core/widget/NestedScrollView;";
    }

    public final Object get() {
        return ((HotelHomeFragment) this.receiver).getNestedView();
    }

    public final void set(Object obj) {
        ((HotelHomeFragment) this.receiver).setNestedView((NestedScrollView) obj);
    }
}
