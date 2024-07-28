package com.paytmmall.clpartifact.utils;

import com.google.gson.f;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import com.paytmmall.clpartifact.view.viewmodel.UserContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.g.b.k;

final class SFUtils$getSanitizedResponse$$inlined$forEach$lambda$1 implements Runnable {
    final /* synthetic */ HomeResponse $data$inlined;
    final /* synthetic */ ArrayList $filteredList$inlined;
    final /* synthetic */ LinkedHashMap $filteredWidgetList$inlined;
    final /* synthetic */ boolean $isCacheResponse$inlined;
    final /* synthetic */ HomeResponse $response$inlined;
    final /* synthetic */ View $view;

    SFUtils$getSanitizedResponse$$inlined$forEach$lambda$1(View view, HomeResponse homeResponse, boolean z, HomeResponse homeResponse2, LinkedHashMap linkedHashMap, ArrayList arrayList) {
        this.$view = view;
        this.$data$inlined = homeResponse;
        this.$isCacheResponse$inlined = z;
        this.$response$inlined = homeResponse2;
        this.$filteredWidgetList$inlined = linkedHashMap;
        this.$filteredList$inlined = arrayList;
    }

    public final void run() {
        String str;
        String str2;
        CLPArtifact instance = CLPArtifact.getInstance();
        k.a((Object) instance, "CLPArtifact.getInstance()");
        ICLPCommunicationListener communicationListener = instance.getCommunicationListener();
        HashMap hashMap = new HashMap();
        f mGson = SFGsonUtils.INSTANCE.getMGson();
        View view = this.$view;
        k.a((Object) view, "view");
        hashMap.put("response_type", mGson.b(view.getItems()));
        UserContext context = this.$response$inlined.getContext();
        if (context == null || (str = context.getMrequestid()) == null) {
            str = "";
        }
        hashMap.put(CLPConstants.PRODUCT_ID, str);
        View view2 = this.$view;
        k.a((Object) view2, "view");
        Long id = view2.getId();
        if (id == null || (str2 = String.valueOf(id.longValue())) == null) {
            str2 = "";
        }
        hashMap.put("mid", str2);
        View view3 = this.$view;
        k.a((Object) view3, "view");
        hashMap.put(CLPConstants.RESPONSE_SIZE, String.valueOf(view3.getItems().size()));
        communicationListener.logErrorResponse(101, hashMap);
    }
}
