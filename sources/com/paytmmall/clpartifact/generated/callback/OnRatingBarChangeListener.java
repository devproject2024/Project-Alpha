package com.paytmmall.clpartifact.generated.callback;

import android.widget.RatingBar;

public final class OnRatingBarChangeListener implements RatingBar.OnRatingBarChangeListener {
    final Listener mListener;
    final int mSourceId;

    public interface Listener {
        void _internalCallbackOnRatingChanged(int i2, RatingBar ratingBar, float f2, boolean z);
    }

    public OnRatingBarChangeListener(Listener listener, int i2) {
        this.mListener = listener;
        this.mSourceId = i2;
    }

    public final void onRatingChanged(RatingBar ratingBar, float f2, boolean z) {
        this.mListener._internalCallbackOnRatingChanged(this.mSourceId, ratingBar, f2, z);
    }
}
