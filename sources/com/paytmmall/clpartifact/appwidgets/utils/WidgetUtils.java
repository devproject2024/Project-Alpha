package com.paytmmall.clpartifact.appwidgets.utils;

import kotlin.g.b.k;

public final class WidgetUtils {
    private static final String ACTION_BALANCE_HISTORY = ACTION_BALANCE_HISTORY;
    private static final String ACTION_RECHARGE_BILLS = ACTION_RECHARGE_BILLS;
    private static final String ACTION_SCAN_PAY_CLICK = ACTION_SCAN_PAY_CLICK;
    private static final String ACTION_SEND_MONEY = ACTION_SEND_MONEY;
    private static final String ACTION_UPDATE_MULTI_SERVICE_WIDGET = ACTION_UPDATE_MULTI_SERVICE_WIDGET;
    private static final String ACTION_UPDATE_SINGLE_SERVICE_WIDGET = ACTION_UPDATE_SINGLE_SERVICE_WIDGET;
    private static final long GA_CLICK_DELAY_TIME = GA_CLICK_DELAY_TIME;
    public static final WidgetUtils INSTANCE = new WidgetUtils();
    private static final String KEY_WIDGET_ITEM_TYPE = KEY_WIDGET_ITEM_TYPE;
    private static final String TYPE_MONEY_TRANSFER = TYPE_MONEY_TRANSFER;
    private static final String TYPE_PAY_GRID = TYPE_PAY_GRID;
    private static final String TYPE_PAY_GRID_MONEY = TYPE_PAY_GRID_MONEY;
    private static final String URL_BALANCE_HISTORY = URL_BALANCE_HISTORY;
    private static final String URL_DEFAULT = "paytmmp://cash_wallet?featuretype=scanner";
    private static final String URL_RECHARGE_BILLS = URL_RECHARGE_BILLS;
    private static final String URL_SCAN_PAY_CLICK = "paytmmp://cash_wallet?featuretype=scanner";
    private static final String URL_SEND_MONEY = URL_SEND_MONEY;

    private WidgetUtils() {
    }

    public final String getACTION_SCAN_PAY_CLICK() {
        return ACTION_SCAN_PAY_CLICK;
    }

    public final String getACTION_SEND_MONEY() {
        return ACTION_SEND_MONEY;
    }

    public final String getACTION_RECHARGE_BILLS() {
        return ACTION_RECHARGE_BILLS;
    }

    public final String getACTION_BALANCE_HISTORY() {
        return ACTION_BALANCE_HISTORY;
    }

    public final String getACTION_UPDATE_SINGLE_SERVICE_WIDGET() {
        return ACTION_UPDATE_SINGLE_SERVICE_WIDGET;
    }

    public final String getACTION_UPDATE_MULTI_SERVICE_WIDGET() {
        return ACTION_UPDATE_MULTI_SERVICE_WIDGET;
    }

    public final String getURL_SCAN_PAY_CLICK() {
        return URL_SCAN_PAY_CLICK;
    }

    public final String getURL_SEND_MONEY() {
        return URL_SEND_MONEY;
    }

    public final String getURL_RECHARGE_BILLS() {
        return URL_RECHARGE_BILLS;
    }

    public final String getURL_BALANCE_HISTORY() {
        return URL_BALANCE_HISTORY;
    }

    public final String getURL_DEFAULT() {
        return URL_DEFAULT;
    }

    public final String getTYPE_PAY_GRID() {
        return TYPE_PAY_GRID;
    }

    public final String getTYPE_PAY_GRID_MONEY() {
        return TYPE_PAY_GRID_MONEY;
    }

    public final String getTYPE_MONEY_TRANSFER() {
        return TYPE_MONEY_TRANSFER;
    }

    public final String getKEY_WIDGET_ITEM_TYPE() {
        return KEY_WIDGET_ITEM_TYPE;
    }

    public final long getGA_CLICK_DELAY_TIME() {
        return GA_CLICK_DELAY_TIME;
    }

    public final String getDeepLinkUrl(String str) {
        k.c(str, "action");
        if (!k.a((Object) ACTION_SCAN_PAY_CLICK, (Object) str)) {
            if (k.a((Object) ACTION_SEND_MONEY, (Object) str)) {
                return URL_SEND_MONEY;
            }
            if (k.a((Object) ACTION_RECHARGE_BILLS, (Object) str)) {
                return URL_RECHARGE_BILLS;
            }
            if (k.a((Object) ACTION_BALANCE_HISTORY, (Object) str)) {
                return URL_BALANCE_HISTORY;
            }
        }
        return URL_SCAN_PAY_CLICK;
    }
}
