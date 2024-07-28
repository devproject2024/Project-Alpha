package com.travel.bus.orders.b;

import com.paytm.android.chat.utils.KeyList;
import easypay.manager.Constants;

public enum a {
    SUMMARY_ORDER_DETAIL_CLICK(9, "order_click"),
    SUMMARY_AUTO_CLICK(10, "auto_click"),
    SUMMARY_PROFILE_CLICK(11, "profile_click"),
    SUMMARY_CONTACT_US_CLICK(12, "contact_us_click"),
    SUMMARY_REVIEW_AND_RATINGS(122, "review_and_rating_click"),
    SUMMARY_CANCEL_ORDER_CLICK(13, "cancel_order_click"),
    SUMMARY_PENDING_KEEP_TRYING(14, "keep_trying"),
    SUMMARY_MY_ORDER_CLICK(15, "my_order_click"),
    SUMMARY_RETRY_PAYMENT_CLICK(16, "retry_payment_click"),
    SUMMARY_VIEW_DETAILS_CLICK(17, "view_details_click"),
    SUMMARY_RECHARGE_ANOTHER_CLICK(18, "recharge_another_click"),
    FB_SOCIAL_LINK_CLICK(19, "fb_social_link_click"),
    TWITTER_SOCIAL_LINK_CLICK(20, "twitter_social_link_click"),
    INSTAGRAM_SOCIAL_LINK_CLICK(21, "instagram_social_link_click"),
    NEARBY_CLICK(19, "nearby_click"),
    SELLER_INFO_CLICK(34, "seller_info_click"),
    ORDER_DETAILS_CLICK(35, "order_details_click"),
    DOWNLOAD_TICKET_CLICK(36, "download_ticket_click"),
    TRAIN_REFRESH_DOWNLOAD_ADAPTER(776, "refresh_adapter"),
    TRAIN_SUMMARY_CAROUSEL_CLICK(23, "summary_carousel_click"),
    SUMMARY_EXECUTE_TAP_ACTION_GET_CALL(24, "summary_excecute_tap_action_get_call"),
    SUMMARY_EXECUTE_TAP_ACTION_POST_CALL(25, "summary_execute_tap_action_post_call"),
    SUMMARY_EXECUTE_ACTION_GET_CALL(26, "summary_excecute_action_get_call"),
    SUMMARY_EXECUTE_ACTION_POST_CALL(27, "summary_execute_action_post_call"),
    SEND_TICKET_BUTTON_CLICK(28, "send_ticket_click"),
    TRY_AGAIN_BUTTON_CLICK(29, "try_again_button_click"),
    QR_IMAGE_CLICK(30, "qr_image_click"),
    NPS_ITEM_CLICK(31, "nps_item_click"),
    RETRY_BUTTON_CLICK(32, "retry_button_click"),
    WALLET_SUMMARY_CLICK(33, "wallet_summary_click"),
    GET_REFUND_BUTTONS_CLICK(37, "get_refun_buttons_click"),
    CACHE_MOVIE_SUMMARY(38, "cache_movie_summary"),
    SUMMARY_TAX_BREAKUP(Constants.EASY_PAY_MAXIMIZE_ASSIST, "summary_tex_breakup"),
    SUMMARY_BOOK_RETURN_TICKET(Constants.EASY_PAY_VISIBLE_ASSIST, "summary_book_return_ticket"),
    IGNORE_TYPE(200, "ignore_type"),
    LAYOUT_FOOTER_CARD(120, "footer_card"),
    LAYOUT_HEADER_CARD(217, "summary_header_card"),
    LAYOUT_TRAIN_DESC_CARD(218, "train_summary_desc_card"),
    CANCEL_MOVIE_TICKET_CLICK(401, "cancel_movie_ticket_click"),
    LAYOUT_PAYMENT_CARD(121, "payment_card"),
    SUMMARY_PAYMENT_DETAIL_CLICK(259, "payment_detail"),
    SUMMARY_FOOD_DETAIL_CLICK(300, "food_detail"),
    INVOICE_CLICK(KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_MEDIA, "invoice_click"),
    TRAVEL_BUDDY_BANNER_CLICK(KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_AUDIO, "travel_buddy_banner_click");
    
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
        return IGNORE_TYPE;
    }

    public static a fromName(String str) {
        for (a aVar : values()) {
            if (aVar.name.equalsIgnoreCase(str)) {
                return aVar;
            }
        }
        return IGNORE_TYPE;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getName() {
        return this.name;
    }
}
