package com.paytm.android.chat.base;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.c;
import com.paytm.android.chat.utils.AppUtilKt;
import com.paytm.android.chat.utils.LoadingDialog;
import net.one97.paytm.activity.PaytmActivity;

public abstract class BaseActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private LoadingDialog f41806a = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c.a(this);
    }

    public void onResume() {
        super.onResume();
        c.a(this);
        ChatManager.b().d();
    }

    public void onPause() {
        c.e();
        super.onPause();
    }

    public void onStop() {
        b();
        super.onStop();
    }

    public void onDestroy() {
        c.e();
        this.f41806a = null;
        super.onDestroy();
    }

    public final void b() {
        LoadingDialog loadingDialog = this.f41806a;
        if (loadingDialog != null && loadingDialog.isShowing()) {
            this.f41806a.dismiss();
        }
    }

    public Resources getResources() {
        Resources resources = super.getResources();
        if (!(resources == null || ((double) resources.getConfiguration().fontScale) == 1.0d)) {
            Configuration configuration = resources.getConfiguration();
            configuration.fontScale = 1.0f;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return resources;
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        try {
            AppUtilKt.reInitializeChatManager(context);
        } catch (Exception unused) {
        }
    }
}
