package com.travel.flight.span;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.g.b.k;

public final class a extends MetricAffectingSpan {

    /* renamed from: a  reason: collision with root package name */
    private final float f25498a = 0.25f;

    public final void updateMeasureState(TextPaint textPaint) {
        k.c(textPaint, "paint");
        textPaint.baselineShift += (int) (textPaint.ascent() * this.f25498a);
    }

    public final void updateDrawState(TextPaint textPaint) {
        k.c(textPaint, "ds");
        textPaint.baselineShift += (int) (textPaint.ascent() * this.f25498a);
    }
}
