package com.travel.flight.flightticket.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import com.travel.flight.R;
import java.lang.Number;
import java.math.BigDecimal;

public class RangeSeekBarFlight<T extends Number> extends ImageView {

    /* renamed from: c  reason: collision with root package name */
    public static final int f25304c = Color.rgb(0, 185, 245);

    /* renamed from: a  reason: collision with root package name */
    protected final a f25305a;

    /* renamed from: b  reason: collision with root package name */
    protected c f25306b = null;

    /* renamed from: d  reason: collision with root package name */
    protected int f25307d = PriceRangeSeekBar.INVALID_POINTER_ID;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f25308e = new Paint(1);

    /* renamed from: f  reason: collision with root package name */
    private final Bitmap f25309f = BitmapFactory.decodeResource(getResources(), R.drawable.pre_f_seekbar_thumb);

    /* renamed from: g  reason: collision with root package name */
    private final Bitmap f25310g = BitmapFactory.decodeResource(getResources(), R.drawable.pre_f_seekbar_thumb);

    /* renamed from: h  reason: collision with root package name */
    private final float f25311h = ((float) this.f25309f.getWidth());

    /* renamed from: i  reason: collision with root package name */
    private final float f25312i = (this.f25311h * 0.5f);
    private final float j = (((float) this.f25309f.getHeight()) * 0.5f);
    private final float k = (this.j * 0.2f);
    private final float l = this.f25312i;
    private final T m;
    private final T n;
    private final double o;
    private final double p;
    private double q = 0.0d;
    private double r = 1.0d;
    private boolean s = false;
    private b<T> t;
    private boolean u = true;
    private float v;
    private int w;
    private boolean x;

    public interface b<T> {
        void a(T t, T t2);
    }

    protected enum c {
        MIN,
        MAX
    }

    public void setMinThumbEnable(boolean z) {
        this.u = z;
        invalidate();
    }

    public RangeSeekBarFlight(T t2, T t3, Context context) throws IllegalArgumentException {
        super(context);
        this.m = t2;
        this.n = t3;
        this.o = t2.doubleValue();
        this.p = t3.doubleValue();
        this.f25305a = a.fromNumber(t2);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.w = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public void setNotifyWhileDragging(boolean z) {
        this.s = z;
    }

    public T getAbsoluteMinValue() {
        return this.m;
    }

    public T getAbsoluteMaxValue() {
        return this.n;
    }

    public T getSelectedMinValue() {
        return a(this.q);
    }

    public void setSelectedMinValue(T t2) {
        if (0.0d == this.p - this.o) {
            setNormalizedMinValue(0.0d);
        } else {
            setNormalizedMinValue(a(t2));
        }
    }

    public T getSelectedMaxValue() {
        return a(this.r);
    }

    public void setSelectedMaxValue(T t2) {
        if (0.0d == this.p - this.o) {
            setNormalizedMaxValue(1.0d);
        } else {
            setNormalizedMaxValue(a(t2));
        }
    }

    public void setOnRangeSeekBarChangeListener(b<T> bVar) {
        this.t = bVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        b<T> bVar;
        int i2 = 0;
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction() & PriceRangeSeekBar.INVALID_POINTER_ID;
        c cVar = null;
        if (action == 0) {
            this.f25307d = motionEvent.getPointerId(motionEvent.getPointerCount() - 1);
            this.v = motionEvent.getX(motionEvent.findPointerIndex(this.f25307d));
            float f2 = this.v;
            if (this.u && a(f2, this.q)) {
                i2 = 1;
            }
            boolean a2 = a(f2, this.r);
            if (i2 != 0 && a2) {
                cVar = f2 / ((float) getWidth()) > 0.5f ? c.MIN : c.MAX;
            } else if (i2 != 0) {
                cVar = c.MIN;
            } else if (a2) {
                cVar = c.MAX;
            }
            this.f25306b = cVar;
            if (this.f25306b == null) {
                return super.onTouchEvent(motionEvent);
            }
            setPressed(true);
            invalidate();
            this.x = true;
            a(motionEvent);
            a();
        } else if (action == 1) {
            if (this.x) {
                a(motionEvent);
                this.x = false;
                setPressed(false);
            } else {
                this.x = true;
                a(motionEvent);
                this.x = false;
            }
            this.f25306b = null;
            invalidate();
            b<T> bVar2 = this.t;
            if (bVar2 != null) {
                bVar2.a(getSelectedMinValue(), getSelectedMaxValue());
            }
        } else if (action != 2) {
            if (action != 3) {
                if (action == 5) {
                    int pointerCount = motionEvent.getPointerCount() - 1;
                    this.v = motionEvent.getX(pointerCount);
                    this.f25307d = motionEvent.getPointerId(pointerCount);
                } else if (action == 6) {
                    int action2 = (motionEvent.getAction() & PriceRangeSeekBar.ACTION_POINTER_INDEX_MASK) >> 8;
                    if (motionEvent.getPointerId(action2) == this.f25307d) {
                        if (action2 == 0) {
                            i2 = 1;
                        }
                        this.v = motionEvent.getX(i2);
                        this.f25307d = motionEvent.getPointerId(i2);
                    }
                    invalidate();
                }
            } else if (this.x) {
                this.x = false;
                setPressed(false);
            }
            invalidate();
        } else if (this.f25306b != null) {
            if (this.x) {
                a(motionEvent);
            } else if (Math.abs(motionEvent.getX(motionEvent.findPointerIndex(this.f25307d)) - this.v) > ((float) this.w)) {
                setPressed(true);
                invalidate();
                this.x = true;
                a(motionEvent);
                a();
            }
            if (this.s && (bVar = this.t) != null) {
                bVar.a(getSelectedMinValue(), getSelectedMaxValue());
            }
        }
        return true;
    }

    private final void a(MotionEvent motionEvent) {
        float x2 = motionEvent.getX(motionEvent.findPointerIndex(this.f25307d));
        if (c.MIN.equals(this.f25306b)) {
            setNormalizedMinValue(a(x2));
        } else if (c.MAX.equals(this.f25306b)) {
            setNormalizedMaxValue(a(x2));
        }
    }

    private void a() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i2, int i3) {
        int i4 = 200;
        if (View.MeasureSpec.getMode(i2) != 0) {
            i4 = View.MeasureSpec.getSize(i2);
        }
        int height = this.f25309f.getHeight();
        if (View.MeasureSpec.getMode(i3) != 0) {
            height = Math.min(height, View.MeasureSpec.getSize(i3));
        }
        setMeasuredDimension(i4, height);
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF(this.l, (((float) getHeight()) - this.k) * 0.5f, ((float) getWidth()) - this.l, (((float) getHeight()) + this.k) * 0.5f);
        this.f25308e.setStyle(Paint.Style.FILL);
        this.f25308e.setColor(androidx.core.content.b.c(getContext(), R.color.color_ebebeb));
        this.f25308e.setAntiAlias(true);
        canvas.drawRect(rectF, this.f25308e);
        rectF.left = b(this.q);
        rectF.right = b(this.r);
        this.f25308e.setColor(f25304c);
        canvas.drawRect(rectF, this.f25308e);
        if (this.u) {
            a(b(this.q), c.MIN.equals(this.f25306b), canvas);
        }
        a(b(this.r), c.MAX.equals(this.f25306b), canvas);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("SUPER", super.onSaveInstanceState());
        bundle.putDouble("MIN", this.q);
        bundle.putDouble("MAX", this.r);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("SUPER"));
        this.q = bundle.getDouble("MIN");
        this.r = bundle.getDouble("MAX");
    }

    private void a(float f2, boolean z, Canvas canvas) {
        canvas.drawBitmap(z ? this.f25310g : this.f25309f, f2 - this.f25312i, (((float) getHeight()) * 0.5f) - this.j, this.f25308e);
    }

    private boolean a(float f2, double d2) {
        return Math.abs(f2 - b(d2)) <= this.f25312i;
    }

    public void setNormalizedMinValue(double d2) {
        this.q = Math.max(0.0d, Math.min(1.0d, Math.min(d2, this.r)));
        invalidate();
    }

    public void setNormalizedMaxValue(double d2) {
        this.r = Math.max(0.0d, Math.min(1.0d, Math.max(d2, this.q)));
        invalidate();
    }

    private T a(double d2) {
        a aVar = this.f25305a;
        double d3 = this.o;
        return aVar.toNumber(d3 + (d2 * (this.p - d3)));
    }

    /* access modifiers changed from: protected */
    public final double a(T t2) {
        if (0.0d == this.p - this.o) {
            return 0.0d;
        }
        double doubleValue = t2.doubleValue();
        double d2 = this.o;
        return (doubleValue - d2) / (this.p - d2);
    }

    private float b(double d2) {
        return (float) (((double) this.l) + (d2 * ((double) (((float) getWidth()) - (this.l * 2.0f)))));
    }

    private double a(float f2) {
        float width = (float) getWidth();
        float f3 = this.l;
        if (width <= f3 * 2.0f) {
            return 0.0d;
        }
        return Math.min(1.0d, Math.max(0.0d, (double) ((f2 - f3) / (width - (f3 * 2.0f)))));
    }

    enum a {
        LONG,
        DOUBLE,
        INTEGER,
        FLOAT,
        SHORT,
        BYTE,
        BIG_DECIMAL;

        public static <E extends Number> a fromNumber(E e2) throws IllegalArgumentException {
            if (e2 instanceof Long) {
                return LONG;
            }
            if (e2 instanceof Double) {
                return DOUBLE;
            }
            if (e2 instanceof Integer) {
                return INTEGER;
            }
            if (e2 instanceof Float) {
                return FLOAT;
            }
            if (e2 instanceof Short) {
                return SHORT;
            }
            if (e2 instanceof Byte) {
                return BYTE;
            }
            if (e2 instanceof BigDecimal) {
                return BIG_DECIMAL;
            }
            throw new IllegalArgumentException("Number class '" + e2.getClass().getName() + "' is not supported");
        }

        public final Number toNumber(double d2) {
            switch (this) {
                case LONG:
                    return new Long((long) d2);
                case DOUBLE:
                    return Double.valueOf(d2);
                case INTEGER:
                    return new Integer((int) d2);
                case FLOAT:
                    return new Float(d2);
                case SHORT:
                    return new Short((short) ((int) d2));
                case BYTE:
                    return new Byte((byte) ((int) d2));
                case BIG_DECIMAL:
                    return new BigDecimal(d2);
                default:
                    throw new InstantiationError("can't convert " + this + " to a Number object");
            }
        }
    }
}
