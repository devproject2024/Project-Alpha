package com.business.merchant_payments.businesswallet.util;

import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.model.businesswallet.OrderDetail;
import com.business.merchant_payments.model.lastcollectedpaymentmodel.OfflineTransDetailObject;
import kotlin.g.b.k;

public final class BWalletUtil {
    public static final BWalletUtil INSTANCE = new BWalletUtil();

    public final OfflineTransDetailObject transformWalletOrder(OrderDetail orderDetail) {
        if (orderDetail == null) {
            return null;
        }
        OfflineTransDetailObject offlineTransDetailObject = new OfflineTransDetailObject();
        offlineTransDetailObject.setmPayerPhoneNumber(AppUtility.getMaskedMobileNumber(orderDetail.getUserPhoneNo()));
        offlineTransDetailObject.setmCustID(orderDetail.getCustId());
        offlineTransDetailObject.setmTransactionID(orderDetail.getTxnId());
        offlineTransDetailObject.setmTransactionAmmount(orderDetail.getTxnAmt());
        offlineTransDetailObject.setmTransactionStatus(orderDetail.getOrderStatus());
        offlineTransDetailObject.setmTransactionType(INSTANCE.mapOrderType(orderDetail.getOrderType()));
        offlineTransDetailObject.setmCommissionAmmount(orderDetail.getServiceFee());
        offlineTransDetailObject.setmServiceTax(orderDetail.getTaxFee());
        offlineTransDetailObject.setmChangeBackAmmount(orderDetail.getMerchantId());
        offlineTransDetailObject.setIsSettled("0");
        offlineTransDetailObject.setmMerchantOrderID(orderDetail.getOrderId());
        offlineTransDetailObject.setmPosID(orderDetail.getMerchantPosOrderId());
        offlineTransDetailObject.setmMerchantID(orderDetail.getMerchantId());
        offlineTransDetailObject.setmMerchantName(orderDetail.getMerchantName());
        offlineTransDetailObject.setmMerchantDisplayName(orderDetail.getMerchantName());
        offlineTransDetailObject.setmSettlementAmmount(INSTANCE.calculateNetAmount(orderDetail));
        offlineTransDetailObject.setmUserPhoneNo(orderDetail.getUserPhoneNo());
        offlineTransDetailObject.setMaskedCardNo(orderDetail.getMaskedCardNo());
        offlineTransDetailObject.setUserVPA(orderDetail.getUserVPA());
        offlineTransDetailObject.setUserName(orderDetail.getUserName());
        offlineTransDetailObject.setPayMethod(orderDetail.getPayMethod());
        String orderCreatedTime = orderDetail.getOrderCreatedTime();
        if (orderCreatedTime != null) {
            offlineTransDetailObject.setmTransactionDate(DateUtility.getFormattedDate(orderCreatedTime, "yyyy-MM-dd HH:mm:ss", "dd/MM/yyyy HH:mm:ss"));
        }
        String orderCompletedTime = orderDetail.getOrderCompletedTime();
        if (orderCompletedTime != null) {
            offlineTransDetailObject.setmSettlementDate(DateUtility.getFormattedDate(orderCompletedTime, "yyyy-MM-dd HH:mm:ss", "dd/MM/yyyy HH:mm:ss"));
        }
        return offlineTransDetailObject;
    }

    private final String mapOrderType(String str) {
        return k.a((Object) TransactionType.TRANSFER_FOR_SETTLEMENT, (Object) str) ? "PAYER_TO_MERCHANT_TRANSFER" : str;
    }

    private final String calculateNetAmount(OrderDetail orderDetail) {
        return String.valueOf(parseAmount(orderDetail.getTxnAmt()) - (parseAmount(orderDetail.getServiceFee()) + parseAmount(orderDetail.getTaxFee())));
    }

    private final double parseAmount(String str) {
        if (str == null) {
            str = "0.0";
        }
        try {
            return Double.parseDouble(str);
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    private final String getTxnAmount(OfflineTransDetailObject offlineTransDetailObject) {
        double parseAmount = parseAmount(offlineTransDetailObject.getmServiceTax());
        double parseAmount2 = parseAmount(offlineTransDetailObject.getmCommissionAmmount());
        return String.valueOf(parseAmount(offlineTransDetailObject.getmTransactionAmmount()) - ((parseAmount + parseAmount2) + parseAmount(offlineTransDetailObject.getChargebackAmt())));
    }
}
