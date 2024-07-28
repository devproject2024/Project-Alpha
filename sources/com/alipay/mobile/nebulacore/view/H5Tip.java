package com.alipay.mobile.nebulacore.view;

import android.os.Handler;
import android.widget.PopupWindow;
import com.alipay.mobile.nebula.util.H5Log;

public class H5Tip {
    public static final String TAG = "H5Tip";
    static Handler handler;
    private static volatile PopupWindow popWindow;
    static Runnable task;

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        r3 = (android.widget.Button) r7.findViewById(com.alipay.mobile.nebulacore.R.id.h5_false_image);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        if (android.text.TextUtils.isEmpty(r9) != false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
        ((android.widget.TextView) r7.findViewById(com.alipay.mobile.nebulacore.R.id.h5_description)).setText(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        popWindow.setFocusable(false);
        popWindow.setTouchable(true);
        popWindow.setOutsideTouchable(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005a, code lost:
        if (r0 != false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        popWindow.showAsDropDown(r8, 0, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0062, code lost:
        popWindow.showAtLocation(r8, 48, 0, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006a, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006b, code lost:
        com.alipay.mobile.nebula.util.H5Log.e(TAG, "exception detail.", r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void showTip(android.content.Context r7, android.view.ViewGroup r8, java.lang.String r9) {
        /*
            int r0 = r8.getVisibility()
            r1 = 1
            r2 = 0
            r3 = 8
            if (r0 != r3) goto L_0x000c
            r0 = 1
            goto L_0x000d
        L_0x000c:
            r0 = 0
        L_0x000d:
            java.lang.Class<com.alipay.mobile.nebulacore.view.H5Tip> r3 = com.alipay.mobile.nebulacore.view.H5Tip.class
            monitor-enter(r3)
            android.widget.PopupWindow r4 = popWindow     // Catch:{ all -> 0x0094 }
            if (r4 == 0) goto L_0x001e
            android.widget.PopupWindow r4 = popWindow     // Catch:{ all -> 0x0094 }
            boolean r4 = r4.isShowing()     // Catch:{ all -> 0x0094 }
            if (r4 == 0) goto L_0x001e
            monitor-exit(r3)     // Catch:{ all -> 0x0094 }
            return
        L_0x001e:
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)     // Catch:{ all -> 0x0094 }
            int r4 = com.alipay.mobile.nebulacore.R.layout.h5_tip     // Catch:{ all -> 0x0094 }
            android.view.View r7 = r7.inflate(r4, r8, r2)     // Catch:{ all -> 0x0094 }
            android.widget.PopupWindow r4 = new android.widget.PopupWindow     // Catch:{ all -> 0x0094 }
            r5 = -1
            r6 = -2
            r4.<init>(r7, r5, r6, r2)     // Catch:{ all -> 0x0094 }
            popWindow = r4     // Catch:{ all -> 0x0094 }
            monitor-exit(r3)     // Catch:{ all -> 0x0094 }
            int r3 = com.alipay.mobile.nebulacore.R.id.h5_false_image
            android.view.View r3 = r7.findViewById(r3)
            android.widget.Button r3 = (android.widget.Button) r3
            boolean r4 = android.text.TextUtils.isEmpty(r9)
            if (r4 != 0) goto L_0x004b
            int r4 = com.alipay.mobile.nebulacore.R.id.h5_description
            android.view.View r7 = r7.findViewById(r4)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r7.setText(r9)
        L_0x004b:
            android.widget.PopupWindow r7 = popWindow
            r7.setFocusable(r2)
            android.widget.PopupWindow r7 = popWindow
            r7.setTouchable(r1)
            android.widget.PopupWindow r7 = popWindow
            r7.setOutsideTouchable(r1)
            if (r0 != 0) goto L_0x0062
            android.widget.PopupWindow r7 = popWindow     // Catch:{ Exception -> 0x006a }
            r7.showAsDropDown(r8, r2, r2)     // Catch:{ Exception -> 0x006a }
            goto L_0x0072
        L_0x0062:
            android.widget.PopupWindow r7 = popWindow     // Catch:{ Exception -> 0x006a }
            r9 = 48
            r7.showAtLocation(r8, r9, r2, r2)     // Catch:{ Exception -> 0x006a }
            goto L_0x0072
        L_0x006a:
            r7 = move-exception
            java.lang.String r8 = "H5Tip"
            java.lang.String r9 = "exception detail."
            com.alipay.mobile.nebula.util.H5Log.e(r8, r9, r7)
        L_0x0072:
            com.alipay.mobile.nebulacore.view.H5Tip$1 r7 = new com.alipay.mobile.nebulacore.view.H5Tip$1
            r7.<init>()
            r3.setOnClickListener(r7)
            com.alipay.mobile.nebulacore.view.H5Tip$2 r7 = new com.alipay.mobile.nebulacore.view.H5Tip$2
            r7.<init>()
            task = r7
            android.os.Handler r7 = new android.os.Handler
            android.os.Looper r8 = android.os.Looper.getMainLooper()
            r7.<init>(r8)
            handler = r7
            java.lang.Runnable r8 = task
            r0 = 3000(0xbb8, double:1.482E-320)
            r7.postDelayed(r8, r0)
            return
        L_0x0094:
            r7 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0094 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.view.H5Tip.showTip(android.content.Context, android.view.ViewGroup, java.lang.String):void");
    }

    public static void dismissTip() {
        try {
            if (popWindow != null && popWindow.isShowing()) {
                popWindow.dismiss();
                handler.removeCallbacks(task);
            }
        } catch (IllegalArgumentException e2) {
            H5Log.e(TAG, "exception detail", e2);
        } finally {
            popWindow = null;
        }
    }
}
