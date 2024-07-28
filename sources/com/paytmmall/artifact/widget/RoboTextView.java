package com.paytmmall.artifact.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.d.d;
import com.paytmmall.clpartifact.utils.CLPConstants;

public class RoboTextView extends AppCompatTextView {
    public RoboTextView(Context context) {
        super(context);
        if (!isInEditMode() && !isInEditMode()) {
            try {
                if (getTypeface() != null) {
                    if (getTypeface() == null || getTypeface().equals(a.a(getContext(), CLPConstants.FONT_ROBOTO_LIGHT))) {
                        return;
                    }
                }
                setTypeface(a.a(getContext(), CLPConstants.FONT_ROBOTO_LIGHT));
            } catch (Exception unused) {
            }
        }
    }

    public RoboTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            a(context, attributeSet);
        }
    }

    public RoboTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        if (!isInEditMode()) {
            a(context, attributeSet);
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoboTextView);
        try {
            int integer = obtainStyledAttributes.getInteger(R.styleable.RoboTextView_fontType, 0);
            if (integer == 0) {
                return;
            }
            if (integer != 1) {
                if (integer != 2) {
                    if (integer != 3) {
                        if (integer != 4) {
                            if (integer == 5) {
                                if (d.j() >= 14) {
                                    setTypeface(Typeface.create("sans-serif", 2));
                                } else {
                                    setTypeface((Typeface) null, 2);
                                }
                            }
                        } else if (d.j() >= 14) {
                            setTypeface(Typeface.create("sans-serif", 1));
                        } else {
                            setTypeface((Typeface) null, 1);
                        }
                    } else if (d.j() >= 14) {
                        setTypeface(Typeface.create("sans-serif-medium", 0));
                    } else {
                        setTypeface((Typeface) null, 1);
                    }
                } else if (d.j() >= 14) {
                    setTypeface(Typeface.create("sans-serif", 0));
                } else {
                    setTypeface((Typeface) null, 0);
                }
            } else if (d.j() >= 14) {
                setTypeface(Typeface.create("sans-serif-light", 0));
            } else {
                setTypeface((Typeface) null, 0);
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setFontType(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 == 5) {
                                if (d.j() >= 14) {
                                    setTypeface(Typeface.create("sans-serif", 2));
                                } else {
                                    setTypeface((Typeface) null, 2);
                                }
                            }
                        } else if (d.j() >= 14) {
                            setTypeface(Typeface.create("sans-serif", 1));
                        } else {
                            setTypeface((Typeface) null, 1);
                        }
                    } else if (d.j() >= 14) {
                        setTypeface(Typeface.create("sans-serif-medium", 0));
                    } else {
                        setTypeface((Typeface) null, 1);
                    }
                } else if (d.j() >= 14) {
                    setTypeface(Typeface.create("sans-serif", 0));
                } else {
                    setTypeface((Typeface) null, 0);
                }
            } else if (d.j() >= 14) {
                setTypeface(Typeface.create("sans-serif-light", 0));
            } else {
                setTypeface((Typeface) null, 0);
            }
        }
        invalidate();
    }
}
