package net.one97.paytm.nativesdk.Utils;

import androidx.lifecycle.z;

final class SingleLiveEvent$observe$1<T> implements z<T> {
    final /* synthetic */ z $observer;
    final /* synthetic */ SingleLiveEvent this$0;

    SingleLiveEvent$observe$1(SingleLiveEvent singleLiveEvent, z zVar) {
        this.this$0 = singleLiveEvent;
        this.$observer = zVar;
    }

    public final void onChanged(T t) {
        if (this.this$0.pending.compareAndSet(true, false)) {
            this.$observer.onChanged(t);
        }
    }
}
