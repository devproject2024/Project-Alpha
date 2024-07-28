package net.one97.paytm.o2o.events.b;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;

public interface c {

    public interface a {
        void a(IJRPaytmDataModel iJRPaytmDataModel, HashMap<String, b.a> hashMap);

        void a(String str, b.a aVar, String str2, String str3);
    }

    public interface b {

        public enum a {
            GRID_DATA_API,
            CITIES_LIST_API,
            TRAVELLER_FORM_INFO,
            INSIDER_HOLD_CALL_RESPONSE,
            BANNER_API,
            GET_WALLET_TOKEN_API,
            PINCODE_VALIDATION
        }
    }
}
