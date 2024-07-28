package net.one97.paytm.account;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.PeriodicSync;
import android.os.Bundle;
import java.util.List;
import net.one97.paytm.utils.ag;

public final class a {
    public static synchronized void a(Context context) throws SecurityException {
        boolean z;
        PeriodicSync periodicSync;
        synchronized (a.class) {
            com.paytm.b.a.a a2 = ag.a(context.getApplicationContext());
            boolean b2 = a2.b("setup_complete", false, true);
            Account a3 = PaytmAccountService.a();
            if (((AccountManager) context.getSystemService("account")).addAccountExplicitly(a3, (String) null, (Bundle) null)) {
                ContentResolver.setIsSyncable(a3, "com.android.contacts", 1);
                if (!ContentResolver.getSyncAutomatically(a3, "com.android.contacts")) {
                    ContentResolver.setSyncAutomatically(a3, "com.android.contacts", true);
                }
                ContentResolver.addPeriodicSync(a3, "com.android.contacts", new Bundle(), 86400);
                z = true;
            } else {
                z = false;
            }
            List<PeriodicSync> periodicSyncs = ContentResolver.getPeriodicSyncs(a3, "com.android.contacts");
            if (periodicSyncs != null && periodicSyncs.size() > 0 && (periodicSync = periodicSyncs.get(0)) != null && periodicSync.period == 604800) {
                ContentResolver.addPeriodicSync(a3, "com.android.contacts", new Bundle(), 86400);
            }
            if (z || !b2) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("force", true);
                bundle.putBoolean("expedited", true);
                ContentResolver.requestSync(PaytmAccountService.a(), "com.android.contacts", bundle);
                a2.a("setup_complete", true, true);
            }
        }
    }
}
