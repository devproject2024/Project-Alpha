package com.alipay.mobile.nebulacore.env;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;
import com.alipay.mobile.h5container.api.H5Context;
import com.alipay.mobile.h5container.service.RnService;
import com.alipay.mobile.h5container.service.UcService;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.provider.H5ToastProvider;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl;
import com.alipay.mobile.nebulacore.wallet.H5WalletWrapper;

public class H5Environment {
    public static final String TAG = "H5Environment";
    private static Context context;

    public static String getSessionId(H5Context h5Context, Bundle bundle) {
        return H5WalletWrapper.getSessionId(h5Context, bundle);
    }

    public static void startActivity(H5Context h5Context, Intent intent) {
        H5WalletWrapper.startActivity(h5Context, intent);
    }

    public static Class<?> getClass(String str, String str2) {
        return H5WalletWrapper.getClass(str, str2);
    }

    public static Context getContext() {
        if (context == null) {
            Context context2 = H5Utils.getContext();
            context = context2;
            if (context2 != null) {
                context = context.getApplicationContext();
            }
        }
        return context;
    }

    public static void setContext(Context context2) {
        if (context == null && context2 != null) {
            context = context2.getApplicationContext();
        }
    }

    public static Resources getResources() {
        return H5WalletWrapper.getResources();
    }

    public static UcService getUcService() {
        return H5WalletWrapper.getUcService();
    }

    public static RnService getRnService() {
        return H5WalletWrapper.getRnService();
    }

    public static String getConfig(String str) {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) Nebula.getProviderManager().getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider == null) {
            return null;
        }
        return h5ConfigProvider.getConfig(str);
    }

    public static String getConfigWithProcessCache(String str) {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) Nebula.getProviderManager().getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider == null) {
            return null;
        }
        return h5ConfigProvider.getConfigWithProcessCache(str);
    }

    public static void showToast(Context context2, String str, int i2) {
        H5ToastProvider h5ToastProvider = (H5ToastProvider) H5ProviderManagerImpl.getInstance().getProvider(H5ToastProvider.class.getName());
        if (h5ToastProvider != null) {
            h5ToastProvider.makeToast(context2, str, i2);
        } else {
            Toast.makeText(context2, str, i2).show();
        }
    }

    public static boolean isInWallet() {
        return H5Utils.isInWallet();
    }
}
