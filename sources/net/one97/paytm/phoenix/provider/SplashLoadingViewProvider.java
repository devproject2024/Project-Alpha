package net.one97.paytm.phoenix.provider;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import java.lang.ref.WeakReference;
import kotlin.g.b.k;

public final class SplashLoadingViewProvider implements SplashIconViewProvider {
    private WeakReference<Activity> activity;
    /* access modifiers changed from: private */
    public WeakReference<View> inflatedView;
    private FrameLayout parentLayout;
    /* access modifiers changed from: private */
    public LottieAnimationView view;

    public final void updateProgress(int i2) {
    }

    public final void showSplashView(WeakReference<Activity> weakReference, FrameLayout frameLayout) {
        k.c(weakReference, "activity");
        k.c(frameLayout, "containerLayout");
        this.parentLayout = frameLayout;
        this.activity = weakReference;
        Activity activity2 = (Activity) weakReference.get();
        if (activity2 != null) {
            activity2.runOnUiThread(new SplashLoadingViewProvider$showSplashView$1(this, weakReference, frameLayout));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: android.app.Activity} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void hideSplashView() {
        /*
            r2 = this;
            android.widget.FrameLayout r0 = r2.parentLayout
            if (r0 == 0) goto L_0x0047
            java.lang.ref.WeakReference<android.app.Activity> r0 = r2.activity
            r1 = 0
            if (r0 == 0) goto L_0x0010
            java.lang.Object r0 = r0.get()
            android.app.Activity r0 = (android.app.Activity) r0
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            boolean r0 = r0 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r0 == 0) goto L_0x0030
            java.lang.ref.WeakReference<android.app.Activity> r0 = r2.activity
            if (r0 == 0) goto L_0x0020
            java.lang.Object r0 = r0.get()
            r1 = r0
            android.app.Activity r1 = (android.app.Activity) r1
        L_0x0020:
            if (r1 == 0) goto L_0x0028
            net.one97.paytm.phoenix.ui.PhoenixActivity r1 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r1
            r1.a()
            goto L_0x0030
        L_0x0028:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r0.<init>(r1)
            throw r0
        L_0x0030:
            java.lang.ref.WeakReference<android.app.Activity> r0 = r2.activity
            if (r0 == 0) goto L_0x0046
            java.lang.Object r0 = r0.get()
            android.app.Activity r0 = (android.app.Activity) r0
            if (r0 == 0) goto L_0x0046
            net.one97.paytm.phoenix.provider.SplashLoadingViewProvider$hideSplashView$1 r1 = new net.one97.paytm.phoenix.provider.SplashLoadingViewProvider$hideSplashView$1
            r1.<init>(r2)
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r0.runOnUiThread(r1)
        L_0x0046:
            return
        L_0x0047:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "showSplashView must be called before hiding it"
            r0.<init>(r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.provider.SplashLoadingViewProvider.hideSplashView():void");
    }
}
