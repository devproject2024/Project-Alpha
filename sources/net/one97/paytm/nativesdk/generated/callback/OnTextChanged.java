package net.one97.paytm.nativesdk.generated.callback;

import androidx.databinding.a.d;

public final class OnTextChanged implements d.c {
    final Listener mListener;
    final int mSourceId;

    public interface Listener {
        void _internalCallbackOnTextChanged(int i2, CharSequence charSequence, int i3, int i4, int i5);
    }

    public OnTextChanged(Listener listener, int i2) {
        this.mListener = listener;
        this.mSourceId = i2;
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        this.mListener._internalCallbackOnTextChanged(this.mSourceId, charSequence, i2, i3, i4);
    }
}
