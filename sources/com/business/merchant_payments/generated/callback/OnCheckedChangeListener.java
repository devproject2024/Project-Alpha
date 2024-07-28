package com.business.merchant_payments.generated.callback;

import android.widget.CompoundButton;

public final class OnCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {
    public final Listener mListener;
    public final int mSourceId;

    public interface Listener {
        void _internalCallbackOnCheckedChanged(int i2, CompoundButton compoundButton, boolean z);
    }

    public OnCheckedChangeListener(Listener listener, int i2) {
        this.mListener = listener;
        this.mSourceId = i2;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.mListener._internalCallbackOnCheckedChanged(this.mSourceId, compoundButton, z);
    }
}
