package net.one97.paytm.utils;

import android.content.Intent;
import androidx.localbroadcastmanager.a.a;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytm.utility.u;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.oauth.OauthModule;

public final class ab implements u {
    public final void a() {
        q.d("logged in   " + b.r(CJRJarvisApplication.getAppContext()));
        ag.a(CJRJarvisApplication.getAppContext()).a((u) null);
        OauthModule.b().openHomePage(CJRJarvisApplication.getAppContext(), false, "", true);
        a.a(CJRJarvisApplication.getAppContext()).a(new Intent("action_update_login_status"));
        q.d("onDecryptException");
    }
}
