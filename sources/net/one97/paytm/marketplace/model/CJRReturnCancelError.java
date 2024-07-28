package net.one97.paytm.marketplace.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRReturnCancelError implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "error_description")
    private String errorDescription;
    @b(a = "error_title")
    private String errorTitle;

    public String getErrorTitle() {
        return this.errorTitle;
    }

    public String getErrorDescription() {
        return this.errorDescription;
    }
}
