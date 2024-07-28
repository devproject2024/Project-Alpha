package net.one97.paytm.dynamic.module.eduforms.plugins;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJREduFeeAndroid extends IJRPaytmDataModel {
    @b(a = "launch_url")
    private String launchUrl;
    @b(a = "min_supported_app_version")
    private String minSupportedAppVersion;
    @b(a = "min_supported_os_version")
    private int minSupportedOsVersion;

    public String getMinSupportedAppVersion() {
        return this.minSupportedAppVersion;
    }

    public int getMinSupportedOsVersion() {
        return this.minSupportedOsVersion;
    }

    public String getLaunchUrl() {
        return this.launchUrl;
    }
}
