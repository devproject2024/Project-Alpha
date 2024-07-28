package net.one97.paytm.passbook.utility;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.h.v;
import androidx.viewpager.widget.ViewPager;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import net.one97.paytm.common.widgets.R;
import net.one97.paytm.common.widgets.a.b;

public class CirclePageIndicator extends View implements b {

    /* renamed from: a  reason: collision with root package name */
    private float f59193a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f59194b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f59195c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f59196d;

    /* renamed from: e  reason: collision with root package name */
    private ViewPager f59197e;

    /* renamed from: f  reason: collision with root package name */
    private ViewPager.e f59198f;

    /* renamed from: g  reason: collision with root package name */
    private int f59199g;

    /* renamed from: h  reason: collision with root package name */
    private int f59200h;

    /* renamed from: i  reason: collision with root package name */
    private float f59201i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private int n;
    private float o;
    private int p;
    private boolean q;

    public CirclePageIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.vpiCirclePageIndicatorStyle);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f59194b = new Paint(1);
        this.f59195c = new Paint(1);
        this.f59196d = new Paint(1);
        this.o = -1.0f;
        this.p = -1;
        if (!isInEditMode()) {
            Resources resources = getResources();
            int color = resources.getColor(R.color.default_circle_indicator_page_color);
            int color2 = resources.getColor(R.color.paytm_blue);
            int integer = resources.getInteger(R.integer.default_circle_indicator_orientation);
            int color3 = resources.getColor(R.color.default_circle_indicator_stroke_color);
            float dimension = resources.getDimension(R.dimen.default_circle_indicator_stroke_width);
            float dimension2 = resources.getDimension(R.dimen.default_circle_indicator_radius);
            boolean z = resources.getBoolean(R.bool.default_circle_indicator_centered);
            boolean z2 = resources.getBoolean(R.bool.default_circle_indicator_snap);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CirclePageIndicator, i2, 0);
            this.l = obtainStyledAttributes.getBoolean(R.styleable.CirclePageIndicator_centered, z);
            this.k = obtainStyledAttributes.getInt(R.styleable.CirclePageIndicator_android_orientation, integer);
            this.f59194b.setStyle(Paint.Style.FILL);
            this.f59194b.setColor(obtainStyledAttributes.getColor(R.styleable.CirclePageIndicator_pageColor, color));
            this.f59195c.setStyle(Paint.Style.STROKE);
            this.f59195c.setColor(obtainStyledAttributes.getColor(R.styleable.CirclePageIndicator_strokeColor, color3));
            this.f59195c.setStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.CirclePageIndicator_strokeWidth, dimension));
            this.f59196d.setStyle(Paint.Style.FILL);
            this.f59196d.setColor(obtainStyledAttributes.getColor(R.styleable.CirclePageIndicator_fillColor, color2));
            this.f59193a = obtainStyledAttributes.getDimension(R.styleable.CirclePageIndicator_radius, dimension2);
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
        this.f59194b.setColor(i2);
        invalidate();
    }

    public int getPageColor() {
        return this.f59194b.getColor();
    }

    public void setFillColor(int i2) {
        this.f59196d.setColor(i2);
        invalidate();
    }

    public int getFillColor() {
        return this.f59196d.getColor();
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
        this.f59195c.setColor(i2);
        invalidate();
    }

    public int getStrokeColor() {
        return this.f59195c.getColor();
    }

    public void setStrokeWidth(float f2) {
        this.f59195c.setStrokeWidth(f2);
        invalidate();
    }

    public float getStrokeWidth() {
        return this.f59195c.getStrokeWidth();
    }

    public void setRadius(float f2) {
        this.f59193a = f2;
        invalidate();
    }

    public float getRadius() {
        return this.f59193a;
    }

    public void setSnap(boolean z) {
        this.m = z;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int itemActualCount;
        int i2;
        int i3;
        int i4;
        int i5;
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.f59197e != null && (itemActualCount = getItemActualCount()) != 0) {
            if (this.f59199g >= itemActualCount) {
                setCurrentItem(itemActualCount - 1);
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
            float f4 = this.f59193a;
            float f5 = 3.0f * f4;
            float f6 = ((float) i2) + f4;
            float f7 = ((float) i4) + f4;
            if (this.l) {
                f7 += (((float) ((i5 - i4) - i3)) / 2.0f) - ((((float) itemActualCount) * f5) / 2.0f);
            }
            float f8 = this.f59193a;
            if (this.f59195c.getStrokeWidth() > 0.0f) {
                f8 -= this.f59195c.getStrokeWidth() / 2.0f;
            }
            for (int i6 = 0; i6 < itemActualCount; i6++) {
                float f9 = (((float) i6) * f5) + f7;
                if (this.k == 0) {
                    f3 = f6;
                } else {
                    f3 = f9;
                    f9 = f6;
                }
                if (this.f59194b.getAlpha() > 0) {
                    canvas.drawCircle(f9, f3, f8, this.f59194b);
                }
                float f10 = this.f59193a;
                if (f8 != f10) {
                    canvas.drawCircle(f9, f3, f10, this.f59195c);
                }
            }
            float f11 = ((float) (this.m ? this.f59200h : this.f59199g)) * f5;
            if (!this.m) {
                f11 += this.f59201i * f5;
            }
            if (this.k == 0) {
                f2 = f11 + f7;
            } else {
                float f12 = f6;
                f6 = f11 + f7;
                f2 = f12;
            }
            canvas.drawCircle(f2, f6, this.f59193a, this.f59196d);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        int i2 = 0;
        if (this.f59197e == null || getItemActualCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & PriceRangeSeekBar.INVALID_POINTER_ID;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x = motionEvent.getX(motionEvent.findPointerIndex(this.p));
                    float f2 = x - this.o;
                    if (!this.q && Math.abs(f2) > ((float) this.n)) {
                        this.q = true;
                    }
                    if (this.q) {
                        this.o = x;
                        if (this.f59197e.isFakeDragging() || this.f59197e.beginFakeDrag()) {
                            this.f59197e.fakeDragBy(f2);
                        }
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        this.o = motionEvent.getX(actionIndex);
                        this.p = motionEvent.getPointerId(actionIndex);
                    } else if (action == 6) {
                        int actionIndex2 = motionEvent.getActionIndex();
                        if (motionEvent.getPointerId(actionIndex2) == this.p) {
                            if (actionIndex2 == 0) {
                                i2 = 1;
                            }
                            this.p = motionEvent.getPointerId(i2);
                        }
                        this.o = motionEvent.getX(motionEvent.findPointerIndex(this.p));
                    }
                }
            }
            if (!this.q) {
                int itemActualCount = getItemActualCount();
                float width = (float) getWidth();
                float f3 = width / 2.0f;
                float f4 = width / 6.0f;
                if (this.f59199g > 0 && motionEvent.getX() < f3 - f4) {
                    if (action != 3) {
                        this.f59197e.setCurrentItem(this.f59199g - 1);
                    }
                    return true;
                } else if (this.f59199g < itemActualCount - 1 && motionEvent.getX() > f3 + f4) {
                    if (action != 3) {
                        this.f59197e.setCurrentItem(this.f59199g + 1);
                    }
                    return true;
                }
            }
            this.q = false;
            this.p = -1;
            if (this.f59197e.isFakeDragging()) {
                this.f59197e.endFakeDrag();
            }
        } else {
            this.p = motionEvent.getPointerId(0);
            this.o = motionEvent.getX();
        }
        return true;
    }

    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.f59197e;
        if (viewPager2 != viewPager) {
            if (viewPager2 != null) {
                viewPager2.setOnPageChangeListener((ViewPager.e) null);
            }
            if (viewPager.getAdapter() != null) {
                this.f59197e = viewPager;
                this.f59197e.setOnPageChangeListener(this);
                invalidate();
                return;
            }
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
    }

    public void setViewPager(ViewPager viewPager, int i2) {
        setViewPager(viewPager);
        setCurrentItem(i2);
    }

    public void setCurrentItem(int i2) {
        ViewPager viewPager = this.f59197e;
        if (viewPager != null) {
            viewPager.setCurrentItem(i2);
            this.f59199g = i2;
            invalidate();
            return;
        }
        throw new IllegalStateException("ViewPager has not been bound.");
    }

    public void onPageScrollStateChanged(int i2) {
        this.j = i2;
        ViewPager.e eVar = this.f59198f;
        if (eVar != null) {
            eVar.onPageScrollStateChanged(i2);
        }
    }

    public void onPageScrolled(int i2, float f2, int i3) {
        this.f59199g = i2;
        this.f59201i = f2;
        invalidate();
        ViewPager.e eVar = this.f59198f;
        if (eVar != null) {
            eVar.onPageScrolled(i2, f2, i3);
        }
    }

    public void onPageSelected(int i2) {
        if (this.m || this.j == 0) {
            this.f59199g = i2;
            this.f59200h = i2;
            invalidate();
        }
        ViewPager.e eVar = this.f59198f;
        if (eVar != null) {
            eVar.onPageSelected(i2);
        }
    }

    public void setOnPageChangeListener(ViewPager.e eVar) {
        this.f59198f = eVar;
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
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 || this.f59197e == null) {
            return size;
        }
        int itemActualCount = getItemActualCount();
        float f2 = this.f59193a;
        int paddingLeft = (int) (((float) (getPaddingLeft() + getPaddingRight())) + (((float) (itemActualCount * 2)) * f2) + (((float) (itemActualCount - 1)) * f2) + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
    }

    private int b(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (int) ((this.f59193a * 2.0f) + ((float) getPaddingTop()) + ((float) getPaddingBottom()) + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f59199g = savedState.f59202a;
        this.f59200h = savedState.f59202a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f59202a = this.f59199g;
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
        int f59202a;

        /* synthetic */ SavedState(Parcel parcel, byte b2) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f59202a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f59202a);
        }
    }

    private int getItemActualCount() {
        return this.f59197e.getAdapter().getCount();
    }
}
