package net.one97.paytm.upi.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;
import net.one97.paytm.upi.R;

public class RoboTextView extends TextView {

    public interface FontType {
        public static final int ROBOTOBOLD = 4;
        public static final int ROBOTOITALIC = 5;
        public static final int ROBOTOLIGHT = 1;
        public static final int ROBOTOMEDIUM = 3;
        public static final int ROBOTOREGULAR = 2;
    }

    public RoboTextView(Context context) {
        super(context);
        if (!isInEditMode()) {
            init();
        }
    }

    public RoboTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            setAttribute(context, attributeSet);
        }
    }

    public RoboTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        if (!isInEditMode()) {
            setAttribute(context, attributeSet);
        }
    }

    private void setAttribute(Context context, AttributeSet attributeSet) {
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
                                if (Build.VERSION.SDK_INT >= 14) {
                                    setTypeface(Typeface.create("sans-serif", 2));
                                } else {
                                    setTypeface((Typeface) null, 2);
                                }
                            }
                        } else if (Build.VERSION.SDK_INT >= 14) {
                            setTypeface(Typeface.create("sans-serif", 1));
                        } else {
                            setTypeface((Typeface) null, 1);
                        }
                    } else if (Build.VERSION.SDK_INT >= 14) {
                        setTypeface(Typeface.create("sans-serif-medium", 0));
                    } else {
                        setTypeface((Typeface) null, 1);
                    }
                } else if (Build.VERSION.SDK_INT >= 14) {
                    setTypeface(Typeface.create("sans-serif", 0));
                } else {
                    setTypeface((Typeface) null, 0);
                }
            } else if (Build.VERSION.SDK_INT >= 14) {
                setTypeface(Typeface.create("sans-serif-light", 0));
            } else {
                setTypeface((Typeface) null, 0);
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void init() {
        isInEditMode();
    }

    public void setFontType(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 == 5) {
                                if (Build.VERSION.SDK_INT >= 14) {
                                    setTypeface(Typeface.create("sans-serif", 2));
                                } else {
                                    setTypeface((Typeface) null, 2);
                                }
                            }
                        } else if (Build.VERSION.SDK_INT >= 14) {
                            setTypeface(Typeface.create("sans-serif", 1));
                        } else {
                            setTypeface((Typeface) null, 1);
                        }
                    } else if (Build.VERSION.SDK_INT >= 14) {
                        setTypeface(Typeface.create("sans-serif-medium", 0));
                    } else {
                        setTypeface((Typeface) null, 1);
                    }
                } else if (Build.VERSION.SDK_INT >= 14) {
                    setTypeface(Typeface.create("sans-serif", 0));
                } else {
                    setTypeface((Typeface) null, 0);
                }
            } else if (Build.VERSION.SDK_INT >= 14) {
                setTypeface(Typeface.create("sans-serif-light", 0));
            } else {
                setTypeface((Typeface) null, 0);
            }
        }
        invalidate();
    }
}
