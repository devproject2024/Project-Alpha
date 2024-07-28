package net.one97.paytm.nativesdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;

public class CharacterWrapTextView extends AppCompatTextView {
    public CharacterWrapTextView(Context context) {
        super(context);
    }

    public CharacterWrapTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CharacterWrapTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence.toString().replaceAll(".(?!$)", "$0​"), bufferType);
    }
}
