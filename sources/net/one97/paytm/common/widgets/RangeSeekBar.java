package net.one97.paytm.common.widgets;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.lang.Number;
import java.math.BigDecimal;

public class RangeSeekBar<T extends Number> extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    protected final a f49865a;

    /* renamed from: b  reason: collision with root package name */
    protected c f49866b;

    /* renamed from: c  reason: collision with root package name */
    public int f49867c;

    /* renamed from: d  reason: collision with root package name */
    protected int f49868d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f49869e;

    /* renamed from: f  reason: collision with root package name */
    private final Bitmap f49870f;

    /* renamed from: g  reason: collision with root package name */
    private final Bitmap f49871g;

    /* renamed from: h  reason: collision with root package name */
    private final float f49872h;

    /* renamed from: i  reason: collision with root package name */
    private final float f49873i;
    private final float j;
    private final float k;
    private final T l;
    private final T m;
    private final double n;
    private final double o;
    private double p;
    private double q;
    private boolean r;
    private b<T> s;
    private float t;
    private int u;
    private boolean v;

    public interface b<T> {
    }

    protected enum c {
        MIN,
        MAX
    }

    public void setNotifyWhileDragging(boolean z) {
        this.r = z;
    }

    public T getAbsoluteMinValue() {
        return this.l;
    }

    public T getAbsoluteMaxValue() {
        return this.m;
    }

    public T getSelectedMinValue() {
        return a(this.p);
    }

    public void setSelectedMinValue(T t2) {
        if (0.0d == this.o - this.n) {
            setNormalizedMinValue(0.0d);
        } else {
            setNormalizedMinValue(a(t2));
        }
    }

    public T getSelectedMaxValue() {
        return a(this.q);
    }

    public void setSelectedMaxValue(T t2) {
        if (0.0d == this.o - this.n) {
            setNormalizedMaxValue(1.0d);
        } else {
            setNormalizedMaxValue(a(t2));
        }
    }

    public void setOnRangeSeekBarChangeListener(b<T> bVar) {
        this.s = bVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2 = 0;
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction() & PriceRangeSeekBar.INVALID_POINTER_ID;
        c cVar = null;
        if (action == 0) {
            this.f49868d = motionEvent.getPointerId(motionEvent.getPointerCount() - 1);
            this.t = motionEvent.getX(motionEvent.findPointerIndex(this.f49868d));
            float f2 = this.t;
            boolean a2 = a(f2, this.p);
            boolean a3 = a(f2, this.q);
            if (a2 && a3) {
                cVar = f2 / ((float) getWidth()) > 0.5f ? c.MIN : c.MAX;
            } else if (a2) {
                cVar = c.MIN;
            } else if (a3) {
                cVar = c.MAX;
            }
            this.f49866b = cVar;
        } else if (action == 1) {
            if (this.v) {
                a(motionEvent);
                this.v = false;
                setPressed(false);
            } else {
                this.v = true;
                a(motionEvent);
                this.v = false;
            }
            this.f49866b = null;
            invalidate();
            if (this.s != null) {
                getSelectedMinValue();
                getSelectedMaxValue();
            }
        } else if (action != 2) {
            if (action != 3) {
                if (action == 5) {
                    int pointerCount = motionEvent.getPointerCount() - 1;
                    this.t = motionEvent.getX(pointerCount);
                    this.f49868d = motionEvent.getPointerId(pointerCount);
                } else if (action == 6) {
                    int action2 = (motionEvent.getAction() & PriceRangeSeekBar.ACTION_POINTER_INDEX_MASK) >> 8;
                    if (motionEvent.getPointerId(action2) == this.f49868d) {
                        if (action2 == 0) {
                            i2 = 1;
                        }
                        this.t = motionEvent.getX(i2);
                        this.f49868d = motionEvent.getPointerId(i2);
                    }
                    invalidate();
                }
            } else if (this.v) {
                this.v = false;
                setPressed(false);
            }
            invalidate();
        } else if (this.f49866b != null) {
            if (this.v) {
                a(motionEvent);
            } else if (Math.abs(motionEvent.getX(motionEvent.findPointerIndex(this.f49868d)) - this.t) > ((float) this.u)) {
                setPressed(true);
                invalidate();
                this.v = true;
                a(motionEvent);
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
            }
            if (this.r && this.s != null) {
                getSelectedMinValue();
                getSelectedMaxValue();
            }
        }
        return true;
    }

    private final void a(MotionEvent motionEvent) {
        float x = motionEvent.getX(motionEvent.findPointerIndex(this.f49868d));
        if (c.MIN.equals(this.f49866b)) {
            setNormalizedMinValue(a(x));
        } else if (c.MAX.equals(this.f49866b)) {
            setNormalizedMaxValue(a(x));
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i2, int i3) {
        int i4 = 200;
        if (View.MeasureSpec.getMode(i2) != 0) {
            i4 = View.MeasureSpec.getSize(i2);
        }
        int height = this.f49870f.getHeight();
        if (View.MeasureSpec.getMode(i3) != 0) {
            height = Math.min(height, View.MeasureSpec.getSize(i3));
        }
        setMeasuredDimension(i4, height);
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF(this.k, (((float) getHeight()) - this.j) * 0.5f, ((float) getWidth()) - this.k, (((float) getHeight()) + this.j) * 0.5f);
        this.f49869e.setStyle(Paint.Style.FILL);
        this.f49869e.setColor(-7829368);
        this.f49869e.setAntiAlias(true);
        canvas.drawRect(rectF, this.f49869e);
        rectF.left = b(this.p);
        rectF.right = b(this.q);
        this.f49869e.setColor(this.f49867c);
        canvas.drawRect(rectF, this.f49869e);
        a(b(this.p), c.MIN.equals(this.f49866b), canvas);
        a(b(this.q), c.MAX.equals(this.f49866b), canvas);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("SUPER", super.onSaveInstanceState());
        bundle.putDouble("MIN", this.p);
        bundle.putDouble("MAX", this.q);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("SUPER"));
        this.p = bundle.getDouble("MIN");
        this.q = bundle.getDouble("MAX");
    }

    private void a(float f2, boolean z, Canvas canvas) {
        canvas.drawBitmap(z ? this.f49871g : this.f49870f, f2 - this.f49872h, (((float) getHeight()) * 0.5f) - this.f49873i, this.f49869e);
    }

    private boolean a(float f2, double d2) {
        return Math.abs(f2 - b(d2)) <= this.f49872h;
    }

    public void setNormalizedMinValue(double d2) {
        this.p = Math.max(0.0d, Math.min(1.0d, Math.min(d2, this.q)));
        invalidate();
    }

    public void setNormalizedMaxValue(double d2) {
        this.q = Math.max(0.0d, Math.min(1.0d, Math.max(d2, this.p)));
        invalidate();
    }

    private T a(double d2) {
        a aVar = this.f49865a;
        double d3 = this.n;
        return aVar.toNumber(d3 + (d2 * (this.o - d3)));
    }

    private double a(T t2) {
        if (0.0d == this.o - this.n) {
            return 0.0d;
        }
        double doubleValue = t2.doubleValue();
        double d2 = this.n;
        return (doubleValue - d2) / (this.o - d2);
    }

    private float b(double d2) {
        return (float) (((double) this.k) + (d2 * ((double) (((float) getWidth()) - (this.k * 2.0f)))));
    }

    private double a(float f2) {
        float width = (float) getWidth();
        float f3 = this.k;
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
