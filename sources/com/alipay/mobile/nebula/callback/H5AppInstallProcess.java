package com.alipay.mobile.nebula.callback;

import com.alipay.mobile.nebula.appcenter.util.H5AppInstallStep;

public interface H5AppInstallProcess {
    void onResult(boolean z, boolean z2);

    void prepare(H5AppInstallStep h5AppInstallStep, String str);
}
