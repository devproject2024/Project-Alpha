package net.one97.paytm.upi.mandate.utils;

import com.paytm.android.chat.bean.jsonbean.TxNotifyData;

public enum l {
    ACTIVE("ACTIVE"),
    EXPIRED(TxNotifyData.UPI_STATUS_EXPIRED),
    CANCELLED(TxNotifyData.UPI_STATUS_CANCELLED),
    DECLINED(TxNotifyData.UPI_STATUS_DECLINED),
    COMPLETED("COMPLETED"),
    DEEMED("DEEMED"),
    PENDING_CREATE("PENDING_CREATE"),
    PENDING_UPDATE("PENDING_UPDATE"),
    PENDING_CANCELLATION("PENDING_CANCELLATION"),
    PENDING_DECLINE("PENDING_DECLINE"),
    PENDING_EXECUTE("PENDING_EXECUTE"),
    FAILED_EXECUTION_ACTIVE("FAILED_EXECUTION_ACTIVE"),
    FAILED_EXECUTION_EXPIRED("FAILED_EXECUTION_EXPIRED"),
    SUCCESS_UPDATE_ACTIVE("SUCCESS_UPDATE_ACTIVE"),
    FAILED_UPDATE_ACTIVE("FAILED_UPDATE_ACTIVE"),
    FAILED_REVOKE_ACTIVE("FAILED_REVOKE_ACTIVE");
    
    private final String status;

    private l(String str) {
        this.status = str;
    }

    public final String getStatus() {
        return this.status;
    }
}
