package net.one97.paytm.recharge.metro.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.sendbird.android.constant.StringSet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.di.helper.b;
import net.one97.paytm.recharge.metro.c.g;
import net.one97.paytm.recharge.metro.c.p;
import net.one97.paytm.recharge.metro.f.c;
import net.one97.paytm.recharge.metro.f.d;
import net.one97.paytm.upi.util.CJRGTMConstants;

public final class AJRActiveMetroTicketListActivity extends CJRBaseMetroActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private boolean f63201a;

    /* renamed from: b  reason: collision with root package name */
    private Serializable f63202b;

    /* renamed from: c  reason: collision with root package name */
    private String f63203c = "";

    /* renamed from: d  reason: collision with root package name */
    private HashMap f63204d;

    public final View a(int i2) {
        if (this.f63204d == null) {
            this.f63204d = new HashMap();
        }
        View view = (View) this.f63204d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f63204d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        ActionBar supportActionBar;
        super.onCreate(bundle);
        getLayoutInflater().inflate(R.layout.activity_ticket_options, c(), true);
        this.f63201a = getIntent().getBooleanExtra("show_single_tickets", false);
        this.f63202b = getIntent().getSerializableExtra("activeMetroTickets");
        String stringExtra = getIntent().getStringExtra("vertical_name");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.f63203c = stringExtra;
        c.a aVar = c.f63576a;
        if (c.a.a()) {
            ActionBar supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.a((CharSequence) "");
            }
        } else {
            c.a aVar2 = c.f63576a;
            if (c.j != null) {
                c.a aVar3 = c.f63576a;
                List i2 = c.j;
                if (i2 == null) {
                    k.a();
                }
                if (!i2.isEmpty()) {
                    ActionBar supportActionBar3 = getSupportActionBar();
                    if (supportActionBar3 != null) {
                        supportActionBar3.a((CharSequence) "Mumbai Metro");
                    }
                }
            }
            c.a aVar4 = c.f63576a;
            if (c.j != null) {
                c.a aVar5 = c.f63576a;
                List i3 = c.j;
                if (i3 == null) {
                    k.a();
                }
                if ((!i3.isEmpty()) && (supportActionBar = getSupportActionBar()) != null) {
                    supportActionBar.a((CharSequence) "Delhi Metro");
                }
            }
        }
        if (getIntent().getBooleanExtra("metro_offline", false)) {
            a(false);
        } else {
            b();
        }
    }

    private final void b() {
        Bundle bundle = new Bundle();
        Intent intent = getIntent();
        k.a((Object) intent, "intent");
        bundle.putAll(intent.getExtras());
        Serializable serializable = this.f63202b;
        if (serializable instanceof List) {
            if (serializable != null) {
                Collection arrayList = new ArrayList();
                for (Object next : (List) serializable) {
                    if (((CJRActiveMetroTicketModel) next).getQrCodes() != null) {
                        arrayList.add(next);
                    }
                }
                List list = (List) arrayList;
                if (list.size() > 1) {
                    bundle.putSerializable("activeMetroTickets", (Serializable) list);
                    a(bundle);
                } else if (list.isEmpty()) {
                    a(true);
                } else {
                    Object obj = list.get(0);
                    if (obj != null) {
                        bundle.putSerializable("activeMetroTickets", (Serializable) obj);
                        if (getIntent().getBooleanExtra("metro_offline", false)) {
                            c.d.a aVar = c.d.Companion;
                            String b2 = c.d.a.b(((CJRActiveMetroTicketModel) list.get(0)).getProductType());
                            if (b2 == null) {
                                b2 = getIntent().getStringExtra(StringSet.operator);
                            }
                            bundle.putString(StringSet.operator, b2);
                        }
                        b(bundle);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type java.io.Serializable");
                }
            } else {
                throw new u("null cannot be cast to non-null type kotlin.collections.List<net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel>");
            }
        } else if (serializable == null || getIntent().getBooleanExtra("metro_offline", false)) {
            a(true);
        } else {
            b(bundle);
        }
    }

    private final void a(Bundle bundle) {
        try {
            b bVar = b.f62652a;
            b.a((Context) this, "mumbai metro qr", CJRGTMConstants.MONEY_TRANSFER_EVENT_ACTION_SAVED_ACCOUNTS_VIEW_ALL_CLICKED, "", "", "/utility/active-tickets", "utility");
        } catch (Throwable unused) {
        }
        getSupportFragmentManager().a().b(R.id.container_fragment, Fragment.instantiate(this, net.one97.paytm.recharge.metro.c.b.class.getName(), bundle)).b();
    }

    private final void b(Bundle bundle) {
        if (!d.INSTANCE.validateIsAlreadyClicked(this)) {
            try {
                b bVar = b.f62652a;
                b.a((Context) this, "mumbai metro qr", "view_ticket_clicked", "", "", "/utility/all-active-tickets", "utility");
            } catch (Throwable unused) {
            }
            g gVar = new g();
            gVar.setCancelable(true);
            gVar.setArguments(bundle);
            j supportFragmentManager = getSupportFragmentManager();
            k.a((Object) supportFragmentManager, "supportFragmentManager");
            gVar.show(supportFragmentManager, net.one97.paytm.recharge.metro.c.b.class.getName());
        }
    }

    private final void a(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt(AppManagerUtil.EXTEND_TYPE, p.f63427c);
        bundle.putBoolean("hasNoOfflineTickets", z);
        getSupportFragmentManager().a().b(R.id.container_fragment, Fragment.instantiate(this, p.class.getName(), bundle)).b();
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.see_offline_ticket;
        if (valueOf != null && valueOf.intValue() == i2) {
            b();
            return;
        }
        int i3 = R.id.retry_button;
        if (valueOf != null && valueOf.intValue() == i3) {
            Context context = this;
            if (com.paytm.utility.b.c(context)) {
                setResult(1002);
                finish();
                return;
            }
            com.paytm.utility.b.a(context, getResources().getString(R.string.title_connection_problem), getResources().getString(R.string.msg_connection_problem));
        }
    }

    public final void onBackPressed() {
        c.a aVar = c.f63576a;
        if (c.l) {
            setResult(1004);
        }
        super.onBackPressed();
    }
}
