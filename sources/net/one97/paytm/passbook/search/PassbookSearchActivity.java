package net.one97.paytm.passbook.search;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.j;
import androidx.viewpager.widget.ViewPager;
import com.google.gson.f;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.one97.paytm.common.entity.CJRPGToken;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.widgets.CJRHorizontalListView;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.beans.CJRCashWallet;
import net.one97.paytm.passbook.beans.CJRLedger;
import net.one97.paytm.passbook.beans.CJRLedgerResponse;
import net.one97.paytm.passbook.beans.CJRTransaction;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.mapping.c;
import net.one97.paytm.passbook.utility.CustomToggleButton;
import net.one97.paytm.passbook.utility.h;
import net.one97.paytm.passbook.utility.l;
import net.one97.paytm.passbook.utility.m;
import net.one97.paytm.passbook.utility.n;
import net.one97.paytm.passbook.utility.q;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PassbookSearchActivity extends BaseActivity implements View.OnClickListener, g, i.a<IJRDataModel>, l {
    /* access modifiers changed from: private */
    public CustomToggleButton A;
    /* access modifiers changed from: private */
    public CustomToggleButton B;
    /* access modifiers changed from: private */
    public CustomToggleButton C;
    /* access modifiers changed from: private */
    public CustomToggleButton D;
    /* access modifiers changed from: private */
    public CustomToggleButton E;
    /* access modifiers changed from: private */
    public CustomToggleButton F;
    /* access modifiers changed from: private */
    public CustomToggleButton G;
    /* access modifiers changed from: private */
    public CustomToggleButton H;
    private ArrayList<f> I;
    /* access modifiers changed from: private */
    public f J;
    /* access modifiers changed from: private */
    public f K;
    /* access modifiers changed from: private */
    public f L;
    /* access modifiers changed from: private */
    public f M;
    /* access modifiers changed from: private */
    public f N;
    /* access modifiers changed from: private */
    public f O;
    /* access modifiers changed from: private */
    public CustomToggleButton P;
    /* access modifiers changed from: private */
    public f Q;
    /* access modifiers changed from: private */
    public f R;
    /* access modifiers changed from: private */
    public f S;
    /* access modifiers changed from: private */
    public f T;
    /* access modifiers changed from: private */
    public ArrayList<f> U;
    /* access modifiers changed from: private */
    public Button V;
    /* access modifiers changed from: private */
    public LinearLayout W;
    /* access modifiers changed from: private */
    public boolean X = false;
    private int Y;
    private CompoundButton.OnCheckedChangeListener Z = new CompoundButton.OnCheckedChangeListener() {
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            int id = compoundButton.getId();
            if (id == R.id.btn_toggle_paytm_cashback) {
                if (z) {
                    PassbookSearchActivity.this.t.setTextColor(-1);
                    PassbookSearchActivity.this.J.f58475d = true;
                    PassbookSearchActivity.this.U.add(PassbookSearchActivity.this.J);
                    PassbookSearchActivity passbookSearchActivity = PassbookSearchActivity.this;
                    PassbookSearchActivity.a(passbookSearchActivity, passbookSearchActivity.t.getText().toString());
                    CustomToggleButton i2 = PassbookSearchActivity.this.t;
                    i2.setTextOn(PassbookSearchActivity.this.J.f58472a);
                } else {
                    PassbookSearchActivity.this.t.setTextColor(-16777216);
                    PassbookSearchActivity.this.J.f58475d = false;
                    PassbookSearchActivity.this.U.remove(PassbookSearchActivity.this.J);
                    CustomToggleButton i3 = PassbookSearchActivity.this.t;
                    i3.setTextOff(PassbookSearchActivity.this.J.f58472a);
                }
                if (PassbookSearchActivity.this.U.size() == 0) {
                    PassbookSearchActivity.this.V.setVisibility(8);
                    PassbookSearchActivity.this.v.setVisibility(8);
                } else {
                    PassbookSearchActivity.this.V.setVisibility(0);
                    PassbookSearchActivity.this.v.setVisibility(0);
                }
                PassbookSearchActivity.this.z.a((ArrayList<f>) PassbookSearchActivity.this.U);
            } else if (id == R.id.btn_toggle_paytm_sent_to_bank) {
                if (z) {
                    PassbookSearchActivity.this.A.setTextColor(-1);
                    PassbookSearchActivity.this.K.f58475d = true;
                    PassbookSearchActivity.this.U.add(PassbookSearchActivity.this.K);
                    PassbookSearchActivity passbookSearchActivity2 = PassbookSearchActivity.this;
                    PassbookSearchActivity.a(passbookSearchActivity2, passbookSearchActivity2.A.getText().toString());
                    CustomToggleButton l = PassbookSearchActivity.this.A;
                    l.setTextOn(PassbookSearchActivity.this.K.f58472a);
                } else {
                    PassbookSearchActivity.this.A.setTextColor(-16777216);
                    PassbookSearchActivity.this.K.f58475d = false;
                    PassbookSearchActivity.this.U.remove(PassbookSearchActivity.this.K);
                    CustomToggleButton l2 = PassbookSearchActivity.this.A;
                    l2.setTextOff(PassbookSearchActivity.this.K.f58472a);
                }
                if (PassbookSearchActivity.this.U.size() == 0) {
                    PassbookSearchActivity.this.V.setVisibility(8);
                    PassbookSearchActivity.this.v.setVisibility(8);
                } else {
                    PassbookSearchActivity.this.V.setVisibility(0);
                    PassbookSearchActivity.this.v.setVisibility(0);
                }
                PassbookSearchActivity.this.z.a((ArrayList<f>) PassbookSearchActivity.this.U);
            } else if (id == R.id.btn_toggle_refund) {
                if (z) {
                    PassbookSearchActivity.this.B.setTextColor(-1);
                    PassbookSearchActivity.this.L.f58475d = true;
                    PassbookSearchActivity.this.U.add(PassbookSearchActivity.this.L);
                    PassbookSearchActivity passbookSearchActivity3 = PassbookSearchActivity.this;
                    PassbookSearchActivity.a(passbookSearchActivity3, passbookSearchActivity3.B.getText().toString());
                    CustomToggleButton n = PassbookSearchActivity.this.B;
                    n.setTextOn(PassbookSearchActivity.this.L.f58472a);
                } else {
                    PassbookSearchActivity.this.B.setTextColor(-16777216);
                    PassbookSearchActivity.this.L.f58475d = false;
                    PassbookSearchActivity.this.U.remove(PassbookSearchActivity.this.L);
                    CustomToggleButton n2 = PassbookSearchActivity.this.B;
                    n2.setTextOff(PassbookSearchActivity.this.L.f58472a);
                }
                if (PassbookSearchActivity.this.U.size() == 0) {
                    PassbookSearchActivity.this.V.setVisibility(8);
                    PassbookSearchActivity.this.v.setVisibility(8);
                } else {
                    PassbookSearchActivity.this.V.setVisibility(0);
                    PassbookSearchActivity.this.v.setVisibility(0);
                }
                PassbookSearchActivity.this.z.a((ArrayList<f>) PassbookSearchActivity.this.U);
            } else if (id == R.id.btn_toggle_paytm_cash_sent) {
                if (z) {
                    PassbookSearchActivity.this.C.setTextColor(-1);
                    PassbookSearchActivity.this.M.f58475d = true;
                    PassbookSearchActivity.this.U.add(PassbookSearchActivity.this.M);
                    PassbookSearchActivity passbookSearchActivity4 = PassbookSearchActivity.this;
                    PassbookSearchActivity.a(passbookSearchActivity4, passbookSearchActivity4.C.getText().toString());
                    CustomToggleButton p = PassbookSearchActivity.this.C;
                    p.setTextOn(PassbookSearchActivity.this.M.f58472a);
                } else {
                    PassbookSearchActivity.this.C.setTextColor(-16777216);
                    PassbookSearchActivity.this.M.f58475d = false;
                    PassbookSearchActivity.this.U.remove(PassbookSearchActivity.this.M);
                    CustomToggleButton p2 = PassbookSearchActivity.this.C;
                    p2.setTextOff(PassbookSearchActivity.this.M.f58472a);
                }
                if (PassbookSearchActivity.this.U.size() == 0) {
                    PassbookSearchActivity.this.V.setVisibility(8);
                    PassbookSearchActivity.this.v.setVisibility(8);
                } else {
                    PassbookSearchActivity.this.V.setVisibility(0);
                    PassbookSearchActivity.this.v.setVisibility(0);
                }
                PassbookSearchActivity.this.z.a((ArrayList<f>) PassbookSearchActivity.this.U);
            } else if (id == R.id.btn_toggle_paytm_paid_for_order) {
                if (z) {
                    PassbookSearchActivity.this.D.setTextColor(-1);
                    PassbookSearchActivity.this.N.f58475d = true;
                    PassbookSearchActivity.this.U.add(PassbookSearchActivity.this.N);
                    PassbookSearchActivity passbookSearchActivity5 = PassbookSearchActivity.this;
                    PassbookSearchActivity.a(passbookSearchActivity5, passbookSearchActivity5.D.getText().toString());
                    CustomToggleButton r = PassbookSearchActivity.this.D;
                    r.setTextOn(PassbookSearchActivity.this.N.f58472a);
                } else {
                    PassbookSearchActivity.this.D.setTextColor(-16777216);
                    PassbookSearchActivity.this.N.f58475d = false;
                    PassbookSearchActivity.this.U.remove(PassbookSearchActivity.this.N);
                    CustomToggleButton r2 = PassbookSearchActivity.this.D;
                    r2.setTextOff(PassbookSearchActivity.this.N.f58472a);
                }
                if (PassbookSearchActivity.this.U.size() == 0) {
                    PassbookSearchActivity.this.V.setVisibility(8);
                    PassbookSearchActivity.this.v.setVisibility(8);
                } else {
                    PassbookSearchActivity.this.V.setVisibility(0);
                    PassbookSearchActivity.this.v.setVisibility(0);
                }
                PassbookSearchActivity.this.z.a((ArrayList<f>) PassbookSearchActivity.this.U);
            } else if (id == R.id.btn_toggle_paytm_cash_received) {
                if (z) {
                    PassbookSearchActivity.this.E.setTextColor(-1);
                    PassbookSearchActivity.this.O.f58475d = true;
                    PassbookSearchActivity.this.U.add(PassbookSearchActivity.this.O);
                    PassbookSearchActivity passbookSearchActivity6 = PassbookSearchActivity.this;
                    PassbookSearchActivity.a(passbookSearchActivity6, passbookSearchActivity6.E.getText().toString());
                    CustomToggleButton t = PassbookSearchActivity.this.E;
                    t.setTextOn(PassbookSearchActivity.this.O.f58472a);
                } else {
                    PassbookSearchActivity.this.E.setTextColor(-16777216);
                    PassbookSearchActivity.this.O.f58475d = false;
                    PassbookSearchActivity.this.U.remove(PassbookSearchActivity.this.O);
                    CustomToggleButton t2 = PassbookSearchActivity.this.E;
                    t2.setTextOff(PassbookSearchActivity.this.O.f58472a);
                }
                if (PassbookSearchActivity.this.U.size() == 0) {
                    PassbookSearchActivity.this.V.setVisibility(8);
                    PassbookSearchActivity.this.v.setVisibility(8);
                } else {
                    PassbookSearchActivity.this.V.setVisibility(0);
                    PassbookSearchActivity.this.v.setVisibility(0);
                }
                PassbookSearchActivity.this.z.a((ArrayList<f>) PassbookSearchActivity.this.U);
            } else if (id == R.id.btn_toggle_money_added) {
                if (z) {
                    PassbookSearchActivity.this.P.setTextColor(-1);
                    PassbookSearchActivity.this.Q.f58475d = true;
                    PassbookSearchActivity.this.U.add(PassbookSearchActivity.this.Q);
                    PassbookSearchActivity passbookSearchActivity7 = PassbookSearchActivity.this;
                    PassbookSearchActivity.a(passbookSearchActivity7, passbookSearchActivity7.P.getText().toString());
                    CustomToggleButton v = PassbookSearchActivity.this.P;
                    v.setTextOn(PassbookSearchActivity.this.Q.f58472a);
                } else {
                    PassbookSearchActivity.this.P.setTextColor(-16777216);
                    PassbookSearchActivity.this.Q.f58475d = false;
                    PassbookSearchActivity.this.U.remove(PassbookSearchActivity.this.Q);
                    CustomToggleButton v2 = PassbookSearchActivity.this.P;
                    v2.setTextOff(PassbookSearchActivity.this.Q.f58472a);
                }
                if (PassbookSearchActivity.this.U.size() == 0) {
                    PassbookSearchActivity.this.V.setVisibility(8);
                    PassbookSearchActivity.this.v.setVisibility(8);
                } else {
                    PassbookSearchActivity.this.V.setVisibility(0);
                    PassbookSearchActivity.this.v.setVisibility(0);
                }
                PassbookSearchActivity.this.z.a((ArrayList<f>) PassbookSearchActivity.this.U);
            } else if (id == R.id.btn_toggle_failed) {
                if (z) {
                    PassbookSearchActivity.this.F.setTextColor(-1);
                    PassbookSearchActivity.this.R.f58475d = true;
                    PassbookSearchActivity.this.U.add(PassbookSearchActivity.this.R);
                    PassbookSearchActivity passbookSearchActivity8 = PassbookSearchActivity.this;
                    PassbookSearchActivity.a(passbookSearchActivity8, passbookSearchActivity8.F.getText().toString());
                    CustomToggleButton x = PassbookSearchActivity.this.F;
                    x.setTextOn(PassbookSearchActivity.this.R.f58472a);
                } else {
                    PassbookSearchActivity.this.F.setTextColor(-16777216);
                    PassbookSearchActivity.this.R.f58475d = false;
                    PassbookSearchActivity.this.U.remove(PassbookSearchActivity.this.R);
                    CustomToggleButton x2 = PassbookSearchActivity.this.F;
                    x2.setTextOff(PassbookSearchActivity.this.R.f58472a);
                }
                if (PassbookSearchActivity.this.U.size() == 0) {
                    PassbookSearchActivity.this.V.setVisibility(8);
                    PassbookSearchActivity.this.v.setVisibility(8);
                } else {
                    PassbookSearchActivity.this.V.setVisibility(0);
                    PassbookSearchActivity.this.v.setVisibility(0);
                }
                PassbookSearchActivity.this.z.a((ArrayList<f>) PassbookSearchActivity.this.U);
            } else if (id == R.id.btn_toggle_paytm_pending) {
                if (z) {
                    PassbookSearchActivity.this.G.setTextColor(-1);
                    PassbookSearchActivity.this.S.f58475d = true;
                    PassbookSearchActivity.this.U.add(PassbookSearchActivity.this.S);
                    PassbookSearchActivity passbookSearchActivity9 = PassbookSearchActivity.this;
                    PassbookSearchActivity.a(passbookSearchActivity9, passbookSearchActivity9.G.getText().toString());
                    CustomToggleButton z2 = PassbookSearchActivity.this.G;
                    z2.setTextOn(PassbookSearchActivity.this.S.f58472a);
                } else {
                    PassbookSearchActivity.this.G.setTextColor(-16777216);
                    PassbookSearchActivity.this.S.f58475d = false;
                    PassbookSearchActivity.this.U.remove(PassbookSearchActivity.this.S);
                    CustomToggleButton z3 = PassbookSearchActivity.this.G;
                    z3.setTextOff(PassbookSearchActivity.this.S.f58472a);
                }
                if (PassbookSearchActivity.this.U.size() == 0) {
                    PassbookSearchActivity.this.V.setVisibility(8);
                    PassbookSearchActivity.this.v.setVisibility(8);
                } else {
                    PassbookSearchActivity.this.V.setVisibility(0);
                    PassbookSearchActivity.this.v.setVisibility(0);
                }
                PassbookSearchActivity.this.z.a((ArrayList<f>) PassbookSearchActivity.this.U);
            } else if (id == R.id.btn_toggle_paytm_succesful) {
                if (z) {
                    PassbookSearchActivity.this.H.setTextColor(-1);
                    PassbookSearchActivity.this.T.f58475d = true;
                    PassbookSearchActivity.this.U.add(PassbookSearchActivity.this.T);
                    PassbookSearchActivity passbookSearchActivity10 = PassbookSearchActivity.this;
                    PassbookSearchActivity.a(passbookSearchActivity10, passbookSearchActivity10.H.getText().toString());
                    CustomToggleButton B = PassbookSearchActivity.this.H;
                    B.setTextOn(PassbookSearchActivity.this.T.f58472a);
                } else {
                    PassbookSearchActivity.this.H.setTextColor(-16777216);
                    PassbookSearchActivity.this.T.f58475d = false;
                    PassbookSearchActivity.this.U.remove(PassbookSearchActivity.this.T);
                    CustomToggleButton B2 = PassbookSearchActivity.this.H;
                    B2.setTextOff(PassbookSearchActivity.this.T.f58472a);
                }
                if (PassbookSearchActivity.this.U.size() == 0) {
                    PassbookSearchActivity.this.V.setVisibility(8);
                    PassbookSearchActivity.this.v.setVisibility(8);
                } else {
                    PassbookSearchActivity.this.V.setVisibility(0);
                    PassbookSearchActivity.this.v.setVisibility(0);
                }
                PassbookSearchActivity.this.z.a((ArrayList<f>) PassbookSearchActivity.this.U);
            }
            boolean unused = PassbookSearchActivity.this.X = false;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    LinkedHashMap<String, ArrayList<CJRTransaction>> f58314a;
    private MenuItem aa;
    private boolean ab = true;
    /* access modifiers changed from: private */
    public SearchView ac;
    private boolean ad = true;
    private Toolbar ae;
    private TextView af;

    /* renamed from: b  reason: collision with root package name */
    int f58315b;

    /* renamed from: c  reason: collision with root package name */
    boolean f58316c = false;

    /* renamed from: d  reason: collision with root package name */
    ProgressDialog f58317d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ViewPager f58318e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public JSONObject f58319f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f58320g;

    /* renamed from: h  reason: collision with root package name */
    private String f58321h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<h> f58322i = new ArrayList<>();
    private ExecutorService j;
    private Dialog k;
    private boolean l;
    private boolean m = false;
    private boolean n;
    private boolean o;
    private LinearLayout p;
    private RelativeLayout q;
    private LinkedHashMap r;
    private LinearLayout s;
    /* access modifiers changed from: private */
    public CustomToggleButton t;
    private CJRHorizontalListView u;
    /* access modifiers changed from: private */
    public RelativeLayout v;
    /* access modifiers changed from: private */
    public TextView w;
    private int x;
    private int y;
    /* access modifiers changed from: private */
    public a z;

    public final void a(String str) {
    }

    public final String c() {
        return null;
    }

    public final boolean g() {
        return true;
    }

    public final boolean i() {
        return true;
    }

    public /* synthetic */ void onResponse(Object obj) {
        boolean z2;
        IJRDataModel iJRDataModel = (IJRDataModel) obj;
        if (!isFinishing()) {
            o();
            a();
            h();
            if (iJRDataModel instanceof CJRLedger) {
                b.j();
                this.w.setVisibility(8);
                this.q.setVisibility(0);
                CJRLedger cJRLedger = (CJRLedger) iJRDataModel;
                this.m = false;
                if (this.U.size() > 0) {
                    this.v.setVisibility(0);
                } else {
                    this.v.setVisibility(8);
                }
                this.W.setVisibility(8);
                this.f58318e.setVisibility(0);
                if (cJRLedger == null || !(z2 = this.f58316c)) {
                    a(cJRLedger, this.f58316c);
                    return;
                }
                a(cJRLedger, z2);
                this.f58316c = false;
            } else if (iJRDataModel instanceof CJRLedgerResponse) {
                CJRLedgerResponse cJRLedgerResponse = (CJRLedgerResponse) iJRDataModel;
                if (this.l) {
                    this.l = false;
                    j();
                }
                if (cJRLedgerResponse != null) {
                    c.a((Context) this, (String) null, cJRLedgerResponse.getDisplayMessage());
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        setContentView(R.layout.pass_activity_module_passbook_search);
        this.j = Executors.newFixedThreadPool(1);
        this.ae = (Toolbar) findViewById(R.id.toolbar);
        this.ae.setTitle(R.string.top_menu_passbook);
        setSupportActionBar(this.ae);
        this.ae.setNavigationIcon(R.drawable.pass_back_arrow);
        this.af = (TextView) this.ae.findViewById(R.id.toolbar_title);
        this.ae.setNavigationOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PassbookSearchActivity.this.finish();
            }
        });
        this.o = intent.getBooleanExtra("issearch", false);
        this.f58315b = 0;
        this.q = (RelativeLayout) findViewById(R.id.passbook_layout);
        this.p = (LinearLayout) findViewById(R.id.no_internet_layout);
        this.s = (LinearLayout) findViewById(R.id.passbook_search);
        this.f58318e = (ViewPager) findViewById(R.id.passbook_wallet_viewpager);
        try {
            new HashMap().put("wallet_screen_type", "net/one97/paytm/passbook");
            getApplicationContext();
        } catch (Exception unused) {
        }
        this.w = (TextView) findViewById(R.id.tvNoData);
        this.w.setVisibility(8);
        this.W = (LinearLayout) findViewById(R.id.search_container);
        this.u = (CJRHorizontalListView) findViewById(R.id.list_filter_by);
        this.v = (RelativeLayout) findViewById(R.id.list_filter_container);
        this.x = b.f((Context) this);
        CJRHorizontalListView cJRHorizontalListView = this.u;
        int i2 = this.y;
        cJRHorizontalListView.setPadding(i2, i2, i2, i2);
        this.u.setDividerWidth(this.y);
        this.y = this.x / 2;
        this.V = (Button) findViewById(R.id.btn_search);
        this.V.setVisibility(8);
        this.V.setOnClickListener(this);
        ((RelativeLayout) findViewById(R.id.lyt_close_filter)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PassbookSearchActivity.a(PassbookSearchActivity.this);
            }
        });
        this.I = new ArrayList<>();
        this.U = new ArrayList<>();
        this.t = (CustomToggleButton) findViewById(R.id.btn_toggle_paytm_cashback);
        this.J = new f();
        this.J.f58477f = R.id.btn_toggle_paytm_cashback;
        this.J.f58472a = getString(R.string.paytm_cashback);
        this.t.setText(getString(R.string.paytm_cashback));
        f fVar = this.J;
        fVar.f58473b = "transaction";
        fVar.f58476e.add(new Integer("7"));
        f fVar2 = this.J;
        fVar2.f58475d = false;
        this.I.add(fVar2);
        this.t.setOnCheckedChangeListener(this.Z);
        this.A = (CustomToggleButton) findViewById(R.id.btn_toggle_paytm_sent_to_bank);
        this.K = new f();
        this.K.f58477f = R.id.btn_toggle_paytm_sent_to_bank;
        this.K.f58472a = getString(R.string.sent_to_bank);
        this.A.setText(getString(R.string.sent_to_bank));
        f fVar3 = this.K;
        fVar3.f58473b = "transaction";
        fVar3.f58476e.add(new Integer("29"));
        f fVar4 = this.K;
        fVar4.f58475d = false;
        this.I.add(fVar4);
        this.A.setOnCheckedChangeListener(this.Z);
        this.B = (CustomToggleButton) findViewById(R.id.btn_toggle_refund);
        this.B.setOnCheckedChangeListener(this.Z);
        this.L = new f();
        this.L.f58477f = R.id.btn_toggle_refund;
        this.L.f58472a = getString(R.string.refund);
        this.B.setText(getString(R.string.refund));
        f fVar5 = this.L;
        fVar5.f58473b = "transaction";
        fVar5.f58476e.add(new Integer("2"));
        this.L.f58476e.add(new Integer("3"));
        f fVar6 = this.L;
        fVar6.f58475d = false;
        this.I.add(fVar6);
        this.C = (CustomToggleButton) findViewById(R.id.btn_toggle_paytm_cash_sent);
        this.C.setOnCheckedChangeListener(this.Z);
        this.M = new f();
        this.M.f58477f = R.id.btn_toggle_paytm_cash_sent;
        this.M.f58472a = getString(R.string.paytm_cash_sent);
        this.C.setText(getString(R.string.paytm_cash_sent));
        f fVar7 = this.M;
        fVar7.f58473b = "transaction";
        fVar7.f58476e.add(new Integer("5"));
        f fVar8 = this.M;
        fVar8.f58475d = false;
        this.I.add(fVar8);
        this.D = (CustomToggleButton) findViewById(R.id.btn_toggle_paytm_paid_for_order);
        this.D.setOnCheckedChangeListener(this.Z);
        this.N = new f();
        this.N.f58477f = R.id.btn_toggle_paytm_paid_for_order;
        this.N.f58472a = getString(R.string.paid_for_orders);
        this.D.setText(getString(R.string.paid_for_orders));
        f fVar9 = this.N;
        fVar9.f58473b = "transaction";
        fVar9.f58476e.add(new Integer("1"));
        f fVar10 = this.N;
        fVar10.f58475d = false;
        this.I.add(fVar10);
        this.E = (CustomToggleButton) findViewById(R.id.btn_toggle_paytm_cash_received);
        this.E.setOnCheckedChangeListener(this.Z);
        this.O = new f();
        this.O.f58477f = R.id.btn_toggle_paytm_cash_received;
        this.O.f58472a = getString(R.string.paytm_cash_received);
        this.E.setText(getString(R.string.paytm_cash_received));
        f fVar11 = this.O;
        fVar11.f58473b = "transaction";
        fVar11.f58476e.add(new Integer("100"));
        f fVar12 = this.O;
        fVar12.f58475d = false;
        this.I.add(fVar12);
        this.P = (CustomToggleButton) findViewById(R.id.btn_toggle_money_added);
        this.P.setOnCheckedChangeListener(this.Z);
        this.Q = new f();
        this.Q.f58477f = R.id.btn_toggle_money_added;
        this.Q.f58472a = getString(R.string.money_added);
        this.P.setText(getString(R.string.money_added));
        f fVar13 = this.Q;
        fVar13.f58473b = "transaction";
        fVar13.f58476e.add(new Integer("4"));
        this.Q.f58476e.add(new Integer("20"));
        this.Q.f58476e.add(new Integer("36"));
        f fVar14 = this.Q;
        fVar14.f58475d = false;
        this.I.add(fVar14);
        this.F = (CustomToggleButton) findViewById(R.id.btn_toggle_failed);
        this.F.setOnCheckedChangeListener(this.Z);
        this.R = new f();
        this.R.f58477f = R.id.btn_toggle_failed;
        this.R.f58472a = getString(R.string.failed_transaction);
        this.F.setText(getString(R.string.failed_transaction));
        f fVar15 = this.R;
        fVar15.f58473b = "status";
        fVar15.f58474c = "FAILURE";
        fVar15.f58475d = false;
        this.I.add(fVar15);
        this.G = (CustomToggleButton) findViewById(R.id.btn_toggle_paytm_pending);
        this.G.setOnCheckedChangeListener(this.Z);
        this.S = new f();
        this.S.f58477f = R.id.btn_toggle_paytm_pending;
        this.S.f58472a = getString(R.string.pending);
        this.G.setText(getString(R.string.pending));
        f fVar16 = this.S;
        fVar16.f58473b = "status";
        fVar16.f58474c = "PENDING";
        fVar16.f58475d = false;
        this.I.add(fVar16);
        this.H = (CustomToggleButton) findViewById(R.id.btn_toggle_paytm_succesful);
        this.H.setOnCheckedChangeListener(this.Z);
        this.T = new f();
        this.T.f58477f = R.id.btn_toggle_paytm_succesful;
        this.T.f58472a = getString(R.string.successfull);
        this.H.setText(getString(R.string.successfull));
        f fVar17 = this.T;
        fVar17.f58473b = "status";
        fVar17.f58474c = "SUCCESS";
        fVar17.f58475d = false;
        this.I.add(fVar17);
        if (this.U.size() == 0) {
            this.v.setVisibility(8);
        } else {
            this.v.setVisibility(0);
        }
        this.z = new a(this, this.U, new b() {
            public final void a(f fVar) {
                ((CustomToggleButton) PassbookSearchActivity.this.findViewById(fVar.f58477f)).setChecked(false);
                PassbookSearchActivity.this.U.remove(fVar);
                PassbookSearchActivity.this.w.setVisibility(8);
                if (PassbookSearchActivity.this.U.size() == 0) {
                    PassbookSearchActivity.this.v.setVisibility(8);
                } else {
                    PassbookSearchActivity.this.v.setVisibility(0);
                }
                PassbookSearchActivity.this.z.a((ArrayList<f>) PassbookSearchActivity.this.U);
                if (PassbookSearchActivity.this.f58318e.getVisibility() == 0) {
                    PassbookSearchActivity passbookSearchActivity = PassbookSearchActivity.this;
                    passbookSearchActivity.f58316c = false;
                    passbookSearchActivity.f58315b = 0;
                    if (passbookSearchActivity.U.size() > 0) {
                        PassbookSearchActivity passbookSearchActivity2 = PassbookSearchActivity.this;
                        passbookSearchActivity2.d(passbookSearchActivity2.ac.getQuery().toString());
                        return;
                    }
                    PassbookSearchActivity.this.W.setVisibility(0);
                    PassbookSearchActivity.this.f58318e.setVisibility(8);
                }
            }
        });
        this.u.setAdapter((ListAdapter) this.z);
        if (!isFinishing()) {
            ViewPager viewPager = this.f58318e;
            j supportFragmentManager = getSupportFragmentManager();
            net.one97.paytm.passbook.mapping.g.a();
            viewPager.setAdapter(new c(supportFragmentManager, net.one97.paytm.passbook.mapping.g.a(getResources().getStringArray(R.array.passbook_search_tabs))));
        }
        this.f58318e.setVisibility(8);
        if (this.U.size() > 0) {
            this.v.setVisibility(0);
        }
        this.s.setVisibility(0);
        this.q.setVisibility(8);
        SearchView searchView = this.ac;
        if (searchView != null) {
            searchView.setIconified(false);
            this.ac.clearFocus();
        }
        if (intent.hasExtra("title")) {
            setTitle(getIntent().getStringExtra("title"));
        } else {
            setTitle(getString(R.string.top_menu_passbook));
        }
        this.Y = intent.getIntExtra("sub_wallet_type", -1);
    }

    public void onStart() {
        super.onStart();
        d.b().s();
        d.b();
    }

    public void onStop() {
        d.b().r();
        super.onStop();
    }

    private void j() {
        try {
            this.f58321h = d.b().a("checkBalance");
            if (this.f58321h == null) {
                return;
            }
            if (URLUtil.isValidUrl(this.f58321h)) {
                this.f58321h = b.e((Context) this, this.f58321h);
                HashMap hashMap = new HashMap();
                hashMap.put("ssotoken", a.q(this));
                hashMap.put("Accept-Encoding", "gzip");
                new StringBuilder("SSO Token :: ").append(a.q(this));
                b.j();
                if (b.c((Context) this)) {
                    getApplicationContext();
                    net.one97.paytm.passbook.mapping.a.c.a();
                    net.one97.paytm.passbook.mapping.a.c.b(new net.one97.paytm.passbook.mapping.a.b(this.f58321h, this, this, new CJRCashWallet(), hashMap, (String) null, a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, PassbookSearchActivity.class.getName()));
                }
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(LinkedHashMap linkedHashMap) {
        m.a(getApplicationContext()).a("passbook_offline", new f().a((Object) linkedHashMap, new com.google.gson.b.a<LinkedHashMap<String, ArrayList<CJRTransaction>>>() {
        }.getType()), true);
    }

    private LinkedHashMap k() {
        return (LinkedHashMap) new f().a(m.a(getApplicationContext()).b("passbook_offline", "", true), new com.google.gson.b.a<LinkedHashMap<String, ArrayList<CJRTransaction>>>() {
        }.getType());
    }

    private void a(CJRLedger cJRLedger, final boolean z2) {
        final ArrayList<CJRTransaction> transactionList = cJRLedger.getTransactionList();
        if (transactionList != null) {
            boolean z3 = false;
            if (transactionList.size() > 0 || this.f58315b > 0) {
                this.w.setVisibility(8);
            } else {
                this.w.setVisibility(0);
            }
            if (transactionList.size() > 0) {
                z3 = true;
            }
            this.X = z3;
            this.f58315b += 100;
            new StringBuilder("onResponse() :: CJRLedger").append(transactionList.size());
            b.j();
            Thread thread = new Thread(new Runnable() {
                public final void run() {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it2 = transactionList.iterator();
                    while (it2.hasNext()) {
                        CJRTransaction cJRTransaction = (CJRTransaction) it2.next();
                        String txnType = cJRTransaction.getTxnType();
                        if (txnType.equalsIgnoreCase("CR")) {
                            if (cJRTransaction.getNarration().contains("Added ")) {
                                arrayList3.add(cJRTransaction);
                            } else {
                                arrayList2.add(cJRTransaction);
                            }
                        } else if (txnType.equalsIgnoreCase("DR")) {
                            arrayList.add(cJRTransaction);
                        }
                    }
                    if (!z2) {
                        PassbookSearchActivity passbookSearchActivity = PassbookSearchActivity.this;
                        if (passbookSearchActivity.f58314a != null) {
                            passbookSearchActivity.f58314a.clear();
                            passbookSearchActivity.a((LinkedHashMap) passbookSearchActivity.f58314a);
                        }
                    }
                    PassbookSearchActivity.this.a("DR", (ArrayList<CJRTransaction>) arrayList);
                    PassbookSearchActivity.this.a("CR", (ArrayList<CJRTransaction>) arrayList2);
                    PassbookSearchActivity.this.a("CR_added", (ArrayList<CJRTransaction>) arrayList3);
                    PassbookSearchActivity.this.a(StringSet.all, (ArrayList<CJRTransaction>) transactionList);
                    if (PassbookSearchActivity.this.f58322i != null) {
                        Iterator it3 = PassbookSearchActivity.this.f58322i.iterator();
                        while (it3.hasNext()) {
                            ((h) it3.next()).a();
                        }
                    }
                }
            });
            if (this.j == null) {
                this.j = Executors.newFixedThreadPool(1);
            }
            this.j.submit(thread);
        }
    }

    public final void a(String str, ArrayList<CJRTransaction> arrayList) {
        if (!isFinishing()) {
            if (this.f58314a == null) {
                this.f58314a = new LinkedHashMap<>();
            }
            ArrayList arrayList2 = this.f58314a.get(str);
            if (arrayList2 != null) {
                arrayList.addAll(0, arrayList2);
            }
            this.f58314a.put(str, arrayList);
            a((LinkedHashMap) this.f58314a);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn_search) {
            this.f58315b = 0;
            d(this.ac.getQuery().toString());
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            if (this.f58318e.getVisibility() == 0) {
                if (this.U.size() > 0) {
                    this.v.setVisibility(0);
                }
                this.W.setVisibility(0);
                this.f58318e.setVisibility(8);
                this.w.setVisibility(8);
            } else {
                onBackPressed();
            }
            return true;
        } else if (itemId == R.id.action_passbook_search) {
            return true;
        } else {
            return super.onOptionsItemSelected(menuItem);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f58318e = null;
        this.f58314a = null;
        this.f58322i = null;
        this.j = null;
        System.gc();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 3 && i3 == -1) {
            this.f58315b = 0;
            d();
            j();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(java.lang.String r15) {
        /*
            r14 = this;
            java.lang.Class<net.one97.paytm.passbook.search.PassbookSearchActivity> r0 = net.one97.paytm.passbook.search.PassbookSearchActivity.class
            java.lang.String r1 = ""
            g((java.lang.String) r15)
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat
            java.lang.String r5 = "yyyy-MM-dd HH:mm:ss"
            r4.<init>(r5)
            java.util.Calendar r5 = java.util.Calendar.getInstance()
            java.lang.String r6 = "lastLimit"
            r7 = 30
            r3.put(r6, r7)     // Catch:{ JSONException -> 0x00ba }
            java.lang.String r6 = "startLimit"
            int r7 = r14.f58315b     // Catch:{ JSONException -> 0x00ba }
            r3.put(r6, r7)     // Catch:{ JSONException -> 0x00ba }
            java.lang.String r6 = "payerName"
            r3.put(r6, r1)     // Catch:{ JSONException -> 0x00ba }
            java.lang.String r6 = "payeeName"
            r3.put(r6, r1)     // Catch:{ JSONException -> 0x00ba }
            org.json.JSONArray r6 = r14.m()     // Catch:{ JSONException -> 0x00ba }
            java.lang.String r7 = "txnType"
            if (r6 == 0) goto L_0x0043
            org.json.JSONArray r6 = r14.m()     // Catch:{ JSONException -> 0x00ba }
            r3.put(r7, r6)     // Catch:{ JSONException -> 0x00ba }
        L_0x0043:
            boolean r6 = android.text.TextUtils.isEmpty(r15)     // Catch:{ JSONException -> 0x00ba }
            java.lang.String r8 = "all"
            if (r6 != 0) goto L_0x0066
            org.json.JSONArray r6 = r14.e((java.lang.String) r15)     // Catch:{ JSONException -> 0x00ba }
            if (r6 == 0) goto L_0x0066
            org.json.JSONArray r6 = r14.e((java.lang.String) r15)     // Catch:{ JSONException -> 0x00ba }
            int r6 = r6.length()     // Catch:{ JSONException -> 0x00ba }
            if (r6 <= 0) goto L_0x0066
            org.json.JSONArray r15 = r14.e((java.lang.String) r15)     // Catch:{ JSONException -> 0x00ba }
            r3.put(r7, r15)     // Catch:{ JSONException -> 0x00ba }
            r3.put(r8, r1)     // Catch:{ JSONException -> 0x00ba }
            goto L_0x009b
        L_0x0066:
            org.json.JSONArray r6 = r14.f((java.lang.String) r15)     // Catch:{ JSONException -> 0x00ba }
            java.lang.String r7 = "txnMessage"
            if (r6 == 0) goto L_0x0080
            org.json.JSONArray r6 = r14.f((java.lang.String) r15)     // Catch:{ JSONException -> 0x00ba }
            int r6 = r6.length()     // Catch:{ JSONException -> 0x00ba }
            if (r6 <= 0) goto L_0x0080
            org.json.JSONArray r15 = r14.f((java.lang.String) r15)     // Catch:{ JSONException -> 0x00ba }
            r3.put(r7, r15)     // Catch:{ JSONException -> 0x00ba }
            goto L_0x009b
        L_0x0080:
            org.json.JSONArray r6 = r14.l()     // Catch:{ JSONException -> 0x00ba }
            if (r6 == 0) goto L_0x0098
            org.json.JSONArray r6 = r14.l()     // Catch:{ JSONException -> 0x00ba }
            int r6 = r6.length()     // Catch:{ JSONException -> 0x00ba }
            if (r6 <= 0) goto L_0x0098
            org.json.JSONArray r15 = r14.l()     // Catch:{ JSONException -> 0x00ba }
            r3.put(r7, r15)     // Catch:{ JSONException -> 0x00ba }
            goto L_0x009b
        L_0x0098:
            r3.put(r8, r15)     // Catch:{ JSONException -> 0x00ba }
        L_0x009b:
            java.lang.String r15 = "From"
            java.lang.String r6 = "2014-01-01 00:00:00"
            r3.put(r15, r6)     // Catch:{ JSONException -> 0x00ba }
            java.lang.String r15 = "to"
            java.util.Date r5 = r5.getTime()     // Catch:{ JSONException -> 0x00ba }
            java.lang.String r4 = r4.format(r5)     // Catch:{ JSONException -> 0x00ba }
            r3.put(r15, r4)     // Catch:{ JSONException -> 0x00ba }
            java.lang.String r15 = "accountNumber"
            r3.put(r15, r1)     // Catch:{ JSONException -> 0x00ba }
            java.lang.String r15 = "request"
            r2.put(r15, r3)     // Catch:{ JSONException -> 0x00ba }
            goto L_0x00bb
        L_0x00ba:
        L_0x00bb:
            net.one97.paytm.passbook.mapping.f r15 = net.one97.paytm.passbook.d.b()
            java.lang.String r1 = "PaytmCashLedgerSearchAPI"
            java.lang.String r4 = r15.a((java.lang.String) r1)
            if (r4 == 0) goto L_0x0165
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.lang.String r15 = "Content-Type"
            java.lang.String r1 = "application/json"
            r8.put(r15, r1)
            java.lang.String r15 = com.paytm.utility.a.q(r14)
            java.lang.String r1 = "ssotoken"
            r8.put(r1, r15)
            java.lang.String r15 = "Accept-Encoding"
            java.lang.String r1 = "gzip"
            r8.put(r15, r1)
            boolean r15 = com.paytm.utility.b.c((android.content.Context) r14)
            if (r15 == 0) goto L_0x0147
            java.lang.String r15 = java.lang.String.valueOf(r4)
            java.lang.String r1 = "loadLedgerList() URL :: "
            r1.concat(r15)
            com.paytm.utility.b.j()
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r1 = "loadLedgerList() json :: "
            r15.<init>(r1)
            java.lang.String r3 = r2.toString()
            r15.append(r3)
            com.paytm.utility.b.j()
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r1)
            java.lang.String r1 = r8.toString()
            r15.append(r1)
            com.paytm.utility.b.j()
            android.content.res.Resources r15 = r14.getResources()
            int r1 = net.one97.paytm.passbook.R.string.please_wait_progress_msg
            java.lang.String r15 = r15.getString(r1)
            r14.a((android.content.Context) r14, (java.lang.String) r15)
            r14.getApplicationContext()
            net.one97.paytm.passbook.mapping.a.c.a()
            net.one97.paytm.passbook.mapping.a.b r15 = new net.one97.paytm.passbook.mapping.a.b
            net.one97.paytm.passbook.beans.CJRLedger r7 = new net.one97.paytm.passbook.beans.CJRLedger
            r7.<init>()
            java.lang.String r9 = r2.toString()
            com.paytm.network.a$a r10 = com.paytm.network.a.C0715a.POST
            com.paytm.network.a$c r11 = com.paytm.network.a.c.PASSBOOK
            com.paytm.network.a$b r12 = com.paytm.network.a.b.SILENT
            java.lang.String r13 = r0.getName()
            r3 = r15
            r5 = r14
            r6 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            net.one97.paytm.passbook.mapping.a.c.b(r15)
            return
        L_0x0147:
            net.one97.paytm.passbook.mapping.a.b r15 = new net.one97.paytm.passbook.mapping.a.b
            net.one97.paytm.passbook.beans.CJRLedger r7 = new net.one97.paytm.passbook.beans.CJRLedger
            r7.<init>()
            java.lang.String r9 = r2.toString()
            com.paytm.network.a$a r10 = com.paytm.network.a.C0715a.POST
            com.paytm.network.a$c r11 = com.paytm.network.a.c.PASSBOOK
            com.paytm.network.a$b r12 = com.paytm.network.a.b.SILENT
            java.lang.String r13 = r0.getName()
            r3 = r15
            r5 = r14
            r6 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r14.a((net.one97.paytm.passbook.mapping.a.b) r15)
        L_0x0165:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.search.PassbookSearchActivity.d(java.lang.String):void");
    }

    private JSONArray l() {
        ArrayList arrayList = new ArrayList();
        Iterator<f> it2 = this.U.iterator();
        while (it2.hasNext()) {
            f next = it2.next();
            if (next.f58473b.equals("status")) {
                arrayList.add(next.f58474c);
            }
        }
        try {
            return new JSONArray(new f().b(arrayList));
        } catch (JSONException unused) {
            return null;
        }
    }

    private JSONArray m() {
        ArrayList arrayList = new ArrayList();
        Iterator<f> it2 = this.U.iterator();
        while (it2.hasNext()) {
            f next = it2.next();
            if (next.f58473b.equals("transaction")) {
                Iterator<Integer> it3 = next.f58476e.iterator();
                while (it3.hasNext()) {
                    arrayList.add(it3.next());
                }
            }
        }
        try {
            return new JSONArray(new f().b(arrayList));
        } catch (JSONException unused) {
            return null;
        }
    }

    private JSONArray e(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<f> it2 = this.I.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            f next = it2.next();
            if (next.f58472a.equalsIgnoreCase(str)) {
                Iterator<Integer> it3 = next.f58476e.iterator();
                while (it3.hasNext()) {
                    arrayList.add(it3.next());
                }
            }
        }
        try {
            return new JSONArray(new f().b(arrayList));
        } catch (JSONException unused) {
            return null;
        }
    }

    private JSONArray f(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<f> it2 = this.I.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            f next = it2.next();
            if (next.f58472a.equalsIgnoreCase(str)) {
                arrayList.add(next.f58474c);
                break;
            }
        }
        try {
            return new JSONArray(new f().b(arrayList));
        } catch (JSONException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final void a() {
        try {
            if (this.k != null && this.k.isShowing()) {
                this.k.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    public void onBackPressed() {
        boolean z2;
        ArrayList<h> arrayList = this.f58322i;
        boolean z3 = true;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<h> it2 = this.f58322i.iterator();
            loop0:
            while (true) {
                z2 = false;
                while (true) {
                    if (!it2.hasNext()) {
                        break loop0;
                    } else if (it2.next().b() || z2) {
                        z2 = true;
                    }
                }
            }
        } else {
            z2 = false;
        }
        if (this.f58318e.getVisibility() == 0) {
            if (this.U.size() > 0) {
                this.v.setVisibility(0);
            }
            this.W.setVisibility(0);
            this.f58318e.setVisibility(8);
            this.w.setVisibility(8);
        } else {
            z3 = z2;
        }
        if (!z3) {
            super.onBackPressed();
        }
    }

    private static void g(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/net/one97/paytm/passbook");
            hashMap.put("wallet_passbook_search_keyword", str);
        } catch (Exception unused) {
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pass_passbookmenu, menu);
        this.aa = menu.findItem(R.id.action_passbook_search);
        this.ac = (SearchView) this.aa.getActionView();
        this.ac.setQueryHint(getResources().getString(R.string.search));
        MenuItem menuItem = this.aa;
        if (menuItem != null) {
            menuItem.setShowAsAction(2);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public final void a(final net.one97.paytm.passbook.mapping.a.b bVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                if (b.c((Context) PassbookSearchActivity.this)) {
                    PassbookSearchActivity.this.getApplicationContext();
                    net.one97.paytm.passbook.mapping.a.c.a();
                    net.one97.paytm.passbook.mapping.a.c.b(bVar);
                    return;
                }
                PassbookSearchActivity.this.a(bVar);
            }
        });
        builder.show();
    }

    public final void h() {
        ProgressDialog progressDialog = this.f58317d;
        if (progressDialog != null && progressDialog.isShowing() && !isFinishing()) {
            this.f58317d.dismiss();
            this.f58317d = null;
        }
    }

    private void n() {
        if (!isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            String string = getResources().getString(R.string.title_401_410);
            builder.setTitle(string).setMessage(getResources().getString(R.string.message_401_410)).setCancelable(false);
            builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    PassbookSearchActivity.F(PassbookSearchActivity.this);
                }
            });
            builder.show();
        }
    }

    private void a(Context context, String str) {
        ProgressDialog progressDialog = this.f58317d;
        if (progressDialog == null || !progressDialog.isShowing()) {
            this.f58317d = new ProgressDialog(context);
            try {
                this.f58317d.setProgressStyle(0);
                this.f58317d.setMessage(str);
                this.f58317d.setCancelable(false);
                this.f58317d.setCanceledOnTouchOutside(false);
                this.f58317d.show();
            } catch (Exception | IllegalArgumentException unused) {
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.af.setText(charSequence);
    }

    public final ArrayList<CJRTransaction> c(String str) {
        LinkedHashMap<String, ArrayList<CJRTransaction>> linkedHashMap = this.f58314a;
        if (linkedHashMap != null) {
            return linkedHashMap.get(str);
        }
        if (b.c((Context) this)) {
            return null;
        }
        if (this.r == null) {
            this.r = k();
        }
        LinkedHashMap linkedHashMap2 = this.r;
        if (linkedHashMap2 != null) {
            return (ArrayList) linkedHashMap2.get(str);
        }
        return null;
    }

    public final String a(String str, String str2, String str3) {
        try {
            return new SimpleDateFormat(str2).format(new SimpleDateFormat(str, Locale.ENGLISH).parse(str3));
        } catch (Exception unused) {
            return "";
        }
    }

    public final void d() {
        String e2;
        ArrayList arrayList;
        Class<PassbookSearchActivity> cls = PassbookSearchActivity.class;
        this.q.setVisibility(0);
        this.p.setVisibility(8);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("userGuid", "");
            jSONObject2.put("startLimit", this.f58315b);
            jSONObject2.put("lastLimit", 100);
            jSONObject.put("request", jSONObject2);
        } catch (JSONException unused) {
        }
        String a2 = d.b().a("PaytmCashLedger");
        if (a2 != null && (e2 = b.e((Context) this, a2)) != null && URLUtil.isValidUrl(e2)) {
            "----->URL :: ".concat(String.valueOf(e2));
            b.j();
            new StringBuilder("----->JSON :: ").append(jSONObject.toString());
            b.j();
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("ssotoken", com.paytm.utility.a.q(this));
            hashMap.put("Accept-Encoding", "gzip");
            if (b.c((Context) this)) {
                new StringBuilder("loadPassbookEntries() json :: ").append(jSONObject.toString());
                b.j();
                getApplicationContext();
                net.one97.paytm.passbook.mapping.a.c.a();
                net.one97.paytm.passbook.mapping.a.c.b(new net.one97.paytm.passbook.mapping.a.b(e2, this, this, new CJRLedger(), hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, cls.getName()));
                return;
            }
            this.r = k();
            LinkedHashMap linkedHashMap = this.r;
            if (linkedHashMap != null) {
                arrayList = (ArrayList) linkedHashMap.get(StringSet.all);
            } else {
                arrayList = new ArrayList();
            }
            if (arrayList.size() > 0) {
                ArrayList<h> arrayList2 = this.f58322i;
                if (arrayList2 != null) {
                    Iterator<h> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        it2.next().a();
                    }
                    return;
                }
                return;
            }
            a(new net.one97.paytm.passbook.mapping.a.b(e2, this, this, new CJRLedger(), hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, cls.getName()));
        }
    }

    public final void a(String str, JSONObject jSONObject) {
        this.f58320g = str;
        this.f58319f = jSONObject;
        this.n = true;
        try {
            if (this.k == null) {
                this.k = c.f(this);
            }
            if (this.k != null && !this.k.isShowing()) {
                this.k.show();
            }
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(m.a(getApplicationContext()).b("sso_token=", "", true))) {
            d.b().a((Activity) this, (com.paytm.network.listener.b) new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    PassbookSearchActivity.this.o();
                    PassbookSearchActivity.this.a();
                    PassbookSearchActivity.this.h();
                    PassbookSearchActivity passbookSearchActivity = PassbookSearchActivity.this;
                    PassbookSearchActivity.a(passbookSearchActivity, (CJRPGTokenList) iJRPaytmDataModel, passbookSearchActivity.f58320g, PassbookSearchActivity.this.f58319f);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    PassbookSearchActivity.this.onErrorResponse(i2, iJRPaytmDataModel, networkCustomError);
                }
            }, a.c.PASSBOOK);
            return;
        }
        h();
        n();
    }

    public final void a(h hVar) {
        this.f58322i.add(hVar);
    }

    public final void b(h hVar) {
        this.f58322i.remove(hVar);
    }

    public final void e() {
        if (this.X) {
            d(this.ac.getQuery().toString());
        }
    }

    public final void f() {
        this.f58316c = true;
    }

    public final void b(String str) {
        try {
            new HashMap();
            getApplicationContext();
        } catch (Exception unused) {
        }
        new net.one97.paytm.passbook.subWallet.b.b(this, str, new net.one97.paytm.passbook.subWallet.a() {
            public final void a(String str) {
                d.b().b(str);
            }
        }).show();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o() {
        /*
            r3 = this;
            androidx.appcompat.widget.SearchView r0 = r3.ac     // Catch:{ Exception -> 0x001f }
            if (r0 == 0) goto L_0x0009
            androidx.appcompat.widget.SearchView r0 = r3.ac     // Catch:{ Exception -> 0x001f }
            r0.clearFocus()     // Catch:{ Exception -> 0x001f }
        L_0x0009:
            java.lang.String r0 = "input_method"
            java.lang.Object r0 = r3.getSystemService(r0)     // Catch:{  }
            android.view.inputmethod.InputMethodManager r0 = (android.view.inputmethod.InputMethodManager) r0     // Catch:{  }
            if (r0 == 0) goto L_0x001f
            android.view.View r1 = r3.getCurrentFocus()     // Catch:{  }
            android.os.IBinder r1 = r1.getWindowToken()     // Catch:{  }
            r2 = 0
            r0.hideSoftInputFromWindow(r1, r2)     // Catch:{  }
        L_0x001f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.search.PassbookSearchActivity.o():void");
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        h();
        PassbookSearchActivity.class.getSimpleName();
        net.one97.paytm.passbook.utility.j.a((Activity) this, (Throwable) networkCustomError);
    }

    public boolean onPrepareOptionsMenu(final Menu menu) {
        this.ac.setQueryHint(getString(R.string.search_hint_passbook));
        this.ac.setQuery("", false);
        this.ac.setOnQueryTextListener(new SearchView.b() {
            public final boolean b(String str) {
                return false;
            }

            public final boolean a(String str) {
                PassbookSearchActivity.this.ac.clearFocus();
                Menu menu = menu;
                if (menu != null) {
                    menu.findItem(R.id.action_passbook_search).collapseActionView();
                    PassbookSearchActivity.this.ac.setIconifiedByDefault(true);
                    PassbookSearchActivity.this.ac.setIconified(true);
                    PassbookSearchActivity.this.ac.setQuery(str, false);
                }
                PassbookSearchActivity passbookSearchActivity = PassbookSearchActivity.this;
                passbookSearchActivity.f58315b = 0;
                passbookSearchActivity.d(str);
                return true;
            }
        });
        return super.onPrepareOptionsMenu(menu);
    }

    public final void b() {
        this.f58315b = 0;
        d();
        j();
    }

    static /* synthetic */ void a(PassbookSearchActivity passbookSearchActivity) {
        passbookSearchActivity.t.setChecked(false);
        passbookSearchActivity.t.setText(passbookSearchActivity.getString(R.string.paytm_cashback));
        passbookSearchActivity.A.setChecked(false);
        passbookSearchActivity.A.setText(passbookSearchActivity.getString(R.string.sent_to_bank));
        passbookSearchActivity.B.setChecked(false);
        passbookSearchActivity.B.setText(passbookSearchActivity.getString(R.string.refund));
        passbookSearchActivity.C.setChecked(false);
        passbookSearchActivity.C.setText(passbookSearchActivity.getString(R.string.paytm_cash_sent));
        passbookSearchActivity.D.setChecked(false);
        passbookSearchActivity.D.setText(passbookSearchActivity.getString(R.string.paid_for_orders));
        passbookSearchActivity.E.setChecked(false);
        passbookSearchActivity.E.setText(passbookSearchActivity.getString(R.string.paytm_cash_received));
        passbookSearchActivity.P.setChecked(false);
        passbookSearchActivity.P.setText(passbookSearchActivity.getString(R.string.money_added));
        passbookSearchActivity.F.setChecked(false);
        passbookSearchActivity.F.setText(passbookSearchActivity.getString(R.string.failed_transaction));
        passbookSearchActivity.G.setChecked(false);
        passbookSearchActivity.G.setText(passbookSearchActivity.getString(R.string.pending));
        passbookSearchActivity.H.setChecked(false);
        passbookSearchActivity.H.setText(passbookSearchActivity.getString(R.string.successfull));
        passbookSearchActivity.w.setVisibility(8);
        passbookSearchActivity.X = false;
        if (passbookSearchActivity.f58318e.getVisibility() != 0) {
            return;
        }
        if (passbookSearchActivity.ac.getQuery().toString().length() <= 0) {
            passbookSearchActivity.W.setVisibility(0);
            passbookSearchActivity.f58318e.setVisibility(8);
            return;
        }
        passbookSearchActivity.f58315b = 0;
        passbookSearchActivity.d(passbookSearchActivity.ac.getQuery().toString());
    }

    static /* synthetic */ void a(PassbookSearchActivity passbookSearchActivity, String str) {
        String str2;
        String str3;
        int i2 = passbookSearchActivity.Y;
        if (i2 != -1) {
            String str4 = null;
            if (i2 == n.TOLL.getValue()) {
                str4 = "fastag_wallet_passbook_search_transaction_filter_clicked";
                str3 = "fastag_wallet_passbook_search_by_keyword_clicked";
                str2 = "/passbook/fastag-wallet/search";
            } else {
                str3 = null;
                str2 = null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            q.a(passbookSearchActivity, str4, str3, arrayList, str2);
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("new_wallet_screen_type", "net/one97/paytm/passbook");
            hashMap.put("new_wallet_passbook_filter_name", str);
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void F(PassbookSearchActivity passbookSearchActivity) {
        try {
            if (b.c((Context) passbookSearchActivity)) {
                d.b().a((Activity) passbookSearchActivity, passbookSearchActivity.getClass().getName(), true, false);
            }
        } catch (Exception unused) {
        }
        Intent intent = new Intent(passbookSearchActivity, d.b().u());
        intent.putExtra("parent_activity", d.b().g());
        intent.putExtra("authError", true);
        intent.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
        passbookSearchActivity.startActivityForResult(intent, 3);
    }

    static /* synthetic */ void a(PassbookSearchActivity passbookSearchActivity, CJRPGTokenList cJRPGTokenList, String str, JSONObject jSONObject) {
        String str2;
        boolean z2;
        PassbookSearchActivity passbookSearchActivity2 = passbookSearchActivity;
        Class<PassbookSearchActivity> cls = PassbookSearchActivity.class;
        ArrayList<CJRPGToken> pGTokenList = cJRPGTokenList.getPGTokenList();
        if (pGTokenList == null) {
            str2 = null;
        } else {
            int size = pGTokenList.size();
            long j2 = 0;
            int i2 = 0;
            String str3 = null;
            while (true) {
                if (i2 >= size) {
                    str2 = null;
                    break;
                }
                CJRPGToken cJRPGToken = pGTokenList.get(i2);
                String[] split = cJRPGToken.getScopes().split(AppConstants.COMMA);
                int length = split.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        if (!TextUtils.isEmpty(split[i3]) && split[i3].equalsIgnoreCase("wallet")) {
                            z2 = true;
                            break;
                        }
                        i3++;
                    } else {
                        z2 = false;
                        break;
                    }
                }
                if (z2) {
                    str2 = cJRPGToken.getToken();
                    j2 = cJRPGToken.getExpires();
                    break;
                }
                if (str3 == null) {
                    str3 = cJRPGToken.getResourceOwnerId();
                }
                i2++;
            }
            m.a(d.b().b()).a("wallet_token_expire=", j2, true);
            m.a(d.b().b()).a("wallet_sso_token=", str2, true);
            m.a(d.b().b()).a("resource_owner_id", str3, true);
        }
        "walletSSOToken :: ".concat(String.valueOf(str2));
        b.j();
        if (TextUtils.isEmpty(str2)) {
            passbookSearchActivity.n();
        } else if (passbookSearchActivity2.n) {
            passbookSearchActivity2.n = false;
            String e2 = b.e((Context) passbookSearchActivity2, str);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("ssotoken", str2);
            hashMap.put("Accept-Encoding", "gzip");
            String jSONObject2 = jSONObject != null ? jSONObject.toString() : null;
            "----> URL ::".concat(String.valueOf(e2));
            b.j();
            "----> JSON ::".concat(String.valueOf(jSONObject2));
            b.j();
            if (!URLUtil.isValidUrl(e2)) {
                return;
            }
            if (b.c((Context) passbookSearchActivity)) {
                net.one97.paytm.passbook.mapping.a.c.a();
                net.one97.paytm.passbook.mapping.a.c.b(new net.one97.paytm.passbook.mapping.a.b(e2, passbookSearchActivity, passbookSearchActivity, new CJRLedgerResponse(), hashMap, jSONObject2, a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, cls.getName()));
                return;
            }
            passbookSearchActivity2.a(new net.one97.paytm.passbook.mapping.a.b(e2, passbookSearchActivity, passbookSearchActivity, new CJRLedgerResponse(), hashMap, jSONObject2, a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, cls.getName()));
        }
    }
}
