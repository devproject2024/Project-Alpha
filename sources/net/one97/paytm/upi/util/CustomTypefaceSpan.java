package net.one97.paytm.upi.util;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

public class CustomTypefaceSpan extends TypefaceSpan {
    private final Typeface newType;

    public CustomTypefaceSpan(String str, Typeface typeface) {
        super(str);
        this.newType = typeface;
    }

    public CustomTypefaceSpan(Typeface typeface) {
        super("");
        this.newType = typeface;
    }

    public void updateDrawState(TextPaint textPaint) {
        applyCustomTypeFace(textPaint, this.newType);
    }

    public void updateMeasureState(TextPaint textPaint) {
        applyCustomTypeFace(textPaint, this.newType);
    }

    private static void applyCustomTypeFace(Paint paint, Typeface typeface) {
        int i2;
        Typeface typeface2 = paint.getTypeface();
        if (typeface2 == null) {
            i2 = 0;
        } else {
            i2 = typeface2.getStyle();
        }
        int i3 = i2 & (~typeface.getStyle());
        if ((i3 & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((i3 & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(typeface);
    }
}
