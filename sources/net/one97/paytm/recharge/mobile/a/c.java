package net.one97.paytm.recharge.mobile.a;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import com.google.android.material.appbar.AppBarLayout;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.automatic.b.a.a;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.e;
import net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8;
import net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem;
import net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionListActivity;
import net.one97.paytm.recharge.presentation.b.f;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class c extends j {
    /* access modifiers changed from: private */
    public static final String G;

    /* renamed from: f  reason: collision with root package name */
    public static final a f63593f = new a((byte) 0);
    /* access modifiers changed from: private */
    public boolean D;
    private e E;
    private LinkedList<CJRSelectedGroupItem> F;
    private HashMap H;

    public final void a(List<? extends CJRFrequentOrder> list) {
        k.c(list, "recents");
    }

    public final View b(int i2) {
        if (this.H == null) {
            this.H = new HashMap();
        }
        View view = (View) this.H.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.H.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void d(CJRFrequentOrder cJRFrequentOrder, int i2) {
        k.c(cJRFrequentOrder, "item");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        u();
    }

    public final void u() {
        HashMap hashMap = this.H;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* access modifiers changed from: protected */
    public final void x() {
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        String simpleName = j.class.getSimpleName();
        k.a((Object) simpleName, "FJRMobileLandingFragmentV8::class.java.simpleName");
        G = simpleName;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ((AppBarLayout) b(R.id.appbar_layout)).setExpanded(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        r2 = r2.H;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(int r2, int r3, android.content.Intent r4) {
        /*
            r1 = this;
            r0 = 203(0xcb, float:2.84E-43)
            if (r2 == r0) goto L_0x0009
            boolean r2 = super.a((int) r2, (int) r3, (android.content.Intent) r4)
            return r2
        L_0x0009:
            net.one97.paytm.recharge.mobile.d.a r2 = r1.f63600h
            if (r2 == 0) goto L_0x001a
            androidx.lifecycle.y<java.lang.Boolean> r2 = r2.H
            androidx.lifecycle.LiveData r2 = (androidx.lifecycle.LiveData) r2
            if (r2 == 0) goto L_0x001a
            java.lang.Object r2 = r2.getValue()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            goto L_0x001b
        L_0x001a:
            r2 = 0
        L_0x001b:
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)
            r3 = 1
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x0028
            r1.D()
        L_0x0028:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.c.a(int, int, android.content.Intent):boolean");
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.Boolean] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x000c
            int r1 = r6.getId()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x000d
        L_0x000c:
            r1 = r0
        L_0x000d:
            int r2 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r2 = r5.b(r2)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r2 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r2
            java.lang.String r3 = "btn_proceed"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            int r2 = r2.getId()
            if (r1 != 0) goto L_0x0021
            goto L_0x002c
        L_0x0021:
            int r3 = r1.intValue()
            if (r3 != r2) goto L_0x002c
            r5.j()
            goto L_0x00de
        L_0x002c:
            int r2 = net.one97.paytm.recharge.R.id.txt_payment_automatic_update_operator
            r3 = 1
            if (r1 != 0) goto L_0x0032
            goto L_0x003e
        L_0x0032:
            int r4 = r1.intValue()
            if (r4 != r2) goto L_0x003e
            r5.r = r3
            r5.e("")
            return
        L_0x003e:
            int r2 = net.one97.paytm.recharge.R.id.btn_payment_automatic_confirm
            if (r1 != 0) goto L_0x0043
            goto L_0x00b7
        L_0x0043:
            int r4 = r1.intValue()
            if (r4 != r2) goto L_0x00b7
            net.one97.paytm.recharge.mobile.d.a r1 = r5.f63600h
            if (r1 == 0) goto L_0x0051
            java.util.HashMap r0 = r1.q()
        L_0x0051:
            if (r0 == 0) goto L_0x00de
            android.content.Intent r1 = new android.content.Intent
            android.content.Context r2 = r5.getContext()
            java.lang.Class<net.one97.paytm.recharge.presentation.activity.AJRAutomaticSetupActivity> r4 = net.one97.paytm.recharge.presentation.activity.AJRAutomaticSetupActivity.class
            r1.<init>(r2, r4)
            java.lang.String r2 = "recharge_number"
            java.lang.Object r4 = r0.get(r2)
            java.lang.String r4 = (java.lang.String) r4
            r1.putExtra(r2, r4)
            java.lang.String r2 = "operator_name"
            java.lang.Object r4 = r0.get(r2)
            java.lang.String r4 = (java.lang.String) r4
            r1.putExtra(r2, r4)
            java.lang.String r2 = "nick_name"
            java.lang.Object r4 = r0.get(r2)
            java.lang.String r4 = (java.lang.String) r4
            r1.putExtra(r2, r4)
            java.lang.String r2 = "product_id"
            java.lang.Object r4 = r0.get(r2)
            java.lang.String r4 = (java.lang.String) r4
            r1.putExtra(r2, r4)
            java.lang.String r2 = "operator_logo"
            java.lang.Object r4 = r0.get(r2)
            java.lang.String r4 = (java.lang.String) r4
            r1.putExtra(r2, r4)
            java.lang.String r2 = "service_paytype"
            java.lang.Object r4 = r0.get(r2)
            java.lang.String r4 = (java.lang.String) r4
            r1.putExtra(r2, r4)
            java.lang.String r2 = "is_bank_mandate_enabled"
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r4 = "1"
            boolean r0 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r0, (boolean) r3)
            r1.putExtra(r2, r0)
            r0 = 203(0xcb, float:2.84E-43)
            r5.startActivityForResult(r1, r0)
            goto L_0x00de
        L_0x00b7:
            int r2 = net.one97.paytm.recharge.R.id.ic_payment_automatic_cross
            if (r1 != 0) goto L_0x00bc
            goto L_0x00de
        L_0x00bc:
            int r1 = r1.intValue()
            if (r1 != r2) goto L_0x00de
            net.one97.paytm.recharge.mobile.d.a r1 = r5.f63600h
            if (r1 == 0) goto L_0x00d2
            androidx.lifecycle.y<java.lang.Boolean> r1 = r1.H
            androidx.lifecycle.LiveData r1 = (androidx.lifecycle.LiveData) r1
            if (r1 == 0) goto L_0x00d2
            java.lang.Object r0 = r1.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
        L_0x00d2:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r1)
            r0 = r0 ^ r3
            if (r0 == 0) goto L_0x00de
            r5.D()
        L_0x00de:
            super.onClick(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.c.onClick(android.view.View):void");
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f63594a;

        b(c cVar) {
            this.f63594a = cVar;
        }

        public final void run() {
            az azVar = az.f61525a;
            az.a(this.f63594a.getContext(), ERROR_TYPE.UNDEFINED, ACTION_TYPE.PAYMENT_AUTOMATIC, this.f63594a.getString(R.string.title_prepaid_automatic), this.f63594a.getString(R.string.prepaid_automatic_not_supported));
        }
    }

    /* renamed from: net.one97.paytm.recharge.mobile.a.c$c  reason: collision with other inner class name */
    static final class C1235c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f63595a;

        C1235c(c cVar) {
            this.f63595a = cVar;
        }

        public final void onClick(View view) {
            this.f63595a.D = false;
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f63596a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f63597b;

        d(c cVar, String str) {
            this.f63596a = cVar;
            this.f63597b = str;
        }

        public final void onClick(View view) {
            this.f63596a.D = false;
            net.one97.paytm.recharge.ordersummary.h.d dVar = this.f63596a.l;
            if (dVar != null) {
                String str = this.f63597b;
                a.C1160a aVar = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, str, net.one97.paytm.recharge.automatic.b.a.a.D, (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
            }
        }
    }

    public final void ap_() {
        this.D = false;
        CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8 = this.o;
        if (cJRInputFieldWithActionWidgetV8 != null) {
            cJRInputFieldWithActionWidgetV8.c(false);
        }
    }

    public final void an_() {
        this.D = false;
        CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8 = this.o;
        if (cJRInputFieldWithActionWidgetV8 != null) {
            cJRInputFieldWithActionWidgetV8.c(false);
        }
        if (getActivity() != null && az.c(getActivity())) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            az.f(activity, "");
        } else if (getActivity() != null) {
            startActivity(new Intent(getActivity(), AJRAutomaticSubscriptionListActivity.class));
        }
    }

    public final void aq_() {
        a(this.F);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v8, types: [java.lang.Long] */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008f, code lost:
        r0 = r0.z;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.LinkedList<net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem> r15) {
        /*
            r14 = this;
            net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8 r0 = r14.o
            r1 = 0
            if (r0 == 0) goto L_0x0008
            r0.c((boolean) r1)
        L_0x0008:
            net.one97.paytm.recharge.mobile.d.a r0 = r14.f63600h
            r2 = 0
            if (r0 == 0) goto L_0x002a
            net.one97.paytm.recharge.mobile.d.a r3 = r14.f63600h
            if (r3 == 0) goto L_0x001f
            androidx.lifecycle.y<java.lang.String> r3 = r3.z
            androidx.lifecycle.LiveData r3 = (androidx.lifecycle.LiveData) r3
            if (r3 == 0) goto L_0x001f
            java.lang.Object r3 = r3.getValue()
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x0021
        L_0x001f:
            java.lang.String r3 = ""
        L_0x0021:
            boolean r0 = r0.b((java.lang.String) r3)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x002b
        L_0x002a:
            r0 = r2
        L_0x002b:
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r3)
            if (r0 == 0) goto L_0x0071
            r14.j()
            int r15 = net.one97.paytm.recharge.R.id.toolbar_layout
            android.view.View r15 = r14.b(r15)
            net.one97.paytm.recharge.common.widget.SubtitleCollapsingToolbarLayout r15 = (net.one97.paytm.recharge.common.widget.SubtitleCollapsingToolbarLayout) r15
            if (r15 != 0) goto L_0x005a
            net.one97.paytm.recharge.common.utils.az r15 = net.one97.paytm.recharge.common.utils.az.f61525a
            android.content.Context r15 = r14.getContext()
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r0 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r1 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.PAYMENT_AUTOMATIC
            int r2 = net.one97.paytm.recharge.R.string.title_prepaid_automatic
            java.lang.String r2 = r14.getString(r2)
            int r3 = net.one97.paytm.recharge.R.string.prepaid_automatic_not_supported
            java.lang.String r3 = r14.getString(r3)
            net.one97.paytm.recharge.common.utils.az.a(r15, r0, r1, r2, r3)
            return
        L_0x005a:
            int r15 = net.one97.paytm.recharge.R.id.toolbar_layout
            android.view.View r15 = r14.b(r15)
            net.one97.paytm.recharge.common.widget.SubtitleCollapsingToolbarLayout r15 = (net.one97.paytm.recharge.common.widget.SubtitleCollapsingToolbarLayout) r15
            if (r15 == 0) goto L_0x0070
            net.one97.paytm.recharge.mobile.a.c$b r0 = new net.one97.paytm.recharge.mobile.a.c$b
            r0.<init>(r14)
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            r1 = 200(0xc8, double:9.9E-322)
            r15.postDelayed(r0, r1)
        L_0x0070:
            return
        L_0x0071:
            boolean r0 = r14.D
            java.lang.String r3 = "activity!!"
            r4 = 1
            if (r0 != 0) goto L_0x00e0
            r14.F = r15
            net.one97.paytm.recharge.common.utils.e r15 = new net.one97.paytm.recharge.common.utils.e
            androidx.fragment.app.FragmentActivity r0 = r14.getActivity()
            if (r0 != 0) goto L_0x0085
            kotlin.g.b.k.a()
        L_0x0085:
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r6 = r0
            android.app.Activity r6 = (android.app.Activity) r6
            net.one97.paytm.recharge.mobile.d.a r0 = r14.f63600h
            if (r0 == 0) goto L_0x009d
            androidx.lifecycle.y<java.lang.String> r0 = r0.z
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x009d
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r7 = r0
            goto L_0x009e
        L_0x009d:
            r7 = r2
        L_0x009e:
            if (r7 != 0) goto L_0x00a3
            kotlin.g.b.k.a()
        L_0x00a3:
            java.lang.String r0 = "mMobileRechargeViewModel…edMobileNumber()?.value!!"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            androidx.fragment.app.j r8 = r14.getChildFragmentManager()
            java.lang.String r0 = "childFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            net.one97.paytm.recharge.mobile.d.a r0 = r14.f63600h
            if (r0 == 0) goto L_0x00c3
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r0 = r0.f61409b
            if (r0 == 0) goto L_0x00c3
            net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = r0.getCategoryData()
            if (r0 == 0) goto L_0x00c3
            java.lang.Long r2 = r0.getCategoryId()
        L_0x00c3:
            r9 = r2
            r10 = r14
            net.one97.paytm.recharge.common.utils.e$a r10 = (net.one97.paytm.recharge.common.utils.e.a) r10
            r5 = r15
            r5.<init>(r6, r7, r8, r9, r10)
            r14.E = r15
            net.one97.paytm.recharge.common.utils.e r15 = r14.E
            if (r15 == 0) goto L_0x00da
            net.one97.paytm.recharge.mobile.a.c$c r0 = new net.one97.paytm.recharge.mobile.a.c$c
            r0.<init>(r14)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r15.f61621f = r0
        L_0x00da:
            r14.D = r4
            r14.j()
            return
        L_0x00e0:
            if (r15 == 0) goto L_0x01bd
            boolean r0 = r15.isEmpty()
            if (r0 != 0) goto L_0x01bd
            net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8 r0 = r14.o
            if (r0 == 0) goto L_0x00ef
            r0.c((boolean) r1)
        L_0x00ef:
            java.lang.Object r0 = r15.get(r1)
            net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem r0 = (net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem) r0
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = r0.getItem()
            if (r0 == 0) goto L_0x01b9
            java.lang.String r0 = r0.getSchedulable()
            if (r0 == 0) goto L_0x01b9
            java.lang.String r5 = "0"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r5, (boolean) r4)
            if (r0 != r4) goto L_0x01b9
            java.lang.Object r15 = r15.get(r1)
            net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem r15 = (net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem) r15
            net.one97.paytm.recharge.model.v4.CJRAggsItem r15 = r15.getItem()
            if (r15 == 0) goto L_0x011a
            java.lang.String r15 = r15.getDisplayValue()
            goto L_0x011b
        L_0x011a:
            r15 = r2
        L_0x011b:
            net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8 r0 = r14.o
            if (r0 == 0) goto L_0x0122
            r0.c((boolean) r1)
        L_0x0122:
            r14.C()
            r14.j()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            net.one97.paytm.recharge.automatic.b.a.a$a r5 = net.one97.paytm.recharge.automatic.b.a.a.f60239a
            java.lang.String r5 = net.one97.paytm.recharge.automatic.b.a.a.f60240b
            r0.append(r5)
            java.lang.String r5 = "_"
            r0.append(r5)
            net.one97.paytm.recharge.mobile.d.a r5 = r14.f63600h
            if (r5 == 0) goto L_0x014d
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r5 = r5.f61409b
            if (r5 == 0) goto L_0x014d
            net.one97.paytm.recharge.model.v4.CJRCategoryData r5 = r5.getCategoryData()
            if (r5 == 0) goto L_0x014d
            java.lang.String r2 = r5.getGaKey()
        L_0x014d:
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            net.one97.paytm.recharge.ordersummary.h.d r5 = r14.l
            if (r5 == 0) goto L_0x0169
            net.one97.paytm.recharge.automatic.b.a.a$a r2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a
            java.lang.String r7 = net.one97.paytm.recharge.automatic.b.a.a.C
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 124(0x7c, float:1.74E-43)
            r6 = r0
            net.one97.paytm.recharge.ordersummary.h.d.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)
        L_0x0169:
            net.one97.paytm.recharge.presentation.c.a$a r2 = net.one97.paytm.recharge.presentation.c.a.f64795a
            androidx.fragment.app.FragmentActivity r2 = r14.getActivity()
            if (r2 != 0) goto L_0x0174
            kotlin.g.b.k.a()
        L_0x0174:
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            android.content.Context r2 = (android.content.Context) r2
            int r3 = net.one97.paytm.recharge.R.string.coming_soon_excalamation
            java.lang.String r3 = r14.getString(r3)
            java.lang.String r5 = "getString(R.string.coming_soon_excalamation)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            int r5 = net.one97.paytm.recharge.R.string.we_are_working_hard_operator
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r1] = r15
            java.lang.String r15 = r14.getString(r5, r4)
            java.lang.String r1 = "getString(R.string.we_ar…erator, selectedOperator)"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r1)
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            int r1 = net.one97.paytm.recharge.R.string.ok
            java.lang.String r1 = r14.getString(r1)
            java.lang.String r4 = "getString(R.string.ok)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            net.one97.paytm.recharge.mobile.a.c$d r4 = new net.one97.paytm.recharge.mobile.a.c$d
            r4.<init>(r14, r0)
            android.view.View$OnClickListener r4 = (android.view.View.OnClickListener) r4
            com.google.android.material.bottomsheet.b r15 = net.one97.paytm.recharge.presentation.c.a.C1278a.a(r2, r3, r15, r1, r4)
            androidx.fragment.app.j r0 = r14.getChildFragmentManager()
            java.lang.Class<net.one97.paytm.recharge.presentation.c.a> r1 = net.one97.paytm.recharge.presentation.c.a.class
            java.lang.String r1 = r1.getSimpleName()
            r15.show((androidx.fragment.app.j) r0, (java.lang.String) r1)
            return
        L_0x01b9:
            super.a((java.util.LinkedList<net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem>) r15)
            return
        L_0x01bd:
            super.a((java.util.LinkedList<net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem>) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.c.a(java.util.LinkedList):void");
    }

    public final void w() {
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        Object obj = null;
        HashMap<String, String> q = aVar != null ? aVar.q() : null;
        if (q != null) {
            f.a aVar2 = f.f64764a;
            String str = q.get("recharge_number");
            String str2 = q.get("operator_name");
            String str3 = q.get("operator_logo");
            String str4 = q.get("nick_name");
            String str5 = q.get(CLPConstants.PRODUCT_ID);
            String str6 = q.get("service_paytype");
            net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
            if (aVar3 != null) {
                obj = aVar3.e();
            }
            View.OnClickListener onClickListener = this;
            f c2 = f.a.a(str, str2, str3, str4, str5, str6, String.valueOf(obj)).a(onClickListener).b(onClickListener).c(onClickListener);
            j childFragmentManager = getChildFragmentManager();
            f.a aVar4 = f.f64764a;
            c2.show(childFragmentManager, f.f64765g);
        }
    }
}
