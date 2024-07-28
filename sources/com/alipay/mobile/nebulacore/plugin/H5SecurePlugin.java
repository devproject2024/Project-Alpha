package com.alipay.mobile.nebulacore.plugin;

import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5RsaUtil;
import com.alipay.mobile.nebula.util.H5Utils;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public class H5SecurePlugin extends H5SimplePlugin {
    public static final String TAG = "H5SecurePlugin";

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5Plugin.CommonEvents.RSA);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (!H5Plugin.CommonEvents.RSA.equals(h5Event.getAction())) {
            return true;
        }
        rsa(h5Event, h5BridgeContext);
        return true;
    }

    private void rsa(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        e param = h5Event.getParam();
        String string = H5Utils.getString(param, "action");
        String string2 = H5Utils.getString(param, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        String string3 = H5Utils.getString(param, "key");
        if (TextUtils.isEmpty(string2)) {
            H5Log.e(TAG, "invalid text");
            e eVar = new e();
            eVar.put("error", (Object) 10);
            h5BridgeContext.sendBridgeResult(eVar);
        } else if (TextUtils.isEmpty(string3)) {
            H5Log.e(TAG, "invalid key");
            e eVar2 = new e();
            eVar2.put("error", (Object) 11);
            h5BridgeContext.sendBridgeResult(eVar2);
        } else {
            String str = null;
            if (TextUtils.equals(string, "encrypt")) {
                str = H5RsaUtil.encrypt(string2, string3);
            } else if (TextUtils.equals(string, "decrypt")) {
                str = H5RsaUtil.decrypt(string2, string3);
            }
            if (TextUtils.isEmpty(str)) {
                H5Log.e(TAG, "ras error!");
                e eVar3 = new e();
                eVar3.put("error", (Object) 11);
                h5BridgeContext.sendBridgeResult(eVar3);
                return;
            }
            e eVar4 = new e();
            eVar4.put(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, (Object) str);
            h5BridgeContext.sendBridgeResult(eVar4);
        }
    }
}
