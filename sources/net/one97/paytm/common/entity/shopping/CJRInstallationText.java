package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRInstallationText implements IJRDataModel {
    @b(a = "additional_text")
    private String mAdditionalText;
    @b(a = "brand_cc")
    private String mBrandCC;
    @b(a = "main_text")
    private String mMainText;
    @b(a = "tollfree_number")
    private String mTollfreeNumber;

    public String getTollfreeNumber() {
        return this.mTollfreeNumber;
    }

    public void setTollfreeNumber(String str) {
        this.mTollfreeNumber = str;
    }

    public String getBrandCC() {
        return this.mBrandCC;
    }

    public void setBrandCC(String str) {
        this.mBrandCC = str;
    }

    public String getMainText() {
        return this.mMainText;
    }

    public void setMainText(String str) {
        this.mMainText = str;
    }

    public String getAdditionalText() {
        return this.mAdditionalText;
    }

    public void setAdditionalText(String str) {
        this.mAdditionalText = str;
    }
}
