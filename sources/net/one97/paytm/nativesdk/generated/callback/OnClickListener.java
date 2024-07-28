package net.one97.paytm.nativesdk.generated.callback;

import android.view.View;

public final class OnClickListener implements View.OnClickListener {
    final Listener mListener;
    final int mSourceId;

    public interface Listener {
        void _internalCallbackOnClick(int i2, View view);
    }

    public OnClickListener(Listener listener, int i2) {
        this.mListener = listener;
        this.mSourceId = i2;
    }

    public final void onClick(View view) {
        this.mListener._internalCallbackOnClick(this.mSourceId, view);
    }
}
