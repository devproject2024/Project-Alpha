package com.paytmmall.clpartifact.utils;

import com.paytmmall.clpartifact.modal.clpCommon.CLPResponse;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import java.util.List;

public class GAUtil {
    public static final String ADD_TO_CART = "Add To Cart";
    public static final String CURRENCY = "INR";
    public static final String CURRENCY_CODE = "'currencyCode'";
    public static final String CUSTOM_EVENT = "custom_event";
    public static final String EVENT_ACTION = "event_action";
    public static final String EVENT_CATEGORY = "event_category";
    public static final String EVENT_LABEL = "event_label";
    private static final String IMPRESSION_RESPONSE = "response";
    public static final String KEY_CATEGORY_TAB_NAME = "category_tab_name";
    public static final String KEY_FILTER_AVAILABLE = "filterAvailable";
    public static final String KEY_GA = "ga_key";
    public static final String KEY_IS_RE = "isRE";
    public static final String KEY_LIST_ID_TYPE = "list_id_type";
    public static final String KEY_PREV_GA_KEY = "prev_ga_key";
    public static final String KEY_PREV_SCREEN_NAME = "prev_screen_name";
    public static final String KEY_PREV_SCREEN_TITLE = "prev_screen_title";
    public static final String KEY_PREV_SCREEN_TYPE = "prev_screen_type";
    public static final String KEY_PREV_WIDGET_NAME = "prev_widget_name";
    public static final String KEY_PREV_WIDGET_POSITION = "prev_widget_position";
    public static final String KEY_PREV_WIDGET_TYPE = "prev_widget_type";
    public static final String KEY_RECO_ID = "recoId";
    public static final String KEY_TABBED_GRID_EXPERIMENT = "tabbedGridExperiment";
    public static final String MARKET_PLACE = "marketplace";
    public static final String USER_ID = "user_id";
    public static final String VERTICAL_NAME = "vertical_name";
    public static String customerId = "Customer_Id";
    public static String event = "event";
    public static String eventProductClick = "productClick";
    public static String eventProductImpression = "productImpression";
    public static String eventPromotionClick = "promotionClick";
    public static String eventPromotionImpression = "promotionImpression";
    public static String evetName = "eventName";
    private static String mGAKey = "";
    private static GAProductImpression mImpression = null;
    private static String mPrevListName = null;
    private static GAPromotionImpression mPromotionImpression = null;
    private static String mTimeSlot = null;
    public static String screenName = "screenName";
    public static String verticalName = "vertical_name";

    public static String getDimension24() {
        return "";
    }

    public static void setGAKey(CLPResponse cLPResponse) {
        mGAKey = (cLPResponse == null || cLPResponse.getGaKey() == null) ? mGAKey : cLPResponse.getGaKey();
    }

    public static String getGakey() {
        return mGAKey;
    }

    public static void setPrevListName(String str) {
        mPrevListName = str;
    }

    public static String getPrevListName() {
        return mPrevListName;
    }

    public static void setFlashSaleSlotInfo(String str) {
        mTimeSlot = str;
    }

    public static GAProductImpression getCachedGAImpression() {
        return mImpression;
    }

    public static void setGAImpression(GAProductImpression gAProductImpression) {
        mImpression = gAProductImpression;
    }

    public static void setGAPromotionImpression(GAPromotionImpression gAPromotionImpression) {
        mPromotionImpression = gAPromotionImpression;
    }

    public static GAPromotionImpression getmPromotionImpression() {
        return mPromotionImpression;
    }

    public static String getTimeSlot() {
        return mTimeSlot;
    }

    public static boolean isFlashSale(List<CJRGridProduct.PromoData> list) {
        if (list == null || list.size() == 0 || list.get(0) == null || !list.get(0).isFlashSale()) {
            return false;
        }
        return true;
    }
}
