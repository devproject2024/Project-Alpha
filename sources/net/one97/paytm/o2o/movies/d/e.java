package net.one97.paytm.o2o.movies.d;

import android.app.Activity;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.Map;

public interface e {

    public interface a {
        void a(IJRPaytmDataModel iJRPaytmDataModel, HashMap<String, b.a> hashMap);

        void a(boolean z, String str, int i2, b.a aVar, String str2, String str3, NetworkCustomError networkCustomError);
    }

    public interface b {

        public enum a {
            MOVIEPASS_CATELOG_API,
            MOVIEPASS_ACTIVE_EXPIRE,
            MOVIEPASS_PREVAIDATE_API,
            MOVIEPASS_CHECKOUT_API,
            WALLET_TOKEN_API,
            MOVIEPASS_CITY_LIST_API,
            MOVIEPASS_BANNER_API,
            MOVIEPASS_VERIFY_API,
            MOVIEPASS_PROMO,
            UPCOMING_MOVIES,
            CINEMA_LIST
        }

        String a(a aVar, String str, a aVar2);

        String a(a aVar, String str, a aVar2, Map<String, Object> map);

        void a(Activity activity, a aVar);
    }
}
