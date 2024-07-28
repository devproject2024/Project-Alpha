package net.one97.paytm.phoenix.provider;

import net.one97.paytm.phoenix.provider.H5PartnerAppsDataProvider;

public final class H5PartnerAppsDataProvider$getPartnerData$request$1 implements H5PartnerAppsDataProvider.StoreFrontDataFetched {
    final /* synthetic */ H5PartnerAppsDataProvider.H5PartnerAppsDataProviderCallback $callback;

    H5PartnerAppsDataProvider$getPartnerData$request$1(H5PartnerAppsDataProvider.H5PartnerAppsDataProviderCallback h5PartnerAppsDataProviderCallback) {
        this.$callback = h5PartnerAppsDataProviderCallback;
    }

    public final void onDataFetched() {
        if (H5PartnerAppsDataProvider.partnerRawData != null) {
            H5PartnerAppsDataProvider.H5PartnerAppsDataProviderCallback h5PartnerAppsDataProviderCallback = this.$callback;
            if (h5PartnerAppsDataProviderCallback != null) {
                h5PartnerAppsDataProviderCallback.onAppUrlFetched(H5PartnerAppsDataProvider.partnerRawData);
                return;
            }
            return;
        }
        H5PartnerAppsDataProvider.H5PartnerAppsDataProviderCallback h5PartnerAppsDataProviderCallback2 = this.$callback;
        if (h5PartnerAppsDataProviderCallback2 != null) {
            h5PartnerAppsDataProviderCallback2.onError("SR");
        }
    }

    public final void onError(String str) {
        H5PartnerAppsDataProvider.H5PartnerAppsDataProviderCallback h5PartnerAppsDataProviderCallback = this.$callback;
        if (h5PartnerAppsDataProviderCallback != null) {
            h5PartnerAppsDataProviderCallback.onError(str);
        }
    }
}
