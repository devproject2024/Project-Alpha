package com.paytm.business.merchantprofile.common;

import com.paytm.business.merchantprofile.ProfileConfig;

public class ProfileConstants {
    public static final String ADD_EDIT_GSTIN_URL = "add_edit_gstin_url";
    public static final String CLIENT_ACCEPT_PAYMENTS = "Accept Payments";
    public static final String CLIENT_P4B = "P4B";
    public static final String DEACTIVATION_ENABLED_PPI_CHANGES = "deactivation_enabled_ppiLimits";
    public static final String FETCH_GSTIN_LEAD_STATUS = "fetch_gstin_lead_status";
    public static final String INTENT_EXTRA_SELECTED_END_DATE = "intent_extra_selected_end_date";
    public static final String INTENT_EXTRA_SELECTED_START_DATE = "intent_extra_selected_start_date";
    public static final String KEY_END = "end";
    public static final String KEY_RANGE = "range";
    public static final String KEY_START = "start";
    public static final int PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 0;
    public static final int REQUEST_CODE_DEPART_DATE = 1;
    public static final String SETTLEMENTS = "SETTLEMENTS";
    public static final String SHOULD_SHOW_DEACTIVATE_ACCOUNT = "deactivation_enabled";
    public static final String TYPE = "type";

    public static boolean isP4BClient() {
        return ProfileConfig.getInstance().getClientName().equalsIgnoreCase("P4B");
    }

    public static boolean isAcceptPaymentsClient() {
        return ProfileConfig.getInstance().getClientName().equalsIgnoreCase("Accept Payments");
    }
}
