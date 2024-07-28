package com.business.merchant_payments.ups;

import android.app.Application;
import com.business.merchant_payments.ups.UPSDataProvider;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class UPSManager {
    public static final Companion Companion = new Companion((g) null);
    public static volatile UPSManager INSTANCE = null;
    public static final long MAX_TIME_CONSTRAINT = 21600000;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final UPSManager getInstance() {
            if (UPSManager.INSTANCE == null) {
                synchronized (UPSManager.class) {
                    if (UPSManager.INSTANCE == null) {
                        UPSManager.INSTANCE = new UPSManager();
                    }
                }
            }
            UPSManager access$getINSTANCE$cp = UPSManager.INSTANCE;
            k.a((Object) access$getINSTANCE$cp);
            return access$getINSTANCE$cp;
        }
    }

    public static /* synthetic */ void init$default(UPSManager uPSManager, Application application, UPSDataProvider.UPSResponseListener uPSResponseListener, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            uPSResponseListener = null;
        }
        uPSManager.init(application, uPSResponseListener);
    }

    public final void init(Application application, UPSDataProvider.UPSResponseListener uPSResponseListener) {
        k.d(application, "applicationContext");
        if (shouldFetchData()) {
            new UPSDataProvider(application).fetchPrefsFromUPS(true, new ArrayList(), uPSResponseListener);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean shouldFetchData() {
        /*
            r8 = this;
            com.business.merchant_payments.common.utility.APSharedPreferences r0 = com.business.merchant_payments.common.utility.APSharedPreferences.getInstance()
            java.lang.String r1 = "APSharedPreferences.getInstance()"
            kotlin.g.b.k.b(r0, r1)
            long r0 = r0.getUPSSyncTimestamp()
            long r2 = java.lang.System.currentTimeMillis()
            com.business.merchant_payments.PaymentsConfig r4 = com.business.merchant_payments.PaymentsConfig.getInstance()
            java.lang.String r5 = "PaymentsConfig.getInstance()"
            kotlin.g.b.k.b(r4, r5)
            com.business.common_module.b.i r4 = r4.getMerchantDataProvider()
            java.lang.String r4 = r4.B()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            r6 = 1
            r7 = 0
            if (r4 != 0) goto L_0x003d
            com.business.merchant_payments.PaymentsConfig r4 = com.business.merchant_payments.PaymentsConfig.getInstance()
            kotlin.g.b.k.b(r4, r5)
            com.business.common_module.b.i r4 = r4.getMerchantDataProvider()
            boolean r4 = r4.K()
            if (r4 == 0) goto L_0x003d
            r4 = 1
            goto L_0x003e
        L_0x003d:
            r4 = 0
        L_0x003e:
            long r2 = r2 - r0
            r0 = 21600000(0x1499700, double:1.0671818E-316)
            int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r5 <= 0) goto L_0x0048
            r0 = 1
            goto L_0x0049
        L_0x0048:
            r0 = 0
        L_0x0049:
            if (r4 == 0) goto L_0x004e
            if (r0 == 0) goto L_0x004e
            return r6
        L_0x004e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.ups.UPSManager.shouldFetchData():boolean");
    }
}
