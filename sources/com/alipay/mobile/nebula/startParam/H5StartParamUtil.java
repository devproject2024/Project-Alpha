package com.alipay.mobile.nebula.startParam;

import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.List;

public class H5StartParamUtil {
    private static final String TAG = "H5StartParamUtil";

    public static void byteToInfo(String str, byte[] bArr, List<H5StartParamInfo> list, StringBuilder sb) {
        if (bArr != null) {
            try {
                String str2 = new String(bArr, AppConstants.UTF_8);
                if (!TextUtils.isEmpty(str2)) {
                    e parseObject = H5Utils.parseObject(str2);
                    sb.append(H5Utils.getString(parseObject, "prerenderPage", ""));
                    e jSONObject = H5Utils.getJSONObject(parseObject, H5Param.LAUNCHER_PARAM, (e) null);
                    if (jSONObject != null && !jSONObject.isEmpty()) {
                        for (String next : jSONObject.keySet()) {
                            try {
                                H5StartParamInfo h5StartParamInfo = new H5StartParamInfo();
                                h5StartParamInfo.tag = next;
                                h5StartParamInfo.param = (e) jSONObject.get(next);
                                list.add(h5StartParamInfo);
                            } catch (Exception e2) {
                                H5Log.e(TAG, (Throwable) e2);
                            }
                        }
                    }
                }
            } catch (Exception e3) {
                H5Log.e(TAG, (Throwable) e3);
                H5LogProvider h5LogProvider = (H5LogProvider) H5Utils.getProvider(H5LogProvider.class.getName());
                if (h5LogProvider != null) {
                    h5LogProvider.logV2("H5_CONFIG_FILE_PARSE_FAIL", (String) null, (String) null, (String) null, "appId=" + str + "^error=" + e3.toString(), "H-EM");
                }
            }
        }
    }
}
