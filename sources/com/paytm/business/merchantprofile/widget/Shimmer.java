package com.paytm.business.merchantprofile.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.paytm.business.merchantprofile.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Shimmer {
    public static final int COMPONENT_COUNT = 4;
    public boolean alphaShimmer;
    public long animationDuration;
    public boolean autoStart;
    public int baseColor;
    public boolean clipToChildren;
    public final int[] colors = new int[4];
    public int direction;
    public float dropoff;
    public int fixedHeight;
    public int fixedWidth;
    public float heightRatio;
    public int highlightColor;
    public float intensity;
    public final float[] positions = new float[4];
    public int repeatCount;
    public long repeatDelay;
    public int repeatMode;
    public int shape;
    public float tilt;
    public float widthRatio;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Direction {
        public static final int BOTTOM_TO_TOP = 3;
        public static final int LEFT_TO_RIGHT = 0;
        public static final int RIGHT_TO_LEFT = 2;
        public static final int TOP_TO_BOTTOM = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Shape {
        public static final int LINEAR = 0;
        public static final int RADIAL = 1;
    }

    public Shimmer() {
        new RectF();
        this.direction = 0;
        this.highlightColor = -1;
        this.baseColor = 1291845631;
        this.shape = 0;
        this.fixedWidth = 0;
        this.fixedHeight = 0;
        this.widthRatio = 1.0f;
        this.heightRatio = 1.0f;
        this.intensity = 0.0f;
        this.dropoff = 0.5f;
        this.tilt = 20.0f;
        this.clipToChildren = true;
        this.autoStart = false;
        this.alphaShimmer = true;
        this.repeatCount = -1;
        this.repeatMode = 1;
        this.animationDuration = 1000;
    }

    public int width(int i2) {
        int i3 = this.fixedWidth;
        return i3 <= 0 ? Math.round(this.widthRatio * ((float) i2)) : i3;
    }

    public int height(int i2) {
        int i3 = this.fixedHeight;
        return i3 <= 0 ? Math.round(this.heightRatio * ((float) i2)) : i3;
    }

    public void updateColors() {
        if (this.shape != 1) {
            int[] iArr = this.colors;
            int i2 = this.baseColor;
            iArr[0] = i2;
            int i3 = this.highlightColor;
            iArr[1] = i3;
            iArr[2] = i3;
            iArr[3] = i2;
            return;
        }
        int[] iArr2 = this.colors;
        int i4 = this.highlightColor;
        iArr2[0] = i4;
        iArr2[1] = i4;
        int i5 = this.baseColor;
        iArr2[2] = i5;
        iArr2[3] = i5;
    }

    public void updatePositions() {
        if (this.shape != 1) {
            this.positions[0] = Math.max(((1.0f - this.intensity) - this.dropoff) / 2.0f, 0.0f);
            this.positions[1] = Math.max(((1.0f - this.intensity) - 0.001f) / 2.0f, 0.0f);
            this.positions[2] = Math.min(((this.intensity + 1.0f) + 0.001f) / 2.0f, 1.0f);
            this.positions[3] = Math.min(((this.intensity + 1.0f) + this.dropoff) / 2.0f, 1.0f);
            return;
        }
        float[] fArr = this.positions;
        fArr[0] = 0.0f;
        fArr[1] = Math.min(this.intensity, 1.0f);
        this.positions[2] = Math.min(this.intensity + this.dropoff, 1.0f);
        this.positions[3] = 1.0f;
    }

    public static abstract class Builder<T extends Builder<T>> {
        public final Shimmer mShimmer = new Shimmer();

        public abstract T getThis();

        public T consumeAttributes(Context context, AttributeSet attributeSet) {
            return consumeAttributes(context.obtainStyledAttributes(attributeSet, R.styleable.ShimmerFrameLayout, 0, 0));
        }

        public T consumeAttributes(TypedArray typedArray) {
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_clip_to_children)) {
                setClipToChildren(typedArray.getBoolean(R.styleable.ShimmerFrameLayout_shimmer_clip_to_children, this.mShimmer.clipToChildren));
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_auto_start)) {
                setAutoStart(typedArray.getBoolean(R.styleable.ShimmerFrameLayout_shimmer_auto_start, this.mShimmer.autoStart));
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_base_alpha)) {
                setBaseAlpha(typedArray.getFloat(R.styleable.ShimmerFrameLayout_shimmer_base_alpha, 0.3f));
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_highlight_alpha)) {
                setHighlightAlpha(typedArray.getFloat(R.styleable.ShimmerFrameLayout_shimmer_highlight_alpha, 1.0f));
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_duration)) {
                setDuration((long) typedArray.getInt(R.styleable.ShimmerFrameLayout_shimmer_duration, (int) this.mShimmer.animationDuration));
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_repeat_count)) {
                setRepeatCount(typedArray.getInt(R.styleable.ShimmerFrameLayout_shimmer_repeat_count, this.mShimmer.repeatCount));
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_repeat_delay)) {
                setRepeatDelay((long) typedArray.getInt(R.styleable.ShimmerFrameLayout_shimmer_repeat_delay, (int) this.mShimmer.repeatDelay));
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_repeat_mode)) {
                setRepeatMode(typedArray.getInt(R.styleable.ShimmerFrameLayout_shimmer_repeat_mode, this.mShimmer.repeatMode));
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_direction)) {
                int i2 = typedArray.getInt(R.styleable.ShimmerFrameLayout_shimmer_direction, this.mShimmer.direction);
                if (i2 == 1) {
                    setDirection(1);
                } else if (i2 == 2) {
                    setDirection(2);
                } else if (i2 != 3) {
                    setDirection(0);
                } else {
                    setDirection(3);
                }
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_shape)) {
                if (typedArray.getInt(R.styleable.ShimmerFrameLayout_shimmer_shape, this.mShimmer.shape) != 1) {
                    setShape(0);
                } else {
                    setShape(1);
                }
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_dropoff)) {
                setDropoff(typedArray.getFloat(R.styleable.ShimmerFrameLayout_shimmer_dropoff, this.mShimmer.dropoff));
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_fixed_width)) {
                setFixedWidth(typedArray.getDimensionPixelSize(R.styleable.ShimmerFrameLayout_shimmer_fixed_width, this.mShimmer.fixedWidth));
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_fixed_height)) {
                setFixedHeight(typedArray.getDimensionPixelSize(R.styleable.ShimmerFrameLayout_shimmer_fixed_height, this.mShimmer.fixedHeight));
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_intensity)) {
                setIntensity(typedArray.getFloat(R.styleable.ShimmerFrameLayout_shimmer_intensity, this.mShimmer.intensity));
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_width_ratio)) {
                setWidthRatio(typedArray.getFloat(R.styleable.ShimmerFrameLayout_shimmer_width_ratio, this.mShimmer.widthRatio));
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_height_ratio)) {
                setHeightRatio(typedArray.getFloat(R.styleable.ShimmerFrameLayout_shimmer_height_ratio, this.mShimmer.heightRatio));
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_tilt)) {
                setTilt(typedArray.getFloat(R.styleable.ShimmerFrameLayout_shimmer_tilt, this.mShimmer.tilt));
            }
            return getThis();
        }

        public T copyFrom(Shimmer shimmer) {
            setDirection(shimmer.direction);
            setShape(shimmer.shape);
            setFixedWidth(shimmer.fixedWidth);
            setFixedHeight(shimmer.fixedHeight);
            setWidthRatio(shimmer.widthRatio);
            setHeightRatio(shimmer.heightRatio);
            setIntensity(shimmer.intensity);
            setDropoff(shimmer.dropoff);
            setTilt(shimmer.tilt);
            setClipToChildren(shimmer.clipToChildren);
            setAutoStart(shimmer.autoStart);
            setRepeatCount(shimmer.repeatCount);
            setRepeatMode(shimmer.repeatMode);
            setRepeatDelay(shimmer.repeatDelay);
            setDuration(shimmer.animationDuration);
            Shimmer shimmer2 = this.mShimmer;
            shimmer2.baseColor = shimmer.baseColor;
            shimmer2.highlightColor = shimmer.highlightColor;
            return getThis();
        }

        public T setDirection(int i2) {
            this.mShimmer.direction = i2;
            return getThis();
        }

        public T setShape(int i2) {
            this.mShimmer.shape = i2;
            return getThis();
        }

        public T setFixedWidth(int i2) {
            if (i2 >= 0) {
                this.mShimmer.fixedWidth = i2;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid width: ".concat(String.valueOf(i2)));
        }

        public T setFixedHeight(int i2) {
            if (i2 >= 0) {
                this.mShimmer.fixedHeight = i2;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid height: ".concat(String.valueOf(i2)));
        }

        public T setWidthRatio(float f2) {
            if (f2 >= 0.0f) {
                this.mShimmer.widthRatio = f2;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid width ratio: ".concat(String.valueOf(f2)));
        }

        public T setHeightRatio(float f2) {
            if (f2 >= 0.0f) {
                this.mShimmer.heightRatio = f2;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid height ratio: ".concat(String.valueOf(f2)));
        }

        public T setIntensity(float f2) {
            if (f2 >= 0.0f) {
                this.mShimmer.intensity = f2;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid intensity value: ".concat(String.valueOf(f2)));
        }

        public T setDropoff(float f2) {
            if (f2 >= 0.0f) {
                this.mShimmer.dropoff = f2;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid dropoff value: ".concat(String.valueOf(f2)));
        }

        public T setTilt(float f2) {
            this.mShimmer.tilt = f2;
            return getThis();
        }

        public T setBaseAlpha(float f2) {
            Shimmer shimmer = this.mShimmer;
            shimmer.baseColor = (((int) (clamp(0.0f, 1.0f, f2) * 255.0f)) << 24) | (shimmer.baseColor & 16777215);
            return getThis();
        }

        public T setHighlightAlpha(float f2) {
            Shimmer shimmer = this.mShimmer;
            shimmer.highlightColor = (((int) (clamp(0.0f, 1.0f, f2) * 255.0f)) << 24) | (shimmer.highlightColor & 16777215);
            return getThis();
        }

        public T setClipToChildren(boolean z) {
            this.mShimmer.clipToChildren = z;
            return getThis();
        }

        public T setAutoStart(boolean z) {
            this.mShimmer.autoStart = z;
            return getThis();
        }

        public T setRepeatCount(int i2) {
            this.mShimmer.repeatCount = i2;
            return getThis();
        }

        public T setRepeatMode(int i2) {
            this.mShimmer.repeatMode = i2;
            return getThis();
        }

        public T setRepeatDelay(long j) {
            if (j >= 0) {
                this.mShimmer.repeatDelay = j;
                return getThis();
            }
            throw new IllegalArgumentException("Given a negative repeat delay: ".concat(String.valueOf(j)));
        }

        public T setDuration(long j) {
            if (j >= 0) {
                this.mShimmer.animationDuration = j;
                return getThis();
            }
            throw new IllegalArgumentException("Given a negative duration: ".concat(String.valueOf(j)));
        }

        public Shimmer build() {
            this.mShimmer.updateColors();
            this.mShimmer.updatePositions();
            return this.mShimmer;
        }

        public static float clamp(float f2, float f3, float f4) {
            return Math.min(f3, Math.max(f2, f4));
        }
    }

    public static class AlphaHighlightBuilder extends Builder<AlphaHighlightBuilder> {
        public AlphaHighlightBuilder getThis() {
            return this;
        }

        public AlphaHighlightBuilder() {
            this.mShimmer.alphaShimmer = true;
        }
    }

    public static class ColorHighlightBuilder extends Builder<ColorHighlightBuilder> {
        public ColorHighlightBuilder getThis() {
            return this;
        }

        public ColorHighlightBuilder() {
            this.mShimmer.alphaShimmer = false;
        }

        public ColorHighlightBuilder setHighlightColor(int i2) {
            this.mShimmer.highlightColor = i2;
            return getThis();
        }

        public ColorHighlightBuilder setBaseColor(int i2) {
            Shimmer shimmer = this.mShimmer;
            shimmer.baseColor = (i2 & 16777215) | (shimmer.baseColor & -16777216);
            return getThis();
        }

        public ColorHighlightBuilder consumeAttributes(TypedArray typedArray) {
            super.consumeAttributes(typedArray);
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_base_color)) {
                setBaseColor(typedArray.getColor(R.styleable.ShimmerFrameLayout_shimmer_base_color, this.mShimmer.baseColor));
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_highlight_color)) {
                setHighlightColor(typedArray.getColor(R.styleable.ShimmerFrameLayout_shimmer_highlight_color, this.mShimmer.highlightColor));
            }
            return getThis();
        }
    }
}
