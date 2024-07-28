package net.one97.paytm.dynamic.module.gold;

import android.app.Application;
import com.paytm.finance.gold.a.a;
import com.paytm.finance.gold.a.b;
import kotlin.g.b.k;

public final class GoldDataProvider {
    public static final GoldDataProvider INSTANCE = new GoldDataProvider();
    private static boolean isInitCalled;

    private GoldDataProvider() {
    }

    public final boolean isInitCalled() {
        return isInitCalled;
    }

    public final void setInitCalled(boolean z) {
        isInitCalled = z;
    }

    public final void initGoldModule(Application application) {
        k.c(application, "application");
        if (!isInitCalled) {
            a.f13415b.a(application);
            a.f13415b.a((b) GoldModuleHelper.INSTANCE);
        }
    }
}
