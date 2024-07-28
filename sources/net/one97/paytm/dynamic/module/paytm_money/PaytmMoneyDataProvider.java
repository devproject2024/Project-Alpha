package net.one97.paytm.dynamic.module.paytm_money;

import android.app.Application;
import com.paytmmoney.lite.mod.PaytmMoneyManager;
import kotlin.g.b.k;
import net.one97.paytm.dynamic.module.money.PaytmMoneyModuleHelper;

public final class PaytmMoneyDataProvider {
    public static final PaytmMoneyDataProvider INSTANCE = new PaytmMoneyDataProvider();
    private static boolean isInitCalled;

    private PaytmMoneyDataProvider() {
    }

    public final boolean isInitCalled() {
        return isInitCalled;
    }

    public final void setInitCalled(boolean z) {
        isInitCalled = z;
    }

    public final void initPMLiteModule(Application application) {
        k.c(application, "application");
        if (!isInitCalled) {
            PaytmMoneyManager.INSTANCE.init(application, false);
            PaytmMoneyManager.INSTANCE.initListeners(PaytmMoneyModuleHelper.INSTANCE);
        }
    }
}
