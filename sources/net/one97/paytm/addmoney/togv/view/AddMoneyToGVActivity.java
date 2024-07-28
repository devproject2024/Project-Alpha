package net.one97.paytm.addmoney.togv.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.q;
import androidx.lifecycle.k;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkCustomVolleyError;
import com.paytm.utility.h;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import net.one97.paytm.addmoney.AddMoneyBaseToolbarActivity;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.j;
import net.one97.paytm.addmoney.togv.a.a;
import net.one97.paytm.addmoney.togv.b.a;
import net.one97.paytm.addmoney.togv.view.c;
import net.one97.paytm.addmoney.utils.CustomAmountTextInputEditText;
import net.one97.paytm.addmoney.utils.d;
import net.one97.paytm.addmoney.utils.l;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.requestmoney.model.ContactItemModel;
import net.one97.paytm.upi.util.CustomWalletLoaderDialog;

public class AddMoneyToGVActivity extends AddMoneyBaseToolbarActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, a.b, a.b {
    /* access modifiers changed from: private */
    public String A;
    /* access modifiers changed from: private */
    public String B;
    private String C;
    private String D;
    /* access modifiers changed from: private */
    public net.one97.paytm.addmoney.togv.a.a E;
    private List<String> F;
    private int G = 3;
    /* access modifiers changed from: private */
    public boolean H;
    /* access modifiers changed from: private */
    public String I;
    /* access modifiers changed from: private */
    public ImageView J;
    private NestedScrollView K;
    private RadioGroup L;
    private RadioButton M;
    /* access modifiers changed from: private */
    public RadioButton N;
    private ConstraintLayout O;
    private LinearLayout P;
    private ImageView Q;
    private TextView R;
    private TextView S;
    /* access modifiers changed from: private */
    public a T;
    /* access modifiers changed from: private */
    public CoordinatorLayout U;
    private boolean V;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f48727c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public TextView f48728d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f48729e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f48730f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextView f48731g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public CustomAmountTextInputEditText f48732h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public View f48733i;
    /* access modifiers changed from: private */
    public TextView j;
    /* access modifiers changed from: private */
    public EditText k;
    private ImageView l;
    private View m;
    /* access modifiers changed from: private */
    public TextView n;
    private a o;
    private b p;
    private TextView q;
    /* access modifiers changed from: private */
    public LinearLayout r;
    private String s;
    /* access modifiers changed from: private */
    public String t;
    private String u;
    private int v;
    private int w;
    /* access modifiers changed from: private */
    public boolean x;
    /* access modifiers changed from: private */
    public a.C0856a y;
    private CustomWalletLoaderDialog z;

    public final void a(NetworkCustomError networkCustomError) {
    }

    public final int a() {
        return R.layout.uam_activity_gv_purchase;
    }

    public final int b() {
        return f48004a;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.U = (CoordinatorLayout) findViewById(R.id.rootview);
        this.U.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                Rect rect = new Rect();
                AddMoneyToGVActivity.this.U.getWindowVisibleDisplayFrame(rect);
                int height = AddMoneyToGVActivity.this.U.getRootView().getHeight();
                if (((double) (height - rect.bottom)) > ((double) height) * 0.15d) {
                    AddMoneyToGVActivity.this.r.setVisibility(8);
                } else {
                    AddMoneyToGVActivity.this.r.setVisibility(0);
                }
            }
        });
        if (getIntent() != null) {
            a(getIntent());
        }
        d.a(this, "/add-money/gv");
    }

    private void a(Intent intent) {
        this.s = com.paytm.utility.b.C((Context) this);
        this.t = com.paytm.utility.b.l((Context) this);
        this.u = net.one97.paytm.helper.a.b().l();
        this.v = net.one97.paytm.helper.a.b().h("gvminvalue");
        this.w = net.one97.paytm.helper.a.b().h("gvmaxvalue");
        b(intent);
        v();
        l();
        t();
        m();
        n();
        p();
        q();
        j();
        u();
        this.y = new net.one97.paytm.addmoney.togv.d.a(this, j.a(getApplicationContext(), (Activity) this));
        i();
        if (intent.getBooleanExtra("isForFriends", false)) {
            this.N.setChecked(true);
        }
    }

    private void i() {
        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar_gv);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar_gv);
        this.f48728d.setText(this.I);
        ((AppBarLayout) findViewById(R.id.app_bar)).a((AppBarLayout.b) new AppBarLayout.b() {

            /* renamed from: a  reason: collision with root package name */
            boolean f48759a = true;

            /* renamed from: b  reason: collision with root package name */
            int f48760b = -1;

            public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
                if (this.f48760b == -1) {
                    this.f48760b = appBarLayout.getTotalScrollRange();
                }
                int i3 = this.f48760b;
                if (i3 + i2 == 0 || i2 + i3 <= i3 / 2) {
                    collapsingToolbarLayout.setTitle(AddMoneyToGVActivity.this.I);
                    AddMoneyToGVActivity.this.f48728d.setVisibility(4);
                    AddMoneyToGVActivity.this.J.setVisibility(4);
                    this.f48759a = true;
                } else if (this.f48759a) {
                    collapsingToolbarLayout.setTitle(" ");
                    AddMoneyToGVActivity.this.f48728d.setVisibility(0);
                    AddMoneyToGVActivity.this.J.setVisibility(0);
                    this.f48759a = false;
                }
            }
        });
    }

    private void j() {
        if (TextUtils.isEmpty(this.D) || this.D.equalsIgnoreCase(this.t)) {
            o();
        } else {
            k();
        }
        String str = this.A;
        if (str != null) {
            this.f48732h.setText(str);
        }
    }

    private void k() {
        if (!TextUtils.isEmpty(this.C)) {
            this.j.setText(this.C);
        }
        if (!TextUtils.isEmpty(this.D)) {
            b bVar = this.p;
            if (bVar != null) {
                this.k.removeTextChangedListener(bVar);
            }
            this.k.setText(this.D);
            b bVar2 = this.p;
            if (bVar2 != null) {
                this.k.addTextChangedListener(bVar2);
            }
            this.x = true;
        }
    }

    private void b(Intent intent) {
        if (intent.getStringExtra("gv_reciever_mobile") != null) {
            this.C = intent.getStringExtra("gv_reciever_name");
            this.D = intent.getStringExtra("gv_reciever_mobile");
            if (!this.D.equals(com.paytm.utility.b.l((Context) this))) {
                this.V = true;
            }
        }
        if (intent.getStringExtra("amount") != null) {
            this.A = intent.getStringExtra("amount");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.y.b();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        super.onActivityResult(i2, i3, intent);
        int i4 = 0;
        a(false);
        if (i3 != -1) {
            return;
        }
        if (i2 == 1007) {
            Cursor cursor = null;
            try {
                cursor = getContentResolver().query(intent.getData(), (String[]) null, (String) null, (String[]) null, (String) null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("data1");
                int columnIndex2 = cursor.getColumnIndex("display_name");
                String string = cursor.getString(columnIndex);
                String string2 = cursor.getString(columnIndex2);
                String str2 = "";
                if (!TextUtils.isEmpty(string)) {
                    str = string.trim().replaceAll("[^\\d+]", str2).replaceAll(" ", str2);
                } else {
                    str = str2;
                }
                if (str.length() > 10) {
                    if (!TextUtils.isEmpty(str)) {
                        String replaceAll = str.trim().replaceAll("[^\\d+]", str2);
                        if (replaceAll.startsWith(getString(R.string.mobile_number_prefix_91))) {
                            i4 = 3;
                        } else if (replaceAll.startsWith(getString(R.string.mobile_number_prefix_91_without_plus))) {
                            i4 = 2;
                        } else if (replaceAll.startsWith(getString(R.string.mobile_number_prefix_0))) {
                            i4 = 1;
                        }
                        str2 = replaceAll.substring(i4, replaceAll.length()).trim().replaceAll(" ", str2);
                    }
                    str = str2;
                }
                if (d(str)) {
                    this.k.setText(str);
                } else {
                    if (str.length() > 5) {
                        str = new StringBuilder(str).insert(5, ' ').toString();
                    }
                    this.k.setText(str);
                    this.k.setSelection(this.k.getText().length());
                }
                if (!TextUtils.isEmpty(string2)) {
                    this.j.setText(string2);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } else if (i2 == 1006) {
            if (r()) {
                intent.setClass(getApplicationContext(), AddMoneyToGvSelfStatusActivity.class);
            } else {
                intent.setClass(getApplicationContext(), AddMoneyToGVStatusActivity.class);
            }
            intent.putExtra("do_check_order_status_by_polling", true);
            startActivity(intent);
            finish();
        }
    }

    private void l() {
        this.f48727c = (ImageView) findViewById(R.id.iv_back_arrow);
        this.f48728d = (TextView) findViewById(R.id.tv_toolbar_title);
        this.f48729e = (TextView) findViewById(R.id.tv_toolbar_message);
        this.f48730f = (TextView) findViewById(R.id.tv_toolbar_know_more);
        this.f48731g = (TextView) findViewById(R.id.tv_rupee_prefix);
        this.f48732h = (CustomAmountTextInputEditText) findViewById(R.id.et_amount);
        CustomAmountTextInputEditText customAmountTextInputEditText = this.f48732h;
        customAmountTextInputEditText.setSelection(customAmountTextInputEditText.getText().length());
        this.f48733i = findViewById(R.id.v_amount_divider);
        this.j = (TextView) findViewById(R.id.tv_contact_name);
        this.k = (EditText) findViewById(R.id.et_contact);
        this.l = (ImageView) findViewById(R.id.iv_contact);
        this.q = (TextView) findViewById(R.id.name_mobile_tv);
        this.n = (TextView) findViewById(R.id.btn_proceed);
        this.J = (ImageView) findViewById(R.id.expandedImage);
        this.K = (NestedScrollView) findViewById(R.id.scroll_view);
        this.L = (RadioGroup) findViewById(R.id.rg_gv_type);
        this.M = (RadioButton) findViewById(R.id.rb_gv_self);
        this.M.setTypeface(Typeface.create("sans-serif-medium", 1));
        this.N = (RadioButton) findViewById(R.id.rb_gv_friends);
        this.N.setChecked(this.V);
        this.O = (ConstraintLayout) findViewById(R.id.friend_family_wrapper);
        this.P = (LinearLayout) findViewById(R.id.ll_select_contact);
        this.R = (TextView) findViewById(R.id.amount_in_words);
        this.m = findViewById(R.id.v_name_mobile_divider);
        this.Q = (ImageView) findViewById(R.id.iv_contact_ff);
        this.S = (TextView) findViewById(R.id.error_name_number);
        this.r = (LinearLayout) findViewById(R.id.bottomView);
    }

    private void m() {
        this.f48732h.setPrefix("");
        this.f48732h.setMaxDigitsAfterDecimalPoint(0);
        this.f48732h.setMaxDigitsBeforeDecimalPoint(String.valueOf(this.w).length());
    }

    private void n() {
        this.I = getString(R.string.uam_gv_paytm_gv);
    }

    /* access modifiers changed from: private */
    public void o() {
        if (!TextUtils.isEmpty(this.s)) {
            this.j.setText(this.s);
        }
        if (!TextUtils.isEmpty(this.t)) {
            b bVar = this.p;
            if (bVar != null) {
                this.k.removeTextChangedListener(bVar);
            }
            this.k.setText(this.t);
            b bVar2 = this.p;
            if (bVar2 != null) {
                this.k.addTextChangedListener(bVar2);
            }
            this.x = true;
        }
    }

    private void p() {
        this.f48727c.setOnClickListener(this);
        this.f48730f.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.L.setOnCheckedChangeListener(this);
    }

    private void q() {
        this.o = new a(this, (byte) 0);
        this.f48732h.addTextChangedListener(this.o);
        this.f48732h.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    d.a((Context) AddMoneyToGVActivity.this, "gift_voucher", "gv_amount_clicked", "/gift-voucher", (String) null, (String) null);
                    AddMoneyToGVActivity.this.f48733i.setBackgroundColor(androidx.core.content.b.c(AddMoneyToGVActivity.this, R.color.color_00b9f5));
                    return;
                }
                AddMoneyToGVActivity.this.f48733i.setBackgroundColor(androidx.core.content.b.c(AddMoneyToGVActivity.this, R.color.color_f3f7f8));
            }
        });
        this.p = new b(this, (byte) 0);
        this.k.addTextChangedListener(this.p);
        this.k.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    d.a((Context) AddMoneyToGVActivity.this, "gift_voucher", "gv_edit_phonenumber_clicked", "/gift-voucher", (String) null, (String) null);
                    TextUtils.isEmpty(AddMoneyToGVActivity.this.k.getText().toString());
                }
            }
        });
    }

    private boolean r() {
        return this.k.getText().toString().equalsIgnoreCase(this.t);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_back_arrow) {
            d.a((Context) this, "gift_voucher", "buy_giftvoucher_back_clicked", "/gift-voucher", (String) null, (String) null);
            finish();
        } else if (id == R.id.tv_toolbar_know_more) {
            d.a((Context) this, "gift_voucher", "gv_knowmore_clicked", "/gift-voucher", (String) null, (String) null);
            String l2 = net.one97.paytm.helper.a.b().l();
            View inflate = getLayoutInflater().inflate(R.layout.uam_gv_layout_know_more, (ViewGroup) null);
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
            ((TextView) inflate.findViewById(R.id.tv_title)).setText(l2);
            ((ImageView) inflate.findViewById(R.id.iv_close)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    d.a((Context) AddMoneyToGVActivity.this, "gift_voucher", "gv_knowmore_closed", "/gift-voucher", (String) null, (String) null);
                    aVar.dismiss();
                }
            });
            ((TextView) inflate.findViewById(R.id.tv_info_2)).setText(getString(R.string.uam_gv_info_2, new Object[]{l2}));
            String f2 = net.one97.paytm.helper.a.b().f("gvpopupknowmore");
            if (!TextUtils.isEmpty(f2)) {
                ((ImageView) inflate.findViewById(R.id.iv_success_3)).setVisibility(0);
                TextView textView = (TextView) inflate.findViewById(R.id.tv_info_3);
                textView.setText(f2);
                textView.setVisibility(0);
            }
            ((TextView) inflate.findViewById(R.id.tv_hint)).setText(getString(R.string.uam_gv_hint, new Object[]{l2}));
            ((TextView) inflate.findViewById(R.id.tv_terms_and_condition)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    Intent b2 = net.one97.paytm.helper.a.b().b(this);
                    b2.putExtra("url", "https://www.paytmbank.com/Terms&Conditions");
                    b2.putExtra("title", this.getString(R.string.uam_gv_t_n_c));
                    this.startActivity(b2);
                    aVar.dismiss();
                }
            });
        } else if (id == R.id.iv_contact || id == R.id.name_mobile_tv || id == R.id.iv_contact_ff) {
            q a2 = getSupportFragmentManager().a();
            this.T = new a((b) new b() {
                public final void a(ContactItemModel contactItemModel) {
                    AddMoneyToGVActivity.this.getSupportFragmentManager().a().a((Fragment) AddMoneyToGVActivity.this.T).c();
                    AddMoneyToGVActivity.a(AddMoneyToGVActivity.this, contactItemModel);
                }
            });
            new a(com.paytm.utility.b.l((Context) this));
            a2.a(R.anim.fragment_bottom_up, R.anim.fade_out, R.anim.fragment_bottom_up, R.anim.fade_out);
            a2.a(R.id.fragmentContainer, this.T, a.class.getName()).a(a.class.getName());
            a2.c();
        } else if (id == R.id.btn_proceed) {
            if (this.M.isChecked()) {
                if (TextUtils.isEmpty(this.f48732h.getText().toString())) {
                    s();
                } else if (com.paytm.utility.b.c((Context) this)) {
                    this.y.a(c(), this.k.getText().toString(), r());
                    d.a((Context) this, "add_money", "gv_proceed_clicked", "/add-money", "paytm_wallet", (String) null);
                } else {
                    h();
                }
            }
            if (this.N.isChecked()) {
                if (TextUtils.isEmpty(this.k.getText().toString())) {
                    this.S.setVisibility(0);
                    this.S.setText(getString(R.string.select_contact_number));
                }
                if (TextUtils.isEmpty(this.f48732h.getText().toString())) {
                    s();
                }
                if (!TextUtils.isEmpty(this.k.getText().toString()) && !TextUtils.isEmpty(this.f48732h.getText().toString())) {
                    Calendar instance = Calendar.getInstance();
                    instance.setTime(new Date());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy");
                    System.out.println(simpleDateFormat.format(instance.getTime()));
                    instance.add(1, 10);
                    String format = simpleDateFormat.format(instance.getTime());
                    String obj = this.f48732h.getText().toString();
                    String obj2 = this.k.getText().toString();
                    c cVar = new c(TextUtils.isEmpty(this.s) ? this.t : this.s, this.j.getText().toString(), obj, format, obj2, Boolean.valueOf(r()));
                    cVar.show(getSupportFragmentManager(), cVar.getTag());
                    cVar.f48801a = new c.a() {
                    };
                }
            }
        }
    }

    private void s() {
        this.R.setVisibility(0);
        this.R.setText(getString(R.string.gv_enter_amount_between, new Object[]{"1", "10000"}));
        this.R.setTextColor(androidx.core.content.b.c(this, R.color.wallet_error));
    }

    public final double c() {
        String str;
        if (!this.H) {
            str = com.paytm.utility.b.Q(this.f48732h.getText().toString());
        } else {
            net.one97.paytm.addmoney.togv.a.a aVar = this.E;
            str = aVar != null ? aVar.a(aVar.f48668a) : "0";
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return 0.0d;
        }
    }

    public final String d() {
        return this.k.getText().toString();
    }

    public final String e() {
        return this.j.getText().toString();
    }

    public final void a(boolean z2) {
        try {
            if (this.z == null) {
                this.z = new CustomWalletLoaderDialog(this);
            }
            if (z2) {
                if (this.z != null) {
                    this.z.setTitle(getString(R.string.uam_processing_request));
                    this.z.showLoader();
                }
            } else if (this.z != null) {
                this.z.dismissLoader();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public static boolean d(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (Integer.parseInt(String.valueOf(str.charAt(0))) <= 4 || str.length() != 10) {
                    return false;
                }
                return true;
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    public final void a(String str) {
        this.x = false;
        String string = getString(R.string.uam_error);
        String string2 = getString(R.string.uam_gv_sent_error, new Object[]{this.u});
        if (TextUtils.isEmpty(str)) {
            str = string2;
        }
        d.a((Context) this, "gift_voucher", "gv_phonenumber_edit_error ", "/gift-voucher", (String) null, (String) null);
        final h hVar = new h(this);
        hVar.setTitle(string);
        hVar.a(str);
        hVar.a(-3, getString(R.string.upi_ok), new View.OnClickListener() {
            public final void onClick(View view) {
                hVar.dismiss();
            }
        });
        hVar.show();
        this.P.setVisibility(8);
        this.O.setVisibility(0);
        this.k.setText("");
        this.f48732h.setText("");
    }

    public final void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.j.setText(str);
            this.C = str;
        }
        this.x = true;
    }

    public final void a(String str, String str2) {
        String string = getString(R.string.uam_error);
        if (NetworkCustomError.ErrorType.AuthFailureError.name().equalsIgnoreCase(str)) {
            string = getString(R.string.session_time_out);
        }
        String string2 = getString(R.string.uam_error_random);
        if (!TextUtils.isEmpty(str2)) {
            string2 = str2;
        }
        final h hVar = new h(this);
        hVar.setTitle(string);
        hVar.a(string2);
        hVar.a(-3, getString(R.string.upi_ok), new View.OnClickListener() {
            public final void onClick(View view) {
                hVar.dismiss();
            }
        });
        hVar.show();
    }

    public final void f() {
        a.C0856a aVar = this.y;
        if (aVar != null) {
            aVar.a(r());
        }
    }

    public final void a(final CJRRechargePayment cJRRechargePayment) {
        if (cJRRechargePayment.getStatus() == null || !cJRRechargePayment.getStatus().equalsIgnoreCase("SUCCESS")) {
            a(false);
            if (cJRRechargePayment != null && cJRRechargePayment.getCode() == 401) {
                NetworkCustomVolleyError networkCustomVolleyError = new NetworkCustomVolleyError();
                String f2 = net.one97.paytm.helper.a.b().f("cartCheckout");
                if (!TextUtils.isEmpty(f2)) {
                    networkCustomVolleyError.setUrl(f2);
                    if (cJRRechargePayment.getError() != null && !TextUtils.isEmpty(cJRRechargePayment.getError().getMessage())) {
                        networkCustomVolleyError.setAlertMessage(cJRRechargePayment.getError().getMessage());
                    }
                }
                net.one97.paytm.helper.a.b().a((Activity) this, (String) null, (Bundle) null);
            } else if (cJRRechargePayment != null && cJRRechargePayment.getError() != null) {
                com.paytm.utility.b.a((Context) this, cJRRechargePayment.getError().getTitle(), cJRRechargePayment.getError().getMessage());
            }
        } else if ("1".equals(cJRRechargePayment.isNativeEnabled())) {
            net.one97.paytm.helper.a.b().a(getApplicationContext(), cJRRechargePayment, (net.one97.paytm.addmoney.togv.b.c) new net.one97.paytm.addmoney.togv.b.c() {
                public final void a() {
                    AddMoneyToGVActivity.this.a(true);
                }

                public final void b() {
                    AddMoneyToGVActivity.this.b(cJRRechargePayment);
                }

                public final void c() {
                    AddMoneyToGVActivity.this.a(false);
                    AddMoneyToGVActivity.this.b(cJRRechargePayment);
                }
            });
        } else {
            a(false);
            b(cJRRechargePayment);
        }
    }

    /* access modifiers changed from: private */
    public void b(CJRRechargePayment cJRRechargePayment) {
        Intent f2 = net.one97.paytm.helper.a.b().f((Activity) this);
        f2.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
        f2.putExtra("add_money_to_gv", true);
        net.one97.paytm.helper.a.b().a(cJRRechargePayment, f2);
        startActivityForResult(f2, 1006);
        a(false);
    }

    public void onCheckedChanged(RadioGroup radioGroup, int i2) {
        if (radioGroup != this.L) {
            return;
        }
        if (i2 == R.id.rb_gv_self) {
            this.j.setText(this.s);
            this.k.setText(this.t);
            this.M.setTypeface(Typeface.create("sans-serif-medium", 1));
            this.N.setTypeface(Typeface.create("sans-serif-medium", 0));
            this.n.setText(getString(R.string.uam_gv_proceed));
            this.O.setVisibility(8);
            this.Q.setVisibility(8);
            this.P.setVisibility(0);
            this.R.setText("");
            this.S.setText("");
            this.f48732h.setText("");
            d.a((Context) this, "add_money", "gv_for_self_selected", "/add-money", (String) null, (String) null);
        } else if (i2 == R.id.rb_gv_friends) {
            this.M.setTypeface(Typeface.create("sans-serif-medium", 0));
            this.N.setTypeface(Typeface.create("sans-serif-medium", 1));
            this.n.setText(getString(R.string.uam_gv_proceed));
            this.k.setText("");
            this.P.setVisibility(8);
            this.O.setVisibility(0);
            this.R.setText("");
            this.S.setText("");
            this.f48732h.setText("");
            d.a((Context) this, "add_money", "gv_for_family_selected", "/add-money", (String) null, (String) null);
        }
    }

    class a implements TextWatcher {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        private a() {
        }

        /* synthetic */ a(AddMoneyToGVActivity addMoneyToGVActivity, byte b2) {
            this();
        }

        public final void afterTextChanged(Editable editable) {
            if (editable.length() > 0 && !TextUtils.isEmpty(AddMoneyToGVActivity.this.f48732h.getText().toString())) {
                AddMoneyToGVActivity addMoneyToGVActivity = AddMoneyToGVActivity.this;
                String unused = addMoneyToGVActivity.B = addMoneyToGVActivity.A;
            }
            if (editable.length() > 0) {
                boolean unused2 = AddMoneyToGVActivity.this.H = false;
                if (AddMoneyToGVActivity.this.E != null) {
                    AddMoneyToGVActivity.this.E.b(-1);
                }
                AddMoneyToGVActivity.this.f48731g.setTextColor(androidx.core.content.b.c(AddMoneyToGVActivity.this, R.color.color_222222));
                String unused3 = AddMoneyToGVActivity.this.A = editable.toString();
            } else {
                AddMoneyToGVActivity.this.f48731g.setTextColor(androidx.core.content.b.c(AddMoneyToGVActivity.this, R.color.color_b8c2cb));
                if (!AddMoneyToGVActivity.this.H) {
                    String unused4 = AddMoneyToGVActivity.this.A = editable.toString();
                }
            }
            if (editable.length() <= 0 || TextUtils.isEmpty(AddMoneyToGVActivity.this.k.getText().toString()) || !AddMoneyToGVActivity.this.N.isChecked()) {
                AddMoneyToGVActivity.this.n.setText(AddMoneyToGVActivity.this.getString(R.string.uam_gv_proceed));
            } else {
                AddMoneyToGVActivity.this.n.setText(AddMoneyToGVActivity.this.getString(R.string.uam_gv_proceed_to_preview));
            }
            if (TextUtils.isEmpty(AddMoneyToGVActivity.this.A) || Integer.parseInt(AddMoneyToGVActivity.this.A.replace(AppConstants.COMMA, "")) <= 10000) {
                AddMoneyToGVActivity.this.u();
            } else {
                AddMoneyToGVActivity.this.f48732h.setText(AddMoneyToGVActivity.this.B);
            }
        }
    }

    class b implements TextWatcher {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        private b() {
        }

        /* synthetic */ b(AddMoneyToGVActivity addMoneyToGVActivity, byte b2) {
            this();
        }

        public final void afterTextChanged(Editable editable) {
            boolean unused = AddMoneyToGVActivity.this.x = false;
            AddMoneyToGVActivity.this.j.setText("");
            if (editable.length() > 0 && editable.length() == 10) {
                if (!AddMoneyToGVActivity.d(editable.toString())) {
                    Toast.makeText(AddMoneyToGVActivity.this, AddMoneyToGVActivity.this.getString(R.string.uam_gv_enter_valid_mobile_number), 0).show();
                } else if (editable.toString().equalsIgnoreCase(AddMoneyToGVActivity.this.t)) {
                    AddMoneyToGVActivity.this.o();
                } else if (com.paytm.utility.b.c((Context) AddMoneyToGVActivity.this)) {
                    AddMoneyToGVActivity.this.y.a(editable.toString());
                } else {
                    AddMoneyToGVActivity.this.h();
                    AddMoneyToGVActivity.this.k.setText("");
                }
            }
        }
    }

    private void t() {
        String f2 = net.one97.paytm.helper.a.b().f("gvSelectAmountList");
        if (!TextUtils.isEmpty(f2)) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            getResources().getDimension(R.dimen.uam_gv_select_amount_item_width);
            getResources().getDimension(R.dimen.uam_gv_select_amount_padding);
            getResources().getDimension(R.dimen.uam_gv_padding_start_rv);
            int i2 = displayMetrics.widthPixels;
            this.F = Arrays.asList(f2.split(AppConstants.COMMA));
            this.E = new net.one97.paytm.addmoney.togv.a.a(this.F, this);
            this.E.f48668a = -1;
        }
    }

    public final void a(int i2) {
        if (this.E != null) {
            this.f48732h.setText("");
            if (i2 != this.E.f48668a) {
                this.H = true;
                this.A = this.E.a(i2);
                this.E.b(i2);
            } else {
                this.H = false;
                this.A = "";
                this.E.b(-1);
            }
            u();
        }
    }

    /* access modifiers changed from: private */
    public void u() {
        if (!TextUtils.isEmpty(this.A)) {
            this.R.setVisibility(0);
            this.R.setTextColor(Color.rgb(139, 166, 193));
            if (this.A.equals("1")) {
                TextView textView = this.R;
                textView.setText(getString(R.string.uam_rupee) + " " + l.a(this.A.replace(AppConstants.COMMA, "")) + " only");
                return;
            }
            TextView textView2 = this.R;
            textView2.setText(getString(R.string.uam_rupees) + " " + l.a(this.A.replace(AppConstants.COMMA, "")) + " only");
            return;
        }
        this.R.setVisibility(8);
    }

    public final void h() {
        final h hVar = new h(this);
        hVar.setTitle(getResources().getString(R.string.no_connection));
        hVar.a(getResources().getString(R.string.no_internet));
        hVar.a(-3, getString(R.string.upi_ok), new View.OnClickListener() {
            public final void onClick(View view) {
                hVar.dismiss();
            }
        });
        hVar.show();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }

    private void v() {
        b bVar;
        EditText editText = this.k;
        if (!(editText == null || (bVar = this.p) == null)) {
            editText.removeTextChangedListener(bVar);
        }
        CustomAmountTextInputEditText customAmountTextInputEditText = this.f48732h;
        if (customAmountTextInputEditText != null && customAmountTextInputEditText != null) {
            customAmountTextInputEditText.removeTextChangedListener(this.o);
        }
    }

    public final void g() {
        final h hVar = new h(this);
        hVar.setTitle(getResources().getString(R.string.session_time_out));
        hVar.a(getResources().getString(R.string.uam_session_timed_out_msg));
        hVar.a(-3, getString(R.string.upi_ok), new View.OnClickListener() {
            public final void onClick(View view) {
                hVar.dismiss();
                AddMoneyToGVActivity.i(AddMoneyToGVActivity.this);
            }
        });
        hVar.show();
    }

    public final void b(final String str, String str2) {
        if (getLifecycle().a().isAtLeast(k.b.RESUMED)) {
            String string = getString(R.string.uam_error);
            if (NetworkCustomError.ErrorType.AuthFailureError.name().equalsIgnoreCase(str)) {
                string = getString(R.string.session_time_out);
            }
            String string2 = getString(R.string.uam_error_random);
            if (TextUtils.isEmpty(str2)) {
                str2 = string2;
            }
            final h hVar = new h(this);
            hVar.setTitle(string);
            hVar.a(str2);
            hVar.a(-3, getString(R.string.upi_ok), new View.OnClickListener() {
                public final void onClick(View view) {
                    if (NetworkCustomError.ErrorType.AuthFailureError.name().equalsIgnoreCase(str)) {
                        AddMoneyToGVActivity.i(AddMoneyToGVActivity.this);
                    }
                    hVar.dismiss();
                }
            });
            hVar.show();
        }
    }

    static /* synthetic */ void a(AddMoneyToGVActivity addMoneyToGVActivity, ContactItemModel contactItemModel) {
        addMoneyToGVActivity.S.setText("");
        if (com.paytm.utility.b.c((Context) addMoneyToGVActivity)) {
            addMoneyToGVActivity.Q.setVisibility(0);
            addMoneyToGVActivity.P.setVisibility(0);
            addMoneyToGVActivity.O.setVisibility(8);
            addMoneyToGVActivity.l.setVisibility(0);
            addMoneyToGVActivity.j.setText(contactItemModel.getName());
            addMoneyToGVActivity.k.setText(contactItemModel.getPhnNo());
            return;
        }
        addMoneyToGVActivity.h();
    }

    static /* synthetic */ void i(AddMoneyToGVActivity addMoneyToGVActivity) {
        net.one97.paytm.helper.a.b().h((Activity) addMoneyToGVActivity);
        Intent a2 = net.one97.paytm.helper.a.b().a((FragmentActivity) addMoneyToGVActivity);
        a2.addFlags(67108864);
        a2.addFlags(268435456);
        addMoneyToGVActivity.startActivity(a2);
        addMoneyToGVActivity.finish();
    }
}
