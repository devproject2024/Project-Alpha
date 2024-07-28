package net.one97.paytm.recharge.mobile.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.LiveData;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.as;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.e;
import net.one97.paytm.recharge.common.utils.o;
import net.one97.paytm.recharge.common.widget.CJRAmountInputFieldWidgetV8;
import net.one97.paytm.recharge.model.CJRPersonalInsurance;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper;
import net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionListActivity;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8;

public final class b extends f implements e.a {
    /* access modifiers changed from: private */
    public static final String B;

    /* renamed from: f  reason: collision with root package name */
    public static final a f63592f = new a((byte) 0);
    private final C1234b A = new C1234b();
    private HashMap C;
    private e z;

    public final void a(CJRAmountInputFieldWidgetV8 cJRAmountInputFieldWidgetV8) {
        k.c(cJRAmountInputFieldWidgetV8, "view");
    }

    public final void ap_() {
    }

    public final View b(int i2) {
        if (this.C == null) {
            this.C = new HashMap();
        }
        View view = (View) this.C.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.C.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void e() {
    }

    /* access modifiers changed from: protected */
    public final void f() {
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        u();
    }

    public final void u() {
        HashMap hashMap = this.C;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        String simpleName = b.class.getSimpleName();
        k.a((Object) simpleName, "FJRAddNewBillEnterMobile…V8::class.java.simpleName");
        B = simpleName;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x00a6, code lost:
        r5 = r5.z;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r7, android.os.Bundle r8) {
        /*
            r6 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r7, r0)
            int r0 = net.one97.paytm.recharge.R.id.toolbar
            android.view.View r0 = r6.b(r0)
            androidx.appcompat.widget.Toolbar r0 = (androidx.appcompat.widget.Toolbar) r0
            java.lang.String r1 = "toolbar"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r2 = ""
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setTitle((java.lang.CharSequence) r2)
            super.onViewCreated(r7, r8)
            int r7 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r7 = r6.b(r7)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r7 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r7
            int r8 = net.one97.paytm.recharge.R.string.confirm
            java.lang.String r8 = r6.getString(r8)
            r7.setProceedBtnText(r8)
            android.widget.RelativeLayout$LayoutParams r7 = new android.widget.RelativeLayout$LayoutParams
            r8 = -1
            r0 = -2
            r7.<init>(r8, r0)
            r8 = 0
            r0 = 2
            r7.addRule(r0, r8)
            int r0 = net.one97.paytm.recharge.R.id.toolbar
            android.view.View r0 = r6.b(r0)
            androidx.appcompat.widget.Toolbar r0 = (androidx.appcompat.widget.Toolbar) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            int r0 = r0.getId()
            r1 = 3
            r7.addRule(r1, r0)
            int r0 = net.one97.paytm.recharge.R.id.upper_section
            android.view.View r0 = r6.b(r0)
            java.lang.String r2 = "upper_section"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            android.view.ViewGroup$LayoutParams r7 = (android.view.ViewGroup.LayoutParams) r7
            r0.setLayoutParams(r7)
            int r7 = net.one97.paytm.recharge.R.id.disclaimer
            android.view.View r7 = r6.b(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            java.lang.String r0 = "disclaimer"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            java.lang.String r3 = "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams"
            if (r7 == 0) goto L_0x0129
            android.widget.RelativeLayout$LayoutParams r7 = (android.widget.RelativeLayout.LayoutParams) r7
            int r4 = net.one97.paytm.recharge.R.id.upper_section
            android.view.View r4 = r6.b(r4)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            int r2 = r4.getId()
            r7.addRule(r1, r2)
            int r2 = net.one97.paytm.recharge.R.id.disclaimer
            android.view.View r2 = r6.b(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)
            android.view.ViewGroup$LayoutParams r7 = (android.view.ViewGroup.LayoutParams) r7
            r2.setLayoutParams(r7)
            int r7 = net.one97.paytm.recharge.R.id.disclaimer
            android.view.View r7 = r6.b(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x00c4
            int r2 = net.one97.paytm.recharge.R.string.setup_automatic_disclaimer_text
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            net.one97.paytm.recharge.mobile.d.a r5 = r6.f63600h
            if (r5 == 0) goto L_0x00b3
            androidx.lifecycle.y<java.lang.String> r5 = r5.z
            androidx.lifecycle.LiveData r5 = (androidx.lifecycle.LiveData) r5
            if (r5 == 0) goto L_0x00b3
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x00b4
        L_0x00b3:
            r5 = 0
        L_0x00b4:
            if (r5 != 0) goto L_0x00b9
            kotlin.g.b.k.a()
        L_0x00b9:
            r4[r8] = r5
            java.lang.String r2 = r6.getString(r2, r4)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r7.setText(r2)
        L_0x00c4:
            int r7 = net.one97.paytm.recharge.R.id.disclaimer
            android.view.View r7 = r6.b(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x00d3
            android.view.View r7 = (android.view.View) r7
            net.one97.paytm.recharge.common.utils.ai.a(r7)
        L_0x00d3:
            int r7 = net.one97.paytm.recharge.R.id.lyt_footer
            android.view.View r7 = r6.b(r7)
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            java.lang.String r2 = "lyt_footer"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r2)
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            if (r7 == 0) goto L_0x0123
            android.widget.RelativeLayout$LayoutParams r7 = (android.widget.RelativeLayout.LayoutParams) r7
            r3 = 10
            int r4 = com.paytm.utility.b.c((int) r3)
            r5 = 15
            int r5 = com.paytm.utility.b.c((int) r5)
            int r3 = com.paytm.utility.b.c((int) r3)
            r7.setMargins(r4, r5, r3, r8)
            r3 = 12
            r7.addRule(r3, r8)
            int r8 = net.one97.paytm.recharge.R.id.disclaimer
            android.view.View r8 = r6.b(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            int r8 = r8.getId()
            r7.addRule(r1, r8)
            int r8 = net.one97.paytm.recharge.R.id.lyt_footer
            android.view.View r8 = r6.b(r8)
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r2)
            android.view.ViewGroup$LayoutParams r7 = (android.view.ViewGroup.LayoutParams) r7
            r8.setLayoutParams(r7)
            return
        L_0x0123:
            kotlin.u r7 = new kotlin.u
            r7.<init>(r3)
            throw r7
        L_0x0129:
            kotlin.u r7 = new kotlin.u
            r7.<init>(r3)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.b.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001c, code lost:
        r0 = r0.z;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.recharge.model.v4.CJRInstruct r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.openAutomaticAddNewBill
            if (r0 == 0) goto L_0x0110
            r4.l()
            r4.l()
            android.content.Intent r5 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            java.lang.Class<net.one97.paytm.recharge.presentation.activity.AJRAutomaticSetupActivity> r1 = net.one97.paytm.recharge.presentation.activity.AJRAutomaticSetupActivity.class
            r5.<init>(r0, r1)
            net.one97.paytm.recharge.mobile.d.a r0 = r4.f63600h
            r1 = 0
            if (r0 == 0) goto L_0x0029
            androidx.lifecycle.y<java.lang.String> r0 = r0.z
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x0029
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x002a
        L_0x0029:
            r0 = r1
        L_0x002a:
            if (r0 != 0) goto L_0x002f
            kotlin.g.b.k.a()
        L_0x002f:
            java.lang.String r2 = "recharge_number"
            r5.putExtra(r2, r0)
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r0 = new net.one97.paytm.common.entity.recharge.CJRFrequentOrder
            net.one97.paytm.recharge.mobile.d.a r2 = r4.f63600h
            if (r2 == 0) goto L_0x0047
            androidx.lifecycle.y<java.lang.String> r2 = r2.z
            androidx.lifecycle.LiveData r2 = (androidx.lifecycle.LiveData) r2
            if (r2 == 0) goto L_0x0047
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x0048
        L_0x0047:
            r2 = r1
        L_0x0048:
            if (r2 != 0) goto L_0x004d
            kotlin.g.b.k.a()
        L_0x004d:
            net.one97.paytm.recharge.mobile.d.a r3 = r4.f63600h
            if (r3 == 0) goto L_0x0064
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r3 = r3.G
            androidx.lifecycle.LiveData r3 = (androidx.lifecycle.LiveData) r3
            if (r3 == 0) goto L_0x0064
            java.lang.Object r3 = r3.getValue()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r3 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r3
            if (r3 == 0) goto L_0x0064
            java.lang.String r3 = r3.getOperator()
            goto L_0x0065
        L_0x0064:
            r3 = r1
        L_0x0065:
            r0.<init>(r2, r3)
            net.one97.paytm.recharge.mobile.d.a r2 = r4.f63600h
            if (r2 == 0) goto L_0x0079
            androidx.lifecycle.y<java.lang.String> r2 = r2.z
            androidx.lifecycle.LiveData r2 = (androidx.lifecycle.LiveData) r2
            if (r2 == 0) goto L_0x0079
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x007a
        L_0x0079:
            r2 = r1
        L_0x007a:
            if (r2 != 0) goto L_0x007f
            kotlin.g.b.k.a()
        L_0x007f:
            r0.setRechargeNumber(r2)
            java.io.Serializable r0 = (java.io.Serializable) r0
            java.lang.String r2 = "selected_recent"
            r5.putExtra(r2, r0)
            net.one97.paytm.recharge.mobile.d.a r0 = r4.f63600h
            if (r0 == 0) goto L_0x00aa
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r0 = r0.G
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x00aa
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r0
            if (r0 == 0) goto L_0x00aa
            java.lang.Long r0 = r0.getProductId()
            if (r0 == 0) goto L_0x00aa
            long r2 = r0.longValue()
            java.lang.String r0 = java.lang.String.valueOf(r2)
            goto L_0x00ab
        L_0x00aa:
            r0 = r1
        L_0x00ab:
            java.lang.String r2 = "product_id"
            r5.putExtra(r2, r0)
            net.one97.paytm.recharge.mobile.d.a r0 = r4.f63600h
            if (r0 == 0) goto L_0x00c7
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r0 = r0.G
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x00c7
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r0
            if (r0 == 0) goto L_0x00c7
            java.lang.String r0 = r0.getImageUrl()
            goto L_0x00c8
        L_0x00c7:
            r0 = r1
        L_0x00c8:
            java.lang.String r2 = "operator_logo"
            r5.putExtra(r2, r0)
            net.one97.paytm.recharge.mobile.d.a r0 = r4.f63600h
            if (r0 == 0) goto L_0x00e4
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r0 = r0.G
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x00e4
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r0
            if (r0 == 0) goto L_0x00e4
            java.lang.String r0 = r0.getService()
            goto L_0x00e5
        L_0x00e4:
            r0 = r1
        L_0x00e5:
            java.lang.String r2 = "service_type"
            r5.putExtra(r2, r0)
            net.one97.paytm.recharge.mobile.d.a r0 = r4.f63600h
            if (r0 == 0) goto L_0x0100
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r0 = r0.G
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x0100
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r0
            if (r0 == 0) goto L_0x0100
            java.lang.String r1 = r0.getBankEMandateEnable()
        L_0x0100:
            r0 = 1
            java.lang.String r2 = "1"
            boolean r0 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r1, (boolean) r0)
            java.lang.String r1 = "is_bank_mandate_enabled"
            r5.putExtra(r1, r0)
            r4.startActivity(r5)
            return
        L_0x0110:
            super.a((net.one97.paytm.recharge.model.v4.CJRInstruct) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.b.a(net.one97.paytm.recharge.model.v4.CJRInstruct):void");
    }

    public final void onClick(View view) {
        CJRCategoryDataHelper cJRCategoryDataHelper;
        CJRCategoryData categoryData;
        LiveData liveData;
        Long l = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btn_proceed;
        if (valueOf == null || valueOf.intValue() != i2) {
            super.onClick(view);
        } else if (!com.paytm.utility.b.c((Context) getActivity())) {
            a((String) null, (NetworkCustomError) new as(false, 1, (g) null), (Object) null);
        } else {
            j();
            CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) b(R.id.btn_proceed);
            if (cJRProceedWidgetV8 != null) {
                cJRProceedWidgetV8.a();
            }
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (aVar != null && aVar.f61411d) {
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    k.a();
                }
                k.a((Object) activity, "activity!!");
                Activity activity2 = activity;
                net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
                String str = (aVar2 == null || (liveData = aVar2.z) == null) ? null : (String) liveData.getValue();
                if (str == null) {
                    k.a();
                }
                k.a((Object) str, "mMobileRechargeViewModel…edMobileNumber()?.value!!");
                j childFragmentManager = getChildFragmentManager();
                k.a((Object) childFragmentManager, "childFragmentManager");
                net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
                if (!(aVar3 == null || (cJRCategoryDataHelper = aVar3.f61409b) == null || (categoryData = cJRCategoryDataHelper.getCategoryData()) == null)) {
                    l = categoryData.getCategoryId();
                }
                this.z = new e(activity2, str, childFragmentManager, l, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void g() {
        ((CJRProceedWidgetV8) b(R.id.btn_proceed)).setProceedBtnText(getString(R.string.confirm));
    }

    /* renamed from: net.one97.paytm.recharge.mobile.a.b$b  reason: collision with other inner class name */
    public static final class C1234b extends BottomSheetBehavior.a {
        public final void onSlide(View view, float f2) {
            k.c(view, "bottomSheet");
        }

        public final void onStateChanged(View view, int i2) {
            k.c(view, "bottomSheet");
        }

        C1234b() {
        }
    }

    public final void an_() {
        if (getActivity() == null || !az.c(getActivity())) {
            startActivity(new Intent(getContext(), AJRAutomaticSubscriptionListActivity.class));
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        az.f(activity, "");
    }

    public final void aq_() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            d dVar = d.f64967a;
            CJRRechargeErrorModel a2 = d.a(ACTION_TYPE.CLP_PROCEED, ERROR_TYPE.UNDEFINED);
            d dVar2 = d.f64967a;
            d.b(a2, ACTION_TYPE.CLP_PROCEED);
            d dVar3 = d.f64967a;
            d.a(a2, ACTION_TYPE.CLP_PROCEED);
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (aVar != null) {
                k.a((Object) activity, "it");
                boolean unused = aVar.a(activity, "verify", "10", false, false, (String) null, (String) null, a2, (CJRPersonalInsurance) null, (String) null, (o) null);
            }
        }
    }

    public final void ar_() {
        l();
    }
}
