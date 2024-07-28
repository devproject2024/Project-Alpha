package com.paytm.business.merchantprofile.model;

import com.business.common_module.f.a;
import com.google.gson.a.c;
import java.util.List;

public class MappingDetailsModel extends a {
    @c(a = "helpline")
    @com.google.gson.a.a
    public HelpLineModel mHelplineModel;
    @c(a = "merchantLimit")
    @com.google.gson.a.a
    public List<MerchantLimitModel> mMerchantLimitModel = null;

    public HelpLineModel getmHelplineModel() {
        return this.mHelplineModel;
    }

    public void setmHelplineModel(HelpLineModel helpLineModel) {
        this.mHelplineModel = helpLineModel;
    }

    public List<MerchantLimitModel> getmMerchantLimitModel() {
        return this.mMerchantLimitModel;
    }

    public void setmMerchantLimitModel(List<MerchantLimitModel> list) {
        this.mMerchantLimitModel = list;
    }
}
