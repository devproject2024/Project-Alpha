package net.one97.paytm.p2b.view.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.NetworkCustomError;
import java.util.Arrays;
import java.util.List;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.wallet.CJRP2BStatus;
import net.one97.paytm.common.entity.wallet.CJRP2BStatusTxnWiseResponse;
import net.one97.paytm.common.entity.wallet.FeeDetailsBreakupList;
import net.one97.paytm.p2b.R;
import net.one97.paytm.p2b.a.b;
import net.one97.paytm.p2b.c.d;
import net.one97.paytm.p2b.d.g;
import net.one97.paytm.p2b.d.h;
import net.one97.paytm.p2b.d.k;
import net.one97.paytm.p2b.e.a;
import net.one97.paytm.p2b.view.c.c;
import net.one97.paytm.p2b.view.c.f;
import net.one97.paytm.upi.util.UpiConstants;

public class SendMoneyToBankActivity extends PaytmActivity implements View.OnClickListener, j.c, b.C1058b, g {

    /* renamed from: a  reason: collision with root package name */
    public static String f12799a;

    /* renamed from: b  reason: collision with root package name */
    private j f12800b;

    /* renamed from: c  reason: collision with root package name */
    private FrameLayout f12801c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public b.a f12802d;

    /* renamed from: e  reason: collision with root package name */
    private CJRP2BStatus f12803e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12804f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f12805g;

    /* renamed from: h  reason: collision with root package name */
    private c f12806h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f12807i;
    private LinearLayout j;
    private String k;
    private TextView l;
    private boolean m;
    /* access modifiers changed from: private */
    public a n;
    /* access modifiers changed from: private */
    public int o;
    private LottieAnimationView p;

    public void attachBaseContext(Context context) {
        if (h.b().e(context) != null) {
            super.attachBaseContext(h.b().e(context));
        } else {
            super.attachBaseContext(context);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean l2 = h.b().l();
        int m2 = h.b().m();
        if (l2 && m2 == 0) {
            startActivity(h.b().c((Context) this));
            finish();
        }
        setContentView(R.layout.p2b_activity_send_money_to_bank);
        this.n = (a) new al((ao) this, (al.b) al.a.a(getApplication())).a(a.class);
        this.n.a();
        a aVar = this.n;
        Integer valueOf = Integer.valueOf(getIntent().getIntExtra("extra_module_open_source", 0));
        if (valueOf == null || valueOf.intValue() != 1) {
            aVar.p = null;
        } else {
            aVar.p = CJRPGTransactionRequestUtils.PAYER_BANK_NAME;
        }
        this.n.f12768b.observe(this, new z<net.one97.paytm.p2b.data.a<Integer>>() {
            public final /* synthetic */ void onChanged(Object obj) {
                net.one97.paytm.p2b.data.a aVar = (net.one97.paytm.p2b.data.a) obj;
                if (aVar != null && aVar.f12730b != null) {
                    int unused = SendMoneyToBankActivity.this.o = ((Integer) aVar.f12730b).intValue();
                }
            }
        });
        this.n.f12771e.observe(this, new z<Boolean>() {
            public final /* synthetic */ void onChanged(Object obj) {
                if (((Boolean) obj).booleanValue()) {
                    SendMoneyToBankActivity.this.n.a();
                }
            }
        });
        a(getIntent());
    }

    private void f() {
        this.f12801c = (FrameLayout) findViewById(R.id.fl_fragment_container);
        this.f12802d = new d(this, getClass().getName(), net.one97.paytm.p2b.data.a.b.a((Context) this));
        this.j = (LinearLayout) findViewById(R.id.ll_kyc);
        this.l = (TextView) findViewById(R.id.proceed_btn);
        this.p = (LottieAnimationView) findViewById(R.id.lav_progress);
        this.l.setOnClickListener(this);
        this.f12805g = (ImageView) findViewById(R.id.iv_back);
        this.f12805g.setOnClickListener(this);
    }

    private void a(Intent intent) {
        this.f12800b = getSupportFragmentManager();
        this.f12800b.a((j.c) this);
        f();
        j();
        b(intent);
        g();
    }

    private void b(Intent intent) {
        if (intent != null) {
            try {
                this.m = intent.getBooleanExtra(net.one97.paytm.p2b.d.c.f12679i, false);
                this.f12804f = intent.getBooleanExtra(UpiConstants.EXTRA_KEY_IS_FROM_PASSBOOK, false);
                String stringExtra = intent.getStringExtra(net.one97.paytm.p2b.d.c.f12671a);
                f12799a = intent.getStringExtra("key_source");
                if (!TextUtils.isEmpty(stringExtra)) {
                    this.f12802d.a(a(stringExtra));
                }
            } catch (Exception unused) {
            }
        }
    }

    private static double a(String str) {
        try {
            return Double.parseDouble(str);
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    private void g() {
        this.k = i();
        String k2 = h.b().k();
        List asList = !TextUtils.isEmpty(k2) ? Arrays.asList(k2.split("\\s*,\\s*")) : null;
        if (asList == null || !asList.contains(this.k)) {
            this.j.setVisibility(8);
            this.f12801c.setVisibility(0);
            if (com.paytm.utility.b.c((Context) this)) {
                this.f12802d.j();
            } else {
                h();
            }
        } else {
            this.j.setVisibility(0);
            this.f12801c.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        c.a aVar = new c.a(this);
        aVar.a((CharSequence) getString(R.string.no_connection));
        aVar.b((CharSequence) getString(R.string.no_internet));
        aVar.a((CharSequence) getString(R.string.network_retry_yes), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                if (com.paytm.utility.b.c((Context) SendMoneyToBankActivity.this)) {
                    SendMoneyToBankActivity.this.f12802d.j();
                } else {
                    SendMoneyToBankActivity.this.h();
                }
            }
        });
        aVar.b();
    }

    public final void b() {
        k.a(this.p);
    }

    public final void c() {
        k.b(this.p);
    }

    public final void a(NetworkCustomError networkCustomError) {
        if (!isFinishing()) {
            String canonicalName = SendMoneyToBankActivity.class.getCanonicalName();
            Boolean bool = Boolean.FALSE;
            k.a((Activity) this, networkCustomError, canonicalName);
        }
    }

    public final void a(CJRP2BStatus cJRP2BStatus) {
        String str;
        double d2;
        double d3;
        double d4;
        this.f12803e = cJRP2BStatus;
        try {
            CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) getIntent().getSerializableExtra("extra_home_data");
            if (cJRHomePageItem != null) {
                String bankUserName = cJRHomePageItem.getBankUserName();
                String bankAccountNumber = cJRHomePageItem.getBankAccountNumber();
                String ifsc = cJRHomePageItem.getIfsc();
                String bankAmount = cJRHomePageItem.getBankAmount();
                cJRHomePageItem.getBankComment();
                this.f12802d.a(bankAccountNumber, bankUserName, ifsc, false, (String) null, (String) null);
                CJRP2BStatusTxnWiseResponse statusTxnWiseResponse = this.f12803e.getResponse().getStatusTxnWiseResponse();
                double parseDouble = !TextUtils.isEmpty(statusTxnWiseResponse.getFixedCommission()) ? Double.parseDouble(statusTxnWiseResponse.getFixedCommission()) : 0.0d;
                double parseDouble2 = !TextUtils.isEmpty(statusTxnWiseResponse.getFloatCommission()) ? Double.parseDouble(statusTxnWiseResponse.getFloatCommission()) : 0.0d;
                if (!TextUtils.isEmpty(bankAmount)) {
                    double parseDouble3 = Double.parseDouble(bankAmount);
                    d3 = parseDouble2;
                    d4 = parseDouble3;
                    d2 = k.b(parseDouble3, parseDouble2);
                } else {
                    d4 = 0.0d;
                    d3 = 0.0d;
                    d2 = 0.0d;
                }
                if (!TextUtils.isEmpty(bankAmount) && !TextUtils.isEmpty(bankUserName) && !TextUtils.isEmpty(bankAccountNumber) && !TextUtils.isEmpty(ifsc)) {
                    this.f12807i = true;
                }
                this.f12802d.a(d4, d3, parseDouble2, d2, parseDouble);
            }
        } catch (Exception unused) {
        }
        q a2 = this.f12800b.a();
        if (this.f12802d.b() > 0.0d) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f12802d.b());
            str = sb.toString();
        } else {
            str = "";
        }
        a2.a(R.id.fl_fragment_container, (Fragment) net.one97.paytm.p2b.view.c.h.a(this.m, str, this.f12803e));
        a2.c();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        Fragment c2 = this.f12800b.c(R.id.fl_fragment_container);
        if (c2 != null) {
            c2.onActivityResult(i2, i3, intent);
        }
        if (i2 == 3 && i3 == -1) {
            this.n.a();
        }
    }

    private String i() {
        return h.b().d((Context) this);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.proceed_btn) {
            h.b().a((Activity) this);
        } else if (id == R.id.iv_back) {
            onBackPressed();
        }
    }

    public void onBackPressed() {
        Fragment c2 = this.f12800b.c(R.id.fl_fragment_container);
        if (c2 instanceof net.one97.paytm.p2b.view.c.c) {
            h.b().j();
        }
        super.onBackPressed();
        if (c2 != null && (c2 instanceof net.one97.paytm.p2b.view.c.d) && this.o == 0) {
            getSupportFragmentManager().a((String) null, 0);
        }
    }

    public final void a() {
        if (this.f12800b.c(R.id.fl_fragment_container) == null) {
        }
    }

    private void j() {
        List<Fragment> d2 = this.f12800b.f3424a.d();
        if (d2 != null && d2.size() > 0) {
            for (Fragment a2 : d2) {
                this.f12800b.a().a(a2).c();
            }
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }

    public final void a(double d2, double d3, double d4, double d5, double d6) {
        this.f12802d.a(d2, d3, d5, d4, d6);
    }

    public final void d() {
        q a2 = this.f12800b.a();
        Fragment a3 = net.one97.paytm.p2b.view.c.d.a(this.f12802d.b());
        a2.a(R.anim.p2b_fade_in, R.anim.p2b_fade_out, R.anim.p2b_fade_in, R.anim.p2b_fade_out);
        a2.a(R.id.fl_fragment_container, a3);
        a2.a(net.one97.paytm.p2b.view.c.d.class.getName());
        a2.c();
    }

    public final void a(String str, String str2, String str3, boolean z, String str4, String str5) {
        this.f12802d.a(str, str2, str3, z, str4, str5);
    }

    public final void a(boolean z) {
        q a2 = this.f12800b.a();
        f a3 = f.a(this.f12802d.b(), this.f12802d.c(), this.f12802d.d(), this.f12802d.e(), z, this.m);
        a2.a(R.anim.p2b_fade_in, R.anim.p2b_fade_out, R.anim.p2b_fade_in, R.anim.p2b_fade_out);
        a2.a(R.id.fl_fragment_container, (Fragment) a3);
        a2.a(a3.getClass().getName());
        a2.c();
    }

    public final void b(boolean z) {
        q a2 = this.f12800b.a();
        String g2 = this.f12802d.g();
        String h2 = this.f12802d.h();
        String i2 = this.f12802d.i();
        String k2 = this.f12802d.k();
        String l2 = this.f12802d.l();
        double c2 = this.f12802d.c();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f12802d.b());
        this.f12806h = net.one97.paytm.p2b.view.c.c.a(g2, h2, i2, z, k2, l2, c2, sb.toString(), this.f12802d.f(), this.f12802d.d(), this.m);
        a2.a(R.anim.p2b_fade_in, R.anim.p2b_fade_out, R.anim.p2b_fade_in, R.anim.p2b_fade_out);
        a2.a(R.id.fl_fragment_container, (Fragment) this.f12806h);
        a2.a(net.one97.paytm.p2b.view.c.c.class.getName());
        a2.c();
    }

    public final void a(double d2, List<FeeDetailsBreakupList> list) {
        String a2 = k.a(this.f12802d.d());
        if (d2 != 0.0d) {
            a2 = k.a(d2);
        }
        k.a((Activity) this);
        View inflate = getLayoutInflater().inflate(R.layout.p2b_informatory_popup, (ViewGroup) null);
        final com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(this, R.style.p2bAppBottomSheetDialogTheme);
        aVar.setContentView(inflate);
        final BottomSheetBehavior from = BottomSheetBehavior.from((View) inflate.getParent());
        aVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                from.setState(4);
                k.a((Activity) SendMoneyToBankActivity.this);
            }
        });
        from.setBottomSheetCallback(new BottomSheetBehavior.a() {
            public final void onStateChanged(View view, int i2) {
            }

            public final void onSlide(View view, float f2) {
                aVar.cancel();
            }
        });
        from.setState(2);
        from.setPeekHeight(com.paytm.utility.b.b((Activity) this));
        aVar.getWindow().setSoftInputMode(16);
        aVar.show();
        inflate.findViewById(R.id.iv_cross).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                aVar.cancel();
            }
        });
        inflate.findViewById(R.id.tv_i_understand).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                aVar.cancel();
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.tv_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_info_via_money_transfer);
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_pop_up_text);
        TextView textView4 = (TextView) inflate.findViewById(R.id.tv_rbi_guideline);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_transfer_flow);
        if (list == null || list.size() <= 1) {
            textView.setText(getString(R.string.p2b_interest_charge, new Object[]{a2}));
            textView4.setText(getString(R.string.p2b_rbi_guideline, new Object[]{a2}));
        } else {
            textView.setText(getString(R.string.p2b_slab_heading));
            textView4.setText(k.a((Context) this, list));
        }
        textView3.setVisibility(8);
        textView4.setVisibility(0);
        textView2.setVisibility(0);
        imageView.setVisibility(0);
        try {
            String string = getString(R.string.p2b_recommend_via_money_transfer);
            SpannableString spannableString = new SpannableString(string);
            int indexOf = string.indexOf(getString(R.string.p2b_money_transfer));
            if (indexOf > 0) {
                spannableString.setSpan(new ClickableSpan() {
                    public final void onClick(View view) {
                        SendMoneyToBankActivity.this.startActivity(h.b().b((Context) SendMoneyToBankActivity.this));
                        SendMoneyToBankActivity.this.finish();
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(SendMoneyToBankActivity.this.getResources().getColor(R.color.p2b_blue));
                        textPaint.setUnderlineText(false);
                    }
                }, indexOf, getString(R.string.p2b_recommend_via_money_transfer).length(), 33);
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
            }
            textView2.setText(spannableString);
        } catch (Exception unused) {
        }
    }

    public final void e() {
        net.one97.paytm.p2b.b.a b2 = h.b();
        new NetworkCustomError();
        b2.a((Activity) this, (String) null, true);
    }
}
