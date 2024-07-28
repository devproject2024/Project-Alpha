package com.paytm.android.chat.utils.imagecropper;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.AppCompatImageView;
import com.paytm.android.chat.R;
import com.paytm.android.chat.utils.ImageUtils;
import com.paytm.android.chat.utils.imagecropper.Callbacks;
import com.paytm.android.chat.utils.imagecropper.animation.SimpleValueAnimator;
import com.paytm.android.chat.utils.imagecropper.animation.SimpleValueAnimatorListener;
import com.paytm.android.chat.utils.imagecropper.animation.ValueAnimatorV14;
import com.paytm.android.chat.utils.imagecropper.animation.ValueAnimatorV8;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import io.reactivex.rxjava3.a.b;
import io.reactivex.rxjava3.a.c;
import io.reactivex.rxjava3.a.e;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.d.g;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class CropImageView extends AppCompatImageView {
    private static final int DEBUG_TEXT_SIZE_IN_DP = 15;
    private static final int DEFAULT_ANIMATION_DURATION_MILLIS = 100;
    private static final float DEFAULT_INITIAL_FRAME_SCALE = 1.0f;
    private static final int FRAME_STROKE_WEIGHT_IN_DP = 1;
    private static final int GUIDE_STROKE_WEIGHT_IN_DP = 1;
    private static final int HANDLE_SIZE_IN_DP = 14;
    private static final int MIN_FRAME_SIZE_IN_DP = 50;
    private static final String TAG = CropImageView.class.getSimpleName();
    private static final int TRANSLUCENT_BLACK = -1157627904;
    private static final int TRANSLUCENT_WHITE = -1140850689;
    private static final int TRANSPARENT = 0;
    private static final int WHITE = -1;
    private final Interpolator DEFAULT_INTERPOLATOR;
    /* access modifiers changed from: private */
    public float mAngle;
    private int mAnimationDurationMillis;
    private SimpleValueAnimator mAnimator;
    private int mBackgroundColor;
    private PointF mCenter;
    private Bitmap.CompressFormat mCompressFormat;
    private int mCompressQuality;
    private CropMode mCropMode;
    private PointF mCustomRatio;
    private ExecutorService mExecutor;
    /* access modifiers changed from: private */
    public int mExifRotation;
    private int mFrameColor;
    /* access modifiers changed from: private */
    public RectF mFrameRect;
    private float mFrameStrokeWeight;
    private int mGuideColor;
    private ShowMode mGuideShowMode;
    private float mGuideStrokeWeight;
    private int mHandleColor;
    private ShowMode mHandleShowMode;
    private int mHandleSize;
    /* access modifiers changed from: private */
    public Handler mHandler;
    private RectF mImageRect;
    private float mImgHeight;
    private float mImgWidth;
    /* access modifiers changed from: private */
    public RectF mInitialFrameRect;
    private float mInitialFrameScale;
    private int mInputImageHeight;
    private int mInputImageWidth;
    private Interpolator mInterpolator;
    /* access modifiers changed from: private */
    public boolean mIsAnimating;
    private boolean mIsAnimationEnabled;
    private boolean mIsCropEnabled;
    /* access modifiers changed from: private */
    public AtomicBoolean mIsCropping;
    /* access modifiers changed from: private */
    public boolean mIsDebug;
    private boolean mIsEnabled;
    private boolean mIsHandleShadowEnabled;
    private boolean mIsInitialized;
    /* access modifiers changed from: private */
    public AtomicBoolean mIsLoading;
    /* access modifiers changed from: private */
    public boolean mIsRotating;
    /* access modifiers changed from: private */
    public AtomicBoolean mIsSaving;
    private float mLastX;
    private float mLastY;
    private Matrix mMatrix;
    private float mMinFrameSize;
    private int mOutputHeight;
    private int mOutputImageHeight;
    private int mOutputImageWidth;
    private int mOutputMaxHeight;
    private int mOutputMaxWidth;
    private int mOutputWidth;
    private int mOverlayColor;
    private Paint mPaintBitmap;
    private Paint mPaintDebug;
    private Paint mPaintFrame;
    private Paint mPaintTranslucent;
    private Uri mSaveUri;
    /* access modifiers changed from: private */
    public float mScale;
    private boolean mShowGuide;
    private boolean mShowHandle;
    /* access modifiers changed from: private */
    public Uri mSourceUri;
    private a mTouchArea;
    private int mTouchPadding;
    /* access modifiers changed from: private */
    public int mViewHeight;
    /* access modifiers changed from: private */
    public int mViewWidth;

    enum a {
        OUT_OF_BOUNDS,
        CENTER,
        LEFT_TOP,
        RIGHT_TOP,
        LEFT_BOTTOM,
        RIGHT_BOTTOM
    }

    private float constrain(float f2, float f3, float f4, float f5) {
        return (f2 < f3 || f2 > f4) ? f5 : f2;
    }

    private float getRotatedHeight(float f2, float f3, float f4) {
        return f2 % 180.0f == 0.0f ? f4 : f3;
    }

    private float getRotatedWidth(float f2, float f3, float f4) {
        return f2 % 180.0f == 0.0f ? f3 : f4;
    }

    private float sq(float f2) {
        return f2 * f2;
    }

    public CropImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mScale = 1.0f;
        this.mAngle = 0.0f;
        this.mImgWidth = 0.0f;
        this.mImgHeight = 0.0f;
        this.mIsInitialized = false;
        this.mMatrix = null;
        this.mCenter = new PointF();
        this.mIsRotating = false;
        this.mIsAnimating = false;
        this.mAnimator = null;
        this.DEFAULT_INTERPOLATOR = new DecelerateInterpolator();
        this.mInterpolator = this.DEFAULT_INTERPOLATOR;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mSourceUri = null;
        this.mSaveUri = null;
        this.mExifRotation = 0;
        this.mOutputWidth = 0;
        this.mOutputHeight = 0;
        this.mIsDebug = false;
        this.mCompressFormat = Bitmap.CompressFormat.PNG;
        this.mCompressQuality = 100;
        this.mInputImageWidth = 0;
        this.mInputImageHeight = 0;
        this.mOutputImageWidth = 0;
        this.mOutputImageHeight = 0;
        this.mIsLoading = new AtomicBoolean(false);
        this.mIsCropping = new AtomicBoolean(false);
        this.mIsSaving = new AtomicBoolean(false);
        this.mTouchArea = a.OUT_OF_BOUNDS;
        this.mCropMode = CropMode.SQUARE;
        this.mGuideShowMode = ShowMode.SHOW_ALWAYS;
        this.mHandleShowMode = ShowMode.SHOW_ALWAYS;
        this.mTouchPadding = 0;
        this.mShowGuide = true;
        this.mShowHandle = true;
        this.mIsCropEnabled = true;
        this.mIsEnabled = true;
        this.mCustomRatio = new PointF(1.0f, 1.0f);
        this.mFrameStrokeWeight = 2.0f;
        this.mGuideStrokeWeight = 2.0f;
        this.mIsAnimationEnabled = true;
        this.mAnimationDurationMillis = 100;
        this.mIsHandleShadowEnabled = true;
        this.mExecutor = Executors.newSingleThreadExecutor();
        float density = getDensity();
        this.mHandleSize = (int) (14.0f * density);
        this.mMinFrameSize = 50.0f * density;
        float f2 = density * 1.0f;
        this.mFrameStrokeWeight = f2;
        this.mGuideStrokeWeight = f2;
        this.mPaintFrame = new Paint();
        this.mPaintTranslucent = new Paint();
        this.mPaintBitmap = new Paint();
        this.mPaintBitmap.setFilterBitmap(true);
        this.mPaintDebug = new Paint();
        this.mPaintDebug.setAntiAlias(true);
        this.mPaintDebug.setStyle(Paint.Style.STROKE);
        this.mPaintDebug.setColor(-1);
        this.mPaintDebug.setTextSize(15.0f * density);
        this.mMatrix = new Matrix();
        this.mScale = 1.0f;
        this.mBackgroundColor = 0;
        this.mFrameColor = -1;
        this.mOverlayColor = TRANSLUCENT_BLACK;
        this.mHandleColor = -1;
        this.mGuideColor = TRANSLUCENT_WHITE;
        handleStyleable(context, attributeSet, i2, density);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mode = this.mCropMode;
        savedState.backgroundColor = this.mBackgroundColor;
        savedState.overlayColor = this.mOverlayColor;
        savedState.frameColor = this.mFrameColor;
        savedState.guideShowMode = this.mGuideShowMode;
        savedState.handleShowMode = this.mHandleShowMode;
        savedState.showGuide = this.mShowGuide;
        savedState.showHandle = this.mShowHandle;
        savedState.handleSize = this.mHandleSize;
        savedState.touchPadding = this.mTouchPadding;
        savedState.minFrameSize = this.mMinFrameSize;
        savedState.customRatioX = this.mCustomRatio.x;
        savedState.customRatioY = this.mCustomRatio.y;
        savedState.frameStrokeWeight = this.mFrameStrokeWeight;
        savedState.guideStrokeWeight = this.mGuideStrokeWeight;
        savedState.isCropEnabled = this.mIsCropEnabled;
        savedState.handleColor = this.mHandleColor;
        savedState.guideColor = this.mGuideColor;
        savedState.initialFrameScale = this.mInitialFrameScale;
        savedState.angle = this.mAngle;
        savedState.isAnimationEnabled = this.mIsAnimationEnabled;
        savedState.animationDuration = this.mAnimationDurationMillis;
        savedState.exifRotation = this.mExifRotation;
        savedState.sourceUri = this.mSourceUri;
        savedState.saveUri = this.mSaveUri;
        savedState.compressFormat = this.mCompressFormat;
        savedState.compressQuality = this.mCompressQuality;
        savedState.isDebug = this.mIsDebug;
        savedState.outputMaxWidth = this.mOutputMaxWidth;
        savedState.outputMaxHeight = this.mOutputMaxHeight;
        savedState.outputWidth = this.mOutputWidth;
        savedState.outputHeight = this.mOutputHeight;
        savedState.isHandleShadowEnabled = this.mIsHandleShadowEnabled;
        savedState.inputImageWidth = this.mInputImageWidth;
        savedState.inputImageHeight = this.mInputImageHeight;
        savedState.outputImageWidth = this.mOutputImageWidth;
        savedState.outputImageHeight = this.mOutputImageHeight;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCropMode = savedState.mode;
        this.mBackgroundColor = savedState.backgroundColor;
        this.mOverlayColor = savedState.overlayColor;
        this.mFrameColor = savedState.frameColor;
        this.mGuideShowMode = savedState.guideShowMode;
        this.mHandleShowMode = savedState.handleShowMode;
        this.mShowGuide = savedState.showGuide;
        this.mShowHandle = savedState.showHandle;
        this.mHandleSize = savedState.handleSize;
        this.mTouchPadding = savedState.touchPadding;
        this.mMinFrameSize = savedState.minFrameSize;
        this.mCustomRatio = new PointF(savedState.customRatioX, savedState.customRatioY);
        this.mFrameStrokeWeight = savedState.frameStrokeWeight;
        this.mGuideStrokeWeight = savedState.guideStrokeWeight;
        this.mIsCropEnabled = savedState.isCropEnabled;
        this.mHandleColor = savedState.handleColor;
        this.mGuideColor = savedState.guideColor;
        this.mInitialFrameScale = savedState.initialFrameScale;
        this.mAngle = savedState.angle;
        this.mIsAnimationEnabled = savedState.isAnimationEnabled;
        this.mAnimationDurationMillis = savedState.animationDuration;
        this.mExifRotation = savedState.exifRotation;
        this.mSourceUri = savedState.sourceUri;
        this.mSaveUri = savedState.saveUri;
        this.mCompressFormat = savedState.compressFormat;
        this.mCompressQuality = savedState.compressQuality;
        this.mIsDebug = savedState.isDebug;
        this.mOutputMaxWidth = savedState.outputMaxWidth;
        this.mOutputMaxHeight = savedState.outputMaxHeight;
        this.mOutputWidth = savedState.outputWidth;
        this.mOutputHeight = savedState.outputHeight;
        this.mIsHandleShadowEnabled = savedState.isHandleShadowEnabled;
        this.mInputImageWidth = savedState.inputImageWidth;
        this.mInputImageHeight = savedState.inputImageHeight;
        this.mOutputImageWidth = savedState.outputImageWidth;
        this.mOutputImageHeight = savedState.outputImageHeight;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        setMeasuredDimension(size, size2);
        this.mViewWidth = (size - getPaddingLeft()) - getPaddingRight();
        this.mViewHeight = (size2 - getPaddingTop()) - getPaddingBottom();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (getDrawable() != null) {
            setupLayout(this.mViewWidth, this.mViewHeight);
        }
    }

    public void onDraw(Canvas canvas) {
        canvas.drawColor(this.mBackgroundColor);
        if (this.mIsInitialized) {
            setMatrix();
            Bitmap bitmap = getBitmap();
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, this.mMatrix, this.mPaintBitmap);
                drawCropFrame(canvas);
            }
            if (this.mIsDebug) {
                drawDebugInfo(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.mExecutor.shutdown();
        super.onDetachedFromWindow();
    }

    private void handleStyleable(Context context, AttributeSet attributeSet, int i2, float f2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.scv_CropImageView, i2, 0);
        this.mCropMode = CropMode.SQUARE;
        try {
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.scv_CropImageView_scv_img_src);
            if (drawable != null) {
                setImageDrawable(drawable);
            }
            CropMode[] values = CropMode.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                CropMode cropMode = values[i3];
                if (obtainStyledAttributes.getInt(R.styleable.scv_CropImageView_scv_crop_mode, 3) == cropMode.getId()) {
                    this.mCropMode = cropMode;
                    break;
                }
                i3++;
            }
            this.mBackgroundColor = obtainStyledAttributes.getColor(R.styleable.scv_CropImageView_scv_background_color, 0);
            this.mOverlayColor = obtainStyledAttributes.getColor(R.styleable.scv_CropImageView_scv_overlay_color, TRANSLUCENT_BLACK);
            this.mFrameColor = obtainStyledAttributes.getColor(R.styleable.scv_CropImageView_scv_frame_color, -1);
            this.mHandleColor = obtainStyledAttributes.getColor(R.styleable.scv_CropImageView_scv_handle_color, -1);
            this.mGuideColor = obtainStyledAttributes.getColor(R.styleable.scv_CropImageView_scv_guide_color, TRANSLUCENT_WHITE);
            ShowMode[] values2 = ShowMode.values();
            int length2 = values2.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length2) {
                    break;
                }
                ShowMode showMode = values2[i4];
                if (obtainStyledAttributes.getInt(R.styleable.scv_CropImageView_scv_guide_show_mode, 1) == showMode.getId()) {
                    this.mGuideShowMode = showMode;
                    break;
                }
                i4++;
            }
            ShowMode[] values3 = ShowMode.values();
            int length3 = values3.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length3) {
                    break;
                }
                ShowMode showMode2 = values3[i5];
                if (obtainStyledAttributes.getInt(R.styleable.scv_CropImageView_scv_handle_show_mode, 1) == showMode2.getId()) {
                    this.mHandleShowMode = showMode2;
                    break;
                }
                i5++;
            }
            setGuideShowMode(this.mGuideShowMode);
            setHandleShowMode(this.mHandleShowMode);
            this.mHandleSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.scv_CropImageView_scv_handle_size, (int) (14.0f * f2));
            this.mTouchPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.scv_CropImageView_scv_touch_padding, 0);
            this.mMinFrameSize = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.scv_CropImageView_scv_min_frame_size, (int) (50.0f * f2));
            int i6 = (int) (f2 * 1.0f);
            this.mFrameStrokeWeight = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.scv_CropImageView_scv_frame_stroke_weight, i6);
            this.mGuideStrokeWeight = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.scv_CropImageView_scv_guide_stroke_weight, i6);
            this.mIsCropEnabled = obtainStyledAttributes.getBoolean(R.styleable.scv_CropImageView_scv_crop_enabled, true);
            this.mInitialFrameScale = constrain(obtainStyledAttributes.getFloat(R.styleable.scv_CropImageView_scv_initial_frame_scale, 1.0f), 0.01f, 1.0f, 1.0f);
            this.mIsAnimationEnabled = obtainStyledAttributes.getBoolean(R.styleable.scv_CropImageView_scv_animation_enabled, true);
            this.mAnimationDurationMillis = obtainStyledAttributes.getInt(R.styleable.scv_CropImageView_scv_animation_duration, 100);
            this.mIsHandleShadowEnabled = obtainStyledAttributes.getBoolean(R.styleable.scv_CropImageView_scv_handle_shadow_enabled, true);
        } catch (Exception unused) {
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void drawDebugInfo(Canvas canvas) {
        StringBuilder sb;
        int i2;
        Paint.FontMetrics fontMetrics = this.mPaintDebug.getFontMetrics();
        this.mPaintDebug.measureText(AppConstants.CAROUSEL_SUB_TYPE);
        int i3 = (int) (fontMetrics.descent - fontMetrics.ascent);
        int density = (int) (this.mImageRect.left + (((float) this.mHandleSize) * 0.5f * getDensity()));
        int density2 = (int) (this.mImageRect.top + ((float) i3) + (((float) this.mHandleSize) * 0.5f * getDensity()));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("LOADED FROM: ");
        sb2.append(this.mSourceUri != null ? "Uri" : "Bitmap");
        float f2 = (float) density;
        canvas.drawText(sb2.toString(), f2, (float) density2, this.mPaintDebug);
        StringBuilder sb3 = new StringBuilder();
        if (this.mSourceUri == null) {
            sb3.append("INPUT_IMAGE_SIZE: ");
            sb3.append((int) this.mImgWidth);
            sb3.append("x");
            sb3.append((int) this.mImgHeight);
            i2 = density2 + i3;
            canvas.drawText(sb3.toString(), f2, (float) i2, this.mPaintDebug);
            sb = new StringBuilder();
        } else {
            i2 = density2 + i3;
            canvas.drawText("INPUT_IMAGE_SIZE: " + this.mInputImageWidth + "x" + this.mInputImageHeight, f2, (float) i2, this.mPaintDebug);
            sb = new StringBuilder();
        }
        sb.append("LOADED_IMAGE_SIZE: ");
        sb.append(getBitmap().getWidth());
        sb.append("x");
        sb.append(getBitmap().getHeight());
        int i4 = i2 + i3;
        canvas.drawText(sb.toString(), f2, (float) i4, this.mPaintDebug);
        StringBuilder sb4 = new StringBuilder();
        if (this.mOutputImageWidth > 0 && this.mOutputImageHeight > 0) {
            sb4.append("OUTPUT_IMAGE_SIZE: ");
            sb4.append(this.mOutputImageWidth);
            sb4.append("x");
            sb4.append(this.mOutputImageHeight);
            int i5 = i4 + i3;
            canvas.drawText(sb4.toString(), f2, (float) i5, this.mPaintDebug);
            int i6 = i5 + i3;
            canvas.drawText("EXIF ROTATION: " + this.mExifRotation, f2, (float) i6, this.mPaintDebug);
            i4 = i6 + i3;
            canvas.drawText("CURRENT_ROTATION: " + ((int) this.mAngle), f2, (float) i4, this.mPaintDebug);
        }
        int i7 = i4 + i3;
        canvas.drawText("FRAME_RECT: " + this.mFrameRect.toString(), f2, (float) i7, this.mPaintDebug);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ACTUAL_CROP_RECT: ");
        sb5.append(getActualCropRect() != null ? getActualCropRect().toString() : "");
        canvas.drawText(sb5.toString(), f2, (float) (i7 + i3), this.mPaintDebug);
    }

    private void drawCropFrame(Canvas canvas) {
        if (this.mIsCropEnabled && !this.mIsRotating) {
            drawOverlay(canvas);
            drawFrame(canvas);
            if (this.mShowGuide) {
                drawGuidelines(canvas);
            }
            if (this.mShowHandle) {
                drawHandles(canvas);
            }
        }
    }

    private void drawOverlay(Canvas canvas) {
        this.mPaintTranslucent.setAntiAlias(true);
        this.mPaintTranslucent.setFilterBitmap(true);
        this.mPaintTranslucent.setColor(this.mOverlayColor);
        this.mPaintTranslucent.setStyle(Paint.Style.FILL);
        Path path = new Path();
        RectF rectF = new RectF((float) Math.floor((double) this.mImageRect.left), (float) Math.floor((double) this.mImageRect.top), (float) Math.ceil((double) this.mImageRect.right), (float) Math.ceil((double) this.mImageRect.bottom));
        if (this.mIsAnimating || !(this.mCropMode == CropMode.CIRCLE || this.mCropMode == CropMode.CIRCLE_SQUARE)) {
            path.addRect(rectF, Path.Direction.CW);
            path.addRect(this.mFrameRect, Path.Direction.CCW);
            canvas.drawPath(path, this.mPaintTranslucent);
            return;
        }
        path.addRect(rectF, Path.Direction.CW);
        PointF pointF = new PointF((this.mFrameRect.left + this.mFrameRect.right) / 2.0f, (this.mFrameRect.top + this.mFrameRect.bottom) / 2.0f);
        path.addCircle(pointF.x, pointF.y, (this.mFrameRect.right - this.mFrameRect.left) / 2.0f, Path.Direction.CCW);
        canvas.drawPath(path, this.mPaintTranslucent);
    }

    private void drawFrame(Canvas canvas) {
        this.mPaintFrame.setAntiAlias(true);
        this.mPaintFrame.setFilterBitmap(true);
        this.mPaintFrame.setStyle(Paint.Style.STROKE);
        this.mPaintFrame.setColor(this.mFrameColor);
        this.mPaintFrame.setStrokeWidth(this.mFrameStrokeWeight);
        canvas.drawRect(this.mFrameRect, this.mPaintFrame);
    }

    private void drawGuidelines(Canvas canvas) {
        this.mPaintFrame.setColor(this.mGuideColor);
        this.mPaintFrame.setStrokeWidth(this.mGuideStrokeWeight);
        float f2 = this.mFrameRect.left + ((this.mFrameRect.right - this.mFrameRect.left) / 3.0f);
        float f3 = this.mFrameRect.right - ((this.mFrameRect.right - this.mFrameRect.left) / 3.0f);
        float f4 = this.mFrameRect.top + ((this.mFrameRect.bottom - this.mFrameRect.top) / 3.0f);
        float f5 = this.mFrameRect.bottom - ((this.mFrameRect.bottom - this.mFrameRect.top) / 3.0f);
        canvas.drawLine(f2, this.mFrameRect.top, f2, this.mFrameRect.bottom, this.mPaintFrame);
        canvas.drawLine(f3, this.mFrameRect.top, f3, this.mFrameRect.bottom, this.mPaintFrame);
        canvas.drawLine(this.mFrameRect.left, f4, this.mFrameRect.right, f4, this.mPaintFrame);
        canvas.drawLine(this.mFrameRect.left, f5, this.mFrameRect.right, f5, this.mPaintFrame);
    }

    private void drawHandles(Canvas canvas) {
        if (this.mIsHandleShadowEnabled) {
            drawHandleShadows(canvas);
        }
        this.mPaintFrame.setStyle(Paint.Style.FILL);
        this.mPaintFrame.setColor(this.mHandleColor);
        canvas.drawCircle(this.mFrameRect.left, this.mFrameRect.top, (float) this.mHandleSize, this.mPaintFrame);
        canvas.drawCircle(this.mFrameRect.right, this.mFrameRect.top, (float) this.mHandleSize, this.mPaintFrame);
        canvas.drawCircle(this.mFrameRect.left, this.mFrameRect.bottom, (float) this.mHandleSize, this.mPaintFrame);
        canvas.drawCircle(this.mFrameRect.right, this.mFrameRect.bottom, (float) this.mHandleSize, this.mPaintFrame);
    }

    private void drawHandleShadows(Canvas canvas) {
        this.mPaintFrame.setStyle(Paint.Style.FILL);
        this.mPaintFrame.setColor(TRANSLUCENT_BLACK);
        RectF rectF = new RectF(this.mFrameRect);
        rectF.offset(0.0f, 1.0f);
        canvas.drawCircle(rectF.left, rectF.top, (float) this.mHandleSize, this.mPaintFrame);
        canvas.drawCircle(rectF.right, rectF.top, (float) this.mHandleSize, this.mPaintFrame);
        canvas.drawCircle(rectF.left, rectF.bottom, (float) this.mHandleSize, this.mPaintFrame);
        canvas.drawCircle(rectF.right, rectF.bottom, (float) this.mHandleSize, this.mPaintFrame);
    }

    /* access modifiers changed from: private */
    public void setMatrix() {
        this.mMatrix.reset();
        this.mMatrix.setTranslate(this.mCenter.x - (this.mImgWidth * 0.5f), this.mCenter.y - (this.mImgHeight * 0.5f));
        Matrix matrix = this.mMatrix;
        float f2 = this.mScale;
        matrix.postScale(f2, f2, this.mCenter.x, this.mCenter.y);
        this.mMatrix.postRotate(this.mAngle, this.mCenter.x, this.mCenter.y);
    }

    /* access modifiers changed from: private */
    public void setupLayout(int i2, int i3) {
        if (i2 != 0 && i3 != 0) {
            setCenter(new PointF(((float) getPaddingLeft()) + (((float) i2) * 0.5f), ((float) getPaddingTop()) + (((float) i3) * 0.5f)));
            setScale(calcScale(i2, i3, this.mAngle));
            setMatrix();
            this.mImageRect = calcImageRect(new RectF(0.0f, 0.0f, this.mImgWidth, this.mImgHeight), this.mMatrix);
            RectF rectF = this.mInitialFrameRect;
            if (rectF != null) {
                this.mFrameRect = applyInitialFrameRect(rectF);
            } else {
                this.mFrameRect = calcFrameRect(this.mImageRect);
            }
            this.mIsInitialized = true;
            invalidate();
        }
    }

    private float calcScale(int i2, int i3, float f2) {
        this.mImgWidth = (float) getDrawable().getIntrinsicWidth();
        this.mImgHeight = (float) getDrawable().getIntrinsicHeight();
        if (this.mImgWidth <= 0.0f) {
            this.mImgWidth = (float) i2;
        }
        if (this.mImgHeight <= 0.0f) {
            this.mImgHeight = (float) i3;
        }
        float f3 = (float) i2;
        float f4 = (float) i3;
        float f5 = f3 / f4;
        float rotatedWidth = getRotatedWidth(f2) / getRotatedHeight(f2);
        if (rotatedWidth >= f5) {
            return f3 / getRotatedWidth(f2);
        }
        if (rotatedWidth < f5) {
            return f4 / getRotatedHeight(f2);
        }
        return 1.0f;
    }

    private RectF calcImageRect(RectF rectF, Matrix matrix) {
        RectF rectF2 = new RectF();
        matrix.mapRect(rectF2, rectF);
        return rectF2;
    }

    private RectF calcFrameRect(RectF rectF) {
        float ratioX = getRatioX(rectF.width());
        float ratioY = getRatioY(rectF.height());
        float width = rectF.width() / rectF.height();
        float f2 = ratioX / ratioY;
        float f3 = rectF.left;
        float f4 = rectF.top;
        float f5 = rectF.right;
        float f6 = rectF.bottom;
        if (f2 >= width) {
            f3 = rectF.left;
            f5 = rectF.right;
            float f7 = (rectF.top + rectF.bottom) * 0.5f;
            float width2 = (rectF.width() / f2) * 0.5f;
            f4 = f7 - width2;
            f6 = f7 + width2;
        } else if (f2 < width) {
            f4 = rectF.top;
            f6 = rectF.bottom;
            float f8 = (rectF.left + rectF.right) * 0.5f;
            float height = rectF.height() * f2 * 0.5f;
            f5 = f8 + height;
            f3 = f8 - height;
        }
        float f9 = f5 - f3;
        float f10 = f6 - f4;
        float f11 = f3 + (f9 / 2.0f);
        float f12 = f4 + (f10 / 2.0f);
        float f13 = this.mInitialFrameScale;
        float f14 = (f9 * f13) / 2.0f;
        float f15 = (f10 * f13) / 2.0f;
        return new RectF(f11 - f14, f12 - f15, f11 + f14, f12 + f15);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mIsInitialized || !this.mIsCropEnabled || !this.mIsEnabled || this.mIsRotating || this.mIsAnimating || this.mIsLoading.get() || this.mIsCropping.get()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            onDown(motionEvent);
            return true;
        } else if (action == 1) {
            getParent().requestDisallowInterceptTouchEvent(false);
            onUp(motionEvent);
            return true;
        } else if (action == 2) {
            onMove(motionEvent);
            if (this.mTouchArea != a.OUT_OF_BOUNDS) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return true;
        } else if (action != 3) {
            return false;
        } else {
            getParent().requestDisallowInterceptTouchEvent(false);
            onCancel();
            return true;
        }
    }

    private void onDown(MotionEvent motionEvent) {
        invalidate();
        this.mLastX = motionEvent.getX();
        this.mLastY = motionEvent.getY();
        checkTouchArea(motionEvent.getX(), motionEvent.getY());
    }

    private void onMove(MotionEvent motionEvent) {
        float x = motionEvent.getX() - this.mLastX;
        float y = motionEvent.getY() - this.mLastY;
        int i2 = AnonymousClass10.f42373a[this.mTouchArea.ordinal()];
        if (i2 == 1) {
            moveFrame(x, y);
        } else if (i2 == 2) {
            moveHandleLT(x, y);
        } else if (i2 == 3) {
            moveHandleRT(x, y);
        } else if (i2 == 4) {
            moveHandleLB(x, y);
        } else if (i2 == 5) {
            moveHandleRB(x, y);
        }
        invalidate();
        this.mLastX = motionEvent.getX();
        this.mLastY = motionEvent.getY();
    }

    private void onUp(MotionEvent motionEvent) {
        if (this.mGuideShowMode == ShowMode.SHOW_ON_TOUCH) {
            this.mShowGuide = false;
        }
        if (this.mHandleShowMode == ShowMode.SHOW_ON_TOUCH) {
            this.mShowHandle = false;
        }
        this.mTouchArea = a.OUT_OF_BOUNDS;
        invalidate();
    }

    private void onCancel() {
        this.mTouchArea = a.OUT_OF_BOUNDS;
        invalidate();
    }

    private void checkTouchArea(float f2, float f3) {
        if (isInsideCornerLeftTop(f2, f3)) {
            this.mTouchArea = a.LEFT_TOP;
            if (this.mHandleShowMode == ShowMode.SHOW_ON_TOUCH) {
                this.mShowHandle = true;
            }
            if (this.mGuideShowMode == ShowMode.SHOW_ON_TOUCH) {
                this.mShowGuide = true;
            }
        } else if (isInsideCornerRightTop(f2, f3)) {
            this.mTouchArea = a.RIGHT_TOP;
            if (this.mHandleShowMode == ShowMode.SHOW_ON_TOUCH) {
                this.mShowHandle = true;
            }
            if (this.mGuideShowMode == ShowMode.SHOW_ON_TOUCH) {
                this.mShowGuide = true;
            }
        } else if (isInsideCornerLeftBottom(f2, f3)) {
            this.mTouchArea = a.LEFT_BOTTOM;
            if (this.mHandleShowMode == ShowMode.SHOW_ON_TOUCH) {
                this.mShowHandle = true;
            }
            if (this.mGuideShowMode == ShowMode.SHOW_ON_TOUCH) {
                this.mShowGuide = true;
            }
        } else if (isInsideCornerRightBottom(f2, f3)) {
            this.mTouchArea = a.RIGHT_BOTTOM;
            if (this.mHandleShowMode == ShowMode.SHOW_ON_TOUCH) {
                this.mShowHandle = true;
            }
            if (this.mGuideShowMode == ShowMode.SHOW_ON_TOUCH) {
                this.mShowGuide = true;
            }
        } else if (isInsideFrame(f2, f3)) {
            if (this.mGuideShowMode == ShowMode.SHOW_ON_TOUCH) {
                this.mShowGuide = true;
            }
            this.mTouchArea = a.CENTER;
        } else {
            this.mTouchArea = a.OUT_OF_BOUNDS;
        }
    }

    private boolean isInsideFrame(float f2, float f3) {
        if (this.mFrameRect.left > f2 || this.mFrameRect.right < f2 || this.mFrameRect.top > f3 || this.mFrameRect.bottom < f3) {
            return false;
        }
        this.mTouchArea = a.CENTER;
        return true;
    }

    private boolean isInsideCornerLeftTop(float f2, float f3) {
        float f4 = f2 - this.mFrameRect.left;
        float f5 = f3 - this.mFrameRect.top;
        return sq((float) (this.mHandleSize + this.mTouchPadding)) >= (f4 * f4) + (f5 * f5);
    }

    private boolean isInsideCornerRightTop(float f2, float f3) {
        float f4 = f2 - this.mFrameRect.right;
        float f5 = f3 - this.mFrameRect.top;
        return sq((float) (this.mHandleSize + this.mTouchPadding)) >= (f4 * f4) + (f5 * f5);
    }

    private boolean isInsideCornerLeftBottom(float f2, float f3) {
        float f4 = f2 - this.mFrameRect.left;
        float f5 = f3 - this.mFrameRect.bottom;
        return sq((float) (this.mHandleSize + this.mTouchPadding)) >= (f4 * f4) + (f5 * f5);
    }

    private boolean isInsideCornerRightBottom(float f2, float f3) {
        float f4 = f2 - this.mFrameRect.right;
        float f5 = f3 - this.mFrameRect.bottom;
        return sq((float) (this.mHandleSize + this.mTouchPadding)) >= (f4 * f4) + (f5 * f5);
    }

    private void moveFrame(float f2, float f3) {
        this.mFrameRect.left += f2;
        this.mFrameRect.right += f2;
        this.mFrameRect.top += f3;
        this.mFrameRect.bottom += f3;
        checkMoveBounds();
    }

    private void moveHandleLT(float f2, float f3) {
        if (this.mCropMode == CropMode.FREE) {
            this.mFrameRect.left += f2;
            this.mFrameRect.top += f3;
            if (isWidthTooSmall()) {
                this.mFrameRect.left -= this.mMinFrameSize - getFrameW();
            }
            if (isHeightTooSmall()) {
                this.mFrameRect.top -= this.mMinFrameSize - getFrameH();
            }
            checkScaleBounds();
            return;
        }
        float ratioY = (getRatioY() * f2) / getRatioX();
        this.mFrameRect.left += f2;
        this.mFrameRect.top += ratioY;
        if (isWidthTooSmall()) {
            float frameW = this.mMinFrameSize - getFrameW();
            this.mFrameRect.left -= frameW;
            this.mFrameRect.top -= (frameW * getRatioY()) / getRatioX();
        }
        if (isHeightTooSmall()) {
            float frameH = this.mMinFrameSize - getFrameH();
            this.mFrameRect.top -= frameH;
            this.mFrameRect.left -= (frameH * getRatioX()) / getRatioY();
        }
        if (!isInsideHorizontal(this.mFrameRect.left)) {
            float f4 = this.mImageRect.left - this.mFrameRect.left;
            this.mFrameRect.left += f4;
            this.mFrameRect.top += (f4 * getRatioY()) / getRatioX();
        }
        if (!isInsideVertical(this.mFrameRect.top)) {
            float f5 = this.mImageRect.top - this.mFrameRect.top;
            this.mFrameRect.top += f5;
            this.mFrameRect.left += (f5 * getRatioX()) / getRatioY();
        }
    }

    private void moveHandleRT(float f2, float f3) {
        if (this.mCropMode == CropMode.FREE) {
            this.mFrameRect.right += f2;
            this.mFrameRect.top += f3;
            if (isWidthTooSmall()) {
                this.mFrameRect.right += this.mMinFrameSize - getFrameW();
            }
            if (isHeightTooSmall()) {
                this.mFrameRect.top -= this.mMinFrameSize - getFrameH();
            }
            checkScaleBounds();
            return;
        }
        float ratioY = (getRatioY() * f2) / getRatioX();
        this.mFrameRect.right += f2;
        this.mFrameRect.top -= ratioY;
        if (isWidthTooSmall()) {
            float frameW = this.mMinFrameSize - getFrameW();
            this.mFrameRect.right += frameW;
            this.mFrameRect.top -= (frameW * getRatioY()) / getRatioX();
        }
        if (isHeightTooSmall()) {
            float frameH = this.mMinFrameSize - getFrameH();
            this.mFrameRect.top -= frameH;
            this.mFrameRect.right += (frameH * getRatioX()) / getRatioY();
        }
        if (!isInsideHorizontal(this.mFrameRect.right)) {
            float f4 = this.mFrameRect.right - this.mImageRect.right;
            this.mFrameRect.right -= f4;
            this.mFrameRect.top += (f4 * getRatioY()) / getRatioX();
        }
        if (!isInsideVertical(this.mFrameRect.top)) {
            float f5 = this.mImageRect.top - this.mFrameRect.top;
            this.mFrameRect.top += f5;
            this.mFrameRect.right -= (f5 * getRatioX()) / getRatioY();
        }
    }

    private void moveHandleLB(float f2, float f3) {
        if (this.mCropMode == CropMode.FREE) {
            this.mFrameRect.left += f2;
            this.mFrameRect.bottom += f3;
            if (isWidthTooSmall()) {
                this.mFrameRect.left -= this.mMinFrameSize - getFrameW();
            }
            if (isHeightTooSmall()) {
                this.mFrameRect.bottom += this.mMinFrameSize - getFrameH();
            }
            checkScaleBounds();
            return;
        }
        float ratioY = (getRatioY() * f2) / getRatioX();
        this.mFrameRect.left += f2;
        this.mFrameRect.bottom -= ratioY;
        if (isWidthTooSmall()) {
            float frameW = this.mMinFrameSize - getFrameW();
            this.mFrameRect.left -= frameW;
            this.mFrameRect.bottom += (frameW * getRatioY()) / getRatioX();
        }
        if (isHeightTooSmall()) {
            float frameH = this.mMinFrameSize - getFrameH();
            this.mFrameRect.bottom += frameH;
            this.mFrameRect.left -= (frameH * getRatioX()) / getRatioY();
        }
        if (!isInsideHorizontal(this.mFrameRect.left)) {
            float f4 = this.mImageRect.left - this.mFrameRect.left;
            this.mFrameRect.left += f4;
            this.mFrameRect.bottom -= (f4 * getRatioY()) / getRatioX();
        }
        if (!isInsideVertical(this.mFrameRect.bottom)) {
            float f5 = this.mFrameRect.bottom - this.mImageRect.bottom;
            this.mFrameRect.bottom -= f5;
            this.mFrameRect.left += (f5 * getRatioX()) / getRatioY();
        }
    }

    private void moveHandleRB(float f2, float f3) {
        if (this.mCropMode == CropMode.FREE) {
            this.mFrameRect.right += f2;
            this.mFrameRect.bottom += f3;
            if (isWidthTooSmall()) {
                this.mFrameRect.right += this.mMinFrameSize - getFrameW();
            }
            if (isHeightTooSmall()) {
                this.mFrameRect.bottom += this.mMinFrameSize - getFrameH();
            }
            checkScaleBounds();
            return;
        }
        float ratioY = (getRatioY() * f2) / getRatioX();
        this.mFrameRect.right += f2;
        this.mFrameRect.bottom += ratioY;
        if (isWidthTooSmall()) {
            float frameW = this.mMinFrameSize - getFrameW();
            this.mFrameRect.right += frameW;
            this.mFrameRect.bottom += (frameW * getRatioY()) / getRatioX();
        }
        if (isHeightTooSmall()) {
            float frameH = this.mMinFrameSize - getFrameH();
            this.mFrameRect.bottom += frameH;
            this.mFrameRect.right += (frameH * getRatioX()) / getRatioY();
        }
        if (!isInsideHorizontal(this.mFrameRect.right)) {
            float f4 = this.mFrameRect.right - this.mImageRect.right;
            this.mFrameRect.right -= f4;
            this.mFrameRect.bottom -= (f4 * getRatioY()) / getRatioX();
        }
        if (!isInsideVertical(this.mFrameRect.bottom)) {
            float f5 = this.mFrameRect.bottom - this.mImageRect.bottom;
            this.mFrameRect.bottom -= f5;
            this.mFrameRect.right -= (f5 * getRatioX()) / getRatioY();
        }
    }

    private void checkScaleBounds() {
        float f2 = this.mFrameRect.left - this.mImageRect.left;
        float f3 = this.mFrameRect.right - this.mImageRect.right;
        float f4 = this.mFrameRect.top - this.mImageRect.top;
        float f5 = this.mFrameRect.bottom - this.mImageRect.bottom;
        if (f2 < 0.0f) {
            this.mFrameRect.left -= f2;
        }
        if (f3 > 0.0f) {
            this.mFrameRect.right -= f3;
        }
        if (f4 < 0.0f) {
            this.mFrameRect.top -= f4;
        }
        if (f5 > 0.0f) {
            this.mFrameRect.bottom -= f5;
        }
    }

    private void checkMoveBounds() {
        float f2 = this.mFrameRect.left - this.mImageRect.left;
        if (f2 < 0.0f) {
            this.mFrameRect.left -= f2;
            this.mFrameRect.right -= f2;
        }
        float f3 = this.mFrameRect.right - this.mImageRect.right;
        if (f3 > 0.0f) {
            this.mFrameRect.left -= f3;
            this.mFrameRect.right -= f3;
        }
        float f4 = this.mFrameRect.top - this.mImageRect.top;
        if (f4 < 0.0f) {
            this.mFrameRect.top -= f4;
            this.mFrameRect.bottom -= f4;
        }
        float f5 = this.mFrameRect.bottom - this.mImageRect.bottom;
        if (f5 > 0.0f) {
            this.mFrameRect.top -= f5;
            this.mFrameRect.bottom -= f5;
        }
    }

    private boolean isInsideHorizontal(float f2) {
        return this.mImageRect.left <= f2 && this.mImageRect.right >= f2;
    }

    private boolean isInsideVertical(float f2) {
        return this.mImageRect.top <= f2 && this.mImageRect.bottom >= f2;
    }

    private boolean isWidthTooSmall() {
        return getFrameW() < this.mMinFrameSize;
    }

    private boolean isHeightTooSmall() {
        return getFrameH() < this.mMinFrameSize;
    }

    private void recalculateFrameRect(int i2) {
        if (this.mImageRect != null) {
            if (this.mIsAnimating) {
                getAnimator().cancelAnimation();
            }
            final RectF rectF = new RectF(this.mFrameRect);
            final RectF calcFrameRect = calcFrameRect(this.mImageRect);
            final float f2 = calcFrameRect.left - rectF.left;
            final float f3 = calcFrameRect.top - rectF.top;
            final float f4 = calcFrameRect.right - rectF.right;
            final float f5 = calcFrameRect.bottom - rectF.bottom;
            if (this.mIsAnimationEnabled) {
                SimpleValueAnimator animator = getAnimator();
                animator.addAnimatorListener(new SimpleValueAnimatorListener() {
                    public final void onAnimationStarted() {
                        boolean unused = CropImageView.this.mIsAnimating = true;
                    }

                    public final void onAnimationUpdated(float f2) {
                        RectF unused = CropImageView.this.mFrameRect = new RectF(rectF.left + (f2 * f2), rectF.top + (f3 * f2), rectF.right + (f4 * f2), rectF.bottom + (f5 * f2));
                        CropImageView.this.invalidate();
                    }

                    public final void onAnimationFinished() {
                        RectF unused = CropImageView.this.mFrameRect = calcFrameRect;
                        CropImageView.this.invalidate();
                        boolean unused2 = CropImageView.this.mIsAnimating = false;
                    }
                });
                animator.startAnimation((long) i2);
                return;
            }
            this.mFrameRect = calcFrameRect(this.mImageRect);
            invalidate();
        }
    }

    private float getRatioX(float f2) {
        switch (this.mCropMode) {
            case FIT_IMAGE:
                return this.mImageRect.width();
            case FREE:
                return f2;
            case RATIO_4_3:
                return 4.0f;
            case RATIO_3_4:
                return 3.0f;
            case RATIO_16_9:
                return 16.0f;
            case RATIO_9_16:
                return 9.0f;
            case SQUARE:
            case CIRCLE:
            case CIRCLE_SQUARE:
                return 1.0f;
            case CUSTOM:
                return this.mCustomRatio.x;
            default:
                return f2;
        }
    }

    private float getRatioY(float f2) {
        switch (this.mCropMode) {
            case FIT_IMAGE:
                return this.mImageRect.height();
            case FREE:
                return f2;
            case RATIO_4_3:
                return 3.0f;
            case RATIO_3_4:
                return 4.0f;
            case RATIO_16_9:
                return 9.0f;
            case RATIO_9_16:
                return 16.0f;
            case SQUARE:
            case CIRCLE:
            case CIRCLE_SQUARE:
                return 1.0f;
            case CUSTOM:
                return this.mCustomRatio.y;
            default:
                return f2;
        }
    }

    private float getRatioX() {
        switch (this.mCropMode) {
            case FIT_IMAGE:
                return this.mImageRect.width();
            case RATIO_4_3:
                return 4.0f;
            case RATIO_3_4:
                return 3.0f;
            case RATIO_16_9:
                return 16.0f;
            case RATIO_9_16:
                return 9.0f;
            case SQUARE:
            case CIRCLE:
            case CIRCLE_SQUARE:
                return 1.0f;
            case CUSTOM:
                return this.mCustomRatio.x;
            default:
                return 1.0f;
        }
    }

    private float getRatioY() {
        switch (this.mCropMode) {
            case FIT_IMAGE:
                return this.mImageRect.height();
            case RATIO_4_3:
                return 3.0f;
            case RATIO_3_4:
                return 4.0f;
            case RATIO_16_9:
                return 9.0f;
            case RATIO_9_16:
                return 16.0f;
            case SQUARE:
            case CIRCLE:
            case CIRCLE_SQUARE:
                return 1.0f;
            case CUSTOM:
                return this.mCustomRatio.y;
            default:
                return 1.0f;
        }
    }

    private float getDensity() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    /* access modifiers changed from: private */
    public void postErrorOnMainThread(final Callbacks.ImageCallback imageCallback, final Throwable th) {
        if (imageCallback != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                imageCallback.onError(th);
            } else {
                this.mHandler.post(new Runnable() {
                    public final void run() {
                        imageCallback.onError(th);
                    }
                });
            }
        }
    }

    private Bitmap getBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private float getRotatedWidth(float f2) {
        return getRotatedWidth(f2, this.mImgWidth, this.mImgHeight);
    }

    private float getRotatedHeight(float f2) {
        return getRotatedHeight(f2, this.mImgWidth, this.mImgHeight);
    }

    private Bitmap getRotatedBitmap(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.setRotate(this.mAngle, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private SimpleValueAnimator getAnimator() {
        setupAnimatorIfNeeded();
        return this.mAnimator;
    }

    private void setupAnimatorIfNeeded() {
        if (this.mAnimator != null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 14) {
            this.mAnimator = new ValueAnimatorV8(this.mInterpolator);
        } else {
            this.mAnimator = new ValueAnimatorV14(this.mInterpolator);
        }
    }

    private Bitmap getCroppedBitmapFromUri() throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = getContext().getContentResolver().openInputStream(this.mSourceUri);
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(inputStream, false);
            int width = newInstance.getWidth();
            int height = newInstance.getHeight();
            Rect calcCropRect = calcCropRect(width, height);
            if (this.mAngle != 0.0f) {
                Matrix matrix = new Matrix();
                matrix.setRotate(-this.mAngle);
                RectF rectF = new RectF();
                matrix.mapRect(rectF, new RectF(calcCropRect));
                rectF.offset(rectF.left < 0.0f ? (float) width : 0.0f, rectF.top < 0.0f ? (float) height : 0.0f);
                calcCropRect = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            }
            Bitmap decodeRegion = newInstance.decodeRegion(calcCropRect, new BitmapFactory.Options());
            if (this.mAngle != 0.0f) {
                Bitmap rotatedBitmap = getRotatedBitmap(decodeRegion);
                if (!(decodeRegion == getBitmap() || decodeRegion == rotatedBitmap)) {
                    decodeRegion.recycle();
                }
                decodeRegion = rotatedBitmap;
            }
            return decodeRegion;
        } finally {
            ImageUtils.closeQuietly(inputStream);
        }
    }

    private Rect calcCropRect(int i2, int i3) {
        float f2 = (float) i2;
        float f3 = (float) i3;
        float rotatedWidth = getRotatedWidth(this.mAngle, f2, f3) / this.mImageRect.width();
        float f4 = this.mImageRect.left * rotatedWidth;
        float f5 = this.mImageRect.top * rotatedWidth;
        int round = Math.round((this.mFrameRect.left * rotatedWidth) - f4);
        int round2 = Math.round((this.mFrameRect.top * rotatedWidth) - f5);
        int round3 = Math.round((this.mFrameRect.right * rotatedWidth) - f4);
        int round4 = Math.round((this.mFrameRect.bottom * rotatedWidth) - f5);
        return new Rect(Math.max(round, 0), Math.max(round2, 0), Math.min(round3, Math.round(getRotatedWidth(this.mAngle, f2, f3))), Math.min(round4, Math.round(getRotatedHeight(this.mAngle, f2, f3))));
    }

    private Bitmap scaleBitmapIfNeeded(Bitmap bitmap) {
        int i2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float ratioX = getRatioX(this.mFrameRect.width()) / getRatioY(this.mFrameRect.height());
        int i3 = this.mOutputWidth;
        int i4 = 0;
        if (i3 > 0) {
            i4 = Math.round(((float) i3) / ratioX);
        } else {
            int i5 = this.mOutputHeight;
            if (i5 > 0) {
                i4 = i5;
                i3 = Math.round(((float) i5) * ratioX);
            } else {
                int i6 = this.mOutputMaxWidth;
                if (i6 <= 0 || (i2 = this.mOutputMaxHeight) <= 0 || (width <= i6 && height <= i2)) {
                    i3 = 0;
                } else {
                    i3 = this.mOutputMaxWidth;
                    i4 = this.mOutputMaxHeight;
                    if (((float) i3) / ((float) i4) >= ratioX) {
                        i3 = Math.round(((float) i4) * ratioX);
                    } else {
                        i4 = Math.round(((float) i3) / ratioX);
                    }
                }
            }
        }
        if (i3 <= 0 || i4 <= 0) {
            return bitmap;
        }
        Bitmap scaledBitmap = ImageUtils.getScaledBitmap(bitmap, i3, i4);
        if (!(bitmap == getBitmap() || bitmap == scaledBitmap)) {
            bitmap.recycle();
        }
        return scaledBitmap;
    }

    /* access modifiers changed from: private */
    public Uri saveImage(Bitmap bitmap, Uri uri) throws IOException, IllegalStateException {
        this.mSaveUri = uri;
        if (this.mSaveUri != null) {
            OutputStream outputStream = null;
            try {
                outputStream = getContext().getContentResolver().openOutputStream(uri);
                bitmap.compress(this.mCompressFormat, this.mCompressQuality, outputStream);
                ImageUtils.copyExifInfo(getContext(), this.mSourceUri, uri, bitmap.getWidth(), bitmap.getHeight());
                ImageUtils.updateGalleryInfo(getContext(), uri);
                return uri;
            } finally {
                ImageUtils.closeQuietly(outputStream);
            }
        } else {
            throw new IllegalStateException("Save uri must not be null.");
        }
    }

    public Bitmap getImageBitmap() {
        return getBitmap();
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    public void setImageResource(int i2) {
        this.mIsInitialized = false;
        resetImageInfo();
        super.setImageResource(i2);
        updateLayout();
    }

    public void setImageDrawable(Drawable drawable) {
        this.mIsInitialized = false;
        resetImageInfo();
        setImageDrawableInternal(drawable);
    }

    /* access modifiers changed from: private */
    public void setImageDrawableInternal(Drawable drawable) {
        super.setImageDrawable(drawable);
        updateLayout();
    }

    public void setImageURI(Uri uri) {
        this.mIsInitialized = false;
        super.setImageURI(uri);
        updateLayout();
    }

    private void updateLayout() {
        if (getDrawable() != null) {
            setupLayout(this.mViewWidth, this.mViewHeight);
        }
    }

    private void resetImageInfo() {
        if (!this.mIsLoading.get()) {
            this.mSourceUri = null;
            this.mSaveUri = null;
            this.mInputImageWidth = 0;
            this.mInputImageHeight = 0;
            this.mOutputImageWidth = 0;
            this.mOutputImageHeight = 0;
            this.mAngle = (float) this.mExifRotation;
        }
    }

    public void startLoad(Uri uri, Callbacks.LoadCallback loadCallback) {
        loadAsync(uri, loadCallback);
    }

    public void loadAsync(Uri uri, Callbacks.LoadCallback loadCallback) {
        loadAsync(uri, false, (RectF) null, loadCallback);
    }

    public void loadAsync(Uri uri, boolean z, RectF rectF, Callbacks.LoadCallback loadCallback) {
        final Uri uri2 = uri;
        final RectF rectF2 = rectF;
        final boolean z2 = z;
        final Callbacks.LoadCallback loadCallback2 = loadCallback;
        this.mExecutor.submit(new Runnable() {
            public final void run() {
                try {
                    CropImageView.this.mIsLoading.set(true);
                    Uri unused = CropImageView.this.mSourceUri = uri2;
                    RectF unused2 = CropImageView.this.mInitialFrameRect = rectF2;
                    if (z2) {
                        CropImageView.this.applyThumbnail(uri2);
                    }
                    final Bitmap access$600 = CropImageView.this.getImage(uri2);
                    CropImageView.this.mHandler.post(new Runnable() {
                        public final void run() {
                            float unused = CropImageView.this.mAngle = (float) CropImageView.this.mExifRotation;
                            CropImageView.this.setImageDrawableInternal(new BitmapDrawable(CropImageView.this.getResources(), access$600));
                            if (loadCallback2 != null) {
                                loadCallback2.onSuccess();
                            }
                        }
                    });
                } catch (Exception e2) {
                    CropImageView.this.postErrorOnMainThread(loadCallback2, e2);
                } catch (Throwable th) {
                    CropImageView.this.mIsLoading.set(false);
                    throw th;
                }
                CropImageView.this.mIsLoading.set(false);
            }
        });
    }

    public b loadAsCompletable(Uri uri) {
        return loadAsCompletable(uri, false, (RectF) null);
    }

    public b loadAsCompletable(final Uri uri, final boolean z, final RectF rectF) {
        return b.a((e) new e() {
            public final void a(final c cVar) throws Exception {
                RectF unused = CropImageView.this.mInitialFrameRect = rectF;
                Uri unused2 = CropImageView.this.mSourceUri = uri;
                if (z) {
                    CropImageView.this.applyThumbnail(uri);
                }
                final Bitmap access$600 = CropImageView.this.getImage(uri);
                CropImageView.this.mHandler.post(new Runnable() {
                    public final void run() {
                        float unused = CropImageView.this.mAngle = (float) CropImageView.this.mExifRotation;
                        CropImageView.this.setImageDrawableInternal(new BitmapDrawable(CropImageView.this.getResources(), access$600));
                        cVar.onComplete();
                    }
                });
            }
        }).b((g<? super io.reactivex.rxjava3.b.c>) new g<io.reactivex.rxjava3.b.c>() {
            public final /* synthetic */ void accept(Object obj) throws Throwable {
                CropImageView.this.mIsLoading.set(true);
            }
        }).b((io.reactivex.rxjava3.d.a) new io.reactivex.rxjava3.d.a() {
            public final void run() throws Exception {
                CropImageView.this.mIsLoading.set(false);
            }
        });
    }

    public LoadRequest load(Uri uri) {
        return new LoadRequest(this, uri);
    }

    /* access modifiers changed from: private */
    public void applyThumbnail(Uri uri) {
        final Bitmap thumbnail = getThumbnail(uri);
        if (thumbnail != null) {
            this.mHandler.post(new Runnable() {
                public final void run() {
                    CropImageView cropImageView = CropImageView.this;
                    float unused = cropImageView.mAngle = (float) cropImageView.mExifRotation;
                    CropImageView cropImageView2 = CropImageView.this;
                    cropImageView2.setImageDrawableInternal(new BitmapDrawable(cropImageView2.getResources(), thumbnail));
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public Bitmap getImage(Uri uri) {
        if (uri != null) {
            this.mExifRotation = ImageUtils.getExifOrientation(getContext(), this.mSourceUri);
            int maxSize = ImageUtils.getMaxSize();
            int max = Math.max(this.mViewWidth, this.mViewHeight);
            if (max != 0) {
                maxSize = max;
            }
            Bitmap decodeSampledBitmapFromUri = ImageUtils.decodeSampledBitmapFromUri(getContext(), this.mSourceUri, maxSize);
            this.mInputImageWidth = ImageUtils.sInputImageWidth;
            this.mInputImageHeight = ImageUtils.sInputImageHeight;
            return decodeSampledBitmapFromUri;
        }
        throw new IllegalStateException("Source Uri must not be null.");
    }

    private Bitmap getThumbnail(Uri uri) {
        if (uri != null) {
            this.mExifRotation = ImageUtils.getExifOrientation(getContext(), this.mSourceUri);
            int max = (int) (((float) Math.max(this.mViewWidth, this.mViewHeight)) * 0.1f);
            if (max == 0) {
                return null;
            }
            Bitmap decodeSampledBitmapFromUri = ImageUtils.decodeSampledBitmapFromUri(getContext(), this.mSourceUri, max);
            this.mInputImageWidth = ImageUtils.sInputImageWidth;
            this.mInputImageHeight = ImageUtils.sInputImageHeight;
            return decodeSampledBitmapFromUri;
        }
        throw new IllegalStateException("Source Uri must not be null.");
    }

    public void rotateImage(RotateDegrees rotateDegrees, int i2) {
        if (this.mIsRotating) {
            getAnimator().cancelAnimation();
        }
        final float f2 = this.mAngle;
        final float value = f2 + ((float) rotateDegrees.getValue());
        final float f3 = value - f2;
        final float f4 = this.mScale;
        final float calcScale = calcScale(this.mViewWidth, this.mViewHeight, value);
        if (this.mIsAnimationEnabled) {
            final float f5 = calcScale - f4;
            SimpleValueAnimator animator = getAnimator();
            animator.addAnimatorListener(new SimpleValueAnimatorListener() {
                public final void onAnimationStarted() {
                    boolean unused = CropImageView.this.mIsRotating = true;
                }

                public final void onAnimationUpdated(float f2) {
                    float unused = CropImageView.this.mAngle = f2 + (f3 * f2);
                    float unused2 = CropImageView.this.mScale = f4 + (f5 * f2);
                    CropImageView.this.setMatrix();
                    CropImageView.this.invalidate();
                }

                public final void onAnimationFinished() {
                    float unused = CropImageView.this.mAngle = value % 360.0f;
                    float unused2 = CropImageView.this.mScale = calcScale;
                    RectF unused3 = CropImageView.this.mInitialFrameRect = null;
                    CropImageView cropImageView = CropImageView.this;
                    cropImageView.setupLayout(cropImageView.mViewWidth, CropImageView.this.mViewHeight);
                    boolean unused4 = CropImageView.this.mIsRotating = false;
                }
            });
            animator.startAnimation((long) i2);
            return;
        }
        this.mAngle = value % 360.0f;
        this.mScale = calcScale;
        setupLayout(this.mViewWidth, this.mViewHeight);
    }

    public void rotateImage(RotateDegrees rotateDegrees) {
        rotateImage(rotateDegrees, this.mAnimationDurationMillis);
    }

    public Bitmap getCroppedBitmap() {
        Bitmap bitmap = getBitmap();
        if (bitmap == null) {
            return null;
        }
        Bitmap rotatedBitmap = getRotatedBitmap(bitmap);
        Rect calcCropRect = calcCropRect(bitmap.getWidth(), bitmap.getHeight());
        Bitmap createBitmap = Bitmap.createBitmap(rotatedBitmap, calcCropRect.left, calcCropRect.top, calcCropRect.width(), calcCropRect.height(), (Matrix) null, false);
        if (!(rotatedBitmap == createBitmap || rotatedBitmap == bitmap)) {
            rotatedBitmap.recycle();
        }
        if (this.mCropMode != CropMode.CIRCLE) {
            return createBitmap;
        }
        Bitmap circularBitmap = getCircularBitmap(createBitmap);
        if (createBitmap == getBitmap()) {
            return circularBitmap;
        }
        createBitmap.recycle();
        return circularBitmap;
    }

    public Bitmap getCircularBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        Canvas canvas = new Canvas(createBitmap);
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        canvas.drawCircle((float) width, (float) height, (float) Math.min(width, height), paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public void startCrop(final Uri uri, final Callbacks.CropCallback cropCallback, final Callbacks.SaveCallback saveCallback) {
        this.mExecutor.submit(new Runnable() {
            public final void run() {
                final Bitmap bitmap = null;
                try {
                    CropImageView.this.mIsCropping.set(true);
                    bitmap = CropImageView.this.cropImage();
                    CropImageView.this.mHandler.post(new Runnable() {
                        public final void run() {
                            if (cropCallback != null) {
                                cropCallback.onSuccess(bitmap);
                            }
                            if (CropImageView.this.mIsDebug) {
                                CropImageView.this.invalidate();
                            }
                        }
                    });
                    Uri unused = CropImageView.this.saveImage(bitmap, uri);
                    CropImageView.this.mHandler.post(new Runnable() {
                        public final void run() {
                            if (saveCallback != null) {
                                saveCallback.onSuccess(uri);
                            }
                        }
                    });
                } catch (Exception e2) {
                    if (bitmap == null) {
                        CropImageView.this.postErrorOnMainThread(cropCallback, e2);
                    } else {
                        CropImageView.this.postErrorOnMainThread(saveCallback, e2);
                    }
                } catch (Throwable th) {
                    CropImageView.this.mIsCropping.set(false);
                    throw th;
                }
                CropImageView.this.mIsCropping.set(false);
            }
        });
    }

    public void cropAsync(final Uri uri, final Callbacks.CropCallback cropCallback) {
        this.mExecutor.submit(new Runnable() {
            public final void run() {
                try {
                    CropImageView.this.mIsCropping.set(true);
                    if (uri != null) {
                        Uri unused = CropImageView.this.mSourceUri = uri;
                    }
                    final Bitmap access$1900 = CropImageView.this.cropImage();
                    CropImageView.this.mHandler.post(new Runnable() {
                        public final void run() {
                            if (cropCallback != null) {
                                cropCallback.onSuccess(access$1900);
                            }
                            if (CropImageView.this.mIsDebug) {
                                CropImageView.this.invalidate();
                            }
                        }
                    });
                } catch (Exception e2) {
                    CropImageView.this.postErrorOnMainThread(cropCallback, e2);
                } catch (Throwable th) {
                    CropImageView.this.mIsCropping.set(false);
                    throw th;
                }
                CropImageView.this.mIsCropping.set(false);
            }
        });
    }

    public void cropAsync(Callbacks.CropCallback cropCallback) {
        cropAsync((Uri) null, cropCallback);
    }

    public y<Bitmap> cropAsSingle(final Uri uri) {
        return y.a(new Callable<Bitmap>() {
            public final /* synthetic */ Object call() throws Exception {
                Uri uri = uri;
                if (uri != null) {
                    Uri unused = CropImageView.this.mSourceUri = uri;
                }
                return CropImageView.this.cropImage();
            }
        }).a((g<? super io.reactivex.rxjava3.b.c>) new g<io.reactivex.rxjava3.b.c>() {
            public final /* synthetic */ void accept(Object obj) throws Throwable {
                CropImageView.this.mIsCropping.set(true);
            }
        }).a((io.reactivex.rxjava3.d.a) new io.reactivex.rxjava3.d.a() {
            public final void run() throws Exception {
                CropImageView.this.mIsCropping.set(false);
            }
        });
    }

    public y<Bitmap> cropAsSingle() {
        return cropAsSingle((Uri) null);
    }

    public CropRequest crop(Uri uri) {
        return new CropRequest(this, uri);
    }

    public void saveAsync(final Uri uri, final Bitmap bitmap, final Callbacks.SaveCallback saveCallback) {
        this.mExecutor.submit(new Runnable() {
            public final void run() {
                try {
                    CropImageView.this.mIsSaving.set(true);
                    Uri unused = CropImageView.this.saveImage(bitmap, uri);
                    CropImageView.this.mHandler.post(new Runnable() {
                        public final void run() {
                            if (saveCallback != null) {
                                saveCallback.onSuccess(uri);
                            }
                        }
                    });
                } catch (Exception e2) {
                    CropImageView.this.postErrorOnMainThread(saveCallback, e2);
                } catch (Throwable th) {
                    CropImageView.this.mIsSaving.set(false);
                    throw th;
                }
                CropImageView.this.mIsSaving.set(false);
            }
        });
    }

    public y<Uri> saveAsSingle(final Bitmap bitmap, final Uri uri) {
        return y.a(new Callable<Uri>() {
            public final /* synthetic */ Object call() throws Exception {
                return CropImageView.this.saveImage(bitmap, uri);
            }
        }).a((g<? super io.reactivex.rxjava3.b.c>) new g<io.reactivex.rxjava3.b.c>() {
            public final /* synthetic */ void accept(Object obj) throws Throwable {
                CropImageView.this.mIsSaving.set(true);
            }
        }).a((io.reactivex.rxjava3.d.a) new io.reactivex.rxjava3.d.a() {
            public final void run() throws Exception {
                CropImageView.this.mIsSaving.set(false);
            }
        });
    }

    public SaveRequest save(Bitmap bitmap) {
        return new SaveRequest(this, bitmap);
    }

    /* access modifiers changed from: private */
    public Bitmap cropImage() throws IOException, IllegalStateException {
        Bitmap bitmap;
        if (this.mSourceUri == null) {
            bitmap = getCroppedBitmap();
        } else {
            bitmap = getCroppedBitmapFromUri();
            if (this.mCropMode == CropMode.CIRCLE) {
                Bitmap circularBitmap = getCircularBitmap(bitmap);
                if (bitmap != getBitmap()) {
                    bitmap.recycle();
                }
                bitmap = circularBitmap;
            }
        }
        Bitmap scaleBitmapIfNeeded = scaleBitmapIfNeeded(bitmap);
        this.mOutputImageWidth = scaleBitmapIfNeeded.getWidth();
        this.mOutputImageHeight = scaleBitmapIfNeeded.getHeight();
        return scaleBitmapIfNeeded;
    }

    public RectF getActualCropRect() {
        RectF rectF = this.mImageRect;
        if (rectF == null) {
            return null;
        }
        float f2 = rectF.left / this.mScale;
        float f3 = this.mImageRect.top / this.mScale;
        return new RectF(Math.max(0.0f, (this.mFrameRect.left / this.mScale) - f2), Math.max(0.0f, (this.mFrameRect.top / this.mScale) - f3), Math.min(this.mImageRect.right / this.mScale, (this.mFrameRect.right / this.mScale) - f2), Math.min(this.mImageRect.bottom / this.mScale, (this.mFrameRect.bottom / this.mScale) - f3));
    }

    private RectF applyInitialFrameRect(RectF rectF) {
        RectF rectF2 = new RectF();
        rectF2.set(rectF.left * this.mScale, rectF.top * this.mScale, rectF.right * this.mScale, rectF.bottom * this.mScale);
        rectF2.offset(this.mImageRect.left, this.mImageRect.top);
        rectF2.set(Math.max(this.mImageRect.left, rectF2.left), Math.max(this.mImageRect.top, rectF2.top), Math.min(this.mImageRect.right, rectF2.right), Math.min(this.mImageRect.bottom, rectF2.bottom));
        return rectF2;
    }

    public void setCropMode(CropMode cropMode, int i2) {
        if (cropMode == CropMode.CUSTOM) {
            setCustomRatio(1, 1);
            return;
        }
        this.mCropMode = cropMode;
        recalculateFrameRect(i2);
    }

    public void setCropMode(CropMode cropMode) {
        setCropMode(cropMode, this.mAnimationDurationMillis);
    }

    public void setCustomRatio(int i2, int i3, int i4) {
        if (i2 != 0 && i3 != 0) {
            this.mCropMode = CropMode.CUSTOM;
            this.mCustomRatio = new PointF((float) i2, (float) i3);
            recalculateFrameRect(i4);
        }
    }

    public void setCustomRatio(int i2, int i3) {
        setCustomRatio(i2, i3, this.mAnimationDurationMillis);
    }

    public void setOverlayColor(int i2) {
        this.mOverlayColor = i2;
        invalidate();
    }

    public void setFrameColor(int i2) {
        this.mFrameColor = i2;
        invalidate();
    }

    public void setHandleColor(int i2) {
        this.mHandleColor = i2;
        invalidate();
    }

    public void setGuideColor(int i2) {
        this.mGuideColor = i2;
        invalidate();
    }

    public void setBackgroundColor(int i2) {
        this.mBackgroundColor = i2;
        invalidate();
    }

    public void setMinFrameSizeInDp(int i2) {
        this.mMinFrameSize = ((float) i2) * getDensity();
    }

    public void setMinFrameSizeInPx(int i2) {
        this.mMinFrameSize = (float) i2;
    }

    public void setHandleSizeInDp(int i2) {
        this.mHandleSize = (int) (((float) i2) * getDensity());
    }

    public void setTouchPaddingInDp(int i2) {
        this.mTouchPadding = (int) (((float) i2) * getDensity());
    }

    /* renamed from: com.paytm.android.chat.utils.imagecropper.CropImageView$10  reason: invalid class name */
    static /* synthetic */ class AnonymousClass10 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f42373a = new int[a.values().length];

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f42375c = new int[ShowMode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(39:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|(2:21|22)|23|(2:25|26)|27|29|30|31|32|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|(3:51|52|54)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|(2:21|22)|23|25|26|27|29|30|31|32|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|(3:51|52|54)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(44:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|(2:21|22)|23|25|26|27|29|30|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|49|50|51|52|54) */
        /* JADX WARNING: Can't wrap try/catch for region: R(45:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|21|22|23|25|26|27|29|30|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|49|50|51|52|54) */
        /* JADX WARNING: Can't wrap try/catch for region: R(46:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|21|22|23|25|26|27|29|30|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|49|50|51|52|54) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0072 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x007d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0089 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0095 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00be */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00c8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00d2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00dc */
        static {
            /*
                com.paytm.android.chat.utils.imagecropper.CropImageView$ShowMode[] r0 = com.paytm.android.chat.utils.imagecropper.CropImageView.ShowMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f42375c = r0
                r0 = 1
                int[] r1 = f42375c     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.paytm.android.chat.utils.imagecropper.CropImageView$ShowMode r2 = com.paytm.android.chat.utils.imagecropper.CropImageView.ShowMode.SHOW_ALWAYS     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f42375c     // Catch:{ NoSuchFieldError -> 0x001f }
                com.paytm.android.chat.utils.imagecropper.CropImageView$ShowMode r3 = com.paytm.android.chat.utils.imagecropper.CropImageView.ShowMode.NOT_SHOW     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f42375c     // Catch:{ NoSuchFieldError -> 0x002a }
                com.paytm.android.chat.utils.imagecropper.CropImageView$ShowMode r4 = com.paytm.android.chat.utils.imagecropper.CropImageView.ShowMode.SHOW_ON_TOUCH     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.paytm.android.chat.utils.imagecropper.CropImageView$CropMode[] r3 = com.paytm.android.chat.utils.imagecropper.CropImageView.CropMode.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f42374b = r3
                int[] r3 = f42374b     // Catch:{ NoSuchFieldError -> 0x003d }
                com.paytm.android.chat.utils.imagecropper.CropImageView$CropMode r4 = com.paytm.android.chat.utils.imagecropper.CropImageView.CropMode.FIT_IMAGE     // Catch:{ NoSuchFieldError -> 0x003d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r3 = f42374b     // Catch:{ NoSuchFieldError -> 0x0047 }
                com.paytm.android.chat.utils.imagecropper.CropImageView$CropMode r4 = com.paytm.android.chat.utils.imagecropper.CropImageView.CropMode.FREE     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                int[] r3 = f42374b     // Catch:{ NoSuchFieldError -> 0x0051 }
                com.paytm.android.chat.utils.imagecropper.CropImageView$CropMode r4 = com.paytm.android.chat.utils.imagecropper.CropImageView.CropMode.RATIO_4_3     // Catch:{ NoSuchFieldError -> 0x0051 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0051 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                r3 = 4
                int[] r4 = f42374b     // Catch:{ NoSuchFieldError -> 0x005c }
                com.paytm.android.chat.utils.imagecropper.CropImageView$CropMode r5 = com.paytm.android.chat.utils.imagecropper.CropImageView.CropMode.RATIO_3_4     // Catch:{ NoSuchFieldError -> 0x005c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                r4 = 5
                int[] r5 = f42374b     // Catch:{ NoSuchFieldError -> 0x0067 }
                com.paytm.android.chat.utils.imagecropper.CropImageView$CropMode r6 = com.paytm.android.chat.utils.imagecropper.CropImageView.CropMode.RATIO_16_9     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                r5 = 6
                int[] r6 = f42374b     // Catch:{ NoSuchFieldError -> 0x0072 }
                com.paytm.android.chat.utils.imagecropper.CropImageView$CropMode r7 = com.paytm.android.chat.utils.imagecropper.CropImageView.CropMode.RATIO_9_16     // Catch:{ NoSuchFieldError -> 0x0072 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0072 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0072 }
            L_0x0072:
                int[] r6 = f42374b     // Catch:{ NoSuchFieldError -> 0x007d }
                com.paytm.android.chat.utils.imagecropper.CropImageView$CropMode r7 = com.paytm.android.chat.utils.imagecropper.CropImageView.CropMode.SQUARE     // Catch:{ NoSuchFieldError -> 0x007d }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r8 = 7
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                int[] r6 = f42374b     // Catch:{ NoSuchFieldError -> 0x0089 }
                com.paytm.android.chat.utils.imagecropper.CropImageView$CropMode r7 = com.paytm.android.chat.utils.imagecropper.CropImageView.CropMode.CIRCLE     // Catch:{ NoSuchFieldError -> 0x0089 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0089 }
                r8 = 8
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                int[] r6 = f42374b     // Catch:{ NoSuchFieldError -> 0x0095 }
                com.paytm.android.chat.utils.imagecropper.CropImageView$CropMode r7 = com.paytm.android.chat.utils.imagecropper.CropImageView.CropMode.CIRCLE_SQUARE     // Catch:{ NoSuchFieldError -> 0x0095 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0095 }
                r8 = 9
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0095 }
            L_0x0095:
                int[] r6 = f42374b     // Catch:{ NoSuchFieldError -> 0x00a1 }
                com.paytm.android.chat.utils.imagecropper.CropImageView$CropMode r7 = com.paytm.android.chat.utils.imagecropper.CropImageView.CropMode.CUSTOM     // Catch:{ NoSuchFieldError -> 0x00a1 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a1 }
                r8 = 10
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x00a1 }
            L_0x00a1:
                com.paytm.android.chat.utils.imagecropper.CropImageView$a[] r6 = com.paytm.android.chat.utils.imagecropper.CropImageView.a.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                f42373a = r6
                int[] r6 = f42373a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.paytm.android.chat.utils.imagecropper.CropImageView$a r7 = com.paytm.android.chat.utils.imagecropper.CropImageView.a.CENTER     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r6[r7] = r0     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f42373a     // Catch:{ NoSuchFieldError -> 0x00be }
                com.paytm.android.chat.utils.imagecropper.CropImageView$a r6 = com.paytm.android.chat.utils.imagecropper.CropImageView.a.LEFT_TOP     // Catch:{ NoSuchFieldError -> 0x00be }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00be }
                r0[r6] = r1     // Catch:{ NoSuchFieldError -> 0x00be }
            L_0x00be:
                int[] r0 = f42373a     // Catch:{ NoSuchFieldError -> 0x00c8 }
                com.paytm.android.chat.utils.imagecropper.CropImageView$a r1 = com.paytm.android.chat.utils.imagecropper.CropImageView.a.RIGHT_TOP     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                int[] r0 = f42373a     // Catch:{ NoSuchFieldError -> 0x00d2 }
                com.paytm.android.chat.utils.imagecropper.CropImageView$a r1 = com.paytm.android.chat.utils.imagecropper.CropImageView.a.LEFT_BOTTOM     // Catch:{ NoSuchFieldError -> 0x00d2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d2 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00d2 }
            L_0x00d2:
                int[] r0 = f42373a     // Catch:{ NoSuchFieldError -> 0x00dc }
                com.paytm.android.chat.utils.imagecropper.CropImageView$a r1 = com.paytm.android.chat.utils.imagecropper.CropImageView.a.RIGHT_BOTTOM     // Catch:{ NoSuchFieldError -> 0x00dc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dc }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00dc }
            L_0x00dc:
                int[] r0 = f42373a     // Catch:{ NoSuchFieldError -> 0x00e6 }
                com.paytm.android.chat.utils.imagecropper.CropImageView$a r1 = com.paytm.android.chat.utils.imagecropper.CropImageView.a.OUT_OF_BOUNDS     // Catch:{ NoSuchFieldError -> 0x00e6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e6 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x00e6 }
            L_0x00e6:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.utils.imagecropper.CropImageView.AnonymousClass10.<clinit>():void");
        }
    }

    public void setGuideShowMode(ShowMode showMode) {
        this.mGuideShowMode = showMode;
        int i2 = AnonymousClass10.f42375c[showMode.ordinal()];
        if (i2 == 1) {
            this.mShowGuide = true;
        } else if (i2 == 2 || i2 == 3) {
            this.mShowGuide = false;
        }
        invalidate();
    }

    public void setHandleShowMode(ShowMode showMode) {
        this.mHandleShowMode = showMode;
        int i2 = AnonymousClass10.f42375c[showMode.ordinal()];
        if (i2 == 1) {
            this.mShowHandle = true;
        } else if (i2 == 2 || i2 == 3) {
            this.mShowHandle = false;
        }
        invalidate();
    }

    public void setFrameStrokeWeightInDp(int i2) {
        this.mFrameStrokeWeight = ((float) i2) * getDensity();
        invalidate();
    }

    public void setGuideStrokeWeightInDp(int i2) {
        this.mGuideStrokeWeight = ((float) i2) * getDensity();
        invalidate();
    }

    public void setCropEnabled(boolean z) {
        this.mIsCropEnabled = z;
        invalidate();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.mIsEnabled = z;
    }

    public void setInitialFrameScale(float f2) {
        this.mInitialFrameScale = constrain(f2, 0.01f, 1.0f, 1.0f);
    }

    public void setAnimationEnabled(boolean z) {
        this.mIsAnimationEnabled = z;
    }

    public void setAnimationDuration(int i2) {
        this.mAnimationDurationMillis = i2;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
        this.mAnimator = null;
        setupAnimatorIfNeeded();
    }

    public void setOutputWidth(int i2) {
        this.mOutputWidth = i2;
        this.mOutputHeight = 0;
    }

    public void setOutputHeight(int i2) {
        this.mOutputHeight = i2;
        this.mOutputWidth = 0;
    }

    public void setOutputMaxSize(int i2, int i3) {
        this.mOutputMaxWidth = i2;
        this.mOutputMaxHeight = i3;
    }

    public void setCompressFormat(Bitmap.CompressFormat compressFormat) {
        this.mCompressFormat = compressFormat;
    }

    public void setCompressQuality(int i2) {
        this.mCompressQuality = i2;
    }

    public void setHandleShadowEnabled(boolean z) {
        this.mIsHandleShadowEnabled = z;
    }

    public boolean isCropping() {
        return this.mIsCropping.get();
    }

    public Uri getSourceUri() {
        return this.mSourceUri;
    }

    public Uri getSaveUri() {
        return this.mSaveUri;
    }

    public boolean isSaving() {
        return this.mIsSaving.get();
    }

    private void setScale(float f2) {
        this.mScale = f2;
    }

    private void setCenter(PointF pointF) {
        this.mCenter = pointF;
    }

    private float getFrameW() {
        return this.mFrameRect.right - this.mFrameRect.left;
    }

    private float getFrameH() {
        return this.mFrameRect.bottom - this.mFrameRect.top;
    }

    public enum CropMode {
        FIT_IMAGE(0),
        RATIO_4_3(1),
        RATIO_3_4(2),
        SQUARE(3),
        RATIO_16_9(4),
        RATIO_9_16(5),
        FREE(6),
        CUSTOM(7),
        CIRCLE(8),
        CIRCLE_SQUARE(9);
        
        private final int ID;

        private CropMode(int i2) {
            this.ID = i2;
        }

        public final int getId() {
            return this.ID;
        }
    }

    public enum ShowMode {
        SHOW_ALWAYS(1),
        SHOW_ON_TOUCH(2),
        NOT_SHOW(3);
        
        private final int ID;

        private ShowMode(int i2) {
            this.ID = i2;
        }

        public final int getId() {
            return this.ID;
        }
    }

    public enum RotateDegrees {
        ROTATE_90D(90),
        ROTATE_180D(AppConstants.READ_TIME_OUT),
        ROTATE_270D(270),
        ROTATE_M90D(-90),
        ROTATE_M180D(-180),
        ROTATE_M270D(-270);
        
        private final int VALUE;

        private RotateDegrees(int i2) {
            this.VALUE = i2;
        }

        public final int getValue() {
            return this.VALUE;
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };
        float angle;
        int animationDuration;
        int backgroundColor;
        Bitmap.CompressFormat compressFormat;
        int compressQuality;
        float customRatioX;
        float customRatioY;
        int exifRotation;
        int frameColor;
        float frameStrokeWeight;
        int guideColor;
        ShowMode guideShowMode;
        float guideStrokeWeight;
        int handleColor;
        ShowMode handleShowMode;
        int handleSize;
        float initialFrameScale;
        int inputImageHeight;
        int inputImageWidth;
        boolean isAnimationEnabled;
        boolean isCropEnabled;
        boolean isDebug;
        boolean isHandleShadowEnabled;
        float minFrameSize;
        CropMode mode;
        int outputHeight;
        int outputImageHeight;
        int outputImageWidth;
        int outputMaxHeight;
        int outputMaxWidth;
        int outputWidth;
        int overlayColor;
        Uri saveUri;
        boolean showGuide;
        boolean showHandle;
        Uri sourceUri;
        int touchPadding;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mode = (CropMode) parcel.readSerializable();
            this.backgroundColor = parcel.readInt();
            this.overlayColor = parcel.readInt();
            this.frameColor = parcel.readInt();
            this.guideShowMode = (ShowMode) parcel.readSerializable();
            this.handleShowMode = (ShowMode) parcel.readSerializable();
            boolean z = true;
            this.showGuide = parcel.readInt() != 0;
            this.showHandle = parcel.readInt() != 0;
            this.handleSize = parcel.readInt();
            this.touchPadding = parcel.readInt();
            this.minFrameSize = parcel.readFloat();
            this.customRatioX = parcel.readFloat();
            this.customRatioY = parcel.readFloat();
            this.frameStrokeWeight = parcel.readFloat();
            this.guideStrokeWeight = parcel.readFloat();
            this.isCropEnabled = parcel.readInt() != 0;
            this.handleColor = parcel.readInt();
            this.guideColor = parcel.readInt();
            this.initialFrameScale = parcel.readFloat();
            this.angle = parcel.readFloat();
            this.isAnimationEnabled = parcel.readInt() != 0;
            this.animationDuration = parcel.readInt();
            this.exifRotation = parcel.readInt();
            this.sourceUri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
            this.saveUri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
            this.compressFormat = (Bitmap.CompressFormat) parcel.readSerializable();
            this.compressQuality = parcel.readInt();
            this.isDebug = parcel.readInt() != 0;
            this.outputMaxWidth = parcel.readInt();
            this.outputMaxHeight = parcel.readInt();
            this.outputWidth = parcel.readInt();
            this.outputHeight = parcel.readInt();
            this.isHandleShadowEnabled = parcel.readInt() == 0 ? false : z;
            this.inputImageWidth = parcel.readInt();
            this.inputImageHeight = parcel.readInt();
            this.outputImageWidth = parcel.readInt();
            this.outputImageHeight = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeSerializable(this.mode);
            parcel.writeInt(this.backgroundColor);
            parcel.writeInt(this.overlayColor);
            parcel.writeInt(this.frameColor);
            parcel.writeSerializable(this.guideShowMode);
            parcel.writeSerializable(this.handleShowMode);
            parcel.writeInt(this.showGuide ? 1 : 0);
            parcel.writeInt(this.showHandle ? 1 : 0);
            parcel.writeInt(this.handleSize);
            parcel.writeInt(this.touchPadding);
            parcel.writeFloat(this.minFrameSize);
            parcel.writeFloat(this.customRatioX);
            parcel.writeFloat(this.customRatioY);
            parcel.writeFloat(this.frameStrokeWeight);
            parcel.writeFloat(this.guideStrokeWeight);
            parcel.writeInt(this.isCropEnabled ? 1 : 0);
            parcel.writeInt(this.handleColor);
            parcel.writeInt(this.guideColor);
            parcel.writeFloat(this.initialFrameScale);
            parcel.writeFloat(this.angle);
            parcel.writeInt(this.isAnimationEnabled ? 1 : 0);
            parcel.writeInt(this.animationDuration);
            parcel.writeInt(this.exifRotation);
            parcel.writeParcelable(this.sourceUri, i2);
            parcel.writeParcelable(this.saveUri, i2);
            parcel.writeSerializable(this.compressFormat);
            parcel.writeInt(this.compressQuality);
            parcel.writeInt(this.isDebug ? 1 : 0);
            parcel.writeInt(this.outputMaxWidth);
            parcel.writeInt(this.outputMaxHeight);
            parcel.writeInt(this.outputWidth);
            parcel.writeInt(this.outputHeight);
            parcel.writeInt(this.isHandleShadowEnabled ? 1 : 0);
            parcel.writeInt(this.inputImageWidth);
            parcel.writeInt(this.inputImageHeight);
            parcel.writeInt(this.outputImageWidth);
            parcel.writeInt(this.outputImageHeight);
        }
    }
}
