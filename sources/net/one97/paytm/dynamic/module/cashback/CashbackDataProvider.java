package net.one97.paytm.dynamic.module.cashback;

import android.content.Context;
import java.lang.ref.WeakReference;
import kotlin.g.b.k;
import net.one97.paytm.cashback.posttxn.d;
import net.one97.paytm.common.entity.vipcashback.CashbackPreferenceUtility;
import net.one97.paytm.deeplink.e;
import net.one97.paytm.vipcashback.c.a;
import net.one97.paytm.vipcashback.c.b;
import net.one97.paytm.vipcashback.f.c;

public class CashbackDataProvider implements e.a {
    private static CashbackDataProvider instance;
    private WeakReference<d> cashbackListener;

    public static CashbackDataProvider getInstance() {
        if (instance == null) {
            instance = new CashbackDataProvider();
        }
        return instance;
    }

    public static void initCashbackModule(Context context) {
        CashbackJarvisHelper.init();
    }

    private CashbackDataProvider() {
        e.a((e.a) this);
    }

    public void registerCashbackListener(d dVar) {
        this.cashbackListener = new WeakReference<>(dVar);
    }

    public void loadCashbackData() {
        WeakReference<d> weakReference = this.cashbackListener;
        if (weakReference != null) {
            weakReference.get();
        }
    }

    public void clearCashbackPreferences() {
        c.a aVar = c.f20856a;
        CashbackPreferenceUtility.Companion companion = CashbackPreferenceUtility.Companion;
        b bVar = a.a().f20708b;
        k.a((Object) bVar, "CashbackHelper.getImplListener()");
        Context applicationContext = bVar.getApplicationContext();
        k.a((Object) applicationContext, "CashbackHelper.getImplLi…ener().applicationContext");
        com.paytm.b.a.a pref = companion.getPref(applicationContext);
        pref.a(c.f20857b, true, false);
        pref.a(c.f20858c, 0, false);
    }
}
