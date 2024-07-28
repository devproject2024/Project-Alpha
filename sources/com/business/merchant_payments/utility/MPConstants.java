package com.business.merchant_payments.utility;

import com.business.merchant_payments.PaymentsConfig;

public class MPConstants {
    public static final String CLIENT_ACCEPT_PAYMENTS = "Accept Payments";
    public static final String CLIENT_P4B = "P4B";
    public static final String INTENT_EXTRA_SELECTED_END_DATE = "intent_extra_selected_end_date";
    public static final String INTENT_EXTRA_SELECTED_START_DATE = "intent_extra_selected_start_date";
    public static final String KEY_END = "end";
    public static final String KEY_RANGE = "range";
    public static final String KEY_START = "start";
    public static final int PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 0;
    public static final int REQUEST_CODE_DEPART_DATE = 1;
    public static final String SETTLEMENTS = "SETTLEMENTS";
    public static final String TYPE = "type";

    public interface PaymentSummaryRange {
        public static final String CUSTOM = "custom";
        public static final String MONTH = "month";
        public static final String TODAY = "today";
        public static final String WEEK = "week";
    }

    public static boolean isP4BClient() {
        return PaymentsConfig.getInstance().getClientName().equalsIgnoreCase("P4B");
    }

    public static boolean isAcceptPaymentsClient() {
        return PaymentsConfig.getInstance().getClientName().equalsIgnoreCase("Accept Payments");
    }
}
