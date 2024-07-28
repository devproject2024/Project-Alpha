package com.alipay.mobile.nebulacore.api;

import android.os.Bundle;
import com.alipay.mobile.h5container.service.UcService;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.env.H5WebViewChoose;
import com.alipay.mobile.nebulacore.web.H5HardwarePolicy;

public class H5UcInitTask implements Runnable {
    public static final String TAG = "H5UcInitTask";
    private Bundle bundle;
    private long taskInit = System.currentTimeMillis();
    private boolean urgent;

    public H5UcInitTask(boolean z, Bundle bundle2) {
        this.urgent = z;
        this.bundle = bundle2;
    }

    public void run() {
        if (H5WebViewChoose.notNeedInitUc(this.bundle)) {
            H5Log.d(TAG, "not need init uc");
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis() - this.taskInit;
            H5Log.d(TAG, "init uc task wait phase0 " + currentTimeMillis + " urgent " + this.urgent);
            UcService ucService = H5Environment.getUcService();
            long currentTimeMillis2 = (System.currentTimeMillis() - this.taskInit) - currentTimeMillis;
            boolean z = false;
            if (ucService == null) {
                H5Log.e(TAG, "ucService == null");
                H5WebViewChoose.sendUcReceiver(false);
            } else if (Nebula.disableHWACByUCStyle()) {
                if (!H5HardwarePolicy.disableHardwareAccelerate(this.bundle, (String) null)) {
                    z = true;
                }
                ucService.init(z);
            } else {
                ucService.init(H5HardwarePolicy.isAbove14Level());
            }
            H5Log.d(TAG, "init uc task phase1 " + currentTimeMillis2 + " phase2 " + (((System.currentTimeMillis() - this.taskInit) - currentTimeMillis) - currentTimeMillis2));
        } catch (Exception e2) {
            H5Log.e(TAG, "catch exception ", e2);
        }
    }
}
