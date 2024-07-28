package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.ImageView;
import java.util.HashSet;

public class RoundedDrawable extends Drawable {
    public static final int DEFAULT_BORDER_COLOR = Color.parseColor("#669b9b9b");
    public static final String TAG = "RoundedDrawable";
    private final Bitmap mBitmap;
    private final int mBitmapHeight;
    private final Paint mBitmapPaint;
    private final RectF mBitmapRect = new RectF();
    private final int mBitmapWidth;
    private ColorStateList mBorderColor = ColorStateList.valueOf(DEFAULT_BORDER_COLOR);
    private final Paint mBorderPaint;
    private final RectF mBorderRect = new RectF();
    private float mBorderWidth = 0.0f;
    private final RectF mBounds = new RectF();
    private float mCornerRadius = 0.0f;
    private final boolean[] mCornersRounded = {true, true, true, true};
    private final RectF mDrawableRect = new RectF();
    private boolean mOval = false;
    private boolean mRebuildShader = true;
    private ImageView.ScaleType mScaleType = ImageView.ScaleType.FIT_CENTER;
    private final Matrix mShaderMatrix = new Matrix();
    private final RectF mSquareCornersRect = new RectF();
    private Shader.TileMode mTileModeX = Shader.TileMode.CLAMP;
    private Shader.TileMode mTileModeY = Shader.TileMode.CLAMP;

    public int getOpacity() {
        return -3;
    }

    public RoundedDrawable(Bitmap bitmap) {
        this.mBitmap = bitmap;
        this.mBitmapWidth = bitmap.getWidth();
        this.mBitmapHeight = bitmap.getHeight();
        this.mBitmapRect.set(0.0f, 0.0f, (float) this.mBitmapWidth, (float) this.mBitmapHeight);
        this.mBitmapPaint = new Paint();
        this.mBitmapPaint.setStyle(Paint.Style.FILL);
        this.mBitmapPaint.setAntiAlias(true);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor.getColorForState(getState(), DEFAULT_BORDER_COLOR));
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
    }

    public static RoundedDrawable fromBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            return new RoundedDrawable(bitmap);
        }
        return null;
    }

    public static Drawable fromDrawable(Drawable drawable) {
        if (drawable == null || (drawable instanceof RoundedDrawable)) {
            return drawable;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                layerDrawable.setDrawableByLayerId(layerDrawable.getId(i2), fromDrawable(layerDrawable.getDrawable(i2)));
            }
            return layerDrawable;
        }
        Bitmap drawableToBitmap = drawableToBitmap(drawable);
        return drawableToBitmap != null ? new RoundedDrawable(drawableToBitmap) : drawable;
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public Bitmap getSourceBitmap() {
        return this.mBitmap;
    }

    public boolean isStateful() {
        return this.mBorderColor.isStateful();
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int colorForState = this.mBorderColor.getColorForState(iArr, 0);
        if (this.mBorderPaint.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.mBorderPaint.setColor(colorForState);
        return true;
    }

    /* renamed from: com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.RoundedDrawable$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType = new int[ImageView.ScaleType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$android$widget$ImageView$ScaleType = r0
                int[] r0 = $SwitchMap$android$widget$ImageView$ScaleType     // Catch:{ NoSuchFieldError -> 0x0014 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$android$widget$ImageView$ScaleType     // Catch:{ NoSuchFieldError -> 0x001f }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$android$widget$ImageView$ScaleType     // Catch:{ NoSuchFieldError -> 0x002a }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$android$widget$ImageView$ScaleType     // Catch:{ NoSuchFieldError -> 0x0035 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = $SwitchMap$android$widget$ImageView$ScaleType     // Catch:{ NoSuchFieldError -> 0x0040 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = $SwitchMap$android$widget$ImageView$ScaleType     // Catch:{ NoSuchFieldError -> 0x004b }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r0 = $SwitchMap$android$widget$ImageView$ScaleType     // Catch:{ NoSuchFieldError -> 0x0056 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.RoundedDrawable.AnonymousClass1.<clinit>():void");
        }
    }

    private void updateShaderMatrix() {
        float f2;
        float f3;
        float f4;
        int i2 = AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
        if (i2 == 1) {
            this.mBorderRect.set(this.mBounds);
            RectF rectF = this.mBorderRect;
            float f5 = this.mBorderWidth;
            rectF.inset(f5 / 2.0f, f5 / 2.0f);
            this.mShaderMatrix.reset();
            this.mShaderMatrix.setTranslate((float) ((int) (((this.mBorderRect.width() - ((float) this.mBitmapWidth)) * 0.5f) + 0.5f)), (float) ((int) (((this.mBorderRect.height() - ((float) this.mBitmapHeight)) * 0.5f) + 0.5f)));
        } else if (i2 == 2) {
            this.mBorderRect.set(this.mBounds);
            RectF rectF2 = this.mBorderRect;
            float f6 = this.mBorderWidth;
            rectF2.inset(f6 / 2.0f, f6 / 2.0f);
            this.mShaderMatrix.reset();
            float f7 = 0.0f;
            if (((float) this.mBitmapWidth) * this.mBorderRect.height() > this.mBorderRect.width() * ((float) this.mBitmapHeight)) {
                f3 = this.mBorderRect.height() / ((float) this.mBitmapHeight);
                f2 = (this.mBorderRect.width() - (((float) this.mBitmapWidth) * f3)) * 0.5f;
            } else {
                f3 = this.mBorderRect.width() / ((float) this.mBitmapWidth);
                f7 = (this.mBorderRect.height() - (((float) this.mBitmapHeight) * f3)) * 0.5f;
                f2 = 0.0f;
            }
            this.mShaderMatrix.setScale(f3, f3);
            Matrix matrix = this.mShaderMatrix;
            float f8 = this.mBorderWidth;
            matrix.postTranslate(((float) ((int) (f2 + 0.5f))) + (f8 / 2.0f), ((float) ((int) (f7 + 0.5f))) + (f8 / 2.0f));
        } else if (i2 == 3) {
            this.mShaderMatrix.reset();
            if (((float) this.mBitmapWidth) > this.mBounds.width() || ((float) this.mBitmapHeight) > this.mBounds.height()) {
                f4 = Math.min(this.mBounds.width() / ((float) this.mBitmapWidth), this.mBounds.height() / ((float) this.mBitmapHeight));
            } else {
                f4 = 1.0f;
            }
            this.mShaderMatrix.setScale(f4, f4);
            this.mShaderMatrix.postTranslate((float) ((int) (((this.mBounds.width() - (((float) this.mBitmapWidth) * f4)) * 0.5f) + 0.5f)), (float) ((int) (((this.mBounds.height() - (((float) this.mBitmapHeight) * f4)) * 0.5f) + 0.5f)));
            this.mBorderRect.set(this.mBitmapRect);
            this.mShaderMatrix.mapRect(this.mBorderRect);
            RectF rectF3 = this.mBorderRect;
            float f9 = this.mBorderWidth;
            rectF3.inset(f9 / 2.0f, f9 / 2.0f);
            this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
        } else if (i2 == 5) {
            this.mBorderRect.set(this.mBitmapRect);
            this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBounds, Matrix.ScaleToFit.END);
            this.mShaderMatrix.mapRect(this.mBorderRect);
            RectF rectF4 = this.mBorderRect;
            float f10 = this.mBorderWidth;
            rectF4.inset(f10 / 2.0f, f10 / 2.0f);
            this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
        } else if (i2 == 6) {
            this.mBorderRect.set(this.mBitmapRect);
            this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBounds, Matrix.ScaleToFit.START);
            this.mShaderMatrix.mapRect(this.mBorderRect);
            RectF rectF5 = this.mBorderRect;
            float f11 = this.mBorderWidth;
            rectF5.inset(f11 / 2.0f, f11 / 2.0f);
            this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
        } else if (i2 != 7) {
            this.mBorderRect.set(this.mBitmapRect);
            this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBounds, Matrix.ScaleToFit.CENTER);
            this.mShaderMatrix.mapRect(this.mBorderRect);
            RectF rectF6 = this.mBorderRect;
            float f12 = this.mBorderWidth;
            rectF6.inset(f12 / 2.0f, f12 / 2.0f);
            this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
        } else {
            this.mBorderRect.set(this.mBounds);
            RectF rectF7 = this.mBorderRect;
            float f13 = this.mBorderWidth;
            rectF7.inset(f13 / 2.0f, f13 / 2.0f);
            this.mShaderMatrix.reset();
            this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
        }
        this.mDrawableRect.set(this.mBorderRect);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mBounds.set(rect);
        updateShaderMatrix();
    }

    public void draw(Canvas canvas) {
        if (this.mRebuildShader) {
            BitmapShader bitmapShader = new BitmapShader(this.mBitmap, this.mTileModeX, this.mTileModeY);
            if (this.mTileModeX == Shader.TileMode.CLAMP && this.mTileModeY == Shader.TileMode.CLAMP) {
                bitmapShader.setLocalMatrix(this.mShaderMatrix);
            }
            this.mBitmapPaint.setShader(bitmapShader);
            this.mRebuildShader = false;
        }
        if (this.mOval) {
            if (this.mBorderWidth > 0.0f) {
                canvas.drawOval(this.mDrawableRect, this.mBitmapPaint);
                canvas.drawOval(this.mBorderRect, this.mBorderPaint);
                return;
            }
            canvas.drawOval(this.mDrawableRect, this.mBitmapPaint);
        } else if (any(this.mCornersRounded)) {
            float f2 = this.mCornerRadius;
            if (this.mBorderWidth > 0.0f) {
                canvas.drawRoundRect(this.mDrawableRect, f2, f2, this.mBitmapPaint);
                canvas.drawRoundRect(this.mBorderRect, f2, f2, this.mBorderPaint);
                redrawBitmapForSquareCorners(canvas);
                redrawBorderForSquareCorners(canvas);
                return;
            }
            canvas.drawRoundRect(this.mDrawableRect, f2, f2, this.mBitmapPaint);
            redrawBitmapForSquareCorners(canvas);
        } else {
            canvas.drawRect(this.mDrawableRect, this.mBitmapPaint);
            if (this.mBorderWidth > 0.0f) {
                canvas.drawRect(this.mBorderRect, this.mBorderPaint);
            }
        }
    }

    private void redrawBitmapForSquareCorners(Canvas canvas) {
        if (!all(this.mCornersRounded) && this.mCornerRadius != 0.0f) {
            float f2 = this.mDrawableRect.left;
            float f3 = this.mDrawableRect.top;
            float width = this.mDrawableRect.width() + f2;
            float height = this.mDrawableRect.height() + f3;
            float f4 = this.mCornerRadius;
            if (!this.mCornersRounded[0]) {
                this.mSquareCornersRect.set(f2, f3, f2 + f4, f3 + f4);
                canvas.drawRect(this.mSquareCornersRect, this.mBitmapPaint);
            }
            if (!this.mCornersRounded[1]) {
                this.mSquareCornersRect.set(width - f4, f3, width, f4);
                canvas.drawRect(this.mSquareCornersRect, this.mBitmapPaint);
            }
            if (!this.mCornersRounded[2]) {
                this.mSquareCornersRect.set(width - f4, height - f4, width, height);
                canvas.drawRect(this.mSquareCornersRect, this.mBitmapPaint);
            }
            if (!this.mCornersRounded[3]) {
                this.mSquareCornersRect.set(f2, height - f4, f4 + f2, height);
                canvas.drawRect(this.mSquareCornersRect, this.mBitmapPaint);
            }
        }
    }

    private void redrawBorderForSquareCorners(Canvas canvas) {
        if (!all(this.mCornersRounded) && this.mCornerRadius != 0.0f) {
            float f2 = this.mDrawableRect.left;
            float f3 = this.mDrawableRect.top;
            float width = f2 + this.mDrawableRect.width();
            float height = f3 + this.mDrawableRect.height();
            float f4 = this.mCornerRadius;
            float f5 = this.mBorderWidth / 2.0f;
            if (!this.mCornersRounded[0]) {
                canvas.drawLine(f2 - f5, f3, f2 + f4, f3, this.mBorderPaint);
                canvas.drawLine(f2, f3 - f5, f2, f3 + f4, this.mBorderPaint);
            }
            if (!this.mCornersRounded[1]) {
                Canvas canvas2 = canvas;
                float f6 = width;
                canvas2.drawLine((width - f4) - f5, f3, f6, f3, this.mBorderPaint);
                canvas2.drawLine(width, f3 - f5, f6, f3 + f4, this.mBorderPaint);
            }
            if (!this.mCornersRounded[2]) {
                Canvas canvas3 = canvas;
                float f7 = height;
                canvas3.drawLine((width - f4) - f5, height, width + f5, f7, this.mBorderPaint);
                canvas3.drawLine(width, height - f4, width, f7, this.mBorderPaint);
            }
            if (!this.mCornersRounded[3]) {
                canvas.drawLine(f2 - f5, height, f2 + f4, height, this.mBorderPaint);
                canvas.drawLine(f2, height - f4, f2, height, this.mBorderPaint);
            }
        }
    }

    public int getAlpha() {
        return this.mBitmapPaint.getAlpha();
    }

    public void setAlpha(int i2) {
        this.mBitmapPaint.setAlpha(i2);
        invalidateSelf();
    }

    public ColorFilter getColorFilter() {
        return this.mBitmapPaint.getColorFilter();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mBitmapPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setDither(boolean z) {
        this.mBitmapPaint.setDither(z);
        invalidateSelf();
    }

    public void setFilterBitmap(boolean z) {
        this.mBitmapPaint.setFilterBitmap(z);
        invalidateSelf();
    }

    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    public float getCornerRadius(int i2) {
        if (this.mCornersRounded[i2]) {
            return this.mCornerRadius;
        }
        return 0.0f;
    }

    public RoundedDrawable setCornerRadius(float f2) {
        setCornerRadius(f2, f2, f2, f2);
        return this;
    }

    public RoundedDrawable setCornerRadius(int i2, float f2) {
        int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i3 != 0) {
            float f3 = this.mCornerRadius;
            if (!(f3 == 0.0f || f3 == f2)) {
                throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
            }
        }
        if (i3 == 0) {
            if (only(i2, this.mCornersRounded)) {
                this.mCornerRadius = 0.0f;
            }
            this.mCornersRounded[i2] = false;
        } else {
            if (this.mCornerRadius == 0.0f) {
                this.mCornerRadius = f2;
            }
            this.mCornersRounded[i2] = true;
        }
        return this;
    }

    public RoundedDrawable setCornerRadius(float f2, float f3, float f4, float f5) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f2));
        hashSet.add(Float.valueOf(f3));
        hashSet.add(Float.valueOf(f4));
        hashSet.add(Float.valueOf(f5));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() <= 1) {
            if (!hashSet.isEmpty()) {
                float floatValue = ((Float) hashSet.iterator().next()).floatValue();
                if (Float.isInfinite(floatValue) || Float.isNaN(floatValue) || floatValue < 0.0f) {
                    throw new IllegalArgumentException("Invalid radius value: ".concat(String.valueOf(floatValue)));
                }
                this.mCornerRadius = floatValue;
            } else {
                this.mCornerRadius = 0.0f;
            }
            boolean z = false;
            this.mCornersRounded[0] = f2 > 0.0f;
            this.mCornersRounded[1] = f3 > 0.0f;
            this.mCornersRounded[2] = f4 > 0.0f;
            boolean[] zArr = this.mCornersRounded;
            if (f5 > 0.0f) {
                z = true;
            }
            zArr[3] = z;
            return this;
        }
        throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundedDrawable setBorderWidth(float f2) {
        this.mBorderWidth = f2;
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor.getDefaultColor();
    }

    public RoundedDrawable setBorderColor(int i2) {
        return setBorderColor(ColorStateList.valueOf(i2));
    }

    public ColorStateList getBorderColors() {
        return this.mBorderColor;
    }

    public RoundedDrawable setBorderColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.mBorderColor = colorStateList;
        this.mBorderPaint.setColor(this.mBorderColor.getColorForState(getState(), DEFAULT_BORDER_COLOR));
        return this;
    }

    public boolean isOval() {
        return this.mOval;
    }

    public RoundedDrawable setOval(boolean z) {
        this.mOval = z;
        return this;
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public RoundedDrawable setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.mScaleType != scaleType) {
            this.mScaleType = scaleType;
            updateShaderMatrix();
        }
        return this;
    }

    public Shader.TileMode getTileModeX() {
        return this.mTileModeX;
    }

    public RoundedDrawable setTileModeX(Shader.TileMode tileMode) {
        if (this.mTileModeX != tileMode) {
            this.mTileModeX = tileMode;
            this.mRebuildShader = true;
            invalidateSelf();
        }
        return this;
    }

    public Shader.TileMode getTileModeY() {
        return this.mTileModeY;
    }

    public RoundedDrawable setTileModeY(Shader.TileMode tileMode) {
        if (this.mTileModeY != tileMode) {
            this.mTileModeY = tileMode;
            this.mRebuildShader = true;
            invalidateSelf();
        }
        return this;
    }

    private static boolean only(int i2, boolean[] zArr) {
        int length = zArr.length;
        int i3 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= length) {
                return true;
            }
            boolean z2 = zArr[i3];
            if (i3 != i2) {
                z = false;
            }
            if (z2 != z) {
                return false;
            }
            i3++;
        }
    }

    private static boolean any(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    private static boolean all(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return false;
            }
        }
        return true;
    }

    public Bitmap toBitmap() {
        return drawableToBitmap(this);
    }
}
