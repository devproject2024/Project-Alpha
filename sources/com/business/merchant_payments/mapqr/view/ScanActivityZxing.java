package com.business.merchant_payments.mapqr.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.utilities.a.c;
import com.business.common_module.view.widget.CustomTextView;
import com.business.common_module.zxingutils.ViewfinderView;
import com.business.common_module.zxingutils.a;
import com.business.common_module.zxingutils.e;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.BaseActivity;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.business.merchant_payments.mapqr.model.MapQRResponse;
import com.business.merchant_payments.mapqr.model.VerifyQRResponse;
import com.business.merchant_payments.mapqr.viewmodel.MapQRViewModel;
import com.business.merchant_payments.mapqr.zxingutils.ScanHandler;
import com.google.android.material.snackbar.Snackbar;
import com.google.zxing.client.android.b;
import com.google.zxing.client.android.history.d;
import com.google.zxing.r;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.upi.util.UpiConstants;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class ScanActivityZxing extends BaseActivity implements SurfaceHolder.Callback {
    public static final Companion Companion = new Companion((g) null);
    public static String TAG = "ScanActivity";
    public final String INTENT_EXTRA = ScanActivityVision.INTENT_EXTRA;
    public final int RC_HANDLE_CAMERA_PERM = 2;
    public final int REQUEST_PERMISSION_SETTING = 401;
    public HashMap _$_findViewCache;
    public a ambientLightManager;
    public boolean askedForPermission;
    public ImageView back;
    public b beepManager;
    public e cameraManager;
    public String characterSet;
    public Collection<? extends com.google.zxing.a> decodeFormats;
    public Map<com.google.zxing.e, ?> decodeHints;
    public Snackbar errorSnackBar;
    public ImageView flashIcon;
    public boolean flashOFF = true;
    public ScanHandler handler;
    public boolean hasSurface;
    public d historyManager;
    public com.business.common_module.zxingutils.g inactivityTimer;
    public boolean isForVerifyQRFlow;
    public final String jsonFile = "blue_dotted_progress.json";
    public r lastResult;
    public MapQRViewModel mapQRViewModel;
    public RelativeLayout noCameraPermissionUI;
    public RelativeLayout rlContainer;
    public SurfaceHolder surfaceHolder;
    public ViewfinderView viewfinderView;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final e getCameraManager() {
        return this.cameraManager;
    }

    public final void setCameraManager(e eVar) {
        this.cameraManager = eVar;
    }

    public final ScanHandler getHandler() {
        return this.handler;
    }

    public final void setHandler(ScanHandler scanHandler) {
        this.handler = scanHandler;
    }

    public final ViewfinderView getViewfinderView() {
        return this.viewfinderView;
    }

    public final void setViewfinderView(ViewfinderView viewfinderView2) {
        this.viewfinderView = viewfinderView2;
    }

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final String getTAG() {
            return ScanActivityZxing.TAG;
        }

        public final void setTAG(String str) {
            k.d(str, "<set-?>");
            ScanActivityZxing.TAG = str;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mp_activity_scan_zxing);
        this.rlContainer = (RelativeLayout) findViewById(R.id.scan_only_parent_layout);
        if (getIntent().getExtras() != null && getIntent().hasExtra("is_for_verifying_qr")) {
            this.isForVerifyQRFlow = getIntent().getBooleanExtra("is_for_verifying_qr", false);
        }
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        instance.getEventPublisher();
        askForPermissions();
        initScanningComponents();
        initUI();
        setData();
    }

    private final void initScanningComponents() {
        this.ambientLightManager = new a(this);
        PreferenceManager.setDefaultValues(this, com.google.zxing.client.android.R.xml.preferences, false);
        d dVar = new d(this);
        this.historyManager = dVar;
        dVar.c();
        this.cameraManager = new e(getApplication());
        ViewfinderView viewfinderView2 = (ViewfinderView) findViewById(R.id.viewfinder_view);
        this.viewfinderView = viewfinderView2;
        if (viewfinderView2 != null) {
            viewfinderView2.setCameraManagerModified(this.cameraManager);
        }
        this.beepManager = new b(this);
        this.inactivityTimer = new com.business.common_module.zxingutils.g(this);
        this.handler = null;
        this.lastResult = null;
        b bVar = this.beepManager;
        if (bVar != null) {
            bVar.a();
        }
        a aVar = this.ambientLightManager;
        if (aVar != null) {
            aVar.a(this.cameraManager);
        }
        com.business.common_module.zxingutils.g gVar = this.inactivityTimer;
        if (gVar != null) {
            gVar.c();
        }
        this.decodeFormats = null;
        this.characterSet = null;
        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.preview_view);
        k.b(surfaceView, "surfaceView");
        SurfaceHolder holder = surfaceView.getHolder();
        this.surfaceHolder = holder;
        k.a((Object) holder);
        initializeCamera(holder);
    }

    private final void initializeCamera(SurfaceHolder surfaceHolder2) {
        if (this.hasSurface) {
            initCamera(surfaceHolder2);
        } else {
            surfaceHolder2.addCallback(this);
        }
    }

    public final void onResume() {
        RelativeLayout relativeLayout;
        super.onResume();
        if (androidx.core.app.a.a((Context) this, "android.permission.CAMERA") == 0 && (relativeLayout = this.noCameraPermissionUI) != null) {
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            initScanningComponents();
        } else if (!this.askedForPermission && this.noCameraPermissionUI != null) {
            initializeNoCameraUI();
        }
        this.askedForPermission = false;
    }

    private final void initCamera(SurfaceHolder surfaceHolder2) {
        new Handler().postDelayed(new ScanActivityZxing$initCamera$1(this, surfaceHolder2), 200);
    }

    public final void handleDecode(r rVar, Bitmap bitmap) {
        b bVar;
        k.d(rVar, "rawResult");
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.rlErrorLayout);
        if (relativeLayout != null && relativeLayout.getVisibility() == 8) {
            com.business.common_module.zxingutils.g gVar = this.inactivityTimer;
            if (gVar != null) {
                gVar.a();
            }
            com.business.common_module.zxingutils.g gVar2 = this.inactivityTimer;
            if (gVar2 != null) {
                gVar2.d();
            }
            this.lastResult = rVar;
            if ((bitmap != null) && (bVar = this.beepManager) != null) {
                bVar.b();
            }
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            instance.getEventPublisher();
            new Handler(Looper.getMainLooper()).post(new ScanActivityZxing$handleDecode$1(this, rVar));
            initScanningComponents();
        }
    }

    public final void drawViewfinder() {
        ViewfinderView viewfinderView2 = this.viewfinderView;
        if (viewfinderView2 != null) {
            viewfinderView2.a();
        }
    }

    public final void askForPermissions() {
        this.askedForPermission = true;
        if (androidx.core.app.a.a((Context) this, "android.permission.CAMERA") != 0) {
            initializeNoCameraUI();
            requestCameraPermission();
        }
    }

    private final void initializeNoCameraUI() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.no_camera_permission_ui);
        this.noCameraPermissionUI = relativeLayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        View findViewById = findViewById(R.id.capture_enable_camera_btn);
        k.b(findViewById, "findViewById(R.id.capture_enable_camera_btn)");
        ((Button) findViewById).setOnClickListener(new ScanActivityZxing$initializeNoCameraUI$1(this));
    }

    private final void requestCameraPermission() {
        LogUtility.d(TAG, "Camera permission is not granted. Requesting permission");
        String[] strArr = {"android.permission.CAMERA"};
        if (!androidx.core.app.a.a((Activity) this, "android.permission.CAMERA")) {
            androidx.core.app.a.a(this, strArr, this.RC_HANDLE_CAMERA_PERM);
        }
    }

    private final void initUI() {
        this.back = (ImageView) findViewById(R.id.iv_back);
        int c2 = androidx.core.content.b.c(this, R.color.white);
        ImageView imageView = this.back;
        if (imageView != null) {
            imageView.setColorFilter(c2, PorterDuff.Mode.SRC_ATOP);
        }
        ImageView imageView2 = this.back;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new ScanActivityZxing$initUI$1(this));
        }
        this.flashIcon = (ImageView) findViewById(R.id.iv_flash_icon);
        if (getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
            ImageView imageView3 = this.flashIcon;
            if (imageView3 != null) {
                imageView3.setOnClickListener(new ScanActivityZxing$initUI$2(this));
            }
        } else {
            ImageView imageView4 = this.flashIcon;
            if (imageView4 != null) {
                imageView4.setVisibility(8);
            }
        }
        if (this.isForVerifyQRFlow) {
            GAGTMTagAnalytics.getSingleInstance().sendEvent(this, "verify_qr_scan_and_verify_popup", "shown", "", "");
            View findViewById = findViewById(R.id.tv_heading);
            if (findViewById != null) {
                ((TextView) findViewById).setVisibility(8);
                View findViewById2 = findViewById(R.id.tv_sub_heading);
                if (findViewById2 != null) {
                    ((TextView) findViewById2).setVisibility(8);
                    View findViewById3 = findViewById(R.id.verifyQrContainer);
                    k.b(findViewById3, "findViewById<View>(R.id.verifyQrContainer)");
                    findViewById3.setVisibility(0);
                    findViewById(R.id.doItLater).setOnClickListener(new ScanActivityZxing$initUI$3(this));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
        View findViewById4 = findViewById(R.id.tv_heading);
        if (findViewById4 != null) {
            ((TextView) findViewById4).setVisibility(0);
            View findViewById5 = findViewById(R.id.tv_sub_heading);
            if (findViewById5 != null) {
                ((TextView) findViewById5).setVisibility(0);
                View findViewById6 = findViewById(R.id.verifyQrContainer);
                k.b(findViewById6, "findViewById<View>(R.id.verifyQrContainer)");
                findViewById6.setVisibility(8);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    /* access modifiers changed from: private */
    public final void toggleFlashBtn() {
        if (this.flashOFF) {
            ImageView imageView = this.flashIcon;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.mqr_flash);
            }
            e eVar = this.cameraManager;
            if (eVar != null) {
                eVar.a(true);
            }
        } else {
            ImageView imageView2 = this.flashIcon;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.mqr_flash_off);
            }
            e eVar2 = this.cameraManager;
            if (eVar2 != null) {
                eVar2.a(false);
            }
        }
        this.flashOFF = !this.flashOFF;
    }

    private final void setData() {
        LiveData<com.business.common_module.utilities.a.b<VerifyQRResponse>> liveData;
        LiveData<com.business.common_module.utilities.a.b<MapQRResponse>> liveData2;
        MapQRViewModel mapQRViewModel2 = (MapQRViewModel) provideViewModel(MapQRViewModel.class, (Fragment) null);
        this.mapQRViewModel = mapQRViewModel2;
        if (!(mapQRViewModel2 == null || (liveData2 = mapQRViewModel2.mapQRResponseLiveDataWrapper) == null)) {
            liveData2.observe(this, new ScanActivityZxing$setData$1(this));
        }
        MapQRViewModel mapQRViewModel3 = this.mapQRViewModel;
        if (mapQRViewModel3 != null && (liveData = mapQRViewModel3.verifyQRResponseLiveDataWrapper) != null) {
            liveData.observe(this, new ScanActivityZxing$setData$2(this));
        }
    }

    public final void openPostVerifyFlow(String str) {
        k.d(str, "qrType");
        Intent intent = new Intent(this, PostVerifyQRActivity.class);
        if (p.a(str, AppConstants.UPI_QR_CODE, true)) {
            k.b(intent.putExtra(this.INTENT_EXTRA, UpiConstants.UPI_SOURCE_MAPPING.PAYTM_QR_SCAN_SOURCE), "intent.putExtra(INTENT_E…CommonConstants.PAYTM_QR)");
        } else {
            boolean z = false;
            if ((str.length() == 0) || !p.a(str, "not_scannable", true)) {
                if ((str.length() == 0) || !p.a(str, "not_paytm_qr", true)) {
                    if (str.length() == 0) {
                        z = true;
                    }
                    if (!z && !p.a(str, AppConstants.UPI_QR_CODE, true)) {
                        intent.putExtra(this.INTENT_EXTRA, "old_paytm_qr");
                    }
                } else {
                    k.b(intent.putExtra(this.INTENT_EXTRA, "not_paytm_qr"), "intent.putExtra(INTENT_E…onConstants.NOT_PAYTM_QR)");
                }
            } else {
                k.b(intent.putExtra(this.INTENT_EXTRA, "not_scannable"), "intent.putExtra(INTENT_E…nConstants.NOT_SCANNABLE)");
            }
        }
        startActivity(intent);
        finish();
    }

    /* access modifiers changed from: private */
    public final void setResponseFlow(com.business.common_module.utilities.a.b<MapQRResponse> bVar) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(MapQRSuccessScreen.SUCCESS_DATA, (Serializable) bVar.f7358c);
        Intent intent = new Intent(this, MapQRSuccessScreen.class);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        k.d(strArr, "permissions");
        k.d(iArr, "grantResults");
        if (i2 != this.RC_HANDLE_CAMERA_PERM) {
            LogUtility.d(TAG, "Got unexpected permission result: ".concat(String.valueOf(i2)));
            super.onRequestPermissionsResult(i2, strArr, iArr);
        } else if (iArr.length == 0 || iArr[0] != 0) {
            String str = TAG;
            StringBuilder sb = new StringBuilder("Permission not granted: results len = ");
            sb.append(iArr.length);
            sb.append(" Result code = ");
            sb.append(iArr.length > 0 ? Integer.valueOf(iArr[0]) : "(empty)");
            LogUtility.e(str, sb.toString());
        } else {
            LogUtility.d(TAG, "Camera permission granted - initialize the camera source");
            RelativeLayout relativeLayout = this.noCameraPermissionUI;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            initScanningComponents();
        }
    }

    /* JADX WARNING: type inference failed for: r4v12, types: [android.view.View] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showSnackBar(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L_0x000c
            int r4 = com.business.merchant_payments.R.string.mp_error_in_mapping_qr_code
            java.lang.String r4 = r3.getString(r4)
        L_0x000c:
            android.widget.RelativeLayout r0 = r3.rlContainer
            kotlin.g.b.k.a((java.lang.Object) r0)
            kotlin.g.b.k.a((java.lang.Object) r4)
            r1 = -2
            com.google.android.material.snackbar.Snackbar r4 = com.google.android.material.snackbar.Snackbar.a((android.view.View) r0, (java.lang.CharSequence) r4, (int) r1)
            int r0 = com.business.merchant_payments.R.string.mp_ok
            com.business.merchant_payments.mapqr.view.ScanActivityZxing$showSnackBar$1 r1 = com.business.merchant_payments.mapqr.view.ScanActivityZxing$showSnackBar$1.INSTANCE
            com.google.android.material.snackbar.Snackbar r4 = r4.a((int) r0, (android.view.View.OnClickListener) r1)
            r3.errorSnackBar = r4
            if (r4 == 0) goto L_0x002e
            int r0 = com.business.merchant_payments.R.color.color_00b9f5
            int r0 = androidx.core.content.b.c(r3, r0)
            r4.d(r0)
        L_0x002e:
            com.google.android.material.snackbar.Snackbar r4 = r3.errorSnackBar
            r0 = 0
            if (r4 == 0) goto L_0x0038
            android.view.View r4 = r4.b()
            goto L_0x0039
        L_0x0038:
            r4 = r0
        L_0x0039:
            if (r4 == 0) goto L_0x0044
            int r1 = com.business.merchant_payments.R.color.black
            int r1 = androidx.core.content.b.c(r3, r1)
            r4.setBackgroundColor(r1)
        L_0x0044:
            if (r4 == 0) goto L_0x004f
            int r1 = com.google.android.material.R.id.snackbar_text
            android.view.View r1 = r4.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x0050
        L_0x004f:
            r1 = r0
        L_0x0050:
            java.lang.String r2 = "null cannot be cast to non-null type android.widget.TextView"
            if (r1 == 0) goto L_0x007f
            if (r4 == 0) goto L_0x005f
            int r0 = com.google.android.material.R.id.snackbar_action
            android.view.View r4 = r4.findViewById(r0)
            r0 = r4
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x005f:
            if (r0 == 0) goto L_0x0079
            r4 = 0
            r0.setAllCaps(r4)
            android.graphics.Typeface r4 = r1.getTypeface()
            r0 = 1
            r1.setTypeface(r4, r0)
            r4 = -1
            r1.setTextColor(r4)
            com.google.android.material.snackbar.Snackbar r4 = r3.errorSnackBar
            if (r4 == 0) goto L_0x0078
            r4.c()
        L_0x0078:
            return
        L_0x0079:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            r4.<init>(r2)
            throw r4
        L_0x007f:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            r4.<init>(r2)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.mapqr.view.ScanActivityZxing.showSnackBar(java.lang.String):void");
    }

    public final void onDestroy() {
        com.business.common_module.zxingutils.g gVar = this.inactivityTimer;
        if (gVar != null) {
            gVar.d();
        }
        super.onDestroy();
    }

    public final void onPause() {
        resetingViews();
        super.onPause();
    }

    private final void resetingViews() {
        ScanHandler scanHandler = this.handler;
        if (scanHandler != null) {
            if (scanHandler != null) {
                scanHandler.quitSynchronously();
            }
            this.handler = null;
        }
        com.business.common_module.zxingutils.g gVar = this.inactivityTimer;
        if (gVar != null) {
            gVar.b();
        }
        a aVar = this.ambientLightManager;
        if (aVar != null) {
            aVar.a();
        }
        b bVar = this.beepManager;
        if (bVar != null) {
            bVar.close();
        }
        e eVar = this.cameraManager;
        if (eVar != null) {
            eVar.b();
        }
        if (!this.hasSurface) {
            View findViewById = findViewById(R.id.preview_view);
            if (findViewById != null) {
                SurfaceView surfaceView = (SurfaceView) findViewById;
                if (surfaceView != null) {
                    surfaceView.getHolder().removeCallback(this);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.SurfaceView");
        }
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder2, int i2, int i3, int i4) {
        if (surfaceHolder2 == null) {
            LogUtility.e(TAG, "*** WARNING *** surfaceCreated() gave us a null surface!");
        }
        if (!this.hasSurface) {
            this.hasSurface = true;
            initCamera(surfaceHolder2);
        }
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder2) {
        this.hasSurface = false;
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder2) {
        if (surfaceHolder2 == null) {
            LogUtility.e(TAG, "*** WARNING *** surfaceCreated() gave us a null surface!");
        }
        if (!this.hasSurface) {
            this.hasSurface = true;
            initCamera(surfaceHolder2);
        }
    }

    /* access modifiers changed from: private */
    public final void showErrorLayout(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.rlErrorLayout);
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        ((ImageView) _$_findCachedViewById(R.id.ivCross)).setOnClickListener(new ScanActivityZxing$showErrorLayout$1(this));
        ((CustomTextView) _$_findCachedViewById(R.id.tvRetry)).setOnClickListener(new ScanActivityZxing$showErrorLayout$2(this));
        CustomTextView customTextView = (CustomTextView) _$_findCachedViewById(R.id.errorText);
        k.b(customTextView, CLConstants.FIELD_ERROR_TEXT);
        customTextView.setText(str);
    }

    public final <T extends c> T provideViewModel(Class<T> cls, Fragment fragment) {
        k.d(cls, "modelClass");
        c.a aVar = new c.a(getApplication());
        if (fragment == null) {
            T a2 = new al((ao) this, (al.b) aVar).a(cls);
            k.b(a2, "ViewModelProvider(this, …ctory).get<T>(modelClass)");
            return (c) a2;
        }
        T a3 = new al((ao) fragment, (al.b) aVar).a(cls);
        k.b(a3, "ViewModelProvider(fragme…ctory).get<T>(modelClass)");
        return (c) a3;
    }
}
