package com.travel.flight.flightticket.d;

public enum c {
    NAVIGATE_TO_FARE_RULES(100, "navigate_to_fare_rules"),
    NAVIGATE_TO_OFFER_LIST(101, "navigate_to_offer_list"),
    ON_PROMO_CLICK(103, "on_promo_click"),
    ON_PROMO_TEXT_CHANGE(103, "on_promo_text_change"),
    ON_PROMO_REMOVED(104, "on_promo_removed"),
    NAVIGATE_TO_MORE_SELLER(105, "on_more_seller"),
    PROCEED_TO_PAY(106, "proceed_to_pay"),
    NAVIGATE_TO_TC(107, "navigate_to_tc"),
    INSURANCE_CHECKBOX(108, "insurance_checkbox"),
    CANCEL_PROTECT_INSURANCE_CHECKBOX(118, "cancel_protect_insurance_checkbox"),
    INSURANCE_TnC(109, "insurance_tnc"),
    INVALID(115, "invalid"),
    CONVENIENCE_FEE_DETAILS(116, "conveniencefeedetails"),
    CANCEL_PROTECT_TnC(119, "insurance_tnc"),
    CONVENIENCE_FEE_DETAILS_CLOSE(117, "conveniencefeedetailsclose"),
    NAVIGATE_TO_MINI_RULES(120, "navigate_to_mini_rules"),
    ANCILLARY_BUY_BAG(124, "ancillarybuybag"),
    ANCILLARY_SELECT_SEAT(125, "ancillaryselectseat"),
    ANCILLARY_BUY_MEAL(121, "ancillarybuymeal"),
    ANCILLARY_DETAILS(122, "ancillaryDetails"),
    ANCILLARY_DETAILS_CLOSE(123, "ancillaryDetailsClose"),
    NAVIGATE_TO_CANCELLATION_RULES(124, "navigate_to_cancellation"),
    ON_BUNDLE_SELECTED(126, "bundle_selected"),
    ON_BUNDLE_DESELECTED(127, "bundle_deselected");
    
    private int index;
    private String name;

    private c(int i2, String str) {
        this.index = i2;
        this.name = str;
    }

    public static c fromIndex(int i2) {
        for (c cVar : values()) {
            if (cVar.index == i2) {
                return cVar;
            }
        }
        return INVALID;
    }

    public static c fromName(String str) {
        for (c cVar : values()) {
            if (cVar.name.equalsIgnoreCase(str)) {
                return cVar;
            }
        }
        return INVALID;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getName() {
        return this.name;
    }
}
