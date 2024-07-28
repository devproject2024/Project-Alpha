package net.one97.paytm.recharge.legacy.catalog.model.v2;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class TopLevelCategoryHeader implements IJRDataModel {
    @b(a = "url")
    public String deeplink;
    @b(a = "description")
    public String description;
    @b(a = "title")
    public String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getDeeplink() {
        return this.deeplink;
    }

    public void setDeeplink(String str) {
        this.deeplink = str;
    }
}
