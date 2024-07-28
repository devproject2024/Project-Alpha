package net.one97.paytm.phoenix.provider;

import net.one97.paytm.phoenix.provider.H5PartnerAppsDataProvider;

public final class H5PartnerAppsDataProvider$getAppUrl$request$1 implements H5PartnerAppsDataProvider.StoreFrontDataFetched {
    final /* synthetic */ String $appId;
    final /* synthetic */ H5PartnerAppsDataProvider.H5PartnerAppsUrlProviderCallback $callback;

    H5PartnerAppsDataProvider$getAppUrl$request$1(String str, H5PartnerAppsDataProvider.H5PartnerAppsUrlProviderCallback h5PartnerAppsUrlProviderCallback) {
        this.$appId = str;
        this.$callback = h5PartnerAppsUrlProviderCallback;
    }

    public final void onDataFetched() {
        if (H5PartnerAppsDataProvider.appData.get(this.$appId) != null) {
            H5PartnerAppsDataProvider.H5PartnerAppsUrlProviderCallback h5PartnerAppsUrlProviderCallback = this.$callback;
            if (h5PartnerAppsUrlProviderCallback != null) {
                h5PartnerAppsUrlProviderCallback.onAppUrlFetched((MiniAppData) H5PartnerAppsDataProvider.appData.get(this.$appId));
                return;
            }
            return;
        }
        H5PartnerAppsDataProvider.H5PartnerAppsUrlProviderCallback h5PartnerAppsUrlProviderCallback2 = this.$callback;
        if (h5PartnerAppsUrlProviderCallback2 != null) {
            h5PartnerAppsUrlProviderCallback2.onError("AN");
        }
    }

    public final void onError(String str) {
        H5PartnerAppsDataProvider.H5PartnerAppsUrlProviderCallback h5PartnerAppsUrlProviderCallback = this.$callback;
        if (h5PartnerAppsUrlProviderCallback != null) {
            h5PartnerAppsUrlProviderCallback.onError(str);
        }
    }
}
