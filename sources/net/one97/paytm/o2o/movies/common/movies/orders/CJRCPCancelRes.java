package net.one97.paytm.o2o.movies.common.movies.orders;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public final class CJRCPCancelRes extends IJRPaytmDataModel {
    public static final int CANCELLATION_STATUS_AMOUNT_MISMATCH = 3;
    public static final int CANCELLATION_STATUS_FAILED = 0;
    public static final int CANCELLATION_STATUS_PENDING = 2;
    public static final int CANCELLATION_STATUS_SUCCESS = 1;
    public static final a Companion = new a((byte) 0);
    @b(a = "cancellationStatus")
    private Integer cancellationStatus;
    @b(a = "message")
    private String message;
    @b(a = "refundAmount")
    private String refundAmount;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final String getRefundAmount() {
        return this.refundAmount;
    }

    public final void setRefundAmount(String str) {
        this.refundAmount = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final void setCancellationStatus(Integer num) {
        this.cancellationStatus = num;
    }

    public final Integer getCancellationStatus() {
        Integer num = this.cancellationStatus;
        if (num == null) {
            return -1;
        }
        return num;
    }
}
