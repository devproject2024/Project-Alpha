package net.one97.paytm.h5.model;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class H5AppDataResponseModel implements IJRDataModel {
    @b(a = "allowed_bridges")
    private List<H5AppAllowedBridgeModel> allowedBridges;
    @b(a = "app_id")
    private String appId;
    @b(a = "name")
    private String appName;
    @b(a = "app_type")
    private String appType;
    @b(a = "meta_info")
    private H5AppMetaInfoModel metaInfo;
    @b(a = "phoenix_status")
    private Boolean phoenixStatus;

    public String getAppType() {
        return this.appType;
    }

    public void setAppType(String str) {
        this.appType = str;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public H5AppMetaInfoModel getMetaInfo() {
        return this.metaInfo;
    }

    public void setMetaInfo(H5AppMetaInfoModel h5AppMetaInfoModel) {
        this.metaInfo = h5AppMetaInfoModel;
    }

    public List<H5AppAllowedBridgeModel> getAllowedBridges() {
        return this.allowedBridges;
    }

    public void setAllowedBridges(List<H5AppAllowedBridgeModel> list) {
        this.allowedBridges = list;
    }

    public Boolean getPhoenixStatus() {
        return this.phoenixStatus;
    }

    public void setPhoenixStatus(Boolean bool) {
        this.phoenixStatus = bool;
    }

    public String toString() {
        return "H5AppDataResponseModel{appId='" + this.appId + '\'' + ", appName='" + this.appName + '\'' + ", metaInfo=" + this.metaInfo + ", allowedBridges=" + this.allowedBridges + ", phoenixStatus=" + this.phoenixStatus + '}';
    }
}
