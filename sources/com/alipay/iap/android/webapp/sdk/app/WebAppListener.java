package com.alipay.iap.android.webapp.sdk.app;

import android.os.Bundle;

public interface WebAppListener {

    public static class Adapter implements WebAppListener {
        public void onAppCreated(Bundle bundle) {
        }

        public void onAppDestroyed(Bundle bundle) {
        }
    }

    void onAppCreated(Bundle bundle);

    void onAppDestroyed(Bundle bundle);
}
