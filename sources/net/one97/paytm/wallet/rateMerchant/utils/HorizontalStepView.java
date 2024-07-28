package net.one97.paytm.wallet.rateMerchant.utils;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.wallet.R;

public final class HorizontalStepView extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f71713a;

    /* renamed from: b  reason: collision with root package name */
    private final int f71714b;

    /* renamed from: c  reason: collision with root package name */
    private final int f71715c;

    /* renamed from: d  reason: collision with root package name */
    private final int f71716d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f71717e;

    /* renamed from: f  reason: collision with root package name */
    private int f71718f;

    /* renamed from: g  reason: collision with root package name */
    private final List<a> f71719g;

    /* renamed from: h  reason: collision with root package name */
    private int f71720h;

    public HorizontalStepView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public HorizontalStepView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HorizontalStepView(Context context, AttributeSet attributeSet, int i2, int i3, g gVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HorizontalStepView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        this.f71719g = new ArrayList();
        this.f71720h = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HorizontalStepView);
        this.f71713a = obtainStyledAttributes.getInt(R.styleable.HorizontalStepView_stepCount, 3);
        this.f71714b = obtainStyledAttributes.getColor(R.styleable.HorizontalStepView_stepColor, Color.parseColor("#21c17a"));
        this.f71715c = obtainStyledAttributes.getColor(R.styleable.HorizontalStepView_stepColor, Color.parseColor("#e2ebee"));
        int i3 = R.styleable.HorizontalStepView_stepGap;
        k.c(context, "context");
        Resources resources = context.getResources();
        k.a((Object) resources, "resources");
        this.f71716d = obtainStyledAttributes.getInt(i3, (int) ((((float) resources.getDisplayMetrics().densityDpi) / 160.0f) * 12.0f));
        this.f71717e = new Paint(1);
        Paint paint = this.f71717e;
        paint.setAntiAlias(true);
        paint.setColor(this.f71715c);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10.0f);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        obtainStyledAttributes.recycle();
        c();
    }

    public final void setStepCount(int i2) {
        this.f71713a = i2;
        b();
    }

    private final void c() {
        this.f71719g.clear();
        int i2 = this.f71713a;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f71719g.add(new a(i3));
        }
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        if (canvas != null) {
            float height = (float) (getHeight() / 2);
            float paddingLeft = (float) getPaddingLeft();
            for (a aVar : this.f71719g) {
                if (aVar.f71721a) {
                    this.f71717e.setColor(this.f71714b);
                } else {
                    this.f71717e.setColor(this.f71715c);
                }
                canvas.drawLine(paddingLeft, height, paddingLeft + ((float) this.f71718f), height, this.f71717e);
                paddingLeft += (float) (this.f71718f + this.f71716d);
            }
        }
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f71718f = (((getWidth() - (this.f71716d * (this.f71713a - 1))) - getPaddingLeft()) - getPaddingRight()) / this.f71713a;
    }

    public final void a() {
        int i2 = this.f71720h;
        if (i2 < this.f71713a - 1) {
            this.f71720h = i2 + 1;
            this.f71719g.get(this.f71720h).f71721a = true;
            invalidate();
        }
    }

    public final void b() {
        this.f71720h = -1;
        c();
        invalidate();
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f71721a = false;

        /* renamed from: b  reason: collision with root package name */
        private final int f71722b;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (this.f71722b == aVar.f71722b) {
                        if (this.f71721a == aVar.f71721a) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            int i2 = this.f71722b * 31;
            boolean z = this.f71721a;
            if (z) {
                z = true;
            }
            return i2 + (z ? 1 : 0);
        }

        public final String toString() {
            return "StepData(stepPos=" + this.f71722b + ", isCompleted=" + this.f71721a + ")";
        }

        public a(int i2) {
            this.f71722b = i2;
        }
    }
}
