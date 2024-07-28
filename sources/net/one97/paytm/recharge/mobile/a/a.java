package net.one97.paytm.recharge.mobile.a;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.HashMap;
import java.util.LinkedList;
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

public final class a extends e {
    /* access modifiers changed from: private */
    public static final String E;

    /* renamed from: f  reason: collision with root package name */
    public static final C1233a f63586f = new C1233a((byte) 0);
    /* access modifiers changed from: private */
    public boolean B;
    private e C;
    private LinkedList<CJRSelectedGroupItem> D;
    private HashMap F;

    public final View b(int i2) {
        if (this.F == null) {
            this.F = new HashMap();
        }
        View view = (View) this.F.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.F.put(Integer.valueOf(i2), findViewById);
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
        HashMap hashMap = this.F;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* access modifiers changed from: protected */
    public final void v() {
    }

    /* renamed from: net.one97.paytm.recharge.mobile.a.a$a  reason: collision with other inner class name */
    public static final class C1233a {
        private C1233a() {
        }

        public /* synthetic */ C1233a(byte b2) {
            this();
        }
    }

    static {
        String simpleName = a.class.getSimpleName();
        k.a((Object) simpleName, "FJRAddNewBillEnterMobile…V8::class.java.simpleName");
        E = simpleName;
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.a.a(int, int, android.content.Intent):boolean");
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
            int r2 = net.one97.paytm.recharge.R.id.txt_payment_automatic_update_operator
            r3 = 1
            if (r1 != 0) goto L_0x0013
            goto L_0x001f
        L_0x0013:
            int r4 = r1.intValue()
            if (r4 != r2) goto L_0x001f
            r5.r = r3
            r5.e("")
            return
        L_0x001f:
            int r2 = net.one97.paytm.recharge.R.id.btn_payment_automatic_confirm
            if (r1 != 0) goto L_0x0024
            goto L_0x0099
        L_0x0024:
            int r4 = r1.intValue()
            if (r4 != r2) goto L_0x0099
            net.one97.paytm.recharge.mobile.d.a r1 = r5.f63600h
            if (r1 == 0) goto L_0x0032
            java.util.HashMap r0 = r1.q()
        L_0x0032:
            if (r0 == 0) goto L_0x00c0
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
            goto L_0x00c0
        L_0x0099:
            int r2 = net.one97.paytm.recharge.R.id.ic_payment_automatic_cross
            if (r1 != 0) goto L_0x009e
            goto L_0x00c0
        L_0x009e:
            int r1 = r1.intValue()
            if (r1 != r2) goto L_0x00c0
            net.one97.paytm.recharge.mobile.d.a r1 = r5.f63600h
            if (r1 == 0) goto L_0x00b4
            androidx.lifecycle.y<java.lang.Boolean> r1 = r1.H
            androidx.lifecycle.LiveData r1 = (androidx.lifecycle.LiveData) r1
            if (r1 == 0) goto L_0x00b4
            java.lang.Object r0 = r1.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
        L_0x00b4:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r1)
            r0 = r0 ^ r3
            if (r0 == 0) goto L_0x00c0
            r5.D()
        L_0x00c0:
            super.onClick(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.a.onClick(android.view.View):void");
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f63587a;

        b(a aVar) {
            this.f63587a = aVar;
        }

        public final void run() {
            az azVar = az.f61525a;
            az.a(this.f63587a.getContext(), ERROR_TYPE.UNDEFINED, ACTION_TYPE.PAYMENT_AUTOMATIC, this.f63587a.getString(R.string.title_prepaid_automatic), this.f63587a.getString(R.string.prepaid_automatic_not_supported));
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f63588a;

        c(a aVar) {
            this.f63588a = aVar;
        }

        public final void onClick(View view) {
            this.f63588a.B = false;
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f63589a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f63590b;

        d(a aVar, String str) {
            this.f63589a = aVar;
            this.f63590b = str;
        }

        public final void onClick(View view) {
            net.one97.paytm.recharge.ordersummary.h.d dVar = this.f63589a.l;
            if (dVar != null) {
                String str = this.f63590b;
                a.C1160a aVar = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, str, net.one97.paytm.recharge.automatic.b.a.a.D, (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
            }
            this.f63589a.B = false;
        }
    }

    public final void ap_() {
        this.B = false;
        CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8 = this.o;
        if (cJRInputFieldWithActionWidgetV8 != null) {
            cJRInputFieldWithActionWidgetV8.c(false);
        }
    }

    public final void an_() {
        this.B = false;
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
        a(this.D);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r5v6, types: [java.lang.Long] */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r6 = r6.z;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.LinkedList<net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem> r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8 r2 = r0.o
            r3 = 0
            if (r2 == 0) goto L_0x000c
            r2.c((boolean) r3)
        L_0x000c:
            net.one97.paytm.recharge.mobile.d.a r2 = r0.f63600h
            java.lang.String r4 = "mMobileRechargeViewModel…edMobileNumber()?.value!!"
            r5 = 0
            if (r2 == 0) goto L_0x0036
            net.one97.paytm.recharge.mobile.d.a r6 = r0.f63600h
            if (r6 == 0) goto L_0x0024
            androidx.lifecycle.y<java.lang.String> r6 = r6.z
            androidx.lifecycle.LiveData r6 = (androidx.lifecycle.LiveData) r6
            if (r6 == 0) goto L_0x0024
            java.lang.Object r6 = r6.getValue()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0025
        L_0x0024:
            r6 = r5
        L_0x0025:
            if (r6 != 0) goto L_0x002a
            kotlin.g.b.k.a()
        L_0x002a:
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            boolean r2 = r2.b((java.lang.String) r6)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            goto L_0x0037
        L_0x0036:
            r2 = r5
        L_0x0037:
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r6)
            if (r2 == 0) goto L_0x007d
            r17.j()
            int r1 = net.one97.paytm.recharge.R.id.toolbar_layout
            android.view.View r1 = r0.b(r1)
            net.one97.paytm.recharge.common.widget.SubtitleCollapsingToolbarLayout r1 = (net.one97.paytm.recharge.common.widget.SubtitleCollapsingToolbarLayout) r1
            if (r1 != 0) goto L_0x0066
            net.one97.paytm.recharge.common.utils.az r1 = net.one97.paytm.recharge.common.utils.az.f61525a
            android.content.Context r1 = r17.getContext()
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r3 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.PAYMENT_AUTOMATIC
            int r4 = net.one97.paytm.recharge.R.string.title_prepaid_automatic
            java.lang.String r4 = r0.getString(r4)
            int r5 = net.one97.paytm.recharge.R.string.prepaid_automatic_not_supported
            java.lang.String r5 = r0.getString(r5)
            net.one97.paytm.recharge.common.utils.az.a(r1, r2, r3, r4, r5)
            return
        L_0x0066:
            int r1 = net.one97.paytm.recharge.R.id.toolbar_layout
            android.view.View r1 = r0.b(r1)
            net.one97.paytm.recharge.common.widget.SubtitleCollapsingToolbarLayout r1 = (net.one97.paytm.recharge.common.widget.SubtitleCollapsingToolbarLayout) r1
            if (r1 == 0) goto L_0x007c
            net.one97.paytm.recharge.mobile.a.a$b r2 = new net.one97.paytm.recharge.mobile.a.a$b
            r2.<init>(r0)
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r3 = 200(0xc8, double:9.9E-322)
            r1.postDelayed(r2, r3)
        L_0x007c:
            return
        L_0x007d:
            boolean r2 = r0.B
            java.lang.String r6 = "activity!!"
            r7 = 1
            if (r2 != 0) goto L_0x00ea
            r0.D = r1
            net.one97.paytm.recharge.common.utils.e r1 = new net.one97.paytm.recharge.common.utils.e
            androidx.fragment.app.FragmentActivity r2 = r17.getActivity()
            if (r2 != 0) goto L_0x0091
            kotlin.g.b.k.a()
        L_0x0091:
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            r9 = r2
            android.app.Activity r9 = (android.app.Activity) r9
            net.one97.paytm.recharge.mobile.d.a r2 = r0.f63600h
            if (r2 == 0) goto L_0x00a9
            androidx.lifecycle.y<java.lang.String> r2 = r2.z
            androidx.lifecycle.LiveData r2 = (androidx.lifecycle.LiveData) r2
            if (r2 == 0) goto L_0x00a9
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            r10 = r2
            goto L_0x00aa
        L_0x00a9:
            r10 = r5
        L_0x00aa:
            if (r10 != 0) goto L_0x00af
            kotlin.g.b.k.a()
        L_0x00af:
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r4)
            androidx.fragment.app.j r11 = r17.getChildFragmentManager()
            java.lang.String r2 = "childFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r2)
            net.one97.paytm.recharge.mobile.d.a r2 = r0.f63600h
            if (r2 == 0) goto L_0x00cd
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r2 = r2.f61409b
            if (r2 == 0) goto L_0x00cd
            net.one97.paytm.recharge.model.v4.CJRCategoryData r2 = r2.getCategoryData()
            if (r2 == 0) goto L_0x00cd
            java.lang.Long r5 = r2.getCategoryId()
        L_0x00cd:
            r12 = r5
            r13 = r0
            net.one97.paytm.recharge.common.utils.e$a r13 = (net.one97.paytm.recharge.common.utils.e.a) r13
            r8 = r1
            r8.<init>(r9, r10, r11, r12, r13)
            r0.C = r1
            net.one97.paytm.recharge.common.utils.e r1 = r0.C
            if (r1 == 0) goto L_0x00e4
            net.one97.paytm.recharge.mobile.a.a$c r2 = new net.one97.paytm.recharge.mobile.a.a$c
            r2.<init>(r0)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r1.f61621f = r2
        L_0x00e4:
            r0.B = r7
            r17.j()
            return
        L_0x00ea:
            net.one97.paytm.recharge.common.utils.t r2 = r0.f61110b
            if (r2 == 0) goto L_0x00f1
            r2.a()
        L_0x00f1:
            if (r1 == 0) goto L_0x01c1
            boolean r2 = r18.isEmpty()
            if (r2 != 0) goto L_0x01c1
            net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8 r2 = r0.o
            if (r2 == 0) goto L_0x0100
            r2.c((boolean) r3)
        L_0x0100:
            java.lang.Object r2 = r1.get(r3)
            net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem r2 = (net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem) r2
            net.one97.paytm.recharge.model.v4.CJRAggsItem r2 = r2.getItem()
            if (r2 == 0) goto L_0x01bd
            java.lang.String r2 = r2.getSchedulable()
            if (r2 == 0) goto L_0x01bd
            java.lang.String r4 = "0"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r4, (boolean) r7)
            if (r2 != r7) goto L_0x01bd
            java.lang.Object r1 = r1.get(r3)
            net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem r1 = (net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem) r1
            net.one97.paytm.recharge.model.v4.CJRAggsItem r1 = r1.getItem()
            if (r1 == 0) goto L_0x012b
            java.lang.String r1 = r1.getDisplayValue()
            goto L_0x012c
        L_0x012b:
            r1 = r5
        L_0x012c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            net.one97.paytm.recharge.automatic.b.a.a$a r4 = net.one97.paytm.recharge.automatic.b.a.a.f60239a
            java.lang.String r4 = net.one97.paytm.recharge.automatic.b.a.a.f60240b
            r2.append(r4)
            java.lang.String r4 = "_"
            r2.append(r4)
            net.one97.paytm.recharge.mobile.d.a r4 = r0.f63600h
            if (r4 == 0) goto L_0x0151
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r4 = r4.f61409b
            if (r4 == 0) goto L_0x0151
            net.one97.paytm.recharge.model.v4.CJRCategoryData r4 = r4.getCategoryData()
            if (r4 == 0) goto L_0x0151
            java.lang.String r5 = r4.getGaKey()
        L_0x0151:
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            net.one97.paytm.recharge.ordersummary.h.d r8 = r0.l
            if (r8 == 0) goto L_0x016d
            net.one97.paytm.recharge.automatic.b.a.a$a r4 = net.one97.paytm.recharge.automatic.b.a.a.f60239a
            java.lang.String r10 = net.one97.paytm.recharge.automatic.b.a.a.C
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 124(0x7c, float:1.74E-43)
            r9 = r2
            net.one97.paytm.recharge.ordersummary.h.d.a(r8, r9, r10, r11, r12, r13, r14, r15, r16)
        L_0x016d:
            net.one97.paytm.recharge.presentation.c.a$a r4 = net.one97.paytm.recharge.presentation.c.a.f64795a
            androidx.fragment.app.FragmentActivity r4 = r17.getActivity()
            if (r4 != 0) goto L_0x0178
            kotlin.g.b.k.a()
        L_0x0178:
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            android.content.Context r4 = (android.content.Context) r4
            int r5 = net.one97.paytm.recharge.R.string.coming_soon_excalamation
            java.lang.String r5 = r0.getString(r5)
            java.lang.String r6 = "getString(R.string.coming_soon_excalamation)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            int r6 = net.one97.paytm.recharge.R.string.we_are_working_hard_operator
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r7[r3] = r1
            java.lang.String r1 = r0.getString(r6, r7)
            java.lang.String r3 = "getString(R.string.we_ar…erator, selectedOperator)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r3 = net.one97.paytm.recharge.R.string.ok
            java.lang.String r3 = r0.getString(r3)
            java.lang.String r6 = "getString(R.string.ok)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            net.one97.paytm.recharge.mobile.a.a$d r6 = new net.one97.paytm.recharge.mobile.a.a$d
            r6.<init>(r0, r2)
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
            com.google.android.material.bottomsheet.b r1 = net.one97.paytm.recharge.presentation.c.a.C1278a.a(r4, r5, r1, r3, r6)
            androidx.fragment.app.j r2 = r17.getChildFragmentManager()
            java.lang.Class<net.one97.paytm.recharge.presentation.c.a> r3 = net.one97.paytm.recharge.presentation.c.a.class
            java.lang.String r3 = r3.getSimpleName()
            r1.show((androidx.fragment.app.j) r2, (java.lang.String) r3)
            return
        L_0x01bd:
            super.a((java.util.LinkedList<net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem>) r18)
            return
        L_0x01c1:
            super.a((java.util.LinkedList<net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem>) r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.a.a(java.util.LinkedList):void");
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
            if (c2.getFragmentManager() == null && !c2.isAdded()) {
                j childFragmentManager = getChildFragmentManager();
                f.a aVar4 = f.f64764a;
                c2.show(childFragmentManager, f.f64765g);
            }
        }
    }
}
