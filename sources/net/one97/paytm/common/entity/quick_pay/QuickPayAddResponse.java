package net.one97.paytm.common.entity.quick_pay;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class QuickPayAddResponse extends IJRPaytmDataModel implements IJRDataModel {
    private PayLoad payload;
    private int responseCode;
    private String responseMessage;

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public void setResponseMessage(String str) {
        this.responseMessage = str;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(int i2) {
        this.responseCode = i2;
    }

    public PayLoad getPayload() {
        return this.payload;
    }

    public void setPayload(PayLoad payLoad) {
        this.payload = payLoad;
    }

    public class PayLoad {
        private long siId;

        public PayLoad() {
        }

        public long getSiId() {
            return this.siId;
        }

        public void setSiId(long j) {
            this.siId = j;
        }
    }
}
