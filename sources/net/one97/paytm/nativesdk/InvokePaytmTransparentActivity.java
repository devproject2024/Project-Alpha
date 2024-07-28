package net.one97.paytm.nativesdk;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import java.util.HashMap;
import net.one97.paytm.activity.PaytmActivity;

public final class InvokePaytmTransparentActivity extends PaytmActivity {
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
        setTheme(2132017605);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.f();
        }
        new FetchAuthCodeFragment().show(getSupportFragmentManager(), FetchAuthCodeFragment.class.getSimpleName());
    }
}
