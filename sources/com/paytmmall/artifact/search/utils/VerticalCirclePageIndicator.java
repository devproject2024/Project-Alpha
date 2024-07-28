package com.paytmmall.artifact.search.utils;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.h.v;
import androidx.viewpager.widget.ViewPager;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.search.utils.VerticalViewPager;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

public class VerticalCirclePageIndicator extends View implements ViewPager.e {

    /* renamed from: a  reason: collision with root package name */
    private float f15973a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f15974b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f15975c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f15976d;

    /* renamed from: e  reason: collision with root package name */
    private VerticalViewPager f15977e;

    /* renamed from: f  reason: collision with root package name */
    private VerticalViewPager.e f15978f;

    /* renamed from: g  reason: collision with root package name */
    private int f15979g;

    /* renamed from: h  reason: collision with root package name */
    private int f15980h;

    /* renamed from: i  reason: collision with root package name */
    private float f15981i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private int n;
    private float o;
    private int p;
    private boolean q;

    public VerticalCirclePageIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public VerticalCirclePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.vpiCirclePageIndicatorStyle);
    }

    public VerticalCirclePageIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15974b = new Paint(1);
        this.f15975c = new Paint(1);
        this.f15976d = new Paint(1);
        this.o = -1.0f;
        this.p = -1;
        if (!isInEditMode()) {
            Resources resources = getResources();
            int color = resources.getColor(R.color.default_circle_indicator_page_color);
            int color2 = resources.getColor(R.color.default_circle_indicator_fill_color);
            int integer = resources.getInteger(R.integer.default_circle_indicator_orientation);
            int color3 = resources.getColor(R.color.default_circle_indicator_stroke_color);
            float dimension = resources.getDimension(R.dimen.default_circle_indicator_stroke_width);
            float dimension2 = resources.getDimension(R.dimen.default_vertical_circle_indicator_radius);
            boolean z = resources.getBoolean(R.bool.default_circle_indicator_centered);
            boolean z2 = resources.getBoolean(R.bool.default_circle_indicator_snap);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CirclePageIndicator, i2, 0);
            this.l = obtainStyledAttributes.getBoolean(R.styleable.CirclePageIndicator_centered, z);
            this.k = obtainStyledAttributes.getInt(R.styleable.CirclePageIndicator_android_orientation, integer);
            this.f15974b.setStyle(Paint.Style.FILL);
            this.f15974b.setColor(obtainStyledAttributes.getColor(R.styleable.CirclePageIndicator_pageColor, color));
            this.f15975c.setStyle(Paint.Style.STROKE);
            this.f15975c.setColor(obtainStyledAttributes.getColor(R.styleable.CirclePageIndicator_strokeColor, color3));
            this.f15975c.setStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.CirclePageIndicator_strokeWidth, dimension));
            this.f15976d.setStyle(Paint.Style.FILL);
            this.f15976d.setColor(obtainStyledAttributes.getColor(R.styleable.CirclePageIndicator_fillColor, color2));
            this.f15973a = obtainStyledAttributes.getDimension(R.styleable.CirclePageIndicator_radius, dimension2);
            this.m = obtainStyledAttributes.getBoolean(R.styleable.CirclePageIndicator_snap, z2);
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.CirclePageIndicator_android_background);
            if (drawable != null) {
                setBackgroundDrawable(drawable);
            }
            obtainStyledAttributes.recycle();
            this.n = v.a(ViewConfiguration.get(context));
        }
    }

    public void setCentered(boolean z) {
        this.l = z;
        invalidate();
    }

    public void setPageColor(int i2) {
        this.f15974b.setColor(i2);
        invalidate();
    }

    public int getPageColor() {
        return this.f15974b.getColor();
    }

    public void setFillColor(int i2) {
        this.f15976d.setColor(i2);
        invalidate();
    }

    public int getFillColor() {
        return this.f15976d.getColor();
    }

    public void setOrientation(int i2) {
        if (i2 == 0 || i2 == 1) {
            this.k = i2;
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
    }

    public int getOrientation() {
        return this.k;
    }

    public void setStrokeColor(int i2) {
        this.f15975c.setColor(i2);
        invalidate();
    }

    public int getStrokeColor() {
        return this.f15975c.getColor();
    }

    public void setStrokeWidth(float f2) {
        this.f15975c.setStrokeWidth(f2);
        invalidate();
    }

    public float getStrokeWidth() {
        return this.f15975c.getStrokeWidth();
    }

    public void setRadius(float f2) {
        this.f15973a = f2;
        invalidate();
    }

    public float getRadius() {
        return this.f15973a;
    }

    public void setSnap(boolean z) {
        this.m = z;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int a2;
        int i2;
        int i3;
        int i4;
        int i5;
        float f2;
        float f3;
        super.onDraw(canvas);
        VerticalViewPager verticalViewPager = this.f15977e;
        if (verticalViewPager != null && (a2 = verticalViewPager.getAdapter().a()) != 0) {
            if (this.f15979g >= a2) {
                setCurrentItem(a2 - 1);
                return;
            }
            if (this.k == 0) {
                i5 = getWidth();
                i4 = getPaddingLeft();
                i3 = getPaddingRight();
                i2 = getPaddingTop();
            } else {
                i5 = getHeight();
                i4 = getPaddingTop();
                i3 = getPaddingBottom();
                i2 = getPaddingLeft();
            }
            float f4 = this.f15973a;
            float f5 = 3.0f * f4;
            float f6 = ((float) i2) + f4;
            float f7 = ((float) i4) + f4;
            if (this.l) {
                f7 += (((float) ((i5 - i4) - i3)) / 2.0f) - ((((float) a2) * f5) / 2.0f);
            }
            float f8 = this.f15973a;
            if (this.f15975c.getStrokeWidth() > 0.0f) {
                f8 -= this.f15975c.getStrokeWidth() / 2.0f;
            }
            for (int i6 = 0; i6 < a2; i6++) {
                float f9 = (((float) i6) * f5) + f7;
                if (this.k == 0) {
                    f3 = f6;
                } else {
                    f3 = f9;
                    f9 = f6;
                }
                if (this.f15974b.getAlpha() > 0) {
                    canvas.drawCircle(f9, f3, f8, this.f15974b);
                }
                float f10 = this.f15973a;
                if (f8 != f10) {
                    canvas.drawCircle(f9, f3, f10, this.f15975c);
                }
            }
            float f11 = ((float) (this.m ? this.f15980h : this.f15979g)) * f5;
            if (!this.m) {
                f11 += this.f15981i * f5;
            }
            if (this.k == 0) {
                f2 = f11 + f7;
            } else {
                float f12 = f6;
                f6 = f11 + f7;
                f2 = f12;
            }
            canvas.drawCircle(f2, f6, this.f15973a, this.f15976d);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        MotionEvent motionEvent2 = motionEvent;
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        VerticalViewPager verticalViewPager = this.f15977e;
        if (verticalViewPager == null || verticalViewPager.getAdapter().a() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & PriceRangeSeekBar.INVALID_POINTER_ID;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x = motionEvent2.getX(motionEvent2.findPointerIndex(this.p));
                    float f2 = x - this.o;
                    if (!this.q && Math.abs(f2) > ((float) this.n)) {
                        this.q = true;
                    }
                    if (!this.q) {
                        return true;
                    }
                    this.o = x;
                    if (!this.f15977e.l) {
                        VerticalViewPager verticalViewPager2 = this.f15977e;
                        if (verticalViewPager2.f15988f) {
                            z = false;
                        } else {
                            verticalViewPager2.l = true;
                            verticalViewPager2.setScrollState(1);
                            verticalViewPager2.f15990h = 0.0f;
                            verticalViewPager2.f15989g = 0.0f;
                            if (verticalViewPager2.j == null) {
                                verticalViewPager2.j = VelocityTracker.obtain();
                            } else {
                                verticalViewPager2.j.clear();
                            }
                            long uptimeMillis = SystemClock.uptimeMillis();
                            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
                            verticalViewPager2.j.addMovement(obtain);
                            obtain.recycle();
                            verticalViewPager2.m = uptimeMillis;
                            z = true;
                        }
                        if (!z) {
                            return true;
                        }
                    }
                    VerticalViewPager verticalViewPager3 = this.f15977e;
                    if (verticalViewPager3.l) {
                        verticalViewPager3.f15990h += f2;
                        float scrollY = ((float) verticalViewPager3.getScrollY()) - f2;
                        float height = (float) verticalViewPager3.getHeight();
                        float f3 = verticalViewPager3.f15985c * height;
                        float f4 = verticalViewPager3.f15986d * height;
                        VerticalViewPager.b bVar = verticalViewPager3.f15983a.get(0);
                        VerticalViewPager.b bVar2 = verticalViewPager3.f15983a.get(verticalViewPager3.f15983a.size() - 1);
                        if (bVar.f16003a != 0) {
                            f3 = bVar.f16007e * height;
                        }
                        if (bVar2.f16003a != verticalViewPager3.f15984b.a() - 1) {
                            f4 = bVar2.f16007e * height;
                        }
                        if (scrollY < f3) {
                            scrollY = f3;
                        } else if (scrollY > f4) {
                            scrollY = f4;
                        }
                        int i2 = (int) scrollY;
                        verticalViewPager3.f15990h += scrollY - ((float) i2);
                        verticalViewPager3.scrollTo(verticalViewPager3.getScrollX(), i2);
                        verticalViewPager3.a(i2);
                        MotionEvent obtain2 = MotionEvent.obtain(verticalViewPager3.m, SystemClock.uptimeMillis(), 2, 0.0f, verticalViewPager3.f15990h, 0);
                        verticalViewPager3.j.addMovement(obtain2);
                        obtain2.recycle();
                        return true;
                    }
                    throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
                } else if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        this.o = motionEvent2.getX(actionIndex);
                        this.p = motionEvent2.getPointerId(actionIndex);
                        return true;
                    } else if (action != 6) {
                        return true;
                    } else {
                        int actionIndex2 = motionEvent.getActionIndex();
                        if (motionEvent2.getPointerId(actionIndex2) == this.p) {
                            this.p = motionEvent2.getPointerId(actionIndex2 == 0 ? 1 : 0);
                        }
                        this.o = motionEvent2.getX(motionEvent2.findPointerIndex(this.p));
                        return true;
                    }
                }
            }
            if (!this.q) {
                int a2 = this.f15977e.getAdapter().a();
                float width = (float) getWidth();
                float f5 = width / 2.0f;
                float f6 = width / 6.0f;
                if (this.f15979g <= 0 || motionEvent.getX() >= f5 - f6) {
                    if (this.f15979g < a2 - 1 && motionEvent.getX() > f5 + f6) {
                        if (action != 3) {
                            this.f15977e.setCurrentItem(this.f15979g + 1);
                        }
                        return true;
                    }
                } else if (action == 3) {
                    return true;
                } else {
                    this.f15977e.setCurrentItem(this.f15979g - 1);
                    return true;
                }
            }
            this.q = false;
            this.p = -1;
            if (!this.f15977e.l) {
                return true;
            }
            VerticalViewPager verticalViewPager4 = this.f15977e;
            if (verticalViewPager4.l) {
                VelocityTracker velocityTracker = verticalViewPager4.j;
                velocityTracker.computeCurrentVelocity(1000, (float) verticalViewPager4.k);
                int yVelocity = (int) velocityTracker.getYVelocity(verticalViewPager4.f15991i);
                verticalViewPager4.f15987e = true;
                int height2 = verticalViewPager4.getHeight();
                int scrollY2 = verticalViewPager4.getScrollY();
                VerticalViewPager.b c2 = verticalViewPager4.c();
                verticalViewPager4.a(verticalViewPager4.a(c2.f16003a, ((((float) scrollY2) / ((float) height2)) - c2.f16007e) / c2.f16006d, yVelocity, (int) (verticalViewPager4.f15990h - verticalViewPager4.f15989g)), true, true, yVelocity);
                verticalViewPager4.d();
                verticalViewPager4.l = false;
                return true;
            }
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        this.p = motionEvent2.getPointerId(0);
        this.o = motionEvent.getX();
        return true;
    }

    public void setViewPager(VerticalViewPager verticalViewPager) {
        if (this.f15977e != verticalViewPager) {
            if (verticalViewPager.getAdapter() != null) {
                this.f15977e = verticalViewPager;
                invalidate();
                return;
            }
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
    }

    public void setViewPager(VerticalViewPager verticalViewPager, int i2) {
        setViewPager(verticalViewPager);
        setCurrentItem(i2);
    }

    public void setCurrentItem(int i2) {
        VerticalViewPager verticalViewPager = this.f15977e;
        if (verticalViewPager != null) {
            verticalViewPager.setCurrentItem(i2);
            this.f15979g = i2;
            invalidate();
            return;
        }
        throw new IllegalStateException("ViewPager has not been bound.");
    }

    public void onPageScrollStateChanged(int i2) {
        this.j = i2;
    }

    public void onPageScrolled(int i2, float f2, int i3) {
        this.f15979g = i2;
        this.f15981i = f2;
        invalidate();
    }

    public void onPageSelected(int i2) {
        if (this.m || this.j == 0) {
            this.f15979g = i2;
            this.f15980h = i2;
            invalidate();
        }
    }

    public void setOnPageChangeListener(VerticalViewPager.e eVar) {
        this.f15978f = eVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.k == 0) {
            setMeasuredDimension(a(i2), b(i3));
        } else {
            setMeasuredDimension(b(i2), a(i3));
        }
    }

    private int a(int i2) {
        VerticalViewPager verticalViewPager;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 || (verticalViewPager = this.f15977e) == null) {
            return size;
        }
        int a2 = verticalViewPager.getAdapter().a();
        float f2 = this.f15973a;
        int paddingLeft = (int) (((float) (getPaddingLeft() + getPaddingRight())) + (((float) (a2 * 2)) * f2) + (((float) (a2 - 1)) * f2) + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
    }

    private int b(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (int) ((this.f15973a * 2.0f) + ((float) getPaddingTop()) + ((float) getPaddingBottom()) + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f15979g = savedState.f15982a;
        this.f15980h = savedState.f15982a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f15982a = this.f15979g;
        return savedState;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (byte) 0);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f15982a;

        /* synthetic */ SavedState(Parcel parcel, byte b2) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f15982a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f15982a);
        }
    }
}
