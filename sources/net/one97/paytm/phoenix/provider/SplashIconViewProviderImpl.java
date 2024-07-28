package net.one97.paytm.phoenix.provider;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import java.lang.ref.WeakReference;

public final class SplashIconViewProviderImpl implements SplashIconViewProvider {
    private WeakReference<Activity> activity;
    /* access modifiers changed from: private */
    public WeakReference<View> inflatedView;
    private FrameLayout parentLayout;
    /* access modifiers changed from: private */
    public ProgressBar view;

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x002a, code lost:
        r5 = (android.view.View) r5.get();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showSplashView(java.lang.ref.WeakReference<android.app.Activity> r4, android.widget.FrameLayout r5) {
        /*
            r3 = this;
            java.lang.String r0 = "activity"
            kotlin.g.b.k.c(r4, r0)
            java.lang.String r0 = "containerLayout"
            kotlin.g.b.k.c(r5, r0)
            r3.parentLayout = r5
            r3.activity = r4
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x0092 }
            java.lang.Object r0 = r4.get()     // Catch:{ Exception -> 0x0092 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ Exception -> 0x0092 }
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)     // Catch:{ Exception -> 0x0092 }
            int r1 = net.one97.paytm.phoenix.R.layout.ph5_loading_view     // Catch:{ Exception -> 0x0092 }
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r2)     // Catch:{ Exception -> 0x0092 }
            r5.<init>(r0)     // Catch:{ Exception -> 0x0092 }
            r3.inflatedView = r5     // Catch:{ Exception -> 0x0092 }
            java.lang.ref.WeakReference<android.view.View> r5 = r3.inflatedView     // Catch:{ Exception -> 0x0092 }
            if (r5 == 0) goto L_0x003b
            java.lang.Object r5 = r5.get()     // Catch:{ Exception -> 0x0092 }
            android.view.View r5 = (android.view.View) r5     // Catch:{ Exception -> 0x0092 }
            if (r5 == 0) goto L_0x003b
            int r0 = net.one97.paytm.phoenix.R.id.ph5_animation_view     // Catch:{ Exception -> 0x0092 }
            android.view.View r5 = r5.findViewById(r0)     // Catch:{ Exception -> 0x0092 }
            android.widget.ProgressBar r5 = (android.widget.ProgressBar) r5     // Catch:{ Exception -> 0x0092 }
            goto L_0x003c
        L_0x003b:
            r5 = r2
        L_0x003c:
            r3.view = r5     // Catch:{ Exception -> 0x0092 }
            java.lang.ref.WeakReference<android.view.View> r5 = r3.inflatedView     // Catch:{ Exception -> 0x0092 }
            if (r5 == 0) goto L_0x0096
            java.lang.Object r5 = r5.get()     // Catch:{ Exception -> 0x0092 }
            android.view.View r5 = (android.view.View) r5     // Catch:{ Exception -> 0x0092 }
            if (r5 == 0) goto L_0x0096
            java.lang.Object r0 = r4.get()     // Catch:{ Exception -> 0x0092 }
            boolean r0 = r0 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity     // Catch:{ Exception -> 0x0092 }
            if (r0 == 0) goto L_0x0096
            java.lang.Object r0 = r4.get()     // Catch:{ Exception -> 0x0092 }
            android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ Exception -> 0x0092 }
            if (r0 == 0) goto L_0x0068
            r1 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r1)     // Catch:{ Exception -> 0x0092 }
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0     // Catch:{ Exception -> 0x0092 }
            if (r0 == 0) goto L_0x0068
            r0.addView(r5)     // Catch:{ Exception -> 0x0092 }
        L_0x0068:
            android.widget.ProgressBar r5 = r3.view     // Catch:{ Exception -> 0x0092 }
            if (r5 == 0) goto L_0x0096
            java.lang.Object r0 = r4.get()     // Catch:{ Exception -> 0x0092 }
            android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ Exception -> 0x0092 }
            if (r0 == 0) goto L_0x008a
            net.one97.paytm.phoenix.ui.PhoenixActivity r0 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r0     // Catch:{ Exception -> 0x0092 }
            if (r0 == 0) goto L_0x0082
            net.one97.paytm.phoenix.provider.PhoenixProgressHandler r0 = r0.f59611i     // Catch:{ Exception -> 0x0092 }
            int r0 = r0.getProgress()     // Catch:{ Exception -> 0x0092 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0092 }
        L_0x0082:
            int r0 = r2.intValue()     // Catch:{ Exception -> 0x0092 }
            r5.setProgress(r0)     // Catch:{ Exception -> 0x0092 }
            goto L_0x0096
        L_0x008a:
            kotlin.u r5 = new kotlin.u     // Catch:{ Exception -> 0x0092 }
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r5.<init>(r0)     // Catch:{ Exception -> 0x0092 }
            throw r5     // Catch:{ Exception -> 0x0092 }
        L_0x0092:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0096:
            java.lang.ref.WeakReference<android.view.View> r5 = r3.inflatedView
            if (r5 == 0) goto L_0x00cf
            java.lang.Object r5 = r5.get()
            android.view.View r5 = (android.view.View) r5
            if (r5 == 0) goto L_0x00cf
            r4.get()
            java.lang.Object r0 = r4.get()
            boolean r0 = r0 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r0 == 0) goto L_0x00cb
            java.lang.Object r4 = r4.get()
            if (r4 != 0) goto L_0x00b6
            kotlin.g.b.k.a()
        L_0x00b6:
            java.lang.String r0 = "activity.get()!!"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            android.app.Activity r4 = (android.app.Activity) r4
            android.content.res.Resources r4 = r4.getResources()
            r0 = 17170443(0x106000b, float:2.4611944E-38)
            int r4 = r4.getColor(r0)
            r5.setBackgroundColor(r4)
        L_0x00cb:
            r4 = 0
            r5.setVisibility(r4)
        L_0x00cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.provider.SplashIconViewProviderImpl.showSplashView(java.lang.ref.WeakReference, android.widget.FrameLayout):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.lang.Object} */
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
            r0 = 0
            r1.f59610h = r0
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
            net.one97.paytm.phoenix.provider.SplashIconViewProviderImpl$hideSplashView$1 r1 = new net.one97.paytm.phoenix.provider.SplashIconViewProviderImpl$hideSplashView$1
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.provider.SplashIconViewProviderImpl.hideSplashView():void");
    }

    public final void updateProgress(int i2) {
        ProgressBar progressBar = this.view;
        if (progressBar != null && progressBar != null) {
            progressBar.setProgress(i2);
        }
    }
}
