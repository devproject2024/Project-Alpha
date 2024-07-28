package net.one97.paytm.nativesdk.interfaces;

import com.android.volley.VolleyError;

public interface PromoSearchListener {
    void onPromoSearchError(VolleyError volleyError);

    void onPromoSearchSuccess(String str);
}
