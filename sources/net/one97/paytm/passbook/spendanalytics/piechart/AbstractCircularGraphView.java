package net.one97.paytm.passbook.spendanalytics.piechart;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import java.util.ArrayList;
import net.one97.paytm.passbook.R;

public abstract class AbstractCircularGraphView extends View implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    protected int f58578a;

    /* renamed from: b  reason: collision with root package name */
    protected ArrayList<a> f58579b;

    /* renamed from: c  reason: collision with root package name */
    protected float f58580c;

    /* renamed from: d  reason: collision with root package name */
    protected Paint f58581d;

    /* renamed from: e  reason: collision with root package name */
    private int f58582e;

    /* renamed from: f  reason: collision with root package name */
    private int f58583f;

    /* renamed from: g  reason: collision with root package name */
    private int f58584g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f58585h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f58586i;

    /* access modifiers changed from: protected */
    public abstract void a(int i2);

    public AbstractCircularGraphView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AbstractCircularGraphView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public AbstractCircularGraphView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f58582e = c(15);
        this.f58583f = c(20);
        this.f58584g = c(10);
        this.f58578a = -1;
        this.f58579b = new ArrayList<>();
        this.f58580c = 0.0f;
        this.f58581d = new Paint(1);
        this.f58581d.setStyle(Paint.Style.STROKE);
        this.f58585h = 0;
        if (getContext().obtainStyledAttributes(attributeSet, R.styleable.AbstractCircularGraphView).getBoolean(R.styleable.AbstractCircularGraphView_isTouchEnabled, false)) {
            setOnTouchListener(this);
        }
    }

    /* access modifiers changed from: protected */
    public final void a() {
        for (int i2 = 0; i2 < this.f58579b.size(); i2++) {
            this.f58580c += this.f58579b.get(i2).f58591b.floatValue();
        }
    }

    private int c(int i2) {
        return (int) TypedValue.applyDimension(1, (float) i2, getContext().getResources().getDisplayMetrics());
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i2;
        super.onDraw(canvas);
        ArrayList<a> arrayList = this.f58579b;
        if (arrayList != null && arrayList.size() != 0) {
            RectF rectF = new RectF();
            float f2 = (float) this.f58585h;
            int i3 = 0;
            while (i3 < this.f58579b.size()) {
                a aVar = this.f58579b.get(i3);
                this.f58581d.setColor(aVar.f58590a.intValue());
                float floatValue = aVar.a(this.f58580c).floatValue();
                if (i3 == this.f58578a) {
                    int i4 = this.f58584g;
                    int i5 = this.f58583f;
                    i2 = (i4 + (i5 >> 1)) - (i5 - this.f58582e);
                } else {
                    i2 = this.f58584g + (this.f58582e >> 1);
                }
                float f3 = (float) i2;
                rectF.set(f3, f3, ((float) getWidth()) - f3, ((float) getHeight()) - f3);
                this.f58581d.setStrokeWidth((float) (i3 == this.f58578a ? this.f58583f : this.f58582e));
                canvas.drawArc(rectF, f2, floatValue, false, this.f58581d);
                f2 += floatValue;
                i3++;
            }
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        float f2;
        if (this.f58586i) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            performHapticFeedback(1);
            int width = getWidth() >> 1;
            int i2 = x - width;
            int i3 = (y - width) * -1;
            if (((double) width) >= Math.sqrt((double) ((i2 * i2) + (i3 * i3)))) {
                float degrees = (float) Math.toDegrees(Math.atan(((double) i3) / ((double) i2)));
                float f3 = 0.0f;
                if (i2 <= 0 || i3 <= 0 || degrees <= 0.0f) {
                    if (i2 >= 0 || i3 <= 0 || degrees >= 0.0f) {
                        if (i2 < 0 && i3 < 0 && degrees > 0.0f) {
                            f2 = 180.0f;
                        } else if (i2 > 0 && i3 < 0 && degrees < 0.0f) {
                            f2 = 270.0f;
                            degrees += 90.0f;
                        }
                        degrees += f2;
                    } else {
                        degrees = degrees + 90.0f + 90.0f;
                    }
                }
                float f4 = (float) ((int) (360.0f - degrees));
                this.f58585h = (this.f58585h + 360) % 360;
                d();
                int i4 = this.f58585h;
                float f5 = ((float) i4) < f4 ? f4 - ((float) i4) : ((float) (360 - i4)) + f4;
                int i5 = 0;
                while (true) {
                    if (i5 >= this.f58579b.size()) {
                        break;
                    }
                    f3 += this.f58579b.get(i5).a(this.f58580c).floatValue();
                    if (f3 >= f5) {
                        this.f58578a = i5;
                        invalidate();
                        a(i5);
                        a(f4, this.f58579b.get(i5));
                        break;
                    }
                    i5++;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void d() {
        float f2 = (float) this.f58585h;
        for (int i2 = 0; i2 < this.f58579b.size(); i2++) {
            a aVar = this.f58579b.get(i2);
            aVar.f58592c = f2;
            f2 = (aVar.a(this.f58580c).floatValue() + f2) % 360.0f;
            aVar.f58593d = f2;
        }
    }

    private void a(float f2, a aVar) {
        float f3;
        float floatValue = aVar.a(this.f58580c).floatValue() / 2.0f;
        float f4 = f2 - aVar.f58592c;
        int i2 = (f2 > 270.0f ? 1 : (f2 == 270.0f ? 0 : -1));
        if (i2 <= 0 && f2 >= 90.0f) {
            f3 = (((((float) this.f58585h) + (270.0f - f2)) - (aVar.f58593d - f2)) + floatValue) % 360.0f;
        } else if (i2 > 0 || f2 == 0.0f) {
            f3 = (((((float) this.f58585h) - ((float) ((int) (f2 - 270.0f)))) + f4) - floatValue) % 360.0f;
        } else {
            f3 = ((((((float) this.f58585h) - ((float) ((int) (f2 + 90.0f)))) + f4) - floatValue) % 360.0f) + 360.0f;
        }
        float abs = Math.abs(((float) this.f58585h) - f3);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) this.f58585h, f3});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = AbstractCircularGraphView.this.f58585h = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AbstractCircularGraphView.this.invalidate();
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
                boolean unused = AbstractCircularGraphView.this.f58586i = true;
            }

            public final void onAnimationEnd(Animator animator) {
                boolean unused = AbstractCircularGraphView.this.f58586i = false;
                AbstractCircularGraphView.this.d();
            }

            public final void onAnimationCancel(Animator animator) {
                boolean unused = AbstractCircularGraphView.this.f58586i = false;
            }

            public final void onAnimationRepeat(Animator animator) {
                boolean unused = AbstractCircularGraphView.this.f58586i = true;
            }
        });
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setDuration((long) (((abs * 1000.0f) / 360.0f) + 250.0f));
        ofFloat.start();
    }

    public final void b() {
        this.f58578a = -1;
        invalidate();
    }

    public final void b(int i2) {
        ArrayList<a> arrayList = this.f58579b;
        if (arrayList == null) {
            throw new IllegalArgumentException("No record found");
        } else if (i2 < 0 || i2 >= arrayList.size()) {
            throw new IllegalArgumentException("Invalid index");
        } else {
            this.f58578a = i2;
            a aVar = this.f58579b.get(i2);
            if (aVar.f58592c == aVar.f58593d) {
                d();
            }
            a(aVar.f58592c + 1.0f, aVar);
            a(i2);
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        this.f58578a = -1;
        this.f58579b.clear();
        this.f58580c = 0.0f;
        this.f58585h = 0;
        this.f58586i = false;
    }
}
