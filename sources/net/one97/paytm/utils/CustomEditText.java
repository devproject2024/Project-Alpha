package net.one97.paytm.utils;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.AttributeSet;
import com.google.android.material.textfield.TextInputEditText;

public class CustomEditText extends TextInputEditText {
    public CustomEditText(Context context) {
        super(context);
        a();
    }

    public CustomEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public CustomEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        setFilters(new InputFilter[]{new a(this, (byte) 0)});
    }

    class a implements InputFilter {
        private a() {
        }

        /* synthetic */ a(CustomEditText customEditText, byte b2) {
            this();
        }

        public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            while (i2 < i3) {
                int type = Character.getType(charSequence.charAt(i2));
                if (!Character.isLetterOrDigit(charSequence.charAt(i2)) && type != 12) {
                    return "";
                }
                i2++;
            }
            return null;
        }
    }
}
