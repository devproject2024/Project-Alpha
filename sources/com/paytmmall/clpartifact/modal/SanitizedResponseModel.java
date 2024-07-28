package com.paytmmall.clpartifact.modal;

import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import com.paytmmall.clpartifact.listeners.IGAEnableListener;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.widgets.blueprints.IWidgetProvider;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class SanitizedResponseModel {
    private final String adRequestId;
    private final IGAEnableListener gaEnableListener;
    private StoreFrontGAHandler gaListener;
    private final List<View> rvWidgets;
    private final LinkedHashMap<Integer, IWidgetProvider> sfWidgets;
    private final String verticalName;

    public SanitizedResponseModel(List<? extends View> list, LinkedHashMap<Integer, IWidgetProvider> linkedHashMap, String str, String str2, int i2, IGAEnableListener iGAEnableListener) {
        k.c(list, "rvWidgets");
        k.c(linkedHashMap, "sfWidgets");
        this.rvWidgets = list;
        this.sfWidgets = linkedHashMap;
        this.adRequestId = str;
        this.verticalName = str2;
        this.gaEnableListener = iGAEnableListener;
        this.gaListener = new SanitizedResponseModel$gaListener$1(this, i2);
    }

    public final List<View> getRvWidgets() {
        return this.rvWidgets;
    }

    public final LinkedHashMap<Integer, IWidgetProvider> getSfWidgets() {
        return this.sfWidgets;
    }

    public final String getAdRequestId() {
        return this.adRequestId;
    }

    public final String getVerticalName() {
        return this.verticalName;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SanitizedResponseModel(List list, LinkedHashMap linkedHashMap, String str, String str2, int i2, IGAEnableListener iGAEnableListener, int i3, g gVar) {
        this(list, linkedHashMap, str, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? 1004 : i2, (i3 & 32) != 0 ? null : iGAEnableListener);
    }

    public final IGAEnableListener getGaEnableListener() {
        return this.gaEnableListener;
    }

    public final StoreFrontGAHandler getGaListener() {
        return this.gaListener;
    }

    public final void setGaListener(StoreFrontGAHandler storeFrontGAHandler) {
        k.c(storeFrontGAHandler, "<set-?>");
        this.gaListener = storeFrontGAHandler;
    }
}
