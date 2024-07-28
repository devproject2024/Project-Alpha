package net.one97.paytm.dynamic.module.h5sdk;

import android.content.Context;
import android.os.Bundle;
import kotlin.g.b.k;
import net.one97.paytm.h5.b.c;
import net.one97.paytm.h5.model.H5AppDataResponseModel;
import net.one97.paytm.h5.model.H5AppDetailsForUserModel;

public final class H5ManagerHelper$loadPage$1 implements c.a {
    final /* synthetic */ String $appUniqueId;
    final /* synthetic */ Bundle $bundle;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $deeplinkData;
    final /* synthetic */ boolean $isTransparent;
    final /* synthetic */ String $urlOrAssetPath;
    final /* synthetic */ String $verticalName;

    H5ManagerHelper$loadPage$1(String str, String str2, String str3, Bundle bundle, String str4, boolean z, Context context) {
        this.$verticalName = str;
        this.$appUniqueId = str2;
        this.$urlOrAssetPath = str3;
        this.$bundle = bundle;
        this.$deeplinkData = str4;
        this.$isTransparent = z;
        this.$context = context;
    }

    public final void onAppDataFetched(H5AppDetailsForUserModel h5AppDetailsForUserModel) {
        H5AppDataResponseModel response;
        if (h5AppDetailsForUserModel == null || (response = h5AppDetailsForUserModel.getResponse()) == null) {
            H5ManagerHelper.loadPageFromH5Manager$default(H5ManagerHelper.INSTANCE, this.$verticalName, this.$appUniqueId, this.$urlOrAssetPath, this.$bundle, this.$deeplinkData, this.$isTransparent, this.$context, false, 128, (Object) null);
            return;
        }
        H5ManagerHelper h5ManagerHelper = H5ManagerHelper.INSTANCE;
        String str = this.$verticalName;
        String str2 = this.$appUniqueId;
        String str3 = this.$urlOrAssetPath;
        Bundle bundle = this.$bundle;
        String str4 = this.$deeplinkData;
        boolean z = this.$isTransparent;
        Context context = this.$context;
        Boolean phoenixStatus = response.getPhoenixStatus();
        k.a((Object) phoenixStatus, "it.phoenixStatus");
        h5ManagerHelper.loadPageFromH5Manager(str, str2, str3, bundle, str4, z, context, phoenixStatus.booleanValue());
    }

    public final void onError(String str) {
        H5ManagerHelper.loadPageFromH5Manager$default(H5ManagerHelper.INSTANCE, this.$verticalName, this.$appUniqueId, this.$urlOrAssetPath, this.$bundle, this.$deeplinkData, this.$isTransparent, this.$context, false, 128, (Object) null);
    }
}
