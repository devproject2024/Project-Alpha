package net.one97.paytm.dynamic.module.paytm_money;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.play.core.splitcompat.a;
import com.paytm.utility.q;
import com.paytmmoney.lite.mod.PaytmMoneyManager;
import java.util.HashMap;
import kotlin.g.b.k;

public final class PmLiteControllerActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        q.d("onCreate");
        PaytmMoneyDataProvider paytmMoneyDataProvider = PaytmMoneyDataProvider.INSTANCE;
        Application application = getApplication();
        k.a((Object) application, "application");
        paytmMoneyDataProvider.initPMLiteModule(application);
        Intent intent = getIntent();
        k.a((Object) intent, "intent");
        PaytmMoneyManager.INSTANCE.openH5InitActivity(this, intent);
        finish();
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        super.attachBaseContext(context);
        a.a((Context) this);
    }
}
