package com.paytmmall.clpartifact.utils;

import android.view.ViewGroup;
import com.google.gson.f;
import com.google.gson.g;
import com.paytm.utility.a;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Page;
import java.util.List;

public class CLPUtils {
    public static boolean isFlashSale(List<Page> list) {
        try {
            return isFlashSaleTab(list.get(0)) && isNotAdded(list);
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
        }
    }

    private static boolean isNotAdded(List<Page> list) {
        try {
            return list.get(1).getViews().get(0).getType().equalsIgnoreCase(ViewHolderFactory.TYPE_ITEM_TABBED);
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public static boolean isFlashSaleTab(Page page) {
        try {
            return ViewHolderFactory.TYPE_TABBED_2_SALE.equalsIgnoreCase(page.getViews().get(0).getType());
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return false;
        }
    }

    public static boolean isHomeClient(IGAHandlerListener iGAHandlerListener) {
        return iGAHandlerListener != null && iGAHandlerListener.getClient() == 1001;
    }

    public static boolean isFlyoutClient(IGAHandlerListener iGAHandlerListener) {
        return iGAHandlerListener != null && iGAHandlerListener.getClient() == 1005;
    }

    public static boolean isRechargeClient(IGAHandlerListener iGAHandlerListener) {
        return iGAHandlerListener != null && iGAHandlerListener.getClient() == 1007;
    }

    public static boolean isShowMoreClient(IGAHandlerListener iGAHandlerListener) {
        return iGAHandlerListener != null && iGAHandlerListener.getClient() == 1008;
    }

    public static f getGson() {
        g gVar = new g();
        gVar.f39468f = true;
        return gVar.a();
    }

    public static boolean getGTMBoolean(String str, boolean z) {
        return CLPArtifact.isCLPListenerAvailable() ? CLPArtifact.getInstance().getCommunicationListener().getGTMBoolean(str, z) : z;
    }

    public static void setHomeMargins(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams();
            marginLayoutParams.bottomMargin = a.a(15);
            marginLayoutParams.topMargin = a.a(0);
        }
    }
}
