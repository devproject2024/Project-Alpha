package net.one97.paytm.phoenix.provider;

public final class DefaultTitleBarProviderImp implements PhoenixTitleBarProvider {
    public final String getBackButtonColor() {
        return "#000000";
    }

    public final String getStatusBarColor() {
        return "#808080";
    }

    public final String getTitleBarImageUrl() {
        return "";
    }

    public final String getTitleBarText() {
        return "";
    }

    public final Boolean showToolbar() {
        return Boolean.TRUE;
    }

    public final Boolean showBackButton() {
        return Boolean.TRUE;
    }
}
