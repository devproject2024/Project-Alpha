package com.business.merchant_payments.payment.listener;

import com.business.merchant_payments.common.BaseListener;

public interface InitiateRefundListener extends BaseListener {
    String getComingFromScreen();

    void showDialog(String str, String str2);
}
