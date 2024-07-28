package net.one97.paytm.games.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import java.util.Map;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;

public interface a {
    void CJRLoadPage(Context context, String str, CJRHomePageItem cJRHomePageItem, int i2, String str2);

    void checkDeepLinking(Activity activity, String str);

    boolean enableBranch();

    Context getApplicationContext();

    String getDeeplinkScheme();

    boolean getGtmBoolean(String str, boolean z);

    String getGtmString(String str);

    Intent getLoginScreenIntent(Context context);

    String getSSOToken(Context context);

    Intent getSplashIntent(Context context);

    boolean isStag();

    void sendCustomEventWithMap(String str, Map<String, Object> map, Context context);

    void sendOpenScreenWithDeviceInfo(String str, String str2, Context context);

    void sendPromotionClickImpression(Context context, int i2, String str, String str2, String str3, String str4);

    void sendPromotionImpression(Context context, int i2, String str, String str2, String str3, String str4);

    Context wrapContext(Context context);
}
