package net.one97.paytm.common.entity.brts;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBrtsUTS extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "displayMerchantName")
    private String mDisplayMerchantName;
    @b(a = "industryType")
    private String mIndustryType;
    @b(a = "merchantGuid")
    private String mMerchantGuid;
    @b(a = "merchantLogo")
    private String mMerchantLogoURL;
    @b(a = "merchantName")
    private String mMerchantName;
    @b(a = "pax")
    private ArrayList<String> mPaxTypes;
    @b(a = "routes")
    private ArrayList<CJRBrtsRoute> mRoutes;
    @b(a = "sourceId")
    private String mSourceId;
    @b(a = "sourceName")
    private String mSourceName;

    public String getMerchantGuid() {
        return this.mMerchantGuid;
    }

    public String getIndustryType() {
        return this.mIndustryType;
    }

    public String getSourceName() {
        return this.mSourceName;
    }

    public ArrayList<CJRBrtsRoute> getRoutes() {
        return this.mRoutes;
    }

    public String getMerchantLogoURL() {
        return this.mMerchantLogoURL;
    }

    public String getMerchantName() {
        return this.mMerchantName;
    }

    public String getSourceId() {
        return this.mSourceId;
    }

    public ArrayList<String> getmPaxTypes() {
        return this.mPaxTypes;
    }

    public String getmDisplayMerchantName() {
        return this.mDisplayMerchantName;
    }

    public void setmDisplayMerchantName(String str) {
        this.mDisplayMerchantName = str;
    }
}
