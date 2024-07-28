package net.one97.paytm.landingpage.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public Activity f53012a;

    /* renamed from: b  reason: collision with root package name */
    public Context f53013b = this.f53012a.getApplicationContext();

    /* JADX WARNING: Can't wrap try/catch for region: R(9:6|7|8|(1:10)(1:11)|12|13|14|(1:16)(1:17)|18) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0083 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x00a6 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x008d A[Catch:{ Exception -> 0x00a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0092 A[Catch:{ Exception -> 0x00a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ae A[Catch:{ Exception -> 0x00b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e(android.app.Activity r6) {
        /*
            r5 = this;
            java.lang.String r0 = "mounted"
            r5.<init>()
            r5.f53012a = r6
            android.app.Activity r6 = r5.f53012a
            android.content.Context r6 = r6.getApplicationContext()
            r5.f53013b = r6
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            r6.getName()
            android.content.Context r6 = r5.f53013b
            android.content.Context r6 = r6.getApplicationContext()
            com.paytm.b.a.a r6 = net.one97.paytm.utils.ag.a(r6)
            java.lang.String r1 = "cleacr_cache"
            r2 = 1
            boolean r3 = r6.b((java.lang.String) r1, (boolean) r2, (boolean) r2)
            if (r3 == 0) goto L_0x00a6
            r3 = 0
            r6.a((java.lang.String) r1, (boolean) r3, (boolean) r2)
            net.one97.paytm.landingpage.utils.e$1 r6 = new net.one97.paytm.landingpage.utils.e$1     // Catch:{ Exception -> 0x009e }
            r6.<init>()     // Catch:{ Exception -> 0x009e }
            java.util.concurrent.Executor r1 = android.os.AsyncTask.THREAD_POOL_EXECUTOR     // Catch:{ Exception -> 0x009e }
            r1.execute(r6)     // Catch:{ Exception -> 0x009e }
            android.content.Context r6 = r5.f53013b     // Catch:{ Exception -> 0x009e }
            if (r6 == 0) goto L_0x00a6
            java.lang.String r1 = "."
            java.lang.String r2 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x0083 }
            boolean r2 = r2.equals(r0)     // Catch:{ Exception -> 0x0083 }
            if (r2 == 0) goto L_0x0060
            java.io.File r2 = r6.getExternalCacheDir()     // Catch:{ Exception -> 0x0083 }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0083 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0083 }
            r4.<init>()     // Catch:{ Exception -> 0x0083 }
            r4.append(r2)     // Catch:{ Exception -> 0x0083 }
            r4.append(r1)     // Catch:{ Exception -> 0x0083 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x0083 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0083 }
            goto L_0x007c
        L_0x0060:
            java.io.File r2 = r6.getCacheDir()     // Catch:{ Exception -> 0x0083 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ Exception -> 0x0083 }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0083 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0083 }
            r4.<init>()     // Catch:{ Exception -> 0x0083 }
            r4.append(r2)     // Catch:{ Exception -> 0x0083 }
            r4.append(r1)     // Catch:{ Exception -> 0x0083 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x0083 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0083 }
        L_0x007c:
            java.lang.String r1 = r3.getAbsolutePath()     // Catch:{ Exception -> 0x0083 }
            net.one97.paytm.common.utility.c.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0083 }
        L_0x0083:
            java.lang.String r1 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x00a6 }
            boolean r0 = r1.equals(r0)     // Catch:{ Exception -> 0x00a6 }
            if (r0 == 0) goto L_0x0092
            java.io.File r6 = r6.getExternalCacheDir()     // Catch:{ Exception -> 0x00a6 }
            goto L_0x0096
        L_0x0092:
            java.io.File r6 = r6.getCacheDir()     // Catch:{ Exception -> 0x00a6 }
        L_0x0096:
            java.lang.String r6 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x00a6 }
            net.one97.paytm.common.utility.c.a((java.lang.String) r6)     // Catch:{ Exception -> 0x00a6 }
            goto L_0x00a6
        L_0x009e:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.paytm.utility.q.b(r6)
        L_0x00a6:
            android.content.Context r6 = r5.f53013b     // Catch:{ Exception -> 0x00b4 }
            boolean r6 = com.paytm.utility.a.n(r6)     // Catch:{ Exception -> 0x00b4 }
            if (r6 == 0) goto L_0x00b3
            android.content.Context r6 = r5.f53013b     // Catch:{ Exception -> 0x00b4 }
            net.one97.paytm.GoogleAdvertisementIDInfo.a((android.content.Context) r6)     // Catch:{ Exception -> 0x00b4 }
        L_0x00b3:
            return
        L_0x00b4:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.paytm.utility.q.b(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.landingpage.utils.e.<init>(android.app.Activity):void");
    }

    public final CJRHomePageItem a() {
        Intent intent = this.f53012a.getIntent();
        if (!intent.hasExtra("mobileNumber")) {
            return null;
        }
        CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
        cJRHomePageItem.setReferralNo(intent.getStringExtra("mobileNumber"));
        if (intent.hasExtra("amount")) {
            cJRHomePageItem.setReferralAmount(intent.getStringExtra("amount"));
        }
        if (intent.hasExtra("rechargeType")) {
            cJRHomePageItem.setReferralRechargeType(intent.getStringExtra("rechargeType"));
        }
        if (intent.hasExtra("referralSource")) {
            cJRHomePageItem.setmReferralSource(intent.getStringExtra("referralSource"));
        }
        return cJRHomePageItem;
    }

    public static String a(String str) {
        if (str.equals("")) {
            return null;
        }
        return str;
    }
}
