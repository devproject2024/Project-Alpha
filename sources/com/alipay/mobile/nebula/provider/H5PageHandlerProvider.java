package com.alipay.mobile.nebula.provider;

import android.app.Activity;
import com.alipay.mobile.h5container.api.H5Page;

public interface H5PageHandlerProvider {
    boolean handlerPageExit(H5Page h5Page, Activity activity);
}
