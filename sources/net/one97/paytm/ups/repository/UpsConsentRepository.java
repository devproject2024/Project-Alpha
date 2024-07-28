package net.one97.paytm.ups.repository;

import android.app.Application;
import com.google.gson.g;
import com.paytm.network.a;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.a.ae;
import kotlin.g.b.k;
import net.one97.paytm.ups.UpsSdk;
import net.one97.paytm.ups.db.ConsentItem;
import net.one97.paytm.ups.db.UpsDao;
import net.one97.paytm.ups.listener.GetConsentListener;
import net.one97.paytm.ups.listener.UpdateConsentListener;
import net.one97.paytm.ups.manager.DatabaseManager;
import net.one97.paytm.ups.network.UpsNetwork;
import net.one97.paytm.ups.network.model.consent.ConsentRequestBody;
import net.one97.paytm.ups.network.model.consent.Request;
import net.one97.paytm.ups.repository.repoInterface.UpsConsentRepositoryInterface;

public final class UpsConsentRepository implements UpsConsentRepositoryInterface {
    public static final UpsConsentRepository INSTANCE = new UpsConsentRepository();
    private static final String TAG = "UpsConsentRepository";

    private UpsConsentRepository() {
    }

    public final void getConsent(List<String> list, GetConsentListener getConsentListener) {
        k.c(list, "consentKeys");
        k.c(getConsentListener, "listener");
        Application applicationContext = UpsSdk.INSTANCE.getApplicationContext();
        if (applicationContext != null) {
            String uuid = UUID.randomUUID().toString();
            k.a((Object) uuid, "UUID.randomUUID().toString()");
            a consentNetworkCall = UpsNetwork.INSTANCE.getConsentNetworkCall(applicationContext, new UpsConsentRepository$getConsent$$inlined$let$lambda$1(getConsentListener, list), list, uuid);
            if (consentNetworkCall != null) {
                consentNetworkCall.a();
            } else {
                getConsentListener.onGetConsent(true, ae.a());
            }
        } else {
            getConsentListener.onGetConsent(true, ae.a());
        }
    }

    public final void updateConsent(String str, boolean z, UpdateConsentListener updateConsentListener) {
        k.c(str, "consentKey");
        k.c(updateConsentListener, "listener");
        Application applicationContext = UpsSdk.INSTANCE.getApplicationContext();
        if (applicationContext != null) {
            String uuid = UUID.randomUUID().toString();
            k.a((Object) uuid, "UUID.randomUUID().toString()");
            String b2 = new g().a().b(new ConsentRequestBody(new Request(str, z), uuid));
            k.a((Object) b2, "jsonBody");
            a putConsentNetworkCall = UpsNetwork.INSTANCE.putConsentNetworkCall(applicationContext, new UpsConsentRepository$updateConsent$$inlined$let$lambda$1(str, z, updateConsentListener), b2, uuid);
            if (putConsentNetworkCall != null) {
                putConsentNetworkCall.a();
                return;
            }
            return;
        }
        updateConsentListener.onConsentUpdated(true, str, z);
    }

    public final Map<String, Boolean> checkConsentsAvailable(List<String> list) {
        k.c(list, "consentKeys");
        HashMap hashMap = new HashMap();
        UpsDao upsDao = DatabaseManager.INSTANCE.getDatabase().getUpsDao();
        q.d("Available Consents -> " + upsDao.getAllAvailableConsent().toString());
        for (ConsentItem consentItem : upsDao.getAllAvailableConsent()) {
            if (list.contains(consentItem.getConsentKey())) {
                Map map = hashMap;
                String consentKey = consentItem.getConsentKey();
                String consentValue = consentItem.getConsentValue();
                if (consentValue == null) {
                    k.a();
                }
                map.put(consentKey, Boolean.valueOf(Boolean.parseBoolean(consentValue)));
            }
        }
        q.d("Available Consents Map -> ".concat(String.valueOf(hashMap)));
        return hashMap;
    }

    public final boolean checkConsentValue(String str) {
        k.c(str, "consentKey");
        List<ConsentItem> consent = DatabaseManager.INSTANCE.getDatabase().getUpsDao().getConsent(str);
        if (str.length() == 0) {
            return false;
        }
        String consentValue = consent.get(0).getConsentValue();
        if (consentValue == null) {
            k.a();
        }
        return Boolean.parseBoolean(consentValue) && consent.get(0).getSyncedWithServer();
    }
}
