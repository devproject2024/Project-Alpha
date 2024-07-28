package net.one97.paytm.paymentsBank.f.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import d.a.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.bankCommon.model.CustProductStatus;
import net.one97.paytm.bankOpen.activity.PaymentsBankBaseActivity;
import net.one97.paytm.bankOpen.ica.activity.ICAAccountOpeningActivity;
import net.one97.paytm.payments.activity.AJRChangePasscode;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.biometricAuthWall.BiometricSettingsActivity;
import net.one97.paytm.paymentsBank.download.activity.DownloadActivity;
import net.one97.paytm.paymentsBank.f.b.a;
import net.one97.paytm.paymentsBank.fragment.b;
import net.one97.paytm.paymentsBank.utils.j;
import net.one97.paytm.paymentsBank.utils.n;
import net.one97.paytm.paymentsBank.utils.o;

public final class a implements g.a, g.b<IJRPaytmDataModel> {

    /* renamed from: a  reason: collision with root package name */
    public b f18317a;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.paymentsBank.f.b f18318b;

    /* renamed from: c  reason: collision with root package name */
    private View f18319c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f18320d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f18321e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f18322f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f18323g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f18324h;

    /* renamed from: i  reason: collision with root package name */
    private RecyclerView f18325i;
    private net.one97.paytm.paymentsBank.f.a j;
    private boolean k = true;
    private CustProductList l;
    private AppCompatImageView m;
    private ViewGroup n;
    private View o;

    public final /* synthetic */ void onResponse(Object obj) {
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        com.paytm.utility.b.Z((Context) this.f18317a.getActivity());
        if (iJRPaytmDataModel instanceof CustProductStatus) {
            Intent intent = new Intent(this.f18317a.getActivity(), DownloadActivity.class);
            if (((CustProductStatus) iJRPaytmDataModel).getPanRec().equals("Y")) {
                intent.putExtra("SHOW_TDS", true);
            }
            this.f18317a.startActivity(intent);
        } else if (iJRPaytmDataModel instanceof CustProductList) {
            CustProductList custProductList = (CustProductList) iJRPaytmDataModel;
            this.k = false;
            ArrayList arrayList = new ArrayList();
            net.one97.paytm.paymentsBank.f.b.a aVar = new net.one97.paytm.paymentsBank.f.b.a();
            aVar.f18337a = 1;
            aVar.f18338b = this.f18320d.getText().toString().toUpperCase();
            arrayList.add(aVar);
            net.one97.paytm.paymentsBank.f.b.a aVar2 = new net.one97.paytm.paymentsBank.f.b.a();
            aVar2.f18337a = 2;
            net.one97.paytm.paymentsBank.utils.a aVar3 = net.one97.paytm.paymentsBank.utils.a.f19494a;
            String i2 = net.one97.paytm.paymentsBank.utils.a.i(this.l);
            aVar2.f18341e = i2;
            if (i2.equals("ISA")) {
                aVar2.f18338b = this.f18317a.getString(R.string.pb_drawer_isa);
            } else if (i2.equals("ICA")) {
                aVar2.f18338b = this.f18317a.getString(R.string.pb_drawer_ica);
            }
            net.one97.paytm.paymentsBank.utils.a aVar4 = net.one97.paytm.paymentsBank.utils.a.f19494a;
            String f2 = net.one97.paytm.paymentsBank.utils.a.a(this.l, true);
            aVar2.f18339c = this.f18317a.getString(R.string.ica_acc_no, f2);
            aVar2.f18340d = f2;
            net.one97.paytm.paymentsBank.utils.a aVar5 = net.one97.paytm.paymentsBank.utils.a.f19494a;
            aVar2.f18342f = net.one97.paytm.paymentsBank.utils.a.b(this.l, true);
            aVar2.f18343g = true;
            net.one97.paytm.paymentsBank.f.b.a aVar6 = new net.one97.paytm.paymentsBank.f.b.a();
            aVar6.f18337a = 2;
            net.one97.paytm.paymentsBank.utils.a aVar7 = net.one97.paytm.paymentsBank.utils.a.f19494a;
            String i3 = net.one97.paytm.paymentsBank.utils.a.i(custProductList);
            aVar6.f18341e = i3;
            if (i3.equals("ISA")) {
                aVar6.f18338b = this.f18317a.getString(R.string.pb_drawer_isa);
            } else if (i3.equals("ICA")) {
                aVar6.f18338b = this.f18317a.getString(R.string.pb_drawer_ica);
            }
            net.one97.paytm.paymentsBank.utils.a aVar8 = net.one97.paytm.paymentsBank.utils.a.f19494a;
            String a2 = net.one97.paytm.paymentsBank.utils.a.a(custProductList, false);
            b bVar = this.f18317a;
            int i4 = R.string.ica_acc_no;
            Object[] objArr = new Object[1];
            objArr[0] = a2 != null ? a2 : "NA";
            aVar6.f18339c = bVar.getString(i4, objArr);
            aVar6.f18340d = a2;
            net.one97.paytm.paymentsBank.utils.a aVar9 = net.one97.paytm.paymentsBank.utils.a.f19494a;
            aVar6.f18342f = net.one97.paytm.paymentsBank.utils.a.b(custProductList, false);
            if (i2.equals("ICA")) {
                arrayList.add(aVar6);
                arrayList.add(aVar2);
            } else {
                arrayList.add(aVar2);
                arrayList.add(aVar6);
            }
            this.j = new net.one97.paytm.paymentsBank.f.a(this.f18317a.getActivity(), arrayList);
            net.one97.paytm.paymentsBank.f.a aVar10 = this.j;
            aVar10.f18313b = new net.one97.paytm.paymentsBank.h.b() {
                public final void onClick(View view, int i2, Object obj) {
                    a.this.a(view, i2, (a) obj);
                }
            };
            this.f18325i.setAdapter(aVar10);
            this.m.setImageDrawable(androidx.core.content.b.a(this.f18317a.getContext(), R.drawable.pb_drawer_up_svg));
        }
    }

    public a(b bVar, View view) {
        this.f18317a = bVar;
        this.f18319c = view;
    }

    public final void a() {
        c.a().a((Object) this, false);
        this.f18320d = (TextView) this.f18319c.findViewById(R.id.tv_name);
        this.f18321e = (TextView) this.f18319c.findViewById(R.id.tv_acc_type);
        this.f18322f = (TextView) this.f18319c.findViewById(R.id.tv_acc_no);
        this.f18323g = (TextView) this.f18319c.findViewById(R.id.tv_ifsc_code);
        this.f18324h = (TextView) this.f18319c.findViewById(R.id.share_tv);
        this.m = (AppCompatImageView) this.f18319c.findViewById(R.id.arrow_iv);
        this.m.setVisibility(8);
        this.f18321e.setVisibility(8);
        this.n = (ViewGroup) this.f18319c.findViewById(R.id.tooltip_lyt);
        this.o = this.f18319c.findViewById(R.id.tooltip_arrow);
        this.f18320d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.onClick(view);
            }
        });
        this.f18324h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.onClick(view);
            }
        });
        ((ImageView) this.f18319c.findViewById(R.id.iv_profile)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.onClick(view);
            }
        });
        o.a().getNameFromKyc(this.f18317a.getActivity(), new d() {
            public final void onFragmentAction(int i2, Object obj) {
                a.this.a(i2, obj);
            }
        });
        ((ViewGroup) this.f18319c.findViewById(R.id.switch_acc_lyt)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.b(view);
            }
        });
        this.m.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.a(view);
            }
        });
        this.f18325i = (RecyclerView) this.f18319c.findViewById(R.id.rv_menu);
        this.f18325i.setLayoutManager(new LinearLayoutManager(this.f18317a.getActivity(), 1, false));
        this.f18325i.setNestedScrollingEnabled(false);
        this.f18318b = new net.one97.paytm.paymentsBank.f.b(this.f18317a.getActivity(), net.one97.paytm.paymentsBank.f.c.a.a(this.f18317a, false));
        this.f18325i.setAdapter(this.f18318b);
        this.f18318b.f18333b = new net.one97.paytm.paymentsBank.h.b() {
            public final void onClick(View view, int i2, Object obj) {
                a.this.a(view, i2, (net.one97.paytm.paymentsBank.f.b.b) obj);
            }
        };
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, Object obj) {
        this.f18320d.setText((String) obj);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        e();
        b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        e();
        b();
    }

    private void b() {
        if (n.g()) {
            if (this.k) {
                net.one97.paytm.paymentsBank.f.a aVar = this.j;
                if (aVar == null) {
                    com.paytm.utility.b.k(this.f18317a.getActivity(), this.f18317a.getString(R.string.pb_please_wait));
                    String str = "ISA";
                    if (j.a().equals(str)) {
                        str = "ICA";
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("screen_name", getClass().getSimpleName());
                    f a2 = net.one97.paytm.paymentsBank.b.a.a((Context) this.f18317a.getActivity(), (g.b<IJRPaytmDataModel>) this, (g.a) this, a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap, str);
                    a2.f16270b = "custProductListApi";
                    o.a().getApplicationContext();
                    new net.one97.paytm.bankCommon.g.c();
                    net.one97.paytm.bankCommon.g.c.a(a2);
                } else {
                    this.k = false;
                    this.f18325i.setAdapter(aVar);
                }
            } else {
                this.k = true;
                this.f18325i.setAdapter(this.f18318b);
            }
            this.m.setImageDrawable(androidx.core.content.b.a(this.f18317a.getContext(), this.k ? R.drawable.pb_drawer_down_svg : R.drawable.pb_drawer_up_svg));
        } else if (!this.f18318b.equals(this.f18325i.getAdapter())) {
            this.f18325i.setAdapter(this.f18318b);
        }
    }

    public final void onClick(View view) {
        d();
        if (view.getId() == R.id.tv_name) {
            c();
        } else if (view.getId() == R.id.share_tv) {
            this.f18317a.l();
        } else if (view.getId() == R.id.iv_profile) {
            c();
        }
    }

    private void c() {
        net.one97.paytm.payments.c.c.b bVar = net.one97.paytm.payments.c.c.b.f17264a;
        if (net.one97.paytm.payments.c.c.b.c()) {
            net.one97.paytm.payments.c.c.b bVar2 = net.one97.paytm.payments.c.c.b.f17264a;
            net.one97.paytm.payments.c.c.b.b(this.f18317a.getActivity(), new Bundle());
            return;
        }
        o.a().openProfile(this.f18317a.getActivity());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view, int i2, net.one97.paytm.paymentsBank.f.b.b bVar) {
        d();
        if (bVar.f18350a == 3) {
            this.f18317a.j();
            return;
        }
        switch (bVar.f18351b) {
            case 101:
                this.f18317a.m();
                return;
            case 102:
                if (!com.paytm.utility.b.c((Context) this.f18317a.getActivity())) {
                    this.f18317a.r();
                    return;
                }
                com.paytm.utility.b.k(this.f18317a.getActivity(), this.f18317a.getString(R.string.pb_please_wait));
                new net.one97.paytm.paymentsBank.slfd.a.a.b.a(this.f18317a.getActivity()).a((Context) this.f18317a.getActivity(), (g.b<IJRPaytmDataModel>) this, (g.a) this, j.a());
                return;
            case 103:
                this.f18317a.a(7);
                return;
            case 104:
                this.f18317a.getActivity();
                net.one97.paytm.bankCommon.mapping.g.a();
                o.a().openWebViewActivity(this.f18317a.getActivity(), net.one97.paytm.bankCommon.utils.d.a("ratesAndChargesUrl"), this.f18317a.getString(R.string.pb_pdc_rate_and_charges));
                return;
            case 105:
                this.f18317a.i();
                return;
            case 106:
                this.f18317a.p();
                return;
            case 108:
                o.a().openHelpAndSupport(this.f18317a.getActivity(), true);
                return;
            case 109:
                this.f18317a.startActivity(new Intent(this.f18317a.getActivity(), AJRChangePasscode.class));
                return;
            case 111:
                o.a().openLanguageChangeActivity(this.f18317a.getActivity());
                return;
            case 113:
                net.one97.paytm.paymentsBank.h.a a2 = o.a();
                FragmentActivity activity = this.f18317a.getActivity();
                String stringFromGTM = o.a().getStringFromGTM("pb_blog_url");
                if (!URLUtil.isValidUrl(stringFromGTM)) {
                    stringFromGTM = "https://www.paytmbank.com/blog/";
                }
                a2.openWebViewActivity(activity, stringFromGTM, this.f18317a.getString(R.string.drawer_heading_blog));
                return;
            case 114:
                b bVar2 = this.f18317a;
                bVar2.startActivityForResult(new Intent(bVar2.getActivity(), BiometricSettingsActivity.class), 1205);
                return;
            default:
                return;
        }
    }

    public final void onEvent(CustProductList custProductList) {
        try {
            this.l = custProductList;
            net.one97.paytm.paymentsBank.utils.a aVar = net.one97.paytm.paymentsBank.utils.a.f19494a;
            String i2 = net.one97.paytm.paymentsBank.utils.a.i(custProductList);
            if ("ISA".equals(i2)) {
                this.f18321e.setText("Savings Account");
            } else if ("ICA".equals(i2)) {
                this.f18321e.setText("Current Account");
            }
            TextView textView = this.f18322f;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f18317a.getString(R.string.pb_drawer_acno));
            sb.append(" ");
            net.one97.paytm.paymentsBank.utils.a aVar2 = net.one97.paytm.paymentsBank.utils.a.f19494a;
            sb.append(net.one97.paytm.paymentsBank.utils.a.a(custProductList, true));
            textView.setText(sb.toString());
            TextView textView2 = this.f18323g;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f18317a.getString(R.string.pb_drawer_ifsc));
            sb2.append(": ");
            net.one97.paytm.paymentsBank.utils.a aVar3 = net.one97.paytm.paymentsBank.utils.a.f19494a;
            sb2.append(net.one97.paytm.paymentsBank.utils.a.b(custProductList, true));
            textView2.setText(sb2.toString());
            this.f18324h.setVisibility(0);
        } catch (Exception unused) {
        }
    }

    private void d() {
        new Handler().post(new Runnable() {
            public final void run() {
                a.this.f();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f() {
        ((DrawerLayout) this.f18317a.getView().findViewById(R.id.drawer_layout)).a(false);
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        com.paytm.utility.b.Z((Context) this.f18317a.getActivity());
        this.m.setImageDrawable(androidx.core.content.b.a(this.f18317a.getContext(), this.k ? R.drawable.pb_drawer_down_svg : R.drawable.pb_drawer_up_svg));
    }

    private void e() {
        this.o.setVisibility(8);
        this.n.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view, int i2, net.one97.paytm.paymentsBank.f.b.a aVar) {
        if (aVar.f18343g) {
            this.k = true;
            this.f18325i.setAdapter(this.f18318b);
        } else if (!TextUtils.isEmpty(aVar.f18340d)) {
            for (net.one97.paytm.paymentsBank.f.b.a next : this.j.f18312a) {
                if (aVar.f18340d.equals(next.f18340d)) {
                    next.f18343g = true;
                } else {
                    next.f18343g = false;
                }
            }
            this.j.notifyDataSetChanged();
            this.k = true;
            this.f18318b.a(net.one97.paytm.paymentsBank.f.c.a.a(this.f18317a, false));
            this.f18325i.setAdapter(this.f18318b);
            net.one97.paytm.bankCommon.h.b.a(this.f18317a.getContext(), aVar.f18341e);
            b bVar = this.f18317a;
            bVar.f18469c = false;
            bVar.m = false;
            bVar.q = false;
            bVar.r = false;
            net.one97.paytm.paymentsBank.a.b bVar2 = bVar.x;
            net.one97.paytm.paymentsBank.utils.a aVar2 = net.one97.paytm.paymentsBank.utils.a.f19494a;
            bVar2.f17287a = net.one97.paytm.paymentsBank.utils.a.j();
            bVar2.notifyDataSetChanged();
            net.one97.paytm.paymentsBank.accntfreeze.a a2 = net.one97.paytm.paymentsBank.accntfreeze.a.a();
            AppCompatActivity appCompatActivity = (AppCompatActivity) bVar.getActivity();
            Fragment c2 = appCompatActivity.getSupportFragmentManager().c(a2.f17338b);
            if (c2 != null) {
                appCompatActivity.getSupportFragmentManager().a().a(c2).c();
            }
            a2.b();
            bVar.n.setVisibility(8);
            if (j.a().equals("ISA")) {
                bVar.n();
            } else {
                bVar.o();
            }
            Fragment c3 = bVar.getChildFragmentManager().c(R.id.nachPendingLayout);
            if (c3 != null) {
                bVar.getChildFragmentManager().a().a(c3).c();
            }
            ((FrameLayout) bVar.p.findViewById(R.id.fragment_bank_tab_lyt)).removeAllViews();
            bVar.u.findViewById(R.id.show_more).setVisibility(8);
            bVar.v.setText("");
            bVar.f18472f.setText("");
            bVar.p.findViewById(R.id.svblockedacc).setVisibility(8);
            bVar.p.findViewById(R.id.fdblockedacc).setVisibility(8);
            bVar.f18474h.setText("");
            bVar.f18475i.setText("");
            bVar.s.setVisibility(8);
            bVar.l.setText("");
            bVar.o.findViewById(R.id.show_more).setVisibility(0);
            bVar.w.setText("");
            bVar.f18473g.setText("");
            bVar.k.setText("");
            bVar.p.findViewById(R.id.fdblockedacc).setVisibility(8);
            bVar.p.findViewById(R.id.heading).setVisibility(8);
            bVar.f18471e.setText("");
            bVar.j.setText("");
            bVar.f();
            bVar.h();
        } else if (aVar.f18341e.equalsIgnoreCase("ICA")) {
            this.f18317a.startActivity(new Intent(this.f18317a.getActivity(), ICAAccountOpeningActivity.class));
        } else {
            Intent intent = new Intent(this.f18317a.getActivity(), PaymentsBankBaseActivity.class);
            intent.putExtra("extraDefaultFrame", 3);
            this.f18317a.startActivity(intent);
        }
        d();
        this.m.setImageDrawable(androidx.core.content.b.a(this.f18317a.getContext(), this.k ? R.drawable.pb_drawer_down_svg : R.drawable.pb_drawer_up_svg));
    }
}
