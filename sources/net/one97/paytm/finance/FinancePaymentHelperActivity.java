package net.one97.paytm.finance;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.play.core.splitcompat.a;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.h5.b;

public final class FinancePaymentHelperActivity extends AppCompatActivity {
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
        if (getIntent() != null) {
            Intent intent = getIntent();
            k.a((Object) intent, "intent");
            if (intent.getExtras() != null) {
                b bVar = b.f50536a;
                Context context = this;
                Intent intent2 = getIntent();
                k.a((Object) intent2, "intent");
                Bundle extras = intent2.getExtras();
                if (extras == null) {
                    k.a();
                }
                k.a((Object) extras, "intent.extras!!");
                b.b(context, extras);
                return;
            }
        }
        finish();
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.a((Context) this);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        setResult(i3, intent);
        finish();
    }
}
