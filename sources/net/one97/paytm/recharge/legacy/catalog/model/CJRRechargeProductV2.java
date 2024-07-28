package net.one97.paytm.recharge.legacy.catalog.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.recharge.model.CJRGroupField;

public class CJRRechargeProductV2 implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "brand_image")
    private String mBrandImage;
    @b(a = "group_field")
    public ArrayList<CJRGroupField> mGroupFields;
    @b(a = "id")
    private String mId;
    @b(a = "meta_description")
    private String mMetaData;
    @b(a = "name")
    private String mName;
    @b(a = "operator_image")
    private String mOperatorImage;
    @b(a = "url")
    private String mUrl;

    public String getName() {
        return this.mName;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getId() {
        return this.mId;
    }

    public String getBrandImage() {
        return this.mBrandImage;
    }

    public String getOperatorImage() {
        return this.mOperatorImage;
    }

    public ArrayList<CJRGroupField> getGroupFields() {
        return this.mGroupFields;
    }

    public String getmMetaData() {
        return this.mMetaData;
    }

    public String getOperatorName() {
        return this.mName;
    }
}
