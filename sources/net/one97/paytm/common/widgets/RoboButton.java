package net.one97.paytm.common.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.paytm.utility.b;

public class RoboButton extends AppCompatButton {
    public RoboButton(Context context) {
        super(context);
    }

    public RoboButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public RoboButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoboTextView);
        try {
            int integer = obtainStyledAttributes.getInteger(R.styleable.RoboTextView_fontType, 0);
            if (integer != 0) {
                if (integer != 1) {
                    if (integer != 2) {
                        if (integer != 3) {
                            if (integer == 4) {
                                if (b.d() >= 14) {
                                    setTypeface(Typeface.create("sans-serif", 1));
                                    return;
                                } else {
                                    setTypeface((Typeface) null, 1);
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else if (b.d() >= 14) {
                            setTypeface(Typeface.create("sans-serif-medium", 0));
                            return;
                        } else {
                            setTypeface((Typeface) null, 1);
                            return;
                        }
                    }
                } else if (b.d() >= 14) {
                    setTypeface(Typeface.create("sans-serif-light", 0));
                } else {
                    setTypeface((Typeface) null, 0);
                }
                if (b.d() >= 14) {
                    setTypeface(Typeface.create("sans-serif", 0));
                } else {
                    setTypeface((Typeface) null, 0);
                }
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
