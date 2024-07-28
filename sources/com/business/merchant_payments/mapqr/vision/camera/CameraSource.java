package com.business.merchant_payments.mapqr.vision.camera;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.os.SystemClock;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.business.common_module.utilities.LogUtility;
import com.google.android.gms.common.images.a;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.lang.Thread;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CameraSource {
    public static final float ASPECT_RATIO_TOLERANCE = 0.01f;
    public static final int CAMERA_FACING_BACK = 0;
    public static final int CAMERA_FACING_FRONT = 1;
    public static final int DUMMY_TEXTURE_NAME = 100;
    public static final String TAG = "OpenCameraSource";
    public Map<byte[], ByteBuffer> mBytesToByteBuffer;
    public Camera mCamera;
    public final Object mCameraLock;
    public Context mContext;
    public SurfaceTexture mDummySurfaceTexture;
    public SurfaceView mDummySurfaceView;
    public int mFacing;
    public String mFlashMode;
    public String mFocusMode;
    public FrameProcessingRunnable mFrameProcessor;
    public a mPreviewSize;
    public Thread mProcessingThread;
    public float mRequestedFps;
    public int mRequestedPreviewHeight;
    public int mRequestedPreviewWidth;
    public int mRotation;

    public interface AutoFocusCallback {
        void onAutoFocus(boolean z);
    }

    public interface AutoFocusMoveCallback {
        void onAutoFocusMoving(boolean z);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FlashMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusMode {
    }

    public interface PictureCallback {
        void onPictureTaken(byte[] bArr);
    }

    public interface ShutterCallback {
        void onShutter();
    }

    public static class Builder {
        public CameraSource mCameraSource;
        public final com.google.android.gms.vision.a<?> mDetector;

        public Builder(Context context, com.google.android.gms.vision.a<?> aVar) {
            CameraSource cameraSource = new CameraSource();
            this.mCameraSource = cameraSource;
            if (context == null) {
                throw new IllegalArgumentException("No context supplied.");
            } else if (aVar != null) {
                this.mDetector = aVar;
                Context unused = cameraSource.mContext = context;
            } else {
                throw new IllegalArgumentException("No detector supplied.");
            }
        }

        public Builder setRequestedFps(float f2) {
            if (f2 > 0.0f) {
                float unused = this.mCameraSource.mRequestedFps = f2;
                return this;
            }
            throw new IllegalArgumentException("Invalid fps: ".concat(String.valueOf(f2)));
        }

        public Builder setFocusMode(String str) {
            String unused = this.mCameraSource.mFocusMode = str;
            return this;
        }

        public Builder setFlashMode(String str) {
            String unused = this.mCameraSource.mFlashMode = str;
            return this;
        }

        public Builder setRequestedPreviewSize(int i2, int i3) {
            if (i2 <= 0 || i2 > 1000000 || i3 <= 0 || i3 > 1000000) {
                throw new IllegalArgumentException("Invalid preview size: " + i2 + "x" + i3);
            }
            int unused = this.mCameraSource.mRequestedPreviewWidth = i2;
            int unused2 = this.mCameraSource.mRequestedPreviewHeight = i3;
            return this;
        }

        public Builder setFacing(int i2) {
            if (i2 == 0 || i2 == 1) {
                int unused = this.mCameraSource.mFacing = i2;
                return this;
            }
            throw new IllegalArgumentException("Invalid camera: ".concat(String.valueOf(i2)));
        }

        public CameraSource build() {
            CameraSource cameraSource = this.mCameraSource;
            cameraSource.getClass();
            FrameProcessingRunnable unused = cameraSource.mFrameProcessor = new FrameProcessingRunnable(this.mDetector);
            return this.mCameraSource;
        }
    }

    public void release() {
        synchronized (this.mCameraLock) {
            stop();
            this.mFrameProcessor.release();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:11|12|13|14|(1:16)(1:17)|18|19|20) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001b */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.business.merchant_payments.mapqr.vision.camera.CameraSource start() throws java.io.IOException {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mCameraLock
            monitor-enter(r0)
            android.hardware.Camera r1 = r3.mCamera     // Catch:{ all -> 0x005d }
            if (r1 == 0) goto L_0x0015
            android.content.Context r1 = r3.mContext     // Catch:{ all -> 0x005d }
            java.lang.String r2 = "android.permission.CAMERA"
            int r1 = androidx.core.app.a.a((android.content.Context) r1, (java.lang.String) r2)     // Catch:{ all -> 0x005d }
            if (r1 == 0) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            return r3
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            return r3
        L_0x0015:
            android.hardware.Camera r1 = r3.createCamera()     // Catch:{ Exception -> 0x001b }
            r3.mCamera = r1     // Catch:{ Exception -> 0x001b }
        L_0x001b:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x005d }
            r2 = 11
            if (r1 < r2) goto L_0x0030
            android.graphics.SurfaceTexture r1 = new android.graphics.SurfaceTexture     // Catch:{ all -> 0x005d }
            r2 = 100
            r1.<init>(r2)     // Catch:{ all -> 0x005d }
            r3.mDummySurfaceTexture = r1     // Catch:{ all -> 0x005d }
            android.hardware.Camera r2 = r3.mCamera     // Catch:{ all -> 0x005d }
            r2.setPreviewTexture(r1)     // Catch:{ all -> 0x005d }
            goto L_0x0042
        L_0x0030:
            android.view.SurfaceView r1 = new android.view.SurfaceView     // Catch:{ all -> 0x005d }
            android.content.Context r2 = r3.mContext     // Catch:{ all -> 0x005d }
            r1.<init>(r2)     // Catch:{ all -> 0x005d }
            r3.mDummySurfaceView = r1     // Catch:{ all -> 0x005d }
            android.hardware.Camera r2 = r3.mCamera     // Catch:{ all -> 0x005d }
            android.view.SurfaceHolder r1 = r1.getHolder()     // Catch:{ all -> 0x005d }
            r2.setPreviewDisplay(r1)     // Catch:{ all -> 0x005d }
        L_0x0042:
            android.hardware.Camera r1 = r3.mCamera     // Catch:{ all -> 0x005d }
            r1.startPreview()     // Catch:{ all -> 0x005d }
            java.lang.Thread r1 = new java.lang.Thread     // Catch:{ all -> 0x005d }
            com.business.merchant_payments.mapqr.vision.camera.CameraSource$FrameProcessingRunnable r2 = r3.mFrameProcessor     // Catch:{ all -> 0x005d }
            r1.<init>(r2)     // Catch:{ all -> 0x005d }
            r3.mProcessingThread = r1     // Catch:{ all -> 0x005d }
            com.business.merchant_payments.mapqr.vision.camera.CameraSource$FrameProcessingRunnable r1 = r3.mFrameProcessor     // Catch:{ all -> 0x005d }
            r2 = 1
            r1.setActive(r2)     // Catch:{ all -> 0x005d }
            java.lang.Thread r1 = r3.mProcessingThread     // Catch:{ all -> 0x005d }
            r1.start()     // Catch:{ all -> 0x005d }
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            return r3
        L_0x005d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.mapqr.vision.camera.CameraSource.start():com.business.merchant_payments.mapqr.vision.camera.CameraSource");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:11|12|13|14|15) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0037 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.business.merchant_payments.mapqr.vision.camera.CameraSource start(android.view.SurfaceHolder r3) throws java.io.IOException {
        /*
            r2 = this;
            java.lang.Object r0 = r2.mCameraLock
            monitor-enter(r0)
            android.hardware.Camera r1 = r2.mCamera     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0015
            android.content.Context r3 = r2.mContext     // Catch:{ all -> 0x0039 }
            java.lang.String r1 = "android.permission.CAMERA"
            int r3 = androidx.core.app.a.a((android.content.Context) r3, (java.lang.String) r1)     // Catch:{ all -> 0x0039 }
            if (r3 == 0) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            return r2
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            return r2
        L_0x0015:
            android.hardware.Camera r1 = r2.createCamera()     // Catch:{ Exception -> 0x0037 }
            r2.mCamera = r1     // Catch:{ Exception -> 0x0037 }
            r1.setPreviewDisplay(r3)     // Catch:{ Exception -> 0x0037 }
            android.hardware.Camera r3 = r2.mCamera     // Catch:{ Exception -> 0x0037 }
            r3.startPreview()     // Catch:{ Exception -> 0x0037 }
            java.lang.Thread r3 = new java.lang.Thread     // Catch:{ Exception -> 0x0037 }
            com.business.merchant_payments.mapqr.vision.camera.CameraSource$FrameProcessingRunnable r1 = r2.mFrameProcessor     // Catch:{ Exception -> 0x0037 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0037 }
            r2.mProcessingThread = r3     // Catch:{ Exception -> 0x0037 }
            com.business.merchant_payments.mapqr.vision.camera.CameraSource$FrameProcessingRunnable r3 = r2.mFrameProcessor     // Catch:{ Exception -> 0x0037 }
            r1 = 1
            r3.setActive(r1)     // Catch:{ Exception -> 0x0037 }
            java.lang.Thread r3 = r2.mProcessingThread     // Catch:{ Exception -> 0x0037 }
            r3.start()     // Catch:{ Exception -> 0x0037 }
        L_0x0037:
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            return r2
        L_0x0039:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.mapqr.vision.camera.CameraSource.start(android.view.SurfaceHolder):com.business.merchant_payments.mapqr.vision.camera.CameraSource");
    }

    public void stop() {
        synchronized (this.mCameraLock) {
            this.mFrameProcessor.setActive(false);
            if (this.mProcessingThread != null) {
                try {
                    this.mProcessingThread.join();
                } catch (InterruptedException unused) {
                    LogUtility.d(TAG, "Frame processing thread interrupted on release.");
                }
                this.mProcessingThread = null;
            }
            this.mBytesToByteBuffer.clear();
            if (this.mCamera != null) {
                this.mCamera.stopPreview();
                this.mCamera.setPreviewCallbackWithBuffer((Camera.PreviewCallback) null);
                try {
                    if (Build.VERSION.SDK_INT >= 11) {
                        this.mCamera.setPreviewTexture((SurfaceTexture) null);
                    } else {
                        this.mCamera.setPreviewDisplay((SurfaceHolder) null);
                    }
                } catch (Exception e2) {
                    LogUtility.e(TAG, "Failed to clear camera preview: ".concat(String.valueOf(e2)));
                }
                this.mCamera.release();
                this.mCamera = null;
            }
        }
    }

    public a getPreviewSize() {
        return this.mPreviewSize;
    }

    public int getCameraFacing() {
        return this.mFacing;
    }

    public int doZoom(float f2) {
        synchronized (this.mCameraLock) {
            if (this.mCamera == null) {
                return 0;
            }
            Camera.Parameters parameters = this.mCamera.getParameters();
            if (!parameters.isZoomSupported()) {
                LogUtility.d(TAG, "Zoom is not supported on this device");
                return 0;
            }
            int maxZoom = parameters.getMaxZoom();
            int zoom = parameters.getZoom() + 1;
            int round = Math.round(f2 > 1.0f ? ((float) zoom) + (f2 * ((float) (maxZoom / 10))) : ((float) zoom) * f2) - 1;
            if (round < 0) {
                round = 0;
            } else if (round > maxZoom) {
                round = maxZoom;
            }
            parameters.setZoom(round);
            this.mCamera.setParameters(parameters);
            return round;
        }
    }

    public void takePicture(ShutterCallback shutterCallback, PictureCallback pictureCallback) {
        synchronized (this.mCameraLock) {
            if (this.mCamera != null) {
                PictureStartCallback pictureStartCallback = new PictureStartCallback();
                ShutterCallback unused = pictureStartCallback.mDelegate = shutterCallback;
                PictureDoneCallback pictureDoneCallback = new PictureDoneCallback();
                PictureCallback unused2 = pictureDoneCallback.mDelegate = pictureCallback;
                this.mCamera.takePicture(pictureStartCallback, (Camera.PictureCallback) null, (Camera.PictureCallback) null, pictureDoneCallback);
            }
        }
    }

    public String getFocusMode() {
        return this.mFocusMode;
    }

    public boolean setFocusMode(String str) {
        synchronized (this.mCameraLock) {
            if (!(this.mCamera == null || str == null)) {
                Camera.Parameters parameters = this.mCamera.getParameters();
                if (parameters.getSupportedFocusModes().contains(str)) {
                    parameters.setFocusMode(str);
                    this.mCamera.setParameters(parameters);
                    this.mFocusMode = str;
                    return true;
                }
            }
            return false;
        }
    }

    public String getFlashMode() {
        return this.mFlashMode;
    }

    public boolean setFlashMode(String str) {
        synchronized (this.mCameraLock) {
            if (!(this.mCamera == null || str == null)) {
                Camera.Parameters parameters = this.mCamera.getParameters();
                if (parameters.getSupportedFlashModes().contains(str)) {
                    parameters.setFlashMode(str);
                    this.mCamera.setParameters(parameters);
                    this.mFlashMode = str;
                    return true;
                }
            }
            return false;
        }
    }

    public void autoFocus(AutoFocusCallback autoFocusCallback) {
        synchronized (this.mCameraLock) {
            if (this.mCamera != null) {
                CameraAutoFocusCallback cameraAutoFocusCallback = null;
                if (autoFocusCallback != null) {
                    CameraAutoFocusCallback cameraAutoFocusCallback2 = new CameraAutoFocusCallback();
                    AutoFocusCallback unused = cameraAutoFocusCallback2.mDelegate = autoFocusCallback;
                    cameraAutoFocusCallback = cameraAutoFocusCallback2;
                }
                this.mCamera.autoFocus(cameraAutoFocusCallback);
            }
        }
    }

    public void cancelAutoFocus() {
        synchronized (this.mCameraLock) {
            if (this.mCamera != null) {
                this.mCamera.cancelAutoFocus();
            }
        }
    }

    public boolean setAutoFocusMoveCallback(AutoFocusMoveCallback autoFocusMoveCallback) {
        if (Build.VERSION.SDK_INT < 16) {
            return false;
        }
        synchronized (this.mCameraLock) {
            if (this.mCamera != null) {
                CameraAutoFocusMoveCallback cameraAutoFocusMoveCallback = null;
                if (autoFocusMoveCallback != null) {
                    CameraAutoFocusMoveCallback cameraAutoFocusMoveCallback2 = new CameraAutoFocusMoveCallback();
                    AutoFocusMoveCallback unused = cameraAutoFocusMoveCallback2.mDelegate = autoFocusMoveCallback;
                    cameraAutoFocusMoveCallback = cameraAutoFocusMoveCallback2;
                }
                this.mCamera.setAutoFocusMoveCallback(cameraAutoFocusMoveCallback);
            }
        }
        return true;
    }

    public CameraSource() {
        this.mCameraLock = new Object();
        this.mFacing = 0;
        this.mRequestedFps = 30.0f;
        this.mRequestedPreviewWidth = TarConstants.EOF_BLOCK;
        this.mRequestedPreviewHeight = 768;
        this.mFocusMode = null;
        this.mFlashMode = null;
        this.mBytesToByteBuffer = new HashMap();
    }

    public class PictureStartCallback implements Camera.ShutterCallback {
        public ShutterCallback mDelegate;

        public PictureStartCallback(CameraSource cameraSource) {
        }

        public void onShutter() {
            ShutterCallback shutterCallback = this.mDelegate;
            if (shutterCallback != null) {
                shutterCallback.onShutter();
            }
        }
    }

    public class PictureDoneCallback implements Camera.PictureCallback {
        public PictureCallback mDelegate;

        public PictureDoneCallback() {
        }

        public void onPictureTaken(byte[] bArr, Camera camera) {
            PictureCallback pictureCallback = this.mDelegate;
            if (pictureCallback != null) {
                pictureCallback.onPictureTaken(bArr);
            }
            synchronized (CameraSource.this.mCameraLock) {
                if (CameraSource.this.mCamera != null) {
                    CameraSource.this.mCamera.startPreview();
                }
            }
        }
    }

    public class CameraAutoFocusCallback implements Camera.AutoFocusCallback {
        public AutoFocusCallback mDelegate;

        public CameraAutoFocusCallback(CameraSource cameraSource) {
        }

        public void onAutoFocus(boolean z, Camera camera) {
            AutoFocusCallback autoFocusCallback = this.mDelegate;
            if (autoFocusCallback != null) {
                autoFocusCallback.onAutoFocus(z);
            }
        }
    }

    public class CameraAutoFocusMoveCallback implements Camera.AutoFocusMoveCallback {
        public AutoFocusMoveCallback mDelegate;

        public CameraAutoFocusMoveCallback(CameraSource cameraSource) {
        }

        public void onAutoFocusMoving(boolean z, Camera camera) {
            AutoFocusMoveCallback autoFocusMoveCallback = this.mDelegate;
            if (autoFocusMoveCallback != null) {
                autoFocusMoveCallback.onAutoFocusMoving(z);
            }
        }
    }

    private Camera createCamera() {
        int idForRequestedCamera = getIdForRequestedCamera(this.mFacing);
        if (idForRequestedCamera != -1) {
            Camera open = Camera.open(idForRequestedCamera);
            SizePair selectSizePair = selectSizePair(open, this.mRequestedPreviewWidth, this.mRequestedPreviewHeight);
            if (selectSizePair != null) {
                a pictureSize = selectSizePair.pictureSize();
                this.mPreviewSize = selectSizePair.previewSize();
                int[] selectPreviewFpsRange = selectPreviewFpsRange(open, this.mRequestedFps);
                if (selectPreviewFpsRange != null) {
                    Camera.Parameters parameters = open.getParameters();
                    if (pictureSize != null) {
                        parameters.setPictureSize(pictureSize.f8720a, pictureSize.f8721b);
                    }
                    parameters.setPreviewSize(this.mPreviewSize.f8720a, this.mPreviewSize.f8721b);
                    parameters.setPreviewFpsRange(selectPreviewFpsRange[0], selectPreviewFpsRange[1]);
                    parameters.setPreviewFormat(17);
                    setRotation(open, parameters, idForRequestedCamera);
                    if (this.mFocusMode != null) {
                        if (parameters.getSupportedFocusModes().contains(this.mFocusMode)) {
                            parameters.setFocusMode(this.mFocusMode);
                        } else {
                            LogUtility.i(TAG, "Camera focus mode: " + this.mFocusMode + " is not supported on this device.");
                        }
                    }
                    this.mFocusMode = parameters.getFocusMode();
                    if (!(this.mFlashMode == null || parameters.getSupportedFlashModes() == null)) {
                        if (parameters.getSupportedFlashModes().contains(this.mFlashMode)) {
                            parameters.setFlashMode(this.mFlashMode);
                        } else {
                            LogUtility.i(TAG, "Camera flash mode: " + this.mFlashMode + " is not supported on this device.");
                        }
                    }
                    this.mFlashMode = parameters.getFlashMode();
                    open.setParameters(parameters);
                    open.setPreviewCallbackWithBuffer(new CameraPreviewCallback());
                    open.addCallbackBuffer(createPreviewBuffer(this.mPreviewSize));
                    open.addCallbackBuffer(createPreviewBuffer(this.mPreviewSize));
                    open.addCallbackBuffer(createPreviewBuffer(this.mPreviewSize));
                    open.addCallbackBuffer(createPreviewBuffer(this.mPreviewSize));
                    return open;
                }
                throw new RuntimeException("Could not find suitable preview frames per second range.");
            }
            throw new RuntimeException("Could not find suitable preview size.");
        }
        throw new RuntimeException("Could not find requested camera.");
    }

    public static int getIdForRequestedCamera(int i2) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i3 = 0; i3 < Camera.getNumberOfCameras(); i3++) {
            Camera.getCameraInfo(i3, cameraInfo);
            if (cameraInfo.facing == i2) {
                return i3;
            }
        }
        return -1;
    }

    public static SizePair selectSizePair(Camera camera, int i2, int i3) {
        SizePair sizePair = null;
        int i4 = Integer.MAX_VALUE;
        for (SizePair next : generateValidPreviewSizeList(camera)) {
            a previewSize = next.previewSize();
            int abs = Math.abs(previewSize.f8720a - i2) + Math.abs(previewSize.f8721b - i3);
            if (abs < i4) {
                sizePair = next;
                i4 = abs;
            }
        }
        return sizePair;
    }

    public static class SizePair {
        public a mPicture;
        public a mPreview;

        public SizePair(Camera.Size size, Camera.Size size2) {
            this.mPreview = new a(size.width, size.height);
            if (size2 != null) {
                this.mPicture = new a(size2.width, size2.height);
            }
        }

        public a previewSize() {
            return this.mPreview;
        }

        public a pictureSize() {
            return this.mPicture;
        }
    }

    public static List<SizePair> generateValidPreviewSizeList(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        ArrayList arrayList = new ArrayList();
        for (Camera.Size next : supportedPreviewSizes) {
            float f2 = ((float) next.width) / ((float) next.height);
            Iterator<Camera.Size> it2 = supportedPictureSizes.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Camera.Size next2 = it2.next();
                if (Math.abs(f2 - (((float) next2.width) / ((float) next2.height))) < 0.01f) {
                    arrayList.add(new SizePair(next, next2));
                    break;
                }
            }
        }
        if (arrayList.size() == 0) {
            LogUtility.d(TAG, "No preview sizes have a corresponding same-aspect-ratio picture size");
            for (Camera.Size sizePair : supportedPreviewSizes) {
                arrayList.add(new SizePair(sizePair, (Camera.Size) null));
            }
        }
        return arrayList;
    }

    private int[] selectPreviewFpsRange(Camera camera, float f2) {
        int i2 = (int) (f2 * 1000.0f);
        int[] iArr = null;
        int i3 = Integer.MAX_VALUE;
        for (int[] next : camera.getParameters().getSupportedPreviewFpsRange()) {
            int abs = Math.abs(i2 - next[0]) + Math.abs(i2 - next[1]);
            if (abs < i3) {
                iArr = next;
                i3 = abs;
            }
        }
        return iArr;
    }

    private void setRotation(Camera camera, Camera.Parameters parameters, int i2) {
        int i3;
        int i4;
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        int i5 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i5 = 90;
            } else if (rotation == 2) {
                i5 = AppConstants.READ_TIME_OUT;
            } else if (rotation != 3) {
                LogUtility.e(TAG, "Bad rotation value: ".concat(String.valueOf(rotation)));
            } else {
                i5 = 270;
            }
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i2, cameraInfo);
        if (cameraInfo.facing == 1) {
            i3 = (cameraInfo.orientation + i5) % 360;
            i4 = (360 - i3) % 360;
        } else {
            i3 = ((cameraInfo.orientation - i5) + 360) % 360;
            i4 = i3;
        }
        this.mRotation = i3 / 90;
        camera.setDisplayOrientation(i4);
        parameters.setRotation(i3);
    }

    private byte[] createPreviewBuffer(a aVar) {
        byte[] bArr = new byte[(((int) Math.ceil(((double) ((long) ((aVar.f8721b * aVar.f8720a) * ImageFormat.getBitsPerPixel(17)))) / 8.0d)) + 1)];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (!wrap.hasArray() || wrap.array() != bArr) {
            throw new IllegalStateException("Failed to create valid buffer for camera source.");
        }
        this.mBytesToByteBuffer.put(bArr, wrap);
        return bArr;
    }

    public class CameraPreviewCallback implements Camera.PreviewCallback {
        public CameraPreviewCallback() {
        }

        public void onPreviewFrame(byte[] bArr, Camera camera) {
            CameraSource.this.mFrameProcessor.setNextFrame(bArr, camera);
        }
    }

    public class FrameProcessingRunnable implements Runnable {
        public static final /* synthetic */ boolean $assertionsDisabled = (!CameraSource.class.desiredAssertionStatus());
        public boolean mActive = true;
        public com.google.android.gms.vision.a<?> mDetector;
        public final Object mLock = new Object();
        public ByteBuffer mPendingFrameData;
        public int mPendingFrameId = 0;
        public long mPendingTimeMillis;
        public long mStartTimeMillis = SystemClock.elapsedRealtime();

        public FrameProcessingRunnable(com.google.android.gms.vision.a<?> aVar) {
            this.mDetector = aVar;
        }

        public void release() {
            if ($assertionsDisabled || CameraSource.this.mProcessingThread.getState() == Thread.State.TERMINATED) {
                this.mDetector.a();
                this.mDetector = null;
                return;
            }
            throw new AssertionError();
        }

        public void setActive(boolean z) {
            synchronized (this.mLock) {
                this.mActive = z;
                this.mLock.notifyAll();
            }
        }

        public void setNextFrame(byte[] bArr, Camera camera) {
            synchronized (this.mLock) {
                if (this.mPendingFrameData != null) {
                    camera.addCallbackBuffer(this.mPendingFrameData.array());
                    this.mPendingFrameData = null;
                }
                if (!CameraSource.this.mBytesToByteBuffer.containsKey(bArr)) {
                    LogUtility.d(CameraSource.TAG, "Skipping frame.  Could not find ByteBuffer associated with the image data from the camera.");
                    return;
                }
                this.mPendingTimeMillis = SystemClock.elapsedRealtime() - this.mStartTimeMillis;
                this.mPendingFrameId++;
                this.mPendingFrameData = (ByteBuffer) CameraSource.this.mBytesToByteBuffer.get(bArr);
                this.mLock.notifyAll();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r6.mDetector.b(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0079, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            com.business.common_module.utilities.LogUtility.e(com.business.merchant_payments.mapqr.vision.camera.CameraSource.TAG, "Exception thrown from receiver.".concat(java.lang.String.valueOf(r0)));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0098, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0099, code lost:
            com.business.merchant_payments.mapqr.vision.camera.CameraSource.access$1800(r6.this$0).addCallbackBuffer(r2.array());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a6, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
            L_0x0000:
                java.lang.Object r0 = r6.mLock
                monitor-enter(r0)
            L_0x0003:
                boolean r1 = r6.mActive     // Catch:{ all -> 0x00a7 }
                if (r1 == 0) goto L_0x0023
                java.nio.ByteBuffer r1 = r6.mPendingFrameData     // Catch:{ all -> 0x00a7 }
                if (r1 != 0) goto L_0x0023
                java.lang.Object r1 = r6.mLock     // Catch:{ InterruptedException -> 0x0011 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0011 }
                goto L_0x0003
            L_0x0011:
                r1 = move-exception
                java.lang.String r2 = "OpenCameraSource"
                java.lang.String r3 = "Frame processing loop terminated."
                java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00a7 }
                java.lang.String r1 = r3.concat(r1)     // Catch:{ all -> 0x00a7 }
                com.business.common_module.utilities.LogUtility.d(r2, r1)     // Catch:{ all -> 0x00a7 }
                monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
                return
            L_0x0023:
                boolean r1 = r6.mActive     // Catch:{ all -> 0x00a7 }
                if (r1 != 0) goto L_0x0029
                monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
                return
            L_0x0029:
                com.google.android.gms.vision.b$a r1 = new com.google.android.gms.vision.b$a     // Catch:{ all -> 0x00a7 }
                r1.<init>()     // Catch:{ all -> 0x00a7 }
                java.nio.ByteBuffer r2 = r6.mPendingFrameData     // Catch:{ all -> 0x00a7 }
                com.business.merchant_payments.mapqr.vision.camera.CameraSource r3 = com.business.merchant_payments.mapqr.vision.camera.CameraSource.this     // Catch:{ all -> 0x00a7 }
                com.google.android.gms.common.images.a r3 = r3.mPreviewSize     // Catch:{ all -> 0x00a7 }
                int r3 = r3.f8720a     // Catch:{ all -> 0x00a7 }
                com.business.merchant_payments.mapqr.vision.camera.CameraSource r4 = com.business.merchant_payments.mapqr.vision.camera.CameraSource.this     // Catch:{ all -> 0x00a7 }
                com.google.android.gms.common.images.a r4 = r4.mPreviewSize     // Catch:{ all -> 0x00a7 }
                int r4 = r4.f8721b     // Catch:{ all -> 0x00a7 }
                r5 = 17
                com.google.android.gms.vision.b$a r1 = r1.a(r2, r3, r4, r5)     // Catch:{ all -> 0x00a7 }
                int r2 = r6.mPendingFrameId     // Catch:{ all -> 0x00a7 }
                com.google.android.gms.vision.b$a r1 = r1.a((int) r2)     // Catch:{ all -> 0x00a7 }
                long r2 = r6.mPendingTimeMillis     // Catch:{ all -> 0x00a7 }
                com.google.android.gms.vision.b$a r1 = r1.a((long) r2)     // Catch:{ all -> 0x00a7 }
                com.business.merchant_payments.mapqr.vision.camera.CameraSource r2 = com.business.merchant_payments.mapqr.vision.camera.CameraSource.this     // Catch:{ all -> 0x00a7 }
                int r2 = r2.mRotation     // Catch:{ all -> 0x00a7 }
                com.google.android.gms.vision.b$a r1 = r1.b(r2)     // Catch:{ all -> 0x00a7 }
                com.google.android.gms.vision.b r1 = r1.a()     // Catch:{ all -> 0x00a7 }
                java.nio.ByteBuffer r2 = r6.mPendingFrameData     // Catch:{ all -> 0x00a7 }
                r3 = 0
                r6.mPendingFrameData = r3     // Catch:{ all -> 0x00a7 }
                monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
                com.google.android.gms.vision.a<?> r0 = r6.mDetector     // Catch:{ all -> 0x0079 }
                r0.b(r1)     // Catch:{ all -> 0x0079 }
                com.business.merchant_payments.mapqr.vision.camera.CameraSource r0 = com.business.merchant_payments.mapqr.vision.camera.CameraSource.this
                android.hardware.Camera r0 = r0.mCamera
                byte[] r1 = r2.array()
                r0.addCallbackBuffer(r1)
                goto L_0x0000
            L_0x0079:
                r0 = move-exception
                java.lang.String r1 = "OpenCameraSource"
                java.lang.String r3 = "Exception thrown from receiver."
                java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0098 }
                java.lang.String r0 = r3.concat(r0)     // Catch:{ all -> 0x0098 }
                com.business.common_module.utilities.LogUtility.e(r1, r0)     // Catch:{ all -> 0x0098 }
                com.business.merchant_payments.mapqr.vision.camera.CameraSource r0 = com.business.merchant_payments.mapqr.vision.camera.CameraSource.this
                android.hardware.Camera r0 = r0.mCamera
                byte[] r1 = r2.array()
                r0.addCallbackBuffer(r1)
                goto L_0x0000
            L_0x0098:
                r0 = move-exception
                com.business.merchant_payments.mapqr.vision.camera.CameraSource r1 = com.business.merchant_payments.mapqr.vision.camera.CameraSource.this
                android.hardware.Camera r1 = r1.mCamera
                byte[] r2 = r2.array()
                r1.addCallbackBuffer(r2)
                throw r0
            L_0x00a7:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.mapqr.vision.camera.CameraSource.FrameProcessingRunnable.run():void");
        }
    }
}
