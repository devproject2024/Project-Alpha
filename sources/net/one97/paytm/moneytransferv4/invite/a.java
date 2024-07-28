package net.one97.paytm.moneytransferv4.invite;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LineBackgroundSpan;
import android.text.style.LineHeightSpan;
import android.widget.TextView;

public final class a implements LineBackgroundSpan, LineHeightSpan {

    /* renamed from: a  reason: collision with root package name */
    private Paint f55650a = new Paint();

    /* renamed from: b  reason: collision with root package name */
    private TextView f55651b;

    /* renamed from: c  reason: collision with root package name */
    private float f55652c;

    /* renamed from: d  reason: collision with root package name */
    private float f55653d;

    public a(TextView textView) {
        this.f55650a.setColor(-7829368);
        this.f55650a.setStyle(Paint.Style.STROKE);
        this.f55650a.setPathEffect(new DashPathEffect(new float[]{10.0f, 10.0f}, 0.0f));
        this.f55650a.setStrokeWidth(4.0f);
        this.f55651b = textView;
        this.f55652c = 4.0f;
        this.f55653d = 10.0f;
    }

    public final void chooseHeight(CharSequence charSequence, int i2, int i3, int i4, int i5, Paint.FontMetricsInt fontMetricsInt) {
        fontMetricsInt.ascent = (int) (((float) fontMetricsInt.ascent) - this.f55653d);
        fontMetricsInt.top = (int) (((float) fontMetricsInt.top) - this.f55653d);
        fontMetricsInt.descent = (int) (((float) fontMetricsInt.descent) + this.f55653d);
        fontMetricsInt.bottom = (int) (((float) fontMetricsInt.bottom) + this.f55653d);
    }

    public final void drawBackground(Canvas canvas, Paint paint, int i2, int i3, int i4, int i5, int i6, CharSequence charSequence, int i7, int i8, int i9) {
        int lineCount = this.f55651b.getLineCount();
        for (int i10 = 0; i10 < lineCount; i10++) {
            Layout layout = this.f55651b.getLayout();
            Canvas canvas2 = canvas;
            canvas2.drawLine(layout.getLineLeft(i10), this.f55652c + (((float) layout.getLineBottom(i10)) - this.f55653d), layout.getLineRight(i10), (((float) layout.getLineBottom(i10)) - this.f55653d) + this.f55652c, this.f55650a);
        }
    }
}
