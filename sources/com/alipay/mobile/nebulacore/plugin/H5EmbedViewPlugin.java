package com.alipay.mobile.nebulacore.plugin;

import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.provider.H5EmbededViewProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.view.IH5EmbedView;

public class H5EmbedViewPlugin extends H5SimplePlugin {
    private static final String NB_RENDER = "NBComponent.render";
    private static final String NB_SENDMSG = "NBComponent.sendMessage";
    private static final String TAG = "H5EmbedViewPlugin";

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(NB_RENDER);
        h5EventFilter.addAction(NB_SENDMSG);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        H5EmbededViewProvider embededViewProvider;
        String action = h5Event.getAction();
        if (!TextUtils.equals(action, NB_RENDER) && !TextUtils.equals(action, NB_SENDMSG)) {
            return super.handleEvent(h5Event, h5BridgeContext);
        }
        e param = h5Event.getParam();
        String string = H5Utils.getString(param, "element");
        H5Page h5Page = (H5Page) h5Event.getTarget();
        if (h5Page == null || (embededViewProvider = h5Page.getEmbededViewProvider()) == null) {
            return true;
        }
        IH5EmbedView embedViewWrapperById = embededViewProvider.getEmbedViewWrapperById(string);
        if (TextUtils.equals(action, NB_RENDER)) {
            H5Log.d(TAG, "NB_RENDER");
            if (embedViewWrapperById != null) {
                e jSONObject = H5Utils.getJSONObject(param, "props", (e) null);
                e jSONObject2 = H5Utils.getJSONObject(param, "data", (e) null);
                if (jSONObject != null && !jSONObject.isEmpty()) {
                    jSONObject2.putAll(jSONObject);
                }
                jSONObject2.put("element", (Object) string);
                embedViewWrapperById.onReceivedRender(jSONObject2, h5BridgeContext);
            }
        }
        if (!TextUtils.equals(action, NB_SENDMSG)) {
            return true;
        }
        H5Log.d(TAG, "NB_SENDMSG");
        if (embedViewWrapperById == null) {
            return true;
        }
        String string2 = H5Utils.getString(param, "actionType");
        e jSONObject3 = H5Utils.getJSONObject(param, "data", (e) null);
        jSONObject3.put("element", (Object) string);
        embedViewWrapperById.onReceivedMessage(string2, jSONObject3, h5BridgeContext);
        return true;
    }
}
