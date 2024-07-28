package net.one97.paytm.common.entity.upgradeKyc;

import com.google.gson.f;
import org.json.JSONObject;

public class NearbyRequestCreator {
    private static volatile NearbyRequestCreator nearbyrequestCreatorInstance;

    interface NearbyRequestConstants {
        public static final String OPENING_TIME_SORT = "OPENING_TIME_SORT";
        public static final String distance = "latitude";
        public static final String endLimit = "latitude";
        public static final String filterType = "filterType";
        public static final String ipAddress = "ipAddress";
        public static final String latitude = "latitude";
        public static final String longitude = "latitude";
        public static final String platformName = "platformName";
        public static final String request = "request";
        public static final String searchFilter = "latitude";
        public static final String sortBy = "latitude";
        public static final String startLimit = "latitude";
        public static final String value = "value";
        public static final String version = "version";
    }

    public static NearbyRequestCreator getNearbyRequestCreatorInstance() {
        if (nearbyrequestCreatorInstance == null) {
            synchronized (NearbyRequestCreator.class) {
                if (nearbyrequestCreatorInstance == null) {
                    nearbyrequestCreatorInstance = new NearbyRequestCreator();
                }
            }
        }
        return nearbyrequestCreatorInstance;
    }

    public JSONObject createNearByRequestBody(FetchCashPointRequestModal fetchCashPointRequestModal) {
        try {
            return new JSONObject(new f().b(fetchCashPointRequestModal));
        } catch (Exception unused) {
            return new JSONObject();
        }
    }

    public JSONObject createNearByLiskeDislikeRequestBody(LikeDislikeRequestModal likeDislikeRequestModal) {
        try {
            return new JSONObject(new f().b(likeDislikeRequestModal));
        } catch (Exception unused) {
            return new JSONObject();
        }
    }
}
