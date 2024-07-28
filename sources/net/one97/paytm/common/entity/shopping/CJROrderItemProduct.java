package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderItemProduct implements Cloneable, IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "category_id")
    private String category_id;
    @b(a = "need_shipping")
    private String mNeedShipping;
    @b(a = "id")
    private long mProductId;
    @b(a = "thumbnail")
    private String mThumbnail;
    @b(a = "vertical_id")
    private long mVerticalId;
    @b(a = "vertical_label")
    private String mVerticalLabel;

    public String getVerticalLabel() {
        return this.mVerticalLabel;
    }

    public long getVerticalId() {
        return this.mVerticalId;
    }

    public String getThumbnail() {
        return this.mThumbnail;
    }

    public long getProductId() {
        return this.mProductId;
    }

    public void setmVerticalLabel(String str) {
        this.mVerticalLabel = str;
    }

    public void setNeedShipping(String str) {
        this.mNeedShipping = str;
    }

    public String getNeedShipping() {
        return this.mNeedShipping;
    }

    public CJROrderItemProduct clone() throws CloneNotSupportedException {
        return (CJROrderItemProduct) super.clone();
    }

    public String getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id(String str) {
        this.category_id = str;
    }
}
