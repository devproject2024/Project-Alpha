package net.one97.paytm.smssdk.a;

import android.content.Context;

public interface a {
    Context getContext();

    String getSSOToken();

    String getUserId();

    b provideSmsSdkConfig();
}
