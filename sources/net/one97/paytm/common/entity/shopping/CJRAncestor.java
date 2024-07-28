package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.CJRDataModelItem;

public class CJRAncestor extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "id")
    private String mAncestorID;
    @b(a = "name")
    private String mAncestorName;
    @b(a = "url_key")
    private String mURLKey;

    public String getName() {
        return this.mAncestorName;
    }

    public String getAncestorID() {
        return this.mAncestorID;
    }

    public String getURLKey() {
        return this.mURLKey;
    }
}
