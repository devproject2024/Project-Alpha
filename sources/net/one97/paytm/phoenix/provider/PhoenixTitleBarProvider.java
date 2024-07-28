package net.one97.paytm.phoenix.provider;

public interface PhoenixTitleBarProvider {
    String getBackButtonColor();

    String getStatusBarColor();

    String getTitleBarImageUrl();

    String getTitleBarText();

    Boolean showBackButton();

    Boolean showToolbar();
}
