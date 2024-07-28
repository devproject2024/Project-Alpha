package net.one97.travelpass.ui.b;

public enum b {
    TRAVEL_PASS_CAROUSEL(1),
    TRAVEL_PASS_PRICE_DETAILS_ITEM(2),
    TRAVEL_PASS_PARTNER_OFFERS(3),
    TRAVEL_PASS_INTERNAL_OFFERS(5),
    TRAVEL_PASS_HOW_TO_USE(8),
    TRAVEL_PASS_FAQ_ITEM(9),
    TRAVEL_PASS_TEAMS_CONDITIONS(10),
    TRAVEL_PASS_BUTTON(11),
    TRAVEL_PASS_KNOW_MORE(12),
    TRAVEL_PASS_KNOW_MORE_ITEMS(13),
    TRAVEL_PASS_PARTNER_OFFERS_ITEM(12),
    TRAVEL_PASS_INTERNAL_OFFERS_ITEM(13),
    TRAVEL_PASS_PRICE_DETAILS(15),
    TRAVEL_PASS_HEADER_INFO(16),
    TRAVEL_PASS_ABOUT_INFO(17),
    TRAVEL_PASS_FAQ(18),
    TRAVEL_PASS_CAROUSEL_ITEM(19),
    MY_PASS_HEADER_INFO(20),
    TRAVEL_PASS_HEADER_USER_INFO(21),
    TRAVEL_PASS_TABS(22),
    TRAVEL_PASS_TAB_ITEM(23),
    TRAVEL_PASS_SUBSCRIBE_ITEM(24),
    LAYOUT_IGNORE_TYPE(-1);
    
    int viewType;

    private b(int i2) {
        this.viewType = 0;
        this.viewType = i2;
    }

    public static b fromIndex(int i2) {
        for (b bVar : values()) {
            if (bVar.viewType == i2) {
                return bVar;
            }
        }
        return LAYOUT_IGNORE_TYPE;
    }
}
