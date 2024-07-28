package net.one97.paytm.wallet.entity;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;

public class CardExpiryEditText extends AppCompatEditText {
    public CardExpiryEditText(Context context) {
        super(context);
    }

    public CardExpiryEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CardExpiryEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onSelectionChanged(int i2, int i3) {
        setSelection(length());
    }
}
