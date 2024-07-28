package com.business.merchant_payments.mapqr.vision.camera;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.utilities.b;
import com.google.android.gms.common.images.a;
import java.io.IOException;

public class CameraSourcePreview extends ViewGroup {
    public static final String TAG = "CameraSourcePreview";
    public CameraSource mCameraSource;
    public Context mContext;
    public GraphicOverlay mOverlay;
    public boolean mStartRequested = false;
    public boolean mSurfaceAvailable = false;
    public SurfaceView mSurfaceView;

    public CameraSourcePreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        SurfaceView surfaceView = new SurfaceView(context);
        this.mSurfaceView = surfaceView;
        surfaceView.getHolder().addCallback(new SurfaceCallback());
        addView(this.mSurfaceView);
    }

    public void start(CameraSource cameraSource) throws IOException, SecurityException {
        if (cameraSource == null) {
            stop();
        }
        this.mCameraSource = cameraSource;
        if (cameraSource != null) {
            Context context = this.mContext;
            if (context instanceof AppCompatActivity) {
                this.mStartRequested = true;
                if (b.c((AppCompatActivity) context)) {
                    startIfReady();
                } else {
                    b.d((AppCompatActivity) this.mContext);
                }
            }
        }
    }

    public void start(CameraSource cameraSource, GraphicOverlay graphicOverlay) throws IOException, SecurityException {
        this.mOverlay = graphicOverlay;
        start(cameraSource);
    }

    public void stop() {
        CameraSource cameraSource = this.mCameraSource;
        if (cameraSource != null) {
            cameraSource.stop();
        }
    }

    public void release() {
        CameraSource cameraSource = this.mCameraSource;
        if (cameraSource != null) {
            cameraSource.release();
            this.mCameraSource = null;
        }
    }

    /* access modifiers changed from: private */
    public void startIfReady() throws IOException, SecurityException {
        if (this.mStartRequested && this.mSurfaceAvailable) {
            this.mCameraSource.start(this.mSurfaceView.getHolder());
            if (!(this.mOverlay == null || this.mCameraSource.getPreviewSize() == null)) {
                a previewSize = this.mCameraSource.getPreviewSize();
                int min = Math.min(previewSize.f8720a, previewSize.f8721b);
                int max = Math.max(previewSize.f8720a, previewSize.f8721b);
                if (isPortraitMode()) {
                    this.mOverlay.setCameraInfo(min, max, this.mCameraSource.getCameraFacing());
                } else {
                    this.mOverlay.setCameraInfo(max, min, this.mCameraSource.getCameraFacing());
                }
                this.mOverlay.clear();
            }
            this.mStartRequested = false;
        }
    }

    public class SurfaceCallback implements SurfaceHolder.Callback {
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        }

        public SurfaceCallback() {
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            boolean unused = CameraSourcePreview.this.mSurfaceAvailable = true;
            try {
                CameraSourcePreview.this.startIfReady();
            } catch (SecurityException e2) {
                LogUtility.e(CameraSourcePreview.TAG, "Do not have permission to start the camera".concat(String.valueOf(e2)));
            } catch (IOException e3) {
                LogUtility.e(CameraSourcePreview.TAG, "Could not start camera source.".concat(String.valueOf(e3)));
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            boolean unused = CameraSourcePreview.this.mSurfaceAvailable = false;
        }
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        CameraSource cameraSource = this.mCameraSource;
        if (cameraSource != null) {
            cameraSource.getPreviewSize();
        }
        isPortraitMode();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            getChildAt(i8).layout(0, 0, i6, i7);
        }
        try {
            if (!(this.mContext instanceof AppCompatActivity)) {
                return;
            }
            if (b.c((AppCompatActivity) this.mContext)) {
                startIfReady();
            } else {
                b.d((AppCompatActivity) this.mContext);
            }
        } catch (SecurityException e2) {
            LogUtility.e(TAG, "Do not have permission to start the camera".concat(String.valueOf(e2)));
        } catch (IOException e3) {
            LogUtility.e(TAG, "Could not start camera source.".concat(String.valueOf(e3)));
        }
    }

    private boolean isPortraitMode() {
        int i2 = this.mContext.getResources().getConfiguration().orientation;
        if (i2 == 2) {
            return false;
        }
        if (i2 == 1) {
            return true;
        }
        LogUtility.d(TAG, "isPortraitMode returning false by default");
        return false;
    }
}
