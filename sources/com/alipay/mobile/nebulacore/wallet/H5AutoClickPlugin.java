package com.alipay.mobile.nebulacore.wallet;

import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebulacore.Nebula;

public class H5AutoClickPlugin extends H5SimplePlugin {
    private static final String autoClick = "autoClick";

    public void onPrepare(H5EventFilter h5EventFilter) {
        super.onPrepare(h5EventFilter);
        h5EventFilter.addAction(autoClick);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (!TextUtils.equals(h5Event.getAction(), autoClick)) {
            return super.handleEvent(h5Event, h5BridgeContext);
        }
        if (H5Logger.enableStockTradeLog() && Nebula.getH5LogHandler() != null) {
            Nebula.getH5LogHandler().autoClick(h5Event);
        }
        h5BridgeContext.sendSuccess();
        return true;
    }
}
