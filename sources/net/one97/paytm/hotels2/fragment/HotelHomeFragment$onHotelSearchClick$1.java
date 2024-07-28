package net.one97.paytm.hotels2.fragment;

import kotlin.g.b.n;
import kotlin.g.b.y;
import kotlin.k.d;
import net.one97.paytm.hotels2.entity.CJRHotelSearchInput;

final /* synthetic */ class HotelHomeFragment$onHotelSearchClick$1 extends n {
    HotelHomeFragment$onHotelSearchClick$1(HotelHomeFragment hotelHomeFragment) {
        super(hotelHomeFragment);
    }

    public final String getName() {
        return "mHotelSearchInput";
    }

    public final d getOwner() {
        return y.b(HotelHomeFragment.class);
    }

    public final String getSignature() {
        return "getMHotelSearchInput()Lnet/one97/paytm/hotels2/entity/CJRHotelSearchInput;";
    }

    public final Object get() {
        return HotelHomeFragment.access$getMHotelSearchInput$p((HotelHomeFragment) this.receiver);
    }

    public final void set(Object obj) {
        ((HotelHomeFragment) this.receiver).mHotelSearchInput = (CJRHotelSearchInput) obj;
    }
}
