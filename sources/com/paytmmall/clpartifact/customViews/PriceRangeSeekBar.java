package com.paytmmall.clpartifact.customViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.widget.AppCompatImageView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import java.lang.Number;
import java.math.BigDecimal;

public class PriceRangeSeekBar<T extends Number> extends AppCompatImageView {
    public static final int ACTION_POINTER_INDEX_MASK = 65280;
    public static final int ACTION_POINTER_INDEX_SHIFT = 8;
    public static final int ACTION_POINTER_UP = 6;
    public static final int DEFAULT_COLOR = Color.argb(INVALID_POINTER_ID, 51, 181, 229);
    public static final Integer DEFAULT_MAXIMUM = 100;
    public static final Integer DEFAULT_MINIMUM = 0;
    private static final int DEFAULT_TEXT_DISTANCE_TO_BUTTON_IN_DP = 8;
    private static final int DEFAULT_TEXT_DISTANCE_TO_TOP_IN_DP = 8;
    private static final int DEFAULT_TEXT_SIZE_IN_DP = 14;
    public static final int HEIGHT_IN_DP = 30;
    private static final int INITIAL_PADDING_IN_DP = 5;
    public static final int INVALID_POINTER_ID = 255;
    private float INITIAL_PADDING;
    private final int LINE_HEIGHT_IN_DP = 4;
    private T absoluteMaxValue;
    private double absoluteMaxValuePrim;
    private T absoluteMinValue;
    private double absoluteMinValuePrim;
    private OnRangeSeekBarChangeListener<T> listener;
    private int mActivePointerId = INVALID_POINTER_ID;
    private int mDistanceToTop;
    private float mDownMotionX;
    private boolean mIsDragging;
    private RectF mRect;
    private int mScaledTouchSlop;
    private boolean mSingleThumb;
    private int mTextOffset;
    private int mTextSize;
    private double normalizedMaxValue = 1.0d;
    private double normalizedMinValue = 0.0d;
    private boolean notifyWhileDragging = false;
    private NumberType numberType;
    private float padding;
    private final Paint paint = new Paint(1);
    private Thumb pressedThumb = null;
    private final Bitmap thumbDisabledImage = BitmapFactory.decodeResource(getResources(), R.drawable.ic_range_selector_44);
    private final float thumbHalfHeight = (((float) this.thumbImage.getHeight()) * 0.5f);
    private final float thumbHalfWidth = (this.thumbWidth * 0.5f);
    private final Bitmap thumbImage = BitmapFactory.decodeResource(getResources(), R.drawable.ic_range_selector_44);
    private final Bitmap thumbPressedImage = BitmapFactory.decodeResource(getResources(), R.drawable.ic_range_selector_44);
    private final float thumbWidth = ((float) this.thumbImage.getWidth());

    public interface OnRangeSeekBarChangeListener<T> {
        void onRangeSeekBarValuesChanged(PriceRangeSeekBar<?> priceRangeSeekBar, T t, T t2);
    }

    enum Thumb {
        MIN,
        MAX
    }

    public PriceRangeSeekBar(Context context) {
        super(context);
    }

    public PriceRangeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public PriceRangeSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context, attributeSet);
    }

    private T extractNumericValueFromAttributes(TypedArray typedArray, int i2, int i3) {
        TypedValue peekValue = typedArray.peekValue(i2);
        if (peekValue == null) {
            return Integer.valueOf(i3);
        }
        if (peekValue.type == 4) {
            return Float.valueOf(typedArray.getFloat(i2, (float) i3));
        }
        return Integer.valueOf(typedArray.getInteger(i2, i3));
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            setRangeToDefaultValues();
        } else {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.PriceSeekBar, 0, 0);
            setRangeValues(extractNumericValueFromAttributes(obtainStyledAttributes, R.styleable.PriceSeekBar_absoluteMinValue, DEFAULT_MINIMUM.intValue()), extractNumericValueFromAttributes(obtainStyledAttributes, R.styleable.PriceSeekBar_absoluteMaxValue, DEFAULT_MAXIMUM.intValue()));
            this.mSingleThumb = obtainStyledAttributes.getBoolean(R.styleable.PriceSeekBar_singleThumb, false);
            obtainStyledAttributes.recycle();
        }
        setValuePrimAndNumberType();
        this.INITIAL_PADDING = (float) dpToPx(context, 5);
        this.mTextSize = dpToPx(context, 14);
        this.mDistanceToTop = dpToPx(context, 8);
        this.mTextOffset = this.mTextSize + dpToPx(context, 8) + this.mDistanceToTop;
        float dpToPx = ((float) dpToPx(context, 4)) / 2.0f;
        this.mRect = new RectF(this.padding, (((float) this.mTextOffset) + this.thumbHalfHeight) - dpToPx, ((float) getWidth()) - this.padding, ((float) this.mTextOffset) + this.thumbHalfHeight + dpToPx);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.mScaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public void setRangeValues(T t, T t2) {
        this.absoluteMinValue = t;
        this.absoluteMaxValue = t2;
        setValuePrimAndNumberType();
    }

    private void setRangeToDefaultValues() {
        this.absoluteMinValue = DEFAULT_MINIMUM;
        this.absoluteMaxValue = DEFAULT_MAXIMUM;
        setValuePrimAndNumberType();
    }

    private void setValuePrimAndNumberType() {
        this.absoluteMinValuePrim = this.absoluteMinValue.doubleValue();
        this.absoluteMaxValuePrim = this.absoluteMaxValue.doubleValue();
        this.numberType = NumberType.fromNumber(this.absoluteMinValue);
    }

    public void resetSelectedValues() {
        setSelectedMinValue(this.absoluteMinValue);
        setSelectedMaxValue(this.absoluteMaxValue);
    }

    public boolean isNotifyWhileDragging() {
        return this.notifyWhileDragging;
    }

    public void setNotifyWhileDragging(boolean z) {
        this.notifyWhileDragging = z;
    }

    public T getAbsoluteMinValue() {
        return this.absoluteMinValue;
    }

    public T getAbsoluteMaxValue() {
        return this.absoluteMaxValue;
    }

    public T getSelectedMinValue() {
        return normalizedToValue(this.normalizedMinValue);
    }

    public void setSelectedMinValue(T t) {
        if (0.0d == this.absoluteMaxValuePrim - this.absoluteMinValuePrim) {
            setNormalizedMinValue(t.doubleValue());
        } else {
            setNormalizedMinValue(valueToNormalized(t));
        }
    }

    public T getSelectedMaxValue() {
        return normalizedToValue(this.normalizedMaxValue);
    }

    public void setSelectedMaxValue(T t) {
        if (0.0d == this.absoluteMaxValuePrim - this.absoluteMinValuePrim) {
            setNormalizedMaxValue(1.0d);
        } else {
            setNormalizedMaxValue(valueToNormalized(t));
        }
    }

    public void setOnRangeSeekBarChangeListener(OnRangeSeekBarChangeListener<T> onRangeSeekBarChangeListener) {
        this.listener = onRangeSeekBarChangeListener;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        OnRangeSeekBarChangeListener<T> onRangeSeekBarChangeListener;
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction() & INVALID_POINTER_ID;
        if (action == 0) {
            this.mActivePointerId = motionEvent.getPointerId(motionEvent.getPointerCount() - 1);
            this.mDownMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
            this.pressedThumb = evalPressedThumb(this.mDownMotionX);
            if (this.pressedThumb == null) {
                return super.onTouchEvent(motionEvent);
            }
            setPressed(true);
            invalidate();
            onStartTrackingTouch();
            trackTouchEvent(motionEvent);
            attemptClaimDrag();
        } else if (action == 1) {
            if (this.mIsDragging) {
                trackTouchEvent(motionEvent);
                onStopTrackingTouch();
                setPressed(false);
            } else {
                onStartTrackingTouch();
                trackTouchEvent(motionEvent);
                onStopTrackingTouch();
            }
            this.pressedThumb = null;
            invalidate();
            OnRangeSeekBarChangeListener<T> onRangeSeekBarChangeListener2 = this.listener;
            if (onRangeSeekBarChangeListener2 != null) {
                onRangeSeekBarChangeListener2.onRangeSeekBarValuesChanged(this, getSelectedMinValue(), getSelectedMaxValue());
            }
        } else if (action != 2) {
            if (action != 3) {
                if (action == 5) {
                    int pointerCount = motionEvent.getPointerCount() - 1;
                    this.mDownMotionX = motionEvent.getX(pointerCount);
                    this.mActivePointerId = motionEvent.getPointerId(pointerCount);
                } else if (action == 6) {
                    onSecondaryPointerUp(motionEvent);
                }
            } else if (this.mIsDragging) {
                onStopTrackingTouch();
                setPressed(false);
            }
            invalidate();
        } else if (this.pressedThumb != null) {
            if (this.mIsDragging) {
                trackTouchEvent(motionEvent);
            } else if (Math.abs(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)) - this.mDownMotionX) > ((float) this.mScaledTouchSlop)) {
                setPressed(true);
                invalidate();
                onStartTrackingTouch();
                trackTouchEvent(motionEvent);
                attemptClaimDrag();
            }
            if (this.notifyWhileDragging && (onRangeSeekBarChangeListener = this.listener) != null) {
                onRangeSeekBarChangeListener.onRangeSeekBarValuesChanged(this, getSelectedMinValue(), getSelectedMaxValue());
            }
        }
        return true;
    }

    private final void onSecondaryPointerUp(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & ACTION_POINTER_INDEX_MASK) >> 8;
        if (motionEvent.getPointerId(action) == this.mActivePointerId) {
            int i2 = action == 0 ? 1 : 0;
            this.mDownMotionX = motionEvent.getX(i2);
            this.mActivePointerId = motionEvent.getPointerId(i2);
        }
    }

    private final void trackTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
        if (Thumb.MIN.equals(this.pressedThumb) && !this.mSingleThumb) {
            setNormalizedMinValue(screenToNormalized(x));
        } else if (Thumb.MAX.equals(this.pressedThumb)) {
            setNormalizedMaxValue(screenToNormalized(x));
        }
    }

    private void attemptClaimDrag() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void onStartTrackingTouch() {
        this.mIsDragging = true;
    }

    /* access modifiers changed from: package-private */
    public void onStopTrackingTouch() {
        this.mIsDragging = false;
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i2, int i3) {
        int i4 = 200;
        if (View.MeasureSpec.getMode(i2) != 0) {
            i4 = View.MeasureSpec.getSize(i2);
        }
        int dpToPx = dpToPx(getContext(), 30) + 300;
        if (View.MeasureSpec.getMode(i3) != 0) {
            dpToPx = Math.min(dpToPx, View.MeasureSpec.getSize(i3));
        }
        setMeasuredDimension(i4, dpToPx);
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.paint.setTextSize((float) this.mTextSize);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(CLPArtifact.getInstance().getContext().getResources().getColor(R.color.gray_filer_list));
        boolean z = true;
        this.paint.setAntiAlias(true);
        float max = Math.max(this.paint.measureText(""), this.paint.measureText(""));
        float f2 = ((float) this.mTextOffset) + this.thumbHalfHeight + ((float) (this.mTextSize / 3));
        canvas.drawText("", 0.0f, f2, this.paint);
        canvas.drawText("", ((float) getWidth()) - max, f2, this.paint);
        this.padding = this.INITIAL_PADDING + max + this.thumbHalfWidth;
        this.mRect.left = this.padding;
        this.mRect.right = ((float) getWidth()) - this.padding;
        canvas.drawRect(this.mRect, this.paint);
        if (!getSelectedMinValue().equals(getAbsoluteMinValue()) || !getSelectedMaxValue().equals(getAbsoluteMaxValue())) {
            z = false;
        }
        int color = z ? CLPArtifact.getInstance().getContext().getResources().getColor(R.color.primaryBlue) : DEFAULT_COLOR;
        this.mRect.left = normalizedToScreen(this.normalizedMinValue);
        this.mRect.right = normalizedToScreen(this.normalizedMaxValue);
        this.paint.setColor(color);
        canvas.drawRect(this.mRect, this.paint);
        if (!this.mSingleThumb) {
            drawThumb(normalizedToScreen(this.normalizedMinValue), Thumb.MIN.equals(this.pressedThumb), canvas, z);
        }
        drawThumb(normalizedToScreen(this.normalizedMaxValue), Thumb.MAX.equals(this.pressedThumb), canvas, z);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("SUPER", super.onSaveInstanceState());
        bundle.putDouble("MIN", this.normalizedMinValue);
        bundle.putDouble("MAX", this.normalizedMaxValue);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("SUPER"));
        this.normalizedMinValue = bundle.getDouble("MIN");
        this.normalizedMaxValue = bundle.getDouble("MAX");
    }

    private void drawThumb(float f2, boolean z, Canvas canvas, boolean z2) {
        Bitmap bitmap;
        if (z2) {
            bitmap = this.thumbDisabledImage;
        } else {
            bitmap = z ? this.thumbPressedImage : this.thumbImage;
        }
        canvas.drawBitmap(bitmap, f2 - this.thumbHalfWidth, (float) this.mTextOffset, this.paint);
    }

    private Thumb evalPressedThumb(float f2) {
        boolean isInThumbRange = isInThumbRange(f2, this.normalizedMinValue);
        boolean isInThumbRange2 = isInThumbRange(f2, this.normalizedMaxValue);
        if (isInThumbRange && isInThumbRange2) {
            return f2 / ((float) getWidth()) > 0.5f ? Thumb.MIN : Thumb.MAX;
        }
        if (isInThumbRange) {
            return Thumb.MIN;
        }
        if (isInThumbRange2) {
            return Thumb.MAX;
        }
        return null;
    }

    private boolean isInThumbRange(float f2, double d2) {
        return Math.abs(f2 - normalizedToScreen(d2)) <= this.thumbHalfWidth;
    }

    private void setNormalizedMinValue(double d2) {
        this.normalizedMinValue = Math.max(0.0d, Math.min(1.0d, Math.min(d2, this.normalizedMaxValue)));
        invalidate();
    }

    private void setNormalizedMaxValue(double d2) {
        this.normalizedMaxValue = Math.max(0.0d, Math.min(1.0d, Math.max(d2, this.normalizedMinValue)));
        invalidate();
    }

    private T normalizedToValue(double d2) {
        double d3 = this.absoluteMinValuePrim;
        return this.numberType.toNumber(((double) Math.round((d3 + (d2 * (this.absoluteMaxValuePrim - d3))) * 100.0d)) / 100.0d);
    }

    private double valueToNormalized(T t) {
        if (0.0d == this.absoluteMaxValuePrim - this.absoluteMinValuePrim) {
            return 0.0d;
        }
        double doubleValue = t.doubleValue();
        double d2 = this.absoluteMinValuePrim;
        return (doubleValue - d2) / (this.absoluteMaxValuePrim - d2);
    }

    private float normalizedToScreen(double d2) {
        return (float) (((double) this.padding) + (d2 * ((double) (((float) getWidth()) - (this.padding * 2.0f)))));
    }

    private double screenToNormalized(float f2) {
        float width = (float) getWidth();
        float f3 = this.padding;
        if (width <= f3 * 2.0f) {
            return 0.0d;
        }
        return Math.min(1.0d, Math.max(0.0d, (double) ((f2 - f3) / (width - (f3 * 2.0f)))));
    }

    enum NumberType {
        LONG,
        DOUBLE,
        INTEGER,
        FLOAT,
        SHORT,
        BYTE,
        BIG_DECIMAL;

        public static <E extends Number> NumberType fromNumber(E e2) throws IllegalArgumentException {
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
                    return Long.valueOf((long) d2);
                case DOUBLE:
                    return Double.valueOf(d2);
                case INTEGER:
                    return Integer.valueOf((int) d2);
                case FLOAT:
                    return Float.valueOf((float) d2);
                case SHORT:
                    return Short.valueOf((short) ((int) d2));
                case BYTE:
                    return Byte.valueOf((byte) ((int) d2));
                case BIG_DECIMAL:
                    return BigDecimal.valueOf(d2);
                default:
                    throw new InstantiationError("can't convert " + this + " to a Number object");
            }
        }
    }

    public static int dpToPx(Context context, int i2) {
        return Math.round(((float) i2) * getPixelScaleFactor(context));
    }

    public static int pxToDp(Context context, int i2) {
        return Math.round(((float) i2) / getPixelScaleFactor(context));
    }

    private static float getPixelScaleFactor(Context context) {
        return context.getResources().getDisplayMetrics().xdpi / 160.0f;
    }
}
