package com.travel.flight.flightticket.f;

public enum n {
    ITEM_HEADER_VIEW(99, "item_onward_view"),
    ITEM_ROUTE_VIEW(100, "item_onward_journey_view"),
    ITEM_POLICY_VIEW(101, "item_cancellation_window"),
    ITEM_CANCELLATION_WINDOW(102, "cancellation_window"),
    ITEM_RESCHEDULE_WINDOW(103, "reschedule_window"),
    ITEM_NO_SHOW_REFUND(104, "no_show_refeund"),
    ITEM_SPECIAL_FARE(105, "special_fare"),
    ITEM_TANDC_WITH_TEXT(106, "tandc_text_view");
    
    private int index;
    private String name;

    private n(int i2, String str) {
        this.index = i2;
        this.name = str;
    }

    public static n fromName(String str) {
        for (n nVar : values()) {
            if (nVar.name.equalsIgnoreCase(str)) {
                return nVar;
            }
        }
        return ITEM_TANDC_WITH_TEXT;
    }

    public static n fromIndex(int i2) {
        for (n nVar : values()) {
            if (nVar.index == i2) {
                return nVar;
            }
        }
        return ITEM_TANDC_WITH_TEXT;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getName() {
        return this.name;
    }
}
