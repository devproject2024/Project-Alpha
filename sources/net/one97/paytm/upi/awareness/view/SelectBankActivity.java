package net.one97.paytm.upi.awareness.view;

import android.app.Activity;
import android.content.Context;
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
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.registration.view.b;
import net.one97.paytm.upi.util.UpiConstants;

public class SelectBankActivity extends PaytmActivity implements a.b, a.b {

    /* renamed from: a  reason: collision with root package name */
    private a.C1341a f66559a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.upi.registration.presenter.a f66560b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f66561c;

    /* renamed from: d  reason: collision with root package name */
    private ProgressBar f66562d;

    /* renamed from: e  reason: collision with root package name */
    private Toolbar f66563e;

    /* renamed from: f  reason: collision with root package name */
    private SearchView f66564f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextView f66565g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TextView f66566h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f66567i;
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
            SelectBankActivity.this.f66560b.a((String) message.obj);
            return false;
        }
    });

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.f66559a = (a.C1341a) obj;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_awareness_select_bank);
        if (getIntent() != null) {
            this.k = getIntent().getStringExtra("redirection_url");
            this.l = getIntent().getStringExtra("user_phone_number");
        }
        getApplicationContext();
        getApplicationContext();
        new net.one97.paytm.upi.awareness.c.a(g.a(net.one97.paytm.upi.h.a.a(g.d(), (a.C1347a) null)), this);
        this.f66563e = (Toolbar) findViewById(R.id.tb_activity);
        this.f66562d = (ProgressBar) findViewById(R.id.pb_progress);
        this.f66561c = (RecyclerView) findViewById(R.id.rv_favBanks);
        this.f66561c.setLayoutManager(new GridLayoutManager(this, 3));
        this.f66564f = (SearchView) findViewById(R.id.searchView);
        this.f66566h = (TextView) findViewById(R.id.tv_skip);
        this.f66565g = (TextView) this.f66563e.findViewById(R.id.tv_toolbar_title);
        this.f66567i = (TextView) this.f66563e.findViewById(R.id.tv_toolbar_subtitle);
        b d2 = b.d();
        d2.f68799a = false;
        getApplicationContext();
        getApplicationContext();
        this.f66560b = new net.one97.paytm.upi.registration.presenter.a(g.a(net.one97.paytm.upi.h.a.a(g.d(), (a.C1347a) null)), d2, (byte) 0);
        getSupportFragmentManager().a().a(R.id.fl_banksListContainer, d2, b.class.getCanonicalName()).b();
        this.f66559a.e();
        setSupportActionBar(this.f66563e);
        this.f66563e.setOnMenuItemClickListener(new Toolbar.b() {
            public final boolean a(MenuItem menuItem) {
                return false;
            }
        });
        this.f66563e.findViewById(R.id.iv_back_arrow).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SelectBankActivity.this.onBackPressed();
            }
        });
        this.f66564f.setOnSearchClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SelectBankActivity.this.f66565g.setVisibility(8);
                SelectBankActivity.this.f66566h.setVisibility(8);
                SelectBankActivity.this.f66561c.setVisibility(8);
            }
        });
        this.f66564f.setOnCloseListener(new SearchView.a() {
            public final boolean a() {
                SelectBankActivity.this.f66565g.setVisibility(0);
                if (SelectBankActivity.this.j) {
                    SelectBankActivity.this.f66566h.setVisibility(0);
                }
                SelectBankActivity.this.f66561c.setVisibility(0);
                return false;
            }
        });
        this.f66564f.setOnQueryTextListener(new SearchView.b() {
            public final boolean a(String str) {
                return false;
            }

            public final boolean b(String str) {
                SelectBankActivity.this.m.removeCallbacksAndMessages((Object) null);
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = str;
                SelectBankActivity.this.m.sendMessageDelayed(obtain, 200);
                return true;
            }
        });
        if (!TextUtils.isEmpty(this.l)) {
            this.f66567i.setText(getString(R.string.upi_link_upi, new Object[]{this.l}));
            this.f66567i.setVisibility(0);
            return;
        }
        this.f66567i.setVisibility(8);
    }

    public void onResume() {
        super.onResume();
    }

    public final void a() {
        this.f66562d.setVisibility(0);
    }

    public final void a(List<UpiBaseDataModel> list) {
        this.f66562d.setVisibility(8);
        this.f66560b.a(list);
    }

    public final void b(List<net.one97.paytm.upi.awareness.b.a> list) {
        this.f66561c.setAdapter(new a(list, this));
    }

    public final void b() {
        this.f66562d.setVisibility(8);
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
