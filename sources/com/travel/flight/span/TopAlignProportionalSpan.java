package com.travel.flight.span;

import android.text.TextPaint;
import android.text.style.SuperscriptSpan;

public class TopAlignProportionalSpan extends SuperscriptSpan {

    /* renamed from: a  reason: collision with root package name */
    protected float f25496a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f25497b;

    public TopAlignProportionalSpan(float f2) {
        this.f25496a = 1.0f;
        this.f25497b = false;
        this.f25497b = false;
        if (f2 > 0.0f && f2 < 1.0f) {
            this.f25496a = f2;
        }
    }

    public TopAlignProportionalSpan() {
        this.f25496a = 1.0f;
        this.f25497b = false;
        this.f25497b = true;
        this.f25496a = 0.9f;
    }

    public void updateDrawState(TextPaint textPaint) {
        float textSize = textPaint.getTextSize() * this.f25496a;
        float f2 = textPaint.getFontMetrics().ascent;
        textPaint.setTextSize(textSize);
        float f3 = textPaint.getFontMetrics().ascent;
        if (this.f25497b) {
            textPaint.baselineShift = (int) (((float) textPaint.baselineShift) - ((f2 - f3) + 2.0f));
        } else {
            textPaint.baselineShift = (int) (((float) textPaint.baselineShift) + (f2 - f3) + 2.0f);
        }
    }

    public void updateMeasureState(TextPaint textPaint) {
        updateDrawState(textPaint);
    }
}
