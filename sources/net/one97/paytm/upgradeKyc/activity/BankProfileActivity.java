package net.one97.paytm.upgradeKyc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import java.util.HashMap;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.c;

public final class BankProfileActivity extends UpgradeKycBaseActivity implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f65250a;

    public final View a(int i2) {
        if (this.f65250a == null) {
            this.f65250a = new HashMap();
        }
        View view = (View) this.f65250a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f65250a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int b() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getSupportFragmentManager().a().b(R.id.fl_container, new c()).c();
        ((ImageView) a(R.id.iv_back_btn)).setOnClickListener(new a(this));
    }

    public final int a() {
        return R.layout.activity_bank_profile;
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BankProfileActivity f65251a;

        a(BankProfileActivity bankProfileActivity) {
            this.f65251a = bankProfileActivity;
        }

        public final void onClick(View view) {
            this.f65251a.onBackPressed();
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        Fragment c2 = getSupportFragmentManager().c(R.id.fl_container);
        if (c2 != null) {
            c2.onActivityResult(i2, i3, intent);
        }
    }

    public final void aC_() {
        onBackPressed();
    }
}
