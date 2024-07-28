package com.paytmmall.clpartifact.widgets.providers;

import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.widgets.blueprints.IWidgetProvider;
import com.paytmmall.clpartifact.widgets.factory.SFWidgetFactory;

public class WidgetProvider {
    public static IWidgetProvider getWidgetProvider(View view) {
        String type = view.getType();
        if (SFWidgetFactory.TYPE_HEADER_MENU.equalsIgnoreCase(type)) {
            return new MenuWidgetProvider(view);
        }
        if (SFWidgetFactory.TYPE_INTERSTETIAL.equalsIgnoreCase(type)) {
            return new ISWidgetProvider(view);
        }
        if (SFWidgetFactory.TYPE_FLASH_POPUP.equalsIgnoreCase(type)) {
            return new IFlashPopUpWidgetProvider(view);
        }
        if (SFWidgetFactory.TYPE_CASHBACK_POPUP.equalsIgnoreCase(type)) {
            return new CashbackWidgetProvider(view);
        }
        if (SFWidgetFactory.TYPE_OVERLAY_BANNER.equalsIgnoreCase(type)) {
            return new P4BNotificationWidgetProvider(view);
        }
        if (SFWidgetFactory.TYPE_FLOATING_NAV.equalsIgnoreCase(type)) {
            return new NavWidgetProvider(view);
        }
        return null;
    }
}
