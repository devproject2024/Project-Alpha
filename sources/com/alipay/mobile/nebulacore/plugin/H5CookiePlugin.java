package com.alipay.mobile.nebulacore.plugin;

import android.text.TextUtils;
import android.webkit.CookieManager;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.util.H5CookieUtil;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5PatternHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.sendbird.android.constant.StringSet;
import java.util.regex.Pattern;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public class H5CookiePlugin extends H5SimplePlugin {
    public static final String TAG = "H5CookiePlugin";
    private H5Page h5Page = null;

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5Plugin.CommonEvents.GET_COOKIE);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (!H5Plugin.CommonEvents.GET_COOKIE.equals(h5Event.getAction()) || !(h5Event.getTarget() instanceof H5Page)) {
            return true;
        }
        this.h5Page = (H5Page) h5Event.getTarget();
        getCookie(h5BridgeContext);
        return true;
    }

    private void getCookie(H5BridgeContext h5BridgeContext) {
        String string = H5Utils.getString(this.h5Page.getParams(), "appId");
        boolean z = H5Utils.getBoolean(this.h5Page.getParams(), H5Param.isH5app, false);
        H5Log.d(TAG, "appId:" + string + " isH5App:" + z);
        if (!z) {
            setError(h5BridgeContext);
            return;
        }
        e eVar = new e();
        String url = this.h5Page.getUrl();
        String cookie = H5CookieUtil.getCookie(url);
        H5Log.d(TAG, "host:" + url + " cookieStr:" + cookie);
        if (!TextUtils.isEmpty(cookie)) {
            eVar.put("success", (Object) Boolean.TRUE);
            eVar.put("cookie", (Object) cookie);
            h5BridgeContext.sendBridgeResult(eVar);
            return;
        }
        eVar.put("error", (Object) 11);
        eVar.put(ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE, (Object) H5Environment.getResources().getString(R.string.h5_not_get_value));
        h5BridgeContext.sendBridgeResult(eVar);
    }

    private void setError(H5BridgeContext h5BridgeContext) {
        String string = H5Environment.getResources().getString(R.string.h5_norightinvoke);
        e eVar = new e();
        eVar.put("error", (Object) 4);
        eVar.put(ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE, (Object) string);
        h5BridgeContext.sendBridgeResult(eVar);
    }

    private void getMtopToken(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        Pattern compile;
        e param = h5Event.getParam();
        String cookie = CookieManager.getInstance().getCookie((param == null || !param.containsKey("domain") || TextUtils.isEmpty(param.getString("domain"))) ? ".taobao.com" : param.getString("domain"));
        String str = "";
        if (!TextUtils.isEmpty(cookie) && (compile = H5PatternHelper.compile("; ")) != null) {
            String[] split = compile.split(cookie);
            int length = split.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    String str2 = split[i2];
                    if (str2 != null && str2.startsWith("_m_h5_tk=")) {
                        str = str2.replace("_m_h5_tk=", str);
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
        }
        e eVar = new e();
        eVar.put(StringSet.token, (Object) str);
        h5BridgeContext.sendBridgeResult(eVar);
    }
}
