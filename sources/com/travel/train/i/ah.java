package com.travel.train.i;

import com.paytm.android.chat.utils.KeyList;

public enum ah {
    ORDER_STATUS_TEXT_ACTION(KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_FILE, "retry_booking_click"),
    ORDER_ACTION_CLICK(KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_AUDIO, "order_action_click"),
    FAVOURITE_CLICK(304, "favourite_click"),
    VIEW_ROUTE(305, "view_route"),
    VIEW_COACH(306, "view_coach"),
    CANCEL_TICKET(307, "cancel_ticket"),
    INTERNAL_PROMOTION_DEEPLINK_CLICK(308, "internal_promotion_deeplink_click"),
    CONTACT_US_CLICK(309, "contact_us_click"),
    VIEW_PASSBOOK_CLICK(310, "view_passbook_click"),
    CP_TnC(310, "cp_tnc_click"),
    CHANGE_STATION(311, "change_station"),
    CST_HANDLING(312, "cst_handling");
    
    private int index;
    private String name;

    private ah(int i2, String str) {
        this.index = i2;
        this.name = str;
    }

    public static ah fromName(String str) {
        for (ah ahVar : values()) {
            if (ahVar.name.equalsIgnoreCase(str)) {
                return ahVar;
            }
        }
        return ORDER_STATUS_TEXT_ACTION;
    }

    public static ah fromIndex(int i2) {
        for (ah ahVar : values()) {
            if (ahVar.index == i2) {
                return ahVar;
            }
        }
        return ORDER_STATUS_TEXT_ACTION;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getName() {
        return this.name;
    }
}
