package com.alipay.mobile.nebulacore.plugin;

import android.net.Uri;
import android.text.ClipboardManager;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.env.H5Environment;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public class H5ClipboardPlugin extends H5SimplePlugin {
    public static final String TAG = "H5ClipboardPlugin";

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5Plugin.CommonEvents.SET_CLIPBOARD);
        h5EventFilter.addAction(H5Plugin.CommonEvents.GET_CLIPBOARD);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        if (H5Plugin.CommonEvents.SET_CLIPBOARD.equals(action)) {
            setClipboard(h5Event, h5BridgeContext);
            return true;
        } else if (!H5Plugin.CommonEvents.GET_CLIPBOARD.equals(action)) {
            return true;
        } else {
            getClipboard(h5BridgeContext);
            return true;
        }
    }

    public void setClipboard(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        e param = h5Event.getParam();
        if (param == null) {
            h5BridgeContext.sendError(h5Event, H5Event.Error.INVALID_PARAM);
            return;
        }
        String string = H5Utils.getString(param, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        if (string.startsWith("https://ds.alipay.com/error/securityLink.htm") || string.startsWith("https://ds.alipay.com/error/redirectLink.htm")) {
            string = Uri.parse(string).getQueryParameter("url");
            H5Log.d(TAG, "competitive link special text is ".concat(String.valueOf(string)));
        }
        ((ClipboardManager) H5Environment.getContext().getSystemService("clipboard")).setText(string);
        h5BridgeContext.sendSuccess();
    }

    private void getClipboard(H5BridgeContext h5BridgeContext) {
        CharSequence charSequence;
        try {
            charSequence = ((ClipboardManager) H5Environment.getContext().getSystemService("clipboard")).getText();
        } catch (Throwable th) {
            H5Log.e(TAG, th);
            charSequence = null;
        }
        String charSequence2 = charSequence != null ? charSequence.toString() : "";
        e eVar = new e();
        eVar.put(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, (Object) charSequence2);
        h5BridgeContext.sendBridgeResult(eVar);
    }
}
