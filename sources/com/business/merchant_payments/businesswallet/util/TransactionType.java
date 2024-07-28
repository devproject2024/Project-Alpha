package com.business.merchant_payments.businesswallet.util;

public final class TransactionType {
    public static final String ACQUIRING = "ACQUIRING";
    public static final String CANCEL = "CANCEL";
    public static final TransactionType INSTANCE = new TransactionType();
    public static final String REFUND = "REFUND";
    public static final String TRANSFER_FOR_SETTLEMENT = "TRANSFER_FOR_SETTLEMENT";
}
