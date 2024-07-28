package net.one97.paytm.phoenix.provider;

import android.app.Activity;

final class PhoenixLoadingViewProviderImpl$showLoadingView$1 implements Runnable {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ PhoenixLoadingViewProviderImpl this$0;

    PhoenixLoadingViewProviderImpl$showLoadingView$1(PhoenixLoadingViewProviderImpl phoenixLoadingViewProviderImpl, Activity activity) {
        this.this$0 = phoenixLoadingViewProviderImpl;
        this.$activity = activity;
    }

    /* JADX WARNING: type inference failed for: r2v10, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r5 = this;
            net.one97.paytm.phoenix.provider.PhoenixLoadingViewProviderImpl r0 = r5.this$0     // Catch:{ Exception -> 0x005c }
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x005c }
            android.app.Activity r2 = r5.$activity     // Catch:{ Exception -> 0x005c }
            android.view.LayoutInflater r2 = r2.getLayoutInflater()     // Catch:{ Exception -> 0x005c }
            int r3 = net.one97.paytm.phoenix.R.layout.ph5_loading_view     // Catch:{ Exception -> 0x005c }
            r4 = 0
            android.view.View r2 = r2.inflate(r3, r4)     // Catch:{ Exception -> 0x005c }
            r1.<init>(r2)     // Catch:{ Exception -> 0x005c }
            r0.inflatedView = r1     // Catch:{ Exception -> 0x005c }
            net.one97.paytm.phoenix.provider.PhoenixLoadingViewProviderImpl r0 = r5.this$0     // Catch:{ Exception -> 0x005c }
            java.lang.ref.WeakReference r0 = r0.inflatedView     // Catch:{ Exception -> 0x005c }
            if (r0 == 0) goto L_0x0060
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x005c }
            android.view.View r0 = (android.view.View) r0     // Catch:{ Exception -> 0x005c }
            if (r0 == 0) goto L_0x0060
            net.one97.paytm.phoenix.provider.PhoenixLoadingViewProviderImpl r1 = r5.this$0     // Catch:{ Exception -> 0x005c }
            net.one97.paytm.phoenix.provider.PhoenixLoadingViewProviderImpl r2 = r5.this$0     // Catch:{ Exception -> 0x005c }
            java.lang.ref.WeakReference r2 = r2.inflatedView     // Catch:{ Exception -> 0x005c }
            if (r2 == 0) goto L_0x0042
            java.lang.Object r2 = r2.get()     // Catch:{ Exception -> 0x005c }
            android.view.View r2 = (android.view.View) r2     // Catch:{ Exception -> 0x005c }
            if (r2 == 0) goto L_0x0042
            int r3 = net.one97.paytm.phoenix.R.id.ph5_animation_view     // Catch:{ Exception -> 0x005c }
            android.view.View r2 = r2.findViewById(r3)     // Catch:{ Exception -> 0x005c }
            r4 = r2
            android.widget.ProgressBar r4 = (android.widget.ProgressBar) r4     // Catch:{ Exception -> 0x005c }
        L_0x0042:
            r1.view = r4     // Catch:{ Exception -> 0x005c }
            android.app.Activity r1 = r5.$activity     // Catch:{ Exception -> 0x005c }
            boolean r1 = r1 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity     // Catch:{ Exception -> 0x005c }
            if (r1 == 0) goto L_0x0060
            android.app.Activity r1 = r5.$activity     // Catch:{ Exception -> 0x005c }
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r1 = r1.findViewById(r2)     // Catch:{ Exception -> 0x005c }
            android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1     // Catch:{ Exception -> 0x005c }
            if (r1 == 0) goto L_0x0060
            r1.addView(r0)     // Catch:{ Exception -> 0x005c }
            goto L_0x0060
        L_0x005c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0060:
            net.one97.paytm.phoenix.provider.PhoenixLoadingViewProviderImpl r0 = r5.this$0
            java.lang.ref.WeakReference r0 = r0.inflatedView
            if (r0 == 0) goto L_0x008a
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            if (r0 == 0) goto L_0x008a
            android.app.Activity r1 = r5.$activity
            boolean r2 = r1 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r2 == 0) goto L_0x0086
            net.one97.paytm.phoenix.ui.PhoenixActivity r1 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r1
            android.content.res.Resources r1 = r1.getResources()
            r2 = 17170445(0x106000d, float:2.461195E-38)
            int r1 = r1.getColor(r2)
            r0.setBackgroundColor(r1)
        L_0x0086:
            r1 = 0
            r0.setVisibility(r1)
        L_0x008a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.provider.PhoenixLoadingViewProviderImpl$showLoadingView$1.run():void");
    }
}
