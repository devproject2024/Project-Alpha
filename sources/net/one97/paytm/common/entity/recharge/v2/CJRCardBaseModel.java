package net.one97.paytm.common.entity.recharge.v2;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCardBaseModel extends IJRPaytmDataModel implements IJRDataModel {
    private String operaterCardTypeImageUrl;
    private String operatorIimageUrl;

    public final String getOperatorIimageUrl() {
        return this.operatorIimageUrl;
    }

    public final void setOperatorIimageUrl(String str) {
        this.operatorIimageUrl = str;
    }

    public final String getOperaterCardTypeImageUrl() {
        return this.operaterCardTypeImageUrl;
    }

    public final void setOperaterCardTypeImageUrl(String str) {
        this.operaterCardTypeImageUrl = str;
    }
}
