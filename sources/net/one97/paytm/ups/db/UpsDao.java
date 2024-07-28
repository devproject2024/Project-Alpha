package net.one97.paytm.ups.db;

import java.util.List;

public interface UpsDao {
    void deleteTable();

    List<ConsentItem> getAllAvailableConsent();

    List<ConsentItem> getConsent(String str);

    List<ConsentItem> getConsentNeededToSyncWithServer(boolean z);

    long insertConsent(ConsentItem consentItem);

    public static final class DefaultImpls {
        public static /* synthetic */ List getConsentNeededToSyncWithServer$default(UpsDao upsDao, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    z = false;
                }
                return upsDao.getConsentNeededToSyncWithServer(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getConsentNeededToSyncWithServer");
        }
    }
}
