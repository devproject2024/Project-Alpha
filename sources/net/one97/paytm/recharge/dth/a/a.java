package net.one97.paytm.recharge.dth.a;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity;
import net.one97.paytm.recharge.common.fragment.FJRRechargeUtilBaseFragment;
import net.one97.paytm.recharge.model.v4.ErrorAction;

public class a extends FJRRechargeUtilBaseFragment {

    /* renamed from: f  reason: collision with root package name */
    private HashMap f62658f;

    public final void a(ErrorAction errorAction) {
        k.c(errorAction, "action");
    }

    public View b(int i2) {
        if (this.f62658f == null) {
            this.f62658f = new HashMap();
        }
        View view = (View) this.f62658f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f62658f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void l() {
    }

    public final String m() {
        return "";
    }

    public final String n() {
        return "";
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        u();
    }

    public final String p() {
        return "";
    }

    public final String r() {
        return null;
    }

    public final String s() {
        return null;
    }

    public void u() {
        HashMap hashMap = this.f62658f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final void a(Toolbar toolbar) {
        k.c(toolbar, "toolbar");
        FragmentActivity activity = getActivity();
        if (activity != null && (activity instanceof AJRRechargeUtilityActivity)) {
            ((AJRRechargeUtilityActivity) activity).a(toolbar);
        }
    }

    public final Map<String, Object> q() {
        return new HashMap<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: java.util.List} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r4 = (r4 = r32.getAttributes()).get(0);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.util.HashMap<java.lang.String, java.lang.String> r31, net.one97.paytm.recharge.model.v4.CJRCategoryData r32, java.lang.String r33) {
        /*
            r30 = this;
            r0 = r31
            r1 = r33
            java.lang.String r2 = "hashMap"
            kotlin.g.b.k.c(r0, r2)
            java.lang.String r2 = "url"
            kotlin.g.b.k.c(r1, r2)
            r2 = 0
            r3 = 0
            if (r32 == 0) goto L_0x0025
            java.util.List r4 = r32.getAttributes()
            if (r4 == 0) goto L_0x0025
            java.lang.Object r4 = r4.get(r2)
            net.one97.paytm.recharge.model.v4.GroupAttributesItem r4 = (net.one97.paytm.recharge.model.v4.GroupAttributesItem) r4
            if (r4 == 0) goto L_0x0025
            java.lang.String r4 = r4.getName()
            goto L_0x0026
        L_0x0025:
            r4 = r3
        L_0x0026:
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            r6 = 1
            if (r5 != 0) goto L_0x0119
            java.util.Map r0 = (java.util.Map) r0
            java.lang.Object r0 = r0.get(r4)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x0119
            if (r32 == 0) goto L_0x0074
            net.one97.paytm.recharge.model.v4.CJRGroupings r4 = r32.getGroupings()
            if (r4 == 0) goto L_0x0074
            java.util.List r4 = r4.getAggs()
            if (r4 == 0) goto L_0x0074
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r4 = r4.iterator()
        L_0x0055:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L_0x0070
            java.lang.Object r7 = r4.next()
            r8 = r7
            net.one97.paytm.recharge.model.v4.CJRAggsItem r8 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r8
            java.lang.String r8 = r8.getValue()
            boolean r8 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r8, (boolean) r2)
            if (r8 == 0) goto L_0x0055
            r5.add(r7)
            goto L_0x0055
        L_0x0070:
            r4 = r5
            java.util.List r4 = (java.util.List) r4
            goto L_0x0075
        L_0x0074:
            r4 = r3
        L_0x0075:
            if (r4 == 0) goto L_0x0089
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L_0x007e
            goto L_0x0089
        L_0x007e:
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r0 = r4.isEmpty()
            r0 = r0 ^ r6
            if (r0 == 0) goto L_0x0088
            return r2
        L_0x0088:
            return r6
        L_0x0089:
            if (r32 == 0) goto L_0x009b
            java.lang.Long r4 = r32.getCategoryId()
            if (r4 == 0) goto L_0x009b
            long r4 = r4.longValue()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            if (r4 != 0) goto L_0x009d
        L_0x009b:
            java.lang.String r4 = ""
        L_0x009d:
            net.one97.paytm.recharge.widgets.c.d r5 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r3 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r3, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r3)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r5 = r3.getFlowName()
            if (r5 != 0) goto L_0x00d4
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r5 = new net.one97.paytm.recharge.widgets.model.CRUFlowModel
            r7 = r5
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 1048575(0xfffff, float:1.469367E-39)
            r29 = 0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
        L_0x00d4:
            r3.setFlowName(r5)
            r3.setCategoryId(r4)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r4 = r3.getFlowName()
            if (r4 == 0) goto L_0x00e9
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r5 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UI_DESCRIPTION
            java.lang.String r5 = r5.name()
            r4.setErrorType(r5)
        L_0x00e9:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r4 = r3.getFlowName()
            if (r4 == 0) goto L_0x00f8
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r5 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.DEEPLINK
            java.lang.String r5 = r5.name()
            r4.setActionType(r5)
        L_0x00f8:
            r4 = r1
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0104
            r3.setUrl(r1)
        L_0x0104:
            int r1 = net.one97.paytm.recharge.R.string.product_not_found
            java.lang.Object[] r4 = new java.lang.Object[r6]
            r4[r2] = r0
            r0 = r30
            java.lang.String r1 = r0.getString(r1, r4)
            r3.setErrorMsg(r1)
            net.one97.paytm.recharge.common.utils.az r1 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r3)
            return r6
        L_0x0119:
            r0 = r30
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.a.a.a(java.util.HashMap, net.one97.paytm.recharge.model.v4.CJRCategoryData, java.lang.String):boolean");
    }
}
