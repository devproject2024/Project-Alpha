package net.one97.paytm.upi.awareness.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.awareness.a.a;
import net.one97.paytm.upi.awareness.view.a;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.registration.view.b;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;

public class AwarenessSelectBankActivity extends PaytmActivity implements a.b, a.b {

    /* renamed from: a  reason: collision with root package name */
    private a.C1341a f66544a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.upi.registration.presenter.a f66545b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f66546c;

    /* renamed from: d  reason: collision with root package name */
    private ProgressBar f66547d;

    /* renamed from: e  reason: collision with root package name */
    private Toolbar f66548e;

    /* renamed from: f  reason: collision with root package name */
    private SearchView f66549f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextView f66550g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TextView f66551h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f66552i;
    /* access modifiers changed from: private */
    public boolean j = false;
    private String k = "";
    private String l = "";
    /* access modifiers changed from: private */
    public Handler m = new Handler(new Handler.Callback() {
        public final boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            AwarenessSelectBankActivity.this.f66545b.a((String) message.obj);
            return false;
        }
    });

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.f66544a = (a.C1341a) obj;
    }

    public void attachBaseContext(Context context) {
        if (i.a().m == null) {
            super.attachBaseContext(context);
        }
        ContextWrapper d2 = i.a().m.d(context);
        if (d2 != null) {
            super.attachBaseContext(d2);
        } else {
            super.attachBaseContext(context);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_awareness_select_bank);
        this.l = UpiAppUtils.getMobile(this);
        if (!TextUtils.isEmpty(this.l)) {
            this.l = "+91 " + this.l;
        }
        if (getIntent() != null) {
            this.k = getIntent().getStringExtra("redirection_url");
        }
        getApplicationContext();
        getApplicationContext();
        new net.one97.paytm.upi.awareness.c.a(g.a(net.one97.paytm.upi.h.a.a(g.d(), (a.C1347a) null)), this);
        this.f66548e = (Toolbar) findViewById(R.id.tb_activity);
        this.f66547d = (ProgressBar) findViewById(R.id.pb_progress);
        this.f66546c = (RecyclerView) findViewById(R.id.rv_favBanks);
        this.f66546c.setLayoutManager(new GridLayoutManager(this, 3));
        this.f66549f = (SearchView) findViewById(R.id.searchView);
        this.f66551h = (TextView) findViewById(R.id.tv_skip);
        this.f66550g = (TextView) this.f66548e.findViewById(R.id.tv_toolbar_title);
        this.f66552i = (TextView) this.f66548e.findViewById(R.id.tv_toolbar_subtitle);
        b d2 = b.d();
        d2.f68799a = false;
        getApplicationContext();
        getApplicationContext();
        this.f66545b = new net.one97.paytm.upi.registration.presenter.a(g.a(net.one97.paytm.upi.h.a.a(g.d(), (a.C1347a) null)), d2, (byte) 0);
        getSupportFragmentManager().a().a(R.id.fl_banksListContainer, d2, b.class.getCanonicalName()).b();
        this.f66544a.e();
        setSupportActionBar(this.f66548e);
        this.f66548e.setOnMenuItemClickListener(new Toolbar.b() {
            public final boolean a(MenuItem menuItem) {
                return false;
            }
        });
        this.f66548e.findViewById(R.id.iv_back_arrow).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AwarenessSelectBankActivity.this.onBackPressed();
            }
        });
        this.f66549f.setOnSearchClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AwarenessSelectBankActivity.this.f66550g.setVisibility(8);
                AwarenessSelectBankActivity.this.f66551h.setVisibility(8);
                AwarenessSelectBankActivity.this.f66546c.setVisibility(8);
            }
        });
        this.f66549f.setOnCloseListener(new SearchView.a() {
            public final boolean a() {
                AwarenessSelectBankActivity.this.f66550g.setVisibility(0);
                if (AwarenessSelectBankActivity.this.j) {
                    AwarenessSelectBankActivity.this.f66551h.setVisibility(0);
                }
                AwarenessSelectBankActivity.this.f66546c.setVisibility(0);
                return false;
            }
        });
        this.f66549f.setOnQueryTextListener(new SearchView.b() {
            public final boolean a(String str) {
                return false;
            }

            public final boolean b(String str) {
                AwarenessSelectBankActivity.this.m.removeCallbacksAndMessages((Object) null);
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = str;
                AwarenessSelectBankActivity.this.m.sendMessageDelayed(obtain, 200);
                return true;
            }
        });
        if (!TextUtils.isEmpty(this.l)) {
            this.f66552i.setText(getString(R.string.upi_link_upi, new Object[]{this.l}));
            this.f66552i.setVisibility(0);
            return;
        }
        this.f66552i.setVisibility(8);
    }

    public void onResume() {
        super.onResume();
    }

    public final void a() {
        this.f66547d.setVisibility(0);
    }

    public final void a(List<UpiBaseDataModel> list) {
        this.f66547d.setVisibility(8);
        this.f66545b.a(list);
    }

    public final void b(List<net.one97.paytm.upi.awareness.b.a> list) {
        this.f66546c.setAdapter(new a(list, this));
    }

    public final void b() {
        this.f66547d.setVisibility(8);
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider) {
        if (Build.VERSION.SDK_INT < 23 || androidx.core.content.b.a((Context) this, "android.permission.READ_PHONE_STATE") == 0) {
            UpiRegistrationActivity.a((Activity) this, accountProvider, this.k, getIntent().getIntExtra(UpiConstants.EXTRA_ON_BOARDING_SOURCE, 0));
            finish();
            return;
        }
        requestPermissions(new String[]{"android.permission.READ_PHONE_STATE"}, 16);
    }
}
