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
import net.one97.paytm.passbook.mlv.b.a;
import net.one97.paytm.passbook.mlv.b.b;

public final class MLVMainActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f58034a;

    public final View a(int i2) {
        if (this.f58034a == null) {
            this.f58034a = new HashMap();
        }
        View view = (View) this.f58034a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f58034a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.passbook_mlv_main_activity);
        a aVar = new a();
        Intent intent = getIntent();
        aVar.setArguments(intent != null ? intent.getExtras() : null);
        getSupportFragmentManager().a().a(R.id.container, (Fragment) aVar).a(b.class.getCanonicalName()).c();
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
}
