package net.one97.paytm.acceptPayment.activities;

import android.content.Context;
import android.os.Bundle;
import net.one97.paytm.acceptPayment.configs.a;
import net.one97.paytm.acceptPayment.utils.e;

public abstract class BaseActivity extends CJRActionBarBaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new e(getClass().getName(), this, this);
    }

    public void onResume() {
        super.onResume();
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(a.f52046a.f52049d.a(context));
    }
}
