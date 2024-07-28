package net.one97.paytm.ups.workManager;

import androidx.work.ListenableWorker;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.ups.db.ConsentItem;
import net.one97.paytm.ups.db.UpsDao;
import net.one97.paytm.ups.listener.UpdateConsentListener;
import net.one97.paytm.ups.manager.DatabaseManager;
import net.one97.paytm.ups.repository.UpsConsentRepository;

public final class UpsSyncWorker$consentUpdateListener$1 implements UpdateConsentListener {
    final /* synthetic */ UpsSyncWorker this$0;

    UpsSyncWorker$consentUpdateListener$1(UpsSyncWorker upsSyncWorker) {
        this.this$0 = upsSyncWorker;
    }

    public final void onConsentUpdated(boolean z, String str, boolean z2) {
        k.c(str, "consent");
        if (!z) {
            List consentNeededToSyncWithServer$default = UpsDao.DefaultImpls.getConsentNeededToSyncWithServer$default(DatabaseManager.INSTANCE.getDatabase().getUpsDao(), false, 1, (Object) null);
            if (consentNeededToSyncWithServer$default.isEmpty()) {
                this.this$0.setResult(new ListenableWorker.a.c());
                this.this$0.getLatch().countDown();
                return;
            }
            ConsentItem consentItem = (ConsentItem) consentNeededToSyncWithServer$default.get(0);
            UpsConsentRepository upsConsentRepository = UpsConsentRepository.INSTANCE;
            String consentKey = consentItem.getConsentKey();
            String consentValue = consentItem.getConsentValue();
            if (consentValue == null) {
                k.a();
            }
            upsConsentRepository.updateConsent(consentKey, Boolean.parseBoolean(consentValue), this);
            return;
        }
        this.this$0.setResult(new ListenableWorker.a.C0076a());
        this.this$0.getLatch().countDown();
    }
}
