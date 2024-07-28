package net.one97.paytm.hotels2.fragment;

import com.airbnb.lottie.h;
import kotlin.g.b.k;

final class HotelHomeFragment$downalodSrpLoaderAnimationJson$1<T> implements h<Throwable> {
    final /* synthetic */ HotelHomeFragment this$0;

    HotelHomeFragment$downalodSrpLoaderAnimationJson$1(HotelHomeFragment hotelHomeFragment) {
        this.this$0 = hotelHomeFragment;
    }

    public final void onResult(Throwable th) {
        HotelHomeFragment hotelHomeFragment = this.this$0;
        k.a((Object) th, "result");
        hotelHomeFragment.urlAnimationError(th);
    }
}
