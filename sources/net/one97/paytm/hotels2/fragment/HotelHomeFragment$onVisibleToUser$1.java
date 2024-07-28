package net.one97.paytm.hotels2.fragment;

final class HotelHomeFragment$onVisibleToUser$1 implements Runnable {
    final /* synthetic */ HotelHomeFragment this$0;

    HotelHomeFragment$onVisibleToUser$1(HotelHomeFragment hotelHomeFragment) {
        this.this$0 = hotelHomeFragment;
    }

    public final void run() {
        if (!this.this$0.isAdded() || this.this$0.isDetached()) {
            this.this$0.isStoreFrontFragmentAddPending = true;
        } else {
            this.this$0.createEndlessScroll();
        }
    }
}
