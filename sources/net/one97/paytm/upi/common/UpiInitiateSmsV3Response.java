package net.one97.paytm.upi.common;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class UpiInitiateSmsV3Response extends IJRPaytmDataModel implements UpiBaseDataModel {
    @b(a = "requestId")
    private final String requestId;
    @b(a = "respCode")
    private final String respCode;
    @b(a = "respDetails")
    private final ResponseDetails respDetails;
    @b(a = "respMessage")
    private final String respMessage;
    @b(a = "status")
    private final String status;

    public final String getStatus() {
        return this.status;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getRespMessage() {
        return this.respMessage;
    }

    public final String getRespCode() {
        return this.respCode;
    }

    public final ResponseDetails getRespDetails() {
        return this.respDetails;
    }

    public UpiInitiateSmsV3Response(String str, String str2, String str3, String str4, ResponseDetails responseDetails) {
        k.c(str, "status");
        k.c(str2, "requestId");
        k.c(str3, "respMessage");
        k.c(str4, "respCode");
        k.c(responseDetails, "respDetails");
        this.status = str;
        this.requestId = str2;
        this.respMessage = str3;
        this.respCode = str4;
        this.respDetails = responseDetails;
    }

    public static final class ResponseDetails extends IJRPaytmDataModel implements UpiBaseDataModel {
        @b(a = "verificationData")
        private final String verificationData;
        @b(a = "vmnDetails")
        private final ArrayList<Vmn> vmnDetails;

        public final String getVerificationData() {
            return this.verificationData;
        }

        public final ArrayList<Vmn> getVmnDetails() {
            return this.vmnDetails;
        }

        public ResponseDetails(String str, ArrayList<Vmn> arrayList) {
            k.c(str, "verificationData");
            k.c(arrayList, "vmnDetails");
            this.verificationData = str;
            this.vmnDetails = arrayList;
        }
    }

    public static final class Vmn extends IJRPaytmDataModel implements UpiBaseDataModel {
        @b(a = "vmn")
        private final String vmn;

        public Vmn(String str) {
            k.c(str, "vmn");
            this.vmn = str;
        }

        public final String getVmn() {
            return this.vmn;
        }
    }
}
