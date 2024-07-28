package net.one97.travelpass.ordersummary.b;

public enum a {
    TP_ORDER_SUMMARY_HEADER(0),
    TP_ORDER_SUMMARY_ACTION(1),
    TP_ORDER_SUMMARY_BANNER(2),
    TP_ORDER_SUMMARY_DETAIL(3),
    TP_ORDER_SUMMARY_CASHBACK(4),
    TP_ORDER_SUMMARY_TERMS_AND_CONDITIONS(6),
    TP_ORDER_SUMMARY_CONTACT_US(7),
    TP_ORDER_SUMMARY_DETAIL_ITEM(8),
    TP_ORDER_SUMMARY_PAYMENT_DETAIL(5),
    TP_ORDER_SUMMARY_PAYMENT_DETAIL_ITEM(9),
    TP_ORDER_SUMMARY_PAYMENT_BREAKUP_ITEM(10),
    TP_ORDER_SUMMARY_REFUND_DETAIL(11),
    TP_ORDER_SUMMARY_REFUND_INFO_ITEM(12),
    TP_ORDER_SUMMARY_REFUND_DETAIL_ITEM(13),
    TP_ORDER_SUMMARY_WALLET_REFUND_ITEM(14),
    TP_ORDER_SUMMARY_BANK_REFUND_ITEM(15),
    LAYOUT_IGNORE_TYPE(-1);
    
    int viewType;

    private a(int i2) {
        this.viewType = 0;
        this.viewType = i2;
    }

    public static a fromIndex(int i2) {
        for (a aVar : values()) {
            if (aVar.viewType == i2) {
                return aVar;
            }
        }
        return LAYOUT_IGNORE_TYPE;
    }
}
