package com.paytm.notification.ui.inapp.view.a;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.paytm.notification.b.e;
import com.paytm.notification.models.FlashMessage;
import com.paytm.notification.ui.inapp.view.a.b;
import kotlin.g.b.k;

public final class a implements com.paytm.notification.ui.inapp.view.a {
    public final boolean a(FlashMessage flashMessage, Activity activity) throws Exception {
        FragmentTransaction beginTransaction;
        k.c(flashMessage, "flashMessage");
        if (activity == null) {
            return false;
        }
        boolean z = activity instanceof AppCompatActivity;
        if (z) {
            j supportFragmentManager = ((AppCompatActivity) activity).getSupportFragmentManager();
            if (supportFragmentManager != null) {
                q a2 = supportFragmentManager.a();
                int b2 = b(activity);
                b.a aVar = b.f43370a;
                a2.a(b2, b.a.a(flashMessage), "flash_box").b();
            }
            return true;
        } else if (!z) {
            e.f43014a.a("Flash ignored because the current Activity is not AppCompatActivity", new Object[0]);
            return false;
        } else {
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (!(fragmentManager == null || (beginTransaction = fragmentManager.beginTransaction()) == null)) {
                int b3 = b(activity);
                b.a aVar2 = b.f43370a;
                FragmentTransaction add = beginTransaction.add(b3, (Fragment) b.a.a(flashMessage), "flash_box");
                if (add != null) {
                    add.commit();
                }
            }
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r2 = r2.metaData;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int b(android.app.Activity r2) {
        /*
            r0 = 16908290(0x1020002, float:2.3877235E-38)
            if (r2 == 0) goto L_0x0033
            com.paytm.notification.e.a r1 = new com.paytm.notification.e.a
            r1.<init>()
            java.lang.Class r1 = r2.getClass()
            android.content.Context r2 = (android.content.Context) r2
            android.content.pm.ActivityInfo r2 = com.paytm.notification.e.a.a(r1, r2)
            if (r2 == 0) goto L_0x0025
            android.os.Bundle r2 = r2.metaData
            if (r2 == 0) goto L_0x0025
            java.lang.String r1 = "com.paytm.push.flash.container"
            int r2 = r2.getInt(r1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0026
        L_0x0025:
            r2 = 0
        L_0x0026:
            if (r2 == 0) goto L_0x0033
            int r1 = r2.intValue()
            if (r1 == 0) goto L_0x0033
            int r2 = r2.intValue()
            return r2
        L_0x0033:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.ui.inapp.view.a.a.b(android.app.Activity):int");
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [android.app.Fragment] */
    /* JADX WARNING: type inference failed for: r2v3, types: [androidx.fragment.app.Fragment] */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.app.Activity r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof androidx.appcompat.app.AppCompatActivity     // Catch:{ Exception -> 0x005b }
            java.lang.String r1 = "flash_box"
            r2 = 0
            if (r0 == 0) goto L_0x0028
            r0 = r4
            androidx.appcompat.app.AppCompatActivity r0 = (androidx.appcompat.app.AppCompatActivity) r0     // Catch:{ Exception -> 0x005b }
            androidx.fragment.app.j r0 = r0.getSupportFragmentManager()     // Catch:{ Exception -> 0x005b }
            if (r0 == 0) goto L_0x0014
            androidx.fragment.app.Fragment r2 = r0.c((java.lang.String) r1)     // Catch:{ Exception -> 0x005b }
        L_0x0014:
            if (r2 == 0) goto L_0x005f
            androidx.appcompat.app.AppCompatActivity r4 = (androidx.appcompat.app.AppCompatActivity) r4     // Catch:{ Exception -> 0x005b }
            androidx.fragment.app.j r4 = r4.getSupportFragmentManager()     // Catch:{ Exception -> 0x005b }
            androidx.fragment.app.q r4 = r4.a()     // Catch:{ Exception -> 0x005b }
            androidx.fragment.app.q r4 = r4.a((androidx.fragment.app.Fragment) r2)     // Catch:{ Exception -> 0x005b }
            r4.c()     // Catch:{ Exception -> 0x005b }
            return
        L_0x0028:
            boolean r0 = r4 instanceof androidx.appcompat.app.AppCompatActivity     // Catch:{ Exception -> 0x005b }
            if (r0 != 0) goto L_0x0037
            com.paytm.notification.b.e$b r4 = com.paytm.notification.b.e.f43014a     // Catch:{ Exception -> 0x005b }
            java.lang.String r0 = "There should be NO Flash to dismiss in this case because the current Activity is not AppCompatActivity"
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x005b }
            r4.a(r0, r1)     // Catch:{ Exception -> 0x005b }
            return
        L_0x0037:
            if (r4 == 0) goto L_0x0043
            android.app.FragmentManager r0 = r4.getFragmentManager()     // Catch:{ Exception -> 0x005b }
            if (r0 == 0) goto L_0x0043
            android.app.Fragment r2 = r0.findFragmentByTag(r1)     // Catch:{ Exception -> 0x005b }
        L_0x0043:
            if (r2 == 0) goto L_0x005a
            android.app.FragmentManager r4 = r4.getFragmentManager()     // Catch:{ Exception -> 0x005b }
            if (r4 == 0) goto L_0x005a
            android.app.FragmentTransaction r4 = r4.beginTransaction()     // Catch:{ Exception -> 0x005b }
            if (r4 == 0) goto L_0x005a
            android.app.FragmentTransaction r4 = r4.remove(r2)     // Catch:{ Exception -> 0x005b }
            if (r4 == 0) goto L_0x005a
            r4.commitAllowingStateLoss()     // Catch:{ Exception -> 0x005b }
        L_0x005a:
            return
        L_0x005b:
            r4 = move-exception
            r4.printStackTrace()
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.ui.inapp.view.a.a.a(android.app.Activity):void");
    }
}
