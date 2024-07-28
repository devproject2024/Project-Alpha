package com.paytmmall.clpartifact.customViews;

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
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.ViewUtils;
import com.paytmmall.clpartifact.utils.PageIndicator;
import com.paytmmall.clpartifact.view.adapter.SliderViewPagerAdapter;

public class CirclePageIndicator extends View implements PageIndicator {
    private static final int INVALID_POINTER = -1;
    private int mActivePointerId;
    private boolean mCentered;
    private int mCurrentPage;
    private boolean mIsDragging;
    private float mLastMotionX;
    private ViewPager.e mListener;
    private int mOrientation;
    private float mPageOffset;
    private final Paint mPaintFill;
    private final Paint mPaintPageFill;
    private final Paint mPaintStroke;
    private float mRadius;
    private int mScrollState;
    private boolean mSnap;
    private int mSnapPage;
    private int mTouchSlop;
    private ViewPager mViewPager;

    public CirclePageIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.vpiCirclePageIndicatorStyle);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mPaintPageFill = new Paint(1);
        this.mPaintStroke = new Paint(1);
        this.mPaintFill = new Paint(1);
        this.mLastMotionX = -1.0f;
        this.mActivePointerId = -1;
        if (!isInEditMode()) {
            Resources resources = getResources();
            int color = resources.getColor(R.color.default_circle_indicator_page_color);
            int color2 = resources.getColor(R.color.page_indicator);
            int integer = resources.getInteger(R.integer.default_circle_indicator_orientation);
            int color3 = resources.getColor(R.color.default_circle_indicator_stroke_color);
            float dimension = resources.getDimension(R.dimen.default_circle_indicator_stroke_width);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CirclePageIndicator, i2, 0);
            this.mCentered = obtainStyledAttributes.getBoolean(R.styleable.CirclePageIndicator_centered, true);
            this.mOrientation = obtainStyledAttributes.getInt(R.styleable.CirclePageIndicator_android_orientation, integer);
            this.mPaintPageFill.setStyle(Paint.Style.FILL);
            this.mPaintPageFill.setColor(obtainStyledAttributes.getColor(R.styleable.CirclePageIndicator_pageColor, color));
            this.mPaintStroke.setStyle(Paint.Style.STROKE);
            this.mPaintStroke.setColor(obtainStyledAttributes.getColor(R.styleable.CirclePageIndicator_strokeColor, color3));
            this.mPaintStroke.setStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.CirclePageIndicator_strokeWidth, dimension));
            this.mPaintFill.setStyle(Paint.Style.FILL);
            this.mPaintFill.setColor(obtainStyledAttributes.getColor(R.styleable.CirclePageIndicator_fillColor, color2));
            this.mRadius = obtainStyledAttributes.getDimension(R.styleable.CirclePageIndicator_radius, (float) ViewUtils.convertDpToPixel(3.0f, context));
            this.mSnap = obtainStyledAttributes.getBoolean(R.styleable.CirclePageIndicator_snap, false);
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.CirclePageIndicator_android_background);
            if (drawable != null) {
                setBackgroundDrawable(drawable);
            }
            obtainStyledAttributes.recycle();
            this.mTouchSlop = v.a(ViewConfiguration.get(context));
        }
    }

    public void setCentered(boolean z) {
        this.mCentered = z;
        invalidate();
    }

    public boolean isCentered() {
        return this.mCentered;
    }

    public void setPageColor(int i2) {
        this.mPaintPageFill.setColor(i2);
        invalidate();
    }

    public int getPageColor() {
        return this.mPaintPageFill.getColor();
    }

    public void setFillColor(int i2) {
        this.mPaintFill.setColor(i2);
        invalidate();
    }

    public int getFillColor() {
        return this.mPaintFill.getColor();
    }

    public void setOrientation(int i2) {
        if (i2 == 0 || i2 == 1) {
            this.mOrientation = i2;
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setStrokeColor(int i2) {
        this.mPaintStroke.setColor(i2);
        invalidate();
    }

    public int getStrokeColor() {
        return this.mPaintStroke.getColor();
    }

    public void setStrokeWidth(float f2) {
        this.mPaintStroke.setStrokeWidth(f2);
        invalidate();
    }

    public float getStrokeWidth() {
        return this.mPaintStroke.getStrokeWidth();
    }

    public void setRadius(float f2) {
        this.mRadius = f2;
        invalidate();
    }

    public float getRadius() {
        return this.mRadius;
    }

    public void setSnap(boolean z) {
        this.mSnap = z;
        invalidate();
    }

    public boolean isSnap() {
        return this.mSnap;
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
        if (this.mViewPager != null && (itemActualCount = getItemActualCount()) != 0) {
            if (this.mCurrentPage >= itemActualCount) {
                setCurrentItem(itemActualCount - 1);
                return;
            }
            if (this.mOrientation == 0) {
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
            float f4 = this.mRadius;
            float f5 = 3.0f * f4;
            float f6 = ((float) i2) + f4;
            float f7 = ((float) i4) + f4;
            if (this.mCentered) {
                f7 += (((float) ((i5 - i4) - i3)) / 2.0f) - ((((float) itemActualCount) * f5) / 2.0f);
            }
            float f8 = this.mRadius;
            if (this.mPaintStroke.getStrokeWidth() > 0.0f) {
                f8 -= this.mPaintStroke.getStrokeWidth() / 2.0f;
            }
            for (int i6 = 0; i6 < itemActualCount; i6++) {
                float f9 = (((float) i6) * f5) + f7;
                if (this.mOrientation == 0) {
                    f3 = f6;
                } else {
                    f3 = f9;
                    f9 = f6;
                }
                if (this.mPaintPageFill.getAlpha() > 0) {
                    canvas.drawCircle(f9, f3, f8, this.mPaintPageFill);
                }
                float f10 = this.mRadius;
                if (f8 != f10) {
                    canvas.drawCircle(f9, f3, f10, this.mPaintStroke);
                }
            }
            float f11 = ((float) (this.mSnap ? this.mSnapPage : this.mCurrentPage)) * f5;
            if (!this.mSnap) {
                f11 += this.mPageOffset * f5;
            }
            if (this.mOrientation == 0) {
                f2 = f11 + f7;
            } else {
                float f12 = f6;
                f6 = f11 + f7;
                f2 = f12;
            }
            canvas.drawCircle(f2, f6, this.mRadius, this.mPaintFill);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        int i2 = 0;
        if (this.mViewPager == null || getItemActualCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & PriceRangeSeekBar.INVALID_POINTER_ID;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                    float f2 = x - this.mLastMotionX;
                    if (!this.mIsDragging && Math.abs(f2) > ((float) this.mTouchSlop)) {
                        this.mIsDragging = true;
                    }
                    if (this.mIsDragging) {
                        this.mLastMotionX = x;
                        if (this.mViewPager.isFakeDragging() || this.mViewPager.beginFakeDrag()) {
                            this.mViewPager.fakeDragBy(f2);
                        }
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        this.mLastMotionX = motionEvent.getX(actionIndex);
                        this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                    } else if (action == 6) {
                        int actionIndex2 = motionEvent.getActionIndex();
                        if (motionEvent.getPointerId(actionIndex2) == this.mActivePointerId) {
                            if (actionIndex2 == 0) {
                                i2 = 1;
                            }
                            this.mActivePointerId = motionEvent.getPointerId(i2);
                        }
                        this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                    }
                }
            }
            if (!this.mIsDragging) {
                int itemActualCount = getItemActualCount();
                float width = (float) getWidth();
                float f3 = width / 2.0f;
                float f4 = width / 6.0f;
                if (this.mCurrentPage > 0 && motionEvent.getX() < f3 - f4) {
                    if (action != 3) {
                        this.mViewPager.setCurrentItem(this.mCurrentPage - 1);
                    }
                    return true;
                } else if (this.mCurrentPage < itemActualCount - 1 && motionEvent.getX() > f3 + f4) {
                    if (action != 3) {
                        this.mViewPager.setCurrentItem(this.mCurrentPage + 1);
                    }
                    return true;
                }
            }
            this.mIsDragging = false;
            this.mActivePointerId = -1;
            if (this.mViewPager.isFakeDragging()) {
                this.mViewPager.endFakeDrag();
            }
        } else {
            this.mActivePointerId = motionEvent.getPointerId(0);
            this.mLastMotionX = motionEvent.getX();
        }
        return true;
    }

    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.mViewPager;
        if (viewPager2 != viewPager) {
            if (viewPager2 != null) {
                viewPager2.setOnPageChangeListener((ViewPager.e) null);
            }
            if (viewPager.getAdapter() != null) {
                this.mViewPager = viewPager;
                this.mViewPager.setOnPageChangeListener(this);
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
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            viewPager.setCurrentItem(i2);
            this.mCurrentPage = getActualPosition(i2);
            invalidate();
            return;
        }
        throw new IllegalStateException("ViewPager has not been bound.");
    }

    public void notifyDataSetChanged() {
        invalidate();
    }

    public void onPageScrollStateChanged(int i2) {
        this.mScrollState = i2;
        ViewPager.e eVar = this.mListener;
        if (eVar != null) {
            eVar.onPageScrollStateChanged(i2);
        }
    }

    public void onPageScrolled(int i2, float f2, int i3) {
        this.mCurrentPage = getActualPosition(i2);
        this.mPageOffset = f2;
        invalidate();
        ViewPager.e eVar = this.mListener;
        if (eVar != null) {
            eVar.onPageScrolled(i2, f2, i3);
        }
    }

    public void onPageSelected(int i2) {
        if (this.mSnap || this.mScrollState == 0) {
            this.mCurrentPage = getActualPosition(i2);
            this.mSnapPage = getActualPosition(i2);
            invalidate();
        }
        ViewPager.e eVar = this.mListener;
        if (eVar != null) {
            eVar.onPageSelected(i2);
        }
    }

    public void setOnPageChangeListener(ViewPager.e eVar) {
        this.mListener = eVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.mOrientation == 0) {
            setMeasuredDimension(measureLong(i2), measureShort(i3));
        } else {
            setMeasuredDimension(measureShort(i2), measureLong(i3));
        }
    }

    private int measureLong(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 || this.mViewPager == null) {
            return size;
        }
        int itemActualCount = getItemActualCount();
        float f2 = this.mRadius;
        int paddingLeft = (int) (((float) (getPaddingLeft() + getPaddingRight())) + (((float) (itemActualCount * 2)) * f2) + (((float) (itemActualCount - 1)) * f2) + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
    }

    private int measureShort(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (int) ((this.mRadius * 2.0f) + ((float) getPaddingTop()) + ((float) getPaddingBottom()) + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentPage = savedState.currentPage;
        this.mSnapPage = savedState.currentPage;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.currentPage = this.mCurrentPage;
        return savedState;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        int currentPage;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.currentPage = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.currentPage);
        }
    }

    private int getItemActualCount() {
        if (this.mViewPager.getAdapter() instanceof SliderViewPagerAdapter) {
            return ((SliderViewPagerAdapter) this.mViewPager.getAdapter()).getActualCount();
        }
        return this.mViewPager.getAdapter().getCount();
    }

    private int getActualPosition(int i2) {
        int actualCount;
        if (!(this.mViewPager.getAdapter() instanceof SliderViewPagerAdapter) || (actualCount = ((SliderViewPagerAdapter) this.mViewPager.getAdapter()).getActualCount()) == 0) {
            return i2;
        }
        return i2 % actualCount;
    }
}
