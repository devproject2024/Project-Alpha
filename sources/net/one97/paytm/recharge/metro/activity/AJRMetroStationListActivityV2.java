package net.one97.paytm.recharge.metro.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import com.paytmmall.clpartifact.view.actions.IuserActions;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.metro.c.r;
import net.one97.paytm.recharge.model.metro.CJRMetroStationModel;

public final class AJRMetroStationListActivityV2 extends AJRMetroStationListActivity {

    /* renamed from: g  reason: collision with root package name */
    private String f63216g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f63217h;

    /* renamed from: i  reason: collision with root package name */
    private String f63218i;
    private String j;
    private HashMap k;

    public final View a(int i2) {
        if (this.k == null) {
            this.k = new HashMap();
        }
        View view = (View) this.k.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.k.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        if (getIntent().hasExtra("destination_name_for_penalty")) {
            this.f63216g = getIntent().getStringExtra("destination_name_for_penalty");
        }
        if (getIntent().hasExtra("is_store_value_pass")) {
            this.f63217h = getIntent().getBooleanExtra("is_store_value_pass", false);
        }
        if (getIntent().hasExtra("metro_event_label")) {
            this.f63218i = getIntent().getStringExtra("metro_event_label");
        }
        if (getIntent().hasExtra("metro_event_category")) {
            this.j = getIntent().getStringExtra("metro_event_category");
        }
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public final void a(List<CJRMetroStationModel> list, String str, CJRMetroStationModel cJRMetroStationModel, String str2, String str3, String str4) {
        k.c(str3, "hint");
        k.c(str4, "hintDest");
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            finish();
            return;
        }
        r rVar = new r();
        if (list == null) {
            k.a();
        }
        if (cJRMetroStationModel == null) {
            k.a();
        }
        String str5 = this.f63216g;
        boolean z = this.f63217h;
        String str6 = this.j;
        String str7 = str6 == null ? "" : str6;
        String str8 = this.f63218i;
        Fragment a2 = rVar.a(list, str, cJRMetroStationModel, str5, z, str7, str8 == null ? "" : str8);
        q a3 = getSupportFragmentManager().a();
        k.a((Object) a3, "supportFragmentManager.beginTransaction()");
        if (!this.f63209c) {
            a3.a(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right);
            a3.b(R.id.station_fragment_container, a2);
            a3.a(((net.one97.paytm.recharge.metro.c.q) a2).getClass().getSimpleName());
        } else {
            a3.b(R.id.station_fragment_container, a2);
        }
        a3.b();
    }

    public final void a(CJRMetroStationModel cJRMetroStationModel) {
        k.c(cJRMetroStationModel, "selectedExitStation");
        this.f63208b = cJRMetroStationModel;
        if (this.f63208b != null) {
            setResult(IuserActions.ON_FLASHSALE_CLICK, new Intent().putExtra("sourceMetroStation", this.f63207a).putExtra("destinationMetroStation", this.f63208b));
            finish();
        }
    }
}
