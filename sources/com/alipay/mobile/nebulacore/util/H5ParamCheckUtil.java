package com.alipay.mobile.nebulacore.util;

import android.os.Bundle;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.provider.H5StartParamCheck;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;

public class H5ParamCheckUtil {
    public static final String TAG = "H5ParamCheckUtil";

    public static void checkParams(Bundle bundle) {
        H5StartParamCheck h5StartParamCheck;
        if (!H5Utils.getBoolean(bundle, H5Param.isTinyApp, false) && (h5StartParamCheck = (H5StartParamCheck) Nebula.getProviderManager().getProvider(H5StartParamCheck.class.getName())) != null) {
            h5StartParamCheck.checkParams(bundle);
        }
    }
}
