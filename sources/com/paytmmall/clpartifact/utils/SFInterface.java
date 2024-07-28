package com.paytmmall.clpartifact.utils;

import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.a;
import com.paytmmall.clpartifact.listeners.IGAEnableListener;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.network.SFCallbackListener;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import java.util.HashMap;
import kotlin.g.b.k;

public final class SFInterface {
    public static final SFInterface INSTANCE = new SFInterface();

    private SFInterface() {
    }

    public static /* synthetic */ SanitizedResponseModel getSanitizedResponse$default(SFInterface sFInterface, HomeResponse homeResponse, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return sFInterface.getSanitizedResponse(homeResponse, z);
    }

    public final SanitizedResponseModel getSanitizedResponse(HomeResponse homeResponse, boolean z) {
        k.c(homeResponse, Payload.RESPONSE);
        return SFUtils.INSTANCE.getSanitizedResponse(homeResponse, z);
    }

    public final void getStoreFrontReponse(String str, HashMap<String, String> hashMap, a.c cVar, SFCallbackListener sFCallbackListener) {
        k.c(str, "url");
        k.c(hashMap, H5Logger.HEADER);
        k.c(cVar, "verticalId");
        k.c(sFCallbackListener, "listener");
        SFUtils.getStoreFrontReponse$default(SFUtils.INSTANCE, str, hashMap, cVar, sFCallbackListener, (String) null, 0, (IGAEnableListener) null, 112, (Object) null);
    }

    public final void getRefreshableResponse(String str, HashMap<String, String> hashMap, a.c cVar, SFCallbackListener sFCallbackListener) {
        k.c(str, "url");
        k.c(hashMap, H5Logger.HEADER);
        k.c(cVar, "verticalId");
        k.c(sFCallbackListener, "listener");
        SFUtils.getRefreshableResponse$default(SFUtils.INSTANCE, str, hashMap, cVar, sFCallbackListener, (String) null, 0, (IGAEnableListener) null, 112, (Object) null);
    }

    public final void notifySuccessTransaction(String str) {
        k.c(str, "uniqueOrderID");
        SFUtils.INSTANCE.refreshHome(str);
    }

    public static /* synthetic */ SanitizedResponseModel getSanitizedResponse$default(SFInterface sFInterface, HomeResponse homeResponse, boolean z, String str, int i2, IGAEnableListener iGAEnableListener, int i3, Object obj) {
        boolean z2 = (i3 & 2) != 0 ? false : z;
        int i4 = (i3 & 8) != 0 ? 1004 : i2;
        if ((i3 & 16) != 0) {
            iGAEnableListener = null;
        }
        return sFInterface.getSanitizedResponse(homeResponse, z2, str, i4, iGAEnableListener);
    }

    public final SanitizedResponseModel getSanitizedResponse(HomeResponse homeResponse, boolean z, String str, int i2, IGAEnableListener iGAEnableListener) {
        k.c(homeResponse, Payload.RESPONSE);
        return SFUtils.INSTANCE.getSanitizedResponse(homeResponse, z, str, i2, iGAEnableListener);
    }

    public static /* synthetic */ void getStoreFrontReponse$default(SFInterface sFInterface, String str, HashMap hashMap, a.c cVar, SFCallbackListener sFCallbackListener, String str2, int i2, IGAEnableListener iGAEnableListener, int i3, Object obj) {
        sFInterface.getStoreFrontReponse(str, hashMap, cVar, sFCallbackListener, str2, (i3 & 32) != 0 ? 1004 : i2, iGAEnableListener);
    }

    public final void getStoreFrontReponse(String str, HashMap<String, String> hashMap, a.c cVar, SFCallbackListener sFCallbackListener, String str2, int i2, IGAEnableListener iGAEnableListener) {
        k.c(str, "url");
        k.c(hashMap, H5Logger.HEADER);
        k.c(cVar, "verticalId");
        k.c(sFCallbackListener, "listener");
        SFUtils.INSTANCE.getStoreFrontReponse(str, hashMap, cVar, sFCallbackListener, str2, i2, iGAEnableListener);
    }
}
