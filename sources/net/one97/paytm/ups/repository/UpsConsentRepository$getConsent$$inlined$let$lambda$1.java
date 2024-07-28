package net.one97.paytm.ups.repository;

import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import kotlin.a.ae;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.ups.db.ConsentItem;
import net.one97.paytm.ups.listener.GetConsentListener;
import net.one97.paytm.ups.manager.DatabaseManager;
import net.one97.paytm.ups.network.model.consent.ConsentStatus;
import net.one97.paytm.ups.network.model.consent.ConsentStatusPreference;
import net.one97.paytm.ups.network.model.consent.ConsentStatusResponse;

public final class UpsConsentRepository$getConsent$$inlined$let$lambda$1 implements b {
    final /* synthetic */ List $consentKeys$inlined;
    final /* synthetic */ GetConsentListener $listener$inlined;

    UpsConsentRepository$getConsent$$inlined$let$lambda$1(GetConsentListener getConsentListener, List list) {
        this.$listener$inlined = getConsentListener;
        this.$consentKeys$inlined = list;
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.$listener$inlined.onGetConsent(true, ae.a());
        q.d("get consent failed  status code =  ".concat(String.valueOf(i2)));
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
        if (iJRPaytmDataModel2 instanceof ConsentStatus) {
            ConsentStatus consentStatus = (ConsentStatus) iJRPaytmDataModel2;
            if (consentStatus.getNetworkResponse().statusCode == 200) {
                HashMap hashMap = new HashMap();
                ConsentStatusResponse response = consentStatus.getResponse();
                List<ConsentStatusPreference> preferences = response != null ? response.getPreferences() : null;
                if (preferences != null) {
                    for (ConsentStatusPreference consentStatusPreference : preferences) {
                        hashMap.put(consentStatusPreference.getKey(), Boolean.valueOf(consentStatusPreference.getValue()));
                        DatabaseManager.INSTANCE.getDatabase().getUpsDao().insertConsent(new ConsentItem(consentStatusPreference.getKey(), String.valueOf(consentStatusPreference.getValue()), true, (String) null, 0, 24, (g) null));
                    }
                }
                this.$listener$inlined.onGetConsent(false, hashMap);
                StringBuilder sb = new StringBuilder("consent fetch id successfully  response = ");
                byte[] bArr = consentStatus.getNetworkResponse().data;
                k.a((Object) bArr, "response.networkResponse.data");
                Charset forName = Charset.forName(AppConstants.UTF_8);
                k.a((Object) forName, "Charset.forName(\"UTF-8\")");
                sb.append(new String(bArr, forName));
                q.d(sb.toString());
                return;
            }
        }
    }
}
