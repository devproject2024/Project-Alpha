package com.travel.train.helper;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.FragmentActivity;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.train.R;
import com.travel.train.b.ar;
import com.travel.train.fragment.ai;
import com.travel.train.i.q;
import com.travel.train.i.u;
import com.travel.train.j.g;
import com.travel.train.j.j;
import com.travel.train.j.n;
import com.travel.train.model.trainticket.CJRTrainFilterItem;
import com.travel.train.model.trainticket.CJRTrainFilterModel;
import com.travel.train.model.trainticket.CJRTrainFilters;
import com.travel.train.model.trainticket.CJRTrainSearchResults;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import com.travel.train.model.trainticket.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.utility.d;

public final class c implements View.OnClickListener, ar.a, q {

    /* renamed from: a  reason: collision with root package name */
    private u f27256a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public FragmentActivity f27257b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f27258c;

    /* renamed from: d  reason: collision with root package name */
    private String[] f27259d;

    /* renamed from: e  reason: collision with root package name */
    private SwitchCompat f27260e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f27261f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public View f27262g;

    /* renamed from: h  reason: collision with root package name */
    private ai f27263h;

    /* renamed from: i  reason: collision with root package name */
    private int f27264i = 0;
    /* access modifiers changed from: private */
    public boolean j = false;
    private String k = "";
    private ArrayList<CJRTrainFilterItem> l = new ArrayList<>();
    private ArrayList<CJRTrainFilterItem> m = new ArrayList<>();
    private ArrayList<CJRTrainFilterItem> n = new ArrayList<>();
    private CJRTrainFilterModel o = new CJRTrainFilterModel();
    private j p;

    public c(FragmentActivity fragmentActivity, View view) {
        this.f27257b = fragmentActivity;
        this.f27259d = this.f27257b.getResources().getStringArray(R.array.train_sort_by_array_code);
        this.p = new j(this);
        this.f27258c = (TextView) view.findViewById(R.id.lyt_sort_name_display);
        this.f27258c.setText(this.f27259d[0]);
        ((LinearLayout) view.findViewById(R.id.lyt_train_sort_view)).setOnClickListener(this);
        ((LinearLayout) view.findViewById(R.id.lyt_train_filter_view)).setOnClickListener(this);
        if (g.f27551a != null && !TextUtils.isEmpty(g.f27551a.getSortTitle())) {
            ((TextView) view.findViewById(R.id.tv_sort_train)).setText(g.f27551a.getSortTitle());
        }
        if (g.f27551a != null && !TextUtils.isEmpty(g.f27551a.getFilterTitle())) {
            ((TextView) view.findViewById(R.id.tv_filter_train)).setText(g.f27551a.getFilterTitle());
        }
        final TextView textView = (TextView) view.findViewById(R.id.avl_only_text);
        this.f27261f = (ImageView) view.findViewById(R.id.imageFilterApplied);
        this.f27260e = (SwitchCompat) view.findViewById(R.id.avl_only_switch);
        this.f27260e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    textView.setTextColor(c.this.f27257b.getResources().getColor(R.color.color_00b9f5));
                } else {
                    textView.setTextColor(c.this.f27257b.getResources().getColor(R.color.color_222222));
                }
                if (c.this.f27262g != null) {
                    c.this.f27262g.setVisibility(8);
                }
                if (!c.this.j) {
                    c.a(c.this, z);
                }
            }
        });
    }

    public c(FragmentActivity fragmentActivity) {
        this.f27257b = fragmentActivity;
        this.f27259d = this.f27257b.getResources().getStringArray(R.array.train_sort_by_array_code);
        this.p = new j(this);
    }

    public final void a(u uVar) {
        this.f27256a = uVar;
    }

    public final void a(String str) {
        this.k = str;
    }

    public final String a() {
        return this.k;
    }

    public final ArrayList<CJRTrainFilterItem> b() {
        return this.n;
    }

    public final CJRTrainFilterModel c() {
        return this.o;
    }

    public final void a(CJRTrainSearchResults cJRTrainSearchResults) {
        this.n.clear();
        if (cJRTrainSearchResults != null) {
            ArrayList<CJRTrainFilters> filters = cJRTrainSearchResults.getBody().getFilters();
            if (filters != null && filters.size() > 0) {
                for (int i2 = 0; i2 < filters.size(); i2++) {
                    if ("ac".equalsIgnoreCase(filters.get(i2).getId()) || "nonac".equalsIgnoreCase(filters.get(i2).getId())) {
                        for (int i3 = 0; i3 < filters.get(i2).getFilters().size(); i3++) {
                            filters.get(i2).getFilters().get(i3).setSelectValue(false);
                            filters.get(i2).getFilters().get(i3).setId(filters.get(i2).getId());
                            this.n.add(filters.get(i2).getFilters().get(i3));
                        }
                    }
                }
            }
            g();
        }
    }

    private void g() {
        this.l.clear();
        this.m.clear();
        for (int i2 = 0; i2 < this.n.size(); i2++) {
            if ("ac".equalsIgnoreCase(this.n.get(i2).getId())) {
                this.l.add(this.n.get(i2));
            } else if ("nonac".equalsIgnoreCase(this.n.get(i2).getId())) {
                this.m.add(this.n.get(i2));
            }
        }
    }

    public final void b(CJRTrainSearchResults cJRTrainSearchResults) {
        this.j = true;
        this.o.clearFilter();
        if (!TextUtils.isEmpty(this.k)) {
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                if ("NonAcType".equalsIgnoreCase(this.k) && "nonac".equalsIgnoreCase(this.n.get(i2).getId())) {
                    this.n.get(i2).setSelectValue(true);
                } else if ("AcType".equalsIgnoreCase(this.k) && "ac".equalsIgnoreCase(this.n.get(i2).getId())) {
                    this.n.get(i2).setSelectValue(true);
                }
            }
            if ("NonAcType".equalsIgnoreCase(this.k)) {
                this.f27261f.setVisibility(0);
                a("nonac", cJRTrainSearchResults);
                a(n.g(this.f27257b));
            } else if ("AcType".equalsIgnoreCase(this.k)) {
                this.f27261f.setVisibility(0);
                a("ac", cJRTrainSearchResults);
                a(n.f(this.f27257b));
            } else {
                a(AppConstants.FOR_ALL, cJRTrainSearchResults);
                i();
            }
        } else {
            a(AppConstants.FOR_ALL, cJRTrainSearchResults);
            i();
        }
        this.f27260e.setChecked(false);
        this.j = false;
    }

    private void a(String str, CJRTrainSearchResults cJRTrainSearchResults) {
        if (cJRTrainSearchResults != null && cJRTrainSearchResults.getBody() != null && cJRTrainSearchResults.getBody().getFilters() != null) {
            this.o.getmSelectedFareCalssesList().clear();
            if (str.equalsIgnoreCase("ac")) {
                this.o.setmSelectedFareCalssesList(n.a(str, this.l, cJRTrainSearchResults));
            } else if (str.equalsIgnoreCase("nonac")) {
                this.o.setmSelectedFareCalssesList(n.a(str, this.m, cJRTrainSearchResults));
            } else {
                this.o.setmSelectedFareCalssesList(n.a(str, this.n, cJRTrainSearchResults));
            }
            if (!TextUtils.isEmpty(this.k)) {
                cJRTrainSearchResults.getBody().setTrains(this.p.a(cJRTrainSearchResults.getBody().getTrains(), this.o));
            }
        }
    }

    public final void a(View view) {
        this.f27262g = view;
        View view2 = this.f27262g;
        if (view2 != null) {
            TextView textView = (TextView) view2.findViewById(R.id.train_filter_popup_txt);
            ImageView imageView = (ImageView) this.f27262g.findViewById(R.id.bulb_icon);
            View findViewById = this.f27262g.findViewById(R.id.close_ac_trains_hidden_icon);
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        c.this.d(view);
                    }
                });
            }
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        c.this.c(view);
                    }
                });
            }
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        c.this.b(view);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        h();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        h();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        this.f27262g.setVisibility(8);
    }

    private void a(Spannable spannable) {
        TextView textView;
        View view = this.f27262g;
        if (view != null && (textView = (TextView) view.findViewById(R.id.train_filter_popup_txt)) != null) {
            this.f27262g.setVisibility(0);
            textView.setText(spannable);
            this.f27262g.postDelayed(new Runnable() {
                public final void run() {
                    c.this.f27262g.setVisibility(8);
                }
            }, 10000);
        }
    }

    private void h() {
        n.a(d.dJ, (Context) this.f27257b);
        this.f27262g.setVisibility(8);
        for (int i2 = 0; i2 < this.n.size(); i2++) {
            this.n.get(i2).setSelectValue(false);
        }
        this.k = null;
        CJRTrainSearchResults cJRTrainSearchResults = (CJRTrainSearchResults) n.a((Serializable) this.f27256a.e());
        a(AppConstants.FOR_ALL, cJRTrainSearchResults);
        this.p.a(cJRTrainSearchResults, this.o);
        i();
    }

    private void d(CJRTrainSearchResults cJRTrainSearchResults) {
        u uVar;
        if (cJRTrainSearchResults != null && (uVar = this.f27256a) != null) {
            uVar.a(cJRTrainSearchResults);
        }
    }

    private void i() {
        CJRTrainFilterModel cJRTrainFilterModel = this.o;
        if (cJRTrainFilterModel != null) {
            if (!n.a(cJRTrainFilterModel.getmSelectedFareCalssesList(), this.n) || this.o.getmSelectedSourceList().size() > 0 || this.o.getmSelectedDestinationList().size() > 0 || this.o.getmSelecteddepartureList().size() > 0 || this.o.getmSelectedArrivaList().size() > 0) {
                this.f27261f.setVisibility(0);
            } else {
                this.f27261f.setVisibility(4);
            }
        } else {
            this.f27261f.setVisibility(4);
        }
    }

    public final void d() {
        this.k = null;
        a(this.f27256a.e());
        b(this.f27256a.e());
        d(this.f27256a.e());
    }

    public final void onClick(View view) {
        u uVar;
        int id = view.getId();
        if (id == R.id.lyt_train_sort_view) {
            FragmentActivity fragmentActivity = this.f27257b;
            if (fragmentActivity != null && !fragmentActivity.isFinishing()) {
                ai aiVar = this.f27263h;
                if (aiVar == null || !aiVar.isVisible()) {
                    this.f27263h = new ai(this);
                    Bundle bundle = new Bundle();
                    bundle.putInt("click_position", this.f27264i);
                    this.f27263h.setArguments(bundle);
                    androidx.fragment.app.j supportFragmentManager = this.f27257b.getSupportFragmentManager();
                    if (supportFragmentManager != null) {
                        this.f27263h.show(supportFragmentManager, ai.class.getSimpleName());
                    }
                }
            }
        } else if (id == R.id.lyt_train_filter_view && (uVar = this.f27256a) != null) {
            uVar.c();
        }
    }

    private void a(int i2) {
        this.f27258c.setText(this.f27259d[i2]);
    }

    public final void a(int i2, i iVar) {
        this.f27264i = i2;
        a(this.f27264i);
        u uVar = this.f27256a;
        if (uVar != null) {
            uVar.a(iVar);
        }
    }

    public final ArrayList<i> e() {
        Resources resources = this.f27257b.getResources();
        ArrayList<i> arrayList = new ArrayList<>();
        i iVar = new i();
        iVar.setTitle(resources.getString(R.string.pre_t_train_recommended_tab));
        iVar.setSortByTrain("recommended");
        iVar.setOrderByTrain("forward");
        arrayList.add(iVar);
        i iVar2 = new i();
        iVar2.setTitle(resources.getString(R.string.train_duration_tab));
        iVar2.setSortByTrain(com.business.merchant_payments.common.utility.AppConstants.DURATION);
        iVar2.setOrderByTrain("forward");
        arrayList.add(iVar2);
        i iVar3 = new i();
        iVar3.setTitle(resources.getString(R.string.train_departure_tab));
        iVar3.setSortByTrain("departure");
        iVar3.setOrderByTrain("forward");
        arrayList.add(iVar3);
        i iVar4 = new i();
        iVar4.setTitle(resources.getString(R.string.train_departure_tab));
        iVar4.setSortByTrain("departure");
        iVar4.setOrderByTrain(StringSet.reverse);
        arrayList.add(iVar4);
        i iVar5 = new i();
        iVar5.setTitle(resources.getString(R.string.train_arrival_tab));
        iVar5.setSortByTrain("arrival");
        iVar5.setOrderByTrain("forward");
        arrayList.add(iVar5);
        i iVar6 = new i();
        iVar6.setTitle(resources.getString(R.string.train_arrival_tab));
        iVar6.setSortByTrain("arrival");
        iVar6.setOrderByTrain(StringSet.reverse);
        arrayList.add(iVar6);
        return arrayList;
    }

    public final i f() {
        return e().get(0);
    }

    public final void c(CJRTrainSearchResults cJRTrainSearchResults) {
        int intValue;
        if (cJRTrainSearchResults != null && cJRTrainSearchResults.getBody().getSort() != null && (intValue = n.a(cJRTrainSearchResults).intValue()) != -1) {
            ArrayList<i> e2 = e();
            for (int i2 = 0; i2 < e2.size(); i2++) {
                e2.get(i2);
                if (i2 == intValue) {
                    a(intValue);
                    return;
                }
            }
        }
    }

    public final void a(List<CJRTrainSearchResultsTrain> list) {
        u uVar = this.f27256a;
        if (uVar != null) {
            uVar.d().getBody().setTrains(list);
            d(this.f27256a.d());
        }
    }

    public final void a(CJRTrainSearchResults cJRTrainSearchResults, CJRTrainFilterModel cJRTrainFilterModel, ArrayList<CJRTrainFilterItem> arrayList, boolean z) {
        if (arrayList != null && arrayList.size() > 0) {
            this.n.clear();
            try {
                Iterator<CJRTrainFilterItem> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    this.n.add(it2.next().clone());
                }
            } catch (CloneNotSupportedException unused) {
            }
            if (this.n.size() > 0) {
                g();
            }
        }
        this.o = cJRTrainFilterModel;
        if (z) {
            this.k = null;
            if (n.a(arrayList)) {
                a(n.f(this.f27257b));
                u uVar = this.f27256a;
                if (uVar != null) {
                    uVar.f();
                }
            }
            if (this.f27256a != null) {
                if (this.f27260e.isChecked()) {
                    cJRTrainSearchResults.getBody().setTrains(j.a(cJRTrainSearchResults.getBody().getTrains()));
                }
                this.f27256a.a(cJRTrainSearchResults);
            }
            this.f27261f.setVisibility(0);
        } else {
            d();
        }
        this.f27256a.a(e().get(this.f27264i));
    }

    static /* synthetic */ void a(c cVar, boolean z) {
        if (z) {
            CJRTrainSearchResults d2 = cVar.f27256a.d();
            if (!(d2 == null || d2.getBody() == null || d2.getBody().getTrains() == null)) {
                d2.getBody().setTrains(j.a(d2.getBody().getTrains()));
            }
            if (cVar.f27256a != null) {
                cVar.d(d2);
                return;
            }
            return;
        }
        j jVar = cVar.p;
        jVar.f27565a = false;
        jVar.a((CJRTrainSearchResults) n.a((Serializable) cVar.f27256a.e()), cVar.o);
    }
}
