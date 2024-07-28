package net.one97.paytm.wallet.newdesign.nearby.helper;

import android.content.Context;
import android.content.ContextWrapper;
import java.util.HashMap;
import net.one97.paytm.wallet.newdesign.nearby.datamodals.NearbyOffersBannerModal;

public interface e {
    ContextWrapper a(Context context);

    String a();

    String a(String str);

    void a(String str, String str2, Context context);

    void a(String str, HashMap<String, Object> hashMap, Context context);

    void a(NearbyOffersBannerModal.Item item, Context context, int i2, String str);

    Context b();

    void b(NearbyOffersBannerModal.Item item, Context context, int i2, String str);

    boolean b(String str);
}
