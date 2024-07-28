package net.one97.paytm.phoenix.provider;

import android.content.Context;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.utils.v;

public final class PhoenixAppsFlyerSendEventProviderImpl implements PhoenixAppsFlerSendEventProvider {
    public final void sendAppsFlyerEvent(Context context, String str, HashMap<String, String> hashMap) {
        k.c(context, "context");
        k.c(str, "eventName");
        k.c(hashMap, Item.CTA_URL_TYPE_MAP);
        v.f69802a.a(context, str, hashMap);
    }
}
