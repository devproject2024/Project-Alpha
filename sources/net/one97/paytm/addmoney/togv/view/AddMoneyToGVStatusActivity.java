package net.one97.paytm.addmoney.togv.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
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
import net.one97.paytm.addmoney.utils.k;
import net.one97.paytm.addmoney.utils.l;
import net.one97.paytm.helper.a;
import net.one97.paytm.newaddmoney.utils.e;
import net.one97.paytm.upi.util.UpiConstants;

public class AddMoneyToGVStatusActivity extends AddMoneyBaseToolbarActivity implements View.OnClickListener, b.C0857b {
    private TextView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private Group E;
    private ConstraintLayout F;
    private TextView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private TextView L;
    private TableRow M;
    private TableRow N;
    private View O;
    private TableRow P;
    private View Q;
    private TextView R;
    private TextView S;
    private TextView T;
    private TextView U;
    private TextView V;
    private ImageView W;
    private HashMap<String, View> X = new HashMap<>();
    private k Y;
    private b.a Z;
    private String aa;
    private String ab;
    private String ac;
    private String ad;
    private boolean ae = false;
    private boolean af;
    private LinearLayout ag;
    private LinearLayout ah;
    private ConstraintLayout ai;
    private TextView aj;

    /* renamed from: c  reason: collision with root package name */
    public SFWidget f48765c;

    /* renamed from: d  reason: collision with root package name */
    private NestedScrollView f48766d;

    /* renamed from: e  reason: collision with root package name */
    private ConstraintLayout f48767e;

    /* renamed from: f  reason: collision with root package name */
    private ConstraintLayout f48768f;

    /* renamed from: g  reason: collision with root package name */
    private ConstraintLayout f48769g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f48770h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f48771i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private ImageView n;
    private TextView o;
    private LinearLayout p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private ConstraintLayout u;
    private ConstraintLayout v;
    private ConstraintLayout w;
    private ConstraintLayout x;
    private ImageView y;
    private ImageView z;

    public final void a(NetworkCustomError networkCustomError) {
    }

    public final int a() {
        return R.layout.uam_activity_gv_status;
    }

    public final int b() {
        return f48004a;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ac = a.b().l();
        this.f48766d = (NestedScrollView) findViewById(R.id.sv_gv_content);
        this.W = (ImageView) findViewById(R.id.cross_iv);
        this.f48767e = (ConstraintLayout) findViewById(R.id.cl_gv_success_txn_detail_container);
        this.f48768f = (ConstraintLayout) findViewById(R.id.i_gv_gift_card);
        this.f48770h = (ImageView) findViewById(R.id.iv_gv_back_button);
        this.f48771i = (ImageView) findViewById(R.id.iv_gv_share_header);
        this.j = (TextView) findViewById(R.id.tv_gv_recipient_name);
        this.k = (TextView) findViewById(R.id.tv_gv_card_amount);
        this.l = (TextView) findViewById(R.id.tv_gv_card_gift_message);
        this.m = (TextView) findViewById(R.id.tv_gv_sender_name);
        this.n = (ImageView) findViewById(R.id.iv_gv_btn_collapse);
        this.o = (TextView) findViewById(R.id.tv_gv_view_detail);
        this.p = (LinearLayout) findViewById(R.id.ll_gv_details);
        this.q = (TextView) findViewById(R.id.tv_gv_sent_from_bank);
        this.r = (TextView) findViewById(R.id.tv_gv_sent_from);
        this.s = (TextView) findViewById(R.id.tv_gv_sent_from_pay_instrument);
        this.t = (TextView) findViewById(R.id.tv_gv_transaction_id);
        this.f48769g = (ConstraintLayout) findViewById(R.id.i_gv_id_date_time);
        this.J = (TextView) findViewById(R.id.tv_gv_order_id);
        this.K = (TextView) findViewById(R.id.tv_gv_date_time);
        this.u = (ConstraintLayout) findViewById(R.id.cl_gv_failure_pending_txn_details);
        this.v = (ConstraintLayout) findViewById(R.id.cl_success_banner_large);
        this.y = (ImageView) findViewById(R.id.iv_gv_status_drawable);
        this.z = (ImageView) findViewById(R.id.iv_gv_share);
        this.A = (TextView) findViewById(R.id.tv_gv_amount);
        this.B = (TextView) findViewById(R.id.tv_gv_amount_in_words);
        this.C = (TextView) findViewById(R.id.tv_gv_status_msg_banner);
        this.D = (TextView) findViewById(R.id.tv_gv_notify);
        this.E = (Group) findViewById(R.id.g_gv_pending_failure);
        this.F = (ConstraintLayout) findViewById(R.id.cl_gv_failed_txn_detail_container);
        this.G = (TextView) findViewById(R.id.tv_gv_failure_title);
        this.H = (TextView) findViewById(R.id.tv_gv_failure_button_title);
        this.I = (TextView) findViewById(R.id.tv_gv_failure_subtitle);
        this.L = (TextView) findViewById(R.id.tv_buy_another);
        this.L.setText(getString(R.string.uam_buy_gv, new Object[]{this.ac}));
        this.M = (TableRow) findViewById(R.id.tr_buy_gv);
        this.N = (TableRow) findViewById(R.id.tr_gv_view_passbook);
        this.O = findViewById(R.id.v_gv_balance_divider);
        this.P = (TableRow) findViewById(R.id.tr_need_help);
        this.Q = findViewById(R.id.v_gv_purchase_divider);
        this.R = (TextView) findViewById(R.id.tv_gv_balance_title);
        this.R.setText(getString(R.string.uam_gv_balance, new Object[]{this.ac, "---"}));
        this.S = (TextView) findViewById(R.id.tv_gv_order_id_details);
        this.T = (TextView) findViewById(R.id.tv_gv_date_time_details);
        this.w = (ConstraintLayout) findViewById(R.id.cl_gv_success_gift_card);
        this.x = (ConstraintLayout) findViewById(R.id.cl_fullfillment_pending_txn_detail_container);
        this.U = (TextView) findViewById(R.id.tv_gv_pending_amount);
        this.ag = (LinearLayout) findViewById(R.id.cashBackContainerLl);
        this.ah = (LinearLayout) findViewById(R.id.ll_gv_btn_view_detail);
        this.ai = (ConstraintLayout) findViewById(R.id.cl_gv_toolbar);
        this.V = (TextView) findViewById(R.id.tv_gv_status_msg_success);
        this.aj = (TextView) findViewById(R.id.tv_gv_status_msg_pending);
        this.W.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AddMoneyToGVStatusActivity.this.a(view);
            }
        });
        e.a(this, a.b().a("gv_home_url", "https://storefront.paytm.com/v2/h/post-txn-page-new"), new net.one97.paytm.helper.b() {
            public final void onWidgetLoaded(SanitizedResponseModel sanitizedResponseModel) {
                AddMoneyToGVStatusActivity.this.a(sanitizedResponseModel);
            }
        }, "add_money_post_transaction_screen");
        final View findViewById = findViewById(R.id.lyt_bottom_tab_bar);
        NestedScrollView nestedScrollView = this.f48766d;
        if (nestedScrollView != null) {
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.b() {
                public final void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
                    if (i3 > i5) {
                        findViewById.setVisibility(8);
                    } else if (i3 < i5) {
                        findViewById.setVisibility(0);
                    }
                }
            });
        }
        this.n.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.f48770h.setOnClickListener(this);
        this.f48771i.setOnClickListener(this);
        this.ah.setOnClickListener(this);
        this.aa = getIntent().getStringExtra("order_id");
        this.ab = getIntent().getStringExtra("merchant_id");
        this.af = getIntent().getBooleanExtra("do_check_order_status_by_polling", false);
        this.Z = new net.one97.paytm.addmoney.togv.d.b(this, j.a(getApplicationContext(), (Activity) this), this.aa, this.ab, this.af);
        this.Z.a();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        startActivity(new Intent(this, AddMoneyToGVActivity.class));
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(SanitizedResponseModel sanitizedResponseModel) {
        LinkedHashMap<Integer, IWidgetProvider> sfWidgets = ((SanitizedResponseModel) Objects.requireNonNull(sanitizedResponseModel)).getSfWidgets();
        this.f48765c = ((IWidgetProvider) Objects.requireNonNull(sfWidgets.get(104))).getWidget(this, sanitizedResponseModel.getGaListener());
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.lyt_bottom_tab_bar);
        SFWidget sFWidget = this.f48765c;
        if (sFWidget instanceof IStaticWidget) {
            frameLayout.addView(((IStaticWidget) sFWidget).getView());
        }
        List<com.paytmmall.clpartifact.modal.clpCommon.View> rvWidgets = sanitizedResponseModel.getRvWidgets();
        StoreFrontGAHandler gaListener = sanitizedResponseModel.getGaListener();
        net.one97.paytm.newaddmoney.view.e eVar = net.one97.paytm.newaddmoney.view.e.f55944a;
        net.one97.paytm.newaddmoney.view.e.a(getSupportFragmentManager(), findViewById(R.id.fl_sf_sdk), rvWidgets, "add_money_post_transaction_screen", gaListener);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_gv_share_header || id == R.id.iv_gv_share) {
            d();
        } else if (id == R.id.tv_gv_order_id) {
            d.a((Context) this, "gift_voucher", "payconfirm_orderid_clicked ", "/gift-voucher/order-confirmation", (String) null, (String) null);
            Intent b2 = a.b().b((FragmentActivity) this);
            b2.putExtra("order_id", this.aa);
            b2.putExtra(UpiConstants.FROM, "Order_history");
            startActivity(b2);
            finish();
        } else if (id == R.id.tr_buy_gv) {
            d.a((Context) this, "gift_voucher", "payconfirm_buygv_clicked ", "/gift-voucher/order-confirmation", (String) null, (String) null);
            if ("LOYALTY_POINT".equalsIgnoreCase(this.ad)) {
                a.b().a((Context) this, "paytmmp://redeemcoins");
                return;
            }
            startActivity(new Intent(this, AddMoneyToGVActivity.class));
            finish();
        } else if (id == R.id.tr_gv_balance) {
            d.a((Context) this, "gift_voucher", "payconfirm_balance_clicked ", "/gift-voucher/order-confirmation", (String) null, (String) null);
            Bundle bundle = new Bundle();
            bundle.putInt("sub_wallet_type", 12);
            bundle.putString("display_name", getString(R.string.uam_gv_gift_vouchere));
            a.b().a((Context) this, "paytmmp://cash_wallet?featuretype=cash_ledger&tab=gift_voucher", bundle);
            finish();
        } else if (id == R.id.tr_need_help) {
            a.b().a((FragmentActivity) this, (Bundle) null);
        } else if (id == R.id.iv_gv_btn_collapse || id == R.id.ll_gv_btn_view_detail) {
            if (this.ae) {
                this.p.setVisibility(8);
                this.T.setVisibility(8);
                this.S.setVisibility(8);
                this.n.setImageResource(R.drawable.ic_gv_collapse_down);
                this.o.setText(getString(R.string.uam_gv_view_details));
            } else {
                this.p.setVisibility(0);
                this.T.setVisibility(0);
                this.S.setVisibility(0);
                this.n.setImageResource(R.drawable.ic_gv_collapse_up);
                this.o.setText(getString(R.string.uam_gv_hide_details));
            }
            this.ae = !this.ae;
        } else if (id == R.id.tr_gv_view_passbook) {
            a.b().a((Context) this, "paytmmp://cash_wallet?featuretype=cash_ledger&tab=gift_voucher", (Bundle) null);
            finish();
        } else if (id == R.id.iv_gv_back_button) {
            onBackPressed();
        }
    }

    public void onBackPressed() {
        if (this.ae) {
            super.onBackPressed();
        } else {
            finish();
        }
    }

    private void d() {
        if (Build.VERSION.SDK_INT < 23 || !s.a() || androidx.core.content.b.a((Context) this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            try {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("image/*");
                intent.putExtra("android.intent.extra.SUBJECT", this.ac);
                intent.putExtra("android.intent.extra.TEXT", getString(R.string.uam_gv_share_body_gifting));
                intent.putExtra("android.intent.extra.STREAM", AddMoneyUtils.a((Context) this, a((ViewGroup) findViewById(R.id.cl_gv_card))));
                Intent createChooser = Intent.createChooser(intent, getString(R.string.uam_gv_share_title, new Object[]{this.ac}));
                if (createChooser.resolveActivity(getPackageManager()) != null) {
                    startActivity(createChooser);
                } else {
                    Toast.makeText(this, getString(R.string.uam_gv_no_app_found), 1).show();
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
        } else {
            s.b((Activity) this);
        }
    }

    private static Bitmap a(ViewGroup viewGroup) {
        Bitmap createBitmap = Bitmap.createBitmap(viewGroup.getWidth(), viewGroup.getHeight(), Bitmap.Config.ARGB_8888);
        viewGroup.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 != 56) {
            return;
        }
        if (s.a(iArr)) {
            d();
        } else {
            Toast.makeText(this, "Permission denied", 0).show();
        }
    }

    public final void a(boolean z2) {
        if (z2) {
            this.f48766d.setVisibility(8);
        } else {
            this.f48766d.setVisibility(0);
        }
        try {
            if (this.Y == null) {
                this.Y = new k(this);
            }
            if (z2) {
                this.Y.f48991a = getString(R.string.uam_gv_fetching_order_status);
                this.Y.a();
                return;
            }
            this.Y.b();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(String str, double d2, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        b(str, d2, str2, str3, str6, str7, str8, str4, str5);
        a.b().a(getSupportFragmentManager(), R.id.fl_gv_deals);
        if (!TextUtils.isEmpty(str8)) {
            a.b().a(this.f48765c, (Context) this, getSupportFragmentManager(), str2, "16", net.one97.paytm.utils.b.a.GIFT_VOUCHER, "");
        }
        this.f48767e.setVisibility(0);
        this.w.setVisibility(0);
        this.x.setVisibility(8);
        this.u.setVisibility(8);
        this.f48769g.setVisibility(8);
        this.F.setVisibility(8);
        this.p.setVisibility(8);
        this.T.setVisibility(8);
        this.S.setVisibility(8);
        this.f48771i.setVisibility(0);
        this.ai.setVisibility(0);
        this.V.setText(getString(R.string.uam_gv_sent_success_gift, new Object[]{this.ac}));
    }

    public final void a(double d2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        b("", d2, str, str2, str5, str6, str7, str3, str4);
        this.f48767e.setVisibility(8);
        this.u.setVisibility(0);
        this.F.setVisibility(0);
        this.C.setText(getResources().getString(R.string.uam_gv_purchase_fail, new Object[]{this.ac}));
        this.y.setImageResource(R.drawable.uam_gv_ic_failed_white);
        this.v.setBackgroundColor(getResources().getColor(R.color.order_failure_color));
        this.E.setVisibility(8);
        this.D.setVisibility(8);
        this.f48769g.setVisibility(0);
        this.f48771i.setVisibility(8);
        this.ai.setVisibility(8);
        this.I.setVisibility(8);
        this.H.setVisibility(8);
        if (!TextUtils.isEmpty(str8)) {
            this.G.setText(str8);
        } else {
            this.G.setVisibility(8);
        }
    }

    public final void b(double d2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        b("", d2, str, str2, str5, str6, str7, str3, str4);
        String string = getString(R.string.uam_gv_notify_pending_text, new Object[]{str3});
        this.f48767e.setVisibility(8);
        this.u.setVisibility(0);
        this.F.setVisibility(8);
        this.C.setText(getResources().getString(R.string.uam_gv_purchase_pending_text, new Object[]{this.ac}));
        this.y.setImageResource(R.drawable.uam_gv_pending_white);
        this.v.setBackgroundColor(getResources().getColor(R.color.order_pending_color));
        this.E.setVisibility(8);
        this.f48769g.setVisibility(0);
        this.f48771i.setVisibility(8);
        this.ai.setVisibility(8);
        if (!TextUtils.isEmpty(str8)) {
            this.D.setText(str8);
        } else {
            this.D.setText(string);
        }
    }

    public final void a(double d2, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        b("", d2, str, str2, str5, str6, str7, str3, str4);
        this.f48767e.setVisibility(0);
        this.w.setVisibility(8);
        this.x.setVisibility(0);
        this.u.setVisibility(8);
        this.f48769g.setVisibility(0);
        this.F.setVisibility(8);
        this.p.setVisibility(8);
        this.T.setVisibility(8);
        this.S.setVisibility(8);
        this.f48771i.setVisibility(8);
        this.ai.setVisibility(0);
        this.aj.setText(getString(R.string.uam_gv_purchase_pending_text, new Object[]{this.ac}));
    }

    public final void a(double d2) {
        if (Double.compare(d2, -1.0d) == 0) {
            this.R.setText(getString(R.string.uam_gv_balance, new Object[]{this.ac, "---"}));
            return;
        }
        this.R.setText(b(d2));
    }

    private SpannableString b(double d2) {
        String b2 = com.paytm.utility.b.b(Double.valueOf(d2));
        String string = getString(R.string.uam_gv_balance, new Object[]{this.ac, b2});
        SpannableString spannableString = new SpannableString(string);
        try {
            spannableString.setSpan(new StyleSpan(1), string.indexOf(b2) - 1, string.length(), 18);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return spannableString;
    }

    private void b(String str, double d2, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        String str9;
        String str10;
        String str11 = str3;
        String str12 = str5;
        this.ad = str12;
        this.k.setText(getString(R.string.uam_gv_amount, new Object[]{com.paytm.utility.b.b(Double.valueOf(d2))}));
        this.J.setText(getString(R.string.uam_gv_order_id, new Object[]{str2}));
        this.K.setText(str3);
        if (!TextUtils.isEmpty(str2)) {
            this.J.setText(getString(R.string.uam_gv_order_id, new Object[]{str2}));
            this.S.setText(getString(R.string.uam_gv_order_id, new Object[]{str2}));
        }
        if (!TextUtils.isEmpty(str3)) {
            this.K.setText(str3);
            this.T.setText(str3);
        }
        if ("LOYALTY_POINT".equalsIgnoreCase(str12)) {
            this.q.setVisibility(0);
            this.q.setText(getString(R.string.uam_gv_paytm_first_points));
            str9 = str4;
        } else if (!TextUtils.isEmpty(str4)) {
            this.q.setVisibility(0);
            str9 = str4;
            if (str4.equalsIgnoreCase("ppbl")) {
                str9 = getString(R.string.paytm_payment_bank);
            }
            this.q.setText(str9);
        } else {
            str9 = str4;
            this.q.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str5)) {
            str12 = AddMoneyUtils.a((Context) this, str12);
        }
        String str13 = "";
        if (TextUtils.isEmpty(str9)) {
            str9 = str13;
        }
        if (!TextUtils.isEmpty(str12)) {
            str13 = str12;
        }
        if (!TextUtils.isEmpty(str13.trim())) {
            this.s.setVisibility(0);
            if ("LOYALTY_POINT".equalsIgnoreCase(str13.trim())) {
                this.s.setText(getString(R.string.uam_gv_points_redeemed, new Object[]{str}));
            } else {
                this.s.setText(getString(R.string.uam_gv_payment_mode, new Object[]{str13}));
            }
        } else {
            this.s.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str9) || !TextUtils.isEmpty(str13) || !TextUtils.isEmpty(str6)) {
            this.r.setVisibility(0);
        } else {
            this.r.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str6)) {
            this.t.setText(getString(R.string.uam_gv_transaction_id, new Object[]{str6}));
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(8);
        }
        if (TextUtils.isEmpty(str7)) {
            this.j.setText(str8);
        } else {
            this.j.setText(str7);
        }
        String j2 = com.paytm.utility.b.j((Context) this);
        if (TextUtils.isEmpty(j2)) {
            this.m.setText(getString(R.string.uam_gv_from, new Object[]{com.paytm.utility.b.l((Context) this)}));
        } else {
            this.m.setText(getString(R.string.uam_gv_from, new Object[]{j2}));
        }
        this.A.setText(getString(R.string.uam_gv_amount, new Object[]{com.paytm.utility.b.b(Double.valueOf(d2))}));
        this.U.setText(getString(R.string.uam_gv_amount, new Object[]{com.paytm.utility.b.b(Double.valueOf(d2))}));
        String a2 = l.a(String.valueOf(d2));
        if (d2 <= 1.0d) {
            str10 = getString(R.string.rupee_only, new Object[]{a2});
        } else {
            str10 = getString(R.string.rupees_only, new Object[]{a2});
        }
        this.B.setText(str10);
    }

    public final String c() {
        return getString(R.string.fullfillment_failure_text);
    }
}
