package net.one97.paytm.recharge.presentation.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.f;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.utility.m;
import net.one97.paytm.common.widgets.g;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.automatic.b.a.a;
import net.one97.paytm.recharge.automatic.c.a.a;
import net.one97.paytm.recharge.automatic.c.a.b;
import net.one97.paytm.recharge.domain.entities.AutomaticOptionListItemModel;
import net.one97.paytm.recharge.presentation.a.c;

public final class AJRAutomaticOptionListActivity extends PaytmActivity implements DialogInterface.OnCancelListener, AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final List<AutomaticOptionListItemModel> f64647a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final int f64648b = 1;

    /* renamed from: c  reason: collision with root package name */
    private final int f64649c = 2;

    /* renamed from: d  reason: collision with root package name */
    private final int f64650d = 4;

    /* renamed from: e  reason: collision with root package name */
    private final int f64651e = 8;

    /* renamed from: f  reason: collision with root package name */
    private final int f64652f = 16;

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        a aVar = a.f60256a;
        super.attachBaseContext(a.a(context));
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_automatic_option_list);
        if (getIntent() != null && getIntent().hasExtra("extra_home_data")) {
            a aVar = a.f60256a;
            Context context = this;
            if (a.c(context)) {
                a aVar2 = a.f60256a;
                a.b(context);
            } else {
                a();
            }
        }
        setSupportActionBar((Toolbar) findViewById(R.id.tool_bar));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.e(R.drawable.back_arrow);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.b(true);
        }
        setTitle(R.string.empty);
        b bVar = b.f60258a;
        int o = b.o();
        String[] stringArray = getResources().getStringArray(R.array.automatic_option_list_titles);
        k.a((Object) stringArray, "resources.getStringArray…matic_option_list_titles)");
        String[] stringArray2 = getResources().getStringArray(R.array.automatic_option_list_descriptions);
        k.a((Object) stringArray2, "resources.getStringArray…option_list_descriptions)");
        int i2 = 0;
        Integer[] numArr = {Integer.valueOf(R.drawable.ic_paytm_automatic_logo), Integer.valueOf(R.drawable.add_money_icon_new), Integer.valueOf(R.drawable.gold_icon), Integer.valueOf(R.drawable.ic_auth_merchants), Integer.valueOf(R.drawable.ic_auth_merchants)};
        int i3 = 1;
        while (i3 < o) {
            List<AutomaticOptionListItemModel> list = this.f64647a;
            String str = stringArray[i2];
            k.a((Object) str, "optionTitles[index]");
            String str2 = stringArray2[i2];
            k.a((Object) str2, "optionDescriptions[index]");
            list.add(new AutomaticOptionListItemModel(i3, str, str2, numArr[i2].intValue()));
            i3 <<= 1;
            i2++;
        }
        int size = this.f64647a.size();
        if (size == 0) {
            m.a(this, R.string.text_someting_went_wrong).show();
            finish();
        } else if (size != 1) {
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.options);
            k.a((Object) recyclerView, "optionsView");
            Context context2 = this;
            recyclerView.setLayoutManager(new LinearLayoutManager(context2));
            recyclerView.setAdapter(new c(context2, this.f64647a, this));
            recyclerView.addItemDecoration(new g(f.b().a(context2, R.drawable.grid_divider)));
        } else {
            onItemClick((AdapterView<?>) null, (View) null, 0, 0);
            finish();
        }
        a aVar3 = a.f60256a;
        a.C1160a aVar4 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
        net.one97.paytm.recharge.automatic.c.a.a.a((Context) this, net.one97.paytm.recharge.automatic.b.a.a.S);
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        int id = this.f64647a.get(i2).getId();
        if (id == this.f64648b) {
            a.C1160a aVar = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            a(net.one97.paytm.recharge.automatic.b.a.a.f60241c);
            net.one97.paytm.recharge.automatic.c.a.a aVar2 = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            Context context = this;
            if (net.one97.paytm.recharge.automatic.c.a.a.c(context)) {
                net.one97.paytm.recharge.automatic.c.a.a aVar3 = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                net.one97.paytm.recharge.automatic.c.a.a.b(context);
                return;
            }
            a();
        } else if (id == this.f64649c) {
            a.C1160a aVar4 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            a(net.one97.paytm.recharge.automatic.b.a.a.f60242d);
            net.one97.paytm.recharge.automatic.c.a.a aVar5 = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            net.one97.paytm.recharge.automatic.c.a.a.a((Context) this, "paytmmp://cash_wallet?featuretype=add_money&tab=automatic_add_money", new CJRHomePageItem());
        } else if (id == this.f64650d) {
            a.C1160a aVar6 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            a(net.one97.paytm.recharge.automatic.b.a.a.f60243e);
            CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
            cJRHomePageItem.setUrlType("gold-sip");
            b bVar = b.f60258a;
            cJRHomePageItem.setUrl(b.p());
            net.one97.paytm.recharge.automatic.c.a.a aVar7 = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            net.one97.paytm.recharge.automatic.c.a.a.a((Context) this, "paytmmp://gold-sip", cJRHomePageItem);
        } else if (id == this.f64651e) {
            a.C1160a aVar8 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            a(net.one97.paytm.recharge.automatic.b.a.a.f60244f);
            net.one97.paytm.recharge.automatic.c.a.a aVar9 = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            startActivity(new Intent(this, net.one97.paytm.recharge.automatic.c.a.a.b()));
        } else if (id == this.f64652f) {
            a.C1160a aVar10 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            a(net.one97.paytm.recharge.automatic.b.a.a.f60245g);
            net.one97.paytm.recharge.automatic.c.a.a aVar11 = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            StringBuilder sb = new StringBuilder("paytmmp://ottsubscription-recharge?url=");
            b bVar2 = b.f60258a;
            sb.append(b.s());
            sb.append("&pageRedirectUrl=subscription-list");
            net.one97.paytm.recharge.automatic.c.a.a.a((Context) this, sb.toString(), new CJRHomePageItem());
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        onBackPressed();
    }

    private final void a() {
        Context context = this;
        if (!com.paytm.utility.b.c(context)) {
            com.paytm.utility.b.b(context, getString(R.string.no_connection), getString(R.string.no_internet));
            return;
        }
        Serializable serializableExtra = getIntent().getSerializableExtra("extra_home_data");
        if (!(serializableExtra instanceof CJRHomePageItem)) {
            serializableExtra = null;
        }
        CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) serializableExtra;
        Intent intent = new Intent(context, AJRAutomaticSubscriptionListActivity.class);
        if (getIntent().hasExtra("extra_home_data") && cJRHomePageItem != null && cJRHomePageItem.isDeepLinking()) {
            intent.putExtra("extra_home_data", getIntent().getSerializableExtra("extra_home_data"));
        }
        startActivity(intent);
        if (cJRHomePageItem != null && cJRHomePageItem.isDeepLinking()) {
            finish();
        }
    }

    private final void a(String str) {
        try {
            net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            net.one97.paytm.recharge.automatic.c.a.a.a(this, net.one97.paytm.recharge.automatic.b.a.a.f60240b, str, (Object) null, (Object) null, (Object) null, (Object) null, 120);
        } catch (Throwable unused) {
        }
    }
}
