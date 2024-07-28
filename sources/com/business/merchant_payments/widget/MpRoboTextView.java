package com.business.merchant_payments.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.AppUtility;

public class MpRoboTextView extends AppCompatTextView {
    public MpRoboTextView(Context context) {
        super(context);
    }

    public MpRoboTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            setAttribute(context, attributeSet);
        }
    }

    public MpRoboTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        if (!isInEditMode()) {
            setAttribute(context, attributeSet);
        }
    }

    private void setAttribute(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MpRoboTextView);
        try {
            int integer = obtainStyledAttributes.getInteger(R.styleable.MpRoboTextView_mpfontTypeValue, 0);
            if (integer == 0) {
                return;
            }
            if (integer != 1) {
                if (integer != 2) {
                    if (integer != 3) {
                        if (integer != 4) {
                            if (integer == 5) {
                                if (AppUtility.getOSVersion() >= 14) {
                                    setTypeface(Typeface.create("sans-serif", 2));
                                } else {
                                    setTypeface((Typeface) null, 2);
                                }
                            }
                        } else if (AppUtility.getOSVersion() >= 14) {
                            setTypeface(Typeface.create("sans-serif", 1));
                        } else {
                            setTypeface((Typeface) null, 1);
                        }
                    } else if (AppUtility.getOSVersion() >= 14) {
                        setTypeface(Typeface.create("sans-serif-medium", 0));
                    } else {
                        setTypeface((Typeface) null, 1);
                    }
                } else if (AppUtility.getOSVersion() >= 14) {
                    setTypeface(Typeface.create("sans-serif", 0));
                } else {
                    setTypeface((Typeface) null, 0);
                }
            } else if (AppUtility.getOSVersion() >= 14) {
                setTypeface(Typeface.create("sans-serif-light", 0));
            } else {
                setTypeface((Typeface) null, 0);
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
