package net.one97.paytm.passbook.mlv.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.mlv.b.b;

public final class MLVTemplateActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f58035a;

    public final View a(int i2) {
        if (this.f58035a == null) {
            this.f58035a = new HashMap();
        }
        View view = (View) this.f58035a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f58035a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.passbook_mlv_activity);
        getSupportFragmentManager().a().a(R.id.container, (Fragment) new b()).a(b.class.getCanonicalName()).c();
    }

    public final void onBackPressed() {
        super.onBackPressed();
        j supportFragmentManager = getSupportFragmentManager();
        k.a((Object) supportFragmentManager, "supportFragmentManager");
        if (supportFragmentManager.f() > 1) {
            getSupportFragmentManager().d();
        } else {
            finish();
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 3) {
            Fragment c2 = getSupportFragmentManager().c(R.id.container);
            if (c2 instanceof b) {
                c2.onActivityResult(i2, i3, intent);
            }
        }
    }
}
