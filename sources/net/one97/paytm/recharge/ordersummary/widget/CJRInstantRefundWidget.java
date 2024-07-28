package net.one97.paytm.recharge.ordersummary.widget;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.b.c.e;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8;
import net.one97.paytm.recharge.model.imps.CJRRefundAllocatedInfoV8;
import net.one97.paytm.recharge.model.imps.CJRRefundConsultViewV8;
import net.one97.paytm.recharge.ordersummary.f.q;
import net.one97.paytm.recharge.ordersummary.f.t;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class CJRInstantRefundWidget extends ConstraintLayout implements q, t.b {
    /* access modifiers changed from: private */
    public static ArrayList<CJRRefundAllocatedInfoV8> A = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    static int f64396d = 1;
    /* access modifiers changed from: package-private */

    /* renamed from: e  reason: collision with root package name */
    public static Boolean f64397e = Boolean.FALSE;

    /* renamed from: f  reason: collision with root package name */
    public static final c f64398f = new c((byte) 0);
    /* access modifiers changed from: private */
    public static String v = "TO_INSTANT";
    private static String w = "TO_SOURCE";
    private static int x = 2;
    private static int y = 1000;
    /* access modifiers changed from: private */
    public static int z = -1;
    private HashMap B;

    /* renamed from: a  reason: collision with root package name */
    CJRImpsRefundConsultViewV8 f64399a;

    /* renamed from: b  reason: collision with root package name */
    net.one97.paytm.recharge.ordersummary.g.f f64400b;

    /* renamed from: c  reason: collision with root package name */
    q f64401c;

    /* renamed from: g  reason: collision with root package name */
    private String f64402g = "";

    /* renamed from: h  reason: collision with root package name */
    private String f64403h;

    /* renamed from: i  reason: collision with root package name */
    private String f64404i;
    private ProgressDialog j;
    private List<RadioButton> k = new ArrayList();
    private List<TextView> l = new ArrayList();
    private String m = "&destination=TO_INSTANT";
    private b n;
    /* access modifiers changed from: private */
    public boolean o;
    private RecyclerView p;
    private String q = "";
    private String r = "";
    private IJRPaytmDataModel s;
    private Fragment t;
    private d u;

    public interface b {
        void a();
    }

    public interface d {
        void v();
    }

    public final View b(int i2) {
        if (this.B == null) {
            this.B = new HashMap();
        }
        View view = (View) this.B.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.B.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public CJRInstantRefundWidget(Context context, IJRPaytmDataModel iJRPaytmDataModel, Integer num, Fragment fragment, d dVar, q qVar) {
        super(context);
        Double refundAmount;
        this.s = iJRPaytmDataModel;
        this.t = fragment;
        this.u = dVar;
        this.f64401c = qVar;
        if (this.f64401c == null) {
            this.f64401c = this;
        }
        Fragment fragment2 = this.t;
        String str = null;
        if (fragment2 instanceof b) {
            this.n = (b) (!(fragment2 instanceof b) ? null : fragment2);
        }
        List<RadioButton> list = this.k;
        if (list != null) {
            list.clear();
        }
        IJRPaytmDataModel iJRPaytmDataModel2 = this.s;
        this.f64399a = (CJRImpsRefundConsultViewV8) (!(iJRPaytmDataModel2 instanceof CJRImpsRefundConsultViewV8) ? null : iJRPaytmDataModel2);
        CJRImpsRefundConsultViewV8 cJRImpsRefundConsultViewV8 = this.f64399a;
        this.f64403h = cJRImpsRefundConsultViewV8 != null ? cJRImpsRefundConsultViewV8.getCancelUrl() : null;
        CJRImpsRefundConsultViewV8 cJRImpsRefundConsultViewV82 = this.f64399a;
        this.f64404i = cJRImpsRefundConsultViewV82 != null ? cJRImpsRefundConsultViewV82.getOrderId() : null;
        CJRImpsRefundConsultViewV8 cJRImpsRefundConsultViewV83 = this.f64399a;
        this.r = context != null ? context.getString(R.string.imps_total_refund, new Object[]{ba.h((cJRImpsRefundConsultViewV83 == null || (refundAmount = cJRImpsRefundConsultViewV83.getRefundAmount()) == null) ? null : String.valueOf(refundAmount.doubleValue()))}) : str;
        if (this.f64399a != null) {
            LayoutInflater from = LayoutInflater.from(context);
            if (num == null) {
                k.a();
            }
            from.inflate(num.intValue(), this, true);
            getInstantRefundPresenter();
            g();
        }
    }

    public final Fragment getFragment() {
        return this.t;
    }

    public final q getImpsProgressListener() {
        return this.f64401c;
    }

    public final IJRPaytmDataModel getInstantRefundModal() {
        return this.s;
    }

    public final d getParentRefreshListener() {
        return this.u;
    }

    public final void setFragment(Fragment fragment) {
        this.t = fragment;
    }

    public final void setImpsProgressListener(q qVar) {
        this.f64401c = qVar;
    }

    public final void setInstantRefundModal(IJRPaytmDataModel iJRPaytmDataModel) {
        this.s = iJRPaytmDataModel;
    }

    public final void setParentRefreshListener(d dVar) {
        this.u = dVar;
    }

    public final String getCancelAppendString() {
        return this.m;
    }

    public final void setCancelAppendString(String str) {
        this.m = str;
    }

    public final b getCloseWidgetListener() {
        return this.n;
    }

    public final void setCloseWidgetListener(b bVar) {
        this.n = bVar;
    }

    public final RecyclerView getRvPaymentDetails() {
        return this.p;
    }

    public final void setRvPaymentDetails(RecyclerView recyclerView) {
        this.p = recyclerView;
    }

    public final String getErrorCode() {
        return this.q;
    }

    public final void setErrorCode(String str) {
        this.q = str;
    }

    public final String getRefundAmount() {
        return this.r;
    }

    public final void setRefundAmount(String str) {
        this.r = str;
    }

    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    public final String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -2020697580) {
                if (hashCode != 67452) {
                    if (hashCode == 2223588 && str.equals("HOUR")) {
                        Integer valueOf = str2 != null ? Integer.valueOf(Integer.parseInt(str2)) : null;
                        if (valueOf != null && valueOf.intValue() == 1) {
                            Context context = getContext();
                            if (context != null) {
                                return context.getString(R.string.imps_hour);
                            }
                            return null;
                        }
                        Context context2 = getContext();
                        if (context2 != null) {
                            return context2.getString(R.string.imps_hours);
                        }
                        return null;
                    }
                } else if (str.equals("DAY")) {
                    Integer valueOf2 = str2 != null ? Integer.valueOf(Integer.parseInt(str2)) : null;
                    if (valueOf2 != null && valueOf2.intValue() == 1) {
                        Context context3 = getContext();
                        if (context3 != null) {
                            return context3.getString(R.string.imps_day);
                        }
                        return null;
                    }
                    Context context4 = getContext();
                    if (context4 != null) {
                        return context4.getString(R.string.imps_days);
                    }
                    return null;
                }
            } else if (str.equals("MINUTE")) {
                Integer valueOf3 = str2 != null ? Integer.valueOf(Integer.parseInt(str2)) : null;
                if (valueOf3 != null && valueOf3.intValue() == 1) {
                    Context context5 = getContext();
                    if (context5 != null) {
                        return context5.getString(R.string.imps_minute);
                    }
                    return null;
                }
                Context context6 = getContext();
                if (context6 != null) {
                    return context6.getString(R.string.imps_minutes);
                }
                return null;
            }
        }
        return "";
    }

    public final void a(String str) {
        RecyclerView.a adapter;
        this.q = str;
        RecyclerView recyclerView = this.p;
        if (recyclerView != null && (adapter = recyclerView.getAdapter()) != null) {
            adapter.notifyDataSetChanged();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:97:0x013e, code lost:
        r8 = (r8 = r8.getMResultInfo()).getResultStatus();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.paytm.network.model.IJRPaytmDataModel r7, java.lang.Integer r8) {
        /*
            r6 = this;
            r0 = 2
            r1 = 1
            r2 = 0
            if (r8 != 0) goto L_0x0006
            goto L_0x000c
        L_0x0006:
            int r3 = r8.intValue()
            if (r3 == r0) goto L_0x0114
        L_0x000c:
            if (r8 != 0) goto L_0x000f
            goto L_0x0017
        L_0x000f:
            int r3 = r8.intValue()
            if (r3 != r1) goto L_0x0017
            goto L_0x0114
        L_0x0017:
            if (r8 != 0) goto L_0x001b
            goto L_0x00e0
        L_0x001b:
            int r0 = r8.intValue()
            r1 = 3
            if (r0 != r1) goto L_0x00e0
            java.lang.String r8 = r6.f64404i
            if (r8 == 0) goto L_0x00df
            net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8 r8 = r6.f64399a
            if (r8 == 0) goto L_0x002f
            net.one97.paytm.common.entity.shopping.CJROrderSummary r8 = r8.getOrderSummary()
            goto L_0x0030
        L_0x002f:
            r8 = r2
        L_0x0030:
            if (r8 != 0) goto L_0x0035
            kotlin.g.b.k.a()
        L_0x0035:
            java.util.ArrayList r8 = r8.getOrderedCartList()
            r0 = 0
            java.lang.Object r8 = r8.get(r0)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r8 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r8
            if (r8 == 0) goto L_0x0051
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r8 = r8.getProductDetail()
            if (r8 == 0) goto L_0x0051
            long r0 = r8.getCategoryId()
            java.lang.Long r8 = java.lang.Long.valueOf(r0)
            goto L_0x0052
        L_0x0051:
            r8 = r2
        L_0x0052:
            java.lang.String r8 = java.lang.String.valueOf(r8)
            net.one97.paytm.recharge.di.helper.b r0 = net.one97.paytm.recharge.di.helper.b.f62652a     // Catch:{ all -> 0x0066 }
            android.content.Context r0 = r6.getContext()     // Catch:{ all -> 0x0066 }
            java.lang.String r8 = net.one97.paytm.recharge.common.utils.ba.i(r8)     // Catch:{ all -> 0x0066 }
            java.lang.String r1 = "transaction_cancelled_screen_loaded"
            net.one97.paytm.recharge.di.helper.b.c(r0, r8, r1, r2)     // Catch:{ all -> 0x0066 }
            goto L_0x0067
        L_0x0066:
        L_0x0067:
            net.one97.paytm.recharge.ordersummary.f.q r8 = r6.f64401c
            if (r8 == 0) goto L_0x0070
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r8.a(r0)
        L_0x0070:
            net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget$b r8 = r6.n
            if (r8 == 0) goto L_0x0077
            r8.a()
        L_0x0077:
            net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget$d r8 = r6.u
            if (r8 == 0) goto L_0x0081
            if (r8 == 0) goto L_0x0080
            r8.v()
        L_0x0080:
            return
        L_0x0081:
            android.content.Context r8 = r6.getContext()
            boolean r8 = r8 instanceof net.one97.paytm.recharge.common.e.z
            if (r8 == 0) goto L_0x00a0
            if (r7 == 0) goto L_0x009f
            android.content.Context r8 = r6.getContext()
            if (r8 == 0) goto L_0x0097
            net.one97.paytm.recharge.common.e.z r8 = (net.one97.paytm.recharge.common.e.z) r8
            r8.a(r7)
            return
        L_0x0097:
            kotlin.u r7 = new kotlin.u
            java.lang.String r8 = "null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeListener"
            r7.<init>(r8)
            throw r7
        L_0x009f:
            return
        L_0x00a0:
            net.one97.paytm.recharge.widgets.c.d r7 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r7 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r2, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r2)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r8 = r7.getFlowName()
            if (r8 == 0) goto L_0x00b5
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r0 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.OS_INSTANT_REFUND
            java.lang.String r0 = r0.name()
            r8.setActionType(r0)
        L_0x00b5:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r8 = r7.getFlowName()
            if (r8 == 0) goto L_0x00c4
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r0 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r0 = r0.name()
            r8.setErrorType(r0)
        L_0x00c4:
            android.content.Context r8 = r6.getContext()
            if (r8 == 0) goto L_0x00d7
            net.one97.paytm.recharge.ordersummary.activity.CJRBaseOrderSummaryActivity r8 = (net.one97.paytm.recharge.ordersummary.activity.CJRBaseOrderSummaryActivity) r8
            java.lang.String r0 = r6.f64404i
            if (r0 != 0) goto L_0x00d3
            kotlin.g.b.k.a()
        L_0x00d3:
            r8.b(r0, r7)
            goto L_0x00df
        L_0x00d7:
            kotlin.u r7 = new kotlin.u
            java.lang.String r8 = "null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.activity.CJRBaseOrderSummaryActivity"
            r7.<init>(r8)
            throw r7
        L_0x00df:
            return
        L_0x00e0:
            if (r8 != 0) goto L_0x00e3
            return
        L_0x00e3:
            int r8 = r8.intValue()
            if (r8 != 0) goto L_0x0113
            net.one97.paytm.recharge.ordersummary.f.q r8 = r6.f64401c
            if (r8 == 0) goto L_0x00f2
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r8.a(r0)
        L_0x00f2:
            boolean r8 = r7 instanceof net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8
            if (r8 == 0) goto L_0x0113
            net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8 r0 = r6.f64399a
            if (r0 == 0) goto L_0x00ff
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r0.getOrderSummary()
            goto L_0x0100
        L_0x00ff:
            r0 = r2
        L_0x0100:
            if (r8 != 0) goto L_0x0103
            r7 = r2
        L_0x0103:
            net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8 r7 = (net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8) r7
            r6.f64399a = r7
            if (r0 == 0) goto L_0x0110
            net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8 r7 = r6.f64399a
            if (r7 == 0) goto L_0x0110
            r7.setOrderSummary(r0)
        L_0x0110:
            r6.g()
        L_0x0113:
            return
        L_0x0114:
            if (r7 == 0) goto L_0x0230
            boolean r3 = r7 instanceof net.one97.paytm.recharge.model.imps.CJRImpsRefundModel
            if (r3 != 0) goto L_0x011b
            r7 = r2
        L_0x011b:
            net.one97.paytm.recharge.model.imps.CJRImpsRefundModel r7 = (net.one97.paytm.recharge.model.imps.CJRImpsRefundModel) r7
            if (r7 == 0) goto L_0x0226
            java.lang.String r3 = "F"
            java.lang.String r4 = "S"
            java.lang.String r5 = "impsRefundModal"
            if (r8 != 0) goto L_0x0129
            goto L_0x01a1
        L_0x0129:
            int r8 = r8.intValue()
            if (r8 != r0) goto L_0x01a1
            kotlin.g.b.k.c(r7, r5)
            net.one97.paytm.recharge.model.imps.CJRImpsRefundBodyModel r8 = r7.getBody()
            if (r8 == 0) goto L_0x014d
            net.one97.paytm.recharge.model.imps.CJRImpsRefundResultInfo r8 = r8.getMResultInfo()
            if (r8 == 0) goto L_0x014d
            java.lang.String r8 = r8.getResultStatus()
            if (r8 == 0) goto L_0x014d
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r4, (boolean) r1)
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            goto L_0x014e
        L_0x014d:
            r8 = r2
        L_0x014e:
            if (r8 != 0) goto L_0x0153
            kotlin.g.b.k.a()
        L_0x0153:
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x015d
            r6.a()
            return
        L_0x015d:
            net.one97.paytm.recharge.model.imps.CJRImpsRefundBodyModel r8 = r7.getBody()
            if (r8 == 0) goto L_0x0178
            net.one97.paytm.recharge.model.imps.CJRImpsRefundResultInfo r8 = r8.getMResultInfo()
            if (r8 == 0) goto L_0x0178
            java.lang.String r8 = r8.getResultStatus()
            if (r8 == 0) goto L_0x0178
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r3, (boolean) r1)
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            goto L_0x0179
        L_0x0178:
            r8 = r2
        L_0x0179:
            if (r8 != 0) goto L_0x017e
            kotlin.g.b.k.a()
        L_0x017e:
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x01a0
            net.one97.paytm.recharge.ordersummary.f.q r8 = r6.f64401c
            if (r8 == 0) goto L_0x018d
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r8.a(r0)
        L_0x018d:
            net.one97.paytm.recharge.model.imps.CJRImpsRefundBodyModel r7 = r7.getBody()
            if (r7 == 0) goto L_0x019d
            net.one97.paytm.recharge.model.imps.CJRImpsRefundResultInfo r7 = r7.getMResultInfo()
            if (r7 == 0) goto L_0x019d
            java.lang.String r2 = r7.getResultCodeId()
        L_0x019d:
            r6.a((java.lang.String) r2)
        L_0x01a0:
            return
        L_0x01a1:
            kotlin.g.b.k.c(r7, r5)
            net.one97.paytm.recharge.model.imps.CJRImpsRefundBodyModel r8 = r7.getBody()
            if (r8 == 0) goto L_0x01bf
            net.one97.paytm.recharge.model.imps.CJRImpsRefundResultInfo r8 = r8.getMResultInfo()
            if (r8 == 0) goto L_0x01bf
            java.lang.String r8 = r8.getResultStatus()
            if (r8 == 0) goto L_0x01bf
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r4, (boolean) r1)
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            goto L_0x01c0
        L_0x01bf:
            r8 = r2
        L_0x01c0:
            if (r8 != 0) goto L_0x01c5
            kotlin.g.b.k.a()
        L_0x01c5:
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x01d1
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            r6.b((java.lang.Boolean) r7)
            return
        L_0x01d1:
            net.one97.paytm.recharge.model.imps.CJRImpsRefundBodyModel r8 = r7.getBody()
            if (r8 == 0) goto L_0x01ec
            net.one97.paytm.recharge.model.imps.CJRImpsRefundResultInfo r8 = r8.getMResultInfo()
            if (r8 == 0) goto L_0x01ec
            java.lang.String r8 = r8.getResultStatus()
            if (r8 == 0) goto L_0x01ec
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r3, (boolean) r1)
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            goto L_0x01ed
        L_0x01ec:
            r8 = r2
        L_0x01ed:
            if (r8 != 0) goto L_0x01f2
            kotlin.g.b.k.a()
        L_0x01f2:
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0225
            net.one97.paytm.recharge.model.imps.CJRImpsRefundBodyModel r7 = r7.getBody()
            if (r7 == 0) goto L_0x0208
            net.one97.paytm.recharge.model.imps.CJRImpsRefundResultInfo r7 = r7.getMResultInfo()
            if (r7 == 0) goto L_0x0208
            java.lang.String r2 = r7.getResultCodeId()
        L_0x0208:
            java.lang.String r7 = "2003"
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x0216
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            r6.b((java.lang.Boolean) r7)
            return
        L_0x0216:
            net.one97.paytm.recharge.ordersummary.f.q r7 = r6.f64401c
            if (r7 == 0) goto L_0x021f
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            r7.a(r8)
        L_0x021f:
            r6.f()
            r6.a((java.lang.String) r2)
        L_0x0225:
            return
        L_0x0226:
            java.lang.String r7 = r6.f64402g
            com.paytm.network.model.NetworkCustomError r7 = b((java.lang.String) r7)
            r6.a((com.paytm.network.model.NetworkCustomError) r7, (java.lang.Integer) r8)
            return
        L_0x0230:
            java.lang.String r7 = r6.f64402g
            com.paytm.network.model.NetworkCustomError r7 = b((java.lang.String) r7)
            r6.a((com.paytm.network.model.NetworkCustomError) r7, (java.lang.Integer) r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget.a(com.paytm.network.model.IJRPaytmDataModel, java.lang.Integer):void");
    }

    private static NetworkCustomError b(String str) {
        k.c(str, ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
        NetworkCustomError networkCustomError = new NetworkCustomError();
        networkCustomError.setmAlertTitle(str);
        return networkCustomError;
    }

    public final void a(NetworkCustomError networkCustomError, Integer num) {
        k.c(networkCustomError, "error");
        q qVar = this.f64401c;
        if (qVar != null) {
            qVar.a(Boolean.FALSE);
        }
        if (TextUtils.isEmpty(networkCustomError.getMessage()) || !CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError) || getContext() == null) {
            Context context = getContext();
            String string = context != null ? context.getString(R.string.imps_api_error_msg) : null;
            if (!TextUtils.isEmpty(networkCustomError.getAlertMessage())) {
                string = networkCustomError.getAlertMessage();
            }
            String alertTitle = !TextUtils.isEmpty(networkCustomError.getAlertTitle()) ? networkCustomError.getAlertTitle() : "";
            if (num == null || num.intValue() != 2) {
                if (num != null && num.intValue() == 1) {
                    f();
                } else if (num != null && num.intValue() == 3) {
                    f();
                    b bVar = this.n;
                    if (bVar != null) {
                        bVar.a();
                    }
                } else {
                    return;
                }
            }
            az azVar = az.f61525a;
            az.a(getContext(), ERROR_TYPE.UNDEFINED, ACTION_TYPE.OS_CTA_CANCEL, alertTitle, string);
            return;
        }
        CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
        Context context2 = getContext();
        if (context2 != null) {
            cJRRechargeUtilities.showSessionTimeoutAlert((Activity) context2, (String) null, (Bundle) null, networkCustomError, false, true);
            return;
        }
        throw new u("null cannot be cast to non-null type android.app.Activity");
    }

    public final void getInstantRefundPresenter() {
        if (this.f64400b == null) {
            t.b bVar = this;
            e.a aVar = net.one97.paytm.recharge.common.b.c.e.f60936b;
            Context context = getContext();
            k.a((Object) context, "context");
            net.one97.paytm.recharge.common.b.c.e a2 = e.a.a(context);
            CJRImpsRefundConsultViewV8 cJRImpsRefundConsultViewV8 = this.f64399a;
            this.f64400b = new net.one97.paytm.recharge.ordersummary.g.f(bVar, a2, cJRImpsRefundConsultViewV8 != null ? cJRImpsRefundConsultViewV8.getOrderSummary() : null);
        }
    }

    public final void a(View view) {
        RecyclerView.a adapter;
        k.c(view, "view");
        if (k.a(view.getTag(), (Object) Integer.valueOf(x))) {
            this.o = true;
            RecyclerView recyclerView = this.p;
            if (!(recyclerView == null || (adapter = recyclerView.getAdapter()) == null)) {
                adapter.notifyDataSetChanged();
            }
            String str = null;
            TextView textView = (TextView) (!(view instanceof TextView) ? null : view);
            if (textView != null) {
                Context context = getContext();
                if (context != null) {
                    str = context.getString(R.string.imps_add_another_account);
                }
                textView.setText(str);
            }
            view.setTag(Integer.valueOf(f64396d));
            return;
        }
        Intent intent = new Intent("net.one97.paytm.action.upi.onboarding.CHECK");
        Fragment fragment = this.t;
        if (fragment != null) {
            if (fragment != null) {
                fragment.startActivityForResult(intent, y);
            }
        } else if (getContext() != null) {
            Context context2 = getContext();
            if (context2 != null) {
                Activity activity = (Activity) context2;
                if (activity != null) {
                    activity.startActivityForResult(intent, y);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type android.app.Activity");
        }
    }

    public final void b(Boolean bool) {
        String str;
        if (this.f64403h == null) {
            q qVar = this.f64401c;
            if (qVar != null) {
                qVar.a(Boolean.FALSE);
                return;
            }
            return;
        }
        if (k.a((Object) bool, (Object) Boolean.TRUE) && (str = this.f64403h) != null) {
            CharSequence charSequence = str;
            String str2 = this.m;
            if (str2 == null) {
                k.a();
            }
            if (!p.a(charSequence, (CharSequence) str2, false)) {
                this.f64403h = k.a(this.f64403h, (Object) this.m);
            }
        }
        if (!TextUtils.isEmpty(this.f64403h)) {
            q qVar2 = this.f64401c;
            if (qVar2 != null) {
                qVar2.j();
            }
            net.one97.paytm.recharge.ordersummary.g.f fVar = this.f64400b;
            if (fVar != null) {
                fVar.a(3, this.f64403h);
            }
        }
    }

    private final void f() {
        RecyclerView.a adapter;
        CJRRefundAllocatedInfoV8 orgSelectedRefundAccount;
        CJRImpsRefundConsultViewV8 cJRImpsRefundConsultViewV8 = this.f64399a;
        if (!(cJRImpsRefundConsultViewV8 == null || (orgSelectedRefundAccount = cJRImpsRefundConsultViewV8.getOrgSelectedRefundAccount()) == null)) {
            orgSelectedRefundAccount.setAssetId((String) null);
        }
        RecyclerView recyclerView = this.p;
        if (recyclerView != null && (adapter = recyclerView.getAdapter()) != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public final void a() {
        CJRImpsRefundConsultViewV8 cJRImpsRefundConsultViewV8 = this.f64399a;
        String str = null;
        CJRRefundAllocatedInfoV8 locallySelectedRefundAccount = cJRImpsRefundConsultViewV8 != null ? cJRImpsRefundConsultViewV8.getLocallySelectedRefundAccount() : null;
        if (!TextUtils.isEmpty(locallySelectedRefundAccount != null ? locallySelectedRefundAccount.getMAccountId() : null)) {
            q qVar = this.f64401c;
            if (qVar != null) {
                qVar.j();
            }
            net.one97.paytm.recharge.ordersummary.g.f fVar = this.f64400b;
            if (fVar != null) {
                if (locallySelectedRefundAccount != null) {
                    str = locallySelectedRefundAccount.getMAccountId();
                }
                fVar.a(1, str);
            }
        }
    }

    public final void b() {
        List<RadioButton> list = this.k;
        if (list != null) {
            int i2 = 0;
            for (Object next : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.k.a();
                }
                RadioButton radioButton = (RadioButton) next;
                if (radioButton != null) {
                    radioButton.setChecked(false);
                }
                TextView textView = this.l.get(i2);
                if (!(textView == null || textView == null)) {
                    textView.setTextColor(androidx.core.content.b.c(getContext(), R.color.color_trans_black));
                }
                i2 = i3;
            }
        }
    }

    public final void setAddAccountText() {
        ArrayList<CJRRefundAllocatedInfoV8> arrayList = A;
        String str = null;
        if (arrayList != null) {
            if ((arrayList != null ? Integer.valueOf(arrayList.size()) : null).intValue() > 1) {
                this.o = false;
                TextView textView = (TextView) b(R.id.tv_add_account);
                if (textView != null) {
                    Context context = getContext();
                    if (context != null) {
                        str = context.getString(R.string.imps_view_all_linked_account);
                    }
                    textView.setText(str);
                }
                TextView textView2 = (TextView) b(R.id.tv_add_account);
                if (textView2 != null) {
                    textView2.setTag(Integer.valueOf(x));
                    return;
                }
                return;
            }
        }
        this.o = true;
        TextView textView3 = (TextView) b(R.id.tv_add_account);
        if (textView3 != null) {
            Context context2 = getContext();
            if (context2 != null) {
                str = context2.getString(R.string.imps_add_another_account);
            }
            textView3.setText(str);
        }
        TextView textView4 = (TextView) b(R.id.tv_add_account);
        if (textView4 != null) {
            textView4.setTag(Integer.valueOf(f64396d));
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRInstantRefundWidget f64441a;

        i(CJRInstantRefundWidget cJRInstantRefundWidget) {
            this.f64441a = cJRInstantRefundWidget;
        }

        public final void onClick(View view) {
            CJRInstantRefundWidget cJRInstantRefundWidget = this.f64441a;
            k.a((Object) view, "it");
            cJRInstantRefundWidget.a(view);
        }
    }

    /* JADX WARNING: type inference failed for: r1v30, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01ca A[Catch:{ Exception -> 0x01b9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g() {
        /*
            r25 = this;
            r8 = r25
            int r0 = net.one97.paytm.recharge.R.id.tv_add_account
            android.view.View r0 = r8.b((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0018
            net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget$i r1 = new net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget$i
            r1.<init>(r8)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0018:
            int r0 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r0 = r8.b((int) r0)
            android.widget.Button r0 = (android.widget.Button) r0
            if (r0 == 0) goto L_0x002e
            net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget$j r1 = new net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget$j
            r1.<init>(r8)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x002e:
            net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8 r9 = r8.f64399a
            if (r9 == 0) goto L_0x0781
            r0 = -1
            z = r0
            java.util.List<android.widget.RadioButton> r0 = r8.k
            if (r0 == 0) goto L_0x003e
            r0.clear()
            kotlin.x r0 = kotlin.x.f47997a
        L_0x003e:
            java.util.List<android.widget.TextView> r0 = r8.l
            if (r0 == 0) goto L_0x0047
            r0.clear()
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0047:
            java.util.ArrayList<net.one97.paytm.recharge.model.imps.CJRRefundAllocatedInfoV8> r0 = A
            if (r0 == 0) goto L_0x0050
            r0.clear()
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0050:
            r10 = 0
            r8.o = r10
            int r0 = net.one97.paytm.recharge.R.id.lyt_bank_list
            android.view.View r0 = r8.b((int) r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            if (r0 == 0) goto L_0x0062
            r0.removeAllViews()
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0062:
            int r0 = net.one97.paytm.recharge.R.id.lyt_org_account
            android.view.View r0 = r8.b((int) r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            if (r0 == 0) goto L_0x0071
            r0.removeAllViews()
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0071:
            java.lang.String r0 = r8.r
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 8
            if (r0 != 0) goto L_0x009e
            int r0 = net.one97.paytm.recharge.R.id.tv_total_refund
            android.view.View r0 = r8.b((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x008a
            r0.setVisibility(r10)
        L_0x008a:
            int r0 = net.one97.paytm.recharge.R.id.tv_total_refund     // Catch:{ Exception -> 0x009c }
            android.view.View r0 = r8.b((int) r0)     // Catch:{ Exception -> 0x009c }
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ Exception -> 0x009c }
            if (r0 == 0) goto L_0x00ab
            java.lang.String r2 = r8.r     // Catch:{ Exception -> 0x009c }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x009c }
            r0.setText(r2)     // Catch:{ Exception -> 0x009c }
            goto L_0x00ab
        L_0x009c:
            goto L_0x00ab
        L_0x009e:
            int r0 = net.one97.paytm.recharge.R.id.tv_total_refund
            android.view.View r0 = r8.b((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x00ab
            r0.setVisibility(r1)
        L_0x00ab:
            java.lang.String r11 = "timeUnit"
            r12 = 2
            java.lang.String r13 = "value"
            r14 = 1
            if (r9 == 0) goto L_0x01fa
            net.one97.paytm.recharge.model.imps.CJRWalletViewV8 r0 = r9.getWalletView()
            if (r0 == 0) goto L_0x01fa
            int r1 = net.one97.paytm.recharge.R.id.walletLayout
            android.view.View r1 = r8.b((int) r1)
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
            if (r1 == 0) goto L_0x00c6
            r1.setVisibility(r10)
        L_0x00c6:
            int r1 = net.one97.paytm.recharge.R.id.firstdivider
            android.view.View r1 = r8.b((int) r1)
            if (r1 == 0) goto L_0x00d1
            r1.setVisibility(r10)
        L_0x00d1:
            int r1 = net.one97.paytm.recharge.R.id.tv_wv_primarytext
            android.view.View r1 = r8.b((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x00fa
            android.content.Context r2 = r25.getContext()
            if (r2 == 0) goto L_0x00f4
            int r3 = net.one97.paytm.recharge.R.string.imps_refund_to
            java.lang.Object[] r4 = new java.lang.Object[r14]
            if (r0 == 0) goto L_0x00ec
            java.lang.String r5 = r0.getDestinationText()
            goto L_0x00ed
        L_0x00ec:
            r5 = 0
        L_0x00ed:
            r4[r10] = r5
            java.lang.String r2 = r2.getString(r3, r4)
            goto L_0x00f5
        L_0x00f4:
            r2 = 0
        L_0x00f5:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
        L_0x00fa:
            if (r0 == 0) goto L_0x0109
            java.util.HashMap r1 = r0.getMaxRefundTime()
            if (r1 == 0) goto L_0x0109
            java.lang.Object r1 = r1.get(r13)
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x010a
        L_0x0109:
            r1 = 0
        L_0x010a:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x017b
            if (r0 == 0) goto L_0x0121
            java.util.HashMap r1 = r0.getMaxRefundTime()
            if (r1 == 0) goto L_0x0121
            java.lang.Object r1 = r1.get(r11)
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x0122
        L_0x0121:
            r1 = 0
        L_0x0122:
            if (r0 == 0) goto L_0x0131
            java.util.HashMap r2 = r0.getMaxRefundTime()
            if (r2 == 0) goto L_0x0131
            java.lang.Object r2 = r2.get(r13)
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x0132
        L_0x0131:
            r2 = 0
        L_0x0132:
            java.lang.String r1 = r8.a((java.lang.String) r1, (java.lang.String) r2)
            android.content.Context r2 = r25.getContext()
            if (r2 == 0) goto L_0x0159
            int r3 = net.one97.paytm.recharge.R.string.imps_refund_time_details
            java.lang.Object[] r4 = new java.lang.Object[r12]
            if (r0 == 0) goto L_0x014f
            java.util.HashMap r5 = r0.getMaxRefundTime()
            if (r5 == 0) goto L_0x014f
            java.lang.Object r5 = r5.get(r13)
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x0150
        L_0x014f:
            r5 = 0
        L_0x0150:
            r4[r10] = r5
            r4[r14] = r1
            java.lang.String r1 = r2.getString(r3, r4)
            goto L_0x015a
        L_0x0159:
            r1 = 0
        L_0x015a:
            int r2 = net.one97.paytm.recharge.R.id.tv_wv_secondarytext
            android.view.View r2 = r8.b((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x016b
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.recharge.common.utils.ai.a(r2)
            kotlin.x r2 = kotlin.x.f47997a
        L_0x016b:
            int r2 = net.one97.paytm.recharge.R.id.tv_wv_secondarytext
            android.view.View r2 = r8.b((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x018c
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2.setText(r1)
            goto L_0x018c
        L_0x017b:
            int r1 = net.one97.paytm.recharge.R.id.tv_wv_secondarytext
            android.view.View r1 = r8.b((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x018c
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.recharge.common.utils.ai.b(r1)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x018c:
            if (r0 == 0) goto L_0x019d
            java.util.HashMap r1 = r0.getAmount()
            if (r1 == 0) goto L_0x019d
            java.lang.String r2 = "currency"
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x019e
        L_0x019d:
            r1 = 0
        L_0x019e:
            java.lang.String r2 = "INR"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r14)
            if (r1 == 0) goto L_0x01a9
            java.lang.String r1 = "₹"
            goto L_0x01aa
        L_0x01a9:
            r1 = 0
        L_0x01aa:
            if (r0 == 0) goto L_0x01bb
            java.util.HashMap r2 = r0.getAmount()     // Catch:{ Exception -> 0x01b9 }
            if (r2 == 0) goto L_0x01bb
            java.lang.Object r2 = r2.get(r13)     // Catch:{ Exception -> 0x01b9 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x01b9 }
            goto L_0x01bc
        L_0x01b9:
            goto L_0x01d4
        L_0x01bb:
            r2 = 0
        L_0x01bc:
            java.lang.String r2 = net.one97.paytm.recharge.common.utils.ba.h(r2)     // Catch:{ Exception -> 0x01b9 }
            int r3 = net.one97.paytm.recharge.R.id.tv_wv_amount     // Catch:{ Exception -> 0x01b9 }
            android.view.View r3 = r8.b((int) r3)     // Catch:{ Exception -> 0x01b9 }
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ Exception -> 0x01b9 }
            if (r3 == 0) goto L_0x01f7
            java.lang.String r2 = kotlin.g.b.k.a((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ Exception -> 0x01b9 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x01b9 }
            r3.setText(r2)     // Catch:{ Exception -> 0x01b9 }
            goto L_0x01f7
        L_0x01d4:
            int r2 = net.one97.paytm.recharge.R.id.tv_wv_amount
            android.view.View r2 = r8.b((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x01f7
            if (r0 == 0) goto L_0x01ed
            java.util.HashMap r0 = r0.getAmount()
            if (r0 == 0) goto L_0x01ed
            java.lang.Object r0 = r0.get(r13)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x01ee
        L_0x01ed:
            r0 = 0
        L_0x01ee:
            java.lang.String r0 = kotlin.g.b.k.a((java.lang.String) r1, (java.lang.Object) r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.setText(r0)
        L_0x01f7:
            kotlin.x r0 = kotlin.x.f47997a
            goto L_0x0214
        L_0x01fa:
            int r0 = net.one97.paytm.recharge.R.id.walletLayout
            android.view.View r0 = r8.b((int) r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            if (r0 == 0) goto L_0x0207
            r0.setVisibility(r1)
        L_0x0207:
            int r0 = net.one97.paytm.recharge.R.id.firstdivider
            android.view.View r0 = r8.b((int) r0)
            if (r0 == 0) goto L_0x0212
            r0.setVisibility(r1)
        L_0x0212:
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0214:
            if (r9 == 0) goto L_0x0770
            java.util.List r0 = r9.getOtherRefundConsultView()
            if (r0 == 0) goto L_0x0770
            if (r0 == 0) goto L_0x076d
            int r1 = r0.size()
            if (r1 <= 0) goto L_0x076d
            java.util.Iterator r16 = r0.iterator()
        L_0x0228:
            boolean r0 = r16.hasNext()
            if (r0 == 0) goto L_0x0666
            java.lang.Object r0 = r16.next()
            r17 = r0
            net.one97.paytm.recharge.model.imps.CJRRefundConsultViewV8 r17 = (net.one97.paytm.recharge.model.imps.CJRRefundConsultViewV8) r17
            if (r17 == 0) goto L_0x0661
            java.lang.String r0 = r17.getDestination()
            java.lang.String r1 = "TO_INSTANT"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x031c
            int r0 = net.one97.paytm.recharge.R.id.instantrefundLayout
            android.view.View r0 = r8.b((int) r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            java.lang.String r1 = "instantrefundLayout"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.recharge.common.utils.ai.a(r0)
            java.util.List r0 = r17.getRefundAllocatedInfos()
            if (r0 == 0) goto L_0x065f
            int r1 = r0.size()
            if (r1 <= 0) goto L_0x065f
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
            r2 = 0
        L_0x026a:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0308
            java.lang.Object r3 = r0.next()
            int r4 = r2 + 1
            if (r2 >= 0) goto L_0x027b
            kotlin.a.k.a()
        L_0x027b:
            r2 = r3
            net.one97.paytm.recharge.model.imps.CJRRefundAllocatedInfoV8 r2 = (net.one97.paytm.recharge.model.imps.CJRRefundAllocatedInfoV8) r2
            if (r17 == 0) goto L_0x0285
            java.lang.String r3 = r17.getDisableReason()
            goto L_0x0286
        L_0x0285:
            r3 = 0
        L_0x0286:
            if (r3 == 0) goto L_0x02df
            if (r17 == 0) goto L_0x028f
            java.lang.String r3 = r17.getDisableReason()
            goto L_0x0290
        L_0x028f:
            r3 = 0
        L_0x0290:
            java.lang.String r5 = "null"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r5, (boolean) r14)
            if (r3 == 0) goto L_0x0299
            goto L_0x02df
        L_0x0299:
            if (r17 == 0) goto L_0x02a0
            java.lang.String r3 = r17.getDisableReason()
            goto L_0x02a1
        L_0x02a0:
            r3 = 0
        L_0x02a1:
            java.lang.String r5 = "IMPS_ACCOUNT_NOT_EXIST"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r5, (boolean) r14)
            if (r3 == 0) goto L_0x0305
            if (r2 == 0) goto L_0x02b0
            java.util.HashMap r3 = r2.getMaxRefundTime()
            goto L_0x02b1
        L_0x02b0:
            r3 = 0
        L_0x02b1:
            java.lang.String r5 = "24"
            r3.put(r13, r5)
            if (r2 == 0) goto L_0x02c3
            java.util.HashMap r3 = r2.getMaxRefundTime()
            if (r3 == 0) goto L_0x02c3
            java.lang.String r5 = "Hrs"
            r3.put(r11, r5)
        L_0x02c3:
            if (r2 == 0) goto L_0x02ca
            java.lang.String r3 = v
            r2.setStatus(r3)
        L_0x02ca:
            java.util.ArrayList<net.one97.paytm.recharge.model.imps.CJRRefundAllocatedInfoV8> r3 = A
            if (r3 == 0) goto L_0x02d5
            boolean r2 = r3.add(r2)
            java.lang.Boolean.valueOf(r2)
        L_0x02d5:
            if (r9 == 0) goto L_0x0305
            java.lang.Integer r2 = java.lang.Integer.valueOf(r14)
            r9.setStatus(r2)
            goto L_0x0305
        L_0x02df:
            if (r9 == 0) goto L_0x02e8
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)
            r9.setStatus(r3)
        L_0x02e8:
            if (r2 == 0) goto L_0x02ef
            java.lang.String r3 = r2.getAssetId()
            goto L_0x02f0
        L_0x02ef:
            r3 = 0
        L_0x02f0:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x0304
            java.util.ArrayList<net.one97.paytm.recharge.model.imps.CJRRefundAllocatedInfoV8> r3 = A
            if (r3 == 0) goto L_0x0305
            boolean r2 = r3.add(r2)
            java.lang.Boolean.valueOf(r2)
            goto L_0x0305
        L_0x0304:
            r1 = r2
        L_0x0305:
            r2 = r4
            goto L_0x026a
        L_0x0308:
            kotlin.x r0 = kotlin.x.f47997a
            if (r1 == 0) goto L_0x065f
            java.util.ArrayList<net.one97.paytm.recharge.model.imps.CJRRefundAllocatedInfoV8> r0 = A
            if (r0 == 0) goto L_0x065f
            if (r1 != 0) goto L_0x0315
            kotlin.g.b.k.a()
        L_0x0315:
            r0.add(r10, r1)
            kotlin.x r0 = kotlin.x.f47997a
            goto L_0x065f
        L_0x031c:
            java.lang.String r0 = r17.getDestination()
            java.lang.String r1 = "TO_SOURCE"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x065f
            int r0 = net.one97.paytm.recharge.R.id.lyt_org_account
            android.view.View r0 = r8.b((int) r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            if (r0 == 0) goto L_0x0339
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.recharge.common.utils.ai.a(r0)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0339:
            java.util.List r0 = r17.getRefundAllocatedInfos()
            if (r0 == 0) goto L_0x065f
            int r1 = r0.size()
            if (r1 <= 0) goto L_0x065f
            kotlin.g.b.x$e r7 = new kotlin.g.b.x$e
            r7.<init>()
            android.content.Context r1 = r25.getContext()
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r1)
            r7.element = r1
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r18 = r0.iterator()
            r19 = 0
        L_0x035c:
            boolean r0 = r18.hasNext()
            if (r0 == 0) goto L_0x065f
            java.lang.Object r0 = r18.next()
            r6 = r0
            net.one97.paytm.recharge.model.imps.CJRRefundAllocatedInfoV8 r6 = (net.one97.paytm.recharge.model.imps.CJRRefundAllocatedInfoV8) r6
            if (r6 == 0) goto L_0x0654
            if (r6 == 0) goto L_0x0372
            java.lang.String r0 = r6.getBankName()
            goto L_0x0373
        L_0x0372:
            r0 = 0
        L_0x0373:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0384
            if (r6 == 0) goto L_0x0382
            java.lang.String r0 = r6.getBankName()
            goto L_0x0386
        L_0x0382:
            r0 = 0
            goto L_0x0386
        L_0x0384:
            java.lang.String r0 = ""
        L_0x0386:
            if (r6 == 0) goto L_0x038d
            java.lang.String r1 = r6.getPayMethod()
            goto L_0x038e
        L_0x038d:
            r1 = 0
        L_0x038e:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x03b0
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x03a5
            java.lang.String r1 = " - "
            java.lang.String r0 = kotlin.g.b.k.a((java.lang.String) r0, (java.lang.Object) r1)
        L_0x03a5:
            if (r6 == 0) goto L_0x03ac
            java.lang.String r1 = r6.getPayMethod()
            goto L_0x03ad
        L_0x03ac:
            r1 = 0
        L_0x03ad:
            kotlin.g.b.k.a((java.lang.String) r0, (java.lang.Object) r1)
        L_0x03b0:
            if (r6 == 0) goto L_0x03b9
            java.lang.String r0 = r6.getSource_text()
            r20 = r0
            goto L_0x03bb
        L_0x03b9:
            r20 = 0
        L_0x03bb:
            if (r9 == 0) goto L_0x03d0
            java.lang.Integer r0 = r9.getStatus()
            if (r0 == 0) goto L_0x03d0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r14)
            boolean r0 = r0.equals(r1)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x03d1
        L_0x03d0:
            r0 = 0
        L_0x03d1:
            if (r0 != 0) goto L_0x03d6
            kotlin.g.b.k.a()
        L_0x03d6:
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x041f
            java.util.ArrayList<net.one97.paytm.recharge.model.imps.CJRRefundAllocatedInfoV8> r0 = A
            if (r0 == 0) goto L_0x03e7
            boolean r0 = r0.add(r6)
            java.lang.Boolean.valueOf(r0)
        L_0x03e7:
            if (r6 == 0) goto L_0x03ee
            java.lang.String r0 = w
            r6.setStatus(r0)
        L_0x03ee:
            int r0 = net.one97.paytm.recharge.R.id.lyt_org_account
            android.view.View r0 = r8.b((int) r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            if (r0 == 0) goto L_0x03ff
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.recharge.common.utils.ai.b(r0)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x03ff:
            int r0 = net.one97.paytm.recharge.R.id.seconddivider
            android.view.View r0 = r8.b((int) r0)
            if (r0 == 0) goto L_0x040c
            net.one97.paytm.recharge.common.utils.ai.b(r0)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x040c:
            int r0 = net.one97.paytm.recharge.R.id.tv_add_account
            android.view.View r0 = r8.b((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0654
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.recharge.common.utils.ai.b(r0)
            kotlin.x r0 = kotlin.x.f47997a
            goto L_0x0654
        L_0x041f:
            int r0 = net.one97.paytm.recharge.R.id.lyt_org_account
            android.view.View r0 = r8.b((int) r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            if (r0 == 0) goto L_0x0430
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.recharge.common.utils.ai.a(r0)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0430:
            int r0 = net.one97.paytm.recharge.R.id.seconddivider
            android.view.View r0 = r8.b((int) r0)
            if (r0 == 0) goto L_0x043d
            net.one97.paytm.recharge.common.utils.ai.a(r0)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x043d:
            int r0 = net.one97.paytm.recharge.R.id.tv_add_account
            android.view.View r0 = r8.b((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x044e
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.recharge.common.utils.ai.a(r0)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x044e:
            T r0 = r7.element
            android.view.LayoutInflater r0 = (android.view.LayoutInflater) r0
            int r1 = net.one97.paytm.recharge.R.layout.imps_org_payment_source_layout_v8
            int r2 = net.one97.paytm.recharge.R.id.lyt_org_account
            android.view.View r2 = r8.b((int) r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            android.view.View r5 = r0.inflate(r1, r2, r14)
            java.lang.String r0 = "inflater.inflate(R.layou…8, lyt_org_account, true)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)
            kotlin.g.b.x$e r1 = new kotlin.g.b.x$e
            r1.<init>()
            if (r5 == 0) goto L_0x0475
            int r0 = net.one97.paytm.recharge.R.id.view_selector
            android.view.View r0 = r5.findViewById(r0)
            android.widget.RadioButton r0 = (android.widget.RadioButton) r0
            goto L_0x0476
        L_0x0475:
            r0 = 0
        L_0x0476:
            r1.element = r0
            java.util.List<android.widget.RadioButton> r0 = r8.k
            if (r0 == 0) goto L_0x048c
            T r2 = r1.element
            android.widget.RadioButton r2 = (android.widget.RadioButton) r2
            java.lang.String r3 = "radioButton"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            boolean r0 = r0.add(r2)
            java.lang.Boolean.valueOf(r0)
        L_0x048c:
            if (r5 == 0) goto L_0x0498
            int r0 = net.one97.paytm.recharge.R.id.tv_bank_details
            android.view.View r0 = r5.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r4 = r0
            goto L_0x0499
        L_0x0498:
            r4 = 0
        L_0x0499:
            if (r5 == 0) goto L_0x04a5
            int r0 = net.one97.paytm.recharge.R.id.tv_account_number
            android.view.View r0 = r5.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r3 = r0
            goto L_0x04a6
        L_0x04a5:
            r3 = 0
        L_0x04a6:
            kotlin.g.b.x$e r2 = new kotlin.g.b.x$e
            r2.<init>()
            if (r5 == 0) goto L_0x04b6
            int r0 = net.one97.paytm.recharge.R.id.tv_os_refunddetail
            android.view.View r0 = r5.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x04b7
        L_0x04b6:
            r0 = 0
        L_0x04b7:
            r2.element = r0
            if (r5 == 0) goto L_0x04c4
            int r0 = net.one97.paytm.recharge.R.id.tv_primary_label
            android.view.View r0 = r5.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x04c5
        L_0x04c4:
            r0 = 0
        L_0x04c5:
            java.util.List<android.widget.TextView> r15 = r8.l
            if (r15 == 0) goto L_0x04d9
            T r14 = r2.element
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r10 = "refundDetailView"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r10)
            boolean r10 = r15.add(r14)
            java.lang.Boolean.valueOf(r10)
        L_0x04d9:
            if (r5 == 0) goto L_0x04fe
            net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget$f r10 = new net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget$f
            r15 = r0
            r0 = r10
            r14 = r2
            r12 = r3
            r3 = r7
            r21 = r15
            r15 = r4
            r4 = r19
            r22 = r14
            r14 = r5
            r5 = r17
            r23 = r6
            r6 = r9
            r24 = r7
            r7 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            android.view.View$OnClickListener r10 = (android.view.View.OnClickListener) r10
            r14.setOnClickListener(r10)
            kotlin.x r0 = kotlin.x.f47997a
            goto L_0x0509
        L_0x04fe:
            r21 = r0
            r22 = r2
            r12 = r3
            r15 = r4
            r14 = r5
            r23 = r6
            r24 = r7
        L_0x0509:
            r0 = r20
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0526
            if (r15 == 0) goto L_0x051d
            r4 = r15
            android.view.View r4 = (android.view.View) r4
            net.one97.paytm.recharge.common.utils.ai.a(r4)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x051d:
            java.lang.String r1 = "bankDetailView"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r1)
            r15.setText(r0)
            goto L_0x0530
        L_0x0526:
            if (r15 == 0) goto L_0x0530
            r4 = r15
            android.view.View r4 = (android.view.View) r4
            net.one97.paytm.recharge.common.utils.ai.b(r4)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0530:
            if (r23 == 0) goto L_0x0537
            java.lang.String r15 = r23.getMaskedAccountNo()
            goto L_0x0538
        L_0x0537:
            r15 = 0
        L_0x0538:
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r0 = android.text.TextUtils.isEmpty(r15)
            if (r0 != 0) goto L_0x055a
            if (r12 == 0) goto L_0x054a
            r3 = r12
            android.view.View r3 = (android.view.View) r3
            net.one97.paytm.recharge.common.utils.ai.a(r3)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x054a:
            if (r12 == 0) goto L_0x0564
            if (r23 == 0) goto L_0x0553
            java.lang.String r15 = r23.getMaskedAccountNo()
            goto L_0x0554
        L_0x0553:
            r15 = 0
        L_0x0554:
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r12.setText(r15)
            goto L_0x0564
        L_0x055a:
            if (r12 == 0) goto L_0x0564
            r3 = r12
            android.view.View r3 = (android.view.View) r3
            net.one97.paytm.recharge.common.utils.ai.b(r3)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0564:
            if (r23 == 0) goto L_0x0574
            java.util.HashMap r0 = r23.getMaxRefundTime()
            if (r0 == 0) goto L_0x0574
            java.lang.Object r0 = r0.get(r13)
            r15 = r0
            java.lang.String r15 = (java.lang.String) r15
            goto L_0x0575
        L_0x0574:
            r15 = 0
        L_0x0575:
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r0 = android.text.TextUtils.isEmpty(r15)
            if (r0 != 0) goto L_0x05e8
            if (r23 == 0) goto L_0x058d
            java.util.HashMap r0 = r23.getMaxRefundTime()
            if (r0 == 0) goto L_0x058d
            java.lang.Object r0 = r0.get(r11)
            r15 = r0
            java.lang.String r15 = (java.lang.String) r15
            goto L_0x058e
        L_0x058d:
            r15 = 0
        L_0x058e:
            if (r23 == 0) goto L_0x059d
            java.util.HashMap r0 = r23.getMaxRefundTime()
            if (r0 == 0) goto L_0x059d
            java.lang.Object r0 = r0.get(r13)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x059e
        L_0x059d:
            r0 = 0
        L_0x059e:
            java.lang.String r0 = r8.a((java.lang.String) r15, (java.lang.String) r0)
            android.content.Context r1 = r25.getContext()
            if (r1 == 0) goto L_0x05cc
            int r2 = net.one97.paytm.recharge.R.string.imps_org_refung_dur_key
            r3 = 2
            java.lang.Object[] r4 = new java.lang.Object[r3]
            if (r23 == 0) goto L_0x05be
            java.util.HashMap r3 = r23.getMaxRefundTime()
            if (r3 == 0) goto L_0x05be
            java.lang.Object r3 = r3.get(r13)
            r15 = r3
            java.lang.String r15 = (java.lang.String) r15
            r3 = 0
            goto L_0x05c0
        L_0x05be:
            r3 = 0
            r15 = 0
        L_0x05c0:
            r4[r3] = r15
            r3 = 1
            r4[r3] = r0
            java.lang.String r15 = r1.getString(r2, r4)
            r0 = r22
            goto L_0x05cf
        L_0x05cc:
            r0 = r22
            r15 = 0
        L_0x05cf:
            T r1 = r0.element
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x05dc
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.recharge.common.utils.ai.a(r1)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x05dc:
            T r0 = r0.element
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x05f7
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r0.setText(r15)
            goto L_0x05f7
        L_0x05e8:
            r0 = r22
            T r0 = r0.element
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x05f7
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.recharge.common.utils.ai.b(r0)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x05f7:
            if (r23 == 0) goto L_0x05fe
            java.lang.String r15 = r23.getDestinationText()
            goto L_0x05ff
        L_0x05fe:
            r15 = 0
        L_0x05ff:
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r0 = android.text.TextUtils.isEmpty(r15)
            if (r0 != 0) goto L_0x0624
            if (r21 == 0) goto L_0x0612
            r0 = r21
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.recharge.common.utils.ai.a(r0)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0612:
            if (r21 == 0) goto L_0x062f
            if (r23 == 0) goto L_0x061b
            java.lang.String r15 = r23.getDestinationText()
            goto L_0x061c
        L_0x061b:
            r15 = 0
        L_0x061c:
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r0 = r21
            r0.setText(r15)
            goto L_0x062f
        L_0x0624:
            r0 = r21
            if (r0 == 0) goto L_0x062f
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.recharge.common.utils.ai.b(r0)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x062f:
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            if (r23 == 0) goto L_0x063a
            java.lang.String r15 = r23.getBankImageUrl()
            goto L_0x063b
        L_0x063a:
            r15 = 0
        L_0x063b:
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r15)
            if (r0 == 0) goto L_0x0656
            if (r14 == 0) goto L_0x064d
            int r1 = net.one97.paytm.recharge.R.id.img_bank_logo
            android.view.View r1 = r14.findViewById(r1)
            r15 = r1
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            goto L_0x064e
        L_0x064d:
            r15 = 0
        L_0x064e:
            r0.a((android.widget.ImageView) r15)
            kotlin.x r0 = kotlin.x.f47997a
            goto L_0x0656
        L_0x0654:
            r24 = r7
        L_0x0656:
            int r19 = r19 + 1
            r7 = r24
            r10 = 0
            r12 = 2
            r14 = 1
            goto L_0x035c
        L_0x065f:
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0661:
            r10 = 0
            r12 = 2
            r14 = 1
            goto L_0x0228
        L_0x0666:
            java.util.ArrayList<net.one97.paytm.recharge.model.imps.CJRRefundAllocatedInfoV8> r0 = A
            if (r0 == 0) goto L_0x076d
            if (r0 == 0) goto L_0x0675
            int r0 = r0.size()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r0)
            goto L_0x0676
        L_0x0675:
            r15 = 0
        L_0x0676:
            int r0 = r15.intValue()
            if (r0 <= 0) goto L_0x076b
            r25.setAddAccountText()
            java.util.ArrayList<net.one97.paytm.recharge.model.imps.CJRRefundAllocatedInfoV8> r0 = A
            if (r0 == 0) goto L_0x06cf
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x068a:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x06cd
            java.lang.Object r2 = r0.next()
            int r3 = r1 + 1
            if (r1 >= 0) goto L_0x069b
            kotlin.a.k.a()
        L_0x069b:
            net.one97.paytm.recharge.model.imps.CJRRefundAllocatedInfoV8 r2 = (net.one97.paytm.recharge.model.imps.CJRRefundAllocatedInfoV8) r2
            if (r2 == 0) goto L_0x06a4
            java.lang.String r15 = r2.getAssetId()
            goto L_0x06a5
        L_0x06a4:
            r15 = 0
        L_0x06a5:
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r4 = android.text.TextUtils.isEmpty(r15)
            if (r4 != 0) goto L_0x06cb
            z = r1
            if (r9 == 0) goto L_0x06b4
            r9.setSelectedIndex(r1)
        L_0x06b4:
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            f64397e = r4
            if (r2 == 0) goto L_0x06c1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
            r2.setSelectedIndex(r4)
        L_0x06c1:
            if (r9 == 0) goto L_0x06c6
            r9.setOrgSelectedRefundAccount(r2)
        L_0x06c6:
            if (r9 == 0) goto L_0x06cb
            r9.setOrgSelectedRefundAccountIndex(r1)
        L_0x06cb:
            r1 = r3
            goto L_0x068a
        L_0x06cd:
            kotlin.x r0 = kotlin.x.f47997a
        L_0x06cf:
            android.content.Context r0 = r25.getContext()
            android.view.LayoutInflater.from(r0)
            int r0 = net.one97.paytm.recharge.R.id.lyt_bank_list
            android.view.View r0 = r8.findViewById(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            r8.p = r0
            androidx.recyclerview.widget.RecyclerView r0 = r8.p
            if (r0 == 0) goto L_0x06e8
            r1 = 0
            r0.setVisibility(r1)
        L_0x06e8:
            androidx.recyclerview.widget.RecyclerView r0 = r8.p
            if (r0 == 0) goto L_0x06fa
            androidx.recyclerview.widget.LinearLayoutManager r1 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r2 = r25.getContext()
            r1.<init>(r2)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r1
            r0.setLayoutManager(r1)
        L_0x06fa:
            if (r9 == 0) goto L_0x0701
            java.lang.Integer r15 = r9.getStatus()
            goto L_0x0702
        L_0x0701:
            r15 = 0
        L_0x0702:
            if (r15 != 0) goto L_0x0705
            goto L_0x071b
        L_0x0705:
            int r0 = r15.intValue()
            r1 = 2
            if (r0 != r1) goto L_0x071b
            androidx.recyclerview.widget.RecyclerView r0 = r8.p
            if (r0 == 0) goto L_0x076b
            net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget$g r1 = new net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget$g
            r1.<init>(r9, r8)
            androidx.recyclerview.widget.RecyclerView$a r1 = (androidx.recyclerview.widget.RecyclerView.a) r1
            r0.setAdapter(r1)
            goto L_0x076b
        L_0x071b:
            if (r9 == 0) goto L_0x0722
            java.lang.Integer r15 = r9.getStatus()
            goto L_0x0723
        L_0x0722:
            r15 = 0
        L_0x0723:
            if (r15 != 0) goto L_0x0726
            goto L_0x076b
        L_0x0726:
            int r0 = r15.intValue()
            r1 = 1
            if (r0 != r1) goto L_0x076b
            r0 = 0
            if (r9 == 0) goto L_0x0733
            r9.setSelectedIndex(r0)
        L_0x0733:
            java.util.ArrayList<net.one97.paytm.recharge.model.imps.CJRRefundAllocatedInfoV8> r1 = A     // Catch:{ Exception -> 0x0756 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ Exception -> 0x0756 }
            net.one97.paytm.recharge.model.imps.CJRRefundAllocatedInfoV8 r1 = (net.one97.paytm.recharge.model.imps.CJRRefundAllocatedInfoV8) r1     // Catch:{ Exception -> 0x0756 }
            if (r1 == 0) goto L_0x0742
            java.lang.String r15 = r1.getStatus()     // Catch:{ Exception -> 0x0756 }
            goto L_0x0743
        L_0x0742:
            r15 = 0
        L_0x0743:
            java.lang.String r0 = v     // Catch:{ Exception -> 0x0756 }
            r1 = 1
            boolean r0 = kotlin.m.p.a((java.lang.String) r15, (java.lang.String) r0, (boolean) r1)     // Catch:{ Exception -> 0x0756 }
            if (r0 == 0) goto L_0x0751
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0756 }
            f64397e = r0     // Catch:{ Exception -> 0x0756 }
            goto L_0x075a
        L_0x0751:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0756 }
            f64397e = r0     // Catch:{ Exception -> 0x0756 }
            goto L_0x075a
        L_0x0756:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            f64397e = r0
        L_0x075a:
            r0 = 0
            z = r0
            androidx.recyclerview.widget.RecyclerView r0 = r8.p
            if (r0 == 0) goto L_0x076b
            net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget$h r1 = new net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget$h
            r1.<init>(r9, r8)
            androidx.recyclerview.widget.RecyclerView$a r1 = (androidx.recyclerview.widget.RecyclerView.a) r1
            r0.setAdapter(r1)
        L_0x076b:
            kotlin.x r0 = kotlin.x.f47997a
        L_0x076d:
            kotlin.x r0 = kotlin.x.f47997a
            return
        L_0x0770:
            int r0 = net.one97.paytm.recharge.R.id.instantrefundLayout
            android.view.View r0 = r8.b((int) r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            if (r0 == 0) goto L_0x0781
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.recharge.common.utils.ai.b(r0)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0781:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget.g():void");
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRInstantRefundWidget f64442a;

        j(CJRInstantRefundWidget cJRInstantRefundWidget) {
            this.f64442a = cJRInstantRefundWidget;
        }

        /* JADX WARNING: type inference failed for: r1v4, types: [java.lang.Long] */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
            r0 = r0.getStatus();
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r6) {
            /*
                r5 = this;
                net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget r6 = r5.f64442a
                java.lang.String r0 = ""
                r6.a((java.lang.String) r0)
                net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8 r0 = r6.f64399a
                r1 = 0
                if (r0 == 0) goto L_0x003c
                int r0 = r0.getSelectedIndex()
                r2 = -1
                if (r0 == r2) goto L_0x0014
                goto L_0x003c
            L_0x0014:
                android.content.Context r0 = r6.getContext()
                if (r0 == 0) goto L_0x0021
                int r2 = net.one97.paytm.recharge.R.string.imps_no_bank_selected_error_msg
                java.lang.String r0 = r0.getString(r2)
                goto L_0x0022
            L_0x0021:
                r0 = r1
            L_0x0022:
                android.content.Context r2 = r6.getContext()
                if (r2 == 0) goto L_0x002e
                int r1 = net.one97.paytm.recharge.R.string.error
                java.lang.String r1 = r2.getString(r1)
            L_0x002e:
                net.one97.paytm.recharge.common.utils.az r2 = net.one97.paytm.recharge.common.utils.az.f61525a
                android.content.Context r6 = r6.getContext()
                net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
                net.one97.paytm.recharge.widgets.model.ACTION_TYPE r3 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.OS_CTA_CANCEL
                net.one97.paytm.recharge.common.utils.az.a(r6, r2, r3, r1, r0)
                return
            L_0x003c:
                java.lang.Boolean r0 = net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget.f64397e
                java.lang.Boolean r2 = java.lang.Boolean.TRUE
                boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r2)
                java.lang.String r2 = "popup_procced_clicked"
                r3 = 0
                if (r0 == 0) goto L_0x0128
                net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8 r0 = r6.f64399a
                if (r0 == 0) goto L_0x0061
                java.lang.Integer r0 = r0.getStatus()
                if (r0 == 0) goto L_0x0061
                r4 = 1
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                boolean r0 = r0.equals(r4)
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                goto L_0x0062
            L_0x0061:
                r0 = r1
            L_0x0062:
                if (r0 != 0) goto L_0x0067
                kotlin.g.b.k.a()
            L_0x0067:
                boolean r0 = r0.booleanValue()
                if (r0 == 0) goto L_0x0083
                android.view.View r0 = new android.view.View
                android.content.Context r1 = r6.getContext()
                r0.<init>(r1)
                int r1 = net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget.f64396d
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                r0.setTag(r1)
                r6.a((android.view.View) r0)
                return
            L_0x0083:
                net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8 r0 = r6.f64399a
                if (r0 == 0) goto L_0x008c
                net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r0.getOrderSummary()
                goto L_0x008d
            L_0x008c:
                r0 = r1
            L_0x008d:
                if (r0 != 0) goto L_0x0092
                kotlin.g.b.k.a()
            L_0x0092:
                java.util.ArrayList r0 = r0.getOrderedCartList()
                java.lang.Object r0 = r0.get(r3)
                net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
                if (r0 == 0) goto L_0x00ad
                net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r0.getProductDetail()
                if (r0 == 0) goto L_0x00ad
                long r3 = r0.getCategoryId()
                java.lang.Long r0 = java.lang.Long.valueOf(r3)
                goto L_0x00ae
            L_0x00ad:
                r0 = r1
            L_0x00ae:
                java.lang.String r0 = java.lang.String.valueOf(r0)
                net.one97.paytm.recharge.di.helper.b r3 = net.one97.paytm.recharge.di.helper.b.f62652a     // Catch:{ all -> 0x00c2 }
                android.content.Context r3 = r6.getContext()     // Catch:{ all -> 0x00c2 }
                java.lang.String r0 = net.one97.paytm.recharge.common.utils.ba.i(r0)     // Catch:{ all -> 0x00c2 }
                java.lang.String r4 = "get_instant_refund"
                net.one97.paytm.recharge.di.helper.b.c(r3, r0, r2, r4)     // Catch:{ all -> 0x00c2 }
                goto L_0x00c3
            L_0x00c2:
            L_0x00c3:
                net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8 r0 = r6.f64399a
                if (r0 == 0) goto L_0x00cc
                net.one97.paytm.recharge.model.imps.CJRRefundAllocatedInfoV8 r0 = r0.getLocallySelectedRefundAccount()
                goto L_0x00cd
            L_0x00cc:
                r0 = r1
            L_0x00cd:
                if (r0 == 0) goto L_0x0122
                if (r0 == 0) goto L_0x00d6
                java.lang.String r0 = r0.getAssetId()
                goto L_0x00d7
            L_0x00d6:
                r0 = r1
            L_0x00d7:
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 == 0) goto L_0x011c
                net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8 r0 = r6.f64399a
                if (r0 == 0) goto L_0x00e8
                net.one97.paytm.recharge.model.imps.CJRRefundAllocatedInfoV8 r0 = r0.getOrgSelectedRefundAccount()
                goto L_0x00e9
            L_0x00e8:
                r0 = r1
            L_0x00e9:
                if (r0 == 0) goto L_0x0118
                java.lang.String r0 = r0.getAssetId()
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 == 0) goto L_0x00f8
                goto L_0x0118
            L_0x00f8:
                net.one97.paytm.recharge.ordersummary.f.q r0 = r6.f64401c
                if (r0 == 0) goto L_0x00ff
                r0.j()
            L_0x00ff:
                net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8 r0 = r6.f64399a
                if (r0 == 0) goto L_0x0108
                net.one97.paytm.recharge.model.imps.CJRRefundAllocatedInfoV8 r0 = r0.getOrgSelectedRefundAccount()
                goto L_0x0109
            L_0x0108:
                r0 = r1
            L_0x0109:
                net.one97.paytm.recharge.ordersummary.g.f r6 = r6.f64400b
                if (r6 == 0) goto L_0x0117
                r2 = 2
                if (r0 == 0) goto L_0x0114
                java.lang.String r1 = r0.getAssetId()
            L_0x0114:
                r6.a(r2, r1)
            L_0x0117:
                return
            L_0x0118:
                r6.a()
                return
            L_0x011c:
                java.lang.Boolean r0 = java.lang.Boolean.TRUE
                r6.b((java.lang.Boolean) r0)
                return
            L_0x0122:
                java.lang.Boolean r0 = java.lang.Boolean.TRUE
                r6.b((java.lang.Boolean) r0)
                return
            L_0x0128:
                net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8 r0 = r6.f64399a     // Catch:{ all -> 0x0164 }
                if (r0 == 0) goto L_0x0131
                net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r0.getOrderSummary()     // Catch:{ all -> 0x0164 }
                goto L_0x0132
            L_0x0131:
                r0 = r1
            L_0x0132:
                if (r0 != 0) goto L_0x0137
                kotlin.g.b.k.a()     // Catch:{ all -> 0x0164 }
            L_0x0137:
                java.util.ArrayList r0 = r0.getOrderedCartList()     // Catch:{ all -> 0x0164 }
                java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x0164 }
                net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0     // Catch:{ all -> 0x0164 }
                if (r0 == 0) goto L_0x0151
                net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r0.getProductDetail()     // Catch:{ all -> 0x0164 }
                if (r0 == 0) goto L_0x0151
                long r0 = r0.getCategoryId()     // Catch:{ all -> 0x0164 }
                java.lang.Long r1 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x0164 }
            L_0x0151:
                java.lang.String r0 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0164 }
                net.one97.paytm.recharge.di.helper.b r1 = net.one97.paytm.recharge.di.helper.b.f62652a     // Catch:{ all -> 0x0164 }
                android.content.Context r1 = r6.getContext()     // Catch:{ all -> 0x0164 }
                java.lang.String r0 = net.one97.paytm.recharge.common.utils.ba.i(r0)     // Catch:{ all -> 0x0164 }
                java.lang.String r3 = "original_payment_source"
                net.one97.paytm.recharge.di.helper.b.c(r1, r0, r2, r3)     // Catch:{ all -> 0x0164 }
            L_0x0164:
                java.lang.Boolean r0 = java.lang.Boolean.FALSE
                r6.b((java.lang.Boolean) r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget.j.onClick(android.view.View):void");
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f64420a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f64421b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x.e f64422c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f64423d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ CJRRefundConsultViewV8 f64424e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ CJRImpsRefundConsultViewV8 f64425f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ CJRInstantRefundWidget f64426g;

        f(x.e eVar, x.e eVar2, x.e eVar3, int i2, CJRRefundConsultViewV8 cJRRefundConsultViewV8, CJRImpsRefundConsultViewV8 cJRImpsRefundConsultViewV8, CJRInstantRefundWidget cJRInstantRefundWidget) {
            this.f64420a = eVar;
            this.f64421b = eVar2;
            this.f64422c = eVar3;
            this.f64423d = i2;
            this.f64424e = cJRRefundConsultViewV8;
            this.f64425f = cJRImpsRefundConsultViewV8;
            this.f64426g = cJRInstantRefundWidget;
        }

        public final void onClick(View view) {
            RecyclerView.a adapter;
            RadioButton radioButton = (RadioButton) this.f64420a.element;
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
            this.f64426g.setErrorCode("");
            CJRImpsRefundConsultViewV8 cJRImpsRefundConsultViewV8 = this.f64425f;
            if (cJRImpsRefundConsultViewV8 != null) {
                cJRImpsRefundConsultViewV8.setSelectedIndex(this.f64423d);
            }
            CJRInstantRefundWidget.z = -1;
            RecyclerView rvPaymentDetails = this.f64426g.getRvPaymentDetails();
            if (!(rvPaymentDetails == null || (adapter = rvPaymentDetails.getAdapter()) == null)) {
                adapter.notifyDataSetChanged();
            }
            CJRInstantRefundWidget.f64397e = Boolean.FALSE;
            TextView textView = (TextView) this.f64421b.element;
            if (textView != null) {
                textView.setTextColor(androidx.core.content.b.c(this.f64426g.getContext(), R.color.rc_header_pending_color));
            }
        }
    }

    public static final class g extends RecyclerView.a<a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRImpsRefundConsultViewV8 f64427a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRInstantRefundWidget f64428b;

        /* renamed from: c  reason: collision with root package name */
        private Boolean f64429c = Boolean.FALSE;

        g(CJRImpsRefundConsultViewV8 cJRImpsRefundConsultViewV8, CJRInstantRefundWidget cJRInstantRefundWidget) {
            this.f64427a = cJRImpsRefundConsultViewV8;
            this.f64428b = cJRInstantRefundWidget;
        }

        /* JADX WARNING: Removed duplicated region for block: B:101:0x0186  */
        /* JADX WARNING: Removed duplicated region for block: B:107:0x0197  */
        /* JADX WARNING: Removed duplicated region for block: B:133:0x01ec A[Catch:{ Exception -> 0x01d9 }] */
        /* JADX WARNING: Removed duplicated region for block: B:143:0x021d  */
        /* JADX WARNING: Removed duplicated region for block: B:144:0x0222  */
        /* JADX WARNING: Removed duplicated region for block: B:150:0x0231  */
        /* JADX WARNING: Removed duplicated region for block: B:151:0x0236  */
        /* JADX WARNING: Removed duplicated region for block: B:154:0x023e  */
        /* JADX WARNING: Removed duplicated region for block: B:155:0x0243  */
        /* JADX WARNING: Removed duplicated region for block: B:158:0x024c  */
        /* JADX WARNING: Removed duplicated region for block: B:172:0x0279  */
        /* JADX WARNING: Removed duplicated region for block: B:173:0x0280  */
        /* JADX WARNING: Removed duplicated region for block: B:180:0x0295  */
        /* JADX WARNING: Removed duplicated region for block: B:215:0x0322  */
        /* JADX WARNING: Removed duplicated region for block: B:219:0x032b  */
        /* JADX WARNING: Removed duplicated region for block: B:220:0x0330  */
        /* JADX WARNING: Removed duplicated region for block: B:223:0x0339  */
        /* JADX WARNING: Removed duplicated region for block: B:230:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r11, final int r12) {
            /*
                r10 = this;
                net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget$a r11 = (net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget.a) r11
                java.lang.String r0 = "holder"
                kotlin.g.b.k.c(r11, r0)
                java.util.ArrayList r0 = net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget.A
                java.lang.Object r0 = r0.get(r12)
                java.lang.String r1 = "instantBankList[position]"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                net.one97.paytm.recharge.model.imps.CJRRefundAllocatedInfoV8 r0 = (net.one97.paytm.recharge.model.imps.CJRRefundAllocatedInfoV8) r0
                android.view.View r1 = r11.f64412h
                if (r1 == 0) goto L_0x0024
                net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget$g$1 r2 = new net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget$g$1
                r2.<init>(r10, r11, r0, r12)
                android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
                r1.setOnClickListener(r2)
            L_0x0024:
                net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8 r1 = r10.f64427a
                r2 = 1
                r3 = 0
                r4 = 0
                if (r1 == 0) goto L_0x006b
                int r1 = r1.getOrgSelectedRefundAccountIndex()
                if (r12 != r1) goto L_0x006b
                net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8 r1 = r10.f64427a
                if (r1 == 0) goto L_0x003a
                net.one97.paytm.recharge.model.imps.CJRRefundAllocatedInfoV8 r1 = r1.getOrgSelectedRefundAccount()
                goto L_0x003b
            L_0x003a:
                r1 = r4
            L_0x003b:
                if (r1 == 0) goto L_0x0042
                java.lang.String r1 = r1.getAssetId()
                goto L_0x0043
            L_0x0042:
                r1 = r4
            L_0x0043:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 == 0) goto L_0x0053
                android.view.View r1 = r11.f64411g
                if (r1 == 0) goto L_0x007b
                net.one97.paytm.recharge.common.utils.ai.a(r1)
                goto L_0x007b
            L_0x0053:
                android.view.View r1 = r11.f64411g
                if (r1 == 0) goto L_0x005a
                net.one97.paytm.recharge.common.utils.ai.b(r1)
            L_0x005a:
                android.widget.RadioButton r1 = r11.f64409e
                if (r1 == 0) goto L_0x007b
                int r5 = net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget.z
                if (r5 != r12) goto L_0x0066
                r5 = 1
                goto L_0x0067
            L_0x0066:
                r5 = 0
            L_0x0067:
                r1.setChecked(r5)
                goto L_0x007b
            L_0x006b:
                android.widget.RadioButton r1 = r11.f64409e
                if (r1 == 0) goto L_0x007b
                int r5 = net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget.z
                if (r5 != r12) goto L_0x0077
                r5 = 1
                goto L_0x0078
            L_0x0077:
                r5 = 0
            L_0x0078:
                r1.setChecked(r5)
            L_0x007b:
                int r1 = net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget.z
                if (r1 != r12) goto L_0x01a1
                net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget r1 = r10.f64428b
                java.lang.String r5 = r1.getErrorCode()
                if (r5 != 0) goto L_0x008b
                goto L_0x017c
            L_0x008b:
                int r6 = r5.hashCode()
                r7 = 1507426(0x170062, float:2.112354E-39)
                if (r6 == r7) goto L_0x0165
                r7 = 1537246(0x1774de, float:2.15414E-39)
                if (r6 == r7) goto L_0x0150
                r7 = 1537254(0x1774e6, float:2.154152E-39)
                if (r6 == r7) goto L_0x013b
                switch(r6) {
                    case 1537215: goto L_0x0126;
                    case 1537216: goto L_0x0111;
                    case 1537217: goto L_0x00fb;
                    case 1537218: goto L_0x00e5;
                    case 1537219: goto L_0x00cf;
                    case 1537220: goto L_0x00b9;
                    case 1537221: goto L_0x00a3;
                    default: goto L_0x00a1;
                }
            L_0x00a1:
                goto L_0x017c
            L_0x00a3:
                java.lang.String r6 = "2007"
                boolean r5 = r5.equals(r6)
                if (r5 == 0) goto L_0x017c
                android.content.Context r1 = r1.getContext()
                if (r1 == 0) goto L_0x017a
                int r5 = net.one97.paytm.recharge.R.string.imps_2007
                java.lang.String r1 = r1.getString(r5)
                goto L_0x017e
            L_0x00b9:
                java.lang.String r6 = "2006"
                boolean r5 = r5.equals(r6)
                if (r5 == 0) goto L_0x017c
                android.content.Context r1 = r1.getContext()
                if (r1 == 0) goto L_0x017a
                int r5 = net.one97.paytm.recharge.R.string.imps_2006
                java.lang.String r1 = r1.getString(r5)
                goto L_0x017e
            L_0x00cf:
                java.lang.String r6 = "2005"
                boolean r5 = r5.equals(r6)
                if (r5 == 0) goto L_0x017c
                android.content.Context r1 = r1.getContext()
                if (r1 == 0) goto L_0x017a
                int r5 = net.one97.paytm.recharge.R.string.imps_2005
                java.lang.String r1 = r1.getString(r5)
                goto L_0x017e
            L_0x00e5:
                java.lang.String r6 = "2004"
                boolean r5 = r5.equals(r6)
                if (r5 == 0) goto L_0x017c
                android.content.Context r1 = r1.getContext()
                if (r1 == 0) goto L_0x017a
                int r5 = net.one97.paytm.recharge.R.string.imps_2004
                java.lang.String r1 = r1.getString(r5)
                goto L_0x017e
            L_0x00fb:
                java.lang.String r6 = "2003"
                boolean r5 = r5.equals(r6)
                if (r5 == 0) goto L_0x017c
                android.content.Context r1 = r1.getContext()
                if (r1 == 0) goto L_0x017a
                int r5 = net.one97.paytm.recharge.R.string.imps_2003
                java.lang.String r1 = r1.getString(r5)
                goto L_0x017e
            L_0x0111:
                java.lang.String r6 = "2002"
                boolean r5 = r5.equals(r6)
                if (r5 == 0) goto L_0x017c
                android.content.Context r1 = r1.getContext()
                if (r1 == 0) goto L_0x017a
                int r5 = net.one97.paytm.recharge.R.string.imps_2002
                java.lang.String r1 = r1.getString(r5)
                goto L_0x017e
            L_0x0126:
                java.lang.String r6 = "2001"
                boolean r5 = r5.equals(r6)
                if (r5 == 0) goto L_0x017c
                android.content.Context r1 = r1.getContext()
                if (r1 == 0) goto L_0x017a
                int r5 = net.one97.paytm.recharge.R.string.imps_2001
                java.lang.String r1 = r1.getString(r5)
                goto L_0x017e
            L_0x013b:
                java.lang.String r6 = "2019"
                boolean r5 = r5.equals(r6)
                if (r5 == 0) goto L_0x017c
                android.content.Context r1 = r1.getContext()
                if (r1 == 0) goto L_0x017a
                int r5 = net.one97.paytm.recharge.R.string.imps_2019
                java.lang.String r1 = r1.getString(r5)
                goto L_0x017e
            L_0x0150:
                java.lang.String r6 = "2011"
                boolean r5 = r5.equals(r6)
                if (r5 == 0) goto L_0x017c
                android.content.Context r1 = r1.getContext()
                if (r1 == 0) goto L_0x017a
                int r5 = net.one97.paytm.recharge.R.string.imps_2011
                java.lang.String r1 = r1.getString(r5)
                goto L_0x017e
            L_0x0165:
                java.lang.String r6 = "1003"
                boolean r5 = r5.equals(r6)
                if (r5 == 0) goto L_0x017c
                android.content.Context r1 = r1.getContext()
                if (r1 == 0) goto L_0x017a
                int r5 = net.one97.paytm.recharge.R.string.imps_1003
                java.lang.String r1 = r1.getString(r5)
                goto L_0x017e
            L_0x017a:
                r1 = r4
                goto L_0x017e
            L_0x017c:
                java.lang.String r1 = ""
            L_0x017e:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r5 = android.text.TextUtils.isEmpty(r1)
                if (r5 != 0) goto L_0x0197
                android.widget.TextView r5 = r11.f64410f
                if (r5 == 0) goto L_0x018d
                r5.setText(r1)
            L_0x018d:
                android.widget.TextView r1 = r11.f64410f
                if (r1 == 0) goto L_0x01aa
                android.view.View r1 = (android.view.View) r1
                net.one97.paytm.recharge.common.utils.ai.a(r1)
                goto L_0x01aa
            L_0x0197:
                android.widget.TextView r1 = r11.f64410f
                if (r1 == 0) goto L_0x01aa
                android.view.View r1 = (android.view.View) r1
                net.one97.paytm.recharge.common.utils.ai.b(r1)
                goto L_0x01aa
            L_0x01a1:
                android.widget.TextView r1 = r11.f64410f
                if (r1 == 0) goto L_0x01aa
                android.view.View r1 = (android.view.View) r1
                net.one97.paytm.recharge.common.utils.ai.b(r1)
            L_0x01aa:
                if (r0 == 0) goto L_0x01bb
                java.util.HashMap r1 = r0.getAmount()
                if (r1 == 0) goto L_0x01bb
                java.lang.String r5 = "currency"
                java.lang.Object r1 = r1.get(r5)
                java.lang.String r1 = (java.lang.String) r1
                goto L_0x01bc
            L_0x01bb:
                r1 = r4
            L_0x01bc:
                java.lang.String r5 = "INR"
                boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r5, (boolean) r2)
                if (r1 == 0) goto L_0x01c7
                java.lang.String r1 = "₹"
                goto L_0x01c8
            L_0x01c7:
                r1 = r4
            L_0x01c8:
                java.lang.String r5 = "value"
                if (r0 == 0) goto L_0x01db
                java.util.HashMap r6 = r0.getAmount()     // Catch:{ Exception -> 0x01d9 }
                if (r6 == 0) goto L_0x01db
                java.lang.Object r6 = r6.get(r5)     // Catch:{ Exception -> 0x01d9 }
                java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x01d9 }
                goto L_0x01dc
            L_0x01d9:
                goto L_0x01f6
            L_0x01db:
                r6 = r4
            L_0x01dc:
                java.lang.String r6 = net.one97.paytm.recharge.common.utils.ba.h(r6)     // Catch:{ Exception -> 0x01d9 }
                net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget r7 = r10.f64428b     // Catch:{ Exception -> 0x01d9 }
                int r8 = net.one97.paytm.recharge.R.id.tv_instant_refund_amt     // Catch:{ Exception -> 0x01d9 }
                android.view.View r7 = r7.b((int) r8)     // Catch:{ Exception -> 0x01d9 }
                android.widget.TextView r7 = (android.widget.TextView) r7     // Catch:{ Exception -> 0x01d9 }
                if (r7 == 0) goto L_0x021b
                java.lang.String r6 = kotlin.g.b.k.a((java.lang.String) r1, (java.lang.Object) r6)     // Catch:{ Exception -> 0x01d9 }
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x01d9 }
                r7.setText(r6)     // Catch:{ Exception -> 0x01d9 }
                goto L_0x021b
            L_0x01f6:
                net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget r6 = r10.f64428b
                int r7 = net.one97.paytm.recharge.R.id.tv_instant_refund_amt
                android.view.View r6 = r6.b((int) r7)
                android.widget.TextView r6 = (android.widget.TextView) r6
                if (r6 == 0) goto L_0x021b
                if (r0 == 0) goto L_0x0211
                java.util.HashMap r7 = r0.getAmount()
                if (r7 == 0) goto L_0x0211
                java.lang.Object r7 = r7.get(r5)
                java.lang.String r7 = (java.lang.String) r7
                goto L_0x0212
            L_0x0211:
                r7 = r4
            L_0x0212:
                java.lang.String r1 = kotlin.g.b.k.a((java.lang.String) r1, (java.lang.Object) r7)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r6.setText(r1)
            L_0x021b:
                if (r0 == 0) goto L_0x0222
                java.lang.String r1 = r0.getBankName()
                goto L_0x0223
            L_0x0222:
                r1 = r4
            L_0x0223:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x023c
                android.widget.TextView r1 = r11.f64405a
                if (r1 == 0) goto L_0x023c
                if (r0 == 0) goto L_0x0236
                java.lang.String r6 = r0.getBankName()
                goto L_0x0237
            L_0x0236:
                r6 = r4
            L_0x0237:
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                r1.setText(r6)
            L_0x023c:
                if (r0 == 0) goto L_0x0243
                java.lang.String r1 = r0.getMaskedAccountNo()
                goto L_0x0244
            L_0x0243:
                r1 = r4
            L_0x0244:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x0271
                net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget r1 = r10.f64428b
                android.content.Context r1 = r1.getContext()
                if (r1 == 0) goto L_0x0267
                int r6 = net.one97.paytm.recharge.R.string.imps_account_num
                java.lang.Object[] r7 = new java.lang.Object[r2]
                if (r0 == 0) goto L_0x025f
                java.lang.String r8 = r0.getMaskedAccountNo()
                goto L_0x0260
            L_0x025f:
                r8 = r4
            L_0x0260:
                r7[r3] = r8
                java.lang.String r1 = r1.getString(r6, r7)
                goto L_0x0268
            L_0x0267:
                r1 = r4
            L_0x0268:
                android.widget.TextView r6 = r11.f64406b
                if (r6 == 0) goto L_0x0271
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r6.setText(r1)
            L_0x0271:
                if (r0 == 0) goto L_0x0280
                java.util.HashMap r1 = r0.getMaxRefundTime()
                if (r1 == 0) goto L_0x0280
                java.lang.Object r1 = r1.get(r5)
                java.lang.String r1 = (java.lang.String) r1
                goto L_0x0281
            L_0x0280:
                r1 = r4
            L_0x0281:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                r6 = 8
                if (r1 != 0) goto L_0x0322
                android.widget.TextView r1 = r11.f64410f
                if (r1 == 0) goto L_0x0322
                int r1 = r1.getVisibility()
                if (r1 != r6) goto L_0x0322
                net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget r1 = r10.f64428b
                if (r0 == 0) goto L_0x02a8
                java.util.HashMap r6 = r0.getMaxRefundTime()
                if (r6 == 0) goto L_0x02a8
                java.lang.String r7 = "timeUnit"
                java.lang.Object r6 = r6.get(r7)
                java.lang.String r6 = (java.lang.String) r6
                goto L_0x02a9
            L_0x02a8:
                r6 = r4
            L_0x02a9:
                if (r0 == 0) goto L_0x02b8
                java.util.HashMap r7 = r0.getMaxRefundTime()
                if (r7 == 0) goto L_0x02b8
                java.lang.Object r7 = r7.get(r5)
                java.lang.String r7 = (java.lang.String) r7
                goto L_0x02b9
            L_0x02b8:
                r7 = r4
            L_0x02b9:
                java.lang.String r1 = r1.a((java.lang.String) r6, (java.lang.String) r7)
                net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget r6 = r10.f64428b
                android.content.Context r6 = r6.getContext()
                if (r6 == 0) goto L_0x02e3
                int r7 = net.one97.paytm.recharge.R.string.imps_refund_time_details
                r8 = 2
                java.lang.Object[] r8 = new java.lang.Object[r8]
                if (r0 == 0) goto L_0x02d9
                java.util.HashMap r9 = r0.getMaxRefundTime()
                if (r9 == 0) goto L_0x02d9
                java.lang.Object r5 = r9.get(r5)
                java.lang.String r5 = (java.lang.String) r5
                goto L_0x02da
            L_0x02d9:
                r5 = r4
            L_0x02da:
                r8[r3] = r5
                r8[r2] = r1
                java.lang.String r1 = r6.getString(r7, r8)
                goto L_0x02e4
            L_0x02e3:
                r1 = r4
            L_0x02e4:
                android.widget.TextView r2 = r11.f64407c
                if (r2 == 0) goto L_0x02eb
                r2.setVisibility(r3)
            L_0x02eb:
                android.widget.TextView r2 = r11.f64407c
                if (r2 == 0) goto L_0x02f4
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r2.setText(r1)
            L_0x02f4:
                int r1 = net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget.z
                if (r1 != r12) goto L_0x030e
                android.widget.TextView r12 = r11.f64407c
                if (r12 == 0) goto L_0x0329
                net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget r1 = r10.f64428b
                android.content.Context r1 = r1.getContext()
                int r2 = net.one97.paytm.recharge.R.color.rc_green_color
                int r1 = androidx.core.content.b.c(r1, r2)
                r12.setTextColor(r1)
                goto L_0x0329
            L_0x030e:
                android.widget.TextView r12 = r11.f64407c
                if (r12 == 0) goto L_0x0329
                net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget r1 = r10.f64428b
                android.content.Context r1 = r1.getContext()
                int r2 = net.one97.paytm.recharge.R.color.color_trans_black
                int r1 = androidx.core.content.b.c(r1, r2)
                r12.setTextColor(r1)
                goto L_0x0329
            L_0x0322:
                android.widget.TextView r12 = r11.f64407c
                if (r12 == 0) goto L_0x0329
                r12.setVisibility(r6)
            L_0x0329:
                if (r0 == 0) goto L_0x0330
                java.lang.String r12 = r0.getBankImageUrl()
                goto L_0x0331
            L_0x0330:
                r12 = r4
            L_0x0331:
                java.lang.CharSequence r12 = (java.lang.CharSequence) r12
                boolean r12 = android.text.TextUtils.isEmpty(r12)
                if (r12 != 0) goto L_0x034e
                com.squareup.picasso.w r12 = com.squareup.picasso.w.a()
                if (r0 == 0) goto L_0x0343
                java.lang.String r4 = r0.getBankImageUrl()
            L_0x0343:
                com.squareup.picasso.aa r12 = r12.a((java.lang.String) r4)
                if (r12 == 0) goto L_0x034e
                android.widget.ImageView r11 = r11.f64408d
                r12.a((android.widget.ImageView) r11)
            L_0x034e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget.g.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            k.c(viewGroup, "parent");
            View inflate = LayoutInflater.from(this.f64428b.getContext()).inflate(R.layout.imps_banks_layout_v8, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(cont…layout_v8, parent, false)");
            return new a(inflate);
        }

        public final int getItemCount() {
            if (!this.f64428b.o) {
                return 1;
            }
            ArrayList d2 = CJRInstantRefundWidget.A;
            return (d2 != null ? Integer.valueOf(d2.size()) : null).intValue();
        }
    }

    public static final class h extends RecyclerView.a<e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRImpsRefundConsultViewV8 f64434a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRInstantRefundWidget f64435b;

        /* renamed from: c  reason: collision with root package name */
        private Boolean f64436c = Boolean.FALSE;

        h(CJRImpsRefundConsultViewV8 cJRImpsRefundConsultViewV8, CJRInstantRefundWidget cJRInstantRefundWidget) {
            this.f64434a = cJRImpsRefundConsultViewV8;
            this.f64435b = cJRInstantRefundWidget;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0019, code lost:
            r2 = r0.getAmount();
         */
        /* JADX WARNING: Removed duplicated region for block: B:141:0x0202  */
        /* JADX WARNING: Removed duplicated region for block: B:144:0x020b  */
        /* JADX WARNING: Removed duplicated region for block: B:145:0x0211  */
        /* JADX WARNING: Removed duplicated region for block: B:149:0x021c  */
        /* JADX WARNING: Removed duplicated region for block: B:150:0x0221  */
        /* JADX WARNING: Removed duplicated region for block: B:153:0x022a  */
        /* JADX WARNING: Removed duplicated region for block: B:179:0x0283  */
        /* JADX WARNING: Removed duplicated region for block: B:184:0x0290  */
        /* JADX WARNING: Removed duplicated region for block: B:185:0x0295  */
        /* JADX WARNING: Removed duplicated region for block: B:188:0x029a  */
        /* JADX WARNING: Removed duplicated region for block: B:191:0x029f  */
        /* JADX WARNING: Removed duplicated region for block: B:194:0x02a6  */
        /* JADX WARNING: Removed duplicated region for block: B:195:0x02ab  */
        /* JADX WARNING: Removed duplicated region for block: B:198:0x02b0  */
        /* JADX WARNING: Removed duplicated region for block: B:201:0x02b5  */
        /* JADX WARNING: Removed duplicated region for block: B:203:0x02c1  */
        /* JADX WARNING: Removed duplicated region for block: B:204:0x02c6  */
        /* JADX WARNING: Removed duplicated region for block: B:207:0x02d3  */
        /* JADX WARNING: Removed duplicated region for block: B:211:0x02e9  */
        /* JADX WARNING: Removed duplicated region for block: B:217:0x0304  */
        /* JADX WARNING: Removed duplicated region for block: B:218:0x030c  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x005a A[Catch:{ Exception -> 0x0047 }] */
        /* JADX WARNING: Removed duplicated region for block: B:220:0x0315  */
        /* JADX WARNING: Removed duplicated region for block: B:221:0x031a  */
        /* JADX WARNING: Removed duplicated region for block: B:224:0x0323  */
        /* JADX WARNING: Removed duplicated region for block: B:233:0x0342  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x008b  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0090  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0099  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00a2  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00a6  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00ab  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00b4  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x00d2  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x00de  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x00e3  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x00e9  */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x00fd  */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x0111  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x011c  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x0121  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x012a  */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x0145  */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x0156  */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x015d  */
        /* JADX WARNING: Removed duplicated region for block: B:97:0x0166  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r11, final int r12) {
            /*
                r10 = this;
                net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget$e r11 = (net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget.e) r11
                java.lang.String r0 = "holder"
                kotlin.g.b.k.c(r11, r0)
                java.util.ArrayList r0 = net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget.A
                java.lang.Object r0 = r0.get(r12)
                java.lang.String r1 = "instantBankList[position]"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                net.one97.paytm.recharge.model.imps.CJRRefundAllocatedInfoV8 r0 = (net.one97.paytm.recharge.model.imps.CJRRefundAllocatedInfoV8) r0
                r1 = 0
                if (r0 == 0) goto L_0x0028
                java.util.HashMap r2 = r0.getAmount()
                if (r2 == 0) goto L_0x0028
                java.lang.String r3 = "currency"
                java.lang.Object r2 = r2.get(r3)
                java.lang.String r2 = (java.lang.String) r2
                goto L_0x0029
            L_0x0028:
                r2 = r1
            L_0x0029:
                r3 = 1
                java.lang.String r4 = "INR"
                boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r4, (boolean) r3)
                if (r2 == 0) goto L_0x0035
                java.lang.String r2 = "₹"
                goto L_0x0036
            L_0x0035:
                r2 = r1
            L_0x0036:
                java.lang.String r4 = "value"
                if (r0 == 0) goto L_0x0049
                java.util.HashMap r5 = r0.getAmount()     // Catch:{ Exception -> 0x0047 }
                if (r5 == 0) goto L_0x0049
                java.lang.Object r5 = r5.get(r4)     // Catch:{ Exception -> 0x0047 }
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0047 }
                goto L_0x004a
            L_0x0047:
                goto L_0x0064
            L_0x0049:
                r5 = r1
            L_0x004a:
                java.lang.String r5 = net.one97.paytm.recharge.common.utils.ba.h(r5)     // Catch:{ Exception -> 0x0047 }
                net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget r6 = r10.f64435b     // Catch:{ Exception -> 0x0047 }
                int r7 = net.one97.paytm.recharge.R.id.tv_instant_refund_amt     // Catch:{ Exception -> 0x0047 }
                android.view.View r6 = r6.b((int) r7)     // Catch:{ Exception -> 0x0047 }
                android.widget.TextView r6 = (android.widget.TextView) r6     // Catch:{ Exception -> 0x0047 }
                if (r6 == 0) goto L_0x0089
                java.lang.String r5 = kotlin.g.b.k.a((java.lang.String) r2, (java.lang.Object) r5)     // Catch:{ Exception -> 0x0047 }
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x0047 }
                r6.setText(r5)     // Catch:{ Exception -> 0x0047 }
                goto L_0x0089
            L_0x0064:
                net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget r5 = r10.f64435b
                int r6 = net.one97.paytm.recharge.R.id.tv_instant_refund_amt
                android.view.View r5 = r5.b((int) r6)
                android.widget.TextView r5 = (android.widget.TextView) r5
                if (r5 == 0) goto L_0x0089
                if (r0 == 0) goto L_0x007f
                java.util.HashMap r6 = r0.getAmount()
                if (r6 == 0) goto L_0x007f
                java.lang.Object r6 = r6.get(r4)
                java.lang.String r6 = (java.lang.String) r6
                goto L_0x0080
            L_0x007f:
                r6 = r1
            L_0x0080:
                java.lang.String r2 = kotlin.g.b.k.a((java.lang.String) r2, (java.lang.Object) r6)
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r5.setText(r2)
            L_0x0089:
                if (r0 == 0) goto L_0x0090
                java.lang.String r2 = r0.getBankName()
                goto L_0x0091
            L_0x0090:
                r2 = r1
            L_0x0091:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 != 0) goto L_0x00a2
                if (r0 == 0) goto L_0x00a0
                java.lang.String r2 = r0.getBankName()
                goto L_0x00a4
            L_0x00a0:
                r2 = r1
                goto L_0x00a4
            L_0x00a2:
                java.lang.String r2 = ""
            L_0x00a4:
                if (r0 == 0) goto L_0x00ab
                java.lang.String r5 = r0.getPayMethod()
                goto L_0x00ac
            L_0x00ab:
                r5 = r1
            L_0x00ac:
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                boolean r5 = android.text.TextUtils.isEmpty(r5)
                if (r5 != 0) goto L_0x00ce
                r5 = r2
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                boolean r5 = android.text.TextUtils.isEmpty(r5)
                if (r5 != 0) goto L_0x00c3
                java.lang.String r5 = " - "
                java.lang.String r2 = kotlin.g.b.k.a((java.lang.String) r2, (java.lang.Object) r5)
            L_0x00c3:
                if (r0 == 0) goto L_0x00ca
                java.lang.String r5 = r0.getPayMethod()
                goto L_0x00cb
            L_0x00ca:
                r5 = r1
            L_0x00cb:
                kotlin.g.b.k.a((java.lang.String) r2, (java.lang.Object) r5)
            L_0x00ce:
                android.view.View r2 = r11.f64419g
                if (r2 == 0) goto L_0x00dc
                net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget$h$1 r5 = new net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget$h$1
                r5.<init>(r10, r11, r0, r12)
                android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
                r2.setOnClickListener(r5)
            L_0x00dc:
                if (r0 == 0) goto L_0x00e3
                java.lang.String r2 = r0.getSource_text()
                goto L_0x00e4
            L_0x00e3:
                r2 = r1
            L_0x00e4:
                android.widget.RadioButton r5 = r11.f64413a
                r6 = 0
                if (r5 == 0) goto L_0x00f5
                int r7 = net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget.z
                if (r7 != r12) goto L_0x00f1
                r7 = 1
                goto L_0x00f2
            L_0x00f1:
                r7 = 0
            L_0x00f2:
                r5.setChecked(r7)
            L_0x00f5:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                boolean r5 = android.text.TextUtils.isEmpty(r2)
                if (r5 != 0) goto L_0x0111
                android.widget.TextView r5 = r11.f64414b
                if (r5 == 0) goto L_0x0106
                android.view.View r5 = (android.view.View) r5
                net.one97.paytm.recharge.common.utils.ai.a(r5)
            L_0x0106:
                android.widget.TextView r5 = r11.f64414b
                java.lang.String r7 = "holder?.bankDetailView"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
                r5.setText(r2)
                goto L_0x011a
            L_0x0111:
                android.widget.TextView r2 = r11.f64414b
                if (r2 == 0) goto L_0x011a
                android.view.View r2 = (android.view.View) r2
                net.one97.paytm.recharge.common.utils.ai.b(r2)
            L_0x011a:
                if (r0 == 0) goto L_0x0121
                java.lang.String r2 = r0.getMaskedAccountNo()
                goto L_0x0122
            L_0x0121:
                r2 = r1
            L_0x0122:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 != 0) goto L_0x0145
                android.widget.TextView r2 = r11.f64415c
                if (r2 == 0) goto L_0x0133
                android.view.View r2 = (android.view.View) r2
                net.one97.paytm.recharge.common.utils.ai.a(r2)
            L_0x0133:
                android.widget.TextView r2 = r11.f64415c
                if (r2 == 0) goto L_0x014e
                if (r0 == 0) goto L_0x013e
                java.lang.String r5 = r0.getMaskedAccountNo()
                goto L_0x013f
            L_0x013e:
                r5 = r1
            L_0x013f:
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r2.setText(r5)
                goto L_0x014e
            L_0x0145:
                android.widget.TextView r2 = r11.f64415c
                if (r2 == 0) goto L_0x014e
                android.view.View r2 = (android.view.View) r2
                net.one97.paytm.recharge.common.utils.ai.b(r2)
            L_0x014e:
                if (r0 == 0) goto L_0x015d
                java.util.HashMap r2 = r0.getMaxRefundTime()
                if (r2 == 0) goto L_0x015d
                java.lang.Object r2 = r2.get(r4)
                java.lang.String r2 = (java.lang.String) r2
                goto L_0x015e
            L_0x015d:
                r2 = r1
            L_0x015e:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 != 0) goto L_0x0211
                net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget r2 = r10.f64435b
                java.lang.String r5 = "timeUnit"
                if (r0 == 0) goto L_0x0179
                java.util.HashMap r7 = r0.getMaxRefundTime()
                if (r7 == 0) goto L_0x0179
                java.lang.Object r7 = r7.get(r5)
                java.lang.String r7 = (java.lang.String) r7
                goto L_0x017a
            L_0x0179:
                r7 = r1
            L_0x017a:
                if (r0 == 0) goto L_0x0189
                java.util.HashMap r8 = r0.getMaxRefundTime()
                if (r8 == 0) goto L_0x0189
                java.lang.Object r8 = r8.get(r4)
                java.lang.String r8 = (java.lang.String) r8
                goto L_0x018a
            L_0x0189:
                r8 = r1
            L_0x018a:
                java.lang.String r2 = r2.a((java.lang.String) r7, (java.lang.String) r8)
                if (r0 == 0) goto L_0x0195
                java.lang.String r7 = r0.getStatus()
                goto L_0x0196
            L_0x0195:
                r7 = r1
            L_0x0196:
                net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget$c r8 = net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget.f64398f
                java.lang.String r8 = net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget.v
                boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r8, (boolean) r3)
                r8 = 2
                if (r7 == 0) goto L_0x01da
                net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget r2 = r10.f64435b
                android.content.Context r2 = r2.getContext()
                if (r2 == 0) goto L_0x01d8
                int r7 = net.one97.paytm.recharge.R.string.imps_refund_time_details
                java.lang.Object[] r8 = new java.lang.Object[r8]
                if (r0 == 0) goto L_0x01be
                java.util.HashMap r9 = r0.getMaxRefundTime()
                if (r9 == 0) goto L_0x01be
                java.lang.Object r4 = r9.get(r4)
                java.lang.String r4 = (java.lang.String) r4
                goto L_0x01bf
            L_0x01be:
                r4 = r1
            L_0x01bf:
                r8[r6] = r4
                if (r0 == 0) goto L_0x01d0
                java.util.HashMap r4 = r0.getMaxRefundTime()
                if (r4 == 0) goto L_0x01d0
                java.lang.Object r4 = r4.get(r5)
                java.lang.String r4 = (java.lang.String) r4
                goto L_0x01d1
            L_0x01d0:
                r4 = r1
            L_0x01d1:
                r8[r3] = r4
                java.lang.String r2 = r2.getString(r7, r8)
                goto L_0x01fe
            L_0x01d8:
                r2 = r1
                goto L_0x01fe
            L_0x01da:
                net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget r5 = r10.f64435b
                android.content.Context r5 = r5.getContext()
                if (r5 == 0) goto L_0x01d8
                int r7 = net.one97.paytm.recharge.R.string.imps_org_refung_dur_key
                java.lang.Object[] r8 = new java.lang.Object[r8]
                if (r0 == 0) goto L_0x01f5
                java.util.HashMap r9 = r0.getMaxRefundTime()
                if (r9 == 0) goto L_0x01f5
                java.lang.Object r4 = r9.get(r4)
                java.lang.String r4 = (java.lang.String) r4
                goto L_0x01f6
            L_0x01f5:
                r4 = r1
            L_0x01f6:
                r8[r6] = r4
                r8[r3] = r2
                java.lang.String r2 = r5.getString(r7, r8)
            L_0x01fe:
                android.widget.TextView r4 = r11.f64416d
                if (r4 == 0) goto L_0x0207
                android.view.View r4 = (android.view.View) r4
                net.one97.paytm.recharge.common.utils.ai.a(r4)
            L_0x0207:
                android.widget.TextView r4 = r11.f64416d
                if (r4 == 0) goto L_0x021a
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r4.setText(r2)
                goto L_0x021a
            L_0x0211:
                android.widget.TextView r2 = r11.f64416d
                if (r2 == 0) goto L_0x021a
                android.view.View r2 = (android.view.View) r2
                net.one97.paytm.recharge.common.utils.ai.b(r2)
            L_0x021a:
                if (r0 == 0) goto L_0x0221
                java.lang.String r2 = r0.getDestinationText()
                goto L_0x0222
            L_0x0221:
                r2 = r1
            L_0x0222:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 != 0) goto L_0x0283
                android.widget.TextView r2 = r11.f64417e
                if (r2 == 0) goto L_0x0233
                android.view.View r2 = (android.view.View) r2
                net.one97.paytm.recharge.common.utils.ai.a(r2)
            L_0x0233:
                if (r0 == 0) goto L_0x023a
                java.lang.String r2 = r0.getStatus()
                goto L_0x023b
            L_0x023a:
                r2 = r1
            L_0x023b:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 != 0) goto L_0x0271
                if (r0 == 0) goto L_0x024a
                java.lang.String r2 = r0.getStatus()
                goto L_0x024b
            L_0x024a:
                r2 = r1
            L_0x024b:
                net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget$c r4 = net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget.f64398f
                java.lang.String r4 = net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget.v
                boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r4, (boolean) r3)
                if (r2 == 0) goto L_0x0271
                android.widget.TextView r2 = r11.f64417e
                if (r2 == 0) goto L_0x028c
                net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget r4 = r10.f64435b
                android.content.Context r4 = r4.getContext()
                if (r4 == 0) goto L_0x026a
                int r5 = net.one97.paytm.recharge.R.string.rc_imps_refund_to_bank
                java.lang.String r4 = r4.getString(r5)
                goto L_0x026b
            L_0x026a:
                r4 = r1
            L_0x026b:
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                r2.setText(r4)
                goto L_0x028c
            L_0x0271:
                android.widget.TextView r2 = r11.f64417e
                if (r2 == 0) goto L_0x028c
                if (r0 == 0) goto L_0x027c
                java.lang.String r4 = r0.getDestinationText()
                goto L_0x027d
            L_0x027c:
                r4 = r1
            L_0x027d:
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                r2.setText(r4)
                goto L_0x028c
            L_0x0283:
                android.widget.TextView r2 = r11.f64417e
                if (r2 == 0) goto L_0x028c
                android.view.View r2 = (android.view.View) r2
                net.one97.paytm.recharge.common.utils.ai.b(r2)
            L_0x028c:
                android.widget.RadioButton r2 = r11.f64413a
                if (r2 == 0) goto L_0x0295
                android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
                goto L_0x0296
            L_0x0295:
                r2 = r1
            L_0x0296:
                boolean r4 = r2 instanceof android.widget.RelativeLayout.LayoutParams
                if (r4 != 0) goto L_0x029b
                r2 = r1
            L_0x029b:
                android.widget.RelativeLayout$LayoutParams r2 = (android.widget.RelativeLayout.LayoutParams) r2
                if (r2 == 0) goto L_0x02a2
                r2.setMargins(r6, r6, r6, r6)
            L_0x02a2:
                android.widget.TextView r2 = r11.f64417e
                if (r2 == 0) goto L_0x02ab
                android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
                goto L_0x02ac
            L_0x02ab:
                r2 = r1
            L_0x02ac:
                boolean r4 = r2 instanceof android.widget.RelativeLayout.LayoutParams
                if (r4 != 0) goto L_0x02b1
                r2 = r1
            L_0x02b1:
                android.widget.RelativeLayout$LayoutParams r2 = (android.widget.RelativeLayout.LayoutParams) r2
                if (r2 == 0) goto L_0x02bf
                r4 = 1094713344(0x41400000, float:12.0)
                float r4 = net.one97.paytm.recharge.common.utils.ba.a((float) r4)
                int r4 = (int) r4
                r2.setMargins(r4, r6, r6, r6)
            L_0x02bf:
                if (r0 == 0) goto L_0x02c6
                java.lang.String r2 = r0.getStatus()
                goto L_0x02c7
            L_0x02c6:
                r2 = r1
            L_0x02c7:
                net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget$c r4 = net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget.f64398f
                java.lang.String r4 = net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget.v
                boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r4, (boolean) r3)
                if (r2 == 0) goto L_0x02e9
                int r2 = net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget.z
                if (r2 != r12) goto L_0x02e1
                android.widget.TextView r2 = r11.f64416d
                int r3 = net.one97.paytm.recharge.R.style.impsInstantRefundStyle
                androidx.core.widget.i.a((android.widget.TextView) r2, (int) r3)
                goto L_0x02fe
            L_0x02e1:
                android.widget.TextView r2 = r11.f64416d
                int r3 = net.one97.paytm.recharge.R.style.impsInstantRefundStyledefault
                androidx.core.widget.i.a((android.widget.TextView) r2, (int) r3)
                goto L_0x02fe
            L_0x02e9:
                int r2 = net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget.z
                if (r2 != r12) goto L_0x02f7
                android.widget.TextView r2 = r11.f64416d
                int r3 = net.one97.paytm.recharge.R.style.impsSourceRefundStyle
                androidx.core.widget.i.a((android.widget.TextView) r2, (int) r3)
                goto L_0x02fe
            L_0x02f7:
                android.widget.TextView r2 = r11.f64416d
                int r3 = net.one97.paytm.recharge.R.style.impsSourceRefundStyledefault
                androidx.core.widget.i.a((android.widget.TextView) r2, (int) r3)
            L_0x02fe:
                int r2 = net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget.z
                if (r2 != r12) goto L_0x030c
                android.widget.TextView r12 = r11.f64417e
                int r2 = net.one97.paytm.recharge.R.style.impsStyleSelectedNoBank
                androidx.core.widget.i.a((android.widget.TextView) r12, (int) r2)
                goto L_0x0313
            L_0x030c:
                android.widget.TextView r12 = r11.f64417e
                int r2 = net.one97.paytm.recharge.R.style.impsStyleDefaultNoBank
                androidx.core.widget.i.a((android.widget.TextView) r12, (int) r2)
            L_0x0313:
                if (r0 == 0) goto L_0x031a
                java.lang.String r12 = r0.getBankImageUrl()
                goto L_0x031b
            L_0x031a:
                r12 = r1
            L_0x031b:
                java.lang.CharSequence r12 = (java.lang.CharSequence) r12
                boolean r12 = android.text.TextUtils.isEmpty(r12)
                if (r12 != 0) goto L_0x0342
                android.widget.ImageView r12 = r11.f64418f
                if (r12 == 0) goto L_0x032c
                android.view.View r12 = (android.view.View) r12
                net.one97.paytm.recharge.common.utils.ai.a(r12)
            L_0x032c:
                com.squareup.picasso.w r12 = com.squareup.picasso.w.a()
                if (r0 == 0) goto L_0x0336
                java.lang.String r1 = r0.getBankImageUrl()
            L_0x0336:
                com.squareup.picasso.aa r12 = r12.a((java.lang.String) r1)
                if (r12 == 0) goto L_0x0341
                android.widget.ImageView r11 = r11.f64418f
                r12.a((android.widget.ImageView) r11)
            L_0x0341:
                return
            L_0x0342:
                android.widget.ImageView r11 = r11.f64418f
                if (r11 == 0) goto L_0x034b
                android.view.View r11 = (android.view.View) r11
                net.one97.paytm.recharge.common.utils.ai.b(r11)
            L_0x034b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget.h.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            k.c(viewGroup, "parent");
            View inflate = LayoutInflater.from(this.f64435b.getContext()).inflate(R.layout.imps_org_payment_source_layout_v8, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(cont…layout_v8, parent, false)");
            return new e(inflate);
        }

        public final int getItemCount() {
            ArrayList d2 = CJRInstantRefundWidget.A;
            return (d2 != null ? Integer.valueOf(d2.size()) : null).intValue();
        }
    }

    public final void a(int i2, int i3) {
        if (i2 == y && i3 == -1) {
            q qVar = this.f64401c;
            if (qVar != null) {
                qVar.j();
            }
            net.one97.paytm.recharge.ordersummary.g.f fVar = this.f64400b;
            if (fVar != null) {
                fVar.a(0, (String) null);
            }
        }
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f64405a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f64406b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f64407c;

        /* renamed from: d  reason: collision with root package name */
        final ImageView f64408d;

        /* renamed from: e  reason: collision with root package name */
        final RadioButton f64409e;

        /* renamed from: f  reason: collision with root package name */
        final TextView f64410f;

        /* renamed from: g  reason: collision with root package name */
        final View f64411g;

        /* renamed from: h  reason: collision with root package name */
        final View f64412h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.tv_bankname);
            if (findViewById != null) {
                this.f64405a = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.tv_account_number);
                if (findViewById2 != null) {
                    this.f64406b = (TextView) findViewById2;
                    View findViewById3 = view.findViewById(R.id.tv_bank_descp);
                    if (findViewById3 != null) {
                        this.f64407c = (TextView) findViewById3;
                        View findViewById4 = view.findViewById(R.id.img_bankimage);
                        if (findViewById4 != null) {
                            this.f64408d = (ImageView) findViewById4;
                            View findViewById5 = view.findViewById(R.id.view_selector);
                            if (findViewById5 != null) {
                                this.f64409e = (RadioButton) findViewById5;
                                View findViewById6 = view.findViewById(R.id.tv_inline_error);
                                if (findViewById6 != null) {
                                    this.f64410f = (TextView) findViewById6;
                                    View findViewById7 = view.findViewById(R.id.alphaView);
                                    if (findViewById7 != null) {
                                        this.f64411g = findViewById7;
                                        this.f64412h = view;
                                        return;
                                    }
                                    throw new u("null cannot be cast to non-null type android.view.View");
                                }
                                throw new u("null cannot be cast to non-null type android.widget.TextView");
                            }
                            throw new u("null cannot be cast to non-null type android.widget.RadioButton");
                        }
                        throw new u("null cannot be cast to non-null type android.widget.ImageView");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public static final class e extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RadioButton f64413a;

        /* renamed from: b  reason: collision with root package name */
        TextView f64414b;

        /* renamed from: c  reason: collision with root package name */
        TextView f64415c;

        /* renamed from: d  reason: collision with root package name */
        TextView f64416d;

        /* renamed from: e  reason: collision with root package name */
        TextView f64417e;

        /* renamed from: f  reason: collision with root package name */
        ImageView f64418f;

        /* renamed from: g  reason: collision with root package name */
        View f64419g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(View view) {
            super(view);
            k.c(view, "view");
            this.f64413a = (RadioButton) view.findViewById(R.id.view_selector);
            this.f64414b = (TextView) view.findViewById(R.id.tv_bank_details);
            this.f64415c = (TextView) view.findViewById(R.id.tv_account_number);
            this.f64416d = (TextView) view.findViewById(R.id.tv_os_refunddetail);
            this.f64417e = (TextView) view.findViewById(R.id.tv_primary_label);
            this.f64418f = (ImageView) view.findViewById(R.id.img_bank_logo);
            this.f64419g = view;
        }
    }

    public final void j() {
        ProgressDialog progressDialog;
        if (this.j == null) {
            this.j = ProgressDialog.show(getContext(), "", getContext().getString(R.string.please_wait));
        }
        ProgressDialog progressDialog2 = this.j;
        if (progressDialog2 != null && !progressDialog2.isShowing() && (progressDialog = this.j) != null) {
            progressDialog.show();
        }
    }

    public final void a(Boolean bool) {
        try {
            ProgressDialog progressDialog = this.j;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        } catch (IllegalStateException unused) {
        }
    }
}
