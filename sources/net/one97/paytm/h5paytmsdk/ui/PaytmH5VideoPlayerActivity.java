package net.one97.paytm.h5paytmsdk.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.g.b.k;
import net.one97.paytm.h5paytmsdk.videoplayer.PaytmH5VideoPlayerImpl;

public class PaytmH5VideoPlayerActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final a f17113a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final Handler f17114b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    private PaytmH5VideoPlayerImpl f17115c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17116d;

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f17117e = new c(this);

    /* renamed from: f  reason: collision with root package name */
    private final Runnable f17118f = new b(this);

    public static final /* synthetic */ PaytmH5VideoPlayerImpl a(PaytmH5VideoPlayerActivity paytmH5VideoPlayerActivity) {
        PaytmH5VideoPlayerImpl paytmH5VideoPlayerImpl = paytmH5VideoPlayerActivity.f17115c;
        if (paytmH5VideoPlayerImpl == null) {
            k.a("videoPlayer");
        }
        return paytmH5VideoPlayerImpl;
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmH5VideoPlayerActivity f17120a;

        c(PaytmH5VideoPlayerActivity paytmH5VideoPlayerActivity) {
            this.f17120a = paytmH5VideoPlayerActivity;
        }

        public final void run() {
            PaytmH5VideoPlayerActivity.a(this.f17120a).setSystemUiVisibility(4871);
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmH5VideoPlayerActivity f17119a;

        b(PaytmH5VideoPlayerActivity paytmH5VideoPlayerActivity) {
            this.f17119a = paytmH5VideoPlayerActivity;
        }

        public final void run() {
            PaytmH5VideoPlayerActivity.b(this.f17119a);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r6 = r6.getExtras();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r6) {
        /*
            r5 = this;
            super.onCreate(r6)
            int r6 = net.one97.paytm.h5paytmsdk.R.layout.ph5_activity_fullscreen
            r5.setContentView((int) r6)
            android.content.Intent r6 = r5.getIntent()
            r0 = 0
            if (r6 == 0) goto L_0x001d
            android.os.Bundle r6 = r6.getExtras()
            if (r6 == 0) goto L_0x001d
            java.lang.String r1 = "videoUrl"
            java.lang.String r6 = r6.getString(r1)
            goto L_0x001e
        L_0x001d:
            r6 = r0
        L_0x001e:
            android.content.Intent r1 = r5.getIntent()
            if (r1 == 0) goto L_0x0031
            android.os.Bundle r1 = r1.getExtras()
            if (r1 == 0) goto L_0x0031
            java.lang.String r0 = "title"
            java.lang.String r0 = r1.getString(r0)
        L_0x0031:
            r1 = 1
            r5.f17116d = r1
            int r2 = net.one97.paytm.h5paytmsdk.R.id.h5_vp
            android.view.View r2 = r5.findViewById(r2)
            if (r2 != 0) goto L_0x003f
            kotlin.g.b.k.a()
        L_0x003f:
            net.one97.paytm.h5paytmsdk.videoplayer.PaytmH5VideoPlayerImpl r2 = (net.one97.paytm.h5paytmsdk.videoplayer.PaytmH5VideoPlayerImpl) r2
            r5.f17115c = r2
            net.one97.paytm.h5paytmsdk.videoplayer.PaytmH5VideoPlayerImpl r2 = r5.f17115c
            if (r2 != 0) goto L_0x004d
            java.lang.String r3 = "videoPlayer"
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x004d:
            android.net.Uri r3 = android.net.Uri.parse(r6)
            java.lang.String r4 = "Uri.parse(videoUrl)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            r2.setSource(r3)
            androidx.appcompat.widget.Toolbar r3 = r2.getToolbar()
            r4 = r0
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setTitle((java.lang.CharSequence) r4)
            int r4 = net.one97.paytm.h5paytmsdk.R.drawable.abc_ic_ab_back_material
            r3.setNavigationIcon((int) r4)
            net.one97.paytm.h5paytmsdk.ui.PaytmH5VideoPlayerActivity$d r4 = new net.one97.paytm.h5paytmsdk.ui.PaytmH5VideoPlayerActivity$d
            r4.<init>(r5, r6, r0)
            android.view.View$OnClickListener r4 = (android.view.View.OnClickListener) r4
            r3.setNavigationOnClickListener(r4)
            r2.setHideControlsOnPlay(r1)
            net.one97.paytm.h5paytmsdk.ui.PaytmH5VideoPlayerActivity$e r6 = new net.one97.paytm.h5paytmsdk.ui.PaytmH5VideoPlayerActivity$e
            r6.<init>()
            net.one97.paytm.h5paytmsdk.videoplayer.a r6 = (net.one97.paytm.h5paytmsdk.videoplayer.a) r6
            r2.setCallback(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.h5paytmsdk.ui.PaytmH5VideoPlayerActivity.onCreate(android.os.Bundle):void");
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmH5VideoPlayerActivity f17121a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17122b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f17123c;

        d(PaytmH5VideoPlayerActivity paytmH5VideoPlayerActivity, String str, String str2) {
            this.f17121a = paytmH5VideoPlayerActivity;
            this.f17122b = str;
            this.f17123c = str2;
        }

        public final void onClick(View view) {
            this.f17121a.onBackPressed();
        }
    }

    public static final class e implements net.one97.paytm.h5paytmsdk.videoplayer.a {
        e() {
        }

        public final void a(PaytmH5VideoPlayerImpl paytmH5VideoPlayerImpl) {
            k.c(paytmH5VideoPlayerImpl, "player");
            com.alipay.iap.android.common.b.c.c();
        }

        public final void b(PaytmH5VideoPlayerImpl paytmH5VideoPlayerImpl) {
            k.c(paytmH5VideoPlayerImpl, "player");
            com.alipay.iap.android.common.b.c.c();
        }

        public final void c(PaytmH5VideoPlayerImpl paytmH5VideoPlayerImpl) {
            k.c(paytmH5VideoPlayerImpl, "player");
            com.alipay.iap.android.common.b.c.c();
        }

        public final void d(PaytmH5VideoPlayerImpl paytmH5VideoPlayerImpl) {
            k.c(paytmH5VideoPlayerImpl, "player");
            com.alipay.iap.android.common.b.c.c();
        }

        public final void a(int i2) {
            "onBuffering ".concat(String.valueOf(i2));
            com.alipay.iap.android.common.b.c.c();
        }

        public final void a(PaytmH5VideoPlayerImpl paytmH5VideoPlayerImpl, Exception exc) {
            k.c(paytmH5VideoPlayerImpl, "player");
            k.c(exc, "e");
            new StringBuilder("onError ").append(exc.getMessage());
            com.alipay.iap.android.common.b.c.c();
        }

        public final void e(PaytmH5VideoPlayerImpl paytmH5VideoPlayerImpl) {
            k.c(paytmH5VideoPlayerImpl, "player");
            com.alipay.iap.android.common.b.c.c();
        }

        public final void f(PaytmH5VideoPlayerImpl paytmH5VideoPlayerImpl) {
            k.c(paytmH5VideoPlayerImpl, "player");
            com.alipay.iap.android.common.b.c.c();
        }
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.f17114b.removeCallbacks(this.f17118f);
        this.f17114b.postDelayed(this.f17118f, 100);
    }

    public void attachBaseContext(Context context) {
        k.c(context, "newBase");
        super.attachBaseContext(context);
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void b(PaytmH5VideoPlayerActivity paytmH5VideoPlayerActivity) {
        ActionBar supportActionBar = paytmH5VideoPlayerActivity.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.f();
        }
        paytmH5VideoPlayerActivity.f17116d = false;
        paytmH5VideoPlayerActivity.f17114b.postDelayed(paytmH5VideoPlayerActivity.f17117e, 300);
    }
}
