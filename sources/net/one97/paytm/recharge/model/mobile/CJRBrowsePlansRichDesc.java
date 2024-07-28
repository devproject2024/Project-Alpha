package net.one97.paytm.recharge.model.mobile;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBrowsePlansRichDesc implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "attributes")
    private CJRBrowsePlansDescAttributes mAttributes;
    @b(a = "description")
    private String mDescription;
    @b(a = "title")
    private String mTitle;

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public CJRBrowsePlansDescAttributes getAttributes() {
        return this.mAttributes;
    }

    public void setmDescription(String str) {
        this.mDescription = str;
    }
}
