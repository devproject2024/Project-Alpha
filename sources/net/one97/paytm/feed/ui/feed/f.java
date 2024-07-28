package net.one97.paytm.feed.ui.feed;

import android.content.Context;

public interface f {
    void collapseAppBar();

    void expandAppBar();

    void getUserData(Context context);

    void loadH5Container(Context context, String str, String str2);

    void loadH5Container(Context context, String str, String str2, String str3);

    void onDispatchDeeplink(Context context, String str);

    void onEditProfileClicked(Context context);

    void onLoginLinkify(Context context);
}
