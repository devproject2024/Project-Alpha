package com.paytm.business.merchantprofile.inactivemerchant;

public final class ReactivationStatusNetwork {
    public static final String AWAITING_CLOSE = "AWAITING_CLOSE";
    public static final ReactivationStatusNetwork INSTANCE = new ReactivationStatusNetwork();
    public static final String LEAD_CLOSED = "LEAD_CLOSED";
    public static final String LEAD_CREATED = "LEAD_CREATED";
    public static final String LEAD_NOT_PRESENT = "LEAD_NOT_PRESENT";
    public static final String MERCHANT_REACTIVATION_FAILED = "MERCHANT_REACTIVATION_FAILED";
    public static final String MERCHANT_REACTIVATION_SUCCESS = "MERCHANT_REACTIVATION_SUCCESS";
}
