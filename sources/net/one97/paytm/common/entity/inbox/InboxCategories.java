package net.one97.paytm.common.entity.inbox;

import com.paytm.network.model.IJRPaytmDataModel;

public class InboxCategories extends IJRPaytmDataModel {
    private String background;
    private String category;
    private String imgUrl;

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public String getBackground() {
        return this.background;
    }

    public void setBackground(String str) {
        this.background = str;
    }

    public String getUrl() {
        return this.imgUrl;
    }

    public void setUrl(String str) {
        this.imgUrl = str;
    }
}
