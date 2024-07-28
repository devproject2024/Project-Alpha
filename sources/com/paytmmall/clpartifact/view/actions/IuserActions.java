package com.paytmmall.clpartifact.view.actions;

public interface IuserActions {
    public static final int HANDLE_DEEPLINK = 1004;
    public static final int HANDLE_GRID_RESPONSE = 1007;
    public static final int HIDE_KEYBOARD = 1011;
    public static final int ON_FLASHSALE_CLICK = 1012;
    public static final int OPEN_LOGIN = 1006;
    public static final int OPEN_REVIEW = 1001;
    public static final int OPEN_REVIEWS_TAB = 1008;
    public static final int OPEN_STORES_TAB = 1009;
    public static final int RATE_A_STORE = 1002;
    public static final int REDIRECT_CLOSE = 1005;
    public static final int REPORT_REVIEW = 1003;
    public static final int SCROLL_MAIN_RV = 1010;

    public @interface UserActions {
    }
}
