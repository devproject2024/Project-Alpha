package com.paytmmall.clpartifact.customViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.utils.CLPConstants;

public class CLPRobotoTextView extends AppCompatTextView {

    public interface FontType {
        public static final int ROBOTOBOLD = 4;
        public static final int ROBOTOITALIC = 5;
        public static final int ROBOTOLIGHT = 1;
        public static final int ROBOTOMEDIUM = 3;
        public static final int ROBOTOREGULAR = 2;
    }

    public CLPRobotoTextView(Context context) {
        super(context);
        if (!isInEditMode()) {
            init();
        }
    }

    public CLPRobotoTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            setAttribute(context, attributeSet);
        }
    }

    public CLPRobotoTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        if (!isInEditMode()) {
            setAttribute(context, attributeSet);
        }
    }

    private void setAttribute(Context context, AttributeSet attributeSet) {
        ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CLPRobotoTextView);
        try {
            int integer = obtainStyledAttributes.getInteger(R.styleable.CLPRobotoTextView_clpFontType, 0);
            if (integer == 0) {
                return;
            }
            if (integer != 1) {
                if (integer != 2) {
                    if (integer != 3) {
                        if (integer != 4) {
                            if (integer == 5) {
                                if (communicationListener == null || communicationListener.getOSVersion() < 14) {
                                    setTypeface((Typeface) null, 2);
                                } else {
                                    setTypeface(Typeface.create("sans-serif", 2));
                                }
                            }
                        } else if (communicationListener == null || communicationListener.getOSVersion() < 14) {
                            setTypeface((Typeface) null, 1);
                        } else {
                            setTypeface(Typeface.create("sans-serif", 1));
                        }
                    } else if (communicationListener == null || communicationListener.getOSVersion() < 14) {
                        setTypeface((Typeface) null, 1);
                    } else {
                        setTypeface(Typeface.create("sans-serif-medium", 0));
                    }
                } else if (communicationListener == null || communicationListener.getOSVersion() < 14) {
                    setTypeface((Typeface) null, 0);
                } else {
                    setTypeface(Typeface.create("sans-serif", 0));
                }
            } else if (communicationListener == null || communicationListener.getOSVersion() < 14) {
                setTypeface((Typeface) null, 0);
            } else {
                setTypeface(Typeface.create("sans-serif-light", 0));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void init() {
        if (!isInEditMode()) {
            try {
                if (getTypeface() != null) {
                    if (getTypeface() == null || getTypeface().equals(Typefaces.get(getContext(), CLPConstants.FONT_ROBOTO_LIGHT))) {
                        return;
                    }
                }
                setTypeface(Typefaces.get(getContext(), CLPConstants.FONT_ROBOTO_LIGHT));
            } catch (Exception unused) {
            }
        }
    }

    public void setFontType(int i2) {
        if (i2 != 0) {
            ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 == 5) {
                                if (communicationListener == null || communicationListener.getOSVersion() < 14) {
                                    setTypeface((Typeface) null, 2);
                                } else {
                                    setTypeface(Typeface.create("sans-serif", 2));
                                }
                            }
                        } else if (communicationListener == null || communicationListener.getOSVersion() < 14) {
                            setTypeface((Typeface) null, 1);
                        } else {
                            setTypeface(Typeface.create("sans-serif", 1));
                        }
                    } else if (communicationListener == null || communicationListener.getOSVersion() < 14) {
                        setTypeface((Typeface) null, 1);
                    } else {
                        setTypeface(Typeface.create("sans-serif-medium", 0));
                    }
                } else if (communicationListener == null || communicationListener.getOSVersion() < 14) {
                    setTypeface((Typeface) null, 0);
                } else {
                    setTypeface(Typeface.create("sans-serif", 0));
                }
            } else if (communicationListener == null || communicationListener.getOSVersion() < 14) {
                setTypeface((Typeface) null, 0);
            } else {
                setTypeface(Typeface.create("sans-serif-light", 0));
            }
        }
        invalidate();
    }
}
