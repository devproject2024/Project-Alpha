package net.one97.paytm.bankCommon.model.nominee;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class NomineeEditStatusResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "response")
    private Response response;
    @b(a = "success")
    private Boolean success;

    public Response getResponse() {
        return this.response;
    }

    public void setResponse(Response response2) {
        this.response = response2;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean bool) {
        this.success = bool;
    }

    public static class Response extends IJRPaytmDataModel {
        @b(a = "ISA")
        private ISA iSA;

        public ISA getISA() {
            return this.iSA;
        }

        public void setISA(ISA isa) {
            this.iSA = isa;
        }
    }

    public static class ISA extends IJRPaytmDataModel {
        @b(a = "status")
        private String status;
        @b(a = "updatedAt")
        private long updatedAt;
        @b(a = "updatedBy")
        private String updatedBy;

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public long getUpdatedAt() {
            return this.updatedAt;
        }

        public void setUpdatedAt(long j) {
            this.updatedAt = j;
        }

        public String getUpdatedBy() {
            return this.updatedBy;
        }

        public void setUpdatedBy(String str) {
            this.updatedBy = str;
        }
    }
}
