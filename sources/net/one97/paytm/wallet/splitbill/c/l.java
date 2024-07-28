package net.one97.paytm.wallet.splitbill.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.i.h;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.b.b;
import net.one97.paytm.wallet.splitbill.model.SBContactDetail;

public class l extends h {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f72218a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.wallet.splitbill.a.l f72219b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Activity f72220c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f72221d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f72222e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public TextView f72223f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public b f72224g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TextView f72225h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<SBContactDetail> f72226i = new ArrayList<>();
    /* access modifiers changed from: private */
    public double j;
    private Switch k;
    /* access modifiers changed from: private */
    public boolean l;
    private String m;
    private ArrayList<SBContactDetail> n;
    /* access modifiers changed from: private */
    public ArrayList<SBContactDetail> o;
    private String p;
    /* access modifiers changed from: private */
    public boolean q = false;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.sb_split_bill_fragment, (ViewGroup) null);
        if (getArguments() != null) {
            try {
                Iterator it2 = ((ArrayList) getArguments().getSerializable("list")).iterator();
                while (it2.hasNext()) {
                    this.f72226i.add((SBContactDetail) ((SBContactDetail) it2.next()).clone());
                }
            } catch (Exception unused) {
            }
            this.f72221d = getArguments().getInt(CLPConstants.ARGUMENT_KEY_POSITION);
            this.m = getArguments().getString("bill_amount");
            this.p = getArguments().getString("split_options");
            this.l = getArguments().getBoolean("is_equal");
            this.n = (ArrayList) getArguments().getSerializable("paid_contact_list");
            this.o = (ArrayList) getArguments().getSerializable("split_contact_list");
        }
        this.f72218a = (RecyclerView) inflate.findViewById(R.id.recycleview);
        this.f72218a.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        this.f72222e = (TextView) inflate.findViewById(R.id.tvSelectPeple);
        this.f72223f = (TextView) inflate.findViewById(R.id.tvamount);
        this.k = (Switch) inflate.findViewById(R.id.switch_btn);
        this.f72225h = (TextView) inflate.findViewById(R.id.error);
        this.f72225h.setVisibility(8);
        if (!TextUtils.isEmpty(this.m)) {
            this.j = Double.valueOf(this.m).doubleValue();
            TextView textView = this.f72223f;
            StringBuilder sb = new StringBuilder(FilterPriceSliderFragment.RUPEE_SYMBOL);
            Double valueOf = Double.valueOf(this.j);
            if (Math.floor(valueOf.doubleValue()) == Math.ceil(valueOf.doubleValue())) {
                str = new DecimalFormat("#").format(valueOf);
            } else {
                str = valueOf.toString();
            }
            sb.append(str);
            textView.setText(sb.toString());
            this.k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    l.this.f72225h.setVisibility(8);
                    l.this.f72223f.setTextColor(-16777216);
                    if (z) {
                        boolean unused = l.this.q = false;
                        l.this.f72224g.a(true);
                        if (l.this.f72221d == 1) {
                            double f2 = l.this.j / ((double) l.this.o.size());
                            boolean unused2 = l.this.l = true;
                            for (int i2 = 0; i2 < l.this.o.size(); i2++) {
                                ((SBContactDetail) l.this.o.get(i2)).setmAmount(String.valueOf(f2));
                            }
                        }
                        l lVar = l.this;
                        ArrayList g2 = lVar.o;
                        Activity h2 = l.this.f72220c;
                        l lVar2 = l.this;
                        net.one97.paytm.wallet.splitbill.a.l unused3 = lVar.f72219b = new net.one97.paytm.wallet.splitbill.a.l(g2, h2, lVar2, lVar2.j, l.this.l, l.this.f72221d);
                        l.this.f72218a.setAdapter(l.this.f72219b);
                        l.this.f72219b.notifyDataSetChanged();
                        return;
                    }
                    if (!l.this.q) {
                        Iterator it2 = l.this.o.iterator();
                        while (it2.hasNext()) {
                            ((SBContactDetail) it2.next()).setmAmount("0");
                        }
                        l lVar3 = l.this;
                        ArrayList g3 = lVar3.o;
                        Activity h3 = l.this.f72220c;
                        l lVar4 = l.this;
                        net.one97.paytm.wallet.splitbill.a.l unused4 = lVar3.f72219b = new net.one97.paytm.wallet.splitbill.a.l(g3, h3, lVar4, lVar4.j, l.this.l, l.this.f72221d);
                        l.this.f72218a.setAdapter(l.this.f72219b);
                        l.this.f72219b.notifyDataSetChanged();
                    }
                    l.this.f72224g.a(false);
                    boolean unused5 = l.this.l = false;
                }
            });
            if (this.f72221d == 0) {
                this.k.setVisibility(8);
                this.k.setChecked(false);
                this.l = false;
                this.f72222e.setText(getResources().getString(R.string.select_people));
                if (a(this.n)) {
                    int i2 = -1;
                    for (int i3 = 0; i3 < this.n.size(); i3++) {
                        this.n.get(i3).setmAmount("0");
                        if (this.n.get(i3).getmName().equalsIgnoreCase("You")) {
                            i2 = i3;
                        }
                    }
                    this.n.get(i2).setmIsSelectedForPay(true);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.j);
                    this.n.get(i2).setmAmount(sb2.toString());
                }
                this.f72219b = new net.one97.paytm.wallet.splitbill.a.l(this.n, this.f72220c, this, this.j, this.l, this.f72221d);
                this.f72218a.setAdapter(this.f72219b);
            } else {
                this.k.setVisibility(0);
                if (this.l) {
                    this.k.setChecked(true);
                } else {
                    this.k.setChecked(false);
                }
                this.f72222e.setText(getResources().getString(R.string.split_equally));
                this.f72219b = new net.one97.paytm.wallet.splitbill.a.l(this.o, this.f72220c, this, this.j, this.l, this.f72221d);
                this.f72218a.setAdapter(this.f72219b);
            }
        }
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f72220c = (Activity) context;
        this.f72224g = (b) context;
    }

    private static boolean a(ArrayList<SBContactDetail> arrayList) {
        Iterator<SBContactDetail> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (it2.next().getmIsSelectedForPay()) {
                return false;
            }
        }
        return true;
    }

    public final void a(boolean z) {
        this.f72225h.setVisibility(0);
        this.f72223f.setTextColor(Color.parseColor("#fd5c5c"));
        if (z) {
            this.f72225h.setText("Please select people who paid the bill from the list");
        } else {
            this.f72225h.setText("The sum of individual amount does not add up to total bill amount");
        }
    }

    public final void a(boolean z, boolean z2) {
        this.q = z2;
        Switch switchR = this.k;
        if (switchR != null) {
            switchR.setChecked(z);
            this.l = z;
        }
        if (!z2) {
            a();
        }
    }

    public final void a() {
        try {
            View currentFocus = this.f72220c.getCurrentFocus();
            if (currentFocus != null) {
                ((InputMethodManager) this.f72220c.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        } catch (Exception unused) {
        }
    }

    public final void b() {
        this.f72223f.setTextColor(-16777216);
        this.f72225h.setVisibility(8);
    }
}
