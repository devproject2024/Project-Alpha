package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRSearchPopularProduct extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "image_url")
    private String mImageUrl;
    @b(a = "price")
    private String mPrice;
    @b(a = "text")
    private String mText;
    @b(a = "newurl")
    private String mUrl;

    public String getmText() {
        return this.mText;
    }

    public void setmText(String str) {
        this.mText = str;
    }

    public String getmUrl() {
        return this.mUrl;
    }

    public void setmUrl(String str) {
        this.mUrl = str;
    }

    public String getmImageUrl() {
        return this.mImageUrl;
    }

    public void setmImageUrl(String str) {
        this.mImageUrl = str;
    }

    public String getmPrice() {
        return this.mPrice;
    }

    public void setmPrice(String str) {
        this.mPrice = str;
    }
}
