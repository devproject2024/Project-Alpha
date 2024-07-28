package net.one97.paytm.oauth.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.oauth.R;

public final class CircleProgressBar extends View {

    /* renamed from: a  reason: collision with root package name */
    private final float f56816a;

    /* renamed from: b  reason: collision with root package name */
    private final float f56817b;

    /* renamed from: c  reason: collision with root package name */
    private int f56818c;

    /* renamed from: d  reason: collision with root package name */
    private int f56819d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f56820e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f56821f;

    /* renamed from: g  reason: collision with root package name */
    private float f56822g;

    /* renamed from: h  reason: collision with root package name */
    private final RectF f56823h;

    /* renamed from: i  reason: collision with root package name */
    private float f56824i;
    private float j;
    private float k;

    public CircleProgressBar(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CircleProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        this.f56816a = 10.0f;
        this.f56817b = 10.0f;
        this.f56818c = Color.parseColor("#e2ebee");
        this.f56819d = Color.parseColor("#21c17a");
        setUpUi(attributeSet);
        Paint paint = new Paint();
        paint.setColor(this.f56818c);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f56816a);
        paint.setAntiAlias(true);
        this.f56820e = paint;
        Paint paint2 = new Paint();
        paint2.setColor(this.f56819d);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(this.f56817b);
        paint2.setAntiAlias(true);
        this.f56821f = paint2;
        this.f56823h = new RectF();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CircleProgressBar(Context context, AttributeSet attributeSet, int i2, int i3, g gVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void setUpUi(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.OauthCircleProgressBar);
            String string = obtainStyledAttributes.getString(R.styleable.OauthCircleProgressBar_oauthBgColor);
            if (!TextUtils.isEmpty(string)) {
                this.f56818c = Color.parseColor(string);
            }
            String string2 = obtainStyledAttributes.getString(R.styleable.OauthCircleProgressBar_oauthProgressColor);
            if (!TextUtils.isEmpty(string2)) {
                this.f56819d = Color.parseColor(string2);
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final float getProgress() {
        return this.f56822g;
    }

    public final void setProgress(float f2) {
        this.f56822g = f2;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        float f2 = ((float) i2) / 2.0f;
        this.f56824i = f2;
        this.j = ((float) i3) / 2.0f;
        this.k = f2 - this.f56817b;
        RectF rectF = this.f56823h;
        float f3 = this.f56824i;
        float f4 = this.k;
        float f5 = this.j;
        rectF.set(f3 - f4, f5 - f4, f3 + f4, f5 + f4);
        super.onSizeChanged(i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {
            canvas.drawCircle(this.f56824i, this.j, this.k, this.f56820e);
        }
        if (canvas != null) {
            canvas.drawArc(this.f56823h, 270.0f, this.f56822g * 360.0f, false, this.f56821f);
        }
    }
}
