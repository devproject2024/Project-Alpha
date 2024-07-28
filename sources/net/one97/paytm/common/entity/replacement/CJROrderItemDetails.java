package net.one97.paytm.common.entity.replacement;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderItemDetails implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "existingAttribute")
    private CJRExistingAttribute mExistingAttribute;

    public CJRExistingAttribute getExistingAttribute() {
        return this.mExistingAttribute;
    }
}
