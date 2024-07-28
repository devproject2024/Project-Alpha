package net.one97.paytm.addmoney.togv.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.paytmmall.clpartifact.widgets.blueprints.IWidgetProvider;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import net.one97.paytm.addmoney.AddMoneyBaseToolbarActivity;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.j;
import net.one97.paytm.addmoney.togv.b.b;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.addmoney.utils.d;
import net.one97.paytm.addmoney.utils.l;
import net.one97.paytm.helper.a;
import net.one97.paytm.newaddmoney.view.e;
import net.one97.paytm.upi.util.CustomWalletLoaderDialog;
import net.one97.paytm.upi.util.UpiConstants;

public class AddMoneyToGvSelfStatusActivity extends AddMoneyBaseToolbarActivity implements View.OnClickListener, b.C0857b {
    private TextView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private TextView G;
    private ConstraintLayout H;
    private TextView I;
    private TextView J;
    private FrameLayout K;
    private TextView L;
    private TextView M;
    private TextView N;
    private FrameLayout O;
    private String P;
    private TextView Q;
    private HashMap<String, View> R = new HashMap<>();
    private CustomWalletLoaderDialog S;
    private b.a T;
    private String U;
    private String V;
    private String W;
    private TextView X;
    private boolean Y;
    private boolean Z = false;
    private LinearLayout aa;
    private TextView ab;
    private String ac;
    private boolean ad = false;
    private ImageView ae;
    private String af = "";

    /* renamed from: c  reason: collision with root package name */
    public SFWidget f48774c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f48775d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f48776e;

    /* renamed from: f  reason: collision with root package name */
    private NestedScrollView f48777f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f48778g;

    /* renamed from: h  reason: collision with root package name */
    private TableRow f48779h;

    /* renamed from: i  reason: collision with root package name */
    private TableRow f48780i;
    private TableRow j;
    private ConstraintLayout k;
    private ConstraintLayout l;
    private ConstraintLayout m;
    private ConstraintLayout n;
    private ConstraintLayout o;
    private ImageView p;
    private ImageView q;
    private ConstraintLayout r;
    private View s;
    private TextView t;
    private ImageView u;
    private ImageView v;
    private TextView w;
    private Group x;
    private TextView y;
    private TextView z;

    public final void a(NetworkCustomError networkCustomError) {
    }

    public final int a() {
        return R.layout.uam_activity_gv_self_status;
    }

    public final int b() {
        return f48004a;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null && getIntent().hasExtra("source")) {
            this.af = getIntent().getStringExtra("source");
        }
        this.f48777f = (NestedScrollView) findViewById(R.id.sv_content);
        this.ae = (ImageView) findViewById(R.id.cross_iv);
        this.f48775d = (TextView) findViewById(R.id.tv_gv_amount);
        this.f48776e = (TextView) findViewById(R.id.tv_gv_amount_in_words);
        this.f48778g = (TextView) findViewById(R.id.tv_gv_balance_title);
        this.f48778g.setText(getString(R.string.uam_gv_balance, new Object[]{a.b().l(), "---"}));
        this.l = (ConstraintLayout) findViewById(R.id.cl_success_banner_large);
        this.o = (ConstraintLayout) findViewById(R.id.cl_failed_txn_detail_container);
        this.H = (ConstraintLayout) findViewById(R.id.i_gv_orderId_dateTime);
        this.k = (ConstraintLayout) findViewById(R.id.cl_toolbar);
        this.m = (ConstraintLayout) findViewById(R.id.cl_success_txn_detail_container);
        this.n = (ConstraintLayout) findViewById(R.id.cl_pending_txn_detail_container);
        this.p = (ImageView) findViewById(R.id.iv_back_arrow);
        this.q = (ImageView) findViewById(R.id.iv_share_header);
        this.r = (ConstraintLayout) findViewById(R.id.i_gv_success_banner);
        this.s = findViewById(R.id.activation_layout);
        this.t = (TextView) findViewById(R.id.tv_gv_status_msg_banner);
        this.u = (ImageView) findViewById(R.id.iv_gv_status_drawable);
        this.v = (ImageView) findViewById(R.id.iv_gv_share);
        this.w = (TextView) findViewById(R.id.tv_gv_view_detail_banner);
        this.x = (Group) findViewById(R.id.g_gv_pending_failure);
        this.y = (TextView) findViewById(R.id.tv_gv_notify);
        this.z = (TextView) findViewById(R.id.tv_gv_detail_view_amount);
        this.A = (TextView) findViewById(R.id.tv_gv_detail_view_amount_in_words);
        this.B = (TextView) findViewById(R.id.tv_gv_added_from_pay_instrument);
        this.C = (TextView) findViewById(R.id.tv_gv_transaction_id);
        this.D = (TextView) findViewById(R.id.tv_gv_pending_amount);
        this.E = (TextView) findViewById(R.id.tv_gv_failure_title);
        this.G = (TextView) findViewById(R.id.tv_gv_failure_subtitle);
        this.F = (TextView) findViewById(R.id.tv_gv_failure_button_title);
        this.I = (TextView) findViewById(R.id.tv_gv_order_id);
        this.f48779h = (TableRow) findViewById(R.id.tr_gv_view_passbook);
        this.X = (TextView) findViewById(R.id.tv_buy_another);
        this.X.setText(getString(R.string.make_payment));
        this.f48780i = (TableRow) findViewById(R.id.tr_buy_gv);
        this.j = (TableRow) findViewById(R.id.tr_need_help);
        this.K = (FrameLayout) findViewById(R.id.i_gv_payment_status);
        this.J = (TextView) findViewById(R.id.tv_gv_date_time);
        this.L = (TextView) findViewById(R.id.tv_gv_status_msg_success);
        this.M = (TextView) findViewById(R.id.tv_gv_added_from_title);
        this.N = (TextView) findViewById(R.id.tv_gv_pay_mode);
        this.O = (FrameLayout) findViewById(R.id.fl_gv_deals);
        this.aa = (LinearLayout) findViewById(R.id.cashBackContainerLl);
        this.ab = (TextView) findViewById(R.id.tv_gv_to_);
        this.Q = (TextView) findViewById(R.id.tv_gv_status_msg_pending);
        findViewById(R.id.activate_wallet).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AddMoneyToGvSelfStatusActivity.this.a(view);
            }
        });
        if (getIntent().hasExtra("isCallbackRequired")) {
            this.ad = getIntent().getBooleanExtra("isCallbackRequired", false);
        }
        this.f48780i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.f48779h.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.ae.setOnClickListener(this);
        this.U = getIntent().getStringExtra("order_id");
        this.V = getIntent().getStringExtra("merchant_id");
        this.Z = getIntent().getBooleanExtra("do_check_order_status_by_polling", false);
        this.T = new net.one97.paytm.addmoney.togv.d.b(this, j.a(getApplicationContext(), (Activity) this), this.U, this.V, this.Z);
        this.T.a();
        this.P = a.b().l();
    }

    public void onDestroy() {
        super.onDestroy();
        this.T.b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(SanitizedResponseModel sanitizedResponseModel) {
        LinkedHashMap<Integer, IWidgetProvider> sfWidgets = ((SanitizedResponseModel) Objects.requireNonNull(sanitizedResponseModel)).getSfWidgets();
        this.f48774c = sfWidgets.get(104).getWidget(this, sanitizedResponseModel.getGaListener());
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.lyt_bottom_tab_bar);
        SFWidget sFWidget = this.f48774c;
        if (sFWidget instanceof IStaticWidget) {
            frameLayout.addView(((IStaticWidget) sFWidget).getView());
        }
        List<com.paytmmall.clpartifact.modal.clpCommon.View> rvWidgets = sanitizedResponseModel.getRvWidgets();
        StoreFrontGAHandler gaListener = sanitizedResponseModel.getGaListener();
        e eVar = e.f55944a;
        e.a(getSupportFragmentManager(), findViewById(R.id.fl_sf_sdk), rvWidgets, "add_money_post_transaction_screen", gaListener);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(View view, NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
        if (i3 > i5) {
            view.setVisibility(8);
        }
        if (i3 < i5) {
            view.setVisibility(0);
        }
    }

    private void d() {
        if (!this.ad) {
            net.one97.paytm.newaddmoney.utils.e.a(this, a.b().a("gv_home_url", "https://storefront.paytm.com/v2/h/post-txn-page-new"), new net.one97.paytm.helper.b() {
                public final void onWidgetLoaded(SanitizedResponseModel sanitizedResponseModel) {
                    AddMoneyToGvSelfStatusActivity.this.a(sanitizedResponseModel);
                }
            }, "add_money_post_transaction_screen");
            View findViewById = findViewById(R.id.lyt_bottom_tab_bar);
            NestedScrollView nestedScrollView = this.f48777f;
            if (nestedScrollView != null) {
                nestedScrollView.setOnScrollChangeListener(new NestedScrollView.b(findViewById) {
                    private final /* synthetic */ View f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
                        AddMoneyToGvSelfStatusActivity.a(this.f$0, nestedScrollView, i2, i3, i4, i5);
                    }
                });
                return;
            }
            return;
        }
        View findViewById2 = findViewById(R.id.stub);
        findViewById2.setBackground(androidx.core.content.b.a((Context) this, R.drawable.elevation_effect_background));
        Button button = (Button) findViewById2.findViewById(R.id.btn_done);
        button.setVisibility(0);
        if (getIntent().hasExtra("done_button_text")) {
            button.setText(getIntent().getStringExtra("done_button_text"));
        }
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AddMoneyToGvSelfStatusActivity.this.b(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        e();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x003a, code lost:
        if (r2.equals("") == false) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e() {
        /*
            r6 = this;
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            java.lang.String r1 = r6.ac
            java.lang.String r2 = "addmoney_status"
            r0.putExtra(r2, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r2 = net.one97.paytm.addmoney.R.string.add_paytm_balance_new
            java.lang.String r2 = r6.getString(r2)
            r1.append(r2)
            java.lang.String r2 = " ₹ "
            r1.append(r2)
            android.content.Context r2 = r6.getApplicationContext()
            if (r2 == 0) goto L_0x003d
            android.content.Context r2 = r2.getApplicationContext()
            com.paytm.b.a.a r2 = net.one97.paytm.addmoney.utils.h.a(r2)
            r3 = 0
            java.lang.String r4 = ""
            java.lang.String r5 = "pref_new_balance_wallet_Gv"
            java.lang.String r2 = r2.b((java.lang.String) r5, (java.lang.String) r4, (boolean) r3)
            boolean r3 = r2.equals(r4)
            if (r3 != 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r2 = 0
        L_0x003e:
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "wallet_balance"
            r0.putExtra(r2, r1)
            r1 = -1
            r6.setResult(r1, r0)
            r6.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.addmoney.togv.view.AddMoneyToGvSelfStatusActivity.e():void");
    }

    public void onClick(View view) {
        int id = view.getId();
        int i2 = 0;
        if (id == R.id.tv_gv_order_id) {
            d.a((Context) this, "gift_voucher", "payconfirm_orderid_clicked ", "/gift-voucher/order-confirmation", (ArrayList<String>) new ArrayList(Arrays.asList(new String[]{"", "", "", this.af})), (String) null);
            Intent b2 = a.b().b((FragmentActivity) this);
            b2.putExtra("order_id", this.U);
            b2.putExtra(UpiConstants.FROM, "Order_history");
            startActivity(b2);
            finish();
        } else if (id == R.id.tr_buy_gv) {
            a.b().a((Context) this, "paytmmp://cash_wallet?featuretype=scanner", (Bundle) null);
        } else if (id == R.id.tr_gv_balance) {
            d.a((Context) this, "gift_voucher", "payconfirm_balance_clicked ", "/gift-voucher/order-confirmation", (ArrayList<String>) new ArrayList(Arrays.asList(new String[]{"", "", "", this.af})), (String) null);
            Bundle bundle = new Bundle();
            bundle.putInt("sub_wallet_type", 12);
            bundle.putString("display_name", getString(R.string.uam_gv_gift_vouchere));
            a.b().a((Context) this, "paytmmp://cash_wallet?featuretype=cash_ledger&tab=gift_voucher", bundle);
            finish();
        } else if (id == R.id.tr_need_help) {
            a.b().a((FragmentActivity) this, (Bundle) null);
            finish();
        } else if (id == R.id.tr_gv_view_passbook) {
            a.b().a((Context) this, "paytmmp://cash_wallet?featuretype=cash_ledger&tab=gift_voucher", (Bundle) null);
            finish();
        } else if (id == R.id.tv_gv_view_detail_banner) {
            g();
        } else if (id == R.id.iv_gv_share || id == R.id.iv_share_header) {
            if (Build.VERSION.SDK_INT < 23 || !s.a() || checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                if (!this.Y) {
                    g();
                    i2 = 100;
                }
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        try {
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.setType("image/png");
                            intent.putExtra("android.intent.extra.SUBJECT", a.b().l());
                            intent.putExtra("android.intent.extra.TEXT", AddMoneyToGvSelfStatusActivity.this.getString(R.string.uam_gv_share_body_self));
                            AddMoneyToGvSelfStatusActivity addMoneyToGvSelfStatusActivity = AddMoneyToGvSelfStatusActivity.this;
                            View findViewById = AddMoneyToGvSelfStatusActivity.this.findViewById(R.id.ll_share_details_gp);
                            findViewById.setBackgroundColor(androidx.core.content.b.c(addMoneyToGvSelfStatusActivity, R.color.white));
                            Bitmap createBitmap = Bitmap.createBitmap(findViewById.getWidth(), findViewById.getHeight(), Bitmap.Config.ARGB_8888);
                            findViewById.draw(new Canvas(createBitmap));
                            intent.putExtra("android.intent.extra.STREAM", AddMoneyUtils.a((Context) AddMoneyToGvSelfStatusActivity.this, createBitmap));
                            Intent createChooser = Intent.createChooser(intent, AddMoneyToGvSelfStatusActivity.this.getString(R.string.uam_gv_share));
                            if (createChooser.resolveActivity(AddMoneyToGvSelfStatusActivity.this.getPackageManager()) != null) {
                                AddMoneyToGvSelfStatusActivity.this.startActivity(createChooser);
                            } else {
                                Toast.makeText(AddMoneyToGvSelfStatusActivity.this, AddMoneyToGvSelfStatusActivity.this.getString(R.string.no_app_found), 1).show();
                            }
                        } catch (IOException e2) {
                            if (com.paytm.utility.b.v) {
                                e2.printStackTrace();
                            }
                        } catch (Exception e3) {
                            if (com.paytm.utility.b.v) {
                                e3.printStackTrace();
                            }
                        }
                    }
                }, (long) i2);
                return;
            }
            s.b((Activity) this);
            Toast.makeText(this, getString(R.string.permission_not_granted), 0).show();
        } else if (id == R.id.iv_back_arrow) {
            onBackPressed();
        } else if (id == R.id.cross_iv) {
            startActivity(new Intent(this, AddMoneyToGVActivity.class));
            finish();
        }
    }

    public final void a(boolean z2) {
        if (z2) {
            this.f48777f.setVisibility(8);
        } else {
            this.f48777f.setVisibility(0);
        }
        try {
            if (this.S == null) {
                this.S = new CustomWalletLoaderDialog(this);
            }
            if (z2) {
                this.S.setTitle(getString(R.string.uam_gv_fetching_order_status));
                this.S.showLoader();
                return;
            }
            this.S.dismissLoader();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(String str, double d2, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{net.one97.paytm.newaddmoney.utils.e.a(this), "Gv", "", this.af}));
        d.a((Context) this, "add_money", "add_money_success", "add_money_post_payment_screen", (ArrayList<String>) arrayList, "");
        a(str, d2, str2, str3, str6, str7, str8, "");
        a.b().a(getSupportFragmentManager(), R.id.fl_gv_deals);
        if (!TextUtils.isEmpty(str8)) {
            this.aa.setVisibility(0);
            a.b().a(this.f48774c, (Context) this, getSupportFragmentManager(), str2, "16", net.one97.paytm.utils.b.a.GIFT_VOUCHER, "");
        } else {
            this.aa.setVisibility(8);
        }
        f();
        d();
        this.ac = "SUCCESS";
    }

    public final void a(double d2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{net.one97.paytm.newaddmoney.utils.e.a(this), "Gv", "", this.af}));
        d.a((Context) this, "add_money", "add_money_failed", "add_money_post_payment_screen", (ArrayList<String>) arrayList, "");
        a("", d2, str, str2, str5, str6, str7, "");
        this.k.setVisibility(8);
        this.K.setVisibility(0);
        this.n.setVisibility(8);
        this.m.setVisibility(8);
        this.r.setVisibility(0);
        this.o.setVisibility(0);
        this.x.setVisibility(8);
        this.l.setBackgroundColor(getResources().getColor(R.color.color_fd5c5c));
        this.t.setText(getResources().getString(R.string.uam_gv_purchase_fail, new Object[]{this.P}));
        this.u.setImageResource(R.drawable.uam_gv_ic_failed_white);
        this.H.setVisibility(0);
        this.y.setVisibility(8);
        this.O.setVisibility(8);
        this.aa.setVisibility(8);
        if (!TextUtils.isEmpty(str8)) {
            this.E.setText(str8);
        } else {
            this.E.setVisibility(8);
        }
        d();
        this.ac = "FAILURE";
    }

    public final void b(double d2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{net.one97.paytm.newaddmoney.utils.e.a(this), "Gv", "", this.af}));
        d.a((Context) this, "add_money", "add_money_pending", "add_money_post_payment_screen", (ArrayList<String>) arrayList, "");
        a("", d2, str, str2, str5, str6, str7, "");
        this.r.setVisibility(0);
        this.l.setBackgroundColor(getResources().getColor(R.color.color_ffa400));
        this.t.setText(getResources().getString(R.string.uam_gv_purchase_pending_text, new Object[]{this.P}));
        this.u.setImageResource(R.drawable.uam_gv_pending_white);
        this.k.setVisibility(8);
        this.K.setVisibility(8);
        this.H.setVisibility(0);
        this.x.setVisibility(8);
        this.y.setVisibility(0);
        this.o.setVisibility(8);
        this.O.setVisibility(8);
        this.aa.setVisibility(8);
        if (!TextUtils.isEmpty(str8)) {
            this.y.setText(str8);
        } else {
            this.y.setText(getString(R.string.uam_gv_we_will_notify));
        }
        d();
        this.ac = "PENDING";
    }

    public final void a(double d2, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        a("", d2, str, str2, str5, str6, str7, "");
        this.r.setVisibility(8);
        this.k.setVisibility(0);
        this.K.setVisibility(0);
        this.m.setVisibility(8);
        this.n.setVisibility(0);
        this.o.setVisibility(8);
        this.H.setVisibility(0);
        this.x.setVisibility(8);
        this.y.setVisibility(8);
        this.O.setVisibility(8);
        this.aa.setVisibility(8);
        this.q.setVisibility(8);
        this.Q.setText(getString(R.string.uam_gv_purchase_pending_text, new Object[]{this.P}));
        d();
        this.ac = "PENDING";
    }

    public final void a(double d2) {
        if (Double.compare(d2, -1.0d) == 0) {
            TextView textView = this.f48776e;
            textView.setText(getString(R.string.add_paytm_balance_new) + " ₹ --.--");
            TextView textView2 = this.A;
            textView2.setText(getString(R.string.add_paytm_balance_new) + " ₹ --.--");
            return;
        }
        String b2 = com.paytm.utility.b.b(Double.valueOf(d2));
        TextView textView3 = this.f48776e;
        textView3.setText(getString(R.string.add_paytm_balance_new) + " ₹" + b2);
        TextView textView4 = this.A;
        textView4.setText(getString(R.string.add_paytm_balance_new) + " ₹" + b2);
    }

    public final String c() {
        return getString(R.string.fullfillment_failure_text);
    }

    private void f() {
        this.l.setBackgroundColor(getResources().getColor(R.color.color_21c17a));
        this.u.setImageResource(R.drawable.add_money_ic_success);
        this.t.setText(getResources().getString(R.string.uam_gv_success, new Object[]{this.P}));
        this.r.setVisibility(0);
        this.x.setVisibility(0);
        this.y.setVisibility(8);
        this.K.setVisibility(8);
        this.k.setVisibility(8);
        this.H.setVisibility(8);
        this.O.setVisibility(0);
        this.aa.setVisibility(0);
        this.Y = false;
        if (net.one97.paytm.newaddmoney.utils.e.a()) {
            this.s.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        d.a((Context) this, "add_money", "add_money_min_kyc_selected", "add_money_post_payment_screen", (ArrayList<String>) new ArrayList(Arrays.asList(new String[]{net.one97.paytm.newaddmoney.utils.e.a(this), "GV", "", this.af})), "");
        a.b().a((Context) this, "paytmmp://min_kyc?featuretype=popup");
        d.a((Context) this, "add_money", "add_money_wallet_activate", "/add-money", (ArrayList<String>) new ArrayList(Arrays.asList(new String[]{net.one97.paytm.newaddmoney.utils.e.a(this), "", "", this.af})), "");
    }

    private void g() {
        this.r.setVisibility(8);
        this.s.setVisibility(8);
        this.y.setVisibility(8);
        this.K.setVisibility(0);
        this.m.setVisibility(0);
        this.n.setVisibility(8);
        this.o.setVisibility(8);
        this.k.setVisibility(0);
        this.H.setVisibility(0);
        this.Y = true;
        this.O.setVisibility(0);
        this.aa.setVisibility(8);
        this.q.setVisibility(0);
        this.L.setText(getString(R.string.uam_gv_success, new Object[]{this.P}));
    }

    private void a(String str, double d2, String str2, String str3, String str4, String str5, String str6, String str7) {
        String str8;
        this.W = str5;
        this.f48775d.setText(getString(R.string.uam_gv_amount, new Object[]{com.paytm.utility.b.b(Double.valueOf(d2))}));
        this.z.setText(getString(R.string.uam_gv_amount, new Object[]{com.paytm.utility.b.b(Double.valueOf(d2))}));
        this.D.setText(getString(R.string.uam_gv_amount, new Object[]{com.paytm.utility.b.b(Double.valueOf(d2))}));
        String a2 = l.a(String.valueOf(d2));
        if (d2 <= 1.0d) {
            str8 = getString(R.string.rupee_only, new Object[]{a2});
        } else {
            str8 = getString(R.string.rupees_only, new Object[]{a2});
        }
        this.f48776e.setText(str8);
        if (!TextUtils.isEmpty(str2)) {
            this.I.setText(getString(R.string.uam_gv_order_id, new Object[]{str2}));
        }
        if (!TextUtils.isEmpty(str3)) {
            this.J.setText(str3);
        }
        if ("LOYALTY_POINT".equalsIgnoreCase(str5)) {
            this.B.setVisibility(0);
            this.B.setText(getString(R.string.uam_gv_paytm_first_points));
        } else if (!TextUtils.isEmpty(str4)) {
            if (str4.equalsIgnoreCase("ppbl")) {
                str4 = getString(R.string.paytm_payment_bank);
            }
            this.B.setVisibility(0);
            this.B.setText(str4);
        } else {
            this.B.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str6)) {
            this.C.setVisibility(0);
            this.C.setText(getString(R.string.uam_gv_transaction_id, new Object[]{str6}));
        } else {
            this.C.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str5)) {
            str5 = AddMoneyUtils.a((Context) this, str5);
        }
        String str9 = "";
        if (TextUtils.isEmpty(str4)) {
            str4 = str9;
        }
        if (!TextUtils.isEmpty(str5)) {
            str9 = str5;
        }
        if (!TextUtils.isEmpty(str9.trim())) {
            this.N.setVisibility(0);
            if ("LOYALTY_POINT".equalsIgnoreCase(str9.trim())) {
                this.N.setText(getString(R.string.uam_gv_points_redeemed, new Object[]{str}));
            } else {
                this.N.setText(getString(R.string.uam_gv_payment_mode, new Object[]{str9}));
            }
        } else {
            this.N.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str4) || !TextUtils.isEmpty(str9) || !TextUtils.isEmpty(str6)) {
            this.M.setVisibility(0);
        } else {
            this.M.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str7)) {
            this.E.setText(str7);
        }
    }

    public void onBackPressed() {
        if (this.Y) {
            f();
        } else if (this.ad) {
            e();
        } else {
            finish();
        }
    }
}
