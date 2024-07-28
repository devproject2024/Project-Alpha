package net.one97.paytm.p2mNewDesign.b;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Response;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b;
import net.one97.paytm.p2mNewDesign.a.d;
import net.one97.paytm.p2mNewDesign.e.a;
import net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.f.g;
import net.one97.paytm.p2mNewDesign.f.h;
import net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2;
import net.one97.paytm.p2mNewDesign.models.PaymentModesV2;
import net.one97.paytm.wallet.R;

public final class c extends a implements View.OnClickListener, Response.Listener<IJRDataModel>, net.one97.paytm.p2mNewDesign.PaymentOptions.b.a, h {
    private static String x = "offline_payments";

    /* renamed from: a  reason: collision with root package name */
    int[] f13235a = new int[2];

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f13236b;

    /* renamed from: d  reason: collision with root package name */
    private d f13237d;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.p2mNewDesign.PaymentOptions.a.a f13238e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f13239f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f13240g;

    /* renamed from: h  reason: collision with root package name */
    private int f13241h = -1;

    /* renamed from: i  reason: collision with root package name */
    private PaymentModesV2 f13242i;
    private CJRFetchPayMethodResponse j;
    private PaymentModesV2 k;
    private ProgressDialog l;
    private Context m;
    private View n;
    private LinearLayout o;
    private boolean p;
    private TextView q;
    private String r;
    private RelativeLayout s;
    private g t;
    private boolean u;
    private RadioButton v;
    private boolean w;
    private InstrumentInfo y;

    public final String a() {
        return "NET_BANKING";
    }

    public final boolean a(List<net.one97.paytm.p2mNewDesign.db.b.a> list) {
        return false;
    }

    public final void b() {
    }

    public final void b(boolean z) {
    }

    public final void i() {
    }

    public final /* synthetic */ void onResponse(Object obj) {
        IJRDataModel iJRDataModel = (IJRDataModel) obj;
        if (iJRDataModel instanceof CJRFetchPayMethodResponse) {
            ProgressDialog progressDialog = this.l;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.l.dismiss();
                this.l = null;
            }
            this.j = (CJRFetchPayMethodResponse) iJRDataModel;
            this.k = this.f13242i;
            this.f13238e = new net.one97.paytm.p2mNewDesign.PaymentOptions.a.a(this.m, this.k.getPayChannelOptions(), this.f13241h, this);
            this.f13238e.setTitle(this.m.getString(R.string.select_banks));
            this.f13238e.show();
        }
    }

    public final void a(Context context, InstrumentInfo instrumentInfo, InstrumentInfo instrumentInfo2, String str, boolean z) {
        this.m = context;
        this.y = instrumentInfo;
        this.n = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.lyt_netbanking_card, (ViewGroup) null);
        View view = this.n;
        this.o = (LinearLayout) view;
        this.s = (RelativeLayout) view.findViewById(R.id.rl_pay_mode_pg);
        this.s.setOnClickListener(this);
        this.q = (TextView) this.n.findViewById(R.id.tv_pay_mode);
        this.v = (RadioButton) this.n.findViewById(R.id.rb_instrumentInfo);
        this.v.setOnClickListener(this);
        this.r = instrumentInfo.getPayMode();
        this.q.setText(this.m.getString(R.string.net_banking));
        this.f13236b = (RecyclerView) this.n.findViewById(R.id.rec_bank_list);
        this.f13239f = (TextView) this.n.findViewById(R.id.txt_other_bank);
        if (b.f().n != null && b.f().n.getPayMode().equalsIgnoreCase("NET_BANKING")) {
            this.v.setButtonDrawable(androidx.core.content.b.a(this.m, R.drawable.ic_radio_active));
            this.t.f(true);
            this.t.a(b.f().n, "sectionClose");
            this.t.a(b.f().n, "uncheck");
            this.u = true;
            l();
            m();
            List<InstrumentInfo> a2 = b.f().a(false);
            String displaySecondaryInfo = b.f().n.getDisplaySecondaryInfo();
            if (a2 != null && a2.size() > 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= a2.size()) {
                        break;
                    } else if (a2.get(i2).getDisplaySecondaryInfo().equalsIgnoreCase(displaySecondaryInfo)) {
                        this.w = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == a2.size()) {
                    this.w = false;
                }
            }
        }
        b.f();
        if (!b.q("NET_BANKING")) {
            this.n.setAlpha(0.4f);
        }
    }

    public final void a(boolean z) {
        if (z) {
            this.n.findViewById(R.id.rl_pay_mode_pg).performClick();
        } else {
            d();
        }
    }

    public final View c() {
        return this.n;
    }

    public final void onClick(View view) {
        String str;
        int id = view.getId();
        if (id == R.id.select_other_bank) {
            this.t.r();
        } else if (id != R.id.rb_instrumentInfo && id != R.id.rl_pay_mode_pg) {
        } else {
            if (b.f().J == null || b.f().H == null || !b.f().L) {
                this.t.n();
                b.f();
                if (!b.q("NET_BANKING")) {
                    g gVar = this.t;
                    if ("0".equalsIgnoreCase(b.f().A)) {
                        str = this.m.getResources().getString(R.string.limit_breach_msg);
                    } else {
                        str = String.format(this.m.getResources().getString(R.string.limit_breach_msg_with_amount_new), new Object[]{b.f().A});
                    }
                    gVar.a(str, false, false);
                    return;
                }
                if (!this.u) {
                    this.f13236b.setVisibility(0);
                    InstrumentInfo instrumentInfo = new InstrumentInfo();
                    instrumentInfo.setPayMode("NET_BANKING");
                    this.v.setButtonDrawable(androidx.core.content.b.a(this.m, R.drawable.ic_radio_active));
                    this.t.d("NET_BANKING");
                    this.t.f(true);
                    this.q.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
                    this.t.a(instrumentInfo, "updateSelection");
                    this.t.a(instrumentInfo, "sectionClose");
                    this.t.a(instrumentInfo, "uncheck");
                    this.u = true;
                    l();
                    m();
                }
                if (b.f().f13092h) {
                    a("offline_payments", "post_scan_netbanking_payment", "flow_through_scan_icon", this.m, "home/pay-send/post-scan/bank-details-entered");
                } else {
                    a("offline_payments", "post_pay_netbanking_payment", "flow_through_pay_icon", this.m, "home/pay-send/post-scan/bank-details-entered");
                }
            } else {
                this.f51247c = false;
            }
        }
    }

    private void l() {
        new Handler().postDelayed(new Runnable() {
            public final void run() {
            }
        }, 200);
    }

    private void m() {
        this.f13237d = new d(this.m, this.t, this.p, b.f().n.getDisplaySecondaryInfo(), this);
        this.f13236b.setLayoutManager(new GridLayoutManager(this.m, 3));
        this.f13236b.setItemAnimator(new androidx.recyclerview.widget.g());
        this.f13236b.setAdapter(this.f13237d);
        this.f13236b.setNestedScrollingEnabled(false);
        this.f13236b.setVisibility(0);
    }

    public final void a(PayChannelOptionsV2 payChannelOptionsV2, int i2) {
        if (payChannelOptionsV2 != null) {
            this.f13241h = i2;
            this.f13239f.setText(payChannelOptionsV2.getChannelCode());
            this.f13240g.setVisibility(0);
        }
        net.one97.paytm.p2mNewDesign.PaymentOptions.a.a aVar = this.f13238e;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    public final void a(g gVar) {
        this.t = gVar;
    }

    public final void d() {
        this.v.setButtonDrawable(androidx.core.content.b.a(this.m, R.drawable.ic_radio_inactive));
        this.q.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        this.u = false;
        this.f13236b.setVisibility(8);
    }

    public final void h() {
        this.t.r();
    }

    public final String e() {
        return this.y.getPriority();
    }

    public final boolean f() {
        if (this.y.getmIsDisabled() == null) {
            return false;
        }
        return this.y.getmIsDisabled().getStatus().booleanValue();
    }

    public final void j() {
        this.n.setAlpha(0.4f);
    }

    public final void k() {
        this.n.setAlpha(1.0f);
    }

    public final void a(String str) {
        if (Double.parseDouble(TextUtils.isEmpty(b.f().A) ? "0" : b.f().A) < Double.valueOf(str).doubleValue()) {
            b.f();
            if (!b.q("NET_BANKING")) {
                if (b.f().n != null && "NET_BANKING".equalsIgnoreCase(b.f().n.getPayMode())) {
                    this.t.a("0".equalsIgnoreCase(b.f().A) ? this.m.getResources().getString(R.string.limit_breach_msg) : String.format(this.m.getResources().getString(R.string.limit_breach_msg_with_amount_new), new Object[]{b.f().A}), false, false);
                }
                if (b.f().n != null && "NET_BANKING".equalsIgnoreCase(b.f().n.getPayMode())) {
                    this.t.s();
                    d();
                }
                this.n.setAlpha(0.4f);
                return;
            }
            return;
        }
        this.n.setAlpha(1.0f);
    }

    public final void g() {
        ArrayList arrayList;
        int i2;
        List<InstrumentInfo> list = this.f13237d.f13157b;
        String displaySecondaryInfo = b.f().n.getDisplaySecondaryInfo();
        if (list == null || list.size() <= 0) {
            arrayList = null;
        } else {
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                } else if (list.get(i3).getDisplaySecondaryInfo().equalsIgnoreCase(displaySecondaryInfo)) {
                    this.w = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 == list.size()) {
                int i4 = 0;
                while (true) {
                    if (i4 >= list.size()) {
                        i2 = 0;
                        break;
                    } else if (list.get(i4).isMore()) {
                        i2 = i4 - 1;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (i2 >= 0 && i2 < list.size()) {
                    list.remove(i2);
                    list.add(i2, b.f().n);
                    this.w = false;
                }
            }
            arrayList = new ArrayList(list);
        }
        if (arrayList != null) {
            String displaySecondaryInfo2 = b.f().n.getDisplaySecondaryInfo();
            d dVar = this.f13237d;
            dVar.f13156a = displaySecondaryInfo2;
            dVar.f13157b = arrayList;
            dVar.notifyDataSetChanged();
        }
    }
}
