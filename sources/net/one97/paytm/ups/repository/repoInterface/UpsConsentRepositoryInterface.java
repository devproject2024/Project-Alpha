package net.one97.paytm.ups.repository.repoInterface;

import java.util.List;
import java.util.Map;
import net.one97.paytm.ups.listener.GetConsentListener;
import net.one97.paytm.ups.listener.UpdateConsentListener;

public interface UpsConsentRepositoryInterface {
    boolean checkConsentValue(String str);

    Map<String, Boolean> checkConsentsAvailable(List<String> list);

    void getConsent(List<String> list, GetConsentListener getConsentListener);

    void updateConsent(String str, boolean z, UpdateConsentListener updateConsentListener);
}
