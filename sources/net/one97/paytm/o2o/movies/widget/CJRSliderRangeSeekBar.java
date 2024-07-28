package net.one97.paytm.o2o.movies.widget;

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
import java.lang.Number;
import java.math.BigDecimal;
import net.one97.paytm.o2o.movies.R;

public class CJRSliderRangeSeekBar<T extends Number> extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    protected final a f76145a;

    /* renamed from: b  reason: collision with root package name */
    protected c f76146b = null;

    /* renamed from: c  reason: collision with root package name */
    public int f76147c;

    /* renamed from: d  reason: collision with root package name */
    protected int f76148d = PriceRangeSeekBar.INVALID_POINTER_ID;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f76149e = new Paint(1);

    /* renamed from: f  reason: collision with root package name */
    private final Bitmap f76150f = BitmapFactory.decodeResource(getResources(), R.drawable.ic_anchoir);

    /* renamed from: g  reason: collision with root package name */
    private final Bitmap f76151g = BitmapFactory.decodeResource(getResources(), R.drawable.ic_pressed_anchoir);

    /* renamed from: h  reason: collision with root package name */
    private final float f76152h = ((float) this.f76150f.getWidth());

    /* renamed from: i  reason: collision with root package name */
    private final float f76153i = (this.f76152h * 0.5f);
    private final float j = (((float) this.f76150f.getHeight()) * 0.5f);
    private final float k = (this.j * 0.2f);
    private final float l = this.f76153i;
    private final T m;
    private final T n;
    private final double o;
    private final double p;
    private double q = 0.0d;
    private double r = 1.0d;
    private boolean s = false;
    private b<T> t;
    private float u;
    private int v;
    private boolean w;

    public interface b<T> {
        void a(CJRSliderRangeSeekBar<?> cJRSliderRangeSeekBar, T t, T t2);
    }

    protected enum c {
        MIN,
        MAX
    }

    public CJRSliderRangeSeekBar(T t2, T t3, Context context) throws IllegalArgumentException {
        super(context);
        this.m = t2;
        this.n = t3;
        this.o = t2.doubleValue();
        this.p = t3.doubleValue();
        this.f76145a = a.fromNumber(t2);
        if (context != null) {
            this.f76147c = context.getResources().getColor(R.color.paytm_blue);
        } else {
            this.f76147c = Color.argb(PriceRangeSeekBar.INVALID_POINTER_ID, 51, 181, 229);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.v = ViewConfiguration.get(getContext()).getScaledTouchSlop();
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
            this.f76148d = motionEvent.getPointerId(motionEvent.getPointerCount() - 1);
            this.u = motionEvent.getX(motionEvent.findPointerIndex(this.f76148d));
            float f2 = this.u;
            boolean a2 = a(f2, this.q);
            boolean a3 = a(f2, this.r);
            if (a2 && a3) {
                cVar = f2 / ((float) getWidth()) > 0.5f ? c.MIN : c.MAX;
            } else if (a2) {
                cVar = c.MIN;
            } else if (a3) {
                cVar = c.MAX;
            }
            this.f76146b = cVar;
        } else if (action == 1) {
            if (this.w) {
                a(motionEvent);
                this.w = false;
                setPressed(false);
            } else {
                this.w = true;
                a(motionEvent);
                this.w = false;
            }
            this.f76146b = null;
            invalidate();
            b<T> bVar2 = this.t;
            if (bVar2 != null) {
                bVar2.a(this, getSelectedMinValue(), getSelectedMaxValue());
            }
        } else if (action != 2) {
            if (action != 3) {
                if (action == 5) {
                    int pointerCount = motionEvent.getPointerCount() - 1;
                    this.u = motionEvent.getX(pointerCount);
                    this.f76148d = motionEvent.getPointerId(pointerCount);
                } else if (action == 6) {
                    int action2 = (motionEvent.getAction() & PriceRangeSeekBar.ACTION_POINTER_INDEX_MASK) >> 8;
                    if (motionEvent.getPointerId(action2) == this.f76148d) {
                        if (action2 == 0) {
                            i2 = 1;
                        }
                        this.u = motionEvent.getX(i2);
                        this.f76148d = motionEvent.getPointerId(i2);
                    }
                    invalidate();
                }
            } else if (this.w) {
                this.w = false;
                setPressed(false);
            }
            invalidate();
        } else if (this.f76146b != null) {
            if (this.w) {
                a(motionEvent);
            } else if (Math.abs(motionEvent.getX(motionEvent.findPointerIndex(this.f76148d)) - this.u) > ((float) this.v)) {
                setPressed(true);
                invalidate();
                this.w = true;
                a(motionEvent);
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
            }
            if (this.s && (bVar = this.t) != null) {
                bVar.a(this, getSelectedMinValue(), getSelectedMaxValue());
            }
        }
        return true;
    }

    private final void a(MotionEvent motionEvent) {
        float x = motionEvent.getX(motionEvent.findPointerIndex(this.f76148d));
        if (c.MIN.equals(this.f76146b)) {
            setNormalizedMinValue(a(x));
        } else if (c.MAX.equals(this.f76146b)) {
            setNormalizedMaxValue(a(x));
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i2, int i3) {
        int i4 = 200;
        if (View.MeasureSpec.getMode(i2) != 0) {
            i4 = View.MeasureSpec.getSize(i2);
        }
        int height = this.f76150f.getHeight();
        if (View.MeasureSpec.getMode(i3) != 0) {
            height = Math.min(height, View.MeasureSpec.getSize(i3));
        }
        setMeasuredDimension(i4, height);
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF(this.l, (((float) getHeight()) - this.k) * 0.5f, ((float) getWidth()) - this.l, (((float) getHeight()) + this.k) * 0.5f);
        this.f76149e.setStyle(Paint.Style.FILL);
        this.f76149e.setColor(-7829368);
        this.f76149e.setAntiAlias(true);
        canvas.drawRect(rectF, this.f76149e);
        rectF.left = b(this.q);
        rectF.right = b(this.r);
        this.f76149e.setColor(this.f76147c);
        canvas.drawRect(rectF, this.f76149e);
        a(b(this.q), c.MIN.equals(this.f76146b), canvas);
        a(b(this.r), c.MAX.equals(this.f76146b), canvas);
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
        canvas.drawBitmap(z ? this.f76151g : this.f76150f, f2 - this.f76153i, (((float) getHeight()) * 0.5f) - this.j, this.f76149e);
    }

    private boolean a(float f2, double d2) {
        return Math.abs(f2 - b(d2)) <= this.f76153i;
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
        a aVar = this.f76145a;
        double d3 = this.o;
        return aVar.toNumber(d3 + (d2 * (this.p - d3)));
    }

    private double a(T t2) {
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
