package com.travel.train.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.travel.train.R;
import com.travel.train.i.ai;

public final class bf {
    public static View a(ViewGroup viewGroup, ai aiVar) {
        switch (aiVar) {
            case ORDER_STATUS_LAYOUT:
                return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_train_order_header_lyout, viewGroup, false);
            case ORDER_ACTIONS_LAYOUT:
                return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_train_order_actions_layout, viewGroup, false);
            case ORDER_BOOKING_DETAILS_LAYOUT:
                return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_train_order_train_details_lyt, viewGroup, false);
            case ORDER_TRAVELLER_DETAILS_LAYOUT:
                return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_train_order_summary_traveller_item, viewGroup, false);
            case ORDER_TEXT_HOLDER_LAYOUT:
                return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_train_order_text_holder_layout, viewGroup, false);
            case ORDER_PROMOTION_BANNERS_LAYOUT:
                return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_train_internal_promotion_layout, viewGroup, false);
            case ORDER_CP_LAYOUT:
                return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_train_order_summary_cancelation_protect, viewGroup, false);
            case ORDER_CASHBACK_LAYOUT:
                return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_train_cashback_card_lyt, viewGroup, false);
            case ORDER_FARE_DETAILS_LAYOUT:
                return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_train_order_summary_fare_detail_lyt, viewGroup, false);
            case ORDER_REFUND_LAYOUT:
                return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_train_order_summary_refund_details_layout, viewGroup, false);
            case ORDER_CANCELLATION_CHARGES_LAYOUT:
                return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_train_order_cancellation_charges_lyt, viewGroup, false);
            case ORDER_GST_DETAILS_LAYOUT:
                return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_train_order_summary_gst_lyt, viewGroup, false);
            case ORDER_CONTACT_US_LAYOUT:
                return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_train_order_summary_footer_lyt, viewGroup, false);
            case FOOTER_PROGRESS_BAR:
                return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_list_footer_progress_bar, viewGroup, false);
            default:
                return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_list_footer_progress_bar, viewGroup, false);
        }
    }
}
