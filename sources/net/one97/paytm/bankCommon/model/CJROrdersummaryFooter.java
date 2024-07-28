package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrdersummaryFooter implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "description")
    private String mDescription;
    @b(a = "header")
    private String mHeader;

    public String getHeader() {
        return this.mHeader;
    }

    public String getDescription() {
        return this.mDescription;
    }
}
