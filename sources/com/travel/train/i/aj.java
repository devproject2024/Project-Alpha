package com.travel.train.i;

import com.paytm.android.chat.utils.KeyList;

public enum aj {
    USER_ID_EDIT_CLICK(KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_FILE, "user_id_edit_click"),
    START_COUNTRY_LIST_VIEW(KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_AUDIO, "start_country_list_view"),
    START_REVIEW_ITERNARY_VIEW(304, "start_review_iternary_view"),
    IGNORE_CLICK(308, "ignore_click");
    
    private int index;
    private String name;

    private aj(int i2, String str) {
        this.index = i2;
        this.name = str;
    }

    public static aj fromName(String str) {
        for (aj ajVar : values()) {
            if (ajVar.name.equalsIgnoreCase(str)) {
                return ajVar;
            }
        }
        return IGNORE_CLICK;
    }

    public static aj fromIndex(int i2) {
        for (aj ajVar : values()) {
            if (ajVar.index == i2) {
                return ajVar;
            }
        }
        return IGNORE_CLICK;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getName() {
        return this.name;
    }
}
