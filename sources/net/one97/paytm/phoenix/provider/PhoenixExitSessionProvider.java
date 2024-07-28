package net.one97.paytm.phoenix.provider;

import android.app.Activity;
import java.util.HashMap;

public interface PhoenixExitSessionProvider {
    boolean exitSession(Activity activity, HashMap<String, Object> hashMap);
}
