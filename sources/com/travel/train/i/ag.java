package com.travel.train.i;

import com.paytm.android.chat.utils.KeyList;
import kotlin.g.b.k;

public enum ag {
    BOOK_TICKETS(300, "book_tickets"),
    PNR_STATUS(300, "pnr_status"),
    LIVE_TRAIN_STATUS(300, "live_train_status"),
    METRO_RAIL(300, "metro_rail"),
    HANDLE_WITH_DEEPLINK(KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_MEDIA, "deeplink"),
    IGNORE_TYPE(203, "ignore_type"),
    TRAIN_CALENDAR(300, "train_calendar");
    
    public static final a Companion = null;
    private int index;
    private String nameStr;

    private ag(int i2, String str) {
        this.index = i2;
        this.nameStr = str;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getNameStr() {
        return this.nameStr;
    }

    public final void setIndex(int i2) {
        this.index = i2;
    }

    public final void setNameStr(String str) {
        k.c(str, "<set-?>");
        this.nameStr = str;
    }

    static {
        Companion = new a((byte) 0);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
