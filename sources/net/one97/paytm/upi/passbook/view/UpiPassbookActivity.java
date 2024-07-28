package net.one97.paytm.upi.passbook.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.localbroadcastmanager.a.a;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.CJRReplacementReason;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.UpiConstants;

public class UpiPassbookActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    BroadcastReceiver f67709a = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (UpiConstants.EXTRA_ACTION_RELOAD_UPI.equalsIgnoreCase(intent.getAction())) {
                boolean unused = UpiPassbookActivity.this.j = intent.getBooleanExtra(UpiConstants.EXTRA_RELOAD_UPI_TRANSACTIONS, false);
                boolean unused2 = UpiPassbookActivity.this.k = intent.getBooleanExtra(UpiConstants.EXTRA_RELOAD_UPI_PENDING_REQUESTS, false);
                UpiPassbookActivity.this.a();
                UpiPassbookActivity.this.b();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Context f67710b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f67711c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public TabLayout f67712d;

    /* renamed from: e  reason: collision with root package name */
    private ViewPager f67713e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f67714f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f67715g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f67716h;

    /* renamed from: i  reason: collision with root package name */
    private String f67717i;
    /* access modifiers changed from: private */
    public boolean j;
    /* access modifiers changed from: private */
    public boolean k;
    /* access modifiers changed from: private */
    public boolean l;
    private boolean m;
    private boolean n;
    /* access modifiers changed from: private */
    public int o;
    private CJRReplacementReason p;
    private boolean q = false;
    /* access modifiers changed from: private */
    public RelativeLayout r;
    private TextView s;
    private TextView t;
    private TextView u;

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
        setContentView(R.layout.activity_upi_passbook);
        this.f67710b = this;
        int i2 = 0;
        this.j = false;
        this.k = false;
        this.l = getIntent().getBooleanExtra(UpiConstants.EXTRA_KEY_IS_FROM_PASSBOOK, false);
        this.f67717i = getIntent().getStringExtra(UpiConstants.EXTRA_INTENT_UPI_PASSBOOK_TAB);
        this.o = getIntent().getIntExtra(UpiConstants.KEY_UPI_ITEM_TYPE, UpiConstants.UpiItemType.TRANSACTIONS.ordinal());
        this.q = getIntent().getBooleanExtra("isFromRequestMoney", false);
        this.n = getIntent().getBooleanExtra(CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, false);
        this.r = (RelativeLayout) findViewById(R.id.root_dummy_snack);
        this.s = (TextView) findViewById(R.id.tv_snack_bar_title);
        this.t = (TextView) findViewById(R.id.tv_snack_bar_message);
        this.u = (TextView) findViewById(R.id.btn_action);
        if (this.q) {
            String string = getString(R.string.rq_request_send_successfully);
            this.r.setVisibility(0);
            if (!TextUtils.isEmpty(string)) {
                this.s.setText(string);
                this.s.setVisibility(0);
            } else {
                this.s.setVisibility(8);
            }
            if (!TextUtils.isEmpty("")) {
                this.t.setVisibility(0);
                this.t.setText("");
            } else {
                this.t.setVisibility(8);
            }
            this.u.setText(getString(R.string.request_money_done));
            this.u.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    UpiPassbookActivity.this.r.setVisibility(8);
                }
            });
        }
        if (!TextUtils.isEmpty(this.f67717i)) {
            this.f67717i.equalsIgnoreCase("getpendingrequests");
            this.o = UpiConstants.UpiItemType.PENDING_REQUESTS.ordinal();
        }
        this.m = getIntent().getBooleanExtra(UpiConstants.EXTRA_INTENT_UPI_FROM_CST, false);
        if (getIntent().hasExtra(UpiConstants.INTENT_EXTRA_CST_ORDER_REASONS)) {
            this.p = new CJRReplacementReason();
            this.p.setIssueText("UPI");
            this.p.setId(UpiConstants.CST_UPI_ID);
        }
        this.f67714f = (TextView) findViewById(R.id.tv_spam_folder);
        this.f67714f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CJRSendGTMTag.sendNewCustomGTMEvents(UpiPassbookActivity.this.getApplicationContext(), Events.Category.COLLECT, "spam_folder_click", "", "", "", Events.Screen.PAYMENT_REQUEST_PAGE, "passbook");
                Intent intent = new Intent(UpiPassbookActivity.this.f67710b, UpiPassbookActivity.class);
                intent.putExtra(UpiConstants.KEY_UPI_ITEM_TYPE, UpiConstants.UpiItemType.SPAM_REQUESTS.ordinal());
                UpiPassbookActivity.this.startActivity(intent);
            }
        });
        this.f67715g = (TextView) findViewById(R.id.tv_title);
        if (this.o == UpiConstants.UpiItemType.TRANSACTIONS.ordinal()) {
            this.f67715g.setText(getString(R.string.upi_title_payments));
        } else if (this.o == UpiConstants.UpiItemType.PENDING_REQUESTS.ordinal()) {
            this.f67715g.setText(getString(R.string.upi_title_payment_request));
        } else if (this.o == UpiConstants.UpiItemType.SPAM_REQUESTS.ordinal()) {
            this.f67715g.setText(getString(R.string.upi_spam_folder_new));
        }
        this.f67716h = (ImageView) findViewById(R.id.iv_refresh);
        this.f67716h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (UpiPassbookActivity.this.l) {
                    CJRSendGTMTag.sendNewCustomGTMEvents(UpiPassbookActivity.this.getApplicationContext(), "passbook_UPI", "UPI_passbook_refresh_clicked", "", "", "", "/passbook/upi", "passbook");
                }
                if (UpiPassbookActivity.this.o == UpiConstants.UpiItemType.TRANSACTIONS.ordinal()) {
                    Intent intent = new Intent();
                    intent.setAction(UpiConstants.EXTRA_ACTION_UPI_PASSBOOK_REFRESH_TRANSACTIONS);
                    a.a(UpiPassbookActivity.this.f67710b).a(intent);
                } else if (UpiPassbookActivity.this.o == UpiConstants.UpiItemType.PENDING_REQUESTS.ordinal()) {
                    if (UpiPassbookActivity.this.f67712d.getVisibility() != 0) {
                        return;
                    }
                    if (UpiPassbookActivity.this.f67712d.getSelectedTabPosition() == 0) {
                        Intent intent2 = new Intent();
                        intent2.setAction(UpiConstants.EXTRA_ACTION_UPI_PASSBOOK_REFRESH_RECEIVED_TRANSACTIONS);
                        a.a(UpiPassbookActivity.this.f67710b).a(intent2);
                        return;
                    }
                    Intent intent3 = new Intent();
                    intent3.setAction(UpiConstants.EXTRA_ACTION_UPI_PASSBOOK_REFRESH_SENT_TRANSACTIONS);
                    a.a(UpiPassbookActivity.this.f67710b).a(intent3);
                } else if (UpiPassbookActivity.this.o == UpiConstants.UpiItemType.SPAM_REQUESTS.ordinal()) {
                    Intent intent4 = new Intent();
                    intent4.setAction(UpiConstants.EXTRA_ACTION_UPI_PASSBOOK_REFRESH_SPAM);
                    a.a(UpiPassbookActivity.this.f67710b).a(intent4);
                }
            }
        });
        this.f67712d = (TabLayout) findViewById(R.id.tl_upi_tabs);
        this.f67713e = (ViewPager) findViewById(R.id.vp_upi);
        this.f67711c = (ImageView) findViewById(R.id.iv_back_button);
        this.f67711c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (UpiPassbookActivity.this.o == UpiConstants.UpiItemType.PENDING_REQUESTS.ordinal()) {
                    CJRSendGTMTag.sendNewCustomGTMEvents(UpiPassbookActivity.this.getApplicationContext(), Events.Category.COLLECT, Events.Action.BACK_ARROW_CLICKED, "", "", "", Events.Screen.PAYMENT_REQUEST_PAGE, "passbook");
                } else if (UpiPassbookActivity.this.o == UpiConstants.UpiItemType.SPAM_REQUESTS.ordinal()) {
                    CJRSendGTMTag.sendNewCustomGTMEvents(UpiPassbookActivity.this.getApplicationContext(), Events.Category.COLLECT, Events.Action.BACK_ARROW_CLICKED, "", "", "", Events.Screen.SPAM_FOLDER, "passbook");
                }
                UpiPassbookActivity.this.finish();
            }
        });
        b bVar = new b(this.f67710b, getSupportFragmentManager(), this.p, this.l, this.o, this.m, this.n);
        this.f67713e.setAdapter(bVar);
        this.f67713e.addOnPageChangeListener(new ViewPager.e() {
            public final void onPageScrollStateChanged(int i2) {
            }

            public final void onPageScrolled(int i2, float f2, int i3) {
            }

            public final void onPageSelected(int i2) {
                if (i2 == 0) {
                    UpiPassbookActivity.this.a();
                } else if (i2 == 1) {
                    UpiPassbookActivity.this.b();
                }
            }
        });
        this.f67712d.setupWithViewPager(this.f67713e);
        bVar.notifyDataSetChanged();
        if (this.o == UpiConstants.UpiItemType.TRANSACTIONS.ordinal()) {
            this.f67712d.setVisibility(8);
            this.f67714f.setVisibility(8);
        } else if (this.o == UpiConstants.UpiItemType.PENDING_REQUESTS.ordinal()) {
            this.f67712d.setVisibility(0);
            this.f67714f.setVisibility(0);
        } else if (this.o == UpiConstants.UpiItemType.SPAM_REQUESTS.ordinal()) {
            this.f67712d.setVisibility(8);
            this.f67714f.setVisibility(8);
        }
        if (this.o == UpiConstants.UpiItemType.PENDING_REQUESTS.ordinal()) {
            if (!TextUtils.isEmpty(this.f67717i) && "getpendingrequestssent".equalsIgnoreCase(this.f67717i)) {
                i2 = 1;
            }
            this.f67713e.setCurrentItem(i2);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(UpiConstants.EXTRA_ACTION_RELOAD_UPI);
        a.a(this.f67710b).a(this.f67709a, intentFilter);
        net.one97.paytm.upi.f.a aVar = i.a().l;
        if (aVar != null) {
            aVar.a(getApplicationContext());
        }
    }

    public void onResume() {
        super.onResume();
        a();
        b();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f67709a != null) {
            a.a(this.f67710b).a(this.f67709a);
            this.f67709a = null;
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        if (this.j) {
            this.j = false;
            Intent intent = new Intent();
            intent.setAction(UpiConstants.EXTRA_ACTION_UPI_PASSBOOK_TAB_CHANGED);
            intent.putExtra(UpiConstants.EXTRA_RELOAD_UPI_TRANSACTIONS, true);
            a.a(this.f67710b).a(intent);
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        if (this.k) {
            this.k = false;
            Intent intent = new Intent();
            intent.setAction(UpiConstants.EXTRA_ACTION_UPI_PASSBOOK_TAB_CHANGED);
            intent.putExtra(UpiConstants.EXTRA_RELOAD_UPI_PENDING_REQUESTS, true);
            a.a(this.f67710b).a(intent);
        }
    }
}
