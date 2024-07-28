package com.alipay.mobile.nebula.view;

import android.content.Context;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.nebula.callback.H5SimpleRpcListener;

public interface IH5TinyPopMenu {
    void init(H5Page h5Page, String str, Context context);

    void onRelease();

    void requestRpc(H5SimpleRpcListener h5SimpleRpcListener, H5Page h5Page, Context context);

    void showMenu();
}
