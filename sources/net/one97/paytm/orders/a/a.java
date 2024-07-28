package net.one97.paytm.orders.a;

import easypay.manager.Constants;

public enum a {
    LAYOUT_FOOTER_CARD(120, "footer_card"),
    LAYOUT_PAYMENT_CARD(121, "payment_card"),
    LAYOUT_IGNORE_TYPE(-1, "ignore_type"),
    LAYOUT_HEADER_CARD(217, "summary_header_card"),
    LAYOUT_TRAIN_DESC_CARD(218, "train_summary_desc_card"),
    LAYOUT_TRAIN_RATING_CARD(258, "train_rating_desc_card"),
    LAYOUT_TRAIN_TRAVELLER_DETAILS_CARD(219, "train_traveller_details_card"),
    LAYOUT_TRAIN_DOWNLOAD_TICKET_DETAILS_CARD(289, "train_download_details_card"),
    LAYOUT_BANNER_CARD(220, "summary_banner_card"),
    LAYOUT_FAILED_MOVIE_DESC_CARD(Constants.EASY_PAY_MINIMIZE_ASSIST, "failed_movie_desc_card"),
    LAYOUT_MOVIE_PAYMENT_CARD(Constants.EASY_PAY_MAXIMIZE_ASSIST, "movie_payment_card"),
    LAYOUT_SUCCESS_MOVIE_DESC_CARD(Constants.EASY_PAY_VISIBLE_ASSIST, "success_movie_desc_card"),
    LAYOUT_PENDING_MOVIE_DESC_CARD(Constants.EASY_PAY_INVISIBLE_ASSIST, "pending_movie_desc_card"),
    LAYOUT_MOVIE_SEND_TICKET_CARD(Constants.EASY_PAY_GENERIC_CALLBACK, "send_movie_ticket_card"),
    LAYOUT_NPS_CAPTURE_CARD(226, "nps_capture_card"),
    LAYOUT_TRAIN_REFUND_CARD(228, "train_refund_card"),
    LAYOUT_TRAIN_HEADER_CARD(227, "train_summary_header_card"),
    LAYOUT_MOVIE_FOOD_CARD(230, "movie_food_card"),
    LAYOUT_FLIGHT_HEADER_CARD(267, "flight_summary_header_card"),
    LAYOUT_FLIGHT_DESC_CARD(229, "flight_summary_desc_card"),
    LAYOUT_FLIGHT_TRAVELLER_DETAILS_CARD(349, "flight_travellers_detail_card"),
    LAYOUT_MOVIE_UPCOMING_MOVIE(331, "movie_upcoming_card"),
    LAYOUT_MOVIE_SUMMARY_CATALOG(987, "movie_summary_catalog_card"),
    LAYOUT_MOVIE_POST_ORDER_FOOD_CARD(431, "movie_post_order_food_card"),
    LAYOUT_MOVIE_POST_ORDER_MOVIE_DETAIL(432, "movie_post_order_movie_detail"),
    LAYOUT_TRAIN_LIFAFA_CARD(433, "layout_train_lifafa_card"),
    LAYOUT_CANCELLATION_PROTECT_FLIGHT_CARD(269, "cancellation_protect"),
    LAYOUT_PAYMENT_FLIGHT_CARD(249, "flight_payment_card"),
    LAYOUT_VIP_CASH_BACK_CARD(250, "layout_vip_cash_back_card"),
    LAYOUT_MOVIE_CASH_BACK_CARD(277, "layout_movie_cash_back_card");
    
    private int index;
    private String name;

    private a(int i2, String str) {
        this.index = i2;
        this.name = str;
    }

    public static a fromIndex(int i2) {
        for (a aVar : values()) {
            if (aVar.index == i2) {
                return aVar;
            }
        }
        return LAYOUT_IGNORE_TYPE;
    }

    public static a fromName(String str) {
        for (a aVar : values()) {
            if (aVar.name.equalsIgnoreCase(str)) {
                return aVar;
            }
        }
        return LAYOUT_IGNORE_TYPE;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getName() {
        return this.name;
    }
}
