package net.one97.paytm.common.entity.cst;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCSTTicketDetail implements IJRDataModel {
    @b(a = "caseNumber")
    private String caseNumber;
    @b(a = "errors")
    private String errors;
    @b(a = "id")
    private String id;
    @b(a = "success")
    private boolean success;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getErrors() {
        return this.errors;
    }

    public void setErrors(String str) {
        this.errors = str;
    }

    public String getCaseNumber() {
        return this.caseNumber;
    }

    public void setCaseNumber(String str) {
        this.caseNumber = str;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
