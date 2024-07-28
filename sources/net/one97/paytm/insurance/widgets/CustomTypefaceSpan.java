package net.one97.paytm.insurance.widgets;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

public class CustomTypefaceSpan extends TypefaceSpan {

    /* renamed from: a  reason: collision with root package name */
    private final Typeface f14074a;

    public CustomTypefaceSpan(String str, Typeface typeface) {
        super(str);
        this.f14074a = typeface;
    }

    public void updateDrawState(TextPaint textPaint) {
        a(textPaint, this.f14074a);
    }

    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint, this.f14074a);
    }

    private static void a(Paint paint, Typeface typeface) {
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
