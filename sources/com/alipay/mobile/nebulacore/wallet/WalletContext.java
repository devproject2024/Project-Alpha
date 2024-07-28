package com.alipay.mobile.nebulacore.wallet;

import android.content.Context;
import com.alipay.mobile.framework.app.f;
import com.alipay.mobile.h5container.api.H5Context;

public class WalletContext extends H5Context {
    private f microApp;

    public WalletContext(Context context) {
        super(context);
    }

    public f getMicroApplication() {
        return this.microApp;
    }

    public void setMicroApplication(f fVar) {
        this.microApp = fVar;
    }
}
