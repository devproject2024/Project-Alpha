package net.one97.paytm.bankOpen.ica.view.stepview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.paytm.utility.b;
import kotlin.g.b.k;

public final class BankStepsView extends View {

    /* renamed from: a  reason: collision with root package name */
    public Paint f16629a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f16630b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f16631c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f16632d;

    /* renamed from: e  reason: collision with root package name */
    private int f16633e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f16634f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f16635g;

    /* renamed from: h  reason: collision with root package name */
    private float f16636h;

    public final int getMTotalSteps() {
        return this.f16633e;
    }

    public final void setMTotalSteps(int i2) {
        this.f16633e = i2;
    }

    public final int getMCurrentStep() {
        return this.f16634f;
    }

    public final void setMCurrentStep(int i2) {
        this.f16634f = i2;
    }

    public final Paint getMLinePaint() {
        Paint paint = this.f16629a;
        if (paint == null) {
            k.a("mLinePaint");
        }
        return paint;
    }

    public final void setMLinePaint(Paint paint) {
        k.c(paint, "<set-?>");
        this.f16629a = paint;
    }

    public final Paint getMDoneCirclePaint() {
        Paint paint = this.f16630b;
        if (paint == null) {
            k.a("mDoneCirclePaint");
        }
        return paint;
    }

    public final void setMDoneCirclePaint(Paint paint) {
        k.c(paint, "<set-?>");
        this.f16630b = paint;
    }

    public final Paint getMCurrentCirclePaint() {
        Paint paint = this.f16631c;
        if (paint == null) {
            k.a("mCurrentCirclePaint");
        }
        return paint;
    }

    public final void setMCurrentCirclePaint(Paint paint) {
        k.c(paint, "<set-?>");
        this.f16631c = paint;
    }

    public final Paint getMRemainingStepsCirclePaint() {
        Paint paint = this.f16632d;
        if (paint == null) {
            k.a("mRemainingStepsCirclePaint");
        }
        return paint;
    }

    public final void setMRemainingStepsCirclePaint(Paint paint) {
        k.c(paint, "<set-?>");
        this.f16632d = paint;
    }

    public final int getMCircleRadius() {
        return this.f16635g;
    }

    public final void setMCircleRadius(int i2) {
        this.f16635g = i2;
    }

    public final float getMLineHeight() {
        return this.f16636h;
    }

    public final void setMLineHeight(float f2) {
        this.f16636h = f2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BankStepsView(Context context) {
        super(context);
        k.c(context, "context");
        a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BankStepsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        k.c(attributeSet, "attributeSet");
        a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BankStepsView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        k.c(attributeSet, "attributeSet");
        a();
    }

    private void a() {
        this.f16629a = new Paint(1);
        this.f16630b = new Paint(1);
        this.f16631c = new Paint(1);
        this.f16632d = new Paint(1);
        Paint paint = this.f16629a;
        if (paint == null) {
            k.a("mLinePaint");
        }
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = this.f16630b;
        if (paint2 == null) {
            k.a("mDoneCirclePaint");
        }
        paint2.setStyle(Paint.Style.FILL);
        Paint paint3 = this.f16631c;
        if (paint3 == null) {
            k.a("mCurrentCirclePaint");
        }
        paint3.setStyle(Paint.Style.FILL);
        Paint paint4 = this.f16632d;
        if (paint4 == null) {
            k.a("mRemainingStepsCirclePaint");
        }
        paint4.setStyle(Paint.Style.FILL);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, (Paint) null);
        }
        this.f16635g = b.c(4);
        this.f16636h = (float) b.c(1);
        Paint paint5 = this.f16629a;
        if (paint5 == null) {
            k.a("mLinePaint");
        }
        paint5.setStrokeWidth(this.f16636h);
    }

    public final void a(int i2, int i3, int i4, int i5) {
        Paint paint = this.f16629a;
        if (paint == null) {
            k.a("mLinePaint");
        }
        paint.setColor(androidx.core.content.b.c(getContext(), i2));
        Paint paint2 = this.f16630b;
        if (paint2 == null) {
            k.a("mDoneCirclePaint");
        }
        paint2.setColor(androidx.core.content.b.c(getContext(), i3));
        Paint paint3 = this.f16631c;
        if (paint3 == null) {
            k.a("mCurrentCirclePaint");
        }
        paint3.setColor(androidx.core.content.b.c(getContext(), i4));
        Paint paint4 = this.f16632d;
        if (paint4 == null) {
            k.a("mRemainingStepsCirclePaint");
        }
        paint4.setColor(androidx.core.content.b.c(getContext(), i5));
        invalidate();
    }

    public static /* synthetic */ void setSteps$default(BankStepsView bankStepsView, Integer num, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = null;
        }
        bankStepsView.setSteps(num, i2);
    }

    public final void setSteps(Integer num, int i2) {
        if (num != null) {
            num.intValue();
            this.f16633e = num.intValue();
        }
        this.f16634f = i2;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        Paint paint;
        super.onDraw(canvas);
        if (this.f16633e >= 2) {
            if (canvas != null) {
                float f2 = (float) this.f16635g;
                float height = (float) (getHeight() / 2);
                float width = ((float) getWidth()) - ((float) this.f16635g);
                float height2 = (float) (getHeight() / 2);
                Paint paint2 = this.f16629a;
                if (paint2 == null) {
                    k.a("mLinePaint");
                }
                canvas.drawLine(f2, height, width, height2, paint2);
            }
            float f3 = (float) this.f16635g;
            int width2 = getWidth() - (this.f16635g * 2);
            int i2 = this.f16633e;
            int i3 = width2 / (i2 - 1);
            if (i2 > 0) {
                int i4 = 1;
                while (true) {
                    if (canvas != null) {
                        float height3 = (float) (getHeight() / 2);
                        float f4 = (float) this.f16635g;
                        int i5 = this.f16634f;
                        if (i4 < i5) {
                            paint = this.f16630b;
                            if (paint == null) {
                                k.a("mDoneCirclePaint");
                            }
                        } else if (i4 == i5) {
                            paint = this.f16631c;
                            if (paint == null) {
                                k.a("mCurrentCirclePaint");
                            }
                        } else {
                            paint = this.f16632d;
                            if (paint == null) {
                                k.a("mRemainingStepsCirclePaint");
                            }
                        }
                        canvas.drawCircle(f3, height3, f4, paint);
                    }
                    f3 += (float) i3;
                    if (i4 != i2) {
                        i4++;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
