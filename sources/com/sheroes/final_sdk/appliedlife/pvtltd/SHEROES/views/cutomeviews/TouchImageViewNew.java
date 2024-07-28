package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import android.widget.Scroller;
import androidx.appcompat.widget.AppCompatImageView;

public class TouchImageViewNew extends AppCompatImageView {
    private static final String DEBUG = "DEBUG";
    private static final float SUPER_MAX_MULTIPLIER = 1.25f;
    private static final float SUPER_MIN_MULTIPLIER = 0.75f;
    /* access modifiers changed from: private */
    public Context context;
    private ZoomVariables delayedZoomVariables;
    /* access modifiers changed from: private */
    public GestureDetector.OnDoubleTapListener doubleTapListener = null;
    /* access modifiers changed from: private */
    public Fling fling;
    /* access modifiers changed from: private */
    public float[] m;
    /* access modifiers changed from: private */
    public GestureDetector mGestureDetector;
    /* access modifiers changed from: private */
    public ScaleGestureDetector mScaleDetector;
    private ImageView.ScaleType mScaleType;
    private float matchViewHeight;
    private float matchViewWidth;
    /* access modifiers changed from: private */
    public Matrix matrix;
    /* access modifiers changed from: private */
    public float maxScale;
    /* access modifiers changed from: private */
    public float minScale;
    /* access modifiers changed from: private */
    public float normalizedScale;
    private boolean onDrawReady;
    private float prevMatchViewHeight;
    private float prevMatchViewWidth;
    private Matrix prevMatrix;
    private int prevViewHeight;
    private int prevViewWidth;
    /* access modifiers changed from: private */
    public State state;
    private float superMaxScale;
    private float superMinScale;
    /* access modifiers changed from: private */
    public View.OnTouchListener touchListener = null;
    /* access modifiers changed from: private */
    public int viewHeight;
    /* access modifiers changed from: private */
    public int viewWidth;

    enum State {
        NONE,
        DRAG,
        ZOOM,
        FLING,
        ANIMATE_ZOOM
    }

    /* access modifiers changed from: private */
    public float getFixDragTrans(float f2, float f3, float f4) {
        if (f4 <= f3) {
            return 0.0f;
        }
        return f2;
    }

    private float getFixTrans(float f2, float f3, float f4) {
        float f5;
        float f6;
        if (f4 <= f3) {
            f5 = f3 - f4;
            f6 = 0.0f;
        } else {
            f6 = f3 - f4;
            f5 = 0.0f;
        }
        if (f2 < f6) {
            return (-f2) + f6;
        }
        if (f2 > f5) {
            return (-f2) + f5;
        }
        return 0.0f;
    }

    public TouchImageViewNew(Context context2) {
        super(context2);
        sharedConstructing(context2);
    }

    public TouchImageViewNew(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        sharedConstructing(context2);
    }

    public TouchImageViewNew(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        sharedConstructing(context2);
    }

    private void sharedConstructing(Context context2) {
        super.setClickable(true);
        this.context = context2;
        this.mScaleDetector = new ScaleGestureDetector(context2, new ScaleListener(this, (AnonymousClass1) null));
        this.mGestureDetector = new GestureDetector(context2, new GestureListener(this, (AnonymousClass1) null));
        this.matrix = new Matrix();
        this.prevMatrix = new Matrix();
        this.m = new float[9];
        this.normalizedScale = 1.0f;
        if (this.mScaleType == null) {
            this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        }
        this.minScale = 1.0f;
        this.maxScale = 3.0f;
        this.superMinScale = this.minScale * 0.75f;
        this.superMaxScale = this.maxScale * SUPER_MAX_MULTIPLIER;
        setImageMatrix(this.matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
        setState(State.NONE);
        this.onDrawReady = false;
        super.setOnTouchListener(new TouchImageViewListener(this, (AnonymousClass1) null));
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.touchListener = onTouchListener;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.doubleTapListener = onDoubleTapListener;
    }

    public void setImageResource(int i2) {
        super.setImageResource(i2);
        savePreviousImageValues();
        fitImageToView();
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        savePreviousImageValues();
        fitImageToView();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        savePreviousImageValues();
        fitImageToView();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        savePreviousImageValues();
        fitImageToView();
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.FIT_START || scaleType == ImageView.ScaleType.FIT_END) {
            throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
        } else if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(ImageView.ScaleType.MATRIX);
        } else {
            this.mScaleType = scaleType;
        }
    }

    public boolean isZoomed() {
        return this.normalizedScale != 1.0f;
    }

    public Bitmap getZoomedImage() {
        Bitmap createBitmap = Bitmap.createBitmap(this.viewWidth, this.viewHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        layout(0, 0, this.viewWidth, this.viewHeight);
        draw(canvas);
        return createBitmap;
    }

    public Bitmap getZoomedImageFromSource() {
        if (this.mScaleType != ImageView.ScaleType.FIT_XY) {
            Bitmap bitmap = ((BitmapDrawable) getDrawable()).getBitmap();
            Rect zoomedRect = getZoomedRect();
            if (zoomedRect.width() <= 0 || zoomedRect.height() <= 0) {
                return null;
            }
            return Bitmap.createBitmap(bitmap, zoomedRect.left, zoomedRect.top, zoomedRect.width(), zoomedRect.height());
        }
        throw new UnsupportedOperationException("getZoomedImageFromSource() not supported with FIT_XY");
    }

    public Rect getZoomedRect() {
        if (this.mScaleType != ImageView.ScaleType.FIT_XY) {
            PointF drawablePointFromTouchPoint = getDrawablePointFromTouchPoint(0.0f, 0.0f);
            PointF drawablePointFromTouchPoint2 = getDrawablePointFromTouchPoint((float) this.viewWidth, (float) this.viewHeight);
            return new Rect((int) drawablePointFromTouchPoint.x, (int) drawablePointFromTouchPoint.y, (int) drawablePointFromTouchPoint2.x, (int) drawablePointFromTouchPoint2.y);
        }
        throw new UnsupportedOperationException("getZoomedRect() not supported with FIT_XY");
    }

    private void savePreviousImageValues() {
        Matrix matrix2 = this.matrix;
        if (matrix2 != null) {
            matrix2.getValues(this.m);
            this.prevMatrix.setValues(this.m);
            this.prevMatchViewHeight = this.matchViewHeight;
            this.prevMatchViewWidth = this.matchViewWidth;
            this.prevViewHeight = this.viewHeight;
            this.prevViewWidth = this.viewWidth;
        }
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putFloat("saveScale", this.normalizedScale);
        bundle.putFloat("matchViewHeight", this.matchViewHeight);
        bundle.putFloat("matchViewWidth", this.matchViewWidth);
        bundle.putInt("viewWidth", this.viewWidth);
        bundle.putInt("viewHeight", this.viewHeight);
        this.matrix.getValues(this.m);
        bundle.putFloatArray("matrix", this.m);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.normalizedScale = bundle.getFloat("saveScale");
            this.m = bundle.getFloatArray("matrix");
            this.prevMatrix.setValues(this.m);
            this.prevMatchViewHeight = bundle.getFloat("matchViewHeight");
            this.prevMatchViewWidth = bundle.getFloat("matchViewWidth");
            this.prevViewHeight = bundle.getInt("viewHeight");
            this.prevViewWidth = bundle.getInt("viewWidth");
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.onDrawReady = true;
        ZoomVariables zoomVariables = this.delayedZoomVariables;
        if (zoomVariables != null) {
            setZoom(zoomVariables.scale, this.delayedZoomVariables.focusX, this.delayedZoomVariables.focusY, this.delayedZoomVariables.scaleType);
            this.delayedZoomVariables = null;
        }
        super.onDraw(canvas);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        savePreviousImageValues();
    }

    public float getMaxZoom() {
        return this.maxScale;
    }

    public void setMaxZoom(float f2) {
        this.maxScale = f2;
        this.superMaxScale = this.maxScale * SUPER_MAX_MULTIPLIER;
    }

    public float getMinZoom() {
        return this.minScale;
    }

    public void setMinZoom(float f2) {
        this.minScale = f2;
        this.superMinScale = this.minScale * 0.75f;
    }

    public float getCurrentZoom() {
        return this.normalizedScale;
    }

    public void resetZoom() {
        this.normalizedScale = 1.0f;
        fitImageToView();
    }

    public void setZoom(float f2) {
        setZoom(f2, 0.5f, 0.5f);
    }

    public void setZoom(float f2, float f3, float f4) {
        setZoom(f2, f3, f4, this.mScaleType);
    }

    public void setZoom(float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        if (!this.onDrawReady) {
            this.delayedZoomVariables = new ZoomVariables(f2, f3, f4, scaleType);
            return;
        }
        setScaleType(scaleType);
        resetZoom();
        scaleImage(f2, (float) (this.viewWidth / 2), (float) (this.viewHeight / 2), false);
        this.matrix.getValues(this.m);
        this.m[2] = -((f3 * getImageWidth()) - (((float) this.viewWidth) * 0.5f));
        this.m[5] = -((f4 * getImageHeight()) - (((float) this.viewHeight) * 0.5f));
        this.matrix.setValues(this.m);
        fixTrans();
        setImageMatrix(this.matrix);
    }

    public void setZoom(TouchImageViewNew touchImageViewNew) {
        PointF centerOfZoomedImage = touchImageViewNew.getCenterOfZoomedImage();
        setZoom(touchImageViewNew.getCurrentZoom(), centerOfZoomedImage.x, centerOfZoomedImage.y, touchImageViewNew.getScaleType());
    }

    public PointF getDrawablePointFromTouchPoint(float f2, float f3) {
        return transformCoordTouchToBitmap(f2, f3, true);
    }

    public PointF getDrawablePointFromTouchPoint(PointF pointF) {
        return transformCoordTouchToBitmap(pointF.x, pointF.y, true);
    }

    public PointF getCenterOfZoomedImage() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        PointF drawablePointFromTouchPoint = getDrawablePointFromTouchPoint((float) (this.viewWidth / 2), (float) (this.viewHeight / 2));
        drawablePointFromTouchPoint.x /= (float) intrinsicWidth;
        drawablePointFromTouchPoint.y /= (float) intrinsicHeight;
        return drawablePointFromTouchPoint;
    }

    /* access modifiers changed from: private */
    public void fixTrans() {
        this.matrix.getValues(this.m);
        float[] fArr = this.m;
        float f2 = fArr[2];
        float f3 = fArr[5];
        float fixTrans = getFixTrans(f2, (float) this.viewWidth, getImageWidth());
        float fixTrans2 = getFixTrans(f3, (float) this.viewHeight, getImageHeight());
        if (fixTrans != 0.0f || fixTrans2 != 0.0f) {
            this.matrix.postTranslate(fixTrans, fixTrans2);
        }
    }

    /* access modifiers changed from: private */
    public void fixScaleTrans() {
        fixTrans();
        this.matrix.getValues(this.m);
        float imageWidth = getImageWidth();
        int i2 = this.viewWidth;
        if (imageWidth < ((float) i2)) {
            this.m[2] = (((float) i2) - getImageWidth()) / 2.0f;
        }
        float imageHeight = getImageHeight();
        int i3 = this.viewHeight;
        if (imageHeight < ((float) i3)) {
            this.m[5] = (((float) i3) - getImageHeight()) / 2.0f;
        }
        this.matrix.setValues(this.m);
    }

    /* access modifiers changed from: private */
    public float getImageWidth() {
        return this.matchViewWidth * this.normalizedScale;
    }

    /* access modifiers changed from: private */
    public float getImageHeight() {
        return this.matchViewHeight * this.normalizedScale;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        this.viewWidth = setViewSize(mode, size, intrinsicWidth);
        this.viewHeight = setViewSize(mode2, size2, intrinsicHeight);
        setMeasuredDimension(this.viewWidth, this.viewHeight);
        fitImageToView();
    }

    private void fitImageToView() {
        Drawable drawable = getDrawable();
        if (drawable != null && drawable.getIntrinsicWidth() != 0 && drawable.getIntrinsicHeight() != 0 && this.matrix != null && this.prevMatrix != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            float f2 = (float) intrinsicWidth;
            float f3 = ((float) this.viewWidth) / f2;
            float f4 = (float) intrinsicHeight;
            float f5 = ((float) this.viewHeight) / f4;
            int i2 = AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        f3 = Math.min(1.0f, Math.min(f3, f5));
                        f5 = f3;
                    } else if (i2 != 4) {
                        if (i2 != 5) {
                            throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
                        }
                    }
                    f3 = Math.min(f3, f5);
                } else {
                    f3 = Math.max(f3, f5);
                }
                f5 = f3;
            } else {
                f3 = 1.0f;
                f5 = 1.0f;
            }
            int i3 = this.viewWidth;
            float f6 = ((float) i3) - (f3 * f2);
            int i4 = this.viewHeight;
            float f7 = ((float) i4) - (f5 * f4);
            this.matchViewWidth = ((float) i3) - f6;
            this.matchViewHeight = ((float) i4) - f7;
            if (!isZoomed()) {
                this.matrix.setScale(f3, f5);
                this.matrix.postTranslate(f6 / 2.0f, f7 / 2.0f);
                this.normalizedScale = 1.0f;
            } else {
                if (this.prevMatchViewWidth == 0.0f || this.prevMatchViewHeight == 0.0f) {
                    savePreviousImageValues();
                }
                this.prevMatrix.getValues(this.m);
                float[] fArr = this.m;
                float f8 = this.matchViewWidth / f2;
                float f9 = this.normalizedScale;
                fArr[0] = f8 * f9;
                fArr[4] = (this.matchViewHeight / f4) * f9;
                float f10 = fArr[2];
                float f11 = fArr[5];
                translateMatrixAfterRotate(2, f10, this.prevMatchViewWidth * f9, getImageWidth(), this.prevViewWidth, this.viewWidth, intrinsicWidth);
                translateMatrixAfterRotate(5, f11, this.prevMatchViewHeight * this.normalizedScale, getImageHeight(), this.prevViewHeight, this.viewHeight, intrinsicHeight);
                this.matrix.setValues(this.m);
            }
            fixTrans();
            setImageMatrix(this.matrix);
        }
    }

    /* renamed from: com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType = new int[ImageView.ScaleType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
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
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.AnonymousClass1.<clinit>():void");
        }
    }

    private int setViewSize(int i2, int i3, int i4) {
        if (i2 != Integer.MIN_VALUE) {
            return i2 != 0 ? i3 : i4;
        }
        return Math.min(i4, i3);
    }

    private void translateMatrixAfterRotate(int i2, float f2, float f3, float f4, int i3, int i4, int i5) {
        float f5 = (float) i4;
        if (f4 < f5) {
            float[] fArr = this.m;
            fArr[i2] = (f5 - (((float) i5) * fArr[0])) * 0.5f;
        } else if (f2 > 0.0f) {
            this.m[i2] = -((f4 - f5) * 0.5f);
        } else {
            this.m[i2] = -((((Math.abs(f2) + (((float) i3) * 0.5f)) / f3) * f4) - (f5 * 0.5f));
        }
    }

    /* access modifiers changed from: private */
    public void setState(State state2) {
        this.state = state2;
    }

    public boolean canScrollHorizontally(int i2) {
        this.matrix.getValues(this.m);
        float f2 = this.m[2];
        if (getImageWidth() < ((float) this.viewWidth)) {
            return false;
        }
        if (f2 >= -1.0f && i2 < 0) {
            return false;
        }
        if (Math.abs(f2) + ((float) this.viewWidth) + 1.0f < getImageWidth() || i2 <= 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void scaleImage(float f2, float f3, float f4, boolean z) {
        float f5;
        float f6;
        if (z) {
            f5 = this.superMinScale;
            f6 = this.superMaxScale;
        } else {
            f5 = this.minScale;
            f6 = this.maxScale;
        }
        float f7 = this.normalizedScale;
        this.normalizedScale = f7 * f2;
        float f8 = this.normalizedScale;
        if (f8 > f6) {
            this.normalizedScale = f6;
            f2 = f6 / f7;
        } else if (f8 < f5) {
            this.normalizedScale = f5;
            f2 = f5 / f7;
        }
        this.matrix.postScale(f2, f2, f3, f4);
        fixScaleTrans();
    }

    /* access modifiers changed from: private */
    public PointF transformCoordTouchToBitmap(float f2, float f3, boolean z) {
        this.matrix.getValues(this.m);
        float intrinsicWidth = (float) getDrawable().getIntrinsicWidth();
        float intrinsicHeight = (float) getDrawable().getIntrinsicHeight();
        float[] fArr = this.m;
        float f4 = fArr[2];
        float f5 = fArr[5];
        float imageWidth = ((f2 - f4) * intrinsicWidth) / getImageWidth();
        float imageHeight = ((f3 - f5) * intrinsicHeight) / getImageHeight();
        if (z) {
            imageWidth = Math.min(Math.max(imageWidth, 0.0f), intrinsicWidth);
            imageHeight = Math.min(Math.max(imageHeight, 0.0f), intrinsicHeight);
        }
        return new PointF(imageWidth, imageHeight);
    }

    /* access modifiers changed from: private */
    public PointF transformCoordBitmapToTouch(float f2, float f3) {
        this.matrix.getValues(this.m);
        return new PointF(this.m[2] + (getImageWidth() * (f2 / ((float) getDrawable().getIntrinsicWidth()))), this.m[5] + (getImageHeight() * (f3 / ((float) getDrawable().getIntrinsicHeight()))));
    }

    /* access modifiers changed from: private */
    public void compatPostOnAnimation(Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            postOnAnimation(runnable);
        } else {
            postDelayed(runnable, 16);
        }
    }

    private void printMatrixInfo() {
        float[] fArr = new float[9];
        this.matrix.getValues(fArr);
        StringBuilder sb = new StringBuilder("Scale: ");
        sb.append(fArr[0]);
        sb.append(" TransX: ");
        sb.append(fArr[2]);
        sb.append(" TransY: ");
        sb.append(fArr[5]);
    }

    class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private GestureListener() {
        }

        /* synthetic */ GestureListener(TouchImageViewNew touchImageViewNew, AnonymousClass1 r2) {
            this();
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (TouchImageViewNew.this.doubleTapListener != null) {
                return TouchImageViewNew.this.doubleTapListener.onSingleTapConfirmed(motionEvent);
            }
            return TouchImageViewNew.this.performClick();
        }

        public void onLongPress(MotionEvent motionEvent) {
            TouchImageViewNew.this.performLongClick();
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (TouchImageViewNew.this.fling != null) {
                TouchImageViewNew.this.fling.cancelFling();
            }
            TouchImageViewNew touchImageViewNew = TouchImageViewNew.this;
            Fling unused = touchImageViewNew.fling = new Fling((int) f2, (int) f3);
            TouchImageViewNew touchImageViewNew2 = TouchImageViewNew.this;
            touchImageViewNew2.compatPostOnAnimation(touchImageViewNew2.fling);
            return super.onFling(motionEvent, motionEvent2, f2, f3);
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            boolean onDoubleTap = TouchImageViewNew.this.doubleTapListener != null ? TouchImageViewNew.this.doubleTapListener.onDoubleTap(motionEvent) : false;
            if (TouchImageViewNew.this.state != State.NONE) {
                return onDoubleTap;
            }
            TouchImageViewNew.this.compatPostOnAnimation(new DoubleTapZoom(TouchImageViewNew.this.normalizedScale == TouchImageViewNew.this.minScale ? TouchImageViewNew.this.maxScale : TouchImageViewNew.this.minScale, motionEvent.getX(), motionEvent.getY(), false));
            return true;
        }

        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if (TouchImageViewNew.this.doubleTapListener != null) {
                return TouchImageViewNew.this.doubleTapListener.onDoubleTapEvent(motionEvent);
            }
            return false;
        }
    }

    class TouchImageViewListener implements View.OnTouchListener {
        private PointF last;

        private TouchImageViewListener() {
            this.last = new PointF();
        }

        /* synthetic */ TouchImageViewListener(TouchImageViewNew touchImageViewNew, AnonymousClass1 r2) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x005b, code lost:
            if (r7 != 6) goto L_0x00d6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
            /*
                r5 = this;
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                android.view.View$OnTouchListener r0 = r0.touchListener
                if (r0 == 0) goto L_0x0011
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                android.view.View$OnTouchListener r0 = r0.touchListener
                r0.onTouch(r6, r7)
            L_0x0011:
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r6 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                android.view.ScaleGestureDetector r6 = r6.mScaleDetector
                r6.onTouchEvent(r7)
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r6 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                android.view.GestureDetector r6 = r6.mGestureDetector
                r6.onTouchEvent(r7)
                android.graphics.PointF r6 = new android.graphics.PointF
                float r0 = r7.getX()
                float r1 = r7.getY()
                r6.<init>(r0, r1)
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew$State r0 = r0.state
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew$State r1 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.State.NONE
                r2 = 1
                if (r0 == r1) goto L_0x004f
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew$State r0 = r0.state
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew$State r1 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.State.DRAG
                if (r0 == r1) goto L_0x004f
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew$State r0 = r0.state
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew$State r1 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.State.FLING
                if (r0 != r1) goto L_0x00d6
            L_0x004f:
                int r7 = r7.getAction()
                if (r7 == 0) goto L_0x00b9
                if (r7 == r2) goto L_0x00b1
                r0 = 2
                if (r7 == r0) goto L_0x005f
                r6 = 6
                if (r7 == r6) goto L_0x00b1
                goto L_0x00d6
            L_0x005f:
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r7 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew$State r7 = r7.state
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew$State r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.State.DRAG
                if (r7 != r0) goto L_0x00d6
                float r7 = r6.x
                android.graphics.PointF r0 = r5.last
                float r0 = r0.x
                float r7 = r7 - r0
                float r0 = r6.y
                android.graphics.PointF r1 = r5.last
                float r1 = r1.y
                float r0 = r0 - r1
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r1 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                int r3 = r1.viewWidth
                float r3 = (float) r3
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r4 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                float r4 = r4.getImageWidth()
                float r7 = r1.getFixDragTrans(r7, r3, r4)
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r1 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                int r3 = r1.viewHeight
                float r3 = (float) r3
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r4 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                float r4 = r4.getImageHeight()
                float r0 = r1.getFixDragTrans(r0, r3, r4)
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r1 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                android.graphics.Matrix r1 = r1.matrix
                r1.postTranslate(r7, r0)
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r7 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                r7.fixTrans()
                android.graphics.PointF r7 = r5.last
                float r0 = r6.x
                float r6 = r6.y
                r7.set(r0, r6)
                goto L_0x00d6
            L_0x00b1:
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r6 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew$State r7 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.State.NONE
                r6.setState(r7)
                goto L_0x00d6
            L_0x00b9:
                android.graphics.PointF r7 = r5.last
                r7.set(r6)
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r6 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew$Fling r6 = r6.fling
                if (r6 == 0) goto L_0x00cf
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r6 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew$Fling r6 = r6.fling
                r6.cancelFling()
            L_0x00cf:
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r6 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew$State r7 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.State.DRAG
                r6.setState(r7)
            L_0x00d6:
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r6 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                android.graphics.Matrix r7 = r6.matrix
                r6.setImageMatrix(r7)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.TouchImageViewListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private ScaleListener() {
        }

        /* synthetic */ ScaleListener(TouchImageViewNew touchImageViewNew, AnonymousClass1 r2) {
            this();
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            TouchImageViewNew.this.setState(State.ZOOM);
            return true;
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            TouchImageViewNew.this.scaleImage(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), true);
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0044  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onScaleEnd(android.view.ScaleGestureDetector r9) {
            /*
                r8 = this;
                super.onScaleEnd(r9)
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r9 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew$State r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.State.NONE
                r9.setState(r0)
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r9 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                float unused = r9.normalizedScale
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r9 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                float r9 = r9.normalizedScale
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                float r0 = r0.maxScale
                r1 = 1
                int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r9 <= 0) goto L_0x0028
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r9 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                float r9 = r9.maxScale
            L_0x0026:
                r4 = r9
                goto L_0x0042
            L_0x0028:
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r9 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                float r9 = r9.normalizedScale
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                float r0 = r0.minScale
                int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r9 >= 0) goto L_0x003f
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r9 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                float r9 = r9.minScale
                goto L_0x0026
            L_0x003f:
                r1 = 0
                r9 = 0
                r4 = 0
            L_0x0042:
                if (r1 == 0) goto L_0x0062
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew$DoubleTapZoom r9 = new com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew$DoubleTapZoom
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r3 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                int r0 = r3.viewWidth
                int r0 = r0 / 2
                float r5 = (float) r0
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                int r0 = r0.viewHeight
                int r0 = r0 / 2
                float r6 = (float) r0
                r7 = 1
                r2 = r9
                r2.<init>(r4, r5, r6, r7)
                com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.this
                r0.compatPostOnAnimation(r9)
            L_0x0062:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew.ScaleListener.onScaleEnd(android.view.ScaleGestureDetector):void");
        }
    }

    class DoubleTapZoom implements Runnable {
        private static final float ZOOM_TIME = 500.0f;
        private float bitmapX;
        private float bitmapY;
        private PointF endTouch;
        private AccelerateDecelerateInterpolator interpolator = new AccelerateDecelerateInterpolator();
        private long startTime;
        private PointF startTouch;
        private float startZoom;
        private boolean stretchImageToSuper;
        private float targetZoom;

        DoubleTapZoom(float f2, float f3, float f4, boolean z) {
            TouchImageViewNew.this.setState(State.ANIMATE_ZOOM);
            this.startTime = System.currentTimeMillis();
            this.startZoom = TouchImageViewNew.this.normalizedScale;
            this.targetZoom = f2;
            this.stretchImageToSuper = z;
            PointF access$2200 = TouchImageViewNew.this.transformCoordTouchToBitmap(f3, f4, false);
            this.bitmapX = access$2200.x;
            this.bitmapY = access$2200.y;
            this.startTouch = TouchImageViewNew.this.transformCoordBitmapToTouch(this.bitmapX, this.bitmapY);
            this.endTouch = new PointF((float) (TouchImageViewNew.this.viewWidth / 2), (float) (TouchImageViewNew.this.viewHeight / 2));
        }

        public void run() {
            float interpolate = interpolate();
            TouchImageViewNew.this.scaleImage(calculateDeltaScale(interpolate), this.bitmapX, this.bitmapY, this.stretchImageToSuper);
            translateImageToCenterTouchPosition(interpolate);
            TouchImageViewNew.this.fixScaleTrans();
            TouchImageViewNew touchImageViewNew = TouchImageViewNew.this;
            touchImageViewNew.setImageMatrix(touchImageViewNew.matrix);
            if (interpolate < 1.0f) {
                TouchImageViewNew.this.compatPostOnAnimation(this);
            } else {
                TouchImageViewNew.this.setState(State.NONE);
            }
        }

        private void translateImageToCenterTouchPosition(float f2) {
            float f3 = this.startTouch.x + ((this.endTouch.x - this.startTouch.x) * f2);
            float f4 = this.startTouch.y + (f2 * (this.endTouch.y - this.startTouch.y));
            PointF access$2300 = TouchImageViewNew.this.transformCoordBitmapToTouch(this.bitmapX, this.bitmapY);
            TouchImageViewNew.this.matrix.postTranslate(f3 - access$2300.x, f4 - access$2300.y);
        }

        private float interpolate() {
            return this.interpolator.getInterpolation(Math.min(1.0f, ((float) (System.currentTimeMillis() - this.startTime)) / ZOOM_TIME));
        }

        private float calculateDeltaScale(float f2) {
            float f3 = this.startZoom;
            return (f3 + (f2 * (this.targetZoom - f3))) / TouchImageViewNew.this.normalizedScale;
        }
    }

    class Fling implements Runnable {
        int currX;
        int currY;
        CompatScroller scroller;

        Fling(int i2, int i3) {
            int i4;
            int i5;
            int i6;
            int i7;
            TouchImageViewNew.this.setState(State.FLING);
            this.scroller = new CompatScroller(TouchImageViewNew.this.context);
            TouchImageViewNew.this.matrix.getValues(TouchImageViewNew.this.m);
            int i8 = (int) TouchImageViewNew.this.m[2];
            int i9 = (int) TouchImageViewNew.this.m[5];
            if (TouchImageViewNew.this.getImageWidth() > ((float) TouchImageViewNew.this.viewWidth)) {
                i5 = TouchImageViewNew.this.viewWidth - ((int) TouchImageViewNew.this.getImageWidth());
                i4 = 0;
            } else {
                i5 = i8;
                i4 = i5;
            }
            if (TouchImageViewNew.this.getImageHeight() > ((float) TouchImageViewNew.this.viewHeight)) {
                i7 = TouchImageViewNew.this.viewHeight - ((int) TouchImageViewNew.this.getImageHeight());
                i6 = 0;
            } else {
                i7 = i9;
                i6 = i7;
            }
            this.scroller.fling(i8, i9, i2, i3, i5, i4, i7, i6);
            this.currX = i8;
            this.currY = i9;
        }

        public void cancelFling() {
            if (this.scroller != null) {
                TouchImageViewNew.this.setState(State.NONE);
                this.scroller.forceFinished(true);
            }
        }

        public void run() {
            if (this.scroller.isFinished()) {
                this.scroller = null;
            } else if (this.scroller.computeScrollOffset()) {
                int currX2 = this.scroller.getCurrX();
                int currY2 = this.scroller.getCurrY();
                int i2 = currX2 - this.currX;
                int i3 = currY2 - this.currY;
                this.currX = currX2;
                this.currY = currY2;
                TouchImageViewNew.this.matrix.postTranslate((float) i2, (float) i3);
                TouchImageViewNew.this.fixTrans();
                TouchImageViewNew touchImageViewNew = TouchImageViewNew.this;
                touchImageViewNew.setImageMatrix(touchImageViewNew.matrix);
                TouchImageViewNew.this.compatPostOnAnimation(this);
            }
        }
    }

    class CompatScroller {
        boolean isPreGingerbread = false;
        OverScroller overScroller;
        Scroller scroller;

        public CompatScroller(Context context) {
            this.overScroller = new OverScroller(context);
        }

        public void fling(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            if (this.isPreGingerbread) {
                this.scroller.fling(i2, i3, i4, i5, i6, i7, i8, i9);
            } else {
                this.overScroller.fling(i2, i3, i4, i5, i6, i7, i8, i9);
            }
        }

        public void forceFinished(boolean z) {
            if (this.isPreGingerbread) {
                this.scroller.forceFinished(z);
            } else {
                this.overScroller.forceFinished(z);
            }
        }

        public boolean isFinished() {
            if (this.isPreGingerbread) {
                return this.scroller.isFinished();
            }
            return this.overScroller.isFinished();
        }

        public boolean computeScrollOffset() {
            if (this.isPreGingerbread) {
                return this.scroller.computeScrollOffset();
            }
            return this.overScroller.computeScrollOffset();
        }

        public int getCurrX() {
            if (this.isPreGingerbread) {
                return this.scroller.getCurrX();
            }
            return this.overScroller.getCurrX();
        }

        public int getCurrY() {
            if (this.isPreGingerbread) {
                return this.scroller.getCurrY();
            }
            return this.overScroller.getCurrY();
        }
    }

    class ZoomVariables {
        public float focusX;
        public float focusY;
        public float scale;
        public ImageView.ScaleType scaleType;

        public ZoomVariables(float f2, float f3, float f4, ImageView.ScaleType scaleType2) {
            this.scale = f2;
            this.focusX = f3;
            this.focusY = f4;
            this.scaleType = scaleType2;
        }
    }
}
