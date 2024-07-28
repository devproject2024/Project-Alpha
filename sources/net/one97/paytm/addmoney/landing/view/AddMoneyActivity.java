package net.one97.paytm.addmoney.landing.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import com.paytm.network.i;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import net.one97.paytm.addmoney.AddMoneyBaseToolbarActivity;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.common.model.BankUtils;
import net.one97.paytm.addmoney.landing.a.a;
import net.one97.paytm.addmoney.togv.view.AddMoneyToGVActivity;
import net.one97.paytm.addmoney.toppb.view.AddMoneyToPPBActivity;
import net.one97.paytm.addmoney.utils.AddMoneyCardView;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.addmoney.utils.d;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.newaddmoney.view.AddMoneyNewActivity;
import net.one97.paytm.passbook.beans.CustProductList;
import net.one97.paytm.upi.g;
import org.json.JSONException;
import org.json.JSONObject;

public class AddMoneyActivity extends AddMoneyBaseToolbarActivity implements View.OnClickListener, a.c {

    /* renamed from: c  reason: collision with root package name */
    private Context f48589c;

    /* renamed from: d  reason: collision with root package name */
    private final int f48590d = 1;

    /* renamed from: e  reason: collision with root package name */
    private final int f48591e = 2;

    /* renamed from: f  reason: collision with root package name */
    private final int f48592f = 3;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public AddMoneyCardView f48593g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public AddMoneyCardView f48594h;

    /* renamed from: i  reason: collision with root package name */
    private AddMoneyCardView f48595i;
    private RecyclerView j;
    private CJRHomePageItem k;
    /* access modifiers changed from: private */
    public net.one97.paytm.addmoney.landing.c.a l;
    /* access modifiers changed from: private */
    public int m = 0;
    private LottieAnimationView n;
    private final String o = AddMoneyActivity.class.getSimpleName();
    private a p;
    /* access modifiers changed from: private */
    public boolean q;
    private TextView r;
    /* access modifiers changed from: private */
    public String s;
    private String t;
    private TextView u;
    private TextView v;
    private CardView w;
    private Boolean x;

    public final void a(boolean z) {
    }

    public final int b() {
        return 0;
    }

    public final Activity c() {
        return this;
    }

    public void onClick(View view) {
    }

    public final int a() {
        return R.layout.uam_activity_main;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f48589c = this;
        this.s = getIntent().getStringExtra("add_money_source");
        this.t = net.one97.paytm.helper.a.b().l();
        this.q = getIntent().getBooleanExtra("destroy_self", false);
        d.a(this, "/add-money");
        d.a((Context) this, "add_money", SDKConstants.PG_SCREEN_LOADED, "/add-money", (String) null, (String) null);
        findViewById(R.id.payments_bank_info_btn_close).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AddMoneyActivity.this.onBackPressed();
            }
        });
        if (getIntent().hasExtra("extra_home_data")) {
            this.k = (CJRHomePageItem) getIntent().getSerializableExtra("extra_home_data");
            CJRHomePageItem cJRHomePageItem = this.k;
            if (cJRHomePageItem != null) {
                String pushFeatureType = cJRHomePageItem.getPushFeatureType();
                if (!TextUtils.isEmpty(pushFeatureType) && pushFeatureType.equalsIgnoreCase("add_money")) {
                    if (!net.one97.paytm.helper.a.b().m(getApplicationContext())) {
                        h();
                    }
                    finish();
                    return;
                }
            }
        }
        this.n = (LottieAnimationView) findViewById(R.id.content_loader);
        this.r = (TextView) findViewById(R.id.tv_desc);
        this.u = (TextView) findViewById(R.id.tv_title);
        if ("PPB".equalsIgnoreCase(this.s)) {
            this.u.setText(getString(R.string.uam_add_money_landing_title_for_ppb));
            this.r.setVisibility(8);
        }
        this.r.setText(getString(R.string.uam_landing_desc_new, new Object[]{this.t}));
        this.l = new net.one97.paytm.addmoney.landing.c.a(this, g.a());
        if (b.r((Context) this)) {
            g();
        } else {
            a((Activity) this);
        }
        this.f48593g = new AddMoneyCardView(this);
        this.f48593g.setTitle(getString(R.string.to_paytm_wallet));
        this.f48593g.setSubTitle((String) null);
        this.f48593g.setIcon(R.drawable.uam_wallet_source_list_icon);
        this.f48593g.setClickListenerOnActionViewBalance(new View.OnClickListener() {
            public final void onClick(View view) {
                if (b.r((Context) AddMoneyActivity.this)) {
                    int unused = AddMoneyActivity.this.m = 1;
                    AddMoneyActivity.this.f48593g.setViewBalanceActionVisibility(false);
                    AddMoneyActivity.this.f48593g.a(true);
                    AddMoneyActivity.this.l.i();
                    return;
                }
                AddMoneyActivity.a((Activity) AddMoneyActivity.this);
            }
        });
        this.f48593g.setDescription((String) null);
        this.f48593g.setViewBalanceActionVisibility(false);
        this.m = 1;
        if (b.r((Context) this)) {
            this.f48593g.a(true);
            this.l.i();
        }
        this.f48593g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.a((Context) AddMoneyActivity.this, "add_money", "paytm_wallet_clicked", "/add-money", "paytm_wallet", (String) null);
                if (!net.one97.paytm.helper.a.b().m(AddMoneyActivity.this)) {
                    AddMoneyActivity.this.h();
                }
            }
        });
        ((ViewGroup) findViewById(R.id.wallet_card_layout)).addView(this.f48593g);
        findViewById(R.id.wallet_card_layout).setVisibility(0);
        this.j = (RecyclerView) findViewById(R.id.rv_banks);
        this.w = (CardView) findViewById(R.id.activate_wallet_card_layout);
        this.v = (TextView) this.w.findViewById(R.id.wallet_activation_proceed_tv);
        this.v.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                new d().show(AddMoneyActivity.this.getSupportFragmentManager(), AddMoneyActivity.class.getName());
            }
        });
        this.j.setLayoutManager(new LinearLayoutManager(this));
        this.p = new a(this, this.l);
        this.j.setAdapter(this.p);
        this.l.a();
    }

    private void g() {
        a(this.n, true);
        this.l.g();
        boolean h2 = net.one97.paytm.helper.a.b().h();
        int g2 = net.one97.paytm.helper.a.b().g();
        if (h2 && g2 == 0) {
            getSupportFragmentManager().a().b(R.id.auto_add_layout, new e(), (String) null).c();
        } else if (!"PPB".equalsIgnoreCase(this.s) && net.one97.paytm.helper.a.b().h() && net.one97.paytm.helper.a.b().g() == 0) {
            getSupportFragmentManager().a().b(R.id.auto_add_layout, new e(), (String) null).c();
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        startActivity(new Intent(this, AddMoneyNewActivity.class));
    }

    private void i() {
        if (!"PPB".equalsIgnoreCase(this.s)) {
            this.f48595i = new AddMoneyCardView(this);
            this.f48595i.setTitle(this.t);
            this.f48595i.setIcon(R.drawable.uam_ic_gift_voucher);
            this.f48595i.setClickOnKnowMore(new View.OnClickListener() {
                public final void onClick(View view) {
                }
            });
            this.f48595i.setSubTitle((String) null);
            this.f48595i.setDescription((String) null);
            this.f48593g.setViewBalanceActionVisibility(false);
            this.f48595i.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    d.a((Context) AddMoneyActivity.this, "add_money", "paytm_giftvoucher_clicked", "/add-money", (String) null, (String) null);
                    AddMoneyActivity.this.startActivity(new Intent(AddMoneyActivity.this, AddMoneyToGVActivity.class));
                    AddMoneyActivity.this.f48593g.setEnabled(false);
                }
            });
            this.f48595i.setKnowMoreActionVisibility(false);
            ((ViewGroup) findViewById(R.id.gift_voucher_layout)).addView(this.f48595i);
            ((ViewGroup) findViewById(R.id.gift_voucher_layout)).setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        d.a((Context) this, "add_money", "ppb_view_balance_clicked", "/add-money", (String) null, (String) null);
        if (b.r((Context) this)) {
            this.m = 2;
            AddMoneyCardView addMoneyCardView = this.f48594h;
            if (addMoneyCardView != null) {
                addMoneyCardView.setViewBalanceActionVisibility(false);
                this.f48594h.a(true);
            }
            this.l.h();
            return;
        }
        a((Activity) this);
    }

    public static void a(Activity activity) {
        if (activity != null) {
            net.one97.paytm.helper.a.b().g(activity);
        }
    }

    public final void b(boolean z) {
        a(this.n, z);
    }

    public final void a(String str, String str2, String str3) {
        int i2 = this.m;
        if (i2 == 1) {
            this.f48593g.setSubTitle(getString(R.string.uam_balance_rupee, new Object[]{str}));
            this.f48593g.setViewBalanceActionVisibility(false);
            this.f48593g.a(false);
            if (c(str3)) {
                i();
                AddMoneyCardView addMoneyCardView = this.f48595i;
                if (addMoneyCardView != null) {
                    addMoneyCardView.setSubTitle(getString(R.string.uam_balance_rupee, new Object[]{str2}));
                    this.f48595i.a(false);
                }
            }
        } else if (i2 == 3 && c(str3)) {
            i();
            AddMoneyCardView addMoneyCardView2 = this.f48595i;
            if (addMoneyCardView2 != null) {
                addMoneyCardView2.setSubTitle(getString(R.string.uam_gv_main_balance, new Object[]{str2}));
                this.f48595i.a(false);
            }
        }
        if ("Non Wallet Account".equalsIgnoreCase(str3)) {
            this.w.setVisibility(0);
        } else {
            this.w.setVisibility(8);
        }
    }

    private static boolean c(String str) {
        for (String equalsIgnoreCase : net.one97.paytm.helper.a.b().f("gvpurchaseenable").split(AppConstants.COMMA)) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public final void d() {
        int i2 = this.m;
        if (i2 == 1) {
            this.f48593g.a(false);
            this.f48593g.setViewBalanceActionVisibility(true);
            this.f48593g.setSubTitle((String) null);
            this.f48595i.a(false);
            this.f48595i.setViewBalanceActionVisibility(true);
            this.f48595i.setSubTitle((String) null);
        } else if (i2 == 3) {
            this.f48595i.a(false);
            this.f48595i.setViewBalanceActionVisibility(true);
            this.f48595i.setSubTitle((String) null);
        }
    }

    public final void a(boolean z, final String str) {
        a(this.n, false);
        if (z) {
            this.f48594h = new AddMoneyCardView(this);
            this.f48594h.setTitle(getString(R.string.uam_main_bank_title));
            this.f48594h.setSubTitle((String) null);
            this.f48594h.setIcon(R.drawable.uam_ppb_header_icon);
            this.f48594h.setClickListenerOnActionViewBalance(new View.OnClickListener() {
                public final void onClick(View view) {
                    if ("PPB".equalsIgnoreCase(AddMoneyActivity.this.s)) {
                        AddMoneyActivity.this.j();
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("ENTER_HEADER", "paytm_saving_account_confirm");
                    net.one97.paytm.helper.a.b().a((Activity) AddMoneyActivity.this, intent);
                    AddMoneyActivity.this.startActivityForResult(intent, 1008);
                }
            });
            this.f48594h.setDescription((String) null);
            this.f48594h.setViewBalanceActionVisibility(true);
            if (CustProductList.ISA_CREDIT_FREEZED.equalsIgnoreCase(str) || CustProductList.ISA_TOTAL_FREEZED.equalsIgnoreCase(str)) {
                this.f48594h.setPpbAccountStatus(getString(R.string.uam_ppb_account_blocked));
            }
            this.f48594h.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    d.a((Context) AddMoneyActivity.this, "add_money", "paytm_paymentBank_bank_clicked", "/add-money", "paytm_wallet", (String) null);
                    if (CustProductList.ISA_CREDIT_FREEZED.equalsIgnoreCase(str) || CustProductList.ISA_TOTAL_FREEZED.equalsIgnoreCase(str)) {
                        net.one97.paytm.addmoney.landing.c.a c2 = AddMoneyActivity.this.l;
                        if (c2.f48580b.getIsa().freezeDescriptionList != null) {
                            try {
                                JSONObject jSONObject = new JSONObject(c2.f48580b.getIsa().freezeDescriptionList.get(0).getActionDescription());
                                c2.f48579a.a(jSONObject.getString(RequestConfirmationDialogFragment.KEY_DESCRIPTION), jSONObject.getString(Item.KEY_REASON), jSONObject.getString("action_text"), jSONObject.getString("deeplink"), jSONObject.getString("weblink"));
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                    } else {
                        if (net.one97.paytm.helper.a.b().g("enable_add_money_to_ppb_2")) {
                            Intent intent = new Intent(AddMoneyActivity.this, AddMoneyToPPBActivity.class);
                            intent.putExtra("destroy_self", AddMoneyActivity.this.q);
                            if (AddMoneyActivity.this.l.f() != null) {
                                intent.putExtra("slfdIblCifStatus", AddMoneyActivity.this.l.f());
                            }
                            if (AddMoneyActivity.this.l.f48584f != null) {
                                intent.putExtra("slfdBalance", AddMoneyActivity.this.l.f48584f.doubleValue());
                            }
                            AddMoneyActivity.this.startActivityForResult(intent, 101);
                        } else {
                            AddMoneyActivity.this.startActivity(BankUtils.getAddMoneyBankActivityIntent(AddMoneyActivity.this));
                        }
                        AddMoneyActivity.this.f48594h.setEnabled(false);
                    }
                }
            });
            ((ViewGroup) findViewById(R.id.ppb_card_layout)).addView(this.f48594h);
            ((ViewGroup) findViewById(R.id.ppb_card_layout)).setVisibility(0);
        } else if ((net.one97.paytm.helper.a.b().h() && net.one97.paytm.helper.a.b().g() == 0) || net.one97.paytm.helper.a.b().g() == 1) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.uam_add_money_ppb_onboarding, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tv_open_account)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    net.one97.paytm.helper.a.b().a((Activity) AddMoneyActivity.this);
                }
            });
            ((ViewGroup) findViewById(R.id.ppb_onboarding_card_layout)).addView(inflate);
            ((ViewGroup) findViewById(R.id.ppb_onboarding_card_layout)).setVisibility(0);
        }
    }

    public final void a(String str) {
        if (this.m == 2) {
            this.f48594h.a(false);
            this.f48594h.setViewBalanceActionVisibility(true);
            this.f48594h.setSubTitle((String) null);
        }
        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase("null")) {
            str = getString(R.string.check_your_network);
        }
        b.b((Context) this, getString(R.string.error), str);
    }

    public final void b(String str) {
        this.f48594h.setSubTitle(getString(R.string.uam_balance_rupee, new Object[]{AddMoneyUtils.d(str)}));
        this.f48594h.setViewBalanceActionVisibility(false);
        this.f48594h.a(false);
    }

    public final void a(NetworkCustomError networkCustomError) {
        net.one97.paytm.helper.a.b().a((Activity) this, AddMoneyActivity.class.getCanonicalName(), (Bundle) null, Boolean.TRUE, Boolean.FALSE);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 == -1) {
            if (i2 == 301) {
                a(this.n, true);
                this.l.g();
                g();
                this.l.a();
                this.l.i();
            } else {
                if (i2 != 288) {
                    net.one97.paytm.helper.a.b();
                    if (i2 != 3) {
                        if (i2 == 1008) {
                            j();
                        }
                    }
                }
                a(this.n, true);
                this.l.a();
            }
            if (intent != null) {
                this.x = Boolean.valueOf(intent.getBooleanExtra("fd_clicked", false));
            }
        } else if (i2 != 1008 && i2 != 101) {
            finish();
        } else {
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }

    public void onDestroy() {
        i.b();
        super.onDestroy();
    }

    public final void a(int i2, int i3) {
        a aVar = this.p;
        if (aVar != null) {
            aVar.notifyItemRangeInserted(i2, i3);
        }
    }

    public final void a(int i2) {
        a aVar = this.p;
        if (aVar != null) {
            aVar.notifyItemRangeRemoved(0, i2);
        }
    }

    public final void c(boolean z) {
        RecyclerView recyclerView = this.j;
        if (recyclerView == null) {
            return;
        }
        if (z) {
            recyclerView.setVisibility(0);
        } else {
            recyclerView.setVisibility(8);
        }
    }

    public final void a(String str, String str2, String str3, String str4) {
        d.a((Context) this, "add_money", "other_bank_clicked", "/add-money", "paytm_wallet", (String) null);
        StringBuilder sb = new StringBuilder();
        sb.append(net.one97.paytm.helper.a.b().i() + "cash_wallet?featuretype=money_transfer");
        sb.append("&account=");
        sb.append(str3);
        sb.append("&pn=");
        sb.append(str);
        sb.append("&ifsc=");
        sb.append(str4);
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(str2)) {
            sb2 = sb2 + "&bank_name=" + str2;
        }
        net.one97.paytm.helper.a.b().a((Context) this, sb2);
    }

    public final void e() {
        if (!g.a((net.one97.paytm.upi.h.a) null).e() || !g.a((net.one97.paytm.upi.h.a) null).h()) {
            findViewById(R.id.upi_onboarding_card_layout).setVisibility(0);
            Bundle bundle = new Bundle();
            bundle.putString("upi_address", "");
            b bVar = new b();
            bVar.setArguments(bundle);
            getSupportFragmentManager().a().b(R.id.fl_upi_onboarding_card_layout, bVar, (String) null).c();
        }
    }

    public final void f() {
        findViewById(R.id.fl_upi_onboarding_card_layout).setVisibility(8);
    }

    public void onResume() {
        super.onResume();
        AddMoneyCardView addMoneyCardView = this.f48593g;
        if (addMoneyCardView != null) {
            addMoneyCardView.setEnabled(true);
        }
        AddMoneyCardView addMoneyCardView2 = this.f48595i;
        if (addMoneyCardView2 != null) {
            addMoneyCardView2.setEnabled(true);
        }
        AddMoneyCardView addMoneyCardView3 = this.f48594h;
        if (addMoneyCardView3 != null) {
            addMoneyCardView3.setEnabled(true);
            Boolean bool = this.x;
            if (bool != null && bool.booleanValue()) {
                this.f48594h.setViewBalanceActionVisibility(false);
                this.f48594h.a(true);
                this.l.h();
            }
        }
    }

    public final void a(String str, String str2, String str3, final String str4, final String str5) {
        View inflate = getLayoutInflater().inflate(R.layout.uam_ppb_layout_account_status, (ViewGroup) null);
        final com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(this);
        aVar.setContentView(inflate);
        final BottomSheetBehavior from = BottomSheetBehavior.from((View) inflate.getParent());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        from.setPeekHeight(displayMetrics.heightPixels);
        aVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                from.setState(4);
            }
        });
        from.setState(2);
        if (!isFinishing()) {
            aVar.show();
        }
        ((TextView) inflate.findViewById(R.id.tv_description)).setText(str);
        ((ImageView) inflate.findViewById(R.id.iv_close)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                aVar.dismiss();
            }
        });
        ((TextView) inflate.findViewById(R.id.tv_reason)).setText(str2);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_action);
        textView.setText(str3);
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!TextUtils.isEmpty(str4)) {
                    net.one97.paytm.helper.a.b().a((Context) AddMoneyActivity.this, str4);
                } else {
                    TextUtils.isEmpty(str5);
                }
            }
        });
    }
}
