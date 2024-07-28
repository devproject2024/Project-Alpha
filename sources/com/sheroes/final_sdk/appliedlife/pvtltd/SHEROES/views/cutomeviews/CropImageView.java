package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.exifinterface.a.a;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.BitmapCroppingWorkerTask;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.BitmapLoadingWorkerTask;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.BitmapUtils;
import java.lang.ref.WeakReference;
import java.util.UUID;

public class CropImageView extends FrameLayout {
    private CropImageAnimation mAnimation;
    private boolean mAutoZoomEnabled;
    private Bitmap mBitmap;
    private WeakReference<BitmapCroppingWorkerTask> mBitmapCroppingWorkerTask;
    private WeakReference<BitmapLoadingWorkerTask> mBitmapLoadingWorkerTask;
    private final CropOverlayView mCropOverlayView;
    private int mDegreesRotated;
    private boolean mFlipHorizontally;
    private boolean mFlipVertically;
    private final Matrix mImageInverseMatrix;
    private final Matrix mImageMatrix;
    private final float[] mImagePoints;
    private int mImageResource;
    private final ImageView mImageView;
    private int mInitialDegreesRotated;
    private int mLayoutHeight;
    private int mLayoutWidth;
    private Uri mLoadedImageUri;
    private int mLoadedSampleSize;
    private int mMaxZoom;
    private OnCropImageCompleteListener mOnCropImageCompleteListener;
    /* access modifiers changed from: private */
    public OnSetCropOverlayReleasedListener mOnCropOverlayReleasedListener;
    private OnSetImageUriCompleteListener mOnSetImageUriCompleteListener;
    private final ProgressBar mProgressBar;
    private RectF mRestoreCropWindowRect;
    private int mRestoreDegreesRotated;
    private boolean mSaveBitmapToInstanceState;
    private Uri mSaveInstanceStateBitmapUri;
    private ScaleType mScaleType;
    private boolean mShowCropOverlay;
    private boolean mShowProgressBar;
    private boolean mSizeChanged;
    private float mZoom;
    private float mZoomOffsetX;
    private float mZoomOffsetY;

    public enum CropShape {
        RECTANGLE,
        OVAL
    }

    public enum Guidelines {
        OFF,
        ON_TOUCH,
        ON
    }

    public interface OnCropImageCompleteListener {
        void onCropImageComplete(CropImageView cropImageView, CropResult cropResult);
    }

    public interface OnSetCropOverlayReleasedListener {
        void onCropOverlayReleased(Rect rect);
    }

    public interface OnSetImageUriCompleteListener {
        void onSetImageUriComplete(CropImageView cropImageView, Uri uri, Exception exc);
    }

    public enum RequestSizeOptions {
        NONE,
        SAMPLING,
        RESIZE_INSIDE,
        RESIZE_FIT,
        RESIZE_EXACT
    }

    public enum ScaleType {
        FIT_CENTER,
        CENTER,
        CENTER_CROP,
        CENTER_INSIDE
    }

    public CropImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX WARNING: type inference failed for: r2v47, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CropImageView(android.content.Context r6, android.util.AttributeSet r7) {
        /*
            r5 = this;
            r5.<init>(r6, r7)
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            r5.mImageMatrix = r0
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            r5.mImageInverseMatrix = r0
            r0 = 8
            float[] r0 = new float[r0]
            r5.mImagePoints = r0
            r0 = 0
            r5.mSaveBitmapToInstanceState = r0
            r1 = 1
            r5.mShowCropOverlay = r1
            r5.mShowProgressBar = r1
            r5.mAutoZoomEnabled = r1
            r5.mLoadedSampleSize = r1
            r2 = 1065353216(0x3f800000, float:1.0)
            r5.mZoom = r2
            boolean r2 = r6 instanceof android.app.Activity
            r3 = 0
            if (r2 == 0) goto L_0x0034
            r2 = r6
            android.app.Activity r2 = (android.app.Activity) r2
            android.content.Intent r2 = r2.getIntent()
            goto L_0x0035
        L_0x0034:
            r2 = r3
        L_0x0035:
            if (r2 == 0) goto L_0x0048
            java.lang.String r4 = "bundle"
            android.os.Bundle r2 = r2.getBundleExtra(r4)
            if (r2 == 0) goto L_0x0048
            java.lang.String r3 = "CROP_IMAGE_EXTRA_OPTIONS"
            android.os.Parcelable r2 = r2.getParcelable(r3)
            r3 = r2
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageOptions r3 = (com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageOptions) r3
        L_0x0048:
            if (r3 != 0) goto L_0x01ee
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageOptions r3 = new com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageOptions
            r3.<init>()
            if (r7 == 0) goto L_0x01ee
            int[] r2 = com.sheroes.final_sdk.R.styleable.CropImageView
            android.content.res.TypedArray r7 = r6.obtainStyledAttributes(r7, r2, r0, r0)
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropFixAspectRatio     // Catch:{ all -> 0x01e9 }
            boolean r2 = r3.fixAspectRatio     // Catch:{ all -> 0x01e9 }
            boolean r0 = r7.getBoolean(r0, r2)     // Catch:{ all -> 0x01e9 }
            r3.fixAspectRatio = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropAspectRatioX     // Catch:{ all -> 0x01e9 }
            int r2 = r3.aspectRatioX     // Catch:{ all -> 0x01e9 }
            int r0 = r7.getInteger(r0, r2)     // Catch:{ all -> 0x01e9 }
            r3.aspectRatioX = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropAspectRatioY     // Catch:{ all -> 0x01e9 }
            int r2 = r3.aspectRatioY     // Catch:{ all -> 0x01e9 }
            int r0 = r7.getInteger(r0, r2)     // Catch:{ all -> 0x01e9 }
            r3.aspectRatioY = r0     // Catch:{ all -> 0x01e9 }
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageView$ScaleType[] r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageView.ScaleType.values()     // Catch:{ all -> 0x01e9 }
            int r2 = com.sheroes.final_sdk.R.styleable.CropImageView_cropScaleType     // Catch:{ all -> 0x01e9 }
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageView$ScaleType r4 = r3.scaleType     // Catch:{ all -> 0x01e9 }
            int r4 = r4.ordinal()     // Catch:{ all -> 0x01e9 }
            int r2 = r7.getInt(r2, r4)     // Catch:{ all -> 0x01e9 }
            r0 = r0[r2]     // Catch:{ all -> 0x01e9 }
            r3.scaleType = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropAutoZoomEnabled     // Catch:{ all -> 0x01e9 }
            boolean r2 = r3.autoZoomEnabled     // Catch:{ all -> 0x01e9 }
            boolean r0 = r7.getBoolean(r0, r2)     // Catch:{ all -> 0x01e9 }
            r3.autoZoomEnabled = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropMultiTouchEnabled     // Catch:{ all -> 0x01e9 }
            boolean r2 = r3.multiTouchEnabled     // Catch:{ all -> 0x01e9 }
            boolean r0 = r7.getBoolean(r0, r2)     // Catch:{ all -> 0x01e9 }
            r3.multiTouchEnabled = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropMaxZoom     // Catch:{ all -> 0x01e9 }
            int r2 = r3.maxZoom     // Catch:{ all -> 0x01e9 }
            int r0 = r7.getInteger(r0, r2)     // Catch:{ all -> 0x01e9 }
            r3.maxZoom = r0     // Catch:{ all -> 0x01e9 }
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageView$CropShape[] r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageView.CropShape.values()     // Catch:{ all -> 0x01e9 }
            int r2 = com.sheroes.final_sdk.R.styleable.CropImageView_cropShape     // Catch:{ all -> 0x01e9 }
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageView$CropShape r4 = r3.cropShape     // Catch:{ all -> 0x01e9 }
            int r4 = r4.ordinal()     // Catch:{ all -> 0x01e9 }
            int r2 = r7.getInt(r2, r4)     // Catch:{ all -> 0x01e9 }
            r0 = r0[r2]     // Catch:{ all -> 0x01e9 }
            r3.cropShape = r0     // Catch:{ all -> 0x01e9 }
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageView$Guidelines[] r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageView.Guidelines.values()     // Catch:{ all -> 0x01e9 }
            int r2 = com.sheroes.final_sdk.R.styleable.CropImageView_cropGuidelines     // Catch:{ all -> 0x01e9 }
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageView$Guidelines r4 = r3.guidelines     // Catch:{ all -> 0x01e9 }
            int r4 = r4.ordinal()     // Catch:{ all -> 0x01e9 }
            int r2 = r7.getInt(r2, r4)     // Catch:{ all -> 0x01e9 }
            r0 = r0[r2]     // Catch:{ all -> 0x01e9 }
            r3.guidelines = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropSnapRadius     // Catch:{ all -> 0x01e9 }
            float r2 = r3.snapRadius     // Catch:{ all -> 0x01e9 }
            float r0 = r7.getDimension(r0, r2)     // Catch:{ all -> 0x01e9 }
            r3.snapRadius = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropTouchRadius     // Catch:{ all -> 0x01e9 }
            float r2 = r3.touchRadius     // Catch:{ all -> 0x01e9 }
            float r0 = r7.getDimension(r0, r2)     // Catch:{ all -> 0x01e9 }
            r3.touchRadius = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropInitialCropWindowPaddingRatio     // Catch:{ all -> 0x01e9 }
            float r2 = r3.initialCropWindowPaddingRatio     // Catch:{ all -> 0x01e9 }
            float r0 = r7.getFloat(r0, r2)     // Catch:{ all -> 0x01e9 }
            r3.initialCropWindowPaddingRatio = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropBorderLineThickness     // Catch:{ all -> 0x01e9 }
            float r2 = r3.borderLineThickness     // Catch:{ all -> 0x01e9 }
            float r0 = r7.getDimension(r0, r2)     // Catch:{ all -> 0x01e9 }
            r3.borderLineThickness = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropBorderLineColor     // Catch:{ all -> 0x01e9 }
            int r2 = r3.borderLineColor     // Catch:{ all -> 0x01e9 }
            int r0 = r7.getInteger(r0, r2)     // Catch:{ all -> 0x01e9 }
            r3.borderLineColor = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropBorderCornerThickness     // Catch:{ all -> 0x01e9 }
            float r2 = r3.borderCornerThickness     // Catch:{ all -> 0x01e9 }
            float r0 = r7.getDimension(r0, r2)     // Catch:{ all -> 0x01e9 }
            r3.borderCornerThickness = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropBorderCornerOffset     // Catch:{ all -> 0x01e9 }
            float r2 = r3.borderCornerOffset     // Catch:{ all -> 0x01e9 }
            float r0 = r7.getDimension(r0, r2)     // Catch:{ all -> 0x01e9 }
            r3.borderCornerOffset = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropBorderCornerLength     // Catch:{ all -> 0x01e9 }
            float r2 = r3.borderCornerLength     // Catch:{ all -> 0x01e9 }
            float r0 = r7.getDimension(r0, r2)     // Catch:{ all -> 0x01e9 }
            r3.borderCornerLength = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropBorderCornerColor     // Catch:{ all -> 0x01e9 }
            int r2 = r3.borderCornerColor     // Catch:{ all -> 0x01e9 }
            int r0 = r7.getInteger(r0, r2)     // Catch:{ all -> 0x01e9 }
            r3.borderCornerColor = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropGuidelinesThickness     // Catch:{ all -> 0x01e9 }
            float r2 = r3.guidelinesThickness     // Catch:{ all -> 0x01e9 }
            float r0 = r7.getDimension(r0, r2)     // Catch:{ all -> 0x01e9 }
            r3.guidelinesThickness = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropGuidelinesColor     // Catch:{ all -> 0x01e9 }
            int r2 = r3.guidelinesColor     // Catch:{ all -> 0x01e9 }
            int r0 = r7.getInteger(r0, r2)     // Catch:{ all -> 0x01e9 }
            r3.guidelinesColor = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropBackgroundColor     // Catch:{ all -> 0x01e9 }
            int r2 = r3.backgroundColor     // Catch:{ all -> 0x01e9 }
            int r0 = r7.getInteger(r0, r2)     // Catch:{ all -> 0x01e9 }
            r3.backgroundColor = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropShowCropOverlay     // Catch:{ all -> 0x01e9 }
            boolean r2 = r5.mShowCropOverlay     // Catch:{ all -> 0x01e9 }
            boolean r0 = r7.getBoolean(r0, r2)     // Catch:{ all -> 0x01e9 }
            r3.showCropOverlay = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropShowProgressBar     // Catch:{ all -> 0x01e9 }
            boolean r2 = r5.mShowProgressBar     // Catch:{ all -> 0x01e9 }
            boolean r0 = r7.getBoolean(r0, r2)     // Catch:{ all -> 0x01e9 }
            r3.showProgressBar = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropBorderCornerThickness     // Catch:{ all -> 0x01e9 }
            float r2 = r3.borderCornerThickness     // Catch:{ all -> 0x01e9 }
            float r0 = r7.getDimension(r0, r2)     // Catch:{ all -> 0x01e9 }
            r3.borderCornerThickness = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropMinCropWindowWidth     // Catch:{ all -> 0x01e9 }
            int r2 = r3.minCropWindowWidth     // Catch:{ all -> 0x01e9 }
            float r2 = (float) r2     // Catch:{ all -> 0x01e9 }
            float r0 = r7.getDimension(r0, r2)     // Catch:{ all -> 0x01e9 }
            int r0 = (int) r0     // Catch:{ all -> 0x01e9 }
            r3.minCropWindowWidth = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropMinCropWindowHeight     // Catch:{ all -> 0x01e9 }
            int r2 = r3.minCropWindowHeight     // Catch:{ all -> 0x01e9 }
            float r2 = (float) r2     // Catch:{ all -> 0x01e9 }
            float r0 = r7.getDimension(r0, r2)     // Catch:{ all -> 0x01e9 }
            int r0 = (int) r0     // Catch:{ all -> 0x01e9 }
            r3.minCropWindowHeight = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropMinCropResultWidthPX     // Catch:{ all -> 0x01e9 }
            int r2 = r3.minCropResultWidth     // Catch:{ all -> 0x01e9 }
            float r2 = (float) r2     // Catch:{ all -> 0x01e9 }
            float r0 = r7.getFloat(r0, r2)     // Catch:{ all -> 0x01e9 }
            int r0 = (int) r0     // Catch:{ all -> 0x01e9 }
            r3.minCropResultWidth = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropMinCropResultHeightPX     // Catch:{ all -> 0x01e9 }
            int r2 = r3.minCropResultHeight     // Catch:{ all -> 0x01e9 }
            float r2 = (float) r2     // Catch:{ all -> 0x01e9 }
            float r0 = r7.getFloat(r0, r2)     // Catch:{ all -> 0x01e9 }
            int r0 = (int) r0     // Catch:{ all -> 0x01e9 }
            r3.minCropResultHeight = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropMaxCropResultWidthPX     // Catch:{ all -> 0x01e9 }
            int r2 = r3.maxCropResultWidth     // Catch:{ all -> 0x01e9 }
            float r2 = (float) r2     // Catch:{ all -> 0x01e9 }
            float r0 = r7.getFloat(r0, r2)     // Catch:{ all -> 0x01e9 }
            int r0 = (int) r0     // Catch:{ all -> 0x01e9 }
            r3.maxCropResultWidth = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropMaxCropResultHeightPX     // Catch:{ all -> 0x01e9 }
            int r2 = r3.maxCropResultHeight     // Catch:{ all -> 0x01e9 }
            float r2 = (float) r2     // Catch:{ all -> 0x01e9 }
            float r0 = r7.getFloat(r0, r2)     // Catch:{ all -> 0x01e9 }
            int r0 = (int) r0     // Catch:{ all -> 0x01e9 }
            r3.maxCropResultHeight = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropFlipHorizontally     // Catch:{ all -> 0x01e9 }
            boolean r2 = r3.flipHorizontally     // Catch:{ all -> 0x01e9 }
            boolean r0 = r7.getBoolean(r0, r2)     // Catch:{ all -> 0x01e9 }
            r3.flipHorizontally = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropFlipHorizontally     // Catch:{ all -> 0x01e9 }
            boolean r2 = r3.flipVertically     // Catch:{ all -> 0x01e9 }
            boolean r0 = r7.getBoolean(r0, r2)     // Catch:{ all -> 0x01e9 }
            r3.flipVertically = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropSaveBitmapToInstanceState     // Catch:{ all -> 0x01e9 }
            boolean r2 = r5.mSaveBitmapToInstanceState     // Catch:{ all -> 0x01e9 }
            boolean r0 = r7.getBoolean(r0, r2)     // Catch:{ all -> 0x01e9 }
            r5.mSaveBitmapToInstanceState = r0     // Catch:{ all -> 0x01e9 }
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropAspectRatioX     // Catch:{ all -> 0x01e9 }
            boolean r0 = r7.hasValue(r0)     // Catch:{ all -> 0x01e9 }
            if (r0 == 0) goto L_0x01e5
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropAspectRatioX     // Catch:{ all -> 0x01e9 }
            boolean r0 = r7.hasValue(r0)     // Catch:{ all -> 0x01e9 }
            if (r0 == 0) goto L_0x01e5
            int r0 = com.sheroes.final_sdk.R.styleable.CropImageView_cropFixAspectRatio     // Catch:{ all -> 0x01e9 }
            boolean r0 = r7.hasValue(r0)     // Catch:{ all -> 0x01e9 }
            if (r0 != 0) goto L_0x01e5
            r3.fixAspectRatio = r1     // Catch:{ all -> 0x01e9 }
        L_0x01e5:
            r7.recycle()
            goto L_0x01ee
        L_0x01e9:
            r6 = move-exception
            r7.recycle()
            throw r6
        L_0x01ee:
            r3.validate()
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageView$ScaleType r7 = r3.scaleType
            r5.mScaleType = r7
            boolean r7 = r3.autoZoomEnabled
            r5.mAutoZoomEnabled = r7
            int r7 = r3.maxZoom
            r5.mMaxZoom = r7
            boolean r7 = r3.showCropOverlay
            r5.mShowCropOverlay = r7
            boolean r7 = r3.showProgressBar
            r5.mShowProgressBar = r7
            boolean r7 = r3.flipHorizontally
            r5.mFlipHorizontally = r7
            boolean r7 = r3.flipVertically
            r5.mFlipVertically = r7
            android.view.LayoutInflater r6 = android.view.LayoutInflater.from(r6)
            int r7 = com.sheroes.final_sdk.R.layout.crop_sheroes_image_view
            android.view.View r6 = r6.inflate(r7, r5, r1)
            int r7 = com.sheroes.final_sdk.R.id.sheroes_ImageView_image
            android.view.View r7 = r6.findViewById(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            r5.mImageView = r7
            android.widget.ImageView r7 = r5.mImageView
            android.widget.ImageView$ScaleType r0 = android.widget.ImageView.ScaleType.MATRIX
            r7.setScaleType(r0)
            int r7 = com.sheroes.final_sdk.R.id.sheroes_CropOverlayView
            android.view.View r7 = r6.findViewById(r7)
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropOverlayView r7 = (com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropOverlayView) r7
            r5.mCropOverlayView = r7
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropOverlayView r7 = r5.mCropOverlayView
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageView$1 r0 = new com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageView$1
            r0.<init>()
            r7.setCropWindowChangeListener(r0)
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropOverlayView r7 = r5.mCropOverlayView
            r7.setInitialAttributeValues(r3)
            int r7 = com.sheroes.final_sdk.R.id.sheroes_CropProgressBar
            android.view.View r6 = r6.findViewById(r7)
            android.widget.ProgressBar r6 = (android.widget.ProgressBar) r6
            r5.mProgressBar = r6
            r5.setProgressBarVisibility()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageView.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public ScaleType getScaleType() {
        return this.mScaleType;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType != this.mScaleType) {
            this.mScaleType = scaleType;
            this.mZoom = 1.0f;
            this.mZoomOffsetY = 0.0f;
            this.mZoomOffsetX = 0.0f;
            this.mCropOverlayView.resetCropOverlayView();
            requestLayout();
        }
    }

    public CropShape getCropShape() {
        return this.mCropOverlayView.getCropShape();
    }

    public void setCropShape(CropShape cropShape) {
        this.mCropOverlayView.setCropShape(cropShape);
    }

    public boolean isAutoZoomEnabled() {
        return this.mAutoZoomEnabled;
    }

    public void setAutoZoomEnabled(boolean z) {
        if (this.mAutoZoomEnabled != z) {
            this.mAutoZoomEnabled = z;
            handleCropWindowChanged(false, false);
            this.mCropOverlayView.invalidate();
        }
    }

    public void setMultiTouchEnabled(boolean z) {
        if (this.mCropOverlayView.setMultiTouchEnabled(z)) {
            handleCropWindowChanged(false, false);
            this.mCropOverlayView.invalidate();
        }
    }

    public int getMaxZoom() {
        return this.mMaxZoom;
    }

    public void setMaxZoom(int i2) {
        if (this.mMaxZoom != i2 && i2 > 0) {
            this.mMaxZoom = i2;
            handleCropWindowChanged(false, false);
            this.mCropOverlayView.invalidate();
        }
    }

    public void setMinCropResultSize(int i2, int i3) {
        this.mCropOverlayView.setMinCropResultSize(i2, i3);
    }

    public void setMaxCropResultSize(int i2, int i3) {
        this.mCropOverlayView.setMaxCropResultSize(i2, i3);
    }

    public int getRotatedDegrees() {
        return this.mDegreesRotated;
    }

    public void setRotatedDegrees(int i2) {
        int i3 = this.mDegreesRotated;
        if (i3 != i2) {
            rotateImage(i2 - i3);
        }
    }

    public boolean isFixAspectRatio() {
        return this.mCropOverlayView.isFixAspectRatio();
    }

    public void setFixedAspectRatio(boolean z) {
        this.mCropOverlayView.setFixedAspectRatio(z);
    }

    public boolean isFlippedHorizontally() {
        return this.mFlipHorizontally;
    }

    public void setFlippedHorizontally(boolean z) {
        if (this.mFlipHorizontally != z) {
            this.mFlipHorizontally = z;
            applyImageMatrix((float) getWidth(), (float) getHeight(), true, false);
        }
    }

    public boolean isFlippedVertically() {
        return this.mFlipVertically;
    }

    public void setFlippedVertically(boolean z) {
        if (this.mFlipVertically != z) {
            this.mFlipVertically = z;
            applyImageMatrix((float) getWidth(), (float) getHeight(), true, false);
        }
    }

    public Guidelines getGuidelines() {
        return this.mCropOverlayView.getGuidelines();
    }

    public void setGuidelines(Guidelines guidelines) {
        this.mCropOverlayView.setGuidelines(guidelines);
    }

    public Pair<Integer, Integer> getAspectRatio() {
        return new Pair<>(Integer.valueOf(this.mCropOverlayView.getAspectRatioX()), Integer.valueOf(this.mCropOverlayView.getAspectRatioY()));
    }

    public void setAspectRatio(int i2, int i3) {
        this.mCropOverlayView.setAspectRatioX(i2);
        this.mCropOverlayView.setAspectRatioY(i3);
        setFixedAspectRatio(true);
    }

    public void clearAspectRatio() {
        this.mCropOverlayView.setAspectRatioX(1);
        this.mCropOverlayView.setAspectRatioY(1);
        setFixedAspectRatio(false);
    }

    public void setSnapRadius(float f2) {
        if (f2 >= 0.0f) {
            this.mCropOverlayView.setSnapRadius(f2);
        }
    }

    public boolean isShowProgressBar() {
        return this.mShowProgressBar;
    }

    public void setShowProgressBar(boolean z) {
        if (this.mShowProgressBar != z) {
            this.mShowProgressBar = z;
            setProgressBarVisibility();
        }
    }

    public boolean isShowCropOverlay() {
        return this.mShowCropOverlay;
    }

    public void setShowCropOverlay(boolean z) {
        if (this.mShowCropOverlay != z) {
            this.mShowCropOverlay = z;
            setCropOverlayVisibility();
        }
    }

    public boolean isSaveBitmapToInstanceState() {
        return this.mSaveBitmapToInstanceState;
    }

    public void setSaveBitmapToInstanceState(boolean z) {
        this.mSaveBitmapToInstanceState = z;
    }

    public int getImageResource() {
        return this.mImageResource;
    }

    public Uri getImageUri() {
        return this.mLoadedImageUri;
    }

    public Rect getWholeImageRect() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null) {
            return null;
        }
        return new Rect(0, 0, bitmap.getWidth() * this.mLoadedSampleSize, this.mBitmap.getHeight() * this.mLoadedSampleSize);
    }

    public Rect getCropRect() {
        if (this.mBitmap == null) {
            return null;
        }
        return BitmapUtils.getRectFromPoints(getCropPoints(), this.mLoadedSampleSize * this.mBitmap.getWidth(), this.mLoadedSampleSize * this.mBitmap.getHeight(), this.mCropOverlayView.isFixAspectRatio(), this.mCropOverlayView.getAspectRatioX(), this.mCropOverlayView.getAspectRatioY());
    }

    public float[] getCropPoints() {
        RectF cropWindowRect = this.mCropOverlayView.getCropWindowRect();
        float[] fArr = {cropWindowRect.left, cropWindowRect.top, cropWindowRect.right, cropWindowRect.top, cropWindowRect.right, cropWindowRect.bottom, cropWindowRect.left, cropWindowRect.bottom};
        this.mImageMatrix.invert(this.mImageInverseMatrix);
        this.mImageInverseMatrix.mapPoints(fArr);
        for (int i2 = 0; i2 < 8; i2++) {
            fArr[i2] = fArr[i2] * ((float) this.mLoadedSampleSize);
        }
        return fArr;
    }

    public void setCropRect(Rect rect) {
        this.mCropOverlayView.setInitialCropWindowRect(rect);
    }

    public void resetCropRect() {
        this.mZoom = 1.0f;
        this.mZoomOffsetX = 0.0f;
        this.mZoomOffsetY = 0.0f;
        this.mDegreesRotated = this.mInitialDegreesRotated;
        this.mFlipHorizontally = false;
        this.mFlipVertically = false;
        applyImageMatrix((float) getWidth(), (float) getHeight(), false, false);
        this.mCropOverlayView.resetCropWindowRect();
    }

    public Bitmap getCroppedImage() {
        return getCroppedImage(0, 0, RequestSizeOptions.NONE);
    }

    public Bitmap getCroppedImage(int i2, int i3) {
        return getCroppedImage(i2, i3, RequestSizeOptions.RESIZE_INSIDE);
    }

    public Bitmap getCroppedImage(int i2, int i3, RequestSizeOptions requestSizeOptions) {
        Bitmap bitmap;
        RequestSizeOptions requestSizeOptions2 = requestSizeOptions;
        if (this.mBitmap == null) {
            return null;
        }
        this.mImageView.clearAnimation();
        int i4 = 0;
        int i5 = requestSizeOptions2 != RequestSizeOptions.NONE ? i2 : 0;
        if (requestSizeOptions2 != RequestSizeOptions.NONE) {
            i4 = i3;
        }
        if (this.mLoadedImageUri == null || (this.mLoadedSampleSize <= 1 && requestSizeOptions2 != RequestSizeOptions.SAMPLING)) {
            bitmap = BitmapUtils.cropBitmapObjectHandleOOM(this.mBitmap, getCropPoints(), this.mDegreesRotated, this.mCropOverlayView.isFixAspectRatio(), this.mCropOverlayView.getAspectRatioX(), this.mCropOverlayView.getAspectRatioY(), this.mFlipHorizontally, this.mFlipVertically).bitmap;
        } else {
            bitmap = BitmapUtils.cropBitmap(getContext(), this.mLoadedImageUri, getCropPoints(), this.mDegreesRotated, this.mBitmap.getWidth() * this.mLoadedSampleSize, this.mBitmap.getHeight() * this.mLoadedSampleSize, this.mCropOverlayView.isFixAspectRatio(), this.mCropOverlayView.getAspectRatioX(), this.mCropOverlayView.getAspectRatioY(), i5, i4, this.mFlipHorizontally, this.mFlipVertically).bitmap;
        }
        return BitmapUtils.resizeBitmap(bitmap, i5, i4, requestSizeOptions2);
    }

    public void getCroppedImageAsync() {
        getCroppedImageAsync(0, 0, RequestSizeOptions.NONE);
    }

    public void getCroppedImageAsync(int i2, int i3) {
        getCroppedImageAsync(i2, i3, RequestSizeOptions.RESIZE_INSIDE);
    }

    public void getCroppedImageAsync(int i2, int i3, RequestSizeOptions requestSizeOptions) {
        if (this.mOnCropImageCompleteListener != null) {
            startCropWorkerTask(i2, i3, requestSizeOptions, (Uri) null, (Bitmap.CompressFormat) null, 0);
            return;
        }
        throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
    }

    public void saveCroppedImageAsync(Uri uri) {
        saveCroppedImageAsync(uri, Bitmap.CompressFormat.JPEG, 90, 0, 0, RequestSizeOptions.NONE);
    }

    public void saveCroppedImageAsync(Uri uri, Bitmap.CompressFormat compressFormat, int i2) {
        saveCroppedImageAsync(uri, compressFormat, i2, 0, 0, RequestSizeOptions.NONE);
    }

    public void saveCroppedImageAsync(Uri uri, Bitmap.CompressFormat compressFormat, int i2, int i3, int i4) {
        saveCroppedImageAsync(uri, compressFormat, i2, i3, i4, RequestSizeOptions.RESIZE_INSIDE);
    }

    public void saveCroppedImageAsync(Uri uri, Bitmap.CompressFormat compressFormat, int i2, int i3, int i4, RequestSizeOptions requestSizeOptions) {
        if (this.mOnCropImageCompleteListener != null) {
            startCropWorkerTask(i3, i4, requestSizeOptions, uri, compressFormat, i2);
            return;
        }
        throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
    }

    public void setOnSetCropOverlayReleasedListener(OnSetCropOverlayReleasedListener onSetCropOverlayReleasedListener) {
        this.mOnCropOverlayReleasedListener = onSetCropOverlayReleasedListener;
    }

    public void setOnSetImageUriCompleteListener(OnSetImageUriCompleteListener onSetImageUriCompleteListener) {
        this.mOnSetImageUriCompleteListener = onSetImageUriCompleteListener;
    }

    public void setOnCropImageCompleteListener(OnCropImageCompleteListener onCropImageCompleteListener) {
        this.mOnCropImageCompleteListener = onCropImageCompleteListener;
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.mCropOverlayView.setInitialCropWindowRect((Rect) null);
        setBitmap(bitmap, 0, (Uri) null, 1, 0);
    }

    public void setImageBitmap(Bitmap bitmap, a aVar) {
        int i2;
        Bitmap bitmap2;
        if (bitmap == null || aVar == null) {
            bitmap2 = bitmap;
            i2 = 0;
        } else {
            BitmapUtils.RotateBitmapResult rotateBitmapByExif = BitmapUtils.rotateBitmapByExif(bitmap, aVar);
            Bitmap bitmap3 = rotateBitmapByExif.bitmap;
            int i3 = rotateBitmapByExif.degrees;
            this.mInitialDegreesRotated = rotateBitmapByExif.degrees;
            bitmap2 = bitmap3;
            i2 = i3;
        }
        this.mCropOverlayView.setInitialCropWindowRect((Rect) null);
        setBitmap(bitmap2, 0, (Uri) null, 1, i2);
    }

    public void setImageResource(int i2) {
        if (i2 != 0) {
            this.mCropOverlayView.setInitialCropWindowRect((Rect) null);
            setBitmap(BitmapFactory.decodeResource(getResources(), i2), i2, (Uri) null, 1, 0);
        }
    }

    public void setImageUriAsync(Uri uri) {
        if (uri != null) {
            WeakReference<BitmapLoadingWorkerTask> weakReference = this.mBitmapLoadingWorkerTask;
            BitmapLoadingWorkerTask bitmapLoadingWorkerTask = weakReference != null ? (BitmapLoadingWorkerTask) weakReference.get() : null;
            if (bitmapLoadingWorkerTask != null) {
                bitmapLoadingWorkerTask.cancel(true);
            }
            clearImageInt();
            this.mRestoreCropWindowRect = null;
            this.mRestoreDegreesRotated = 0;
            this.mCropOverlayView.setInitialCropWindowRect((Rect) null);
            this.mBitmapLoadingWorkerTask = new WeakReference<>(new BitmapLoadingWorkerTask(this, uri));
            ((BitmapLoadingWorkerTask) this.mBitmapLoadingWorkerTask.get()).execute(new Void[0]);
            setProgressBarVisibility();
        }
    }

    public void clearImage() {
        clearImageInt();
        this.mCropOverlayView.setInitialCropWindowRect((Rect) null);
    }

    public void rotateImage(int i2) {
        int i3;
        int i4 = i2;
        if (this.mBitmap != null) {
            if (i4 < 0) {
                i3 = (i4 % 360) + 360;
            } else {
                i3 = i4 % 360;
            }
            boolean z = !this.mCropOverlayView.isFixAspectRatio() && ((i3 > 45 && i3 < 135) || (i3 > 215 && i3 < 305));
            BitmapUtils.RECT.set(this.mCropOverlayView.getCropWindowRect());
            RectF rectF = BitmapUtils.RECT;
            float height = (z ? rectF.height() : rectF.width()) / 2.0f;
            RectF rectF2 = BitmapUtils.RECT;
            float width = (z ? rectF2.width() : rectF2.height()) / 2.0f;
            if (z) {
                boolean z2 = this.mFlipHorizontally;
                this.mFlipHorizontally = this.mFlipVertically;
                this.mFlipVertically = z2;
            }
            this.mImageMatrix.invert(this.mImageInverseMatrix);
            BitmapUtils.POINTS[0] = BitmapUtils.RECT.centerX();
            BitmapUtils.POINTS[1] = BitmapUtils.RECT.centerY();
            BitmapUtils.POINTS[2] = 0.0f;
            BitmapUtils.POINTS[3] = 0.0f;
            BitmapUtils.POINTS[4] = 1.0f;
            BitmapUtils.POINTS[5] = 0.0f;
            this.mImageInverseMatrix.mapPoints(BitmapUtils.POINTS);
            this.mDegreesRotated = (this.mDegreesRotated + i3) % 360;
            applyImageMatrix((float) getWidth(), (float) getHeight(), true, false);
            this.mImageMatrix.mapPoints(BitmapUtils.POINTS2, BitmapUtils.POINTS);
            this.mZoom = (float) (((double) this.mZoom) / Math.sqrt(Math.pow((double) (BitmapUtils.POINTS2[4] - BitmapUtils.POINTS2[2]), 2.0d) + Math.pow((double) (BitmapUtils.POINTS2[5] - BitmapUtils.POINTS2[3]), 2.0d)));
            this.mZoom = Math.max(this.mZoom, 1.0f);
            applyImageMatrix((float) getWidth(), (float) getHeight(), true, false);
            this.mImageMatrix.mapPoints(BitmapUtils.POINTS2, BitmapUtils.POINTS);
            double sqrt = Math.sqrt(Math.pow((double) (BitmapUtils.POINTS2[4] - BitmapUtils.POINTS2[2]), 2.0d) + Math.pow((double) (BitmapUtils.POINTS2[5] - BitmapUtils.POINTS2[3]), 2.0d));
            float f2 = (float) (((double) height) * sqrt);
            float f3 = (float) (((double) width) * sqrt);
            BitmapUtils.RECT.set(BitmapUtils.POINTS2[0] - f2, BitmapUtils.POINTS2[1] - f3, BitmapUtils.POINTS2[0] + f2, BitmapUtils.POINTS2[1] + f3);
            this.mCropOverlayView.resetCropOverlayView();
            this.mCropOverlayView.setCropWindowRect(BitmapUtils.RECT);
            applyImageMatrix((float) getWidth(), (float) getHeight(), true, false);
            handleCropWindowChanged(false, false);
            this.mCropOverlayView.fixCurrentCropWindowRect();
        }
    }

    public void flipImageHorizontally() {
        this.mFlipHorizontally = !this.mFlipHorizontally;
        applyImageMatrix((float) getWidth(), (float) getHeight(), true, false);
    }

    public void flipImageVertically() {
        this.mFlipVertically = !this.mFlipVertically;
        applyImageMatrix((float) getWidth(), (float) getHeight(), true, false);
    }

    /* access modifiers changed from: package-private */
    public void onSetImageUriAsyncComplete(BitmapLoadingWorkerTask.Result result) {
        this.mBitmapLoadingWorkerTask = null;
        setProgressBarVisibility();
        if (result.error == null) {
            this.mInitialDegreesRotated = result.degreesRotated;
            setBitmap(result.bitmap, 0, result.uri, result.loadSampleSize, result.degreesRotated);
        }
        OnSetImageUriCompleteListener onSetImageUriCompleteListener = this.mOnSetImageUriCompleteListener;
        if (onSetImageUriCompleteListener != null) {
            onSetImageUriCompleteListener.onSetImageUriComplete(this, result.uri, result.error);
        }
    }

    /* access modifiers changed from: package-private */
    public void onImageCroppingAsyncComplete(BitmapCroppingWorkerTask.Result result) {
        this.mBitmapCroppingWorkerTask = null;
        setProgressBarVisibility();
        OnCropImageCompleteListener onCropImageCompleteListener = this.mOnCropImageCompleteListener;
        if (onCropImageCompleteListener != null) {
            onCropImageCompleteListener.onCropImageComplete(this, new CropResult(this.mBitmap, this.mLoadedImageUri, result.bitmap, result.uri, result.error, getCropPoints(), getCropRect(), getWholeImageRect(), getRotatedDegrees(), result.sampleSize));
        }
    }

    private void setBitmap(Bitmap bitmap, int i2, Uri uri, int i3, int i4) {
        Bitmap bitmap2 = this.mBitmap;
        if (bitmap2 == null || !bitmap2.equals(bitmap)) {
            this.mImageView.clearAnimation();
            clearImageInt();
            this.mBitmap = bitmap;
            this.mImageView.setImageBitmap(this.mBitmap);
            this.mLoadedImageUri = uri;
            this.mImageResource = i2;
            this.mLoadedSampleSize = i3;
            this.mDegreesRotated = i4;
            applyImageMatrix((float) getWidth(), (float) getHeight(), true, false);
            CropOverlayView cropOverlayView = this.mCropOverlayView;
            if (cropOverlayView != null) {
                cropOverlayView.resetCropOverlayView();
                setCropOverlayVisibility();
            }
        }
    }

    private void clearImageInt() {
        if (this.mBitmap != null && (this.mImageResource > 0 || this.mLoadedImageUri != null)) {
            this.mBitmap.recycle();
        }
        this.mBitmap = null;
        this.mImageResource = 0;
        this.mLoadedImageUri = null;
        this.mLoadedSampleSize = 1;
        this.mDegreesRotated = 0;
        this.mZoom = 1.0f;
        this.mZoomOffsetX = 0.0f;
        this.mZoomOffsetY = 0.0f;
        this.mImageMatrix.reset();
        this.mSaveInstanceStateBitmapUri = null;
        this.mImageView.setImageBitmap((Bitmap) null);
        setCropOverlayVisibility();
    }

    public void startCropWorkerTask(int i2, int i3, RequestSizeOptions requestSizeOptions, Uri uri, Bitmap.CompressFormat compressFormat, int i4) {
        CropImageView cropImageView;
        RequestSizeOptions requestSizeOptions2 = requestSizeOptions;
        if (this.mBitmap != null) {
            this.mImageView.clearAnimation();
            WeakReference<BitmapCroppingWorkerTask> weakReference = this.mBitmapCroppingWorkerTask;
            BitmapCroppingWorkerTask bitmapCroppingWorkerTask = weakReference != null ? (BitmapCroppingWorkerTask) weakReference.get() : null;
            if (bitmapCroppingWorkerTask != null) {
                bitmapCroppingWorkerTask.cancel(true);
            }
            int i5 = requestSizeOptions2 != RequestSizeOptions.NONE ? i2 : 0;
            int i6 = requestSizeOptions2 != RequestSizeOptions.NONE ? i3 : 0;
            int width = this.mBitmap.getWidth() * this.mLoadedSampleSize;
            int height = this.mBitmap.getHeight();
            int i7 = this.mLoadedSampleSize;
            int i8 = height * i7;
            if (this.mLoadedImageUri == null || (i7 <= 1 && requestSizeOptions2 != RequestSizeOptions.SAMPLING)) {
                BitmapCroppingWorkerTask bitmapCroppingWorkerTask2 = r0;
                BitmapCroppingWorkerTask bitmapCroppingWorkerTask3 = new BitmapCroppingWorkerTask(this, this.mBitmap, getCropPoints(), this.mDegreesRotated, this.mCropOverlayView.isFixAspectRatio(), this.mCropOverlayView.getAspectRatioX(), this.mCropOverlayView.getAspectRatioY(), i5, i6, this.mFlipHorizontally, this.mFlipVertically, requestSizeOptions, uri, compressFormat, i4);
                cropImageView = this;
                cropImageView.mBitmapCroppingWorkerTask = new WeakReference<>(bitmapCroppingWorkerTask2);
            } else {
                BitmapCroppingWorkerTask bitmapCroppingWorkerTask4 = r0;
                BitmapCroppingWorkerTask bitmapCroppingWorkerTask5 = new BitmapCroppingWorkerTask(this, this.mLoadedImageUri, getCropPoints(), this.mDegreesRotated, width, i8, this.mCropOverlayView.isFixAspectRatio(), this.mCropOverlayView.getAspectRatioX(), this.mCropOverlayView.getAspectRatioY(), i5, i6, this.mFlipHorizontally, this.mFlipVertically, requestSizeOptions, uri, compressFormat, i4);
                this.mBitmapCroppingWorkerTask = new WeakReference<>(bitmapCroppingWorkerTask4);
                cropImageView = this;
            }
            ((BitmapCroppingWorkerTask) cropImageView.mBitmapCroppingWorkerTask.get()).execute(new Void[0]);
            setProgressBarVisibility();
            return;
        }
    }

    public Parcelable onSaveInstanceState() {
        BitmapLoadingWorkerTask bitmapLoadingWorkerTask;
        if (this.mLoadedImageUri == null && this.mBitmap == null && this.mImageResource <= 0) {
            return super.onSaveInstanceState();
        }
        Bundle bundle = new Bundle();
        Uri uri = this.mLoadedImageUri;
        if (this.mSaveBitmapToInstanceState && uri == null && this.mImageResource <= 0) {
            uri = BitmapUtils.writeTempStateStoreBitmap(getContext(), this.mBitmap, this.mSaveInstanceStateBitmapUri);
            this.mSaveInstanceStateBitmapUri = uri;
        }
        if (!(uri == null || this.mBitmap == null)) {
            String uuid = UUID.randomUUID().toString();
            BitmapUtils.mStateBitmap = new Pair<>(uuid, new WeakReference(this.mBitmap));
            bundle.putString("LOADED_IMAGE_STATE_BITMAP_KEY", uuid);
        }
        WeakReference<BitmapLoadingWorkerTask> weakReference = this.mBitmapLoadingWorkerTask;
        if (!(weakReference == null || (bitmapLoadingWorkerTask = (BitmapLoadingWorkerTask) weakReference.get()) == null)) {
            bundle.putParcelable("LOADING_IMAGE_URI", bitmapLoadingWorkerTask.getUri());
        }
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putParcelable("LOADED_IMAGE_URI", uri);
        bundle.putInt("LOADED_IMAGE_RESOURCE", this.mImageResource);
        bundle.putInt("LOADED_SAMPLE_SIZE", this.mLoadedSampleSize);
        bundle.putInt("DEGREES_ROTATED", this.mDegreesRotated);
        bundle.putParcelable("INITIAL_CROP_RECT", this.mCropOverlayView.getInitialCropWindowRect());
        BitmapUtils.RECT.set(this.mCropOverlayView.getCropWindowRect());
        this.mImageMatrix.invert(this.mImageInverseMatrix);
        this.mImageInverseMatrix.mapRect(BitmapUtils.RECT);
        bundle.putParcelable("CROP_WINDOW_RECT", BitmapUtils.RECT);
        bundle.putString("CROP_SHAPE", this.mCropOverlayView.getCropShape().name());
        bundle.putBoolean("CROP_AUTO_ZOOM_ENABLED", this.mAutoZoomEnabled);
        bundle.putInt("CROP_MAX_ZOOM", this.mMaxZoom);
        bundle.putBoolean("CROP_FLIP_HORIZONTALLY", this.mFlipHorizontally);
        bundle.putBoolean("CROP_FLIP_VERTICALLY", this.mFlipVertically);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            if (this.mBitmapLoadingWorkerTask == null && this.mLoadedImageUri == null && this.mBitmap == null && this.mImageResource == 0) {
                Uri uri = (Uri) bundle.getParcelable("LOADED_IMAGE_URI");
                if (uri != null) {
                    String string = bundle.getString("LOADED_IMAGE_STATE_BITMAP_KEY");
                    if (string != null) {
                        Bitmap bitmap = (BitmapUtils.mStateBitmap == null || !((String) BitmapUtils.mStateBitmap.first).equals(string)) ? null : (Bitmap) ((WeakReference) BitmapUtils.mStateBitmap.second).get();
                        BitmapUtils.mStateBitmap = null;
                        if (bitmap != null && !bitmap.isRecycled()) {
                            setBitmap(bitmap, 0, uri, bundle.getInt("LOADED_SAMPLE_SIZE"), 0);
                        }
                    }
                    if (this.mLoadedImageUri == null) {
                        setImageUriAsync(uri);
                    }
                } else {
                    int i2 = bundle.getInt("LOADED_IMAGE_RESOURCE");
                    if (i2 > 0) {
                        setImageResource(i2);
                    } else {
                        Uri uri2 = (Uri) bundle.getParcelable("LOADING_IMAGE_URI");
                        if (uri2 != null) {
                            setImageUriAsync(uri2);
                        }
                    }
                }
                int i3 = bundle.getInt("DEGREES_ROTATED");
                this.mRestoreDegreesRotated = i3;
                this.mDegreesRotated = i3;
                Rect rect = (Rect) bundle.getParcelable("INITIAL_CROP_RECT");
                if (rect != null && (rect.width() > 0 || rect.height() > 0)) {
                    this.mCropOverlayView.setInitialCropWindowRect(rect);
                }
                RectF rectF = (RectF) bundle.getParcelable("CROP_WINDOW_RECT");
                if (rectF != null && (rectF.width() > 0.0f || rectF.height() > 0.0f)) {
                    this.mRestoreCropWindowRect = rectF;
                }
                this.mCropOverlayView.setCropShape(CropShape.valueOf(bundle.getString("CROP_SHAPE")));
                this.mAutoZoomEnabled = bundle.getBoolean("CROP_AUTO_ZOOM_ENABLED");
                this.mMaxZoom = bundle.getInt("CROP_MAX_ZOOM");
                this.mFlipHorizontally = bundle.getBoolean("CROP_FLIP_HORIZONTALLY");
                this.mFlipVertically = bundle.getBoolean("CROP_FLIP_VERTICALLY");
            }
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            if (size2 == 0) {
                size2 = bitmap.getHeight();
            }
            double width = size < this.mBitmap.getWidth() ? ((double) size) / ((double) this.mBitmap.getWidth()) : Double.POSITIVE_INFINITY;
            double height = size2 < this.mBitmap.getHeight() ? ((double) size2) / ((double) this.mBitmap.getHeight()) : Double.POSITIVE_INFINITY;
            if (width == Double.POSITIVE_INFINITY && height == Double.POSITIVE_INFINITY) {
                i5 = this.mBitmap.getWidth();
                i4 = this.mBitmap.getHeight();
            } else if (width <= height) {
                i4 = (int) (((double) this.mBitmap.getHeight()) * width);
                i5 = size;
            } else {
                i5 = (int) (((double) this.mBitmap.getWidth()) * height);
                i4 = size2;
            }
            int onMeasureSpec = getOnMeasureSpec(mode, size, i5);
            int onMeasureSpec2 = getOnMeasureSpec(mode2, size2, i4);
            this.mLayoutWidth = onMeasureSpec;
            this.mLayoutHeight = onMeasureSpec2;
            setMeasuredDimension(this.mLayoutWidth, this.mLayoutHeight);
            return;
        }
        setMeasuredDimension(size, size2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.mLayoutWidth <= 0 || this.mLayoutHeight <= 0) {
            updateImageBounds(true);
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = this.mLayoutWidth;
        layoutParams.height = this.mLayoutHeight;
        setLayoutParams(layoutParams);
        if (this.mBitmap != null) {
            float f2 = (float) (i4 - i2);
            float f3 = (float) (i5 - i3);
            applyImageMatrix(f2, f3, true, false);
            if (this.mRestoreCropWindowRect != null) {
                int i6 = this.mRestoreDegreesRotated;
                if (i6 != this.mInitialDegreesRotated) {
                    this.mDegreesRotated = i6;
                    applyImageMatrix(f2, f3, true, false);
                }
                this.mImageMatrix.mapRect(this.mRestoreCropWindowRect);
                this.mCropOverlayView.setCropWindowRect(this.mRestoreCropWindowRect);
                handleCropWindowChanged(false, false);
                this.mCropOverlayView.fixCurrentCropWindowRect();
                this.mRestoreCropWindowRect = null;
            } else if (this.mSizeChanged) {
                this.mSizeChanged = false;
                handleCropWindowChanged(false, false);
            }
        } else {
            updateImageBounds(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.mSizeChanged = i4 > 0 && i5 > 0;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleCropWindowChanged(boolean r11, boolean r12) {
        /*
            r10 = this;
            int r0 = r10.getWidth()
            int r1 = r10.getHeight()
            android.graphics.Bitmap r2 = r10.mBitmap
            if (r2 == 0) goto L_0x00f8
            if (r0 <= 0) goto L_0x00f8
            if (r1 <= 0) goto L_0x00f8
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropOverlayView r2 = r10.mCropOverlayView
            android.graphics.RectF r2 = r2.getCropWindowRect()
            r3 = 0
            if (r11 == 0) goto L_0x003a
            float r11 = r2.left
            int r11 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r11 < 0) goto L_0x0033
            float r11 = r2.top
            int r11 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r11 < 0) goto L_0x0033
            float r11 = r2.right
            float r12 = (float) r0
            int r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            if (r11 > 0) goto L_0x0033
            float r11 = r2.bottom
            float r12 = (float) r1
            int r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            if (r11 <= 0) goto L_0x00f8
        L_0x0033:
            float r11 = (float) r0
            float r12 = (float) r1
            r0 = 0
            r10.applyImageMatrix(r11, r12, r0, r0)
            return
        L_0x003a:
            boolean r11 = r10.mAutoZoomEnabled
            r4 = 1065353216(0x3f800000, float:1.0)
            if (r11 != 0) goto L_0x0046
            float r11 = r10.mZoom
            int r11 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r11 <= 0) goto L_0x00f8
        L_0x0046:
            float r11 = r10.mZoom
            int r5 = r10.mMaxZoom
            float r5 = (float) r5
            int r11 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r11 >= 0) goto L_0x0088
            float r11 = r2.width()
            float r5 = (float) r0
            r6 = 1056964608(0x3f000000, float:0.5)
            float r7 = r5 * r6
            int r11 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r11 >= 0) goto L_0x0088
            float r11 = r2.height()
            float r7 = (float) r1
            float r6 = r6 * r7
            int r11 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r11 >= 0) goto L_0x0088
            int r11 = r10.mMaxZoom
            float r11 = (float) r11
            float r6 = r2.width()
            float r8 = r10.mZoom
            float r6 = r6 / r8
            r8 = 1059313418(0x3f23d70a, float:0.64)
            float r6 = r6 / r8
            float r5 = r5 / r6
            float r6 = r2.height()
            float r9 = r10.mZoom
            float r6 = r6 / r9
            float r6 = r6 / r8
            float r7 = r7 / r6
            float r5 = java.lang.Math.min(r5, r7)
            float r11 = java.lang.Math.min(r11, r5)
            goto L_0x0089
        L_0x0088:
            r11 = 0
        L_0x0089:
            float r5 = r10.mZoom
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 <= 0) goto L_0x00c6
            float r5 = r2.width()
            float r6 = (float) r0
            r7 = 1059481190(0x3f266666, float:0.65)
            float r8 = r6 * r7
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 > 0) goto L_0x00a8
            float r5 = r2.height()
            float r8 = (float) r1
            float r8 = r8 * r7
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 <= 0) goto L_0x00c6
        L_0x00a8:
            float r11 = r2.width()
            float r5 = r10.mZoom
            float r11 = r11 / r5
            r5 = 1057132380(0x3f028f5c, float:0.51)
            float r11 = r11 / r5
            float r6 = r6 / r11
            float r11 = (float) r1
            float r2 = r2.height()
            float r7 = r10.mZoom
            float r2 = r2 / r7
            float r2 = r2 / r5
            float r11 = r11 / r2
            float r11 = java.lang.Math.min(r6, r11)
            float r11 = java.lang.Math.max(r4, r11)
        L_0x00c6:
            boolean r2 = r10.mAutoZoomEnabled
            if (r2 != 0) goto L_0x00cc
            r11 = 1065353216(0x3f800000, float:1.0)
        L_0x00cc:
            int r2 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x00f8
            float r2 = r10.mZoom
            int r2 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x00f8
            if (r12 == 0) goto L_0x00f0
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageAnimation r2 = r10.mAnimation
            if (r2 != 0) goto L_0x00e7
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageAnimation r2 = new com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageAnimation
            android.widget.ImageView r3 = r10.mImageView
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropOverlayView r4 = r10.mCropOverlayView
            r2.<init>(r3, r4)
            r10.mAnimation = r2
        L_0x00e7:
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageAnimation r2 = r10.mAnimation
            float[] r3 = r10.mImagePoints
            android.graphics.Matrix r4 = r10.mImageMatrix
            r2.setStartState(r3, r4)
        L_0x00f0:
            r10.mZoom = r11
            float r11 = (float) r0
            float r0 = (float) r1
            r1 = 1
            r10.applyImageMatrix(r11, r0, r1, r12)
        L_0x00f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageView.handleCropWindowChanged(boolean, boolean):void");
    }

    private void applyImageMatrix(float f2, float f3, boolean z, boolean z2) {
        float f4;
        if (this.mBitmap != null) {
            float f5 = 0.0f;
            if (f2 > 0.0f && f3 > 0.0f) {
                this.mImageMatrix.invert(this.mImageInverseMatrix);
                RectF cropWindowRect = this.mCropOverlayView.getCropWindowRect();
                this.mImageInverseMatrix.mapRect(cropWindowRect);
                this.mImageMatrix.reset();
                this.mImageMatrix.postTranslate((f2 - ((float) this.mBitmap.getWidth())) / 2.0f, (f3 - ((float) this.mBitmap.getHeight())) / 2.0f);
                mapImagePointsByImageMatrix();
                int i2 = this.mDegreesRotated;
                if (i2 > 0) {
                    this.mImageMatrix.postRotate((float) i2, BitmapUtils.getRectCenterX(this.mImagePoints), BitmapUtils.getRectCenterY(this.mImagePoints));
                    mapImagePointsByImageMatrix();
                }
                float min = Math.min(f2 / BitmapUtils.getRectWidth(this.mImagePoints), f3 / BitmapUtils.getRectHeight(this.mImagePoints));
                if (this.mScaleType == ScaleType.FIT_CENTER || ((this.mScaleType == ScaleType.CENTER_INSIDE && min < 1.0f) || (min > 1.0f && this.mAutoZoomEnabled))) {
                    this.mImageMatrix.postScale(min, min, BitmapUtils.getRectCenterX(this.mImagePoints), BitmapUtils.getRectCenterY(this.mImagePoints));
                    mapImagePointsByImageMatrix();
                }
                float f6 = this.mFlipHorizontally ? -this.mZoom : this.mZoom;
                float f7 = this.mFlipVertically ? -this.mZoom : this.mZoom;
                this.mImageMatrix.postScale(f6, f7, BitmapUtils.getRectCenterX(this.mImagePoints), BitmapUtils.getRectCenterY(this.mImagePoints));
                mapImagePointsByImageMatrix();
                this.mImageMatrix.mapRect(cropWindowRect);
                if (z) {
                    if (f2 > BitmapUtils.getRectWidth(this.mImagePoints)) {
                        f4 = 0.0f;
                    } else {
                        f4 = Math.max(Math.min((f2 / 2.0f) - cropWindowRect.centerX(), -BitmapUtils.getRectLeft(this.mImagePoints)), ((float) getWidth()) - BitmapUtils.getRectRight(this.mImagePoints)) / f6;
                    }
                    this.mZoomOffsetX = f4;
                    if (f3 <= BitmapUtils.getRectHeight(this.mImagePoints)) {
                        f5 = Math.max(Math.min((f3 / 2.0f) - cropWindowRect.centerY(), -BitmapUtils.getRectTop(this.mImagePoints)), ((float) getHeight()) - BitmapUtils.getRectBottom(this.mImagePoints)) / f7;
                    }
                    this.mZoomOffsetY = f5;
                } else {
                    this.mZoomOffsetX = Math.min(Math.max(this.mZoomOffsetX * f6, -cropWindowRect.left), (-cropWindowRect.right) + f2) / f6;
                    this.mZoomOffsetY = Math.min(Math.max(this.mZoomOffsetY * f7, -cropWindowRect.top), (-cropWindowRect.bottom) + f3) / f7;
                }
                this.mImageMatrix.postTranslate(this.mZoomOffsetX * f6, this.mZoomOffsetY * f7);
                cropWindowRect.offset(this.mZoomOffsetX * f6, this.mZoomOffsetY * f7);
                this.mCropOverlayView.setCropWindowRect(cropWindowRect);
                mapImagePointsByImageMatrix();
                this.mCropOverlayView.invalidate();
                if (z2) {
                    this.mAnimation.setEndState(this.mImagePoints, this.mImageMatrix);
                    this.mImageView.startAnimation(this.mAnimation);
                } else {
                    this.mImageView.setImageMatrix(this.mImageMatrix);
                }
                updateImageBounds(false);
            }
        }
    }

    private void mapImagePointsByImageMatrix() {
        float[] fArr = this.mImagePoints;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = (float) this.mBitmap.getWidth();
        float[] fArr2 = this.mImagePoints;
        fArr2[3] = 0.0f;
        fArr2[4] = (float) this.mBitmap.getWidth();
        this.mImagePoints[5] = (float) this.mBitmap.getHeight();
        float[] fArr3 = this.mImagePoints;
        fArr3[6] = 0.0f;
        fArr3[7] = (float) this.mBitmap.getHeight();
        this.mImageMatrix.mapPoints(this.mImagePoints);
    }

    private static int getOnMeasureSpec(int i2, int i3, int i4) {
        if (i2 == 1073741824) {
            return i3;
        }
        return i2 == Integer.MIN_VALUE ? Math.min(i4, i3) : i4;
    }

    private void setCropOverlayVisibility() {
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        if (cropOverlayView != null) {
            cropOverlayView.setVisibility((!this.mShowCropOverlay || this.mBitmap == null) ? 4 : 0);
        }
    }

    private void setProgressBarVisibility() {
        int i2 = 0;
        boolean z = this.mShowProgressBar && ((this.mBitmap == null && this.mBitmapLoadingWorkerTask != null) || this.mBitmapCroppingWorkerTask != null);
        ProgressBar progressBar = this.mProgressBar;
        if (!z) {
            i2 = 4;
        }
        progressBar.setVisibility(i2);
    }

    private void updateImageBounds(boolean z) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && !z) {
            this.mCropOverlayView.setCropWindowLimits((float) getWidth(), (float) getHeight(), ((float) (bitmap.getWidth() * this.mLoadedSampleSize)) / BitmapUtils.getRectWidth(this.mImagePoints), ((float) (this.mBitmap.getHeight() * this.mLoadedSampleSize)) / BitmapUtils.getRectHeight(this.mImagePoints));
        }
        this.mCropOverlayView.setBounds(z ? null : this.mImagePoints, getWidth(), getHeight());
    }

    public static class CropResult {
        private final Bitmap mBitmap;
        private final float[] mCropPoints;
        private final Rect mCropRect;
        private final Exception mError;
        private final Bitmap mOriginalBitmap;
        private final Uri mOriginalUri;
        private final int mRotation;
        private final int mSampleSize;
        private final Uri mUri;
        private final Rect mWholeImageRect;

        CropResult(Bitmap bitmap, Uri uri, Bitmap bitmap2, Uri uri2, Exception exc, float[] fArr, Rect rect, Rect rect2, int i2, int i3) {
            this.mOriginalBitmap = bitmap;
            this.mOriginalUri = uri;
            this.mBitmap = bitmap2;
            this.mUri = uri2;
            this.mError = exc;
            this.mCropPoints = fArr;
            this.mCropRect = rect;
            this.mWholeImageRect = rect2;
            this.mRotation = i2;
            this.mSampleSize = i3;
        }

        public Bitmap getOriginalBitmap() {
            return this.mOriginalBitmap;
        }

        public Uri getOriginalUri() {
            return this.mOriginalUri;
        }

        public boolean isSuccessful() {
            return this.mError == null;
        }

        public Bitmap getBitmap() {
            return this.mBitmap;
        }

        public Uri getUri() {
            return this.mUri;
        }

        public Exception getError() {
            return this.mError;
        }

        public float[] getCropPoints() {
            return this.mCropPoints;
        }

        public Rect getCropRect() {
            return this.mCropRect;
        }

        public Rect getWholeImageRect() {
            return this.mWholeImageRect;
        }

        public int getRotation() {
            return this.mRotation;
        }

        public int getSampleSize() {
            return this.mSampleSize;
        }
    }
}
