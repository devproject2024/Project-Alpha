package net.one97.paytm.phoenix.provider;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import java.util.ArrayList;

public interface PhoenixAppShortCutProvider {
    Intent getIntentForMiniAppDeeplink(String str, Context context);

    ArrayList<ShortcutInfo> provideAlreadyExistingAppShortcuts(Context context);
}
