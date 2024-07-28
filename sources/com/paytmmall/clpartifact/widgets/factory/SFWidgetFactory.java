package com.paytmmall.clpartifact.widgets.factory;

import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.widgets.blueprints.IWidgetProvider;
import com.paytmmall.clpartifact.widgets.providers.WidgetProvider;
import java.util.HashSet;

public class SFWidgetFactory {
    public static String TYPE_CASHBACK_POPUP = "scratchcard-popup";
    public static String TYPE_FLASH_POPUP = "flash-popup";
    public static String TYPE_FLOATING_NAV = "floating-nav";
    public static String TYPE_HEADER_MENU = "shortcut-menu";
    public static String TYPE_INTERSTETIAL = "interstitial";
    public static String TYPE_OVERLAY_BANNER = "overlay-banner";
    private static HashSet<String> apiWidgetTypes = new HashSet<String>() {
        {
            add(SFWidgetFactory.TYPE_CASHBACK_POPUP);
            add(SFWidgetFactory.TYPE_INTERSTETIAL);
            add(SFWidgetFactory.TYPE_OVERLAY_BANNER);
            add(SFWidgetFactory.TYPE_FLASH_POPUP);
        }
    };
    private static HashSet<String> widgetTypes = new HashSet<String>() {
        {
            add(SFWidgetFactory.TYPE_INTERSTETIAL);
            add(SFWidgetFactory.TYPE_HEADER_MENU);
            add(SFWidgetFactory.TYPE_CASHBACK_POPUP);
            add(SFWidgetFactory.TYPE_FLOATING_NAV);
            add(SFWidgetFactory.TYPE_FLASH_POPUP);
        }
    };

    public static boolean isSFWidget(View view) {
        return widgetTypes.contains(view.getType());
    }

    public static boolean isApiOnlyWidget(String str) {
        return apiWidgetTypes.contains(str);
    }

    public static IWidgetProvider getWidgetProvider(View view) {
        return WidgetProvider.getWidgetProvider(view);
    }
}
