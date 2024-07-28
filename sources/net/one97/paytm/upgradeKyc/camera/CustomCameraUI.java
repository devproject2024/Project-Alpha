package net.one97.paytm.upgradeKyc.camera;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import kotlin.x;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.data.models.requestotp.SelfieModal;
import net.one97.paytm.upgradeKyc.helper.b;

public final class CustomCameraUI extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    int f65620a;

    /* renamed from: b  reason: collision with root package name */
    ProgressDialog f65621b;

    /* renamed from: c  reason: collision with root package name */
    private a f65622c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f65623d;

    /* renamed from: e  reason: collision with root package name */
    private b.a f65624e = b.a.AUTO;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f65625f = "";

    /* renamed from: g  reason: collision with root package name */
    private HashMap f65626g;

    public final View a(int i2) {
        if (this.f65626g == null) {
            this.f65626g = new HashMap();
        }
        View view = (View) this.f65626g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f65626g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final /* synthetic */ a a(CustomCameraUI customCameraUI) {
        a aVar = customCameraUI.f65622c;
        if (aVar == null) {
            kotlin.g.b.k.a("camera2");
        }
        return aVar;
    }

    public final void a(b.a aVar) {
        kotlin.g.b.k.c(aVar, "<set-?>");
        this.f65624e = aVar;
    }

    public final String a(Bitmap bitmap) {
        if (bitmap == null) {
            try {
                kotlin.g.b.k.a();
            } catch (Exception unused) {
                e();
                return null;
            }
        }
        int i2 = 100;
        if (bitmap.getAllocationByteCount() / TarConstants.EOF_BLOCK > 500) {
            i2 = 90;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
        kotlin.g.b.k.a((Object) byteArrayOutputStream.toByteArray(), "outputStream.toByteArray()");
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_custom_camera_ui);
        a(true);
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.iv_capture_image);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new b(this));
        }
        ((AppCompatImageView) a(R.id.iv_rotate_camera)).setOnClickListener(new d(this));
        ((AppCompatImageView) a(R.id.crossImg)).setOnClickListener(new e(this));
        ((AppCompatImageView) a(R.id.iv_flash_camera)).setOnClickListener(new f(this));
        TextView textView = (TextView) a(R.id.tv_on);
        if (textView != null) {
            textView.setOnClickListener(new g(this));
        }
        TextView textView2 = (TextView) a(R.id.tv_off);
        if (textView2 != null) {
            textView2.setOnClickListener(new h(this));
        }
        TextView textView3 = (TextView) a(R.id.tv_auto);
        if (textView3 != null) {
            textView3.setOnClickListener(new i(this));
        }
        ((AppCompatImageView) a(R.id.backImg)).setOnClickListener(new j(this));
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) a(R.id.iv_selfie_upload);
        if (appCompatImageView2 != null) {
            appCompatImageView2.setOnClickListener(new k(this));
        }
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) a(R.id.iv_selfie_decline);
        if (appCompatImageView3 != null) {
            appCompatImageView3.setOnClickListener(new c(this));
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomCameraUI f65628a;

        b(CustomCameraUI customCameraUI) {
            this.f65628a = customCameraUI;
        }

        public final void onClick(View view) {
            a a2 = CustomCameraUI.a(this.f65628a);
            kotlin.g.a.b<? super Bitmap, x> r0 = new kotlin.g.a.b<Bitmap, x>(this) {
                final /* synthetic */ b this$0;

                {
                    this.this$0 = r1;
                }

                public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Bitmap) obj);
                    return x.f47997a;
                }

                public final void invoke(final Bitmap bitmap) {
                    kotlin.g.b.k.c(bitmap, "it");
                    this.this$0.f65628a.runOnUiThread(new Runnable(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ AnonymousClass1 f65629a;

                        {
                            this.f65629a = r1;
                        }

                        public final void run() {
                            this.f65629a.this$0.f65628a.c();
                            this.f65629a.this$0.f65628a.f65620a++;
                            ConstraintLayout constraintLayout = (ConstraintLayout) this.f65629a.this$0.f65628a.a(R.id.cameraLayout);
                            if (constraintLayout != null) {
                                constraintLayout.setVisibility(8);
                            }
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) this.f65629a.this$0.f65628a.a(R.id.pictureLayout);
                            if (constraintLayout2 != null) {
                                constraintLayout2.setVisibility(0);
                            }
                            ImageView imageView = (ImageView) this.f65629a.this$0.f65628a.a(R.id.selfie_img);
                            if (imageView != null) {
                                imageView.setImageBitmap(bitmap);
                            }
                        }
                    });
                }
            };
            kotlin.g.b.k.c(r0, "onBitmapReady");
            a2.f65647h = false;
            a2.f65640a = r0;
            try {
                CaptureRequest.Builder builder = a2.f65644e;
                if (builder == null) {
                    kotlin.g.b.k.a();
                }
                builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                a2.f65646g = 1;
                CameraCaptureSession cameraCaptureSession = a2.f65643d;
                if (cameraCaptureSession == null) {
                    kotlin.g.b.k.a();
                }
                CaptureRequest.Builder builder2 = a2.f65644e;
                if (builder2 == null) {
                    kotlin.g.b.k.a();
                }
                cameraCaptureSession.capture(builder2.build(), a2.j, a2.f65642c);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomCameraUI f65632a;

        d(CustomCameraUI customCameraUI) {
            this.f65632a = customCameraUI;
        }

        public final void onClick(View view) {
            a a2 = CustomCameraUI.a(this.f65632a);
            if (a2 != null) {
                a2.b();
                int i2 = 1;
                if (a2.f65641b == 1) {
                    i2 = 0;
                }
                a2.f65641b = i2;
                a2.a();
            }
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomCameraUI f65633a;

        e(CustomCameraUI customCameraUI) {
            this.f65633a = customCameraUI;
        }

        public final void onClick(View view) {
            this.f65633a.finish();
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomCameraUI f65634a;

        f(CustomCameraUI customCameraUI) {
            this.f65634a = customCameraUI;
        }

        public final void onClick(View view) {
            this.f65634a.b();
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomCameraUI f65635a;

        g(CustomCameraUI customCameraUI) {
            this.f65635a = customCameraUI;
        }

        public final void onClick(View view) {
            this.f65635a.a(b.a.ON);
            this.f65635a.b();
            this.f65635a.a();
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomCameraUI f65636a;

        h(CustomCameraUI customCameraUI) {
            this.f65636a = customCameraUI;
        }

        public final void onClick(View view) {
            this.f65636a.a(b.a.OFF);
            this.f65636a.b();
            this.f65636a.a();
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomCameraUI f65637a;

        i(CustomCameraUI customCameraUI) {
            this.f65637a = customCameraUI;
        }

        public final void onClick(View view) {
            this.f65637a.a(b.a.AUTO);
            this.f65637a.b();
            this.f65637a.a();
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomCameraUI f65638a;

        j(CustomCameraUI customCameraUI) {
            this.f65638a = customCameraUI;
        }

        public final void onClick(View view) {
            ConstraintLayout constraintLayout = (ConstraintLayout) this.f65638a.a(R.id.pictureLayout);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
            ConstraintLayout constraintLayout2 = (ConstraintLayout) this.f65638a.a(R.id.cameraLayout);
            if (constraintLayout2 != null) {
                constraintLayout2.setVisibility(0);
            }
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomCameraUI f65639a;

        k(CustomCameraUI customCameraUI) {
            this.f65639a = customCameraUI;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
            if (r4.isShowing() == false) goto L_0x0033;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r12) {
            /*
                r11 = this;
                net.one97.paytm.upgradeKyc.camera.CustomCameraUI r12 = r11.f65639a
                android.content.Context r12 = (android.content.Context) r12
                boolean r12 = com.paytm.utility.b.c((android.content.Context) r12)
                java.lang.String r0 = "getString(R.string.err_nonetwork_msg)"
                java.lang.String r1 = "getString(R.string.err_enable_network_heading)"
                if (r12 == 0) goto L_0x01c5
                net.one97.paytm.upgradeKyc.camera.CustomCameraUI r12 = r11.f65639a
                r2 = r12
                android.content.Context r2 = (android.content.Context) r2
                java.lang.String r3 = "Uploading Image"
                java.lang.String r4 = "message"
                kotlin.g.b.k.c(r3, r4)
                if (r2 != 0) goto L_0x0022
                boolean r4 = r12.isFinishing()
                if (r4 == 0) goto L_0x0071
            L_0x0022:
                android.app.ProgressDialog r4 = r12.f65621b
                if (r4 == 0) goto L_0x0033
                android.app.ProgressDialog r4 = r12.f65621b
                if (r4 != 0) goto L_0x002d
                kotlin.g.b.k.a()
            L_0x002d:
                boolean r4 = r4.isShowing()
                if (r4 != 0) goto L_0x0071
            L_0x0033:
                android.app.ProgressDialog r4 = new android.app.ProgressDialog
                r4.<init>(r2)
                r12.f65621b = r4
                android.app.ProgressDialog r2 = r12.f65621b     // Catch:{ Exception -> 0x0070 }
                if (r2 != 0) goto L_0x0041
                kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0070 }
            L_0x0041:
                r4 = 0
                r2.setProgressStyle(r4)     // Catch:{ Exception -> 0x0070 }
                android.app.ProgressDialog r2 = r12.f65621b     // Catch:{ Exception -> 0x0070 }
                if (r2 != 0) goto L_0x004c
                kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0070 }
            L_0x004c:
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x0070 }
                r2.setMessage(r3)     // Catch:{ Exception -> 0x0070 }
                android.app.ProgressDialog r2 = r12.f65621b     // Catch:{ Exception -> 0x0070 }
                if (r2 != 0) goto L_0x0058
                kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0070 }
            L_0x0058:
                r2.setCancelable(r4)     // Catch:{ Exception -> 0x0070 }
                android.app.ProgressDialog r2 = r12.f65621b     // Catch:{ Exception -> 0x0070 }
                if (r2 != 0) goto L_0x0062
                kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0070 }
            L_0x0062:
                r2.setCanceledOnTouchOutside(r4)     // Catch:{ Exception -> 0x0070 }
                android.app.ProgressDialog r12 = r12.f65621b     // Catch:{ Exception -> 0x0070 }
                if (r12 != 0) goto L_0x006c
                kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0070 }
            L_0x006c:
                r12.show()     // Catch:{ Exception -> 0x0070 }
                goto L_0x0071
            L_0x0070:
            L_0x0071:
                net.one97.paytm.upgradeKyc.camera.CustomCameraUI r12 = r11.f65639a
                int r2 = net.one97.paytm.upgradeKyc.R.id.selfie_img
                android.view.View r2 = r12.a((int) r2)
                android.widget.ImageView r2 = (android.widget.ImageView) r2
                r3 = 0
                if (r2 == 0) goto L_0x0083
                android.graphics.drawable.Drawable r2 = r2.getDrawable()
                goto L_0x0084
            L_0x0083:
                r2 = r3
            L_0x0084:
                boolean r4 = r2 instanceof android.graphics.drawable.BitmapDrawable
                if (r4 != 0) goto L_0x0089
                r2 = r3
            L_0x0089:
                android.graphics.drawable.BitmapDrawable r2 = (android.graphics.drawable.BitmapDrawable) r2
                if (r2 == 0) goto L_0x0092
                android.graphics.Bitmap r2 = r2.getBitmap()
                goto L_0x0093
            L_0x0092:
                r2 = r3
            L_0x0093:
                java.lang.String r12 = r12.a((android.graphics.Bitmap) r2)
                if (r12 == 0) goto L_0x01a7
                net.one97.paytm.upgradeKyc.camera.CustomCameraUI r2 = r11.f65639a
                net.one97.paytm.upgradeKyc.helper.d$a r4 = net.one97.paytm.upgradeKyc.helper.d.f66026a
                net.one97.paytm.upgradeKyc.helper.d r4 = net.one97.paytm.upgradeKyc.helper.d.a.a()
                if (r4 == 0) goto L_0x00a9
                java.lang.String r3 = "kyc_selfie_upload_url"
                java.lang.String r3 = net.one97.paytm.upgradeKyc.helper.d.a((java.lang.String) r3)
            L_0x00a9:
                boolean r4 = android.webkit.URLUtil.isValidUrl(r3)
                if (r4 != 0) goto L_0x00b1
                java.lang.String r3 = "https://dms.paytmbank.com/dm/document/v1/uploadDocument"
            L_0x00b1:
                r4 = r2
                android.content.Context r4 = (android.content.Context) r4
                java.lang.String r5 = com.paytm.utility.d.a(r4)
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                boolean r5 = android.text.TextUtils.isEmpty(r5)
                if (r5 != 0) goto L_0x01a3
                boolean r5 = android.webkit.URLUtil.isValidUrl(r3)
                if (r5 == 0) goto L_0x01a3
                java.lang.String r3 = com.paytm.utility.b.e((android.content.Context) r4, (java.lang.String) r3)
                java.util.HashMap r5 = new java.util.HashMap
                r5.<init>()
                java.util.Map r5 = (java.util.Map) r5
                android.content.Context r6 = r2.getApplicationContext()
                java.lang.String r6 = com.paytm.utility.d.a(r6)
                java.lang.String r7 = "CJRNetUtility.getSSOToken(this.applicationContext)"
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
                java.lang.String r7 = "session_token"
                r5.put(r7, r6)
                java.lang.String r6 = com.paytm.utility.b.n((android.content.Context) r4)
                java.lang.String r7 = com.paytm.utility.b.n((android.content.Context) r4)
                org.json.JSONObject r8 = new org.json.JSONObject
                r8.<init>()
                java.lang.String r9 = "application"
                java.lang.String r10 = "paytmApp"
                r8.put(r9, r10)
                java.lang.String r9 = "agentId"
                r8.put(r9, r6)
                java.lang.String r6 = "custId"
                r8.put(r6, r7)
                org.json.JSONArray r6 = new org.json.JSONArray
                r6.<init>()
                org.json.JSONObject r7 = new org.json.JSONObject
                r7.<init>()
                java.lang.String r9 = "ext"
                java.lang.String r10 = "png"
                r7.put(r9, r10)
                java.lang.String r9 = "fileName"
                java.lang.String r10 = "selfie"
                r7.put(r9, r10)
                java.lang.String r9 = "mimeType"
                java.lang.String r10 = "image/jpeg"
                r7.put(r9, r10)
                java.lang.String r9 = "fileStream"
                r7.put(r9, r12)
                r6.put(r7)
                java.lang.String r12 = "documentDetailList"
                r8.put(r12, r6)
                net.one97.paytm.upgradeKyc.helper.a$a r12 = net.one97.paytm.upgradeKyc.helper.a.f66022a
                com.paytm.network.b r12 = net.one97.paytm.upgradeKyc.helper.a.C1317a.a()
                com.paytm.network.b r12 = r12.a((android.content.Context) r4)
                com.paytm.network.a$a r4 = com.paytm.network.a.C0715a.POST
                com.paytm.network.b r12 = r12.a((com.paytm.network.a.C0715a) r4)
                com.paytm.network.b r12 = r12.a((java.util.Map<java.lang.String, java.lang.String>) r5)
                java.lang.String r4 = r8.toString()
                com.paytm.network.b r12 = r12.b((java.lang.String) r4)
                net.one97.paytm.upgradeKyc.data.models.requestotp.SelfieModal r4 = new net.one97.paytm.upgradeKyc.data.models.requestotp.SelfieModal
                r4.<init>()
                com.paytm.network.model.IJRPaytmDataModel r4 = (com.paytm.network.model.IJRPaytmDataModel) r4
                com.paytm.network.b r12 = r12.a((com.paytm.network.model.IJRPaytmDataModel) r4)
                com.paytm.network.b r12 = r12.a((java.lang.String) r3)
                java.lang.Class<net.one97.paytm.upgradeKyc.activity.MinKycPanAadharUpgradeActivity> r3 = net.one97.paytm.upgradeKyc.activity.MinKycPanAadharUpgradeActivity.class
                java.lang.String r3 = r3.getName()
                com.paytm.network.b r12 = r12.c(r3)
                com.paytm.network.a$b r3 = com.paytm.network.a.b.USER_FACING
                com.paytm.network.b r12 = r12.a((com.paytm.network.a.b) r3)
                net.one97.paytm.upgradeKyc.camera.CustomCameraUI$a r3 = new net.one97.paytm.upgradeKyc.camera.CustomCameraUI$a
                r3.<init>(r2)
                com.paytm.network.listener.b r3 = (com.paytm.network.listener.b) r3
                com.paytm.network.b r12 = r12.a((com.paytm.network.listener.b) r3)
                com.paytm.network.a r12 = r12.l()
                java.lang.String r3 = "CommonNetworkMethods.Com…                 .build()"
                kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r3)
                android.content.Context r3 = r2.getApplicationContext()
                boolean r3 = com.paytm.utility.b.c((android.content.Context) r3)
                if (r3 == 0) goto L_0x018a
                r12.a()
                return
            L_0x018a:
                r2.e()
                int r12 = net.one97.paytm.upgradeKyc.R.string.err_enable_network_heading
                java.lang.String r12 = r2.getString(r12)
                kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
                int r1 = net.one97.paytm.upgradeKyc.R.string.err_nonetwork_msg
                java.lang.String r1 = r2.getString(r1)
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r0)
                r2.a((java.lang.String) r12, (java.lang.String) r1)
                return
            L_0x01a3:
                r2.e()
                return
            L_0x01a7:
                net.one97.paytm.upgradeKyc.camera.CustomCameraUI r12 = r11.f65639a
                int r0 = net.one97.paytm.upgradeKyc.R.string.error
                java.lang.String r0 = r12.getString(r0)
                java.lang.String r1 = "getString(R.string.error)"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                net.one97.paytm.upgradeKyc.camera.CustomCameraUI r1 = r11.f65639a
                int r2 = net.one97.paytm.upgradeKyc.R.string.kyc_generic_error
                java.lang.String r1 = r1.getString(r2)
                java.lang.String r2 = "getString(R.string.kyc_generic_error)"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                r12.a((java.lang.String) r0, (java.lang.String) r1)
                return
            L_0x01c5:
                net.one97.paytm.upgradeKyc.camera.CustomCameraUI r12 = r11.f65639a
                int r2 = net.one97.paytm.upgradeKyc.R.string.err_enable_network_heading
                java.lang.String r2 = r12.getString(r2)
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)
                net.one97.paytm.upgradeKyc.camera.CustomCameraUI r1 = r11.f65639a
                int r3 = net.one97.paytm.upgradeKyc.R.string.err_nonetwork_msg
                java.lang.String r1 = r1.getString(r3)
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r0)
                r12.a((java.lang.String) r2, (java.lang.String) r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.camera.CustomCameraUI.k.onClick(android.view.View):void");
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomCameraUI f65631a;

        c(CustomCameraUI customCameraUI) {
            this.f65631a = customCameraUI;
        }

        public final void onClick(View view) {
            this.f65631a.d();
            ConstraintLayout constraintLayout = (ConstraintLayout) this.f65631a.a(R.id.pictureLayout);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
            ConstraintLayout constraintLayout2 = (ConstraintLayout) this.f65631a.a(R.id.cameraLayout);
            if (constraintLayout2 != null) {
                constraintLayout2.setVisibility(0);
            }
        }
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomCameraUI f65627a;

        a(CustomCameraUI customCameraUI) {
            this.f65627a = customCameraUI;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            this.f65627a.e();
            if (iJRPaytmDataModel instanceof SelfieModal) {
                SelfieModal selfieModal = (SelfieModal) iJRPaytmDataModel;
                String error = selfieModal.getError();
                String errorDescription = selfieModal.getErrorDescription();
                if (TextUtils.isEmpty(error) || TextUtils.isEmpty(errorDescription)) {
                    CustomCameraUI customCameraUI = this.f65627a;
                    List<String> keys = selfieModal.getKeys();
                    String str = null;
                    customCameraUI.f65625f = keys != null ? keys.get(0) : null;
                    CustomCameraUI customCameraUI2 = this.f65627a;
                    List<String> keys2 = selfieModal.getKeys();
                    if (keys2 != null) {
                        str = keys2.get(0);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("dmsID", str);
                    intent.putExtra("isSelfiUploaded", !TextUtils.isEmpty(str));
                    customCameraUI2.setResult(-1, intent);
                    customCameraUI2.finish();
                    return;
                }
                CustomCameraUI customCameraUI3 = this.f65627a;
                String string = customCameraUI3.getString(R.string.error);
                kotlin.g.b.k.a((Object) string, "getString(R.string.error)");
                if (errorDescription == null) {
                    kotlin.g.b.k.a();
                }
                customCameraUI3.a(string, errorDescription);
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            this.f65627a.e();
            CustomCameraUI customCameraUI = this.f65627a;
            String alertTitle = networkCustomError.getAlertTitle();
            kotlin.g.b.k.a((Object) alertTitle, "networkCustomError.alertTitle");
            String alertMessage = networkCustomError.getAlertMessage();
            kotlin.g.b.k.a((Object) alertMessage, "networkCustomError.alertMessage");
            customCameraUI.a(alertTitle, alertMessage);
        }
    }

    public final void a(String str, String str2) {
        kotlin.g.b.k.c(str, "errorTitle");
        kotlin.g.b.k.c(str2, ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
        com.paytm.utility.b.b((Context) this, str, str2);
    }

    public final void a() {
        if (this.f65624e == b.a.AUTO) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.iv_flash_camera);
            if (appCompatImageView != null) {
                appCompatImageView.setImageResource(R.drawable.flash_auto);
            }
            TextView textView = (TextView) a(R.id.tv_auto);
            if (textView != null) {
                textView.setTextColor(Color.parseColor("#00B9FF"));
            }
            TextView textView2 = (TextView) a(R.id.tv_on);
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor("#ffffff"));
            }
            TextView textView3 = (TextView) a(R.id.tv_off);
            if (textView3 != null) {
                textView3.setTextColor(Color.parseColor("#ffffff"));
            }
        } else if (this.f65624e == b.a.ON) {
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) a(R.id.iv_flash_camera);
            if (appCompatImageView2 != null) {
                appCompatImageView2.setImageResource(R.drawable.flash_on);
            }
            TextView textView4 = (TextView) a(R.id.tv_auto);
            if (textView4 != null) {
                textView4.setTextColor(Color.parseColor("#ffffff"));
            }
            TextView textView5 = (TextView) a(R.id.tv_on);
            if (textView5 != null) {
                textView5.setTextColor(Color.parseColor("#00B9FF"));
            }
            TextView textView6 = (TextView) a(R.id.tv_off);
            if (textView6 != null) {
                textView6.setTextColor(Color.parseColor("#ffffff"));
            }
        } else if (this.f65624e == b.a.OFF) {
            AppCompatImageView appCompatImageView3 = (AppCompatImageView) a(R.id.iv_flash_camera);
            if (appCompatImageView3 != null) {
                appCompatImageView3.setImageResource(R.drawable.flash_off);
            }
            TextView textView7 = (TextView) a(R.id.tv_auto);
            if (textView7 != null) {
                textView7.setTextColor(Color.parseColor("#ffffff"));
            }
            TextView textView8 = (TextView) a(R.id.tv_on);
            if (textView8 != null) {
                textView8.setTextColor(Color.parseColor("#ffffff"));
            }
            TextView textView9 = (TextView) a(R.id.tv_off);
            if (textView9 != null) {
                textView9.setTextColor(Color.parseColor("#00B9FF"));
            }
        }
        a aVar = this.f65622c;
        if (aVar == null) {
            kotlin.g.b.k.a("camera2");
        }
        b.a aVar2 = this.f65624e;
        kotlin.g.b.k.c(aVar2, "flash");
        try {
            aVar.f65645f = aVar2;
            Context context = aVar.k.getContext();
            kotlin.g.b.k.a((Object) context, "textureView.context");
            if (context.getPackageManager().hasSystemFeature("android.hardware.camera.flash") && aVar.f65644e != null) {
                CaptureRequest.Builder builder = aVar.f65644e;
                if (builder == null) {
                    kotlin.g.b.k.a();
                }
                aVar.a(builder, true);
            }
        } catch (Exception unused) {
        }
    }

    public final void b() {
        if (!this.f65623d) {
            this.f65623d = true;
            TextView textView = (TextView) a(R.id.tv_auto);
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = (TextView) a(R.id.tv_off);
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            TextView textView3 = (TextView) a(R.id.tv_on);
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.iv_rotate_camera);
            if (appCompatImageView != null) {
                appCompatImageView.setVisibility(4);
            }
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) a(R.id.iv_capture_image);
            if (appCompatImageView2 != null) {
                appCompatImageView2.setVisibility(4);
                return;
            }
            return;
        }
        this.f65623d = false;
        TextView textView4 = (TextView) a(R.id.tv_auto);
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        TextView textView5 = (TextView) a(R.id.tv_off);
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        TextView textView6 = (TextView) a(R.id.tv_on);
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) a(R.id.iv_rotate_camera);
        if (appCompatImageView3 != null) {
            appCompatImageView3.setVisibility(0);
        }
        AppCompatImageView appCompatImageView4 = (AppCompatImageView) a(R.id.iv_capture_image);
        if (appCompatImageView4 != null) {
            appCompatImageView4.setVisibility(0);
        }
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        kotlin.g.b.k.c(strArr, "permissions");
        kotlin.g.b.k.c(iArr, "grantResults");
        if (i2 == 1 && iArr[0] == 0) {
            a(false);
            return;
        }
        String string = getString(R.string.camera_grant_permission_error);
        kotlin.g.b.k.a((Object) string, "error");
        kotlin.g.b.k.c(string, "error");
        CharSequence charSequence = string;
        if (!TextUtils.isEmpty(charSequence)) {
            Toast.makeText(this, charSequence, 0).show();
            finish();
        }
    }

    private final void a(boolean z) {
        if (androidx.core.content.b.a((Context) this, "android.permission.CAMERA") != 0) {
            androidx.core.app.a.a(this, new String[]{"android.permission.CAMERA"}, 1);
        } else {
            b(z);
        }
    }

    private final void b(boolean z) {
        AutoFitTextureView autoFitTextureView = (AutoFitTextureView) a(R.id.camera_view);
        kotlin.g.b.k.a((Object) autoFitTextureView, "camera_view");
        this.f65622c = new a(this, autoFitTextureView);
        a();
        if (!z) {
            d();
        }
    }

    private final void f() {
        ImageView imageView = (ImageView) a(R.id.rounrect);
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.top_left_img);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(0);
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) a(R.id.top_right_img);
        if (appCompatImageView2 != null) {
            appCompatImageView2.setVisibility(0);
        }
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) a(R.id.bottom_left_img);
        if (appCompatImageView3 != null) {
            appCompatImageView3.setVisibility(0);
        }
        AppCompatImageView appCompatImageView4 = (AppCompatImageView) a(R.id.bottom_right_img);
        if (appCompatImageView4 != null) {
            appCompatImageView4.setVisibility(0);
        }
    }

    public final void onPause() {
        c();
        super.onPause();
    }

    public final void c() {
        if (this.f65622c != null) {
            a aVar = this.f65622c;
            if (aVar == null) {
                kotlin.g.b.k.a("camera2");
            }
            aVar.b();
        }
    }

    public final void onResume() {
        d();
        super.onResume();
    }

    public final void onDestroy() {
        super.onDestroy();
    }

    public final void d() {
        if (this.f65622c != null) {
            a aVar = this.f65622c;
            if (aVar == null) {
                kotlin.g.b.k.a("camera2");
            }
            aVar.a();
            f();
        }
    }

    public final void e() {
        try {
            if (this.f65621b != null) {
                ProgressDialog progressDialog = this.f65621b;
                if (progressDialog == null) {
                    kotlin.g.b.k.a();
                }
                if (progressDialog.isShowing() && !isFinishing()) {
                    ProgressDialog progressDialog2 = this.f65621b;
                    if (progressDialog2 == null) {
                        kotlin.g.b.k.a();
                    }
                    progressDialog2.dismiss();
                    this.f65621b = null;
                }
            }
        } catch (Exception unused) {
        }
    }
}
