package net.one97.paytm.recharge.model.rechargeutility;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRUtilityBottomTabData implements IJRDataModel {
    @b(a = "default")
    private String defaultSelected;
    @b(a = "disabled_icon_url")
    private String disabledIconUrl;
    @b(a = "icon_title")
    private String iconTitle;
    @b(a = "icon_url")
    private String iconUrl;
    @b(a = "redirection_url")
    private String redirectionUrl;
    @b(a = "type")
    private String type;

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getRedirectionUrl() {
        return this.redirectionUrl;
    }

    public String getType() {
        return this.type;
    }

    public boolean isDefaultSelected() {
        if (!TextUtils.isEmpty(this.defaultSelected)) {
            return this.defaultSelected.equalsIgnoreCase(this.iconTitle);
        }
        return false;
    }

    public String getIconTitle() {
        return this.iconTitle;
    }

    public String getDisabledIconUrl() {
        return this.disabledIconUrl;
    }

    public void setDisabledIconUrl(String str) {
        this.disabledIconUrl = str;
    }
}
