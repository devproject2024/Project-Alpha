package net.one97.paytm.recharge.mobile.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ac;
import net.one97.paytm.recharge.common.e.n;
import net.one97.paytm.recharge.common.e.p;
import net.one97.paytm.recharge.common.fragment.FJRRechargeUtilBaseFragment;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2;
import net.one97.paytm.recharge.mobile.activity.AJRMobileRechargeActivityV8;
import net.one97.paytm.recharge.mobile.d.a;
import net.one97.paytm.recharge.model.v4.CJRProductsItem;
import net.one97.paytm.recharge.model.v4.ErrorAction;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public class d extends FJRRechargeUtilBaseFragment implements ac, n, p, ba.a {
    public static final a m = new a((byte) 0);
    private static final Class<d> o = d.class;

    /* renamed from: f  reason: collision with root package name */
    private final int f63598f = 10;

    /* renamed from: g  reason: collision with root package name */
    public net.one97.paytm.recharge.mobile.d f63599g;

    /* renamed from: h  reason: collision with root package name */
    public net.one97.paytm.recharge.mobile.d.a f63600h;

    /* renamed from: i  reason: collision with root package name */
    public net.one97.paytm.recharge.common.b.a f63601i;
    protected FJRRechargeUtilityBaseV2.b j;
    protected ba k;
    public net.one97.paytm.recharge.ordersummary.h.d l;
    private boolean n;
    private HashMap p;

    public void a(ErrorAction errorAction) {
        k.c(errorAction, "action");
    }

    public View b(int i2) {
        if (this.p == null) {
            this.p = new HashMap();
        }
        View view = (View) this.p.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.p.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public void c(int i2) {
    }

    /* access modifiers changed from: protected */
    public void d(int i2) {
    }

    public void l() {
    }

    public final String m() {
        return "";
    }

    public String n() {
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
        return "";
    }

    public final String s() {
        return "";
    }

    public void u() {
        HashMap hashMap = this.p;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* access modifiers changed from: protected */
    public void z() {
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof net.one97.paytm.recharge.mobile.d) {
            this.f63599g = (net.one97.paytm.recharge.mobile.d) context;
        }
        if (context instanceof FJRRechargeUtilityBaseV2.b) {
            this.j = (FJRRechargeUtilityBaseV2.b) context;
        }
        if (getParentFragment() instanceof net.one97.paytm.recharge.mobile.d) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                this.f63599g = (net.one97.paytm.recharge.mobile.d) parentFragment;
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.mobile.IJRMobilelandingFragmentCommunicator");
            }
        }
        this.l = new net.one97.paytm.recharge.ordersummary.h.d(context);
        try {
            net.one97.paytm.recharge.mobile.d dVar = this.f63599g;
            this.f63600h = dVar != null ? dVar.h() : null;
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (aVar != null) {
                a((net.one97.paytm.recharge.common.h.b) aVar);
                this.f63601i = aVar.x;
            }
        } catch (Exception unused) {
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            cJRRechargeUtilities.debugLog(o + " recreated & re-started mobile-activity");
            a((CJRRechargeErrorModel) null);
        }
    }

    /* access modifiers changed from: protected */
    public void a(CJRRechargeErrorModel cJRRechargeErrorModel) {
        FragmentActivity activity;
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
        FragmentActivity activity3 = getActivity();
        Intent intent = activity3 != null ? activity3.getIntent() : null;
        if (intent != null && (activity = getActivity()) != null) {
            activity.startActivity(new Intent(getContext(), AJRMobileRechargeActivityV8.class).putExtras(intent).setFlags(603979776));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(int r13, int r14, android.content.Intent r15) {
        /*
            r12 = this;
            r0 = -1
            r1 = 7
            if (r13 == r1) goto L_0x00a3
            r1 = 607(0x25f, float:8.5E-43)
            if (r13 == r1) goto L_0x001a
            r1 = 800(0x320, float:1.121E-42)
            if (r13 == r1) goto L_0x000e
            goto L_0x00ac
        L_0x000e:
            if (r14 != r0) goto L_0x0015
            r12.c((int) r1)
            goto L_0x00ac
        L_0x0015:
            r12.d((int) r1)
            goto L_0x00ac
        L_0x001a:
            r13 = 0
            if (r15 == 0) goto L_0x007c
            java.lang.String r0 = "extra_agg_item"
            boolean r1 = r15.hasExtra(r0)
            r2 = 1
            if (r1 != r2) goto L_0x007c
            java.io.Serializable r14 = r15.getSerializableExtra(r0)
            boolean r15 = r14 instanceof net.one97.paytm.recharge.model.v4.CJRAggsItem
            if (r15 != 0) goto L_0x002f
            r14 = r13
        L_0x002f:
            net.one97.paytm.recharge.model.v4.CJRAggsItem r14 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r14
            if (r14 == 0) goto L_0x007b
            net.one97.paytm.recharge.common.utils.y r14 = net.one97.paytm.recharge.common.utils.y.f61814b
            java.util.LinkedList r14 = net.one97.paytm.recharge.common.utils.y.i()
            net.one97.paytm.recharge.mobile.d.a r15 = r12.f63600h
            if (r15 == 0) goto L_0x003f
            r15.P = r2
        L_0x003f:
            net.one97.paytm.recharge.mobile.d.a r15 = r12.f63600h
            if (r15 == 0) goto L_0x0046
            r15.a((java.util.LinkedList<net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem>) r14)
        L_0x0046:
            if (r14 == 0) goto L_0x0057
            java.lang.Object r14 = r14.getFirst()     // Catch:{ Exception -> 0x0055 }
            net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem r14 = (net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem) r14     // Catch:{ Exception -> 0x0055 }
            if (r14 == 0) goto L_0x0057
            java.lang.String r14 = r14.getValue()     // Catch:{ Exception -> 0x0055 }
            goto L_0x0058
        L_0x0055:
            r7 = r13
            goto L_0x0059
        L_0x0057:
            r14 = r13
        L_0x0058:
            r7 = r14
        L_0x0059:
            net.one97.paytm.recharge.mobile.d.a r14 = r12.f63600h
            if (r14 == 0) goto L_0x007b
            if (r7 == 0) goto L_0x007b
            net.one97.paytm.recharge.ordersummary.h.d r3 = r14.v
            net.one97.paytm.recharge.mobile.d.a r14 = r12.f63600h
            if (r14 == 0) goto L_0x0069
            java.lang.Object r13 = r14.e()
        L_0x0069:
            r4 = r13
            if (r4 != 0) goto L_0x006f
            kotlin.g.b.k.a()
        L_0x006f:
            r6 = 0
            r8 = 0
            r10 = 0
            r11 = 84
            java.lang.String r5 = "Operator_dropdown_item_selected"
            java.lang.String r9 = "manual"
            net.one97.paytm.recharge.ordersummary.h.d.a(r3, r4, r5, r6, r7, r8, r9, r10, r11)
        L_0x007b:
            return r2
        L_0x007c:
            if (r14 == 0) goto L_0x007f
            goto L_0x00a1
        L_0x007f:
            net.one97.paytm.recharge.mobile.d.a r14 = r12.f63600h
            if (r14 == 0) goto L_0x00a1
            net.one97.paytm.recharge.ordersummary.h.d r0 = r14.v
            if (r0 == 0) goto L_0x00a1
            net.one97.paytm.recharge.mobile.d.a r14 = r12.f63600h
            if (r14 == 0) goto L_0x008f
            java.lang.Object r13 = r14.e()
        L_0x008f:
            r1 = r13
            if (r1 != 0) goto L_0x0095
            kotlin.g.b.k.a()
        L_0x0095:
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 124(0x7c, float:1.74E-43)
            java.lang.String r2 = "operator_back_button_clicked"
            net.one97.paytm.recharge.ordersummary.h.d.a(r0, r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x00a1:
            r13 = 0
            return r13
        L_0x00a3:
            if (r14 != r0) goto L_0x00a9
            r12.c((int) r1)
            goto L_0x00ac
        L_0x00a9:
            r12.d((int) r1)
        L_0x00ac:
            boolean r13 = super.a((int) r13, (int) r14, (android.content.Intent) r15)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.d.a(int, int, android.content.Intent):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        if (r3 == null) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean ax_() {
        /*
            r5 = this;
            r5.j()
            android.content.Context r0 = r5.getContext()
            r1 = 0
            if (r0 == 0) goto L_0x0035
            androidx.fragment.app.FragmentActivity r2 = r5.getActivity()
            r3 = 0
            if (r2 == 0) goto L_0x0018
            java.lang.String r4 = "input_method"
            java.lang.Object r2 = r2.getSystemService(r4)
            goto L_0x0019
        L_0x0018:
            r2 = r3
        L_0x0019:
            boolean r4 = r2 instanceof android.view.inputmethod.InputMethodManager
            if (r4 != 0) goto L_0x001e
            r2 = r3
        L_0x001e:
            android.view.inputmethod.InputMethodManager r2 = (android.view.inputmethod.InputMethodManager) r2
            if (r2 == 0) goto L_0x0033
            android.view.View r3 = new android.view.View
            r3.<init>(r0)
            android.os.IBinder r0 = r3.getWindowToken()
            boolean r0 = r2.hideSoftInputFromWindow(r0, r1)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r0)
        L_0x0033:
            if (r3 != 0) goto L_0x003d
        L_0x0035:
            r0 = r5
            net.one97.paytm.recharge.mobile.a.d r0 = (net.one97.paytm.recharge.mobile.a.d) r0
            r0.j()
            kotlin.x r0 = kotlin.x.f47997a
        L_0x003d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.d.ax_():boolean");
    }

    public Map<String, Object> q() {
        String str;
        LiveData liveData;
        String str2;
        net.one97.paytm.recharge.common.h.b i2 = i();
        String groupFieldValuesForGA = i().f61409b.getGroupFieldValuesForGA();
        String str3 = groupFieldValuesForGA == null ? "" : groupFieldValuesForGA;
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar == null || (liveData = aVar.f61413f) == null || (str2 = (String) liveData.getValue()) == null) {
            str = "";
        } else {
            str = str2;
        }
        return i2.a("", str3, "", str, false);
    }

    public void a(String str, String str2) {
        k.c(str, "mobileNumber");
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        CJRFrequentOrder cJRFrequentOrder = null;
        if (aVar != null) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            k.c("requestMNP", "tag");
            k.c(str, "mobileNumber");
            if (aVar.D.containsKey(str)) {
                net.one97.paytm.recharge.common.utils.ac acVar = aVar.D.get(str);
                if (acVar == null) {
                    k.a();
                }
                k.a((Object) acVar, "enteredMobileNumberWithM…sponseMap[mobileNumber]!!");
                net.one97.paytm.recharge.mobile.d.a.a(aVar, str, acVar, false, false, 12);
            } else {
                aVar.X.put(str, Boolean.FALSE);
                aVar.Y.put(str, Boolean.FALSE);
                aVar.Z.put(str, Boolean.FALSE);
                aVar.aa.f("requestMNP", new a.C1242a(aVar, str), str, a2);
            }
        }
        net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
        if (aVar2 != null) {
            cJRFrequentOrder = aVar2.j();
        }
        if (cJRFrequentOrder == null) {
            i(str2);
        }
    }

    public final void c(String str) {
        k.c(str, "mobileNumber");
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        CJRFrequentOrder j2 = aVar != null ? aVar.j() : null;
        if (j2 != null) {
            net.one97.paytm.recharge.common.utils.ac acVar = new net.one97.paytm.recharge.common.utils.ac();
            Map<String, String> productAttributes = j2.getProductAttributes();
            if (productAttributes != null) {
                acVar.putAll(productAttributes);
                net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
                if (aVar2 != null) {
                    net.one97.paytm.recharge.mobile.d.a.a(aVar2, str, acVar, false, true, 4);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        r2 = r2.f61414g;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "label"
            kotlin.g.b.k.c(r7, r0)
            net.one97.paytm.recharge.mobile.d.a r0 = r5.f63600h
            r1 = 0
            if (r0 == 0) goto L_0x000d
            r0.a((net.one97.paytm.recharge.model.v4.CJRProductsItem) r1)
        L_0x000d:
            net.one97.paytm.recharge.mobile.d.a r0 = r5.f63600h
            if (r0 == 0) goto L_0x0014
            r0.a((net.one97.paytm.common.entity.recharge.CJRFrequentOrder) r1)
        L_0x0014:
            net.one97.paytm.recharge.mobile.d.a r0 = r5.f63600h
            if (r0 == 0) goto L_0x001a
            r0.C = r1
        L_0x001a:
            r0 = 0
            if (r6 == 0) goto L_0x0025
            int r2 = r6.length()     // Catch:{ Exception -> 0x0022 }
            goto L_0x0026
        L_0x0022:
            r6 = move-exception
            goto L_0x00be
        L_0x0025:
            r2 = 0
        L_0x0026:
            int r3 = r5.f63598f     // Catch:{ Exception -> 0x0022 }
            if (r2 < r3) goto L_0x00bb
            net.one97.paytm.recharge.mobile.d.a r2 = r5.f63600h     // Catch:{ Exception -> 0x0022 }
            if (r2 == 0) goto L_0x003b
            androidx.lifecycle.y<java.util.List<net.one97.paytm.common.entity.recharge.CJRFrequentOrder>> r2 = r2.f61414g     // Catch:{ Exception -> 0x0022 }
            androidx.lifecycle.LiveData r2 = (androidx.lifecycle.LiveData) r2     // Catch:{ Exception -> 0x0022 }
            if (r2 == 0) goto L_0x003b
            java.lang.Object r2 = r2.getValue()     // Catch:{ Exception -> 0x0022 }
            java.util.List r2 = (java.util.List) r2     // Catch:{ Exception -> 0x0022 }
            goto L_0x003c
        L_0x003b:
            r2 = r1
        L_0x003c:
            net.one97.paytm.recharge.mobile.d.a r3 = r5.f63600h     // Catch:{ Exception -> 0x0022 }
            if (r3 == 0) goto L_0x00b2
            boolean r3 = r3.f61411d     // Catch:{ Exception -> 0x0022 }
            if (r3 != 0) goto L_0x00b2
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x005b
            boolean r4 = r2.isEmpty()     // Catch:{ Exception -> 0x0022 }
            if (r4 != 0) goto L_0x005b
            net.one97.paytm.recharge.common.utils.ba r3 = r5.k     // Catch:{ Exception -> 0x0022 }
            if (r3 == 0) goto L_0x005a
            int r3 = r5.f63598f     // Catch:{ Exception -> 0x0022 }
            java.lang.String r2 = net.one97.paytm.recharge.common.utils.ba.a((java.util.List<net.one97.paytm.common.entity.recharge.CJRFrequentOrder>) r2, (java.lang.String) r6, (int) r3)     // Catch:{ Exception -> 0x0022 }
            r3 = r2
            goto L_0x005b
        L_0x005a:
            r3 = r1
        L_0x005b:
            r2 = r3
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x0022 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0022 }
            if (r2 == 0) goto L_0x0093
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r2 = new net.one97.paytm.common.entity.recharge.CJRFrequentOrder     // Catch:{ Exception -> 0x0022 }
            r2.<init>()     // Catch:{ Exception -> 0x0022 }
            androidx.fragment.app.FragmentActivity r3 = r5.getActivity()     // Catch:{ Exception -> 0x0022 }
            android.content.Context r3 = (android.content.Context) r3     // Catch:{ Exception -> 0x0022 }
            java.lang.String r3 = com.paytm.utility.b.ab(r3)     // Catch:{ Exception -> 0x0022 }
            r2.setRechargeNumber(r3)     // Catch:{ Exception -> 0x0022 }
            net.one97.paytm.recharge.common.utils.ba r3 = r5.k     // Catch:{ Exception -> 0x0022 }
            if (r3 == 0) goto L_0x0092
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0022 }
            r3 = 1
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder[] r3 = new net.one97.paytm.common.entity.recharge.CJRFrequentOrder[r3]     // Catch:{ Exception -> 0x0022 }
            r3[r0] = r2     // Catch:{ Exception -> 0x0022 }
            java.util.List r0 = java.util.Arrays.asList(r3)     // Catch:{ Exception -> 0x0022 }
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ Exception -> 0x0022 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0022 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ Exception -> 0x0022 }
            int r0 = r5.f63598f     // Catch:{ Exception -> 0x0022 }
            java.lang.String r1 = net.one97.paytm.recharge.common.utils.ba.a((java.util.List<net.one97.paytm.common.entity.recharge.CJRFrequentOrder>) r1, (java.lang.String) r6, (int) r0)     // Catch:{ Exception -> 0x0022 }
        L_0x0092:
            r3 = r1
        L_0x0093:
            r0 = r3
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x0022 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0022 }
            if (r0 != 0) goto L_0x00a9
            boolean r0 = r5.n     // Catch:{ Exception -> 0x0022 }
            if (r0 != 0) goto L_0x00a9
            if (r3 != 0) goto L_0x00a5
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0022 }
        L_0x00a5:
            r5.d((java.lang.String) r3)     // Catch:{ Exception -> 0x0022 }
            return
        L_0x00a9:
            if (r6 != 0) goto L_0x00ae
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0022 }
        L_0x00ae:
            r5.a(r6, r7)     // Catch:{ Exception -> 0x0022 }
            return
        L_0x00b2:
            if (r6 != 0) goto L_0x00b7
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0022 }
        L_0x00b7:
            r5.a(r6, r7)     // Catch:{ Exception -> 0x0022 }
            return
        L_0x00bb:
            r5.n = r0     // Catch:{ Exception -> 0x0022 }
            return
        L_0x00be:
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r7 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.String r0 = "onAutoProceedForMNP:: Number didnt match"
            r7.debugLog(r0)
            net.one97.paytm.recharge.widgets.c.d r7 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r7 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.UNDEFINED
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UI_DISTORT
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r7 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r7, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r1)
            r7.setErrorMsg(r0)
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r7, (java.lang.Throwable) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.d.b(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r2 = r2.f61413f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "correctedNumber"
            kotlin.g.b.k.c(r5, r0)
            net.one97.paytm.recharge.common.utils.ba r0 = r4.k
            if (r0 == 0) goto L_0x0034
            android.content.Context r1 = r4.getContext()
            net.one97.paytm.recharge.mobile.d.a r2 = r4.f63600h
            if (r2 == 0) goto L_0x001e
            androidx.lifecycle.y<java.lang.String> r2 = r2.f61413f
            androidx.lifecycle.LiveData r2 = (androidx.lifecycle.LiveData) r2
            if (r2 == 0) goto L_0x001e
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x001f
        L_0x001e:
            r2 = 0
        L_0x001f:
            net.one97.paytm.recharge.mobile.d.a r3 = r4.f63600h
            if (r3 == 0) goto L_0x002f
            java.lang.Object r3 = r3.e()
            if (r3 == 0) goto L_0x002f
            java.lang.String r3 = r3.toString()
            if (r3 != 0) goto L_0x0031
        L_0x002f:
            java.lang.String r3 = ""
        L_0x0031:
            r0.a((java.lang.String) r5, (android.content.Context) r1, (java.lang.String) r2, (java.lang.String) r3)
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.d.d(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r1 = r1.f61414g;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b_(java.lang.String r8) {
        /*
            r7 = this;
            r0 = 1
            r7.n = r0
            net.one97.paytm.recharge.mobile.d.a r1 = r7.f63600h
            r2 = 0
            if (r1 == 0) goto L_0x0015
            androidx.lifecycle.y<java.util.List<net.one97.paytm.common.entity.recharge.CJRFrequentOrder>> r1 = r1.f61414g
            androidx.lifecycle.LiveData r1 = (androidx.lifecycle.LiveData) r1
            if (r1 == 0) goto L_0x0015
            java.lang.Object r1 = r1.getValue()
            java.util.List r1 = (java.util.List) r1
            goto L_0x0016
        L_0x0015:
            r1 = r2
        L_0x0016:
            java.util.Collection r1 = (java.util.Collection) r1
            if (r1 == 0) goto L_0x0078
            boolean r3 = r1.isEmpty()
            r3 = r3 ^ r0
            if (r3 == 0) goto L_0x0078
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r1 = r1.iterator()
        L_0x0030:
            boolean r4 = r1.hasNext()
            r5 = 0
            if (r4 == 0) goto L_0x0051
            java.lang.Object r4 = r1.next()
            r6 = r4
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r6 = (net.one97.paytm.common.entity.recharge.CJRFrequentOrder) r6
            if (r8 == 0) goto L_0x004b
            java.lang.String r6 = r6.getRechargeNumber()
            boolean r6 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r6, (boolean) r0)
            if (r6 != r0) goto L_0x004b
            r5 = 1
        L_0x004b:
            if (r5 == 0) goto L_0x0030
            r3.add(r4)
            goto L_0x0030
        L_0x0051:
            java.util.List r3 = (java.util.List) r3
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r8 = r3.isEmpty()
            r8 = r8 ^ r0
            if (r8 == 0) goto L_0x0078
            java.util.List r3 = (java.util.List) r3
            net.one97.paytm.recharge.mobile.d.a r8 = r7.f63600h
            if (r8 == 0) goto L_0x0065
            r8.a((net.one97.paytm.recharge.model.v4.CJRProductsItem) r2)
        L_0x0065:
            net.one97.paytm.recharge.mobile.d.a r8 = r7.f63600h
            if (r8 == 0) goto L_0x006b
            r8.C = r2
        L_0x006b:
            net.one97.paytm.recharge.mobile.d.a r8 = r7.f63600h
            if (r8 == 0) goto L_0x0078
            java.lang.Object r0 = r3.get(r5)
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r0 = (net.one97.paytm.common.entity.recharge.CJRFrequentOrder) r0
            r8.a((net.one97.paytm.common.entity.recharge.CJRFrequentOrder) r0)
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.d.b_(java.lang.String):void");
    }

    public void as_() {
        this.n = false;
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            aVar.a((CJRProductsItem) null);
        }
        net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
        if (aVar2 != null) {
            aVar2.a((CJRFrequentOrder) null);
        }
        net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
        if (aVar3 != null) {
            aVar3.C = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        r3 = r1.getCategoryData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(java.lang.String r17) {
        /*
            r16 = this;
            r0 = r16
            java.lang.String r1 = "label"
            r6 = r17
            kotlin.g.b.k.c(r6, r1)
            android.content.Context r1 = r16.getContext()
            if (r1 != 0) goto L_0x0010
            return
        L_0x0010:
            net.one97.paytm.recharge.mobile.d.a r1 = r0.f63600h
            r11 = 0
            if (r1 == 0) goto L_0x0018
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r1 = r1.f61409b
            goto L_0x0019
        L_0x0018:
            r1 = r11
        L_0x0019:
            if (r1 == 0) goto L_0x0024
            net.one97.paytm.recharge.model.v4.CJRCategoryData r2 = r1.getCategoryData()
            if (r2 == 0) goto L_0x0024
            r2.removeAllSelections()
        L_0x0024:
            r2 = -1
            if (r1 == 0) goto L_0x0033
            net.one97.paytm.recharge.model.v4.CJRCategoryData r3 = r1.getCategoryData()
            if (r3 == 0) goto L_0x0033
            int r3 = r3.getGroupLevel()
            r12 = r3
            goto L_0x0034
        L_0x0033:
            r12 = -1
        L_0x0034:
            if (r1 == 0) goto L_0x0048
            net.one97.paytm.recharge.model.v4.CJRCategoryData r3 = r1.getCategoryData()
            if (r3 == 0) goto L_0x0048
            net.one97.paytm.recharge.model.v4.CJRGroupings r3 = r3.getGroupings()
            if (r3 == 0) goto L_0x0048
            java.lang.String r3 = r3.getAggKey()
            r13 = r3
            goto L_0x0049
        L_0x0048:
            r13 = r11
        L_0x0049:
            if (r12 == r2) goto L_0x01af
            boolean r3 = net.one97.paytm.recharge.common.utils.g.c(r13)
            if (r3 == 0) goto L_0x01af
            if (r1 == 0) goto L_0x005d
            if (r13 != 0) goto L_0x0058
            kotlin.g.b.k.a()
        L_0x0058:
            java.util.List r3 = r1.getGroupItemList(r12, r13)
            goto L_0x005e
        L_0x005d:
            r3 = r11
        L_0x005e:
            net.one97.paytm.recharge.common.utils.y r4 = net.one97.paytm.recharge.common.utils.y.f61814b
            net.one97.paytm.recharge.common.utils.y.a((java.util.List<net.one97.paytm.recharge.model.v4.CJRAggsItem>) r3)
            net.one97.paytm.recharge.common.utils.y r4 = net.one97.paytm.recharge.common.utils.y.f61814b
            net.one97.paytm.recharge.common.utils.y.a((net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper) r1)
            net.one97.paytm.recharge.common.utils.y r4 = net.one97.paytm.recharge.common.utils.y.f61814b
            java.util.LinkedList r4 = new java.util.LinkedList
            r4.<init>()
            net.one97.paytm.recharge.common.utils.y.a((java.util.LinkedList<net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem>) r4)
            net.one97.paytm.recharge.mobile.d.a r4 = r0.f63600h
            r14 = 1
            if (r4 == 0) goto L_0x00b2
            androidx.lifecycle.y<java.util.LinkedList<net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem>> r4 = r4.F
            androidx.lifecycle.LiveData r4 = (androidx.lifecycle.LiveData) r4
            if (r4 == 0) goto L_0x00b2
            java.lang.Object r4 = r4.getValue()
            java.util.LinkedList r4 = (java.util.LinkedList) r4
            if (r4 == 0) goto L_0x00b2
            net.one97.paytm.recharge.mobile.d.a r5 = r0.f63600h
            if (r5 == 0) goto L_0x00b2
            androidx.lifecycle.y<java.util.LinkedList<net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem>> r5 = r5.F
            androidx.lifecycle.LiveData r5 = (androidx.lifecycle.LiveData) r5
            if (r5 == 0) goto L_0x00b2
            java.lang.Object r5 = r5.getValue()
            java.util.LinkedList r5 = (java.util.LinkedList) r5
            if (r5 == 0) goto L_0x00b2
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ r14
            if (r5 != r14) goto L_0x00b0
            if (r3 == 0) goto L_0x00b0
            java.lang.Object r2 = r4.getFirst()
            net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem r2 = (net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem) r2
            net.one97.paytm.recharge.model.v4.CJRAggsItem r2 = r2.getItem()
            int r2 = kotlin.a.k.a(r3, r2)
        L_0x00b0:
            r15 = r2
            goto L_0x00b3
        L_0x00b2:
            r15 = -1
        L_0x00b3:
            net.one97.paytm.recharge.mobile.d.a r2 = r0.f63600h     // Catch:{ all -> 0x00fe }
            if (r2 == 0) goto L_0x00d7
            net.one97.paytm.recharge.ordersummary.h.d r2 = r2.v     // Catch:{ all -> 0x00fe }
            if (r2 == 0) goto L_0x00d7
            net.one97.paytm.recharge.mobile.d.a r3 = r0.f63600h     // Catch:{ all -> 0x00fe }
            if (r3 == 0) goto L_0x00c4
            java.lang.Object r3 = r3.e()     // Catch:{ all -> 0x00fe }
            goto L_0x00c5
        L_0x00c4:
            r3 = r11
        L_0x00c5:
            if (r3 != 0) goto L_0x00ca
            kotlin.g.b.k.a()     // Catch:{ all -> 0x00fe }
        L_0x00ca:
            java.lang.String r4 = "Operator_dropdown_clicked"
            r5 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 116(0x74, float:1.63E-43)
            r6 = r17
            net.one97.paytm.recharge.ordersummary.h.d.a(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x00fe }
        L_0x00d7:
            net.one97.paytm.recharge.di.helper.b r2 = net.one97.paytm.recharge.di.helper.b.f62652a     // Catch:{ all -> 0x00fe }
            android.content.Context r2 = r16.getContext()     // Catch:{ all -> 0x00fe }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fe }
            java.lang.String r4 = "/"
            r3.<init>(r4)     // Catch:{ all -> 0x00fe }
            net.one97.paytm.recharge.mobile.d.a r4 = r0.f63600h     // Catch:{ all -> 0x00fe }
            if (r4 == 0) goto L_0x00ed
            java.lang.Object r4 = r4.e()     // Catch:{ all -> 0x00fe }
            goto L_0x00ee
        L_0x00ed:
            r4 = r11
        L_0x00ee:
            r3.append(r4)     // Catch:{ all -> 0x00fe }
            java.lang.String r4 = "/operator"
            r3.append(r4)     // Catch:{ all -> 0x00fe }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00fe }
            net.one97.paytm.recharge.di.helper.b.a((android.content.Context) r2, (java.lang.String) r3)     // Catch:{ all -> 0x00fe }
            goto L_0x00ff
        L_0x00fe:
        L_0x00ff:
            android.content.Intent r2 = new android.content.Intent
            android.content.Context r3 = r16.getContext()
            java.lang.Class<net.one97.paytm.recharge.common.activity.AJRRechargeOperatorSelectionV8> r4 = net.one97.paytm.recharge.common.activity.AJRRechargeOperatorSelectionV8.class
            r2.<init>(r3, r4)
            if (r1 == 0) goto L_0x0116
            if (r13 != 0) goto L_0x0111
            kotlin.g.b.k.a()
        L_0x0111:
            java.lang.String r1 = r1.getGroupingTitle((int) r12, (java.lang.String) r13)
            goto L_0x0117
        L_0x0116:
            r1 = r11
        L_0x0117:
            java.lang.String r3 = "title"
            r2.putExtra(r3, r1)
            java.lang.String r1 = "select"
            r2.putExtra(r1, r14)
            androidx.fragment.app.FragmentActivity r1 = r16.getActivity()
            if (r1 == 0) goto L_0x0137
            androidx.fragment.app.FragmentActivity r1 = r16.getActivity()
            android.content.Context r1 = (android.content.Context) r1
            boolean r1 = net.one97.paytm.recharge.common.utils.az.b((android.content.Context) r1)
            r1 = r1 ^ r14
            java.lang.String r3 = "an"
            r2.putExtra(r3, r1)
        L_0x0137:
            java.lang.String r1 = "list_type"
            java.lang.String r3 = "inputGrouping"
            r2.putExtra(r1, r3)
            java.lang.String r1 = "skip_clear_grouping_selection"
            r2.putExtra(r1, r14)
            java.lang.String r1 = "flightSelectedFilter"
            r2.putExtra(r1, r15)
            int r1 = net.one97.paytm.recharge.R.color.white
            java.lang.String r3 = "toolbar_background_color"
            r2.putExtra(r3, r1)
            net.one97.paytm.recharge.mobile.d.a r1 = r0.f63600h
            r3 = 0
            if (r1 == 0) goto L_0x0157
            boolean r1 = r1.f61411d
            goto L_0x0158
        L_0x0157:
            r1 = 0
        L_0x0158:
            java.lang.String r4 = "open_activity_in_automatic_mode"
            r2.putExtra(r4, r1)
            net.one97.paytm.recharge.mobile.d.a r1 = r0.f63600h
            if (r1 == 0) goto L_0x016b
            net.one97.paytm.common.entity.CJRItem r1 = r1.r
            if (r1 == 0) goto L_0x016b
            java.lang.String r1 = r1.getName()
            if (r1 != 0) goto L_0x016d
        L_0x016b:
            java.lang.String r1 = ""
        L_0x016d:
            java.lang.String r4 = "category_name"
            r2.putExtra(r4, r1)
            net.one97.paytm.recharge.automatic.b.a.a$a r1 = net.one97.paytm.recharge.automatic.b.a.a.f60239a
            java.lang.String r1 = net.one97.paytm.recharge.automatic.b.a.a.f60240b
            net.one97.paytm.recharge.mobile.d.a r4 = r0.f63600h
            if (r4 == 0) goto L_0x0180
            java.lang.Object r11 = r4.e()
        L_0x0180:
            java.lang.String r4 = java.lang.String.valueOf(r11)
            r2.putExtra(r1, r4)
            androidx.fragment.app.FragmentActivity r1 = r16.getActivity()
            if (r1 == 0) goto L_0x01a9
            androidx.fragment.app.FragmentActivity r1 = r16.getActivity()
            android.content.Context r1 = (android.content.Context) r1
            boolean r1 = net.one97.paytm.recharge.common.utils.az.b((android.content.Context) r1)
            if (r1 == 0) goto L_0x01a9
            net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8$a r1 = net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8.f61954f
            int r1 = net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8.m
            java.lang.String r4 = "view_type_brand"
            r2.putExtra(r4, r1)
            java.lang.String r1 = "extra.show.next"
            r2.putExtra(r1, r3)
        L_0x01a9:
            r1 = 607(0x25f, float:8.5E-43)
            r0.startActivityForResult(r2, r1)
            return
        L_0x01af:
            r16.z()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.d.e(java.lang.String):void");
    }

    public void a(String str, NetworkCustomError networkCustomError, Object obj) {
        super.a(str, networkCustomError, obj);
    }

    public void f(String str) {
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        k.c(str, "label");
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null && (dVar = aVar.v) != null) {
            net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
            Object e2 = aVar2 != null ? aVar2.e() : null;
            if (e2 == null) {
                k.a();
            }
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, e2, "recent_selected_inline", "", str, (Object) null, (Object) null, (Object) null, 112);
        }
    }

    public void g(String str) {
        k.c(str, "label");
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            net.one97.paytm.recharge.ordersummary.h.d.a(aVar.v, aVar.e(), "phonebook_icon_clicked", (Object) null, str, (Object) null, (Object) null, (Object) null, 116);
        }
    }

    public void h(String str) {
        k.c(str, "label");
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            net.one97.paytm.recharge.ordersummary.h.d dVar = aVar.v;
            net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
            Object e2 = aVar2 != null ? aVar2.e() : null;
            if (e2 == null) {
                k.a();
            }
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, e2, "my_number_selected", (Object) null, str, (Object) null, (Object) null, (Object) null, 116);
        }
    }

    public void i(String str) {
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            net.one97.paytm.recharge.ordersummary.h.d dVar = aVar.v;
            net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
            Object e2 = aVar2 != null ? aVar2.e() : null;
            if (e2 == null) {
                k.a();
            }
            if (str == null) {
                str = "";
            }
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, e2, "Enter Mobile Number_field _entered", (Object) null, str, (Object) null, (Object) null, (Object) null, 116);
        }
    }

    public final void a(Toolbar toolbar) {
        if (toolbar != null) {
            toolbar.setNavigationIcon(R.drawable.back_arrow);
        }
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener(new b(this));
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63602a;

        b(d dVar) {
            this.f63602a = dVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity;
            net.one97.paytm.recharge.mobile.d dVar = this.f63602a.f63599g;
            if (dVar != null && dVar.d() && (activity = this.f63602a.getActivity()) != null) {
                activity.finish();
            }
        }
    }
}
