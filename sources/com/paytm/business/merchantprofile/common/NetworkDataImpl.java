package com.paytm.business.merchantprofile.common;

import android.content.Context;
import com.business.a.a;
import com.paytm.business.merchantprofile.ProfileConfig;
import com.paytm.business.merchantprofile.common.utility.GTMDataProviderImpl;
import java.util.HashMap;

public class NetworkDataImpl implements a.c {
    public Context appContext;
    public a.C0102a commonHeaderInterface;
    public HashMap<String, String> domainPins;
    public a.b hawkEyeNetworkInterface;
    public boolean isCached;
    public boolean isDebuggable;
    public String verticalName;

    public boolean isCache() {
        return this.isCached;
    }

    public void setCached(boolean z) {
        this.isCached = z;
    }

    public void setDebuggable(boolean z) {
        this.isDebuggable = z;
    }

    public void setHawkEyeNetworkInterface(a.b bVar) {
        this.hawkEyeNetworkInterface = bVar;
    }

    public void setCommonHeaderInterface(a.C0102a aVar) {
        this.commonHeaderInterface = aVar;
    }

    public void setDomainPins(HashMap<String, String> hashMap) {
        this.domainPins = hashMap;
    }

    public void setAppContext(Context context) {
        this.appContext = context;
    }

    public void setVerticalName(String str) {
        this.verticalName = str;
    }

    public boolean isDebuggable() {
        return this.isDebuggable;
    }

    public String getVerticalName() {
        return this.verticalName;
    }

    public a.b getHawkEyeNetworkInterface() {
        return this.hawkEyeNetworkInterface;
    }

    public a.C0102a getCommonHeaderInterface() {
        return this.commonHeaderInterface;
    }

    public HashMap<String, String> getDomainPins() {
        return this.domainPins;
    }

    public Context getAppContext() {
        return this.appContext;
    }

    public static <T> NetworkDataImpl buildData(String str, boolean z) {
        NetworkDataImpl networkDataImpl = new NetworkDataImpl();
        networkDataImpl.setVerticalName(str);
        networkDataImpl.setDebuggable(false);
        networkDataImpl.setHawkEyeNetworkInterface(ProfileConfig.getInstance().getHawkEyeNetworkInterface());
        networkDataImpl.setCommonHeaderInterface(ProfileConfig.getInstance().getCommonHeaderInterface());
        networkDataImpl.setDomainPins(GTMDataProviderImpl.Companion.getMInstance().getSSLPinningConfigAsHashMap());
        networkDataImpl.setAppContext(ProfileConfig.getInstance().getAppContext());
        networkDataImpl.setCached(z);
        return networkDataImpl;
    }

    public static <T> T getAPIService(Class<T> cls, boolean z) {
        return a.a(z ? ProfileConfig.getInstance().getAppContext().getCacheDir() : null, cls, buildData("Payments", z));
    }
}
