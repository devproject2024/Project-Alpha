package net.one97.paytm.upgradeKyc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.j;
import java.util.HashMap;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.d.n;

public final class TransparentActivity extends UpgradeKycBaseActivity implements n.b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f65399a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f65400b;

    public final View a(int i2) {
        if (this.f65400b == null) {
            this.f65400b = new HashMap();
        }
        View view = (View) this.f65400b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f65400b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int b() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        j supportFragmentManager = getSupportFragmentManager();
        n.a aVar = n.f65716d;
        if (supportFragmentManager.c(n.o) == null) {
            n nVar = new n();
            j supportFragmentManager2 = getSupportFragmentManager();
            n.a aVar2 = n.f65716d;
            nVar.show(supportFragmentManager2, n.o);
        }
    }

    public final int a() {
        return R.layout.activity_transparent;
    }

    public final void d() {
        Intent intent = new Intent();
        intent.putExtra("min_kyc_status", this.f65399a);
        setResult(-1, intent);
        finish();
    }

    public final void e() {
        startActivity(new Intent(this, UpgradeKycActivity.class));
        d();
    }

    public final void f() {
        this.f65399a = true;
    }
}
