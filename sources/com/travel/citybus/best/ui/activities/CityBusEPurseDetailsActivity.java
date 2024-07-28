package com.travel.citybus.best.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.travel.citybus.R;
import com.travel.citybus.best.model.BestEPurse;
import com.travel.citybus.best.ui.a.b;
import com.travel.citybus.best.ui.a.d;
import com.travel.citybus.brts.CJRActionBarBaseActivity;
import com.travel.citybus.brts.model.pojo.CJRCity;
import kotlin.g.b.k;

public final class CityBusEPurseDetailsActivity extends CJRActionBarBaseActivity implements d.b {

    /* renamed from: a  reason: collision with root package name */
    private BestEPurse f23122a;

    /* renamed from: b  reason: collision with root package name */
    private CJRCity f23123b;

    /* renamed from: c  reason: collision with root package name */
    private b f23124c;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.best_epurse_wallet_details_activity);
        Intent intent = getIntent();
        q qVar = null;
        if ((intent != null ? intent.getSerializableExtra("best_e_purse_data") : null) != null) {
            Intent intent2 = getIntent();
            this.f23122a = (BestEPurse) (intent2 != null ? intent2.getSerializableExtra("best_e_purse_data") : null);
        }
        Intent intent3 = getIntent();
        if ((intent3 != null ? intent3.getSerializableExtra("extra_city") : null) != null) {
            Intent intent4 = getIntent();
            this.f23123b = (CJRCity) (intent4 != null ? intent4.getSerializableExtra("extra_city") : null);
        }
        j supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null) {
            qVar = supportFragmentManager.a();
        }
        int i2 = R.id.flContainer;
        d.a aVar = d.f23097a;
        BestEPurse bestEPurse = this.f23122a;
        d dVar = new d();
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("best_e_purse_data", bestEPurse);
        dVar.setArguments(bundle2);
        qVar.a(i2, dVar, d.class.getSimpleName()).b();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        b bVar = this.f23124c;
        if (bVar != null) {
            bVar.onActivityResult(i2, i3, intent);
        }
    }

    public final void onBackPressed() {
        j supportFragmentManager = getSupportFragmentManager();
        if ((supportFragmentManager != null ? Integer.valueOf(supportFragmentManager.f()) : null).intValue() > 1) {
            getSupportFragmentManager().d();
        } else {
            super.onBackPressed();
        }
    }

    public final void a() {
        b.a aVar = b.f23072a;
        CJRCity cJRCity = this.f23123b;
        BestEPurse bestEPurse = this.f23122a;
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putSerializable("best_e_purse_data", bestEPurse);
        bundle.putSerializable("extra_city", cJRCity);
        bVar.setArguments(bundle);
        this.f23124c = bVar;
        j supportFragmentManager = getSupportFragmentManager();
        q a2 = supportFragmentManager != null ? supportFragmentManager.a() : null;
        int i2 = R.id.flContainer;
        b bVar2 = this.f23124c;
        if (bVar2 == null) {
            k.a();
        }
        a2.a(i2, bVar2, b.class.getSimpleName()).a(b.class.getSimpleName()).b();
    }
}
