package net.one97.paytm.phoenix.provider;

import android.app.Activity;
import android.content.Intent;
import java.util.HashMap;
import net.one97.paytm.landingpage.activity.AJRMainActivity;

public final class H5ExitSessionProvider implements PhoenixExitSessionProvider {
    public final boolean exitSession(Activity activity, HashMap<String, Object> hashMap) {
        if (activity == null) {
            return false;
        }
        Intent intent = new Intent(activity, AJRMainActivity.class);
        intent.setFlags(67108864);
        activity.startActivity(intent);
        activity.finish();
        return true;
    }
}
