package com.google.androidbrowserhelper.trusted.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.browser.customtabs.f;
import androidx.browser.trusted.h;
import com.google.androidbrowserhelper.trusted.a.b;

public final class a implements c {

    /* renamed from: d  reason: collision with root package name */
    private static d f37631d = new d();

    /* renamed from: a  reason: collision with root package name */
    public b f37632a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37633b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f37634c;

    /* renamed from: e  reason: collision with root package name */
    private final Activity f37635e;

    /* renamed from: f  reason: collision with root package name */
    private final int f37636f;

    /* renamed from: g  reason: collision with root package name */
    private final int f37637g;

    /* renamed from: h  reason: collision with root package name */
    private final ImageView.ScaleType f37638h;

    /* renamed from: i  reason: collision with root package name */
    private final Matrix f37639i;
    private final String j;
    private final int k;
    private Bitmap l;
    private String m;
    private boolean n;

    public a(Activity activity, int i2, int i3, ImageView.ScaleType scaleType, int i4, String str) {
        this.f37633b = Build.VERSION.SDK_INT < 21;
        this.f37636f = i2;
        this.f37637g = i3;
        this.f37638h = scaleType;
        this.f37639i = null;
        this.f37635e = activity;
        this.j = str;
        this.k = i4;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Integer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r8, androidx.browser.trusted.h r9) {
        /*
            r7 = this;
            r7.m = r8
            android.app.Activity r0 = r7.f37635e
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            java.lang.String r2 = "android.support.customtabs.action.CustomTabsService"
            android.content.Intent r1 = r1.setAction(r2)
            android.content.Intent r1 = r1.setPackage(r8)
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            r2 = 64
            android.content.pm.ResolveInfo r0 = r0.resolveService(r1, r2)
            r1 = 0
            if (r0 == 0) goto L_0x002e
            android.content.IntentFilter r2 = r0.filter
            if (r2 != 0) goto L_0x0025
            goto L_0x002e
        L_0x0025:
            android.content.IntentFilter r0 = r0.filter
            java.lang.String r2 = "androidx.browser.trusted.category.TrustedWebActivitySplashScreensV1"
            boolean r0 = r0.hasCategory(r2)
            goto L_0x002f
        L_0x002e:
            r0 = 0
        L_0x002f:
            r7.n = r0
            boolean r0 = r7.n
            if (r0 != 0) goto L_0x0045
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "Provider "
            r9.<init>(r0)
            r9.append(r8)
            java.lang.String r8 = " doesn't support splash screens"
            r9.append(r8)
            return
        L_0x0045:
            android.app.Activity r0 = r7.f37635e
            int r2 = r7.f37636f
            android.graphics.drawable.Drawable r0 = androidx.core.content.b.a((android.content.Context) r0, (int) r2)
            r2 = 0
            if (r0 != 0) goto L_0x0052
            r3 = r2
            goto L_0x0077
        L_0x0052:
            android.graphics.drawable.Drawable r0 = androidx.core.graphics.drawable.a.f(r0)
            int r3 = r0.getIntrinsicWidth()
            int r4 = r0.getIntrinsicHeight()
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r3, r4, r5)
            android.graphics.Canvas r4 = new android.graphics.Canvas
            r4.<init>(r3)
            int r5 = r4.getWidth()
            int r6 = r4.getHeight()
            r0.setBounds(r1, r1, r5, r6)
            r0.draw(r4)
        L_0x0077:
            r7.l = r3
            android.graphics.Bitmap r0 = r7.l
            r1 = -1
            if (r0 == 0) goto L_0x00ac
            android.widget.ImageView r0 = new android.widget.ImageView
            android.app.Activity r3 = r7.f37635e
            r0.<init>(r3)
            android.view.ViewGroup$LayoutParams r3 = new android.view.ViewGroup$LayoutParams
            r3.<init>(r1, r1)
            r0.setLayoutParams(r3)
            android.graphics.Bitmap r3 = r7.l
            r0.setImageBitmap(r3)
            int r3 = r7.f37637g
            r0.setBackgroundColor(r3)
            android.widget.ImageView$ScaleType r3 = r7.f37638h
            r0.setScaleType(r3)
            android.widget.ImageView$ScaleType r3 = r7.f37638h
            android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.MATRIX
            if (r3 != r4) goto L_0x00a7
            android.graphics.Matrix r3 = r7.f37639i
            r0.setImageMatrix(r3)
        L_0x00a7:
            android.app.Activity r3 = r7.f37635e
            r3.setContentView(r0)
        L_0x00ac:
            android.graphics.Bitmap r0 = r7.l
            if (r0 == 0) goto L_0x0167
            com.google.androidbrowserhelper.trusted.a.d r0 = f37631d
            android.app.Activity r3 = r7.f37635e
            androidx.browser.customtabs.d$a r4 = r9.f1944b
            androidx.browser.customtabs.d r4 = r4.c()
            android.content.Intent r4 = r4.f1901a
            com.google.androidbrowserhelper.trusted.a.d$a r5 = r0.b(r3, r8)
            boolean r5 = r5.f37650a
            if (r5 == 0) goto L_0x00e4
            boolean r0 = r0.a((android.content.Context) r3, (java.lang.String) r8)
            if (r0 == 0) goto L_0x00d5
            int r0 = com.google.androidbrowserhelper.trusted.a.d.a((android.content.Context) r3, (androidx.browser.trusted.h) r9)
            androidx.browser.customtabs.a r0 = androidx.browser.customtabs.d.a((android.content.Intent) r4, (int) r0)
            java.lang.Integer r0 = r0.f1875c
            goto L_0x00f0
        L_0x00d5:
            android.os.Bundle r0 = r4.getExtras()
            if (r0 == 0) goto L_0x00ef
            java.lang.String r1 = "androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR"
            java.lang.Object r0 = r0.get(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            goto L_0x00f0
        L_0x00e4:
            boolean r0 = com.google.androidbrowserhelper.trusted.a.a(r8)
            if (r0 == 0) goto L_0x00ef
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
            goto L_0x00f0
        L_0x00ef:
            r0 = r2
        L_0x00f0:
            r1 = 21
            if (r0 == 0) goto L_0x0116
            android.app.Activity r3 = r7.f37635e
            int r0 = r0.intValue()
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r1) goto L_0x0116
            android.view.Window r4 = r3.getWindow()
            r4.setNavigationBarColor(r0)
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 26
            if (r4 < r5) goto L_0x0116
            boolean r0 = com.google.androidbrowserhelper.trusted.g.a((int) r0)
            if (r0 == 0) goto L_0x0116
            r0 = 16
            com.google.androidbrowserhelper.trusted.g.a(r3, r0)
        L_0x0116:
            com.google.androidbrowserhelper.trusted.a.d r0 = f37631d
            android.app.Activity r3 = r7.f37635e
            androidx.browser.customtabs.d$a r4 = r9.f1944b
            androidx.browser.customtabs.d r4 = r4.c()
            android.content.Intent r4 = r4.f1901a
            boolean r8 = r0.a((android.content.Context) r3, (java.lang.String) r8)
            if (r8 == 0) goto L_0x0133
            int r8 = com.google.androidbrowserhelper.trusted.a.d.a((android.content.Context) r3, (androidx.browser.trusted.h) r9)
            androidx.browser.customtabs.a r8 = androidx.browser.customtabs.d.a((android.content.Intent) r4, (int) r8)
            java.lang.Integer r2 = r8.f1873a
            goto L_0x0143
        L_0x0133:
            android.os.Bundle r8 = r4.getExtras()
            if (r8 != 0) goto L_0x013a
            goto L_0x0143
        L_0x013a:
            java.lang.String r9 = "android.support.customtabs.extra.TOOLBAR_COLOR"
            java.lang.Object r8 = r8.get(r9)
            r2 = r8
            java.lang.Integer r2 = (java.lang.Integer) r2
        L_0x0143:
            if (r2 == 0) goto L_0x0167
            android.app.Activity r8 = r7.f37635e
            int r9 = r2.intValue()
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r1) goto L_0x0167
            android.view.Window r0 = r8.getWindow()
            r0.setStatusBarColor(r9)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            if (r0 < r1) goto L_0x0167
            boolean r9 = com.google.androidbrowserhelper.trusted.g.a((int) r9)
            if (r9 == 0) goto L_0x0167
            r9 = 8192(0x2000, float:1.14794E-41)
            com.google.androidbrowserhelper.trusted.g.a(r8, r9)
        L_0x0167:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.androidbrowserhelper.trusted.a.a.a(java.lang.String, androidx.browser.trusted.h):void");
    }

    public final void a(h hVar, f fVar, Runnable runnable) {
        if (!this.n || this.l == null) {
            runnable.run();
        } else if (TextUtils.isEmpty(this.j)) {
            runnable.run();
        } else {
            this.f37632a = new b(this.f37635e, this.l, this.j, fVar, this.m);
            b bVar = this.f37632a;
            $$Lambda$a$KvgDVcth7S3uKjzAeK2Fq5rHKo r0 = new b.a(hVar, runnable) {
                private final /* synthetic */ h f$1;
                private final /* synthetic */ Runnable f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onFinished(boolean z) {
                    a.this.a(this.f$1, this.f$2, z);
                }
            };
            if (b.f37640c || bVar.f37642b.getStatus() == AsyncTask.Status.PENDING) {
                bVar.f37641a = r0;
                bVar.f37642b.execute(new Void[0]);
                return;
            }
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Runnable runnable) {
        runnable.run();
        this.f37635e.overridePendingTransition(0, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(h hVar, Runnable runnable, boolean z) {
        if (!z) {
            runnable.run();
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("androidx.browser.trusted.KEY_SPLASH_SCREEN_VERSION", "androidx.browser.trusted.category.TrustedWebActivitySplashScreensV1");
        bundle.putInt("androidx.browser.trusted.KEY_SPLASH_SCREEN_FADE_OUT_DURATION", this.k);
        bundle.putInt("androidx.browser.trusted.trusted.KEY_SPLASH_SCREEN_BACKGROUND_COLOR", this.f37637g);
        bundle.putInt("androidx.browser.trusted.KEY_SPLASH_SCREEN_SCALE_TYPE", this.f37638h.ordinal());
        Matrix matrix = this.f37639i;
        if (matrix != null) {
            float[] fArr = new float[9];
            matrix.getValues(fArr);
            bundle.putFloatArray("androidx.browser.trusted.KEY_SPLASH_SCREEN_TRANSFORMATION_MATRIX", fArr);
        }
        hVar.f1946d = bundle;
        $$Lambda$a$fMuoUjihSjAi2n5WTYbbCkebgM r3 = new Runnable(runnable) {
            private final /* synthetic */ Runnable f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                a.this.a(this.f$1);
            }
        };
        if (this.f37633b) {
            r3.run();
        } else {
            this.f37634c = r3;
        }
    }
}
