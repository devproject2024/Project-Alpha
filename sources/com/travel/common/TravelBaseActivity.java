package com.travel.common;

import android.content.Context;
import android.view.View;
import com.travel.common.a.a;
import com.travel.utils.q;
import java.util.HashMap;
import kotlin.g.b.y;
import net.one97.paytm.activity.PaytmActivity;

public class TravelBaseActivity extends PaytmActivity {
    private final String TAG = y.b(TravelBaseActivity.class).b();
    private HashMap _$_findViewCache;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i2) {
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

    public final String getTAG() {
        return this.TAG;
    }

    public void attachBaseContext(Context context) {
        a a2 = q.a();
        new StringBuilder("attachBaseContext :: provider ").append(a2);
        if (a2 != null) {
            context = a2.attachBaseContext(context);
        }
        super.attachBaseContext(context);
        Context context2 = this;
        com.google.android.play.core.splitcompat.a.a(context2);
        com.google.android.play.core.splitcompat.a.b(context2);
    }

    public void onResume() {
        super.onResume();
        Context context = this;
        com.google.android.play.core.splitcompat.a.a(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }
}
