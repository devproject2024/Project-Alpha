package net.one97.paytm.recharge.legacy.catalog.model;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRUtilityFilterAttributesV2 implements IJRDataModel {
    @b(a = "bank_code")
    private String bankCode;
    @b(a = "bbps_logo_url")
    private String bbpsLogoURL;
    @b(a = "bg_image")
    private String bgImageUrl;
    @b(a = "config_metro")
    private String config_metro;
    @b(a = "config_ticket_type")
    private String config_ticket_type;
    @b(a = "desc")
    private String description;
    @b(a = "group_config_key")
    private String groupConfigKey;
    @b(a = "icon")
    private String icon;
    @b(a = "image")
    private String image_url;
    @b(a = "label")
    private String label;
    @b(a = "min_android_version")
    private String minAndroidVersion;
    @b(a = "reqType1")
    private String productRequestType;
    @b(a = "schedulable")
    private String schedulable;

    public void setImage_url(String str) {
        this.image_url = str;
    }

    public String getImage_url() {
        return this.image_url;
    }

    public String getBgImageUrl() {
        return this.bgImageUrl;
    }

    public void setBgImageUrl(String str) {
        this.bgImageUrl = str;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getDescription() {
        return this.description;
    }

    public String[] getGroupConfigKeyList() {
        return !TextUtils.isEmpty(this.groupConfigKey) ? this.groupConfigKey.split(AppConstants.COMMA) : new String[0];
    }

    public void setGroupConfigKey(String str) {
        this.groupConfigKey = str;
    }

    public String getBbpsLogoURL() {
        return this.bbpsLogoURL;
    }

    public void setBbpsLogoURL(String str) {
        this.bbpsLogoURL = str;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public String getMinAndroidVersion() {
        return this.minAndroidVersion;
    }

    public void setMinAndroidVersion(String str) {
        this.minAndroidVersion = str;
    }

    public boolean isSchedulable() {
        return !TextUtils.isEmpty(this.schedulable) && "1".equalsIgnoreCase(this.schedulable);
    }

    public String getSchedulable() {
        return this.schedulable;
    }

    public void setSchedulable(String str) {
        this.schedulable = str;
    }

    public String getBankCode() {
        return this.bankCode;
    }

    public String getConfig_metro() {
        return this.config_metro;
    }

    public String getConfig_ticket_type() {
        return this.config_ticket_type;
    }

    public String getProductRequestType() {
        return this.productRequestType;
    }
}
