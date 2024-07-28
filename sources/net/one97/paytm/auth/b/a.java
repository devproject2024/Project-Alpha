package net.one97.paytm.auth.b;

import android.app.Activity;
import android.content.Intent;
import com.paytm.android.chat.utils.KeyList;
import net.one97.paytm.auth.activity.AJRAuthActivity;

public final class a {
    public static void a(Activity activity) {
        if (activity != null) {
            Intent intent = new Intent(activity, AJRAuthActivity.class);
            intent.putExtra("launchSignUp", false);
            intent.putExtra("set_result_required", true);
            intent.putExtra("VERTICAL_NAME", "Wallet");
            activity.startActivityForResult(intent, KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_MEDIA);
        }
    }
}
