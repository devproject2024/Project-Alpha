package net.one97.paytm.hotels2.fragment;

import android.view.View;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;

final class HotelHomeFragment$onCreateView$6 extends l implements b<View, x> {
    final /* synthetic */ HotelHomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HotelHomeFragment$onCreateView$6(HotelHomeFragment hotelHomeFragment) {
        super(1);
        this.this$0 = hotelHomeFragment;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return x.f47997a;
    }

    public final void invoke(View view) {
        k.c(view, "it");
        this.this$0.onHotelSearchClick();
    }
}
