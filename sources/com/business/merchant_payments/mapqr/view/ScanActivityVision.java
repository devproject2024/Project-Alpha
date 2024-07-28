package com.business.merchant_payments.mapqr.view;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.a;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.z;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.utilities.a.c;
import com.business.common_module.utilities.a.e;
import com.business.common_module.utilities.i;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.BaseActivity;
import com.business.merchant_payments.common.utility.APSharedPreferences;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.deeplinkUtil.DeepLinkConstant;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.business.merchant_payments.mapqr.model.MapQRResponse;
import com.business.merchant_payments.mapqr.model.VerifyQRResponse;
import com.business.merchant_payments.mapqr.utility.QRScannedFinishEvent;
import com.business.merchant_payments.mapqr.viewmodel.MapQRViewModel;
import com.business.merchant_payments.mapqr.vision.BarcodeGraphic;
import com.business.merchant_payments.mapqr.vision.BarcodeGraphicTracker;
import com.business.merchant_payments.mapqr.vision.BarcodeTrackerFactory;
import com.business.merchant_payments.mapqr.vision.ViewFinder;
import com.business.merchant_payments.mapqr.vision.camera.CameraSource;
import com.business.merchant_payments.mapqr.vision.camera.CameraSourcePreview;
import com.business.merchant_payments.mapqr.vision.camera.GraphicOverlay;
import com.google.android.gms.common.c;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.a;
import com.google.android.gms.vision.d;
import com.google.android.material.snackbar.Snackbar;
import com.google.zxing.client.android.b;
import java.io.IOException;
import java.io.Serializable;
import net.one97.paytm.upi.util.UpiConstants;

public final class ScanActivityVision extends BaseActivity implements BarcodeGraphicTracker.BarcodeUpdateListener {
    public static final String INTENT_EXTRA = "intent_extra";
    public static final int MAX_FRAME_HEIGHT = 675;
    public static final int MAX_FRAME_WIDTH = 675;
    public static final int MIN_FRAME_HEIGHT = 240;
    public static final int MIN_FRAME_WIDTH = 240;
    public static final int RC_HANDLE_CAMERA_PERM = 2;
    public static final int RC_HANDLE_GMS = 9001;
    public static final int REQUEST_PERMISSION_SETTING = 401;
    public static final String TAG = "Barcode-reader";
    public static final int frameOffset = 30;
    public boolean askedForPermission = false;
    public boolean autoFocus = true;
    public ImageView back;
    public b beepManager;
    public Snackbar errorSnackBar;
    public String featureName = null;
    public ImageView flashIcon;
    public boolean flashOFF = true;
    public boolean isForVerifyQRFlow = false;
    public String jsonFile = "blue_dotted_progress.json";
    public CameraSource mCameraSource;
    public View mFramingRect;
    public GraphicOverlay<BarcodeGraphic> mGraphicOverlay;
    public CameraSourcePreview mPreview;
    public ImageView mScanningLine;
    public MapQRViewModel mapQRViewModel;
    public RelativeLayout noCameraPermissionUI;
    public RelativeLayout rlError;
    public ViewFinder viewFinder;

    public static /* synthetic */ void lambda$showSnackBar$7(View view) {
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() != null && getIntent().hasExtra("is_for_verifying_qr")) {
            this.isForVerifyQRFlow = getIntent().getBooleanExtra("is_for_verifying_qr", false);
        }
        if (!this.isForVerifyQRFlow) {
            requestWindowFeature(1);
            getWindow().setFlags(TarConstants.EOF_BLOCK, TarConstants.EOF_BLOCK);
        }
        setContentView(R.layout.mp_barcode_capture);
        if (getIntent().getExtras() != null && getIntent().hasExtra("getFeatureName")) {
            this.featureName = getIntent().getStringExtra("getFeatureName");
        }
        PaymentsConfig.getInstance().getEventPublisher();
        initBarcodeReaderFunctionalityViews();
        setFramingRectDimensions();
        initUI();
        setData();
    }

    private void initBarcodeReaderFunctionalityViews() {
        this.mPreview = (CameraSourcePreview) findViewById(R.id.preview);
        this.mGraphicOverlay = (GraphicOverlay) findViewById(R.id.graphicOverlay);
        b bVar = new b(this);
        this.beepManager = bVar;
        bVar.a();
        this.askedForPermission = true;
        if (a.a((Context) this, "android.permission.CAMERA") == 0) {
            createCameraSource();
        } else {
            initializeNoCameraUI();
            requestCameraPermission();
        }
        this.viewFinder = (ViewFinder) findViewById(R.id.view_finder);
        this.mFramingRect = findViewById(R.id.framing_rect);
        this.mScanningLine = (ImageView) findViewById(R.id.scanning_line);
        this.rlError = (RelativeLayout) findViewById(R.id.rlErrorLayout);
    }

    private void setData() {
        MapQRViewModel mapQRViewModel2 = (MapQRViewModel) provideViewModel(MapQRViewModel.class, (Fragment) null);
        this.mapQRViewModel = mapQRViewModel2;
        mapQRViewModel2.mapQRResponseLiveDataWrapper.observe(this, new z() {
            public final void onChanged(Object obj) {
                ScanActivityVision.this.lambda$setData$0$ScanActivityVision((com.business.common_module.utilities.a.b) obj);
            }
        });
        this.mapQRViewModel.verifyQRResponseLiveDataWrapper.observe(this, new z() {
            public final void onChanged(Object obj) {
                ScanActivityVision.this.lambda$setData$1$ScanActivityVision((com.business.common_module.utilities.a.b) obj);
            }
        });
    }

    public /* synthetic */ void lambda$setData$0$ScanActivityVision(com.business.common_module.utilities.a.b bVar) {
        if (bVar.f7357b == e.LOADING) {
            Snackbar snackbar = this.errorSnackBar;
            if (snackbar != null && snackbar.e()) {
                this.errorSnackBar.d();
            }
        } else if (bVar.f7356a != null) {
            MapQRResponse mapQRResponse = (MapQRResponse) bVar.f7358c;
            if (mapQRResponse == null) {
                showErrorLayout((String) null);
            } else if ("SUCCESS".equalsIgnoreCase(mapQRResponse.getStatus())) {
                setResponseFlow(bVar);
            } else {
                showErrorLayout(mapQRResponse.getStatusMessage());
            }
        } else {
            showErrorLayout((String) null);
        }
    }

    public /* synthetic */ void lambda$setData$1$ScanActivityVision(com.business.common_module.utilities.a.b bVar) {
        if (bVar.f7357b == e.LOADING) {
            Snackbar snackbar = this.errorSnackBar;
            if (snackbar != null && snackbar.e()) {
                this.errorSnackBar.d();
            }
        } else if (bVar.f7356a != null) {
            VerifyQRResponse verifyQRResponse = (VerifyQRResponse) bVar.f7358c;
            if (verifyQRResponse == null) {
                openPostVerifyFlow("not_scannable");
            } else if ("SUCCESS".equalsIgnoreCase(verifyQRResponse.getStatusMessage()) && ((VerifyQRResponse) bVar.f7358c).getResponse() != null) {
                openPostVerifyFlow(((VerifyQRResponse) bVar.f7358c).getResponse().get(0).getmQRType());
            } else if (verifyQRResponse.getStatusCode() == null || !verifyQRResponse.getStatusCode().equalsIgnoreCase("DQR_0050")) {
                openPostVerifyFlow("not_scannable");
            } else {
                openPostVerifyFlow("not_paytm_qr");
            }
        } else {
            openPostVerifyFlow("not_scannable");
        }
    }

    private void showErrorLayout(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.mp_error_in_mapping_qr_code);
        }
        this.rlError.setVisibility(0);
        ((ImageView) findViewById(R.id.ivCross)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ScanActivityVision.this.rlError.setVisibility(8);
            }
        });
        ((TextView) findViewById(R.id.tvRetry)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ScanActivityVision.this.rlError.setVisibility(8);
            }
        });
        ((TextView) findViewById(R.id.errorText)).setText(str);
    }

    private void setResponseFlow(com.business.common_module.utilities.a.b<MapQRResponse> bVar) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(MapQRSuccessScreen.SUCCESS_DATA, (Serializable) bVar.f7358c);
        Intent intent = new Intent(this, MapQRSuccessScreen.class);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    private void openPostVerifyFlow(String str) {
        Intent intent = new Intent(this, PostVerifyQRActivity.class);
        if (str.equalsIgnoreCase(AppConstants.UPI_QR_CODE)) {
            intent.putExtra(INTENT_EXTRA, UpiConstants.UPI_SOURCE_MAPPING.PAYTM_QR_SCAN_SOURCE);
        } else if (!str.isEmpty() && str.equalsIgnoreCase("not_scannable")) {
            intent.putExtra(INTENT_EXTRA, "not_scannable");
        } else if (!str.isEmpty() && str.equalsIgnoreCase("not_paytm_qr")) {
            intent.putExtra(INTENT_EXTRA, "not_paytm_qr");
        } else if (!str.isEmpty() && !str.equalsIgnoreCase(AppConstants.UPI_QR_CODE)) {
            intent.putExtra(INTENT_EXTRA, "old_paytm_qr");
        }
        startActivity(intent);
        finish();
    }

    private void initializeNoCameraUI() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.no_camera_permission_ui);
        this.noCameraPermissionUI = relativeLayout;
        relativeLayout.setVisibility(0);
        ((Button) findViewById(R.id.capture_enable_camera_btn)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ScanActivityVision.this.lambda$initializeNoCameraUI$2$ScanActivityVision(view);
            }
        });
    }

    public /* synthetic */ void lambda$initializeNoCameraUI$2$ScanActivityVision(View view) {
        if (!a.a((Activity) this, "android.permission.CAMERA")) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", getPackageName(), (String) null));
            startActivityForResult(intent, 401);
            return;
        }
        a.a(this, new String[]{"android.permission.CAMERA"}, 2);
    }

    private void initUI() {
        this.back = (ImageView) findViewById(R.id.iv_back);
        this.back.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        this.back.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ScanActivityVision.this.lambda$initUI$3$ScanActivityVision(view);
            }
        });
        this.flashIcon = (ImageView) findViewById(R.id.iv_flash_icon);
        if (getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
            this.flashIcon.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    ScanActivityVision.this.lambda$initUI$4$ScanActivityVision(view);
                }
            });
        } else {
            this.flashIcon.setVisibility(8);
        }
        if (this.isForVerifyQRFlow) {
            GAGTMTagAnalytics.getSingleInstance().sendEvent(this, "verify_qr_scan_and_verify_popup", "shown", "", "");
            ((TextView) findViewById(R.id.tv_heading)).setVisibility(8);
            ((TextView) findViewById(R.id.tv_sub_heading)).setVisibility(8);
            findViewById(R.id.verifyQrContainer).setVisibility(0);
            findViewById(R.id.doItLater).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    ScanActivityVision.this.lambda$initUI$5$ScanActivityVision(view);
                }
            });
        } else {
            ((TextView) findViewById(R.id.tv_heading)).setVisibility(0);
            ((TextView) findViewById(R.id.tv_sub_heading)).setVisibility(0);
            findViewById(R.id.verifyQrContainer).setVisibility(8);
        }
        if ("multipleQR".equalsIgnoreCase(this.featureName)) {
            ((TextView) findViewById(R.id.tv_heading)).setVisibility(8);
            ((TextView) findViewById(R.id.tv_sub_heading)).setVisibility(8);
        }
    }

    public /* synthetic */ void lambda$initUI$3$ScanActivityVision(View view) {
        onBackPressWithGA();
    }

    public /* synthetic */ void lambda$initUI$4$ScanActivityVision(View view) {
        toggleFlashBtn();
    }

    public /* synthetic */ void lambda$initUI$5$ScanActivityVision(View view) {
        onBackPressed();
        GAGTMTagAnalytics.getSingleInstance().sendEvent(this, "verify_qr_scan_and_verify_popup", "later", "", "");
    }

    private void onBackPressWithGA() {
        if ("multipleQR".equalsIgnoreCase(this.featureName)) {
            GAGTMTagAnalytics.getSingleInstance().sendEventAndScreen(this, "manage_QR", "Scan QR back", "");
        }
        onBackPressed();
    }

    private void toggleFlashBtn() {
        if (this.flashOFF) {
            this.flashIcon.setImageResource(R.drawable.mqr_flash);
        } else {
            this.flashIcon.setImageResource(R.drawable.mqr_flash_off);
        }
        this.flashOFF = !this.flashOFF;
        stopCamera();
        createCameraSource();
        startCameraSource();
    }

    private void stopCamera() {
        this.mPreview.stop();
        CameraSource cameraSource = this.mCameraSource;
        if (cameraSource != null) {
            cameraSource.release();
            this.mCameraSource = null;
        }
    }

    private void requestCameraPermission() {
        LogUtility.d(TAG, "Camera permission is not granted. Requesting permission");
        String[] strArr = {"android.permission.CAMERA"};
        if (!a.a((Activity) this, "android.permission.CAMERA")) {
            a.a(this, strArr, 2);
        }
    }

    /* renamed from: com.business.merchant_payments.mapqr.view.ScanActivityVision$3  reason: invalid class name */
    public class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ String[] val$permissions;
        public final /* synthetic */ Activity val$thisActivity;

        public void onClick(View view) {
            a.a(this.val$thisActivity, this.val$permissions, 2);
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 401 && i3 == -1) {
            this.noCameraPermissionUI.setVisibility(8);
            createCameraSource();
            startCameraSource();
        } else if (i2 == 401 && a.a((Context) this, "android.permission.CAMERA") == 0) {
            this.noCameraPermissionUI.setVisibility(8);
            createCameraSource();
            startCameraSource();
        } else if (i2 == 8888) {
            setResult(8888, new Intent().putExtra(DeepLinkConstant.FEATURES.DOWNLOAD_QR, true));
        }
    }

    private void createCameraSource() {
        com.google.android.gms.vision.barcode.a a2 = new a.C0165a(getApplicationContext()).a();
        a2.a(new d.a(new BarcodeTrackerFactory(this.mGraphicOverlay, this)).f12628a);
        String str = null;
        if (!a2.f12616a.b()) {
            LogUtility.d(TAG, "Detector dependencies are not yet available.");
            if (registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW")) != null) {
                Toast.makeText(this, R.string.mp_low_storage_error, 1).show();
                LogUtility.d(TAG, getString(R.string.mp_low_storage_error));
            }
        }
        CameraSource.Builder requestedFps = new CameraSource.Builder(getApplicationContext(), a2).setFacing(0).setRequestedPreviewSize(1600, TarConstants.EOF_BLOCK).setRequestedFps(15.0f);
        if (Build.VERSION.SDK_INT >= 14) {
            requestedFps = requestedFps.setFocusMode(this.autoFocus ? "continuous-picture" : null);
        }
        if (!this.flashOFF) {
            str = "torch";
        }
        this.mCameraSource = requestedFps.setFlashMode(str).build();
    }

    public final void onResume() {
        RelativeLayout relativeLayout;
        super.onResume();
        if (androidx.core.app.a.a((Context) this, "android.permission.CAMERA") == 0 && (relativeLayout = this.noCameraPermissionUI) != null) {
            relativeLayout.setVisibility(8);
        } else if (!this.askedForPermission && this.noCameraPermissionUI != null) {
            initializeNoCameraUI();
        }
        this.askedForPermission = false;
        startCameraSource();
    }

    public final void onPause() {
        super.onPause();
        setFlashOff();
        CameraSourcePreview cameraSourcePreview = this.mPreview;
        if (cameraSourcePreview != null) {
            cameraSourcePreview.stop();
        }
    }

    private void setFlashOff() {
        this.flashOFF = true;
        ImageView imageView = this.flashIcon;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.mqr_flash_off);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        b bVar = this.beepManager;
        if (bVar != null) {
            bVar.close();
        }
        CameraSourcePreview cameraSourcePreview = this.mPreview;
        if (cameraSourcePreview != null) {
            cameraSourcePreview.release();
        }
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 != 2) {
            LogUtility.d(TAG, "Got unexpected permission result: ".concat(String.valueOf(i2)));
            super.onRequestPermissionsResult(i2, strArr, iArr);
        } else if (iArr.length == 0 || iArr[0] != 0) {
            StringBuilder sb = new StringBuilder("Permission not granted: results len = ");
            sb.append(iArr.length);
            sb.append(" Result code = ");
            sb.append(iArr.length > 0 ? Integer.valueOf(iArr[0]) : "(empty)");
            LogUtility.e(TAG, sb.toString());
        } else {
            LogUtility.d(TAG, "Camera permission granted - initialize the camera source");
            this.autoFocus = true;
            RelativeLayout relativeLayout = this.noCameraPermissionUI;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            createCameraSource();
        }
    }

    private void startCameraSource() throws SecurityException {
        int isGooglePlayServicesAvailable = AppUtility.isGooglePlayServicesAvailable(getApplicationContext());
        if (isGooglePlayServicesAvailable != 0) {
            c.a().a((Activity) this, isGooglePlayServicesAvailable, (int) RC_HANDLE_GMS).show();
        }
        CameraSource cameraSource = this.mCameraSource;
        if (cameraSource != null) {
            try {
                this.mPreview.start(cameraSource, this.mGraphicOverlay);
                this.viewFinder.setCameraSource(this.mCameraSource);
                this.viewFinder.drawViewfinder();
            } catch (IOException e2) {
                LogUtility.e(TAG, "Unable to start camera source.".concat(String.valueOf(e2)));
                this.mCameraSource.release();
                this.mCameraSource = null;
            }
        }
    }

    public final void onBarcodeDetected(Barcode barcode) {
        if ("multipleQR".equalsIgnoreCase(this.featureName)) {
            org.greenrobot.eventbus.c.a().c(new QRScannedFinishEvent(this.mapQRViewModel.getQRCodeValue(barcode.f12554c)));
            finish();
            return;
        }
        if (barcode.f12554c.isEmpty()) {
            PaymentsConfig.getInstance().getEventPublisher().a(this, "verify_qr_QR_scan", "unsuccessful", "", "");
        } else {
            PaymentsConfig.getInstance().getEventPublisher().a(this, "verify_qr_QR_scan", "successful", "", "");
        }
        PaymentsConfig.getInstance().getEventPublisher();
        if (this.rlError.getVisibility() != 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable(barcode) {
                private final /* synthetic */ Barcode f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    ScanActivityVision.this.lambda$onBarcodeDetected$6$ScanActivityVision(this.f$1);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onBarcodeDetected$6$ScanActivityVision(Barcode barcode) {
        if (!i.a(getApplication())) {
            showSnackBar(getString(R.string.mp_network_reconnect_msg));
            return;
        }
        this.beepManager.b();
        if (!this.isForVerifyQRFlow) {
            this.mapQRViewModel.callMapQRApi(barcode.f12554c, APSharedPreferences.getInstance().getCustomerId());
        } else if (barcode.f12554c.isEmpty()) {
            openPostVerifyFlow("not_scannable");
        } else {
            this.mapQRViewModel.triggerVerifyQRApi(barcode.f12554c);
        }
    }

    private void showSnackBar(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.mp_oops_something_wrong_msg);
        }
        Snackbar a2 = Snackbar.a((View) this.mGraphicOverlay, (CharSequence) str, -2).a(R.string.mp_ok, (View.OnClickListener) $$Lambda$ScanActivityVision$VaYHbQ0DsXeh8ycEgNu3hSuQQHw.INSTANCE);
        this.errorSnackBar = a2;
        a2.d(getResources().getColor(R.color.color_00b9f5));
        View b2 = this.errorSnackBar.b();
        b2.setBackgroundColor(androidx.core.content.b.c(this, R.color.black));
        TextView textView = (TextView) b2.findViewById(com.google.android.material.R.id.snackbar_text);
        ((TextView) b2.findViewById(com.google.android.material.R.id.snackbar_action)).setAllCaps(false);
        textView.setTypeface(textView.getTypeface(), 1);
        textView.setTextColor(-1);
        this.errorSnackBar.c();
    }

    private void setFramingRectDimensions() {
        int i2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mFramingRect.getLayoutParams();
        Rect framingRect = this.viewFinder.getFramingRect();
        int i3 = 435;
        if (framingRect != null) {
            i3 = framingRect.height();
            i2 = framingRect.width();
        } else {
            i2 = 435;
        }
        layoutParams.height = i3;
        layoutParams.width = i2;
        this.mFramingRect.setLayoutParams(layoutParams);
        setScanningLineDimesions(i2, i3);
    }

    private void setScanningLineDimesions(int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mScanningLine.getLayoutParams();
        layoutParams.width = i2 - 10;
        this.mScanningLine.setLayoutParams(layoutParams);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, ((((float) i3) / dpToPixel(44)) - 0.0f) - 1.0f);
        translateAnimation.setDuration(3000);
        translateAnimation.setRepeatMode(2);
        translateAnimation.setRepeatCount(-1);
        this.mScanningLine.startAnimation(translateAnimation);
    }

    public final float dpToPixel(int i2) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return (float) ((displayMetrics.densityDpi * i2) / 160);
    }

    public final <T extends com.business.common_module.utilities.a.c> T provideViewModel(Class<T> cls, Fragment fragment) {
        c.a aVar = new c.a(getApplication());
        if (fragment == null) {
            return (com.business.common_module.utilities.a.c) new al((ao) this, (al.b) aVar).a(cls);
        }
        return (com.business.common_module.utilities.a.c) new al((ao) fragment, (al.b) aVar).a(cls);
    }
}
