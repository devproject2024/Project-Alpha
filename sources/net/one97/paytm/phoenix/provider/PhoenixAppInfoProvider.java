package net.one97.paytm.phoenix.provider;

import android.content.Context;
import org.json.JSONObject;

public interface PhoenixAppInfoProvider {
    JSONObject getDefaultParams(Context context);

    int getVersionCode(Context context);

    String getVersionName(Context context);

    void startPhoenixActivityToWebPageStartTrace(String str);

    void startWebPageLoadStartToFinishTrace(String str);

    void stopPhoenixActivityToWebPageStartTrace(String str);

    void stopWebPageLoadStartToFinishTrace();
}
