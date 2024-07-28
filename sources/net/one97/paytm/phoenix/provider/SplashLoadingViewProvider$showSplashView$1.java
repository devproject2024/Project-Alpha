package net.one97.paytm.phoenix.provider;

import android.widget.FrameLayout;
import java.lang.ref.WeakReference;

final class SplashLoadingViewProvider$showSplashView$1 implements Runnable {
    final /* synthetic */ WeakReference $activity;
    final /* synthetic */ FrameLayout $containerLayout;
    final /* synthetic */ SplashLoadingViewProvider this$0;

    SplashLoadingViewProvider$showSplashView$1(SplashLoadingViewProvider splashLoadingViewProvider, WeakReference weakReference, FrameLayout frameLayout) {
        this.this$0 = splashLoadingViewProvider;
        this.$activity = weakReference;
        this.$containerLayout = frameLayout;
    }

    /* JADX WARNING: type inference failed for: r1v16, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r5 = this;
            net.one97.paytm.phoenix.provider.SplashLoadingViewProvider r0 = r5.this$0     // Catch:{ Exception -> 0x005e }
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x005e }
            java.lang.ref.WeakReference r2 = r5.$activity     // Catch:{ Exception -> 0x005e }
            java.lang.Object r2 = r2.get()     // Catch:{ Exception -> 0x005e }
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ Exception -> 0x005e }
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)     // Catch:{ Exception -> 0x005e }
            r3 = 2047410245(0x7a090045, float:1.7783753E35)
            r4 = 0
            android.view.View r2 = r2.inflate(r3, r4)     // Catch:{ Exception -> 0x005e }
            r1.<init>(r2)     // Catch:{ Exception -> 0x005e }
            r0.inflatedView = r1     // Catch:{ Exception -> 0x005e }
            net.one97.paytm.phoenix.provider.SplashLoadingViewProvider r0 = r5.this$0     // Catch:{ Exception -> 0x005e }
            net.one97.paytm.phoenix.provider.SplashLoadingViewProvider r1 = r5.this$0     // Catch:{ Exception -> 0x005e }
            java.lang.ref.WeakReference r1 = r1.inflatedView     // Catch:{ Exception -> 0x005e }
            if (r1 == 0) goto L_0x003a
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x005e }
            android.view.View r1 = (android.view.View) r1     // Catch:{ Exception -> 0x005e }
            if (r1 == 0) goto L_0x003a
            r2 = 2047346227(0x7a080633, float:1.7656953E35)
            android.view.View r1 = r1.findViewById(r2)     // Catch:{ Exception -> 0x005e }
            r4 = r1
            com.airbnb.lottie.LottieAnimationView r4 = (com.airbnb.lottie.LottieAnimationView) r4     // Catch:{ Exception -> 0x005e }
        L_0x003a:
            r0.view = r4     // Catch:{ Exception -> 0x005e }
            net.one97.paytm.phoenix.provider.SplashLoadingViewProvider r0 = r5.this$0     // Catch:{ Exception -> 0x005e }
            com.airbnb.lottie.LottieAnimationView r0 = r0.view     // Catch:{ Exception -> 0x005e }
            if (r0 == 0) goto L_0x0048
            net.one97.paytm.common.widgets.a.a(r0)     // Catch:{ Exception -> 0x005e }
        L_0x0048:
            net.one97.paytm.phoenix.provider.SplashLoadingViewProvider r0 = r5.this$0     // Catch:{ Exception -> 0x005e }
            java.lang.ref.WeakReference r0 = r0.inflatedView     // Catch:{ Exception -> 0x005e }
            if (r0 == 0) goto L_0x0062
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x005e }
            android.view.View r0 = (android.view.View) r0     // Catch:{ Exception -> 0x005e }
            if (r0 == 0) goto L_0x0062
            android.widget.FrameLayout r1 = r5.$containerLayout     // Catch:{ Exception -> 0x005e }
            r1.addView(r0)     // Catch:{ Exception -> 0x005e }
            goto L_0x0062
        L_0x005e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0062:
            net.one97.paytm.phoenix.provider.SplashLoadingViewProvider r0 = r5.this$0
            java.lang.ref.WeakReference r0 = r0.inflatedView
            if (r0 == 0) goto L_0x00a5
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            if (r0 == 0) goto L_0x00a5
            java.lang.ref.WeakReference r1 = r5.$activity
            r1.get()
            java.lang.ref.WeakReference r1 = r5.$activity
            java.lang.Object r1 = r1.get()
            boolean r1 = r1 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r1 == 0) goto L_0x00a1
            java.lang.ref.WeakReference r1 = r5.$activity
            java.lang.Object r1 = r1.get()
            if (r1 != 0) goto L_0x008c
            kotlin.g.b.k.a()
        L_0x008c:
            java.lang.String r2 = "activity.get()!!"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            android.app.Activity r1 = (android.app.Activity) r1
            android.content.res.Resources r1 = r1.getResources()
            r2 = 17170443(0x106000b, float:2.4611944E-38)
            int r1 = r1.getColor(r2)
            r0.setBackgroundColor(r1)
        L_0x00a1:
            r1 = 0
            r0.setVisibility(r1)
        L_0x00a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.provider.SplashLoadingViewProvider$showSplashView$1.run():void");
    }
}
