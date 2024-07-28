package com.travel.train.i;

import com.paytm.android.chat.utils.KeyList;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage;

public enum ai {
    ORDER_STATUS_LAYOUT(201, "order_status"),
    ORDER_ACTIONS_LAYOUT(203, "order_actions"),
    ORDER_BOOKING_DETAILS_LAYOUT(CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE, "booking_details"),
    ORDER_TRAVELLER_DETAILS_LAYOUT(205, "pax_info"),
    ORDER_TEXT_HOLDER_LAYOUT(206, "text_holder"),
    ORDER_PROMOTION_BANNERS_LAYOUT(207, "promotional_banners"),
    ORDER_CP_LAYOUT(208, "cp_actions"),
    ORDER_CANCELLATION_CHARGES_LAYOUT(209, "cancellation_charges"),
    ORDER_CASHBACK_LAYOUT(210, "promo_info"),
    ORDER_FARE_DETAILS_LAYOUT(211, "fare_details"),
    ORDER_REFUND_LAYOUT(213, "refund_details"),
    ORDER_GST_DETAILS_LAYOUT(215, "gst_details"),
    ORDER_VIP_CASHBACK_LAYOUT(217, "cashback"),
    ORDER_CONTACT_US_LAYOUT(216, ViewHolderFactory.TYPE_SEAL_TRUST),
    FOOTER_PROGRESS_BAR(KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_MEDIA, "bottom_progress_bar"),
    IGNORE_LAYOUT(KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_FILE, "ignore_layout");
    
    private int index;
    private String name;

    private ai(int i2, String str) {
        this.index = i2;
        this.name = str;
    }

    public static ai fromName(String str) {
        for (ai aiVar : values()) {
            if (aiVar.name.equalsIgnoreCase(str)) {
                return aiVar;
            }
        }
        return IGNORE_LAYOUT;
    }

    public static ai fromIndex(int i2) {
        for (ai aiVar : values()) {
            if (aiVar.index == i2) {
                return aiVar;
            }
        }
        return IGNORE_LAYOUT;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getName() {
        return this.name;
    }
}
